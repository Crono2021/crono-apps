package v1;

import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f9233a = new ArrayList(1);

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f9234b = new HashSet(1);

    /* renamed from: c, reason: collision with root package name */
    public final o1.d f9235c;

    /* renamed from: d, reason: collision with root package name */
    public final o1.d f9236d;

    /* renamed from: e, reason: collision with root package name */
    public Looper f9237e;

    /* renamed from: f, reason: collision with root package name */
    public d1.y0 f9238f;

    /* renamed from: g, reason: collision with root package name */
    public m1.x f9239g;

    public a() {
        int i9 = 0;
        z zVar = null;
        this.f9235c = new o1.d(new CopyOnWriteArrayList(), i9, zVar);
        this.f9236d = new o1.d(new CopyOnWriteArrayList(), i9, zVar);
    }

    public abstract x a(z zVar, z1.d dVar, long j5);

    public final void b(a0 a0Var) {
        HashSet hashSet = this.f9234b;
        boolean isEmpty = hashSet.isEmpty();
        hashSet.remove(a0Var);
        if (isEmpty || !hashSet.isEmpty()) {
            return;
        }
        c();
    }

    public final void d(a0 a0Var) {
        this.f9237e.getClass();
        HashSet hashSet = this.f9234b;
        boolean isEmpty = hashSet.isEmpty();
        hashSet.add(a0Var);
        if (isEmpty) {
            e();
        }
    }

    public d1.y0 f() {
        return null;
    }

    public abstract d1.e0 g();

    public boolean h() {
        return true;
    }

    public abstract void i();

    public final void j(a0 a0Var, z1.f fVar, m1.x xVar) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.f9237e;
        g1.a.f(looper == null || looper == myLooper);
        this.f9239g = xVar;
        d1.y0 y0Var = this.f9238f;
        this.f9233a.add(a0Var);
        if (this.f9237e == null) {
            this.f9237e = myLooper;
            this.f9234b.add(a0Var);
            k(fVar);
        } else if (y0Var != null) {
            d(a0Var);
            a0Var.a(this, y0Var);
        }
    }

    public abstract void k(z1.f fVar);

    public final void l(d1.y0 y0Var) {
        this.f9238f = y0Var;
        ArrayList arrayList = this.f9233a;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            ((a0) obj).a(this, y0Var);
        }
    }

    public abstract void m(x xVar);

    public final void n(a0 a0Var) {
        ArrayList arrayList = this.f9233a;
        arrayList.remove(a0Var);
        if (!arrayList.isEmpty()) {
            b(a0Var);
            return;
        }
        this.f9237e = null;
        this.f9238f = null;
        this.f9239g = null;
        this.f9234b.clear();
        o();
    }

    public abstract void o();

    public final void p(o1.e eVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f9236d.f7571c;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            o1.c cVar = (o1.c) it.next();
            if (cVar.f7568a == eVar) {
                copyOnWriteArrayList.remove(cVar);
            }
        }
    }

    public final void q(d0 d0Var) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f9235c.f7571c;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            c0 c0Var = (c0) it.next();
            if (c0Var.f9254b == d0Var) {
                copyOnWriteArrayList.remove(c0Var);
            }
        }
    }

    public abstract void r(d1.e0 e0Var);

    public void c() {
    }

    public void e() {
    }
}
