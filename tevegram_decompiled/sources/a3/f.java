package a3;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f {
    public static final int[] A;
    public static final boolean[] B;
    public static final int[] C;
    public static final int[] D;
    public static final int[] E;
    public static final int[] F;

    /* renamed from: w, reason: collision with root package name */
    public static final int f78w = c(2, 2, 2, 0);

    /* renamed from: x, reason: collision with root package name */
    public static final int f79x;

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f80y;

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f81z;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f82a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final SpannableStringBuilder f83b = new SpannableStringBuilder();

    /* renamed from: c, reason: collision with root package name */
    public boolean f84c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f85d;

    /* renamed from: e, reason: collision with root package name */
    public int f86e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f87f;

    /* renamed from: g, reason: collision with root package name */
    public int f88g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f89i;

    /* renamed from: j, reason: collision with root package name */
    public int f90j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f91k;

    /* renamed from: l, reason: collision with root package name */
    public int f92l;

    /* renamed from: m, reason: collision with root package name */
    public int f93m;

    /* renamed from: n, reason: collision with root package name */
    public int f94n;

    /* renamed from: o, reason: collision with root package name */
    public int f95o;

    /* renamed from: p, reason: collision with root package name */
    public int f96p;

    /* renamed from: q, reason: collision with root package name */
    public int f97q;

    /* renamed from: r, reason: collision with root package name */
    public int f98r;

    /* renamed from: s, reason: collision with root package name */
    public int f99s;

    /* renamed from: t, reason: collision with root package name */
    public int f100t;

    /* renamed from: u, reason: collision with root package name */
    public int f101u;

    /* renamed from: v, reason: collision with root package name */
    public int f102v;

    static {
        int c9 = c(0, 0, 0, 0);
        f79x = c9;
        int c10 = c(0, 0, 0, 3);
        f80y = new int[]{0, 0, 0, 0, 0, 2, 0};
        f81z = new int[]{0, 0, 0, 0, 0, 0, 2};
        A = new int[]{3, 3, 3, 3, 3, 3, 1};
        B = new boolean[]{false, false, false, true, true, true, false};
        C = new int[]{c9, c10, c9, c9, c10, c9, c9};
        D = new int[]{0, 1, 2, 3, 4, 3, 4};
        E = new int[]{0, 0, 0, 0, 0, 3, 3};
        F = new int[]{c9, c9, c9, c9, c9, c10, c10};
    }

    public f() {
        d();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(int r4, int r5, int r6, int r7) {
        /*
            r0 = 4
            g1.a.i(r4, r0)
            g1.a.i(r5, r0)
            g1.a.i(r6, r0)
            g1.a.i(r7, r0)
            r0 = 1
            r1 = 255(0xff, float:3.57E-43)
            r2 = 0
            if (r7 == 0) goto L1b
            if (r7 == r0) goto L1b
            r3 = 2
            if (r7 == r3) goto L20
            r3 = 3
            if (r7 == r3) goto L1e
        L1b:
            r7 = 255(0xff, float:3.57E-43)
            goto L22
        L1e:
            r7 = 0
            goto L22
        L20:
            r7 = 127(0x7f, float:1.78E-43)
        L22:
            if (r4 <= r0) goto L27
            r4 = 255(0xff, float:3.57E-43)
            goto L28
        L27:
            r4 = 0
        L28:
            if (r5 <= r0) goto L2d
            r5 = 255(0xff, float:3.57E-43)
            goto L2e
        L2d:
            r5 = 0
        L2e:
            if (r6 <= r0) goto L31
            goto L32
        L31:
            r1 = 0
        L32:
            int r4 = android.graphics.Color.argb(r7, r4, r5, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.f.c(int, int, int, int):int");
    }

    public final void a(char c9) {
        SpannableStringBuilder spannableStringBuilder = this.f83b;
        if (c9 != '\n') {
            spannableStringBuilder.append(c9);
            return;
        }
        SpannableString b9 = b();
        ArrayList arrayList = this.f82a;
        arrayList.add(b9);
        spannableStringBuilder.clear();
        if (this.f96p != -1) {
            this.f96p = 0;
        }
        if (this.f97q != -1) {
            this.f97q = 0;
        }
        if (this.f98r != -1) {
            this.f98r = 0;
        }
        if (this.f100t != -1) {
            this.f100t = 0;
        }
        while (true) {
            if ((!this.f91k || arrayList.size() < this.f90j) && arrayList.size() < 15) {
                return;
            } else {
                arrayList.remove(0);
            }
        }
    }

    public final SpannableString b() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f83b);
        int length = spannableStringBuilder.length();
        if (length > 0) {
            if (this.f96p != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.f96p, length, 33);
            }
            if (this.f97q != -1) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.f97q, length, 33);
            }
            if (this.f98r != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f99s), this.f98r, length, 33);
            }
            if (this.f100t != -1) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f101u), this.f100t, length, 33);
            }
        }
        return new SpannableString(spannableStringBuilder);
    }

    public final void d() {
        this.f82a.clear();
        this.f83b.clear();
        this.f96p = -1;
        this.f97q = -1;
        this.f98r = -1;
        this.f100t = -1;
        this.f102v = 0;
        this.f84c = false;
        this.f85d = false;
        this.f86e = 4;
        this.f87f = false;
        this.f88g = 0;
        this.h = 0;
        this.f89i = 0;
        this.f90j = 15;
        this.f91k = true;
        this.f92l = 0;
        this.f93m = 0;
        this.f94n = 0;
        int i9 = f79x;
        this.f95o = i9;
        this.f99s = f78w;
        this.f101u = i9;
    }

    public final void e(boolean z8, boolean z9) {
        int i9 = this.f96p;
        SpannableStringBuilder spannableStringBuilder = this.f83b;
        if (i9 != -1) {
            if (!z8) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.f96p, spannableStringBuilder.length(), 33);
                this.f96p = -1;
            }
        } else if (z8) {
            this.f96p = spannableStringBuilder.length();
        }
        if (this.f97q == -1) {
            if (z9) {
                this.f97q = spannableStringBuilder.length();
            }
        } else {
            if (z9) {
                return;
            }
            spannableStringBuilder.setSpan(new UnderlineSpan(), this.f97q, spannableStringBuilder.length(), 33);
            this.f97q = -1;
        }
    }

    public final void f(int i9, int i10) {
        int i11 = this.f98r;
        SpannableStringBuilder spannableStringBuilder = this.f83b;
        if (i11 != -1 && this.f99s != i9) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f99s), this.f98r, spannableStringBuilder.length(), 33);
        }
        if (i9 != f78w) {
            this.f98r = spannableStringBuilder.length();
            this.f99s = i9;
        }
        if (this.f100t != -1 && this.f101u != i10) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f101u), this.f100t, spannableStringBuilder.length(), 33);
        }
        if (i10 != f79x) {
            this.f100t = spannableStringBuilder.length();
            this.f101u = i10;
        }
    }
}
