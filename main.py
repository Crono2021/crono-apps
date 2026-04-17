import os 
import json
import math
import unicodedata
import re
import asyncio
import io
import difflib
import base64
import urllib.parse
import urllib.request
import urllib.error
from pathlib import Path
from html import escape
from datetime import datetime


# ===== Permisos extra /reanalizar =====
REANALIZAR_ALLOWED_IDS = {6130939257}

def _is_allowed_reanalizar(user_id: int) -> bool:
    return user_id == OWNER_ID or user_id in REANALIZAR_ALLOWED_IDS

try:
    from zoneinfo import ZoneInfo
except Exception:
    ZoneInfo = None
from telegram import (
    Update,
    InlineKeyboardButton,
    InlineKeyboardMarkup,
)
from telegram.ext import (
    ApplicationBuilder,
    MessageHandler,
    CallbackQueryHandler,
    ContextTypes,
    CommandHandler,
    filters,
    ApplicationHandlerStop,
)
from telegram.error import RetryAfter, BadRequest

# ======================================================
#    CONFIGURACIÓN DEL BOT
# ======================================================
BOT_TOKEN = os.getenv("BOT_TOKEN")
GROUP_ID = int(os.getenv("GROUP_ID"))

# ======================================================
#    TMDB (detección/corrección de títulos y años)
# ======================================================
TMDB_TOKEN = (os.getenv("TMDB_TOKEN") or "").strip()
TMDB_API_BASE = "https://api.themoviedb.org/3/"


# ID DEL OWNER — PERMISOS ESPECIALES
OWNER_ID = 5540195020

# ======================================================
#    GITHUB — catálogo remoto (app Desktop)
# ======================================================
GITHUB_TOKEN = "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"
GITHUB_REPO  = os.getenv("GITHUB_REPO", "Crono2021/cineflix-catalog")  # usuario/repo
GITHUB_API   = "https://api.github.com"

# =============================
#    PERMISOS EXTRA (ALLOWLIST)
# =============================
PAYLOAD_ALLOWED_IDS = {6130939257}
CONTROL_ALLOWED_IDS = {6130939257}

def can_use_payload(user_id: int) -> bool:
    return user_id == OWNER_ID or user_id in PAYLOAD_ALLOWED_IDS

def can_complete_control(user_id: int, admin_ids: list[int]) -> bool:
    return user_id == OWNER_ID or user_id in admin_ids or user_id in CONTROL_ALLOWED_IDS


# Carpeta persistente de Railway
DATA_DIR = Path("/data")
DATA_DIR.mkdir(parents=True, exist_ok=True)
TOPICS_FILE = DATA_DIR / "topics.json"
USERS_FILE = DATA_DIR / "users.json"  # registro de usuarios
SETTINGS_FILE = DATA_DIR / "settings.json"  # ajustes globales (tema de análisis)
REQUESTS_FILE = DATA_DIR / "requests.json"
RATE_LIMITS_FILE = DATA_DIR / "rate_limits.json"  # límite de peticiones por día
BANNED_FILE = DATA_DIR / "banned.json"  # usuarios baneados
HIDDEN_FILE = DATA_DIR / "hidden.txt" # Tema oculto

# Tamaño de página (temas por página en listados generales)
PAGE_SIZE = 30
# Cuántos temas se muestran en "Recientes"
RECENT_LIMIT = 20
# Cuántas películas se muestran en "Películas recientes"
MOVIES_RECENT_LIMIT = 10

# Límite de resultados en búsqueda de películas (sin paginación de momento)
PELIS_RESULT_LIMIT = 70
# Tamaño de página (películas por página en resultados de búsqueda)
MOVIES_PAGE_SIZE = 20
# Tamaño de página para listado de usuarios
USERS_PAGE_SIZE = 30


# ======================================================
#    HELPERS PARA ACENTOS / PRIMERA LETRA
# ======================================================
def get_first_and_base(name: str):
    if not name:
        return None, None
    s = name.strip()
    if not s:
        return None, None
    first = s[0]
    # FIX acentos
    decomp = unicodedata.normalize("NFD", first)
    base = ''.join(c for c in decomp if unicodedata.category(c) != 'Mn')
    return first, base.upper()


def fix_text(s: str) -> str:
    """Normaliza texto para que los acentos y caracteres especiales se vean bien."""
    if not s:
        return ""
    return unicodedata.normalize("NFC", s)


# ======================================================
#    LIMPIEZA DE TÍTULOS (películas)
# ======================================================
EMOJI_PATTERN = re.compile(
    "["
    "\U0001F600-\U0001F64F"  # emoticonos
    "\U0001F300-\U0001F5FF"  # símbolos
    "\U0001F680-\U0001F6FF"
    "\U0001F1E0-\U0001F1FF"  # banderas
    "\U00002700-\U000027BF"
    "\U0001F900-\U0001F9FF"
    "\U00002600-\U000026FF"
    "\U00002B00-\U00002BFF"
    "\U0001FA70-\U0001FAFF"
    "]+",
    flags=re.UNICODE,
)



def limpiar_titulo(linea: str) -> str:
    if not linea:
        return ""

    s = linea.strip()

    # Limpieza básica
    s = re.sub(r"https?://\S+", "", s)
    s = re.sub(r"@\w+", "", s)
    s = re.sub(r"#\w+", "", s)
    s = Emojis_PATTERN.sub("", s) if 'Emojis_PATTERN' in locals() else EMOJI_PATTERN.sub("", s)
    s = re.sub(r"\s{2,}", " ", s).strip()

    patron_parentesis = r"\(\s*(\d{4})\s*\)"
    patron_sin_parentesis = r"\b(\d{4})\b"

    m_par = re.search(patron_parentesis, s)
    m_sin = re.search(patron_sin_parentesis, s)

    if m_par:
        return s[:m_par.end()].strip()

    if m_sin:
        if m_sin.start() == 0:
            return s.strip()
        return s[:m_sin.end()].strip()

    return s.strip()


# ======================================================
#    TMDB helpers (resolver película por título/año)
# ======================================================

def _normalize_ascii(s: str) -> str:
    return "".join(
        c for c in unicodedata.normalize("NFD", s)
        if unicodedata.category(c) != "Mn"
    )

def _norm(s: str) -> str:
    s = (s or "").strip().lower()
    s = _normalize_ascii(s)
    s = "".join(ch for ch in s if ch.isalnum() or ch.isspace())
    s = " ".join(s.split())
    return s

def _similarity(a: str, b: str) -> float:
    a, b = _norm(a), _norm(b)
    if not a or not b:
        return 0.0
    return difflib.SequenceMatcher(a=a, b=b).ratio()


def resolve_movie_request_tmdb(titulo: str, year: int):
    if not TMDB_TOKEN:
        return None

    data = tmdb_get("search/movie", {
        "query": titulo,
        "language": "es-ES",
        "include_adult": "false",
        "page": 1,
    })

    if not data or not data.get("results"):
        return None

    best = None
    best_score = None

    for r in data["results"][:10]:
        rel_year = _year_from_date(r.get("release_date") or "")
        if not rel_year:
            continue

        title_es = r.get("title") or ""
        title_orig = r.get("original_title") or ""

        sim = max(
            _similarity(titulo, title_es),
            _similarity(titulo, title_orig)
        )

        year_dist = abs(rel_year - year)
        score = year_dist * 2 - sim * 10

        if best_score is None or score < best_score:
            best_score = score
            best = (title_es or title_orig, rel_year)

    return best



def _token_match(query: str, title: str) -> bool:
    """
    Match robusto basado en tokens.
    """
    q = _norm(query)
    t = _norm(title)
    if not q or not t:
        return False
    q_tokens = [tok for tok in q.split() if len(tok) >= 3]
    if not q_tokens:
        return False
    t_tokens = set(t.split())
    hits = [tok for tok in q_tokens if tok in t_tokens]
    strong_hits = [tok for tok in hits if len(tok) >= 5]
    return (len(hits) >= 2) and (len(strong_hits) >= 1)

def _year_from_date(date_str: str):
    if not date_str:
        return None
    try:
        return int(str(date_str)[:4])
    except Exception:
        return None

def _is_probably_v3_api_key(token: str) -> bool:
    return bool(token) and len(token) == 32 and all(c in "0123456789abcdefABCDEF" for c in token)

def tmdb_get(path: str, params: dict):
    token = (TMDB_TOKEN or "").strip()
    params = dict(params or {})

    use_bearer = token and not _is_probably_v3_api_key(token)
    if token and not use_bearer:
        params["api_key"] = token  # v3 API key

    qs = urllib.parse.urlencode(params)
    url = TMDB_API_BASE + path.lstrip("/") + ("?" + qs if qs else "")
    req = urllib.request.Request(url)
    req.add_header("accept", "application/json")
    if use_bearer:
        req.add_header("Authorization", f"Bearer {token}")

    try:
        with urllib.request.urlopen(req, timeout=20) as resp:
            return json.loads(resp.read().decode("utf-8"))
    except urllib.error.HTTPError as e:
        try:
            body = e.read().decode("utf-8", errors="replace")
        except Exception:
            body = ""
        print(f"TMDB HTTPError {e.code}: {e.reason} | url={url} | body={body[:300]}")
        return None
    except Exception as e:
        print(f"TMDB error: {e} | url={url}")
        return None

def resolve_movie_tmdb(user_title: str, user_year: int):
    # Devuelve (titulo_es, anio) o None
    if not TMDB_TOKEN:
        return None

    data = tmdb_get("search/movie", {
        "query": user_title,
        "language": "es-ES",
        "include_adult": "false",
        "page": 1,
    }) or {}

    results = data.get("results") or []
    if not results:
        return None

    scored = []
    for r in results[:20]:
        title_es = r.get("title") or ""
        title_orig = r.get("original_title") or ""
        rel_year = _year_from_date(r.get("release_date") or "")
        year_dist = abs(rel_year - user_year) if rel_year else 999

        sim = max(_similarity(user_title, title_es), _similarity(user_title, title_orig))
        pop = float(r.get("popularity") or 0.0)

        token_ok = _token_match(user_title, title_es) or _token_match(user_title, title_orig)

        q_tokens = [t for t in _norm(user_title).split() if len(t) >= 3]
        short_query = len(q_tokens) <= 2

        token_bonus = -0.15 if (short_query and token_ok) else 0.0
        scored.append((year_dist, -(sim + (-token_bonus)), -pop, r, sim, token_ok, short_query))

    scored.sort(key=lambda x: (x[0], x[1], x[2]))
    best = scored[0][3]
    best_title = best.get("title") or best.get("original_title") or user_title
    best_year = _year_from_date(best.get("release_date") or "")

    best_sim = max(_similarity(user_title, best.get("title") or ""),
                   _similarity(user_title, best.get("original_title") or ""))
    best_token_ok = _token_match(user_title, best.get("title") or "") or _token_match(user_title, best.get("original_title") or "")

    q_tokens = [t for t in _norm(user_title).split() if len(t) >= 3]
    short_query = len(q_tokens) <= 2

    if not best_year:
        return None

    if short_query:
        if not best_token_ok and best_sim < 0.55:
            return None
        if best_sim < 0.35 and not best_token_ok:
            return None
    else:
        if best_sim < 0.55:
            return None

    return best_title, best_year

def resolve_movie_tmdb_no_year(user_title: str):
    if not TMDB_TOKEN:
        return None

    data = tmdb_get("search/movie", {
        "query": user_title,
        "language": "es-ES",
        "include_adult": "false",
        "page": 1,
    }) or {}

    results = data.get("results") or []
    if not results:
        return None

    scored = []
    for r in results[:20]:
        title_es = r.get("title") or ""
        title_orig = r.get("original_title") or ""
        rel_year = _year_from_date(r.get("release_date") or "")
        sim = max(_similarity(user_title, title_es), _similarity(user_title, title_orig))
        pop = float(r.get("popularity") or 0.0)
        scored.append((-sim, -pop, -(rel_year or 0), r))

    scored.sort(key=lambda x: (x[0], x[1], x[2]))
    best = scored[0][3]
    best_title = best.get("title") or best.get("original_title") or user_title
    best_year = _year_from_date(best.get("release_date") or "")

    best_sim = max(_similarity(user_title, best.get("title") or ""),
                   _similarity(user_title, best.get("original_title") or ""))

    if best_sim < 0.55 or not best_year:
        return None

    return best_title, best_year


# ======================================================
#    DETECCIÓN DE TEMPORADAS / EPISODIOS EN SERIES
# ======================================================

TEMPORADA_EPISODIO_RE = re.compile(
    r"(?:^|\s)(?:"
    r"[st]?0*(\d{1,2})\s*[xXeE]\s*0*(\d{1,3})"
    r"|T-?(\d{1,2})(?!\d)"
    r"|S-?(\d{1,2})(?!\d)"
    r"|Temporada\s*-?(\d{1,2})(?!\d)"
    r"|Season\s*-?(\d{1,2})(?!\d)"
    r"|Cap[ií]tulo\s*T-?(\d{1,2})(?!\d)"
    r"|Cap[ií]tulo\s*-?(\d{1,2})(?!\d)"
    r")",
    flags=re.IGNORECASE,
)

EXTRAS_PATTERN = re.compile(r"^\s*EXTRAS?\s*$", flags=re.IGNORECASE | re.UNICODE) 


def detectar_temporada_y_episodio(texto: str):
    if not texto:
        return None, None
    m = TEMPORADA_EPISODIO_RE.search(texto)
    if not m:
        return None, None
    for i in range(1, 8):
        if m.group(i):
            return int(m.group(i)), None
    return None, None

def ensure_season_structure(topic_info: dict):
    """Asegura que el dict del tema tiene los campos para manejar temporadas y extras."""
    if "seasons" not in topic_info or not isinstance(topic_info["seasons"], dict):
        topic_info["seasons"] = {}
    if "current_season" not in topic_info or not isinstance(topic_info["current_season"], int):
        topic_info["current_season"] = 1
    if "has_header_image" not in topic_info:
        topic_info["has_header_image"] = False
    if "seasons_built" not in topic_info:
        topic_info["seasons_built"] = False
    if "extras" not in topic_info or not isinstance(topic_info["extras"], list):
        topic_info["extras"] = []
    if "is_extras_section" not in topic_info or not isinstance(topic_info["is_extras_section"], bool):
        topic_info["is_extras_section"] = False
    if "capture_extras_id" not in topic_info or not isinstance(topic_info["capture_extras_id"], int):
        topic_info["capture_extras_id"] = 0
    if "extras_groups" not in topic_info or not isinstance(topic_info["extras_groups"], list):
        topic_info["extras_groups"] = []
    if "extras_capture_buffer" not in topic_info or not isinstance(topic_info["extras_capture_buffer"], list):
        topic_info["extras_capture_buffer"] = []
    if "extras_capture_title" not in topic_info or not isinstance(topic_info["extras_capture_title"], str):
        topic_info["extras_capture_title"] = ""

    if "extras_capture_target" not in topic_info or not isinstance(topic_info["extras_capture_target"], int):
        topic_info["extras_capture_target"] = -1 

    if topic_info.get("extras") and not topic_info["extras_groups"]:
        legacy_title = topic_info.get("extras_title") or "➕ Extras"
        topic_info["extras_groups"].append({"title": legacy_title, "messages": list(topic_info["extras"])})
        topic_info["extras"] = []


def process_message_for_seasons(topic_info: dict, msg, original_message_id: int):
    ensure_season_structure(topic_info)

    seasons = topic_info["seasons"]
    current_season = topic_info["current_season"]
    is_extras_section = topic_info["is_extras_section"]

    file_obj = msg.document or msg.video or msg.animation
    
    caption = (msg.caption or msg.text or "").strip() 
    
    caption_lower = caption.lower()
    
    is_sticker = bool(getattr(msg, "sticker", None))
    is_photo = bool(msg.photo) and not file_obj

    if EXTRAS_PATTERN.search(caption):
        topic_info["is_extras_section"] = True
        return 

    if is_extras_section:
        if file_obj or (msg.photo and caption) or msg.photo:
            topic_info["extras"].append(original_message_id)
        return

    season_from_number, _ = detectar_temporada_y_episodio(caption_lower)
    if season_from_number:
        season = season_from_number
        if season > current_season:
            topic_info["current_season"] = season
        season_key = str(season)
        seasons.setdefault(season_key, [])
        seasons[season_key].append(original_message_id)
        return

    tiene_t1 = any(k == "1" and v for k, v in seasons.items())

    if is_sticker or is_photo:
        if not tiene_t1:
            return

        topic_info["current_season"] += 1
        season_key = str(topic_info["current_season"])
        seasons.setdefault(season_key, [])
        return

    if file_obj or (msg.photo and caption):
        if not tiene_t1:
            season = 1
            topic_info["current_season"] = 1
        else:
            season = topic_info["current_season"] or 1

        season_key = str(season)
        seasons.setdefault(season_key, [])
        seasons[season_key].append(original_message_id)
        return
    return


def load_topics():
    if not TOPICS_FILE.exists():
        return {}
    try:
        with open(TOPICS_FILE, "r", encoding="utf-8") as f:
            data = json.load(f)

        changed = False
        for tid, info in list(data.items()):
            if "name" not in info:
                del data[tid]
                changed = True
                continue
            if "messages" not in info:
                info["messages"] = []
                changed = True
            if "created_at" not in info:
                info["created_at"] = 0
                changed = True
            if info.get("is_pelis") and "movies" not in info:
                info["movies"] = []
                changed = True
            ensure_season_structure(info)

        if changed:
            save_topics(data)

        return data
    except Exception as e:
        print("[load_topics] ERROR cargando JSON:", e)
        return {}


def save_topics(data):
    try:
        with open(TOPICS_FILE, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4, ensure_ascii=False)
    except Exception as e:
        print("[save_topics] ERROR guardando JSON:", e)


def get_pelis_topic_id(topics=None):
    if topics is None:
        topics = load_topics()
    for tid, info in topics.items():
        if info.get("is_pelis"):
            return tid
    return None


def load_users():
    if not USERS_FILE.exists():
        return {}
    try:
        with open(USERS_FILE, "r", encoding="utf-8") as f:
            return json.load(f)
    except Exception as e:
        print("[load_users] ERROR:", e)
        return {}


def save_users(data):
    try:
        with open(USERS_FILE, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4, ensure_ascii=False)
    except Exception as e:
        print("[save_users] ERROR:", e)


def load_banned():
    if not BANNED_FILE.exists():
        return {}
    try:
        with open(BANNED_FILE, "r", encoding="utf-8") as f:
            data = json.load(f)
            if isinstance(data, dict):
                return data
            return {}
    except Exception as e:
        print("[load_banned] ERROR:", e)
        return {}


def save_banned(data):
    try:
        with open(BANNED_FILE, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4, ensure_ascii=False)
    except Exception as e:
        print("[save_banned] ERROR:", e)


def get_ban_reason(user_id: int):
    data = load_banned()
    info = data.get(str(user_id))
    if not info:
        return None
    if isinstance(info, dict):
        return info.get("reason")
    return str(info)


async def ban_guard_message(update: Update, context: ContextTypes.DEFAULT_TYPE):
    user = update.effective_user
    if user is None:
        return

    reason = get_ban_reason(user.id)
    if not reason:
        return

    chat = update.effective_chat
    if chat:
        try:
            await chat.send_message(
                "⛔ No puedes usar este bot porque has sido baneado.\n"
                f"Motivo: <b>{escape(fix_text(str(reason)))}</b>",
                parse_mode="HTML",
            )
        except Exception as e:
            print("[ban_guard_message] Error enviando mensaje de ban:", e)

    raise ApplicationHandlerStop()


async def ban_guard_callback(update: Update, context: ContextTypes.DEFAULT_TYPE):
    user = update.effective_user
    if user is None:
        return

    reason = get_ban_reason(user.id)
    if not reason:
        return

    query = update.callback_query
    if query:
        try:
            await query.answer(
                "⛔ No puedes usar este bot porque has sido baneado.",
                show_alert=True,
            )
            message = query.message
            chat = message.chat if message else None
            if chat:
                await chat.send_message(
                    "⛔ No puedes usar este bot porque has sido baneado.\n"
                    f"Motivo: <b>{escape(fix_text(str(reason)))}</b>",
                    parse_mode="HTML",
                )
        except Exception as e:
            print("[ban_guard_callback] Error enviando mensaje de ban:", e)

    raise ApplicationHandlerStop()


def load_settings():
    if not SETTINGS_FILE.exists():
        return {}
    try:
        with open(SETTINGS_FILE, "r", encoding="utf-8") as f:
            return json.load(f)
    except Exception as e:
        print("[load_settings] ERROR:", e)
        return {}


def save_settings(data):
    try:
        with open(SETTINGS_FILE, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4, ensure_ascii=False)
    except Exception as e:
        print("[save_settings] ERROR:", e)


def load_requests():
    if not REQUESTS_FILE.exists():
        return {}
    try:
        with open(REQUESTS_FILE, "r", encoding="utf-8") as f:
            data = json.load(f)
            if isinstance(data, dict):
                return data
            return {}
    except Exception as e:
        print("[load_requests] ERROR:", e)
        return {}

def save_requests(data):
    try:
        with open(REQUESTS_FILE, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4, ensure_ascii=False)
    except Exception as e:
        print("[save_requests] ERROR guardando:", e)


# ======================================================
#    LÍMITE DE PETICIONES (1 por usuario al día)
# ======================================================
def load_rate_limits():
    if not RATE_LIMITS_FILE.exists():
        return {}
    try:
        with open(RATE_LIMITS_FILE, "r", encoding="utf-8") as f:
            data = json.load(f)
            return data if isinstance(data, dict) else {}
    except Exception as e:
        print("[load_rate_limits] ERROR:", e)
        return {}

def save_rate_limits(data):
    try:
        with open(RATE_LIMITS_FILE, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4, ensure_ascii=False)
    except Exception as e:
        print("[save_rate_limits] ERROR:", e)

def _today_key_madrid():
    try:
        if ZoneInfo:
            return datetime.now(ZoneInfo("Europe/Madrid")).date().isoformat()
    except Exception:
        pass
    return datetime.now().date().isoformat()

def check_and_consume_daily_request(user_id: int):
    """Devuelve (ok:bool, msg:str|None). Si ok, consume la petición del día."""
    data = load_rate_limits()
    uid = str(user_id)
    today = _today_key_madrid()
    last_day = data.get(uid)

    if last_day == today:
        return False, "⏳ Solo puedes hacer <b>1 petición al día</b>.\nVuelve a intentarlo mañana."
    data[uid] = today
    save_rate_limits(data)
    return True, None


async def delete_request_card_and_forget(context: ContextTypes.DEFAULT_TYPE, reqs: dict, req_id: str):
    """Borra la tarjeta (mensaje) del tema de control y elimina la solicitud de requests.json."""
    req = reqs.get(req_id)
    if not req:
        return

    try:
        control_mid = req.get("control_message_id")
        if control_mid:
            await context.bot.delete_message(chat_id=GROUP_ID, message_id=control_mid)
    except Exception as e:
        print(f"[delete_request_card_and_forget] No se pudo borrar la tarjeta {req_id}: {e}")

    try:
        reqs.pop(req_id, None)
        save_requests(reqs)
    except Exception as e:
        print(f"[delete_request_card_and_forget] No se pudo eliminar del JSON {req_id}: {e}")

def register_user_from_update(update: Update):
    user = update.effective_user
    msg = update.effective_message
    if user is None or msg is None:
        return

    users = load_users()
    uid = str(user.id)
    if uid not in users:
        name = user.full_name or (user.username or f"ID {user.id}")
        username = f"@{user.username}" if user.username else ""
        first_seen = msg.date.timestamp() if msg.date else 0
        users[uid] = {
            "id": user.id,
            "name": name,
            "username": username,
            "first_seen": first_seen,
        }
        save_users(users)


# ======================================================
#    DETECTAR TEMAS Y GUARDAR MENSAJES
# ======================================================

async def reanalizar(update: Update, context: ContextTypes.DEFAULT_TYPE):
    user_id = update.effective_user.id
    if user_id != OWNER_ID:
        await update.message.reply_text("⛔ No tienes permiso para usar este comando.")
        return

    topics = load_topics()
    if not topics:
        await update.message.reply_text("No hay series registradas todavía.")
        return

    letters = [
        "A","B","C","D","E","F","G","H","I","J","K","L","M",
        "N","O","P","Q","R","S","T","U","V","W","X","Y","Z","#"
    ]

    keyboard = []
    row = []
    for idx, lt in enumerate(letters, start=1):
        text = lt if lt != "#" else "🅿️"
        row.append(InlineKeyboardButton(text, callback_data=f"reanal_abc:{lt}"))
        if idx % 7 == 0:
            keyboard.append(row)
            row = []
    if row:
        keyboard.append(row)

    keyboard.append([InlineKeyboardButton("❌ Cancelar", callback_data="reanal_cancel")])

    await update.message.reply_text(
        "🔁 <b>Reanalizar series</b>\n"
        "Elige la letra inicial de la serie que quieres reanalizar:",
        parse_mode="HTML",
        reply_markup=InlineKeyboardMarkup(keyboard),
    )


async def reanalizar_callback(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()

    data = query.data
    topics = load_topics()

    if data == "reanal_cancel":
        await query.edit_message_text(
            "Operación cancelada.",
            parse_mode="HTML",
            reply_markup=build_main_keyboard(),
        )
        return

    if data.startswith("reanal_abc:"):
        _, letter = data.split(":", 1)
        letter = letter.upper()

        items = filtrar_por_letra(topics, letter)
        items = [(tid, info.get("name", "")) for tid, info in items]

        if not items:
            await query.edit_message_text(
                f"📭 No hay series que empiecen por {letter}.",
                reply_markup=InlineKeyboardMarkup(
                    [[InlineKeyboardButton("🔙 Volver", callback_data="reanal_cancel")]]
                ),
            )
            return

        context.user_data["reanal_items"] = items
        context.user_data["reanal_letter"] = letter

        return await reanalizar_show_page(query, context, page=1)

    if data.startswith("reanal_page:"):
        _, page_str = data.split(":", 1)
        try:
            page = int(page_str)
        except:
            page = 1
        return await reanalizar_show_page(query, context, page)

    if data.startswith("reanal_do:"):
        _, topic_id = data.split(":", 1)
        topic_id = str(topic_id)

        if topic_id not in topics:
            await query.edit_message_text("❌ Serie no encontrada.")
            return

        info = topics[topic_id]
        ensure_season_structure(info)
        name = fix_text(info.get("name", "Serie"))

        # Reiniciar análisis/estructura
        info["seasons"] = {}
        info["seasons_built"] = False
        info["current_season"] = 1
        info["has_header_image"] = False

        # Reiniciar extras
        info["extras"] = []
        info["is_extras_section"] = False
        info["capture_extras_id"] = 0
        info["extras_groups"] = []
        info["extras_capture_buffer"] = []
        info["extras_capture_title"] = ""

        save_topics(topics)

        await query.edit_message_text(
            f"✔ El análisis de <b>{name}</b> ha sido reiniciado.\n"
            "Cuando vuelvas a abrirla desde el catálogo, se analizará de nuevo.",
            parse_mode="HTML",
        )
        return


async def reanalizar_show_page(query, context, page: int):
    items = context.user_data.get("reanal_items") or []
    letter = context.user_data.get("reanal_letter") or "A"

    per_page = 10
    total = len(items)
    total_pages = max(1, (total + per_page - 1) // per_page)
    page = max(1, min(page, total_pages))

    subset = items[(page-1)*per_page : page*per_page]

    kb = []
    for tid, name in subset:
        kb.append([InlineKeyboardButton(f"📺 {name}", callback_data=f"reanal_do:{tid}")])

    nav = []
    if page > 1:
        nav.append(InlineKeyboardButton("⬅️", callback_data=f"reanal_page:{page-1}"))
    nav.append(InlineKeyboardButton(f"{page}/{total_pages}", callback_data="noop"))
    if page < total_pages:
        nav.append(InlineKeyboardButton("➡️", callback_data=f"reanal_page:{page+1}"))
    kb.append(nav)

    kb.append([InlineKeyboardButton("🔙 Letras", callback_data="reanal_cancel")])

    await query.edit_message_text(
        f"🔁 Elige la serie a reanalizar (letra {letter}):",
        reply_markup=InlineKeyboardMarkup(kb),
    )

async def detect(update: Update, context: ContextTypes.DEFAULT_TYPE):
    msg = update.message
    if msg is None:
        return

    # Solo el grupo configurado
    if msg.chat.id != GROUP_ID:
        return

    # Solo mensajes dentro de un tema
    if msg.message_thread_id is None:
        return

    topic_id = str(msg.message_thread_id)
    topics = load_topics()
 
    # Saltar el tema de análisis (no registrar allí)
    settings = load_settings()
    analyze_tid = str(settings.get("analyze_topic_id", "")) if settings else ""
    control_tid = str(settings.get("control_topic_id", "")) if settings else ""

    # Saltar tema de análisis y tema de control
    if (analyze_tid and topic_id == analyze_tid) or (control_tid and topic_id == control_tid):
        return

    # Si el tema está silenciado, no registramos nada
    if topic_id in topics and topics[topic_id].get("muted"):
        return

    # Crear registro del tema si no existía
    if topic_id not in topics:
        if msg.forum_topic_created:
            # Nombre EXACTO del tema en Telegram
            topic_name = msg.forum_topic_created.name or f"Tema {topic_id}"
        else:
            topic_name = f"Tema {topic_id}"

        topics[topic_id] = {
            "name": topic_name,
            "messages": [],
            "created_at": msg.date.timestamp() if msg.date else 0,
        }

        try:
            await msg.reply_text(
                f"📄 Tema detectado y guardado:\n<b>{escape(fix_text(topic_name))}</b>",
                parse_mode="HTML",
            )
        except Exception as e:
            print("[detect] Error al avisar tema nuevo:", e)
    else:
        # Si ya existía pero no tiene created_at (casos antiguos), lo ponemos ahora
        if "created_at" not in topics[topic_id]:
            topics[topic_id]["created_at"] = msg.date.timestamp() if msg.date else 0
        # Aseguramos estructura peli si procede
        if topics[topic_id].get("is_pelis") and "movies" not in topics[topic_id]:
            topics[topic_id]["movies"] = []
        # Estructura de temporadas en series
        ensure_season_structure(topics[topic_id])

    capture_extras_id = topics[topic_id].get("capture_extras_id", 0)

    if capture_extras_id != 0:  # Si está activo, capturamos
        file_obj = (
            msg.document
            or msg.video
            or msg.animation
            or msg.photo
            or msg.audio
            or msg.voice
        )

        if file_obj:
            topics[topic_id]["extras_capture_buffer"].append(msg.message_id)
            save_topics(topics)
            return

    # Guardar cada mensaje dentro del tema
    topics[topic_id]["messages"].append({"id": msg.message_id})

    # Si no es pelis, procesamos temporadas (solo si no estamos en modo captura de extras)
    if not topics[topic_id].get("is_pelis"):
        try:
            if capture_extras_id == 0:
                 process_message_for_seasons(topics[topic_id], msg, msg.message_id)
        except Exception as e:
            print(f"[detect] Error process_message_for_seasons: {e}")

    # Si es el tema de películas, indexamos con unique_id SOLO si es mp4
    if topics[topic_id].get("is_pelis"):
        file_obj = msg.document or msg.video or msg.animation
        if file_obj:
            mime = getattr(file_obj, "mime_type", "") or ""
            filename = (file_obj.file_name or "").lower()

            # Solo indexar vídeos mp4
            if mime == "video/mp4" or filename.endswith(".mp4"):
                unique_id = file_obj.file_unique_id
                raw_title = (msg.caption or file_obj.file_name or "").strip()

                first_line = raw_title.split("\n")[0].strip()
                title = limpiar_titulo(first_line)

                topics[topic_id].setdefault("movies", [])
                duplicado = any(
                    m.get("unique_id") == unique_id
                    for m in topics[topic_id]["movies"]
                )
                if not duplicado:
                    topics[topic_id]["movies"].append(
                        {"id": msg.message_id, "title": title, "unique_id": unique_id, "file_name": (file_obj.file_name or "")}
                    )

    save_topics(topics)


# ======================================================
#    ORDENAR TEMAS
# ======================================================
def ordenar_temas(items):
    def clave(item):
        _tid, info = item
        nombre = info.get("name", "").strip()
        if not nombre:
            return (2, "", 0, "")

        first, base = get_first_and_base(nombre)
        if base is None:
            return (2, "", 0, nombre.lower())

        base_key = base
        upper_first = first.upper()

        if not ("A" <= base <= "Z"):
            return (0, base_key, 0, nombre.lower())

        if upper_first == "Ñ":
            base_key = "N"
            accent_rank = 2
        else:
            accent_rank = 0 if upper_first != base_key else 1

        return (1, base_key, accent_rank, nombre.lower())

    return sorted(items, key=clave)


def filtrar_por_letra(topics, letter):
    letter = letter.upper()
    filtrados = []

    for tid, info in topics.items():
        nombre = info.get("name", "")
        nombre_strip = nombre.strip()
        if not nombre_strip:
            continue

        first, base = get_first_and_base(nombre_strip)
        if base is None:
            continue

        if letter == "#":
            if not ("A" <= base <= "Z"):
                filtrados.append((tid, info))
        else:
            if base == letter:
                filtrados.append((tid, info))

    return ordenar_temas(filtrados)


# ======================================================
#    TECLADO PRINCIPAL
# ======================================================
def build_main_keyboard():
    rows = []
    letters = list("ABCDEFGHIJKLMNOPQRSTUVWXYZ")

    for i in range(0, len(letters), 5):
        chunk = letters[i: i + 5]
        row = [
            InlineKeyboardButton(l, callback_data=f"letter:{l}")
            for l in chunk
        ]
        rows.append(row)

    rows.append(
        [InlineKeyboardButton("#", callback_data="letter:#")]
    )

    rows.append(
        [
            InlineKeyboardButton("🔍 Buscar series", callback_data="search"),
            InlineKeyboardButton("🕒 Series recientes", callback_data="recent"),
        ]
    )

    rows.append(
        [
            InlineKeyboardButton("🍿 Películas", callback_data="pelis"),
            InlineKeyboardButton("🕒 Películas recientes", callback_data="pelis_recent"),
        ]
    )

    rows.append([
        InlineKeyboardButton("🎲 Serie aleatoria", callback_data="rnd_serie"),
        InlineKeyboardButton("🎬 Película aleatoria", callback_data="rnd_peli"),
    ])

    rows.append(
        [
            InlineKeyboardButton("📥 Pedir actualizar", callback_data="req_update"),
            InlineKeyboardButton("⚠️ Informar error", callback_data="rep_error"),
        ]
    )

    return InlineKeyboardMarkup(rows)


async def show_main_menu(chat, context: ContextTypes.DEFAULT_TYPE):
    context.user_data.pop("search_mode", None)
    await chat.send_message(
        "🎬 <b>Catálogo de series</b>\n"
        "Elige una letra, pulsa Series recientes, Películas o escribe el nombre de una serie para buscar.",
        parse_mode="HTML",
        reply_markup=build_main_keyboard(),
    )


# ======================================================
#    /START y /TEMAS
# ======================================================
def _ensure_series_payloads(topics: dict) -> bool:
    """Asegura que cada serie tenga un payload estable. Devuelve True si hubo cambios."""
    changed = False
    for tid, info in topics.items():
        if info.get("is_pelis"):
            continue
        if not info.get("payload"):
            info["payload"] = f"s{tid}"
            changed = True
    if changed:
        save_topics(topics)
    return changed


def _find_series_topic_id_by_payload(payload: str, topics: dict):
    payload = (payload or "").strip()
    if not payload:
        return None

    # 1) Si el payload es "s<topic_id>" y existe ese topic_id
    if payload.startswith("s"):
        raw = payload[1:]
        if raw.isdigit() and raw in topics and not topics[raw].get("is_pelis"):
            return raw

    # 2) Buscar por campo info["payload"]
    for tid, info in topics.items():
        if info.get("is_pelis"):
            continue
        if (info.get("payload") or "").strip() == payload:
            return str(tid)

    return None


def _build_seasons_keyboard(topic_id: str, info: dict) -> InlineKeyboardMarkup:
    """Construye el teclado de temporadas reutilizando tu callback sendseason."""
    ensure_season_structure(info)
    seasons = info.get("seasons") or {}
    extras_groups = info.get("extras_groups") or []

    def num_emoji(n: int) -> str:
        mapping = {0:"0️⃣",1:"1️⃣",2:"2️⃣",3:"3️⃣",4:"4️⃣",5:"5️⃣",6:"6️⃣",7:"7️⃣",8:"8️⃣",9:"9️⃣"}
        return mapping.get(n, str(n))

    keyboard = []

    for s in sorted(seasons.keys(), key=lambda x: int(x)):
        num = int(s)
        emoji = num_emoji(num)
        keyboard.append([InlineKeyboardButton(f"{emoji} Temporada {s}", callback_data=f"sendseason:{topic_id}:{s}")])

    for idx_ex, g in enumerate(extras_groups):
        if not isinstance(g, dict):
            continue
        msgs = g.get("messages") or []
        if not msgs:
            continue
        btn_text = g.get("title") or "➕ Extras"
        keyboard.append([InlineKeyboardButton(btn_text, callback_data=f"sendseason:{topic_id}:extras:{idx_ex}")])

    keyboard.append([InlineKeyboardButton("🎬 Serie completa", callback_data=f"sendseason:{topic_id}:all")])
    keyboard.append([InlineKeyboardButton("🔙 Volver al catálogo", callback_data="main_menu")])

    return InlineKeyboardMarkup(keyboard)

async def start(update: Update, context: ContextTypes.DEFAULT_TYPE):
    chat = update.effective_chat

    if chat.type != "private":
        await update.message.reply_text("Entra en privado conmigo para ver el catálogo 😊")
        return

    register_user_from_update(update)

    # Si viene payload: /start <payload>
    if context.args:
        payload = context.args[0].strip()
        topics = load_topics()
        _ensure_series_payloads(topics)

        topic_id = _find_series_topic_id_by_payload(payload, topics)
        if topic_id and topic_id in topics:
            info = topics[topic_id]
            if info.get("is_pelis"):
                await show_main_menu(chat, context)
                return

            bot = context.bot
            user_id = update.effective_user.id

            # Asegura análisis si hace falta (para que haya temporadas)
            await _ensure_series_analyzed_if_needed(bot, user_id, topic_id, topics, info)

            # Recarga por si cambió tras analizar
            topics = load_topics()
            info = topics.get(topic_id, info)

            markup = _build_seasons_keyboard(topic_id, info)

            await chat.send_message(
                f"📺 <b>{escape(fix_text(info.get('name','Serie')))}</b>\nElige una temporada:",
                parse_mode="HTML",
                reply_markup=markup,
            )
            return

    # Si no hay payload o es inválido: menú normal
    await show_main_menu(chat, context)


async def temas(update: Update, context: ContextTypes.DEFAULT_TYPE):
    chat = update.effective_chat
    if chat.type != "private":
        await update.message.reply_text("Usa /temas en privado.")
        return
    await show_main_menu(chat, context)


# ======================================================
#    HANDLER: letra pulsada
# ======================================================
def get_hidden_topic():
    if not HIDDEN_FILE.exists():
        return None
    try:
        return HIDDEN_FILE.read_text().strip()
    except:
        return None

def build_letter_page(letter, page, topics_dict):
    filtrados = filtrar_por_letra(topics_dict, letter)
    hidden = get_hidden_topic()
    if hidden:
        filtrados = [i for i in filtrados if i[0] != hidden]

    total = len(filtrados)
    if total == 0:
        return (
            f"📭 No hay series que empiecen por <b>{escape(letter)}</b>.",
            InlineKeyboardMarkup(
                [[InlineKeyboardButton("🔙 Volver", callback_data="main_menu")]]
            ),
        )

    total_pages = max(1, math.ceil(total / PAGE_SIZE))
    page = max(1, min(page, total_pages))

    start_idx = (page - 1) * PAGE_SIZE
    end_idx = start_idx + PAGE_SIZE
    slice_items = filtrados[start_idx:end_idx]

    keyboard = []
    for tid, info in slice_items:
        name = info.get("name", "")
        safe_name = escape(fix_text(name))
        keyboard.append(
            [InlineKeyboardButton(f"🎬 {safe_name}", callback_data=f"t:{tid}")]
        )

    nav_row = []
    if total_pages > 1:
        if page > 1:
            nav_row.append(
                InlineKeyboardButton(
                    "⬅️ Anterior", callback_data=f"page:{letter}:{page-1}"
                )
            )
        nav_row.append(
            InlineKeyboardButton(f"{page}/{total_pages}", callback_data="noop")
        )
        if page < total_pages:
            nav_row.append(
                InlineKeyboardButton(
                    "Siguiente ➡️", callback_data=f"page:{letter}:{page+1}"
                )
            )
    if nav_row:
        keyboard.append(nav_row)

    keyboard.append(
        [InlineKeyboardButton("🔙 Volver", callback_data="main_menu")]
    )

    if letter == "#":
        title = "🎬 <b>Series que empiezan por número o símbolo</b>"
    else:
        title = f"🎬 <b>Series que empiezan por “{escape(letter)}”</b>"

    text = f"{title}\nMostrando {len(slice_items)} de {total}."

    return text, InlineKeyboardMarkup(keyboard)



def build_request_letters_keyboard(mode: str):
    rows = []
    letters = list("ABCDEFGHIJKLMNOPQRSTUVWXYZ") + ["#"]

    row = []
    for idx, lt in enumerate(letters, start=1):
        text_btn = lt if lt != "#" else "🅿️"
        row.append(InlineKeyboardButton(text_btn, callback_data=f"req_letter:{mode}:{lt}"))
        if idx % 7 == 0:
            rows.append(row)
            row = []
    if row:
        rows.append(row)

    rows.append([InlineKeyboardButton("🔙 Volver", callback_data="main_menu")])
    return InlineKeyboardMarkup(rows)


def build_request_series_page(mode: str, letter: str, page: int, topics_dict):
    filtrados = filtrar_por_letra(topics_dict, letter)
    hidden = get_hidden_topic()
    if hidden:
        filtrados = [i for i in filtrados if i[0] != hidden]

    total = len(filtrados)
    if total == 0:
        return (
            f"📭 No hay series que empiecen por <b>{escape(letter)}</b>.",
            InlineKeyboardMarkup(
                [
                    [InlineKeyboardButton("🔤 Elegir otra letra", callback_data=f"req_letters:{mode}")],
                    [InlineKeyboardButton("🔙 Volver", callback_data="main_menu")],
                ]
            ),
        )

    total_pages = max(1, math.ceil(total / PAGE_SIZE))
    page = max(1, min(page, total_pages))

    start_idx = (page - 1) * PAGE_SIZE
    end_idx = start_idx + PAGE_SIZE
    slice_items = filtrados[start_idx:end_idx]

    keyboard = []
    for tid, info in slice_items:
        name = info.get("name", "")
        safe_name = escape(fix_text(name))
        keyboard.append(
            [InlineKeyboardButton(f"🎬 {safe_name}", callback_data=f"req_series:{mode}:{tid}")]
        )

    nav_row = []
    if total_pages > 1:
        if page > 1:
            nav_row.append(
                InlineKeyboardButton(
                    "⬅️ Anterior", callback_data=f"req_page:{mode}:{letter}:{page-1}"
                )
            )
        nav_row.append(
            InlineKeyboardButton(f"{page}/{total_pages}", callback_data="noop")
        )
        if page < total_pages:
            nav_row.append(
                InlineKeyboardButton(
                    "Siguiente ➡️", callback_data=f"req_page:{mode}:{letter}:{page+1}"
                )
            )
    if nav_row:
        keyboard.append(nav_row)

    keyboard.append(
        [InlineKeyboardButton("🔤 Elegir otra letra", callback_data=f"req_letters:{mode}")]
    )
    keyboard.append(
        [InlineKeyboardButton("🔙 Volver", callback_data="main_menu")]
    )

    if letter == "#":
        title = "🎬 Series que empiezan por número o símbolo"
    else:
        title = f"🎬 Series que empiezan por “{escape(letter)}”"

    text_page = f"{title}\nMostrando {len(slice_items)} de {total}."

    return text_page, InlineKeyboardMarkup(keyboard)


async def on_letter(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    _, letter = query.data.split(":", 1)
    topics = load_topics()

    text, markup = build_letter_page(letter, 1, topics)

    try:
        await query.edit_message_text(
            text=text,
            parse_mode="HTML",
            reply_markup=markup,
        )
    except Exception as e:
        print("[on_letter] Error editando mensaje:", e)


async def on_page(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()

    _, letter, page_str = query.data.split(":", 2)
    page = int(page_str)

    topics = load_topics()
    text, markup = build_letter_page(letter, page, topics)

    try:
        await query.edit_message_text(
            text=text,
            parse_mode="HTML",
            reply_markup=markup,
        )
    except Exception as e:
        print("[on_page] Error editando mensaje:", e)


# ======================================================
#    HANDLER: MAIN MENU / BUSCAR / RECIENTES / PELÍCULAS
# ======================================================
async def on_main_menu(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    try:
        await query.edit_message_text(
            "🎬 <b>Catálogo de series</b>\n"
            "Elige una letra, pulsa Series recientes, Películas o escribe el nombre de una serie para buscar.",
            parse_mode="HTML",
            reply_markup=build_main_keyboard(),
        )
        context.user_data.pop("search_mode", None)
    except Exception as e:
        print("[on_main_menu] Error editando mensaje:", e)


async def on_search_btn(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    chat = query.message.chat

    if chat.type != "private":
        await query.edit_message_text("🔍 Usa la búsqueda en privado conmigo.")
        return

    context.user_data["search_mode"] = "series"

    try:
        await query.edit_message_text(
            "🔍 <b>Buscar serie</b>\n"
            "Escribe el nombre o parte del nombre de la serie en el chat.",
            parse_mode="HTML",
            reply_markup=InlineKeyboardMarkup(
                [[InlineKeyboardButton("🔙 Volver", callback_data="main_menu")]]
            ),
        )
    except Exception as e:
        print("[on_search_btn] Error editando mensaje:", e)


async def on_recent_btn(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    chat = query.message.chat
    if chat.type != "private":
        await query.edit_message_text("🕒 Usa Series recientes en privado conmigo.")
        return

    topics = load_topics()
    if not topics:
        await query.edit_message_text(
            "📭 No hay series aún.",
            reply_markup=InlineKeyboardMarkup(
                [[InlineKeyboardButton("🔙 Volver", callback_data="main_menu")]]
            ),
        )
        return

    # Ordenamos por created_at descendente
    items = list(topics.items())
    items.sort(key=lambda x: x[1].get("created_at", 0), reverse=True)
    hidden = get_hidden_topic()
    items = [i for i in items if i[0] != hidden][:RECENT_LIMIT]

    keyboard = []
    for tid, info in items:
        safe_name = escape(fix_text(info.get("name", "")))
        keyboard.append(
            [InlineKeyboardButton(f"🎬 {safe_name}", callback_data=f"t:{tid}")]
        )

    keyboard.append([InlineKeyboardButton("🔙 Volver", callback_data="main_menu")])

    try:
        await query.edit_message_text(
            "🕒 <b>Series recientes</b>",
            parse_mode="HTML",
            reply_markup=InlineKeyboardMarkup(keyboard),
        )
    except Exception as e:
        print("[on_recent_btn] Error editando mensaje:", e)


async def on_req_update_btn(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    chat = query.message.chat

    if chat.type != "private":
        await query.edit_message_text("📥 Usa esta opción en privado conmigo.")
        return

    context.user_data["request_mode"] = "update"
    await query.edit_message_text(
        "📥 <b>Pedir actualización</b>\n"
        "Elige la letra inicial de la serie:",
        parse_mode="HTML",
        reply_markup=build_request_letters_keyboard("update"),
    )


async def on_rep_error_btn(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    chat = query.message.chat

    if chat.type != "private":
        await query.edit_message_text("⚠️ Usa esta opción en privado conmigo.")
        return

    context.user_data["request_mode"] = "error"
    await query.edit_message_text(
        "⚠️ <b>Informar error</b>\n"
        "Elige la letra inicial de la serie:",
        parse_mode="HTML",
        reply_markup=build_request_letters_keyboard("error"),
    )


async def on_req_letters(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    _, mode = query.data.split(":", 1)

    await query.edit_message_text(
        ("📥 <b>Pedir actualización</b>\n" if mode == "update" else "⚠️ <b>Informar error</b>\n")
        + "Elige la letra inicial de la serie:",
        parse_mode="HTML",
        reply_markup=build_request_letters_keyboard(mode),
    )


async def on_req_letter(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    _, mode, letter = query.data.split(":", 2)
    topics = load_topics()

    text_page, markup = build_request_series_page(mode, letter, 1, topics)
    await query.edit_message_text(
        text=text_page,
        parse_mode="HTML",
        reply_markup=markup,
    )


async def on_req_page(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    _, mode, letter, page_str = query.data.split(":", 3)
    page = int(page_str)
    topics = load_topics()

    text_page, markup = build_request_series_page(mode, letter, page, topics)
    await query.edit_message_text(
        text=text_page,
        parse_mode="HTML",
        reply_markup=markup,
    )

async def on_pelis_btn(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    chat = query.message.chat

    if chat.type != "private":
        await query.edit_message_text("🍿 Usa Películas en privado conmigo.")
        return

    context.user_data["search_mode"] = "pelis"

    try:
        await query.edit_message_text(
            "🍿 <b>Búsqueda de películas</b>\n"
            "Escribe el título o parte del título de la película que buscas.",
            parse_mode="HTML",
            reply_markup=InlineKeyboardMarkup(
                [[InlineKeyboardButton("🔙 Volver", callback_data="main_menu")]]
            ),
        )
    except Exception as e:
        print("[on_pelis_btn] Error editando mensaje:", e)

async def on_pelis_recent_btn(update: Update, context: ContextTypes.DEFAULT_TYPE):

    query = update.callback_query

    await query.answer()

    chat = query.message.chat

    if chat.type != "private":
        await query.edit_message_text("🕒 Usa Películas recientes en privado conmigo.")
        return

    topics = load_topics()
    pelis_tid = get_pelis_topic_id(topics)

    if not pelis_tid or pelis_tid not in topics:
        await query.edit_message_text(
            "🍿 No hay un tema configurado como <b>Películas</b>.",
            parse_mode="HTML",
            reply_markup=InlineKeyboardMarkup(
                [[InlineKeyboardButton("🔙 Volver", callback_data="main_menu")]]
            ),
        )
        return

    info = topics[pelis_tid]
    movies = info.get("movies", [])

    if not movies:
        await query.edit_message_text(
            "🍿 Aún no hay películas indexadas.\n"
            "Sube películas con descripción al tema configurado.",
            parse_mode="HTML",
            reply_markup=InlineKeyboardMarkup(
                [[InlineKeyboardButton("🔙 Volver", callback_data="main_menu")]]
            ),
        )
        return

    # Últimas MOVIES_RECENT_LIMIT películas (más nuevas primero)
    recientes = movies[-MOVIES_RECENT_LIMIT:]
    recientes = list(reversed(recientes))

    keyboard = []
    for m in recientes:
        mid = m.get("id")
        title = m.get("title", "")
        if not mid or not title:
            continue

        safe_title = escape(fix_text(title))
        keyboard.append(
            [
                InlineKeyboardButton(
                    f"🎬 {safe_title}",
                    callback_data=f"pelis_msg:{pelis_tid}:{mid}",
                )
            ]
        )

    if not keyboard:
        await query.edit_message_text(
            "🍿 No hay películas recientes para mostrar.",
            parse_mode="HTML",
            reply_markup=InlineKeyboardMarkup(
                [[InlineKeyboardButton("🔙 Volver", callback_data="main_menu")]]
            ),
        )
        return

    keyboard.append([InlineKeyboardButton("🔙 Volver", callback_data="main_menu")])

    await query.edit_message_text(
        "🕒 <b>Películas recientes</b>",
        parse_mode="HTML",
        reply_markup=InlineKeyboardMarkup(keyboard),
    )


# ======================================================
#    Paginación de resultados de películas
# ======================================================
def build_pelis_page(page: int, results: list, topic_id: str, original_query: str | None = None):
    total = len(results)
    if total == 0:
        text = "🍿 No hay resultados de películas para mostrar."
        markup = InlineKeyboardMarkup(
            [[InlineKeyboardButton("🔙 Volver", callback_data="main_menu")]]
        )
        return text, markup

    total_pages = max(1, math.ceil(total / MOVIES_PAGE_SIZE))
    page = max(1, min(page, total_pages))

    start_idx = (page - 1) * MOVIES_PAGE_SIZE
    end_idx = start_idx + MOVIES_PAGE_SIZE
    slice_items = results[start_idx:end_idx]

    keyboard = []
    for mid, title in slice_items:
        safe_title = escape(fix_text(title))
        keyboard.append(
            [
                InlineKeyboardButton(
                    f"🎬 {safe_title}",
                    callback_data=f"pelis_msg:{topic_id}:{mid}",
                )
            ]
        )

    # Navegación
    nav_row = []
    if total_pages > 1:
        if page > 1:
            nav_row.append(
                InlineKeyboardButton("⬅️", callback_data=f"pelis_page:{page-1}")
            )
        nav_row.append(
            InlineKeyboardButton(f"{page}/{total_pages}", callback_data="noop")
        )
        if page < total_pages:
            nav_row.append(
                InlineKeyboardButton("➡️", callback_data=f"pelis_page:{page+1}")
            )
    if nav_row:
        keyboard.append(nav_row)

    keyboard.append(
        [InlineKeyboardButton("🔙 Volver", callback_data="main_menu")]
    )

    if original_query:
        header = f"🍿 Resultados para: <b>{escape(fix_text(original_query))}</b>\n"
    else:
        header = "🍿 Resultados de películas\n"

    text = header + f"Página {page}/{total_pages} (mostrando {len(slice_items)} de {total})."
    return text, InlineKeyboardMarkup(keyboard)


# ======================================================
#    BÚSQUEDA POR TEXTO (privado)
# ======================================================
async def search_text(update: Update, context: ContextTypes.DEFAULT_TYPE):
    msg = update.message
    
    if msg is None:
        return

    chat = msg.chat

    # ----------- ERROR REPORT PENDING FIX -----------
    pending_error = context.user_data.get("error_report_pending")
    if pending_error:
        context.user_data.pop("error_report_pending", None)

        description = msg.text.strip()
        user = msg.from_user
        bot = context.bot
        topic_id = pending_error["topic_id"]
        serie_name = pending_error["serie_name"]

        ok, err = await create_control_card(
            bot,
            "error",
            user,
            topic_id,
            serie_name,
            description=description,
        )
        if not ok:
            await chat.send_message(err, parse_mode="HTML")
            return

        await chat.send_message(
            "📨 Tu informe de error ha sido enviado y será atendido por nuestro equipo.",
            parse_mode="HTML",
            reply_markup=build_main_keyboard(),
        )
        return
    # ----------- END FIX -----------

    if chat.type != "private":
        return 

    # --- Solicitud de película pendiente ---
    if context.user_data.get("movie_request_pending"):
        context.user_data.pop("movie_request_pending", None)

        texto = (msg.text or "").strip()
        if not texto:
            await chat.send_message(
                "❌ No pude leer el título de la película.\n"
                "Por favor, escribe el título y el año, por ejemplo:\n"
                "Matrix 1999",
                parse_mode="HTML",
            )
            return

        m = re.search(r"\b(19\d{2}|20\d{2})\b", texto)
        if not m:
            await chat.send_message(
                "❌ No pude detectar el año.\n"
                "Escribe el título seguido del año, por ejemplo:\n"
                "La Sirenita 2023",
                parse_mode="HTML",
            )
            return

        año = m.group(1)
        titulo = texto.replace(año, "").strip(" -()")
        if not titulo:
            await chat.send_message(
                "❌ No pude detectar el título.\n"
                "Intenta de nuevo, por ejemplo:\n"
                "Gladiator 2000",
                parse_mode="HTML",
            )
            return

        user = msg.from_user
        bot = context.bot

        ok, err = await create_movie_request_card(bot, user, titulo, año)
        if not ok:
            await chat.send_message(err, parse_mode="HTML")
            return

        await chat.send_message(
            "📨 Gracias, tu solicitud de película ha sido enviada a nuestro equipo.",
            parse_mode="HTML",
            reply_markup=build_main_keyboard(),
        )
        return

    query_text = msg.text.strip()
    if not query_text:
        await chat.send_message("Escribe parte del nombre para buscar.")
        return

    mode = context.user_data.get("search_mode", "series")

    topics = load_topics()
    if not topics:
        await chat.send_message("📭 No hay series aún.")
        return

    if mode == "pelis":
        # --- BÚSQUEDA EN TEMA PELÍCULAS ---
        pelis_tid = get_pelis_topic_id(topics)
        if not pelis_tid or pelis_tid not in topics:
            await chat.send_message(
                "🍿 No hay un tema de <b>Películas</b> configurado todavía.",
                parse_mode="HTML",
            )
            return

        info = topics[pelis_tid]
        movies = info.get("movies", [])
        if not movies:
            await chat.send_message(
                "🍿 Aún no hay películas indexadas.\n"
                "Sube películas con descripción al tema configurado.",
                parse_mode="HTML",
            )
            return

        tmdb_title = None
        tmdb_year = None
        if TMDB_TOKEN:
            resolved = resolve_movie_tmdb_no_year(query_text)
            if resolved:
                tmdb_title, tmdb_year = resolved

        q = (tmdb_title or query_text).lower()
        matches = []
        seen_ids = set()

        for m in movies:
            mid = m.get("id")
            title = m.get("title", "")
            if not mid or not title:
                continue
            if mid in seen_ids:
                continue
            t_low = title.lower()
            ok = False

            if q and q in t_low:
                ok = True

            if not ok:
                if _token_match(query_text, title):
                    ok = True

            if not ok and tmdb_title:
                if _similarity(tmdb_title, title) >= 0.72:
                    ok = True

            if ok and tmdb_year:
                years_in_title = re.findall(r"\b(19\d{2}|20\d{2})\b", title)
                if years_in_title and str(tmdb_year) not in years_in_title:
                    pass

            if ok:
                matches.append((mid, title))
                seen_ids.add(mid)

        if not matches:
            await chat.send_message(
                f"🍿 No encontré ninguna película que contenga: <b>{escape(query_text)}</b>",
                parse_mode="HTML",
                reply_markup=InlineKeyboardMarkup(
                    [[InlineKeyboardButton("🎬 Solicitar película", callback_data="req_peli")]]
                ),
            )
            return

        if tmdb_year:
            y = str(tmdb_year)
            matches.sort(key=lambda x: (0 if y in x[1] else 1, x[1].lower()))
        else:
            matches.sort(key=lambda x: x[1].lower())

        matches = matches[:PELIS_RESULT_LIMIT]

        context.user_data["pelis_results"] = matches
        context.user_data["pelis_topic_id"] = pelis_tid
        context.user_data["pelis_query"] = query_text

        text, markup = build_pelis_page(1, matches, pelis_tid, query_text)

        await chat.send_message(
            text,
            parse_mode="HTML",
            reply_markup=markup,
        )

    else:
        # --- BÚSQUEDA NORMAL DE SERIES ---
        query_lower = query_text.lower()
        matches = [
            (tid, info)
            for tid, info in topics.items()
            if query_lower in info.get("name", "").lower()
        ]

        if not matches:
            await chat.send_message(
                f"🔍 No encontré ninguna serie que contenga: <b>{escape(query_text)}</b>",
                parse_mode="HTML",
            )
            return

        matches = ordenar_temas(matches)
        matches = matches[:30]

        keyboard = []
        for tid, info in matches:
            safe_name = escape(fix_text(info.get("name", "")))
            keyboard.append(
                [InlineKeyboardButton(f"🎬 {safe_name}", callback_data=f"t:{tid}")]
            )

        keyboard.append(
            [InlineKeyboardButton("🔙 Volver", callback_data="main_menu")]
        )

        await chat.send_message(
            f"🔍 Resultados para: <b>{escape(query_text)}</b>",
            parse_mode="HTML",
            reply_markup=InlineKeyboardMarkup(keyboard),
        )


# ======================================================
#   COMANDO DIRECTO /peli (ENVÍO AUTOMÁTICO)
# ======================================================
async def peli_directo(update: Update, context: ContextTypes.DEFAULT_TYPE):
    msg = update.effective_message
    if not msg or msg.chat.type != "private":
        return

    if not context.args:
        await msg.reply_text("<b>Uso:</b> <code>/peli Titulo</code>", parse_mode="HTML")
        return

    query_text = " ".join(context.args).strip().lower()
    topics = load_topics()
    pelis_tid = get_pelis_topic_id(topics)

    if not pelis_tid or pelis_tid not in topics:
        await msg.reply_text("🍿 No hay tema de películas configurado.")
        return

    movies = topics[pelis_tid].get("movies", [])
    matches = []

    # Reutilizamos tu lógica de limpieza y búsqueda para ser precisos
    for m in movies:
        title = (m.get("title") or "").lower()
        mid = m.get("id")
        
        # Match si el texto está contenido o si hay similitud por tokens
        if query_text in title or _token_match(query_text, title):
            matches.append(mid)

    if not matches:
        await msg.reply_text(f"❌ No encontré archivos para: <b>{escape(query_text)}</b>", parse_mode="HTML")
        return

    # Avisamos que estamos enviando
    await msg.reply_text(f"🚀 Enviando <b>{len(matches)}</b> archivo(s) encontrado(s)...", parse_mode="HTML")

    # Enviamos los archivos directamente usando tu función copy_messages_safely
    await copy_messages_safely(context.bot, msg.chat_id, matches, from_chat_id=GROUP_ID)


# ======================================================
#    REENVÍO ORDENADO
# ======================================================

async def copy_messages_safely(bot, chat_id: int, message_ids, *, from_chat_id: int):
    enviados = 0
    delay = 0.035
    pausa_larga = 1.0
    paquete = 250
    for mid in message_ids:
        while True:
            try:
                await bot.copy_message(chat_id=chat_id, from_chat_id=from_chat_id, message_id=mid)
                enviados += 1
                await asyncio.sleep(delay)
                if enviados % paquete == 0:
                    await asyncio.sleep(pausa_larga)
                break
            except RetryAfter as e:
                await asyncio.sleep(int(e.retry_after) + 1)
            except BadRequest:
                break
            except Exception:
                break
    return enviados


async def forward_and_return_message(bot, chat_id: int, message_id: int, *, from_chat_id: int):
    delay = 0.15
    pausa_larga = 1.5
    enviados = 0
    while True:
        try:
            msg = await bot.forward_message(
                chat_id=chat_id,
                from_chat_id=from_chat_id,
                message_id=message_id,
                disable_notification=True
            )
            enviados += 1
            await asyncio.sleep(delay)
            if enviados % 100 == 0:
                await asyncio.sleep(pausa_larga)
            return msg
        except RetryAfter as e:
            await asyncio.sleep(int(e.retry_after) + 1)
        except BadRequest:
            return None
        except Exception:
            return None


async def send_topic(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()

    _, topic_id = query.data.split(":", 1)
    topic_id = str(topic_id)

    topics = load_topics()
    if topic_id not in topics:
        await query.edit_message_text("❌ Tema no encontrado.")
        return

    info = topics[topic_id]
    bot = context.bot
    user_id = query.from_user.id

    # Si es tema de pelis
    if info.get("is_pelis"):
        await query.edit_message_text("📨 Enviando contenido del tema...")

        mensajes = [m["id"] for m in info.get("messages", [])]
        if not mensajes:
            await bot.send_message(chat_id=user_id, text="❌ Este tema no tiene mensajes.")
            return

        enviados = await copy_messages_safely(bot, user_id, mensajes, from_chat_id=GROUP_ID)

        await bot.send_message(
            chat_id=user_id,
            text=f"✔ Envío completado. {enviados} mensajes reenviados 🎉",
            reply_markup=InlineKeyboardMarkup(
                [
                [InlineKeyboardButton("⬅️ Volver a la serie", callback_data=f"t:{topic_id}")],
                [InlineKeyboardButton("🔙 Volver al catálogo", callback_data="main_menu")]
            ]
            ),
        )
        return

    # --- SERIE ---
    ensure_season_structure(info)

    # Tema de análisis
    settings = load_settings()
    analyze_topic_id = settings.get("analyze_topic_id")
    if not analyze_topic_id:
        await query.edit_message_text(
            "⚙️ Aún no se ha configurado un tema de análisis.\n"
            "Usa /setanalisis en el grupo, dentro del tema que quieras utilizar para el análisis.",
        )
        return

    try:
        analyze_tid_int = int(analyze_topic_id)
    except (TypeError, ValueError):
        await query.edit_message_text(
            "⚙️ El valor guardado de tema de análisis no es válido. Usa /setanalisis de nuevo."
        )
        return

    # Analizar solo una vez
    if not info.get("seasons_built", False):
        mensajes = [m["id"] for m in info.get("messages", [])]

        if mensajes:
            portada = mensajes[0]
            mensajes = mensajes[1:]

        total = len(mensajes)
        if total == 0:
            await query.edit_message_text("❌ Este tema no tiene episodios que analizar.")
            return

        await query.edit_message_text(
            "☑️ Analizando la serie por primera vez…\n"
            "Esto solo ocurrirá una vez. Te mostraré el progreso en este chat."
        )

        progress_msg = await bot.send_message(chat_id=user_id, text="Progreso: 0%")
        progress_msg_id = progress_msg.message_id

        info["seasons"] = {}
        info["current_season"] = 1
        info["extras"] = [] 
        info["is_extras_section"] = False 
        info["capture_extras_id"] = 0 

        for idx, mid in enumerate(mensajes, start=1):
            fwd = None
            while True:
                try:
                    fwd = await bot.forward_message(
                        chat_id=GROUP_ID,
                        message_thread_id=analyze_tid_int,
                        from_chat_id=GROUP_ID,
                        message_id=mid,
                    )
                    await asyncio.sleep(0.08)
                    break
                except RetryAfter as e:
                    await asyncio.sleep(int(e.retry_after) + 1)
                except BadRequest as e:
                    print(f"[send_topic/analizar] BadRequest reenviando msg {mid}: {e}")
                    break
                except Exception as e:
                    print(f"[send_topic/analizar] Error reenviando msg {mid}: {e}")
                    break

            if fwd is not None:
                try:
                    process_message_for_seasons(info, fwd, mid)
                except Exception as e:
                    print(f"[send_topic/analizar] Error process_message_for_seasons msg {mid}: {e}")

                try:
                    await fwd.delete()
                except Exception:
                    pass

            if idx == total or idx % 50 == 0:
                progress = (idx / total) * 100
                try:
                    await bot.edit_message_text(
                        chat_id=user_id,
                        message_id=progress_msg_id,
                        text=f"Progreso: {progress:.1f}%"
                    )
                except Exception:
                    pass

        try:
            await bot.edit_message_text(
                chat_id=user_id,
                message_id=progress_msg_id,
                text="✔ Análisis completado. Preparando el menú de temporadas…"
            )
        except Exception:
            pass

        info["seasons_built"] = True
        save_topics(topics)

    seasons = info.get("seasons") or {}
    extras_groups = info.get("extras_groups") or []

    if not seasons and not extras_groups:
        mensajes = [m["id"] for m in info.get("messages", [])]
        if mensajes:
            mensajes = mensajes[1:]
            seasons["1"] = mensajes
            info["seasons"] = seasons
            info["current_season"] = 1
            info["seasons_built"] = True
            save_topics(topics)
        else:
            await query.edit_message_text("❌ Este tema no tiene mensajes.")
            return

    def num_emoji(n: int) -> str:
        mapping = {
            0: "0️⃣", 1: "1️⃣", 2: "2️⃣", 3: "3️⃣", 4: "4️⃣",
            5: "5️⃣", 6: "6️⃣", 7: "7️⃣", 8: "8️⃣", 9: "9️⃣",
        }
        if n in mapping:
            return mapping[n]
        return str(n)

    keyboard = []
    for s in sorted(seasons.keys(), key=lambda x: int(x)):
        num = int(s)
        emoji = num_emoji(num)
        keyboard.append(
            [InlineKeyboardButton(f"{emoji} Temporada {s}", callback_data=f"sendseason:{topic_id}:{s}")]
        )
    
    # Botones para EXTRAS
    for idx_ex, g in enumerate(extras_groups):
        if not isinstance(g, dict):
            continue
        msgs = g.get("messages") or []
        if not msgs:
            continue
        btn_text = g.get("title") or "➕ Extras"
        keyboard.append(
            [InlineKeyboardButton(btn_text, callback_data=f"sendseason:{topic_id}:extras:{idx_ex}")]
        )

    keyboard.append(
        [InlineKeyboardButton("🎬 Serie completa", callback_data=f"sendseason:{topic_id}:all")]
    )
    keyboard.append([InlineKeyboardButton("🔙 Volver", callback_data="main_menu")])

    await query.edit_message_text(
        f"📺 <b>{escape(fix_text(info.get('name', 'Serie')))}</b>\n"
        "Elige una temporada o envía la serie completa:",
        parse_mode="HTML",
        reply_markup=InlineKeyboardMarkup(keyboard),
    )


async def send_season(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()

    _, topic_id, season = query.data.split(":", 2)
    topic_id = str(topic_id)

    topics = load_topics()
    if topic_id not in topics:
        await query.edit_message_text("❌ Tema no encontrado.")
        return

    info = topics[topic_id]
    ensure_season_structure(info)
    seasons = info.get("seasons") or {}
    extras_groups = info.get("extras_groups") or []

    extras_idx = None
    if season.startswith("extras"):
        parts = season.split(":", 1)
        if len(parts) == 2 and parts[1].isdigit():
            extras_idx = int(parts[1])
        else:
            extras_idx = 0

        if extras_idx < 0 or extras_idx >= len(extras_groups):
            msg_ids = []
            label = "extras"
        else:
            g = extras_groups[extras_idx]
            msg_ids = g.get("messages", []) if isinstance(g, dict) else []
            label = g.get("title") or "extras"

    elif season == "all":
        ordered_keys = sorted(seasons.keys(), key=lambda x: int(x))
        msg_ids = []
        for key in ordered_keys:
            msg_ids.extend(seasons.get(key, []))
        for g in extras_groups:
            if isinstance(g, dict):
                msg_ids.extend(g.get("messages") or [])
        label = "serie completa"
    else:
        msg_ids = seasons.get(season, [])
        label = f"temporada {season}"

    if not msg_ids:
        if season.startswith("extras"):
            await query.edit_message_text("❌ No hay contenido extra registrado.", parse_mode="HTML")
        else:
            await query.edit_message_text("❌ No hay episodios registrados para esa temporada.", parse_mode="HTML")
        return

    await query.edit_message_text(f"📨 Enviando {label}...")

    bot = context.bot
    user_id = query.from_user.id

    enviados = await copy_messages_safely(bot, user_id, msg_ids, from_chat_id=GROUP_ID)

    await bot.send_message(
        chat_id=user_id,
        text=f"✔ Envío completado ({label}). {enviados} mensajes reenviados 🎉",
        reply_markup=InlineKeyboardMarkup(
            [
                [InlineKeyboardButton("⬅️ Volver a la serie", callback_data=f"t:{topic_id}")],
                [InlineKeyboardButton("🔙 Volver al catálogo", callback_data="main_menu")],
            ]
        ),
    )

async def send_peli_message(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    _, topic_id, mid_str = query.data.split(":", 2)
    topic_id = str(topic_id)

    try:
        mid = int(mid_str)
    except ValueError:
        await query.edit_message_text("❌ Película no encontrada.")
        return

    bot = context.bot
    user_id = query.from_user.id

    try:
        await bot.copy_message(
            chat_id=user_id,
            from_chat_id=GROUP_ID,
            message_id=mid,
        )

        await bot.send_message(
            chat_id=user_id,
            text="🍿 Película enviada.",
            reply_markup=InlineKeyboardMarkup(
                [
                    [InlineKeyboardButton("🈯️ Revisar idioma", callback_data=f"lang_review:{topic_id}:{mid}")],
                    [InlineKeyboardButton("🔙 Volver al catálogo", callback_data="main_menu")],
                ]
            ),
        )

    except Exception as e:
        print(f"[send_peli_message] ERROR copiando peli {mid}: {e}")

        topics = load_topics()
        if topic_id in topics and "movies" in topics[topic_id]:
            antes = len(topics[topic_id]["movies"])
            topics[topic_id]["movies"] = [
                m for m in topics[topic_id]["movies"] if m.get("id") != mid
            ]
            despues = len(topics[topic_id]["movies"])
            if antes != despues:
                save_topics(topics)
                print(f"[send_peli_message] Película {mid} purgada del JSON.")

        await query.edit_message_text(
            (
                "❌ Esa película ya no existe en el tema.\n"
                "Ha sido eliminada del catálogo."
            ),
            parse_mode="HTML",
        )

async def on_pelis_page(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()

    _, page_str = query.data.split(":", 1)
    try:
        page = int(page_str)
    except ValueError:
        await query.edit_message_text(
            "❌ Página no válida.",
            parse_mode="HTML",
        )
        return

    results = context.user_data.get("pelis_results") or []
    topic_id = context.user_data.get("pelis_topic_id")
    original_query = context.user_data.get("pelis_query")

    if not results or not topic_id:
        await query.edit_message_text(
            "❌ No hay resultados de películas para paginar.",
            parse_mode="HTML",
        )
        return

    text, markup = build_pelis_page(page, results, topic_id, original_query)

    try:
        await query.edit_message_text(
            text=text,
            parse_mode="HTML",
            reply_markup=markup,
        )
    except Exception as e:
        print("[on_pelis_page] Error editando mensaje:", e)


# ======================================================
#    ADMIN COMMANDS
# ======================================================
async def setpelis(update: Update, context: ContextTypes.DEFAULT_TYPE):
    msg = update.message

    if update.effective_user.id not in (OWNER_ID, 6130939257):
        await msg.reply_text("⛔ No tienes permiso para usar este comando.")
        return

    topics = load_topics()
    existing_pelis_tid = get_pelis_topic_id(topics)
    if existing_pelis_tid:
        await msg.reply_text(
            "🍿 Ya hay un tema configurado como <b>Películas</b>.\n"
            "No se puede volver a cambiar.",
            parse_mode="HTML",
        )
        return

    if msg.chat.id != GROUP_ID or msg.message_thread_id is None:
        await msg.reply_text(
            "🍿 Usa /setpelis dentro del tema de <b>Películas</b> en el grupo.",
            parse_mode="HTML",
        )
        return

    topic_id = str(msg.message_thread_id)

    if topic_id not in topics:
        topic_name = msg.chat.title or f"Tema {topic_id}"
        topics[topic_id] = {
            "name": topic_name,
            "messages": [],
            "created_at": msg.date.timestamp() if msg.date else 0,
        }

    topics[topic_id]["is_pelis"] = True
    topics[topic_id].setdefault("movies", [])

    save_topics(topics)

    await msg.reply_text(
        "🍿 Este tema ha sido configurado como <b>Películas</b>.\n"
        "A partir de ahora, cada mensaje con descripción se indexará para búsquedas.",
        parse_mode="HTML",
    )


async def silencio(update: Update, context: ContextTypes.DEFAULT_TYPE):
    msg = update.message
    if update.effective_user.id != OWNER_ID:
        await msg.reply_text("⛔ No tienes permiso para usar este comando.")
        return

    if msg.chat.id != GROUP_ID or msg.message_thread_id is None:
        await msg.reply_text(
            "🔇 Usa /silencio dentro del tema que quieras silenciar en el grupo.",
            parse_mode="HTML",
        )
        return

    topic_id = str(msg.message_thread_id)
    topics = load_topics()

    if topic_id not in topics:
        topic_name = msg.chat.title or f"Tema {topic_id}"
        topics[topic_id] = {
            "name": topic_name,
            "messages": [],
            "created_at": msg.date.timestamp() if msg.date else 0,
        }

    topics[topic_id]["muted"] = True
    save_topics(topics)

    await msg.reply_text(
        "🔇 Este tema ha sido <b>silenciado</b>.\n"
        "El bot ya no registrará nada aquí.",
        parse_mode="HTML",
    )


async def activar(update: Update, context: ContextTypes.DEFAULT_TYPE):
    msg = update.message
    if update.effective_user.id != OWNER_ID:
        await msg.reply_text("⛔ No tienes permiso para usar este comando.")
        return

    if msg.chat.id != GROUP_ID or msg.message_thread_id is None:
        await msg.reply_text(
            "🔊 Usa /activar dentro del tema que quieras reactivar en el grupo.",
            parse_mode="HTML",
        )
        return

    topic_id = str(msg.message_thread_id)
    topics = load_topics()

    if topic_id in topics and topics[topic_id].get("muted"):
        topics[topic_id]["muted"] = False
        save_topics(topics)
        await msg.reply_text(
            "🔊 Este tema ha sido <b>reactivado</b>.\n"
            "El bot volverá a registrar mensajes aquí.",
            parse_mode="HTML",
        )
    else:
        await msg.reply_text(
            "ℹ️ Este tema no estaba silenciado.",
            parse_mode="HTML",
        )


def build_borrartema_main_keyboard():
    rows = []
    letters = list("ABCDEFGHIJKLMNOPQRSTUVWXYZ")

    for i in range(0, len(letters), 5):
        chunk = letters[i: i + 5]
        row = [
            InlineKeyboardButton(l, callback_data=f"del_letter:{l}")
            for l in chunk
        ]
        rows.append(row)

    rows.append(
        [InlineKeyboardButton("#", callback_data="del_letter:#")]
    )

    rows.append(
        [InlineKeyboardButton("🔙 Volver al catálogo", callback_data="main_menu")]
    )

    return InlineKeyboardMarkup(rows)



def set_hidden_topic(tid: str):
    HIDDEN_FILE.write_text(tid)

async def ocultar(update: Update, context: ContextTypes.DEFAULT_TYPE):
    msg = update.message
    if msg.from_user.id != OWNER_ID:
        await msg.reply_text("⛔ No tienes permiso.")
        return
    if msg.chat.type != "private":
        await msg.reply_text("ℹ️ Este comando solo funciona en privado.")
        return
    if not context.args:
        await msg.reply_text("❌ Uso: /ocultar NOMBRE_EXACTO_DEL_TEMA")
        return
    nombre = " ".join(context.args).lower()
    topics = load_topics()
    for tid, info in topics.items():
        if info["name"].lower() == nombre:
            set_hidden_topic(tid)
            await msg.reply_text(f"✔ Tema ocultado:\n<b>{info['name']}</b>", parse_mode="HTML")
            return
    await msg.reply_text("❌ No encontré un tema con ese nombre exacto.")

async def borrartema(update: Update, context: ContextTypes.DEFAULT_TYPE):
    if update.effective_user.id != OWNER_ID:
        await update.message.reply_text("⛔ No tienes permiso para usar este comando.")
        return

    chat = update.effective_chat
    topics = load_topics()

    if not topics:
        await chat.send_message("📭 No hay temas para borrar.")
        return

    await chat.send_message(
        "🗑 <b>Borrar temas</b>\n"
        "Elige una letra para ver los temas que comienzan por esa letra.",
        parse_mode="HTML",
        reply_markup=build_borrartema_main_keyboard(),
    )


def build_borrartema_letter_page(letter, page, topics_dict):
    filtrados = filtrar_por_letra(topics_dict, letter)
    total = len(filtrados)
    if total == 0:
        return (
            f"📭 No hay temas que empiecen por <b>{escape(letter)}</b>.",
            build_borrartema_main_keyboard(),
        )

    total_pages = max(1, math.ceil(total / PAGE_SIZE))
    page = max(1, min(page, total_pages))

    start_idx = (page - 1) * PAGE_SIZE
    end_idx = start_idx + PAGE_SIZE
    slice_items = filtrados[start_idx:end_idx]

    keyboard = []
    for tid, info in slice_items:
        safe_name = escape(fix_text(info.get("name", "")))
        keyboard.append(
            [InlineKeyboardButton(f"❌ {safe_name}", callback_data=f"del:{tid}")]
        )

    nav_row = []
    if total_pages > 1:
        if page > 1:
            nav_row.append(
                InlineKeyboardButton(
                    "⬅️ Anterior", callback_data=f"del_page:{letter}:{page-1}"
                )
            )
        nav_row.append(
            InlineKeyboardButton(f"{page}/{total_pages}", callback_data="noop")
        )
        if page < total_pages:
            nav_row.append(
                InlineKeyboardButton(
                    "Siguiente ➡️", callback_data=f"del_page:{letter}:{page+1}"
                )
            )
    if nav_row:
        keyboard.append(nav_row)

    keyboard.append(
        [InlineKeyboardButton("🔤 Elegir otra letra", callback_data="del_main")]
    )
    keyboard.append(
        [InlineKeyboardButton("🔙 Volver al catálogo", callback_data="main_menu")]
    )

    if letter == "#":
        title = "🗑 <b>Temas que empiezan por número o símbolo</b>"
    else:
        title = f"🗑 <b>Temas que empiezan por “{escape(letter)}”</b>"

    text = f"{title}\nMostrando {len(slice_items)} de {total}."

    return text, InlineKeyboardMarkup(keyboard)


async def on_del_main(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    try:
        await query.edit_message_text(
            "🗑 <b>Borrar temas</b>\n"
            "Elige una letra para ver los temas que comienzan por esa letra.",
            parse_mode="HTML",
            reply_markup=build_borrartema_main_keyboard(),
        )
    except Exception as e:
        print("[on_del_main] Error editando mensaje:", e)


async def on_del_letter(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    _, letter = query.data.split(":", 1)
    topics = load_topics()

    text, markup = build_borrartema_letter_page(letter, 1, topics)
    try:
        await query.edit_message_text(
            text=text,
            parse_mode="HTML",
            reply_markup=markup,
        )
    except Exception as e:
        print("[on_del_letter] Error editando mensaje:", e)


async def on_del_page(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    _, letter, page_str = query.data.split(":", 2)
    page = int(page_str)
    topics = load_topics()

    text, markup = build_borrartema_letter_page(letter, page, topics)
    try:
        await query.edit_message_text(
            text=text,
            parse_mode="HTML",
            reply_markup=markup,
        )
    except Exception as e:
        print("[on_del_page] Error editando mensaje:", e)


async def delete_topic(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()

    if query.from_user.id != OWNER_ID:
        await query.edit_message_text("⛔ No tienes permiso para esta acción.")
        return

    _, topic_id = query.data.split(":", 1)
    topic_id = str(topic_id)

    topics = load_topics()
    if topic_id not in topics:
        await query.edit_message_text("❌ Ese tema ya no existe.")
        return

    deleted_name = topics[topic_id]["name"]

    del topics[topic_id]
    save_topics(topics)

    await query.edit_message_text(
        f"🗑 Tema eliminado:\n<b>{escape(deleted_name)}</b>",
        parse_mode="HTML",
    )


async def reiniciar_db(update: Update, context: ContextTypes.DEFAULT_TYPE):
    if update.effective_user.id != OWNER_ID:
        await update.message.reply_text("⛔ No tienes permiso para usar este comando.")
        return

    save_topics({})
    await update.message.reply_text("🗑 Base de datos reiniciada.")


# ======================================================
#    /USUARIOS
# ======================================================
def build_users_page(page: int, users_dict: dict):
    items = list(users_dict.items())
    if not items:
        text = "👥 No hay usuarios registrados todavía."
        markup = InlineKeyboardMarkup(
            [[InlineKeyboardButton("🔙 Volver al catálogo", callback_data="main_menu")]]
        )
        return text, markup

    def clave(u_item):
        uid, info = u_item
        return info.get("first_seen", 0)

    items.sort(key=clave)
    banned_users = load_banned()

    total = len(items)
    total_pages = max(1, math.ceil(total / USERS_PAGE_SIZE))
    page = max(1, min(page, total_pages))

    start_idx = (page - 1) * USERS_PAGE_SIZE
    end_idx = start_idx + USERS_PAGE_SIZE
    slice_items = items[start_idx:end_idx]

    lines = [f"👥 <b>Usuarios registrados</b> (total: {total})\n"]
    for idx, (uid, info) in enumerate(slice_items, start=start_idx + 1):
        name = fix_text(info.get("name", ""))
        username = fix_text(info.get("username", ""))
        
        if username:
            line = f"{idx}. {escape(name)} [{uid}] ({escape(username)})"
        else:
            line = f"{idx}. {escape(name)} [{uid}]"

        if uid in banned_users:
            line += " <b>⛔ BANEADO</b>"

        lines.append(line)

    text = "\n".join(lines)

    keyboard = []
    nav_row = []
    if total_pages > 1:
        if page > 1:
            nav_row.append(
                InlineKeyboardButton(
                    "⬅️ Anterior", callback_data=f"users_page:{page-1}"
                )
            )
        nav_row.append(
            InlineKeyboardButton(f"{page}/{total_pages}", callback_data="noop")
        )
        if page < total_pages:
            nav_row.append(
                InlineKeyboardButton(
                    "Siguiente ➡️", callback_data=f"users_page:{page+1}"
                )
            )
    if nav_row:
        keyboard.append(nav_row)

    keyboard.append(
        [InlineKeyboardButton("🔙 Volver al catálogo", callback_data="main_menu")]
    )

    return text, InlineKeyboardMarkup(keyboard)


async def usuarios(update: Update, context: ContextTypes.DEFAULT_TYPE):
    if update.effective_user.id != OWNER_ID:
        await update.message.reply_text("⛔ No tienes permiso para usar este comando.")
        return

    users = load_users()
    text, markup = build_users_page(1, users)
    await update.message.reply_text(
        text,
        parse_mode="HTML",
        reply_markup=markup,
    )


async def on_users_page(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()

    if query.from_user.id != OWNER_ID:
        await query.edit_message_text("⛔ No tienes permiso para esta acción.")
        return

    _, page_str = query.data.split(":", 1)
    page = int(page_str)

    users = load_users()
    text, markup = build_users_page(page, users)

    try:
        await query.edit_message_text(
            text=text,
            parse_mode="HTML",
            reply_markup=markup,
        )
    except Exception as e:
        print("[on_users_page] Error editando mensaje:", e)




def next_request_id(data: dict) -> str:
    if not data:
        return "1"
    try:
        nums = [int(k) for k in data.keys() if k.isdigit()]
        return str(max(nums) + 1) if nums else "1"
    except Exception:
        return "1"


async def create_control_card(
    bot,
    req_type: str,  # 'update' o 'error'
    user,
    topic_id: str,
    serie_name: str,
    description: str | None = None,
):
    ok_limit, msg_limit = check_and_consume_daily_request(user.id)
    if not ok_limit:
        return False, msg_limit

    settings = load_settings()
    control_tid = settings.get("control_topic_id")
    if not control_tid:
        return False, "⚠️ No hay tema de control configurado. Pide al administrador que use /setcontrol."
    try:
        control_tid_int = int(control_tid)
    except (TypeError, ValueError):
        return False, "⚠️ El tema de control configurado no es válido. Pide al administrador que use /setcontrol de nuevo."
    users_id = user.id
    name = user.full_name or (user.username or f"ID {users_id}")
    username = f"@{user.username}" if user.username else "—"

    estado = "Pendiente"
    if req_type == "update":
        titulo = "📌 Solicitud de actualización"
    else:
        titulo = "⚠️ Informe de error"

    lines = [
        f"{titulo}",
        "",
        f"Serie: <b>{escape(fix_text(serie_name))}</b>",
        f"Estado: <b>{estado}</b>",
        "",
        "Usuario que lo solicita:" if req_type == "update" else "Usuario que informa el error:",
        f"Nombre: {escape(fix_text(name))}",
        f"Usuario: {escape(username)}",
        f"ID: <code>{users_id}</code>",
    ]

    if req_type == "error" and description:
        lines.append("")
        lines.append("Descripción:")
        lines.append(escape(fix_text(description)))

    text_card = "\n".join(lines)

    reqs = load_requests()
    req_id = next_request_id(reqs)

    if req_type == "update":
        btn_text = "✅ ACTUALIZADO"
    else:
        btn_text = "✅ SOLUCIONADO"

    markup = InlineKeyboardMarkup(
        [[InlineKeyboardButton(btn_text, callback_data=f"req_mark:{req_type}:{req_id}")]]
    )

    msg = await bot.send_message(
        chat_id=GROUP_ID,
        message_thread_id=control_tid_int,
        text=text_card,
        parse_mode="HTML",
        reply_markup=markup,
    )

    reqs[req_id] = {
        "id": req_id,
        "type": req_type,
        "status": estado,
        "user_id": users_id,
        "user_name": name,
        "username": username,
        "topic_id": topic_id,
        "serie_name": serie_name,
        "description": description or "",
        "control_message_id": msg.message_id,
        "control_topic_id": control_tid_int,
    }
    save_requests(reqs)

    return True, None


async def on_req_series(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    _, mode, topic_id = query.data.split(":", 2)
    topic_id = str(topic_id)

    topics = load_topics()
    if topic_id not in topics:
        await query.edit_message_text("❌ Serie no encontrada.")
        return

    info = topics[topic_id]
    serie_name = info.get("name", "Serie")

    user = query.from_user
    bot = context.bot

    if mode == "update":
        ok, err = await create_control_card(
            bot,
            "update",
            user,
            topic_id,
            serie_name,
        )
        if not ok:
            await query.edit_message_text(err, parse_mode="HTML")
            return

        await query.edit_message_text(
            "📥 Solicitud de actualización enviada.\n"
            "Nuestro equipo la revisará en cuanto sea posible.",
            parse_mode="HTML",
            reply_markup=InlineKeyboardMarkup(
                [
                    [InlineKeyboardButton("🔙 Volver al catálogo", callback_data="main_menu")],
                ]
            ),
        )

    else:  # mode == "error"
        context.user_data["error_report_pending"] = {
            "topic_id": topic_id,
            "serie_name": serie_name,
        }

        await query.edit_message_text(
            "⚠️ <b>Informar error</b>\n"
            "Describe el error para que nuestro equipo pueda solucionarlo.",
            parse_mode="HTML",
        )


async def on_req_mark(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    _, req_type, req_id = query.data.split(":", 2)

    reqs = load_requests()
    if req_id not in reqs:
        await query.edit_message_text("❌ Solicitud no encontrada o ya eliminada.")
        return

    req = reqs[req_id]

    if req_type == "update":
        new_status = "Completado"
        titulo = "📌 Solicitud de actualización"
        user_msg = (
            f"✅ Tu solicitud de actualización para la serie "
            f"<b>{escape(fix_text(req['serie_name']))}</b> ha sido completada."
        )
    else:
        new_status = "Solucionado"
        titulo = "⚠️ Informe de error"
        user_msg = (
            f"✅ El error que notificaste en la serie "
            f"<b>{escape(fix_text(req['serie_name']))}</b> ha sido solucionado."
        )

    req["status"] = new_status
    save_requests(reqs)

    name = req.get("user_name", "")
    username = req.get("username", "—")
    user_id = req.get("user_id")
    serie_name = req.get("serie_name", "")
    description = req.get("description", "")

    lines = [
        f"{titulo}",
        "",
        f"Serie: <b>{escape(fix_text(serie_name))}</b>",
        f"Estado: <b>{new_status}</b>",
        "",
        "Usuario que lo solicita:" if req_type == "update" else "Usuario que informa el error:",
        f"Nombre: {escape(fix_text(name))}",
        f"Usuario: {escape(username)}",
        f"ID: <code>{user_id}</code>",
    ]

    if req_type == "error" and description:
        lines.append("")
        lines.append("Descripción:")
        lines.append(escape(fix_text(description)))

    text_card = "\n".join(lines)

    try:
        await context.bot.edit_message_text(
            chat_id=GROUP_ID,
            message_id=req["control_message_id"],
            text=text_card,
            parse_mode="HTML",
        )
    except Exception as e:
        print(f"[on_req_mark] Error editando tarjeta: {e}")

    try:
        await context.bot.send_message(
            chat_id=user_id,
            text=user_msg,
            parse_mode="HTML",
        )
    except Exception as e:
        print(f"[on_req_mark] No se pudo notificar al usuario {user_id}: {e}")

    await delete_request_card_and_forget(context, reqs, req_id)

    try:
        await query.answer("Estado actualizado.")
    except Exception:
        pass


async def on_req_peli_btn(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    chat = query.message.chat

    if chat.type != "private":
        await query.answer("Usa este botón en privado conmigo.", show_alert=True)
        return

    context.user_data["movie_request_pending"] = True

    await query.edit_message_text(
        "🎬 <b>Solicitud de película</b>\n"
        "Por favor, escribe el título y el año de la película.\n\n"
        "Ejemplos:\n"
        "• Matrix 1999\n"
        "• La Sirenita 2023\n"
        "• Gladiator 2000",
        parse_mode="HTML",
        reply_markup=InlineKeyboardMarkup(
            [[InlineKeyboardButton("🔙 Volver", callback_data="main_menu")]]
        ),
    )



# ======================================================
#    REVISAR IDIOMA (películas)
# ======================================================

def _extract_title_year_from_text(s: str):
    s = (s or "").strip()
    m = re.search(r"\b(19\d{2}|20\d{2})\b", s)
    if not m:
        return s, ""
    year = m.group(1)
    title = re.sub(r"\b" + re.escape(year) + r"\b", "", s).strip(" -_()[]{}")
    title = re.sub(r"\s{2,}", " ", title).strip()
    return title or s, year


async def create_lang_review_card(bot, user, topic_id: str, movie_mid: int, exact_filename: str, movie_title: str = ""):
    ok_limit, msg_limit = check_and_consume_daily_request(user.id)
    if not ok_limit:
        return False, msg_limit

    """Crea tarjeta en el tema de control para revisión de idioma."""
    settings = load_settings()
    control_tid = settings.get("control_topic_id")
    if not control_tid:
        return False, "⚠️ No hay tema de control configurado. Pide al administrador que use /setcontrol."
    try:
        control_tid_int = int(control_tid)
    except (TypeError, ValueError):
        return False, "⚠️ El tema de control configurado no es válido. Pide al administrador que use /setcontrol de nuevo."

    user_id = user.id
    name = user.full_name or (user.username or f"ID {user_id}")
    username = f"@{user.username}" if user.username else "—"

    estado = "Pendiente"

    msg_title = (movie_title or exact_filename or "").strip()
    final_title, final_year = _extract_title_year_from_text(msg_title)

    # ENLACE DIRECTO
    chat_id_str = str(GROUP_ID).replace("-100", "")
    original_link = f"https://t.me/c/{chat_id_str}/{movie_mid}?thread={topic_id}"

    lines = [
        "🈯️ <b>Revisar idioma</b>",
        "",
        "Revisar idioma",
        f"Película: <b>{escape(fix_text(exact_filename))}</b>",
        f"Estado: <b>{estado}</b>",
        f"Ubicación: <a href='{original_link}'>ENLACE</a>",
        "",
        "Usuario que solicita revisión:",
        f"Nombre: {escape(fix_text(name))}",
        f"Usuario: {escape(username)}",
        f"ID: <code>{user_id}</code>",
    ]
    text_card = "\n".join(lines)

    reqs = load_requests()
    req_id = next_request_id(reqs)

    markup = InlineKeyboardMarkup(
        [[InlineKeyboardButton("✅ COMPLETAR", callback_data=f"lang_complete:{req_id}")]]
    )

    msg = await bot.send_message(
        chat_id=GROUP_ID,
        message_thread_id=control_tid_int,
        text=text_card,
        parse_mode="HTML",
        reply_markup=markup,
    )

    reqs[req_id] = {
        "id": req_id,
        "type": "rev_idioma",
        "status": estado,
        "topic_id": str(topic_id),
        "movie_mid": int(movie_mid),
        "exact_filename": exact_filename,
        "movie_title": movie_title or "",
        "final_title": final_title,
        "final_year": final_year,
        "user_id": user_id,
        "user_name": name,
        "username": username,
        "control_message_id": msg.message_id,
        "control_topic_id": control_tid_int,
    }
    save_requests(reqs)

    return True, None


async def on_lang_review(update: Update, context: ContextTypes.DEFAULT_TYPE):
    """Callback: Muestra la confirmación de Sí/No."""
    query = update.callback_query
    await query.answer()

    try:
        _, topic_id, mid_str = query.data.split(":", 2)
        int(mid_str)
    except Exception:
        await query.answer("❌ Error en los datos.", show_alert=True)
        return

    keyboard = [
        [
            InlineKeyboardButton("Sí", callback_data=f"lang_conf:{topic_id}:{mid_str}"),
            InlineKeyboardButton("No", callback_data=f"lang_canc:{topic_id}:{mid_str}")
        ]
    ]

    await query.edit_message_text(
        text="¿Estás seguro/a de que el idioma de este archivo no es castellano?",
        reply_markup=InlineKeyboardMarkup(keyboard)
    )

async def on_lang_confirm(update: Update, context: ContextTypes.DEFAULT_TYPE):
    """Callback: El usuario dijo SÍ -> Crea la tarjeta en control."""
    query = update.callback_query
    await query.answer() 

    try:
        _, topic_id, mid_str = query.data.split(":", 2)
        topic_id = str(topic_id)
        movie_mid = int(mid_str)
    except Exception:
        await query.edit_message_text("❌ Error interno recuperando datos.")
        return

    topics = load_topics()
    exact_filename = ""
    movie_title = ""

    info = topics.get(topic_id) or {}
    for m in (info.get("movies") or []):
        if int(m.get("id") or 0) == movie_mid:
            exact_filename = (m.get("file_name") or "").strip()
            movie_title = (m.get("title") or "").strip()
            break

    if not exact_filename:
        exact_filename = movie_title or f"ID {movie_mid}"

    ok, err = await create_lang_review_card(
        context.bot,
        query.from_user,
        topic_id,
        movie_mid,
        exact_filename,
        movie_title=movie_title,
    )
    
    if not ok:
        await query.edit_message_text(text=err, parse_mode="HTML")
        return

    await query.edit_message_text(
        text="📨 Gracias por tu colaboración, nuestro equipo lo revisará lo antes posible.",
        reply_markup=InlineKeyboardMarkup(
            [[InlineKeyboardButton("🔙 Volver al catálogo", callback_data="main_menu")]]
        )
    )


async def on_lang_cancel(update: Update, context: ContextTypes.DEFAULT_TYPE):
    """Callback: El usuario dijo NO -> Vuelve al menú de 'Película enviada'."""
    query = update.callback_query
    await query.answer()

    try:
        _, topic_id, mid_str = query.data.split(":", 2)
    except:
        await query.edit_message_text("❌ Error al cancelar.")
        return

    await query.edit_message_text(
        text="🍿 Película enviada.",
        reply_markup=InlineKeyboardMarkup(
            [
                [InlineKeyboardButton("🈯️ Revisar idioma", callback_data=f"lang_review:{topic_id}:{mid_str}")],
                [InlineKeyboardButton("🔙 Volver al catálogo", callback_data="main_menu")],
            ]
        ),
    )


async def on_lang_complete(update: Update, context: ContextTypes.DEFAULT_TYPE):
    """Callback del panel de control: marca la revisión de idioma como completada."""
    query = update.callback_query
    await query.answer()

    _, req_id = query.data.split(":", 1)

    reqs = load_requests()
    if req_id not in reqs:
        await query.edit_message_text("❌ Solicitud no encontrada o ya eliminada.")
        return

    req = reqs[req_id]

    admins = await context.bot.get_chat_administrators(GROUP_ID)
    admin_ids = [a.user.id for a in admins]
    if not can_complete_control(query.from_user.id, admin_ids):
        await query.answer("⛔ Solo administradores o el dueño pueden completar solicitudes.", show_alert=True)
        return

    req["status"] = "Completado"
    save_requests(reqs)

    exact_filename = req.get("exact_filename", "")
    name = req.get("user_name", "")
    username = req.get("username", "—")
    user_id = req.get("user_id")

    lines = [
        "🈯️ <b>Revisar idioma</b>",
        "",
        "Revisar idioma",
        f"Película: <b>{escape(fix_text(exact_filename))}</b>",
        "Estado: <b>Completado</b>",
        "",
        "Usuario que solicita revisión:",
        f"Nombre: {escape(fix_text(name))}",
        f"Usuario: {escape(username)}",
        f"ID: <code>{user_id}</code>",
    ]
    text_card = "\n".join(lines)

    try:
        await context.bot.edit_message_text(
            chat_id=GROUP_ID,
            message_id=req["control_message_id"],
            text=text_card,
            parse_mode="HTML",
        )
    except Exception as e:
        print(f"[on_lang_complete] Error editando tarjeta: {e}")

    final_title = req.get("final_title") or req.get("movie_title") or exact_filename
    final_year = req.get("final_year") or ""
    try:
        if final_year:
            msg = f"La película <b>{escape(fix_text(final_title))} ({escape(fix_text(final_year))})</b> ahora tiene el idioma correcto."
        else:
            msg = f"La película <b>{escape(fix_text(final_title))}</b> ahora tiene el idioma correcto."
        await context.bot.send_message(chat_id=user_id, text=msg, parse_mode="HTML")
    except Exception as e:
        print(f"[on_lang_complete] No se pudo notificar al usuario {user_id}: {e}")

    await delete_request_card_and_forget(context, reqs, req_id)

    try:
        await query.answer("Solicitud completada.")
    except Exception:
        pass


async def create_movie_request_card(bot, user, titulo: str, año: str):
    ok_limit, msg_limit = check_and_consume_daily_request(user.id)
    if not ok_limit:
        return False, msg_limit

    """Crea tarjeta en el tema de control para una petición de película."""
    try:
        año_int = int(año)
    except:
        return False, "Por favor, verifica el título y el año de la película."

    resolved = resolve_movie_request_tmdb(titulo, año_int)
    if resolved:
        titulo, año_int = resolved
        año = str(año_int)


    # Resolver/corregir título y año con TMDB (si hay token configurado)
    try:
        año_num = int(str(año).strip())
    except Exception:
        año_num = None

    if TMDB_TOKEN and año_num:
        resolved = resolve_movie_tmdb(titulo, año_num)
        if not resolved:
            return False, "Por favor, verifica el título y el año de la película."
        titulo, año_corr = resolved
        año = str(año_corr)
    settings = load_settings()
    control_tid = settings.get("control_topic_id")
    if not control_tid:
        return False, "⚠️ No hay tema de control configurado. Pide al administrador que use /setcontrol."

    try:
        control_tid_int = int(control_tid)
    except (TypeError, ValueError):
        return False, "⚠️ El tema de control configurado no es válido. Pide al administrador que use /setcontrol de nuevo."

    user_id = user.id
    name = user.full_name or (user.username or f"ID {user_id}")
    username = f"@{user.username}" if user.username else "—"

    estado = "Pendiente"

    lines = [
        "📌 <b>Petición de película</b>",
        "",
        f"Película: <b>{escape(fix_text(titulo))}</b>",
        f"Año: <b>{escape(fix_text(año))}</b>",
        f"Estado: <b>{estado}</b>",
        "",
        "Usuario que solicita la película:",
        f"Nombre: {escape(fix_text(name))}",
        f"Usuario: {escape(username)}",
        f"ID: <code>{user_id}</code>",
    ]
    text_card = "\n".join(lines)

    reqs = load_requests()
    req_id = next_request_id(reqs)

    markup = InlineKeyboardMarkup(
        [[InlineKeyboardButton("✅ COMPLETAR", callback_data=f"req_peli_mark:{req_id}")]]
    )

    msg = await bot.send_message(
        chat_id=GROUP_ID,
        message_thread_id=control_tid_int,
        text=text_card,
        parse_mode="HTML",
        reply_markup=markup,
    )

    reqs[req_id] = {
        "id": req_id,
        "type": "pelicula",
        "status": estado,
        "titulo": titulo,
        "año": año,
        "user_id": user_id,
        "user_name": name,
        "username": username,
        "control_message_id": msg.message_id,
        "control_topic_id": control_tid_int,
    }
    save_requests(reqs)

    return True, None


async def on_req_peli_mark(update: Update, context: ContextTypes.DEFAULT_TYPE):
    """Callback para marcar una petición de película como completada."""
    query = update.callback_query
    await query.answer()

    data = query.data
    _, req_id = data.split(":", 1)

    reqs = load_requests()
    if req_id not in reqs:
        await query.edit_message_text("❌ Solicitud no encontrada o ya eliminada.")
        return

    req = reqs[req_id]

    admins = await context.bot.get_chat_administrators(GROUP_ID)
    admin_ids = [a.user.id for a in admins]
    if not can_complete_control(query.from_user.id, admin_ids):
        await query.answer("⛔ Solo administradores o el dueño pueden completar solicitudes.", show_alert=True)
        return

    req["status"] = "Completado"
    save_requests(reqs)

    titulo = req.get("titulo", "")
    año = req.get("año", "")
    name = req.get("user_name", "")
    username = req.get("username", "—")
    user_id = req.get("user_id")

    lines = [
        "📌 <b>Petición de película</b>",
        "",
        f"Película: <b>{escape(fix_text(titulo))}</b>",
        f"Año: <b>{escape(fix_text(año))}</b>",
        "Estado: <b>Completado</b>",
        "",
        "Usuario que solicita la película:",
        f"Nombre: {escape(fix_text(name))}",
        f"Usuario: {escape(username)}",
        f"ID: <code>{user_id}</code>",
    ]
    text_card = "\n".join(lines)

    try:
        await context.bot.edit_message_text(
            chat_id=GROUP_ID,
            message_id=req["control_message_id"],
            text=text_card,
            parse_mode="HTML",
        )
    except Exception as e:
        print(f"[on_req_peli_mark] Error editando tarjeta: {e}")

    # Avisar al usuario
    try:
        await context.bot.send_message(
            chat_id=user_id,
            text=(
                "🎬 La película "
                f"<b>{escape(fix_text(titulo))} ({escape(fix_text(año))})</b> "
                "que solicitaste ya ha sido añadida a nuestro bot."
            ),
            parse_mode="HTML",
        )
    except Exception as e:
        print(f"[on_req_peli_mark] No se pudo notificar al usuario {user_id}: {e}")

    await delete_request_card_and_forget(context, reqs, req_id)

    try:
        await query.answer("Solicitud completada.")
    except Exception:
        pass

# ============================
#    /EXPORTAR y /IMPORTAR
# ============================
async def exportar(update: Update, context: ContextTypes.DEFAULT_TYPE):
    if update.effective_user.id != OWNER_ID:
        await update.message.reply_text("⛔ No tienes permiso para usar este comando.")
        return
    if not TOPICS_FILE.exists():
        await update.message.reply_text("No existe topics.json.")
        return
    await update.message.reply_document(document=open(TOPICS_FILE, "rb"), filename="topics.json")

async def importar(update: Update, context: ContextTypes.DEFAULT_TYPE):
    if update.effective_user.id != OWNER_ID:
        await update.message.reply_text("⛔ No tienes permiso para usar este comando.")
        return

    if not update.message.reply_to_message or not update.message.reply_to_message.document:
        await update.message.reply_text("❌ Debes responder a un archivo JSON con /importar")
        return

    doc = update.message.reply_to_message.document
    if not doc.file_name.endswith(".json"):
        await update.message.reply_text("❌ El archivo debe ser .json")
        return

    file = await doc.get_file()
    data = await file.download_as_bytearray()
    try:
        # Validate JSON
        json.loads(data.decode("utf-8"))
        with open(TOPICS_FILE, "wb") as f:
            f.write(data)
        await update.message.reply_text("✔ Base de datos importada correctamente.")
    except Exception as e:
        await update.message.reply_text("❌ Error al importar el JSON.")


# ======================================================
#    NUEVOS COMANDOS /extras y /finalizar
# ======================================================



async def actualizar_extra_mode(update: Update, context: ContextTypes.DEFAULT_TYPE):
    msg = update.message
    user_id = update.effective_user.id

    # Solo dentro del tema (thread) del grupo
    if msg.chat.id != GROUP_ID or msg.message_thread_id is None:
        await msg.reply_text("⚠️ Este comando solo funciona dentro del tema de la serie.", parse_mode="HTML")
        return

    topic_id = str(msg.message_thread_id)
    topics = load_topics()

    if topic_id not in topics:
        await msg.reply_text("❌ Tema no encontrado.", parse_mode="HTML")
        return

    ensure_season_structure(topics[topic_id])
    extras_groups = topics[topic_id].get("extras_groups", [])

    # Si no pasan nombre: mostrar botones para elegir el extra a actualizar
    raw = (msg.text or "").strip()
    parts = raw.split(" ", 1)
    if len(parts) < 2 or not parts[1].strip():
        if not extras_groups:
            await msg.reply_text("ℹ️ No hay extras registrados para esta serie.", parse_mode="HTML")
            return

        keyboard = []
        for i, g in enumerate(extras_groups):
            title = fix_text((g.get("title") or "➕ Extras")).strip()
            btn_text = title if len(title) <= 40 else (title[:37] + "…")
            keyboard.append([InlineKeyboardButton(btn_text, callback_data=f"updextra:{i}")])

        await msg.reply_text(
            ("🧩 <b>¿Qué extra quieres actualizar?</b>\n"
             "Selecciona uno de la lista:"),
            reply_markup=InlineKeyboardMarkup(keyboard),
            parse_mode="HTML",
        )
        return

    # Con nombre: Match exacto (normalizado)
    requested_title = fix_text(parts[1]).strip()

    target_idx = -1
    for i, g in enumerate(extras_groups):
        title = fix_text((g.get("title") or "")).strip()
        if title == requested_title:
            target_idx = i
            break

    if target_idx == -1:
        await msg.reply_text(
            ("❌ No existe un extra con ese nombre exacto.\n"             "Tip: usa /actualizar sin nombre para elegirlo de una lista."),
            parse_mode="HTML",
        )
        return

    # Entrar en modo “actualización”
    topics[topic_id]["extras_capture_buffer"] = []
    topics[topic_id]["extras_capture_title"] = requested_title
    topics[topic_id]["extras_capture_target"] = target_idx
    topics[topic_id]["capture_extras_id"] = user_id
    save_topics(topics)

    await msg.reply_text(
        (f"✏️ <b>Actualizando extra:</b> <code>{escape(requested_title)}</code>\n\n"         "Añade el nuevo contenido para este extra y escribe /finalizar cuando termines."),
        parse_mode="HTML",
    )


async def actualizar_extra_callback(update: Update, context: ContextTypes.DEFAULT_TYPE):
    cq = update.callback_query
    if cq is None or cq.message is None:
        return

    msg = cq.message
    user_id = cq.from_user.id if cq.from_user else 0

    if msg.chat.id != GROUP_ID or msg.message_thread_id is None:
        await cq.answer("Solo dentro del tema de la serie.", show_alert=True)
        return

    topic_id = str(msg.message_thread_id)
    topics = load_topics()
    if topic_id not in topics:
        await cq.answer("Tema no encontrado.", show_alert=True)
        return

    ensure_season_structure(topics[topic_id])
    extras_groups = topics[topic_id].get("extras_groups", [])

    try:
        idx = int((cq.data or "").split(":", 1)[1])
    except Exception:
        await cq.answer("Selección inválida.", show_alert=True)
        return

    if idx < 0 or idx >= len(extras_groups):
        await cq.answer("Ese extra ya no existe.", show_alert=True)
        return

    title = fix_text((extras_groups[idx].get("title") or "➕ Extras")).strip()

    topics[topic_id]["extras_capture_buffer"] = []
    topics[topic_id]["extras_capture_title"] = title
    topics[topic_id]["extras_capture_target"] = idx
    topics[topic_id]["capture_extras_id"] = user_id
    save_topics(topics)

    await cq.answer("Listo ✅")
    try:
        await cq.edit_message_text(
            (f"✅ Seleccionado: <code>{escape(title)}</code>\n"             "Ahora añade el nuevo contenido y escribe /finalizar cuando termines."),
            parse_mode="HTML",
        )
    except Exception:
        await msg.reply_text(
            (f"✏️ <b>Actualizando extra:</b> <code>{escape(title)}</code>\n\n"             "Añade el nuevo contenido para este extra y escribe /finalizar cuando termines."),
            parse_mode="HTML",
        )

async def extras_mode(update: Update, context: ContextTypes.DEFAULT_TYPE):
    msg = update.message
    user_id = update.effective_user.id

    # Comprobación de que el comando se usa dentro de un tema del grupo
    if msg.chat.id != GROUP_ID or msg.message_thread_id is None:
        await msg.reply_text(
            "⚠️ Usa <b>/extras</b> dentro del tema de la serie donde quieres añadir contenido extra.",
            parse_mode="HTML",
        )
        return
    
    topic_id = str(msg.message_thread_id)
    topics = load_topics()
    
    # Asegurar que el tema existe
    if topic_id not in topics:
        await msg.reply_text("❌ Tema no encontrado en la base de datos. Asegúrate de que la serie está registrada.", parse_mode="HTML")
        return

    if topics[topic_id].get("capture_extras_id", 0) != 0:
        if topics[topic_id]["capture_extras_id"] != user_id and user_id != OWNER_ID:
            await msg.reply_text("🚫 Ya hay otro usuario capturando contenido extra en este tema. Pide a esa persona que use /finalizar.", parse_mode="HTML")
            return
    
    ensure_season_structure(topics[topic_id])

    custom_title = " ".join(context.args).strip() if getattr(context, "args", None) else ""
    if custom_title:
        base_title = fix_text(custom_title)
    else:
        base_title = "➕ Extras"

    existing = [g.get("title", "") for g in topics[topic_id].get("extras_groups", []) if isinstance(g, dict)]
    title = base_title
    if title in existing:
        n = 2
        while f"{base_title} {n}" in existing:
            n += 1
        title = f"{base_title} {n}"

    # Empezamos un nuevo grupo de extras
    topics[topic_id]["extras_capture_buffer"] = []
    topics[topic_id]["extras_capture_title"] = title
    topics[topic_id]["capture_extras_id"] = user_id
    save_topics(topics)
    
    await msg.reply_text(
        f"✅ <b>Modo Extras activado</b> (<code>{escape(fix_text(title))}</code>)\n"
        "Todo el contenido (vídeos/fotos/documentos) que envíes a continuación se guardará en este nuevo bloque de extras.\n\n"
        "Cuando termines, usa <b>/finalizar</b> y se añadirá un botón nuevo en la ficha de la serie.",
        parse_mode="HTML",
    )


async def finalizar_mode(update: Update, context: ContextTypes.DEFAULT_TYPE):
    msg = update.message
    user_id = update.effective_user.id

    if msg.chat.id != GROUP_ID or msg.message_thread_id is None:
        await msg.reply_text("⚠️ Este comando solo funciona dentro de un tema del grupo.", parse_mode="HTML")
        return

    topic_id = str(msg.message_thread_id)
    topics = load_topics()
    
    if topic_id not in topics:
        await msg.reply_text("❌ Tema no encontrado.", parse_mode="HTML")
        return

    capture_id = topics[topic_id].get("capture_extras_id", 0)
    
    if capture_id == 0:
        await msg.reply_text("ℹ️ El modo Extras no está activo en este tema.", parse_mode="HTML")
        return
    ensure_season_structure(topics[topic_id])

    buffer_msgs = topics[topic_id].get("extras_capture_buffer", [])
    buffer_title = (topics[topic_id].get("extras_capture_title") or "➕ Extras").strip()
    target = topics[topic_id].get("extras_capture_target", -1)
    was_update = 0 <= target < len(topics[topic_id].get("extras_groups", []))

    if buffer_msgs:
        topics[topic_id].setdefault("extras_groups", [])
        new_block = {"title": buffer_title, "messages": list(buffer_msgs)}
        if 0 <= target < len(topics[topic_id]["extras_groups"]):
            # Reemplaza el extra existente (modo /actualizar)
            topics[topic_id]["extras_groups"][target] = new_block
        else:
            # Crea un bloque nuevo (modo /extras)
            topics[topic_id]["extras_groups"].append(new_block)

    # Limpiar estado de captura
    topics[topic_id]["extras_capture_buffer"] = []
    topics[topic_id]["extras_capture_title"] = ""
    topics[topic_id]["extras_capture_target"] = -1
    topics[topic_id]["capture_extras_id"] = 0
    save_topics(topics)
    
    captured_count = len(buffer_msgs)
    if captured_count:
        action_line = "✅ Extra actualizado" if was_update else "✅ Se añadió un botón nuevo"
        final_text = (
            f"⏹️ <b>Modo Extras finalizado</b>.\n"
            f"{action_line}: <code>{buffer_title}</code> (archivos: {captured_count}).\n"
            "Abre la serie desde el catálogo para verlo en sus botones."
        )
    else:
        final_text = (
            "⏹️ <b>Modo Extras finalizado</b>.\n"
            "ℹ️ No se capturó ningún archivo en este bloque (no se añadió botón)."
        )

    await msg.reply_text(final_text, parse_mode="HTML")


# ======================================================
#    OTROS COMANDOS DE OWNER
# ======================================================

async def repararpelis(update: Update, context: ContextTypes.DEFAULT_TYPE):
    if update.effective_user.id != OWNER_ID:
        await update.message.reply_text("⛔ No tienes permiso para usar este comando.")
        return

    topics = load_topics()
    pelis_tid = get_pelis_topic_id(topics)

    if not pelis_tid or pelis_tid not in topics:
        await update.message.reply_text("🍿 No hay un tema configurado como Películas.")
        return

    movies = topics[pelis_tid].get("movies", [])
    if not movies:
        await update.message.reply_text("🍿 No hay películas guardadas para reparar.")
        return

    reparadas = 0

    for m in movies:
        old_title = m.get("title", "").strip()
        first_line = old_title.split("\n")[0].strip()
        new_title = limpiar_titulo(first_line)
        if new_title != old_title:
            m["title"] = new_title
            reparadas += 1

    save_topics(topics)

    await update.message.reply_text(
        f"✔ Reparación completada. Películas actualizadas: <b>{reparadas}</b>",
        parse_mode="HTML"
    )

async def stats(update: Update, context: ContextTypes.DEFAULT_TYPE):
    topics = load_topics()
    if not topics:
        await update.message.reply_text("📊 No hay datos todavía.")
        return

    total_series = 0
    total_peliculas = 0

    pelis_tid = get_pelis_topic_id(topics)

    for tid, info in topics.items():
        name_lower = info.get("name", "").strip().lower()
        if info.get("muted"):
            continue
        if name_lower == "general" or name_lower == "#general":
            continue
        if info.get("is_pelis"):
            continue
        total_series += 1

    if pelis_tid and pelis_tid in topics:
        total_peliculas = len(topics[pelis_tid].get("movies", []))

    await update.message.reply_text(
        f"📊 <b>Estadísticas</b>\n\n"
        f"📺 Series: <b>{total_series}</b>\n"
        f"🍿 Películas: <b>{total_peliculas}</b>",
        parse_mode="HTML"
    )

async def banear(update: Update, context: ContextTypes.DEFAULT_TYPE):
    msg = update.message
    if update.effective_user.id != OWNER_ID:
        await msg.reply_text("⛔ No tienes permiso para usar este comando.")
        return

    if not context.args or len(context.args) < 2:
        await msg.reply_text(
            "Uso: /banear <ID> <motivo>\nEjemplo: /banear 6474190644 Expulsado por insultos"
        )
        return

    target_id_str = context.args[0]
    try:
        int(target_id_str)
    except ValueError:
        await msg.reply_text("❌ El ID debe ser numérico.")
        return

    reason = " ".join(context.args[1:]).strip()
    if not reason:
        reason = "Sin motivo especificado."

    banned = load_banned()
    banned[target_id_str] = {"reason": reason}
    save_banned(banned)

    await msg.reply_text(
        f"🚫 Usuario <code>{target_id_str}</code> baneado.\n"
        f"Motivo: <b>{escape(fix_text(reason))}</b>",
        parse_mode="HTML",
    )


async def unban(update: Update, context: ContextTypes.DEFAULT_TYPE):
    msg = update.message
    if update.effective_user.id != OWNER_ID:
        await msg.reply_text("⛔ No tienes permiso para usar este comando.")
        return

    if not context.args:
        await msg.reply_text("Uso: /unban <ID>")
        return

    target_id_str = context.args[0]
    banned = load_banned()

    if target_id_str in banned:
        banned.pop(target_id_str)
        save_banned(banned)
        await msg.reply_text(
            f"✅ Usuario <code>{target_id_str}</code> desbaneado.",
            parse_mode="HTML",
        )
    else:
        await msg.reply_text("ℹ️ Ese usuario no estaba baneado.")


async def mensaje(update: Update, context: ContextTypes.DEFAULT_TYPE):
    """/mensaje <texto> - Envía un mensaje a todos los usuarios registrados (sólo OWNER)."""
    if update.effective_user.id != OWNER_ID:
        await update.message.reply_text("⛔ No tienes permiso para usar este comando.")
        return

    if not context.args:
        await update.message.reply_text("Uso: /mensaje <texto a enviar a todos los usuarios>")
        return

    text = " ".join(context.args).strip()
    if not text:
        await update.message.reply_text(
            "El mensaje no puede estar vacío.\nUso: /mensaje <texto a enviar a todos los usuarios>"
        )
        return

    users = load_users()
    if not users:
        await update.message.reply_text("No hay usuarios registrados para enviar el mensaje.")
        return

    bot = context.bot
    enviados = 0
    fallidos = 0

    for uid in users.keys():
        try:
            chat_id = int(uid)
            await bot.send_message(chat_id=chat_id, text=text)
            enviados += 1
        except Exception as e:
            fallidos += 1
            print(f"[mensaje] Error enviando mensaje a {uid}: {e}")

    await update.message.reply_text(
        f"Mensaje enviado a {enviados} usuarios. Fallidos: {fallidos}."
    )

async def setanalisis(update: Update, context: ContextTypes.DEFAULT_TYPE):
    msg = update.message
    if update.effective_user.id != OWNER_ID:
        await msg.reply_text("⛔ No tienes permiso para usar este comando.")
        return
    if msg.chat.id != GROUP_ID or msg.message_thread_id is None:
        await msg.reply_text(
            "⚙️ Usa <b>/setanalisis</b> dentro del tema que quieras usar como zona de análisis en el grupo.",
            parse_mode="HTML",
        )
        return
    topic_id = str(msg.message_thread_id)
    settings = load_settings()
    settings["analyze_topic_id"] = topic_id
    save_settings(settings)
    await msg.reply_text(
        "✔ Tema de análisis configurado.\nA partir de ahora, el bot usará este tema para analizar series.",
        parse_mode="HTML",
    )


async def setcontrol(update: Update, context: ContextTypes.DEFAULT_TYPE):
    msg = update.message
    if update.effective_user.id != OWNER_ID:
        await msg.reply_text("⛔ No tienes permiso para usar este comando.")
        return
    if msg.chat.id != GROUP_ID or msg.message_thread_id is None:
        await msg.reply_text(
            "🧩 Usa <b>/setcontrol</b> dentro del tema que quieras usar como panel de control en el grupo.",
            parse_mode="HTML",
        )
        return
    topic_id = str(msg.message_thread_id)
    settings = load_settings()
    settings["control_topic_id"] = topic_id
    save_settings(settings)
    await msg.reply_text(
        "✔ Tema de control configurado.\nA partir de ahora el bot enviará solicitudes e informes de error aquí.",
        parse_mode="HTML",
    )


async def analizartodo(update: Update, context: ContextTypes.DEFAULT_TYPE):
    user_id = update.effective_user.id
    if user_id != OWNER_ID:
        await update.message.reply_text("⛔ No tienes permiso para este comando.")
        return

    bot = context.bot

    start_msg = await bot.send_message(chat_id=user_id, text="🔎 Iniciando análisis...")
    global_msg = await bot.send_message(chat_id=user_id, text="Progreso global...")
    serie_msg = await bot.send_message(chat_id=user_id, text="Progreso serie...")

    topics = load_topics()
    series = [(tid, info) for tid, info in topics.items() if not info.get("is_pelis") and not info.get("muted")]
    series.sort(key=lambda x: x[0])

    total_series = len(series)
    await bot.edit_message_text(chat_id=user_id, message_id=start_msg.message_id,
                                 text=f"🔎 Analizando {total_series} series...")

    for idx, (tid, info) in enumerate(series, start=1):
        nombre = info.get("name","Serie")

        try:
            await bot.edit_message_text(
                chat_id=user_id,
                message_id=global_msg.message_id,
                text=f"📚 Serie {idx}/{total_series}: {nombre}"
            )
        except:
            pass

        ensure_season_structure(info)
        info["seasons"] = {}
        info["current_season"] = 1
        info["seasons_built"] = False
        info["extras"] = [] 
        info["is_extras_section"] = False 
        info["capture_extras_id"] = 0 


        mensajes = [m["id"] for m in info.get("messages",[])]
        if mensajes:
            mensajes = mensajes[1:]

        if not mensajes:
            continue

        total = len(mensajes)
        try:
            await bot.edit_message_text(chat_id=user_id, message_id=serie_msg.message_id, text="0%")
        except:
            pass

        for pos, mid in enumerate(mensajes, start=1):
            fwd = await forward_and_return_message(bot, user_id, mid, from_chat_id=GROUP_ID)
            if fwd:
                process_message_for_seasons(info, fwd, mid)
                try:
                    await fwd.delete()
                except:
                    pass

            if pos == total or pos % 40 == 0:
                p = (pos/total)*100
                try:
                    await bot.edit_message_text(
                        chat_id=user_id,
                        message_id=serie_msg.message_id,
                        text=f"{p:.1f}%"
                    )
                except:
                    pass

        info["seasons_built"] = True
        save_topics(topics)

    await bot.send_message(chat_id=user_id, text="🎉 Análisis completado.")



async def on_random_serie(update: Update, context: ContextTypes.DEFAULT_TYPE):
    import random
    query = update.callback_query
    await query.answer()
    topics = load_topics()
    series = [(tid, info) for tid, info in topics.items() if not info.get("is_pelis") and info.get("seasons_built")]
    if not series:
        await query.edit_message_text("❌ No hay series analizadas todavía.")
        return
    tid, info = random.choice(series)
    ensure_season_structure(info)
    topic_id = str(tid)
    seasons = info.get("seasons") or {}
    extras_groups = info.get("extras_groups") or []
    from telegram.helpers import escape
    def num_emoji(n):
        mapping={0:"0️⃣",1:"1️⃣",2:"2️⃣",3:"3️⃣",4:"4️⃣",5:"5️⃣",6:"6️⃣",7:"7️⃣",8:"8️⃣",9:"9️⃣"}
        return mapping.get(n,str(n))
    keyboard=[]
    for s in sorted(seasons.keys(), key=lambda x:int(x)):
        num=int(s); emoji=num_emoji(num)
        keyboard.append([InlineKeyboardButton(f"{emoji} Temporada {s}",callback_data=f"sendseason:{topic_id}:{s}")])
    
    # Botones para EXTRAS (múltiples bloques)
    for idx_ex, g in enumerate(extras_groups):
        if not isinstance(g, dict):
            continue
        msgs = g.get("messages") or []
        if not msgs:
            continue
        btn_text = g.get("title") or "➕ Extras"
        keyboard.append(
            [InlineKeyboardButton(btn_text, callback_data=f"sendseason:{topic_id}:extras:{idx_ex}")]
        )
    
    keyboard.append([InlineKeyboardButton("🎬 Serie completa",callback_data=f"sendseason:{topic_id}:all")])
    keyboard.append([InlineKeyboardButton("🔙 Volver",callback_data="main_menu")])
    await query.edit_message_text(
        f"📺 <b>{escape(fix_text(info.get('name','Serie')))}</b>\nElige una temporada:",
        parse_mode="HTML",
        reply_markup=InlineKeyboardMarkup(keyboard)
    )

async def on_random_peli(update: Update, context: ContextTypes.DEFAULT_TYPE):
    import random
    query = update.callback_query
    await query.answer()
    topics = load_topics()
    tid = get_pelis_topic_id(topics)
    if not tid:
        await query.edit_message_text("❌ No hay tema de películas.")
        return
    movies = topics[tid].get("movies",[])
    if not movies:
        await query.edit_message_text("❌ No hay películas registradas.")
        return
    m = random.choice(movies)
    bot=context.bot
    user=query.from_user.id
    await bot.copy_message(chat_id=user,from_chat_id=GROUP_ID,message_id=m["id"])
    await bot.send_message(chat_id=user,text=f"🎬 Película aleatoria enviada: {m['title']}",
        reply_markup=InlineKeyboardMarkup([
            [InlineKeyboardButton("🈯️ Revisar idioma", callback_data=f"lang_review:{tid}:{m['id']}")],
            [InlineKeyboardButton("🔙 Volver al catálogo", callback_data="main_menu")]
        ]))


# ======================================================
#    /BUSCARUSER (solo OWNER)
# ======================================================
async def buscaruser(update: Update, context: ContextTypes.DEFAULT_TYPE):
    user = update.effective_user

    if user.id != OWNER_ID:
        await update.message.reply_text("⛔ No tienes permiso para usar este comando.")
        return

    if not context.args:
        await update.message.reply_text(
            "❌ Uso correcto:\n/buscaruser @usuario",
            parse_mode="HTML"
        )
        return

    query = context.args[0].strip().lstrip("@").lower()
    users = load_users()

    for uid, info in users.items():
        username = (info.get("username") or "").lstrip("@").lower()
        if username == query:
            name = escape(fix_text(info.get("name", "Sin nombre")))
            uname = escape(info.get("username", ""))
            user_id = info.get("id")

            await update.message.reply_text(
                "✅ <b>USUARIO ENCONTRADO</b>\n\n"
                f"👤 Nombre: <b>{name}</b>\n"
                f"🔗 Usuario: <b>{uname}</b>\n"
                f"🆔 ID: <code>{user_id}</code>",
                parse_mode="HTML"
            )
            return

    await update.message.reply_text(
        "❌ <b>USUARIO NO ENCONTRADO</b>\n"
        "Ese usuario no ha iniciado el bot.",
        parse_mode="HTML"
    )



# ======================================================
#    COMANDOS EXTRA (NO MOSTRAR EN /start)
#    - /listaseries  (solo owner) -> devuelve un .txt con todas las series
#    - /s  Titulo (Año)  -> envía la serie completa
#    - /s1 Titulo (Año)  -> envía temporada 1
#    - /s2 ...           -> envía temporada 2
#    etc...
#    Nota: reutiliza el MISMO sistema de envío (copy_messages_safely) y la
#    misma lógica de análisis de temporadas usada por el catálogo normal.
# ======================================================

def _normalize_title(s: str) -> str:
    return fix_text((s or "")).strip().lower()


def _find_series_topic_id_by_name(query_text: str, topics: dict):
    """Encuentra el topic_id de una SERIE por nombre (normalizado)."""
    qn = _normalize_title(query_text)
    if not qn:
        return None

    series_items = [(tid, info) for tid, info in topics.items() if not info.get("is_pelis")]
    if not series_items:
        return None

    # 1) exacto normalizado
    for tid, info in series_items:
        if _normalize_title(info.get("name", "")) == qn:
            return str(tid)

    # 2) aproximación (difflib)
    names_norm = [_normalize_title(info.get("name", "")) for _, info in series_items]
    matches = difflib.get_close_matches(qn, names_norm, n=1, cutoff=0.85)
    if matches:
        best_norm = matches[0]
        for tid, info in series_items:
            if _normalize_title(info.get("name", "")) == best_norm:
                return str(tid)

    # 3) contiene
    for tid, info in series_items:
        if qn in _normalize_title(info.get("name", "")):
            return str(tid)

    return None


async def _ensure_series_analyzed_if_needed(bot, user_id: int, topic_id: str, topics: dict, info: dict):
    """Si la serie aún no tiene seasons_built, ejecuta el MISMO análisis que usa send_topic."""
    ensure_season_structure(info)
    if info.get("seasons_built"):
        return

    settings = load_settings()
    analyze_tid = settings.get("analysis_topic_id")
    if not analyze_tid:
        await bot.send_message(
            chat_id=user_id,
            text="⚠️ No hay tema de análisis configurado. Pide al administrador que use /setanalisis.",
        )
        return

    try:
        analyze_tid_int = int(analyze_tid)
    except (TypeError, ValueError):
        await bot.send_message(
            chat_id=user_id,
            text="⚠️ El tema de análisis configurado no es válido. Pide al administrador que use /setanalisis de nuevo.",
        )
        return

    mensajes = [m["id"] for m in info.get("messages", [])]
    if not mensajes:
        await bot.send_message(chat_id=user_id, text="❌ Este tema no tiene mensajes.")
        return

    total = len(mensajes)
    await bot.send_message(
        chat_id=user_id,
        text=(
            "⏳ Esta serie aún no está analizada.\n"
            "Voy a analizarla ahora para poder separar temporadas.\n"
            "Te mostraré el progreso en este chat."
        ),
    )

    progress_msg = await bot.send_message(chat_id=user_id, text="Progreso: 0%")
    progress_msg_id = progress_msg.message_id

    # inicializa estructura (igual que en send_topic)
    info["seasons"] = {}
    info["current_season"] = 1
    info["extras"] = []
    info["is_extras_section"] = False
    info["capture_extras_id"] = 0

    for idx, mid in enumerate(mensajes, start=1):
        fwd = None
        while True:
            try:
                fwd = await bot.forward_message(
                    chat_id=GROUP_ID,
                    message_thread_id=analyze_tid_int,
                    from_chat_id=GROUP_ID,
                    message_id=mid,
                )
                await asyncio.sleep(0.08)
                break
            except RetryAfter as e:
                await asyncio.sleep(int(e.retry_after) + 1)
            except BadRequest as e:
                print(f"[cmd/analizar] BadRequest reenviando msg {mid}: {e}")
                break
            except Exception as e:
                print(f"[cmd/analizar] Error reenviando msg {mid}: {e}")
                break

        if fwd is not None:
            try:
                process_message_for_seasons(info, fwd, mid)
            except Exception as e:
                print(f"[cmd/analizar] Error process_message_for_seasons msg {mid}: {e}")

            try:
                await fwd.delete()
            except Exception:
                pass

        if idx == total or idx % 50 == 0:
            progress = (idx / total) * 100
            try:
                await bot.edit_message_text(
                    chat_id=user_id,
                    message_id=progress_msg_id,
                    text=f"Progreso: {progress:.1f}%",
                )
            except Exception:
                pass

    try:
        await bot.edit_message_text(
            chat_id=user_id,
            message_id=progress_msg_id,
            text="✔ Análisis completado.",
        )
    except Exception:
        pass

    info["seasons_built"] = True
    topics[topic_id] = info
    save_topics(topics)


async def listaseries(update: Update, context: ContextTypes.DEFAULT_TYPE):
    """Owner-only: envía un .txt con todas las series en formato: Titulo (año) | Payload"""
    if update.effective_user.id != OWNER_ID:
        await update.message.reply_text("⛔ No tienes permiso para usar este comando.")
        return

    topics = load_topics()
    _ensure_series_payloads(topics)

    rows = []
    for tid, info in topics.items():
        if info.get("is_pelis"):
            continue
        name = fix_text(info.get("name", "")).strip()
        payload = (info.get("payload") or f"s{tid}").strip()
        if name:
            rows.append((name, payload))

    rows.sort(key=lambda x: _normalize_title(x[0]))

    content = "\n".join([f"{name} | {payload}" for name, payload in rows]) + ("\n" if rows else "")
    bio = io.BytesIO(content.encode("utf-8"))
    bio.name = "series.txt"

    await update.message.reply_document(
        document=bio,
        filename="series.txt",
        caption=f"📄 Series registradas: {len(rows)}",
    )


async def cmd_send_series(update: Update, context: ContextTypes.DEFAULT_TYPE):
    """Maneja /s y /sN (N=1..n). Reutiliza copy_messages_safely y la estructura seasons."""
    msg = update.effective_message
    if msg is None or not msg.text:
        return

    text = msg.text.strip()
    m = re.match(r"^/s(\d+)?(?:@\w+)?(?:\s+(.+))?$", text)
    if not m:
        return

    season_num = m.group(1)  # None para /s, "1" para /s1, ...
    query_text = (m.group(2) or "").strip()

    if not query_text:
        if season_num:
            await msg.reply_text("Uso: /sN Titulo (Año)\nEj: /s1 Instinto (2024)")
        else:
            await msg.reply_text("Uso: /s Titulo (Año)\nEj: /s Instinto (2024)")
        return

    topics = load_topics()
    topic_id = _find_series_topic_id_by_name(query_text, topics)
    if not topic_id or topic_id not in topics:
        await msg.reply_text(
            f"❌ No encontré esa serie en el catálogo:\n<b>{escape(fix_text(query_text))}</b>",
            parse_mode="HTML",
        )
        return

    info = topics[topic_id]
    if info.get("is_pelis"):
        await msg.reply_text("❌ Ese comando es solo para series.", parse_mode="HTML")
        return

    bot = context.bot
    user_id = update.effective_user.id

    # Asegura análisis si hace falta (misma lógica que send_topic)
    await _ensure_series_analyzed_if_needed(bot, user_id, topic_id, topics, info)

    # Recarga por si el análisis actualizó el JSON
    topics = load_topics()
    info = topics.get(topic_id, info)
    ensure_season_structure(info)

    seasons = info.get("seasons") or {}
    extras_groups = info.get("extras_groups") or []

    if season_num is None:
        # /s -> serie completa (todas las temporadas + extras)
        ordered_keys = sorted(seasons.keys(), key=lambda x: int(x))
        msg_ids = []
        for key in ordered_keys:
            msg_ids.extend(seasons.get(key, []))
        for g in extras_groups:
            if isinstance(g, dict):
                msg_ids.extend(g.get("messages") or [])
        label = "serie completa"
    else:
        # /sN -> temporada N
        try:
            sn = int(season_num)
        except Exception:
            await msg.reply_text("❌ Temporada inválida.", parse_mode="HTML")
            return
        msg_ids = seasons.get(str(sn), [])
        label = f"temporada {sn}"

    if not msg_ids:
        await msg.reply_text(f"❌ No hay episodios registrados para {label}.", parse_mode="HTML")
        return

    await msg.reply_text(f"📨 Enviando {label}...", parse_mode="HTML")

    enviados = await copy_messages_safely(bot, user_id, msg_ids, from_chat_id=GROUP_ID)

    await bot.send_message(
        chat_id=user_id,
        text=f"✔ Envío completado ({label}). {enviados} mensajes reenviados 🎉",
        reply_markup=InlineKeyboardMarkup(
            [
                [InlineKeyboardButton("⬅️ Volver a la serie", callback_data=f"t:{topic_id}")],
                [InlineKeyboardButton("🔙 Volver al catálogo", callback_data="main_menu")],
            ]
        ),
    )




# ======================================================
#    /PAYLOAD (OWNER) - Generador de líneas "Titulo (año) | Payload"
# ======================================================

def build_payload_main_keyboard():
    rows = []
    letters = list("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
    for i in range(0, len(letters), 5):
        chunk = letters[i:i+5]
        rows.append([InlineKeyboardButton(l, callback_data=f"pay_letter:{l}") for l in chunk])
    rows.append([InlineKeyboardButton("#", callback_data="pay_letter:#")])
    rows.append([InlineKeyboardButton("🕒 Series recientes", callback_data="pay_recent")])
    rows.append([InlineKeyboardButton("❌ Cerrar", callback_data="pay_close")])
    return InlineKeyboardMarkup(rows)


def build_payload_letter_page(letter, page, topics_dict):
    filtrados = filtrar_por_letra(topics_dict, letter)
    # solo series (por seguridad)
    filtrados = [(tid, info) for tid, info in filtrados if not info.get("is_pelis")]

    total = len(filtrados)
    if total == 0:
        return (
            f"📭 No hay series que empiecen por <b>{escape(letter)}</b>.",
            InlineKeyboardMarkup([[InlineKeyboardButton("🔙 Volver", callback_data="pay_main")]]),
        )

    total_pages = max(1, math.ceil(total / PAGE_SIZE))
    page = max(1, min(page, total_pages))

    start_idx = (page - 1) * PAGE_SIZE
    end_idx = start_idx + PAGE_SIZE
    slice_items = filtrados[start_idx:end_idx]

    keyboard = []
    for tid, info in slice_items:
        safe_name = escape(fix_text(info.get("name", "")))
        keyboard.append([InlineKeyboardButton(f"📺 {safe_name}", callback_data=f"pay_pick:{tid}")])

    nav_row = []
    if total_pages > 1:
        if page > 1:
            nav_row.append(InlineKeyboardButton("⬅️", callback_data=f"pay_page:{letter}:{page-1}"))
        nav_row.append(InlineKeyboardButton(f"{page}/{total_pages}", callback_data="pay_nop"))
        if page < total_pages:
            nav_row.append(InlineKeyboardButton("➡️", callback_data=f"pay_page:{letter}:{page+1}"))
        keyboard.append(nav_row)

    keyboard.append([InlineKeyboardButton("🔙 Volver", callback_data="pay_main")])

    return (f"📦 <b>Payload</b> — Series con <b>{escape(letter)}</b>", InlineKeyboardMarkup(keyboard))


def build_payload_recent_page(page, topics_dict):
    # Solo series y ordenadas por created_at desc
    items = [(tid, info) for tid, info in topics_dict.items() if not info.get("is_pelis")]
    items.sort(key=lambda x: x[1].get("created_at", 0), reverse=True)

    total = len(items)
    if total == 0:
        return (
            "📭 No hay series aún.",
            InlineKeyboardMarkup([[InlineKeyboardButton("🔙 Volver", callback_data="pay_main")]]),
        )

    # paginamos sobre un máximo razonable (por si tienes miles)
    max_items = max(RECENT_LIMIT, PAGE_SIZE * 5)
    items = items[:max_items]

    total = len(items)
    total_pages = max(1, math.ceil(total / PAGE_SIZE))
    page = max(1, min(page, total_pages))

    start_idx = (page - 1) * PAGE_SIZE
    end_idx = start_idx + PAGE_SIZE
    slice_items = items[start_idx:end_idx]

    keyboard = []
    for tid, info in slice_items:
        safe_name = escape(fix_text(info.get("name", "")))
        keyboard.append([InlineKeyboardButton(f"🕒 {safe_name}", callback_data=f"pay_pick:{tid}")])

    nav_row = []
    if total_pages > 1:
        if page > 1:
            nav_row.append(InlineKeyboardButton("⬅️", callback_data=f"pay_recent_page:{page-1}"))
        nav_row.append(InlineKeyboardButton(f"{page}/{total_pages}", callback_data="pay_nop"))
        if page < total_pages:
            nav_row.append(InlineKeyboardButton("➡️", callback_data=f"pay_recent_page:{page+1}"))
        keyboard.append(nav_row)

    keyboard.append([InlineKeyboardButton("🔙 Volver", callback_data="pay_main")])

    return ("🕒 <b>Series recientes</b> — Selecciona una para obtener la línea de importación", InlineKeyboardMarkup(keyboard))


async def payload(update: Update, context: ContextTypes.DEFAULT_TYPE):
    """Owner-only: abre selector de series para copiar 'Titulo (año) | Payload'."""
    if not can_use_payload(update.effective_user.id):
        await update.message.reply_text("⛔ No tienes permiso para usar este comando.")
        return

    topics = load_topics()
    _ensure_series_payloads(topics)

    await update.message.reply_text(
        "📦 <b>Generador de payload</b>\n"
        "Elige una letra o recientes. Al seleccionar una serie, te devolveré:\n"
        "<code>Titulo (año) | Payload</code>",
        parse_mode="HTML",
        reply_markup=build_payload_main_keyboard(),
    )


async def on_pay_main(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    if not can_use_payload(query.from_user.id):
        await query.edit_message_text("⛔ No tienes permiso.")
        return

    topics = load_topics()
    _ensure_series_payloads(topics)

    await query.edit_message_text(
        "📦 <b>Generador de payload</b>\n"
        "Elige una letra o recientes. Al seleccionar una serie, te devolveré:\n"
        "<code>Titulo (año) | Payload</code>",
        parse_mode="HTML",
        reply_markup=build_payload_main_keyboard(),
    )


async def on_pay_letter(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    if not can_use_payload(query.from_user.id):
        await query.edit_message_text("⛔ No tienes permiso.")
        return

    _, letter = query.data.split(":", 1)
    topics = load_topics()
    _ensure_series_payloads(topics)

    text_msg, markup = build_payload_letter_page(letter, 1, topics)
    await query.edit_message_text(text=text_msg, parse_mode="HTML", reply_markup=markup)


async def on_pay_page(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    if not can_use_payload(query.from_user.id):
        await query.edit_message_text("⛔ No tienes permiso.")
        return

    _, letter, page_str = query.data.split(":", 2)
    page = int(page_str)

    topics = load_topics()
    _ensure_series_payloads(topics)

    text_msg, markup = build_payload_letter_page(letter, page, topics)
    await query.edit_message_text(text=text_msg, parse_mode="HTML", reply_markup=markup)


async def on_pay_recent(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    if not can_use_payload(query.from_user.id):
        await query.edit_message_text("⛔ No tienes permiso.")
        return

    topics = load_topics()
    _ensure_series_payloads(topics)

    text_msg, markup = build_payload_recent_page(1, topics)
    await query.edit_message_text(text=text_msg, parse_mode="HTML", reply_markup=markup)


async def on_pay_recent_page(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    if not can_use_payload(query.from_user.id):
        await query.edit_message_text("⛔ No tienes permiso.")
        return

    _, page_str = query.data.split(":", 1)
    page = int(page_str)

    topics = load_topics()
    _ensure_series_payloads(topics)

    text_msg, markup = build_payload_recent_page(page, topics)
    await query.edit_message_text(text=text_msg, parse_mode="HTML", reply_markup=markup)


async def on_pay_pick(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    if not can_use_payload(query.from_user.id):
        await query.edit_message_text("⛔ No tienes permiso.")
        return

    _, tid = query.data.split(":", 1)
    topics = load_topics()
    _ensure_series_payloads(topics)

    info = topics.get(tid)
    if not info or info.get("is_pelis"):
        await query.edit_message_text(
            "⚠️ Serie no encontrada.",
            reply_markup=InlineKeyboardMarkup([[InlineKeyboardButton("🔙 Volver", callback_data="pay_main")]]),
        )
        return

    name = fix_text(info.get("name", "")).strip()
    payload_val = (info.get("payload") or f"s{tid}").strip()

    line = f"{name} | {payload_val}"

    await query.edit_message_text(
        "✅ <b>Línea para importar en la APP</b>\n\n"
        f"<code>{escape(line)}</code>\n\n"
        "Cópiala y pégala en el panel admin.",
        parse_mode="HTML",
        reply_markup=InlineKeyboardMarkup([[InlineKeyboardButton("🔙 Volver", callback_data="pay_main")]]),
    )



async def on_pay_nop(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()


async def on_pay_close(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    if not can_use_payload(query.from_user.id):
        await query.edit_message_text("⛔ No tienes permiso.")
        return
    try:
        await query.delete_message()
    except Exception:
        # si no se puede borrar, al menos lo editamos
        await query.edit_message_text("✅ Cerrado.")




# ======================================================
#    /UPDATE — Sube catálogo actualizado a GitHub (solo owner)
# ======================================================

def _extract_year_from_title(name: str):
    """Extrae el año entre paréntesis del nombre de la serie/película, e.g. 'Serie (2023)' → 2023."""
    m = re.search(r"\((\d{4})\)", name)
    if m:
        y = int(m.group(1))
        if 1900 <= y <= 2099:
            return y
    return None


def _build_catalog_json(topics: dict) -> str:
    """Genera el catalog.json para series en el formato [{title, year, payload}]."""
    rows = []
    for tid, info in topics.items():
        if info.get("is_pelis"):
            continue
        name = fix_text(info.get("name", "")).strip()
        if not name:
            continue
        payload_val = (info.get("payload") or f"s{tid}").strip()
        year = _extract_year_from_title(name)
        rows.append({"title": name, "year": year, "payload": payload_val})

    rows.sort(key=lambda x: _normalize_title(x["title"]))
    return json.dumps(rows, ensure_ascii=False, indent=2)


def _build_movies_json(topics: dict) -> str:
    """
    Genera movies.json para la app Desktop en formato:
    [{title, search_title, year}]
    Mismo esquema que usa la Railway DB (columnas title, search_title, year).
    """
    seen: set = set()  # dedup por título normalizado
    rows = []

    for tid, info in topics.items():
        if not info.get("is_pelis"):
            continue
        for movie in info.get("movies", []):
            title = fix_text((movie.get("title") or "")).strip()
            if not title:
                continue
            # Clave de dedup: normalizar
            dedup = re.sub(r"\s*\(\d{4}\)\s*$", "", title).lower()
            dedup = re.sub(r"[^a-z0-9]", "", _normalize_ascii(dedup))
            if dedup in seen:
                continue
            seen.add(dedup)

            # search_title: quitar año y etiquetas de idioma para búsqueda TMDB
            search_title = re.sub(
                r"\s*\([^)]*(?:castellano|latino|español|subtitulado|cast)[^)]*\)",
                "", title, flags=re.IGNORECASE
            )
            search_title = re.sub(r"\s*\(\d{4}\)\s*$", "", search_title).strip()
            if not search_title:
                search_title = title

            year = _extract_year_from_title(title)
            rows.append({"title": title, "search_title": search_title, "year": year})

    rows.sort(key=lambda x: _normalize_ascii((x["title"] or "").lower()))
    return json.dumps(rows, ensure_ascii=False, indent=2)


def _github_put_file(path: str, content_bytes: bytes, commit_msg: str) -> tuple[bool, str]:
    """
    Crea o actualiza un fichero en el repo de GitHub via API.
    Devuelve (ok: bool, mensaje: str).
    """
    token = GITHUB_TOKEN
    if not token:
        return False, "GITHUB_TOKEN no configurado."
    
    repo = os.getenv("GITHUB_REPO", "Crono2021/cineflix-catalog").strip()

    url = f"{GITHUB_API}/repos/{repo}/contents/{path}"
    headers = {
        "Authorization": f"token {token}",
        "Accept": "application/vnd.github+json",
        "Content-Type": "application/json",
    }

    # 1. Obtener SHA si el fichero ya existe
    sha = None
    try:
        req_get = urllib.request.Request(url, headers=headers)
        with urllib.request.urlopen(req_get, timeout=15) as resp:
            existing = json.loads(resp.read().decode("utf-8"))
            sha = existing.get("sha")
    except urllib.error.HTTPError as e:
        if e.code != 404:
            return False, f"Error al consultar GitHub (GET {path}): {e.code} {e.reason}"
    except Exception as e:
        return False, f"Error de red consultando GitHub: {e}"

    # 2. PUT con el contenido en base64
    body: dict = {
        "message": commit_msg,
        "content": base64.b64encode(content_bytes).decode("ascii"),
    }
    if sha:
        body["sha"] = sha

    try:
        data = json.dumps(body).encode("utf-8")
        req_put = urllib.request.Request(url, data=data, headers=headers, method="PUT")
        with urllib.request.urlopen(req_put, timeout=30) as resp:
            resp.read()  # consumir respuesta
        return True, f"✅ `{path}` subido correctamente."
    except urllib.error.HTTPError as e:
        try:
            body_err = e.read().decode("utf-8", errors="replace")
        except Exception:
            body_err = ""
        return False, f"Error al subir `{path}` a GitHub: {e.code} — {body_err[:200]}"
    except Exception as e:
        return False, f"Error de red al subir `{path}`: {e}"


async def cmd_update(update: Update, context: ContextTypes.DEFAULT_TYPE):
    """Owner-only: regenera catalog.json y lista_peliculas.txt y los sube al repo de GitHub."""
    user = update.effective_user
    if user is None or user.id != OWNER_ID:
        await update.message.reply_text("⛔ No tienes permiso para usar este comando.")
        return

    msg = await update.message.reply_text(
        "🔄 Generando catálogo actualizado…",
        parse_mode="HTML",
    )

    topics = load_topics()
    _ensure_series_payloads(topics)

    # ── Generar catalog.json (series) ────────────────────────────────────────
    catalog_json = _build_catalog_json(topics)
    series_count = catalog_json.count('"payload"')  # contar entradas rápido

    # ── Generar movies.json (películas) ─────────────────────────────────────
    movies_json = _build_movies_json(topics)
    peli_count = movies_json.count('"title"')  # contar entradas rápido

    now_str = datetime.now().strftime("%Y-%m-%d %H:%M")

    await context.bot.edit_message_text(
        chat_id=msg.chat_id,
        message_id=msg.message_id,
        text=(
            f"📦 <b>Catálogo generado</b>\n"
            f"• Series: <b>{series_count}</b>\n"
            f"• Películas: <b>{peli_count}</b>\n\n"
            "⬆️ Subiendo a GitHub…"
        ),
        parse_mode="HTML",
    )

    resultados = []

    # ── Subir catalog.json ───────────────────────────────────────────────────
    ok1, msg1 = await asyncio.get_event_loop().run_in_executor(
        None,
        _github_put_file,
        "catalog.json",
        catalog_json.encode("utf-8"),
        f"🤖 /update: catalog.json — {now_str} ({series_count} series)",
    )
    resultados.append(msg1)

    # ── Subir movies.json ────────────────────────────────────────────────────
    ok2, msg2 = await asyncio.get_event_loop().run_in_executor(
        None,
        _github_put_file,
        "movies.json",
        movies_json.encode("utf-8"),
        f"🤖 /update: movies.json — {now_str} ({peli_count} películas)",
    )
    resultados.append(msg2)

    todo_ok = ok1 and ok2
    icono = "✅" if todo_ok else "⚠️"

    await context.bot.edit_message_text(
        chat_id=msg.chat_id,
        message_id=msg.message_id,
        text=(
            f"{icono} <b>Actualización completada</b> — {now_str}\n\n"
            + "\n".join(resultados) +
            f"\n\n🔗 Repo: <code>{GITHUB_REPO}</code>\n"
            f"📺 Series: <b>{series_count}</b> | 🎬 Películas: <b>{peli_count}</b>"
        ),
        parse_mode="HTML",
    )


def main():
    app = (
        ApplicationBuilder()
        .token(BOT_TOKEN)
        .connect_timeout(30.0)
        .read_timeout(30.0)
        .write_timeout(30.0)
        .pool_timeout(30.0)
        .build()
    )
    # Guard global de usuarios baneados (se ejecuta antes del resto de handlers)
    app.add_handler(MessageHandler(filters.ALL, ban_guard_message), group=-1)
    app.add_handler(CallbackQueryHandler(ban_guard_callback, pattern=r".*"), group=-1)

    app.add_handler(CallbackQueryHandler(on_random_serie, pattern=r"^rnd_serie$"))
    app.add_handler(CallbackQueryHandler(on_random_peli, pattern=r"^rnd_peli$"))

    # Comandos usuario
    app.add_handler(CommandHandler("start", start))
    app.add_handler(CommandHandler("temas", temas))
    app.add_handler(CommandHandler("stats", stats))
    app.add_handler(CommandHandler("buscaruser", buscaruser))
    app.add_handler(CommandHandler("peli", peli_directo)) # <--- COMANDO AÑADIDO
    
    # NUEVOS COMANDOS: extras y finalizar (Ahora abiertos a todos los miembros del grupo)
    app.add_handler(CommandHandler("extras", extras_mode, filters=filters.ChatType.GROUPS))
    app.add_handler(CommandHandler("actualizar", actualizar_extra_mode, filters=filters.ChatType.GROUPS))
    app.add_handler(CallbackQueryHandler(actualizar_extra_callback, pattern=r"^updextra:\d+$"))
    app.add_handler(CommandHandler("finalizar", finalizar_mode, filters=filters.ChatType.GROUPS))

    # Comandos solo owner
    app.add_handler(CommandHandler("ocultar", ocultar))
    app.add_handler(CommandHandler("borrartema", borrartema))
    app.add_handler(CommandHandler("reiniciar_db", reiniciar_db))
    app.add_handler(CommandHandler("setpelis", setpelis))
    app.add_handler(CommandHandler("setanalisis", setanalisis))
    app.add_handler(CommandHandler("setcontrol", setcontrol))
    app.add_handler(CommandHandler("silencio", silencio))
    app.add_handler(CommandHandler("reanalizar", reanalizar))
    app.add_handler(CommandHandler("analizartodo", analizartodo))
    app.add_handler(CallbackQueryHandler(reanalizar_callback, pattern=r"^reanal_"))
    app.add_handler(CommandHandler("activar", activar))
    app.add_handler(CommandHandler("usuarios", usuarios))
    app.add_handler(CommandHandler("exportar", exportar))
    app.add_handler(CommandHandler("importar", importar))
    app.add_handler(CommandHandler("update", cmd_update))
    app.add_handler(CommandHandler("repararpelis", repararpelis))
    app.add_handler(CommandHandler("repararpelis", repararpelis))
    app.add_handler(CommandHandler("mensaje", mensaje))
    app.add_handler(CommandHandler("banear", banear))
    app.add_handler(CommandHandler("unban", unban))

    # Series -> export/import con payload (solo owner)
    app.add_handler(CommandHandler("listaseries", listaseries))
    app.add_handler(CommandHandler("payload", payload))

    # Callbacks navegación general
    app.add_handler(CallbackQueryHandler(on_letter, pattern=r"^letter:"))
    app.add_handler(CallbackQueryHandler(on_page, pattern=r"^page:"))
    app.add_handler(CallbackQueryHandler(on_main_menu, pattern=r"^main_menu$"))
    app.add_handler(CallbackQueryHandler(on_search_btn, pattern=r"^search$"))
    app.add_handler(CallbackQueryHandler(on_recent_btn, pattern=r"^recent$"))
    app.add_handler(CallbackQueryHandler(on_pelis_btn, pattern=r"^pelis$"))
    app.add_handler(CallbackQueryHandler(on_pelis_recent_btn, pattern=r"^pelis_recent$"))

    app.add_handler(CallbackQueryHandler(on_req_update_btn, pattern=r"^req_update$"))
    app.add_handler(CallbackQueryHandler(on_rep_error_btn, pattern=r"^rep_error$"))
    app.add_handler(CallbackQueryHandler(on_req_letters, pattern=r"^req_letters:"))
    app.add_handler(CallbackQueryHandler(on_req_letter, pattern=r"^req_letter:"))
    app.add_handler(CallbackQueryHandler(on_req_page, pattern=r"^req_page:"))
    app.add_handler(CallbackQueryHandler(on_req_series, pattern=r"^req_series:"))
    app.add_handler(CallbackQueryHandler(on_req_mark, pattern=r"^req_mark:"))
    app.add_handler(CallbackQueryHandler(on_req_peli_btn, pattern=r"^req_peli$"))
    app.add_handler(CallbackQueryHandler(on_req_peli_mark, pattern=r"^req_peli_mark:"))
    
    app.add_handler(CallbackQueryHandler(on_lang_review, pattern=r"^lang_review:"))
    app.add_handler(CallbackQueryHandler(on_lang_confirm, pattern=r"^lang_conf:"))
    app.add_handler(CallbackQueryHandler(on_lang_cancel, pattern=r"^lang_canc:"))

    app.add_handler(CallbackQueryHandler(on_lang_complete, pattern=r"^lang_complete:"))
    app.add_handler(CallbackQueryHandler(on_pelis_page, pattern=r"^pelis_page:"))

    # Callbacks borrado temas
    app.add_handler(CallbackQueryHandler(on_del_main, pattern=r"^del_main$"))
    app.add_handler(CallbackQueryHandler(on_del_letter, pattern=r"^del_letter:"))
    app.add_handler(CallbackQueryHandler(on_del_page, pattern=r"^del_page:"))

    # Callbacks de temas / películas / usuarios
    app.add_handler(CallbackQueryHandler(send_topic, pattern=r"^t:"))
    app.add_handler(CallbackQueryHandler(send_season, pattern=r"^sendseason:"))
    app.add_handler(CallbackQueryHandler(delete_topic, pattern=r"^del:"))
    app.add_handler(CallbackQueryHandler(send_peli_message, pattern=r"^pelis_msg:"))
    app.add_handler(CallbackQueryHandler(on_users_page, pattern=r"^users_page:"))


    # Callbacks /payload (solo owner)
    app.add_handler(CallbackQueryHandler(on_pay_main, pattern=r"^pay_main$"))
    app.add_handler(CallbackQueryHandler(on_pay_letter, pattern=r"^pay_letter:"))
    app.add_handler(CallbackQueryHandler(on_pay_page, pattern=r"^pay_page:"))
    app.add_handler(CallbackQueryHandler(on_pay_recent, pattern=r"^pay_recent$"))
    app.add_handler(CallbackQueryHandler(on_pay_recent_page, pattern=r"^pay_recent_page:"))
    app.add_handler(CallbackQueryHandler(on_pay_pick, pattern=r"^pay_pick:"))
    app.add_handler(CallbackQueryHandler(on_pay_close, pattern=r"^pay_close$"))
    app.add_handler(CallbackQueryHandler(on_pay_nop, pattern=r"^pay_nop$"))

    app.add_handler(MessageHandler(filters.Regex(r"^/s\d*(?:@\w+)?(?:\s|$)"), cmd_send_series))

    # Búsqueda por texto en privado (series o pelis según modo)
    app.add_handler(MessageHandler(filters.TEXT & ~filters.COMMAND, search_text))

    # Guardar mensajes de temas (en grupo)
    app.add_handler(MessageHandler(filters.ALL & ~filters.COMMAND, detect))

    print("BOT LISTO ✔")
    app.run_polling(drop_pending_updates=True, close_loop=False)


if __name__ == "__main__":
    main()
