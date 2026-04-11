import express from 'express';
import path from 'path';
import { fileURLToPath } from 'url';
import { readFileSync, existsSync } from 'fs';
import pkg from 'pg';
import jwt from 'jsonwebtoken';

const { Pool } = pkg;
const __dirname = path.dirname(fileURLToPath(import.meta.url));

const PORT            = process.env.PORT || 3001;
const ADMIN_PASSWORD  = process.env.ADMIN_PASSWORD || 'admin';
const JWT_SECRET      = process.env.JWT_SECRET || 'cineflix-jwt-secret';
const DATABASE_URL    = process.env.DATABASE_URL;

// ── Database ──────────────────────────────────────────────────────────────────
let db = null;
if (DATABASE_URL) {
    db = new Pool({
        connectionString: DATABASE_URL,
        ssl: { rejectUnauthorized: false },
    });
}

// ── TXT parser for lista_peliculas.txt ─────────────────────────────────────────
function parseTxtLine(rawLine) {
    let line = rawLine.trim();
    // Strip "Título: " prefix (may appear twice due to copy-paste bugs)
    line = line.replace(/^(T[ií]tulo:\s*)+/gi, '');
    // Strip " | ID: N/A" and anything after "|"
    line = line.replace(/\s*\|.*$/, '').trim();
    // Remove trailing periods/spaces
    line = line.replace(/\.+$/, '').trim();
    if (!line || line.length < 2) return null;

    // Extract year — try several patterns
    let year = null;
    const yearPatterns = [
        /\((\d{4})\)\s*$/,                    // (2024) at end
        /[Aa]ño[:\s]+(\d{4})/,                // Año: 2024
        /[-–\s](\d{4})\s*$/,                  // - 2024 at end
        /\s(\d{4})\s*$/,                       // bare 2024 at end
    ];
    for (const re of yearPatterns) {
        const m = line.match(re);
        if (m) { const y = parseInt(m[1]); if (y >= 1900 && y <= 2030) { year = y; break; } }
    }

    // search_title: what to send to the bot — strip year + common qualifiers
    let searchTitle = line
        .replace(/\s*\([^)]*(?:Castellano|Latino|Espa[ñn]ol|Subtitulado|cast)\s*[^)]*\)/gi, '')
        .replace(/\s*\([^)]*(?:Romance|Drama|Comedia|Acci[oó]n|Thriller|Terror|Fantas[ií]a|Ciencia Ficci[oó]n)\s*[^)]*\)/gi, '')
        .replace(/\s*\(\d{4}\)\s*$/, '')
        .replace(/\s*[Aa]ño[:\s]+\d{4}\s*$/, '')
        .replace(/\s*[-–]\s*\d{4}\s*$/, '')
        .replace(/\s*\d{4}\s*$/, '')
        .replace(/\s+/g, ' ')
        .trim();
    if (!searchTitle || searchTitle.length < 2) searchTitle = line;

    // Dedup key — normalized (for unique catalog display)
    const dedupKey = line.toLowerCase()
        .replace(/[áàäâ]/g, 'a').replace(/[éèëê]/g, 'e')
        .replace(/[íìïî]/g, 'i').replace(/[óòöô]/g, 'o')
        .replace(/[úùüû]/g, 'u').replace(/[ñ]/g, 'n')
        .replace(/\s*\(\d{4}\)\s*$/, '')
        .replace(/[^a-z0-9\s]/g, '').replace(/\s+/g, ' ').trim();

    return { title: line, searchTitle, year, dedupKey };
}

async function initDB() {
    if (!db) { console.log('[DB] No DATABASE_URL — using catalog.json fallback'); return; }

    // ── Series table ──────────────────────────────────────────────────────────
    await db.query(`
        CREATE TABLE IF NOT EXISTS series (
            id         SERIAL PRIMARY KEY,
            title      TEXT    NOT NULL,
            year       INT,
            payload    TEXT    NOT NULL,
            position   INT     DEFAULT 0,
            active     BOOLEAN DEFAULT true,
            created_at TIMESTAMPTZ DEFAULT NOW()
        )
    `);
    const { rows: sRows } = await db.query('SELECT COUNT(*)::int AS n FROM series');
    if (sRows[0].n === 0) {
        const jsonPath = path.join(__dirname, 'src', 'catalog.json');
        if (existsSync(jsonPath)) {
            const catalog = JSON.parse(readFileSync(jsonPath, 'utf-8'));
            for (let i = 0; i < catalog.length; i++) {
                const s = catalog[i];
                await db.query(
                    'INSERT INTO series (title, year, payload, position) VALUES ($1,$2,$3,$4)',
                    [s.title, s.year || null, s.payload || s.id || s.title, i]
                );
            }
            console.log(`[DB] Imported ${catalog.length} series from catalog.json`);
        }
    }

    // ── Movies table ──────────────────────────────────────────────────────────
    await db.query(`
        CREATE TABLE IF NOT EXISTS movies (
            id           SERIAL PRIMARY KEY,
            title        TEXT    NOT NULL,
            search_title TEXT    NOT NULL,
            year         INT,
            position     INT     DEFAULT 0,
            active       BOOLEAN DEFAULT true,
            created_at   TIMESTAMPTZ DEFAULT NOW()
        )
    `);
    const { rows: mRows } = await db.query('SELECT COUNT(*)::int AS n FROM movies');
    if (mRows[0].n === 0) {
        const txtPath = path.join(__dirname, 'lista_peliculas.txt');
        if (existsSync(txtPath)) {
            const lines = readFileSync(txtPath, 'utf-8').split('\n');
            const seen = new Map(); // dedupKey → position
            let pos = 0;
            for (const raw of lines) {
                const parsed = parseTxtLine(raw);
                if (!parsed) continue;
                if (seen.has(parsed.dedupKey)) continue; // skip duplicates
                seen.set(parsed.dedupKey, pos);
                await db.query(
                    'INSERT INTO movies (title, search_title, year, position) VALUES ($1,$2,$3,$4)',
                    [parsed.title, parsed.searchTitle, parsed.year, pos]
                );
                pos++;
            }
            console.log(`[DB] Imported ${pos} unique movies from lista_peliculas.txt`);
        }
    }

    console.log('[DB] Ready ✓');
}

// ── App ───────────────────────────────────────────────────────────────────────
const app = express();
app.use(express.json());

// ── Auth helper ───────────────────────────────────────────────────────────────
function requireAuth(req, res, next) {
    const auth = req.headers.authorization || '';
    if (!auth.startsWith('Bearer ')) return res.status(401).json({ error: 'Unauthorized' });
    try {
        jwt.verify(auth.slice(7), JWT_SECRET);
        next();
    } catch {
        res.status(401).json({ error: 'Invalid token' });
    }
}

function catalogFallback() {
    try { return JSON.parse(readFileSync(path.join(__dirname, 'src', 'catalog.json'), 'utf-8')); }
    catch { return []; }
}

// ══════════════════════════════════════════════════════════════════════════════
// SERIES API
// ══════════════════════════════════════════════════════════════════════════════

app.get('/api/catalog', async (req, res) => {
    if (!db) return res.json(catalogFallback());
    try {
        const { rows } = await db.query('SELECT * FROM series WHERE active = true ORDER BY position ASC, id ASC');
        res.json(rows);
    } catch (err) { console.error(err); res.json(catalogFallback()); }
});

app.get('/api/catalog/all', requireAuth, async (req, res) => {
    if (!db) return res.json(catalogFallback());
    const { rows } = await db.query('SELECT * FROM series ORDER BY position ASC, id ASC');
    res.json(rows);
});

app.post('/api/admin/login', (req, res) => {
    const received = (req.body.password || '').trim();
    const expected = (ADMIN_PASSWORD || '').trim();
    console.log(`[Auth] Login attempt — expected length: ${expected.length}, received length: ${received.length}`);
    if (received !== expected) return res.status(401).json({ error: 'Contraseña incorrecta' });
    const token = jwt.sign({ admin: true }, JWT_SECRET, { expiresIn: '12h' });
    res.json({ token });
});

app.post('/api/catalog', requireAuth, async (req, res) => {
    if (!db) return res.status(503).json({ error: 'No database configured' });
    const { title, year, payload, position } = req.body;
    if (!title || !payload) return res.status(400).json({ error: 'title and payload are required' });
    const maxPos = await db.query('SELECT COALESCE(MAX(position),0)+1 AS p FROM series');
    const pos = position ?? maxPos.rows[0].p;
    const { rows } = await db.query(
        'INSERT INTO series (title, year, payload, position) VALUES ($1,$2,$3,$4) RETURNING *',
        [title.trim(), year || null, payload.trim(), pos]
    );
    res.json(rows[0]);
});

app.put('/api/catalog/:id', requireAuth, async (req, res) => {
    if (!db) return res.status(503).json({ error: 'No database configured' });
    const { title, year, payload, position, active } = req.body;
    const { rows } = await db.query(
        'UPDATE series SET title=$1, year=$2, payload=$3, position=$4, active=$5 WHERE id=$6 RETURNING *',
        [title, year || null, payload, position ?? 0, active !== false, req.params.id]
    );
    res.json(rows[0]);
});

app.delete('/api/catalog/:id', requireAuth, async (req, res) => {
    if (!db) return res.status(503).json({ error: 'No database configured' });
    await db.query('DELETE FROM series WHERE id=$1', [req.params.id]);
    res.json({ success: true });
});

app.post('/api/catalog/reorder', requireAuth, async (req, res) => {
    if (!db) return res.status(503).json({ error: 'No database configured' });
    for (const item of (req.body.order || []))
        await db.query('UPDATE series SET position=$1 WHERE id=$2', [item.position, item.id]);
    res.json({ success: true });
});

// ══════════════════════════════════════════════════════════════════════════════
// MOVIES API
// ══════════════════════════════════════════════════════════════════════════════

// GET /api/movies — public, supports ?q=search for filtering
app.get('/api/movies', async (req, res) => {
    if (!db) return res.json([]);
    try {
        const q = (req.query.q || '').trim();
        let rows;
        if (q) {
            const result = await db.query(
                `SELECT * FROM movies WHERE active = true
                 AND (LOWER(title) LIKE LOWER($1) OR LOWER(search_title) LIKE LOWER($1))
                 ORDER BY position ASC, id ASC LIMIT 200`,
                [`%${q}%`]
            );
            rows = result.rows;
        } else {
            const result = await db.query(
                'SELECT * FROM movies WHERE active = true ORDER BY position ASC, id ASC'
            );
            rows = result.rows;
        }
        res.json(rows);
    } catch (err) { console.error(err); res.json([]); }
});

// GET /api/movies/all — admin
app.get('/api/movies/all', requireAuth, async (req, res) => {
    if (!db) return res.json([]);
    const q = (req.query.q || '').trim();
    let result;
    if (q) {
        result = await db.query(
            `SELECT * FROM movies WHERE LOWER(title) LIKE LOWER($1)
             ORDER BY position ASC, id ASC LIMIT 500`,
            [`%${q}%`]
        );
    } else {
        result = await db.query('SELECT * FROM movies ORDER BY position ASC, id ASC LIMIT 500');
    }
    res.json(result.rows);
});

// GET /api/movies/count — for admin badge
app.get('/api/movies/count', requireAuth, async (req, res) => {
    if (!db) return res.json({ count: 0 });
    const { rows } = await db.query('SELECT COUNT(*)::int AS count FROM movies');
    res.json(rows[0]);
});

app.post('/api/movies', requireAuth, async (req, res) => {
    if (!db) return res.status(503).json({ error: 'No database configured' });
    const { title, search_title, year, position } = req.body;
    if (!title) return res.status(400).json({ error: 'title is required' });
    const st = search_title || title;
    const maxPos = await db.query('SELECT COALESCE(MAX(position),0)+1 AS p FROM movies');
    const pos = position ?? maxPos.rows[0].p;
    const { rows } = await db.query(
        'INSERT INTO movies (title, search_title, year, position) VALUES ($1,$2,$3,$4) RETURNING *',
        [title.trim(), st.trim(), year || null, pos]
    );
    res.json(rows[0]);
});

app.put('/api/movies/:id', requireAuth, async (req, res) => {
    if (!db) return res.status(503).json({ error: 'No database configured' });
    const { title, search_title, year, position, active } = req.body;
    const { rows } = await db.query(
        'UPDATE movies SET title=$1, search_title=$2, year=$3, position=$4, active=$5 WHERE id=$6 RETURNING *',
        [title, search_title || title, year || null, position ?? 0, active !== false, req.params.id]
    );
    res.json(rows[0]);
});

app.delete('/api/movies/:id', requireAuth, async (req, res) => {
    if (!db) return res.status(503).json({ error: 'No database configured' });
    await db.query('DELETE FROM movies WHERE id=$1', [req.params.id]);
    res.json({ success: true });
});

// ── Admin panel ───────────────────────────────────────────────────────────────
app.get('/admin', (req, res) => res.sendFile(path.join(__dirname, 'admin.html')));

// ── Serve Vite SPA ────────────────────────────────────────────────────────────
app.use(express.static(path.join(__dirname, 'dist')));
app.get('*', (req, res) => res.sendFile(path.join(__dirname, 'dist', 'index.html')));

// ── Start ─────────────────────────────────────────────────────────────────────
initDB()
    .then(() => app.listen(PORT, () => console.log(`[Server] http://localhost:${PORT}`)))
    .catch(err => {
        console.error('[DB] Init error:', err.message);
        app.listen(PORT, () => console.log(`[Server] http://localhost:${PORT} (no DB)`));
    });
