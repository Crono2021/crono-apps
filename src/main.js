// Force a single Buffer implementation before GramJS loads.
// Without this, Buffer.isBuffer() fails across module boundaries.
import { Buffer as _Buf } from 'buffer';
window.Buffer = _Buf;
globalThis.Buffer = _Buf;

let catalog = [];

// ── Railway API base (serves catalog + movies WITH tmdb_poster/name/etc.) ─────
const RAILWAY_API = 'https://cineflix-production-19e3.up.railway.app';

// ── GitHub raw fallback (no TMDB data, used offline / when Railway is down) ───
const CATALOG_REMOTE_URL = 'https://raw.githubusercontent.com/Crono2021/cineflix-catalog/main/catalog.json';
const CATALOG_CACHE_KEY     = 'cineflix_catalog_cache_v2';
const CATALOG_MAX_ID_KEY    = 'cineflix_catalog_max_id_v2';  // last known max DB id

const MOVIES_REMOTE_URL  = 'https://raw.githubusercontent.com/Crono2021/cineflix-catalog/main/movies.json';
const MOVIES_CACHE_KEY      = 'cineflix_movies_cache_v3';
const MOVIES_MAX_ID_KEY     = 'cineflix_movies_max_id_v3';   // last known max DB id

async function loadCatalog() {
    // 1️⃣ Show cached version INSTANTLY (zero wait for the user)
    try {
        const cached = localStorage.getItem(CATALOG_CACHE_KEY);
        if (cached) {
            catalog = JSON.parse(cached);
            console.log(`[Catalog] ⚡ ${catalog.length} series from cache`);
        }
    } catch { /* ignore */ }

    // 2️⃣ Delta sync: ask server for its maxId, compare with ours
    if (catalog.length === 0) {
        await fetchRemoteCatalog(); // Block if we have nothing to show
    } else {
        fetchRemoteCatalog().catch(() => {}); // Background sync if we already have cache
    }
}

async function fetchRemoteCatalog() {
    try {
        const localMaxId = parseInt(localStorage.getItem(CATALOG_MAX_ID_KEY) || '0', 10);

        // Lightweight ping: just get count + maxId (~100 bytes)
        const metaRes = await fetch(`${RAILWAY_API}/api/catalog/meta`);
        if (!metaRes.ok) throw new Error('meta failed');
        const { maxId } = await metaRes.json();

        if (maxId <= localMaxId && catalog.length > 0) {
            // Nothing new — use cache as-is
            console.log('[Catalog] ✅ Cache is up to date (no new items)');
            return;
        }

        if (localMaxId === 0 || catalog.length === 0) {
            // First load: fetch everything
            console.log('[Catalog] 🔄 First load — fetching full catalog from Railway...');
            const res = await fetch(`${RAILWAY_API}/api/catalog`);
            if (!res.ok) throw new Error('full fetch failed');
            const remote = await res.json();
            if (Array.isArray(remote) && remote.length > 0) {
                catalog = remote;
                localStorage.setItem(CATALOG_CACHE_KEY, JSON.stringify(catalog));
                localStorage.setItem(CATALOG_MAX_ID_KEY, String(maxId));
                console.log(`[Catalog] ✅ Full load: ${catalog.length} series`);
            }
        } else {
            // Delta: only fetch entries newer than what we have
            console.log(`[Catalog] 🔄 Delta sync: fetching series with id > ${localMaxId}...`);
            const res = await fetch(`${RAILWAY_API}/api/catalog?after_id=${localMaxId}`);
            if (!res.ok) throw new Error('delta fetch failed');
            const newItems = await res.json();
            if (Array.isArray(newItems) && newItems.length > 0) {
                catalog = [...catalog, ...newItems];
                localStorage.setItem(CATALOG_CACHE_KEY, JSON.stringify(catalog));
                localStorage.setItem(CATALOG_MAX_ID_KEY, String(maxId));
                console.log(`[Catalog] ✅ Delta: +${newItems.length} series nuevas`);
            }
        }
    } catch (err) {
        console.warn('[Catalog] Railway unreachable, using cache/GitHub fallback:', err.message);
        // Only hit GitHub if we have truly nothing
        if (catalog.length === 0) {
            try {
                const res = await fetch(CATALOG_REMOTE_URL);
                if (res.ok) {
                    const remote = await res.json();
                    if (Array.isArray(remote) && remote.length > 0) {
                        catalog = remote;
                        localStorage.setItem(CATALOG_CACHE_KEY, JSON.stringify(catalog));
                        console.log(`[Catalog] ✅ GitHub fallback: ${catalog.length} series (sin TMDB)`);
                    }
                }
            } catch { /* truly offline */ }
        }
    }
}
import {
    isLoggedIn, sendCode, verifyCode, verify2FA, logout,
    sendBotCommand, clickInlineButton, getVideoMessages,
    streamVideo, initServiceWorker, searchMovieByPayload,
    isNativeApp, streamVideoNative, streamVideoMobileCapacitor, restoreNativeSession, playInMpv
} from './telegram.js';
import {
    searchSeries, searchMovie, getSeasonEpisodes, extractSeasonNumber,
    parseEpisodeFile, posterUrl, stillUrl,
    getTrending, getTrendingMovies, discoverMoviesByGenre, normTitle,
} from './tmdb.js';


function makeFocusable(el) {
    el.tabIndex = 0;
    el.addEventListener('keydown', e => {
        if (e.key === 'Enter' || e.keyCode === 13 || e.key === 'DPadCenter') {
            e.preventDefault();
            el.click();
        } else if (e.key === 'ArrowDown' || e.keyCode === 40) {
            // Force strict vertical DOM navigation for lists, bypassing broken WebView flex math
            if (el.parentElement && (el.parentElement.id === 'seasons-list' || el.parentElement.id === 'episodes-list' || el.parentElement.id === 'modal-files-list')) {
                const next = el.nextElementSibling;
                if (next) { e.preventDefault(); next.focus(); }
            }
        } else if (e.key === 'ArrowUp' || e.keyCode === 38) {
            if (el.parentElement && (el.parentElement.id === 'seasons-list' || el.parentElement.id === 'episodes-list' || el.parentElement.id === 'modal-files-list')) {
                const prev = el.previousElementSibling;
                if (prev) { e.preventDefault(); prev.focus(); }
            }
        }
    });
}

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

// Stack to track navigation history so back button works correctly on Android
const viewHistory = [];

function showView(viewId) {
    document.querySelectorAll('.view').forEach(v => v.classList.remove('active'));
    $(viewId).classList.add('active');
    // Track history (avoid duplicates at top)
    if (viewHistory[viewHistory.length - 1] !== viewId) {
        viewHistory.push(viewId);
    }
}

function showStep(stepId) {
    document.querySelectorAll('.login-step').forEach(s => s.classList.remove('active'));
    $(stepId).classList.add('active');
}

// ===== ANDROID BACK BUTTON =====
window.__cineflixBack = function () {
    const modal = $('movie-modal');
    if (modal && !modal.classList.contains('hidden')) {
        modal.classList.add('hidden');
        return true;
    }
    const activeView = document.querySelector('.view.active')?.id;
    switch (activeView) {
        case 'view-player': {
            const vp = $('video-player');
            if (vp) { vp.pause(); vp.src = ''; }
            viewHistory.pop();
            showView(playerOrigin === 'movie' ? 'view-movies' : 'view-episodes');
            return true;
        }
        case 'view-episodes':
            viewHistory.pop(); showView('view-series'); return true;
        case 'view-series':
            viewHistory.pop(); showView('view-movies'); return true;
        case 'view-movies':
        default:
            return false;
    }
};

// ===== LAZY POSTER LOADING =====
// Max 2 concurrent TMDB calls — prevents scroll jank from many parallel requests.
let _posterRunning = 0;
const _posterQueue = [];
const MAX_POSTER_CONCURRENT = 2;

function _runNextPoster() {
    if (_posterRunning >= MAX_POSTER_CONCURRENT || _posterQueue.length === 0) return;
    _posterRunning++;
    const fn = _posterQueue.shift();
    Promise.resolve().then(fn).finally(() => { _posterRunning--; _runNextPoster(); });
}

const _posterObserver = new IntersectionObserver(
    (entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                _posterObserver.unobserve(entry.target);
                const fn = entry.target.__loadPoster;
                if (fn) { entry.target.__loadPoster = null; _posterQueue.push(fn); _runNextPoster(); }
            }
        });
    },
    { rootMargin: '150px 0px', threshold: 0.01 }
);

function schedulePosterLoad(card, loadFn) {
    if (card.dataset.posterQ) return; // already queued — prevent double observation
    card.dataset.posterQ = '1';
    card.__loadPoster = loadFn;
    _posterObserver.observe(card);
}

function applyPosterImage(placeholder, url) {
    if (!placeholder || placeholder.querySelector('[data-poster]')) return; // prevent duplicates
    const img = document.createElement('img');
    img.setAttribute('data-poster', '1');
    img.style.cssText = 'position:absolute;inset:0;width:100%;height:100%;object-fit:cover;opacity:0;transition:opacity 0.2s;border-radius:inherit;pointer-events:none;';
    // Use requestAnimationFrame so the opacity change happens in the paint cycle,
    // not blocking the scroll compositor thread
    img.onload = () => requestAnimationFrame(() => {
        img.style.opacity = '1';
        const sp = placeholder.querySelector('span');
        if (sp) sp.style.display = 'none';
    });
    img.src = url;
    placeholder.style.position = 'relative';
    placeholder.appendChild(img);
}



// ===== OTA UPDATER =====
async function checkOTAUpdates() {
    try {
        let platform = window.__appPlatform; // 'android', 'android_tv', 'desktop'
        let localVersion = window.__appVersion;

        if (!platform && window.AndroidBridge && window.AndroidBridge.getPlatform) {
            platform = window.AndroidBridge.getPlatform();
            localVersion = window.AndroidBridge.getVersionCode();
        }

        if (!platform || !localVersion) return; // Web normal doesn't update via APK

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
        btn.textContent = 'Descargando...';
        btn.style.opacity = '0.7';
        if (window.__appPlatform === 'android_tv') {
            window.AndroidBridge?.downloadAndInstallUpdate(url);
        } else if (window.__appPlatform === 'android') {
            window.AndroidBridge?.downloadAndInstallUpdate(url);
        } else if (window.__appPlatform === 'desktop') {
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

    // On Android: restore session from native SharedPreferences BEFORE checking login.
    // localStorage can be wiped by the OS; SharedPreferences is always persistent.
    await restoreNativeSession();

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
        // Incrementally append new cards instead of wiping innerHTML (which destroys IntersectionObserver and causes massive flicker)
        const cards = row.querySelector('.row-cards');
        const existingCount = cards.childElementCount;
        if (existingCount < series.length) {
            series.slice(existingCount).forEach(s => cards.appendChild(createCard(s)));
        }
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

function renderGrid(series, resetPage = true) {
    if (resetPage) {
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
        $('ser-pag-prev').onclick = () => { seriesGridState.page--; renderGrid(seriesGridState.items, false); window.scrollTo({top: 0}); };
    }
    if (seriesGridState.page < totalPages) {
        $('ser-pag-next').onclick = () => { seriesGridState.page++; renderGrid(seriesGridState.items, false); window.scrollTo({top: 0}); };
    }
}

// ===== CARD =====
function createCard(series) {
    const card = document.createElement('div');
    card.className = 'series-card';
    const displayTitle = (series.tmdb_name || series.title).replace(/\s*\(\d{4}\)\s*$/, '').trim();

    // If server already resolved the poster, embed it directly — no lazy-load flash
    const hasPoster = !!series.tmdb_poster;
    const posterImg = hasPoster
        ? `<img data-poster="1" src="${posterUrl(series.tmdb_poster)}"
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

    // Only schedule lazy poster load if server hasn't resolved it yet
    if (!hasPoster) {
        schedulePosterLoad(card, () => loadCardPoster(card, series));
    }
    makeFocusable(card);
    return card;
}

// ── TMDB: prefer server-cached data, fall back to live TMDB search ──────────────
function tmdbFromEntry(entry) {
    if (!entry?.tmdb_id) return null;
    return {
        id:           entry.tmdb_id,
        name:         entry.tmdb_name || entry.title,
        overview:     entry.tmdb_overview || '',
        posterPath:   entry.tmdb_poster || null,
        backdropPath: entry.tmdb_backdrop || null,
        rating:       entry.tmdb_rating ? parseFloat(entry.tmdb_rating) : null,
        genreIds:     entry.tmdb_genre_ids ? JSON.parse(entry.tmdb_genre_ids) : [],
        year:         entry.year || null,
    };
}

async function loadCardPoster(card, series) {
    // Fast path: use pre-resolved data from Railway DB
    let tmdb = tmdbFromEntry(series);
    // Slow path: live TMDB lookup
    if (!tmdb) tmdb = await searchSeries(series.title, series.year);
    if (tmdb) catalogTmdbCache.set(series.title, tmdb);
    if (!tmdb?.posterPath || !card.isConnected) return;
    applyPosterImage(card.querySelector('.series-card-poster-placeholder'), posterUrl(tmdb.posterPath));
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
            // Fast path: use pre-resolved data — zero TMDB API calls
            let tmdb = tmdbFromEntry(s);
            // Slow path only if server hasn't resolved this entry yet
            if (!tmdb) tmdb = await searchSeries(s.title, s.year);
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
            makeFocusable(el);
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

    // 1️⃣ Try cache first
    let hadCache = false;
    try {
        const cached = localStorage.getItem(MOVIES_CACHE_KEY);
        if (cached) {
            const parsed = JSON.parse(cached);
            if (Array.isArray(parsed) && parsed.length > 0) {
                moviesCatalog = processMoviesList(parsed);
                hadCache = true;
                console.log(`[Movies] ⚡ ${moviesCatalog.length} películas from cache`);
            }
        }
    } catch { /* ignore */ }

    if (hadCache) {
        // 2a️⃣ Has cache: delta sync in background, UI renders instantly from cache
        fetchRemoteMovies().then(() => {
            if (moviesReady && moviesCatalog.length > 0) {
                const recentMovies = [...moviesCatalog]
                    .filter(m => m.year >= 2024)
                    .sort((a, b) => (b.year || 0) - (a.year || 0))
                    .slice(0, 40);
                renderMovieRow('mov_recent', '🆕 Estrenos recientes', recentMovies);
                for (const genre of MOVIE_GENRE_ROWS) {
                    const items = moviesCatalog.filter(m => {
                        let gIds = [];
                        if (m.tmdb_genre_ids) {
                            try { gIds = typeof m.tmdb_genre_ids === 'string' ? JSON.parse(m.tmdb_genre_ids) : m.tmdb_genre_ids; } catch(e){}
                        }
                        return genre.ids.some(id => gIds.includes(id));
                    });
                    if (items.length > 0) renderMovieRow(genre.id, genre.title, items.slice(0, 40));
                }
            }
        }).catch(() => {});
    } else {
        // 2b️⃣ No cache: MUST await so we don't render an empty blank screen
        console.log('[Movies] 🔄 No cache — waiting for Railway catalog...');
        await fetchRemoteMovies();
    }
}


async function fetchRemoteMovies() {
    try {
        const localMaxId = parseInt(localStorage.getItem(MOVIES_MAX_ID_KEY) || '0', 10);

        // Lightweight meta ping
        const metaRes = await fetch(`${RAILWAY_API}/api/movies/meta`);
        if (!metaRes.ok) throw new Error('meta failed');
        const { maxId } = await metaRes.json();

        if (maxId <= localMaxId && moviesCatalog.length > 0) {
            console.log('[Movies] ✅ Cache is up to date (no new movies)');
            return;
        }

        function processAndSave(parsed, newMaxId) {
            const processed = processMoviesList(parsed);
            // Merge: keep existing + add new (avoid duplicates by id)
            const existingIds = new Set(moviesCatalog.map(m => m.id));
            const merged = [...moviesCatalog, ...processed.filter(m => !existingIds.has(m.id))];
            moviesCatalog = merged;
            localStorage.setItem(MOVIES_CACHE_KEY, JSON.stringify(merged));
            localStorage.setItem(MOVIES_MAX_ID_KEY, String(newMaxId));
        }

        if (localMaxId === 0 || moviesCatalog.length === 0) {
            // First load: full fetch
            console.log('[Movies] 🔄 First load — fetching all movies from Railway...');
            const r = await fetch(`${RAILWAY_API}/api/movies`);
            if (!r.ok) throw new Error('full fetch failed');
            const data = await r.json();
            processAndSave(data, maxId);
            console.log(`[Movies] ✅ Full load: ${moviesCatalog.length} películas`);
        } else {
            // Delta fetch — only new entries
            console.log(`[Movies] 🔄 Delta sync: fetching movies with id > ${localMaxId}...`);
            const r = await fetch(`${RAILWAY_API}/api/movies?after_id=${localMaxId}`);
            if (!r.ok) throw new Error('delta fetch failed');
            const newItems = await r.json();
            if (Array.isArray(newItems) && newItems.length > 0) {
                processAndSave(newItems, maxId);
                console.log(`[Movies] ✅ Delta: +${newItems.length} películas nuevas`);
            } else {
                // Update maxId even if no new items (in case of deletions)
                localStorage.setItem(MOVIES_MAX_ID_KEY, String(maxId));
            }
        }
    } catch (err) {
        console.warn('[Movies] Railway unreachable, using cache/GitHub fallback:', err.message);
        if (moviesCatalog.length === 0) {
            try {
                const r = await fetch(MOVIES_REMOTE_URL);
                if (r.ok) {
                    const data = await r.json();
                    moviesCatalog = processMoviesList(data);
                    localStorage.setItem(MOVIES_CACHE_KEY, JSON.stringify(moviesCatalog));
                    console.log(`[Movies] ✅ GitHub fallback: ${moviesCatalog.length} películas (sin TMDB)`);
                }
            } catch { /* truly offline */ }
        }
    }
}

function processMoviesList(rawList) {
    if (!Array.isArray(rawList)) return [];
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
        if (!m.id) m.id = 'mv_' + norm;
        return true;
    });
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

    // Recent row + hero: instantáneo, usando datos del catálogo local
    const currentYear = new Date().getFullYear();
    const recentMovies = [...moviesCatalog]
        .filter(m => m.year >= currentYear - 2)
        .sort((a, b) => (b.year || 0) - (a.year || 0))
        .slice(0, 40);
    renderMovieRow('mov_recent', '🆕 Estrenos recientes', recentMovies);

    // Hero: mismas películas de Estrenos recientes — cero llamadas externas
    if (recentMovies.length > 0) {
        setupMovieHero(recentMovies.slice(0, 6));
    }

    // Delay rendering of heavy genre rows to allow instant UI response on mobile/TV
    setTimeout(() => {
        // Initialize Genre Rows using TMDB data from Railway
        for (const genre of MOVIE_GENRE_ROWS) {
            const items = moviesCatalog.filter(m => {
                let gIds = [];
                if (m.tmdb_genre_ids) {
                    try { gIds = typeof m.tmdb_genre_ids === 'string' ? JSON.parse(m.tmdb_genre_ids) : m.tmdb_genre_ids; } catch(e){}
                }
                return genre.ids.some(id => gIds.includes(id));
            });
            if (items.length > 0) {
                renderMovieRow(genre.id, genre.title, items.slice(0, 40)); 
            }
        }
        
    }, 100);
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
function setupMovieHero(movies) {
    if (!movies.length) return;
    movieHeroShows = movies;
    movieHeroIndex = 0;
    updateMovieHeroDots();
    renderMovieHeroSlide(0); // Sin await — renderiza al instante y enriquece en fondo
    startMovieHeroTimer();
}

// Devuelve hasta 5 peliculas aleatorias priorizando las que ya tienen backdrop cacheado en TMDB localStorage
function getRandomHeroMovies() {
    if (!moviesCatalog.length) return [];
    const shuffled = [...moviesCatalog].sort(() => Math.random() - 0.5);
    const withBackdrop = [];
    const withoutBackdrop = [];
    for (const movie of shuffled) {
        if (withBackdrop.length >= 5) break;
        const cleanTitle = (movie.search_title || movie.title || '')
            .split(/\s*[|\u00b7]\s*/)[0]
            .replace(/\s*\([^)]*(?:Castellano|Latino|Español|Subtitulado)[^)]*\)/gi, '')
            .replace(/\s*\(\d{4}\)\s*$/, '')
            .replace(/\s*\([^)]*\)\s*$/, '')
            .trim();
        const key = ('mv2_' + cleanTitle + '_' + (movie.year || ''))
            .toLowerCase().replace(/[^a-z0-9_]/g, '_');
        try {
            const raw = localStorage.getItem('tmdb_' + key);
            if (raw) {
                const { data } = JSON.parse(raw);
                if (data?.backdropPath) {
                    movie._cachedTmdb = data;
                    withBackdrop.push(movie);
                    continue;
                }
            }
        } catch {}
        if (withoutBackdrop.length < 5) withoutBackdrop.push(movie);
    }
    const result = [...withBackdrop];
    for (const m of withoutBackdrop) {
        if (result.length >= 5) break;
        result.push(m);
    }
    return result;
}

function startMovieHeroTimer() {
    if (movieHeroTimer) clearInterval(movieHeroTimer);
    movieHeroTimer = setInterval(() => {
        movieHeroIndex = (movieHeroIndex + 1) % movieHeroShows.length;
        renderMovieHeroSlide(movieHeroIndex);
        updateMovieHeroDots();
    }, 8000);
}

function renderMovieHeroSlide(idx) {
    const movie = movieHeroShows[idx];
    if (!movie) return;

    // Solo datos del catálogo — sin llamadas externas
    const displayTitle = (movie.tmdb_name || movie.title || '').replace(/\s*\(\d{4}\)\s*$/, '').trim();
    $('movies-hero-title').textContent = displayTitle;
    $('movies-hero-overview').textContent = '';
    $('movies-hero-meta').innerHTML = movie.year ? `<span>${movie.year}</span>` : '';

    // Póster del catálogo como imagen de fondo (ampliado a w1280)
    $('movies-hero-backdrop').style.backgroundImage = movie.tmdb_poster
        ? `url('https://image.tmdb.org/t/p/w1280${movie.tmdb_poster}')`
        : '';

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
 * Reads directly from local tmdb_genre_ids cache instead of waiting for observer.
 */
function filterMoviesByGenre(rowId, label) {
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

    renderMovieGrid(filtered);
    $('movies-count').textContent = filtered.length
        ? `${filtered.length} películas · ${label}`
        : `Sin coincidencias en el catálogo para ${label}`;
}

// ===== MOVIE ROWS =====
function renderMovieRow(id, title, movies, prepend = false) {
    if (!movies.length) return;
    const container = $('movies-rows');
    let row = container.querySelector(`[data-row="${id}"]`);
    if (row) {
        const cards = row.querySelector('.row-cards');
        const existingCount = cards.childElementCount;
        if (existingCount < movies.length) {
            movies.slice(existingCount).forEach(m => cards.appendChild(createMovieCard(m)));
        }
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

function renderMovieGrid(movies, resetPage = true) {
    if (resetPage) {
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
        $('mov-pag-prev').onclick = () => { movieGridState.page--; renderMovieGrid(movieGridState.items, false); window.scrollTo({top: 0}); };
    }
    if (movieGridState.page < totalPages) {
        $('mov-pag-next').onclick = () => { movieGridState.page++; renderMovieGrid(movieGridState.items, false); window.scrollTo({top: 0}); };
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
    const displayYear  = movie.year || null;

    // If server already resolved the poster, embed it directly — no lazy-load flash
    const hasPoster = !!movie.tmdb_poster;
    const posterImg = hasPoster
        ? `<img data-poster="1" src="${posterUrl(movie.tmdb_poster)}" loading="lazy"
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
            ${displayYear ? `<div class="series-card-year">${displayYear}</div>` : ''}
        </div>`;
    card.addEventListener('click', () => openMovie(movie));

    // Only schedule lazy poster load if server hasn't resolved it yet
    if (!hasPoster) {
        schedulePosterLoad(card, () => loadMovieCardPoster(card, movie));
    }
    makeFocusable(card);
    return card;
}

async function loadMovieCardPoster(card, movie) {
    // Fast path: server already resolved TMDB data — use it instantly, zero API call
    let tmdb = movieTmdbCache.get(movie.id) || tmdbFromEntry(movie);

    if (!tmdb) {
        // Micro-delay to avoid queueing TMDB requests for partial searches if the user is typing fast
        await new Promise(r => setTimeout(r, 400));
        if (!card.isConnected) return;
        tmdb = await searchMovie(movie.search_title || movie.title, movie.year);
    }

    if (tmdb) {
        movieTmdbCache.set(movie.id, tmdb);
        onMovieTmdbLoaded(movie, tmdb);
        const titleEl = card.querySelector('.series-card-title');
        if (titleEl) titleEl.textContent = tmdb.name;
        const yearEl = card.querySelector('.series-card-year');
        if (yearEl && tmdb.year) yearEl.textContent = tmdb.year;
    }
    if (!tmdb?.posterPath || !card.isConnected) return;
    applyPosterImage(card.querySelector('.series-card-poster-placeholder'), posterUrl(tmdb.posterPath));
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
        const rawLabel = (video.caption || video.fileName || '').replace(/\.[^.]+$/, '') || displayTitle;
        const label = escapeHtml(rawLabel);

        // Detectar formato MKV u otros no-mp4
        const ext = (video.fileName || video.caption || '').split('.').pop().toLowerCase();
        const formatBadge = ext === 'mkv'  ? '<span class="badge-format badge-mkv">MKV</span>'
                          : ext === 'avi'  ? '<span class="badge-format badge-mkv">AVI</span>'
                          : ext === 'ts'   ? '<span class="badge-format badge-mkv">TS</span>'
                          : '';

        const item = document.createElement('div');
        item.className = 'movie-file-item';
        item.innerHTML = `
            <div class="movie-file-icon">▶</div>
            <div class="movie-file-info">
                <div class="movie-file-name">${label}${formatBadge}</div>
                <div class="movie-file-meta">${sizeStr}${durStr ? ' · ' + durStr : ''}</div>
            </div>
            <div class="movie-file-arrow">›</div>
        `;
        item.addEventListener('click', () => {
            closeMovieModal();
            playerOrigin = 'movie';
            playVideo(video, displayTitle, toShow);
        });
        makeFocusable(item);
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
        let videos = null;

        if (button.data && currentBotMsgId) {
            try {
                const clickResult = await clickInlineButton(currentBotMsgId, button.data);
                // On Android native, Kotlin returns the video array directly (smart wait)
                if (isNativeApp() && Array.isArray(clickResult) && clickResult.length > 0) {
                    videos = clickResult;
                }
            } catch (btnErr) {
                // MESSAGE_ID_INVALID → bot invalidated the old message. Refresh.
                if (btnErr.message?.includes('MESSAGE_ID_INVALID') && currentSeries) {
                    console.warn('MESSAGE_ID_INVALID — refreshing bot message...');
                    const fresh = await sendBotCommand(currentSeries.payload);
                    currentBotMsgId = fresh.messageId;
                    const freshBtn = fresh.buttons.find(b => b.text === button.text);
                    if (freshBtn?.data) {
                        const r2 = await clickInlineButton(currentBotMsgId, freshBtn.data);
                        if (isNativeApp() && Array.isArray(r2) && r2.length > 0) videos = r2;
                    }
                } else {
                    throw btnErr;
                }
            }
        }

        // Fallback: GramJS (desktop) or native with no messages yet
        if (!videos) {
            videos = await getVideoMessages(100, currentBotMsgId || 0);
        }

        $('episodes-loading').classList.add('hidden');

        if (!videos || videos.length === 0) {
            $('episodes-list').innerHTML = '<div class="center-message"><p>No se encontraron episodios</p></div>';
            return;
        }


        // Sort explicitly by msgId to ensure chronological order (Episode 1 first)
        // regardless of whether they came from Kotlin (chronological) or GramJS (reverse chronological)
        videos.sort((a, b) => a.msgId - b.msgId);
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
            card.addEventListener('click', () => { playerOrigin = 'episodes'; playVideo(video, series.title, videos); });
            makeFocusable(card);
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
        $('video-player').src = '';
        const loader = $('mpv-loader');
        if (loader) loader.style.display = 'flex';
        try {
            if (playlistArray && playlistArray.length > 0) {
                const startIndex = playlistArray.indexOf(video) !== -1 ? playlistArray.indexOf(video) : 0;
                await playInMpv(playlistArray, seriesTitle, startIndex);
            } else {
                const label = video.displayTitle || (video.caption || video.fileName || seriesTitle || '').replace(/\.[^.]+$/, '');
                await playInMpv([{ media: video.media, caption: label, displayTitle: label }], seriesTitle, 0);
            }
        } catch (err) {
            alert(`No se pudo abrir en MPV:\n${err.message}`);
        } finally {
            if (loader) loader.style.display = 'none';
        }
        return;
    }

    // ── Native Android TV ───────────────────────────────────────────────────────
    // Usamos el puente TDLib/ExoPlayer (Configuración brutal para Android TV)
    if (isNativeApp()) {
        try {
            await streamVideoNative(video);
        } catch (err) {
            console.error('[Native TV Player] Error:', err.message);
            alert('[Native TV Player] Error: ' + err.message + '\n' + (err.stack ? err.stack : 'No stacktrace'));
        }
        return;
    }

    // ── Native Android Mobile ───────────────────────────────────────────────────
    // Usamos el plugin ExoPlayer de Capacitor enviando chunks Base64 en segundo plano
    if (window.Capacitor?.isNativePlatform?.()) {
        try {
            await streamVideoMobileCapacitor(video);
        } catch (err) {
            console.error('[Native Mobile Player] Error:', err.message);
            alert('[Native Mobile Player] Error: ' + err.message + '\n' + (err.stack ? err.stack : 'No stacktrace'));
        }
        return;
    }

    const videoEl = $('video-player');

    $('player-title').textContent = video.fileName;
    $('player-subtitle').textContent = seriesTitle;
    $('player-download').classList.remove('hidden');
    $('download-progress').style.width = '0%';
    $('download-percent').textContent = '';
    $('download-text').textContent = 'Iniciando reproducción...';
    videoEl.src = '';
    showView('view-player');

    try {
        await streamVideo(video.media, videoEl, (progress) => {
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

        $('player-download').classList.add('hidden');
        await videoEl.play().catch(() => {});

        // On Android WebView: go native fullscreen automatically
        if (isNativeApp()) {
            const req = videoEl.requestFullscreen
                || videoEl.webkitRequestFullscreen
                || videoEl.mozRequestFullScreen;
            if (req) req.call(videoEl).catch(() => {});
        }
    } catch (err) {
        $('download-text').textContent = `Error: ${err.message}`;
        console.error('[Player]', err);
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
