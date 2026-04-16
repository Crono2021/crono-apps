package f3;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Pair;
import f1.h;
import g1.w;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f3321a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3322b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3323c;

    /* renamed from: d, reason: collision with root package name */
    public final long f3324d;

    /* renamed from: e, reason: collision with root package name */
    public final long f3325e;

    /* renamed from: f, reason: collision with root package name */
    public final g f3326f;

    /* renamed from: g, reason: collision with root package name */
    public final String[] f3327g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final String f3328i;

    /* renamed from: j, reason: collision with root package name */
    public final c f3329j;

    /* renamed from: k, reason: collision with root package name */
    public final HashMap f3330k;

    /* renamed from: l, reason: collision with root package name */
    public final HashMap f3331l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f3332m;

    public c(String str, String str2, long j5, long j9, g gVar, String[] strArr, String str3, String str4, c cVar) {
        this.f3321a = str;
        this.f3322b = str2;
        this.f3328i = str4;
        this.f3326f = gVar;
        this.f3327g = strArr;
        this.f3323c = str2 != null;
        this.f3324d = j5;
        this.f3325e = j9;
        str3.getClass();
        this.h = str3;
        this.f3329j = cVar;
        this.f3330k = new HashMap();
        this.f3331l = new HashMap();
    }

    public static c a(String str) {
        return new c(null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    public static SpannableStringBuilder e(String str, TreeMap treeMap) {
        if (!treeMap.containsKey(str)) {
            f1.a aVar = new f1.a();
            aVar.f3218a = new SpannableStringBuilder();
            treeMap.put(str, aVar);
        }
        CharSequence charSequence = ((f1.a) treeMap.get(str)).f3218a;
        charSequence.getClass();
        return (SpannableStringBuilder) charSequence;
    }

    public final c b(int i9) {
        ArrayList arrayList = this.f3332m;
        if (arrayList != null) {
            return (c) arrayList.get(i9);
        }
        throw new IndexOutOfBoundsException();
    }

    public final int c() {
        ArrayList arrayList = this.f3332m;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void d(TreeSet treeSet, boolean z8) {
        String str = this.f3321a;
        boolean equals = "p".equals(str);
        boolean equals2 = "div".equals(str);
        if (z8 || equals || (equals2 && this.f3328i != null)) {
            long j5 = this.f3324d;
            if (j5 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j5));
            }
            long j9 = this.f3325e;
            if (j9 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j9));
            }
        }
        if (this.f3332m == null) {
            return;
        }
        for (int i9 = 0; i9 < this.f3332m.size(); i9++) {
            ((c) this.f3332m.get(i9)).d(treeSet, z8 || equals);
        }
    }

    public final boolean f(long j5) {
        long j9 = this.f3325e;
        long j10 = this.f3324d;
        if (j10 == -9223372036854775807L && j9 == -9223372036854775807L) {
            return true;
        }
        if (j10 <= j5 && j9 == -9223372036854775807L) {
            return true;
        }
        if (j10 != -9223372036854775807L || j5 >= j9) {
            return j10 <= j5 && j5 < j9;
        }
        return true;
    }

    public final void g(long j5, String str, ArrayList arrayList) {
        String str2;
        String str3 = this.h;
        if (!"".equals(str3)) {
            str = str3;
        }
        if (f(j5) && "div".equals(this.f3321a) && (str2 = this.f3328i) != null) {
            arrayList.add(new Pair(str, str2));
            return;
        }
        for (int i9 = 0; i9 < c(); i9++) {
            b(i9).g(j5, str, arrayList);
        }
    }

    public final void h(long j5, Map map, HashMap hashMap, String str, TreeMap treeMap) {
        int i9;
        c cVar;
        g H;
        int i10;
        int i11;
        Map map2 = map;
        if (f(j5)) {
            String str2 = this.h;
            String str3 = "".equals(str2) ? str : str2;
            for (Map.Entry entry : this.f3331l.entrySet()) {
                String str4 = (String) entry.getKey();
                HashMap hashMap2 = this.f3330k;
                int intValue = hashMap2.containsKey(str4) ? ((Integer) hashMap2.get(str4)).intValue() : 0;
                int intValue2 = ((Integer) entry.getValue()).intValue();
                if (intValue != intValue2) {
                    f1.a aVar = (f1.a) treeMap.get(str4);
                    aVar.getClass();
                    f fVar = (f) hashMap.get(str3);
                    fVar.getClass();
                    int i12 = fVar.f3353j;
                    g H2 = a.a.H(this.f3326f, this.f3327g, map2);
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) aVar.f3218a;
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        aVar.f3218a = spannableStringBuilder;
                    }
                    if (H2 != null) {
                        int i13 = H2.h;
                        int i14 = 1;
                        if (((i13 == -1 && H2.f3361i == -1) ? -1 : (i13 == 1 ? (char) 1 : (char) 0) | (H2.f3361i == 1 ? (char) 2 : (char) 0)) != -1) {
                            int i15 = H2.h;
                            if (i15 == -1) {
                                if (H2.f3361i == -1) {
                                    i14 = 1;
                                    i11 = -1;
                                    StyleSpan styleSpan = new StyleSpan(i11);
                                    i9 = 33;
                                    spannableStringBuilder.setSpan(styleSpan, intValue, intValue2, 33);
                                } else {
                                    i14 = 1;
                                }
                            }
                            i11 = (i15 == i14 ? 1 : 0) | (H2.f3361i == i14 ? 2 : 0);
                            StyleSpan styleSpan2 = new StyleSpan(i11);
                            i9 = 33;
                            spannableStringBuilder.setSpan(styleSpan2, intValue, intValue2, 33);
                        } else {
                            i9 = 33;
                        }
                        if (H2.f3359f == i14) {
                            spannableStringBuilder.setSpan(new StrikethroughSpan(), intValue, intValue2, i9);
                        }
                        if (H2.f3360g == i14) {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), intValue, intValue2, i9);
                        }
                        if (H2.f3356c) {
                            if (!H2.f3356c) {
                                m7.c.p("Font color has not been defined.");
                                return;
                            }
                            com.bumptech.glide.d.b(spannableStringBuilder, new ForegroundColorSpan(H2.f3355b), intValue, intValue2);
                        }
                        if (H2.f3358e) {
                            if (!H2.f3358e) {
                                m7.c.p("Background color has not been defined.");
                                return;
                            }
                            com.bumptech.glide.d.b(spannableStringBuilder, new BackgroundColorSpan(H2.f3357d), intValue, intValue2);
                        }
                        if (H2.f3354a != null) {
                            com.bumptech.glide.d.b(spannableStringBuilder, new TypefaceSpan(H2.f3354a), intValue, intValue2);
                        }
                        b bVar = H2.f3370r;
                        if (bVar != null) {
                            int i16 = bVar.f3318a;
                            if (i16 == -1) {
                                i16 = (i12 == 2 || i12 == 1) ? 3 : 1;
                                i10 = 1;
                            } else {
                                i10 = bVar.f3319b;
                            }
                            int i17 = bVar.f3320c;
                            if (i17 == -2) {
                                i17 = 1;
                            }
                            com.bumptech.glide.d.b(spannableStringBuilder, new h(i16, i10, i17), intValue, intValue2);
                        }
                        int i18 = H2.f3365m;
                        if (i18 == 2) {
                            c cVar2 = this.f3329j;
                            while (true) {
                                if (cVar2 == null) {
                                    cVar2 = null;
                                    break;
                                }
                                g H3 = a.a.H(cVar2.f3326f, cVar2.f3327g, map2);
                                if (H3 != null && H3.f3365m == 1) {
                                    break;
                                } else {
                                    cVar2 = cVar2.f3329j;
                                }
                            }
                            if (cVar2 != null) {
                                ArrayDeque arrayDeque = new ArrayDeque();
                                arrayDeque.push(cVar2);
                                while (true) {
                                    if (arrayDeque.isEmpty()) {
                                        cVar = null;
                                        break;
                                    }
                                    c cVar3 = (c) arrayDeque.pop();
                                    g H4 = a.a.H(cVar3.f3326f, cVar3.f3327g, map2);
                                    if (H4 != null && H4.f3365m == 3) {
                                        cVar = cVar3;
                                        break;
                                    }
                                    for (int c9 = cVar3.c() - 1; c9 >= 0; c9--) {
                                        arrayDeque.push(cVar3.b(c9));
                                    }
                                }
                                if (cVar != null) {
                                    if (cVar.c() != 1 || cVar.b(0).f3322b == null) {
                                        g1.a.v("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                                    } else {
                                        String str5 = cVar.b(0).f3322b;
                                        int i19 = w.f3713a;
                                        g H5 = a.a.H(cVar.f3326f, cVar.f3327g, map2);
                                        int i20 = H5 != null ? H5.f3366n : -1;
                                        if (i20 == -1 && (H = a.a.H(cVar2.f3326f, cVar2.f3327g, map2)) != null) {
                                            i20 = H.f3366n;
                                        }
                                        spannableStringBuilder.setSpan(new f1.g(str5, i20), intValue, intValue2, 33);
                                    }
                                }
                            }
                        } else if (i18 == 3 || i18 == 4) {
                            spannableStringBuilder.setSpan(new a(), intValue, intValue2, 33);
                        }
                        if (H2.f3369q == 1) {
                            com.bumptech.glide.d.b(spannableStringBuilder, new f1.e(), intValue, intValue2);
                        }
                        int i21 = H2.f3362j;
                        if (i21 == 1) {
                            com.bumptech.glide.d.b(spannableStringBuilder, new AbsoluteSizeSpan((int) H2.f3363k, true), intValue, intValue2);
                        } else if (i21 == 2) {
                            com.bumptech.glide.d.b(spannableStringBuilder, new RelativeSizeSpan(H2.f3363k), intValue, intValue2);
                        } else if (i21 == 3) {
                            com.bumptech.glide.d.b(spannableStringBuilder, new RelativeSizeSpan(H2.f3363k / 100.0f), intValue, intValue2);
                        }
                        if ("p".equals(this.f3321a)) {
                            float f9 = H2.f3371s;
                            if (f9 != Float.MAX_VALUE) {
                                aVar.f3233q = (f9 * (-90.0f)) / 100.0f;
                            }
                            Layout.Alignment alignment = H2.f3367o;
                            if (alignment != null) {
                                aVar.f3220c = alignment;
                            }
                            Layout.Alignment alignment2 = H2.f3368p;
                            if (alignment2 != null) {
                                aVar.f3221d = alignment2;
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
            int i22 = 0;
            while (i22 < c()) {
                b(i22).h(j5, map2, hashMap, str3, treeMap);
                i22++;
                map2 = map;
            }
        }
    }

    public final void i(long j5, boolean z8, String str, TreeMap treeMap) {
        HashMap hashMap = this.f3330k;
        hashMap.clear();
        HashMap hashMap2 = this.f3331l;
        hashMap2.clear();
        String str2 = this.f3321a;
        if ("metadata".equals(str2)) {
            return;
        }
        String str3 = this.h;
        String str4 = "".equals(str3) ? str : str3;
        if (this.f3323c && z8) {
            SpannableStringBuilder e9 = e(str4, treeMap);
            String str5 = this.f3322b;
            str5.getClass();
            e9.append((CharSequence) str5);
            return;
        }
        if ("br".equals(str2) && z8) {
            e(str4, treeMap).append('\n');
            return;
        }
        if (f(j5)) {
            for (Map.Entry entry : treeMap.entrySet()) {
                String str6 = (String) entry.getKey();
                CharSequence charSequence = ((f1.a) entry.getValue()).f3218a;
                charSequence.getClass();
                hashMap.put(str6, Integer.valueOf(charSequence.length()));
            }
            boolean equals = "p".equals(str2);
            for (int i9 = 0; i9 < c(); i9++) {
                b(i9).i(j5, z8 || equals, str4, treeMap);
            }
            if (equals) {
                SpannableStringBuilder e10 = e(str4, treeMap);
                int length = e10.length() - 1;
                while (length >= 0 && e10.charAt(length) == ' ') {
                    length--;
                }
                if (length >= 0 && e10.charAt(length) != '\n') {
                    e10.append('\n');
                }
            }
            for (Map.Entry entry2 : treeMap.entrySet()) {
                String str7 = (String) entry2.getKey();
                CharSequence charSequence2 = ((f1.a) entry2.getValue()).f3218a;
                charSequence2.getClass();
                hashMap2.put(str7, Integer.valueOf(charSequence2.length()));
            }
        }
    }
}
