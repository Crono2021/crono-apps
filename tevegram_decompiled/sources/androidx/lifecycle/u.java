package androidx.lifecycle;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u {

    /* renamed from: e, reason: collision with root package name */
    public final WeakReference f944e;

    /* renamed from: f, reason: collision with root package name */
    public int f945f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f946g;
    public boolean h;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f940a = new AtomicReference();

    /* renamed from: b, reason: collision with root package name */
    public final boolean f941b = true;

    /* renamed from: c, reason: collision with root package name */
    public p.a f942c = new p.a();

    /* renamed from: d, reason: collision with root package name */
    public m f943d = m.f929j;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f947i = new ArrayList();

    public u(s sVar) {
        this.f944e = new WeakReference(sVar);
    }

    public final void a(r rVar) {
        q reflectiveGenericLifecycleObserver;
        Object obj;
        s sVar;
        c("addObserver");
        m mVar = this.f943d;
        m mVar2 = m.f928i;
        if (mVar != mVar2) {
            mVar2 = m.f929j;
        }
        t tVar = new t();
        HashMap hashMap = v.f948a;
        boolean z8 = rVar instanceof q;
        boolean z9 = rVar instanceof d;
        if (z8 && z9) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((d) rVar, (q) rVar);
        } else if (z9) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((d) rVar, null);
        } else if (z8) {
            reflectiveGenericLifecycleObserver = (q) rVar;
        } else {
            Class<?> cls = rVar.getClass();
            if (v.b(cls) == 2) {
                Object obj2 = v.f949b.get(cls);
                obj2.getClass();
                List list = (List) obj2;
                if (list.size() == 1) {
                    v.a((Constructor) list.get(0), rVar);
                    throw null;
                }
                int size = list.size();
                g[] gVarArr = new g[size];
                if (size > 0) {
                    v.a((Constructor) list.get(0), rVar);
                    throw null;
                }
                reflectiveGenericLifecycleObserver = new CompositeGeneratedAdaptersObserver(gVarArr);
            } else {
                reflectiveGenericLifecycleObserver = new ReflectiveGenericLifecycleObserver(rVar);
            }
        }
        tVar.f939b = reflectiveGenericLifecycleObserver;
        tVar.f938a = mVar2;
        p.a aVar = this.f942c;
        p.c f9 = aVar.f(rVar);
        if (f9 != null) {
            obj = f9.f8083j;
        } else {
            HashMap hashMap2 = aVar.f8078m;
            p.c cVar = new p.c(rVar, tVar);
            aVar.f8092l++;
            p.c cVar2 = aVar.f8090j;
            if (cVar2 == null) {
                aVar.f8089i = cVar;
                aVar.f8090j = cVar;
            } else {
                cVar2.f8084k = cVar;
                cVar.f8085l = cVar2;
                aVar.f8090j = cVar;
            }
            hashMap2.put(rVar, cVar);
            obj = null;
        }
        if (((t) obj) == null && (sVar = (s) this.f944e.get()) != null) {
            boolean z10 = this.f945f != 0 || this.f946g;
            m b9 = b(rVar);
            this.f945f++;
            while (tVar.f938a.compareTo(b9) < 0 && this.f942c.f8078m.containsKey(rVar)) {
                m mVar3 = tVar.f938a;
                ArrayList arrayList = this.f947i;
                arrayList.add(mVar3);
                j jVar = l.Companion;
                m mVar4 = tVar.f938a;
                jVar.getClass();
                mVar4.getClass();
                int ordinal = mVar4.ordinal();
                l lVar = ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? null : l.ON_RESUME : l.ON_START : l.ON_CREATE;
                if (lVar == null) {
                    androidx.fragment.app.a.t(tVar.f938a, "no event up from ");
                    return;
                } else {
                    tVar.a(sVar, lVar);
                    arrayList.remove(arrayList.size() - 1);
                    b9 = b(rVar);
                }
            }
            if (!z10) {
                g();
            }
            this.f945f--;
        }
    }

    public final m b(r rVar) {
        HashMap hashMap = this.f942c.f8078m;
        p.c cVar = hashMap.containsKey(rVar) ? ((p.c) hashMap.get(rVar)).f8085l : null;
        m mVar = cVar != null ? ((t) cVar.f8083j).f938a : null;
        ArrayList arrayList = this.f947i;
        m mVar2 = arrayList.isEmpty() ? null : (m) arrayList.get(arrayList.size() - 1);
        m mVar3 = this.f943d;
        mVar3.getClass();
        if (mVar == null || mVar.compareTo(mVar3) >= 0) {
            mVar = mVar3;
        }
        return (mVar2 == null || mVar2.compareTo(mVar) >= 0) ? mVar : mVar2;
    }

    public final void c(String str) {
        if (this.f941b) {
            ((o.a) o.a.g0().f7545f).getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(androidx.activity.g.n("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void d(l lVar) {
        lVar.getClass();
        c("handleLifecycleEvent");
        e(lVar.a());
    }

    public final void e(m mVar) {
        m mVar2 = this.f943d;
        if (mVar2 == mVar) {
            return;
        }
        m mVar3 = m.f929j;
        m mVar4 = m.f928i;
        if (mVar2 == mVar3 && mVar == mVar4) {
            StringBuilder sb = new StringBuilder("no event down from ");
            sb.append(this.f943d);
            Object obj = this.f944e.get();
            sb.append(" in component ");
            sb.append(obj);
            throw new IllegalStateException(sb.toString().toString());
        }
        this.f943d = mVar;
        if (this.f946g || this.f945f != 0) {
            this.h = true;
            return;
        }
        this.f946g = true;
        g();
        this.f946g = false;
        if (this.f943d == mVar4) {
            this.f942c = new p.a();
        }
    }

    public final void f(r rVar) {
        rVar.getClass();
        c("removeObserver");
        this.f942c.g(rVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0030, code lost:
    
        r11.h = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.u.g():void");
    }
}
