package androidx.lifecycle;

import android.os.Looper;
import android.util.Log;
import android.view.View;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class y {

    /* renamed from: j, reason: collision with root package name */
    public static final Object f954j = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Object f955a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final p.f f956b = new p.f();

    /* renamed from: c, reason: collision with root package name */
    public int f957c = 0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f958d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f959e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f960f;

    /* renamed from: g, reason: collision with root package name */
    public int f961g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f962i;

    public y() {
        Object obj = f954j;
        this.f960f = obj;
        this.f959e = obj;
        this.f961g = -1;
    }

    public static void a(String str) {
        ((o.a) o.a.g0().f7545f).getClass();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        m7.c.p(androidx.activity.g.n("Cannot invoke ", str, " on a background thread"));
    }

    public final void b(x xVar) {
        if (xVar.f951j) {
            if (!xVar.e()) {
                xVar.c(false);
                return;
            }
            int i9 = xVar.f952k;
            int i10 = this.f961g;
            if (i9 >= i10) {
                return;
            }
            xVar.f952k = i10;
            a0.b bVar = xVar.f950i;
            Object obj = this.f959e;
            bVar.getClass();
            s sVar = (s) obj;
            androidx.fragment.app.o oVar = (androidx.fragment.app.o) bVar.f8j;
            if (sVar == null || !oVar.f809e0) {
                return;
            }
            View x6 = oVar.x();
            if (x6.getParent() != null) {
                m7.c.p("DialogFragment can not be attached to a container view");
                return;
            }
            if (oVar.i0 != null) {
                if (androidx.fragment.app.h0.D(3)) {
                    Log.d("FragmentManager", "DialogFragment " + bVar + " setting the content view on " + oVar.i0);
                }
                oVar.i0.setContentView(x6);
            }
        }
    }

    public final void c(x xVar) {
        if (this.h) {
            this.f962i = true;
            return;
        }
        this.h = true;
        do {
            this.f962i = false;
            if (xVar != null) {
                b(xVar);
                xVar = null;
            } else {
                p.f fVar = this.f956b;
                fVar.getClass();
                p.d dVar = new p.d(fVar);
                fVar.f8091k.put(dVar, Boolean.FALSE);
                while (dVar.hasNext()) {
                    b((x) ((Map.Entry) dVar.next()).getValue());
                    if (this.f962i) {
                        break;
                    }
                }
            }
        } while (this.f962i);
        this.h = false;
    }

    public final void d(a0.b bVar) {
        Object obj;
        a("observeForever");
        w wVar = new w(this, bVar);
        p.f fVar = this.f956b;
        p.c f9 = fVar.f(bVar);
        if (f9 != null) {
            obj = f9.f8083j;
        } else {
            p.c cVar = new p.c(bVar, wVar);
            fVar.f8092l++;
            p.c cVar2 = fVar.f8090j;
            if (cVar2 == null) {
                fVar.f8089i = cVar;
                fVar.f8090j = cVar;
            } else {
                cVar2.f8084k = cVar;
                cVar.f8085l = cVar2;
                fVar.f8090j = cVar;
            }
            obj = null;
        }
        x xVar = (x) obj;
        if (xVar instanceof LiveData$LifecycleBoundObserver) {
            m7.c.n("Cannot add the same observer with different lifecycles");
        } else {
            if (xVar != null) {
                return;
            }
            wVar.c(true);
        }
    }

    public final void e(Object obj) {
        a("setValue");
        this.f961g++;
        this.f959e = obj;
        c(null);
    }
}
