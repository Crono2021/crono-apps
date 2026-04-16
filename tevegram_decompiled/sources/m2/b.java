package m2;

import a3.g;
import d1.j0;
import g1.p;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends android.support.v4.media.session.b {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f6605o;

    public static n2.a D0(p pVar) {
        String o8 = pVar.o();
        o8.getClass();
        String o9 = pVar.o();
        o9.getClass();
        return new n2.a(o8, o9, pVar.n(), pVar.n(), Arrays.copyOfRange(pVar.f3699a, pVar.f3700b, pVar.f3701c));
    }

    @Override // android.support.v4.media.session.b
    public final j0 B(l2.a aVar, ByteBuffer byteBuffer) {
        switch (this.f6605o) {
            case 0:
                if (byteBuffer.get() != 116) {
                    return null;
                }
                g gVar = new g(byteBuffer.array(), byteBuffer.limit());
                int i9 = 12;
                gVar.s(12);
                int f9 = (gVar.f() + gVar.i(12)) - 4;
                gVar.s(44);
                gVar.t(gVar.i(12));
                gVar.s(16);
                ArrayList arrayList = new ArrayList();
                while (gVar.f() < f9) {
                    gVar.s(48);
                    int i10 = gVar.i(8);
                    gVar.s(4);
                    int f10 = gVar.f() + gVar.i(i9);
                    String str = null;
                    String str2 = null;
                    while (gVar.f() < f10) {
                        int i11 = gVar.i(8);
                        int i12 = gVar.i(8);
                        int f11 = gVar.f() + i12;
                        if (i11 == 2) {
                            int i13 = gVar.i(16);
                            gVar.s(8);
                            if (i13 == 3) {
                                while (gVar.f() < f11) {
                                    int i14 = gVar.i(8);
                                    Charset charset = a6.b.f201a;
                                    byte[] bArr = new byte[i14];
                                    gVar.k(bArr, i14);
                                    String str3 = new String(bArr, charset);
                                    int i15 = gVar.i(8);
                                    for (int i16 = 0; i16 < i15; i16++) {
                                        gVar.t(gVar.i(8));
                                    }
                                    str = str3;
                                }
                            }
                        } else if (i11 == 21) {
                            Charset charset2 = a6.b.f201a;
                            byte[] bArr2 = new byte[i12];
                            gVar.k(bArr2, i12);
                            str2 = new String(bArr2, charset2);
                        }
                        gVar.p(f11 * 8);
                    }
                    gVar.p(f10 * 8);
                    if (str != null && str2 != null) {
                        arrayList.add(new a(i10, str.concat(str2)));
                    }
                    i9 = 12;
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return new j0(arrayList);
            default:
                return new j0(D0(new p(byteBuffer.array(), byteBuffer.limit())));
        }
    }
}
