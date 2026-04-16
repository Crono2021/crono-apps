package n1;

import android.content.Context;
import android.content.IntentFilter;
import android.util.SparseArray;
import b6.b1;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final e f7247c = new e(b6.g0.q(d.f7243d));

    /* renamed from: d, reason: collision with root package name */
    public static final b6.w0 f7248d;

    /* renamed from: e, reason: collision with root package name */
    public static final b1 f7249e;

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f7250a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public final int f7251b;

    static {
        Object[] objArr = {2, 5, 6};
        b6.q.a(3, objArr);
        f7248d = b6.g0.l(3, objArr);
        b6.i0 i0Var = new b6.i0(4);
        i0Var.g(5, 6);
        i0Var.g(17, 6);
        i0Var.g(7, 6);
        i0Var.g(30, 10);
        i0Var.g(18, 6);
        i0Var.g(6, 8);
        i0Var.g(8, 8);
        i0Var.g(14, 8);
        f7249e = i0Var.a();
    }

    public e(b6.w0 w0Var) {
        for (int i9 = 0; i9 < w0Var.f1466l; i9++) {
            d dVar = (d) w0Var.get(i9);
            this.f7250a.put(dVar.f7244a, dVar);
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f7250a.size(); i11++) {
            i10 = Math.max(i10, ((d) this.f7250a.valueAt(i11)).f7245b);
        }
        this.f7251b = i10;
    }

    public static b6.w0 a(int[] iArr, int i9) {
        b6.e0 e0Var = b6.g0.f1391j;
        b6.q.b(4, "initialCapacity");
        Object[] objArr = new Object[4];
        if (iArr == null) {
            iArr = new int[0];
        }
        int i10 = 0;
        int i11 = 0;
        boolean z8 = false;
        while (i10 < iArr.length) {
            d dVar = new d(iArr[i10], i9);
            int i12 = i11 + 1;
            if (objArr.length < i12) {
                objArr = Arrays.copyOf(objArr, b6.a0.d(objArr.length, i12));
            } else if (z8) {
                objArr = (Object[]) objArr.clone();
            } else {
                objArr[i11] = dVar;
                i10++;
                i11++;
            }
            z8 = false;
            objArr[i11] = dVar;
            i10++;
            i11++;
        }
        return b6.g0.l(i11, objArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ac, code lost:
    
        if ("Xiaomi".equals(r2) == false) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static n1.e b(android.content.Context r5, android.content.Intent r6, d1.g r7, n1.k r8) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.e.b(android.content.Context, android.content.Intent, d1.g, n1.k):n1.e");
    }

    public static e c(Context context, d1.g gVar, k kVar) {
        return b(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), gVar, kVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cb, code lost:
    
        if (r9 != 5) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e6 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair d(d1.g r14, d1.s r15) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.e.d(d1.g, d1.s):android.util.Pair");
    }

    public final boolean e(int i9) {
        int i10 = g1.w.f3713a;
        return this.f7250a.indexOfKey(i9) >= 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
    
        if (r1 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 1
            if (r8 != r9) goto L4
            goto L54
        L4:
            boolean r1 = r9 instanceof n1.e
            r2 = 0
            if (r1 != 0) goto La
            goto L55
        La:
            n1.e r9 = (n1.e) r9
            android.util.SparseArray r1 = r9.f7250a
            int r3 = g1.w.f3713a
            android.util.SparseArray r3 = r8.f7250a
            if (r3 != 0) goto L1a
            if (r1 != 0) goto L18
        L16:
            r1 = 1
            goto L4c
        L18:
            r1 = 0
            goto L4c
        L1a:
            if (r1 != 0) goto L1d
            goto L18
        L1d:
            int r4 = g1.w.f3713a
            r5 = 31
            if (r4 < r5) goto L28
            boolean r1 = d5.a.v(r3, r1)
            goto L4c
        L28:
            int r4 = r3.size()
            int r5 = r1.size()
            if (r4 == r5) goto L33
            goto L18
        L33:
            r5 = 0
        L34:
            if (r5 >= r4) goto L16
            int r6 = r3.keyAt(r5)
            java.lang.Object r7 = r3.valueAt(r5)
            java.lang.Object r6 = r1.get(r6)
            boolean r6 = java.util.Objects.equals(r7, r6)
            if (r6 != 0) goto L49
            goto L18
        L49:
            int r5 = r5 + 1
            goto L34
        L4c:
            if (r1 == 0) goto L55
            int r1 = r8.f7251b
            int r9 = r9.f7251b
            if (r1 != r9) goto L55
        L54:
            return r0
        L55:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.e.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i9;
        int i10 = g1.w.f3713a;
        SparseArray sparseArray = this.f7250a;
        if (i10 >= 31) {
            i9 = sparseArray.contentHashCode();
        } else {
            i9 = 17;
            for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                i9 = Objects.hashCode(sparseArray.valueAt(i11)) + ((sparseArray.keyAt(i11) + (i9 * 31)) * 31);
            }
        }
        return (i9 * 31) + this.f7251b;
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f7251b + ", audioProfiles=" + this.f7250a + "]";
    }
}
