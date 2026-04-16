package s1;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g extends j1.e {

    /* renamed from: s, reason: collision with root package name */
    public long f8702s;

    /* renamed from: t, reason: collision with root package name */
    public int f8703t;

    /* renamed from: u, reason: collision with root package name */
    public int f8704u;

    @Override // j1.e
    public final void k() {
        super.k();
        this.f8703t = 0;
    }

    public final boolean o(j1.e eVar) {
        ByteBuffer byteBuffer;
        g1.a.f(!eVar.c(1073741824));
        g1.a.f(!eVar.c(268435456));
        g1.a.f(!eVar.c(4));
        if (p()) {
            if (this.f8703t >= this.f8704u) {
                return false;
            }
            ByteBuffer byteBuffer2 = eVar.f5359m;
            if (byteBuffer2 != null && (byteBuffer = this.f5359m) != null) {
                if (byteBuffer2.remaining() + byteBuffer.position() > 3072000) {
                    return false;
                }
            }
        }
        int i9 = this.f8703t;
        this.f8703t = i9 + 1;
        if (i9 == 0) {
            this.f5361o = eVar.f5361o;
            if (eVar.c(1)) {
                this.f3748j = 1;
            }
        }
        ByteBuffer byteBuffer3 = eVar.f5359m;
        if (byteBuffer3 != null) {
            m(byteBuffer3.remaining());
            this.f5359m.put(byteBuffer3);
        }
        this.f8702s = eVar.f5361o;
        return true;
    }

    public final boolean p() {
        return this.f8703t > 0;
    }
}
