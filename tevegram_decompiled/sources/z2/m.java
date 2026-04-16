package z2;

import d1.s;
import d2.c0;
import d2.d0;
import g1.p;
import g1.w;
import java.io.EOFException;
import m1.o;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m implements d0 {

    /* renamed from: a, reason: collision with root package name */
    public final d0 f10623a;

    /* renamed from: b, reason: collision with root package name */
    public final c f10624b;

    /* renamed from: g, reason: collision with root package name */
    public l f10629g;
    public s h;

    /* renamed from: d, reason: collision with root package name */
    public int f10626d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f10627e = 0;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f10628f = w.f3718f;

    /* renamed from: c, reason: collision with root package name */
    public final p f10625c = new p();

    public m(d0 d0Var, c cVar) {
        this.f10623a = d0Var;
        this.f10624b = cVar;
    }

    @Override // d2.d0
    public final int a(d1.k kVar, int i9, boolean z8) {
        return b(kVar, i9, z8);
    }

    @Override // d2.d0
    public final int b(d1.k kVar, int i9, boolean z8) {
        if (this.f10629g == null) {
            return this.f10623a.b(kVar, i9, z8);
        }
        g(i9);
        int read = kVar.read(this.f10628f, this.f10627e, i9);
        if (read != -1) {
            this.f10627e += read;
            return read;
        }
        if (z8) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // d2.d0
    public final void c(int i9, p pVar) {
        f(pVar, i9, 0);
    }

    @Override // d2.d0
    public final void d(long j5, int i9, int i10, int i11, c0 c0Var) {
        if (this.f10629g == null) {
            this.f10623a.d(j5, i9, i10, i11, c0Var);
            return;
        }
        g1.a.e("DRM on subtitles is not supported", c0Var == null);
        int i12 = (this.f10627e - i11) - i10;
        this.f10629g.a0(this.f10628f, i12, i10, k.f10620c, new o(this, j5, i9));
        int i13 = i12 + i10;
        this.f10626d = i13;
        if (i13 == this.f10627e) {
            this.f10626d = 0;
            this.f10627e = 0;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0097, code lost:
    
        if (r10.equals("text/vtt") == false) goto L24;
     */
    @Override // d2.d0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(d1.s r10) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.m.e(d1.s):void");
    }

    @Override // d2.d0
    public final void f(p pVar, int i9, int i10) {
        if (this.f10629g == null) {
            this.f10623a.f(pVar, i9, i10);
            return;
        }
        g(i9);
        pVar.e(this.f10627e, i9, this.f10628f);
        this.f10627e += i9;
    }

    public final void g(int i9) {
        int length = this.f10628f.length;
        int i10 = this.f10627e;
        if (length - i10 >= i9) {
            return;
        }
        int i11 = i10 - this.f10626d;
        int max = Math.max(i11 * 2, i9 + i11);
        byte[] bArr = this.f10628f;
        byte[] bArr2 = max <= bArr.length ? bArr : new byte[max];
        System.arraycopy(bArr, this.f10626d, bArr2, 0, i11);
        this.f10626d = 0;
        this.f10627e = i11;
        this.f10628f = bArr2;
    }
}
