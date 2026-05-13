// Force a single Buffer implementation before GramJS loads.
// Without this, Buffer.isBuffer() fails across module boundaries.
import { Buffer as _Buf } from 'buffer';
window.Buffer = _Buf;
globalThis.Buffer = _Buf;

let catalog = [];

// ── Remote catalog URL (GitHub raw) ──────────────────────────────────────────
const CATALOG_REMOTE_URL = 'https://raw.githubusercontent.com/Crono2021/cineflix-catalog/main/catalog.json';
const CATALOG_CACHE_KEY  = 'cineflix_catalog_cache_v2';
const CATALOG_CACHE_TS   = 'cineflix_catalog_ts_v2';
const CATALOG_TTL_MS     = 1000 * 60 * 60 * 6; // Refresh every 6 hours max

const MOVIES_REMOTE_URL  = 'https://raw.githubusercontent.com/Crono2021/cineflix-catalog/main/movies.json';
const MOVIES_CACHE_KEY   = 'cineflix_movies_cache_v2';
const MOVIES_CACHE_TS    = 'cineflix_movies_ts_v2';
const MOVIES_TTL_MS      = 1000 * 60 * 60 * 6; // Refresh every 6 hours max

async function loadCatalog() {
    // 1️⃣ Show cached version INSTANTLY (zero wait for the user)
    try {
        const cached = localStorage.getItem(CATALOG_CACHE_KEY);
        if (cached) {
            catalog = JSON.parse(cached);
            console.log(`[Catalog] Loaded ${catalog.length} items from cache`);
        }
    } catch { /* ignore */ }

    // 2️⃣ If cache is empty or older than TTL, fetch from remote synchronously
    const lastFetch = parseInt(localStorage.getItem(CATALOG_CACHE_TS) || '0', 10);
    const needsSync = !catalog.length || (Date.now() - lastFetch > CATALOG_TTL_MS);

    if (needsSync) {
        await fetchRemoteCatalog();
    } else {
        // 3️⃣ Otherwise refresh silently in background (non-blocking)
        fetchRemoteCatalog().catch(() => {});
    }
}

async function fetchRemoteCatalog() {
    try {
        const res = await fetch(CATALOG_REMOTE_URL, { cache: 'no-store' });
        if (!res.ok) throw new Error(`HTTP ${res.status}`);
        const remote = await res.json();
        if (Array.isArray(remote) && remote.length > 0) {
            catalog = remote;
            localStorage.setItem(CATALOG_CACHE_KEY, JSON.stringify(remote));
            localStorage.setItem(CATALOG_CACHE_TS, Date.now().toString());
            console.log(`[Catalog] ✅ Updated from remote: ${remote.length} items`);
        }
    } catch (err) {
        console.warn('[Catalog] Remote fetch failed, using cache/bundled:', err.message);
        // Fallback: bundled catalog.json inside the app
        if (!catalog.length) {
            try {
                const mod = await import('./catalog.json', { assert: { type: 'json' } });
                catalog = mod.default;
                console.log(`[Catalog] Using bundled fallback: ${catalog.length} items`);
            } catch { catalog = []; }
        }
    }
}
import {
    isLoggedIn, sendCode, verifyCode, verify2FA, logout,
    sendBotCommand, clickInlineButton, getVideoMessages,
    streamVideo, initServiceWorker, searchMovieByPayload,
    playInMpv,
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
let currentTmdbPromise = null; // Promise so openSeason can await it

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

// ===== OTA UPDATER =====
async function checkOTAUpdates() {
    try {
        const platform = window.__appPlatform; // 'android', 'android_tv', 'desktop'
        if (!platform) return; // Web normal doesn't update via APK

        const localVersion = window.__appVersion;
        if (!localVersion) return;

        // Add random timestamp to avoid caching
        const res = await fetch(`https://raw.githubusercontent.com/Crono2021/crono-apps/master/update.json?t=${Date.now()}`);
        if (!res.ok) return;
        const data = await res.json();

        const platformData = data[platform];
        if (!platformData) return;

        let requiresUpdate = false;
        if (typeof localVersion === 'number' || platform !== 'desktop') {
            if (platformData.versionCode > parseInt(localVersion)) requiresUpdate = true;
        } else {
            // Desktop uses semver string
            if (platformData.version !== localVersion) requiresUpdate = true;
        }

        if (requiresUpdate) {
            showUpdateModal(platformData.url);
        }
    } catch(e) {
        console.warn('[OTA] Check failed:', e);
    }
}

function showUpdateModal(url) {
    const div = document.createElement('div');
    div.innerHTML = `
        <div style="position:fixed;top:0;left:0;width:100%;height:100%;background:rgba(0,0,0,0.9);z-index:999999;display:flex;align-items:center;justify-content:center;backdrop-filter:blur(8px);font-family:system-ui,-apple-system,sans-serif">
            <div style="background:#16161e;padding:3rem;border-radius:12px;text-align:center;max-width:400px;border:1px solid rgba(255,255,255,0.1);box-shadow:0 10px 40px rgba(0,0,0,0.5)">
                <div style="font-size:3rem;margin-bottom:1rem">🚀</div>
                <h2 style="margin:0 0 1rem 0;color:#fff;font-size:1.5rem">Nueva Versión Disponible</h2>
                <p style="color:#aaa;margin-bottom:2rem;line-height:1.5;font-size:1rem">Es obligatorio actualizar la aplicación para continuar utilizándola de forma segura y con las últimas funciones de la plataforma.</p>
                <button id="btn-ota-update" style="background:var(--accent,#ff3366);color:#fff;border:none;padding:1rem 2rem;border-radius:8px;font-weight:bold;font-size:1.1rem;cursor:pointer;width:100%;transition:transform 0.1s">Actualizar Ahora</button>
            </div>
        </div>
    `;
    document.body.appendChild(div);

    const btn = document.getElementById('btn-ota-update');
    // Ensure D-Pad focus
    btn.tabIndex = 0;
    btn.focus();
    
    // Auto-focus persistence for Android TV if they click somewhere else
    div.addEventListener('keydown', (e) => {
        if (!e.target.matches('#btn-ota-update')) { e.preventDefault(); btn.focus(); }
    });

    btn.addEventListener('click', () => {
        btn.textContent = 'Tratando de abrir navegador...';
        btn.style.opacity = '0.7';
        if (window.__appPlatform === 'desktop') {
            window.cineflix?.updater?.openExternal(url);
        }
    });
}

// ===== INIT =====
async function init() {
    showView('view-login');
    showStep('login-loading');

    // Comprobar OTA primero
    await checkOTAUpdates();

    // ── Electron: setup MPV event listener ──────────────────────────────────
    if (window.cineflix?.isElectron) {
        window.cineflix.mpv.onEvent(evt => {
            if (evt.type === 'error') {
                alert(`MPV Error: ${evt.message}`);
            }
        });
    }

    // Init Service Worker (web only, no-op in Electron)
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
        const rawQ = $('search-input').value.toLowerCase().trim();
        const q = rawQ.normalize('NFD').replace(/[\u0300-\u036f]/g, '');
        if (!q) { showSection('home'); return; }
        showSection('grid');
        const filtered = catalog.filter(s => {
            const t = s.title.toLowerCase().normalize('NFD').replace(/[\u0300-\u036f]/g, '');
            return t.includes(q);
        });
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

    // 3. Genre rows (synchronous mapping using TMDB data from backend/GitHub)
    for (const genre of [
        { id: 'gen_drama',  title: '🎭 Drama',     ids: [18] },
        { id: 'gen_comedy', title: '😂 Comedia',   ids: [35] },
        { id: 'gen_action', title: '⚡ Acción',    ids: [10759] },
        { id: 'gen_scifi',  title: '🚀 Sci-Fi',    ids: [10765] },
        { id: 'gen_crime',  title: '🔍 Crimen',    ids: [80] },
        { id: 'gen_anim',   title: '🎨 Animación', ids: [16] },
        { id: 'gen_family', title: '👨‍👩‍👧 Familiar',  ids: [10751] },
    ]) {
        const items = catalog.filter(s => {
            let gIds = [];
            if (s.tmdb_genre_ids) {
                try { gIds = typeof s.tmdb_genre_ids === 'string' ? JSON.parse(s.tmdb_genre_ids) : s.tmdb_genre_ids; } catch(e){}
            }
            return genre.ids.some(id => gIds.includes(id));
        });
        if (items.length > 0) {
            renderRow(genre.id, genre.title, items);
        }
    }
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
    const filtered = catalog.filter(s => {
        let gIds = [];
        if (s.tmdb_genre_ids) {
            try { gIds = typeof s.tmdb_genre_ids === 'string' ? JSON.parse(s.tmdb_genre_ids) : s.tmdb_genre_ids; } catch(e){}
        }
        return gIds.includes(genreId);
    });
    
    $('search-count').textContent = filtered.length
        ? `${filtered.length} series · ${label}`
        : `Sin coincidencias para ${label}`;
        
    renderGrid(filtered);
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
let seriesGridState = { items: [], page: 1 };

function renderGrid(series, keepPage = false) {
    if (!keepPage) {
        seriesGridState.items = series;
        seriesGridState.page = 1;
    }
    
    const grid = $('catalog-grid');
    grid.innerHTML = '';
    
    const PAGE_SIZE = 50;
    const totalPages = Math.ceil(seriesGridState.items.length / PAGE_SIZE) || 1;
    const start = (seriesGridState.page - 1) * PAGE_SIZE;
    const batch = seriesGridState.items.slice(start, start + PAGE_SIZE);
    
    batch.forEach(s => grid.appendChild(createCard(s)));
    
    let pagEl = $('series-grid-pag');
    if (!pagEl) {
        pagEl = document.createElement('div');
        pagEl.id = 'series-grid-pag';
        pagEl.className = 'pagination-controls';
        $('search-results').appendChild(pagEl);
    }
    
    if (totalPages <= 1) {
        pagEl.style.display = 'none';
        return;
    }
    
    pagEl.style.display = 'flex';
    pagEl.innerHTML = `
        <button id="ser-pag-prev" class="page-btn" ${seriesGridState.page === 1 ? 'disabled' : ''}>&#10094; Anterior</button>
        <span class="page-info">Página ${seriesGridState.page} de ${totalPages}</span>
        <button id="ser-pag-next" class="page-btn" ${seriesGridState.page === totalPages ? 'disabled' : ''}>Siguiente &#10095;</button>
    `;
    
    if (seriesGridState.page > 1) {
        $('ser-pag-prev').onclick = () => { seriesGridState.page--; renderGrid(seriesGridState.items, true); window.scrollTo({behavior: 'smooth', top: 0}); };
    }
    if (seriesGridState.page < totalPages) {
        $('ser-pag-next').onclick = () => { seriesGridState.page++; renderGrid(seriesGridState.items, true); window.scrollTo({behavior: 'smooth', top: 0}); };
    }
}

// ===== CARD =====
function createCard(series) {
    const card = document.createElement('div');
    card.className = 'series-card';
    const displayTitle = (series.tmdb_name || series.title).replace(/\s*\(\d{4}\)\s*$/, '').trim();
    
    // Utilize pre-resolved TMDB poster from backend to prevent waterfall loading
    const hasPoster = !!series.tmdb_poster;
    const posterImg = hasPoster
        ? `<img loading="lazy" src="${posterUrl(series.tmdb_poster)}"
               style="position:absolute;inset:0;width:100%;height:100%;object-fit:cover;border-radius:inherit;pointer-events:none;" />`
        : '';

    card.innerHTML = `
        <div class="series-card-poster">
            <div class="series-card-poster-placeholder" style="${hasPoster ? 'position:relative' : ''}">
                ${hasPoster ? '' : `<span>${escapeHtml(displayTitle.charAt(0))}</span>`}
                ${posterImg}
            </div>
        </div>
        <div class="series-card-meta">
            <div class="series-card-title">${escapeHtml(displayTitle)}</div>
            ${series.year ? `<div class="series-card-year">${series.year}</div>` : ''}
        </div>`;
    card.addEventListener('click', () => openSeries(series));
    
    if (!hasPoster) {
        loadCardPoster(card, series);
    }
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

// Removed loadGenresBackground

// ===== SERIES (SEASONS) =====
async function openSeries(series) {
    currentSeries = series;
    currentTmdb = null;
    $('series-title').textContent = series.title;
    $('series-loading').classList.remove('hidden');
    $('seasons-list').innerHTML = '';
    showView('view-series');

    // Start TMDB search — store the promise so openSeason can await it
    currentTmdb = null;
    // Auto-clear any stale null cache for this series so failed lookups don't persist
    (() => {
        const cleanTitle = series.title.replace(/\s*\(\d{4}\)\s*$/, '').trim();
        const keyBase = `series_${cleanTitle}_`.toLowerCase().replace(/[^a-z0-9_]/g, '_');
        Object.keys(localStorage)
            .filter(k => k.startsWith('tmdb_' + keyBase))
            .forEach(k => {
                try { const v = JSON.parse(localStorage.getItem(k)); if (v?.data === null) localStorage.removeItem(k); } catch {}
            });
    })();
    const tmdbPromise = searchSeries(series.title, series.year);
    tmdbPromise.then(tmdb => {
        currentTmdb = tmdb;
        if (tmdb?.backdropPath) {
            const header = document.querySelector('#view-series .topbar');
            header.style.backgroundImage = `linear-gradient(to bottom, rgba(0,0,0,0.7), rgba(15,15,20,1)), url('${posterUrl(tmdb.backdropPath, 'w1280')}')`;
            header.style.backgroundSize = 'cover';
            header.style.backgroundPosition = 'center top';
            header.style.padding = '2rem 1rem 1rem';
        }
    });
    // Store promise so openSeason can await it even if not resolved yet
    currentTmdbPromise = tmdbPromise;

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

    // 1️⃣ Show cached version INSTANTLY
    try {
        const cached = localStorage.getItem(MOVIES_CACHE_KEY);
        if (cached) {
            const parsed = JSON.parse(cached);
            if (Array.isArray(parsed) && parsed.length > 0) {
                moviesCatalog = processMoviesList(parsed);
                console.log(`[Movies] Loaded ${moviesCatalog.length} distinct items from cache`);
            }
        }
    } catch { /* ignore */ }

    // 2️⃣ Fetch from GitHub (primary source, authoritative)
    const lastFetch = parseInt(localStorage.getItem(MOVIES_CACHE_TS) || '0', 10);
    const needsSync = !moviesCatalog.length || (Date.now() - lastFetch > MOVIES_TTL_MS);

    if (needsSync) {
        await fetchRemoteMovies();
    } else {
        fetchRemoteMovies().catch(() => {});
    }
}

function processMoviesList(rawList) {
    if (!Array.isArray(rawList)) return [];
    
    // Filter raw filenames (e.g., .mp4, 1080p, [ES])
    const valid = rawList.filter(m => {
        const t = m.title || '';
        if (/\.(mp4|mkv|avi|mov|ts|m2ts|webm)\s*$/i.test(t)) return false;
        if (/\[(?:ES|ES5|CAST|LAT|EN)[^\]]*\]\s*\d{3,4}p/i.test(t)) return false;
        if (/\b(?:720p|1080p|4K|2160p)\b/i.test(t)) return false;
        return true;
    });

    const seen = new Set();
    return valid.filter(m => {
        const norm = (m.search_title || m.title).toLowerCase()
            .replace(/\s*\(\s*(Castellano|Cast\.|Latino|Audio|Español|V\.O\.|VOSE?|Doblado|Subtitulado)[^)]*\)/gi, '')
            .replace(/\s*\(\d{4}\)\s*$/, '')
            .replace(/\s+\b(19|20)\d{2}\b\s*$/, '')
            .replace(/[^a-z0-9]/g, '');
        if (norm.length > 2 && seen.has(norm)) return false;
        seen.add(norm);
        // Ensure every movie has a unique id for the TMDB cache map (since movies.json lacks it)
        if (!m.id) m.id = 'mv_' + norm;
        return true;
    });
}

async function fetchRemoteMovies() {
    try {
        const res = await fetch(MOVIES_REMOTE_URL, { cache: 'no-store' });
        if (!res.ok) throw new Error(`HTTP ${res.status}`);
        const remote = await res.json();
        
        const processed = processMoviesList(remote);
        if (processed.length > 0) {
            moviesCatalog = processed;
            localStorage.setItem(MOVIES_CACHE_KEY, JSON.stringify(processed));
            localStorage.setItem(MOVIES_CACHE_TS, Date.now().toString());
            console.log(`[Movies] ✅ Updated from GitHub: ${processed.length} unique items (from ${remote.length} raw)`);
            return;
        }
    } catch (err) {
        console.warn('[Movies] GitHub fetch failed, trying Railway API:', err.message);
    }

    // 3️⃣ Fallback: Railway API via Electron IPC or fetch
    if (moviesCatalog.length > 0) return; // already have cache, don't overwrite with API
    try {
        const all = window.cineflix?.isElectron
            ? await window.cineflix.movies.fetch()
            : await fetch('/api/movies').then(r => r.ok ? r.json() : []);
        
        if (Array.isArray(all) && all.length > 0) {
            const processed = processMoviesList(all);
            if (processed.length > 0) {
                moviesCatalog = processed;
                console.log(`[Movies] ✅ Loaded ${moviesCatalog.length} distinct items from Railway API fallback`);
            }
        }
    } catch (e) { console.error('[Movies] All sources failed:', e); }
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
        const rawQ = $('movies-search-input').value.toLowerCase().trim();
        const q = rawQ.normalize('NFD').replace(/[\u0300-\u036f]/g, '');
        if (!q) { showMoviesSection('home'); return; }
        showMoviesSection('grid');
        const filtered = moviesCatalog.filter(m => {
            const t = (m.search_title || m.title || '').toLowerCase().normalize('NFD').replace(/[\u0300-\u036f]/g, '');
            return t.includes(q);
        });
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

    // Initialize Genre Rows synchronously
    for (const genre of MOVIE_GENRE_ROWS) {
        const items = moviesCatalog.filter(m => {
            let gIds = [];
            if (m.tmdb_genre_ids) {
                try { gIds = typeof m.tmdb_genre_ids === 'string' ? JSON.parse(m.tmdb_genre_ids) : m.tmdb_genre_ids; } catch(e){}
            }
            return genre.ids.some(id => gIds.includes(id));
        });
        if (items.length > 0) {
            renderMovieRow(genre.id, genre.title, items);
        }
    }
    
    renderAllMoviesCatalog();
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

async function filterMoviesByGenre(rowId, label) {
    showMoviesSection('grid');
    const genre = MOVIE_GENRE_ROWS.find(g => g.id === rowId);
    if (!genre) return;
    
    const filtered = moviesCatalog.filter(m => {
        let gIds = [];
        if (m.tmdb_genre_ids) {
            try { gIds = typeof m.tmdb_genre_ids === 'string' ? JSON.parse(m.tmdb_genre_ids) : m.tmdb_genre_ids; } catch(e){}
        }
        return genre.ids.some(id => gIds.includes(id));
    });
    
    $('movies-count').textContent = filtered.length
        ? `${filtered.length} películas · ${label}`
        : `Sin coincidencias en el catálogo para ${label}`;
        
    renderMovieGrid(filtered);
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

let movieGridState = { items: [], page: 1 };

function renderMovieGrid(movies, keepPage = false) {
    if (!keepPage) {
        movieGridState.items = movies;
        movieGridState.page = 1;
    }
    
    const grid = $('movies-grid');
    grid.innerHTML = '';
    
    const PAGE_SIZE = 50;
    const totalPages = Math.ceil(movieGridState.items.length / PAGE_SIZE) || 1;
    const start = (movieGridState.page - 1) * PAGE_SIZE;
    const batch = movieGridState.items.slice(start, start + PAGE_SIZE);
    
    batch.forEach(m => grid.appendChild(createMovieCard(m)));
    
    let pagEl = $('movies-grid-pag');
    if (!pagEl) {
        pagEl = document.createElement('div');
        pagEl.id = 'movies-grid-pag';
        pagEl.className = 'pagination-controls';
        $('movies-search-results').appendChild(pagEl);
    }
    
    if (totalPages <= 1) {
        pagEl.style.display = 'none';
        return;
    }
    
    pagEl.style.display = 'flex';
    pagEl.innerHTML = `
        <button id="mov-pag-prev" class="page-btn" ${movieGridState.page === 1 ? 'disabled' : ''}>&#10094; Anterior</button>
        <span class="page-info">Página ${movieGridState.page} de ${totalPages}</span>
        <button id="mov-pag-next" class="page-btn" ${movieGridState.page === totalPages ? 'disabled' : ''}>Siguiente &#10095;</button>
    `;
    
    if (movieGridState.page > 1) {
        $('mov-pag-prev').onclick = () => { movieGridState.page--; renderMovieGrid(movieGridState.items, true); window.scrollTo({behavior: 'smooth', top: 0}); };
    }
    if (movieGridState.page < totalPages) {
        $('mov-pag-next').onclick = () => { movieGridState.page++; renderMovieGrid(movieGridState.items, true); window.scrollTo({behavior: 'smooth', top: 0}); };
    }
}

let allMoviesState = { items: [], page: 1 };

function renderAllMoviesCatalog(resetPage = true) {
    if (!document.getElementById('all-movies-section')) {
        const container = $('movies-rows');
        const section = document.createElement('div');
        section.id = 'all-movies-section';
        section.innerHTML = `
            <div class="row-header" style="padding-top:32px">
                <h2 class="row-title">🎬 Todo el catálogo</h2>
                <span class="row-count">${moviesCatalog.length.toLocaleString()} películas</span>
            </div>
            <div id="all-movies-grid" class="catalog-grid all-movies-grid"></div>
            <div id="all-movies-pag" class="pagination-controls"></div>
        `;
        container.appendChild(section);
    }
    
    if (resetPage) {
        allMoviesState.items = [...moviesCatalog].sort((a, b) => (b.year || 0) - (a.year || 0));
        allMoviesState.page = 1;
    }
    
    const grid = $('all-movies-grid');
    grid.innerHTML = '';
    
    const PAGE_SIZE = 50;
    const totalPages = Math.ceil(allMoviesState.items.length / PAGE_SIZE) || 1;
    const start = (allMoviesState.page - 1) * PAGE_SIZE;
    const batch = allMoviesState.items.slice(start, start + PAGE_SIZE);
    
    batch.forEach(m => grid.appendChild(createMovieCard(m)));
    
    const pagEl = $('all-movies-pag');
    if (totalPages <= 1) {
        pagEl.style.display = 'none';
        return;
    }
    
    pagEl.style.display = 'flex';
    pagEl.innerHTML = `
        <button id="all-mov-prev" class="page-btn" ${allMoviesState.page === 1 ? 'disabled' : ''}>&#10094; Anterior</button>
        <span class="page-info">Página ${allMoviesState.page} de ${totalPages}</span>
        <button id="all-mov-next" class="page-btn" ${allMoviesState.page === totalPages ? 'disabled' : ''}>Siguiente &#10095;</button>
    `;
    
    if (allMoviesState.page > 1) {
        $('all-mov-prev').onclick = () => { allMoviesState.page--; renderAllMoviesCatalog(false); window.scrollTo({behavior: 'smooth', top: $('all-movies-section').offsetTop - 60}); };
    }
    if (allMoviesState.page < totalPages) {
        $('all-mov-next').onclick = () => { allMoviesState.page++; renderAllMoviesCatalog(false); window.scrollTo({behavior: 'smooth', top: $('all-movies-section').offsetTop - 60}); };
    }
}

// ===== MOVIE CARDS =====
function createMovieCard(movie) {
    const card = document.createElement('div');
    card.className = 'series-card';
    const displayTitle = (movie.tmdb_name || movie.title).replace(/\s*\(\d{4}\)\s*$/, '').trim();
    
    const hasPoster = !!movie.tmdb_poster;
    const posterImg = hasPoster
        ? `<img loading="lazy" src="${posterUrl(movie.tmdb_poster)}"
               style="position:absolute;inset:0;width:100%;height:100%;object-fit:cover;border-radius:inherit;pointer-events:none;" />`
        : '';

    card.innerHTML = `
        <div class="series-card-poster">
            <div class="series-card-poster-placeholder" style="${hasPoster ? 'position:relative' : ''}">
                ${hasPoster ? '' : `<span>${escapeHtml(displayTitle.charAt(0).toUpperCase())}</span>`}
                ${posterImg}
            </div>
        </div>
        <div class="series-card-meta">
            <div class="series-card-title">${escapeHtml(displayTitle)}</div>
            ${movie.year ? `<div class="series-card-year">${movie.year}</div>` : ''}
        </div>`;
    card.addEventListener('click', () => openMovie(movie));
    
    if (!hasPoster) {
        loadMovieCardPoster(card, movie);
    }
    return card;
}

async function loadMovieCardPoster(card, movie) {
    let tmdb = movieTmdbCache.get(movie.id);
    if (!tmdb) {
        // Micro-delay to avoid queueing TMDB requests for partial searches if the user is typing fast
        // By awaiting here, we also give the DOM time to actually append the card
        await new Promise(r => setTimeout(r, 400));
        if (!card.isConnected) return;
        tmdb = await searchMovie(movie.search_title || movie.title, movie.year);
    }
    
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

        const inElectron = window.cineflix?.isElectron;
        item.innerHTML = `
            <div class="movie-file-icon">▶</div>
            <div class="movie-file-info">
                <div class="movie-file-name">${escapeHtml(label)}</div>
                <div class="movie-file-meta">${sizeStr}${durStr ? ' · ' + durStr : ''}</div>
            </div>
            ${inElectron
                ? `<button class="mpv-btn" title="Reproducir con MPV (cualquier códec)">🎬 MPV</button>`
                : `<div class="movie-file-arrow">›</div>`}
        `;

        if (inElectron) {
            // MPV button: stream via local server → MPV.exe
            item.querySelector('.mpv-btn').addEventListener('click', async (e) => {
                e.stopPropagation();
                closeMovieModal();
                try {
                    playerOrigin = 'movies';
                    await playVideo(video, displayTitle);
                } catch (err) {
                    alert(`No se pudo abrir ${displayTitle}: ${err.message}`);
                }
            });
            // Click on the rest of the item: web player fallback
            item.addEventListener('click', (e) => {
                if (e.target.classList.contains('mpv-btn')) return;
                closeMovieModal();
                playerOrigin = 'movie';
                playVideo(video, displayTitle);
            });
        } else {
            item.addEventListener('click', () => {
                closeMovieModal();
                playerOrigin = 'movie';
                playVideo(video, displayTitle);
            });
        }

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
        // Fetch TMDB episode details — wait for TMDB search to complete
        const seasonNum = extractSeasonNumber(button.text);
        let tmdbEpisodes = [];
        // Await the TMDB promise started in openSeries (handle race condition)
        if (!currentTmdb && currentTmdbPromise) {
            currentTmdb = await currentTmdbPromise;
        }
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
            const parsed = parseEpisodeFile(parseSource, seasonNum);
            const tmdbEp = parsed
                ? tmdbEpisodes.find(e => e.number === parsed.episode)
                : null;

            const still = tmdbEp?.stillPath ? stillUrl(tmdbEp.stillPath) : null;
            // Clean fallback title: strip extension and anything after 60 chars (synopsis in caption)
            const rawFallback = parseSource
                .replace(/\.[^.]+$/, '')            // remove file extension
                .replace(/^(\d+\.\s+)?(?:episodio|ep\.?)\s+\d+\s*/i, '') // strip "N. Episodio N" prefix
                .slice(0, 60).trim();               // cap at 60 chars to avoid showing full synopsis
            const epTitle = tmdbEp?.name || rawFallback || parseSource.slice(0, 40);
            const overview = tmdbEp?.overview || '';
            
            // Save the nice title directly onto the video object so the player can use it later
            video.displayTitle = `${parsed ? `${parsed.season}x${String(parsed.episode).padStart(2,'0')} - ` : ''}${epTitle}`;


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
            card.addEventListener('click', () => { 
                playerOrigin = 'episodes'; 
                playVideo(video, series.title, videos); 
            });
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
async function playVideo(video, seriesTitle, playlistArray = null) {
    // ── Electron: route ALL playback through MPV ──────────────────────────────
    if (window.cineflix?.isElectron) {
        // Show loading overlay so user knows it's doing something
        $('mpv-loader').classList.remove('hidden');
        try {
            // If requested from Episodes, we have the full playlist
            if (playlistArray && playlistArray.length > 0) {
                const startIndex = playlistArray.indexOf(video) !== -1 ? playlistArray.indexOf(video) : 0;
                await playInMpv(playlistArray, seriesTitle, startIndex);
            } else {
                // Otherwise (Movie mode) single item
                const label = video.displayTitle || (video.caption || video.fileName || seriesTitle || '').replace(/\.[^.]+$/, '');
                await playInMpv([{ media: video.media, caption: label, displayTitle: label }], seriesTitle, 0);
            }
        } catch (err) {
            alert(`No se pudo abrir en MPV:\n${err.message}`);
        } finally {
            // Hide loading overlay once it launches or fails
            $('mpv-loader').classList.add('hidden');
        }
        return;
    }

    // ── Web: Service Worker streaming → <video> ────────────────────────────────
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

// ===== AUTO UPDATER ─────────────────────────────────────────────────────────────
if (window.cineflix?.updater) {
    window.cineflix.updater.onUpdateAvailable((info) => {
        const toast = document.getElementById('update-toast');
        if (toast) {
            document.getElementById('update-toast-title').textContent = 'Actualización disponible';
            document.getElementById('update-toast-message').textContent = 'Descargando nueva versión en segundo plano...';
            document.getElementById('btn-update-action').classList.add('hidden');
            toast.classList.remove('hidden');
        }
    });

    window.cineflix.updater.onUpdateDownloaded((info) => {
        const toast = document.getElementById('update-toast');
        if (toast) {
            document.getElementById('update-toast-title').textContent = 'Actualización lista';
            document.getElementById('update-toast-message').textContent = `La versión ${info.version} está lista para instalar.`;
            const btnAction = document.getElementById('btn-update-action');
            btnAction.classList.remove('hidden');
            btnAction.onclick = () => window.cineflix.updater.installUpdate();
            toast.classList.remove('hidden');
        }
    });

    const closeBtn = document.getElementById('btn-update-close');
    if (closeBtn) closeBtn.onclick = () => document.getElementById('update-toast').classList.add('hidden');
}

// ===== START =====
init();
