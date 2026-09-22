(function() {
  'use strict';

  function isDesktopPC() {
    try {
      if (new URLSearchParams(window.location.search).get('tv') === '1') return false;
    } catch (e) {}

    if (window.__appPlatform === 'android_tv' || window.__appPlatform === 'android') return false;
    if (window.AndroidBridge && typeof window.AndroidBridge.getPlatform === 'function') {
      try {
        var p = window.AndroidBridge.getPlatform();
        if (p === 'android_tv' || p === 'android') return false;
      } catch (e) {}
    }

    var ua = (navigator.userAgent || '').toLowerCase();
    // Exclude TV platforms
    if (/smart.?tv|bravia|tizen|webos|hbbtv|vidaa|viera|nettv|philipstv|googletv|androidtv|box|crkey|firetv|aft[mbtsk]|mibox|shield|roku/i.test(ua)) {
      return false;
    }

    // Explicit desktop operating systems
    var isWindows = /windows nt|win32|win64|wow64/i.test(ua);
    var isMac = /macintosh|mac os x/i.test(ua) && !/iphone|ipad|ipod/i.test(ua);
    var isDesktopLinux = /linux/i.test(ua) && !/android/i.test(ua);
    var isCrOS = /cros/i.test(ua);

    if (isWindows || isMac || isDesktopLinux || isCrOS) return true;

    // Pointer fine + no touch + non-mobile
    if (window.matchMedia && window.matchMedia('(pointer: fine)').matches && !('ontouchstart' in window) && !(navigator.maxTouchPoints > 0) && !/mobile|android|iphone|ipad|ipod/i.test(ua)) {
      return true;
    }

    return false;
  }

  class CineflixTVNav {
    constructor() {
      this.focused = null;
      this._prevFocused = null;
      this._lastNavDir = null;
      this.inputMode = false;
      
      this.handleKeyDown = this.handleKeyDown.bind(this);
      this.handleKeyUp = this.handleKeyUp.bind(this);
      this._enterHoldTimer = null;
      this._longPressFired = false;
      
      this.lastNavX = null;
      this.focusedKey = null;
      this.focusStack = [];
      this.savedFocusedKey = null;
      this.navigationInProgress = false;
      this.navigationTimer = null;
    }

    isTV() {
      if (isDesktopPC()) return false;
      if (window._cineflixIsTV || document.body.classList.contains('is-tv') || document.documentElement.classList.contains('android-tv') || document.documentElement.classList.contains('is-tv')) {
        return true;
      }
      try {
        if (window.__appPlatform === 'android_tv') return true;
        if (window.AndroidBridge && typeof window.AndroidBridge.getPlatform === 'function' && window.AndroidBridge.getPlatform() === 'android_tv') return true;
        if (new URLSearchParams(window.location.search).get('tv') === '1') return true;
        const ua = (navigator.userAgent || '').toLowerCase();
        if (/\b(tv|smart-?tv|googletv|tizen|webos|crkey|firetv|aft[mbtsk]|bravia|viera|roku|mibox|shield)\b/i.test(ua)) return true;
      } catch (e) {}
      return false;
    }

    init() {
      document.addEventListener('keydown', this.handleKeyDown, { capture: true });
      document.addEventListener('keyup', this.handleKeyUp, { capture: true });

      // Track clicked/tapped element so restoreFocus always knows where user was
      document.addEventListener('pointerdown', (e) => {
        const focusable = e.target.closest('[tabindex="0"], button, input, textarea, a[href], .series-card, .continue-card, .movie-card, .platform-card, .genre-tab');
        if (focusable) {
          this.focused = focusable;
          this.focusedKey = focusable.dataset.id || focusable.dataset.seriesId || focusable.dataset.movieId || focusable.id || null;
          if (!this.isTV()) {
            document.querySelectorAll('.tv-focused').forEach(node => node.classList.remove('tv-focused'));
          }
        }
      }, { capture: true, passive: true });

      const style = document.createElement('style');
      style.innerHTML = `
        body.is-tv .tv-focused, .android-tv .tv-focused {
          outline: 3px solid #e50914 !important;
          outline-offset: 2px !important;
          box-shadow: 0 0 16px rgba(229, 9, 20, 0.75) !important;
          z-index: 20 !important;
        }
        body.is-tv input.tv-focused, body.is-tv textarea.tv-focused,
        .android-tv input.tv-focused, .android-tv textarea.tv-focused {
          outline: 4px solid #e50914 !important;
          outline-offset: 4px !important;
          box-shadow: 0 0 16px rgba(229, 9, 20, 0.6) !important;
        }
        *:focus { outline: none !important; }
      `;
      document.head.appendChild(style);

      // Ensure search input does not hold initial focus on TV
      const searchInput = document.getElementById('search-input');
      if (searchInput && document.activeElement === searchInput) {
        searchInput.blur();
      }

      // Keep focus when window regains focus (e.g. returning from native PlayerActivity)
      window.addEventListener('focus', () => {
        setTimeout(() => {
          if (!this.focused || !document.body.contains(this.focused) || !this.visible(this.focused)) {
            if (this.hasSavedFocus()) {
              this.restoreFocus();
            } else if (this.focusedKey) {
              const candidates = this.getNavigableElements();
              const recovered = candidates.find(el => 
                (el.dataset.id || el.dataset.seriesId || el.dataset.movieId || el.id) === this.focusedKey
              );
              if (recovered && this.visible(recovered)) {
                this.setFocus(recovered);
              } else if (window._cineflixIsTV) {
                this.focusFirst();
              }
            } else if (window._cineflixIsTV) {
              this.focusFirst();
            }
          }
        }, 150);
      });

      if (window._cineflixIsTV) {
        setTimeout(() => this.focusFirst(), 300);
      }
      console.log('[TV-NAV] Initialized (no MutationObserver)');
    }

    handleKeyDown(e) {
      const key = e.key || e.code;
      const keyCode = e.keyCode || e.which;
      
      const isUp = key === 'ArrowUp' || keyCode === 38 || keyCode === 19;
      const isDown = key === 'ArrowDown' || keyCode === 40 || keyCode === 20;
      const isLeft = key === 'ArrowLeft' || keyCode === 37 || keyCode === 21;
      const isRight = key === 'ArrowRight' || keyCode === 39 || keyCode === 22;
      const isEnter = key === 'Enter' || keyCode === 13 || keyCode === 23 || keyCode === 66;
      const isBack = key === 'Escape' || keyCode === 27 || keyCode === 4;

      if (isUp || isDown || isLeft || isRight || isEnter || isBack) {
        if (isDesktopPC()) {
          // NEVER activate TV mode on desktop PC with physical keyboard
        } else if (!document.body.classList.contains('is-tv')) {
          const ua = (navigator.userAgent || '').toLowerCase();
          if (!ua.includes('mobile') || ua.includes('tv') || ua.includes('box') || ua.includes('shield')) {
            window._cineflixIsTV = true;
            document.body.classList.add('is-tv');
            document.documentElement.classList.add('is-tv');
            console.log('[TV-NAV] D-pad key active -> activated is-tv classes');
          }
        }
      }

      if (isBack) {
        if (window.__cineflixVKOpen && window.__cineflixVKOpen()) {
          e.preventDefault();
          e.stopPropagation();
          if (window.__cineflixVKClose) window.__cineflixVKClose();
          return;
        }
        if (this.inputMode) {
          this.exitInputMode();
          e.preventDefault();
          return;
        }
        this.back();
        e.preventDefault();
        return;
      }

      if (this.inputMode) {
        return; // Let native keyboard handle arrows
      }

      const isMenuKey = key === 'ContextMenu' || key === 'Menu' || keyCode === 82;
      if (isMenuKey) {
        const targetEl = (this.focused && this.focused.closest && (this.focused.closest('.continue-card') || this.focused.closest('.series-card') || this.focused.closest('.movie-card'))) || this.focused;
        if (this.isContinueCard(targetEl)) {
          e.preventDefault();
          e.stopPropagation();
          if (typeof window.showContinueContextMenuForElement === 'function') {
            window.showContinueContextMenuForElement(targetEl);
          }
          return;
        }
      }

      if (isEnter) {
        // If an input is focused on a non-TV device, let the native keyboard/browser handle Enter
        if (document.activeElement && (document.activeElement.tagName === 'INPUT' || document.activeElement.tagName === 'TEXTAREA')) {
          const isTV = !!(window._cineflixIsTV || window.__appPlatform === 'android_tv' || document.body.classList.contains('is-tv'));
          if (!isTV) {
            return;
          }
        }

        e.preventDefault();
        e.stopPropagation();

        if (this._longPressLocked) {
          // While still holding OK from the long-press that opened the modal, ignore all repeats!
          // Debounce safety timer: as long as user keeps holding the button, keep extending the lock!
          if (this._lockSafetyTimer) clearTimeout(this._lockSafetyTimer);
          this._lockSafetyTimer = setTimeout(() => { this._longPressLocked = false; }, 600);
          return;
        }

        const targetEl = (this.focused && this.focused.closest && (this.focused.closest('.continue-card') || this.focused.closest('.series-card') || this.focused.closest('.movie-card'))) || this.focused;
        const isContinue = this.isContinueCard(targetEl);

        if (isContinue) {
          if (this._longPressFired) return;

          // Track continuous key repeats from holding OK on the remote
          this._enterHoldCount = (this._enterHoldCount || 0) + 1;

          // Trigger long press after ~6 repeats (~300-400ms of holding OK)
          if (this._enterHoldCount >= 6) {
            if (this._enterHoldTimer) {
              clearTimeout(this._enterHoldTimer);
              this._enterHoldTimer = null;
            }
            this._longPressFired = true;
            this._longPressLocked = true;
            this._enterHoldCount = 0;
            if (this._lockSafetyTimer) clearTimeout(this._lockSafetyTimer);
            this._lockSafetyTimer = setTimeout(() => { this._longPressLocked = false; }, 800);
            if (typeof window.showContinueContextMenuForElement === 'function') {
              window.showContinueContextMenuForElement(targetEl);
            }
            return;
          }

          if (!this._enterHoldTimer) {
            this._enterHoldTimer = setTimeout(() => {
              this._enterHoldTimer = null;
              if (this._enterHoldCount >= 2) {
                this._longPressFired = true;
                this._longPressLocked = true;
                this._enterHoldCount = 0;
                if (this._lockSafetyTimer) clearTimeout(this._lockSafetyTimer);
                this._lockSafetyTimer = setTimeout(() => { this._longPressLocked = false; }, 800);
                if (typeof window.showContinueContextMenuForElement === 'function') {
                  window.showContinueContextMenuForElement(targetEl);
                }
              } else {
                // Short press fallback when keyup is missing
                this._enterHoldCount = 0;
                this.confirm();
              }
            }, 500);
          }
          return;
        }

        this.confirm();
        return;
      }

      if (isUp || isDown || isLeft || isRight) {
        if (this._enterHoldTimer) {
          clearTimeout(this._enterHoldTimer);
          this._enterHoldTimer = null;
        }
        this._enterHoldCount = 0;
        this._longPressFired = false;
        this._longPressLocked = false;
        e.preventDefault();
        e.stopPropagation();

        const now = (typeof performance !== 'undefined' && performance.now) ? performance.now() : Date.now();
        if (this._lastNavTime && (now - this._lastNavTime < 75)) {
          return;
        }
        this._lastNavTime = now;
        
        let dir = isUp ? 'UP' : isDown ? 'DOWN' : isLeft ? 'LEFT' : 'RIGHT';
        this.navigate(dir);
      }
    }

    handleKeyUp(e) {
      const key = e.key || e.code;
      const keyCode = e.keyCode || e.which;
      const isEnter = key === 'Enter' || keyCode === 13 || keyCode === 23 || keyCode === 66;

      if (isEnter) {
        if (this._enterHoldTimer) {
          clearTimeout(this._enterHoldTimer);
          this._enterHoldTimer = null;
        }

        if (this._longPressLocked) {
          // User finally released the physical OK button after the menu opened!
          this._longPressFired = false;
          this._enterHoldCount = 0;
          if (this._lockSafetyTimer) clearTimeout(this._lockSafetyTimer);
          // Absorb button release bounce for 350ms
          this._lockSafetyTimer = setTimeout(() => {
            this._longPressLocked = false;
          }, 350);
          e.preventDefault();
          e.stopPropagation();
          return;
        }

        const wasLong = this._longPressFired;
        this._longPressFired = false;
        const count = this._enterHoldCount || 0;
        this._enterHoldCount = 0;

        if (wasLong) {
          e.preventDefault();
          e.stopPropagation();
          return;
        }

        const targetEl = (this.focused && this.focused.closest && (this.focused.closest('.continue-card') || this.focused.closest('.series-card') || this.focused.closest('.movie-card'))) || this.focused;
        if (this.isContinueCard(targetEl)) {
          e.preventDefault();
          e.stopPropagation();
          this.confirm();
        }
      }
    }

    isContinueCard(el) {
      if (!el) return false;
      const card = (el.closest && (el.closest('.continue-card') || el.closest('.series-card') || el.closest('.movie-card'))) || el;
      if (card.classList && card.classList.contains('continue-card')) return true;
      const id = card.dataset ? (card.dataset.id || '') : '';
      if (id.startsWith('continue_') || id.startsWith('grid_tv_') || id.startsWith('grid_mv_')) {
        return true;
      }
      try {
        if (card.closest) {
          if (card.closest('#continue-watching-movies') || card.closest('#continue-watching-series') || card.closest('#continue-grid')) {
            return true;
          }
        }
      } catch (e) {}
      return false;
    }

    navigate(dir) {
      this._lastNavDir = dir;
      if (this.inputMode) return;
      if (!this.focused || !this.visible(this.focused)) {
        this.focusFirst();
        if (!this.focused || !this.visible(this.focused)) return;
      }

      this.navigationInProgress = true;

      // 0-B. ACTOR PROFILE DEDICATED NAVIGATION & READING SCROLL:
      const inActorProfile = this.focused && (this.focused.closest('#view-actor-profile') || document.querySelector('#view-actor-profile.active'));
      if (inActorProfile) {
        const actorView = document.getElementById('view-actor-profile');
        const isBio = this.focused && (this.focused.id === 'actor-profile-bio' || this.focused.closest('#actor-profile-bio'));
        const isContentBtn = this.focused && this.focused.id === 'btn-actor-view-content';
        const isBackBtn = this.focused && this.focused.id === 'btn-actor-profile-back';

        if (isBio) {
          if (actorView && actorView.scrollHeight > actorView.clientHeight) {
            if (dir === 'DOWN') {
              const maxScroll = actorView.scrollHeight - actorView.clientHeight;
              if (actorView.scrollTop < maxScroll - 15) {
                actorView.scrollBy({ top: 200, behavior: 'smooth' });
                return;
              }
            } else if (dir === 'UP') {
              if (actorView.scrollTop > 15) {
                actorView.scrollBy({ top: -200, behavior: 'smooth' });
                return;
              }
            }
          }
          if (dir === 'LEFT' || dir === 'UP') {
            const btnContent = document.getElementById('btn-actor-view-content');
            if (btnContent && this.visible(btnContent)) { this.setFocus(btnContent); return; }
            const btnBack = document.getElementById('btn-actor-profile-back');
            if (btnBack && this.visible(btnBack)) { this.setFocus(btnBack); return; }
          }
        } else if (isContentBtn) {
          if (dir === 'UP') {
            const btnBack = document.getElementById('btn-actor-profile-back');
            if (btnBack && this.visible(btnBack)) { this.setFocus(btnBack); return; }
          } else if (dir === 'RIGHT' || dir === 'DOWN') {
            const bio = document.getElementById('actor-profile-bio');
            if (bio && this.visible(bio)) { this.setFocus(bio); return; }
          }
        } else if (isBackBtn) {
          if (dir === 'DOWN') {
            const btnContent = document.getElementById('btn-actor-view-content');
            if (btnContent && this.visible(btnContent)) { this.setFocus(btnContent); return; }
            const bio = document.getElementById('actor-profile-bio');
            if (bio && this.visible(bio)) { this.setFocus(bio); return; }
          }
        }
      }

      // 0. VIRTUAL KEYBOARD DEDICATED NAVIGATION:
      const vkOverlay = document.getElementById('vk-overlay');
      const isVkOpen = vkOverlay && !vkOverlay.classList.contains('hidden') && this.visible(vkOverlay);
      if (isVkOpen) {
        // If focus somehow wandered outside VK, bring it back
        if (!this.focused || !vkOverlay.contains(this.focused)) {
          const firstKey = vkOverlay.querySelector('.vk-key[data-char="Q"]') || vkOverlay.querySelector('.vk-key');
          if (firstKey) this.setFocus(firstKey);
          return;
        }

        const currentKey = this.focused.closest('.vk-key');
        if (currentKey) {
          const rows = Array.from(vkOverlay.querySelectorAll('.vk-row'));
          const currentRow = currentKey.closest('.vk-row');
          const rowIdx = rows.indexOf(currentRow);

          if (rowIdx !== -1) {
            const keysInRow = Array.from(currentRow.querySelectorAll('.vk-key'));
            const keyIdx = keysInRow.indexOf(currentKey);

            if (dir === 'LEFT') {
              if (keyIdx > 0) {
                this.setFocus(keysInRow[keyIdx - 1]);
              } else {
                // Wrap-around horizontal: salta al extremo derecho de la fila
                this.setFocus(keysInRow[keysInRow.length - 1]);
              }
              return;
            }
            if (dir === 'RIGHT') {
              if (keyIdx < keysInRow.length - 1) {
                this.setFocus(keysInRow[keyIdx + 1]);
              } else {
                // Wrap-around horizontal: salta al extremo izquierdo de la fila
                this.setFocus(keysInRow[0]);
              }
              return;
            }
            if (dir === 'UP') {
              const targetRowIdx = (rowIdx > 0) ? (rowIdx - 1) : (rows.length - 1);
              const targetRowKeys = Array.from(rows[targetRowIdx].querySelectorAll('.vk-key'));
              const curRect = currentKey.getBoundingClientRect();
              const curCx = curRect.left + curRect.width / 2;
              let bestKey = targetRowKeys[0];
              let bestDist = Infinity;
              for (let k of targetRowKeys) {
                const kr = k.getBoundingClientRect();
                const dist = Math.abs((kr.left + kr.width / 2) - curCx);
                if (dist < bestDist) {
                  bestDist = dist;
                  bestKey = k;
                }
              }
              this.setFocus(bestKey);
              return;
            }
            if (dir === 'DOWN') {
              const targetRowIdx = (rowIdx < rows.length - 1) ? (rowIdx + 1) : 0;
              const targetRowKeys = Array.from(rows[targetRowIdx].querySelectorAll('.vk-key'));
              const curRect = currentKey.getBoundingClientRect();
              const curCx = curRect.left + curRect.width / 2;
              let bestKey = targetRowKeys[0];
              let bestDist = Infinity;
              for (let k of targetRowKeys) {
                const kr = k.getBoundingClientRect();
                const dist = Math.abs((kr.left + kr.width / 2) - curCx);
                if (dist < bestDist) {
                  bestDist = dist;
                  bestKey = k;
                }
              }
              this.setFocus(bestKey);
              return;
            }
          }
        }
        return; // Stay completely inside VK!
      }

      // 1. HORIZONTAL GROUP SHORTCUT:
      // If moving LEFT/RIGHT within a container (.genre-tabs, .row-cards, .nav-tabs, .nav-links, .hero-buttons, .series-hero-actions, .series-episodes-track, .series-episodes-carousel, .series-detail-cast, .series-detail-buttons),
      // strictly move within that container unless escaping at the boundary (e.g. from last nav tab to search).
      if (dir === 'LEFT' || dir === 'RIGHT') {
        const group = this.focused.closest('.genre-tabs, .row-cards, .nav-tabs, .nav-links, .hero-buttons, .series-hero-actions, .series-episodes-track, .series-episodes-carousel, .series-detail-cast, .series-detail-buttons');
        if (group) {
          // Fast O(1) sibling traversal for horizontal rows, card lists, and nested button clusters (e.g. arrow pairs):
          let candidate = null;
          let searchEl = this.focused;
          
          while (searchEl && searchEl !== group && !candidate) {
            let step = (dir === 'LEFT') ? searchEl.previousElementSibling : searchEl.nextElementSibling;
            while (step) {
              if (step.matches && step.matches('[tabindex="0"], button, input, textarea, a[href]') && step.getAttribute('tabindex') !== '-1') {
                if (step.offsetWidth > 0 || step.offsetHeight > 0) {
                  candidate = step;
                  break;
                }
              } else if (step.querySelectorAll) {
                const inners = Array.from(step.querySelectorAll('[tabindex="0"], button, input, textarea, a[href]'))
                  .filter(el => el.getAttribute('tabindex') !== '-1' && (el.offsetWidth > 0 || el.offsetHeight > 0));
                if (inners.length > 0) {
                  candidate = (dir === 'LEFT') ? inners[inners.length - 1] : inners[0];
                  break;
                }
              }
              step = (dir === 'LEFT') ? step.previousElementSibling : step.nextElementSibling;
            }
            if (!candidate) {
              searchEl = searchEl.parentElement;
            }
          }

          if (candidate) {
            this.setFocus(candidate);
            return;
          }

          // If no sibling in that direction:
          // Escaping rightmost nav tab into search input:
          if (dir === 'RIGHT' && (group.closest('#main-topbar, .topbar') || group.classList.contains('nav-links') || group.classList.contains('nav-tabs'))) {
            const searchInput = document.getElementById('search-input');
            if (searchInput && (searchInput.offsetWidth > 0 || searchInput.offsetHeight > 0)) {
              this.setFocus(searchInput);
              return;
            }
          }

          // Escaping rightmost favorite tab into filter & sort button:
          if (dir === 'RIGHT' && (group.id === 'favorites-tabs' || group.closest('#favorites-tabs'))) {
            const favFilterBtn = document.getElementById('btn-filter-sort-favorites');
            if (favFilterBtn && this.visible(favFilterBtn)) {
              this.setFocus(favFilterBtn);
              return;
            }
          }
          return;
        }
      }

      const inModal = this.focused.closest('.series-detail-card, #movie-files-modal, #vk-overlay, #movie-resume-modal, #series-resume-modal, #continue-context-modal, #fullscreen-trailer-modal, #series-cast-modal, #recap-modal, #remote-modal, #admin-edit-modal, #season-picker-modal, .season-picker-card, #filter-sort-modal, .filter-sort-card');

      const currentRect = this.focused.getBoundingClientRect();
      const currentCenter = { 
          x: currentRect.left + currentRect.width / 2, 
          y: currentRect.top + currentRect.height / 2 
      };

      // ═════════════════════════════════════════════════════════════════════
      // 1.5. STRICT MODAL FOCUS TRAP: Directional nav must NEVER escape modal!
      // ═════════════════════════════════════════════════════════════════════
      if (inModal) {
        const modalContainer = inModal.closest('#season-picker-modal, #movie-files-modal, #movie-resume-modal, #series-resume-modal, #continue-context-modal, #fullscreen-trailer-modal, #series-cast-modal, #recap-modal, #remote-modal, #admin-edit-modal, #filter-sort-modal') || inModal;

        // ── SPECIALIZED LOGIC FOR ORDENAR Y FILTRAR MODAL (#filter-sort-modal) ──
        const isFilterSortModal = !!modalContainer.closest('#filter-sort-modal, .filter-sort-card') || modalContainer.id === 'filter-sort-modal';
        if (isFilterSortModal) {
          const resetBtn = modalContainer.querySelector('#btn-filter-reset');
          const applyBtn = modalContainer.querySelector('#btn-filter-apply');
          const closeBtn = modalContainer.querySelector('#filter-modal-close, .modal-close-btn');
          const sortPills = Array.from(modalContainer.querySelectorAll('#sort-options .filter-pill')).filter(el => this.visible(el));
          const yearPills = Array.from(modalContainer.querySelectorAll('#year-filter-options .filter-pill')).filter(el => this.visible(el));

          const pickClosestX = (elements, targetX) => {
            if (!elements || elements.length === 0) return null;
            let best = elements[0];
            let bestDist = Infinity;
            for (let el of elements) {
              const r = el.getBoundingClientRect();
              const cx = r.left + r.width / 2;
              const d = Math.abs(cx - targetX);
              if (d < bestDist) {
                bestDist = d;
                best = el;
              }
            }
            return best;
          };

          // 1. From Restablecer (btn-filter-reset)
          if (this.focused === resetBtn) {
            if (dir === 'RIGHT') {
              if (applyBtn && this.visible(applyBtn)) {
                this.setFocus(applyBtn);
                this.ensureVisible(applyBtn);
                return;
              }
            } else if (dir === 'UP') {
              if (yearPills.length > 0) {
                const maxY = Math.max(...yearPills.map(p => p.getBoundingClientRect().top));
                const bottomRow = yearPills.filter(p => Math.abs(p.getBoundingClientRect().top - maxY) <= 15);
                const bestPill = pickClosestX(bottomRow.length > 0 ? bottomRow : yearPills, currentCenter.x);
                if (bestPill) {
                  this.setFocus(bestPill);
                  this.ensureVisible(bestPill);
                  return;
                }
              }
            }
            return; // boundary
          }

          // 2. From Aplicar filtros (btn-filter-apply)
          if (this.focused === applyBtn) {
            if (dir === 'LEFT') {
              if (resetBtn && this.visible(resetBtn)) {
                this.setFocus(resetBtn);
                this.ensureVisible(resetBtn);
                return;
              }
            } else if (dir === 'UP') {
              if (yearPills.length > 0) {
                const maxY = Math.max(...yearPills.map(p => p.getBoundingClientRect().top));
                const bottomRow = yearPills.filter(p => Math.abs(p.getBoundingClientRect().top - maxY) <= 15);
                const bestPill = pickClosestX(bottomRow.length > 0 ? bottomRow : yearPills, currentCenter.x);
                if (bestPill) {
                  this.setFocus(bestPill);
                  this.ensureVisible(bestPill);
                  return;
                }
              }
            }
            return; // boundary
          }

          // 3. From Close button
          if (this.focused === closeBtn) {
            if (dir === 'DOWN' || dir === 'LEFT') {
              if (sortPills.length > 0) {
                const minY = Math.min(...sortPills.map(p => p.getBoundingClientRect().top));
                const topRow = sortPills.filter(p => Math.abs(p.getBoundingClientRect().top - minY) <= 15);
                const bestPill = pickClosestX(topRow.length > 0 ? topRow : sortPills, currentCenter.x);
                if (bestPill) {
                  this.setFocus(bestPill);
                  this.ensureVisible(bestPill);
                  return;
                }
              }
            }
            return;
          }

          // 4. From Year Pills
          if (yearPills.includes(this.focused)) {
            if (dir === 'DOWN') {
              const below = yearPills.filter(p => p.getBoundingClientRect().top > currentRect.bottom - 5);
              if (below.length > 0) {
                const minY = Math.min(...below.map(p => p.getBoundingClientRect().top));
                const nextRow = below.filter(p => Math.abs(p.getBoundingClientRect().top - minY) <= 15);
                const best = pickClosestX(nextRow, currentCenter.x);
                if (best) {
                  this.setFocus(best);
                  this.ensureVisible(best);
                  return;
                }
              } else {
                // Bottom row of year pills -> transition to Action Buttons!
                const mRect = modalContainer.getBoundingClientRect();
                const targetBtn = (currentCenter.x < (mRect.left + mRect.width * 0.55)) ? resetBtn : applyBtn;
                const chosen = (targetBtn && this.visible(targetBtn)) ? targetBtn : (applyBtn || resetBtn);
                if (chosen) {
                  this.setFocus(chosen);
                  this.ensureVisible(chosen);
                  return;
                }
              }
            } else if (dir === 'UP') {
              const above = yearPills.filter(p => p.getBoundingClientRect().bottom < currentRect.top + 5);
              if (above.length > 0) {
                const maxY = Math.max(...above.map(p => p.getBoundingClientRect().top));
                const prevRow = above.filter(p => Math.abs(p.getBoundingClientRect().top - maxY) <= 15);
                const best = pickClosestX(prevRow, currentCenter.x);
                if (best) {
                  this.setFocus(best);
                  this.ensureVisible(best);
                  return;
                }
              } else {
                // Top row of year pills -> transition to bottom row of Sort Pills!
                if (sortPills.length > 0) {
                  const maxY = Math.max(...sortPills.map(p => p.getBoundingClientRect().top));
                  const bottomRow = sortPills.filter(p => Math.abs(p.getBoundingClientRect().top - maxY) <= 15);
                  const best = pickClosestX(bottomRow.length > 0 ? bottomRow : sortPills, currentCenter.x);
                  if (best) {
                    this.setFocus(best);
                    this.ensureVisible(best);
                    return;
                  }
                }
              }
            } else if (dir === 'RIGHT') {
              const sameRowRight = yearPills.filter(p => 
                Math.abs(p.getBoundingClientRect().top - currentRect.top) <= 15 &&
                p.getBoundingClientRect().left >= currentRect.right - 5
              );
              if (sameRowRight.length > 0) {
                sameRowRight.sort((a, b) => a.getBoundingClientRect().left - b.getBoundingClientRect().left);
                this.setFocus(sameRowRight[0]);
                this.ensureVisible(sameRowRight[0]);
                return;
              }
              // Row wrap: jump to start of next row if available
              const below = yearPills.filter(p => p.getBoundingClientRect().top > currentRect.bottom - 5);
              if (below.length > 0) {
                below.sort((a, b) => (a.getBoundingClientRect().top - b.getBoundingClientRect().top) || (a.getBoundingClientRect().left - b.getBoundingClientRect().left));
                this.setFocus(below[0]);
                this.ensureVisible(below[0]);
                return;
              }
              // End of all year pills: wrap to reset button
              if (resetBtn && this.visible(resetBtn)) {
                this.setFocus(resetBtn);
                this.ensureVisible(resetBtn);
                return;
              }
            } else if (dir === 'LEFT') {
              const sameRowLeft = yearPills.filter(p => 
                Math.abs(p.getBoundingClientRect().top - currentRect.top) <= 15 &&
                p.getBoundingClientRect().right <= currentRect.left + 5
              );
              if (sameRowLeft.length > 0) {
                sameRowLeft.sort((a, b) => b.getBoundingClientRect().right - a.getBoundingClientRect().right);
                this.setFocus(sameRowLeft[0]);
                this.ensureVisible(sameRowLeft[0]);
                return;
              }
              // Row wrap: jump to end of previous row
              const above = yearPills.filter(p => p.getBoundingClientRect().bottom < currentRect.top + 5);
              if (above.length > 0) {
                above.sort((a, b) => (b.getBoundingClientRect().top - a.getBoundingClientRect().top) || (b.getBoundingClientRect().right - a.getBoundingClientRect().right));
                this.setFocus(above[0]);
                this.ensureVisible(above[0]);
                return;
              }
            }
          }

          // 5. From Sort Pills
          if (sortPills.includes(this.focused)) {
            if (dir === 'DOWN') {
              const below = sortPills.filter(p => p.getBoundingClientRect().top > currentRect.bottom - 5);
              if (below.length > 0) {
                const minY = Math.min(...below.map(p => p.getBoundingClientRect().top));
                const nextRow = below.filter(p => Math.abs(p.getBoundingClientRect().top - minY) <= 15);
                const best = pickClosestX(nextRow, currentCenter.x);
                if (best) {
                  this.setFocus(best);
                  this.ensureVisible(best);
                  return;
                }
              } else {
                // Bottom row of sort pills -> transition to top row of Year Pills!
                if (yearPills.length > 0) {
                  const minY = Math.min(...yearPills.map(p => p.getBoundingClientRect().top));
                  const topRow = yearPills.filter(p => Math.abs(p.getBoundingClientRect().top - minY) <= 15);
                  const best = pickClosestX(topRow.length > 0 ? topRow : yearPills, currentCenter.x);
                  if (best) {
                    this.setFocus(best);
                    this.ensureVisible(best);
                    return;
                  }
                }
              }
            } else if (dir === 'UP') {
              const above = sortPills.filter(p => p.getBoundingClientRect().bottom < currentRect.top + 5);
              if (above.length > 0) {
                const maxY = Math.max(...above.map(p => p.getBoundingClientRect().top));
                const prevRow = above.filter(p => Math.abs(p.getBoundingClientRect().top - maxY) <= 15);
                const best = pickClosestX(prevRow, currentCenter.x);
                if (best) {
                  this.setFocus(best);
                  this.ensureVisible(best);
                  return;
                }
              } else {
                // Top row of sort pills -> jump to close button!
                if (closeBtn && this.visible(closeBtn)) {
                  this.setFocus(closeBtn);
                  this.ensureVisible(closeBtn);
                  return;
                }
              }
            } else if (dir === 'RIGHT') {
              const sameRowRight = sortPills.filter(p => 
                Math.abs(p.getBoundingClientRect().top - currentRect.top) <= 15 &&
                p.getBoundingClientRect().left >= currentRect.right - 5
              );
              if (sameRowRight.length > 0) {
                sameRowRight.sort((a, b) => a.getBoundingClientRect().left - b.getBoundingClientRect().left);
                this.setFocus(sameRowRight[0]);
                this.ensureVisible(sameRowRight[0]);
                return;
              }
              // Row wrap: jump to start of next row
              const below = sortPills.filter(p => p.getBoundingClientRect().top > currentRect.bottom - 5);
              if (below.length > 0) {
                below.sort((a, b) => (a.getBoundingClientRect().top - b.getBoundingClientRect().top) || (a.getBoundingClientRect().left - b.getBoundingClientRect().left));
                this.setFocus(below[0]);
                this.ensureVisible(below[0]);
                return;
              }
              // Wrap into year pills
              if (yearPills.length > 0) {
                this.setFocus(yearPills[0]);
                this.ensureVisible(yearPills[0]);
                return;
              }
            } else if (dir === 'LEFT') {
              const sameRowLeft = sortPills.filter(p => 
                Math.abs(p.getBoundingClientRect().top - currentRect.top) <= 15 &&
                p.getBoundingClientRect().right <= currentRect.left + 5
              );
              if (sameRowLeft.length > 0) {
                sameRowLeft.sort((a, b) => b.getBoundingClientRect().right - a.getBoundingClientRect().right);
                this.setFocus(sameRowLeft[0]);
                this.ensureVisible(sameRowLeft[0]);
                return;
              }
              // Row wrap: jump to end of previous row
              const above = sortPills.filter(p => p.getBoundingClientRect().bottom < currentRect.top + 5);
              if (above.length > 0) {
                above.sort((a, b) => (b.getBoundingClientRect().top - a.getBoundingClientRect().top) || (b.getBoundingClientRect().right - a.getBoundingClientRect().right));
                this.setFocus(above[0]);
                this.ensureVisible(above[0]);
                return;
              }
            }
          }
        }

        // ── GENERAL MODAL SPATIAL CANDIDATE SEARCH WITH DIRECTIONAL WEIGHTING ──
        const modalElements = Array.from(modalContainer.querySelectorAll('[tabindex="0"], button, input, textarea, a[href]'))
          .filter(el => el.getAttribute('tabindex') !== '-1' && this.visible(el));

        if (modalElements.length > 0) {
          const validModalCandidates = [];
          for (let el of modalElements) {
            if (el === this.focused) continue;
            const rect = el.getBoundingClientRect();
            const center = { x: rect.left + rect.width / 2, y: rect.top + rect.height / 2 };
            if (dir === 'UP' && center.y >= currentCenter.y - 5) continue;
            if (dir === 'DOWN' && center.y <= currentCenter.y + 5) continue;
            if (dir === 'LEFT' && center.x >= currentCenter.x - 5) continue;
            if (dir === 'RIGHT' && center.x <= currentCenter.x + 5) continue;
            validModalCandidates.push({ el, rect, center });
          }

          if (validModalCandidates.length > 0) {
            let best = null;
            let bestScore = Infinity;
            for (let item of validModalCandidates) {
              const dx = Math.abs(item.center.x - currentCenter.x);
              const dy = Math.abs(item.center.y - currentCenter.y);
              // Strongly penalize perpendicular movement to prevent erratic jumps across rows/columns
              let score;
              if (dir === 'LEFT' || dir === 'RIGHT') {
                score = Math.sqrt(dx * dx + (dy * 6) * (dy * 6));
              } else {
                score = Math.sqrt((dx * 2) * (dx * 2) + dy * dy);
              }
              if (score < bestScore) {
                bestScore = score;
                best = item.el;
              }
            }
            if (best) {
              this.setFocus(best);
              this.ensureVisible(best);
              return;
            }
          }

          // Directional boundaries inside modal:
          if (dir === 'UP') {
            const closeBtn = modalContainer.querySelector('.modal-close-btn, .recap-close-btn, .btn-close, #season-picker-close, #filter-modal-close');
            if (closeBtn && this.visible(closeBtn) && this.focused !== closeBtn) {
              this.setFocus(closeBtn);
              this.ensureVisible(closeBtn);
              return;
            }
          }
          if (dir === 'DOWN') {
            const options = Array.from(modalContainer.querySelectorAll('.season-option-btn, .resume-btn, .movie-file-item, .filter-pill, .btn-modal-primary, .btn-modal-secondary, button'))
              .filter(b => this.visible(b) && !b.classList.contains('modal-close-btn') && !b.classList.contains('recap-close-btn') && b.id !== 'season-picker-close' && b.id !== 'filter-modal-close');
            if (options.length > 0 && this.focused !== options[0]) {
              this.setFocus(options[0]);
              this.ensureVisible(options[0]);
              return;
            }
          }

          // Modal scroll support if content overflows:
          const scrollContainer = this.focused.closest('.season-picker-options, .modal-body, .recap-modal-card, .resume-options, .modal-card, .filter-sort-body');
          if (scrollContainer && scrollContainer.scrollHeight > scrollContainer.clientHeight) {
            const scrollAmount = dir === 'DOWN' ? 120 : -120;
            scrollContainer.scrollBy({ top: scrollAmount, behavior: 'smooth' });
          }
        }
        // STRICT TRAP: NEVER allow escaping modal to background views!
        return;
      }

      // ═════════════════════════════════════════════════════════════════════
      // 2. STRUCTURED UI BAND TRANSITIONS (View-scoped outside modals)
      // ═════════════════════════════════════════════════════════════════════
      if (!inModal) {
        // Helper: pick closest element horizontally from an array
        const pickClosestX = (elements) => {
          if (!elements || elements.length === 0) return null;
          let best = elements[0];
          let bestDist = Infinity;
          for (let el of elements) {
            const r = el.getBoundingClientRect();
            const cx = r.left + r.width / 2;
            const dist = Math.abs(cx - currentCenter.x);
            if (dist < bestDist) {
              bestDist = dist;
              best = el;
            }
          }
          return best;
        };

        const activeView = this.focused.closest('#views-viewport > .view, .view') ||
                           document.querySelector('#views-viewport > .view.active, #view-catalog.active, #view-movies.active, #view-favorites.active, #view-platforms.active, .view.active');

        if (activeView) {
          const navTabsCont = document.querySelector('#main-nav-bar .nav-links, #main-nav-bar .nav-tabs, #main-nav-bar') || activeView.querySelector('.nav-tabs');
          const genreTabsCont = activeView.querySelector('.genre-tabs, #favorites-tabs, .genre-tabs-bar, #platform-genre-tabs');
          const heroCont = activeView.querySelector('#movies-hero, #catalog-hero, .hero-section');
          const heroBtn = activeView.querySelector('#hero-play-btn, #movies-hero-play-btn, .hero-btn-primary') || (heroCont ? heroCont.querySelector('button') : null);
          const continueCont = activeView.querySelector('#continue-watching-series, #continue-watching-movies');
          const rowsCont = activeView.querySelector('#catalog-rows, #movies-rows, #platform-results-container');
          const searchInput = document.querySelector('#search-input');
          const searchClearBtn = document.querySelector('#search-clear-btn');
          const topbarActions = document.querySelector('#main-topbar .topbar-actions') || activeView.querySelector('.topbar-actions');
          const gridCont = activeView.querySelector('#search-results, #movies-search-results, #favorites-grid, #platforms-grid, #platform-all-grid, .catalog-grid');

          const isHeroBtn = !!(this.focused && (
            this.focused === heroBtn ||
            this.focused.id === 'movies-hero-info-btn' ||
            this.focused.id === 'hero-info-btn' ||
            this.focused.closest('.hero-buttons, .hero-section')
          ));
          const inGenreTabs = !!(genreTabsCont && genreTabsCont.contains(this.focused));
          const inContinueRow = !!(continueCont && continueCont.contains(this.focused));
          const inCatalogRows = !!(rowsCont && rowsCont.contains(this.focused));
          const inContentRow = inCatalogRows ? this.focused.closest('.content-row') : null;
          const inNavTabs = !!(navTabsCont && navTabsCont.contains(this.focused));
          const isSearchInput = !!(searchInput && this.focused === searchInput);
          const isSearchClearBtn = !!(searchClearBtn && this.focused === searchClearBtn);
          const inTopbarActions = !!(topbarActions && topbarActions.contains(this.focused));
          const inGrid = !!(gridCont && gridCont.contains(this.focused) && !inCatalogRows && !inContinueRow);
          const platformSubnav = activeView.querySelector('#platform-subnav');
          const inPlatformSubnav = !!(platformSubnav && platformSubnav.contains(this.focused));
          const platformBackBtn = activeView.querySelector('#btn-back-platforms');
          const isPlatformBackBtn = !!(platformBackBtn && this.focused === platformBackBtn);
          const isViewAllBtn = !!(this.focused && this.focused.classList.contains('btn-view-all'));

          // Helper: get first populated row cards from a catalog rows container
          const getFirstPopulatedRowCards = (container) => {
            if (!container) return [];
            const rows = Array.from(container.querySelectorAll('.content-row')).filter(r => this.visible(r));
            for (const r of rows) {
              const cards = Array.from(r.querySelectorAll('.series-card, .movie-card, .continue-card')).filter(c => this.visible(c));
              if (cards.length > 0) return cards;
            }
            return [];
          };

          // A0. FROM FAVORITES FILTER/SORT BUTTON:
          const isFavFilterBtn = !!(this.focused && this.focused.id === 'btn-filter-sort-favorites');
          if (isFavFilterBtn) {
            if (dir === 'LEFT') {
              const favTabs = genreTabsCont ? Array.from(genreTabsCont.querySelectorAll('.genre-tab, button')).filter(t => this.visible(t)) : [];
              const target = favTabs[favTabs.length - 1] || favTabs[0];
              if (target) { this.setFocus(target); return; }
            } else if (dir === 'DOWN') {
              const favGrid = activeView.querySelector('#favorites-grid');
              if (favGrid && this.visible(favGrid)) {
                const cards = Array.from(favGrid.querySelectorAll('.series-card, .movie-card')).filter(c => this.visible(c));
                if (cards.length > 0) {
                  const target = pickClosestX(cards) || cards[0];
                  this.setFocus(target);
                  return;
                }
              }
            } else if (dir === 'UP') {
              const topbarNav = document.querySelector('#main-nav-bar, .main-nav');
              const navBtns = topbarNav ? Array.from(topbarNav.querySelectorAll('.nav-link, .main-nav-btn, button')).filter(b => this.visible(b)) : [];
              const target = pickClosestX(navBtns) || navBtns.find(b => b.classList.contains('active')) || navBtns[0];
              if (target) { this.setFocus(target); return; }
            }
            return;
          }

          // A. FROM TOPBAR ACTIONS:
          if (inTopbarActions) {
            if (dir === 'DOWN') {
              if (heroBtn && this.visible(heroBtn)) { this.setFocus(heroBtn); return; }
              if (genreTabsCont && this.visible(genreTabsCont)) {
                const tabs = Array.from(genreTabsCont.querySelectorAll('.genre-tab, button')).filter(t => this.visible(t));
                const target = tabs.find(t => t.classList.contains('active')) || pickClosestX(tabs);
                if (target) { this.setFocus(target); return; }
              }
              if (continueCont && this.visible(continueCont)) {
                const continueCards = Array.from(continueCont.querySelectorAll('.series-card, .continue-card, .movie-card')).filter(c => this.visible(c));
                if (continueCards.length > 0) {
                  const target = pickClosestX(continueCards);
                  if (target) { this.setFocus(target); return; }
                }
              }
              const firstCards = getFirstPopulatedRowCards(rowsCont);
              if (firstCards.length > 0) {
                const target = pickClosestX(firstCards);
                if (target) { this.setFocus(target); return; }
              }
            } else if (dir === 'LEFT') {
              const actionBtns = Array.from(topbarActions.querySelectorAll('button')).filter(b => this.visible(b));
              const idx = actionBtns.indexOf(this.focused);
              if (idx > 0) {
                this.setFocus(actionBtns[idx - 1]);
                return;
              } else if (searchClearBtn && this.visible(searchClearBtn) && !searchClearBtn.classList.contains('hidden')) {
                this.setFocus(searchClearBtn);
                return;
              } else if (searchInput && this.visible(searchInput)) {
                this.setFocus(searchInput);
                return;
              } else if (navTabsCont) {
                const navBtns = Array.from(navTabsCont.querySelectorAll('.main-nav-btn, .nav-link, button')).filter(b => this.visible(b));
                if (navBtns.length > 0) { this.setFocus(navBtns[navBtns.length - 1]); return; }
              }
            } else if (dir === 'RIGHT') {
              const actionBtns = Array.from(topbarActions.querySelectorAll('button')).filter(b => this.visible(b));
              const idx = actionBtns.indexOf(this.focused);
              if (idx !== -1 && idx < actionBtns.length - 1) {
                this.setFocus(actionBtns[idx + 1]);
                return;
              }
            }
          }

          // B. FROM SEARCH INPUT:
          if (isSearchInput) {
            if (dir === 'DOWN') {
              const candidates = [];
              if (genreTabsCont && this.visible(genreTabsCont)) {
                const tabs = Array.from(genreTabsCont.querySelectorAll('.genre-tab, button')).filter(t => this.visible(t));
                candidates.push(...tabs);
              }
              if (continueCont && this.visible(continueCont)) {
                const continueCards = Array.from(continueCont.querySelectorAll('.series-card, .continue-card, .movie-card')).filter(c => this.visible(c));
                candidates.push(...continueCards);
              }
              const firstCards = getFirstPopulatedRowCards(rowsCont);
              candidates.push(...firstCards);
              if (gridCont && this.visible(gridCont)) {
                const gridCards = Array.from(gridCont.querySelectorAll('.series-card, .movie-card')).filter(c => this.visible(c));
                candidates.push(...gridCards);
              }
              if (heroBtn && this.visible(heroBtn)) candidates.push(heroBtn);
              const target = pickClosestX(candidates);
              if (target) { this.setFocus(target); return; }
            } else if (dir === 'LEFT') {
              if (navTabsCont) {
                const navBtns = Array.from(navTabsCont.querySelectorAll('.main-nav-btn, .nav-link, button')).filter(b => this.visible(b));
                if (navBtns.length > 0) {
                  this.setFocus(navBtns[navBtns.length - 1]);
                  return;
                }
              }
            } else if (dir === 'RIGHT') {
              if (searchClearBtn && this.visible(searchClearBtn) && !searchClearBtn.classList.contains('hidden')) {
                this.setFocus(searchClearBtn);
                return;
              }
              if (topbarActions) {
                const actionBtns = Array.from(topbarActions.querySelectorAll('button')).filter(b => this.visible(b));
                if (actionBtns.length > 0) { this.setFocus(actionBtns[0]); return; }
              }
            }
          }

          // B.2 FROM SEARCH CLEAR BUTTON:
          if (isSearchClearBtn) {
            if (dir === 'LEFT') {
              if (searchInput && this.visible(searchInput)) {
                this.setFocus(searchInput);
                return;
              }
            } else if (dir === 'RIGHT') {
              if (topbarActions) {
                const actionBtns = Array.from(topbarActions.querySelectorAll('button')).filter(b => this.visible(b));
                if (actionBtns.length > 0) { this.setFocus(actionBtns[0]); return; }
              }
            } else if (dir === 'DOWN') {
              const candidates = [];
              if (genreTabsCont && this.visible(genreTabsCont)) {
                const tabs = Array.from(genreTabsCont.querySelectorAll('.genre-tab, button')).filter(t => this.visible(t));
                candidates.push(...tabs);
              }
              if (continueCont && this.visible(continueCont)) {
                const continueCards = Array.from(continueCont.querySelectorAll('.series-card, .continue-card, .movie-card')).filter(c => this.visible(c));
                candidates.push(...continueCards);
              }
              const firstCards = getFirstPopulatedRowCards(rowsCont);
              candidates.push(...firstCards);
              if (gridCont && this.visible(gridCont)) {
                const gridCards = Array.from(gridCont.querySelectorAll('.series-card, .movie-card')).filter(c => this.visible(c));
                candidates.push(...gridCards);
              }
              if (heroBtn && this.visible(heroBtn)) candidates.push(heroBtn);
              const target = pickClosestX(candidates);
              if (target) { this.setFocus(target); return; }
            }
          }

          // C. FROM NAV TABS:
          if (inNavTabs) {
            if (dir === 'RIGHT') {
              const navBtns = Array.from(navTabsCont.querySelectorAll('.main-nav-btn, .nav-link, button')).filter(b => this.visible(b));
              const idx = navBtns.indexOf(this.focused);
              if (idx !== -1 && idx < navBtns.length - 1) {
                this.setFocus(navBtns[idx + 1]);
                return;
              } else if (idx === navBtns.length - 1) {
                if (searchInput && this.visible(searchInput)) {
                  this.setFocus(searchInput);
                  return;
                } else if (topbarActions) {
                  const actionBtns = Array.from(topbarActions.querySelectorAll('button')).filter(b => this.visible(b));
                  if (actionBtns.length > 0) { this.setFocus(actionBtns[0]); return; }
                }
              }
            } else if (dir === 'LEFT') {
              const navBtns = Array.from(navTabsCont.querySelectorAll('.main-nav-btn, .nav-link, button')).filter(b => this.visible(b));
              const idx = navBtns.indexOf(this.focused);
              if (idx > 0) {
                this.setFocus(navBtns[idx - 1]);
                return;
              }
            } else if (dir === 'UP') {
              return; // Top edge
            } else if (dir === 'DOWN') {
              // 0. Platform subnav if inside platforms view with content visible
              if (platformSubnav && this.visible(platformSubnav) && !platformSubnav.classList.contains('hidden')) {
                const subBtns = Array.from(platformSubnav.querySelectorAll('.main-nav-btn, button')).filter(b => this.visible(b));
                const target = subBtns.find(b => b.classList.contains('active')) || pickClosestX(subBtns);
                if (target) { this.setFocus(target); return; }
              }
              // 1. Hero button
              if (heroBtn && this.visible(heroBtn)) {
                this.setFocus(heroBtn);
                return;
              }
              // 2. Genre tabs
              if (genreTabsCont && this.visible(genreTabsCont)) {
                const tabs = Array.from(genreTabsCont.querySelectorAll('.genre-tab, button')).filter(t => this.visible(t));
                const target = tabs.find(t => t.classList.contains('active')) || pickClosestX(tabs);
                if (target) { this.setFocus(target); return; }
              }
              // 3. Continue watching
              if (continueCont && this.visible(continueCont)) {
                const continueCards = Array.from(continueCont.querySelectorAll('.series-card, .continue-card, .movie-card')).filter(c => this.visible(c));
                if (continueCards.length > 0) {
                  const target = pickClosestX(continueCards);
                  if (target) { this.setFocus(target); return; }
                }
              }
              // 4. Content rows
              const firstCards = getFirstPopulatedRowCards(rowsCont);
              if (firstCards.length > 0) {
                const target = pickClosestX(firstCards);
                if (target) { this.setFocus(target); return; }
              }
              // 5. Grid or platform cards (platforms, favorites, etc.)
              if (gridCont && this.visible(gridCont)) {
                const cards = Array.from(gridCont.querySelectorAll('.platform-card, .series-card, .movie-card, .continue-card, [tabindex="0"], button')).filter(c => this.visible(c));
                if (cards.length > 0) {
                  const target = pickClosestX(cards);
                  if (target) { this.setFocus(target); return; }
                }
              }
            }
          }

          // DEDICATED SERIES VIEW NAVIGATION (#view-series)
          const seriesViewCheckEl = document.getElementById('view-series');
          const isSeriesView = (activeView && activeView.id === 'view-series') ||
                               !!(seriesViewCheckEl && seriesViewCheckEl.classList.contains('active'));
          if (isSeriesView) {
            const seriesViewEl = document.getElementById('view-series');
            const seriesBackBtn = seriesViewEl.querySelector('#btn-back-catalog, .btn-back');
            const seriesHeroSection = seriesViewEl.querySelector('.series-hero-section');
            const heroBtns = seriesHeroSection ? Array.from(seriesHeroSection.querySelectorAll('button')).filter(b => this.visible(b)) : [];
            const seriesPlayBtn = seriesViewEl.querySelector('#series-hero-play');
            const seasonSelect = seriesViewEl.querySelector('#series-season-select');
            const altVersionBtn = seriesViewEl.querySelector('#btn-alt-version');
            const recapBtn = seriesViewEl.querySelector('.btn-recap');
            const seasonBarItems = [seasonSelect, altVersionBtn, recapBtn].filter(el => el && this.visible(el));
            const episodesTrack = seriesViewEl.querySelector('#series-episodes-track');
            const epCards = episodesTrack ? Array.from(episodesTrack.querySelectorAll('.episode-card-h')).filter(c => this.visible(c)) : [];

            // From Series Back Button:
            if (this.focused === seriesBackBtn) {
              if (dir === 'DOWN') {
                if (seriesPlayBtn && this.visible(seriesPlayBtn)) { this.setFocus(seriesPlayBtn); return; }
                if (heroBtns.length > 0) { this.setFocus(heroBtns[0]); return; }
                if (seasonSelect && this.visible(seasonSelect)) { this.setFocus(seasonSelect); return; }
              }
              return;
            }

            // From Hero Buttons (Play, Trailer, Fav, Cast, Prev, Next):
            if (heroBtns.includes(this.focused)) {
              if (dir === 'UP') {
                if (seriesBackBtn && this.visible(seriesBackBtn)) { this.setFocus(seriesBackBtn); return; }
              } else if (dir === 'DOWN') {
                if (seasonSelect && this.visible(seasonSelect)) { this.setFocus(seasonSelect); return; }
                if (epCards.length > 0) { const target = pickClosestX(epCards); if (target) { this.setFocus(target); return; } }
              } else if (dir === 'LEFT') {
                const idx = heroBtns.indexOf(this.focused);
                if (idx > 0) { this.setFocus(heroBtns[idx - 1]); return; }
              } else if (dir === 'RIGHT') {
                const idx = heroBtns.indexOf(this.focused);
                if (idx < heroBtns.length - 1) { this.setFocus(heroBtns[idx + 1]); return; }
              }
              return;
            }

            // From Season Selector bar items (Dropdown, Alt version, Recap):
            if (seasonBarItems.includes(this.focused)) {
              if (dir === 'UP') {
                if (seriesPlayBtn && this.visible(seriesPlayBtn)) { this.setFocus(seriesPlayBtn); return; }
                if (heroBtns.length > 0) { this.setFocus(heroBtns[0]); return; }
                if (seriesBackBtn && this.visible(seriesBackBtn)) { this.setFocus(seriesBackBtn); return; }
              } else if (dir === 'DOWN') {
                if (epCards.length > 0) {
                  const target = pickClosestX(epCards) || epCards[0];
                  if (target) { this.setFocus(target); return; }
                }
              } else if (dir === 'LEFT') {
                const idx = seasonBarItems.indexOf(this.focused);
                if (idx > 0) { this.setFocus(seasonBarItems[idx - 1]); return; }
              } else if (dir === 'RIGHT') {
                const idx = seasonBarItems.indexOf(this.focused);
                if (idx < seasonBarItems.length - 1) { this.setFocus(seasonBarItems[idx + 1]); return; }
              }
              return;
            }

            // From Episode Cards:
            if (epCards.includes(this.focused)) {
              if (dir === 'UP') {
                if (seasonSelect && this.visible(seasonSelect)) { this.setFocus(seasonSelect); return; }
                if (seriesPlayBtn && this.visible(seriesPlayBtn)) { this.setFocus(seriesPlayBtn); return; }
              } else if (dir === 'LEFT') {
                const idx = epCards.indexOf(this.focused);
                if (idx > 0) { this.setFocus(epCards[idx - 1]); return; }
              } else if (dir === 'RIGHT') {
                const idx = epCards.indexOf(this.focused);
                if (idx < epCards.length - 1) { this.setFocus(epCards[idx + 1]); return; }
              }
              return;
            }
          }

          // PLATFORM SUBNAV (🎬 Películas / 📺 Series inside platform view):
          if (inPlatformSubnav) {
            const subBtns = Array.from(platformSubnav.querySelectorAll('.main-nav-btn, button')).filter(b => this.visible(b));
            const idx = subBtns.indexOf(this.focused);
            if (dir === 'LEFT') {
              if (idx > 0) {
                this.setFocus(subBtns[idx - 1]);
                return;
              } else if (platformBackBtn && this.visible(platformBackBtn)) {
                this.setFocus(platformBackBtn);
                return;
              }
            } else if (dir === 'RIGHT') {
              if (idx !== -1 && idx < subBtns.length - 1) {
                this.setFocus(subBtns[idx + 1]);
                return;
              }
            } else if (dir === 'DOWN') {
              if (genreTabsCont && this.visible(genreTabsCont)) {
                const tabs = Array.from(genreTabsCont.querySelectorAll('.genre-tab, button')).filter(t => this.visible(t));
                const target = tabs.find(t => t.classList.contains('active')) || pickClosestX(tabs);
                if (target) { this.setFocus(target); return; }
              }
              const firstCards = getFirstPopulatedRowCards(rowsCont);
              const firstRow = rowsCont ? rowsCont.querySelector('.content-row') : null;
              const firstViewAll = firstRow ? firstRow.querySelector('.btn-view-all') : null;
              const downCandidates = [...firstCards];
              if (firstViewAll && this.visible(firstViewAll)) downCandidates.push(firstViewAll);
              if (downCandidates.length > 0) {
                const target = pickClosestX(downCandidates);
                if (target) { this.setFocus(target); return; }
              }
            } else if (dir === 'UP') {
              const topbarNav = document.querySelector('#main-nav-bar, .main-nav');
              const navBtns = topbarNav ? Array.from(topbarNav.querySelectorAll('.nav-link, .main-nav-btn, button')).filter(b => this.visible(b)) : [];
              const target = navBtns.find(b => b.id === 'nav-platforms' || b.classList.contains('active')) || pickClosestX(navBtns);
              if (target) { this.setFocus(target); return; }
            }
            return;
          }

          // PLATFORM BACK BUTTON (← Back to platforms list):
          if (isPlatformBackBtn) {
            if (dir === 'RIGHT') {
              if (platformSubnav && this.visible(platformSubnav) && !platformSubnav.classList.contains('hidden')) {
                const subBtns = Array.from(platformSubnav.querySelectorAll('.main-nav-btn, button')).filter(b => this.visible(b));
                const target = subBtns.find(b => b.classList.contains('active')) || subBtns[0];
                if (target) { this.setFocus(target); return; }
              }
            } else if (dir === 'DOWN') {
              if (genreTabsCont && this.visible(genreTabsCont) && !genreTabsCont.classList.contains('hidden')) {
                const tabs = Array.from(genreTabsCont.querySelectorAll('.genre-tab, button')).filter(t => this.visible(t));
                const target = tabs[0];
                if (target) { this.setFocus(target); return; }
              }
              // If in "Ver todo" (allGrid visible) or genreTabs hidden:
              const allGrid = activeView.querySelector('#platform-all-grid');
              if (allGrid && this.visible(allGrid) && !allGrid.classList.contains('hidden')) {
                const cards = Array.from(allGrid.querySelectorAll('.series-card, .movie-card')).filter(c => this.visible(c));
                if (cards.length > 0) { this.setFocus(cards[0]); return; }
              }
              // If in platform results container:
              const resultsCont = activeView.querySelector('#platform-results-container');
              if (resultsCont && this.visible(resultsCont)) {
                const cards = getFirstPopulatedRowCards(resultsCont);
                if (cards.length > 0) { this.setFocus(cards[0]); return; }
              }
            } else if (dir === 'UP') {
              const topbarNav = document.querySelector('#main-nav-bar, .main-nav');
              const navBtns = topbarNav ? Array.from(topbarNav.querySelectorAll('.nav-link, .main-nav-btn, button')).filter(b => this.visible(b)) : [];
              const target = navBtns.find(b => b.id === 'nav-platforms' || b.classList.contains('active')) || navBtns[0];
              if (target) { this.setFocus(target); return; }
            }
            return;
          }

          // D. FROM GENRE TABS:
          if (inGenreTabs) {
            if (dir === 'UP') {
              const tabRect = this.focused.getBoundingClientRect();
              // 0. Platform subnav (🎬 Películas / 📺 Series) or back button if inside platforms view!
              if (platformSubnav && this.visible(platformSubnav) && !platformSubnav.classList.contains('hidden')) {
                const subBtns = Array.from(platformSubnav.querySelectorAll('.main-nav-btn, button')).filter(b => this.visible(b));
                const target = subBtns.find(b => b.classList.contains('active')) || pickClosestX(subBtns);
                if (target) { this.setFocus(target); return; }
              }
              if (platformBackBtn && this.visible(platformBackBtn) && tabRect.left < 100) {
                this.setFocus(platformBackBtn);
                return;
              }
              // 1. Hero button if visible and physically on left half of screen
              if (heroBtn && this.visible(heroBtn) && tabRect.left < (window.innerWidth || 1920) * 0.45) {
                this.setFocus(heroBtn);
                return;
              }
              // 2. Topbar elements: nav buttons, search input, action buttons
              const topbarNav = document.querySelector('#main-nav-bar, .main-nav');
              const navBtns = topbarNav ? Array.from(topbarNav.querySelectorAll('.nav-link, .main-nav-btn, button')).filter(b => this.visible(b)) : [];
              const actionBtns = topbarActions ? Array.from(topbarActions.querySelectorAll('button')).filter(b => this.visible(b)) : [];
              const allTopbar = [...navBtns];
              if (searchInput && this.visible(searchInput)) allTopbar.push(searchInput);
              allTopbar.push(...actionBtns);
              const target = pickClosestX(allTopbar) || navBtns.find(b => b.classList.contains('active')) || navBtns[0];
              if (target) { this.setFocus(target); return; }
            } else if (dir === 'DOWN') {
              // 1. Search / Genre results grid if active
              const searchResults = activeView.querySelector('#search-results, #movies-search-results');
              if (searchResults && this.visible(searchResults) && !searchResults.classList.contains('hidden') && window.getComputedStyle(searchResults).display !== 'none') {
                const gridCards = Array.from(searchResults.querySelectorAll('.series-card, .movie-card')).filter(c => this.visible(c));
                const target = pickClosestX(gridCards);
                if (target) { this.setFocus(target); return; }
              }
              // 2. Continue watching
              if (continueCont && this.visible(continueCont)) {
                const continueCards = Array.from(continueCont.querySelectorAll('.series-card, .continue-card, .movie-card')).filter(c => this.visible(c));
                if (continueCards.length > 0) {
                  const target = pickClosestX(continueCards);
                  if (target) { this.setFocus(target); return; }
                }
              }
              // 3. Content rows
              const firstCards = getFirstPopulatedRowCards(rowsCont);
              const firstRow = rowsCont ? rowsCont.querySelector('.content-row') : null;
              const firstViewAll = firstRow ? firstRow.querySelector('.btn-view-all') : null;
              const downCandidates = [...firstCards];
              if (firstViewAll && this.visible(firstViewAll)) downCandidates.push(firstViewAll);
              if (downCandidates.length > 0) {
                const target = pickClosestX(downCandidates);
                if (target) { this.setFocus(target); return; }
              }
              // 4. Grid container (e.g. favorites)
              if (gridCont && this.visible(gridCont)) {
                const gridCards = Array.from(gridCont.querySelectorAll('.series-card, .movie-card')).filter(c => this.visible(c));
                const target = pickClosestX(gridCards);
                if (target) { this.setFocus(target); return; }
              }
            }
          }

          // E. FROM HERO BUTTONS:
          if (isHeroBtn) {
            if (dir === 'UP') {
              // Directly up to Topbar: pick closest element among nav buttons, search input, and action buttons
              const topbarNav = document.querySelector('#main-nav-bar, .main-nav');
              const navBtns = topbarNav ? Array.from(topbarNav.querySelectorAll('.nav-link, .main-nav-btn, button')).filter(b => this.visible(b)) : [];
              const actionBtns = topbarActions ? Array.from(topbarActions.querySelectorAll('button')).filter(b => this.visible(b)) : [];
              const allTopbar = [...navBtns];
              if (searchInput && this.visible(searchInput)) allTopbar.push(searchInput);
              allTopbar.push(...actionBtns);
              const target = pickClosestX(allTopbar) || navBtns.find(b => b.classList.contains('active')) || navBtns[0];
              if (target) { this.setFocus(target); return; }
            } else if (dir === 'DOWN') {
              // 1. Genre tabs below hero
              if (genreTabsCont && this.visible(genreTabsCont)) {
                const tabs = Array.from(genreTabsCont.querySelectorAll('.genre-tab, button')).filter(t => this.visible(t));
                const target = tabs.find(t => t.classList.contains('active')) || pickClosestX(tabs);
                if (target) { this.setFocus(target); return; }
              }
              // 2. Continue watching
              if (continueCont && this.visible(continueCont)) {
                const continueCards = Array.from(continueCont.querySelectorAll('.series-card, .continue-card, .movie-card')).filter(c => this.visible(c));
                if (continueCards.length > 0) {
                  const target = pickClosestX(continueCards);
                  if (target) { this.setFocus(target); return; }
                }
              }
              // 3. Content rows
              const firstCards = getFirstPopulatedRowCards(rowsCont);
              if (firstCards.length > 0) {
                const target = pickClosestX(firstCards);
                if (target) { this.setFocus(target); return; }
              }
            } else if (dir === 'LEFT' || dir === 'RIGHT') {
              const heroButtonsGroup = this.focused.closest('.hero-buttons, .series-hero-actions');
              if (heroButtonsGroup) {
                const btns = Array.from(heroButtonsGroup.querySelectorAll('button')).filter(b => this.visible(b));
                const idx = btns.indexOf(this.focused);
                if (idx !== -1) {
                  if (dir === 'LEFT' && idx > 0) { this.setFocus(btns[idx - 1]); return; }
                  if (dir === 'RIGHT' && idx < btns.length - 1) { this.setFocus(btns[idx + 1]); return; }
                }
              }
              return;
            }
          }

          // F. FROM CONTINUE WATCHING ROW:
          if (inContinueRow) {
            if (dir === 'UP') {
              // 1. Genre tabs (Genre tabs are right above continue watching!)
              if (genreTabsCont && this.visible(genreTabsCont)) {
                const tabs = Array.from(genreTabsCont.querySelectorAll('.genre-tab, button')).filter(t => this.visible(t));
                const target = tabs.find(t => t.classList.contains('active')) || pickClosestX(tabs);
                if (target) { this.setFocus(target); return; }
              }
              // 2. Hero button
              if (heroBtn && this.visible(heroBtn)) {
                this.setFocus(heroBtn);
                return;
              }
              // 3. Nav tabs
              if (navTabsCont && this.visible(navTabsCont)) {
                const navBtns = Array.from(navTabsCont.querySelectorAll('.main-nav-btn, .nav-link, button')).filter(b => this.visible(b));
                const target = navBtns.find(b => b.classList.contains('active')) || pickClosestX(navBtns);
                if (target) { this.setFocus(target); return; }
              }
            } else if (dir === 'DOWN') {
              // Move directly into first populated content row of rowsCont
              const firstCards = getFirstPopulatedRowCards(rowsCont);
              if (firstCards.length > 0) {
                const target = pickClosestX(firstCards);
                if (target) { this.setFocus(target); return; }
              }
            }
          }

          // G.1 FROM VIEW-ALL BUTTON IN ROWS (e.g. inside platform view)
          if (isViewAllBtn && inContentRow) {
            const rows = Array.from(rowsCont.querySelectorAll('.content-row')).filter(r => this.visible(r));
            const rowIdx = rows.indexOf(inContentRow);

            if (dir === 'DOWN') {
              // Focus the card directly below "Ver todo" in the SAME row:
              const curCards = Array.from(inContentRow.querySelectorAll('.series-card, .movie-card, .continue-card')).filter(c => this.visible(c));
              if (curCards.length > 0) {
                const target = pickClosestX(curCards);
                if (target) { this.setFocus(target); return; }
              }
              for (let i = rowIdx + 1; i < rows.length; i++) {
                const nextCards = Array.from(rows[i].querySelectorAll('.series-card, .movie-card')).filter(c => this.visible(c));
                if (nextCards.length > 0) {
                  const target = pickClosestX(nextCards);
                  if (target) { this.setFocus(target); return; }
                }
              }
            } else if (dir === 'UP') {
              // 1. Move to previous row's "Ver todo" button or cards:
              if (rowIdx > 0) {
                const prevRow = rows[rowIdx - 1];
                const prevViewAll = prevRow.querySelector('.btn-view-all');
                if (prevViewAll && this.visible(prevViewAll)) {
                  this.setFocus(prevViewAll);
                  return;
                }
                const prevCards = Array.from(prevRow.querySelectorAll('.series-card, .movie-card')).filter(c => this.visible(c));
                if (prevCards.length > 0) {
                  const target = pickClosestX(prevCards);
                  if (target) { this.setFocus(target); return; }
                }
              }
              // 2. If at top-most row: move UP to genre tabs or platform subnav
              if (genreTabsCont && this.visible(genreTabsCont)) {
                const tabs = Array.from(genreTabsCont.querySelectorAll('.genre-tab, button')).filter(t => this.visible(t));
                const target = pickClosestX(tabs) || tabs[tabs.length - 1];
                if (target) { this.setFocus(target); return; }
              }
              if (platformSubnav && this.visible(platformSubnav)) {
                const subBtns = Array.from(platformSubnav.querySelectorAll('button')).filter(b => this.visible(b));
                const target = pickClosestX(subBtns) || subBtns[subBtns.length - 1];
                if (target) { this.setFocus(target); return; }
              }
            } else if (dir === 'LEFT') {
              // Move LEFT: focus the cards of this row
              const curCards = Array.from(inContentRow.querySelectorAll('.series-card, .movie-card, .continue-card')).filter(c => this.visible(c));
              if (curCards.length > 0) {
                this.setFocus(curCards[0]);
                return;
              }
            } else if (dir === 'RIGHT') {
              return;
            }
            return;
          }

          // G.2 FROM CONTENT ROWS (inside #catalog-rows, #movies-rows, or #platform-results-container):
          if (inCatalogRows && inContentRow && !isViewAllBtn) {
            const rows = Array.from(rowsCont.querySelectorAll('.content-row')).filter(r => this.visible(r));
            const rowIdx = rows.indexOf(inContentRow);

            if (dir === 'UP') {
              const viewAllBtn = inContentRow.querySelector('.btn-view-all');
              const cardRect = this.focused.getBoundingClientRect();
              const cardCenterX = cardRect.left + cardRect.width / 2;

              // If this row has a visible "Ver todo" button and the card is towards the right side of the screen
              // (or if in row 0 and card is not on the far-left edge), go to "Ver todo"!
              if (viewAllBtn && this.visible(viewAllBtn)) {
                const isRightBiased = cardCenterX >= ((window.innerWidth || 1920) * 0.35) || (rowIdx === 0 && cardCenterX >= 180);
                if (isRightBiased) {
                  this.setFocus(viewAllBtn);
                  return;
                }
              }

              for (let i = rowIdx - 1; i >= 0; i--) {
                const prevRow = rows[i];
                const prevViewAll = prevRow.querySelector('.btn-view-all');
                if (prevViewAll && this.visible(prevViewAll) && cardCenterX >= ((window.innerWidth || 1920) * 0.5)) {
                  this.setFocus(prevViewAll);
                  return;
                }
                const prevCards = Array.from(prevRow.querySelectorAll('.series-card, .movie-card')).filter(c => this.visible(c));
                if (prevCards.length > 0) {
                  const target = pickClosestX(prevCards);
                  if (target) { this.setFocus(target); return; }
                }
              }

              // Reached top-most content row:
              if (rowIdx === 0 && viewAllBtn && this.visible(viewAllBtn) && cardCenterX >= 150) {
                this.setFocus(viewAllBtn);
                return;
              }

              // 1. Continue watching:
              if (continueCont && this.visible(continueCont)) {
                const continueCards = Array.from(continueCont.querySelectorAll('.series-card, .continue-card, .movie-card')).filter(c => this.visible(c));
                if (continueCards.length > 0) {
                  const target = pickClosestX(continueCards);
                  if (target) { this.setFocus(target); return; }
                }
              }
              // 2. Genre tabs:
              if (genreTabsCont && this.visible(genreTabsCont)) {
                const tabs = Array.from(genreTabsCont.querySelectorAll('.genre-tab, button')).filter(t => this.visible(t));
                const target = tabs.find(t => t.classList.contains('active')) || pickClosestX(tabs);
                if (target) { this.setFocus(target); return; }
              }
              // 2b. Platform subnav:
              if (platformSubnav && this.visible(platformSubnav) && !platformSubnav.classList.contains('hidden')) {
                const subBtns = Array.from(platformSubnav.querySelectorAll('.main-nav-btn, button')).filter(b => this.visible(b));
                const target = subBtns.find(b => b.classList.contains('active')) || pickClosestX(subBtns);
                if (target) { this.setFocus(target); return; }
              }
              // 3. Hero button:
              if (heroBtn && this.visible(heroBtn)) {
                this.setFocus(heroBtn);
                return;
              }
              // 4. Nav tabs:
              if (navTabsCont && this.visible(navTabsCont)) {
                const navBtns = Array.from(navTabsCont.querySelectorAll('.main-nav-btn, .nav-link, button')).filter(b => this.visible(b));
                const target = navBtns.find(b => b.classList.contains('active')) || pickClosestX(navBtns);
                if (target) { this.setFocus(target); return; }
              }
            } else if (dir === 'DOWN') {
              for (let i = rowIdx + 1; i < rows.length; i++) {
                const nextCards = Array.from(rows[i].querySelectorAll('.series-card, .movie-card')).filter(c => this.visible(c));
                if (nextCards.length > 0) {
                  const target = pickClosestX(nextCards);
                  if (target) { this.setFocus(target); return; }
                }
              }
            }
          }

          // H. FROM GRID (outside catalog rows & continue row):
          if (inGrid && dir === 'UP') {
            const allGridCards = Array.from(gridCont.querySelectorAll('.platform-card, .series-card, .movie-card, .continue-card, [tabindex="0"]')).filter(c => this.visible(c));
            const hasAbove = allGridCards.some(c => {
              const cr = c.getBoundingClientRect();
              return (cr.top + cr.height / 2) < (currentCenter.y - 20);
            });
            if (!hasAbove) {
              // Top row of grid: move to genre tabs, favorites filter button, platform subnav, back button, or nav tabs
              const favFilterBtn = activeView.querySelector('#btn-filter-sort-favorites');
              if (genreTabsCont && this.visible(genreTabsCont)) {
                const tabs = Array.from(genreTabsCont.querySelectorAll('.genre-tab, button')).filter(t => this.visible(t));
                const candidates = [...tabs];
                if (favFilterBtn && this.visible(favFilterBtn)) candidates.push(favFilterBtn);
                const target = pickClosestX(candidates) || tabs.find(t => t.classList.contains('active')) || tabs[0];
                if (target) { this.setFocus(target); return; }
              } else if (favFilterBtn && this.visible(favFilterBtn)) {
                this.setFocus(favFilterBtn);
                return;
              }
              const platformSubnav = activeView.querySelector('#platform-subnav');
              if (platformSubnav && this.visible(platformSubnav)) {
                const subBtns = Array.from(platformSubnav.querySelectorAll('button')).filter(b => this.visible(b));
                const target = subBtns.find(b => b.classList.contains('active')) || pickClosestX(subBtns);
                if (target) { this.setFocus(target); return; }
              }
              const platformBackBtn = activeView.querySelector('#btn-back-platforms');
              if (platformBackBtn && this.visible(platformBackBtn)) {
                this.setFocus(platformBackBtn);
                return;
              }
              if (navTabsCont && this.visible(navTabsCont)) {
                const navBtns = Array.from(navTabsCont.querySelectorAll('.main-nav-btn, button')).filter(b => this.visible(b));
                const target = navBtns.find(b => b.classList.contains('active')) || pickClosestX(navBtns);
                if (target) { this.setFocus(target); return; }
              }
            }
          }
        }
      }

      // ═════════════════════════════════════════════════════════════════════
      // 3. GENERAL SPATIAL NAVIGATION WITH ROW-BANDING (Fallback for grids & modals)
      // ═════════════════════════════════════════════════════════════════════
      const candidates = this.getNavigableElements();
      if (candidates.length === 0) return;

      const targetX = currentCenter.x;
      const validCandidates = [];

      for (let el of candidates) {
        if (el === this.focused) continue;

        // CRITICAL SAFETY: Never jump to topbar actions from content or nav
        if (el.closest('.topbar-actions') && !this.focused.closest('.topbar')) {
          continue;
        }

        // CRITICAL SAFETY: Never jump into topbar when moving UP unless already in header/nav
        if (el.closest('.topbar') && dir === 'UP' && !this.focused.closest('.topbar, .main-nav')) {
          continue;
        }

        const rect = el.getBoundingClientRect();
        const center = { x: rect.left + rect.width / 2, y: rect.top + rect.height / 2 };
        
        // Direction filter
        if (dir === 'UP' && center.y >= currentCenter.y - 5) continue;
        if (dir === 'DOWN' && center.y <= currentCenter.y + 5) continue;
        if (dir === 'LEFT' && center.x >= currentCenter.x - 5) continue;
        if (dir === 'RIGHT' && center.x <= currentCenter.x + 5) continue;

        // Horizontal navigation must never jump rows:
        if (dir === 'LEFT' || dir === 'RIGHT') {
          const vOverlap = Math.max(0, Math.min(currentRect.bottom, rect.bottom) - Math.max(currentRect.top, rect.top));
          const vDist = Math.abs(center.y - currentCenter.y);
          if (vOverlap <= 0 && vDist > 40) continue;
        }

        validCandidates.push({ el, rect, center });
      }

      if (validCandidates.length === 0) {
        if (dir === 'DOWN' || dir === 'UP') {
          const scrollContainer = this.focused && (
            this.focused.closest('#view-actor-profile, #view-actor-results, .series-detail-card, .modal-card, #views-viewport > .view.active') ||
            document.querySelector('#view-actor-profile.active, #view-actor-results.active')
          );
          if (scrollContainer && scrollContainer.scrollHeight > scrollContainer.clientHeight) {
            const scrollAmount = dir === 'DOWN' ? 200 : -200;
            scrollContainer.scrollBy({ top: scrollAmount, behavior: 'smooth' });
          }
        }
        return;
      }

      // ROW-BANDING for UP / DOWN: Strictly favor the nearest adjacent row band
      if (dir === 'UP' || dir === 'DOWN') {
        let minVDist = Infinity;
        for (let item of validCandidates) {
          const vDist = Math.abs(item.center.y - currentCenter.y);
          if (vDist < minVDist) minVDist = vDist;
        }

        const rowBandCandidates = validCandidates.filter(item => {
          return Math.abs(item.center.y - currentCenter.y) <= minVDist + 80;
        });

        let bestCandidate = null;
        let bestScore = Infinity;

        for (let item of (rowBandCandidates.length > 0 ? rowBandCandidates : validCandidates)) {
          const dx = Math.abs(item.center.x - targetX);
          const dy = Math.abs(item.center.y - currentCenter.y);
          const score = Math.sqrt(dx * dx + dy * dy);

          if (score < bestScore) {
            bestScore = score;
            bestCandidate = item.el;
          }
        }

        if (bestCandidate) {
          this.setFocus(bestCandidate);
          return;
        }
      }

      // Horizontal fallback
      let bestCandidate = null;
      let bestScore = Infinity;

      for (let item of validCandidates) {
        let dx = Math.abs(item.center.x - targetX);
        let dy = Math.abs(item.center.y - currentCenter.y);
        dy *= 8;
        let score = Math.sqrt(dx * dx + dy * dy);

        if (score < bestScore) {
          bestScore = score;
          bestCandidate = item.el;
        }
      }

      if (bestCandidate) {
        this.setFocus(bestCandidate);
      } else if (dir === 'DOWN' || dir === 'UP') {
        const scrollContainer = this.focused && (
          this.focused.closest('#view-actor-profile, #view-actor-results, .series-detail-card, .modal-card, #views-viewport > .view.active') ||
          document.querySelector('#view-actor-profile.active, #view-actor-results.active')
        );
        if (scrollContainer && scrollContainer.scrollHeight > scrollContainer.clientHeight) {
          const scrollAmount = dir === 'DOWN' ? 200 : -200;
          scrollContainer.scrollBy({ top: scrollAmount, behavior: 'smooth' });
        }
      }
    }

    getNavigableElements() {
      let root = document.body;
      
      const openModals = Array.from(document.querySelectorAll('.series-detail-card, #movie-files-modal, #vk-overlay, #movie-resume-modal, #series-resume-modal, #continue-context-modal, #fullscreen-trailer-modal, #series-cast-modal, #recap-modal, #remote-modal, #admin-edit-modal, #season-picker-modal, .season-picker-card, #filter-sort-modal, .filter-sort-card')).filter(m => this.visible(m) && !m.classList.contains('hidden'));
      if (openModals.length > 0) {
        root = openModals[openModals.length - 1];
      }

      const elements = Array.from(root.querySelectorAll('[tabindex="0"], button, input, textarea, a[href]'));
      return elements.filter(el => el.getAttribute('tabindex') !== '-1' && this.visible(el));
    }

    visible(el) {
      if (!el || !el.isConnected) return false;
      // Fast path: if dimensions are 0 (e.g. display:none or collapsed), skip expensive getComputedStyle
      if (el.offsetWidth === 0 && el.offsetHeight === 0) {
        return false;
      }
      const cs = window.getComputedStyle(el);
      
      if (cs.display === 'none' || cs.visibility === 'hidden' || cs.opacity === '0') {
          return false;
      }
      
      const r = el.getBoundingClientRect();
      return r.width > 0 && r.height > 0;
    }

    setFocus(el) {
      if (!el) return;
      this._prevFocused = this.focused;
      if (this.focused && this.focused !== el) {
        this.focused.classList.remove('tv-focused', 'tv-input-active');
        const prevSearchBox = this.focused.closest && this.focused.closest('.topbar-search');
        if (prevSearchBox) prevSearchBox.classList.remove('tv-focused');
        // Clean up catalog-grid inline styles from previous focused card
        if (this.focused.classList.contains('series-card') && this.focused.closest && this.focused.closest('.catalog-grid')) {
          this.focused.style.cssText = '';
          const pqv = this.focused.querySelector('.series-card-quickview');
          if (pqv) pqv.style.cssText = '';
          const pmain = this.focused.querySelector('.series-card-main');
          if (pmain) pmain.style.cssText = '';
        }
      }

      // Clear tv-focused from all other elements in the DOM to prevent stuck/ghost focus
      document.querySelectorAll('.tv-focused').forEach(node => {
        if (node !== el) node.classList.remove('tv-focused', 'tv-input-active');
      });
      
      this.focused = el;
      
      this.focusedKey = 
          el.dataset.id || 
          el.dataset.seriesId || 
          el.dataset.movieId || 
          el.id || 
          null;
          
      if (this.isTV()) {
        el.classList.add('tv-focused');
        const searchBox = el.closest && el.closest('.topbar-search');
        if (searchBox) searchBox.classList.add('tv-focused');

        // Force vertical curtain for catalog-grid cards via inline styles
        // to guarantee correct behavior regardless of CSS cascade/specificity
        if (el.classList.contains('series-card') && el.closest('.catalog-grid')) {
          el.style.cssText += ';flex-direction:column!important;width:125px!important;min-width:125px!important;max-width:125px!important;margin-right:0!important;margin-left:0!important;';
          const qv = el.querySelector('.series-card-quickview');
          if (qv) {
            qv.style.cssText += ';position:absolute!important;inset:0!important;width:100%!important;height:100%!important;min-width:unset!important;transform:translateY(0)!important;opacity:1!important;pointer-events:auto!important;border-left:none!important;display:flex!important;flex-direction:column!important;';
          }
          const main = el.querySelector('.series-card-main');
          if (main) {
            main.style.cssText += ';width:100%!important;min-width:0!important;max-width:none!important;flex-direction:column!important;';
          }
        }
      }
      
      // Synopsis auto-scroll for focused card after 3 seconds:
      if (this._synopsisScrollInterval) {
        clearInterval(this._synopsisScrollInterval);
        this._synopsisScrollInterval = null;
      }
      if (this._synopsisScrollTimeout) {
        clearTimeout(this._synopsisScrollTimeout);
        this._synopsisScrollTimeout = null;
      }
      if (this._prevOverviewEl) {
        this._prevOverviewEl.scrollTop = 0;
        this._prevOverviewEl = null;
      }

      const overviewEl = el.querySelector && el.querySelector('.quickview-overview');
      if (overviewEl) {
        this._prevOverviewEl = overviewEl;
        overviewEl.scrollTop = 0;
        this._synopsisScrollTimeout = setTimeout(() => {
          if (this.focused === el && overviewEl.scrollHeight > overviewEl.clientHeight) {
            this._synopsisScrollInterval = setInterval(() => {
              if (this.focused !== el) {
                clearInterval(this._synopsisScrollInterval);
                return;
              }
              if (overviewEl.scrollTop < overviewEl.scrollHeight - overviewEl.clientHeight) {
                overviewEl.scrollTop += 1;
              } else {
                clearInterval(this._synopsisScrollInterval);
              }
            }, 60);
          }
        }, 3000);
      }

      // Transfer native focus so browser doesn't keep active focus on search input.
      // In TV mode or for cards/rows, DO NOT call native el.focus() because Android WebView
      // forces an unpreventable scroll (requestChildRectangleOnScreen) that overrides spatial navigation and cuts off row headers.
      if (typeof el.focus === 'function' && el.tagName !== 'INPUT' && el.tagName !== 'TEXTAREA') {
        if (!this._longPressLocked && !el.closest('#continue-context-modal') && !this.isTV() && !el.closest('.content-row, .catalog-grid, .row-cards')) {
          try { el.focus({ preventScroll: true }); } catch (e) { try { el.focus(); } catch (e2) {} }
        }
      }

      // Exit inputMode if moving to a non-input element
      if (this.inputMode && el.tagName !== 'INPUT' && el.tagName !== 'TEXTAREA') {
        this.exitInputMode();
      }

      this.ensureVisible(el);

      // Blur any focused input so native keyboard doesn't pop up
      if (document.activeElement && (document.activeElement.tagName === 'INPUT' || document.activeElement.tagName === 'TEXTAREA')) {
        if (el !== document.activeElement) {
          document.activeElement.blur();
        }
      }
      
      clearTimeout(this.navigationTimer);
      this.navigationTimer = setTimeout(() => {
          this.navigationInProgress = false;
      }, 150);
    }

    ensureVisible(el) {
      if (!el) return;
      if (el.closest('#vk-overlay')) return; // Virtual keyboard is a fixed overlay, never scroll background

      // 1. HORIZONTAL: scroll parent container if it has horizontal scroll (.genre-tabs, .row-cards, .nav-tabs, .series-detail-cast, .series-episodes-carousel)
      const scrollContainer = el.closest('.genre-tabs, .row-cards, .nav-tabs, .series-detail-cast, .series-episodes-carousel');
      if (scrollContainer) {
        const elRect = el.getBoundingClientRect();
        const contRect = scrollContainer.getBoundingClientRect();
        const isEpisodeCarousel = scrollContainer.classList.contains('series-episodes-carousel');
        const pad = isEpisodeCarousel ? 160 : 60;
        
        // When card in row-cards expands to the right (width ~330px), ensure right side accommodates 215px drawer
        const isRowCard = el.classList.contains('series-card') && el.closest('.row-cards');
        const targetRight = isRowCard ? (elRect.left + 335) : elRect.right;
        
        if (elRect.left < contRect.left + pad) {
          scrollContainer.scrollLeft -= (contRect.left + pad - elRect.left);
        } else if (targetRight > contRect.right - pad) {
          scrollContainer.scrollLeft += (targetRight - (contRect.right - pad));
        }
      }

      // HORIZONTAL NAVIGATION GUARD:
      // If moving horizontally (LEFT/RIGHT) within a horizontal row or card container, NEVER scroll the vertical page!
      const prevCards = this._prevFocused && this._prevFocused.closest && this._prevFocused.closest('.row-cards, .series-episodes-carousel, .series-detail-cast');
      const currCards = el.closest && el.closest('.row-cards, .series-episodes-carousel, .series-detail-cast');
      if (prevCards && currCards && prevCards === currCards) {
        if (this._lastNavDir !== 'UP' && this._lastNavDir !== 'DOWN') {
          return;
        }
      }
      const isHorizontalNav = (this._lastNavDir === 'LEFT' || this._lastNavDir === 'RIGHT');
      const prevRow = this._prevFocused && this._prevFocused.closest && this._prevFocused.closest('.content-row, .row-cards, .genre-tabs, .nav-tabs, .nav-links, .series-episodes-carousel, .series-detail-cast, .hero-buttons, .series-hero-actions');
      const currRow = el.closest && el.closest('.content-row, .row-cards, .genre-tabs, .nav-tabs, .nav-links, .series-episodes-carousel, .series-detail-cast, .hero-buttons, .series-hero-actions');
      if (isHorizontalNav && prevRow && currRow && prevRow === currRow) {
        return;
      }
      
      // 2. MODAL SCROLL: If inside detail modal (.series-detail-card, .modal-card, .recap-modal-card, .series-cast-card), scroll the modal directly
      const modal = el.closest('.series-detail-card, .modal-card, .recap-modal-card, .series-cast-card, .filter-sort-card, .filter-sort-body');
      if (modal) {
        const scrollTarget = el.closest('.filter-sort-body') || modal;
        const mRect = scrollTarget.getBoundingClientRect();
        const elRect = el.getBoundingClientRect();
        const pad = 40;
        if (elRect.top < mRect.top + pad) {
          scrollTarget.scrollTop -= (mRect.top + pad - elRect.top);
        } else if (elRect.bottom > mRect.bottom - pad) {
          scrollTarget.scrollTop += (elRect.bottom - (mRect.bottom - pad));
        }
        return;
      }

      // 3. EPISODES & SEASONS LIST SCROLL: Direct dedicated scroll for chapter lists
      const scrollList = el.closest('.episodes-list, .seasons-list, #episodes-list, #seasons-list');
      if (scrollList) {
        const sRect = scrollList.getBoundingClientRect();
        const elRect = el.getBoundingClientRect();
        const pad = 80;
        if (elRect.top < sRect.top + pad) {
          scrollList.scrollTop -= (sRect.top + pad - elRect.top);
        } else if (elRect.bottom > sRect.bottom - pad) {
          scrollList.scrollTop += (elRect.bottom - (sRect.bottom - pad));
        }
        return;
      }

      // 4. MAIN VIEW SCROLL: Scroll active view container or fallback to window
      const activeView = el.closest('#views-viewport > .view, #view-series, #view-episodes, #view-catalog, #view-movies, #view-favorites, #view-platforms, #view-my-content, #view-continue, #view-actor-profile, #view-actor-results') ||
                         document.querySelector('#views-viewport > .view.active, #view-series.active, #view-episodes.active, #view-catalog.active, #view-movies.active, #view-favorites.active, #view-platforms.active, #view-actor-profile.active, #view-actor-results.active');

      // 4a. If focus moved to Topbar, Nav Bar, Hero, or Platform header, smoothly reset scroll to top!
      if (el.closest('.topbar, .main-nav, #main-topbar, #main-nav-bar, .hero-section, #catalog-hero, #movies-hero, .series-hero-section, #series-hero, #btn-back-platforms, .platform-content-header, #platform-subnav')) {
        if (activeView && activeView.scrollTop > 0) {
          activeView.scrollTo({ top: 0, behavior: 'smooth' });
        } else if (!activeView && window.scrollY > 0) {
          window.scrollTo({ top: 0, behavior: 'smooth' });
        }
        return;
      }

      // Calculate where the top navigation bar/genre tabs end (in screen coordinates)
      const navBar = document.getElementById('main-nav-bar') || document.querySelector('.main-nav');
      const topbar = document.getElementById('main-topbar') || document.querySelector('.topbar');
      const genreTabs = (activeView && activeView.querySelector('.genre-tabs:not(.hidden), #platform-genre-tabs:not(.hidden), #favorites-tabs:not(.hidden)')) || document.querySelector('.genre-tabs:not(.hidden)');
      let topNavBottom = 0;
      if (genreTabs && this.visible(genreTabs) && genreTabs.offsetHeight > 0) {
        const gtRect = genreTabs.getBoundingClientRect();
        // Genre tabs is only a top obstacle if it is docked/sticky near the top of the viewport
        if (gtRect.top <= 80) {
          topNavBottom = Math.max(topNavBottom, gtRect.bottom);
        }
      }
      if (navBar && this.visible(navBar)) {
        topNavBottom = Math.max(topNavBottom, navBar.getBoundingClientRect().bottom);
      } else if (topbar && this.visible(topbar)) {
        topNavBottom = Math.max(topNavBottom, topbar.getBoundingClientRect().bottom);
      }
      if (topNavBottom <= 0) topNavBottom = 70;
      // Top nav safe boundary should not exceed 100px on TV
      topNavBottom = Math.min(topNavBottom, 100);

      // Safe top and bottom margins with breathing room (extra headroom on TV so cards never touch headers)
      const safeTop = topNavBottom + (this.isTV() ? 16 : 12);
      const safeBottom = window.innerHeight - (this.isTV() ? 16 : 24);

      // 4b. CONTENT ROW SCROLL:
      // When navigating rows on TV or mobile, frame the ENTIRE row so row header and card titles are fully visible!
      const contentRow = el.closest('.content-row');
      if (contentRow) {
        const rowRect = contentRow.getBoundingClientRect();
        const cardRect = el.getBoundingClientRect();

        let scrollY = 0;
        // 1. If row header is cut off or above the safe line, scroll UP so header is visible
        if (rowRect.top < safeTop) {
          scrollY = rowRect.top - safeTop;
        } else if (cardRect.bottom > safeBottom) {
          // 2. If card (including poster & title below it) is cut off at bottom, scroll DOWN
          const dockAtTopScroll = rowRect.top - safeTop;
          const cardBottomAfterDock = cardRect.bottom - dockAtTopScroll;
          if (cardBottomAfterDock <= safeBottom) {
            // Docking row header at safeTop fits both the header and the entire card
            scrollY = dockAtTopScroll;
          } else {
            // Screen is compact: prioritize card bottom (title + metadata) so it is never cut off
            scrollY = cardRect.bottom - safeBottom;
          }
        } else if (this.isTV() && this._lastNavDir === 'DOWN' && rowRect.top > safeTop + 50) {
          // On TV, when navigating down to a row below safeTop, dock row header cleanly at safeTop
          const dockAtTopScroll = rowRect.top - safeTop;
          const cardBottomAfterDock = cardRect.bottom - dockAtTopScroll;
          if (cardBottomAfterDock <= safeBottom) {
            scrollY = dockAtTopScroll;
          }
        }

        if (Math.abs(scrollY) > 2) {
          if (activeView && activeView.scrollHeight > activeView.clientHeight) {
            activeView.scrollBy({ top: scrollY, behavior: 'smooth' });
          } else {
            window.scrollBy({ top: scrollY, behavior: 'smooth' });
          }
        }
        return;
      }

      // 4c. GENERAL ELEMENT SCROLL (Genre tabs, Grid items, etc.)
      const r = el.getBoundingClientRect();
      let scrollY = 0;
      if (r.top < safeTop) {
        scrollY = r.top - safeTop;
      } else if (r.bottom > safeBottom) {
        scrollY = r.bottom - safeBottom;
      }

      if (Math.abs(scrollY) > 2) {
        if (activeView && activeView.scrollHeight > activeView.clientHeight) {
          activeView.scrollBy({ top: scrollY, behavior: 'smooth' });
        } else {
          window.scrollBy({ top: scrollY, behavior: 'smooth' });
        }
      }
    }

    confirm() {
      if (this._longPressLocked) {
        console.log('[TV-NAV] confirm blocked: longPressLocked');
        return;
      }
      if (!this.focused) { this.focusFirst(); return; }

      if (this.focused.tagName === 'INPUT' || this.focused.tagName === 'TEXTAREA') {
        const isTV = !isDesktopPC() && (typeof window.isTVForKeyboard === 'function' ? window.isTVForKeyboard() : !!(window._cineflixIsTV || window.__appPlatform === 'android_tv' || document.body.classList.contains('is-tv')));
        if (isTV && typeof window.openVirtualKeyboard === 'function') {
            window.openVirtualKeyboard(this.focused);
            return;
        }

        this.focused.focus();
        this.focused.click();
        
        if (document.activeElement === this.focused) {
            this.inputMode = true;
            this.focused.classList.add('tv-input-active');
        }
      } else {
        const target = this.focused;
        if (target.id === 'search-clear-btn' || target.classList.contains('search-clear-btn')) {
          try { target.click(); } catch (err) {}
          setTimeout(() => {
            const si = document.getElementById('search-input');
            if (si) this.setFocus(si);
          }, 60);
          return;
        }
        if (target.id === 'series-season-select' || target.classList.contains('season-select-dropdown')) {
          if (typeof window.openSeasonPicker === 'function') {
            window.openSeasonPicker();
            return;
          }
        }
        if (typeof target.click === 'function') {
          try { target.click(); } catch (err) { console.warn('[TV-NAV] click error', err); }
        } else if (typeof target.onclick === 'function') {
          try { target.onclick(null); } catch (err) { console.warn('[TV-NAV] onclick error', err); }
        }
      }
    }

    exitInputMode() {
      this.inputMode = false;
      if (this.focused) {
        this.focused.classList.remove('tv-input-active');
        this.focused.blur();
      }
    }

    back() {
      if (window.__cineflixBack) {
        const handled = window.__cineflixBack();
        if (handled) {
          setTimeout(() => {
            if (!this.focused || !document.body.contains(this.focused) || !this.visible(this.focused)) {
              if (this.hasSavedFocus()) {
                this.restoreFocus();
              } else {
                this.focusFirst();
              }
            }
          }, 150);
        }
      }
    }
    
    saveFocus(contextName = '') {
      if (!this.focusStack) this.focusStack = [];

      let scrollEl = null;
      let scrollTop = 0;
      let scrollLeft = 0;

      const activeView = (this.focused && this.focused.closest && this.focused.closest('.view, #views-viewport > .view')) ||
                         document.querySelector('#views-viewport > .view.active') ||
                         document.querySelector('.view.active');

      if (this.focused) {
        scrollEl = this.focused.closest('.view, .catalog-grid, .modal-card, .series-detail-card, .episodes-list, .seasons-list, .row-cards') ||
                   activeView;
        if (scrollEl) {
          scrollTop = scrollEl.scrollTop;
          scrollLeft = scrollEl.scrollLeft;
        }
      } else {
        if (activeView) {
          scrollEl = activeView;
          scrollTop = activeView.scrollTop;
          scrollLeft = activeView.scrollLeft;
        }
      }

      let key = this.focusedKey || 
                (this.focused ? (this.focused.dataset.id || this.focused.dataset.seriesId || this.focused.dataset.movieId || this.focused.id) : null);

      if (!key && document.activeElement && document.activeElement !== document.body) {
        key = (document.activeElement.dataset && document.activeElement.dataset.id) || document.activeElement.id || null;
      }

      const state = {
        key: key,
        el: this.focused || (document.activeElement !== document.body ? document.activeElement : null),
        scrollEl: scrollEl || activeView,
        scrollTop: (scrollEl ? scrollEl.scrollTop : (activeView ? activeView.scrollTop : 0)),
        scrollLeft: scrollLeft,
        windowScrollY: window.scrollY || 0,
        viewId: (activeView && activeView.id) || null,
        context: contextName,
        time: Date.now()
      };

      // Don't push identical duplicate consecutive states
      const last = this.focusStack[this.focusStack.length - 1];
      if (!last || last.key !== state.key || last.viewId !== state.viewId || Math.abs((last.scrollTop || 0) - state.scrollTop) > 20) {
        this.focusStack.push(state);
        if (this.focusStack.length > 20) this.focusStack.shift();
      }

      this.savedFocusedKey = key;
      console.log('[TV-NAV] saveFocus pushed:', state.key, 'ctx:', contextName, 'scrollTop:', state.scrollTop, 'stack:', this.focusStack.length);
    }
    
    restoreFocus(preferredContext = null) {
      if (!this.focusStack) this.focusStack = [];

      while (this.focusStack.length > 0 || this.savedFocusedKey) {
        let state = null;
        if (preferredContext && this.focusStack.length > 0) {
          for (let i = this.focusStack.length - 1; i >= 0; i--) {
            if (this.focusStack[i].context === preferredContext) {
              state = this.focusStack.splice(i, 1)[0];
              break;
            }
          }
        }

        if (!state && this.focusStack.length > 0) {
          state = this.focusStack.pop();
        }

        if (!state && this.savedFocusedKey) {
          state = { key: this.savedFocusedKey };
          this.savedFocusedKey = null;
        }

        if (!state) break;

        console.log('[TV-NAV] restoreFocus inspecting:', state.key, 'ctx:', state.context, 'scrollTop:', state.scrollTop, 'remaining in stack:', this.focusStack.length);
        this.focusedKey = state.key;
        this.savedFocusedKey = this.focusStack.length > 0 ? this.focusStack[this.focusStack.length - 1].key : null;

        // 1. ALWAYS restore container scroll position if we have one!
        if (state.scrollEl && document.body.contains(state.scrollEl)) {
          if (typeof state.scrollTop === 'number') {
            state.scrollEl.scrollTop = state.scrollTop;
            requestAnimationFrame(() => {
              if (state.scrollEl && state.scrollEl.scrollTop !== state.scrollTop) {
                state.scrollEl.scrollTop = state.scrollTop;
              }
            });
          }
          if (typeof state.scrollLeft === 'number') state.scrollEl.scrollLeft = state.scrollLeft;
        }
        if (typeof state.windowScrollY === 'number' && state.windowScrollY > 0) {
          window.scrollTo({ top: state.windowScrollY, behavior: 'auto' });
        }

        let targetEl = null;

        // 2. Try direct element reference
        if (state.el && document.body.contains(state.el) && this.visible(state.el)) {
          targetEl = state.el;
        }

        // 3. Try finding candidate by key
        if (!targetEl && state.key) {
          const candidates = this.getNavigableElements();
          const recovered = candidates.find(el => 
            (el.dataset.id || el.dataset.seriesId || el.dataset.movieId || el.id) === state.key
          );
          if (recovered && this.visible(recovered)) {
            targetEl = recovered;
          }
        }

        if (targetEl) {
          if (window._cineflixIsTV) {
            this.setFocus(targetEl);
            this.ensureVisible(targetEl);
          } else {
            this.focused = targetEl;
            this.focusedKey = state.key;
          }
          console.log('[TV-NAV] restoreFocus success onto:', targetEl);
          return true;
        }

        // If not found, and on TV, don't jump to top if we restored scroll!
        if (!targetEl && window._cineflixIsTV && state.scrollEl) {
          const candidates = this.getNavigableElements();
          const inView = candidates.find(el => {
            if (!state.scrollEl.contains(el)) return false;
            const r = el.getBoundingClientRect();
            return r.top >= 0 && r.bottom <= window.innerHeight;
          });
          if (inView) {
            this.setFocus(inView);
            return true;
          }
        }

        if (!window._cineflixIsTV) {
          // On mobile / touch, we already restored scrollEl.scrollTop. We're done!
          return true;
        }

        // If a specific context was requested and not found visible, stop checking
        if (preferredContext) break;
      }

      if (window._cineflixIsTV) {
        console.log('[TV-NAV] restoreFocus: nothing visible in stack, fallback to focusFirst');
        this.focusFirst();
      }
      return false;
    }

    hasSavedFocus() {
      return (this.focusStack && this.focusStack.length > 0) || !!this.savedFocusedKey;
    }

    clearFocusStack() {
      this.focusStack = [];
      this.savedFocusedKey = null;
    }

    focusPriority() {
      const candidates = this.getNavigableElements();
      if (candidates.length === 0) return false;

      // Priority -1: Fullscreen trailer modal if open
      const trailerModal = document.getElementById('fullscreen-trailer-modal');
      if (trailerModal && !trailerModal.classList.contains('hidden') && this.visible(trailerModal)) {
          const closeBtn = document.getElementById('fullscreen-trailer-close');
          if (closeBtn && this.visible(closeBtn)) {
              this.setFocus(closeBtn);
              return true;
          }
      }

      // Priority 0: Virtual keyboard if open
      const vkOverlay = document.getElementById('vk-overlay');
      if (vkOverlay && !vkOverlay.classList.contains('hidden') && this.visible(vkOverlay)) {
          if (this.focused && vkOverlay.contains(this.focused) && this.visible(this.focused)) {
              return true; // Already focused on a key inside VK, do not disrupt or re-focus 'Q'
          }
          const firstKey = vkOverlay.querySelector('.vk-key[data-char="Q"]') || vkOverlay.querySelector('.vk-key');
          if (firstKey && this.visible(firstKey)) {
              this.setFocus(firstKey);
              return true;
          }
      }

      // Priority 1: detail view play button
      const detail = document.querySelector('#series-detail-modal:not(.hidden), .series-detail-card:not(.hidden)');
      if (detail && this.visible(detail)) {
          const playBtn = candidates.find(el => el.classList.contains('series-detail-play-btn') || el.id === 'series-detail-play');
          if (playBtn) { this.setFocus(playBtn); return true; }
      }

      // Priority 2: In episodes view, prioritize first episode card
      const activeEpisodesView = document.querySelector('#view-episodes.active');
      if (activeEpisodesView) {
          const firstEp = candidates.find(el => el.classList.contains('episode-card'));
          if (firstEp) { this.setFocus(firstEp); return true; }
      }

      // Priority 2.5: In series view, prioritize first season button
      const activeSeriesView = document.querySelector('#view-series.active');
      if (activeSeriesView) {
          const firstSeason = candidates.find(el => el.classList.contains('season-btn'));
          if (firstSeason) { this.setFocus(firstSeason); return true; }
      }

      // Never prioritize main-nav-btn if any modal is currently visible!
      const inAnyModal = Array.from(document.querySelectorAll('.series-detail-card, #movie-files-modal, #vk-overlay, #movie-resume-modal, #series-resume-modal, #continue-context-modal, #fullscreen-trailer-modal, #series-cast-modal, #recap-modal, #remote-modal, #admin-edit-modal, #season-picker-modal, .season-picker-card, #filter-sort-modal, .filter-sort-card')).some(m => this.visible(m) && !m.classList.contains('hidden'));
      if (inAnyModal) return false;

      // Priority 3: In app shell views, prioritize the active main-nav button!
      const activeNavBtn = candidates.find(el => el.classList.contains('main-nav-btn') && el.classList.contains('active')) ||
                           (document.querySelector('#main-nav-bar .main-nav-btn.active'));
      if (activeNavBtn && this.visible(activeNavBtn) && candidates.includes(activeNavBtn)) {
          this.setFocus(activeNavBtn);
          return true;
      }

      // Priority 3.1: Fallbacks for direct IDs
      const navSeries = candidates.find(el => el.id === 'nav-series');
      if (navSeries && this.visible(navSeries)) { this.setFocus(navSeries); return true; }
      const navMovies = candidates.find(el => el.id === 'nav-movies');
      if (navMovies && this.visible(navMovies)) { this.setFocus(navMovies); return true; }

      return false;
    }

    focusFirst() {
      if (!window._cineflixIsTV && !new URLSearchParams(window.location.search).get('tv')) {
        return;
      }
      const candidates = this.getNavigableElements();
      if (candidates.length === 0) return;
      
      if (this.focusedKey) {
          const recovered = candidates.find(el => 
              (el.dataset.id || el.dataset.seriesId || el.dataset.movieId || el.id) === this.focusedKey
          );
          if (recovered && this.visible(recovered)) {
              this.setFocus(recovered);
              return;
          }
      }

      if (this.hasSavedFocus && this.hasSavedFocus()) {
          if (this.restoreFocus()) return;
      }

      if (this.focusPriority()) return;

      const activeView = document.querySelector('#views-viewport > .view.active') || document.querySelector('.view.active');
      if (activeView && activeView.scrollTop > 50) {
        const inView = candidates.find(el => {
          if (!activeView.contains(el)) return false;
          const r = el.getBoundingClientRect();
          return r.top >= 80 && r.bottom <= window.innerHeight - 80;
        });
        if (inView) {
          this.setFocus(inView);
          return;
        }
      }

      let best = candidates[0];
      let minScore = Infinity;

      for (let el of candidates) {
        const r = el.getBoundingClientRect();
        let score = (r.top * 10) + r.left; 
        // Heavily penalize text inputs and topbar actions so focus recovery NEVER defaults to search-input or remote button
        if (el.tagName === 'INPUT' || el.tagName === 'TEXTAREA' || el.closest('.topbar-actions')) {
          score += 100000;
        }
        if (score < minScore) {
            minScore = score;
            best = el;
        }
      }
      this.setFocus(best);
    }

  }

  function boot() {
    const isTVPlatform = (function() {
      if (isDesktopPC()) return false;
      if (window._cineflixIsTV) return true;
      if (document.body.classList.contains('is-tv')) return true;
      if (new URLSearchParams(window.location.search).get('tv') === '1') return true;
      if (window.AndroidBridge && typeof window.AndroidBridge.getPlatform === 'function' && window.AndroidBridge.getPlatform() === 'android_tv') return true;
      const ua = (navigator.userAgent || '').toLowerCase();
      if (/\b(tv|smart-?tv|googletv|tizen|webos|crkey|firetv|aft[mbtsk]|bravia|viera|roku|mibox|shield)\b/i.test(ua)) return true;
      return false;
    })();

    if (isTVPlatform) {
      window._cineflixIsTV = true;
      document.body.classList.add('is-tv');
      document.documentElement.classList.add('is-tv');
      console.log('[TV-NAV] Activating SPATIAL D-pad navigation for TV');
    }

    if (window.cineflixTvNav) return;
    window.cineflixTvNav = new CineflixTVNav();
    window.cineflixTvNav.init();
  }

  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', boot);
  } else {
    boot();
  }

  document.addEventListener('keydown', function autoBoot(e) {
      if (isDesktopPC()) return;
      const key = e.keyCode || e.which;
      if ([13, 23, 66, 37, 38, 39, 40, 19, 20, 21, 22].includes(key)) {
          const ua = (navigator.userAgent || '').toLowerCase();
          if (ua.includes('mobile') && !ua.includes('tv') && !ua.includes('box') && !ua.includes('shield')) return; 

          if (!document.body.classList.contains('is-tv')) {
            console.log('[TV-NAV] Remote key detected! Auto-activating SPATIAL D-pad navigation');
            try { window._cineflixIsTV = true; } catch(err){} 
            document.body.classList.add('is-tv');
            document.documentElement.classList.add('is-tv');
          }
          if (!window.cineflixTvNav) {
            window.cineflixTvNav = new CineflixTVNav();
            window.cineflixTvNav.init();
          }
      }
  });
})();
