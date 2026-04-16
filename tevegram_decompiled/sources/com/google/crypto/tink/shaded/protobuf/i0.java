package com.google.crypto.tink.shaded.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i0 extends k0 {

    /* renamed from: c, reason: collision with root package name */
    public static final Class f2246c = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    public static List d(int i9, long j5, Object obj) {
        List list = (List) p1.f2286c.i(j5, obj);
        if (list.isEmpty()) {
            List g0Var = list instanceof h0 ? new g0(i9) : ((list instanceof z0) && (list instanceof b0)) ? ((b0) list).a(i9) : new ArrayList(i9);
            p1.p(j5, obj, g0Var);
            return g0Var;
        }
        if (f2246c.isAssignableFrom(list.getClass())) {
            ArrayList arrayList = new ArrayList(list.size() + i9);
            arrayList.addAll(list);
            p1.p(j5, obj, arrayList);
            return arrayList;
        }
        if (list instanceof k1) {
            g0 g0Var2 = new g0(list.size() + i9);
            g0Var2.addAll((k1) list);
            p1.p(j5, obj, g0Var2);
            return g0Var2;
        }
        if ((list instanceof z0) && (list instanceof b0)) {
            b0 b0Var = (b0) list;
            if (!((b) b0Var).f2201i) {
                b0 a9 = b0Var.a(list.size() + i9);
                p1.p(j5, obj, a9);
                return a9;
            }
        }
        return list;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.k0
    public final void a(long j5, Object obj) {
        Object unmodifiableList;
        List list = (List) p1.f2286c.i(j5, obj);
        if (list instanceof h0) {
            unmodifiableList = ((h0) list).c();
        } else {
            if (f2246c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof z0) && (list instanceof b0)) {
                b bVar = (b) ((b0) list);
                if (bVar.f2201i) {
                    bVar.f2201i = false;
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        p1.p(j5, obj, unmodifiableList);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.k0
    public final void b(long j5, Object obj, Object obj2) {
        List list = (List) p1.f2286c.i(j5, obj2);
        List d9 = d(list.size(), j5, obj);
        int size = d9.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            d9.addAll(list);
        }
        if (size > 0) {
            list = d9;
        }
        p1.p(j5, obj, list);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.k0
    public final List c(long j5, Object obj) {
        return d(10, j5, obj);
    }
}
