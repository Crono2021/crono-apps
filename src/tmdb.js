// TMDB API integration for TelegramFlix
// Fetches series posters, metadata and episode details

const TMDB_KEY = '1f8cdf0007b2df2c1e11920cb50cfccf';
const TMDB_BASE = 'https://api.themoviedb.org/3';
const IMG_BASE = 'https://image.tmdb.org/t/p/';
const CACHE_TTL = 7 * 24 * 60 * 60 * 1000; // 7 days

// Simple request throttle — max 5 concurrent TMDB requests
let _activeReqs = 0;
const _queue = [];
function throttledFetch(url) {
    return new Promise((resolve, reject) => {
        const run = () => {
            _activeReqs++;
            fetch(url)
                .then(resolve, reject)
                .finally(() => {
                    _activeReqs--;
                    if (_queue.length) _queue.shift()();
                });
        };
        if (_activeReqs < 5) run();
        else _queue.push(run);
    });
}

function cacheGet(key) {
    try {
        const raw = localStorage.getItem('tmdb_' + key);
        if (!raw) return null;
        const { ts, data } = JSON.parse(raw);
        if (Date.now() - ts > CACHE_TTL) { localStorage.removeItem('tmdb_' + key); return null; }
        return data;
    } catch { return null; }
}

function cacheSet(key, data) {
    try {
        localStorage.setItem('tmdb_' + key, JSON.stringify({ ts: Date.now(), data }));
    } catch { }
}

export function posterUrl(path, size = 'w500') {
    return path ? `${IMG_BASE}${size}${path}` : null;
}

export function stillUrl(path, size = 'w300') {
    return path ? `${IMG_BASE}${size}${path}` : null;
}

/**
 * Search TMDB for a TV series by title and optional year.
 * Returns the best match with id, title, poster, backdrop, overview.
 */
export async function searchSeries(title, year) {
    // Strip trailing (year) from titles like "Breaking Bad (2008)" → "Breaking Bad"
    const cleanTitle = title.replace(/\s*\(\d{4}\)\s*$/, '').trim();

    const key = `series_${cleanTitle}_${year || ''}`.toLowerCase().replace(/[^a-z0-9_]/g, '_');
    const cached = cacheGet(key);
    if (cached !== null) return cached;

    try {
        const params = new URLSearchParams({
            api_key: TMDB_KEY,
            query: cleanTitle,
            language: 'es-ES',
            include_adult: false,
        });
        if (year) params.set('first_air_date_year', year);

        const res = await throttledFetch(`${TMDB_BASE}/search/tv?${params}`);
        const json = await res.json();
        let r = json.results?.[0];

        // Retry without year if no result
        if (!r && year) {
            const params2 = new URLSearchParams({ api_key: TMDB_KEY, query: cleanTitle, language: 'es-ES', include_adult: false });
            const res2 = await throttledFetch(`${TMDB_BASE}/search/tv?${params2}`);
            const json2 = await res2.json();
            r = json2.results?.[0];
        }

        if (!r) { cacheSet(key, null); return null; }

        const info = {
            id: r.id,
            name: r.name,
            originalName: r.original_name,
            overview: r.overview,
            posterPath: r.poster_path,
            backdropPath: r.backdrop_path,
            year: r.first_air_date?.slice(0, 4),
            rating: Math.round(r.vote_average * 10) / 10,
            voteCount: r.vote_count,
            genreIds: r.genre_ids,
        };

        cacheSet(key, info);
        return info;
    } catch (err) {
        console.warn('[TMDB] Search failed for', title, err.message);
        return null;
    }
}

/**
 * Search TMDB for a movie by title and optional year.
 */
export async function searchMovie(title, year) {
    const cleanTitle = title.replace(/\s*\(\d{4}\)\s*$/, '').trim();
    const key = `movie_${cleanTitle}_${year || ''}`.toLowerCase().replace(/[^a-z0-9_]/g, '_');
    const cached = cacheGet(key);
    if (cached !== null) return cached;

    try {
        const params = new URLSearchParams({
            api_key: TMDB_KEY, query: cleanTitle, language: 'es-ES', include_adult: false,
        });
        if (year) params.set('primary_release_year', year);
        const res = await throttledFetch(`${TMDB_BASE}/search/movie?${params}`);
        const json = await res.json();
        let r = json.results?.[0];
        if (!r && year) {
            const p2 = new URLSearchParams({ api_key: TMDB_KEY, query: cleanTitle, language: 'es-ES', include_adult: false });
            const r2 = await throttledFetch(`${TMDB_BASE}/search/movie?${p2}`);
            r = (await r2.json()).results?.[0];
        }
        if (!r) { cacheSet(key, null); return null; }
        const info = {
            id: r.id, name: r.title, overview: r.overview,
            posterPath: r.poster_path, backdropPath: r.backdrop_path,
            year: r.release_date?.slice(0, 4),
            rating: Math.round(r.vote_average * 10) / 10,
        };
        cacheSet(key, info);
        return info;
    } catch (err) {
        console.warn('[TMDB] Movie search failed for', title, err.message);
        return null;
    }
}

/**
 * Get episodes for a specific season from TMDB.
 * Returns array of { number, name, overview, stillPath, runtime }.
 */
export async function getSeasonEpisodes(tmdbId, seasonNumber) {
    const key = `season_${tmdbId}_${seasonNumber}`;
    const cached = cacheGet(key);
    if (cached !== null) return cached;

    try {
        const params = new URLSearchParams({ api_key: TMDB_KEY, language: 'es-ES' });
        const res = await fetch(`${TMDB_BASE}/tv/${tmdbId}/season/${seasonNumber}?${params}`);
        const json = await res.json();
        if (!json.episodes) { cacheSet(key, []); return []; }

        const episodes = json.episodes.map(ep => ({
            number: ep.episode_number,
            name: ep.name,
            overview: ep.overview || '',
            stillPath: ep.still_path,
            runtime: ep.runtime,
            airDate: ep.air_date,
        }));

        cacheSet(key, episodes);
        return episodes;
    } catch (err) {
        console.warn('[TMDB] Season fetch failed', tmdbId, seasonNumber, err.message);
        return [];
    }
}

/**
 * Get trending TV shows from TMDB (cached 24h).
 */
export async function getTrending(timeWindow = 'week') {
    const key = `trending_tv_${timeWindow}`;
    const TTL_24H = 24 * 60 * 60 * 1000;
    try {
        const raw = localStorage.getItem('tmdb_' + key);
        if (raw) {
            const { ts, data } = JSON.parse(raw);
            if (Date.now() - ts < TTL_24H) return data;
            localStorage.removeItem('tmdb_' + key);
        }
    } catch { }

    try {
        const params = new URLSearchParams({ api_key: TMDB_KEY, language: 'es-ES' });
        const res = await fetch(`${TMDB_BASE}/trending/tv/${timeWindow}?${params}`);
        const json = await res.json();

        const results = (json.results || []).map(r => ({
            id: r.id,
            name: r.name,
            originalName: r.original_name,
            overview: r.overview,
            posterPath: r.poster_path,
            backdropPath: r.backdrop_path,
            year: r.first_air_date?.slice(0, 4),
            rating: Math.round(r.vote_average * 10) / 10,
            genreIds: r.genre_ids,
        }));

        localStorage.setItem('tmdb_' + key, JSON.stringify({ ts: Date.now(), data: results }));
        return results;
    } catch (err) {
        console.warn('[TMDB] Trending failed:', err.message);
        return [];
    }
}

/**
 * Get trending movies from TMDB (cached 24h).
 */
export async function getTrendingMovies(timeWindow = 'week') {
    const key = `trending_movie_${timeWindow}`;
    const TTL_24H = 24 * 60 * 60 * 1000;
    try {
        const raw = localStorage.getItem('tmdb_' + key);
        if (raw) {
            const { ts, data } = JSON.parse(raw);
            if (Date.now() - ts < TTL_24H) return data;
            localStorage.removeItem('tmdb_' + key);
        }
    } catch { }

    try {
        const params = new URLSearchParams({ api_key: TMDB_KEY, language: 'es-ES' });
        const res = await fetch(`${TMDB_BASE}/trending/movie/${timeWindow}?${params}`);
        const json = await res.json();
        const results = (json.results || []).map(r => ({
            id: r.id, name: r.title, originalName: r.original_title,
            overview: r.overview, posterPath: r.poster_path,
            backdropPath: r.backdrop_path, year: r.release_date?.slice(0, 4),
            rating: Math.round(r.vote_average * 10) / 10, genreIds: r.genre_ids,
        }));
        localStorage.setItem('tmdb_' + key, JSON.stringify({ ts: Date.now(), data: results }));
        return results;
    } catch (err) {
        console.warn('[TMDB] Movie trending failed:', err.message);
        return [];
    }
}

/**
 * Normalize a title for fuzzy matching (remove year, accents, symbols).
 */
export function normTitle(t) {
    return (t || '')
        .replace(/\s*\(\d{4}\)\s*$/, '')
        .toLowerCase()
        .replace(/[áàäâ]/g, 'a').replace(/[éèëê]/g, 'e')
        .replace(/[íìïî]/g, 'i').replace(/[óòöô]/g, 'o')
        .replace(/[úùüû]/g, 'u').replace(/[ñ]/g, 'n')
        .replace(/[^a-z0-9\s]/g, '').trim();
}

export function extractSeasonNumber(label) {
    const m = label.match(/(?:temporada|season|t(?:emp)?\.?\s*)[\s.]?(\d+)/i)
        || label.match(/(\d+)/);
    return m ? parseInt(m[1]) : 1;
}

/**
 * Extract season/episode numbers from a filename or Telegram caption.
 * Handles multiple formats used by the bot:
 *   - 1x03, 01x03 (latin x)
 *   - S01E03, s01e03
 *   - 4×05  (Unicode × multiply sign)
 *   - "The Boys temporada 4 episodio 1" (Spanish caption)
 *   - Cap.403  (first digit = season, last 2 = episode)
 */
export function parseEpisodeFile(filename) {
    if (!filename) return null;

    // Format: S01E03, s01e03
    const m1 = filename.match(/[sS](\d{1,2})[eE](\d{2})/);
    if (m1) return { season: parseInt(m1[1]), episode: parseInt(m1[2]) };

    // Format: 1x03, 01x03 (latin x)
    const m2 = filename.match(/(\d{1,2})[xX](\d{2})/);
    if (m2) return { season: parseInt(m2[1]), episode: parseInt(m2[2]) };

    // Format: 4×05 (Unicode × U+00D7 as used in bot captions)
    const m3 = filename.match(/(\d{1,2})[×✕✗](\d{1,2})/);
    if (m3) return { season: parseInt(m3[1]), episode: parseInt(m3[2]) };

    // Format: "temporada 4 episodio 1" or "temporada 4 capitulo 1" (Spanish)
    const m4 = filename.match(/temporada\s+(\d+)\s+(?:episodio|cap[íi]tulo|cap\.?)\s+(\d+)/i);
    if (m4) return { season: parseInt(m4[1]), episode: parseInt(m4[2]) };

    // Format: Cap.403 → season=4, episode=03
    const m5 = filename.match(/[Cc]ap\.?(\d)(\d{2})/);
    if (m5) return { season: parseInt(m5[1]), episode: parseInt(m5[2]) };

    return null;
}
