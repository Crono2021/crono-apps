package f3;

import android.text.Layout;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public String f3354a;

    /* renamed from: b, reason: collision with root package name */
    public int f3355b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3356c;

    /* renamed from: d, reason: collision with root package name */
    public int f3357d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3358e;

    /* renamed from: k, reason: collision with root package name */
    public float f3363k;

    /* renamed from: l, reason: collision with root package name */
    public String f3364l;

    /* renamed from: o, reason: collision with root package name */
    public Layout.Alignment f3367o;

    /* renamed from: p, reason: collision with root package name */
    public Layout.Alignment f3368p;

    /* renamed from: r, reason: collision with root package name */
    public b f3370r;

    /* renamed from: f, reason: collision with root package name */
    public int f3359f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f3360g = -1;
    public int h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f3361i = -1;

    /* renamed from: j, reason: collision with root package name */
    public int f3362j = -1;

    /* renamed from: m, reason: collision with root package name */
    public int f3365m = -1;

    /* renamed from: n, reason: collision with root package name */
    public int f3366n = -1;

    /* renamed from: q, reason: collision with root package name */
    public int f3369q = -1;

    /* renamed from: s, reason: collision with root package name */
    public float f3371s = Float.MAX_VALUE;

    public final void a(g gVar) {
        int i9;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (gVar != null) {
            if (!this.f3356c && gVar.f3356c) {
                this.f3355b = gVar.f3355b;
                this.f3356c = true;
            }
            if (this.h == -1) {
                this.h = gVar.h;
            }
            if (this.f3361i == -1) {
                this.f3361i = gVar.f3361i;
            }
            if (this.f3354a == null && (str = gVar.f3354a) != null) {
                this.f3354a = str;
            }
            if (this.f3359f == -1) {
                this.f3359f = gVar.f3359f;
            }
            if (this.f3360g == -1) {
                this.f3360g = gVar.f3360g;
            }
            if (this.f3366n == -1) {
                this.f3366n = gVar.f3366n;
            }
            if (this.f3367o == null && (alignment2 = gVar.f3367o) != null) {
                this.f3367o = alignment2;
            }
            if (this.f3368p == null && (alignment = gVar.f3368p) != null) {
                this.f3368p = alignment;
            }
            if (this.f3369q == -1) {
                this.f3369q = gVar.f3369q;
            }
            if (this.f3362j == -1) {
                this.f3362j = gVar.f3362j;
                this.f3363k = gVar.f3363k;
            }
            if (this.f3370r == null) {
                this.f3370r = gVar.f3370r;
            }
            if (this.f3371s == Float.MAX_VALUE) {
                this.f3371s = gVar.f3371s;
            }
            if (!this.f3358e && gVar.f3358e) {
                this.f3357d = gVar.f3357d;
                this.f3358e = true;
            }
            if (this.f3365m != -1 || (i9 = gVar.f3365m) == -1) {
                return;
            }
            this.f3365m = i9;
        }
    }
}
