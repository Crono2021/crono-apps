/**
 * tv-nav.js — Cineflix Android TV D-pad Navigation
 *
 * Only activates when window._cineflixIsTV = true (injected by MainActivity on Android TV).
 * Has zero effect on mobile or the GitHub Pages web app.
 *
 * Key features:
 *  - Zone-based spatial navigation (topbar → genre tabs → hero → rows)
 *  - INPUT MODE: D-pad keys are suppressed while an <input> is active so the
 *    on-screen keyboard can work normally. Back/Escape exits input mode.
 *  - Search inputs and login inputs are fully navigable and activatable
 *  - Auto-scroll focused element into view
 *  - MutationObserver re-focuses when views change
 */

(function () {
  'use strict';

  let bootAttempts = 0;
  function boot() {
    if (window._cineflixIsTV) {
      console.log('[TV-NAV] Activating D-pad navigation for Android TV');
      new CineflixTVNav().init();
    } else if (bootAttempts < 15) {
      bootAttempts++;
      setTimeout(boot, 300);
    } else {
      console.log('[TV-NAV] Aborting boot, window._cineflixIsTV not set after 15 attempts');
    }
  }

  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', boot);
  } else {
    boot();
  }

  // ─────────────────────────────────────────────────────────────────────────
  class CineflixTVNav {
    constructor() {
      this.focused      = null;   // Currently focused DOM element
      this.zoneIndex    = 0;      // Vertical zone index
      this.lastRowIndex = {};     // Horizontal position memory per zone key
      this.inputMode    = false;  // TRUE while user is typing in an <input>
      this._viewTimer   = null;
      this.observer     = null;
      this.injectStyles();
    }

    // ── CSS styles ────────────────────────────────────────────────────────
    injectStyles() {
      const s = document.createElement('style');
      s.textContent = `
        /* D-pad focus ring */
        .tv-focused {
          outline: 3px solid #7c3aed !important;
          transform: scale(1.06) !important;
          z-index: 1000 !important;
          box-shadow: 0 0 0 3px rgba(124,58,237,0.4), 0 8px 30px rgba(124,58,237,0.5) !important;
          transition: transform 0.12s ease, box-shadow 0.12s ease !important;
        }
        /* While typing: green border shows keyboard/text mode is active */
        .tv-input-active {
          outline: 3px solid #22c55e !important;
          box-shadow: 0 0 0 4px rgba(34,197,94,0.35) !important;
          background: rgba(34,197,94,0.08) !important;
        }
        input.tv-focused {
          outline: 3px solid #7c3aed !important;
          background: rgba(124,58,237,0.12) !important;
          caret-color: #7c3aed;
        }
        .hero-btn.tv-focused, .btn-primary.tv-focused { transform: scale(1.1) !important; }
        .genre-tab.tv-focused { background: #7c3aed !important; color: #fff !important; border-color: #7c3aed !important; }
        .main-nav-btn.tv-focused { color: #7c3aed !important; border-bottom-color: #7c3aed !important; }
        .android-tv ::-webkit-scrollbar { display: none !important; }
      `;
      document.head.appendChild(s);
    }

    // ── Init ──────────────────────────────────────────────────────────────
    init() {
      // Capture phase so we intercept before anything else
      document.addEventListener('keydown', (e) => this.onKey(e), true);

      // Detect when user focuses/blurs an input (system keyboard appears/disappears)
      document.addEventListener('focus', (e) => {
        if (e.target.tagName === 'INPUT' || e.target.tagName === 'TEXTAREA') {
          this.enterInputMode(e.target);
        }
      }, true);

      document.addEventListener('blur', (e) => {
        if (e.target.tagName === 'INPUT' || e.target.tagName === 'TEXTAREA') {
          this.exitInputMode(e.target);
        }
      }, true);

      // Re-focus when views change
      this.observer = new MutationObserver(() => this.onViewChanged());
      this.observer.observe(document.getElementById('app') || document.body, {
        subtree: true, attributes: true, attributeFilter: ['class']
      });

      setTimeout(() => this.focusFirst(), 600);
    }

    // ── Input mode enter ──────────────────────────────────────────────────
    // Called when an <input> gains focus (via OK press or directly)
    enterInputMode(el) {
      this.inputMode = true;
      if (this.focused && this.focused !== el) {
        this.focused.classList.remove('tv-focused');
      }
      this.focused = el;
      el.classList.remove('tv-focused');
      el.classList.add('tv-input-active');
      console.log('[TV-NAV] Input mode ON:', el.id || el.placeholder);
    }

    // ── Input mode exit ───────────────────────────────────────────────────
    // Called when the <input> loses focus (Back pressed or user taps elsewhere)
    exitInputMode(el) {
      this.inputMode = false;
      if (el) el.classList.remove('tv-input-active');
      // Restore D-pad focus ring on the same element so user can navigate away
      if (this.focused) {
        this.focused.classList.add('tv-focused');
      }
      console.log('[TV-NAV] Input mode OFF');
    }

    // ── Key handler ───────────────────────────────────────────────────────
    onKey(e) {
      const key = e.keyCode || e.which;

      // ── INPUT MODE: only Back/Escape exits; everything else passes through ──
      if (this.inputMode) {
        if (key === 27 || key === 4 /* Android KEYCODE_BACK */) {
          e.preventDefault();
          if (this.focused) this.focused.blur(); // triggers exitInputMode via blur event
        }
        // Arrow keys, letters, Enter all pass through to on-screen keyboard / input
        return;
      }

      // ── NORMAL D-PAD MODE ─────────────────────────────────────────────
      switch (key) {
        case 37: e.preventDefault(); this.move('left');  break; // ←
        case 39: e.preventDefault(); this.move('right'); break; // →
        case 38: e.preventDefault(); this.move('up');    break; // ↑
        case 40: e.preventDefault(); this.move('down');  break; // ↓
        case 13: e.preventDefault(); this.confirm();     break; // OK / Enter
        case 27:                                               // Escape
        case 4:  e.preventDefault(); this.back();        break; // Android Back
      }
    }

    // ── Build zone list for the current active view ───────────────────────
    getZones() {
      const view = document.querySelector('.view.active');
      if (!view) return [];
      const zones = [];

      // Zone 1 — Topbar: search box + logout button
      const searchInput = view.querySelector('#search-input, #movies-search-input');
      const logoutBtn   = view.querySelector('#btn-logout, #btn-movies-logout');
      const topbarItems = [searchInput, logoutBtn].filter(Boolean).filter(el => this.visible(el));
      if (topbarItems.length) zones.push({ key: 'topbar', items: topbarItems });

      // Zone 2 — Main nav (Series / Películas tabs)
      const navBtns = [...view.querySelectorAll('.main-nav-btn')].filter(el => this.visible(el));
      if (navBtns.length) zones.push({ key: 'main-nav', items: navBtns });

      // Zone 3 — Genre tabs
      const genreTabs = [...view.querySelectorAll('.genre-tab')].filter(el => this.visible(el));
      if (genreTabs.length) zones.push({ key: 'genre-tabs', items: genreTabs });

      // Zone 4 — Hero button (▶ Ver ahora)
      const heroBtns = [...view.querySelectorAll('.hero-btn, .hero-btn-primary')].filter(el => this.visible(el));
      if (heroBtns.length) zones.push({ key: 'hero', items: heroBtns });

      // Zone 5 — Back button (series/episodes detail views)
      const backBtn = view.querySelector('.btn-back');
      if (backBtn && this.visible(backBtn)) {
        zones.push({ key: 'back', items: [backBtn] });
      }

      // Zone 6-N — Each horizontal content row
      [...view.querySelectorAll('.content-row')].forEach((row, i) => {
        const cards = [...row.querySelectorAll('.series-card, .episode-card, .movie-file-item')]
          .filter(el => this.visible(el));
        if (cards.length) zones.push({ key: `row-${i}`, items: cards });
      });

      // Zone — Catalog/search grid (when search results are shown)
      const gridCards = [...view.querySelectorAll(
        '#catalog-grid .series-card, #movies-grid .series-card'
      )].filter(el => this.visible(el));
      if (gridCards.length) zones.push({ key: 'grid', items: gridCards });

      // Zone — Season list
      const seasonBtns = [...view.querySelectorAll('.season-btn')].filter(el => this.visible(el));
      if (seasonBtns.length) zones.push({ key: 'seasons', items: seasonBtns });

      // Zone — Episode list
      const episodeCards = [...view.querySelectorAll('.episode-card')]
        .filter(el => this.visible(el));
      // Only add if not already covered by a .content-row zone
      if (episodeCards.length && !zones.some(z => z.items.some(i => i.classList.contains('episode-card')))) {
        zones.push({ key: 'episodes', items: episodeCards });
      }

      // Zone — Login form (phone input + Send button, OTP input + Verify button)
      const loginStep = view.querySelector('.login-step.active');
      if (loginStep) {
        const loginEls = [...loginStep.querySelectorAll('input, button')]
          .filter(el => this.visible(el));
        if (loginEls.length) zones.push({ key: 'login', items: loginEls });
      }

      // Zone — Modal (movie quality / file selector)
      const modal = document.querySelector('.modal-overlay:not(.hidden)');
      if (modal) {
        const closeBtn = modal.querySelector('#modal-close');
        if (closeBtn && this.visible(closeBtn)) {
          zones.push({ key: 'modal-close', items: [closeBtn] });
        }
        const fileItems = [...modal.querySelectorAll('.movie-file-item')]
          .filter(el => this.visible(el));
        if (fileItems.length) zones.push({ key: 'modal-files', items: fileItems });
      }

      return zones;
    }

    // ── Move focus in direction ───────────────────────────────────────────
    move(direction) {
      const zones = this.getZones();
      if (!zones.length) return;
      if (this.zoneIndex >= zones.length) this.zoneIndex = zones.length - 1;

      const zone    = zones[this.zoneIndex];
      const prevIdx = Math.min(this.lastRowIndex[zone.key] || 0, zone.items.length - 1);

      if (direction === 'left') {
        const next = Math.max(0, prevIdx - 1);
        this.lastRowIndex[zone.key] = next;
        this.setFocus(zone.items[next]);

      } else if (direction === 'right') {
        const next = Math.min(zone.items.length - 1, prevIdx + 1);
        this.lastRowIndex[zone.key] = next;
        this.setFocus(zone.items[next]);

      } else if (direction === 'up') {
        if (this.zoneIndex === 0) return;
        this.lastRowIndex[zone.key] = prevIdx;
        this.zoneIndex = Math.max(0, this.zoneIndex - 1);
        this.focusCurrentZone(zones);

      } else if (direction === 'down') {
        if (this.zoneIndex === zones.length - 1) return;
        this.lastRowIndex[zone.key] = prevIdx;
        this.zoneIndex = Math.min(zones.length - 1, this.zoneIndex + 1);
        this.focusCurrentZone(zones);
      }
    }

    focusCurrentZone(zones) {
      const zone = zones[this.zoneIndex];
      const idx  = Math.min(this.lastRowIndex[zone.key] || 0, zone.items.length - 1);
      this.setFocus(zone.items[idx]);
    }

    // ── Set visual focus on element ───────────────────────────────────────
    setFocus(el) {
      if (!el) return;
      if (this.focused && this.focused !== el) {
        this.focused.classList.remove('tv-focused');
        this.focused.classList.remove('tv-input-active');
      }
      this.focused = el;
      el.classList.add('tv-focused');
      el.scrollIntoView({ behavior: 'smooth', block: 'nearest', inline: 'nearest' });
    }

    // ── OK / Enter pressed ────────────────────────────────────────────────
    confirm() {
      if (!this.focused) { this.focusFirst(); return; }

      if (this.focused.tagName === 'INPUT' || this.focused.tagName === 'TEXTAREA') {
        // Focus the input → triggers enterInputMode → shows system keyboard on TV
        this.focused.focus();
        // enterInputMode is called by the 'focus' event listener automatically
      } else {
        this.focused.click();
      }
    }

    // ── Back pressed ──────────────────────────────────────────────────────
    back() {
      if (window.__cineflixBack) {
        const handled = window.__cineflixBack();
        if (handled) setTimeout(() => this.focusFirst(), 400);
      }
    }

    // ── Auto-focus first relevant element ────────────────────────────────
    focusFirst() {
      const zones = this.getZones();
      if (!zones.length) return;

      // Prefer content over chrome
      const preferred = ['hero', 'row-0', 'seasons', 'episodes', 'login', 'modal-files'];
      const idx = zones.findIndex(z => preferred.includes(z.key));
      this.zoneIndex = idx >= 0 ? idx : 0;
      this.focusCurrentZone(zones);
    }

    // ── View changed (MutationObserver callback) ──────────────────────────
    onViewChanged() {
      clearTimeout(this._viewTimer);
      this._viewTimer = setTimeout(() => {
        if (this.inputMode) return; // Never interrupt active input
        if (!this.focused || !this.visible(this.focused)) {
          if (this.focused) this.focused.classList.remove('tv-focused');
          this.focused   = null;
          this.zoneIndex = 0;
          this.focusFirst();
        }
      }, 350);
    }

    // ── Element visibility check ──────────────────────────────────────────
    visible(el) {
      if (!el) return false;
      const r = el.getBoundingClientRect();
      const cs = window.getComputedStyle(el);
      return r.width > 0 && r.height > 0 &&
        cs.display    !== 'none' &&
        cs.visibility !== 'hidden' &&
        cs.opacity    !== '0';
    }
  }

})();
