package v1;

import android.os.Handler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class j extends a {
    public final HashMap h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public Handler f9306i;

    /* renamed from: j, reason: collision with root package name */
    public z1.f f9307j;

    @Override // v1.a
    public final void c() {
        for (i iVar : this.h.values()) {
            iVar.f9302a.b(iVar.f9303b);
        }
    }

    @Override // v1.a
    public final void e() {
        for (i iVar : this.h.values()) {
            iVar.f9302a.d(iVar.f9303b);
        }
    }

    @Override // v1.a
    public void i() {
        Iterator it = this.h.values().iterator();
        while (it.hasNext()) {
            ((i) it.next()).f9302a.i();
        }
    }

    @Override // v1.a
    public void o() {
        HashMap hashMap = this.h;
        for (i iVar : hashMap.values()) {
            a aVar = iVar.f9302a;
            a0.l lVar = iVar.f9304c;
            aVar.n(iVar.f9303b);
            aVar.q(lVar);
            aVar.p(lVar);
        }
        hashMap.clear();
    }

    public abstract z s(Object obj, z zVar);

    public abstract void v(Object obj, a aVar, d1.y0 y0Var);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [v1.a0, v1.h] */
    public final void w(final Object obj, a aVar) {
        HashMap hashMap = this.h;
        g1.a.f(!hashMap.containsKey(obj));
        ?? r12 = new a0() { // from class: v1.h
            @Override // v1.a0
            public final void a(a aVar2, d1.y0 y0Var) {
                j.this.v(obj, aVar2, y0Var);
            }
        };
        a0.l lVar = new a0.l();
        lVar.f33l = this;
        int i9 = 0;
        z zVar = null;
        lVar.f31j = new o1.d(this.f9235c.f7571c, i9, zVar);
        lVar.f32k = new o1.d(this.f9236d.f7571c, i9, zVar);
        lVar.f30i = obj;
        hashMap.put(obj, new i(aVar, r12, lVar));
        Handler handler = this.f9306i;
        handler.getClass();
        aVar.getClass();
        o1.d dVar = aVar.f9235c;
        dVar.getClass();
        CopyOnWriteArrayList copyOnWriteArrayList = dVar.f7571c;
        c0 c0Var = new c0();
        c0Var.f9253a = handler;
        c0Var.f9254b = lVar;
        copyOnWriteArrayList.add(c0Var);
        this.f9306i.getClass();
        o1.d dVar2 = aVar.f9236d;
        dVar2.getClass();
        CopyOnWriteArrayList copyOnWriteArrayList2 = dVar2.f7571c;
        o1.c cVar = new o1.c();
        cVar.f7568a = lVar;
        copyOnWriteArrayList2.add(cVar);
        z1.f fVar = this.f9307j;
        m1.x xVar = this.f9239g;
        g1.a.l(xVar);
        aVar.j(r12, fVar, xVar);
        if (this.f9234b.isEmpty()) {
            aVar.b(r12);
        }
    }

    public long t(long j5, Object obj) {
        return j5;
    }

    public int u(int i9, Object obj) {
        return i9;
    }
}
