/* Sonido sintetizado (WebAudio) */
// Sound System (Synthesized Web Audio API)
let audioCtx = null;
let isSoundEnabled = false;

function initAudio() {
    if (!audioCtx) {
        const AudioContext = window.AudioContext || window.webkitAudioContext;
        audioCtx = new AudioContext();
    }
    if (audioCtx.state === 'suspended') {
        audioCtx.resume();
    }
}

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
        text.textContent = 'Sonido ON';
        playBlip(587, 'sine', 0.1);
    } else {
        btn.classList.remove('active');
        icon.textContent = '🔈';
        text.textContent = 'Mudo';
    }
}
