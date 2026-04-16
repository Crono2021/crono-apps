package h7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import android.util.Log;
import com.network.tvgramplayer.TvgramApplication;
import com.network.tvgramplayer.service.ProxyService;
import com.network.tvgramplayer.telegram.TdClient$ExplorerAction;
import com.network.tvgramplayer.telegram.TdClient$ExplorerItem;
import com.network.tvgramplayer.telegram.TdClient$ExplorerType;
import i7.h2;
import i7.m0;
import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import n.c4;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k0 {
    public static boolean F;
    public static m0 G;
    public final l8.d A;
    public final Handler B;
    public boolean C;
    public boolean D;
    public final f E;

    /* renamed from: a, reason: collision with root package name */
    public final TvgramApplication f4131a;

    /* renamed from: b, reason: collision with root package name */
    public String f4132b = "";

    /* renamed from: c, reason: collision with root package name */
    public final n7.e f4133c;

    /* renamed from: d, reason: collision with root package name */
    public final l8.d f4134d;

    /* renamed from: e, reason: collision with root package name */
    public final l8.d f4135e;

    /* renamed from: f, reason: collision with root package name */
    public final l8.d f4136f;

    /* renamed from: g, reason: collision with root package name */
    public final l8.d f4137g;
    public final l8.d h;

    /* renamed from: i, reason: collision with root package name */
    public final l8.d f4138i;

    /* renamed from: j, reason: collision with root package name */
    public long f4139j;

    /* renamed from: k, reason: collision with root package name */
    public String f4140k;

    /* renamed from: l, reason: collision with root package name */
    public Client f4141l;

    /* renamed from: m, reason: collision with root package name */
    public final l8.d f4142m;

    /* renamed from: n, reason: collision with root package name */
    public long f4143n;

    /* renamed from: o, reason: collision with root package name */
    public int f4144o;

    /* renamed from: p, reason: collision with root package name */
    public String f4145p;

    /* renamed from: q, reason: collision with root package name */
    public String f4146q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4147r;

    /* renamed from: s, reason: collision with root package name */
    public final ArrayList f4148s;

    /* renamed from: t, reason: collision with root package name */
    public final ConcurrentHashMap f4149t;

    /* renamed from: u, reason: collision with root package name */
    public final l8.d f4150u;

    /* renamed from: v, reason: collision with root package name */
    public final l8.d f4151v;

    /* renamed from: w, reason: collision with root package name */
    public final ConcurrentHashMap f4152w;

    /* renamed from: x, reason: collision with root package name */
    public final n7.e f4153x;

    /* renamed from: y, reason: collision with root package name */
    public final ConcurrentHashMap f4154y;

    /* renamed from: z, reason: collision with root package name */
    public final l8.d f4155z;

    public k0(TvgramApplication tvgramApplication) {
        this.f4131a = tvgramApplication;
        final int i9 = 0;
        this.f4133c = new n7.e(new a8.a(this) { // from class: h7.g0

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ k0 f4097j;

            {
                this.f4097j = this;
            }

            @Override // a8.a
            public final Object d() {
                androidx.fragment.app.g c9;
                switch (i9) {
                    case 0:
                        k0 k0Var = this.f4097j;
                        Log.i("TdClient", "🛠️ Initializing EncryptedSharedPreferences (this can be slow on emulators)...");
                        long currentTimeMillis = System.currentTimeMillis();
                        b6.i0 i0Var = new b6.i0(k0Var.f4131a);
                        int i10 = Build.VERSION.SDK_INT;
                        if (i10 >= 23 && ((KeyGenParameterSpec) i0Var.f1400l) != null) {
                            m7.c.n("KeyScheme set after setting a KeyGenParamSpec");
                            return null;
                        }
                        i0Var.f1398j = 1;
                        a6.d a9 = i10 >= 23 ? q3.d.a(i0Var) : new a6.d((Object) null, (String) i0Var.f1399k);
                        TvgramApplication tvgramApplication2 = k0Var.f4131a;
                        String str = a9.f208b;
                        int i11 = k6.a.f5620a;
                        f6.n.g(k6.c.f5625b);
                        if (!j6.a.a()) {
                            f6.n.e(new g6.h(r6.f0.class, new g6.f[]{new g6.f(9, f6.c.class)}, 8), true);
                        }
                        g6.a.a();
                        Context applicationContext = tvgramApplication2.getApplicationContext();
                        c4 c4Var = new c4();
                        c4Var.f6839f = f6.b.a("AES256_SIV");
                        if (applicationContext == null) {
                            m7.c.n("need an Android context");
                            return null;
                        }
                        c4Var.f6834a = applicationContext;
                        c4Var.f6835b = "__androidx_security_crypto_encrypted_prefs_key_keyset__";
                        c4Var.f6836c = "tdlib_prefs";
                        String b9 = t.a.b("android-keystore://", str);
                        if (!b9.startsWith("android-keystore://")) {
                            m7.c.n("key URI must start with android-keystore://");
                            return null;
                        }
                        c4Var.f6837d = b9;
                        l6.a a10 = c4Var.a();
                        synchronized (a10) {
                            c9 = a10.f6267a.c();
                        }
                        c4 c4Var2 = new c4();
                        c4Var2.f6839f = f6.b.a("AES256_GCM");
                        c4Var2.f6834a = applicationContext;
                        c4Var2.f6835b = "__androidx_security_crypto_encrypted_prefs_value_keyset__";
                        c4Var2.f6836c = "tdlib_prefs";
                        String b10 = t.a.b("android-keystore://", str);
                        if (!b10.startsWith("android-keystore://")) {
                            m7.c.n("key URI must start with android-keystore://");
                            return null;
                        }
                        c4Var2.f6837d = b10;
                        q3.b bVar = new q3.b(applicationContext.getSharedPreferences("tdlib_prefs", 0), (f6.a) c4Var2.a().a().W(f6.a.class), (f6.c) c9.W(f6.c.class));
                        Log.i("TdClient", "✅ EncryptedSharedPreferences ready in " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                        return bVar;
                    default:
                        return new k7.a(this.f4097j.f4131a);
                }
            }
        });
        l8.d a9 = l8.e.a("UNKNOWN");
        this.f4134d = a9;
        this.f4135e = a9;
        l8.d a10 = l8.e.a(null);
        this.f4136f = a10;
        this.f4137g = a10;
        l8.d a11 = l8.e.a(null);
        this.h = a11;
        this.f4138i = a11;
        this.f4142m = l8.e.a(null);
        this.f4148s = new ArrayList();
        this.f4149t = new ConcurrentHashMap();
        o7.p pVar = o7.p.f8013i;
        l8.d a12 = l8.e.a(pVar);
        this.f4150u = a12;
        this.f4151v = a12;
        this.f4152w = new ConcurrentHashMap();
        final int i10 = 1;
        this.f4153x = new n7.e(new a8.a(this) { // from class: h7.g0

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ k0 f4097j;

            {
                this.f4097j = this;
            }

            @Override // a8.a
            public final Object d() {
                androidx.fragment.app.g c9;
                switch (i10) {
                    case 0:
                        k0 k0Var = this.f4097j;
                        Log.i("TdClient", "🛠️ Initializing EncryptedSharedPreferences (this can be slow on emulators)...");
                        long currentTimeMillis = System.currentTimeMillis();
                        b6.i0 i0Var = new b6.i0(k0Var.f4131a);
                        int i102 = Build.VERSION.SDK_INT;
                        if (i102 >= 23 && ((KeyGenParameterSpec) i0Var.f1400l) != null) {
                            m7.c.n("KeyScheme set after setting a KeyGenParamSpec");
                            return null;
                        }
                        i0Var.f1398j = 1;
                        a6.d a92 = i102 >= 23 ? q3.d.a(i0Var) : new a6.d((Object) null, (String) i0Var.f1399k);
                        TvgramApplication tvgramApplication2 = k0Var.f4131a;
                        String str = a92.f208b;
                        int i11 = k6.a.f5620a;
                        f6.n.g(k6.c.f5625b);
                        if (!j6.a.a()) {
                            f6.n.e(new g6.h(r6.f0.class, new g6.f[]{new g6.f(9, f6.c.class)}, 8), true);
                        }
                        g6.a.a();
                        Context applicationContext = tvgramApplication2.getApplicationContext();
                        c4 c4Var = new c4();
                        c4Var.f6839f = f6.b.a("AES256_SIV");
                        if (applicationContext == null) {
                            m7.c.n("need an Android context");
                            return null;
                        }
                        c4Var.f6834a = applicationContext;
                        c4Var.f6835b = "__androidx_security_crypto_encrypted_prefs_key_keyset__";
                        c4Var.f6836c = "tdlib_prefs";
                        String b9 = t.a.b("android-keystore://", str);
                        if (!b9.startsWith("android-keystore://")) {
                            m7.c.n("key URI must start with android-keystore://");
                            return null;
                        }
                        c4Var.f6837d = b9;
                        l6.a a102 = c4Var.a();
                        synchronized (a102) {
                            c9 = a102.f6267a.c();
                        }
                        c4 c4Var2 = new c4();
                        c4Var2.f6839f = f6.b.a("AES256_GCM");
                        c4Var2.f6834a = applicationContext;
                        c4Var2.f6835b = "__androidx_security_crypto_encrypted_prefs_value_keyset__";
                        c4Var2.f6836c = "tdlib_prefs";
                        String b10 = t.a.b("android-keystore://", str);
                        if (!b10.startsWith("android-keystore://")) {
                            m7.c.n("key URI must start with android-keystore://");
                            return null;
                        }
                        c4Var2.f6837d = b10;
                        q3.b bVar = new q3.b(applicationContext.getSharedPreferences("tdlib_prefs", 0), (f6.a) c4Var2.a().a().W(f6.a.class), (f6.c) c9.W(f6.c.class));
                        Log.i("TdClient", "✅ EncryptedSharedPreferences ready in " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                        return bVar;
                    default:
                        return new k7.a(this.f4097j.f4131a);
                }
            }
        });
        this.f4154y = new ConcurrentHashMap();
        l8.d a13 = l8.e.a(pVar);
        this.f4155z = a13;
        this.A = a13;
        this.B = new Handler(Looper.getMainLooper());
        this.E = new f(this, 11);
    }

    public static List e(TdApi.MessageContent messageContent) {
        String str;
        if (messageContent instanceof TdApi.MessageText) {
            str = ((TdApi.MessageText) messageContent).text.text;
        } else if (messageContent instanceof TdApi.MessageVideo) {
            str = ((TdApi.MessageVideo) messageContent).caption.text;
        } else {
            if (!(messageContent instanceof TdApi.MessagePhoto)) {
                if (messageContent instanceof TdApi.MessageDocument) {
                    str = ((TdApi.MessageDocument) messageContent).caption.text;
                }
                return o7.p.f8013i;
            }
            str = ((TdApi.MessagePhoto) messageContent).caption.text;
        }
        str.getClass();
        if (str.length() != 0) {
            ArrayList arrayList = new ArrayList();
            for (n7.b bVar : o7.i.D0(new n7.b("tvgram://", "Ver en TVGram"), new n7.b("t.me/", "Abrir en Telegram"), new n7.b("https://", "Abrir Enlace"), new n7.b("http://", "Abrir Enlace"), new n7.b("acestream://", "Abrir AceStream"), new n7.b("magnet:", "Abrir Torrent (Magnet)"))) {
                String str2 = (String) bVar.f7480i;
                String str3 = (String) bVar.f7481j;
                int i9 = 0;
                while (true) {
                    int h02 = h8.e.h0(str, str2, i9, true);
                    if (h02 != -1) {
                        int length = str.length();
                        char[] cArr = {' ', '\n', '\r', '\t', '\"', '\'', '<', '>', ')'};
                        for (int i10 = 0; i10 < 9; i10++) {
                            int k02 = h8.e.k0(str, cArr[i10], h02, 4);
                            if (k02 != -1 && k02 < length) {
                                length = k02;
                            }
                        }
                        String obj = h8.e.u0(str.substring(h02, length)).toString();
                        if (obj.length() > str2.length()) {
                            String str4 = h8.m.f0(obj, "tvgram://", true) ? "Ver en TVGram" : (h8.e.g0(obj, "/c/", true) || h8.e.g0(obj, "/s/", true)) ? "Abrir Canal/Historial" : str3;
                            if (!arrayList.isEmpty()) {
                                int size = arrayList.size();
                                int i11 = 0;
                                while (i11 < size) {
                                    Object obj2 = arrayList.get(i11);
                                    i11++;
                                    if (b8.i.a(((TdClient$ExplorerAction) obj2).getUrl(), obj)) {
                                        break;
                                    }
                                }
                            }
                            arrayList.add(new TdClient$ExplorerAction(TdClient$ExplorerType.LINK, str4, obj));
                        }
                        i9 = length;
                    }
                }
            }
            return arrayList;
        }
        return o7.p.f8013i;
    }

    public static TdApi.File f(TdApi.MessageContent messageContent) {
        if (messageContent == null) {
            return null;
        }
        switch (messageContent.getConstructor()) {
            case TdApi.MessageAudio.CONSTRUCTOR /* 276722716 */:
                return ((TdApi.MessageAudio) messageContent).audio.audio;
            case TdApi.MessageVoiceNote.CONSTRUCTOR /* 527777781 */:
                return ((TdApi.MessageVoiceNote) messageContent).voiceNote.voice;
            case TdApi.MessageDocument.CONSTRUCTOR /* 596945783 */:
                return ((TdApi.MessageDocument) messageContent).document.document;
            case TdApi.MessageVideo.CONSTRUCTOR /* 952522912 */:
                return ((TdApi.MessageVideo) messageContent).video.video;
            default:
                return null;
        }
    }

    public static String i(TdApi.ChatType chatType) {
        if (chatType == null) {
            return null;
        }
        return chatType instanceof TdApi.ChatTypeSupergroup ? ((TdApi.ChatTypeSupergroup) chatType).isChannel ? "Canal" : "Grupo (S)" : chatType instanceof TdApi.ChatTypeBasicGroup ? "Grupo" : chatType instanceof TdApi.ChatTypePrivate ? "Usuario" : "Telegram";
    }

    public static void n(TdApi.Object object, a8.l lVar) {
        Log.i("TdClient", "Respuesta Join: " + object.getClass().getSimpleName() + " (Constructor: " + object.getConstructor() + ")");
        int constructor = object.getConstructor();
        if (constructor == -1679978726) {
            Log.e("TdClient", "❌ Error al unirse: " + ((TdApi.Error) object).message);
            lVar.a(null);
            return;
        }
        if (constructor == 578181272) {
            Log.i("TdClient", "✅ Payload recibido vía Text");
            lVar.a(((TdApi.Text) object).text);
            return;
        }
        if (constructor != 892575956) {
            Log.i("TdClient", "✅ Unido (Sin payload inmediato). Constructor: " + object.getConstructor());
            lVar.a("JOINED_SUCCESS");
            return;
        }
        TdApi.GroupCallInfo groupCallInfo = (TdApi.GroupCallInfo) object;
        Log.i("TdClient", "✅ Unido con éxito via GroupCallInfo. Payload: " + groupCallInfo.joinPayload);
        lVar.a(groupCallInfo.joinPayload);
    }

    public static boolean p(TdApi.Chat chat) {
        b8.a b9 = b8.r.b(chat.positions);
        while (b9.hasNext()) {
            if (((TdApi.ChatPosition) b9.next()).list instanceof TdApi.ChatListArchive) {
                return true;
            }
        }
        return false;
    }

    public static void r(String str) {
        Log.i("TdClient", str);
        m0 m0Var = G;
        if (m0Var != null) {
            m0Var.a("TD: ".concat(str));
        }
    }

    public final void A() {
        if (this.D) {
            return;
        }
        this.D = true;
        this.B.postDelayed(new h(this, 3), 300L);
    }

    public final void B(long j5, int i9, boolean z8, String str, int i10, TdApi.Chat chat) {
        ConcurrentHashMap concurrentHashMap = this.f4152w;
        if (!z8 || i9 == 0) {
            concurrentHashMap.remove(Long.valueOf(j5));
        } else {
            i0 i0Var = (i0) concurrentHashMap.get(Long.valueOf(j5));
            String str2 = i0Var != null ? i0Var.f4117e : "Cargando...";
            String str3 = i0Var != null ? i0Var.f4118f : null;
            if (chat != null) {
                str2 = chat.title;
                str2.getClass();
                TdApi.ChatPhotoInfo chatPhotoInfo = chat.photo;
                TdApi.File file = chatPhotoInfo != null ? chatPhotoInfo.small : null;
                if (file != null) {
                    String str4 = file.local.path;
                    str4.getClass();
                    if (str4.length() > 0) {
                        str3 = file.local.path;
                    } else {
                        Client client = this.f4141l;
                        if (client != null) {
                            client.send(new TdApi.DownloadFile(file.id, 1, 0L, 0L, true), new androidx.fragment.app.a(27));
                        }
                    }
                }
            }
            String str5 = str2;
            concurrentHashMap.put(Long.valueOf(j5), new i0(j5, i9, str.length() > 0 ? str : str5, i10, str5, str3));
        }
        if (this.C) {
            return;
        }
        this.C = true;
        this.B.postDelayed(new h(this, 2), 500L);
    }

    public final void C(File file, String str, a8.l lVar) {
        if (this.f4139j == 0) {
            Log.e("TdClient", "❌ No se puede subir archivo: ID de usuario no identificado.");
            lVar.a(Boolean.FALSE);
            return;
        }
        TdApi.SendMessage sendMessage = new TdApi.SendMessage(this.f4139j, null, null, null, null, new TdApi.InputMessageDocument(new TdApi.InputFileLocal(file.getAbsolutePath()), null, true, new TdApi.FormattedText(str, null)));
        Client client = this.f4141l;
        if (client != null) {
            client.send(sendMessage, new d(4, lVar));
        }
    }

    public final void a(String str, a8.q qVar) {
        str.getClass();
        Log.d("TdClient", "Checking chat: ".concat(str));
        String str2 = (String) h8.e.p0((CharSequence) h8.e.p0((CharSequence) h8.e.p0(h8.m.d0(h8.m.d0(h8.m.d0(h8.m.d0(h8.m.d0(h8.m.d0(h8.e.u0(str).toString(), "https://", ""), "http://", ""), "t.me/", ""), "telegram.me/", ""), "telegram.dog/", ""), "@", ""), new String[]{"?"}, 6).get(0), new String[]{"&"}, 6).get(0), new String[]{"/"}, 6).get(0);
        if (h8.e.g0(str, "+", false) || h8.e.g0(str, "joinchat/", false)) {
            Client client = this.f4141l;
            if (client != null) {
                client.send(new TdApi.CheckChatInviteLink(str), new t(qVar, this, 0));
                return;
            }
            return;
        }
        if (!h8.m.f0(str2, "-100", false)) {
            h8.l.a0(str2);
        }
        Client client2 = this.f4141l;
        if (client2 != null) {
            client2.send(new TdApi.SearchPublicChat(str2), new i(qVar, this, str2, 1));
        }
    }

    public final void b() {
        r("🧹 Limpiando caché interna de TDLib...");
        Client client = this.f4141l;
        if (client != null) {
            client.send(new TdApi.OptimizeStorage(0L, 0, 0, 0, null, new long[0], new long[0], false, 0), new f(this, 4));
        }
    }

    public final void c(int i9, a8.l lVar) {
        Client client = this.f4141l;
        if (client != null) {
            client.send(new TdApi.GetFile(i9), new b(lVar, i9, this));
        }
    }

    public final void d(int i9, long j5, long j9) {
        Client client = this.f4141l;
        if (client != null) {
            client.send(new TdApi.DownloadFile(i9, 1, j5, j9, true), new androidx.fragment.app.a(27));
        }
    }

    public final void g(long j5, long j9, int i9, long j10, ArrayList arrayList, h2 h2Var) {
        Client client = this.f4141l;
        if (client == null) {
            h2Var.a(arrayList);
        } else if (j10 != 0) {
            client.send(new TdApi.GetMessageThreadHistory(j5, j10, j9, 0, 50), new a0(j10, this, j5, j9, i9, arrayList, h2Var));
        } else {
            client.send(new TdApi.GetChatHistory(j5, j9, 0, 50, false), new a0(this, j5, j9, i9, j10, arrayList, h2Var));
        }
    }

    public final void h(long j5, a8.l lVar) {
        Client client = this.f4141l;
        if (client != null) {
            client.send(new TdApi.GetChat(j5), new d(1, lVar));
        }
    }

    public final String j() {
        String str = this.f4140k;
        if (str != null) {
            return str;
        }
        long currentTimeMillis = System.currentTimeMillis();
        n7.e eVar = this.f4133c;
        String string = ((SharedPreferences) eVar.a()).getString("db_key", null);
        if (string == null) {
            byte[] bArr = new byte[32];
            new SecureRandom().nextBytes(bArr);
            string = Base64.encodeToString(bArr, 2);
            ((SharedPreferences) eVar.a()).edit().putString("db_key", string).apply();
        }
        this.f4140k = string;
        Log.i("TdClient", "🔑 getDatabaseEncryptionKey ready (" + (System.currentTimeMillis() - currentTimeMillis) + "ms)");
        string.getClass();
        return string;
    }

    public final void k(final int i9, final long j5, final long j9, final int i10, final int i11, final int i12, final m7.g gVar) {
        TdApi.GetVideoChatStreamSegment getVideoChatStreamSegment = new TdApi.GetVideoChatStreamSegment(i9, j5, i12, i10, i11 != 1 ? i11 != 2 ? i11 != 3 ? new TdApi.GroupCallVideoQualityThumbnail() : new TdApi.GroupCallVideoQualityFull() : new TdApi.GroupCallVideoQualityFull() : new TdApi.GroupCallVideoQualityMedium());
        Log.v("TdClient", "📤 GetVideoChatStreamSegment: gcid=" + i9 + ", ts=" + j5 + ", ch=" + i10 + ", scale=" + i12 + ", qual=" + i11);
        final long currentTimeMillis = System.currentTimeMillis();
        Client client = this.f4141l;
        if (client != null) {
            client.send(getVideoChatStreamSegment, new Client.ResultHandler() { // from class: h7.h0
                /* JADX WARN: Code restructure failed: missing block: B:27:0x014a, code lost:
                
                    if (h8.e.g0(r4, "QUALITY_INVALID", false) != false) goto L27;
                 */
                @Override // org.drinkless.tdlib.Client.ResultHandler
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void onResult(org.drinkless.tdlib.TdApi.Object r23) {
                    /*
                        Method dump skipped, instructions count: 477
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: h7.h0.onResult(org.drinkless.tdlib.TdApi$Object):void");
                }
            });
        }
    }

    public final void l(int i9, a8.l lVar) {
        Log.d("TdClient", "📤 Requesting GetVideoChatStreams(" + i9 + ")...");
        Client client = this.f4141l;
        if (client != null) {
            client.send(new TdApi.GetVideoChatStreams(i9), new d(3, lVar));
        }
    }

    public final void m(TdApi.Object object, long j5, long j9, int i9, long j10, ArrayList arrayList, h2 h2Var) {
        if (object.getConstructor() != -16498159) {
            h2Var.a(arrayList);
            return;
        }
        TdApi.Messages messages = (TdApi.Messages) object;
        b8.a b9 = b8.r.b(messages.messages);
        long j11 = j9;
        while (b9.hasNext()) {
            TdApi.Message message = (TdApi.Message) b9.next();
            j11 = message.id;
            TdClient$ExplorerItem t8 = t(message);
            if (t8 != null) {
                arrayList.add(t8);
            }
        }
        int length = i9 + messages.messages.length;
        if (arrayList.size() < 30) {
            TdApi.Message[] messageArr = messages.messages;
            messageArr.getClass();
            if (messageArr.length != 0 && length < 1000) {
                g(j5, j11, length, j10, arrayList, h2Var);
                return;
            }
        }
        h2Var.a(arrayList);
    }

    public final void o() {
        String str;
        boolean z8;
        UnsatisfiedLinkError e9;
        long currentTimeMillis = System.currentTimeMillis();
        r("Initializing TdClient (v2.1)...");
        int i9 = 0;
        if (!F) {
            Iterator it = o7.i.D0("tmessages.49", "tdjni", "td").iterator();
            boolean z9 = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                str = (String) it.next();
                try {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    r("Attempting to load native library: " + str + "...");
                    System.loadLibrary(str);
                    long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                    F = true;
                    try {
                        r("✅ Native library " + str + " loaded successfully (" + currentTimeMillis3 + "ms)");
                        z9 = true;
                        break;
                    } catch (UnsatisfiedLinkError e10) {
                        e9 = e10;
                        z8 = true;
                    }
                } catch (UnsatisfiedLinkError e11) {
                    z8 = z9;
                    e9 = e11;
                }
                r("⚠️ Failed to load " + str + ": " + e9.getMessage());
                z9 = z8;
            }
            if (!z9) {
                this.f4136f.e("CRITICAL: Native libraries (tdjni/td) not found context. Check APK ABIs.");
                r("❌ ALL NATIVE LIBRARIES FAILED TO LOAD.");
                return;
            }
        }
        long currentTimeMillis4 = System.currentTimeMillis();
        this.f4141l = Client.create(this.E, null, null);
        long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis4;
        long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
        StringBuilder c9 = t.a.c("⏱️ TDLib Client created in ", currentTimeMillis5, "ms. Global TdClient.init: ");
        c9.append(currentTimeMillis6);
        c9.append("ms");
        r(c9.toString());
        this.f4134d.e("INITIALIZING");
        this.f4152w.clear();
        this.f4150u.e(o7.p.f8013i);
        Client client = this.f4141l;
        if (client != null) {
            client.send(new TdApi.SetLogVerbosityLevel(1), new androidx.fragment.app.a(this, 28));
        }
        try {
            g7.e eVar = ProxyService.f2331i;
            TvgramApplication tvgramApplication = this.f4131a;
            Intent intent = new Intent(tvgramApplication, (Class<?>) ProxyService.class);
            if (Build.VERSION.SDK_INT >= 26) {
                tvgramApplication.startForegroundService(intent);
            } else {
                tvgramApplication.startService(intent);
            }
            r("ProxyService started immediately");
        } catch (Exception e12) {
            r("⚠️ Error starting ProxyService: " + e12.getMessage());
        }
        new Handler(Looper.getMainLooper()).postDelayed(new h(this, i9), 15000L);
    }

    public final void q(long j5, final int i9, final String str, String str2, final a8.l lVar) {
        Log.i("TdClient", "🎥 JoinLiveStream init: GCID=" + i9 + ", Chat=" + j5);
        this.f4143n = j5;
        this.f4144o = i9;
        this.f4145p = str;
        this.f4146q = str2;
        String str3 = str2;
        int nextInt = new Random().nextInt(2000000000) + 1;
        if (str3 == null) {
            str3 = "{}";
        }
        final TdApi.GroupCallJoinParameters groupCallJoinParameters = new TdApi.GroupCallJoinParameters(nextInt, str3, true, false);
        if (str == null || str.length() == 0) {
            Log.i("TdClient", "ℹ️ No invite link provided. Using JoinVideoChat (ID-based)...");
            u(i9, null, groupCallJoinParameters, lVar);
            return;
        }
        Log.i("TdClient", "🚀 Joining via provided inviteLink: ".concat(str));
        TdApi.JoinGroupCall joinGroupCall = new TdApi.JoinGroupCall(new TdApi.InputGroupCallLink(str), groupCallJoinParameters);
        Client client = this.f4141l;
        if (client != null) {
            client.send(joinGroupCall, new Client.ResultHandler() { // from class: h7.n
                @Override // org.drinkless.tdlib.Client.ResultHandler
                public final void onResult(TdApi.Object object) {
                    int constructor = object.getConstructor();
                    a8.l lVar2 = lVar;
                    if (constructor != -1679978726) {
                        k0.n(object, lVar2);
                        return;
                    }
                    Log.w("TdClient", "⚠️ Direct join failed (" + ((TdApi.Error) object).message + "). Falling back to JoinVideoChat (ID-based)...");
                    k0.this.u(i9, str, groupCallJoinParameters, lVar2);
                }
            });
        }
    }

    public final void s() {
        g7.e eVar = ProxyService.f2331i;
        TvgramApplication tvgramApplication = this.f4131a;
        tvgramApplication.stopService(new Intent(tvgramApplication, (Class<?>) ProxyService.class));
        this.f4132b = "";
        Log.i("TdClient", "🌐 Proxy URL updated: ".concat(""));
        Client client = this.f4141l;
        if (client != null) {
            client.send(new TdApi.LogOut(), new androidx.fragment.app.a(27));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.network.tvgramplayer.telegram.TdClient$ExplorerItem t(org.drinkless.tdlib.TdApi.Message r23) {
        /*
            Method dump skipped, instructions count: 1144
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h7.k0.t(org.drinkless.tdlib.TdApi$Message):com.network.tvgramplayer.telegram.TdClient$ExplorerItem");
    }

    public final void u(int i9, String str, TdApi.GroupCallJoinParameters groupCallJoinParameters, a8.l lVar) {
        Log.i("TdClient", "🚀 Usando JoinVideoChat como fallback final (ID: " + i9 + ")");
        if (str == null || str.length() == 0) {
            str = "";
        } else if (h8.e.g0(str, "video_chat=", false)) {
            str = (String) h8.e.p0(h8.e.q0(str, "video_chat=", str), new String[]{"&"}, 6).get(0);
        } else if (h8.e.g0(str, "/+", false)) {
            str = h8.e.q0(str, "/+", str);
        } else if (h8.e.g0(str, "/", false)) {
            str = h8.e.r0(str, "/", str);
        }
        Log.d("TdClient", "🔍 InviteHash detectado/calculado: '" + str + "'");
        long j5 = this.f4139j;
        TdApi.MessageSenderUser messageSenderUser = j5 != 0 ? new TdApi.MessageSenderUser(j5) : null;
        if (str.length() == 0) {
            str = null;
        }
        TdApi.JoinVideoChat joinVideoChat = new TdApi.JoinVideoChat(i9, messageSenderUser, groupCallJoinParameters, str);
        Client client = this.f4141l;
        if (client != null) {
            client.send(joinVideoChat, new d(this, lVar));
        }
    }

    public final void v(String str, boolean z8, final a8.r rVar) {
        CharSequence charSequence;
        Long a02;
        long longValue;
        Long a03;
        str.getClass();
        Log.d("TdClient", "Resolviendo enlace: ".concat(str));
        char[] cArr = {'/'};
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i9 = length - 1;
                char charAt = str.charAt(length);
                int i10 = 0;
                while (true) {
                    if (i10 >= 1) {
                        i10 = -1;
                        break;
                    } else if (charAt == cArr[i10]) {
                        break;
                    } else {
                        i10++;
                    }
                }
                if (!(i10 >= 0)) {
                    charSequence = str.subSequence(0, length + 1);
                    break;
                } else if (i9 < 0) {
                    break;
                } else {
                    length = i9;
                }
            }
        }
        charSequence = "";
        String obj = charSequence.toString();
        final Long a04 = h8.m.f0(obj, "telegram://", false) ? h8.l.a0(h8.e.q0(obj, "telegram://", obj)) : h8.l.a0(obj);
        if (a04 != null) {
            Log.d("TdClient", "ID de chat directo detectado (" + a04 + "), buscando contenido...");
            y(a04.longValue(), z8, new a8.p() { // from class: h7.p
                @Override // a8.p
                public final Object h(Object obj2, Object obj3) {
                    Long l4 = a04;
                    long longValue2 = l4.longValue();
                    a8.r rVar2 = rVar;
                    k0 k0Var = k0.this;
                    k0Var.h(longValue2, new u(rVar2, (TdApi.File) obj2, (String) obj3, l4, k0Var));
                    return n7.g.f7490c;
                }
            });
            return;
        }
        if (h8.m.f0(obj, "tg:", false) || h8.m.f0(obj, "telegram:", false)) {
            String e02 = (!h8.m.f0(h8.m.d0(obj, "telegram:", "tg:"), "tg:/", false) || h8.m.f0(h8.m.d0(obj, "telegram:", "tg:"), "tg://", false)) ? obj : h8.m.e0(h8.m.e0(obj, "tg:/", "tg://"), "telegram:/", "tg://");
            Uri parse = Uri.parse(e02);
            String queryParameter = parse.getQueryParameter("chat_id");
            long longValue2 = ((queryParameter == null || (a02 = h8.l.a0(queryParameter)) == null) && (a02 = h8.l.a0(h8.e.s0(h8.e.q0(e02, "chat_id=", e02), "&"))) == null) ? 0L : a02.longValue();
            String queryParameter2 = parse.getQueryParameter("msg_id");
            if (queryParameter2 == null || (a03 = h8.l.a0(queryParameter2)) == null) {
                Long a05 = h8.l.a0(h8.e.s0(h8.e.q0(e02, "msg_id=", e02), "&"));
                longValue = a05 != null ? a05.longValue() : 0L;
            } else {
                longValue = a03.longValue();
            }
            if (longValue2 != 0 && longValue != 0) {
                long j5 = (longValue <= 0 || longValue >= 1048576) ? longValue : longValue << 20;
                StringBuilder c9 = t.a.c("Deep Link tg://msg detectado (Chat: ", longValue2, ", Msg: ");
                c9.append(longValue);
                c9.append(" -> ID: ");
                c9.append(j5);
                c9.append("), resolviendo...");
                Log.d("TdClient", c9.toString());
                Client client = this.f4141l;
                if (client != null) {
                    final long j9 = j5;
                    final long j10 = longValue2;
                    client.send(new TdApi.GetMessage(longValue2, j5), new Client.ResultHandler() { // from class: h7.q
                        @Override // org.drinkless.tdlib.Client.ResultHandler
                        public final void onResult(TdApi.Object object) {
                            String str2;
                            int constructor = object.getConstructor();
                            long j11 = j10;
                            long j12 = j9;
                            a8.r rVar2 = rVar;
                            if (constructor != 505441744) {
                                TdApi.Error error = object instanceof TdApi.Error ? (TdApi.Error) object : null;
                                String str3 = error != null ? error.message : null;
                                StringBuilder c10 = t.a.c("❌ Error TDLib GetMessage (", j11, "/");
                                c10.append(j12);
                                c10.append("): ");
                                c10.append(str3);
                                Log.e("TdClient", c10.toString());
                                if (error == null || (str2 = error.message) == null) {
                                    str2 = "MESSAGE_NOT_FOUND";
                                }
                                rVar2.i(null, str2, Long.valueOf(j11), null);
                                return;
                            }
                            TdApi.MessageContent messageContent = ((TdApi.Message) object).content;
                            k0 k0Var = k0.this;
                            k0Var.getClass();
                            TdApi.File f9 = k0.f(messageContent);
                            if (f9 != null) {
                                Log.i("TdClient", "✅ Video encontrado en mensaje tg://msg");
                                k0Var.h(j11, new w(rVar2, f9, j11, k0Var, 1));
                            } else {
                                StringBuilder c11 = t.a.c("❌ Mensaje encontrado pero NO contiene video/audio: ", j11, " / ");
                                c11.append(j12);
                                Log.e("TdClient", c11.toString());
                                rVar2.i(null, "NO_VIDEO_IN_MESSAGE", Long.valueOf(j11), null);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            Log.e("TdClient", "❌ Link tg://msg malformado: ".concat(obj));
        }
        if (!h8.e.g0(obj, "/c/", false) || h8.e.g0(h8.e.r0(obj, "/c/", obj), "/", false)) {
            Client client2 = this.f4141l;
            if (client2 != null) {
                client2.send(new TdApi.GetMessageLinkInfo(obj), new s(this, rVar, z8, obj));
                return;
            }
            return;
        }
        Log.d("TdClient", "URL de canal sin mensaje específico, buscando contenido...");
        try {
            long parseLong = Long.parseLong("-100" + h8.e.r0(obj, "/c/", obj));
            y(parseLong, z8, new r(this, parseLong, rVar, 0));
        } catch (Exception e9) {
            Log.e("TdClient", "Error parseando chatId: " + e9.getMessage());
            rVar.i(null, "INVALID_CHAT_ID", null, null);
        }
    }

    public final void w(String str, int i9, a8.l lVar) {
        long j5 = this.f4139j;
        if (j5 == 0) {
            lVar.a(o7.p.f8013i);
            return;
        }
        TdApi.SearchChatMessages searchChatMessages = new TdApi.SearchChatMessages(j5, null, str, null, 0L, 0, i9, new TdApi.SearchMessagesFilterDocument());
        Client client = this.f4141l;
        if (client != null) {
            client.send(searchChatMessages, new d(0, lVar));
        }
    }

    public final void x(long j5, a8.p pVar) {
        Log.d("TdClient", "No hay Live activo. Buscando en historial...");
        Client client = this.f4141l;
        if (client != null) {
            client.send(new TdApi.GetChatHistory(j5, 0L, 0, 20, false), new a3.i(this, pVar));
        }
    }

    public final void y(final long j5, final boolean z8, final a8.p pVar) {
        Log.d("TdClient", "Buscando Video Chat activo primero... (preferVOD=" + z8 + ")");
        Client client = this.f4141l;
        if (client != null) {
            client.send(new TdApi.GetChat(j5), new Client.ResultHandler() { // from class: h7.v
                @Override // org.drinkless.tdlib.Client.ResultHandler
                public final void onResult(TdApi.Object object) {
                    int constructor = object.getConstructor();
                    final k0 k0Var = k0.this;
                    final long j9 = j5;
                    final a8.p pVar2 = pVar;
                    if (constructor != -77484353) {
                        k0Var.x(j9, pVar2);
                        return;
                    }
                    final TdApi.Chat chat = (TdApi.Chat) object;
                    TdApi.VideoChat videoChat = chat.videoChat;
                    int i9 = videoChat != null ? videoChat.groupCallId : 0;
                    if (i9 == 0 || z8) {
                        k0Var.x(j9, pVar2);
                        return;
                    }
                    Log.i("TdClient", "Chat tiene GroupCall (" + i9 + "). Verificando estado...");
                    Client client2 = k0Var.f4141l;
                    if (client2 != null) {
                        client2.send(new TdApi.GetGroupCall(i9), new Client.ResultHandler() { // from class: h7.b0
                            @Override // org.drinkless.tdlib.Client.ResultHandler
                            public final void onResult(TdApi.Object object2) {
                                String str;
                                int constructor2 = object2.getConstructor();
                                long j10 = j9;
                                a8.p pVar3 = pVar2;
                                k0 k0Var2 = k0Var;
                                if (constructor2 != -1792974427) {
                                    k0Var2.x(j10, pVar3);
                                    return;
                                }
                                TdApi.GroupCall groupCall = (TdApi.GroupCall) object2;
                                if (!groupCall.isActive) {
                                    k0Var2.x(j10, pVar3);
                                    return;
                                }
                                Log.i("TdClient", "🚀 Preparando lanzamiento de LiveStreamActivity...");
                                String str2 = groupCall.inviteLink;
                                if (str2 == null) {
                                    str2 = "";
                                }
                                String str3 = groupCall.title;
                                str3.getClass();
                                if (str3.length() == 0) {
                                    str = TdApi.Chat.this.title;
                                    if (str.length() == 0) {
                                        str = "Directo en Vivo";
                                    }
                                } else {
                                    str = groupCall.title;
                                }
                                pVar3.h(null, "LIVE_STREAM_DATA:::" + j10 + ":::" + groupCall.id + ":::" + str + ":::" + groupCall.participantCount + ":::" + str2);
                            }
                        });
                    }
                }
            });
        }
    }

    public final void z(final long j5, final long j9, final int i9, final long j10, final String str, final TdApi.SearchMessagesFilter searchMessagesFilter, final ArrayList arrayList, final h2 h2Var) {
        TdApi.SearchChatMessages searchChatMessages = new TdApi.SearchChatMessages(j5, j10 != 0 ? new TdApi.MessageTopicForum((int) (j10 >> 20)) : null, str, null, j9, 0, 50, searchMessagesFilter == null ? new TdApi.SearchMessagesFilterEmpty() : searchMessagesFilter);
        Client client = this.f4141l;
        if (client != null) {
            client.send(searchChatMessages, new Client.ResultHandler() { // from class: h7.y
                @Override // org.drinkless.tdlib.Client.ResultHandler
                public final void onResult(TdApi.Object object) {
                    k0 k0Var;
                    boolean z8 = object instanceof TdApi.FoundChatMessages;
                    ArrayList arrayList2 = arrayList;
                    h2 h2Var2 = h2Var;
                    if (!z8) {
                        h2Var2.a(arrayList2);
                        return;
                    }
                    TdApi.FoundChatMessages foundChatMessages = (TdApi.FoundChatMessages) object;
                    b8.a b9 = b8.r.b(foundChatMessages.messages);
                    long j11 = j9;
                    while (true) {
                        boolean hasNext = b9.hasNext();
                        k0Var = this;
                        if (!hasNext) {
                            break;
                        }
                        TdApi.Message message = (TdApi.Message) b9.next();
                        j11 = message.id;
                        TdClient$ExplorerItem t8 = k0Var.t(message);
                        if (t8 != null) {
                            arrayList2.add(t8);
                        }
                    }
                    int length = i9 + foundChatMessages.messages.length;
                    if (arrayList2.size() < 30) {
                        TdApi.Message[] messageArr = foundChatMessages.messages;
                        messageArr.getClass();
                        if (messageArr.length != 0 && length < 2000) {
                            k0Var.z(j5, j11, length, j10, str, searchMessagesFilter, arrayList2, h2Var2);
                            return;
                        }
                    }
                    h2Var2.a(arrayList2);
                }
            });
        }
    }
}
