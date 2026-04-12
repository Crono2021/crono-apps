// Force a single Buffer implementation before GramJS loads.
// Without this, Buffer.isBuffer() fails across module boundaries.
import { Buffer as _Buf } from 'buffer';
window.Buffer = _Buf;
globalThis.Buffer = _Buf;

let catalog = [];

async function loadCatalog() {
    try {
        const res = await fetch('/api/catalog');
        if (res.ok) catalog = await res.json();
        else throw new Error('API error');
    } catch {
        // Fallback: embedded catalog (only if API fails)
        try {
            const mod = await import('./catalog.json', { assert: { type: 'json' } });
            catalog = mod.default;
        } catch { catalog = []; }
    }
}
import {
    isLoggedIn, sendCode, verifyCode, verify2FA, logout,
    sendBotCommand, clickInlineButton, getVideoMessages,
    streamVideo, initServiceWorker, searchMovieByPayload,
} from './telegram.js';
import {
    searchSeries, searchMovie, getSeasonEpisodes, extractSeasonNumber,
    parseEpisodeFile, posterUrl, stillUrl,
    getTrending, getTrendingMovies, discoverMoviesByGenre, normTitle,
} from './tmdb.js';


// ===== STATE =====
let currentPhone = '';
let currentSeries = null;
let currentBotMsgId = null;
let currentTmdb = null;

// ===== CATALOG STATE =====
let catalogTmdbCache = new Map(); // title → TmdbInfo
let heroShows = [];
let heroIndex = 0;
let heroTimer = null;
let genreLoading = false;

// ===== MOVIES STATE =====
let moviesCatalog = [];
let moviesReady = false;
let movieTmdbCache = new Map();
let movieGenreCache = new Map(); // rowId → catalog movies[] (populated by discover)
let movieHeroShows = [];
let movieHeroIndex = 0;
let movieHeroTimer = null;
let lastMovieData = null; // { movie, videos } — cached for instant modal reopen
let playerOrigin = 'episodes'; // 'episodes' | 'movie'
let catalogScrollPage = 0;
const CATALOG_PAGE_SIZE = 60;
let catalogReady = false;
let genreUpdateTimer = null; // debounce genre row updates


const GENRE_ROWS = [
    { id: 'drama',     title: '🎭 Drama',                    ids: [18] },
    { id: 'comedy',    title: '😂 Comedia',                   ids: [35] },
    { id: 'action',    title: '⚡ Acción y aventura',          ids: [10759] },
    { id: 'scifi',     title: '🚀 Ciencia ficción y fantasía', ids: [10765] },
    { id: 'crime',     title: '🔍 Crimen y misterio',          ids: [80] },
    { id: 'animation', title: '🎨 Animación',                  ids: [16] },
    { id: 'family',    title: '👨\u200D👩\u200D👧 Familiar',   ids: [10751] },
];

// ===== DOM =====
const $ = id => document.getElementById(id);

// ===== VIEW MANAGEMENT =====
function showView(viewId) {
    document.querySelectorAll('.view').forEach(v => v.classList.remove('active'));
    $(viewId).classList.add('active');
}

function showStep(stepId) {
    document.querySelectorAll('.login-step').forEach(s => s.classList.remove('active'));
    $(stepId).classList.add('active');
}

// ===== INIT =====
async function init() {
    showView('view-login');
    showStep('login-loading');

    // Init Service Worker (blocking — must be ready before streaming)
    await initServiceWorker();

    try {
        const loggedIn = await isLoggedIn();
        if (loggedIn) {
            showCatalog();
        } else {
            showStep('step-phone');
        }
    } catch {
        showStep('step-phone');
    }
}

// ===== AUTH =====
$('btn-phone').addEventListener('click', async () => {
    const phone = $('input-phone').value.trim();
    if (!phone) return;

    currentPhone = phone;
    $('btn-phone').disabled = true;
    $('phone-error').textContent = '';

    try {
        await sendCode(phone);
        showStep('step-otp');
        $('input-otp').focus();
    } catch (err) {
        $('phone-error').textContent = err.message || 'Error al enviar código';
    } finally {
        $('btn-phone').disabled = false;
    }
});

$('btn-otp').addEventListener('click', async () => {
    const code = $('input-otp').value.trim();
    if (!code) return;

    $('btn-otp').disabled = true;
    $('otp-error').textContent = '';

    try {
        const result = await verifyCode(currentPhone, code);
        if (result.needs2FA) {
            showStep('step-2fa');
            $('input-2fa').focus();
        } else {
            showCatalog();
        }
    } catch (err) {
        $('otp-error').textContent = err.message || 'Código incorrecto';
    } finally {
        $('btn-otp').disabled = false;
    }
});

$('btn-2fa').addEventListener('click', async () => {
    const pass = $('input-2fa').value;
    if (!pass) return;

    $('btn-2fa').disabled = true;
    $('twofa-error').textContent = '';

    try {
        await verify2FA(pass);
        showCatalog();
    } catch (err) {
        $('twofa-error').textContent = err.message || 'Error de autenticación';
    } finally {
        $('btn-2fa').disabled = false;
    }
});

// Enter key support
$('input-phone').addEventListener('keydown', e => { if (e.key === 'Enter') $('btn-phone').click(); });
$('input-otp').addEventListener('keydown', e => { if (e.key === 'Enter') $('btn-otp').click(); });
$('input-2fa').addEventListener('keydown', e => { if (e.key === 'Enter') $('btn-2fa').click(); });

$('btn-logout').addEventListener('click', async () => {
    if (confirm('¿Cerrar sesión?')) {
        await logout();
        location.reload();
    }
});

// ===== CATALOG =====
async function showCatalog() {
    showView('view-catalog');
    $('search-input').value = '';
    showSection('home');

    if (catalogReady) {
        // Resume slideshow if paused
        if (heroShows.length > 0 && !heroTimer) startHeroTimer();
        return;
    }
    catalogReady = true;

    // Load catalog from API (or fallback)
    await loadCatalog();

    // Genre tabs
    initGenreTabs();

    // Search handler
    $('search-input').oninput = () => {
        const q = $('search-input').value.toLowerCase().trim();
        if (!q) { showSection('home'); return; }
        showSection('grid');
        const filtered = catalog.filter(s => s.title.toLowerCase().includes(q));
        renderGrid(filtered);
        $('search-count').textContent = `${filtered.length} resultado${filtered.length !== 1 ? 's' : ''}`;
    };

    // 1. Estrenos recientes (no TMDB needed)
    const recent = [...catalog]
        .filter(s => s.year >= 2023)
        .sort((a, b) => (b.year || 0) - (a.year || 0))
        .slice(0, 30);
    renderRow('recent', '🆕 Estrenos recientes', recent);

    // 2. Trending from TMDB
    try {
        const trendingTmdb = await getTrending();
        const matched = trendingTmdb.map(t => findInCatalog(t)).filter(Boolean);
        if (matched.length > 0) {
            renderRow('trending', '🔥 En tendencia esta semana', matched, true);
            await setupHero(matched.slice(0, 5));
        } else {
            await setupHero(recent.slice(0, 5));
        }
    } catch {
        await setupHero(recent.slice(0, 5));
    }

    // 3. Genre rows (background)
    loadGenresBackground();
}

// Show/hide the two content modes
function showSection(mode) {
    // mode: 'home' | 'grid'
    const home = $('netflix-content');
    const grid = $('search-results');
    home.style.display = mode === 'home' ? 'block' : 'none';
    grid.style.display = mode === 'grid' ? 'block' : 'none';
    if (mode === 'home' && heroTimer === null && heroShows.length > 0) startHeroTimer();
    if (mode === 'grid' && heroTimer) { clearInterval(heroTimer); heroTimer = null; }
}

// Match TMDB show against catalog using normalized title
function findInCatalog(tmdbShow) {
    const n = normTitle(tmdbShow.name);
    const no = normTitle(tmdbShow.originalName || '');
    return catalog.find(s => {
        const sn = normTitle(s.title);
        return sn === n || (no && sn === no);
    });
}

// ===== HERO =====
async function setupHero(series) {
    if (!series.length) return;
    heroShows = series;
    heroIndex = 0;
    updateHeroDots();
    await renderHeroSlide(0);
    startHeroTimer();
}

function startHeroTimer() {
    if (heroTimer) clearInterval(heroTimer);
    heroTimer = setInterval(() => {
        heroIndex = (heroIndex + 1) % heroShows.length;
        renderHeroSlide(heroIndex);
        updateHeroDots();
    }, 8000);
}

async function renderHeroSlide(idx) {
    const series = heroShows[idx];
    if (!series) return;
    const tmdb = await searchSeries(series.title, series.year);
    const displayTitle = series.title.replace(/\s*\(\d{4}\)\s*$/, '').trim();

    $('hero-title').textContent = tmdb?.name || displayTitle;
    $('hero-overview').textContent = tmdb?.overview || '';
    $('hero-meta').innerHTML = [
        tmdb?.rating ? `<span class="hero-rating">★ ${tmdb.rating}</span>` : '',
        tmdb?.year || series.year ? `<span>${tmdb?.year || series.year}</span>` : '',
    ].filter(Boolean).join('');

    if (tmdb?.backdropPath) {
        $('hero-backdrop').style.backgroundImage =
            `url('https://image.tmdb.org/t/p/w1280${tmdb.backdropPath}')`;
    }
    $('hero-play-btn').onclick = () => openSeries(series);
}

function updateHeroDots() {
    const dotsEl = $('hero-dots');
    dotsEl.innerHTML = '';
    if (heroShows.length <= 1) return;
    heroShows.forEach((_, i) => {
        const dot = document.createElement('button');
        dot.className = 'hero-dot' + (i === heroIndex ? ' active' : '');
        dot.addEventListener('click', () => {
            heroIndex = i;
            clearInterval(heroTimer); heroTimer = null;
            renderHeroSlide(i);
            updateHeroDots();
            startHeroTimer();
        });
        dotsEl.appendChild(dot);
    });
}

// ===== GENRE TABS =====
function initGenreTabs() {
    const tabs = $('genre-tabs');
    tabs.innerHTML = '';

    function makeTab(label, onClick) {
        const btn = document.createElement('button');
        btn.className = 'genre-tab';
        btn.textContent = label;
        btn.addEventListener('click', () => {
            tabs.querySelectorAll('.genre-tab').forEach(t => t.classList.remove('active'));
            btn.classList.add('active');
            onClick();
        });
        return btn;
    }

    const allTab = makeTab('✦ Todos', () => showSection('home'));
    allTab.classList.add('active');
    tabs.appendChild(allTab);

    const genres = [
        { label: '🎭 Drama',     id: 18 },
        { label: '😂 Comedia',   id: 35 },
        { label: '⚡ Acción',    id: 10759 },
        { label: '🚀 Sci-Fi',    id: 10765 },
        { label: '🔍 Crimen',   id: 80 },
        { label: '🎨 Animación', id: 16 },
        { label: '👨‍👩‍👧 Familiar', id: 10751 },
    ];
    genres.forEach(g => {
        tabs.appendChild(makeTab(g.label, () => filterByGenre(g.id, g.label)));
    });
}

function filterByGenre(genreId, label) {
    showSection('grid');
    const filtered = [];
    for (const [title, tmdb] of catalogTmdbCache) {
        if (tmdb?.genreIds?.includes(genreId)) {
            const entry = catalog.find(s => s.title === title);
            if (entry && !filtered.find(s => s.title === title)) filtered.push(entry);
        }
    }
    renderGrid(filtered);
    $('search-count').textContent = filtered.length
        ? `${filtered.length} series · ${label}`
        : `Cargando ${label}...`;
}

// ===== CONTENT ROWS =====
function renderRow(id, title, series, prepend = false) {
    if (!series.length) return;
    const container = $('catalog-rows');
    let row = container.querySelector(`[data-row="${id}"]`);

    if (row) {
        // Update existing row cards
        const cards = row.querySelector('.row-cards');
        cards.innerHTML = '';
        series.forEach(s => cards.appendChild(createCard(s)));
        return;
    }

    row = document.createElement('div');
    row.className = 'content-row';
    row.dataset.row = id;
    row.innerHTML = `
        <div class="row-header"><h2 class="row-title">${escapeHtml(title)}</h2></div>
        <div class="row-scroll-container">
            <button class="row-arrow row-arrow-left" aria-label="Anterior">&#8249;</button>
            <div class="row-cards"></div>
            <button class="row-arrow row-arrow-right" aria-label="Siguiente">&#8250;</button>
        </div>`;

    const cards = row.querySelector('.row-cards');
    series.forEach(s => cards.appendChild(createCard(s)));

    row.querySelector('.row-arrow-left').addEventListener('click', () =>
        cards.scrollBy({ left: -cards.clientWidth * 0.75, behavior: 'smooth' }));
    row.querySelector('.row-arrow-right').addEventListener('click', () =>
        cards.scrollBy({ left: cards.clientWidth * 0.75, behavior: 'smooth' }));

    prepend ? container.prepend(row) : container.appendChild(row);
}

// ===== GRID (search / genre filter) =====
function renderGrid(series) {
    const grid = $('catalog-grid');
    grid.innerHTML = '';
    series.forEach(s => grid.appendChild(createCard(s)));
}

// ===== CARD =====
function createCard(series) {
    const card = document.createElement('div');
    card.className = 'series-card';
    const displayTitle = series.title.replace(/\s*\(\d{4}\)\s*$/, '').trim();
    card.innerHTML = `
        <div class="series-card-poster">
            <div class="series-card-poster-placeholder">
                <span>${escapeHtml(displayTitle.charAt(0))}</span>
            </div>
        </div>
        <div class="series-card-meta">
            <div class="series-card-title">${escapeHtml(displayTitle)}</div>
            ${series.year ? `<div class="series-card-year">${series.year}</div>` : ''}
        </div>`;
    card.addEventListener('click', () => openSeries(series));
    loadCardPoster(card, series);
    return card;
}

async function loadCardPoster(card, series) {
    const tmdb = await searchSeries(series.title, series.year);
    if (tmdb) catalogTmdbCache.set(series.title, tmdb);
    if (!tmdb?.posterPath) return;
    const url = posterUrl(tmdb.posterPath);
    const placeholder = card.querySelector('.series-card-poster-placeholder');
    const img = new Image();
    img.onload = () => {
        placeholder.style.backgroundImage = `url('${url}')`;
        placeholder.style.backgroundSize = 'cover';
        placeholder.style.backgroundPosition = 'center';
        placeholder.querySelector('span').style.display = 'none';
    };
    img.src = url;
}

// ===== BACKGROUND GENRE LOADER =====
async function loadGenresBackground() {
    if (genreLoading) return;
    genreLoading = true;
    const buckets = new Map(GENRE_ROWS.map(r => [r.id, { meta: r, items: [] }]));

    const BATCH = 10;
    for (let i = 0; i < catalog.length; i += BATCH) {
        const batch = catalog.slice(i, i + BATCH);
        await Promise.all(batch.map(async s => {
            const tmdb = await searchSeries(s.title, s.year);
            if (!tmdb) return;
            catalogTmdbCache.set(s.title, tmdb);
            for (const [, bucket] of buckets) {
                if (tmdb.genreIds?.some(g => bucket.meta.ids.includes(g))) {
                    if (!bucket.items.find(x => x.title === s.title)) bucket.items.push(s);
                }
            }
        }));

        // Update rows that have enough entries
        for (const [, bucket] of buckets) {
            if (bucket.items.length >= 6) {
                renderRow(bucket.meta.id, bucket.meta.title, bucket.items.slice(0, 40));
            }
        }
    }

    // Final pass — show any remaining rows
    for (const [, bucket] of buckets) {
        if (bucket.items.length > 0) {
            renderRow(bucket.meta.id, bucket.meta.title, bucket.items.slice(0, 40));
        }
    }
    genreLoading = false;
}

// ===== SERIES (SEASONS) =====
async function openSeries(series) {
    currentSeries = series;
    currentTmdb = null;
    $('series-title').textContent = series.title;
    $('series-loading').classList.remove('hidden');
    $('seasons-list').innerHTML = '';
    showView('view-series');

    // Load TMDB in background
    searchSeries(series.title, series.year).then(tmdb => {
        currentTmdb = tmdb;
        if (tmdb?.backdropPath) {
            const header = document.querySelector('#view-series .topbar');
            header.style.backgroundImage = `linear-gradient(to bottom, rgba(0,0,0,0.7), rgba(15,15,20,1)), url('${posterUrl(tmdb.backdropPath, 'w1280')}')`;
            header.style.backgroundSize = 'cover';
            header.style.backgroundPosition = 'center top';
            header.style.padding = '2rem 1rem 1rem';
        }
    });

    try {
        const response = await sendBotCommand(series.payload);
        currentBotMsgId = response.messageId;

        $('series-loading').classList.add('hidden');

        if (response.buttons.length === 0) {
            $('seasons-list').innerHTML = '<div class="center-message"><p>No se encontraron temporadas</p></div>';
            return;
        }

        for (const btn of response.buttons) {
            const isBack = btn.text.toLowerCase().includes('volver') || btn.text.toLowerCase().includes('catálogo');
            if (isBack) continue;

            const isComplete = btn.text.toLowerCase().includes('completa');
            const icon = isComplete ? '🎬' : '📺';

            const el = document.createElement('button');
            el.className = 'season-btn';
            el.innerHTML = `<span class="season-icon">${icon}</span> ${escapeHtml(btn.text)}`;
            el.addEventListener('click', () => openSeason(btn, series));
            $('seasons-list').appendChild(el);
        }
    } catch (err) {
        $('series-loading').classList.add('hidden');
        $('seasons-list').innerHTML = `<div class="center-message"><p>Error: ${escapeHtml(err.message)}</p></div>`;
    }
}

$('btn-back-catalog').addEventListener('click', () => showCatalog());

// ===== NAV TABS =====
$('nav-series').addEventListener('click', () => showCatalog());
$('nav-movies').addEventListener('click', () => showMovies());
$('nav-series-from-movies').addEventListener('click', () => showCatalog());
$('nav-movies-active').addEventListener('click', () => {}); // already active
$('btn-movies-logout').addEventListener('click', async () => {
    if (confirm('¿Cerrar sesión?')) { await logout(); location.reload(); }
});
$('modal-close').addEventListener('click', closeMovieModal);
$('movie-files-modal').addEventListener('click', e => {
    if (e.target === $('movie-files-modal')) closeMovieModal();
});

// ===== SMART BACK FROM PLAYER =====
$('btn-back-player').addEventListener('click', () => {
    $('video-player').pause();
    $('video-player').src = '';
    if (playerOrigin === 'movie') {
        showView('view-movies');
        // Reopen movie modal with cached results (instant, no re-search)
        if (lastMovieData) openMovieWithCache(lastMovieData.movie, lastMovieData.videos);
    } else {
        showView('view-episodes');
    }
});

// ===== MOVIES CATALOG =====
async function loadMovies() {
    if (moviesCatalog.length > 0) return;
    try {
        const res = await fetch('/api/movies');
        if (res.ok) {
            const all = await res.json();
            // Filter out raw file entries that got imported into the DB as movie titles
            // e.g. "La Jungla de Cristal III [ES] 1080p.mp4", filenames with quality tags
            // Filter raw filenames and deduplicate titles so we don't have multiple cards for the same movie
            const valid = all.filter(m => {
                const t = m.title || '';
                if (/\.(mp4|mkv|avi|mov|ts|m2ts|webm)\s*$/i.test(t)) return false;
                if (/\[(?:ES|ES5|CAST|LAT)[^\]]*\]\s*\d{3,4}p/i.test(t)) return false;
                if (/\b(?:720p|1080p|4K|2160p)\b/i.test(t)) return false;
                return true;
            });

            const seen = new Set();
            moviesCatalog = valid.filter(m => {
                // Normalize title tightly to dedup duplicates like "Dora (2025)" and "Dora"
                const norm = (m.search_title || m.title).toLowerCase()
                    .replace(/\s*\(\s*(Castellano|Cast\.|Latino|Audio|Español|V\.O\.|VOSE?|Doblado|Subtitulado)[^)]*\)/gi, '')
                    .replace(/\s*\(\d{4}\)\s*$/, '')
                    .replace(/\s+\b(19|20)\d{2}\b\s*$/, '')
                    .replace(/[^a-z0-9]/g, '');
                if (norm.length > 2 && seen.has(norm)) return false;
                seen.add(norm);
                return true;
            });
        }
    } catch { moviesCatalog = []; }
}

const MOVIE_GENRE_ROWS = [
    { id: 'mov_action',  title: '⚡ Acción',        ids: [28, 12, 10752] },
    { id: 'mov_comedy',  title: '😂 Comedia',        ids: [35] },
    { id: 'mov_drama',   title: '🎭 Drama',           ids: [18, 36] },
    { id: 'mov_horror',  title: '👻 Terror',           ids: [27, 9648] },
    { id: 'mov_scifi',   title: '🚀 Ciencia Ficción', ids: [878, 14] },
    { id: 'mov_crime',   title: '🔍 Crimen',          ids: [80, 53] },
    { id: 'mov_family',  title: '👨‍👩‍👧 Familiar',        ids: [10751, 16] },
    { id: 'mov_romance', title: '💖 Romance',         ids: [10749] },
];

async function showMovies() {
    showView('view-movies');
    showMoviesSection('home');
    $('movies-search-input').value = '';

    if (moviesReady) {
        if (movieHeroShows.length > 0 && !movieHeroTimer) startMovieHeroTimer();
        return;
    }
    moviesReady = true;

    await loadMovies();

    initMovieGenreTabs();

    $('movies-search-input').oninput = () => {
        const q = $('movies-search-input').value.toLowerCase().trim();
        if (!q) { showMoviesSection('home'); return; }
        showMoviesSection('grid');
        const filtered = moviesCatalog.filter(m => m.title.toLowerCase().includes(q));
        $('movies-count').textContent = `${filtered.length} resultado${filtered.length !== 1 ? 's' : ''}`;
        renderMovieGrid(filtered);
    };

    // Recent row (always show immediately)
    const recentMovies = [...moviesCatalog]
        .filter(m => m.year >= 2024)
        .sort((a, b) => (b.year || 0) - (a.year || 0))
        .slice(0, 40);
    renderMovieRow('mov_recent', '🆕 Estrenos recientes', recentMovies);

    // Trending from TMDB matched to catalog
    try {
        const trendingTmdb = await getTrendingMovies();
        const matched = trendingTmdb.map(t => findMovieInCatalog(t)).filter(Boolean);
        if (matched.length > 0) {
            renderMovieRow('mov_trending', '🔥 En tendencia esta semana', matched, true);
            await setupMovieHero(matched.slice(0, 5));
        } else {
            await setupMovieHero(recentMovies.slice(0, 5));
        }
    } catch {
        await setupMovieHero(recentMovies.slice(0, 5));
    }

    // Load TMDB genres per catalog movie in background (correct approach: TMDB search finds the right movie)
    loadMoviesBackground();
}

function showMoviesSection(mode) {
    const home = $('movies-content');
    const grid = $('movies-search-results');
    home.style.display = mode === 'home' ? 'block' : 'none';
    grid.style.display = mode === 'grid' ? 'block' : 'none';
    if (mode === 'home' && !movieHeroTimer && movieHeroShows.length > 0) startMovieHeroTimer();
    if (mode === 'grid' && movieHeroTimer) { clearInterval(movieHeroTimer); movieHeroTimer = null; }
}

/**
 * Find a catalog movie that matches a TMDB result.
 * Handles messy catalog titles like:
 *   "Road House (De profesión: duro) (2024)"
 *   "MIRACLE ON 34TH STREET COMEDIA 1994"
 *   "Stuart Little 1 - Edición Coleccionistas - 1999"
 */
function findMovieInCatalog(tmdbMovie) {
    const n = normTitle(tmdbMovie.name);
    const no = normTitle(tmdbMovie.originalName || '');
    if (!n && !no) return null;

    return moviesCatalog.find(m => {
        const fullTitle = m.search_title || m.title;
        // 1. Full normalized title (y_suffix removed by normTitle)
        const mn = normTitle(fullTitle);

        // Exact matches
        if (n && mn === n) return true;
        if (no && mn === no) return true;

        // 2. Title before first '(' — "Road House (De profesión...)" → "road house"
        const mainPart = normTitle(fullTitle.replace(/\s*\(.*$/, '').replace(/\s*\|.*$/, '').trim());
        if (mainPart.length >= 4) {
            if (n && mainPart === n) return true;
            if (no && mainPart === no) return true;
        }

        // 3. Content inside FIRST parenthesis (alternate/Spanish title)
        const altMatch = fullTitle.match(/\(([^)]{4,})\)/);
        if (altMatch && !/^\d{4}$/.test(altMatch[1].trim())) {
            const alt = normTitle(altMatch[1]);
            if (n && alt === n) return true;
            if (no && alt === no) return true;
        }

        // 4. Substring: TMDB title contained IN catalog title
        //    Handles "MIRACLE ON 34TH STREET COMEDIA 1994" matching TMDB "Miracle on 34th Street"
        //    Minimum 5 chars to avoid false positives ("Up", "It", etc.)
        if (n && n.length >= 5 && mn.includes(n)) return true;
        if (no && no.length >= 5 && mn.includes(no)) return true;
        // Also check main part
        if (n && n.length >= 5 && mainPart.includes(n)) return true;
        if (no && no.length >= 5 && mainPart.includes(no)) return true;

        return false;
    });
}

// ===== MOVIE HERO =====
async function setupMovieHero(movies) {
    if (!movies.length) return;
    movieHeroShows = movies;
    movieHeroIndex = 0;
    updateMovieHeroDots();
    await renderMovieHeroSlide(0);
    startMovieHeroTimer();
}

function startMovieHeroTimer() {
    if (movieHeroTimer) clearInterval(movieHeroTimer);
    movieHeroTimer = setInterval(() => {
        movieHeroIndex = (movieHeroIndex + 1) % movieHeroShows.length;
        renderMovieHeroSlide(movieHeroIndex);
        updateMovieHeroDots();
    }, 8000);
}

async function renderMovieHeroSlide(idx) {
    const movie = movieHeroShows[idx];
    if (!movie) return;
    const tmdb = await searchMovie(movie.search_title || movie.title, movie.year);
    const displayTitle = movie.title.replace(/\s*\(\d{4}\)\s*$/, '').trim();
    $('movies-hero-title').textContent = tmdb?.name || displayTitle;
    $('movies-hero-overview').textContent = tmdb?.overview || '';
    $('movies-hero-meta').innerHTML = [
        tmdb?.rating ? `<span class="hero-rating">★ ${tmdb.rating}</span>` : '',
        tmdb?.year || movie.year ? `<span>${tmdb?.year || movie.year}</span>` : '',
    ].filter(Boolean).join('');
    if (tmdb?.backdropPath) {
        $('movies-hero-backdrop').style.backgroundImage =
            `url('https://image.tmdb.org/t/p/w1280${tmdb.backdropPath}')`;
    }
    $('movies-hero-play-btn').onclick = () => openMovie(movie);
}

function updateMovieHeroDots() {
    const dotsEl = $('movies-hero-dots');
    dotsEl.innerHTML = '';
    if (movieHeroShows.length <= 1) return;
    movieHeroShows.forEach((_, i) => {
        const dot = document.createElement('button');
        dot.className = 'hero-dot' + (i === movieHeroIndex ? ' active' : '');
        dot.addEventListener('click', () => {
            movieHeroIndex = i;
            clearInterval(movieHeroTimer); movieHeroTimer = null;
            renderMovieHeroSlide(i);
            updateMovieHeroDots();
            startMovieHeroTimer();
        });
        dotsEl.appendChild(dot);
    });
}

// ===== MOVIE GENRE TABS =====
function initMovieGenreTabs() {
    const tabs = $('movies-genre-tabs');
    tabs.innerHTML = '';
    function makeTab(label, onClick) {
        const btn = document.createElement('button');
        btn.className = 'genre-tab';
        btn.textContent = label;
        btn.addEventListener('click', () => {
            tabs.querySelectorAll('.genre-tab').forEach(t => t.classList.remove('active'));
            btn.classList.add('active');
            onClick();
        });
        return btn;
    }
    const allTab = makeTab('✶ Todas', () => showMoviesSection('home'));
    allTab.classList.add('active');
    tabs.appendChild(allTab);
    MOVIE_GENRE_ROWS.forEach(g => {
        tabs.appendChild(makeTab(g.title, () => filterMoviesByGenre(g.id, g.title)));
    });
}

/**
 * Filter movies by genre tab click.
 * Uses movieGenreCache (from discover) - polls while genre is still loading.
 */
async function filterMoviesByGenre(rowId, label) {
    showMoviesSection('grid');
    $('movies-count').textContent = `Cargando ${label}...`;
    $('movies-grid').innerHTML = '';

    // Wait up to 20s for genre data if still loading
    if (!movieGenreCache.has(rowId)) {
        await new Promise(resolve => {
            const check = setInterval(() => {
                if (movieGenreCache.has(rowId)) { clearInterval(check); resolve(); }
            }, 400);
            setTimeout(() => { clearInterval(check); resolve(); }, 20000);
        });
    }

    const cached = movieGenreCache.get(rowId) || [];
    renderMovieGrid(cached);
    $('movies-count').textContent = cached.length
        ? `${cached.length} películas · ${label}`
        : `Sin coincidencias en el catálogo para ${label}`;
}

// ===== MOVIE ROWS =====
function renderMovieRow(id, title, movies, prepend = false) {
    if (!movies.length) return;
    const container = $('movies-rows');
    let row = container.querySelector(`[data-row="${id}"]`);
    if (row) {
        const cards = row.querySelector('.row-cards');
        cards.innerHTML = '';
        movies.forEach(m => cards.appendChild(createMovieCard(m)));
        return;
    }
    row = document.createElement('div');
    row.className = 'content-row';
    row.dataset.row = id;
    row.innerHTML = `
        <div class="row-header"><h2 class="row-title">${escapeHtml(title)}</h2></div>
        <div class="row-scroll-container">
            <button class="row-arrow row-arrow-left" aria-label="Anterior">&#8249;</button>
            <div class="row-cards"></div>
            <button class="row-arrow row-arrow-right" aria-label="Siguiente">&#8250;</button>
        </div>`;
    const cards = row.querySelector('.row-cards');
    movies.forEach(m => cards.appendChild(createMovieCard(m)));
    row.querySelector('.row-arrow-left').addEventListener('click', () =>
        cards.scrollBy({ left: -cards.clientWidth * 0.75, behavior: 'smooth' }));
    row.querySelector('.row-arrow-right').addEventListener('click', () =>
        cards.scrollBy({ left: cards.clientWidth * 0.75, behavior: 'smooth' }));
    prepend ? container.prepend(row) : container.appendChild(row);
}

function renderMovieGrid(movies) {
    const grid = $('movies-grid');
    grid.innerHTML = '';
    movies.forEach(m => grid.appendChild(createMovieCard(m)));
}

/**
 * Pre-loads TMDB data for catalog movies in background.
 * Each successful result goes through onMovieTmdbLoaded() which classifies genres.
 * Movies already loaded via poster cards are skipped (cache hit).
 */
async function loadMoviesBackground() {
    const sorted = [...moviesCatalog].sort((a, b) => (b.year || 0) - (a.year || 0));

    // Process already-cached movies first (instant on revisit — data is in localStorage)
    for (const m of sorted.slice(0, 400)) {
        const tmdb = movieTmdbCache.get(m.id);
        if (tmdb) onMovieTmdbLoaded(m, tmdb);
    }

    // Fetch TMDB for uncached movies (10 concurrent for speed)
    const toLoad = sorted.slice(0, 400).filter(m => !movieTmdbCache.has(m.id));
    const BATCH = 10;
    for (let i = 0; i < toLoad.length; i += BATCH) {
        await Promise.all(toLoad.slice(i, i + BATCH).map(async m => {
            const tmdb = await searchMovie(m.search_title || m.title, m.year);
            if (!tmdb) return;
            movieTmdbCache.set(m.id, tmdb);
            onMovieTmdbLoaded(m, tmdb); // genre classification happens here
        }));
    }

    // Mark all genre caches as at least initialised so tabs don't wait forever
    for (const genre of MOVIE_GENRE_ROWS) {
        if (!movieGenreCache.has(genre.id)) movieGenreCache.set(genre.id, []);
    }

    renderAllMoviesCatalog();
}

/**
 * Called whenever a movie is successfully matched to TMDB (from poster load OR background load).
 * Classifies it into genres and schedules a debounced row update.
 */
function onMovieTmdbLoaded(movie, tmdb) {
    if (!tmdb?.genreIds?.length) return;
    let changed = false;
    for (const genre of MOVIE_GENRE_ROWS) {
        if (!tmdb.genreIds.some(g => genre.ids.includes(g))) continue;
        const items = movieGenreCache.get(genre.id);
        if (items === undefined) {
            movieGenreCache.set(genre.id, [movie]);
            changed = true;
        } else if (!items.find(x => x.id === movie.id)) {
            items.push(movie);
            changed = true;
        }
    }
    if (!changed) return;
    // Debounce: update DOM rows at most once every 1.5s
    if (!genreUpdateTimer) {
        genreUpdateTimer = setTimeout(() => {
            genreUpdateTimer = null;
            for (const genre of MOVIE_GENRE_ROWS) {
                const items = movieGenreCache.get(genre.id) || [];
                if (items.length > 0)
                    renderMovieRow(genre.id, genre.title, items.slice(0, 40));
            }
        }, 1500);
    }
}

/**
 * Render the full catalog below genre rows with infinite scroll (60 movies per batch).
 */
function renderAllMoviesCatalog() {
    if (document.getElementById('all-movies-section')) return; // already added
    catalogScrollPage = 0;
    const container = $('movies-rows');
    const section = document.createElement('div');
    section.id = 'all-movies-section';
    section.innerHTML = `
        <div class="row-header" style="padding-top:32px">
            <h2 class="row-title">🎬 Todo el catálogo</h2>
            <span class="row-count">${moviesCatalog.length.toLocaleString()} películas</span>
        </div>
        <div id="all-movies-grid" class="catalog-grid all-movies-grid"></div>
        <div id="all-movies-sentinel" style="height:1px"></div>
    `;
    container.appendChild(section);

    // Sort by year descending
    const sorted = [...moviesCatalog].sort((a, b) => (b.year || 0) - (a.year || 0));

    function loadBatch() {
        const grid = document.getElementById('all-movies-grid');
        if (!grid) return;
        const start = catalogScrollPage * CATALOG_PAGE_SIZE;
        const batch = sorted.slice(start, start + CATALOG_PAGE_SIZE);
        if (!batch.length) { observer.disconnect(); return; }
        catalogScrollPage++;
        batch.forEach(m => grid.appendChild(createMovieCard(m)));
    }

    const observer = new IntersectionObserver(entries => {
        if (entries.some(e => e.isIntersecting)) loadBatch();
    }, { rootMargin: '400px' });

    loadBatch(); // first batch immediately
    observer.observe(document.getElementById('all-movies-sentinel'));
}

// ===== MOVIE CARDS =====
function createMovieCard(movie) {
    const card = document.createElement('div');
    card.className = 'series-card';
    const displayTitle = movie.title.replace(/\s*\(\d{4}\)\s*$/, '').trim();
    card.innerHTML = `
        <div class="series-card-poster">
            <div class="series-card-poster-placeholder">
                <span>${escapeHtml(displayTitle.charAt(0).toUpperCase())}</span>
            </div>
        </div>
        <div class="series-card-meta">
            <div class="series-card-title">${escapeHtml(displayTitle)}</div>
            ${movie.year ? `<div class="series-card-year">${movie.year}</div>` : ''}
        </div>`;
    card.addEventListener('click', () => openMovie(movie));
    loadMovieCardPoster(card, movie);
    return card;
}

async function loadMovieCardPoster(card, movie) {
    const cached = movieTmdbCache.get(movie.id);
    const tmdb = cached || await searchMovie(movie.search_title || movie.title, movie.year);
    if (tmdb) {
        movieTmdbCache.set(movie.id, tmdb);
        onMovieTmdbLoaded(movie, tmdb); // ← classify genre with the data we already have
        // Update title and year to official TMDB data
        const titleEl = card.querySelector('.series-card-title');
        if (titleEl) titleEl.textContent = tmdb.name;
        const yearEl = card.querySelector('.series-card-year');
        if (yearEl && tmdb.year) yearEl.textContent = tmdb.year;
    }
    if (!tmdb?.posterPath) return;
    const url = posterUrl(tmdb.posterPath);
    const placeholder = card.querySelector('.series-card-poster-placeholder');
    const img = new Image();
    img.onload = () => {
        placeholder.style.backgroundImage = `url('${url}')`;
        placeholder.style.backgroundSize = 'cover';
        placeholder.style.backgroundPosition = 'center';
        placeholder.querySelector('span').style.display = 'none';
    };
    img.src = url;
}

// ===== OPEN MOVIE (bot /peli command → direct video files) =====
async function openMovie(movie) {
    openMovieModal(movie);
    try {
        const searchTitle = movie.search_title || movie.title.replace(/\s*\(\d{4}\)\s*$/, '').trim();
        const videos = await searchMovieByPayload(searchTitle);
        $('modal-loading').classList.add('hidden');
        if (videos.length === 0) {
            $('modal-error').textContent = 'El bot no encontró ningún archivo para esta película.';
            $('modal-error').classList.remove('hidden');
            return;
        }
        lastMovieData = { movie, videos };
        populateMovieFilesList(movie, videos);
    } catch (err) {
        $('modal-loading').classList.add('hidden');
        $('modal-error').textContent = `Error: ${escapeHtml(err.message)}`;
        $('modal-error').classList.remove('hidden');
    }
}

function openMovieWithCache(movie, videos) {
    openMovieModal(movie);
    $('modal-loading').classList.add('hidden');
    populateMovieFilesList(movie, videos);
}

function openMovieModal(movie) {
    const modal = $('movie-files-modal');
    const displayTitle = movie.title.replace(/\s*\(\d{4}\)\s*$/, '').trim();
    $('modal-movie-title').textContent = displayTitle;
    $('modal-movie-year').textContent = movie.year ? `${movie.year}` : '';
    $('modal-loading').classList.remove('hidden');
    $('modal-files-list').classList.add('hidden');
    $('modal-error').classList.add('hidden');
    $('modal-tmdb-info').innerHTML = '';
    modal.classList.remove('hidden');
    // TMDB info in background
    const cached = movieTmdbCache.get(movie.id);
    const p = cached ? Promise.resolve(cached) : searchMovie(movie.search_title || movie.title, movie.year);
    p.then(tmdb => {
        if (!tmdb) return;
        movieTmdbCache.set(movie.id, tmdb);
        $('modal-tmdb-info').innerHTML = `
            ${tmdb.overview ? `<p class="modal-overview">${escapeHtml(tmdb.overview)}</p>` : ''}
            ${tmdb.rating ? `<span class="modal-rating">★ ${tmdb.rating}</span>` : ''}
        `;
    });
}

function populateMovieFilesList(movie, videos) {
    const displayTitle = movie.title.replace(/\s*\(\d{4}\)\s*$/, '').trim();
    const list = $('modal-files-list');
    list.innerHTML = '';

    // Normalize text: lowercase + strip accents + keep only alphanumeric+spaces
    const normStr = s => s.toLowerCase()
        .normalize('NFD').replace(/[\u0300-\u036f]/g, '')
        .replace(/[^a-z0-9\s]/g, ' ');

    // Significant words from title: >3 chars, not pure numbers, accent-normalized
    const sigWords = normStr(displayTitle)
        .split(/\s+/)
        .filter(w => w.length > 3 && !/^\d+$/.test(w));

    const relevant = sigWords.length >= 2
        ? videos.filter(video => {
            // Build a Set of WHOLE words from the caption (exact match, no substring)
            const capWords = new Set(
                normStr(video.caption || video.fileName || '').split(/\s+/).filter(Boolean)
            );
            const matches = sigWords.filter(w => capWords.has(w)).length;
            return matches / sigWords.length >= 0.7; // 70% of key words as whole words
        })
        : videos; // title too short to filter reliably — show all

    const toShow = relevant.length > 0 ? relevant : videos; // fallback: never leave modal empty

    for (const video of toShow) {
        const sizeStr = video.fileSize > 1073741824
            ? `${(video.fileSize / 1073741824).toFixed(1)} GB`
            : `${(video.fileSize / (1024 * 1024)).toFixed(0)} MB`;
        const durStr = formatDuration(video.duration);
        const label = (video.caption || video.fileName || '').replace(/\.[^.]+$/, '') || displayTitle;
        const item = document.createElement('div');
        item.className = 'movie-file-item';
        item.innerHTML = `
            <div class="movie-file-icon">▶</div>
            <div class="movie-file-info">
                <div class="movie-file-name">${escapeHtml(label)}</div>
                <div class="movie-file-meta">${sizeStr}${durStr ? ' · ' + durStr : ''}</div>
            </div>
            <div class="movie-file-arrow">›</div>
        `;
        item.addEventListener('click', () => {
            closeMovieModal();
            playerOrigin = 'movie';
            playVideo(video, displayTitle);
        });
        list.appendChild(item);
    }
    list.classList.remove('hidden');
}

function closeMovieModal() {
    $('movie-files-modal').classList.add('hidden');
}


// ===== EPISODES =====
async function openSeason(button, series) {
    $('episodes-title').textContent = `${series.title} — ${button.text}`;
    $('episodes-loading').classList.remove('hidden');
    $('episodes-list').innerHTML = '';
    showView('view-episodes');

    try {
        if (button.data && currentBotMsgId) {
            try {
                await clickInlineButton(currentBotMsgId, button.data);
            } catch (btnErr) {
                // MESSAGE_ID_INVALID → bot invalidated the old message.
                // Re-send the series command to get a fresh inline keyboard.
                if (btnErr.message?.includes('MESSAGE_ID_INVALID') && currentSeries) {
                    console.warn('MESSAGE_ID_INVALID — refreshing bot message...');
                    const fresh = await sendBotCommand(currentSeries.payload);
                    currentBotMsgId = fresh.messageId;
                    // Find the matching season button in the fresh response
                    const freshBtn = fresh.buttons.find(b => b.text === button.text);
                    if (freshBtn?.data) {
                        await clickInlineButton(currentBotMsgId, freshBtn.data);
                    }
                } else {
                    throw btnErr;
                }
            }
        }

        const videos = await getVideoMessages(100, currentBotMsgId || 0);

        $('episodes-loading').classList.add('hidden');

        if (videos.length === 0) {
            $('episodes-list').innerHTML = '<div class="center-message"><p>No se encontraron episodios</p></div>';
            return;
        }

        // Don't sort alphabetically. The bot provides them in reverse chronological order
        // (newest message first). Reverse it to show oldest (Episode 1) first.
        videos.reverse();
        // Fetch TMDB episode details — ensure TMDB search has completed
        const seasonNum = extractSeasonNumber(button.text);
        let tmdbEpisodes = [];
        // If TMDB search is still in progress (race condition), wait for it now
        if (!currentTmdb && currentSeries) {
            currentTmdb = await searchSeries(currentSeries.title, currentSeries.year);
        }
        if (currentTmdb?.id) {
            tmdbEpisodes = await getSeasonEpisodes(currentTmdb.id, seasonNum);
        }

        for (const video of videos) {
            const card = document.createElement('div');
            card.className = 'episode-card';

            const sizeStr = video.fileSize > 1073741824
                ? `${(video.fileSize / 1073741824).toFixed(1)} GB`
                : `${(video.fileSize / (1024 * 1024)).toFixed(0)} MB`;
            const durStr = formatDuration(video.duration);

            // Match TMDB episode preferring the Telegram caption to the raw filename
            const parseSource = video.caption || video.fileName;
            const parsed = parseEpisodeFile(parseSource);
            const tmdbEp = parsed
                ? tmdbEpisodes.find(e => e.number === parsed.episode)
                : null;

            const still = tmdbEp?.stillPath ? stillUrl(tmdbEp.stillPath) : null;
            const epTitle = tmdbEp?.name || parseSource.replace(/\.[^.]+$/, '');
            const overview = tmdbEp?.overview || '';

            card.innerHTML = `
                <div class="episode-thumb" style="${still ? `background-image:url('${still}')` : ''}">
                    ${!still ? '<div class="episode-thumb-placeholder">▶</div>' : '<div class="episode-play-overlay">▶</div>'}
                    ${durStr ? `<span class="episode-duration">${durStr}</span>` : ''}
                </div>
                <div class="episode-info">
                    <div class="episode-number">${parsed ? `${parsed.season}×${String(parsed.episode).padStart(2,'0')}` : ''}</div>
                    <div class="episode-name">${escapeHtml(epTitle)}</div>
                    ${overview ? `<div class="episode-overview">${escapeHtml(overview)}</div>` : ''}
                    <div class="episode-meta">${sizeStr}${durStr ? ' · ' + durStr : ''}</div>
                </div>
            `;
            card.addEventListener('click', () => { playerOrigin = 'episodes'; playVideo(video, series.title); });
            $('episodes-list').appendChild(card);
        }
    } catch (err) {
        $('episodes-loading').classList.add('hidden');
        $('episodes-list').innerHTML = `<div class="center-message"><p>Error: ${escapeHtml(err.message)}</p></div>`;
    }
}

// Episodes back stays in episodes view
$('btn-back-series').addEventListener('click', () => showView('view-series'));

// ===== PLAYER =====
async function playVideo(video, seriesTitle) {
    $('player-title').textContent = video.fileName;
    $('player-subtitle').textContent = seriesTitle;
    $('player-download').classList.remove('hidden');
    $('download-progress').style.width = '0%';
    $('download-percent').textContent = '';
    $('download-text').textContent = 'Iniciando reproducción...';
    $('video-player').src = '';
    showView('view-player');

    try {
        await streamVideo(video.media, $('video-player'), (progress) => {
            if (progress.ready) {
                $('player-download').classList.add('hidden');
                return;
            }
            $('download-progress').style.width = progress.percent + '%';
            $('download-percent').textContent = progress.percent + '%';
            const dlMB = (progress.downloaded / (1024 * 1024)).toFixed(0);
            const totMB = (progress.total / (1024 * 1024)).toFixed(0);
            $('download-text').textContent = `Cargando: ${dlMB} / ${totMB} MB`;
        });

        // With SW streaming, video plays immediately — hide overlay
        $('player-download').classList.add('hidden');
        $('video-player').play().catch(() => {});
    } catch (err) {
        $('download-text').textContent = `Error: ${err.message}`;
    }
}

// Back from player: go to episodes OR movie modal depending on origin
$('btn-back-player') && $('btn-back-player').addEventListener('click', () => {
    $('video-player').pause();
    $('video-player').src = '';
    if (playerOrigin === 'movie') {
        showView('view-movies');
        if (lastMovieData) openMovieWithCache(lastMovieData.movie, lastMovieData.videos);
    } else {
        showView('view-episodes');
    }
});

// Fallback for old id (just in case)
const legacyBack = document.getElementById('btn-back-episodes');
if (legacyBack) legacyBack.addEventListener('click', () => {
    $('video-player').pause();
    $('video-player').src = '';
    showView('view-episodes');
});

// ===== HELPERS =====
function formatDuration(seconds) {
    if (!seconds) return '';
    const h = Math.floor(seconds / 3600);
    const m = Math.floor((seconds % 3600) / 60);
    const s = seconds % 60;
    if (h > 0) return `${h}:${String(m).padStart(2, '0')}:${String(s).padStart(2, '0')}`;
    return `${m}:${String(s).padStart(2, '0')}`;
}

function escapeHtml(text) {
    const div = document.createElement('div');
    div.textContent = text;
    return div.innerHTML;
}

// ===== START =====
init();
