package d4;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b0 implements g, com.bumptech.glide.load.data.d {

    /* renamed from: i, reason: collision with root package name */
    public final k f2797i;

    /* renamed from: j, reason: collision with root package name */
    public final h f2798j;

    /* renamed from: k, reason: collision with root package name */
    public int f2799k;

    /* renamed from: l, reason: collision with root package name */
    public int f2800l = -1;

    /* renamed from: m, reason: collision with root package name */
    public b4.f f2801m;

    /* renamed from: n, reason: collision with root package name */
    public List f2802n;

    /* renamed from: o, reason: collision with root package name */
    public int f2803o;

    /* renamed from: p, reason: collision with root package name */
    public volatile h4.p f2804p;

    /* renamed from: q, reason: collision with root package name */
    public File f2805q;

    /* renamed from: r, reason: collision with root package name */
    public c0 f2806r;

    public b0(h hVar, k kVar) {
        this.f2798j = hVar;
        this.f2797i = kVar;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void K(Object obj) {
        this.f2797i.a(this.f2801m, obj, this.f2804p.f4002c, 4, this.f2806r);
    }

    @Override // d4.g
    public final boolean b() {
        List list;
        boolean z8;
        List list2;
        ArrayList a9 = this.f2798j.a();
        if (a9.isEmpty()) {
            return false;
        }
        h hVar = this.f2798j;
        com.bumptech.glide.i b9 = hVar.f2836c.b();
        Class<?> cls = hVar.f2837d.getClass();
        Class cls2 = hVar.f2840g;
        Class cls3 = hVar.f2843k;
        m1.b bVar = b9.h;
        w4.l lVar = (w4.l) ((AtomicReference) bVar.f6510j).getAndSet(null);
        if (lVar == null) {
            lVar = new w4.l(cls, cls2, cls3);
        } else {
            lVar.f9947a = cls;
            lVar.f9948b = cls2;
            lVar.f9949c = cls3;
        }
        synchronized (((s.d) bVar.f6511k)) {
            list = (List) ((s.d) bVar.f6511k).getOrDefault(lVar, null);
        }
        ((AtomicReference) bVar.f6510j).set(lVar);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList a10 = b9.f1773a.a(cls);
            int size = a10.size();
            int i9 = 0;
            while (i9 < size) {
                Object obj = a10.get(i9);
                i9++;
                ArrayList m9 = b9.f1775c.m((Class) obj, cls2);
                int size2 = m9.size();
                int i10 = 0;
                while (i10 < size2) {
                    Object obj2 = m9.get(i10);
                    i10++;
                    Class cls4 = (Class) obj2;
                    if (!b9.f1778f.i(cls4, cls3).isEmpty() && !arrayList.contains(cls4)) {
                        arrayList.add(cls4);
                    }
                }
            }
            z8 = false;
            b9.h.u(cls, cls2, cls3, Collections.unmodifiableList(arrayList));
            list2 = arrayList;
        } else {
            z8 = false;
            list2 = list;
        }
        if (list2.isEmpty()) {
            if (File.class.equals(this.f2798j.f2843k)) {
                return z8;
            }
            StringBuilder sb = new StringBuilder("Failed to find any load path from ");
            sb.append(this.f2798j.f2837d.getClass());
            Class cls5 = this.f2798j.f2843k;
            sb.append(" to ");
            sb.append(cls5);
            throw new IllegalStateException(sb.toString());
        }
        while (true) {
            List list3 = this.f2802n;
            if (list3 != null && this.f2803o < list3.size()) {
                this.f2804p = null;
                boolean z9 = false;
                while (!z9 && this.f2803o < this.f2802n.size()) {
                    List list4 = this.f2802n;
                    int i11 = this.f2803o;
                    this.f2803o = i11 + 1;
                    h4.q qVar = (h4.q) list4.get(i11);
                    File file = this.f2805q;
                    h hVar2 = this.f2798j;
                    this.f2804p = qVar.a(file, hVar2.f2838e, hVar2.f2839f, hVar2.f2841i);
                    if (this.f2804p != null && this.f2798j.c(this.f2804p.f4002c.a()) != null) {
                        this.f2804p.f4002c.c(this.f2798j.f2847o, this);
                        z9 = true;
                    }
                }
                return z9;
            }
            int i12 = this.f2800l + 1;
            this.f2800l = i12;
            if (i12 >= list2.size()) {
                int i13 = this.f2799k + 1;
                this.f2799k = i13;
                if (i13 >= a9.size()) {
                    return z8;
                }
                this.f2800l = 0;
            }
            b4.f fVar = (b4.f) a9.get(this.f2799k);
            Class cls6 = (Class) list2.get(this.f2800l);
            b4.m e9 = this.f2798j.e(cls6);
            h hVar3 = this.f2798j;
            this.f2806r = new c0(hVar3.f2836c.f1758a, fVar, hVar3.f2846n, hVar3.f2838e, hVar3.f2839f, e9, cls6, hVar3.f2841i);
            File r8 = hVar3.h.a().r(this.f2806r);
            this.f2805q = r8;
            if (r8 != null) {
                this.f2801m = fVar;
                this.f2802n = this.f2798j.f2836c.b().g(r8);
                this.f2803o = 0;
            }
            z8 = false;
        }
    }

    @Override // d4.g
    public final void cancel() {
        h4.p pVar = this.f2804p;
        if (pVar != null) {
            pVar.f4002c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void x(Exception exc) {
        this.f2797i.c(this.f2806r, exc, this.f2804p.f4002c, 4);
    }
}
