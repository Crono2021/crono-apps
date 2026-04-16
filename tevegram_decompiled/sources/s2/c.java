package s2;

import d1.i0;
import d1.j0;
import g1.p;
import g1.u;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends android.support.v4.media.session.b {

    /* renamed from: o, reason: collision with root package name */
    public final p f8767o = new p();

    /* renamed from: p, reason: collision with root package name */
    public final a3.g f8768p = new a3.g();

    /* renamed from: q, reason: collision with root package name */
    public u f8769q;

    @Override // android.support.v4.media.session.b
    public final j0 B(l2.a aVar, ByteBuffer byteBuffer) {
        int i9;
        i0 fVar;
        int i10;
        long j5;
        long j9;
        boolean z8;
        boolean z9;
        boolean z10;
        int i11;
        int i12;
        int i13;
        long j10;
        boolean z11;
        long j11;
        long j12;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        int i14;
        int i15;
        int i16;
        char c9;
        long j13;
        boolean z16;
        u uVar = this.f8769q;
        if (uVar == null || aVar.f6080s != uVar.e()) {
            u uVar2 = new u(aVar.f5361o);
            this.f8769q = uVar2;
            uVar2.a(aVar.f5361o - aVar.f6080s);
        }
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        p pVar = this.f8767o;
        pVar.D(array, limit);
        a3.g gVar = this.f8768p;
        gVar.o(array, limit);
        gVar.s(39);
        long i17 = (gVar.i(1) << 32) | gVar.i(32);
        gVar.s(20);
        int i18 = gVar.i(12);
        int i19 = gVar.i(8);
        pVar.G(14);
        if (i19 == 0) {
            i9 = 0;
            fVar = new f();
        } else if (i19 != 255) {
            long j14 = -9223372036854775807L;
            if (i19 == 4) {
                int t8 = pVar.t();
                ArrayList arrayList = new ArrayList(t8);
                int i20 = 0;
                while (i20 < t8) {
                    long v8 = pVar.v();
                    boolean z17 = (pVar.t() & 128) != 0;
                    ArrayList arrayList2 = new ArrayList();
                    if (z17) {
                        i10 = t8;
                        j5 = -9223372036854775807L;
                        j9 = -9223372036854775807L;
                        z8 = false;
                        z9 = false;
                        z10 = false;
                        i11 = 0;
                        i12 = 0;
                        i13 = 0;
                    } else {
                        int t9 = pVar.t();
                        boolean z18 = (t9 & 128) != 0;
                        boolean z19 = (t9 & 64) != 0;
                        boolean z20 = (t9 & 32) != 0;
                        long v9 = z19 ? pVar.v() : -9223372036854775807L;
                        if (!z19) {
                            int t10 = pVar.t();
                            ArrayList arrayList3 = new ArrayList(t10);
                            int i21 = 0;
                            while (i21 < t10) {
                                arrayList3.add(new g(pVar.t(), pVar.v()));
                                i21++;
                                t8 = t8;
                            }
                            arrayList2 = arrayList3;
                        }
                        i10 = t8;
                        if (z20) {
                            long t11 = pVar.t();
                            z11 = (t11 & 128) != 0;
                            j10 = ((((t11 & 1) << 32) | pVar.v()) * 1000) / 90;
                        } else {
                            j10 = -9223372036854775807L;
                            z11 = false;
                        }
                        j9 = j10;
                        z10 = z11;
                        i11 = pVar.z();
                        z8 = z18;
                        z9 = z19;
                        j5 = v9;
                        i12 = pVar.t();
                        i13 = pVar.t();
                    }
                    arrayList.add(new h(v8, z17, z8, z9, arrayList2, j5, z10, j9, i11, i12, i13));
                    i20++;
                    t8 = i10;
                }
                fVar = new i(arrayList);
            } else if (i19 == 5) {
                u uVar3 = this.f8769q;
                long v10 = pVar.v();
                boolean z21 = (pVar.t() & 128) != 0;
                List list = Collections.EMPTY_LIST;
                if (z21) {
                    j11 = -9223372036854775807L;
                    j12 = -9223372036854775807L;
                    z12 = false;
                    z13 = false;
                    z14 = false;
                    z15 = false;
                    i14 = 0;
                    i15 = 0;
                    i16 = 0;
                } else {
                    int t12 = pVar.t();
                    boolean z22 = (t12 & 128) != 0;
                    boolean z23 = (t12 & 64) != 0;
                    boolean z24 = (t12 & 32) != 0;
                    boolean z25 = (t12 & 16) != 0;
                    long d9 = (!z23 || z25) ? -9223372036854775807L : j.d(i17, pVar);
                    if (z23) {
                        c9 = ' ';
                        j13 = 90;
                    } else {
                        int t13 = pVar.t();
                        c9 = ' ';
                        ArrayList arrayList4 = new ArrayList(t13);
                        j13 = 90;
                        for (int i22 = 0; i22 < t13; i22++) {
                            int t14 = pVar.t();
                            long d10 = !z25 ? j.d(i17, pVar) : -9223372036854775807L;
                            arrayList4.add(new d(t14, d10, uVar3.b(d10)));
                        }
                        list = arrayList4;
                    }
                    if (z24) {
                        long t15 = pVar.t();
                        z16 = (t15 & 128) != 0;
                        j14 = ((((t15 & 1) << c9) | pVar.v()) * 1000) / j13;
                    } else {
                        z16 = false;
                    }
                    int z26 = pVar.z();
                    int t16 = pVar.t();
                    z15 = z16;
                    i16 = pVar.t();
                    z14 = z25;
                    i14 = z26;
                    i15 = t16;
                    j12 = j14;
                    j11 = d9;
                    z12 = z22;
                    z13 = z23;
                }
                fVar = new e(v10, z21, z12, z13, z14, j11, uVar3.b(j11), list, z15, j12, i14, i15, i16);
            } else if (i19 != 6) {
                fVar = null;
            } else {
                u uVar4 = this.f8769q;
                long d11 = j.d(i17, pVar);
                fVar = new j(d11, uVar4.b(d11));
            }
            i9 = 0;
        } else {
            long v11 = pVar.v();
            int i23 = i18 - 4;
            byte[] bArr = new byte[i23];
            i9 = 0;
            pVar.e(0, i23, bArr);
            fVar = new a(v11, i17, bArr);
        }
        if (fVar == null) {
            return new j0(new i0[i9]);
        }
        i0[] i0VarArr = new i0[1];
        i0VarArr[i9] = fVar;
        return new j0(i0VarArr);
    }
}
