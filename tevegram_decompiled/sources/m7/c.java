package m7;

import a0.l;
import b6.g0;
import b6.p0;
import b6.w0;
import com.google.crypto.tink.shaded.protobuf.e0;
import com.google.crypto.tink.shaded.protobuf.q;
import com.network.tvgramplayer.voip.Instance;
import d1.z0;
import g1.w;
import i7.x;
import java.io.FileNotFoundException;
import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;
import m6.p;
import org.webrtc.PeerConnectionFactory;
import p1.r;
import r6.q0;
import r6.q1;
import s1.n;
import s1.t;
import s1.y;
import v1.s0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class c implements Instance.OnStateUpdatedListener, m6.b, a6.c, t, y, g1.c {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6694i;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap b(byte[] r8, int r9) {
        /*
            r0 = 0
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r8, r0, r9)
            if (r1 == 0) goto L61
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch: java.io.IOException -> L59
            r2.<init>(r8, r0, r9)     // Catch: java.io.IOException -> L59
            y0.g r8 = new y0.g     // Catch: java.lang.Throwable -> L4d
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L4d
            r2.close()     // Catch: java.io.IOException -> L59
            java.lang.String r9 = "Orientation"
            y0.c r9 = r8.c(r9)
            if (r9 != 0) goto L1d
            goto L24
        L1d:
            java.nio.ByteOrder r8 = r8.f10385f     // Catch: java.lang.NumberFormatException -> L24
            int r8 = r9.e(r8)     // Catch: java.lang.NumberFormatException -> L24
            goto L25
        L24:
            r8 = 1
        L25:
            switch(r8) {
                case 3: goto L2f;
                case 4: goto L2f;
                case 5: goto L2c;
                case 6: goto L29;
                case 7: goto L29;
                case 8: goto L2c;
                default: goto L28;
            }
        L28:
            goto L31
        L29:
            r0 = 90
            goto L31
        L2c:
            r0 = 270(0x10e, float:3.78E-43)
            goto L31
        L2f:
            r0 = 180(0xb4, float:2.52E-43)
        L31:
            if (r0 == 0) goto L4c
            android.graphics.Matrix r6 = new android.graphics.Matrix
            r6.<init>()
            float r8 = (float) r0
            r6.postRotate(r8)
            int r4 = r1.getWidth()
            int r5 = r1.getHeight()
            r7 = 0
            r2 = 0
            r3 = 0
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r1, r2, r3, r4, r5, r6, r7)
            return r8
        L4c:
            return r1
        L4d:
            r0 = move-exception
            r8 = r0
            r2.close()     // Catch: java.lang.Throwable -> L53
            goto L58
        L53:
            r0 = move-exception
            r9 = r0
            r8.addSuppressed(r9)     // Catch: java.io.IOException -> L59
        L58:
            throw r8     // Catch: java.io.IOException -> L59
        L59:
            r0 = move-exception
            r8 = r0
            r1.d r9 = new r1.d
            r9.<init>(r8)
            throw r9
        L61:
            r1.d r0 = new r1.d
            int r8 = r8.length
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Could not decode image data with BitmapFactory. (data.length = "
            r1.<init>(r2)
            r1.append(r8)
            java.lang.String r8 = ", input length = "
            r1.append(r8)
            r1.append(r9)
            java.lang.String r8 = ")"
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m7.c.b(byte[], int):android.graphics.Bitmap");
    }

    public static /* synthetic */ void d() {
        throw new IllegalArgumentException();
    }

    public static /* synthetic */ void e(Object obj) {
        throw new AssertionError(obj);
    }

    public static /* synthetic */ void f(Object obj, Object obj2, Object obj3, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append(obj2);
        sb.append(obj3);
        throw new IllegalStateException(sb.toString(), th);
    }

    public static /* synthetic */ void g(Object obj, String str) {
        throw new FileNotFoundException(str + obj);
    }

    public static /* synthetic */ void h(Object obj, String str, int i9, int i10) {
        throw new IndexOutOfBoundsException(str + i9 + obj + i10);
    }

    public static /* synthetic */ void i(String str) {
        throw new RuntimeException(str);
    }

    public static /* synthetic */ void j(String str, Object obj, Throwable th) {
        throw new SecurityException(str + obj, th);
    }

    public static /* synthetic */ void k(String str, Throwable th) {
        throw new RuntimeException(str, th);
    }

    public static /* synthetic */ void l(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append((Object) " is a reserved key for the encryption keyset.");
        throw new SecurityException(sb.toString());
    }

    public static /* synthetic */ void m(Object obj, String str) {
        throw new RuntimeException(str + obj);
    }

    public static /* synthetic */ void n(String str) {
        throw new IllegalArgumentException(str);
    }

    public static /* synthetic */ void o(String str) {
        throw new NullPointerException(str);
    }

    public static /* synthetic */ void p(String str) {
        throw new IllegalStateException(str);
    }

    @Override // m6.b
    public f6.b a(p pVar) {
        switch (this.f6694i) {
            case 3:
                if (((String) pVar.f6676a).equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
                    try {
                        r6.b D = r6.b.D((com.google.crypto.tink.shaded.protobuf.j) pVar.f6678c, q.a());
                        if (D.B() != 0) {
                            throw new GeneralSecurityException("Only version 0 keys are accepted");
                        }
                        androidx.fragment.app.g gVar = new androidx.fragment.app.g(21, false);
                        gVar.f728j = null;
                        gVar.f729k = null;
                        gVar.f730l = n6.c.f7445f;
                        gVar.j0(D.z().size());
                        int y2 = D.A().y();
                        if (y2 < 10 || 16 < y2) {
                            throw new GeneralSecurityException(androidx.activity.g.m(y2, "Invalid tag size for AesCmacParameters: "));
                        }
                        gVar.f729k = Integer.valueOf(y2);
                        gVar.f730l = n6.e.a((q1) pVar.f6680e);
                        n6.d D2 = gVar.D();
                        androidx.fragment.app.g gVar2 = new androidx.fragment.app.g(20, false);
                        gVar2.f729k = null;
                        gVar2.f730l = null;
                        gVar2.f728j = D2;
                        gVar2.f729k = new x(t6.a.a(D.z().j()), 23);
                        gVar2.f730l = (Integer) pVar.f6681f;
                        return gVar2.C();
                    } catch (e0 | IllegalArgumentException unused) {
                        androidx.fragment.app.a.o("Parsing AesCmacKey failed");
                    }
                } else {
                    n("Wrong type URL in call to AesCmacParameters.parseParameters");
                }
                return null;
            default:
                if (((String) pVar.f6676a).equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
                    try {
                        q0 E = q0.E((com.google.crypto.tink.shaded.protobuf.j) pVar.f6678c, q.a());
                        if (E.C() != 0) {
                            throw new GeneralSecurityException("Only version 0 keys are accepted");
                        }
                        l lVar = new l();
                        lVar.f30i = null;
                        lVar.f31j = null;
                        lVar.f32k = null;
                        lVar.f33l = n6.c.f7453o;
                        lVar.f30i = Integer.valueOf(E.A().size());
                        lVar.f31j = Integer.valueOf(E.B().A());
                        lVar.f32k = n6.k.a(E.B().z());
                        lVar.f33l = n6.k.b((q1) pVar.f6680e);
                        n6.j e9 = lVar.e();
                        androidx.fragment.app.g gVar3 = new androidx.fragment.app.g(22, false);
                        gVar3.f729k = null;
                        gVar3.f730l = null;
                        gVar3.f728j = e9;
                        gVar3.f729k = new x(t6.a.a(E.A().j()), 23);
                        gVar3.f730l = (Integer) pVar.f6681f;
                        return gVar3.E();
                    } catch (e0 | IllegalArgumentException unused2) {
                        androidx.fragment.app.a.o("Parsing HmacKey failed");
                    }
                } else {
                    n("Wrong type URL in call to HmacProtoSerialization.parseKey");
                }
                return null;
        }
    }

    @Override // g1.c
    public void accept(Object obj) {
        ((s0) obj).f9402b.getClass();
    }

    @Override // a6.c
    public Object apply(Object obj) {
        switch (this.f6694i) {
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                r rVar = (r) obj;
                rVar.v();
                w0 w0Var = rVar.Q.f9257b;
                c cVar = new c(27);
                return g0.m(t.a.d(w0Var) ? new p0(w0Var, cVar) : new b6.q0(w0Var, cVar));
            case 25:
                w0 w0Var2 = ((v1.x) obj).j().f9257b;
                c cVar2 = new c(27);
                return g0.m(t.a.d(w0Var2) ? new p0(w0Var2, cVar2) : new b6.q0(w0Var2, cVar2));
            case 27:
                return Integer.valueOf(((z0) obj).f2618c);
            default:
                return (w2.p) obj;
        }
    }

    @Override // s1.y
    public int c(Object obj) {
        n nVar = (n) obj;
        switch (this.f6694i) {
            case 23:
                String str = nVar.f8714a;
                if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
                    return 1;
                }
                return (w.f3713a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
            default:
                return nVar.f8714a.startsWith("OMX.google") ? 1 : 0;
        }
    }

    @Override // com.network.tvgramplayer.voip.Instance.OnStateUpdatedListener
    public void onStateUpdated(int i9, boolean z8) {
        CopyOnWriteArrayList copyOnWriteArrayList = k.M;
        if (i9 == 3) {
            d4.t.s("> ✅ Conexión Establecida");
        }
        if (i9 == 4) {
            d4.t.s("> ❌ Error de Conexión");
        }
    }

    public /* synthetic */ c(int i9) {
        this.f6694i = i9;
    }
}
