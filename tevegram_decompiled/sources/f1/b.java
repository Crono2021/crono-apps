package f1;

import android.graphics.Bitmap;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import g1.w;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b {
    public static final String A;
    public static final String B;
    public static final String C;
    public static final String D;
    public static final String E;
    public static final String F;
    public static final String G;
    public static final String H;
    public static final String I;
    public static final String J;

    /* renamed from: r, reason: collision with root package name */
    public static final String f3234r;

    /* renamed from: s, reason: collision with root package name */
    public static final String f3235s;

    /* renamed from: t, reason: collision with root package name */
    public static final String f3236t;

    /* renamed from: u, reason: collision with root package name */
    public static final String f3237u;

    /* renamed from: v, reason: collision with root package name */
    public static final String f3238v;

    /* renamed from: w, reason: collision with root package name */
    public static final String f3239w;

    /* renamed from: x, reason: collision with root package name */
    public static final String f3240x;

    /* renamed from: y, reason: collision with root package name */
    public static final String f3241y;

    /* renamed from: z, reason: collision with root package name */
    public static final String f3242z;

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f3243a;

    /* renamed from: b, reason: collision with root package name */
    public final Layout.Alignment f3244b;

    /* renamed from: c, reason: collision with root package name */
    public final Layout.Alignment f3245c;

    /* renamed from: d, reason: collision with root package name */
    public final Bitmap f3246d;

    /* renamed from: e, reason: collision with root package name */
    public final float f3247e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3248f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3249g;
    public final float h;

    /* renamed from: i, reason: collision with root package name */
    public final int f3250i;

    /* renamed from: j, reason: collision with root package name */
    public final float f3251j;

    /* renamed from: k, reason: collision with root package name */
    public final float f3252k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f3253l;

    /* renamed from: m, reason: collision with root package name */
    public final int f3254m;

    /* renamed from: n, reason: collision with root package name */
    public final int f3255n;

    /* renamed from: o, reason: collision with root package name */
    public final float f3256o;

    /* renamed from: p, reason: collision with root package name */
    public final int f3257p;

    /* renamed from: q, reason: collision with root package name */
    public final float f3258q;

    static {
        new b("", null, null, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, 0.0f);
        int i9 = w.f3713a;
        f3234r = Integer.toString(0, 36);
        f3235s = Integer.toString(17, 36);
        f3236t = Integer.toString(1, 36);
        f3237u = Integer.toString(2, 36);
        f3238v = Integer.toString(3, 36);
        f3239w = Integer.toString(18, 36);
        f3240x = Integer.toString(4, 36);
        f3241y = Integer.toString(5, 36);
        f3242z = Integer.toString(6, 36);
        A = Integer.toString(7, 36);
        B = Integer.toString(8, 36);
        C = Integer.toString(9, 36);
        D = Integer.toString(10, 36);
        E = Integer.toString(11, 36);
        F = Integer.toString(12, 36);
        G = Integer.toString(13, 36);
        H = Integer.toString(14, 36);
        I = Integer.toString(15, 36);
        J = Integer.toString(16, 36);
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f9, int i9, int i10, float f10, int i11, int i12, float f11, float f12, float f13, boolean z8, int i13, int i14, float f14) {
        if (charSequence == null) {
            bitmap.getClass();
        } else {
            g1.a.f(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f3243a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f3243a = charSequence.toString();
        } else {
            this.f3243a = null;
        }
        this.f3244b = alignment;
        this.f3245c = alignment2;
        this.f3246d = bitmap;
        this.f3247e = f9;
        this.f3248f = i9;
        this.f3249g = i10;
        this.h = f10;
        this.f3250i = i11;
        this.f3251j = f12;
        this.f3252k = f13;
        this.f3253l = z8;
        this.f3254m = i13;
        this.f3255n = i12;
        this.f3256o = f11;
        this.f3257p = i14;
        this.f3258q = f14;
    }

    public final a a() {
        a aVar = new a();
        aVar.f3218a = this.f3243a;
        aVar.f3219b = this.f3246d;
        aVar.f3220c = this.f3244b;
        aVar.f3221d = this.f3245c;
        aVar.f3222e = this.f3247e;
        aVar.f3223f = this.f3248f;
        aVar.f3224g = this.f3249g;
        aVar.h = this.h;
        aVar.f3225i = this.f3250i;
        aVar.f3226j = this.f3255n;
        aVar.f3227k = this.f3256o;
        aVar.f3228l = this.f3251j;
        aVar.f3229m = this.f3252k;
        aVar.f3230n = this.f3253l;
        aVar.f3231o = this.f3254m;
        aVar.f3232p = this.f3257p;
        aVar.f3233q = this.f3258q;
        return aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (TextUtils.equals(this.f3243a, bVar.f3243a) && this.f3244b == bVar.f3244b && this.f3245c == bVar.f3245c) {
                Bitmap bitmap = bVar.f3246d;
                Bitmap bitmap2 = this.f3246d;
                if (bitmap2 != null ? !(bitmap == null || !bitmap2.sameAs(bitmap)) : bitmap == null) {
                    if (this.f3247e == bVar.f3247e && this.f3248f == bVar.f3248f && this.f3249g == bVar.f3249g && this.h == bVar.h && this.f3250i == bVar.f3250i && this.f3251j == bVar.f3251j && this.f3252k == bVar.f3252k && this.f3253l == bVar.f3253l && this.f3254m == bVar.f3254m && this.f3255n == bVar.f3255n && this.f3256o == bVar.f3256o && this.f3257p == bVar.f3257p && this.f3258q == bVar.f3258q) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3243a, this.f3244b, this.f3245c, this.f3246d, Float.valueOf(this.f3247e), Integer.valueOf(this.f3248f), Integer.valueOf(this.f3249g), Float.valueOf(this.h), Integer.valueOf(this.f3250i), Float.valueOf(this.f3251j), Float.valueOf(this.f3252k), Boolean.valueOf(this.f3253l), Integer.valueOf(this.f3254m), Integer.valueOf(this.f3255n), Float.valueOf(this.f3256o), Integer.valueOf(this.f3257p), Float.valueOf(this.f3258q)});
    }
}
