package e4;

import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final a5.d f3096a = new a5.d(11);

    /* renamed from: b, reason: collision with root package name */
    public final e f3097b = new e(0);

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f3098c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f3099d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final int f3100e;

    /* renamed from: f, reason: collision with root package name */
    public int f3101f;

    public f(int i9) {
        this.f3100e = i9;
    }

    public final synchronized void a() {
        c(0);
    }

    public final void b(int i9, Class cls) {
        NavigableMap g9 = g(cls);
        Integer num = (Integer) g9.get(Integer.valueOf(i9));
        if (num != null) {
            if (num.intValue() == 1) {
                g9.remove(Integer.valueOf(i9));
                return;
            } else {
                g9.put(Integer.valueOf(i9), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i9 + ", this: " + this);
    }

    public final void c(int i9) {
        while (this.f3101f > i9) {
            Object T0 = this.f3096a.T0();
            w4.f.b(T0);
            b e9 = e(T0.getClass());
            this.f3101f -= e9.b() * e9.a(T0);
            b(e9.a(T0), T0.getClass());
            if (Log.isLoggable(e9.c(), 2)) {
                Log.v(e9.c(), "evicted: " + e9.a(T0));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002b A[Catch: all -> 0x0046, TRY_ENTER, TryCatch #0 {all -> 0x0046, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0015, B:10:0x001c, B:16:0x002b, B:18:0x003b, B:19:0x003f, B:20:0x005e, B:25:0x0048, B:27:0x0054, B:28:0x0058), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0048 A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0015, B:10:0x001c, B:16:0x002b, B:18:0x003b, B:19:0x003f, B:20:0x005e, B:25:0x0048, B:27:0x0054, B:28:0x0058), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized java.lang.Object d(int r4, java.lang.Class r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.NavigableMap r0 = r3.g(r5)     // Catch: java.lang.Throwable -> L46
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L46
            java.lang.Object r0 = r0.ceilingKey(r1)     // Catch: java.lang.Throwable -> L46
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L46
            if (r0 == 0) goto L26
            int r1 = r3.f3101f     // Catch: java.lang.Throwable -> L46
            if (r1 == 0) goto L24
            int r2 = r3.f3100e     // Catch: java.lang.Throwable -> L46
            int r2 = r2 / r1
            r1 = 2
            if (r2 < r1) goto L1c
            goto L24
        L1c:
            int r1 = r0.intValue()     // Catch: java.lang.Throwable -> L46
            int r2 = r4 * 8
            if (r1 > r2) goto L26
        L24:
            r1 = 1
            goto L27
        L26:
            r1 = 0
        L27:
            e4.e r2 = r3.f3097b
            if (r1 == 0) goto L48
            int r4 = r0.intValue()     // Catch: java.lang.Throwable -> L46
            java.lang.Object r0 = r2.f1132i     // Catch: java.lang.Throwable -> L46
            java.util.ArrayDeque r0 = (java.util.ArrayDeque) r0     // Catch: java.lang.Throwable -> L46
            java.lang.Object r0 = r0.poll()     // Catch: java.lang.Throwable -> L46
            e4.h r0 = (e4.h) r0     // Catch: java.lang.Throwable -> L46
            if (r0 != 0) goto L3f
            e4.h r0 = r2.f()     // Catch: java.lang.Throwable -> L46
        L3f:
            e4.d r0 = (e4.d) r0     // Catch: java.lang.Throwable -> L46
            r0.f3093b = r4     // Catch: java.lang.Throwable -> L46
            r0.f3094c = r5     // Catch: java.lang.Throwable -> L46
            goto L5e
        L46:
            r4 = move-exception
            goto L64
        L48:
            java.lang.Object r0 = r2.f1132i     // Catch: java.lang.Throwable -> L46
            java.util.ArrayDeque r0 = (java.util.ArrayDeque) r0     // Catch: java.lang.Throwable -> L46
            java.lang.Object r0 = r0.poll()     // Catch: java.lang.Throwable -> L46
            e4.h r0 = (e4.h) r0     // Catch: java.lang.Throwable -> L46
            if (r0 != 0) goto L58
            e4.h r0 = r2.f()     // Catch: java.lang.Throwable -> L46
        L58:
            e4.d r0 = (e4.d) r0     // Catch: java.lang.Throwable -> L46
            r0.f3093b = r4     // Catch: java.lang.Throwable -> L46
            r0.f3094c = r5     // Catch: java.lang.Throwable -> L46
        L5e:
            java.lang.Object r4 = r3.f(r0, r5)     // Catch: java.lang.Throwable -> L46
            monitor-exit(r3)
            return r4
        L64:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L46
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.f.d(int, java.lang.Class):java.lang.Object");
    }

    public final b e(Class cls) {
        b bVar;
        HashMap hashMap = this.f3099d;
        b bVar2 = (b) hashMap.get(cls);
        if (bVar2 != null) {
            return bVar2;
        }
        if (cls.equals(int[].class)) {
            bVar = new b(1);
        } else {
            if (!cls.equals(byte[].class)) {
                m7.c.n("No array pool found for: ".concat(cls.getSimpleName()));
                return null;
            }
            bVar = new b(0);
        }
        hashMap.put(cls, bVar);
        return bVar;
    }

    public final Object f(d dVar, Class cls) {
        b e9 = e(cls);
        Object F0 = this.f3096a.F0(dVar);
        if (F0 != null) {
            this.f3101f -= e9.b() * e9.a(F0);
            b(e9.a(F0), cls);
        }
        if (F0 != null) {
            return F0;
        }
        if (Log.isLoggable(e9.c(), 2)) {
            Log.v(e9.c(), "Allocated " + dVar.f3093b + " bytes");
        }
        int i9 = dVar.f3093b;
        switch (e9.f3087a) {
            case 0:
                return new byte[i9];
            default:
                return new int[i9];
        }
    }

    public final NavigableMap g(Class cls) {
        HashMap hashMap = this.f3098c;
        NavigableMap navigableMap = (NavigableMap) hashMap.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        hashMap.put(cls, treeMap);
        return treeMap;
    }

    public final synchronized void h(Object obj) {
        Class<?> cls = obj.getClass();
        b e9 = e(cls);
        int a9 = e9.a(obj);
        int b9 = e9.b() * a9;
        if (b9 <= this.f3100e / 2) {
            e eVar = this.f3097b;
            h hVar = (h) ((ArrayDeque) eVar.f1132i).poll();
            if (hVar == null) {
                hVar = eVar.f();
            }
            d dVar = (d) hVar;
            dVar.f3093b = a9;
            dVar.f3094c = cls;
            this.f3096a.R0(dVar, obj);
            NavigableMap g9 = g(cls);
            Integer num = (Integer) g9.get(Integer.valueOf(dVar.f3093b));
            Integer valueOf = Integer.valueOf(dVar.f3093b);
            int i9 = 1;
            if (num != null) {
                i9 = 1 + num.intValue();
            }
            g9.put(valueOf, Integer.valueOf(i9));
            this.f3101f += b9;
            c(this.f3100e);
        }
    }

    public final synchronized void i(int i9) {
        try {
            if (i9 >= 40) {
                a();
            } else if (i9 >= 20 || i9 == 15) {
                c(this.f3100e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
