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
const TMDB_KEY        = process.env.TMDB_KEY || '1f8cdf0007b2df2c1e11920cb50cfccf';
const TMDB_BASE       = 'https://api.themoviedb.org/3';

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

    // ── Skip raw file entries (not real movie titles) ───────────────────────
    // e.g. "La Jungla [ES] 1080p.mp4", "Movie.2024.BluRay.mkv"
    if (/\.(mp4|mkv|avi|mov|ts|m2ts|webm)\s*$/i.test(line)) return null;
    if (/\[(?:ES|ES5|CAST|LAT|Audio\s+Latino)[^\]]*\]\s*\d{3,4}p/i.test(line)) return null;

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
        .replace(/\s*\[(?:ES|ES5|CAST|LAT|Audio\s+Latino)[^\]]*\]/gi, '') // [ES], [CAST] tags
        .replace(/\s*\[(?:720|1080|2160)p[^\]]*\]/gi, '')                 // [720p] etc.
        .replace(/\s*\b(?:720p|1080p|4K|BluRay|BDRip|HDRip|HDTV|WEBRip|WEB-DL)\b/gi, '')
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

    // ── TMDB & Updates columns (non-destructive — safe to run on existing DB) ───────────
    for (const col of [
        'tmdb_id          INT',
        'tmdb_name        TEXT',
        'tmdb_overview    TEXT',
        'tmdb_poster      TEXT',
        'tmdb_backdrop    TEXT',
        'tmdb_rating      NUMERIC(3,1)',
        'tmdb_genre_ids   TEXT',
        'tmdb_resolved_at TIMESTAMPTZ',
        'last_updated     INT',
    ]) {
        const colName = col.trim().split(/\s+/)[0];
        await db.query(`ALTER TABLE series ADD COLUMN IF NOT EXISTS ${col}`).catch(() => {});
        await db.query(`ALTER TABLE movies ADD COLUMN IF NOT EXISTS ${col}`).catch(() => {});
    }

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
            const seen = new Map();
            let pos = 0;
            for (const raw of lines) {
                const parsed = parseTxtLine(raw);
                if (!parsed) continue;
                if (seen.has(parsed.dedupKey)) continue;
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

// ── TMDB Server-Side Resolution ───────────────────────────────────────────────

// Global progress tracker (single-run at a time)
let _resolveJob = null;

async function tmdbFetch(url) {
    const res = await fetch(url);
    if (res.status === 429) {
        // Rate limited — wait 10s and retry once
        await new Promise(r => setTimeout(r, 10000));
        return fetch(url);
    }
    return res;
}

async function resolveTmdbForRow(title, year, type) {
    // type: 'tv' | 'movie'
    const cleanTitle = title
        .replace(/^[^a-zA-Z0-9¿¡À-ÿ]+/, '')        // Strip hidden emojis, spaces, variations
        .replace(/^0\d{1,2}\s*[-_.]?\s*/, '')      // Strip 08, 097
        .replace(/^\d{1,3}\s*[-_.]\s+/, '')        // Strip 120 - 
        .replace(/\s*\(\d{4}\)\s*$/, '').trim()
        .split(/\s*[|·]\s*/)[0]
        .replace(/\s*\(\s*(Castellano|Cast\.|Latino|Audio|Español|Doblado|Subtitulado)[^)]*\)/gi, '')
        .replace(/\s*\([^)]*\)\s*$/, '')
        .trim();

    const endpoint = type === 'tv' ? 'search/tv' : 'search/movie';
    const yearParam = type === 'tv' ? 'first_air_date_year' : 'primary_release_year';

    async function search(q, withYear) {
        const params = new URLSearchParams({ api_key: TMDB_KEY, query: q, language: 'es-ES', include_adult: false });
        if (withYear && year) params.set(yearParam, year);
        const res = await tmdbFetch(`${TMDB_BASE}/${endpoint}?${params}`);
        const json = await res.json();
        return json.results?.[0] || null;
    }

    let r = await search(cleanTitle, true);
    if (!r && year) r = await search(cleanTitle, false);
    if (!r) {
        // Last resort: strip special chars
        const stripped = cleanTitle.replace(/[:''""\-]/g, ' ').replace(/\s+/g, ' ').trim();
        if (stripped !== cleanTitle) r = await search(stripped, false);
    }
    if (!r) return null;

    return {
        tmdb_id:          r.id,
        tmdb_name:        r.name || r.title || null,
        tmdb_overview:    r.overview || null,
        tmdb_poster:      r.poster_path || null,
        tmdb_backdrop:    r.backdrop_path || null,
        tmdb_rating:      r.vote_average ? Math.round(r.vote_average * 10) / 10 : null,
        tmdb_genre_ids:   r.genre_ids ? JSON.stringify(r.genre_ids) : null,
    };
}

async function forceResolveTmdb(tmdbId, type) {
    // type: 'tv' | 'movie'
    const endpoint = type === 'tv' ? `tv/${tmdbId}` : `movie/${tmdbId}`;
    const params = new URLSearchParams({ api_key: TMDB_KEY, language: 'es-ES' });
    const res = await tmdbFetch(`${TMDB_BASE}/${endpoint}?${params}`);
    if (!res.ok) return null;
    const r = await res.json();
    return {
        tmdb_id:          r.id,
        tmdb_name:        r.name || r.title || null,
        tmdb_overview:    r.overview || null,
        tmdb_poster:      r.poster_path || null,
        tmdb_backdrop:    r.backdrop_path || null,
        tmdb_rating:      r.vote_average ? Math.round(r.vote_average * 10) / 10 : null,
        tmdb_genre_ids:   r.genres ? JSON.stringify(r.genres.map(g => g.id)) : null,
    };
}

async function runResolveJob() {
    if (!db) return { error: 'No database' };
    if (_resolveJob?.running) return { error: 'Ya hay una resolución en curso' };

    _resolveJob = { running: true, resolved: 0, skipped: 0, failed: 0, total: 0, done: false, startedAt: Date.now() };

    (async () => {
        try {
            // ── 1. SYNC FROM GITHUB ───────────────────────────────────────────
            // Ensure Railway has the latest items added by the Telegram Bot
            console.log('[TMDB] Fetching latest JSON from GitHub to sync new items...');
            try {
                // Sync Series
                const resC = await fetch('https://raw.githubusercontent.com/Crono2021/cineflix-catalog/main/catalog.json?v=' + Date.now());
                if (resC.ok) {
                    const latestSeries = await resC.json();
                    const { rows } = await db.query('SELECT payload, last_updated FROM series');
                    const existingPayloads = new Map(rows.map(r => [r.payload, r.last_updated || 0]));
                    let addedSeries = 0;
                    let updatedSeries = 0;
                    for (let i = 0; i < latestSeries.length; i++) {
                        const s = latestSeries[i];
                        const key = s.payload || s.id || s.title;
                        const hasKey = existingPayloads.has(key);
                        if (!hasKey) {
                            await db.query(
                                'INSERT INTO series (title, year, payload, position, last_updated) VALUES ($1,$2,$3,$4,$5)',
                                [s.title, s.year || null, key, i, s.last_updated || null]
                            );
                            existingPayloads.set(key, s.last_updated || 0);
                            addedSeries++;
                        } else {
                            const oldTs = existingPayloads.get(key) || 0;
                            const newTs = s.last_updated || 0;
                            if (newTs > oldTs) {
                                await db.query('UPDATE series SET last_updated=$1 WHERE payload=$2', [newTs, key]);
                                existingPayloads.set(key, newTs);
                                updatedSeries++;
                            }
                        }
                    }
                    console.log(`[TMDB] Sync series: added ${addedSeries}, updated ${updatedSeries} timestamps from GitHub.`);
                }
                
                // Sync Movies
                const resM = await fetch('https://raw.githubusercontent.com/Crono2021/cineflix-catalog/main/movies.json?v=' + Date.now());
                if (resM.ok) {
                    const latestMovies = await resM.json();
                    const { rows } = await db.query('SELECT search_title, COALESCE(year, 0) as year FROM movies');
                    const existingMovies = new Set(rows.map(r => r.search_title + '|' + r.year));
                    let addedMovies = 0;
                    for (let i = 0; i < latestMovies.length; i++) {
                        const m = latestMovies[i];
                        const key = (m.search_title || m.title) + '|' + (m.year || 0);
                        if (!existingMovies.has(key)) {
                            await db.query(
                                'INSERT INTO movies (title, search_title, year, position) VALUES ($1,$2,$3,$4)',
                                [m.title, m.search_title || m.title, m.year || null, i]
                            );
                            existingMovies.add(key);
                            addedMovies++;
                        }
                    }
                    console.log(`[TMDB] Sync movies: added ${addedMovies} new entries from GitHub.`);
                }
            } catch (syncErr) {
                console.warn('[TMDB] Sync from GitHub failed:', syncErr.message);
            }

            // ── 2. RESOLVE TMDB ───────────────────────────────────────────────
            // Fetch all unresolved series
            const { rows: series } = await db.query(
                `SELECT id, title, year FROM series WHERE tmdb_resolved_at IS NULL AND active = true ORDER BY position ASC`
            );
            // Fetch all unresolved movies (limit to avoid overloading TMDB on first run)
            const { rows: movies } = await db.query(
                `SELECT id, title, search_title, year FROM movies WHERE tmdb_resolved_at IS NULL AND active = true ORDER BY position ASC LIMIT 2000`
            );

            _resolveJob.total = series.length + movies.length;
            console.log(`[TMDB] Starting resolution: ${series.length} series + ${movies.length} movies`);

            // ── Resolve series ────────────────────────────────────────────────
            for (const s of series) {
                try {
                    // Throttle: 40 req/10s = 250ms between requests
                    await new Promise(r => setTimeout(r, 260));
                    const data = await resolveTmdbForRow(s.title, s.year, 'tv');
                    if (data) {
                        await db.query(
                            `UPDATE series SET tmdb_id=$1, tmdb_name=$2, tmdb_overview=$3,
                             tmdb_poster=$4, tmdb_backdrop=$5, tmdb_rating=$6,
                             tmdb_genre_ids=$7, tmdb_resolved_at=NOW() WHERE id=$8`,
                            [data.tmdb_id, data.tmdb_name, data.tmdb_overview, data.tmdb_poster,
                             data.tmdb_backdrop, data.tmdb_rating, data.tmdb_genre_ids, s.id]
                        );
                        _resolveJob.resolved++;
                    } else {
                        // Mark as attempted (null tmdb_id, but resolved_at set) to skip on next run
                        await db.query(`UPDATE series SET tmdb_resolved_at=NOW() WHERE id=$1`, [s.id]);
                        _resolveJob.skipped++;
                    }
                } catch (e) {
                    console.warn(`[TMDB] Series failed: ${s.title}`, e.message);
                    _resolveJob.failed++;
                }
            }

            // ── Resolve movies ────────────────────────────────────────────────
            for (const m of movies) {
                try {
                    await new Promise(r => setTimeout(r, 260));
                    const titleToSearch = m.search_title || m.title;
                    const data = await resolveTmdbForRow(titleToSearch, m.year, 'movie');
                    if (data) {
                        await db.query(
                            `UPDATE movies SET tmdb_id=$1, tmdb_name=$2, tmdb_overview=$3,
                             tmdb_poster=$4, tmdb_backdrop=$5, tmdb_rating=$6,
                             tmdb_genre_ids=$7, tmdb_resolved_at=NOW() WHERE id=$8`,
                            [data.tmdb_id, data.tmdb_name, data.tmdb_overview, data.tmdb_poster,
                             data.tmdb_backdrop, data.tmdb_rating, data.tmdb_genre_ids, m.id]
                        );
                        _resolveJob.resolved++;
                    } else {
                        await db.query(`UPDATE movies SET tmdb_resolved_at=NOW() WHERE id=$1`, [m.id]);
                        _resolveJob.skipped++;
                    }
                } catch (e) {
                    console.warn(`[TMDB] Movie failed: ${m.title}`, e.message);
                    _resolveJob.failed++;
                }
            }
        } catch (e) {
            console.error('[TMDB] Resolve job crashed:', e.message);
        } finally {
            _resolveJob.running = false;
            _resolveJob.done = true;
            console.log(`[TMDB] Done — resolved:${_resolveJob.resolved} skipped:${_resolveJob.skipped} failed:${_resolveJob.failed}`);
        }
    })();

    return { started: true };
}

// ── App ───────────────────────────────────────────────────────────────────────
const app = express();
app.use(express.json());

// ── CORS — allow GitHub Pages and local dev to query Railway directly ─────────
const ALLOWED_ORIGINS = [
    'https://crono2021.github.io',
    'https://crono-apps.github.io',
    'http://localhost:5173',
    'http://localhost:3001',
];
app.use((req, res, next) => {
    const origin = req.headers.origin;
    if (!origin || ALLOWED_ORIGINS.includes(origin)) {
        res.setHeader('Access-Control-Allow-Origin', origin || '*');
    }
    res.setHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, OPTIONS');
    res.setHeader('Access-Control-Allow-Headers', 'Content-Type, Authorization');
    if (req.method === 'OPTIONS') return res.sendStatus(204);
    next();
});

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
        const afterId = parseInt(req.query.after_id || '0', 10);
        const query = afterId > 0
            ? 'SELECT * FROM series WHERE active = true AND id > $1 ORDER BY id ASC'
            : 'SELECT * FROM series WHERE active = true ORDER BY position ASC, id ASC';
        const params = afterId > 0 ? [afterId] : [];
        const { rows } = await db.query(query, params);
        res.json(rows);
    } catch (err) { console.error(err); res.json(catalogFallback()); }
});

// Lightweight meta check — returns {count, maxId} so client knows if delta sync is needed
app.get('/api/catalog/meta', async (req, res) => {
    if (!db) return res.json({ count: 0, maxId: 0 });
    try {
        const { rows } = await db.query('SELECT COUNT(*) AS count, MAX(id) AS max_id FROM series WHERE active = true');
        res.json({ count: parseInt(rows[0].count), maxId: parseInt(rows[0].max_id) || 0 });
    } catch (err) { res.json({ count: 0, maxId: 0 }); }
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

// GET /api/movies — public, supports ?q=search and ?after_id=N for delta sync
app.get('/api/movies', async (req, res) => {
    if (!db) return res.json([]);
    try {
        const q = (req.query.q || '').trim();
        const afterId = parseInt(req.query.after_id || '0', 10);
        let rows;
        if (q) {
            const result = await db.query(
                `SELECT * FROM movies WHERE active = true
                 AND (LOWER(title) LIKE LOWER($1) OR LOWER(search_title) LIKE LOWER($1))
                 ORDER BY position ASC, id ASC LIMIT 200`,
                [`%${q}%`]
            );
            rows = result.rows;
        } else if (afterId > 0) {
            const result = await db.query(
                'SELECT * FROM movies WHERE active = true AND id > $1 ORDER BY id ASC',
                [afterId]
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

// Lightweight meta check for movies delta sync
app.get('/api/movies/meta', async (req, res) => {
    if (!db) return res.json({ count: 0, maxId: 0 });
    try {
        const { rows } = await db.query('SELECT COUNT(*) AS count, MAX(id) AS max_id FROM movies WHERE active = true');
        res.json({ count: parseInt(rows[0].count), maxId: parseInt(rows[0].max_id) || 0 });
    } catch (err) { res.json({ count: 0, maxId: 0 }); }
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

// ── TMDB Resolve endpoints ────────────────────────────────────────────────────
app.post('/api/admin/resolve-tmdb', requireAuth, async (req, res) => {
    if (!db) return res.status(503).json({ error: 'No database configured' });
    if (_resolveJob?.running) return res.status(409).json({ error: 'Ya hay una resolución en curso', job: _resolveJob });
    const result = await runResolveJob();
    res.json(result);
});

app.get('/api/admin/resolve-tmdb/status', requireAuth, (req, res) => {
    if (!_resolveJob) return res.json({ running: false, done: false, resolved: 0, skipped: 0, failed: 0, total: 0 });
    res.json(_resolveJob);
});

// Reset tmdb_resolved_at for a single series (force re-resolve)
app.post('/api/admin/resolve-tmdb/reset/:table/:id', requireAuth, async (req, res) => {
    if (!db) return res.status(503).json({ error: 'No database' });
    const table = req.params.table === 'movies' ? 'movies' : 'series';
    await db.query(`UPDATE ${table} SET tmdb_resolved_at=NULL, tmdb_id=NULL WHERE id=$1`, [req.params.id]);
    res.json({ success: true });
});

// Reset ALL failed (unresolved) items across both tables
app.post('/api/admin/resolve-tmdb/retry-failed', requireAuth, async (req, res) => {
    if (!db) return res.status(503).json({ error: 'No database' });
    if (_resolveJob?.running) return res.status(409).json({ error: 'Ya hay una resolución en curso' });
    await db.query(`UPDATE movies SET tmdb_resolved_at=NULL WHERE tmdb_id IS NULL AND tmdb_resolved_at IS NOT NULL`);
    await db.query(`UPDATE series SET tmdb_resolved_at=NULL WHERE tmdb_id IS NULL AND tmdb_resolved_at IS NOT NULL`);
    res.json({ success: true });
});

// Reset ALL items across both tables from scratch
app.post('/api/admin/resolve-tmdb/reset-all', requireAuth, async (req, res) => {
    if (!db) return res.status(503).json({ error: 'No database' });
    if (_resolveJob?.running) return res.status(409).json({ error: 'Ya hay una resolución en curso' });
    await db.query(`UPDATE movies SET tmdb_resolved_at=NULL, tmdb_id=NULL`);
    await db.query(`UPDATE series SET tmdb_resolved_at=NULL, tmdb_id=NULL`);
    res.json({ success: true });
});

// ── Manual Resolve Endpoints ──────────────────────────────────────────────────
app.get('/api/admin/unresolved', requireAuth, async (req, res) => {
    if (!db) return res.json([]);
    const { rows: movies } = await db.query(`
        SELECT id, title, 'movies' AS table_name, year 
        FROM movies 
        WHERE tmdb_id IS NULL AND tmdb_resolved_at IS NOT NULL
    `);
    const { rows: series } = await db.query(`
        SELECT id, title, 'series' AS table_name, year 
        FROM series 
        WHERE tmdb_id IS NULL AND tmdb_resolved_at IS NOT NULL
    `);
    res.json([...movies, ...series]);
});

app.post('/api/admin/force-resolve', requireAuth, async (req, res) => {
    if (!db) return res.status(503).json({ error: 'No database' });
    const { dbId, table, tmdbId } = req.body;
    if (!dbId || !table || !tmdbId) return res.status(400).json({ error: 'Missing parameters' });
    
    try {
        const type = table === 'movies' ? 'movie' : 'tv';
        const data = await forceResolveTmdb(tmdbId, type);
        
        if (!data) return res.status(404).json({ error: 'No se encontró ese ID en TMDB' });
        
        await db.query(
            `UPDATE ${table} SET tmdb_id=$1, tmdb_name=$2, tmdb_overview=$3,
             tmdb_poster=$4, tmdb_backdrop=$5, tmdb_rating=$6,
             tmdb_genre_ids=$7, tmdb_resolved_at=NOW() WHERE id=$8`,
            [data.tmdb_id, data.tmdb_name, data.tmdb_overview, data.tmdb_poster,
             data.tmdb_backdrop, data.tmdb_rating, data.tmdb_genre_ids, dbId]
        );
        res.json({ success: true, data });
    } catch(err) {
        console.error('[Force Resolve] Error:', err);
        res.status(500).json({ error: 'Error interno o de TMDB: ' + err.message });
    }
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
