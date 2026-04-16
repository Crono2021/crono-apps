package e2;

import a6.b;
import androidx.activity.g;
import d1.l0;
import d1.m0;
import d1.r;
import d2.d0;
import d2.m;
import d2.n;
import d2.o;
import d2.p;
import d2.y;
import g1.w;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements m {

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f3065n = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f3066o;

    /* renamed from: p, reason: collision with root package name */
    public static final byte[] f3067p;

    /* renamed from: q, reason: collision with root package name */
    public static final byte[] f3068q;

    /* renamed from: r, reason: collision with root package name */
    public static final int f3069r;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3071b;

    /* renamed from: c, reason: collision with root package name */
    public long f3072c;

    /* renamed from: d, reason: collision with root package name */
    public int f3073d;

    /* renamed from: e, reason: collision with root package name */
    public int f3074e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3075f;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public long f3077i;

    /* renamed from: j, reason: collision with root package name */
    public o f3078j;

    /* renamed from: k, reason: collision with root package name */
    public d0 f3079k;

    /* renamed from: l, reason: collision with root package name */
    public y f3080l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3081m;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f3070a = new byte[1];

    /* renamed from: g, reason: collision with root package name */
    public int f3076g = -1;

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f3066o = iArr;
        int i9 = w.f3713a;
        Charset charset = b.f203c;
        f3067p = "#!AMR\n".getBytes(charset);
        f3068q = "#!AMR-WB\n".getBytes(charset);
        f3069r = iArr[8];
    }

    public final int b(n nVar) {
        boolean z8;
        nVar.h();
        byte[] bArr = this.f3070a;
        nVar.a(0, 1, bArr);
        byte b9 = bArr[0];
        if ((b9 & 131) > 0) {
            throw m0.a(null, "Invalid padding bits for frame header " + ((int) b9));
        }
        int i9 = (b9 >> 3) & 15;
        if (i9 >= 0 && i9 <= 15 && (((z8 = this.f3071b) && (i9 < 10 || i9 > 13)) || (!z8 && (i9 < 12 || i9 > 14)))) {
            return z8 ? f3066o[i9] : f3065n[i9];
        }
        StringBuilder sb = new StringBuilder("Illegal AMR ");
        sb.append(this.f3071b ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(i9);
        throw m0.a(null, sb.toString());
    }

    @Override // d2.m
    public final void c(long j5, long j9) {
        this.f3072c = 0L;
        this.f3073d = 0;
        this.f3074e = 0;
        if (j5 != 0) {
            y yVar = this.f3080l;
            if (yVar instanceof v2.a) {
                this.f3077i = (Math.max(0L, j5 - ((v2.a) yVar).f9465b) * 8000000) / r0.f9468e;
                return;
            }
        }
        this.f3077i = 0L;
    }

    @Override // d2.m
    public final void d(o oVar) {
        this.f3078j = oVar;
        this.f3079k = oVar.l(0, 1);
        oVar.c();
    }

    public final boolean e(n nVar) {
        nVar.h();
        byte[] bArr = f3067p;
        byte[] bArr2 = new byte[bArr.length];
        nVar.a(0, bArr.length, bArr2);
        if (Arrays.equals(bArr2, bArr)) {
            this.f3071b = false;
            nVar.i(bArr.length);
            return true;
        }
        nVar.h();
        byte[] bArr3 = f3068q;
        byte[] bArr4 = new byte[bArr3.length];
        nVar.a(0, bArr3.length, bArr4);
        if (!Arrays.equals(bArr4, bArr3)) {
            return false;
        }
        this.f3071b = true;
        nVar.i(bArr3.length);
        return true;
    }

    @Override // d2.m
    public final boolean g(n nVar) {
        return e(nVar);
    }

    @Override // d2.m
    public final int h(n nVar, d1.w wVar) {
        g1.a.l(this.f3079k);
        int i9 = w.f3713a;
        if (nVar.getPosition() == 0 && !e(nVar)) {
            throw m0.a(null, "Could not find AMR header.");
        }
        if (!this.f3081m) {
            this.f3081m = true;
            boolean z8 = this.f3071b;
            String str = z8 ? "audio/amr-wb" : "audio/3gpp";
            int i10 = z8 ? 16000 : 8000;
            d0 d0Var = this.f3079k;
            r rVar = new r();
            rVar.f2528l = l0.k(str);
            rVar.f2529m = f3069r;
            rVar.f2541y = 1;
            rVar.f2542z = i10;
            g.v(rVar, d0Var);
        }
        int i11 = -1;
        if (this.f3074e == 0) {
            try {
                int b9 = b(nVar);
                this.f3073d = b9;
                this.f3074e = b9;
                if (this.f3076g == -1) {
                    nVar.getPosition();
                    this.f3076g = this.f3073d;
                }
                if (this.f3076g == this.f3073d) {
                    this.h++;
                }
            } catch (EOFException unused) {
            }
        }
        int a9 = this.f3079k.a(nVar, this.f3074e, true);
        if (a9 != -1) {
            int i12 = this.f3074e - a9;
            this.f3074e = i12;
            if (i12 <= 0) {
                this.f3079k.d(this.f3077i + this.f3072c, 1, this.f3073d, 0, null);
                this.f3072c += 20000;
            }
            i11 = 0;
        }
        nVar.e();
        if (!this.f3075f) {
            p pVar = new p(-9223372036854775807L);
            this.f3080l = pVar;
            this.f3078j.t(pVar);
            this.f3075f = true;
        }
        return i11;
    }

    @Override // d2.m
    public final m a() {
        return this;
    }

    @Override // d2.m
    public final void release() {
    }
}
