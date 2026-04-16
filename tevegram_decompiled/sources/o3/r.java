package o3;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public int[] f7794a;

    /* renamed from: b, reason: collision with root package name */
    public int f7795b;

    /* renamed from: c, reason: collision with root package name */
    public int f7796c;

    /* renamed from: d, reason: collision with root package name */
    public int f7797d;

    public r() {
        int highestOneBit = Integer.bitCount(8) != 1 ? Integer.highestOneBit(7) << 1 : 8;
        this.f7797d = highestOneBit - 1;
        this.f7794a = new int[highestOneBit];
    }

    public void a(int i9) {
        int[] iArr = this.f7794a;
        int i10 = this.f7796c;
        iArr[i10] = i9;
        int i11 = this.f7797d & (i10 + 1);
        this.f7796c = i11;
        int i12 = this.f7795b;
        if (i11 == i12) {
            int length = iArr.length;
            int i13 = length - i12;
            int i14 = length << 1;
            if (i14 < 0) {
                m7.c.i("Max array capacity exceeded");
                return;
            }
            int[] iArr2 = new int[i14];
            System.arraycopy(iArr, i12, iArr2, 0, i13);
            System.arraycopy(this.f7794a, 0, iArr2, i13, this.f7795b);
            this.f7794a = iArr2;
            this.f7795b = 0;
            this.f7796c = length;
            this.f7797d = i14 - 1;
        }
    }

    public void b(int i9, int i10) {
        if (i9 < 0) {
            m7.c.n("Layout positions must be non-negative");
            return;
        }
        if (i10 < 0) {
            m7.c.n("Pixel distance must be non-negative");
            return;
        }
        int i11 = this.f7797d;
        int i12 = i11 * 2;
        int[] iArr = this.f7794a;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.f7794a = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i12 >= iArr.length) {
            int[] iArr3 = new int[i11 * 4];
            this.f7794a = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        }
        int[] iArr4 = this.f7794a;
        iArr4[i12] = i9;
        iArr4[i12 + 1] = i10;
        this.f7797d++;
    }

    public void c(RecyclerView recyclerView, boolean z8) {
        this.f7797d = 0;
        int[] iArr = this.f7794a;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        o0 o0Var = recyclerView.f1080v;
        if (recyclerView.f1078u == null || o0Var == null || !o0Var.f7755i) {
            return;
        }
        if (z8) {
            if (!recyclerView.f1062m.j()) {
                o0Var.i(recyclerView.f1078u.a(), this);
            }
        } else if (!recyclerView.L()) {
            o0Var.h(this.f7795b, this.f7796c, recyclerView.f1067o0, this);
        }
        int i9 = this.f7797d;
        if (i9 > o0Var.f7756j) {
            o0Var.f7756j = i9;
            o0Var.f7757k = z8;
            recyclerView.f1058k.m();
        }
    }
}
