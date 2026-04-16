package d1;

import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final c f2367c = new c(new b[0]);

    /* renamed from: d, reason: collision with root package name */
    public static final b f2368d;

    /* renamed from: a, reason: collision with root package name */
    public final int f2369a;

    /* renamed from: b, reason: collision with root package name */
    public final b[] f2370b;

    static {
        b bVar = new b(-1, -1, new int[0], new e0[0], new long[0]);
        int[] iArr = bVar.f2359e;
        int length = iArr.length;
        int max = Math.max(0, length);
        int[] copyOf = Arrays.copyOf(iArr, max);
        Arrays.fill(copyOf, length, max, 0);
        long[] jArr = bVar.f2360f;
        int length2 = jArr.length;
        int max2 = Math.max(0, length2);
        long[] copyOf2 = Arrays.copyOf(jArr, max2);
        Arrays.fill(copyOf2, length2, max2, -9223372036854775807L);
        f2368d = new b(0, bVar.f2356b, copyOf, (e0[]) Arrays.copyOf(bVar.f2358d, 0), copyOf2);
        g1.w.H(1);
        g1.w.H(2);
        g1.w.H(3);
        g1.w.H(4);
    }

    public c(b[] bVarArr) {
        this.f2369a = bVarArr.length;
        this.f2370b = bVarArr;
    }

    public final b a(int i9) {
        return i9 < 0 ? f2368d : this.f2370b[i9];
    }

    public final boolean b(int i9) {
        if (i9 != this.f2369a - 1) {
            return false;
        }
        a(i9).getClass();
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        int i9 = g1.w.f3713a;
        return this.f2369a == cVar.f2369a && Arrays.equals(this.f2370b, cVar.f2370b);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f2370b) + (((((this.f2369a * 961) + ((int) 0)) * 31) + ((int) (-9223372036854775807L))) * 961);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AdPlaybackState(adsId=null, adResumePositionUs=0, adGroups=[");
        int i9 = 0;
        while (true) {
            b[] bVarArr = this.f2370b;
            if (i9 >= bVarArr.length) {
                sb.append("])");
                return sb.toString();
            }
            sb.append("adGroup(timeUs=0, ads=[");
            bVarArr[i9].getClass();
            for (int i10 = 0; i10 < bVarArr[i9].f2359e.length; i10++) {
                sb.append("ad(state=");
                int i11 = bVarArr[i9].f2359e[i10];
                if (i11 == 0) {
                    sb.append('_');
                } else if (i11 == 1) {
                    sb.append('R');
                } else if (i11 == 2) {
                    sb.append('S');
                } else if (i11 == 3) {
                    sb.append('P');
                } else if (i11 != 4) {
                    sb.append('?');
                } else {
                    sb.append('!');
                }
                sb.append(", durationUs=");
                sb.append(bVarArr[i9].f2360f[i10]);
                sb.append(')');
                if (i10 < bVarArr[i9].f2359e.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i9 < bVarArr.length - 1) {
                sb.append(", ");
            }
            i9++;
        }
    }
}
