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

async function initDB() {
    if (!db) { console.log('[DB] No DATABASE_URL — using catalog.json fallback'); return; }
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
    const { rows } = await db.query('SELECT COUNT(*)::int AS n FROM series');
    if (rows[0].n === 0) {
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
    try {
        return JSON.parse(readFileSync(path.join(__dirname, 'src', 'catalog.json'), 'utf-8'));
    } catch { return []; }
}

// ── API Routes ────────────────────────────────────────────────────────────────

// GET /api/catalog — public
app.get('/api/catalog', async (req, res) => {
    if (!db) return res.json(catalogFallback());
    try {
        const { rows } = await db.query(
            'SELECT * FROM series WHERE active = true ORDER BY position ASC, id ASC'
        );
        res.json(rows);
    } catch (err) {
        console.error(err);
        res.json(catalogFallback());
    }
});

// GET /api/catalog/all — admin (including inactive)
app.get('/api/catalog/all', requireAuth, async (req, res) => {
    if (!db) return res.json(catalogFallback());
    const { rows } = await db.query('SELECT * FROM series ORDER BY position ASC, id ASC');
    res.json(rows);
});

// POST /api/admin/login
app.post('/api/admin/login', (req, res) => {
    if (req.body.password !== ADMIN_PASSWORD)
        return res.status(401).json({ error: 'Contraseña incorrecta' });
    const token = jwt.sign({ admin: true }, JWT_SECRET, { expiresIn: '12h' });
    res.json({ token });
});

// POST /api/catalog — add series
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

// PUT /api/catalog/:id — update series
app.put('/api/catalog/:id', requireAuth, async (req, res) => {
    if (!db) return res.status(503).json({ error: 'No database configured' });
    const { title, year, payload, position, active } = req.body;
    const { rows } = await db.query(
        'UPDATE series SET title=$1, year=$2, payload=$3, position=$4, active=$5 WHERE id=$6 RETURNING *',
        [title, year || null, payload, position ?? 0, active !== false, req.params.id]
    );
    res.json(rows[0]);
});

// DELETE /api/catalog/:id — delete series
app.delete('/api/catalog/:id', requireAuth, async (req, res) => {
    if (!db) return res.status(503).json({ error: 'No database configured' });
    await db.query('DELETE FROM series WHERE id=$1', [req.params.id]);
    res.json({ success: true });
});

// POST /api/catalog/reorder — bulk reorder
app.post('/api/catalog/reorder', requireAuth, async (req, res) => {
    if (!db) return res.status(503).json({ error: 'No database configured' });
    const { order } = req.body; // [{id, position}]
    for (const item of (order || [])) {
        await db.query('UPDATE series SET position=$1 WHERE id=$2', [item.position, item.id]);
    }
    res.json({ success: true });
});

// ── Admin panel ───────────────────────────────────────────────────────────────
app.get('/admin', (req, res) => {
    res.sendFile(path.join(__dirname, 'admin.html'));
});

// ── Serve Vite SPA ────────────────────────────────────────────────────────────
app.use(express.static(path.join(__dirname, 'dist')));
app.get('*', (req, res) => {
    res.sendFile(path.join(__dirname, 'dist', 'index.html'));
});

// ── Start ─────────────────────────────────────────────────────────────────────
initDB()
    .then(() => app.listen(PORT, () => console.log(`[Server] http://localhost:${PORT}`)))
    .catch(err => {
        console.error('[DB] Init error:', err.message);
        app.listen(PORT, () => console.log(`[Server] http://localhost:${PORT} (no DB)`));
    });
