package y1;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.LocaleList;
import android.text.TextUtils;
import b6.g0;
import b6.u0;
import b6.v0;
import b6.y;
import d1.b1;
import d1.z0;
import g1.w;
import java.util.Locale;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends m implements Comparable {
    public final int A;
    public final int B;
    public final int C;
    public final boolean D;
    public final boolean E;

    /* renamed from: m, reason: collision with root package name */
    public final int f10413m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f10414n;

    /* renamed from: o, reason: collision with root package name */
    public final String f10415o;

    /* renamed from: p, reason: collision with root package name */
    public final i f10416p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f10417q;

    /* renamed from: r, reason: collision with root package name */
    public final int f10418r;

    /* renamed from: s, reason: collision with root package name */
    public final int f10419s;

    /* renamed from: t, reason: collision with root package name */
    public final int f10420t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f10421u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f10422v;

    /* renamed from: w, reason: collision with root package name */
    public final int f10423w;

    /* renamed from: x, reason: collision with root package name */
    public final int f10424x;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f10425y;

    /* renamed from: z, reason: collision with root package name */
    public final int f10426z;

    public e(int i9, z0 z0Var, int i10, i iVar, int i11, boolean z8, d dVar, int i12) {
        super(i9, z0Var, i10);
        int i13;
        int i14;
        String[] strArr;
        int i15;
        LocaleList locales;
        String languageTags;
        this.f10416p = iVar;
        boolean z9 = iVar.f10441w;
        g0 g0Var = iVar.f2400l;
        g0 g0Var2 = iVar.f2397i;
        int i16 = z9 ? 24 : 16;
        int i17 = 0;
        this.f10421u = false;
        this.f10415o = o.f(this.f10458l.f2546d);
        this.f10417q = o.d(i11, false);
        int i18 = 0;
        while (true) {
            i13 = Integer.MAX_VALUE;
            if (i18 >= g0Var2.size()) {
                i18 = Integer.MAX_VALUE;
                i14 = 0;
                break;
            } else {
                i14 = o.b(this.f10458l, (String) g0Var2.get(i18), false);
                if (i14 > 0) {
                    break;
                } else {
                    i18++;
                }
            }
        }
        this.f10419s = i18;
        this.f10418r = i14;
        int i19 = this.f10458l.f2548f;
        this.f10420t = (i19 == 0 || i19 != 0) ? Integer.bitCount(0) : Integer.MAX_VALUE;
        d1.s sVar = this.f10458l;
        int i20 = sVar.f2548f;
        this.f10422v = i20 == 0 || (i20 & 1) != 0;
        this.f10425y = (sVar.f2547e & 1) != 0;
        int i21 = sVar.f2567z;
        this.f10426z = i21;
        this.A = sVar.A;
        int i22 = sVar.f2550i;
        this.B = i22;
        this.f10414n = (i22 == -1 || i22 <= iVar.f2399k) && (i21 == -1 || i21 <= iVar.f2398j) && dVar.apply(sVar);
        Configuration configuration = Resources.getSystem().getConfiguration();
        int i23 = w.f3713a;
        if (i23 >= 24) {
            locales = configuration.getLocales();
            languageTags = locales.toLanguageTags();
            strArr = languageTags.split(",", -1);
        } else {
            Locale locale = configuration.locale;
            strArr = new String[]{i23 >= 21 ? locale.toLanguageTag() : locale.toString()};
        }
        for (int i24 = 0; i24 < strArr.length; i24++) {
            strArr[i24] = w.N(strArr[i24]);
        }
        int i25 = 0;
        while (true) {
            if (i25 >= strArr.length) {
                i25 = Integer.MAX_VALUE;
                i15 = 0;
                break;
            } else {
                i15 = o.b(this.f10458l, strArr[i25], false);
                if (i15 > 0) {
                    break;
                } else {
                    i25++;
                }
            }
        }
        this.f10423w = i25;
        this.f10424x = i15;
        int i26 = 0;
        while (true) {
            if (i26 >= g0Var.size()) {
                break;
            }
            String str = this.f10458l.f2554m;
            if (str != null && str.equals(g0Var.get(i26))) {
                i13 = i26;
                break;
            }
            i26++;
        }
        this.C = i13;
        this.D = (i11 & 384) == 128;
        this.E = (i11 & 64) == 64;
        boolean z10 = this.f10414n;
        i iVar2 = this.f10416p;
        boolean z11 = iVar2.f10443y;
        b1 b1Var = iVar2.f2401m;
        if (o.d(i11, z11) && (z10 || iVar2.f10440v)) {
            b1Var.getClass();
            i17 = (!o.d(i11, false) || !z10 || this.f10458l.f2550i == -1 || (!iVar2.f10444z && z8) || (i16 & i11) == 0) ? 1 : 2;
        }
        this.f10413m = i17;
    }

    @Override // y1.m
    public final int a() {
        return this.f10413m;
    }

    @Override // y1.m
    public final boolean b(m mVar) {
        int i9;
        String str;
        e eVar = (e) mVar;
        d1.s sVar = eVar.f10458l;
        this.f10416p.getClass();
        d1.s sVar2 = this.f10458l;
        int i10 = sVar2.f2567z;
        if (i10 == -1 || i10 != sVar.f2567z) {
            return false;
        }
        return (this.f10421u || ((str = sVar2.f2554m) != null && TextUtils.equals(str, sVar.f2554m))) && (i9 = sVar2.A) != -1 && i9 == sVar.A && this.D == eVar.D && this.E == eVar.E;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final int compareTo(e eVar) {
        boolean z8 = this.f10417q;
        boolean z9 = this.f10414n;
        v0 a9 = (z9 && z8) ? o.f10473j : o.f10473j.a();
        boolean z10 = eVar.f10417q;
        int i9 = eVar.B;
        y c9 = y.f1469a.c(z8, z10);
        Integer valueOf = Integer.valueOf(this.f10419s);
        Integer valueOf2 = Integer.valueOf(eVar.f10419s);
        u0 u0Var = u0.f1461k;
        y b9 = c9.b(valueOf, valueOf2, u0Var).a(this.f10418r, eVar.f10418r).a(this.f10420t, eVar.f10420t).c(this.f10425y, eVar.f10425y).c(this.f10422v, eVar.f10422v).b(Integer.valueOf(this.f10423w), Integer.valueOf(eVar.f10423w), u0Var).a(this.f10424x, eVar.f10424x).c(z9, eVar.f10414n).b(Integer.valueOf(this.C), Integer.valueOf(eVar.C), u0Var);
        int i10 = this.B;
        Integer valueOf3 = Integer.valueOf(i10);
        Integer valueOf4 = Integer.valueOf(i9);
        this.f10416p.getClass();
        v0 v0Var = o.f10474k;
        y b10 = b9.b(valueOf3, valueOf4, v0Var).c(this.D, eVar.D).c(this.E, eVar.E).b(Integer.valueOf(this.f10426z), Integer.valueOf(eVar.f10426z), a9).b(Integer.valueOf(this.A), Integer.valueOf(eVar.A), a9);
        Integer valueOf5 = Integer.valueOf(i10);
        Integer valueOf6 = Integer.valueOf(i9);
        if (!w.a(this.f10415o, eVar.f10415o)) {
            a9 = v0Var;
        }
        return b10.b(valueOf5, valueOf6, a9).e();
    }
}
