package com.bumptech.glide;

import h4.q;
import h4.r;
import h4.s;
import h4.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final t f1773a;

    /* renamed from: b, reason: collision with root package name */
    public final p4.c f1774b;

    /* renamed from: c, reason: collision with root package name */
    public final m1.b f1775c;

    /* renamed from: d, reason: collision with root package name */
    public final p4.c f1776d;

    /* renamed from: e, reason: collision with root package name */
    public final com.bumptech.glide.load.data.i f1777e;

    /* renamed from: f, reason: collision with root package name */
    public final p4.c f1778f;

    /* renamed from: g, reason: collision with root package name */
    public final p4.c f1779g;
    public final m1.b h = new m1.b(16);

    /* renamed from: i, reason: collision with root package name */
    public final r4.b f1780i = new r4.b();

    /* renamed from: j, reason: collision with root package name */
    public final x.c f1781j;

    public i() {
        x.c cVar = new x.c(new m0.e(20), new o4.d(25), new o4.d(26));
        this.f1781j = cVar;
        this.f1773a = new t(cVar);
        this.f1774b = new p4.c(1);
        this.f1775c = new m1.b(17);
        this.f1776d = new p4.c(3);
        this.f1777e = new com.bumptech.glide.load.data.i();
        this.f1778f = new p4.c(0);
        this.f1779g = new p4.c(2);
        List asList = Arrays.asList("Animation", "Bitmap", "BitmapDrawable");
        ArrayList arrayList = new ArrayList(asList.size());
        arrayList.add("legacy_prepend_all");
        Iterator it = asList.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        arrayList.add("legacy_append");
        m1.b bVar = this.f1775c;
        synchronized (bVar) {
            try {
                ArrayList arrayList2 = new ArrayList((ArrayList) bVar.f6510j);
                ((ArrayList) bVar.f6510j).clear();
                int size = arrayList.size();
                int i9 = 0;
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((ArrayList) bVar.f6510j).add((String) obj);
                }
                int size2 = arrayList2.size();
                while (i9 < size2) {
                    Object obj2 = arrayList2.get(i9);
                    i9++;
                    String str = (String) obj2;
                    if (!arrayList.contains(str)) {
                        ((ArrayList) bVar.f6510j).add(str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(Class cls, b4.b bVar) {
        p4.c cVar = this.f1774b;
        synchronized (cVar) {
            cVar.f8251a.add(new r4.a(cls, bVar));
        }
    }

    public final void b(Class cls, b4.l lVar) {
        p4.c cVar = this.f1776d;
        synchronized (cVar) {
            cVar.f8251a.add(new r4.d(cls, lVar));
        }
    }

    public final void c(Class cls, Class cls2, r rVar) {
        t tVar = this.f1773a;
        synchronized (tVar) {
            tVar.f4004a.a(cls, cls2, rVar);
            tVar.f4005b.f1767a.clear();
        }
    }

    public final void d(String str, Class cls, Class cls2, b4.k kVar) {
        m1.b bVar = this.f1775c;
        synchronized (bVar) {
            bVar.k(str).add(new r4.c(cls, cls2, kVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ArrayList e(Class cls, Class cls2, Class cls3) {
        ArrayList arrayList;
        Class cls4 = cls;
        ArrayList arrayList2 = new ArrayList();
        ArrayList m9 = this.f1775c.m(cls4, cls2);
        int size = m9.size();
        int i9 = 0;
        while (i9 < size) {
            int i10 = i9 + 1;
            Class cls5 = (Class) m9.get(i9);
            ArrayList i11 = this.f1778f.i(cls5, cls3);
            int size2 = i11.size();
            int i12 = 0;
            while (i12 < size2) {
                int i13 = i12 + 1;
                Class cls6 = (Class) i11.get(i12);
                m1.b bVar = this.f1775c;
                synchronized (bVar) {
                    arrayList = new ArrayList();
                    ArrayList arrayList3 = (ArrayList) bVar.f6510j;
                    int size3 = arrayList3.size();
                    int i14 = 0;
                    while (i14 < size3) {
                        Object obj = arrayList3.get(i14);
                        i14++;
                        ArrayList arrayList4 = arrayList3;
                        String str = (String) obj;
                        int i15 = size3;
                        List list = (List) ((HashMap) bVar.f6511k).get(str);
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                r4.c cVar = (r4.c) it.next();
                                Iterator it2 = it;
                                if (cVar.f8552a.isAssignableFrom(cls4) && cls5.isAssignableFrom(cVar.f8553b)) {
                                    arrayList.add(cVar.f8554c);
                                }
                                it = it2;
                            }
                        }
                        size3 = i15;
                        arrayList3 = arrayList4;
                    }
                }
                arrayList2.add(new d4.l(cls4, cls5, cls6, arrayList, this.f1778f.g(cls5, cls6), this.f1781j));
                cls4 = cls;
                i12 = i13;
            }
            cls4 = cls;
            i9 = i10;
        }
        return arrayList2;
    }

    public final ArrayList f() {
        ArrayList arrayList;
        p4.c cVar = this.f1779g;
        synchronized (cVar) {
            arrayList = cVar.f8251a;
        }
        if (arrayList.isEmpty()) {
            throw new h("Failed to find image header parser.");
        }
        return arrayList;
    }

    public final List g(Object obj) {
        List list;
        t tVar = this.f1773a;
        tVar.getClass();
        Class<?> cls = obj.getClass();
        synchronized (tVar) {
            s sVar = (s) tVar.f4005b.f1767a.get(cls);
            list = sVar == null ? null : sVar.f4003a;
            if (list == null) {
                list = Collections.unmodifiableList(tVar.f4004a.c(cls));
                if (((s) tVar.f4005b.f1767a.put(cls, new s(list))) != null) {
                    throw new IllegalStateException("Already cached loaders for model: " + cls);
                }
            }
        }
        if (list.isEmpty()) {
            throw new h("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }
        int size = list.size();
        List list2 = Collections.EMPTY_LIST;
        boolean z8 = true;
        for (int i9 = 0; i9 < size; i9++) {
            q qVar = (q) list.get(i9);
            if (qVar.b(obj)) {
                if (z8) {
                    list2 = new ArrayList(size - i9);
                    z8 = false;
                }
                list2.add(qVar);
            }
        }
        if (!list2.isEmpty()) {
            return list2;
        }
        throw new h("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + obj);
    }

    public final com.bumptech.glide.load.data.g h(Object obj) {
        com.bumptech.glide.load.data.g b9;
        com.bumptech.glide.load.data.i iVar = this.f1777e;
        synchronized (iVar) {
            try {
                w4.f.b(obj);
                com.bumptech.glide.load.data.f fVar = (com.bumptech.glide.load.data.f) ((HashMap) iVar.f1801j).get(obj.getClass());
                if (fVar == null) {
                    Iterator it = ((HashMap) iVar.f1801j).values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.bumptech.glide.load.data.f fVar2 = (com.bumptech.glide.load.data.f) it.next();
                        if (fVar2.a().isAssignableFrom(obj.getClass())) {
                            fVar = fVar2;
                            break;
                        }
                    }
                }
                if (fVar == null) {
                    fVar = com.bumptech.glide.load.data.i.f1799k;
                }
                b9 = fVar.b(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        return b9;
    }

    public final void i(b4.e eVar) {
        p4.c cVar = this.f1779g;
        synchronized (cVar) {
            cVar.f8251a.add(eVar);
        }
    }

    public final void j(com.bumptech.glide.load.data.f fVar) {
        com.bumptech.glide.load.data.i iVar = this.f1777e;
        synchronized (iVar) {
            ((HashMap) iVar.f1801j).put(fVar.a(), fVar);
        }
    }

    public final void k(Class cls, Class cls2, p4.a aVar) {
        p4.c cVar = this.f1778f;
        synchronized (cVar) {
            cVar.f8251a.add(new p4.b(cls, cls2, aVar));
        }
    }
}
