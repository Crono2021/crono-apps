package y;

import android.view.ViewGroup;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d extends ViewGroup.MarginLayoutParams {
    public float A;
    public String B;
    public int C;
    public float D;
    public float E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public float N;
    public float O;
    public int P;
    public int Q;
    public int R;
    public boolean S;
    public boolean T;
    public String U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;

    /* renamed from: a, reason: collision with root package name */
    public int f10231a;

    /* renamed from: a0, reason: collision with root package name */
    public int f10232a0;

    /* renamed from: b, reason: collision with root package name */
    public int f10233b;

    /* renamed from: b0, reason: collision with root package name */
    public int f10234b0;

    /* renamed from: c, reason: collision with root package name */
    public float f10235c;

    /* renamed from: c0, reason: collision with root package name */
    public int f10236c0;

    /* renamed from: d, reason: collision with root package name */
    public int f10237d;

    /* renamed from: d0, reason: collision with root package name */
    public int f10238d0;

    /* renamed from: e, reason: collision with root package name */
    public int f10239e;

    /* renamed from: e0, reason: collision with root package name */
    public int f10240e0;

    /* renamed from: f, reason: collision with root package name */
    public int f10241f;

    /* renamed from: f0, reason: collision with root package name */
    public int f10242f0;

    /* renamed from: g, reason: collision with root package name */
    public int f10243g;

    /* renamed from: g0, reason: collision with root package name */
    public float f10244g0;
    public int h;

    /* renamed from: h0, reason: collision with root package name */
    public int f10245h0;

    /* renamed from: i, reason: collision with root package name */
    public int f10246i;
    public int i0;

    /* renamed from: j, reason: collision with root package name */
    public int f10247j;

    /* renamed from: j0, reason: collision with root package name */
    public float f10248j0;

    /* renamed from: k, reason: collision with root package name */
    public int f10249k;

    /* renamed from: k0, reason: collision with root package name */
    public w.d f10250k0;

    /* renamed from: l, reason: collision with root package name */
    public int f10251l;

    /* renamed from: m, reason: collision with root package name */
    public int f10252m;

    /* renamed from: n, reason: collision with root package name */
    public int f10253n;

    /* renamed from: o, reason: collision with root package name */
    public float f10254o;

    /* renamed from: p, reason: collision with root package name */
    public int f10255p;

    /* renamed from: q, reason: collision with root package name */
    public int f10256q;

    /* renamed from: r, reason: collision with root package name */
    public int f10257r;

    /* renamed from: s, reason: collision with root package name */
    public int f10258s;

    /* renamed from: t, reason: collision with root package name */
    public int f10259t;

    /* renamed from: u, reason: collision with root package name */
    public int f10260u;

    /* renamed from: v, reason: collision with root package name */
    public int f10261v;

    /* renamed from: w, reason: collision with root package name */
    public int f10262w;

    /* renamed from: x, reason: collision with root package name */
    public int f10263x;

    /* renamed from: y, reason: collision with root package name */
    public int f10264y;

    /* renamed from: z, reason: collision with root package name */
    public float f10265z;

    public final void a() {
        this.Y = false;
        this.V = true;
        this.W = true;
        int i9 = ((ViewGroup.MarginLayoutParams) this).width;
        if (i9 == -2 && this.S) {
            this.V = false;
            if (this.H == 0) {
                this.H = 1;
            }
        }
        int i10 = ((ViewGroup.MarginLayoutParams) this).height;
        if (i10 == -2 && this.T) {
            this.W = false;
            if (this.I == 0) {
                this.I = 1;
            }
        }
        if (i9 == 0 || i9 == -1) {
            this.V = false;
            if (i9 == 0 && this.H == 1) {
                ((ViewGroup.MarginLayoutParams) this).width = -2;
                this.S = true;
            }
        }
        if (i10 == 0 || i10 == -1) {
            this.W = false;
            if (i10 == 0 && this.I == 1) {
                ((ViewGroup.MarginLayoutParams) this).height = -2;
                this.T = true;
            }
        }
        if (this.f10235c == -1.0f && this.f10231a == -1 && this.f10233b == -1) {
            return;
        }
        this.Y = true;
        this.V = true;
        this.W = true;
        if (!(this.f10250k0 instanceof w.h)) {
            this.f10250k0 = new w.h();
        }
        ((w.h) this.f10250k0).B(this.R);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007c  */
    @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void resolveLayoutDirection(int r11) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y.d.resolveLayoutDirection(int):void");
    }
}
