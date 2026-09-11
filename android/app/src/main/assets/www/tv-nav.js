(function() {
  'use strict';

  class CineflixTVNav {
    constructor() {
      this.focused = null;
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
      return !!(
        window._cineflixIsTV ||
        window.__appPlatform === 'android_tv' ||
        document.body.classList.contains('is-tv') ||
        document.documentElement.classList.contains('android-tv') ||
        (window.AndroidBridge && typeof window.AndroidBridge.getPlatform === 'function' && window.AndroidBridge.getPlatform() === 'android_tv') ||
        new URLSearchParams(window.location.search).get('tv')
      );
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
          outline: 3px solid #8b5cf6 !important;
          outline-offset: 2px !important;
          box-shadow: 0 0 12px rgba(139, 92, 246, 0.6) !important;
          z-index: 10 !important;
        }
        body.is-tv input.tv-focused, body.is-tv textarea.tv-focused,
        .android-tv input.tv-focused, .android-tv textarea.tv-focused {
          outline: 4px solid #8b5cf6 !important;
          outline-offset: 4px !important;
          box-shadow: 0 0 15px rgba(139, 92, 246, 0.5) !important;
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
      // If moving LEFT/RIGHT within a container (.genre-tabs, .row-cards, .nav-tabs, .platforms-grid, .series-detail-cast, .series-detail-buttons),
      // strictly move within that container and NEVER escape horizontally.
      if (dir === 'LEFT' || dir === 'RIGHT') {
        const group = this.focused.closest('.genre-tabs, .row-cards, .nav-tabs, .series-detail-cast, .series-detail-buttons');
        if (group) {
          const items = Array.from(group.querySelectorAll('[tabindex="0"], button, input, textarea, a[href]'))
            .filter(el => el.getAttribute('tabindex') !== '-1' && this.visible(el));
          const idx = items.indexOf(this.focused);
          if (idx !== -1) {
            if (dir === 'LEFT') {
              if (idx > 0) this.setFocus(items[idx - 1]);
              return;
            }
            if (dir === 'RIGHT') {
              if (idx < items.length - 1) {
                this.setFocus(items[idx + 1]);
                return;
              }
              return;
            }
          }
        }
      }

      const inModal = this.focused.closest('.series-detail-card, #movie-files-modal, #vk-overlay, #movie-resume-modal, #series-resume-modal, #continue-context-modal, #fullscreen-trailer-modal');

      const currentRect = this.focused.getBoundingClientRect();
      const currentCenter = { 
          x: currentRect.left + currentRect.width / 2, 
          y: currentRect.top + currentRect.height / 2 
      };

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
          const navTabsCont = document.querySelector('#main-nav-bar .nav-tabs') || activeView.querySelector('.nav-tabs');
          const genreTabsCont = activeView.querySelector('.genre-tabs, #favorites-tabs, .genre-tabs-bar, #platform-genre-tabs');
          const heroBtn = activeView.querySelector('#hero-play-btn, #movies-hero-play-btn');
          const continueCont = activeView.querySelector('#continue-watching-series, #continue-watching-movies');
          const rowsCont = activeView.querySelector('#catalog-rows, #movies-rows, #platform-results-container');
          const searchInput = document.querySelector('#search-input');
          const topbarActions = document.querySelector('#main-topbar .topbar-actions') || activeView.querySelector('.topbar-actions');
          const gridCont = activeView.querySelector('#search-results, #movies-search-results, #favorites-grid, #platforms-grid, #platform-all-grid, .catalog-grid');

          const isHeroBtn = !!(heroBtn && this.focused === heroBtn);
          const inGenreTabs = !!(genreTabsCont && genreTabsCont.contains(this.focused));
          const inContinueRow = !!(continueCont && continueCont.contains(this.focused));
          const inCatalogRows = !!(rowsCont && rowsCont.contains(this.focused));
          const inContentRow = inCatalogRows ? this.focused.closest('.content-row') : null;
          const inNavTabs = !!(navTabsCont && navTabsCont.contains(this.focused));
          const isSearchInput = !!(searchInput && this.focused === searchInput);
          const inTopbarActions = !!(topbarActions && topbarActions.contains(this.focused));
          const inGrid = !!(gridCont && gridCont.contains(this.focused) && !inCatalogRows && !inContinueRow);

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

          // A. FROM TOPBAR ACTIONS:
          if (inTopbarActions) {
            if (dir === 'DOWN') {
              if (navTabsCont) {
                const navBtns = Array.from(navTabsCont.querySelectorAll('.main-nav-btn, button')).filter(b => this.visible(b));
                const target = navBtns.find(b => b.classList.contains('active')) || pickClosestX(navBtns);
                if (target) { this.setFocus(target); return; }
              }
            } else if (dir === 'LEFT') {
              const actionBtns = Array.from(topbarActions.querySelectorAll('button')).filter(b => this.visible(b));
              const idx = actionBtns.indexOf(this.focused);
              if (idx > 0) {
                this.setFocus(actionBtns[idx - 1]);
                return;
              } else if (searchInput && this.visible(searchInput)) {
                this.setFocus(searchInput);
                return;
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
              if (navTabsCont) {
                const navBtns = Array.from(navTabsCont.querySelectorAll('.main-nav-btn, button')).filter(b => this.visible(b));
                const target = navBtns.find(b => b.classList.contains('active')) || pickClosestX(navBtns);
                if (target) { this.setFocus(target); return; }
              }
            } else if (dir === 'RIGHT') {
              if (topbarActions) {
                const actionBtns = Array.from(topbarActions.querySelectorAll('button')).filter(b => this.visible(b));
                if (actionBtns.length > 0) { this.setFocus(actionBtns[0]); return; }
              }
            }
          }

          // C. FROM NAV TABS:
          if (inNavTabs) {
            if (dir === 'UP') {
              const actionBtns = topbarActions ? Array.from(topbarActions.querySelectorAll('button')).filter(b => this.visible(b)) : [];
              const candidates = (searchInput && this.visible(searchInput)) ? [searchInput, ...actionBtns] : actionBtns;
              const target = pickClosestX(candidates);
              if (target) {
                this.setFocus(target);
                return;
              }
            } else if (dir === 'DOWN') {
              // 1. Genre tabs
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

          // D. FROM GENRE TABS:
          if (inGenreTabs) {
            if (dir === 'UP') {
              if (navTabsCont && this.visible(navTabsCont)) {
                const navBtns = Array.from(navTabsCont.querySelectorAll('.main-nav-btn, button')).filter(b => this.visible(b));
                const target = navBtns.find(b => b.classList.contains('active')) || pickClosestX(navBtns);
                if (target) { this.setFocus(target); return; }
              }
            } else if (dir === 'DOWN') {
              // 1. Search / Genre results grid if active
              const searchResults = activeView.querySelector('#search-results, #movies-search-results');
              if (searchResults && this.visible(searchResults) && !searchResults.classList.contains('hidden') && window.getComputedStyle(searchResults).display !== 'none') {
                const gridCards = Array.from(searchResults.querySelectorAll('.series-card, .movie-card')).filter(c => this.visible(c));
                const target = pickClosestX(gridCards);
                if (target) { this.setFocus(target); return; }
              }
              // 2. Hero button
              if (heroBtn && this.visible(heroBtn)) {
                this.setFocus(heroBtn);
                return;
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
              // 5. Grid container (e.g. favorites)
              if (gridCont && this.visible(gridCont)) {
                const gridCards = Array.from(gridCont.querySelectorAll('.series-card, .movie-card')).filter(c => this.visible(c));
                const target = pickClosestX(gridCards);
                if (target) { this.setFocus(target); return; }
              }
            }
          }

          // E. FROM HERO PLAY BUTTON:
          if (isHeroBtn) {
            if (dir === 'UP') {
              // 1. Genre tabs
              if (genreTabsCont && this.visible(genreTabsCont)) {
                const tabs = Array.from(genreTabsCont.querySelectorAll('.genre-tab, button')).filter(t => this.visible(t));
                const target = tabs.find(t => t.classList.contains('active')) || pickClosestX(tabs);
                if (target) { this.setFocus(target); return; }
              }
              // 2. Nav tabs
              if (navTabsCont && this.visible(navTabsCont)) {
                const navBtns = Array.from(navTabsCont.querySelectorAll('.main-nav-btn, button')).filter(b => this.visible(b));
                const target = navBtns.find(b => b.classList.contains('active')) || pickClosestX(navBtns);
                if (target) { this.setFocus(target); return; }
              }
            } else if (dir === 'DOWN') {
              // 1. Continue watching
              if (continueCont && this.visible(continueCont)) {
                const continueCards = Array.from(continueCont.querySelectorAll('.series-card, .continue-card, .movie-card')).filter(c => this.visible(c));
                if (continueCards.length > 0) {
                  const target = pickClosestX(continueCards);
                  if (target) { this.setFocus(target); return; }
                }
              }
              // 2. Content rows
              const firstCards = getFirstPopulatedRowCards(rowsCont);
              if (firstCards.length > 0) {
                const target = pickClosestX(firstCards);
                if (target) { this.setFocus(target); return; }
              }
            } else if (dir === 'LEFT' || dir === 'RIGHT') {
              return; // Stay on the hero play button
            }
          }

          // F. FROM CONTINUE WATCHING ROW:
          if (inContinueRow) {
            if (dir === 'UP') {
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
              // 3. Nav tabs
              if (navTabsCont && this.visible(navTabsCont)) {
                const navBtns = Array.from(navTabsCont.querySelectorAll('.main-nav-btn, button')).filter(b => this.visible(b));
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

          // G. FROM CONTENT ROWS (inside #catalog-rows or #movies-rows):
          if (inCatalogRows && inContentRow) {
            const rows = Array.from(rowsCont.querySelectorAll('.content-row')).filter(r => this.visible(r));
            const rowIdx = rows.indexOf(inContentRow);

            if (dir === 'UP') {
              for (let i = rowIdx - 1; i >= 0; i--) {
                const prevCards = Array.from(rows[i].querySelectorAll('.series-card, .movie-card')).filter(c => this.visible(c));
                if (prevCards.length > 0) {
                  const target = pickClosestX(prevCards);
                  if (target) { this.setFocus(target); return; }
                }
              }

              // Reached top-most content row:
              // 1. Continue watching:
              if (continueCont && this.visible(continueCont)) {
                const continueCards = Array.from(continueCont.querySelectorAll('.series-card, .continue-card, .movie-card')).filter(c => this.visible(c));
                if (continueCards.length > 0) {
                  const target = pickClosestX(continueCards);
                  if (target) { this.setFocus(target); return; }
                }
              }
              // 2. Hero button:
              if (heroBtn && this.visible(heroBtn)) {
                this.setFocus(heroBtn);
                return;
              }
              // 3. Genre tabs:
              if (genreTabsCont && this.visible(genreTabsCont)) {
                const tabs = Array.from(genreTabsCont.querySelectorAll('.genre-tab, button')).filter(t => this.visible(t));
                const target = tabs.find(t => t.classList.contains('active')) || pickClosestX(tabs);
                if (target) { this.setFocus(target); return; }
              }
              // 4. Nav tabs:
              if (navTabsCont && this.visible(navTabsCont)) {
                const navBtns = Array.from(navTabsCont.querySelectorAll('.main-nav-btn, button')).filter(b => this.visible(b));
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
              // Top row of grid: move to genre tabs, platform subnav, back button, or nav tabs
              if (genreTabsCont && this.visible(genreTabsCont)) {
                const tabs = Array.from(genreTabsCont.querySelectorAll('.genre-tab, button')).filter(t => this.visible(t));
                const target = tabs.find(t => t.classList.contains('active')) || pickClosestX(tabs);
                if (target) { this.setFocus(target); return; }
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
      
      const openModals = Array.from(document.querySelectorAll('.series-detail-card, #movie-files-modal, #vk-overlay, #movie-resume-modal, #series-resume-modal, #continue-context-modal, #fullscreen-trailer-modal')).filter(m => this.visible(m) && !m.classList.contains('hidden'));
      if (openModals.length > 0) {
        root = openModals[openModals.length - 1];
      }

      const elements = Array.from(root.querySelectorAll('[tabindex="0"], button, input, textarea, a[href]'));
      return elements.filter(el => el.getAttribute('tabindex') !== '-1' && this.visible(el));
    }

    visible(el) {
      if (!el) return false;
      if (!document.body.contains(el)) return false;
      const cs = window.getComputedStyle(el);
      
      if (cs.display === 'none' || cs.visibility === 'hidden' || cs.opacity === '0') {
          return false;
      }
      
      const r = el.getBoundingClientRect();
      return r.width > 0 && r.height > 0;
    }

    setFocus(el) {
      if (!el) return;
      if (this.focused && this.focused !== el) {
        this.focused.classList.remove('tv-focused', 'tv-input-active');
      }
      
      this.focused = el;
      
      this.focusedKey = 
          el.dataset.id || 
          el.dataset.seriesId || 
          el.dataset.movieId || 
          el.id || 
          null;
          
      if (this.isTV()) {
        el.classList.add('tv-focused');
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

      // 1. HORIZONTAL: scroll parent container if it has horizontal scroll (.genre-tabs, .row-cards, .nav-tabs, .series-detail-cast)
      const scrollContainer = el.closest('.genre-tabs, .row-cards, .nav-tabs, .series-detail-cast');
      if (scrollContainer) {
        const elRect = el.getBoundingClientRect();
        const contRect = scrollContainer.getBoundingClientRect();
        const pad = 60;
        
        if (elRect.left < contRect.left + pad) {
          scrollContainer.scrollLeft -= (contRect.left + pad - elRect.left);
        } else if (elRect.right > contRect.right - pad) {
          scrollContainer.scrollLeft += (elRect.right - (contRect.right - pad));
        }
      }
      
      // 2. MODAL SCROLL: If inside detail modal (.series-detail-card or .modal-card), scroll the modal directly
      const modal = el.closest('.series-detail-card, .modal-card');
      if (modal) {
        const mRect = modal.getBoundingClientRect();
        const elRect = el.getBoundingClientRect();
        const pad = 60;
        if (elRect.top < mRect.top + pad) {
          modal.scrollTop -= (mRect.top + pad - elRect.top);
        } else if (elRect.bottom > mRect.bottom - pad) {
          modal.scrollTop += (elRect.bottom - (mRect.bottom - pad));
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
      const activeView = el.closest('#views-viewport > .view, #view-catalog, #view-movies, #view-favorites, #view-platforms, #view-my-content, #view-continue, #view-actor-profile, #view-actor-results') ||
                         document.querySelector('#views-viewport > .view.active, #view-catalog.active, #view-movies.active, #view-favorites.active, #view-platforms.active, #view-actor-profile.active, #view-actor-results.active');

      // 4a. If focus moved to Topbar, Nav Bar, or Hero, smoothly reset scroll to top!
      if (el.closest('.topbar, .main-nav, #main-topbar, #main-nav-bar, .hero-section, #catalog-hero, #movies-hero')) {
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
      const genreTabs = document.querySelector('.genre-tabs:not(.hidden)');
      let topNavBottom = 0;
      if (genreTabs && this.visible(genreTabs) && genreTabs.offsetHeight > 0) {
        topNavBottom = Math.max(topNavBottom, genreTabs.getBoundingClientRect().bottom);
      }
      if (navBar && this.visible(navBar)) {
        topNavBottom = Math.max(topNavBottom, navBar.getBoundingClientRect().bottom);
      } else if (topbar && this.visible(topbar)) {
        topNavBottom = Math.max(topNavBottom, topbar.getBoundingClientRect().bottom);
      }
      if (topNavBottom <= 0) topNavBottom = 80;

      // Safe top and bottom margins with breathing room (extra headroom on TV so cards never touch headers)
      const safeTop = topNavBottom + (this.isTV() ? 20 : 14);
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
        }

        // On TV, when navigating down to a row partially or fully below safeTop, dock row header at safeTop
        if (this.isTV() && rowRect.top > safeTop && cardRect.bottom > safeBottom) {
          const dockAtTopScroll = rowRect.top - safeTop;
          const cardBottomAfterDock = cardRect.bottom - dockAtTopScroll;
          if (cardBottomAfterDock <= safeBottom) {
            scrollY = dockAtTopScroll;
          } else {
            scrollY = cardRect.bottom - safeBottom;
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
        const isSearchInput = this.focused.id === 'search-input';

        const isTV = !!(window._cineflixIsTV || window.__appPlatform === 'android_tv' || document.body.classList.contains('is-tv'));
        if (isSearchInput && isTV && typeof window.__cineflixVKOpen !== 'undefined') {
            if (typeof window.openVirtualKeyboard === 'function') {
                window.openVirtualKeyboard(this.focused);
            } else {
                this.focused.click();
            }
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
        key = document.activeElement.dataset?.id || document.activeElement.id || null;
      }

      const state = {
        key: key,
        el: this.focused || (document.activeElement !== document.body ? document.activeElement : null),
        scrollEl: scrollEl || activeView,
        scrollTop: (scrollEl ? scrollEl.scrollTop : (activeView ? activeView.scrollTop : 0)),
        scrollLeft: scrollLeft,
        windowScrollY: window.scrollY || 0,
        viewId: activeView?.id || null,
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
      const inAnyModal = Array.from(document.querySelectorAll('.series-detail-card, #movie-files-modal, #vk-overlay, #movie-resume-modal, #series-resume-modal, #continue-context-modal, #fullscreen-trailer-modal')).some(m => this.visible(m) && !m.classList.contains('hidden'));
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
    if (window.cineflixTvNav) return;
    window.cineflixTvNav = new CineflixTVNav();
    window.cineflixTvNav.init();
    if (window._cineflixIsTV) {
      console.log('[TV-NAV] Activating SPATIAL D-pad navigation for Android TV');
      document.body.classList.add('is-tv');
      document.documentElement.classList.add('is-tv');
    }
  }

  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', boot);
  } else {
    boot();
  }

  document.addEventListener('keydown', function autoBoot(e) {
      const key = e.keyCode || e.which;
      if (!window.cineflixTvNav && [13, 23, 66, 37, 38, 39, 40, 19, 20, 21, 22].includes(key)) {
          const ua = navigator.userAgent.toLowerCase();
          if (ua.includes('mobile')) return; 

          console.log('[TV-NAV] Remote key detected! Auto-activating SPATIAL D-pad navigation');
          try { window._cineflixIsTV = true; } catch(e){} 
          document.body.classList.add('is-tv');
          document.documentElement.classList.add('is-tv');
          window.cineflixTvNav = new CineflixTVNav();
          window.cineflixTvNav.init();
          document.removeEventListener('keydown', autoBoot);
          
          setTimeout(() => {
              if (window.cineflixTvNav.focused && [13, 23, 66].includes(key)) {
                  window.cineflixTvNav.confirm();
              }
          }, 50);
      }
  });
})();
