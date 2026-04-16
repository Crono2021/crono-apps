package r1;

import j1.h;
import java.nio.ByteBuffer;
import z2.i;
import z2.j;
import z2.l;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends h implements z2.g {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f8523o = 1;

    /* renamed from: p, reason: collision with root package name */
    public final Object f8524p;

    public b(String str, l lVar) {
        super(new i[2], new j[2]);
        int i9 = this.f5375g;
        j1.e[] eVarArr = this.f5373e;
        g1.a.k(i9 == eVarArr.length);
        for (j1.e eVar : eVarArr) {
            eVar.m(1024);
        }
        this.f8524p = lVar;
    }

    @Override // j1.h
    public final j1.e e() {
        switch (this.f8523o) {
            case 0:
                return new j1.e(1, 0);
            default:
                return new i();
        }
    }

    @Override // j1.h
    public final j1.f f() {
        switch (this.f8523o) {
            case 0:
                return new a(this);
            default:
                return new z2.e(this);
        }
    }

    @Override // j1.h
    public final j1.c g(Throwable th) {
        switch (this.f8523o) {
            case 0:
                return new d("Unexpected decode error", th);
            default:
                return new z2.h("Unexpected decode error", th);
        }
    }

    @Override // j1.h
    public final j1.c h(j1.e eVar, j1.f fVar, boolean z8) {
        switch (this.f8523o) {
            case 0:
                a aVar = (a) fVar;
                try {
                    ByteBuffer byteBuffer = eVar.f5359m;
                    byteBuffer.getClass();
                    g1.a.k(byteBuffer.hasArray());
                    g1.a.f(byteBuffer.arrayOffset() == 0);
                    m7.c cVar = (m7.c) this.f8524p;
                    byte[] array = byteBuffer.array();
                    int remaining = byteBuffer.remaining();
                    cVar.getClass();
                    aVar.f8521m = m7.c.b(array, remaining);
                    aVar.f5365k = eVar.f5361o;
                    return null;
                } catch (d e9) {
                    return e9;
                }
            default:
                i iVar = (i) eVar;
                j jVar = (j) fVar;
                try {
                    ByteBuffer byteBuffer2 = iVar.f5359m;
                    byteBuffer2.getClass();
                    byte[] array2 = byteBuffer2.array();
                    int limit = byteBuffer2.limit();
                    l lVar = (l) this.f8524p;
                    if (z8) {
                        lVar.reset();
                    }
                    z2.f h02 = lVar.h0(0, limit, array2);
                    long j5 = iVar.f5361o;
                    long j9 = iVar.f10617s;
                    jVar.f5365k = j5;
                    jVar.f10618m = h02;
                    if (j9 != Long.MAX_VALUE) {
                        j5 = j9;
                    }
                    jVar.f10619n = j5;
                    jVar.f3748j &= Integer.MAX_VALUE;
                    return null;
                } catch (z2.h e10) {
                    return e10;
                }
        }
    }

    @Override // z2.g
    public void a(long j5) {
    }

    public b(m7.c cVar) {
        super(new j1.e[1], new a[1]);
        this.f8524p = cVar;
    }
}
