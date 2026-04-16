package androidx.fragment.app;

import android.util.Log;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Constructor;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.webrtc.PeerConnectionFactory;
import r6.q1;
import r6.t1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class a implements m6.b, Client.ResultHandler {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f673i;

    public /* synthetic */ a(int i9) {
        this.f673i = i9;
    }

    public static /* synthetic */ void c() {
        throw new ClassCastException();
    }

    public static /* synthetic */ void d(int i9, String str) {
        throw new IllegalArgumentException(str + i9);
    }

    public static /* synthetic */ void e(Object obj, Object obj2) {
        throw new t0("Fragment " + obj + obj2);
    }

    public static /* synthetic */ void f(Object obj, Object obj2, String str) {
        throw new IllegalStateException(str + obj + obj2);
    }

    public static /* synthetic */ void g(Object obj, String str) {
        throw new IllegalArgumentException(str + obj);
    }

    public static /* synthetic */ void h(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static /* synthetic */ void i(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void j(StringBuilder sb, Object obj) {
        sb.append(obj);
        throw new IllegalStateException(sb.toString());
    }

    public static /* synthetic */ void k(StringBuilder sb, Object obj, Throwable th) {
        sb.append(obj);
        throw new JsonSyntaxException(sb.toString(), th);
    }

    public static /* synthetic */ void l() {
        throw new IllegalStateException();
    }

    public static /* synthetic */ void m(Object obj, Object obj2, String str) {
        throw new IllegalArgumentException(str + obj + obj2);
    }

    public static /* synthetic */ void n(Object obj, String str) {
        throw new IllegalArgumentException(str + obj);
    }

    public static /* synthetic */ void o(String str) {
        throw new GeneralSecurityException(str);
    }

    public static /* synthetic */ void p() {
        throw new UnsupportedOperationException();
    }

    public static /* synthetic */ void q(Object obj, Object obj2, String str) {
        throw new GeneralSecurityException(str + obj + obj2);
    }

    public static /* synthetic */ void r(Object obj, String str) {
        throw new IllegalStateException(str + obj);
    }

    public static /* synthetic */ void s(Object obj, String str) {
        throw new JsonIOException(str + ((Object) obj.toString()));
    }

    public static /* synthetic */ void t(Object obj, String str) {
        throw new IllegalStateException(str + obj);
    }

    public static /* synthetic */ void u(Object obj, String str) {
        throw new GeneralSecurityException(str + obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [f6.b] */
    /* JADX WARN: Type inference failed for: r4v5, types: [int] */
    @Override // m6.b
    public f6.b a(m6.p pVar) {
        ?? r42;
        r6.r D;
        g6.j jVar;
        g6.j jVar2;
        int i9 = 12;
        int i10 = 23;
        boolean z8 = false;
        switch (this.f673i) {
            case 21:
                if (!((String) pVar.f6676a).equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
                    m7.c.n("Wrong type URL in call to AesEaxParameters.parseParameters");
                    return null;
                }
                try {
                    D = r6.r.D((com.google.crypto.tink.shaded.protobuf.j) pVar.f6678c, com.google.crypto.tink.shaded.protobuf.q.a());
                    r42 = D.B();
                } catch (com.google.crypto.tink.shaded.protobuf.e0 unused) {
                    r42 = 0;
                }
                try {
                    if (r42 != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    g6.j jVar3 = g6.j.f3760e;
                    int size = D.z().size();
                    if (size != 16 && size != 24 && size != 32) {
                        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(size)));
                    }
                    int y2 = D.A().y();
                    if (y2 != 12 && y2 != 16) {
                        throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", Integer.valueOf(y2)));
                    }
                    q1 q1Var = (q1) pVar.f6680e;
                    int ordinal = q1Var.ordinal();
                    if (ordinal != 1) {
                        if (ordinal != 2) {
                            if (ordinal != 3) {
                                if (ordinal != 4) {
                                    throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + q1Var.b());
                                }
                            }
                        }
                        jVar3 = g6.j.f3759d;
                    } else {
                        jVar3 = g6.j.f3758c;
                    }
                    g6.k kVar = new g6.k(size, y2, 16, jVar3);
                    g gVar = new g(10, z8);
                    gVar.f729k = null;
                    gVar.f730l = null;
                    gVar.f728j = kVar;
                    gVar.f729k = new i7.x(t6.a.a(D.z().j()), 23);
                    gVar.f730l = (Integer) pVar.f6681f;
                    return gVar.z();
                } catch (com.google.crypto.tink.shaded.protobuf.e0 unused2) {
                    o("Parsing AesEaxcKey failed");
                    return r42;
                }
            case 22:
                if (((String) pVar.f6676a).equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
                    try {
                        r6.x B = r6.x.B((com.google.crypto.tink.shaded.protobuf.j) pVar.f6678c, com.google.crypto.tink.shaded.protobuf.q.a());
                        if (B.z() != 0) {
                            throw new GeneralSecurityException("Only version 0 keys are accepted");
                        }
                        g6.j jVar4 = g6.j.h;
                        int size2 = B.y().size();
                        if (size2 != 16 && size2 != 24 && size2 != 32) {
                            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(size2)));
                        }
                        q1 q1Var2 = (q1) pVar.f6680e;
                        int ordinal2 = q1Var2.ordinal();
                        if (ordinal2 != 1) {
                            if (ordinal2 != 2) {
                                if (ordinal2 != 3) {
                                    if (ordinal2 != 4) {
                                        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + q1Var2.b());
                                    }
                                }
                            }
                            jVar4 = g6.j.f3762g;
                        } else {
                            jVar4 = g6.j.f3761f;
                        }
                        g6.n nVar = new g6.n(size2, 12, 16, jVar4);
                        g gVar2 = new g(11, z8);
                        gVar2.f729k = null;
                        gVar2.f730l = null;
                        gVar2.f728j = nVar;
                        gVar2.f729k = new i7.x(t6.a.a(B.y().j()), 23);
                        gVar2.f730l = (Integer) pVar.f6681f;
                        return gVar2.A();
                    } catch (com.google.crypto.tink.shaded.protobuf.e0 unused3) {
                        o("Parsing AesGcmKey failed");
                    }
                } else {
                    m7.c.n("Wrong type URL in call to AesGcmParameters.parseParameters");
                }
                return null;
            case 23:
                if (!((String) pVar.f6676a).equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
                    m7.c.n("Wrong type URL in call to AesGcmSivParameters.parseParameters");
                    return null;
                }
                try {
                    r6.b0 B2 = r6.b0.B((com.google.crypto.tink.shaded.protobuf.j) pVar.f6678c, com.google.crypto.tink.shaded.protobuf.q.a());
                    if (B2.z() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    g6.j jVar5 = g6.j.f3765k;
                    int size3 = B2.y().size();
                    if (size3 != 16 && size3 != 32) {
                        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(size3)));
                    }
                    q1 q1Var3 = (q1) pVar.f6680e;
                    int ordinal3 = q1Var3.ordinal();
                    if (ordinal3 != 1) {
                        if (ordinal3 != 2) {
                            if (ordinal3 != 3) {
                                if (ordinal3 != 4) {
                                    throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + q1Var3.b());
                                }
                            }
                        }
                        jVar5 = g6.j.f3764j;
                    } else {
                        jVar5 = g6.j.f3763i;
                    }
                    g6.q qVar = new g6.q(size3, jVar5);
                    g gVar3 = new g(i9, z8);
                    gVar3.f729k = null;
                    gVar3.f730l = null;
                    gVar3.f728j = qVar;
                    gVar3.f729k = new i7.x(t6.a.a(B2.y().j()), i10);
                    gVar3.f730l = (Integer) pVar.f6681f;
                    return gVar3.B();
                } catch (com.google.crypto.tink.shaded.protobuf.e0 unused4) {
                    o("Parsing AesGcmSivKey failed");
                    return null;
                }
            case 24:
                if (!((String) pVar.f6676a).equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
                    m7.c.n("Wrong type URL in call to ChaCha20Poly1305Parameters.parseParameters");
                    return null;
                }
                try {
                    r6.j0 B3 = r6.j0.B((com.google.crypto.tink.shaded.protobuf.j) pVar.f6678c, com.google.crypto.tink.shaded.protobuf.q.a());
                    if (B3.z() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    q1 q1Var4 = (q1) pVar.f6680e;
                    int ordinal4 = q1Var4.ordinal();
                    if (ordinal4 != 1) {
                        if (ordinal4 != 2) {
                            if (ordinal4 == 3) {
                                jVar = g6.j.f3768n;
                            } else if (ordinal4 != 4) {
                                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + q1Var4.b());
                            }
                        }
                        jVar = g6.j.f3767m;
                    } else {
                        jVar = g6.j.f3766l;
                    }
                    return g6.s.b(jVar, new i7.x(t6.a.a(B3.y().j()), i10), (Integer) pVar.f6681f);
                } catch (com.google.crypto.tink.shaded.protobuf.e0 unused5) {
                    o("Parsing ChaCha20Poly1305Key failed");
                    return null;
                }
            default:
                if (!((String) pVar.f6676a).equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
                    m7.c.n("Wrong type URL in call to XChaCha20Poly1305Parameters.parseParameters");
                    return null;
                }
                try {
                    t1 B4 = t1.B((com.google.crypto.tink.shaded.protobuf.j) pVar.f6678c, com.google.crypto.tink.shaded.protobuf.q.a());
                    if (B4.z() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    q1 q1Var5 = (q1) pVar.f6680e;
                    int ordinal5 = q1Var5.ordinal();
                    if (ordinal5 != 1) {
                        if (ordinal5 != 2) {
                            if (ordinal5 == 3) {
                                jVar2 = g6.j.f3771q;
                            } else if (ordinal5 != 4) {
                                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + q1Var5.b());
                            }
                        }
                        jVar2 = g6.j.f3770p;
                    } else {
                        jVar2 = g6.j.f3769o;
                    }
                    return g6.w.b(jVar2, new i7.x(t6.a.a(B4.y().j()), i10), (Integer) pVar.f6681f);
                } catch (com.google.crypto.tink.shaded.protobuf.e0 unused6) {
                    o("Parsing XChaCha20Poly1305Key failed");
                    return null;
                }
        }
    }

    public Constructor b() {
        switch (this.f673i) {
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
                    return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(d2.m.class).getConstructor(Integer.TYPE);
                }
                return null;
            default:
                return Class.forName("androidx.media3.decoder.midi.MidiExtractor").asSubclass(d2.m.class).getConstructor(null);
        }
    }

    @Override // org.drinkless.tdlib.Client.ResultHandler
    public void onResult(TdApi.Object object) {
        switch (this.f673i) {
            case 26:
                h7.k0.r("✅ Exit Cleanup Complete");
                break;
            case 27:
                break;
            case 28:
                h7.k0.r("Log verbosity set to 1");
                break;
            default:
                if (!(object instanceof TdApi.Error)) {
                    Log.i("TdClient", "✅ Loaded 100 more chats.");
                    break;
                } else {
                    Log.e("TdClient", "❌ Error loading more chats: " + ((TdApi.Error) object).message);
                    break;
                }
        }
    }

    public /* synthetic */ a(h7.k0 k0Var, int i9) {
        this.f673i = i9;
    }

    private final void v(TdApi.Object object) {
    }
}
