package d2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u implements z2.l {

    /* renamed from: i, reason: collision with root package name */
    public final g1.p f2741i;

    public u(int i9) {
        switch (i9) {
            case 1:
                this.f2741i = new g1.p();
                break;
            default:
                this.f2741i = new g1.p(10);
                break;
        }
    }

    @Override // z2.l
    public void a0(byte[] bArr, int i9, int i10, z2.k kVar, g1.c cVar) {
        f1.b a9;
        g1.p pVar = this.f2741i;
        pVar.D(bArr, i9 + i10);
        pVar.F(i9);
        ArrayList arrayList = new ArrayList();
        while (pVar.a() > 0) {
            g1.a.e("Incomplete Mp4Webvtt Top Level box header found.", pVar.a() >= 8);
            int g9 = pVar.g();
            if (pVar.g() == 1987343459) {
                int i11 = g9 - 8;
                CharSequence charSequence = null;
                f1.a aVar = null;
                while (i11 > 0) {
                    g1.a.e("Incomplete vtt cue box header found.", i11 >= 8);
                    int g10 = pVar.g();
                    int g11 = pVar.g();
                    int i12 = g10 - 8;
                    byte[] bArr2 = pVar.f3699a;
                    int i13 = pVar.f3700b;
                    int i14 = g1.w.f3713a;
                    String str = new String(bArr2, i13, i12, a6.b.f203c);
                    pVar.G(i12);
                    i11 = (i11 - 8) - i12;
                    if (g11 == 1937011815) {
                        h3.g gVar = new h3.g();
                        h3.h.e(str, gVar);
                        aVar = gVar.a();
                    } else if (g11 == 1885436268) {
                        charSequence = h3.h.f(null, str.trim(), Collections.EMPTY_LIST);
                    }
                }
                if (charSequence == null) {
                    charSequence = "";
                }
                if (aVar != null) {
                    aVar.f3218a = charSequence;
                    a9 = aVar.a();
                } else {
                    Pattern pattern = h3.h.f3954a;
                    h3.g gVar2 = new h3.g();
                    gVar2.f3946c = charSequence;
                    a9 = gVar2.a().a();
                }
                arrayList.add(a9);
            } else {
                pVar.G(g9 - 8);
            }
        }
        cVar.accept(new z2.a(-9223372036854775807L, -9223372036854775807L, arrayList));
    }

    @Override // z2.l
    public /* synthetic */ z2.f h0(int i9, int i10, byte[] bArr) {
        return t.a.a(this, bArr, i10);
    }

    @Override // z2.l
    public /* synthetic */ void reset() {
    }
}
