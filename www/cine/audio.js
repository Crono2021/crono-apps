/* Sonido sintetizado (WebAudio) */
// Sound System (Synthesized Web Audio API)
let audioCtx = null;
let isSoundEnabled = true;

function initAudio() {
    if (!audioCtx) {
        const AudioContext = window.AudioContext || window.webkitAudioContext;
        audioCtx = new AudioContext();
    }
    if (audioCtx.state === 'suspended') {
        audioCtx.resume();
    }
}
document.addEventListener('click', () => { if (audioCtx && audioCtx.state === 'suspended') audioCtx.resume(); }, { passive: true });
document.addEventListener('keydown', () => { if (audioCtx && audioCtx.state === 'suspended') audioCtx.resume(); }, { passive: true });

function playBlip(freq = 440, type = 'square', duration = 0.08) {
    if (!isSoundEnabled) return;
    try {
        initAudio();
        const osc = audioCtx.createOscillator();
        const gain = audioCtx.createGain();
        osc.type = type;
        osc.frequency.setValueAtTime(freq, audioCtx.currentTime);
        gain.gain.setValueAtTime(0.06, audioCtx.currentTime);
        gain.gain.exponentialRampToValueAtTime(0.001, audioCtx.currentTime + duration);
        osc.connect(gain);
        gain.connect(audioCtx.destination);
        osc.start();
        osc.stop(audioCtx.currentTime + duration);
    } catch(e) {}
}

function playPopcornCrunch() {
    if (!isSoundEnabled) return;
    playBlip(320, 'triangle', 0.05);
    setTimeout(() => playBlip(480, 'sine', 0.04), 45);
}

function toggleSound() {
    isSoundEnabled = !isSoundEnabled;
    if (isSoundEnabled) initAudio();
    const btn = document.getElementById('btn-sound');
    const icon = document.getElementById('sound-icon');
    const text = document.getElementById('sound-text');
    if (isSoundEnabled) {
        btn.classList.add('active');
        icon.textContent = '🔊';
        text.textContent = 'Efectos ON';
        playBlip(587, 'sine', 0.1);
    } else {
        btn.classList.remove('active');
        icon.textContent = '🔈';
        text.textContent = 'Efectos OFF';
    }
}

// Efectos extra (todos sintetizados; no hay audio de películas ni música)
const _sfxLast = {};
function playSfx(name) {
    if (!isSoundEnabled) return;
    const now = Date.now();
    if (_sfxLast[name] && now - _sfxLast[name] < 400) return;
    _sfxLast[name] = now;
    switch (name) {
        case 'sit':   playBlip(130, 'triangle', 0.12); setTimeout(() => playBlip(95, 'sine', 0.1), 70); break;
        case 'stand': playBlip(200, 'triangle', 0.08); setTimeout(() => playBlip(260, 'triangle', 0.08), 60); break;
        case 'door':  playBlip(180, 'sawtooth', 0.12); setTimeout(() => playBlip(140, 'sawtooth', 0.18), 110); break;
        case 'crunch': playPopcornCrunch(); setTimeout(playPopcornCrunch, 140); setTimeout(playPopcornCrunch, 290); break;
        case 'click': playBlip(520, 'square', 0.04); break;
    }
}
