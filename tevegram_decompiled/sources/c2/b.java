package c2;

import d1.s;
import g1.p;
import g1.w;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends l1.e {
    public final p A;
    public long B;
    public a C;
    public long D;

    /* renamed from: z, reason: collision with root package name */
    public final j1.e f1545z;

    public b() {
        super(6);
        this.f1545z = new j1.e(1, 0);
        this.A = new p();
    }

    @Override // l1.b1
    public final boolean b() {
        return true;
    }

    @Override // l1.b1
    public final void f(long j5, long j9) {
        float[] fArr;
        while (!m() && this.D < 100000 + j5) {
            j1.e eVar = this.f1545z;
            eVar.k();
            a5.d dVar = this.f5828k;
            dVar.o0();
            if (w(dVar, eVar, 0) != -4 || eVar.c(4)) {
                return;
            }
            long j10 = eVar.f5361o;
            this.D = j10;
            boolean z8 = j10 < this.f5837t;
            if (this.C != null && !z8) {
                eVar.n();
                ByteBuffer byteBuffer = eVar.f5359m;
                int i9 = w.f3713a;
                if (byteBuffer.remaining() != 16) {
                    fArr = null;
                } else {
                    byte[] array = byteBuffer.array();
                    int limit = byteBuffer.limit();
                    p pVar = this.A;
                    pVar.D(array, limit);
                    pVar.F(byteBuffer.arrayOffset() + 4);
                    float[] fArr2 = new float[3];
                    for (int i10 = 0; i10 < 3; i10++) {
                        fArr2[i10] = Float.intBitsToFloat(pVar.i());
                    }
                    fArr = fArr2;
                }
                if (fArr != null) {
                    this.C.c(this.D - this.B, fArr);
                }
            }
        }
    }

    @Override // l1.e, l1.x0
    public final void g(int i9, Object obj) {
        if (i9 == 8) {
            this.C = (a) obj;
        }
    }

    @Override // l1.b1
    public final String getName() {
        return "CameraMotionRenderer";
    }

    @Override // l1.e
    public final void n() {
        a aVar = this.C;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // l1.e
    public final void q(long j5, boolean z8) {
        this.D = Long.MIN_VALUE;
        a aVar = this.C;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // l1.e
    public final void v(s[] sVarArr, long j5, long j9) {
        this.B = j9;
    }

    @Override // l1.e
    public final int z(s sVar) {
        return "application/x-camera-motion".equals(sVar.f2554m) ? androidx.activity.g.f(4, 0, 0, 0) : androidx.activity.g.f(0, 0, 0, 0);
    }
}
