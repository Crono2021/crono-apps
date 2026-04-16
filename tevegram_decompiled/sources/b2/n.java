package b2;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import b6.w0;
import d1.h1;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import l1.c1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n extends s1.s {

    /* renamed from: r1, reason: collision with root package name */
    public static final int[] f1218r1 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};

    /* renamed from: s1, reason: collision with root package name */
    public static boolean f1219s1;

    /* renamed from: t1, reason: collision with root package name */
    public static boolean f1220t1;
    public final Context N0;
    public final g O0;
    public final a5.d P0;
    public final int Q0;
    public final boolean R0;
    public final v S0;
    public final u T0;
    public l U0;
    public boolean V0;
    public boolean W0;
    public Surface X0;
    public g1.q Y0;
    public p Z0;

    /* renamed from: a1, reason: collision with root package name */
    public boolean f1221a1;

    /* renamed from: b1, reason: collision with root package name */
    public int f1222b1;

    /* renamed from: c1, reason: collision with root package name */
    public long f1223c1;

    /* renamed from: d1, reason: collision with root package name */
    public int f1224d1;

    /* renamed from: e1, reason: collision with root package name */
    public int f1225e1;

    /* renamed from: f1, reason: collision with root package name */
    public int f1226f1;

    /* renamed from: g1, reason: collision with root package name */
    public long f1227g1;

    /* renamed from: h1, reason: collision with root package name */
    public int f1228h1;

    /* renamed from: i1, reason: collision with root package name */
    public long f1229i1;

    /* renamed from: j1, reason: collision with root package name */
    public h1 f1230j1;

    /* renamed from: k1, reason: collision with root package name */
    public h1 f1231k1;

    /* renamed from: l1, reason: collision with root package name */
    public boolean f1232l1;

    /* renamed from: m1, reason: collision with root package name */
    public boolean f1233m1;

    /* renamed from: n1, reason: collision with root package name */
    public boolean f1234n1;

    /* renamed from: o1, reason: collision with root package name */
    public int f1235o1;

    /* renamed from: p1, reason: collision with root package name */
    public m f1236p1;

    /* renamed from: q1, reason: collision with root package name */
    public t f1237q1;

    public n(Context context, s1.j jVar, s1.t tVar, long j5, boolean z8, Handler handler, j0 j0Var) {
        super(2, jVar, tVar, z8, 30.0f);
        this.Q0 = 50;
        Context applicationContext = context.getApplicationContext();
        this.N0 = applicationContext;
        this.P0 = new a5.d(handler, j0Var);
        b bVar = new b(applicationContext);
        g1.a.k(!bVar.f1137a);
        if (((e) bVar.f1140d) == null) {
            if (((d) bVar.f1139c) == null) {
                bVar.f1139c = new d();
            }
            bVar.f1140d = new e((d) bVar.f1139c);
        }
        g gVar = new g(bVar);
        bVar.f1137a = true;
        if (gVar.f1181d == null) {
            v vVar = new v(applicationContext, this, j5);
            g1.a.k(!gVar.b());
            gVar.f1181d = vVar;
            gVar.f1182e = new d0(gVar, vVar);
        }
        this.O0 = gVar;
        v vVar2 = gVar.f1181d;
        g1.a.l(vVar2);
        this.S0 = vVar2;
        this.T0 = new u();
        this.R0 = "NVIDIA".equals(g1.w.f3715c);
        this.f1222b1 = 1;
        this.f1230j1 = h1.f2473e;
        this.f1235o1 = 0;
        this.f1231k1 = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x0737, code lost:
    
        if (r0.equals("ELUGA_Ray_X") == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x08bb, code lost:
    
        if (r13.equals("JSN-L21") == false) goto L664;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008b A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean u0(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 3210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.n.u0(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x007b, code lost:
    
        if (r3.equals("video/av01") == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int v0(s1.n r10, d1.s r11) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.n.v0(s1.n, d1.s):int");
    }

    public static List w0(Context context, s1.t tVar, d1.s sVar, boolean z8, boolean z9) {
        List e9;
        String str = sVar.f2554m;
        if (str == null) {
            return w0.f1464m;
        }
        if (g1.w.f3713a >= 26 && "video/dolby-vision".equals(str) && !k.a(context)) {
            String b9 = s1.z.b(sVar);
            if (b9 == null) {
                e9 = w0.f1464m;
            } else {
                ((m7.c) tVar).getClass();
                e9 = s1.z.e(b9, z8, z9);
            }
            if (!e9.isEmpty()) {
                return e9;
            }
        }
        return s1.z.g(tVar, sVar, z8, z9);
    }

    public static int x0(s1.n nVar, d1.s sVar) {
        int i9 = sVar.f2555n;
        List list = sVar.f2556o;
        if (i9 == -1) {
            return v0(nVar, sVar);
        }
        int size = list.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            i10 += ((byte[]) list.get(i11)).length;
        }
        return sVar.f2555n + i10;
    }

    public final void A0() {
        int i9;
        s1.k kVar;
        if (!this.f1234n1 || (i9 = g1.w.f3713a) < 23 || (kVar = this.S) == null) {
            return;
        }
        this.f1236p1 = new m(this, kVar);
        if (i9 >= 33) {
            Bundle bundle = new Bundle();
            bundle.putInt("tunnel-peek", 1);
            kVar.setParameters(bundle);
        }
    }

    public final void B0() {
        Surface surface = this.X0;
        p pVar = this.Z0;
        if (surface == pVar) {
            this.X0 = null;
        }
        if (pVar != null) {
            pVar.release();
            this.Z0 = null;
        }
    }

    @Override // s1.s
    public final l1.g C(s1.n nVar, d1.s sVar, d1.s sVar2) {
        l1.g b9 = nVar.b(sVar, sVar2);
        int i9 = b9.f5876e;
        l lVar = this.U0;
        lVar.getClass();
        if (sVar2.f2559r > lVar.f1212a || sVar2.f2560s > lVar.f1213b) {
            i9 |= 256;
        }
        if (x0(nVar, sVar2) > lVar.f1214c) {
            i9 |= 64;
        }
        int i10 = i9;
        return new l1.g(nVar.f8714a, sVar, sVar2, i10 != 0 ? 0 : b9.f5875d, i10);
    }

    public final void C0(s1.k kVar, int i9) {
        Surface surface;
        g1.a.b("releaseOutputBuffer");
        kVar.releaseOutputBuffer(i9, true);
        g1.a.r();
        this.I0.f5859e++;
        this.f1225e1 = 0;
        z0(this.f1230j1);
        v vVar = this.S0;
        boolean z8 = vVar.f1265e != 3;
        vVar.f1265e = 3;
        vVar.f1270k.getClass();
        vVar.f1267g = g1.w.M(SystemClock.elapsedRealtime());
        if (!z8 || (surface = this.X0) == null) {
            return;
        }
        a5.d dVar = this.P0;
        Handler handler = (Handler) dVar.f174j;
        if (handler != null) {
            handler.post(new h0(dVar, surface, SystemClock.elapsedRealtime()));
        }
        this.f1221a1 = true;
    }

    @Override // s1.s
    public final s1.m D(IllegalStateException illegalStateException, s1.n nVar) {
        Surface surface = this.X0;
        j jVar = new j(illegalStateException, nVar);
        System.identityHashCode(surface);
        if (surface != null) {
            surface.isValid();
        }
        return jVar;
    }

    public final void D0(s1.k kVar, int i9, long j5) {
        Surface surface;
        g1.a.b("releaseOutputBuffer");
        kVar.r(i9, j5);
        g1.a.r();
        this.I0.f5859e++;
        this.f1225e1 = 0;
        z0(this.f1230j1);
        v vVar = this.S0;
        boolean z8 = vVar.f1265e != 3;
        vVar.f1265e = 3;
        vVar.f1270k.getClass();
        vVar.f1267g = g1.w.M(SystemClock.elapsedRealtime());
        if (!z8 || (surface = this.X0) == null) {
            return;
        }
        a5.d dVar = this.P0;
        Handler handler = (Handler) dVar.f174j;
        if (handler != null) {
            handler.post(new h0(dVar, surface, SystemClock.elapsedRealtime()));
        }
        this.f1221a1 = true;
    }

    public final boolean E0(s1.n nVar) {
        if (g1.w.f3713a < 23 || this.f1234n1 || u0(nVar.f8714a)) {
            return false;
        }
        return !nVar.f8719f || p.d(this.N0);
    }

    public final void F0(s1.k kVar, int i9) {
        g1.a.b("skipVideoBuffer");
        kVar.releaseOutputBuffer(i9, false);
        g1.a.r();
        this.I0.f5860f++;
    }

    public final void G0(int i9, int i10) {
        l1.f fVar = this.I0;
        fVar.h += i9;
        int i11 = i9 + i10;
        fVar.f5861g += i11;
        this.f1224d1 += i11;
        int i12 = this.f1225e1 + i11;
        this.f1225e1 = i12;
        fVar.f5862i = Math.max(i12, fVar.f5862i);
        int i13 = this.Q0;
        if (i13 <= 0 || this.f1224d1 < i13) {
            return;
        }
        y0();
    }

    public final void H0(long j5) {
        l1.f fVar = this.I0;
        fVar.f5864k += j5;
        fVar.f5865l++;
        this.f1227g1 += j5;
        this.f1228h1++;
    }

    @Override // s1.s
    public final int L(j1.e eVar) {
        return (g1.w.f3713a < 34 || !this.f1234n1 || eVar.f5361o >= this.f5837t) ? 0 : 32;
    }

    @Override // s1.s
    public final boolean M() {
        return this.f1234n1 && g1.w.f3713a < 23;
    }

    @Override // s1.s
    public final float N(float f9, d1.s[] sVarArr) {
        float f10 = -1.0f;
        for (d1.s sVar : sVarArr) {
            float f11 = sVar.f2561t;
            if (f11 != -1.0f) {
                f10 = Math.max(f10, f11);
            }
        }
        if (f10 == -1.0f) {
            return -1.0f;
        }
        return f10 * f9;
    }

    @Override // s1.s
    public final ArrayList O(s1.t tVar, d1.s sVar, boolean z8) {
        List w02 = w0(this.N0, tVar, sVar, z8, this.f1234n1);
        Pattern pattern = s1.z.f8761a;
        ArrayList arrayList = new ArrayList(w02);
        Collections.sort(arrayList, new s1.u(new a3.i(sVar, 22)));
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x015e, code lost:
    
        if (r16 == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0160, code lost:
    
        r9 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0163, code lost:
    
        if (r16 == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0167, code lost:
    
        r3 = new android.graphics.Point(r9, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0166, code lost:
    
        r4 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0162, code lost:
    
        r9 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x017d, code lost:
    
        r12 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ce  */
    @Override // s1.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final s1.i P(s1.n r25, d1.s r26, android.media.MediaCrypto r27, float r28) {
        /*
            Method dump skipped, instructions count: 693
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.n.P(s1.n, d1.s, android.media.MediaCrypto, float):s1.i");
    }

    @Override // s1.s
    public final void Q(j1.e eVar) {
        if (this.W0) {
            ByteBuffer byteBuffer = eVar.f5362p;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b9 = byteBuffer.get();
                short s8 = byteBuffer.getShort();
                short s9 = byteBuffer.getShort();
                byte b10 = byteBuffer.get();
                byte b11 = byteBuffer.get();
                byteBuffer.position(0);
                if (b9 == -75 && s8 == 60 && s9 == 1 && b10 == 4) {
                    if (b11 == 0 || b11 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        s1.k kVar = this.S;
                        kVar.getClass();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        kVar.setParameters(bundle);
                    }
                }
            }
        }
    }

    @Override // s1.s
    public final void V(Exception exc) {
        g1.a.q("MediaCodecVideoRenderer", "Video codec error", exc);
        a5.d dVar = this.P0;
        Handler handler = (Handler) dVar.f174j;
        if (handler != null) {
            handler.post(new f0(dVar, 1, exc));
        }
    }

    @Override // s1.s
    public final void W(long j5, long j9, String str) {
        String str2;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        a5.d dVar = this.P0;
        Handler handler = (Handler) dVar.f174j;
        if (handler != null) {
            str2 = str;
            handler.post(new e0(dVar, str2, j5, j9, 0));
        } else {
            str2 = str;
        }
        this.V0 = u0(str2);
        s1.n nVar = this.Z;
        nVar.getClass();
        boolean z8 = false;
        if (g1.w.f3713a >= 29 && "video/x-vnd.on2.vp9".equals(nVar.f8715b)) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = nVar.f8717d;
            if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
            }
            int length = codecProfileLevelArr.length;
            int i9 = 0;
            while (true) {
                if (i9 >= length) {
                    break;
                }
                if (codecProfileLevelArr[i9].profile == 16384) {
                    z8 = true;
                    break;
                }
                i9++;
            }
        }
        this.W0 = z8;
        A0();
    }

    @Override // s1.s
    public final void X(String str) {
        a5.d dVar = this.P0;
        Handler handler = (Handler) dVar.f174j;
        if (handler != null) {
            handler.post(new f0(dVar, 2, str));
        }
    }

    @Override // s1.s
    public final l1.g Y(a5.d dVar) {
        l1.g Y = super.Y(dVar);
        d1.s sVar = (d1.s) dVar.f175k;
        sVar.getClass();
        a5.d dVar2 = this.P0;
        Handler handler = (Handler) dVar2.f174j;
        if (handler != null) {
            handler.post(new androidx.emoji2.text.m(dVar2, sVar, Y, 1));
        }
        return Y;
    }

    @Override // s1.s
    public final void Z(d1.s sVar, MediaFormat mediaFormat) {
        int integer;
        int i9;
        s1.k kVar = this.S;
        if (kVar != null) {
            kVar.i(this.f1222b1);
        }
        if (this.f1234n1) {
            i9 = sVar.f2559r;
            integer = sVar.f2560s;
        } else {
            mediaFormat.getClass();
            boolean z8 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            int integer2 = z8 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            integer = z8 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
            i9 = integer2;
        }
        float f9 = sVar.f2563v;
        int i10 = sVar.f2562u;
        if (g1.w.f3713a >= 21) {
            if (i10 == 90 || i10 == 270) {
                f9 = 1.0f / f9;
                int i11 = integer;
                integer = i9;
                i9 = i11;
            }
            i10 = 0;
        }
        this.f1230j1 = new h1(f9, i9, integer, i10);
        float f10 = sVar.f2561t;
        c0 c0Var = this.S0.f1262b;
        c0Var.f1152f = f10;
        i iVar = c0Var.f1147a;
        iVar.f1203a.c();
        iVar.f1204b.c();
        iVar.f1205c = false;
        iVar.f1206d = -9223372036854775807L;
        iVar.f1207e = 0;
        c0Var.b();
    }

    @Override // l1.e, l1.b1
    public final boolean a() {
        return this.E0;
    }

    @Override // s1.s, l1.b1
    public final boolean b() {
        p pVar;
        boolean b9 = super.b();
        if (b9 && (((pVar = this.Z0) != null && this.X0 == pVar) || this.S == null || this.f1234n1)) {
            return true;
        }
        v vVar = this.S0;
        if (b9 && vVar.f1265e == 3) {
            vVar.f1268i = -9223372036854775807L;
            return true;
        }
        if (vVar.f1268i != -9223372036854775807L) {
            vVar.f1270k.getClass();
            if (SystemClock.elapsedRealtime() < vVar.f1268i) {
                return true;
            }
            vVar.f1268i = -9223372036854775807L;
        }
        return false;
    }

    @Override // s1.s
    public final void b0(long j5) {
        super.b0(j5);
        if (this.f1234n1) {
            return;
        }
        this.f1226f1--;
    }

    @Override // s1.s
    public final void c0() {
        this.S0.a(2);
        A0();
        g gVar = this.O0;
        if (gVar.b()) {
            gVar.d(this.J0.f8728c);
        }
    }

    @Override // s1.s
    public final void d0(j1.e eVar) {
        Surface surface;
        boolean z8 = this.f1234n1;
        if (!z8) {
            this.f1226f1++;
        }
        if (g1.w.f3713a >= 23 || !z8) {
            return;
        }
        long j5 = eVar.f5361o;
        t0(j5);
        z0(this.f1230j1);
        this.I0.f5859e++;
        v vVar = this.S0;
        boolean z9 = vVar.f1265e != 3;
        vVar.f1265e = 3;
        vVar.f1270k.getClass();
        vVar.f1267g = g1.w.M(SystemClock.elapsedRealtime());
        if (z9 && (surface = this.X0) != null) {
            a5.d dVar = this.P0;
            Handler handler = (Handler) dVar.f174j;
            if (handler != null) {
                handler.post(new h0(dVar, surface, SystemClock.elapsedRealtime()));
            }
            this.f1221a1 = true;
        }
        b0(j5);
    }

    @Override // s1.s
    public final void e0(d1.s sVar) {
        boolean z8 = this.f1232l1;
        g gVar = this.O0;
        if (z8 && !this.f1233m1 && !gVar.b()) {
            try {
                gVar.a(sVar);
                throw null;
            } catch (l0 e9) {
                throw l(e9, sVar, false, 7000);
            }
        } else if (!gVar.b()) {
            this.f1233m1 = true;
        } else {
            g1.a.l(null);
            new u5.e(this, 9);
            throw null;
        }
    }

    @Override // s1.s, l1.b1
    public final void f(long j5, long j9) {
        super.f(j5, j9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10, types: [android.view.Surface] */
    @Override // l1.e, l1.x0
    public final void g(int i9, Object obj) {
        Handler handler;
        long j5;
        Surface surface;
        v vVar = this.S0;
        g gVar = this.O0;
        if (i9 != 1) {
            if (i9 == 7) {
                obj.getClass();
                this.f1237q1 = (t) obj;
                gVar.getClass();
                return;
            }
            if (i9 == 10) {
                obj.getClass();
                int intValue = ((Integer) obj).intValue();
                if (this.f1235o1 != intValue) {
                    this.f1235o1 = intValue;
                    if (this.f1234n1) {
                        i0();
                        return;
                    }
                    return;
                }
                return;
            }
            if (i9 == 4) {
                obj.getClass();
                int intValue2 = ((Integer) obj).intValue();
                this.f1222b1 = intValue2;
                s1.k kVar = this.S;
                if (kVar != null) {
                    kVar.i(intValue2);
                    return;
                }
                return;
            }
            if (i9 == 5) {
                obj.getClass();
                int intValue3 = ((Integer) obj).intValue();
                c0 c0Var = vVar.f1262b;
                if (c0Var.f1155j == intValue3) {
                    return;
                }
                c0Var.f1155j = intValue3;
                c0Var.c(true);
                return;
            }
            if (i9 == 13) {
                obj.getClass();
                gVar.f1184g = (List) obj;
                if (gVar.b()) {
                    g1.a.l(null);
                    throw null;
                }
                this.f1232l1 = true;
                return;
            }
            if (i9 != 14) {
                return;
            }
            obj.getClass();
            this.Y0 = (g1.q) obj;
            if (gVar.b()) {
                g1.q qVar = this.Y0;
                qVar.getClass();
                if (qVar.f3703a != 0) {
                    g1.q qVar2 = this.Y0;
                    qVar2.getClass();
                    if (qVar2.f3704b == 0 || (surface = this.X0) == null) {
                        return;
                    }
                    g1.q qVar3 = this.Y0;
                    qVar3.getClass();
                    gVar.c(surface, qVar3);
                    return;
                }
                return;
            }
            return;
        }
        p pVar = obj instanceof Surface ? (Surface) obj : null;
        if (pVar == null) {
            p pVar2 = this.Z0;
            if (pVar2 != null) {
                pVar = pVar2;
            } else {
                s1.n nVar = this.Z;
                if (nVar != null && E0(nVar)) {
                    pVar = p.e(this.N0, nVar.f8719f);
                    this.Z0 = pVar;
                }
            }
        }
        Surface surface2 = this.X0;
        a5.d dVar = this.P0;
        if (surface2 == pVar) {
            if (pVar == null || pVar == this.Z0) {
                return;
            }
            h1 h1Var = this.f1231k1;
            if (h1Var != null) {
                dVar.Y0(h1Var);
            }
            Surface surface3 = this.X0;
            if (surface3 == null || !this.f1221a1 || (handler = (Handler) dVar.f174j) == null) {
                return;
            }
            handler.post(new h0(dVar, surface3, SystemClock.elapsedRealtime()));
            return;
        }
        this.X0 = pVar;
        c0 c0Var2 = vVar.f1262b;
        c0Var2.getClass();
        int i10 = g1.w.f3713a;
        p pVar3 = (i10 < 17 || !w.a(pVar)) ? pVar : null;
        if (c0Var2.f1151e != pVar3) {
            c0Var2.a();
            c0Var2.f1151e = pVar3;
            c0Var2.c(true);
        }
        vVar.a(1);
        this.f1221a1 = false;
        int i11 = this.f5833p;
        s1.k kVar2 = this.S;
        if (kVar2 != null && !gVar.b()) {
            if (i10 < 23 || pVar == null || this.V0) {
                i0();
                T();
            } else {
                kVar2.o(pVar);
            }
        }
        if (pVar == null || pVar == this.Z0) {
            this.f1231k1 = null;
            if (gVar.b()) {
                int i12 = g1.q.f3702c.f3703a;
                gVar.h = null;
            }
        } else {
            h1 h1Var2 = this.f1231k1;
            if (h1Var2 != null) {
                dVar.Y0(h1Var2);
            }
            if (i11 == 2) {
                long j9 = vVar.f1263c;
                if (j9 > 0) {
                    vVar.f1270k.getClass();
                    j5 = SystemClock.elapsedRealtime() + j9;
                } else {
                    j5 = -9223372036854775807L;
                }
                vVar.f1268i = j5;
            }
            if (gVar.b()) {
                gVar.c(pVar, g1.q.f3702c);
            }
        }
        A0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:174:0x0128, code lost:
    
        if (r5 > 100000) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0136, code lost:
    
        if (r29 >= r24) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x008b, code lost:
    
        if ((r12 == 0 ? false : r3.f1198g[(int) ((r12 - 1) % 15)]) != false) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:140:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0270 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0294  */
    @Override // s1.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g0(long r29, long r31, s1.k r33, java.nio.ByteBuffer r34, int r35, int r36, int r37, long r38, boolean r40, boolean r41, d1.s r42) {
        /*
            Method dump skipped, instructions count: 858
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.n.g0(long, long, s1.k, java.nio.ByteBuffer, int, int, int, long, boolean, boolean, d1.s):boolean");
    }

    @Override // l1.b1
    public final String getName() {
        return "MediaCodecVideoRenderer";
    }

    @Override // l1.e, l1.b1
    public final void h() {
        v vVar = this.S0;
        if (vVar.f1265e == 0) {
            vVar.f1265e = 1;
        }
    }

    @Override // s1.s, l1.e, l1.b1
    public final void k(float f9, float f10) {
        super.k(f9, f10);
        v vVar = this.S0;
        vVar.f1269j = f9;
        c0 c0Var = vVar.f1262b;
        c0Var.f1154i = f9;
        c0Var.f1158m = 0L;
        c0Var.f1161p = -1L;
        c0Var.f1159n = -1L;
        c0Var.c(false);
    }

    @Override // s1.s
    public final void k0() {
        super.k0();
        this.f1226f1 = 0;
    }

    @Override // s1.s, l1.e
    public final void n() {
        a5.d dVar = this.P0;
        this.f1231k1 = null;
        this.S0.a(0);
        A0();
        this.f1221a1 = false;
        this.f1236p1 = null;
        try {
            super.n();
            l1.f fVar = this.I0;
            dVar.getClass();
            synchronized (fVar) {
            }
            Handler handler = (Handler) dVar.f174j;
            if (handler != null) {
                handler.post(new i0(dVar, fVar, 1));
            }
            dVar.Y0(h1.f2473e);
        } catch (Throwable th) {
            dVar.q0(this.I0);
            dVar.Y0(h1.f2473e);
            throw th;
        }
    }

    @Override // l1.e
    public final void o(boolean z8, boolean z9) {
        this.I0 = new l1.f();
        c1 c1Var = this.f5829l;
        c1Var.getClass();
        boolean z10 = c1Var.f5811b;
        g1.a.k((z10 && this.f1235o1 == 0) ? false : true);
        if (this.f1234n1 != z10) {
            this.f1234n1 = z10;
            i0();
        }
        l1.f fVar = this.I0;
        a5.d dVar = this.P0;
        Handler handler = (Handler) dVar.f174j;
        if (handler != null) {
            handler.post(new i0(dVar, fVar, 0));
        }
        this.S0.f1265e = z9 ? 1 : 0;
    }

    @Override // s1.s
    public final boolean o0(s1.n nVar) {
        return this.X0 != null || E0(nVar);
    }

    @Override // l1.e
    public final void p() {
        g1.r rVar = this.f5832o;
        rVar.getClass();
        this.S0.f1270k = rVar;
        g gVar = this.O0;
        g1.a.k(!gVar.b());
        gVar.f1180c = rVar;
    }

    @Override // s1.s, l1.e
    public final void q(long j5, boolean z8) {
        super.q(j5, z8);
        g gVar = this.O0;
        if (gVar.b()) {
            gVar.d(this.J0.f8728c);
        }
        v vVar = this.S0;
        c0 c0Var = vVar.f1262b;
        c0Var.f1158m = 0L;
        c0Var.f1161p = -1L;
        c0Var.f1159n = -1L;
        long j9 = -9223372036854775807L;
        vVar.h = -9223372036854775807L;
        vVar.f1266f = -9223372036854775807L;
        vVar.a(1);
        vVar.f1268i = -9223372036854775807L;
        if (z8) {
            long j10 = vVar.f1263c;
            if (j10 > 0) {
                vVar.f1270k.getClass();
                j9 = SystemClock.elapsedRealtime() + j10;
            }
            vVar.f1268i = j9;
        }
        A0();
        this.f1225e1 = 0;
    }

    @Override // s1.s
    public final int q0(s1.t tVar, d1.s sVar) {
        boolean z8;
        int i9 = 0;
        if (!d1.l0.j(sVar.f2554m)) {
            return androidx.activity.g.f(0, 0, 0, 0);
        }
        boolean z9 = sVar.f2557p != null;
        Context context = this.N0;
        List w02 = w0(context, tVar, sVar, z9, false);
        if (z9 && w02.isEmpty()) {
            w02 = w0(context, tVar, sVar, false, false);
        }
        if (w02.isEmpty()) {
            return androidx.activity.g.f(1, 0, 0, 0);
        }
        int i10 = sVar.I;
        if (i10 != 0 && i10 != 2) {
            return androidx.activity.g.f(2, 0, 0, 0);
        }
        s1.n nVar = (s1.n) w02.get(0);
        boolean d9 = nVar.d(sVar);
        if (!d9) {
            for (int i11 = 1; i11 < w02.size(); i11++) {
                s1.n nVar2 = (s1.n) w02.get(i11);
                if (nVar2.d(sVar)) {
                    nVar = nVar2;
                    z8 = false;
                    d9 = true;
                    break;
                }
            }
        }
        z8 = true;
        int i12 = d9 ? 4 : 3;
        int i13 = nVar.e(sVar) ? 16 : 8;
        int i14 = nVar.f8720g ? 64 : 0;
        int i15 = z8 ? 128 : 0;
        if (g1.w.f3713a >= 26 && "video/dolby-vision".equals(sVar.f2554m) && !k.a(context)) {
            i15 = 256;
        }
        if (d9) {
            List w03 = w0(context, tVar, sVar, z9, true);
            if (!w03.isEmpty()) {
                Pattern pattern = s1.z.f8761a;
                ArrayList arrayList = new ArrayList(w03);
                Collections.sort(arrayList, new s1.u(new a3.i(sVar, 22)));
                s1.n nVar3 = (s1.n) arrayList.get(0);
                if (nVar3.d(sVar) && nVar3.e(sVar)) {
                    i9 = 32;
                }
            }
        }
        return i12 | i13 | i9 | i14 | i15;
    }

    @Override // l1.e
    public final void r() {
        g gVar = this.O0;
        if (!gVar.b() || gVar.f1187k == 2) {
            return;
        }
        g1.t tVar = gVar.f1183f;
        if (tVar != null) {
            tVar.f3708a.removeCallbacksAndMessages(null);
        }
        gVar.h = null;
        gVar.f1187k = 2;
    }

    @Override // l1.e
    public final void s() {
        try {
            try {
                E();
                i0();
            } finally {
                androidx.activity.g.z(this.N, null);
                this.N = null;
            }
        } finally {
            this.f1233m1 = false;
            if (this.Z0 != null) {
                B0();
            }
        }
    }

    @Override // l1.e
    public final void t() {
        this.f1224d1 = 0;
        this.f5832o.getClass();
        this.f1223c1 = SystemClock.elapsedRealtime();
        this.f1227g1 = 0L;
        this.f1228h1 = 0;
        v vVar = this.S0;
        vVar.f1264d = true;
        vVar.f1270k.getClass();
        vVar.f1267g = g1.w.M(SystemClock.elapsedRealtime());
        c0 c0Var = vVar.f1262b;
        c0Var.f1150d = true;
        c0Var.f1158m = 0L;
        c0Var.f1161p = -1L;
        c0Var.f1159n = -1L;
        z zVar = c0Var.f1148b;
        if (zVar != null) {
            b0 b0Var = c0Var.f1149c;
            b0Var.getClass();
            b0Var.f1143j.sendEmptyMessage(1);
            zVar.d(new a3.i(c0Var, 1));
        }
        c0Var.c(false);
    }

    @Override // l1.e
    public final void u() {
        y0();
        int i9 = this.f1228h1;
        if (i9 != 0) {
            long j5 = this.f1227g1;
            a5.d dVar = this.P0;
            Handler handler = (Handler) dVar.f174j;
            if (handler != null) {
                handler.post(new g0(dVar, j5, i9));
            }
            this.f1227g1 = 0L;
            this.f1228h1 = 0;
        }
        v vVar = this.S0;
        vVar.f1264d = false;
        vVar.f1268i = -9223372036854775807L;
        c0 c0Var = vVar.f1262b;
        c0Var.f1150d = false;
        z zVar = c0Var.f1148b;
        if (zVar != null) {
            zVar.a();
            b0 b0Var = c0Var.f1149c;
            b0Var.getClass();
            b0Var.f1143j.sendEmptyMessage(2);
        }
        c0Var.a();
    }

    public final void y0() {
        if (this.f1224d1 > 0) {
            this.f5832o.getClass();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j5 = elapsedRealtime - this.f1223c1;
            int i9 = this.f1224d1;
            a5.d dVar = this.P0;
            Handler handler = (Handler) dVar.f174j;
            if (handler != null) {
                handler.post(new g0(dVar, i9, j5));
            }
            this.f1224d1 = 0;
            this.f1223c1 = elapsedRealtime;
        }
    }

    public final void z0(h1 h1Var) {
        if (h1Var.equals(h1.f2473e) || h1Var.equals(this.f1231k1)) {
            return;
        }
        this.f1231k1 = h1Var;
        this.P0.Y0(h1Var);
    }
}
