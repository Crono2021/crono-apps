package s4;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import b4.h;
import b4.i;
import d4.m;
import k4.o;
import k4.t;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import w4.n;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a implements Cloneable {

    /* renamed from: i, reason: collision with root package name */
    public int f8802i;

    /* renamed from: l, reason: collision with root package name */
    public int f8805l;

    /* renamed from: m, reason: collision with root package name */
    public int f8806m;

    /* renamed from: r, reason: collision with root package name */
    public boolean f8811r;

    /* renamed from: v, reason: collision with root package name */
    public boolean f8815v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f8816w;

    /* renamed from: y, reason: collision with root package name */
    public boolean f8818y;

    /* renamed from: j, reason: collision with root package name */
    public m f8803j = m.f2881d;

    /* renamed from: k, reason: collision with root package name */
    public com.bumptech.glide.g f8804k = com.bumptech.glide.g.f1770k;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8807n = true;

    /* renamed from: o, reason: collision with root package name */
    public int f8808o = -1;

    /* renamed from: p, reason: collision with root package name */
    public int f8809p = -1;

    /* renamed from: q, reason: collision with root package name */
    public b4.f f8810q = v4.a.f9574b;

    /* renamed from: s, reason: collision with root package name */
    public i f8812s = new i();

    /* renamed from: t, reason: collision with root package name */
    public w4.c f8813t = new w4.c();

    /* renamed from: u, reason: collision with root package name */
    public Class f8814u = Object.class;

    /* renamed from: x, reason: collision with root package name */
    public boolean f8817x = true;

    public static boolean g(int i9, int i10) {
        return (i9 & i10) != 0;
    }

    public a a(a aVar) {
        if (this.f8816w) {
            return clone().a(aVar);
        }
        int i9 = aVar.f8802i;
        if (g(aVar.f8802i, 1048576)) {
            this.f8818y = aVar.f8818y;
        }
        if (g(aVar.f8802i, 4)) {
            this.f8803j = aVar.f8803j;
        }
        if (g(aVar.f8802i, 8)) {
            this.f8804k = aVar.f8804k;
        }
        if (g(aVar.f8802i, 16)) {
            this.f8805l = 0;
            this.f8802i &= -33;
        }
        if (g(aVar.f8802i, 32)) {
            this.f8805l = aVar.f8805l;
            this.f8802i &= -17;
        }
        if (g(aVar.f8802i, 64)) {
            this.f8806m = 0;
            this.f8802i &= -129;
        }
        if (g(aVar.f8802i, 128)) {
            this.f8806m = aVar.f8806m;
            this.f8802i &= -65;
        }
        if (g(aVar.f8802i, 256)) {
            this.f8807n = aVar.f8807n;
        }
        if (g(aVar.f8802i, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED)) {
            this.f8809p = aVar.f8809p;
            this.f8808o = aVar.f8808o;
        }
        if (g(aVar.f8802i, 1024)) {
            this.f8810q = aVar.f8810q;
        }
        if (g(aVar.f8802i, 4096)) {
            this.f8814u = aVar.f8814u;
        }
        if (g(aVar.f8802i, 8192)) {
            this.f8802i &= -16385;
        }
        if (g(aVar.f8802i, 16384)) {
            this.f8802i &= -8193;
        }
        if (g(aVar.f8802i, 131072)) {
            this.f8811r = aVar.f8811r;
        }
        if (g(aVar.f8802i, IjkMediaMeta.FF_PROFILE_H264_INTRA)) {
            this.f8813t.putAll(aVar.f8813t);
            this.f8817x = aVar.f8817x;
        }
        this.f8802i |= aVar.f8802i;
        this.f8812s.f1331b.i(aVar.f8812s.f1331b);
        l();
        return this;
    }

    @Override // 
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a clone() {
        try {
            a aVar = (a) super.clone();
            i iVar = new i();
            aVar.f8812s = iVar;
            iVar.f1331b.i(this.f8812s.f1331b);
            w4.c cVar = new w4.c();
            aVar.f8813t = cVar;
            cVar.putAll(this.f8813t);
            aVar.f8815v = false;
            aVar.f8816w = false;
            return aVar;
        } catch (CloneNotSupportedException e9) {
            throw new RuntimeException(e9);
        }
    }

    public final a c(Class cls) {
        if (this.f8816w) {
            return clone().c(cls);
        }
        this.f8814u = cls;
        this.f8802i |= 4096;
        l();
        return this;
    }

    public final a d(m mVar) {
        if (this.f8816w) {
            return clone().d(mVar);
        }
        this.f8803j = mVar;
        this.f8802i |= 4;
        l();
        return this;
    }

    public final a e(int i9) {
        if (this.f8816w) {
            return clone().e(i9);
        }
        this.f8805l = i9;
        this.f8802i = (this.f8802i | 32) & (-17);
        l();
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return f((a) obj);
        }
        return false;
    }

    public final boolean f(a aVar) {
        aVar.getClass();
        if (Float.compare(1.0f, 1.0f) != 0 || this.f8805l != aVar.f8805l) {
            return false;
        }
        char[] cArr = n.f9951a;
        return this.f8806m == aVar.f8806m && this.f8807n == aVar.f8807n && this.f8808o == aVar.f8808o && this.f8809p == aVar.f8809p && this.f8811r == aVar.f8811r && this.f8803j.equals(aVar.f8803j) && this.f8804k == aVar.f8804k && this.f8812s.equals(aVar.f8812s) && this.f8813t.equals(aVar.f8813t) && this.f8814u.equals(aVar.f8814u) && this.f8810q.equals(aVar.f8810q);
    }

    public final a h(o oVar, k4.e eVar) {
        if (this.f8816w) {
            return clone().h(oVar, eVar);
        }
        m(o.f5580g, oVar);
        return p(eVar, false);
    }

    public int hashCode() {
        char[] cArr = n.f9951a;
        return n.h(n.h(n.h(n.h(n.h(n.h(n.h(n.g(0, n.g(0, n.g(1, n.g(this.f8811r ? 1 : 0, n.g(this.f8809p, n.g(this.f8808o, n.g(this.f8807n ? 1 : 0, n.h(n.g(0, n.h(n.g(this.f8806m, n.h(n.g(this.f8805l, n.g(Float.floatToIntBits(1.0f), 17)), null)), null)), null)))))))), this.f8803j), this.f8804k), this.f8812s), this.f8813t), this.f8814u), this.f8810q), null);
    }

    public final a i(int i9, int i10) {
        if (this.f8816w) {
            return clone().i(i9, i10);
        }
        this.f8809p = i9;
        this.f8808o = i10;
        this.f8802i |= IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED;
        l();
        return this;
    }

    public final a j(int i9) {
        if (this.f8816w) {
            return clone().j(i9);
        }
        this.f8806m = i9;
        this.f8802i = (this.f8802i | 128) & (-65);
        l();
        return this;
    }

    public final a k() {
        if (this.f8816w) {
            return clone().k();
        }
        this.f8804k = com.bumptech.glide.g.f1771l;
        this.f8802i |= 8;
        l();
        return this;
    }

    public final void l() {
        if (this.f8815v) {
            m7.c.p("You cannot modify locked T, consider clone()");
        }
    }

    public final a m(h hVar, o oVar) {
        if (this.f8816w) {
            return clone().m(hVar, oVar);
        }
        w4.f.b(hVar);
        this.f8812s.f1331b.put(hVar, oVar);
        l();
        return this;
    }

    public final a n(v4.b bVar) {
        if (this.f8816w) {
            return clone().n(bVar);
        }
        this.f8810q = bVar;
        this.f8802i |= 1024;
        l();
        return this;
    }

    public final a o() {
        if (this.f8816w) {
            return clone().o();
        }
        this.f8807n = false;
        this.f8802i |= 256;
        l();
        return this;
    }

    public final a p(b4.m mVar, boolean z8) {
        if (this.f8816w) {
            return clone().p(mVar, z8);
        }
        t tVar = new t(mVar, z8);
        q(Bitmap.class, mVar, z8);
        q(Drawable.class, tVar, z8);
        q(BitmapDrawable.class, tVar, z8);
        q(o4.c.class, new o4.e(mVar), z8);
        l();
        return this;
    }

    public final a q(Class cls, b4.m mVar, boolean z8) {
        if (this.f8816w) {
            return clone().q(cls, mVar, z8);
        }
        w4.f.b(mVar);
        this.f8813t.put(cls, mVar);
        int i9 = this.f8802i;
        this.f8802i = 67584 | i9;
        this.f8817x = false;
        if (z8) {
            this.f8802i = i9 | 198656;
            this.f8811r = true;
        }
        l();
        return this;
    }

    public final a r(o oVar, k4.e eVar) {
        if (this.f8816w) {
            return clone().r(oVar, eVar);
        }
        m(o.f5580g, oVar);
        return p(eVar, true);
    }

    public final a s() {
        if (this.f8816w) {
            return clone().s();
        }
        this.f8818y = true;
        this.f8802i |= 1048576;
        l();
        return this;
    }
}
