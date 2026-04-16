package w2;

import g1.w;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final p f9838a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9839b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f9840c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f9841d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9842e;

    /* renamed from: f, reason: collision with root package name */
    public final long[] f9843f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f9844g;
    public final long h;

    public s(p pVar, long[] jArr, int[] iArr, int i9, long[] jArr2, int[] iArr2, long j5) {
        g1.a.f(iArr.length == jArr2.length);
        g1.a.f(jArr.length == jArr2.length);
        g1.a.f(iArr2.length == jArr2.length);
        this.f9838a = pVar;
        this.f9840c = jArr;
        this.f9841d = iArr;
        this.f9842e = i9;
        this.f9843f = jArr2;
        this.f9844g = iArr2;
        this.h = j5;
        this.f9839b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public final int a(long j5) {
        long[] jArr = this.f9843f;
        for (int b9 = w.b(j5, jArr, true); b9 < jArr.length; b9++) {
            if ((this.f9844g[b9] & 1) != 0) {
                return b9;
            }
        }
        return -1;
    }
}
