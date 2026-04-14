/**
 * tv-nav.js — Cineflix Android TV D-pad Navigation
 *
 * Only activates when window._cineflixIsTV = true (injected by MainActivity on Android TV).
 * Has zero effect on mobile or the GitHub Pages web app.
 *
 * Architecture:
 *  - Watches for DOM changes via MutationObserver to detect when views change
 *  - Uses a "zone" concept: topbar zone → genre tabs zone → hero zone → rows zone
 *  - Within row zones, ←→ moves between cards; ↑↓ moves between zones/rows
 *  - Auto-scrolls focused element into view
 *  - Enter/OK triggers click(); Back triggers window.__cineflixBack()
 */

(function () {
  'use strict';

  // --- Guard: only run on Android TV ---
  function boot() {
    if (!window._cineflixIsTV) return;
    console.log('[TV-NAV] Activating D-pad navigation for Android TV');
    new CineflixTVNav().init();
  }

  // Wait for _cineflixIsTV to be injected (it comes after DOMContentLoaded)
  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', () => setTimeout(boot, 300));
  } else {
    setTimeout(boot, 300);
  }

  // ─────────────────────────────────────────────────────────────────────────
  class CineflixTVNav {
    constructor() {
      this.focused = null;       // Currently focused element
      this.zoneIndex = 0;        // Current vertical zone index
      this.rowItemIndex = 0;     // Current horizontal index within a row
      this.lastRowIndex = {};    // Remember horizontal position per zone key
      this.observer = null;
      this.injectStyles();
    }

    // ── Inject CSS for TV focus ring ──────────────────────────────────────
    injectStyles() {
      const style = document.createElement('style');
      style.textContent = `
        /* TV focus ring — only visible on Android TV */
        .tv-focused {
          outline: 3px solid #7c3aed !important;
          transform: scale(1.08) !important;
          z-index: 1000 !important;
          box-shadow: 0 0 0 3px #7c3aed55, 0 8px 30px rgba(124,58,237,0.5) !important;
          transition: transform 0.15s ease, box-shadow 0.15s ease !important;
        }
        /* Slightly bigger scale for hero buttons */
        .hero-btn.tv-focused, .btn-primary.tv-focused {
          transform: scale(1.1) !important;
        }
        /* Genre tabs focus */
        .genre-tab.tv-focused {
          background: #7c3aed !important;
          color: #fff !important;
          border-color: #7c3aed !important;
        }
        /* Nav buttons */
        .main-nav-btn.tv-focused {
          color: #7c3aed !important;
          border-bottom-color: #7c3aed !important;
        }
        /* Hide scrollbars on TV (nav with remote doesn't need them) */
        .android-tv ::-webkit-scrollbar { display: none !important; }
        /* Larger text on TV */
        .android-tv .series-card-title { font-size: 0.9rem !important; }
        .android-tv .hero-title { font-size: clamp(2rem, 4vw, 4rem) !important; }
      `;
      document.head.appendChild(style);
    }

    // ── Main entry point ──────────────────────────────────────────────────
    init() {
      document.addEventListener('keydown', (e) => this.onKey(e), true);

      // Watch for view changes and re-focus when a new view becomes active
      this.observer = new MutationObserver(() => this.onViewChanged());
      this.observer.observe(document.getElementById('app') || document.body, {
        subtree: true,
        attributes: true,
        attributeFilter: ['class']
      });

      // Initial focus after a short delay
      setTimeout(() => this.focusFirst(), 600);
    }

    // ── Key handler ───────────────────────────────────────────────────────
    onKey(e) {
      const key = e.keyCode || e.which;

      // KEYCODE map: ArrowLeft=37 ArrowUp=38 ArrowRight=39 ArrowDown=40
      // Enter/OK=13, Escape/Back=27, Android KEYCODE_BACK=4
      switch (key) {
        case 37: e.preventDefault(); this.move('left');  break;
        case 39: e.preventDefault(); this.move('right'); break;
        case 38: e.preventDefault(); this.move('up');    break;
        case 40: e.preventDefault(); this.move('down');  break;
        case 13: e.preventDefault(); this.confirm();     break;
        case 27:
        case 4:  e.preventDefault(); this.back();        break;
      }
    }

    // ── Get all navigable zones for current active view ───────────────────
    getZones() {
      const view = document.querySelector('.view.active');
      if (!view) return [];

      const zones = [];

      // Zone: main nav buttons (Series / Películas)
      const navBtns = [...view.querySelectorAll('.main-nav-btn')].filter(el => this.visible(el));
      if (navBtns.length) zones.push({ key: 'main-nav', type: 'row', items: navBtns });

      // Zone: genre tabs
      const genreTabs = [...view.querySelectorAll('.genre-tab')].filter(el => this.visible(el));
      if (genreTabs.length) zones.push({ key: 'genre-tabs', type: 'row', items: genreTabs });

      // Zone: hero buttons
      const heroBtns = [...view.querySelectorAll('.hero-btn, .hero-btn-primary')].filter(el => this.visible(el));
      if (heroBtns.length) zones.push({ key: 'hero', type: 'row', items: heroBtns });

      // Zone: back button (detail views)
      const backBtn = view.querySelector('.btn-back');
      if (backBtn && this.visible(backBtn)) {
        zones.push({ key: 'back', type: 'row', items: [backBtn] });
      }

      // Zone: each content row of cards
      const rows = [...view.querySelectorAll('.content-row, .catalog-grid')];
      rows.forEach((row, i) => {
        const cards = [...row.querySelectorAll('.series-card, .episode-card, .season-btn, .movie-file-item')].filter(el => this.visible(el));
        if (cards.length) zones.push({ key: `row-${i}`, type: 'row', items: cards });
      });

      // Zone: season buttons (season list view)
      const seasonBtns = [...view.querySelectorAll('.season-btn')].filter(el => this.visible(el));
      if (seasonBtns.length && !zones.find(z => z.items.some(i => i.classList.contains('season-btn')))) {
        zones.push({ key: 'seasons', type: 'row', items: seasonBtns });
      }

      // Zone: login buttons (phone/otp/2fa inputs + buttons)
      const loginStep = view.querySelector('.login-step.active');
      if (loginStep) {
        const loginEls = [...loginStep.querySelectorAll('input, button')].filter(el => this.visible(el));
        if (loginEls.length) zones.push({ key: 'login', type: 'row', items: loginEls });
      }

      // Zone: modal file items
      const modalFiles = [...document.querySelectorAll('.movie-file-item')].filter(el => this.visible(el));
      if (modalFiles.length) zones.push({ key: 'modal', type: 'row', items: modalFiles });

      return zones;
    }

    // ── Move focus in direction ───────────────────────────────────────────
    move(direction) {
      const zones = this.getZones();
      if (!zones.length) return;

      // Ensure zoneIndex is valid
      if (this.zoneIndex >= zones.length) this.zoneIndex = zones.length - 1;

      const zone = zones[this.zoneIndex];
      const remembered = this.lastRowIndex[zone.key] || 0;
      let itemIdx = Math.min(remembered, zone.items.length - 1);

      if (direction === 'left') {
        itemIdx = Math.max(0, itemIdx - 1);
        this.lastRowIndex[zone.key] = itemIdx;
        this.setFocus(zone.items[itemIdx]);
      } else if (direction === 'right') {
        itemIdx = Math.min(zone.items.length - 1, itemIdx + 1);
        this.lastRowIndex[zone.key] = itemIdx;
        this.setFocus(zone.items[itemIdx]);
      } else if (direction === 'up') {
        const newZone = Math.max(0, this.zoneIndex - 1);
        if (newZone !== this.zoneIndex) {
          // Save current horizontal position before leaving
          this.lastRowIndex[zone.key] = itemIdx;
          this.zoneIndex = newZone;
          const nextZone = zones[this.zoneIndex];
          const nextIdx = Math.min(this.lastRowIndex[nextZone.key] || 0, nextZone.items.length - 1);
          this.setFocus(nextZone.items[nextIdx]);
        }
      } else if (direction === 'down') {
        const newZone = Math.min(zones.length - 1, this.zoneIndex + 1);
        if (newZone !== this.zoneIndex) {
          this.lastRowIndex[zone.key] = itemIdx;
          this.zoneIndex = newZone;
          const nextZone = zones[this.zoneIndex];
          const nextIdx = Math.min(this.lastRowIndex[nextZone.key] || 0, nextZone.items.length - 1);
          this.setFocus(nextZone.items[nextIdx]);
        }
      }
    }

    // ── Set focus on element ──────────────────────────────────────────────
    setFocus(el) {
      if (!el) return;
      if (this.focused) this.focused.classList.remove('tv-focused');
      this.focused = el;
      el.classList.add('tv-focused');
      el.scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });
    }

    // ── Confirm / OK press ────────────────────────────────────────────────
    confirm() {
      if (!this.focused) { this.focusFirst(); return; }
      // For input fields, let normal keyboard input mode handle it
      if (this.focused.tagName === 'INPUT') {
        this.focused.focus();
        return;
      }
      this.focused.click();
    }

    // ── Back / Escape press ───────────────────────────────────────────────
    back() {
      if (window.__cineflixBack) {
        const handled = window.__cineflixBack();
        if (handled) {
          setTimeout(() => this.focusFirst(), 400);
        }
        // If not handled, Android native back will be called by the OS
      }
    }

    // ── Focus first element of first zone ────────────────────────────────
    focusFirst() {
      const zones = this.getZones();
      if (!zones.length) return;

      // Prefer hero or first row zone if catalog is loaded
      const heroIdx = zones.findIndex(z => z.key === 'hero');
      this.zoneIndex = heroIdx >= 0 ? heroIdx : 0;

      const zone = zones[this.zoneIndex];
      const itemIdx = this.lastRowIndex[zone.key] || 0;
      this.setFocus(zone.items[Math.min(itemIdx, zone.items.length - 1)]);
    }

    // ── View changed (MutationObserver callback) ──────────────────────────
    onViewChanged() {
      // Debounce
      clearTimeout(this._viewTimer);
      this._viewTimer = setTimeout(() => {
        // Check if focused element is still visible
        if (!this.focused || !this.visible(this.focused)) {
          if (this.focused) this.focused.classList.remove('tv-focused');
          this.focused = null;
          this.zoneIndex = 0;
          this.focusFirst();
        }
      }, 300);
    }

    // ── Visibility check ──────────────────────────────────────────────────
    visible(el) {
      if (!el) return false;
      const rect = el.getBoundingClientRect();
      return (
        rect.width > 0 &&
        rect.height > 0 &&
        window.getComputedStyle(el).display !== 'none' &&
        window.getComputedStyle(el).visibility !== 'hidden'
      );
    }
  }

})();
