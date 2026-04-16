package c7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.chip.ChipGroup;
import g1.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements z2.f {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1641i = 0;

    /* renamed from: j, reason: collision with root package name */
    public final Object f1642j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f1643k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f1644l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f1645m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f1646n;

    public a(f3.c cVar, HashMap hashMap, HashMap hashMap2, HashMap hashMap3) {
        this.f1642j = cVar;
        this.f1645m = hashMap2;
        this.f1646n = hashMap3;
        this.f1644l = Collections.unmodifiableMap(hashMap);
        TreeSet treeSet = new TreeSet();
        int i9 = 0;
        cVar.d(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i9] = ((Long) it.next()).longValue();
            i9++;
        }
        this.f1643k = jArr;
    }

    @Override // z2.f
    public int g(long j5) {
        long[] jArr = (long[]) this.f1643k;
        int b9 = w.b(j5, jArr, false);
        if (b9 < jArr.length) {
            return b9;
        }
        return -1;
    }

    @Override // z2.f
    public long j(int i9) {
        return ((long[]) this.f1643k)[i9];
    }

    @Override // z2.f
    public List q(long j5) {
        f3.c cVar = (f3.c) this.f1642j;
        Map map = (Map) this.f1644l;
        HashMap hashMap = (HashMap) this.f1645m;
        HashMap hashMap2 = (HashMap) this.f1646n;
        ArrayList arrayList = new ArrayList();
        cVar.g(j5, cVar.h, arrayList);
        TreeMap treeMap = new TreeMap();
        cVar.i(j5, false, cVar.h, treeMap);
        cVar.h(j5, map, hashMap, cVar.h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            Pair pair = (Pair) obj;
            String str = (String) hashMap2.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                f3.f fVar = (f3.f) hashMap.get(pair.first);
                fVar.getClass();
                arrayList2.add(new f1.b(null, null, null, decodeByteArray, fVar.f3347c, 0, fVar.f3349e, fVar.f3346b, 0, Integer.MIN_VALUE, -3.4028235E38f, fVar.f3350f, fVar.f3351g, false, -16777216, fVar.f3353j, 0.0f));
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            f3.f fVar2 = (f3.f) hashMap.get(entry.getKey());
            fVar2.getClass();
            f1.a aVar = (f1.a) entry.getValue();
            CharSequence charSequence = aVar.f3218a;
            charSequence.getClass();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequence;
            for (f3.a aVar2 : (f3.a[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), f3.a.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(aVar2), spannableStringBuilder.getSpanEnd(aVar2), (CharSequence) "");
            }
            for (int i10 = 0; i10 < spannableStringBuilder.length(); i10++) {
                if (spannableStringBuilder.charAt(i10) == ' ') {
                    int i11 = i10 + 1;
                    int i12 = i11;
                    while (i12 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i12) == ' ') {
                        i12++;
                    }
                    int i13 = i12 - i11;
                    if (i13 > 0) {
                        spannableStringBuilder.delete(i10, i13 + i10);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            for (int i14 = 0; i14 < spannableStringBuilder.length() - 1; i14++) {
                if (spannableStringBuilder.charAt(i14) == '\n') {
                    int i15 = i14 + 1;
                    if (spannableStringBuilder.charAt(i15) == ' ') {
                        spannableStringBuilder.delete(i15, i14 + 2);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            for (int i16 = 0; i16 < spannableStringBuilder.length() - 1; i16++) {
                if (spannableStringBuilder.charAt(i16) == ' ') {
                    int i17 = i16 + 1;
                    if (spannableStringBuilder.charAt(i17) == '\n') {
                        spannableStringBuilder.delete(i16, i17);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            float f9 = fVar2.f3347c;
            int i18 = fVar2.f3348d;
            aVar.f3222e = f9;
            aVar.f3223f = i18;
            aVar.f3224g = fVar2.f3349e;
            aVar.h = fVar2.f3346b;
            aVar.f3228l = fVar2.f3350f;
            float f10 = fVar2.f3352i;
            int i19 = fVar2.h;
            aVar.f3227k = f10;
            aVar.f3226j = i19;
            aVar.f3232p = fVar2.f3353j;
            arrayList2.add(aVar.a());
        }
        return arrayList2;
    }

    public String toString() {
        switch (this.f1641i) {
            case 2:
                List list = (List) this.f1645m;
                StringBuilder sb = new StringBuilder();
                sb.append("FontRequest {mProviderAuthority: " + ((String) this.f1642j) + ", mProviderPackage: " + ((String) this.f1643k) + ", mQuery: " + ((String) this.f1644l) + ", mCertificates:");
                for (int i9 = 0; i9 < list.size(); i9++) {
                    sb.append(" [");
                    List list2 = (List) list.get(i9);
                    for (int i10 = 0; i10 < list2.size(); i10++) {
                        sb.append(" \"");
                        sb.append(Base64.encodeToString((byte[]) list2.get(i10), 0));
                        sb.append("\"");
                    }
                    sb.append(" ]");
                }
                sb.append("}mCertificatesArray: 0");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    @Override // z2.f
    public int u() {
        return ((long[]) this.f1643k).length;
    }

    public a(String str, String str2, String str3, List list) {
        str.getClass();
        this.f1642j = str;
        str2.getClass();
        this.f1643k = str2;
        this.f1644l = str3;
        list.getClass();
        this.f1645m = list;
        this.f1646n = str + "-" + str2 + "-" + str3;
    }

    public a(CoordinatorLayout coordinatorLayout, ChipGroup chipGroup, ProgressBar progressBar, RecyclerView recyclerView, MaterialToolbar materialToolbar, TextView textView) {
        this.f1642j = chipGroup;
        this.f1643k = progressBar;
        this.f1644l = recyclerView;
        this.f1645m = materialToolbar;
        this.f1646n = textView;
    }
}
