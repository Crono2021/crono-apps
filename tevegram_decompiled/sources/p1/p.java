package p1;

import d1.l0;
import d2.c0;
import d2.d0;
import g1.w;
import java.io.EOFException;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p implements d0 {

    /* renamed from: f, reason: collision with root package name */
    public static final d1.s f8186f;

    /* renamed from: g, reason: collision with root package name */
    public static final d1.s f8187g;

    /* renamed from: a, reason: collision with root package name */
    public final d0 f8188a;

    /* renamed from: b, reason: collision with root package name */
    public final d1.s f8189b;

    /* renamed from: c, reason: collision with root package name */
    public d1.s f8190c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f8191d;

    /* renamed from: e, reason: collision with root package name */
    public int f8192e;

    static {
        d1.r rVar = new d1.r();
        rVar.f2528l = l0.k("application/id3");
        f8186f = new d1.s(rVar);
        d1.r rVar2 = new d1.r();
        rVar2.f2528l = l0.k("application/x-emsg");
        f8187g = new d1.s(rVar2);
    }

    public p(d0 d0Var, int i9) {
        this.f8188a = d0Var;
        if (i9 == 1) {
            this.f8189b = f8186f;
        } else {
            if (i9 != 3) {
                m7.c.n(androidx.activity.g.m(i9, "Unknown metadataType: "));
                throw null;
            }
            this.f8189b = f8187g;
        }
        this.f8191d = new byte[0];
        this.f8192e = 0;
    }

    @Override // d2.d0
    public final int a(d1.k kVar, int i9, boolean z8) {
        return b(kVar, i9, z8);
    }

    @Override // d2.d0
    public final int b(d1.k kVar, int i9, boolean z8) {
        int i10 = this.f8192e + i9;
        byte[] bArr = this.f8191d;
        if (bArr.length < i10) {
            this.f8191d = Arrays.copyOf(bArr, (i10 / 2) + i10);
        }
        int read = kVar.read(this.f8191d, this.f8192e, i9);
        if (read != -1) {
            this.f8192e += read;
            return read;
        }
        if (z8) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // d2.d0
    public final void c(int i9, g1.p pVar) {
        f(pVar, i9, 0);
    }

    @Override // d2.d0
    public final void d(long j5, int i9, int i10, int i11, c0 c0Var) {
        this.f8190c.getClass();
        int i12 = this.f8192e - i11;
        g1.p pVar = new g1.p(Arrays.copyOfRange(this.f8191d, i12 - i10, i12));
        byte[] bArr = this.f8191d;
        System.arraycopy(bArr, i12, bArr, 0, i11);
        this.f8192e = i11;
        String str = this.f8190c.f2554m;
        d1.s sVar = this.f8189b;
        String str2 = sVar.f2554m;
        String str3 = sVar.f2554m;
        if (!w.a(str, str2)) {
            if (!"application/x-emsg".equals(this.f8190c.f2554m)) {
                g1.a.D("HlsSampleStreamWrapper", "Ignoring sample for unsupported format: " + this.f8190c.f2554m);
                return;
            }
            n2.a D0 = m2.b.D0(pVar);
            d1.s b9 = D0.b();
            if (b9 == null || !w.a(str3, b9.f2554m)) {
                g1.a.D("HlsSampleStreamWrapper", "Ignoring EMSG. Expected it to contain wrapped " + str3 + " but actual wrapped format: " + D0.b());
                return;
            }
            byte[] c9 = D0.c();
            c9.getClass();
            pVar = new g1.p(c9);
        }
        int a9 = pVar.a();
        d0 d0Var = this.f8188a;
        d0Var.c(a9, pVar);
        d0Var.d(j5, i9, a9, i11, c0Var);
    }

    @Override // d2.d0
    public final void e(d1.s sVar) {
        this.f8190c = sVar;
        this.f8188a.e(this.f8189b);
    }

    @Override // d2.d0
    public final void f(g1.p pVar, int i9, int i10) {
        int i11 = this.f8192e + i9;
        byte[] bArr = this.f8191d;
        if (bArr.length < i11) {
            this.f8191d = Arrays.copyOf(bArr, (i11 / 2) + i11);
        }
        pVar.e(this.f8192e, i9, this.f8191d);
        this.f8192e += i9;
    }
}
