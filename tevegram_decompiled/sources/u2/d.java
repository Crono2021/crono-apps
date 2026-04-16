package u2;

import android.util.SparseArray;
import androidx.activity.g;
import d1.m0;
import d2.d0;
import d2.e0;
import d2.j;
import d2.m;
import d2.n;
import d2.o;
import d4.i;
import g1.p;
import g1.w;
import i7.x;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements m {

    /* renamed from: e0, reason: collision with root package name */
    public static final byte[] f9026e0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* renamed from: f0, reason: collision with root package name */
    public static final byte[] f9027f0;

    /* renamed from: g0, reason: collision with root package name */
    public static final byte[] f9028g0;

    /* renamed from: h0, reason: collision with root package name */
    public static final byte[] f9029h0;
    public static final UUID i0;

    /* renamed from: j0, reason: collision with root package name */
    public static final Map f9030j0;
    public boolean A;
    public long B;
    public long C;
    public long D;
    public i E;
    public i F;
    public boolean G;
    public boolean H;
    public int I;
    public long J;
    public long K;
    public int L;
    public int M;
    public int[] N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public boolean S;
    public long T;
    public int U;
    public int V;
    public int W;
    public boolean X;
    public boolean Y;
    public boolean Z;

    /* renamed from: a, reason: collision with root package name */
    public final b f9031a;

    /* renamed from: a0, reason: collision with root package name */
    public int f9032a0;

    /* renamed from: b, reason: collision with root package name */
    public final e f9033b;

    /* renamed from: b0, reason: collision with root package name */
    public byte f9034b0;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f9035c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f9036c0;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f9037d;

    /* renamed from: d0, reason: collision with root package name */
    public o f9038d0;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f9039e;

    /* renamed from: f, reason: collision with root package name */
    public final z2.c f9040f;

    /* renamed from: g, reason: collision with root package name */
    public final p f9041g;
    public final p h;

    /* renamed from: i, reason: collision with root package name */
    public final p f9042i;

    /* renamed from: j, reason: collision with root package name */
    public final p f9043j;

    /* renamed from: k, reason: collision with root package name */
    public final p f9044k;

    /* renamed from: l, reason: collision with root package name */
    public final p f9045l;

    /* renamed from: m, reason: collision with root package name */
    public final p f9046m;

    /* renamed from: n, reason: collision with root package name */
    public final p f9047n;

    /* renamed from: o, reason: collision with root package name */
    public final p f9048o;

    /* renamed from: p, reason: collision with root package name */
    public final p f9049p;

    /* renamed from: q, reason: collision with root package name */
    public ByteBuffer f9050q;

    /* renamed from: r, reason: collision with root package name */
    public long f9051r;

    /* renamed from: s, reason: collision with root package name */
    public long f9052s;

    /* renamed from: t, reason: collision with root package name */
    public long f9053t;

    /* renamed from: u, reason: collision with root package name */
    public long f9054u;

    /* renamed from: v, reason: collision with root package name */
    public long f9055v;

    /* renamed from: w, reason: collision with root package name */
    public c f9056w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f9057x;

    /* renamed from: y, reason: collision with root package name */
    public int f9058y;

    /* renamed from: z, reason: collision with root package name */
    public long f9059z;

    static {
        int i9 = w.f3713a;
        f9027f0 = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(a6.b.f203c);
        f9028g0 = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        f9029h0 = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        i0 = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap hashMap = new HashMap();
        g.u(0, hashMap, "htc_video_rotA-000", 90, "htc_video_rotA-090");
        g.u(180, hashMap, "htc_video_rotA-180", 270, "htc_video_rotA-270");
        f9030j0 = Collections.unmodifiableMap(hashMap);
    }

    public d(int i9, z2.c cVar) {
        b bVar = new b();
        this.f9052s = -1L;
        this.f9053t = -9223372036854775807L;
        this.f9054u = -9223372036854775807L;
        this.f9055v = -9223372036854775807L;
        this.B = -1L;
        this.C = -1L;
        this.D = -9223372036854775807L;
        this.f9031a = bVar;
        bVar.f8997d = new x(this, 24);
        this.f9040f = cVar;
        this.f9037d = (i9 & 1) == 0;
        this.f9039e = (i9 & 2) == 0;
        this.f9033b = new e();
        this.f9035c = new SparseArray();
        this.f9042i = new p(4);
        this.f9043j = new p(ByteBuffer.allocate(4).putInt(-1).array());
        this.f9044k = new p(4);
        this.f9041g = new p(h1.g.f3891a);
        this.h = new p(4);
        this.f9045l = new p();
        this.f9046m = new p();
        this.f9047n = new p(8);
        this.f9048o = new p();
        this.f9049p = new p();
        this.N = new int[1];
    }

    public static byte[] i(long j5, long j9, String str) {
        g1.a.f(j5 != -9223372036854775807L);
        int i9 = (int) (j5 / 3600000000L);
        long j10 = j5 - (i9 * 3600000000L);
        int i10 = (int) (j10 / 60000000);
        long j11 = j10 - (i10 * 60000000);
        int i11 = (int) (j11 / 1000000);
        String format = String.format(Locale.US, str, Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf((int) ((j11 - (i11 * 1000000)) / j9)));
        int i12 = w.f3713a;
        return format.getBytes(a6.b.f203c);
    }

    public final void b(int i9) {
        if (this.E == null || this.F == null) {
            throw m0.a(null, "Element " + i9 + " must be in a Cues");
        }
    }

    @Override // d2.m
    public final void c(long j5, long j9) {
        this.D = -9223372036854775807L;
        this.I = 0;
        b bVar = this.f9031a;
        bVar.f8998e = 0;
        bVar.f8995b.clear();
        e eVar = bVar.f8996c;
        eVar.f9062b = 0;
        eVar.f9063c = 0;
        e eVar2 = this.f9033b;
        eVar2.f9062b = 0;
        eVar2.f9063c = 0;
        k();
        int i9 = 0;
        while (true) {
            SparseArray sparseArray = this.f9035c;
            if (i9 >= sparseArray.size()) {
                return;
            }
            e0 e0Var = ((c) sparseArray.valueAt(i9)).U;
            if (e0Var != null) {
                e0Var.f2683b = false;
                e0Var.f2684c = 0;
            }
            i9++;
        }
    }

    @Override // d2.m
    public final void d(o oVar) {
        this.f9038d0 = oVar;
        if (this.f9039e) {
            oVar = new x.c(oVar, this.f9040f);
        }
        this.f9038d0 = oVar;
    }

    public final void e(int i9) {
        if (this.f9056w != null) {
            return;
        }
        throw m0.a(null, "Element " + i9 + " must be in a TrackEntry");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(u2.c r18, long r19, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.d.f(u2.c, long, int, int, int):void");
    }

    @Override // d2.m
    public final boolean g(n nVar) {
        i iVar = new i(7);
        p pVar = (p) iVar.f2852j;
        j jVar = (j) nVar;
        long j5 = jVar.f2702k;
        long j9 = IjkMediaMeta.AV_CH_SIDE_RIGHT;
        if (j5 != -1 && j5 <= IjkMediaMeta.AV_CH_SIDE_RIGHT) {
            j9 = j5;
        }
        int i9 = (int) j9;
        jVar.n(pVar.f3699a, 0, 4, false);
        long v8 = pVar.v();
        iVar.f2851i = 4;
        while (true) {
            if (v8 != 440786851) {
                int i10 = iVar.f2851i + 1;
                iVar.f2851i = i10;
                if (i10 == i9) {
                    break;
                }
                jVar.n(pVar.f3699a, 0, 1, false);
                v8 = ((v8 << 8) & (-256)) | (pVar.f3699a[0] & 255);
            } else {
                long j10 = iVar.j(jVar);
                long j11 = iVar.f2851i;
                if (j10 != Long.MIN_VALUE && (j5 == -1 || j11 + j10 < j5)) {
                    while (true) {
                        long j12 = iVar.f2851i;
                        long j13 = j11 + j10;
                        if (j12 < j13) {
                            if (iVar.j(jVar) != Long.MIN_VALUE) {
                                long j14 = iVar.j(jVar);
                                if (j14 < 0 || j14 > 2147483647L) {
                                    break;
                                }
                                if (j14 != 0) {
                                    int i11 = (int) j14;
                                    jVar.c(i11, false);
                                    iVar.f2851i += i11;
                                }
                            } else {
                                break;
                            }
                        } else if (j12 == j13) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01b7, code lost:
    
        throw d1.m0.a(null, "Mandatory element SeekID or SeekPosition not found");
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x088e, code lost:
    
        if (r1.n() == r2.getLeastSignificantBits()) goto L504;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0baf, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0f33, code lost:
    
        if (r5 == false) goto L836;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0f35, code lost:
    
        r1 = r0.getPosition();
        r3 = r43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0f3d, code lost:
    
        if (r3.A == false) goto L830;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0f52, code lost:
    
        if (r3.f9057x == false) goto L887;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0f54, code lost:
    
        r6 = r3.C;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0f5a, code lost:
    
        if (r6 == (-1)) goto L888;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0f5c, code lost:
    
        r45.f2583a = r6;
        r3.C = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0f60, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0f67, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0f3f, code lost:
    
        r3.C = r1;
        r45.f2583a = r3.B;
        r3.A = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0f4b, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0f61, code lost:
    
        r3 = r43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:819:0x0f7f, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:820:0x0f80, code lost:
    
        if (r5 != false) goto L850;
     */
    /* JADX WARN: Code restructure failed: missing block: B:821:0x0f82, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:822:0x0f83, code lost:
    
        r1 = r3.f9035c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:823:0x0f89, code lost:
    
        if (r0 >= r1.size()) goto L912;
     */
    /* JADX WARN: Code restructure failed: missing block: B:824:0x0f8b, code lost:
    
        r1 = (u2.c) r1.valueAt(r0);
        r1.Y.getClass();
        r2 = r1.U;
     */
    /* JADX WARN: Code restructure failed: missing block: B:825:0x0f98, code lost:
    
        if (r2 == null) goto L914;
     */
    /* JADX WARN: Code restructure failed: missing block: B:826:0x0f9a, code lost:
    
        r2.a(r1.Y, r1.f9009j);
     */
    /* JADX WARN: Code restructure failed: missing block: B:828:0x0fa1, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:831:0x0fa4, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:832:0x0fa7, code lost:
    
        return 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:130:0x08d7  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x08ee  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0901  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0ade  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x090e  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x08f0  */
    /* JADX WARN: Type inference failed for: r3v59 */
    /* JADX WARN: Type inference failed for: r3v60, types: [java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r3v61 */
    @Override // d2.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(d2.n r44, d1.w r45) {
        /*
            Method dump skipped, instructions count: 4826
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.d.h(d2.n, d1.w):int");
    }

    public final void j(n nVar, int i9) {
        p pVar = this.f9042i;
        if (pVar.f3701c >= i9) {
            return;
        }
        byte[] bArr = pVar.f3699a;
        if (bArr.length < i9) {
            pVar.b(Math.max(bArr.length * 2, i9));
        }
        byte[] bArr2 = pVar.f3699a;
        int i10 = pVar.f3701c;
        nVar.readFully(bArr2, i10, i9 - i10);
        pVar.E(i9);
    }

    public final void k() {
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.f9032a0 = 0;
        this.f9034b0 = (byte) 0;
        this.f9036c0 = false;
        this.f9045l.C(0);
    }

    public final long l(long j5) {
        long j9 = this.f9053t;
        if (j9 == -9223372036854775807L) {
            throw m0.a(null, "Can't scale timecode prior to timecodeScale being set.");
        }
        int i9 = w.f3713a;
        return w.S(j5, j9, 1000L, RoundingMode.FLOOR);
    }

    public final int m(n nVar, c cVar, int i9, boolean z8) {
        int a9;
        int a10;
        char c9;
        int i10;
        if ("S_TEXT/UTF8".equals(cVar.f9002b)) {
            n(nVar, f9026e0, i9);
            int i11 = this.V;
            k();
            return i11;
        }
        if ("S_TEXT/ASS".equals(cVar.f9002b)) {
            n(nVar, f9028g0, i9);
            int i12 = this.V;
            k();
            return i12;
        }
        if ("S_TEXT/WEBVTT".equals(cVar.f9002b)) {
            n(nVar, f9029h0, i9);
            int i13 = this.V;
            k();
            return i13;
        }
        d0 d0Var = cVar.Y;
        boolean z9 = this.X;
        p pVar = this.f9045l;
        if (!z9) {
            boolean z10 = cVar.h;
            p pVar2 = this.f9042i;
            if (z10) {
                this.Q &= -1073741825;
                if (!this.Y) {
                    nVar.readFully(pVar2.f3699a, 0, 1);
                    this.U++;
                    byte b9 = pVar2.f3699a[0];
                    if ((b9 & 128) == 128) {
                        throw m0.a(null, "Extension bit is set in signal byte");
                    }
                    this.f9034b0 = b9;
                    this.Y = true;
                }
                byte b10 = this.f9034b0;
                if ((b10 & 1) == 1) {
                    boolean z11 = (b10 & 2) == 2;
                    this.Q |= 1073741824;
                    if (!this.f9036c0) {
                        p pVar3 = this.f9047n;
                        nVar.readFully(pVar3.f3699a, 0, 8);
                        this.U += 8;
                        this.f9036c0 = true;
                        pVar2.f3699a[0] = (byte) ((z11 ? 128 : 0) | 8);
                        pVar2.F(0);
                        d0Var.f(pVar2, 1, 1);
                        this.V++;
                        pVar3.F(0);
                        d0Var.f(pVar3, 8, 1);
                        this.V += 8;
                    }
                    if (z11) {
                        if (!this.Z) {
                            nVar.readFully(pVar2.f3699a, 0, 1);
                            this.U++;
                            pVar2.F(0);
                            this.f9032a0 = pVar2.t();
                            this.Z = true;
                        }
                        int i14 = this.f9032a0 * 4;
                        pVar2.C(i14);
                        nVar.readFully(pVar2.f3699a, 0, i14);
                        this.U += i14;
                        short s8 = (short) ((this.f9032a0 / 2) + 1);
                        int i15 = (s8 * 6) + 2;
                        ByteBuffer byteBuffer = this.f9050q;
                        if (byteBuffer == null || byteBuffer.capacity() < i15) {
                            this.f9050q = ByteBuffer.allocate(i15);
                        }
                        this.f9050q.position(0);
                        this.f9050q.putShort(s8);
                        int i16 = 0;
                        int i17 = 0;
                        while (true) {
                            i10 = this.f9032a0;
                            if (i16 >= i10) {
                                break;
                            }
                            int x6 = pVar2.x();
                            int i18 = i16 % 2;
                            ByteBuffer byteBuffer2 = this.f9050q;
                            if (i18 == 0) {
                                byteBuffer2.putShort((short) (x6 - i17));
                            } else {
                                byteBuffer2.putInt(x6 - i17);
                            }
                            i16++;
                            i17 = x6;
                        }
                        c9 = 2;
                        int i19 = (i9 - this.U) - i17;
                        int i20 = i10 % 2;
                        ByteBuffer byteBuffer3 = this.f9050q;
                        if (i20 == 1) {
                            byteBuffer3.putInt(i19);
                        } else {
                            byteBuffer3.putShort((short) i19);
                            this.f9050q.putInt(0);
                        }
                        byte[] array = this.f9050q.array();
                        p pVar4 = this.f9048o;
                        pVar4.D(array, i15);
                        d0Var.f(pVar4, i15, 1);
                        this.V += i15;
                    }
                }
                c9 = 2;
            } else {
                c9 = 2;
                byte[] bArr = cVar.f9008i;
                if (bArr != null) {
                    pVar.D(bArr, bArr.length);
                }
            }
            if ("A_OPUS".equals(cVar.f9002b) ? z8 : cVar.f9006f > 0) {
                this.Q |= 268435456;
                this.f9049p.C(0);
                int i21 = (pVar.f3701c + i9) - this.U;
                pVar2.C(4);
                byte[] bArr2 = pVar2.f3699a;
                bArr2[0] = (byte) ((i21 >> 24) & 255);
                bArr2[1] = (byte) ((i21 >> 16) & 255);
                bArr2[c9] = (byte) ((i21 >> 8) & 255);
                bArr2[3] = (byte) (i21 & 255);
                d0Var.f(pVar2, 4, 2);
                this.V += 4;
            }
            this.X = true;
        }
        int i22 = i9 + pVar.f3701c;
        if (!"V_MPEG4/ISO/AVC".equals(cVar.f9002b) && !"V_MPEGH/ISO/HEVC".equals(cVar.f9002b)) {
            if (cVar.U != null) {
                g1.a.k(pVar.f3701c == 0);
                cVar.U.c(nVar);
            }
            while (true) {
                int i23 = this.U;
                if (i23 >= i22) {
                    break;
                }
                int i24 = i22 - i23;
                int a11 = pVar.a();
                if (a11 > 0) {
                    a10 = Math.min(i24, a11);
                    d0Var.c(a10, pVar);
                } else {
                    a10 = d0Var.a(nVar, i24, false);
                }
                this.U += a10;
                this.V += a10;
            }
        } else {
            p pVar5 = this.h;
            byte[] bArr3 = pVar5.f3699a;
            bArr3[0] = 0;
            bArr3[1] = 0;
            bArr3[2] = 0;
            int i25 = cVar.Z;
            int i26 = 4 - i25;
            while (this.U < i22) {
                int i27 = this.W;
                if (i27 == 0) {
                    int min = Math.min(i25, pVar.a());
                    nVar.readFully(bArr3, i26 + min, i25 - min);
                    if (min > 0) {
                        pVar.e(i26, min, bArr3);
                    }
                    this.U += i25;
                    pVar5.F(0);
                    this.W = pVar5.x();
                    p pVar6 = this.f9041g;
                    pVar6.F(0);
                    d0Var.c(4, pVar6);
                    this.V += 4;
                } else {
                    int a12 = pVar.a();
                    if (a12 > 0) {
                        a9 = Math.min(i27, a12);
                        d0Var.c(a9, pVar);
                    } else {
                        a9 = d0Var.a(nVar, i27, false);
                    }
                    this.U += a9;
                    this.V += a9;
                    this.W -= a9;
                }
            }
        }
        if ("A_VORBIS".equals(cVar.f9002b)) {
            p pVar7 = this.f9043j;
            pVar7.F(0);
            d0Var.c(4, pVar7);
            this.V += 4;
        }
        int i28 = this.V;
        k();
        return i28;
    }

    public final void n(n nVar, byte[] bArr, int i9) {
        int length = bArr.length + i9;
        p pVar = this.f9046m;
        byte[] bArr2 = pVar.f3699a;
        if (bArr2.length < length) {
            byte[] copyOf = Arrays.copyOf(bArr, length + i9);
            pVar.getClass();
            pVar.D(copyOf, copyOf.length);
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        nVar.readFully(pVar.f3699a, bArr.length, i9);
        pVar.F(0);
        pVar.E(length);
    }

    @Override // d2.m
    public final m a() {
        return this;
    }

    @Override // d2.m
    public final void release() {
    }
}
