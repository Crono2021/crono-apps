package s4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import b4.i;
import d4.a0;
import d4.m;
import d4.n;
import d4.r;
import d4.w;
import g.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import w4.h;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f implements c {
    public static final boolean C = Log.isLoggable("GlideRequest", 2);
    public final RuntimeException A;
    public int B;

    /* renamed from: a, reason: collision with root package name */
    public final String f8825a;

    /* renamed from: b, reason: collision with root package name */
    public final x4.d f8826b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f8827c;

    /* renamed from: d, reason: collision with root package name */
    public final d f8828d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f8829e;

    /* renamed from: f, reason: collision with root package name */
    public final com.bumptech.glide.e f8830f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f8831g;
    public final Class h;

    /* renamed from: i, reason: collision with root package name */
    public final a f8832i;

    /* renamed from: j, reason: collision with root package name */
    public final int f8833j;

    /* renamed from: k, reason: collision with root package name */
    public final int f8834k;

    /* renamed from: l, reason: collision with root package name */
    public final com.bumptech.glide.g f8835l;

    /* renamed from: m, reason: collision with root package name */
    public final t4.b f8836m;

    /* renamed from: n, reason: collision with root package name */
    public final List f8837n;

    /* renamed from: o, reason: collision with root package name */
    public final u4.a f8838o;

    /* renamed from: p, reason: collision with root package name */
    public final j0 f8839p;

    /* renamed from: q, reason: collision with root package name */
    public a0 f8840q;

    /* renamed from: r, reason: collision with root package name */
    public androidx.fragment.app.g f8841r;

    /* renamed from: s, reason: collision with root package name */
    public long f8842s;

    /* renamed from: t, reason: collision with root package name */
    public volatile n f8843t;

    /* renamed from: u, reason: collision with root package name */
    public Drawable f8844u;

    /* renamed from: v, reason: collision with root package name */
    public Drawable f8845v;

    /* renamed from: w, reason: collision with root package name */
    public Drawable f8846w;

    /* renamed from: x, reason: collision with root package name */
    public int f8847x;

    /* renamed from: y, reason: collision with root package name */
    public int f8848y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f8849z;

    public f(Context context, com.bumptech.glide.e eVar, Object obj, Object obj2, Class cls, a aVar, int i9, int i10, com.bumptech.glide.g gVar, t4.b bVar, ArrayList arrayList, d dVar, n nVar, u4.a aVar2) {
        j0 j0Var = w4.f.f9937a;
        this.f8825a = C ? String.valueOf(hashCode()) : null;
        this.f8826b = new x4.d();
        this.f8827c = obj;
        this.f8829e = context;
        this.f8830f = eVar;
        this.f8831g = obj2;
        this.h = cls;
        this.f8832i = aVar;
        this.f8833j = i9;
        this.f8834k = i10;
        this.f8835l = gVar;
        this.f8836m = bVar;
        this.f8837n = arrayList;
        this.f8828d = dVar;
        this.f8843t = nVar;
        this.f8838o = aVar2;
        this.f8839p = j0Var;
        this.B = 1;
        if (this.A == null && ((Map) eVar.h.f8j).containsKey(com.bumptech.glide.d.class)) {
            this.A = new RuntimeException("Glide request origin trace");
        }
    }

    @Override // s4.c
    public final boolean a() {
        boolean z8;
        synchronized (this.f8827c) {
            z8 = this.B == 4;
        }
        return z8;
    }

    public final void b() {
        if (this.f8849z) {
            m7.c.p("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
            return;
        }
        this.f8826b.a();
        this.f8836m.d(this);
        androidx.fragment.app.g gVar = this.f8841r;
        if (gVar != null) {
            synchronized (((n) gVar.f730l)) {
                ((r) gVar.f728j).j((f) gVar.f729k);
            }
            this.f8841r = null;
        }
    }

    public final Drawable c() {
        if (this.f8845v == null) {
            a aVar = this.f8832i;
            aVar.getClass();
            this.f8845v = null;
            int i9 = aVar.f8806m;
            if (i9 > 0) {
                aVar.getClass();
                Context context = this.f8829e;
                this.f8845v = com.bumptech.glide.c.x(context, context, i9, context.getTheme());
            }
        }
        return this.f8845v;
    }

    @Override // s4.c
    public final void clear() {
        synchronized (this.f8827c) {
            try {
                if (this.f8849z) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.f8826b.a();
                if (this.B == 6) {
                    return;
                }
                b();
                a0 a0Var = this.f8840q;
                if (a0Var != null) {
                    this.f8840q = null;
                } else {
                    a0Var = null;
                }
                d dVar = this.f8828d;
                if (dVar == null || dVar.e(this)) {
                    this.f8836m.h(c());
                }
                this.B = 6;
                if (a0Var != null) {
                    this.f8843t.getClass();
                    n.g(a0Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // s4.c
    public final boolean d() {
        boolean z8;
        synchronized (this.f8827c) {
            z8 = this.B == 6;
        }
        return z8;
    }

    public final void e(String str) {
        Log.v("GlideRequest", str + " this: " + this.f8825a);
    }

    public final void f(w wVar, int i9) {
        Drawable drawable;
        this.f8826b.a();
        synchronized (this.f8827c) {
            try {
                wVar.getClass();
                int i10 = this.f8830f.f1765i;
                if (i10 <= i9) {
                    Log.w("Glide", "Load failed for [" + this.f8831g + "] with dimensions [" + this.f8847x + "x" + this.f8848y + "]", wVar);
                    if (i10 <= 4) {
                        wVar.d();
                    }
                }
                this.f8841r = null;
                this.B = 5;
                d dVar = this.f8828d;
                if (dVar != null) {
                    dVar.f(this);
                }
                boolean z8 = true;
                this.f8849z = true;
                try {
                    List list = this.f8837n;
                    if (list != null) {
                        Iterator it = list.iterator();
                        if (it.hasNext()) {
                            if (it.next() != null) {
                                throw new ClassCastException();
                            }
                            d dVar2 = this.f8828d;
                            if (dVar2 == null) {
                                throw null;
                            }
                            dVar2.getRoot().a();
                            throw null;
                        }
                    }
                    d dVar3 = this.f8828d;
                    if (dVar3 != null && !dVar3.h(this)) {
                        z8 = false;
                    }
                    if (this.f8831g == null) {
                        if (this.f8846w == null) {
                            this.f8832i.getClass();
                            this.f8846w = null;
                        }
                        drawable = this.f8846w;
                    } else {
                        drawable = null;
                    }
                    if (drawable == null) {
                        if (this.f8844u == null) {
                            a aVar = this.f8832i;
                            aVar.getClass();
                            this.f8844u = null;
                            int i11 = aVar.f8805l;
                            if (i11 > 0) {
                                Context context = this.f8829e;
                                this.f8832i.getClass();
                                this.f8844u = com.bumptech.glide.c.x(context, context, i11, context.getTheme());
                            }
                        }
                        drawable = this.f8844u;
                    }
                    if (drawable == null) {
                        drawable = c();
                    }
                    this.f8836m.b(drawable);
                } finally {
                    this.f8849z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00a7 A[Catch: all -> 0x002d, TryCatch #0 {all -> 0x002d, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x001a, B:10:0x0024, B:11:0x0030, B:13:0x0034, B:14:0x003c, B:17:0x0041, B:18:0x004b, B:21:0x004d, B:25:0x0055, B:26:0x005a, B:28:0x005c, B:31:0x0078, B:33:0x0084, B:34:0x0091, B:37:0x00b0, B:39:0x00b4, B:40:0x00ce, B:42:0x0097, B:44:0x009b, B:49:0x00a7, B:51:0x008c, B:52:0x0061, B:53:0x0065, B:55:0x006b, B:59:0x0072, B:60:0x0077, B:62:0x00d0, B:63:0x00d7, B:64:0x00d8, B:65:0x00df), top: B:3:0x0003 }] */
    @Override // s4.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.f.g():void");
    }

    public final void h(a0 a0Var, int i9) {
        this.f8826b.a();
        a0 a0Var2 = null;
        try {
            synchronized (this.f8827c) {
                try {
                    this.f8841r = null;
                    if (a0Var == null) {
                        f(new w("Expected to receive a Resource<R> with an object of " + this.h + " inside, but instead got null."), 5);
                        return;
                    }
                    Object obj = a0Var.get();
                    try {
                        if (obj != null && this.h.isAssignableFrom(obj.getClass())) {
                            d dVar = this.f8828d;
                            if (dVar == null || dVar.b(this)) {
                                k(a0Var, obj, i9);
                                return;
                            }
                            this.f8840q = null;
                            this.B = 4;
                            this.f8843t.getClass();
                            n.g(a0Var);
                        }
                        this.f8840q = null;
                        StringBuilder sb = new StringBuilder("Expected to receive an object of ");
                        sb.append(this.h);
                        sb.append(" but instead got ");
                        sb.append(obj != null ? obj.getClass() : "");
                        sb.append("{");
                        sb.append(obj);
                        sb.append("} inside Resource{");
                        sb.append(a0Var);
                        sb.append("}.");
                        sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        f(new w(sb.toString()), 5);
                        this.f8843t.getClass();
                        n.g(a0Var);
                    } catch (Throwable th) {
                        a0Var2 = a0Var;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (a0Var2 != null) {
                this.f8843t.getClass();
                n.g(a0Var2);
            }
            throw th3;
        }
    }

    @Override // s4.c
    public final boolean i() {
        boolean z8;
        synchronized (this.f8827c) {
            z8 = this.B == 4;
        }
        return z8;
    }

    @Override // s4.c
    public final boolean isRunning() {
        boolean z8;
        synchronized (this.f8827c) {
            int i9 = this.B;
            z8 = i9 == 2 || i9 == 3;
        }
        return z8;
    }

    @Override // s4.c
    public final boolean j(c cVar) {
        int i9;
        int i10;
        Object obj;
        Class cls;
        a aVar;
        com.bumptech.glide.g gVar;
        int size;
        int i11;
        int i12;
        Object obj2;
        Class cls2;
        a aVar2;
        com.bumptech.glide.g gVar2;
        int size2;
        if (!(cVar instanceof f)) {
            return false;
        }
        synchronized (this.f8827c) {
            try {
                i9 = this.f8833j;
                i10 = this.f8834k;
                obj = this.f8831g;
                cls = this.h;
                aVar = this.f8832i;
                gVar = this.f8835l;
                List list = this.f8837n;
                size = list != null ? list.size() : 0;
            } finally {
            }
        }
        f fVar = (f) cVar;
        synchronized (fVar.f8827c) {
            try {
                i11 = fVar.f8833j;
                i12 = fVar.f8834k;
                obj2 = fVar.f8831g;
                cls2 = fVar.h;
                aVar2 = fVar.f8832i;
                gVar2 = fVar.f8835l;
                List list2 = fVar.f8837n;
                size2 = list2 != null ? list2.size() : 0;
            } finally {
            }
        }
        if (i9 == i11 && i10 == i12) {
            char[] cArr = w4.n.f9951a;
            if ((obj == null ? obj2 == null : obj.equals(obj2)) && cls.equals(cls2)) {
                if ((aVar == null ? aVar2 == null : aVar.f(aVar2)) && gVar == gVar2 && size == size2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void k(a0 a0Var, Object obj, int i9) {
        d dVar = this.f8828d;
        if (dVar != null) {
            dVar.getRoot().a();
        }
        this.B = 4;
        this.f8840q = a0Var;
        if (this.f8830f.f1765i <= 3) {
            Log.d("Glide", "Finished loading " + obj.getClass().getSimpleName() + " from " + androidx.activity.g.C(i9) + " for " + this.f8831g + " with size [" + this.f8847x + "x" + this.f8848y + "] in " + h.a(this.f8842s) + " ms");
        }
        if (dVar != null) {
            dVar.c(this);
        }
        this.f8849z = true;
        try {
            List list = this.f8837n;
            if (list != null) {
                Iterator it = list.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            }
            this.f8838o.getClass();
            this.f8836m.i(obj);
            this.f8849z = false;
        } catch (Throwable th) {
            this.f8849z = false;
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(int i9, int i10) {
        f fVar = this;
        int i11 = i9;
        fVar.f8826b.a();
        Object obj = fVar.f8827c;
        synchronized (obj) {
            try {
                try {
                    boolean z8 = C;
                    if (z8) {
                        fVar.e("Got onSizeReady in " + h.a(fVar.f8842s));
                    }
                    if (fVar.B == 3) {
                        fVar.B = 2;
                        fVar.f8832i.getClass();
                        if (i11 != Integer.MIN_VALUE) {
                            i11 = Math.round(i11 * 1.0f);
                        }
                        fVar.f8847x = i11;
                        fVar.f8848y = i10 == Integer.MIN_VALUE ? i10 : Math.round(1.0f * i10);
                        if (z8) {
                            fVar.e("finished setup for calling load in " + h.a(fVar.f8842s));
                        }
                        n nVar = fVar.f8843t;
                        com.bumptech.glide.e eVar = fVar.f8830f;
                        Object obj2 = fVar.f8831g;
                        a aVar = fVar.f8832i;
                        b4.f fVar2 = aVar.f8810q;
                        try {
                            int i12 = fVar.f8847x;
                            int i13 = fVar.f8848y;
                            Class cls = aVar.f8814u;
                            try {
                                Class cls2 = fVar.h;
                                com.bumptech.glide.g gVar = fVar.f8835l;
                                m mVar = aVar.f8803j;
                                try {
                                    w4.c cVar = aVar.f8813t;
                                    boolean z9 = aVar.f8811r;
                                    boolean z10 = aVar.f8817x;
                                    try {
                                        i iVar = aVar.f8812s;
                                        boolean z11 = aVar.f8807n;
                                        boolean z12 = aVar.f8818y;
                                        j0 j0Var = fVar.f8839p;
                                        fVar = obj;
                                        try {
                                            fVar.f8841r = nVar.a(eVar, obj2, fVar2, i12, i13, cls, cls2, gVar, mVar, cVar, z9, z10, iVar, z11, z12, fVar, j0Var);
                                            if (fVar.B != 2) {
                                                fVar.f8841r = null;
                                            }
                                            if (z8) {
                                                fVar.e("finished onSizeReady in " + h.a(fVar.f8842s));
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        fVar = obj;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    fVar = obj;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                fVar = obj;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            fVar = obj;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable th7) {
                th = th7;
                fVar = obj;
            }
        }
    }

    @Override // s4.c
    public final void pause() {
        synchronized (this.f8827c) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String toString() {
        Object obj;
        Class cls;
        synchronized (this.f8827c) {
            obj = this.f8831g;
            cls = this.h;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }
}
