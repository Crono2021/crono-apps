package n8;

import i8.f0;
import i8.f1;
import i8.h1;
import i8.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a6.d f7492a = new a6.d("NO_DECISION", 3);

    /* renamed from: b, reason: collision with root package name */
    public static final a6.d f7493b = new a6.d("CLOSED", 3);

    /* renamed from: c, reason: collision with root package name */
    public static final a6.d f7494c = new a6.d("UNDEFINED", 3);

    /* renamed from: d, reason: collision with root package name */
    public static final a6.d f7495d = new a6.d("REUSABLE_CLAIMED", 3);

    /* renamed from: e, reason: collision with root package name */
    public static final a6.d f7496e = new a6.d("CONDITION_FALSE", 3);

    /* renamed from: f, reason: collision with root package name */
    public static final a6.d f7497f = new a6.d("NO_THREAD_ELEMENTS", 3);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, n8.t] */
    /* JADX WARN: Type inference failed for: r4v2, types: [n8.t] */
    public static final Object a(long j5, k8.l lVar) {
        k8.e eVar = k8.e.f5647q;
        while (true) {
            long j9 = lVar.f7533k;
            if (j9 >= j5 && !lVar.c()) {
                return lVar;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d.f7500i;
            Object obj = atomicReferenceFieldUpdater.get(lVar);
            a6.d dVar = f7493b;
            if (obj == dVar) {
                return dVar;
            }
            ?? r42 = (t) ((d) obj);
            if (r42 != 0) {
                lVar = r42;
            } else {
                ?? r12 = (t) eVar.h(Long.valueOf(j9 + 1), lVar);
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(lVar, null, r12)) {
                        if (lVar.c()) {
                            lVar.d();
                        }
                        lVar = r12;
                    } else if (atomicReferenceFieldUpdater.get(lVar) != null) {
                        break;
                    }
                }
            }
        }
    }

    public static final t b(Object obj) {
        if (obj != f7493b) {
            return (t) obj;
        }
        m7.c.p("Does not contain segment");
        return null;
    }

    public static final void c(r7.g gVar, Throwable th) {
        Throwable runtimeException;
        Iterator it = f.f7503a.iterator();
        while (it.hasNext()) {
            try {
                ((j8.b) it.next()).c(th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    android.support.v4.media.session.b.h(runtimeException, th);
                }
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, runtimeException);
            }
        }
        try {
            android.support.v4.media.session.b.h(th, new g(gVar));
        } catch (Throwable unused) {
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }

    public static final boolean d(Object obj) {
        return obj == f7493b;
    }

    public static final Object e(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static final void f(r7.g gVar, Object obj) {
        if (obj == f7497f) {
            return;
        }
        if (!(obj instanceof y)) {
            gVar.d(null, w.f7537l).getClass();
            androidx.fragment.app.a.c();
            return;
        }
        i8.o[] oVarArr = ((y) obj).f7543b;
        int length = oVarArr.length - 1;
        if (length < 0) {
            return;
        }
        i8.o oVar = oVarArr[length];
        throw null;
    }

    public static final void g(Object obj, r7.c cVar) {
        if (!(cVar instanceof h)) {
            cVar.g(obj);
            return;
        }
        h hVar = (h) cVar;
        i8.s sVar = hVar.f7506l;
        t7.c cVar2 = hVar.f7507m;
        Throwable a9 = n7.d.a(obj);
        Object mVar = a9 == null ? obj : new i8.m(a9, false);
        cVar2.f();
        r7.g gVar = cVar2.f8983j;
        if (sVar.g()) {
            hVar.f7508n = mVar;
            hVar.f5247k = 1;
            gVar.getClass();
            sVar.c(gVar, hVar);
            return;
        }
        f0 a10 = f1.a();
        if (a10.f5263k >= IjkMediaMeta.AV_CH_WIDE_RIGHT) {
            hVar.f7508n = mVar;
            hVar.f5247k = 1;
            a10.j(hVar);
            return;
        }
        a10.k(true);
        try {
            gVar.getClass();
            y0 y0Var = (y0) gVar.h(i8.t.f5304j);
            if (y0Var == null || y0Var.B()) {
                Object obj2 = hVar.f7509o;
                gVar.getClass();
                Object k3 = k(gVar, obj2);
                h1 p5 = k3 != f7497f ? i8.w.p(cVar2, gVar, k3) : null;
                try {
                    cVar2.g(obj);
                } finally {
                    if (p5 == null || p5.N()) {
                        f(gVar, k3);
                    }
                }
            } else {
                CancellationException s8 = y0Var.s();
                hVar.c(mVar, s8);
                hVar.g(new n7.c(s8));
            }
            while (a10.m()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static final long i(String str, long j5, long j9, long j10) {
        String str2;
        int i9 = v.f7535a;
        try {
            str2 = System.getProperty(str);
        } catch (SecurityException unused) {
            str2 = null;
        }
        if (str2 == null) {
            return j5;
        }
        Long a02 = h8.l.a0(str2);
        if (a02 == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + str2 + '\'').toString());
        }
        long longValue = a02.longValue();
        if (j9 <= longValue && longValue <= j10) {
            return longValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j9 + ".." + j10 + ", but is '" + longValue + '\'').toString());
    }

    public static int j(int i9, int i10, String str) {
        return (int) i(str, i9, 1, (i10 & 8) != 0 ? Integer.MAX_VALUE : 2097150);
    }

    public static final Object k(r7.g gVar, Object obj) {
        if (obj == null) {
            obj = gVar.d(0, w.f7536k);
            obj.getClass();
        }
        if (obj == 0) {
            return f7497f;
        }
        if (obj instanceof Integer) {
            return gVar.d(new y(((Number) obj).intValue(), gVar), w.f7538m);
        }
        androidx.fragment.app.a.c();
        return null;
    }
}
