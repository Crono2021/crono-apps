package d4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2834a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2835b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public com.bumptech.glide.e f2836c;

    /* renamed from: d, reason: collision with root package name */
    public Object f2837d;

    /* renamed from: e, reason: collision with root package name */
    public int f2838e;

    /* renamed from: f, reason: collision with root package name */
    public int f2839f;

    /* renamed from: g, reason: collision with root package name */
    public Class f2840g;
    public c.a h;

    /* renamed from: i, reason: collision with root package name */
    public b4.i f2841i;

    /* renamed from: j, reason: collision with root package name */
    public Map f2842j;

    /* renamed from: k, reason: collision with root package name */
    public Class f2843k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2844l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2845m;

    /* renamed from: n, reason: collision with root package name */
    public b4.f f2846n;

    /* renamed from: o, reason: collision with root package name */
    public com.bumptech.glide.g f2847o;

    /* renamed from: p, reason: collision with root package name */
    public m f2848p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2849q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2850r;

    public final ArrayList a() {
        boolean z8 = this.f2845m;
        ArrayList arrayList = this.f2835b;
        if (!z8) {
            this.f2845m = true;
            arrayList.clear();
            ArrayList b9 = b();
            int size = b9.size();
            for (int i9 = 0; i9 < size; i9++) {
                h4.p pVar = (h4.p) b9.get(i9);
                b4.f fVar = pVar.f4000a;
                List list = pVar.f4001b;
                if (!arrayList.contains(fVar)) {
                    arrayList.add(pVar.f4000a);
                }
                for (int i10 = 0; i10 < list.size(); i10++) {
                    if (!arrayList.contains(list.get(i10))) {
                        arrayList.add(list.get(i10));
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList b() {
        boolean z8 = this.f2844l;
        ArrayList arrayList = this.f2834a;
        if (!z8) {
            this.f2844l = true;
            arrayList.clear();
            List g9 = this.f2836c.b().g(this.f2837d);
            int size = g9.size();
            for (int i9 = 0; i9 < size; i9++) {
                h4.p a9 = ((h4.q) g9.get(i9)).a(this.f2837d, this.f2838e, this.f2839f, this.f2841i);
                if (a9 != null) {
                    arrayList.add(a9);
                }
            }
        }
        return arrayList;
    }

    public final y c(Class cls) {
        y yVar;
        Class cls2;
        com.bumptech.glide.i b9 = this.f2836c.b();
        Class cls3 = this.f2840g;
        Class cls4 = this.f2843k;
        r4.b bVar = b9.f1780i;
        w4.l lVar = (w4.l) bVar.f8551b.getAndSet(null);
        if (lVar == null) {
            lVar = new w4.l();
        }
        lVar.f9947a = cls;
        lVar.f9948b = cls3;
        lVar.f9949c = cls4;
        synchronized (bVar.f8550a) {
            yVar = (y) bVar.f8550a.getOrDefault(lVar, null);
        }
        bVar.f8551b.set(lVar);
        b9.f1780i.getClass();
        if (r4.b.f8549c.equals(yVar)) {
            return null;
        }
        if (yVar != null) {
            return yVar;
        }
        y yVar2 = null;
        ArrayList e9 = b9.e(cls, cls3, cls4);
        if (e9.isEmpty()) {
            cls2 = cls;
        } else {
            cls2 = cls;
            yVar2 = new y(cls2, cls3, cls4, e9, b9.f1781j);
        }
        y yVar3 = yVar2;
        b9.f1780i.a(cls2, cls3, cls4, yVar3);
        return yVar3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
    
        r1 = r5.f8548b;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b4.b d(java.lang.Object r8) {
        /*
            r7 = this;
            com.bumptech.glide.e r0 = r7.f2836c
            com.bumptech.glide.i r0 = r0.b()
            p4.c r0 = r0.f1774b
            java.lang.Class r1 = r8.getClass()
            monitor-enter(r0)
            java.util.ArrayList r2 = r0.f8251a     // Catch: java.lang.Throwable -> L2a
            int r3 = r2.size()     // Catch: java.lang.Throwable -> L2a
            r4 = 0
        L14:
            if (r4 >= r3) goto L2c
            java.lang.Object r5 = r2.get(r4)     // Catch: java.lang.Throwable -> L2a
            int r4 = r4 + 1
            r4.a r5 = (r4.a) r5     // Catch: java.lang.Throwable -> L2a
            java.lang.Class r6 = r5.f8547a     // Catch: java.lang.Throwable -> L2a
            boolean r6 = r6.isAssignableFrom(r1)     // Catch: java.lang.Throwable -> L2a
            if (r6 == 0) goto L14
            b4.b r1 = r5.f8548b     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r0)
            goto L2e
        L2a:
            r8 = move-exception
            goto L49
        L2c:
            monitor-exit(r0)
            r1 = 0
        L2e:
            if (r1 == 0) goto L31
            return r1
        L31:
            com.bumptech.glide.h r0 = new com.bumptech.glide.h
            java.lang.Class r8 = r8.getClass()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to find source encoder for data class: "
            r1.<init>(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        L49:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.h.d(java.lang.Object):b4.b");
    }

    public final b4.m e(Class cls) {
        b4.m mVar = (b4.m) this.f2842j.get(cls);
        if (mVar == null) {
            Iterator it = this.f2842j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    mVar = (b4.m) entry.getValue();
                    break;
                }
            }
        }
        if (mVar != null) {
            return mVar;
        }
        if (!this.f2842j.isEmpty() || !this.f2849q) {
            return j4.c.f5434b;
        }
        androidx.fragment.app.a.m(cls, ". If you wish to ignore unknown resource types, use the optional transformation methods.", "Missing transformation for ");
        return null;
    }
}
