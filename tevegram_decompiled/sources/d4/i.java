package d4;

import android.graphics.Bitmap;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import d1.l0;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i implements o0.x, p4.a, s1.x {

    /* renamed from: i, reason: collision with root package name */
    public int f2851i;

    /* renamed from: j, reason: collision with root package name */
    public Object f2852j;

    public i(int i9) {
        switch (i9) {
            case 5:
                this.f2852j = Bitmap.CompressFormat.JPEG;
                this.f2851i = 100;
                break;
            case 6:
            default:
                this.f2852j = new long[32];
                break;
            case 7:
                this.f2852j = new g1.p(8);
                break;
        }
    }

    public void a(long j5) {
        int i9 = this.f2851i;
        long[] jArr = (long[]) this.f2852j;
        if (i9 == jArr.length) {
            this.f2852j = Arrays.copyOf(jArr, i9 * 2);
        }
        long[] jArr2 = (long[]) this.f2852j;
        int i10 = this.f2851i;
        this.f2851i = i10 + 1;
        jArr2[i10] = j5;
    }

    @Override // o0.x
    public boolean b(View view) {
        ((BottomSheetBehavior) this.f2852j).C(this.f2851i);
        return true;
    }

    @Override // s1.x
    public MediaCodecInfo c(int i9) {
        if (((MediaCodecInfo[]) this.f2852j) == null) {
            this.f2852j = new MediaCodecList(this.f2851i).getCodecInfos();
        }
        return ((MediaCodecInfo[]) this.f2852j)[i9];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public i3.f0 d(int r5, g1.o r6) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.i.d(int, g1.o):i3.f0");
    }

    public long e(int i9) {
        if (i9 >= 0 && i9 < this.f2851i) {
            return ((long[]) this.f2852j)[i9];
        }
        StringBuilder p5 = androidx.activity.g.p(i9, "Invalid index ", ", size is ");
        p5.append(this.f2851i);
        throw new IndexOutOfBoundsException(p5.toString());
    }

    public List f(g1.o oVar) {
        String str;
        int i9;
        List list = (List) this.f2852j;
        if (h(32)) {
            return list;
        }
        g1.p pVar = new g1.p((byte[]) oVar.f3695l);
        while (pVar.a() > 0) {
            int t8 = pVar.t();
            int t9 = pVar.f3700b + pVar.t();
            if (t8 == 134) {
                ArrayList arrayList = new ArrayList();
                int t10 = pVar.t() & 31;
                for (int i10 = 0; i10 < t10; i10++) {
                    String r8 = pVar.r(3, a6.b.f203c);
                    int t11 = pVar.t();
                    boolean z8 = (t11 & 128) != 0;
                    if (z8) {
                        i9 = t11 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i9 = 1;
                    }
                    byte t12 = (byte) pVar.t();
                    pVar.G(1);
                    List singletonList = z8 ? Collections.singletonList((t12 & 64) != 0 ? new byte[]{1} : new byte[]{0}) : null;
                    d1.r rVar = new d1.r();
                    rVar.f2528l = l0.k(str);
                    rVar.f2521d = r8;
                    rVar.D = i9;
                    rVar.f2530n = singletonList;
                    arrayList.add(new d1.s(rVar));
                }
                list = arrayList;
            }
            pVar.F(t9);
        }
        return list;
    }

    @Override // s1.x
    public boolean g(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }

    public boolean h(int i9) {
        return (i9 & this.f2851i) != 0;
    }

    @Override // s1.x
    public int i() {
        if (((MediaCodecInfo[]) this.f2852j) == null) {
            this.f2852j = new MediaCodecList(this.f2851i).getCodecInfos();
        }
        return ((MediaCodecInfo[]) this.f2852j).length;
    }

    public long j(d2.j jVar) {
        g1.p pVar = (g1.p) this.f2852j;
        int i9 = 0;
        jVar.n(pVar.f3699a, 0, 1, false);
        int i10 = pVar.f3699a[0] & 255;
        if (i10 == 0) {
            return Long.MIN_VALUE;
        }
        int i11 = 128;
        int i12 = 0;
        while ((i10 & i11) == 0) {
            i11 >>= 1;
            i12++;
        }
        int i13 = i10 & (~i11);
        jVar.n(pVar.f3699a, 1, i12, false);
        while (i9 < i12) {
            i9++;
            i13 = (pVar.f3699a[i9] & 255) + (i13 << 8);
        }
        this.f2851i = i12 + 1 + this.f2851i;
        return i13;
    }

    @Override // p4.a
    public a0 k(a0 a0Var, b4.i iVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) a0Var.get()).compress((Bitmap.CompressFormat) this.f2852j, this.f2851i, byteArrayOutputStream);
        a0Var.d();
        return new k4.a0(byteArrayOutputStream.toByteArray());
    }

    @Override // s1.x
    public boolean m(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    @Override // s1.x
    public boolean q() {
        return true;
    }

    public /* synthetic */ i(Object obj, int i9) {
        this.f2852j = obj;
        this.f2851i = i9;
    }

    public /* synthetic */ i(int i9, Object obj) {
        this.f2851i = i9;
        this.f2852j = obj;
    }
}
