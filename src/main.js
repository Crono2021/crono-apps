// Force a single Buffer implementation before GramJS loads.
// Without this, Buffer.isBuffer() fails across module boundaries.
import { Buffer as _Buf } from 'buffer';
window.Buffer = _Buf;
globalThis.Buffer = _Buf;

import catalog from './catalog.json';
import {
    isLoggedIn, sendCode, verifyCode, verify2FA, logout,
    sendBotCommand, clickInlineButton, getVideoMessages,
    streamVideo, initServiceWorker,
} from './telegram.js';
import {
    searchSeries, getSeasonEpisodes, extractSeasonNumber,
    parseEpisodeFile, posterUrl, stillUrl,
    getTrending, normTitle,
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
let catalogReady = false;

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

        videos.sort((a, b) => a.fileName.localeCompare(b.fileName, undefined, { numeric: true }));

        // Fetch TMDB episode details if we have a series ID
        const seasonNum = extractSeasonNumber(button.text);
        let tmdbEpisodes = [];
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

            // Match TMDB episode by filename
            const parsed = parseEpisodeFile(video.fileName);
            const tmdbEp = parsed
                ? tmdbEpisodes.find(e => e.number === parsed.episode)
                : null;

            const still = tmdbEp?.stillPath ? stillUrl(tmdbEp.stillPath) : null;
            const epTitle = tmdbEp?.name || video.fileName.replace(/\.[^.]+$/, '');
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
            card.addEventListener('click', () => playVideo(video, series.title));
            $('episodes-list').appendChild(card);
        }
    } catch (err) {
        $('episodes-loading').classList.add('hidden');
        $('episodes-list').innerHTML = `<div class="center-message"><p>Error: ${escapeHtml(err.message)}</p></div>`;
    }
}

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

$('btn-back-episodes').addEventListener('click', () => {
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
