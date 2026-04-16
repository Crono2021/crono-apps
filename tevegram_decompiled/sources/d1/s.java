package d1;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Stream;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s {
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public int J;

    /* renamed from: a, reason: collision with root package name */
    public final String f2543a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2544b;

    /* renamed from: c, reason: collision with root package name */
    public final b6.g0 f2545c;

    /* renamed from: d, reason: collision with root package name */
    public final String f2546d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2547e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2548f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2549g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final int f2550i;

    /* renamed from: j, reason: collision with root package name */
    public final String f2551j;

    /* renamed from: k, reason: collision with root package name */
    public final j0 f2552k;

    /* renamed from: l, reason: collision with root package name */
    public final String f2553l;

    /* renamed from: m, reason: collision with root package name */
    public final String f2554m;

    /* renamed from: n, reason: collision with root package name */
    public final int f2555n;

    /* renamed from: o, reason: collision with root package name */
    public final List f2556o;

    /* renamed from: p, reason: collision with root package name */
    public final n f2557p;

    /* renamed from: q, reason: collision with root package name */
    public final long f2558q;

    /* renamed from: r, reason: collision with root package name */
    public final int f2559r;

    /* renamed from: s, reason: collision with root package name */
    public final int f2560s;

    /* renamed from: t, reason: collision with root package name */
    public final float f2561t;

    /* renamed from: u, reason: collision with root package name */
    public final int f2562u;

    /* renamed from: v, reason: collision with root package name */
    public final float f2563v;

    /* renamed from: w, reason: collision with root package name */
    public final byte[] f2564w;

    /* renamed from: x, reason: collision with root package name */
    public final int f2565x;

    /* renamed from: y, reason: collision with root package name */
    public final j f2566y;

    /* renamed from: z, reason: collision with root package name */
    public final int f2567z;

    static {
        new s(new r());
        g1.w.H(0);
        g1.w.H(1);
        g1.w.H(2);
        g1.w.H(3);
        g1.w.H(4);
        androidx.activity.g.s(5, 6, 7, 8, 9);
        androidx.activity.g.s(10, 11, 12, 13, 14);
        androidx.activity.g.s(15, 16, 17, 18, 19);
        androidx.activity.g.s(20, 21, 22, 23, 24);
        androidx.activity.g.s(25, 26, 27, 28, 29);
        g1.w.H(30);
        g1.w.H(31);
        g1.w.H(32);
    }

    public s(r rVar) {
        Stream stream;
        boolean anyMatch;
        boolean z8;
        String str;
        this.f2543a = rVar.f2518a;
        String N = g1.w.N(rVar.f2521d);
        this.f2546d = N;
        if (rVar.f2520c.isEmpty() && rVar.f2519b != null) {
            this.f2545c = b6.g0.q(new v(N, rVar.f2519b));
            this.f2544b = rVar.f2519b;
        } else if (rVar.f2520c.isEmpty() || rVar.f2519b != null) {
            if (!rVar.f2520c.isEmpty() || rVar.f2519b != null) {
                stream = rVar.f2520c.stream();
                anyMatch = stream.anyMatch(new b7.j(rVar, 2));
                if (!anyMatch) {
                    z8 = false;
                    g1.a.k(z8);
                    this.f2545c = rVar.f2520c;
                    this.f2544b = rVar.f2519b;
                }
            }
            z8 = true;
            g1.a.k(z8);
            this.f2545c = rVar.f2520c;
            this.f2544b = rVar.f2519b;
        } else {
            b6.g0 g0Var = rVar.f2520c;
            this.f2545c = g0Var;
            int size = g0Var.size();
            int i9 = 0;
            while (true) {
                if (i9 >= size) {
                    str = ((v) g0Var.get(0)).f2582b;
                    break;
                }
                Object obj = g0Var.get(i9);
                i9++;
                v vVar = (v) obj;
                if (TextUtils.equals(vVar.f2581a, N)) {
                    str = vVar.f2582b;
                    break;
                }
            }
            this.f2544b = str;
        }
        this.f2547e = rVar.f2522e;
        this.f2548f = rVar.f2523f;
        int i10 = rVar.f2524g;
        this.f2549g = i10;
        int i11 = rVar.h;
        this.h = i11;
        this.f2550i = i11 != -1 ? i11 : i10;
        this.f2551j = rVar.f2525i;
        this.f2552k = rVar.f2526j;
        this.f2553l = rVar.f2527k;
        this.f2554m = rVar.f2528l;
        this.f2555n = rVar.f2529m;
        List list = rVar.f2530n;
        this.f2556o = list == null ? Collections.EMPTY_LIST : list;
        n nVar = rVar.f2531o;
        this.f2557p = nVar;
        this.f2558q = rVar.f2532p;
        this.f2559r = rVar.f2533q;
        this.f2560s = rVar.f2534r;
        this.f2561t = rVar.f2535s;
        int i12 = rVar.f2536t;
        this.f2562u = i12 == -1 ? 0 : i12;
        float f9 = rVar.f2537u;
        this.f2563v = f9 == -1.0f ? 1.0f : f9;
        this.f2564w = rVar.f2538v;
        this.f2565x = rVar.f2539w;
        this.f2566y = rVar.f2540x;
        this.f2567z = rVar.f2541y;
        this.A = rVar.f2542z;
        this.B = rVar.A;
        int i13 = rVar.B;
        this.C = i13 == -1 ? 0 : i13;
        int i14 = rVar.C;
        this.D = i14 != -1 ? i14 : 0;
        this.E = rVar.D;
        this.F = rVar.E;
        this.G = rVar.F;
        this.H = rVar.G;
        int i15 = rVar.H;
        if (i15 != 0 || nVar == null) {
            this.I = i15;
        } else {
            this.I = 1;
        }
    }

    public static String c(s sVar) {
        char c9;
        String str;
        if (sVar == null) {
            return "null";
        }
        int i9 = sVar.f2548f;
        int i10 = sVar.f2547e;
        b6.g0 g0Var = sVar.f2545c;
        String str2 = sVar.f2546d;
        int i11 = sVar.A;
        int i12 = sVar.f2567z;
        float f9 = sVar.f2561t;
        j jVar = sVar.f2566y;
        int i13 = sVar.f2560s;
        int i14 = sVar.f2559r;
        n nVar = sVar.f2557p;
        String str3 = sVar.f2551j;
        int i15 = sVar.f2550i;
        String str4 = sVar.f2553l;
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(sVar.f2543a);
        sb.append(", mimeType=");
        sb.append(sVar.f2554m);
        if (str4 != null) {
            sb.append(", container=");
            sb.append(str4);
        }
        int i16 = -1;
        if (i15 != -1) {
            sb.append(", bitrate=");
            sb.append(i15);
        }
        if (str3 != null) {
            sb.append(", codecs=");
            sb.append(str3);
        }
        if (nVar != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i17 = 0; i17 < nVar.f2506l; i17++) {
                UUID uuid = nVar.f2503i[i17].f2497j;
                if (uuid.equals(i.f2479b)) {
                    linkedHashSet.add("cenc");
                } else if (uuid.equals(i.f2480c)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(i.f2482e)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(i.f2481d)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(i.f2478a)) {
                    linkedHashSet.add("universal");
                } else {
                    linkedHashSet.add("unknown (" + uuid + ")");
                }
            }
            c9 = ',';
            sb.append(", drm=[");
            new a6.d(String.valueOf(',')).a(sb, linkedHashSet.iterator());
            sb.append(']');
            i16 = -1;
        } else {
            c9 = ',';
        }
        if (i14 != i16 && i13 != i16) {
            sb.append(", res=");
            sb.append(i14);
            sb.append("x");
            sb.append(i13);
        }
        if (jVar != null) {
            int i18 = jVar.f2485c;
            int i19 = jVar.f2484b;
            int i20 = jVar.f2483a;
            int i21 = jVar.f2488f;
            int i22 = jVar.f2487e;
            if ((i22 != -1 && i21 != -1) || (i20 != -1 && i19 != -1 && i18 != -1)) {
                sb.append(", color=");
                if (i20 == -1 || i19 == -1 || i18 == -1) {
                    str = "NA/NA/NA";
                } else {
                    String str5 = i20 != -1 ? i20 != 6 ? i20 != 1 ? i20 != 2 ? "Undefined color space" : "BT601" : "BT709" : "BT2020" : "Unset color space";
                    String str6 = i19 != -1 ? i19 != 1 ? i19 != 2 ? "Undefined color range" : "Limited range" : "Full range" : "Unset color range";
                    String a9 = j.a(i18);
                    Locale locale = Locale.US;
                    str = str5 + "/" + str6 + "/" + a9;
                }
                sb.append(str + "/" + ((i22 == -1 || i21 == -1) ? "NA/NA" : i22 + "/" + i21));
            }
        }
        if (f9 != -1.0f) {
            sb.append(", fps=");
            sb.append(f9);
        }
        if (i12 != -1) {
            sb.append(", channels=");
            sb.append(i12);
        }
        if (i11 != -1) {
            sb.append(", sample_rate=");
            sb.append(i11);
        }
        if (str2 != null) {
            sb.append(", language=");
            sb.append(str2);
        }
        if (!g0Var.isEmpty()) {
            sb.append(", labels=[");
            new a6.d(String.valueOf(c9)).a(sb, g0Var.iterator());
            sb.append("]");
        }
        if (i10 != 0) {
            sb.append(", selectionFlags=[");
            a6.d dVar = new a6.d(String.valueOf(c9));
            int i23 = g1.w.f3713a;
            ArrayList arrayList = new ArrayList();
            if ((i10 & 4) != 0) {
                arrayList.add("auto");
            }
            if ((i10 & 1) != 0) {
                arrayList.add("default");
            }
            if ((i10 & 2) != 0) {
                arrayList.add("forced");
            }
            dVar.a(sb, arrayList.iterator());
            sb.append("]");
        }
        if (i9 != 0) {
            sb.append(", roleFlags=[");
            a6.d dVar2 = new a6.d(String.valueOf(c9));
            int i24 = g1.w.f3713a;
            ArrayList arrayList2 = new ArrayList();
            if ((i9 & 1) != 0) {
                arrayList2.add("main");
            }
            if ((i9 & 2) != 0) {
                arrayList2.add("alt");
            }
            if ((i9 & 4) != 0) {
                arrayList2.add("supplementary");
            }
            if ((i9 & 8) != 0) {
                arrayList2.add("commentary");
            }
            if ((i9 & 16) != 0) {
                arrayList2.add("dub");
            }
            if ((i9 & 32) != 0) {
                arrayList2.add("emergency");
            }
            if ((i9 & 64) != 0) {
                arrayList2.add("caption");
            }
            if ((i9 & 128) != 0) {
                arrayList2.add("subtitle");
            }
            if ((i9 & 256) != 0) {
                arrayList2.add("sign");
            }
            if ((i9 & IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED) != 0) {
                arrayList2.add("describes-video");
            }
            if ((i9 & 1024) != 0) {
                arrayList2.add("describes-music");
            }
            if ((i9 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0) {
                arrayList2.add("enhanced-intelligibility");
            }
            if ((i9 & 4096) != 0) {
                arrayList2.add("transcribes-dialog");
            }
            if ((i9 & 8192) != 0) {
                arrayList2.add("easy-read");
            }
            if ((i9 & 16384) != 0) {
                arrayList2.add("trick-play");
            }
            dVar2.a(sb, arrayList2.iterator());
            sb.append("]");
        }
        return sb.toString();
    }

    public final r a() {
        r rVar = new r();
        rVar.f2518a = this.f2543a;
        rVar.f2519b = this.f2544b;
        rVar.f2520c = this.f2545c;
        rVar.f2521d = this.f2546d;
        rVar.f2522e = this.f2547e;
        rVar.f2523f = this.f2548f;
        rVar.f2524g = this.f2549g;
        rVar.h = this.h;
        rVar.f2525i = this.f2551j;
        rVar.f2526j = this.f2552k;
        rVar.f2527k = this.f2553l;
        rVar.f2528l = this.f2554m;
        rVar.f2529m = this.f2555n;
        rVar.f2530n = this.f2556o;
        rVar.f2531o = this.f2557p;
        rVar.f2532p = this.f2558q;
        rVar.f2533q = this.f2559r;
        rVar.f2534r = this.f2560s;
        rVar.f2535s = this.f2561t;
        rVar.f2536t = this.f2562u;
        rVar.f2537u = this.f2563v;
        rVar.f2538v = this.f2564w;
        rVar.f2539w = this.f2565x;
        rVar.f2540x = this.f2566y;
        rVar.f2541y = this.f2567z;
        rVar.f2542z = this.A;
        rVar.A = this.B;
        rVar.B = this.C;
        rVar.C = this.D;
        rVar.D = this.E;
        rVar.E = this.F;
        rVar.F = this.G;
        rVar.G = this.H;
        rVar.H = this.I;
        return rVar;
    }

    public final boolean b(s sVar) {
        List list = this.f2556o;
        if (list.size() != sVar.f2556o.size()) {
            return false;
        }
        for (int i9 = 0; i9 < list.size(); i9++) {
            if (!Arrays.equals((byte[]) list.get(i9), (byte[]) sVar.f2556o.get(i9))) {
                return false;
            }
        }
        return true;
    }

    public final s d(s sVar) {
        String str;
        String str2;
        int i9;
        int i10;
        if (this == sVar) {
            return this;
        }
        int g9 = l0.g(this.f2554m);
        String str3 = sVar.f2543a;
        b6.g0 g0Var = sVar.f2545c;
        int i11 = sVar.G;
        int i12 = sVar.H;
        String str4 = sVar.f2544b;
        if (str4 == null) {
            str4 = this.f2544b;
        }
        if (g0Var.isEmpty()) {
            g0Var = this.f2545c;
        }
        if ((g9 != 3 && g9 != 1) || (str = sVar.f2546d) == null) {
            str = this.f2546d;
        }
        int i13 = this.f2549g;
        if (i13 == -1) {
            i13 = sVar.f2549g;
        }
        int i14 = this.h;
        if (i14 == -1) {
            i14 = sVar.h;
        }
        String str5 = this.f2551j;
        if (str5 == null) {
            String r8 = g1.w.r(g9, sVar.f2551j);
            if (g1.w.V(r8).length == 1) {
                str5 = r8;
            }
        }
        j0 j0Var = sVar.f2552k;
        j0 j0Var2 = this.f2552k;
        if (j0Var2 != null) {
            j0Var = j0Var2.e(j0Var);
        }
        float f9 = this.f2561t;
        if (f9 == -1.0f && g9 == 2) {
            f9 = sVar.f2561t;
        }
        int i15 = this.f2547e | sVar.f2547e;
        int i16 = this.f2548f | sVar.f2548f;
        n nVar = sVar.f2557p;
        ArrayList arrayList = new ArrayList();
        b6.g0 g0Var2 = g0Var;
        if (nVar != null) {
            String str6 = nVar.f2505k;
            m[] mVarArr = nVar.f2503i;
            int length = mVarArr.length;
            int i17 = 0;
            while (i17 < length) {
                int i18 = i17;
                m mVar = mVarArr[i18];
                int i19 = length;
                if (mVar.f2500m != null) {
                    arrayList.add(mVar);
                }
                i17 = i18 + 1;
                length = i19;
            }
            str2 = str6;
        } else {
            str2 = null;
        }
        n nVar2 = this.f2557p;
        if (nVar2 != null) {
            if (str2 == null) {
                str2 = nVar2.f2505k;
            }
            int size = arrayList.size();
            m[] mVarArr2 = nVar2.f2503i;
            String str7 = str2;
            int length2 = mVarArr2.length;
            int i20 = 0;
            while (i20 < length2) {
                int i21 = i20;
                m mVar2 = mVarArr2[i21];
                int i22 = length2;
                if (mVar2.f2500m != null) {
                    UUID uuid = mVar2.f2497j;
                    i10 = i12;
                    int i23 = 0;
                    while (true) {
                        if (i23 >= size) {
                            i9 = size;
                            arrayList.add(mVar2);
                            break;
                        }
                        i9 = size;
                        if (((m) arrayList.get(i23)).f2497j.equals(uuid)) {
                            break;
                        }
                        i23++;
                        size = i9;
                    }
                } else {
                    i9 = size;
                    i10 = i12;
                }
                i20 = i21 + 1;
                length2 = i22;
                i12 = i10;
                size = i9;
            }
            str2 = str7;
        }
        int i24 = i12;
        n nVar3 = arrayList.isEmpty() ? null : new n(str2, false, (m[]) arrayList.toArray(new m[0]));
        r a9 = a();
        a9.f2518a = str3;
        a9.f2519b = str4;
        a9.f2520c = b6.g0.m(g0Var2);
        a9.f2521d = str;
        a9.f2522e = i15;
        a9.f2523f = i16;
        a9.f2524g = i13;
        a9.h = i14;
        a9.f2525i = str5;
        a9.f2526j = j0Var;
        a9.f2531o = nVar3;
        a9.f2535s = f9;
        a9.F = i11;
        a9.G = i24;
        return new s(a9);
    }

    public final boolean equals(Object obj) {
        int i9;
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        int i10 = this.J;
        return (i10 == 0 || (i9 = sVar.J) == 0 || i10 == i9) && this.f2547e == sVar.f2547e && this.f2548f == sVar.f2548f && this.f2549g == sVar.f2549g && this.h == sVar.h && this.f2555n == sVar.f2555n && this.f2558q == sVar.f2558q && this.f2559r == sVar.f2559r && this.f2560s == sVar.f2560s && this.f2562u == sVar.f2562u && this.f2565x == sVar.f2565x && this.f2567z == sVar.f2567z && this.A == sVar.A && this.B == sVar.B && this.C == sVar.C && this.D == sVar.D && this.E == sVar.E && this.G == sVar.G && this.H == sVar.H && this.I == sVar.I && Float.compare(this.f2561t, sVar.f2561t) == 0 && Float.compare(this.f2563v, sVar.f2563v) == 0 && g1.w.a(this.f2543a, sVar.f2543a) && g1.w.a(this.f2544b, sVar.f2544b) && this.f2545c.equals(sVar.f2545c) && g1.w.a(this.f2551j, sVar.f2551j) && g1.w.a(this.f2553l, sVar.f2553l) && g1.w.a(this.f2554m, sVar.f2554m) && g1.w.a(this.f2546d, sVar.f2546d) && Arrays.equals(this.f2564w, sVar.f2564w) && g1.w.a(this.f2552k, sVar.f2552k) && g1.w.a(this.f2566y, sVar.f2566y) && g1.w.a(this.f2557p, sVar.f2557p) && b(sVar);
    }

    public final int hashCode() {
        if (this.J == 0) {
            String str = this.f2543a;
            int hashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f2544b;
            int hashCode2 = (this.f2545c.hashCode() + ((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31)) * 31;
            String str3 = this.f2546d;
            int hashCode3 = (((((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f2547e) * 31) + this.f2548f) * 31) + this.f2549g) * 31) + this.h) * 31;
            String str4 = this.f2551j;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            j0 j0Var = this.f2552k;
            int hashCode5 = (hashCode4 + (j0Var == null ? 0 : j0Var.hashCode())) * 31;
            String str5 = this.f2553l;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f2554m;
            this.J = ((((((((((((((((((((Float.floatToIntBits(this.f2563v) + ((((Float.floatToIntBits(this.f2561t) + ((((((((((hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.f2555n) * 31) + ((int) this.f2558q)) * 31) + this.f2559r) * 31) + this.f2560s) * 31)) * 31) + this.f2562u) * 31)) * 31) + this.f2565x) * 31) + this.f2567z) * 31) + this.A) * 31) + this.B) * 31) + this.C) * 31) + this.D) * 31) + this.E) * 31) + this.G) * 31) + this.H) * 31) + this.I;
        }
        return this.J;
    }

    public final String toString() {
        return "Format(" + this.f2543a + ", " + this.f2544b + ", " + this.f2553l + ", " + this.f2554m + ", " + this.f2551j + ", " + this.f2550i + ", " + this.f2546d + ", [" + this.f2559r + ", " + this.f2560s + ", " + this.f2561t + ", " + this.f2566y + "], [" + this.f2567z + ", " + this.A + "])";
    }
}
