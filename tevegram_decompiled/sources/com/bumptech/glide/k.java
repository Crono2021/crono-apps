package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import b6.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import w4.n;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k extends s4.a {
    public final m A;
    public final Class B;
    public final e C;
    public a D;
    public Object E;
    public ArrayList F;
    public k G;
    public k H;
    public final boolean I = true;
    public boolean J;
    public boolean K;

    /* renamed from: z, reason: collision with root package name */
    public final Context f1784z;

    static {
    }

    public k(b bVar, m mVar, Class cls, Context context) {
        s4.e eVar;
        this.A = mVar;
        this.B = cls;
        this.f1784z = context;
        s.d dVar = mVar.f1815i.f1733k.f1763f;
        a aVar = (a) dVar.getOrDefault(cls, null);
        if (aVar == null) {
            Iterator it = ((s) dVar.entrySet()).iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    aVar = (a) entry.getValue();
                }
            }
        }
        this.D = aVar == null ? e.f1757k : aVar;
        this.C = bVar.f1733k;
        Iterator it2 = mVar.f1823q.iterator();
        while (it2.hasNext()) {
            if (it2.next() != null) {
                androidx.fragment.app.a.c();
                throw null;
            }
            t();
        }
        synchronized (mVar) {
            eVar = mVar.f1824r;
        }
        a(eVar);
    }

    @Override // s4.a
    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return super.equals(kVar) && Objects.equals(this.B, kVar.B) && this.D.equals(kVar.D) && Objects.equals(this.E, kVar.E) && Objects.equals(this.F, kVar.F) && Objects.equals(this.G, kVar.G) && Objects.equals(this.H, kVar.H) && this.I == kVar.I && this.J == kVar.J;
    }

    @Override // s4.a
    public final int hashCode() {
        return n.g(this.J ? 1 : 0, n.g(this.I ? 1 : 0, n.h(n.h(n.h(n.h(n.h(n.h(n.h(super.hashCode(), this.B), this.D), this.E), this.F), this.G), this.H), null)));
    }

    public final k t() {
        if (this.f8816w) {
            return clone().t();
        }
        l();
        return this;
    }

    @Override // s4.a
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public final k a(s4.a aVar) {
        w4.f.b(aVar);
        return (k) super.a(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final s4.c v(Object obj, t4.b bVar, s4.d dVar, a aVar, g gVar, int i9, int i10, s4.a aVar2) {
        s4.d dVar2;
        s4.d dVar3;
        s4.a aVar3;
        s4.f fVar;
        g gVar2;
        if (this.H != null) {
            dVar3 = new s4.b(obj, dVar);
            dVar2 = dVar3;
        } else {
            dVar2 = null;
            dVar3 = dVar;
        }
        k kVar = this.G;
        if (kVar == null) {
            Context context = this.f1784z;
            e eVar = this.C;
            aVar3 = aVar2;
            fVar = new s4.f(context, eVar, obj, this.E, this.B, aVar3, i9, i10, gVar, bVar, this.F, dVar3, eVar.f1764g, aVar.f1728i);
        } else {
            if (this.K) {
                m7.c.p("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
                return null;
            }
            a aVar4 = kVar.I ? aVar : kVar.D;
            if (s4.a.g(kVar.f8802i, 8)) {
                gVar2 = this.G.f8804k;
            } else {
                int ordinal = gVar.ordinal();
                if (ordinal == 0 || ordinal == 1) {
                    gVar2 = g.f1768i;
                } else if (ordinal == 2) {
                    gVar2 = g.f1769j;
                } else {
                    if (ordinal != 3) {
                        androidx.fragment.app.a.g(this.f8804k, "unknown priority: ");
                        return null;
                    }
                    gVar2 = g.f1770k;
                }
            }
            g gVar3 = gVar2;
            k kVar2 = this.G;
            int i11 = kVar2.f8809p;
            int i12 = kVar2.f8808o;
            if (n.i(i9, i10)) {
                k kVar3 = this.G;
                if (!n.i(kVar3.f8809p, kVar3.f8808o)) {
                    i11 = aVar2.f8809p;
                    i12 = aVar2.f8808o;
                }
            }
            int i13 = i12;
            s4.g gVar4 = new s4.g(obj, dVar3);
            Context context2 = this.f1784z;
            s4.g gVar5 = gVar4;
            e eVar2 = this.C;
            s4.f fVar2 = new s4.f(context2, eVar2, obj, this.E, this.B, aVar2, i9, i10, gVar, bVar, this.F, gVar5, eVar2.f1764g, aVar.f1728i);
            this.K = true;
            k kVar4 = this.G;
            s4.c v8 = kVar4.v(obj, bVar, gVar5, aVar4, gVar3, i11, i13, kVar4);
            this.K = false;
            gVar5.f8852c = fVar2;
            gVar5.f8853d = v8;
            aVar3 = aVar2;
            fVar = gVar5;
        }
        if (dVar2 == null) {
            return fVar;
        }
        k kVar5 = this.H;
        int i14 = kVar5.f8809p;
        int i15 = kVar5.f8808o;
        if (n.i(i9, i10)) {
            k kVar6 = this.H;
            if (!n.i(kVar6.f8809p, kVar6.f8808o)) {
                i14 = aVar3.f8809p;
                i15 = aVar3.f8808o;
            }
        }
        int i16 = i15;
        k kVar7 = this.H;
        s4.b bVar2 = dVar2;
        s4.c v9 = kVar7.v(obj, bVar, bVar2, kVar7.D, kVar7.f8804k, i14, i16, kVar7);
        bVar2.f8821c = fVar;
        bVar2.f8822d = v9;
        return bVar2;
    }

    @Override // s4.a
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final k clone() {
        k kVar = (k) super.clone();
        kVar.D = kVar.D.clone();
        if (kVar.F != null) {
            kVar.F = new ArrayList(kVar.F);
        }
        k kVar2 = kVar.G;
        if (kVar2 != null) {
            kVar.G = kVar2.clone();
        }
        k kVar3 = kVar.H;
        if (kVar3 != null) {
            kVar.H = kVar3.clone();
        }
        return kVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x(android.widget.ImageView r5) {
        /*
            r4 = this;
            w4.n.a()
            w4.f.b(r5)
            r0 = 2048(0x800, float:2.87E-42)
            int r1 = r4.f8802i
            boolean r0 = s4.a.g(r1, r0)
            if (r0 != 0) goto L6d
            android.widget.ImageView$ScaleType r0 = r5.getScaleType()
            if (r0 == 0) goto L6d
            int[] r0 = com.bumptech.glide.j.f1782a
            android.widget.ImageView$ScaleType r1 = r5.getScaleType()
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            switch(r0) {
                case 1: goto L5d;
                case 2: goto L4b;
                case 3: goto L39;
                case 4: goto L39;
                case 5: goto L39;
                case 6: goto L27;
                default: goto L26;
            }
        L26:
            goto L6d
        L27:
            com.bumptech.glide.k r0 = r4.clone()
            k4.o r2 = k4.o.f5576c
            k4.i r3 = new k4.i
            r3.<init>()
            s4.a r0 = r0.h(r2, r3)
            r0.f8817x = r1
            goto L6e
        L39:
            com.bumptech.glide.k r0 = r4.clone()
            k4.o r2 = k4.o.f5575b
            k4.v r3 = new k4.v
            r3.<init>()
            s4.a r0 = r0.h(r2, r3)
            r0.f8817x = r1
            goto L6e
        L4b:
            com.bumptech.glide.k r0 = r4.clone()
            k4.o r2 = k4.o.f5576c
            k4.i r3 = new k4.i
            r3.<init>()
            s4.a r0 = r0.h(r2, r3)
            r0.f8817x = r1
            goto L6e
        L5d:
            com.bumptech.glide.k r0 = r4.clone()
            k4.o r1 = k4.o.f5577d
            k4.h r2 = new k4.h
            r2.<init>()
            s4.a r0 = r0.h(r1, r2)
            goto L6e
        L6d:
            r0 = r4
        L6e:
            com.bumptech.glide.e r1 = r4.C
            o4.d r1 = r1.f1760c
            r1.getClass()
            java.lang.Class<android.graphics.Bitmap> r1 = android.graphics.Bitmap.class
            java.lang.Class r2 = r4.B
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L86
            t4.a r1 = new t4.a
            r2 = 0
            r1.<init>(r5, r2)
            goto L94
        L86:
            java.lang.Class<android.graphics.drawable.Drawable> r1 = android.graphics.drawable.Drawable.class
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L98
            t4.a r1 = new t4.a
            r2 = 1
            r1.<init>(r5, r2)
        L94:
            r4.y(r1, r0)
            return
        L98:
            java.lang.String r5 = "Unhandled class: "
            java.lang.String r0 = ", try .as*(Class).transcode(ResourceTranscoder)"
            androidx.fragment.app.a.m(r2, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.k.x(android.widget.ImageView):void");
    }

    public final void y(t4.b bVar, s4.a aVar) {
        w4.f.b(bVar);
        if (!this.J) {
            m7.c.n("You must call #load() before calling #into()");
            return;
        }
        s4.c v8 = v(new Object(), bVar, null, this.D, aVar.f8804k, aVar.f8809p, aVar.f8808o, aVar);
        s4.c g9 = bVar.g();
        if (v8.j(g9) && (aVar.f8807n || !g9.i())) {
            w4.f.c(g9, "Argument must not be null");
            if (g9.isRunning()) {
                return;
            }
            g9.g();
            return;
        }
        this.A.l(bVar);
        bVar.a(v8);
        m mVar = this.A;
        synchronized (mVar) {
            mVar.f1820n.f1860i.add(bVar);
            com.bumptech.glide.manager.s sVar = mVar.f1818l;
            ((Set) sVar.f1858k).add(v8);
            if (sVar.f1857j) {
                v8.clear();
                if (Log.isLoggable("RequestTracker", 2)) {
                    Log.v("RequestTracker", "Paused, delaying request");
                }
                ((HashSet) sVar.f1859l).add(v8);
            } else {
                v8.g();
            }
        }
    }

    public final k z(Object obj) {
        if (this.f8816w) {
            return clone().z(obj);
        }
        this.E = obj;
        this.J = true;
        l();
        return this;
    }
}
