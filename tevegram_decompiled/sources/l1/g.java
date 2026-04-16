package l1;

import android.text.TextUtils;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f5872a;

    /* renamed from: b, reason: collision with root package name */
    public final d1.s f5873b;

    /* renamed from: c, reason: collision with root package name */
    public final d1.s f5874c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5875d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5876e;

    public g(String str, d1.s sVar, d1.s sVar2, int i9, int i10) {
        g1.a.f(i9 == 0 || i10 == 0);
        if (TextUtils.isEmpty(str)) {
            m7.c.d();
            throw null;
        }
        this.f5872a = str;
        sVar.getClass();
        this.f5873b = sVar;
        sVar2.getClass();
        this.f5874c = sVar2;
        this.f5875d = i9;
        this.f5876e = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && g.class == obj.getClass()) {
            g gVar = (g) obj;
            if (this.f5875d == gVar.f5875d && this.f5876e == gVar.f5876e && this.f5872a.equals(gVar.f5872a) && this.f5873b.equals(gVar.f5873b) && this.f5874c.equals(gVar.f5874c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f5874c.hashCode() + ((this.f5873b.hashCode() + androidx.activity.g.k((((527 + this.f5875d) * 31) + this.f5876e) * 31, 31, this.f5872a)) * 31);
    }
}
