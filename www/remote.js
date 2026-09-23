const wsUrl = location.origin.replace(/^http/, 'ws');
let ws = null;
let currentRoom = null;

const steps = {
    connect: document.getElementById('step-connect'),
    phone: document.getElementById('step-phone'),
    code: document.getElementById('step-code'),
    password: document.getElementById('step-password'),
    success: document.getElementById('step-success'),
    loading: document.getElementById('step-loading')
};

function showStep(stepName) {
    Object.values(steps).forEach(s => s.classList.remove('active'));
    steps[stepName].classList.add('active');
}

function showError(stepId, msg) {
    const err = document.getElementById(`${stepId}-error`);
    if (err) {
        err.innerText = msg;
        err.style.display = 'block';
    }
}

function clearErrors() {
    document.querySelectorAll('.error-msg').forEach(el => el.style.display = 'none');
}

function connectWebSocket(roomCode) {
    ws = new WebSocket(wsUrl);
    
    ws.onopen = () => {
        ws.send(JSON.stringify({ type: 'join_room', code: roomCode }));
    };

    ws.onmessage = (event) => {
        try {
            const msg = JSON.parse(event.data);
            
            if (msg.type === 'error') {
                if (msg.message === 'Código no encontrado') {
                    showStep('connect');
                    document.getElementById('pin-input-container').style.display = 'block';
                    document.querySelector('#step-connect .spinner').style.display = 'none';
                    showError('connect', 'Código inválido o expirado. Inténtalo de nuevo.');
                } else {
                    showError(Object.keys(steps).find(k => steps[k].classList.contains('active')), msg.message || 'Error desconocido');
                    if (steps.loading.classList.contains('active')) showStep('phone');
                }
                return;
            }

            if (msg.type === 'joined') {
                currentRoom = roomCode;
                showStep('phone');
            } else if (msg.type === 'tv_disconnected') {
                showStep('connect');
                document.getElementById('pin-input-container').style.display = 'block';
                document.querySelector('#step-connect .spinner').style.display = 'none';
                showError('connect', 'La TV se ha desconectado. Vuelve a intentarlo.');
            } else if (msg.type === 'tv_action') {
                if (msg.action === 'waiting_for_code') {
                    showStep('code');
                } else if (msg.action === 'waiting_for_password') {
                    showStep('password');
                } else if (msg.action === 'success') {
                    showStep('success');
                    setTimeout(() => ws.close(), 1000);
                } else if (msg.action === 'auth_error') {
                    if (msg.step === 'phone') {
                        showStep('phone');
                        showError('phone', msg.message);
                    } else if (msg.step === 'code') {
                        showStep('code');
                        showError('code', msg.message);
                    } else if (msg.step === 'password') {
                        showStep('password');
                        showError('password', msg.message);
                    }
                }
            }
        } catch (e) {
            console.error('Error parseando WS', e);
        }
    };

    ws.onclose = () => {
        if (!steps.success.classList.contains('active')) {
            showStep('connect');
            document.getElementById('pin-input-container').style.display = 'block';
            document.querySelector('#step-connect .spinner').style.display = 'none';
            showError('connect', 'Desconectado del servidor.');
        }
    };
}

// Inicialización
const urlParams = new URLSearchParams(window.location.search);
const urlRoom = urlParams.get('room');

if (urlRoom) {
    connectWebSocket(urlRoom);
} else {
    document.getElementById('pin-input-container').style.display = 'block';
    document.querySelector('#step-connect .spinner').style.display = 'none';
}

document.getElementById('btn-join').addEventListener('click', () => {
    const pin = document.getElementById('room-pin').value;
    if (pin.length !== 4) return showError('connect', 'El PIN debe tener 4 dígitos');
    clearErrors();
    document.getElementById('pin-input-container').style.display = 'none';
    document.querySelector('#step-connect .spinner').style.display = 'block';
    connectWebSocket(pin);
});

document.getElementById('btn-phone').addEventListener('click', () => {
    const phone = document.getElementById('phone-input').value.trim();
    if (!phone) return showError('phone', 'Introduce tu teléfono');
    clearErrors();
    showStep('loading');
    ws.send(JSON.stringify({ type: 'action', action: 'remote_phone', phone }));
});

document.getElementById('btn-code').addEventListener('click', () => {
    const code = document.getElementById('code-input').value.trim();
    if (!code) return showError('code', 'Introduce el código');
    clearErrors();
    showStep('loading');
    ws.send(JSON.stringify({ type: 'action', action: 'remote_code', code }));
});

document.getElementById('btn-password').addEventListener('click', () => {
    const password = document.getElementById('password-input').value.trim();
    if (!password) return showError('password', 'Introduce la contraseña');
    clearErrors();
    showStep('loading');
    ws.send(JSON.stringify({ type: 'action', action: 'remote_password', password }));
});
