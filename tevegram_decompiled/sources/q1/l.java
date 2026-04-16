package q1;

import android.net.Uri;
import d1.s;
import d1.u0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l extends m {

    /* renamed from: l, reason: collision with root package name */
    public static final l f8384l;

    /* renamed from: d, reason: collision with root package name */
    public final List f8385d;

    /* renamed from: e, reason: collision with root package name */
    public final List f8386e;

    /* renamed from: f, reason: collision with root package name */
    public final List f8387f;

    /* renamed from: g, reason: collision with root package name */
    public final List f8388g;
    public final s h;

    /* renamed from: i, reason: collision with root package name */
    public final List f8389i;

    /* renamed from: j, reason: collision with root package name */
    public final Map f8390j;

    /* renamed from: k, reason: collision with root package name */
    public final List f8391k;

    static {
        List list = Collections.EMPTY_LIST;
        f8384l = new l("", list, list, list, list, list, list, null, list, false, Collections.EMPTY_MAP, list);
    }

    public l(String str, List list, List list2, List list3, List list4, List list5, List list6, s sVar, List list7, boolean z8, Map map, List list8) {
        super(str, list, z8);
        ArrayList arrayList = new ArrayList();
        for (int i9 = 0; i9 < list2.size(); i9++) {
            Uri uri = ((k) list2.get(i9)).f8378a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        b(list3, arrayList);
        b(list4, arrayList);
        b(list5, arrayList);
        b(list6, arrayList);
        this.f8385d = Collections.unmodifiableList(arrayList);
        this.f8386e = Collections.unmodifiableList(list2);
        Collections.unmodifiableList(list3);
        this.f8387f = Collections.unmodifiableList(list4);
        this.f8388g = Collections.unmodifiableList(list5);
        Collections.unmodifiableList(list6);
        this.h = sVar;
        this.f8389i = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.f8390j = Collections.unmodifiableMap(map);
        this.f8391k = Collections.unmodifiableList(list8);
    }

    public static void b(List list, ArrayList arrayList) {
        for (int i9 = 0; i9 < list.size(); i9++) {
            Uri uri = ((j) list.get(i9)).f8375a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
    }

    public static ArrayList c(List list, int i9, List list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            Object obj = list.get(i10);
            int i11 = 0;
            while (true) {
                if (i11 < list2.size()) {
                    u0 u0Var = (u0) list2.get(i11);
                    if (u0Var.f2579j == i9 && u0Var.f2580k == i10) {
                        arrayList.add(obj);
                        break;
                    }
                    i11++;
                }
            }
        }
        return arrayList;
    }

    @Override // q1.m
    public final Object a(List list) {
        ArrayList c9 = c(this.f8386e, 0, list);
        List list2 = Collections.EMPTY_LIST;
        return new l(this.f8392a, this.f8393b, c9, list2, c(this.f8387f, 1, list), c(this.f8388g, 2, list), list2, this.h, this.f8389i, this.f8394c, this.f8390j, this.f8391k);
    }
}
