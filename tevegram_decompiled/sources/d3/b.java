package d3;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.activity.g;
import com.network.tvgramplayer.voip.VoIPController;
import g1.p;
import g1.w;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import z2.f;
import z2.k;
import z2.l;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements l {

    /* renamed from: o, reason: collision with root package name */
    public static final Pattern f2763o = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* renamed from: i, reason: collision with root package name */
    public final boolean f2764i;

    /* renamed from: j, reason: collision with root package name */
    public final a f2765j;

    /* renamed from: l, reason: collision with root package name */
    public LinkedHashMap f2767l;

    /* renamed from: m, reason: collision with root package name */
    public float f2768m = -3.4028235E38f;

    /* renamed from: n, reason: collision with root package name */
    public float f2769n = -3.4028235E38f;

    /* renamed from: k, reason: collision with root package name */
    public final p f2766k = new p();

    public b(List list) {
        if (list == null || list.isEmpty()) {
            this.f2764i = false;
            this.f2765j = null;
            return;
        }
        this.f2764i = true;
        String m9 = w.m((byte[]) list.get(0));
        g1.a.f(m9.startsWith("Format:"));
        a b9 = a.b(m9);
        b9.getClass();
        this.f2765j = b9;
        b(new p((byte[]) list.get(1)), a6.b.f203c);
    }

    public static int a(long j5, ArrayList arrayList, ArrayList arrayList2) {
        int i9;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i9 = 0;
                break;
            }
            if (((Long) arrayList.get(size)).longValue() == j5) {
                return size;
            }
            if (((Long) arrayList.get(size)).longValue() < j5) {
                i9 = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i9, Long.valueOf(j5));
        arrayList2.add(i9, i9 == 0 ? new ArrayList() : new ArrayList((Collection) arrayList2.get(i9 - 1)));
        return i9;
    }

    public static long c(String str) {
        Matcher matcher = f2763o.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String group = matcher.group(1);
        int i9 = w.f3713a;
        return (Long.parseLong(matcher.group(4)) * 10000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(2)) * 60000000) + (Long.parseLong(group) * 3600000000L);
    }

    @Override // z2.l
    public final void a0(byte[] bArr, int i9, int i10, k kVar, g1.c cVar) {
        Charset charset;
        long j5;
        p pVar;
        a aVar;
        float f9;
        int i11;
        int i12;
        int i13;
        int i14;
        float f10;
        Layout.Alignment alignment;
        PointF pointF;
        int i15;
        int i16;
        float f11;
        float f12;
        float f13;
        boolean z8;
        int i17;
        int i18;
        float f14;
        int i19;
        float f15;
        int i20;
        int i21;
        int i22;
        int i23;
        b bVar = this;
        long j9 = kVar.f10621a;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        p pVar2 = bVar.f2766k;
        pVar2.D(bArr, i9 + i10);
        pVar2.F(i9);
        Charset B = pVar2.B();
        if (B == null) {
            B = a6.b.f203c;
        }
        boolean z9 = bVar.f2764i;
        if (!z9) {
            bVar.b(pVar2, B);
        }
        a aVar2 = z9 ? bVar.f2765j : null;
        while (true) {
            String h = pVar2.h(B);
            if (h == null) {
                long j10 = j9;
                ArrayList arrayList3 = (j10 == -9223372036854775807L || !kVar.f10622b) ? null : new ArrayList();
                int i24 = 0;
                for (int i25 = 0; i25 < arrayList.size(); i25++) {
                    List list = (List) arrayList.get(i25);
                    if (!list.isEmpty() || i25 == 0) {
                        if (i25 == arrayList.size() - 1) {
                            androidx.fragment.app.a.l();
                            return;
                        }
                        long longValue = ((Long) arrayList2.get(i25)).longValue();
                        long longValue2 = ((Long) arrayList2.get(i25 + 1)).longValue() - ((Long) arrayList2.get(i25)).longValue();
                        if (j10 == -9223372036854775807L || longValue >= j10) {
                            cVar.accept(new z2.a(longValue, longValue2, list));
                        } else if (arrayList3 != null) {
                            arrayList3.add(new z2.a(longValue, longValue2, list));
                        }
                    }
                }
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    while (i24 < size) {
                        Object obj = arrayList3.get(i24);
                        i24++;
                        cVar.accept((z2.a) obj);
                    }
                    return;
                }
                return;
            }
            if (h.startsWith("Format:")) {
                aVar2 = a.b(h);
            } else {
                if (h.startsWith("Dialogue:")) {
                    if (aVar2 == null) {
                        g1.a.D("SsaParser", "Skipping dialogue line before complete format: ".concat(h));
                    } else {
                        int i26 = aVar2.f2762e;
                        g1.a.f(h.startsWith("Dialogue:"));
                        String[] split = h.substring(9).split(",", i26);
                        if (split.length != i26) {
                            g1.a.D("SsaParser", "Skipping dialogue line with fewer columns than format: ".concat(h));
                        } else {
                            long c9 = c(split[aVar2.f2758a]);
                            if (c9 == -9223372036854775807L) {
                                g1.a.D("SsaParser", "Skipping invalid timing: ".concat(h));
                            } else {
                                charset = B;
                                j5 = j9;
                                long c10 = c(split[aVar2.f2759b]);
                                if (c10 == -9223372036854775807L) {
                                    g1.a.D("SsaParser", "Skipping invalid timing: ".concat(h));
                                    aVar = aVar2;
                                    pVar = pVar2;
                                    bVar = this;
                                    B = charset;
                                    j9 = j5;
                                    aVar2 = aVar;
                                    pVar2 = pVar;
                                } else {
                                    LinkedHashMap linkedHashMap = bVar.f2767l;
                                    e eVar = (linkedHashMap == null || (i23 = aVar2.f2760c) == -1) ? null : (e) linkedHashMap.get(split[i23].trim());
                                    String str = split[aVar2.f2761d];
                                    Matcher matcher = d.f2780a.matcher(str);
                                    int i27 = -1;
                                    PointF pointF2 = null;
                                    while (matcher.find()) {
                                        a aVar3 = aVar2;
                                        String group = matcher.group(1);
                                        group.getClass();
                                        try {
                                            PointF a9 = d.a(group);
                                            if (a9 != null) {
                                                pointF2 = a9;
                                            }
                                        } catch (RuntimeException unused) {
                                        }
                                        try {
                                            Matcher matcher2 = d.f2783d.matcher(group);
                                            if (matcher2.find()) {
                                                String group2 = matcher2.group(1);
                                                group2.getClass();
                                                i22 = e.a(group2);
                                            } else {
                                                i22 = -1;
                                            }
                                            if (i22 != -1) {
                                                i27 = i22;
                                            }
                                        } catch (RuntimeException unused2) {
                                        }
                                        aVar2 = aVar3;
                                    }
                                    aVar = aVar2;
                                    String replace = d.f2780a.matcher(str).replaceAll("").replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                    float f16 = bVar.f2768m;
                                    float f17 = bVar.f2769n;
                                    SpannableString spannableString = new SpannableString(replace);
                                    if (eVar != null) {
                                        boolean z10 = eVar.f2790g;
                                        Integer num = eVar.f2787d;
                                        Integer num2 = eVar.f2786c;
                                        if (num2 != null) {
                                            z8 = z10;
                                            pVar = pVar2;
                                            f9 = f16;
                                            i17 = 33;
                                            i18 = 0;
                                            spannableString.setSpan(new ForegroundColorSpan(num2.intValue()), 0, spannableString.length(), 33);
                                        } else {
                                            z8 = z10;
                                            pVar = pVar2;
                                            f9 = f16;
                                            i17 = 33;
                                            i18 = 0;
                                        }
                                        if (eVar.f2792j == 3 && num != null) {
                                            spannableString.setSpan(new BackgroundColorSpan(num.intValue()), i18, spannableString.length(), i17);
                                        }
                                        float f18 = eVar.f2788e;
                                        if (f18 == -3.4028235E38f || f17 == -3.4028235E38f) {
                                            f14 = -3.4028235E38f;
                                            i19 = Integer.MIN_VALUE;
                                        } else {
                                            f14 = f18 / f17;
                                            i19 = 1;
                                        }
                                        boolean z11 = eVar.f2789f;
                                        if (z11 && z8) {
                                            f15 = f14;
                                            i20 = i19;
                                            i21 = 33;
                                            i11 = 0;
                                            spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
                                        } else {
                                            f15 = f14;
                                            i20 = i19;
                                            i21 = 33;
                                            i11 = 0;
                                            if (z11) {
                                                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                                            } else if (z8) {
                                                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
                                            }
                                        }
                                        if (eVar.h) {
                                            spannableString.setSpan(new UnderlineSpan(), i11, spannableString.length(), i21);
                                        }
                                        if (eVar.f2791i) {
                                            spannableString.setSpan(new StrikethroughSpan(), i11, spannableString.length(), i21);
                                        }
                                        i12 = i27;
                                        f10 = f15;
                                        i14 = i20;
                                        i13 = -1;
                                    } else {
                                        pVar = pVar2;
                                        f9 = f16;
                                        i11 = 0;
                                        i12 = i27;
                                        i13 = -1;
                                        i14 = Integer.MIN_VALUE;
                                        f10 = -3.4028235E38f;
                                    }
                                    if (i12 == i13) {
                                        i12 = eVar != null ? eVar.f2785b : -1;
                                    }
                                    switch (i12) {
                                        case 0:
                                        default:
                                            g.t(i12, "Unknown alignment: ", "SsaParser");
                                        case VoIPController.ERROR_PEER_OUTDATED /* -1 */:
                                            alignment = null;
                                            break;
                                        case 1:
                                        case 4:
                                        case 7:
                                            alignment = Layout.Alignment.ALIGN_NORMAL;
                                            break;
                                        case 2:
                                        case 5:
                                        case 8:
                                            alignment = Layout.Alignment.ALIGN_CENTER;
                                            break;
                                        case 3:
                                        case 6:
                                        case 9:
                                            alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                            break;
                                    }
                                    int i28 = Integer.MIN_VALUE;
                                    switch (i12) {
                                        case 0:
                                        default:
                                            g.t(i12, "Unknown alignment: ", "SsaParser");
                                        case VoIPController.ERROR_PEER_OUTDATED /* -1 */:
                                            i11 = Integer.MIN_VALUE;
                                            break;
                                        case 1:
                                        case 4:
                                        case 7:
                                            break;
                                        case 2:
                                        case 5:
                                        case 8:
                                            i11 = 1;
                                            break;
                                        case 3:
                                        case 6:
                                        case 9:
                                            i11 = 2;
                                            break;
                                    }
                                    switch (i12) {
                                        case 0:
                                        default:
                                            g.t(i12, "Unknown alignment: ", "SsaParser");
                                        case VoIPController.ERROR_PEER_OUTDATED /* -1 */:
                                            pointF = pointF2;
                                            break;
                                        case 1:
                                        case 2:
                                        case 3:
                                            pointF = pointF2;
                                            i28 = 2;
                                            break;
                                        case 4:
                                        case 5:
                                        case 6:
                                            pointF = pointF2;
                                            i28 = 1;
                                            break;
                                        case 7:
                                        case 8:
                                        case 9:
                                            pointF = pointF2;
                                            i28 = 0;
                                            break;
                                    }
                                    if (pointF == null || f17 == -3.4028235E38f || f9 == -3.4028235E38f) {
                                        float f19 = 0.5f;
                                        if (i11 != 0) {
                                            i16 = 1;
                                            if (i11 != 1) {
                                                i15 = 2;
                                                f11 = i11 != 2 ? -3.4028235E38f : 0.95f;
                                            } else {
                                                i15 = 2;
                                                f11 = 0.5f;
                                            }
                                        } else {
                                            i15 = 2;
                                            i16 = 1;
                                            f11 = 0.05f;
                                        }
                                        if (i28 == 0) {
                                            f19 = 0.05f;
                                        } else if (i28 != i16) {
                                            f19 = i28 != i15 ? -3.4028235E38f : 0.95f;
                                        }
                                        f12 = f19;
                                        f13 = f11;
                                    } else {
                                        float f20 = pointF.x / f9;
                                        f12 = pointF.y / f17;
                                        f13 = f20;
                                    }
                                    f1.b bVar2 = new f1.b(spannableString, alignment, null, null, f12, 0, i28, f13, i11, i14, f10, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, 0.0f);
                                    int a10 = a(c10, arrayList2, arrayList);
                                    for (int a11 = a(c9, arrayList2, arrayList); a11 < a10; a11++) {
                                        ((List) arrayList.get(a11)).add(bVar2);
                                    }
                                    bVar = this;
                                    B = charset;
                                    j9 = j5;
                                    aVar2 = aVar;
                                    pVar2 = pVar;
                                }
                            }
                        }
                    }
                }
                charset = B;
                j5 = j9;
                aVar = aVar2;
                pVar = pVar2;
                bVar = this;
                B = charset;
                j9 = j5;
                aVar2 = aVar;
                pVar2 = pVar;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(g1.p r29, java.nio.charset.Charset r30) {
        /*
            Method dump skipped, instructions count: 830
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d3.b.b(g1.p, java.nio.charset.Charset):void");
    }

    @Override // z2.l
    public final /* synthetic */ f h0(int i9, int i10, byte[] bArr) {
        return t.a.a(this, bArr, i10);
    }

    @Override // z2.l
    public final /* synthetic */ void reset() {
    }
}
