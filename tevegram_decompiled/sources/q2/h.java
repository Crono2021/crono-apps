package q2;

import b6.a0;
import b6.e0;
import b6.g0;
import b6.q;
import b6.w0;
import d1.j0;
import d1.l0;
import g1.p;
import g1.w;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h extends android.support.v4.media.session.b {

    /* renamed from: p, reason: collision with root package name */
    public static final m7.c f8448p = new m7.c(18);

    /* renamed from: o, reason: collision with root package name */
    public final m7.c f8449o;

    public h(m7.c cVar) {
        this.f8449o = cVar;
    }

    public static a E0(p pVar, int i9, int i10) {
        int W0;
        String concat;
        int t8 = pVar.t();
        Charset T0 = T0(t8);
        int i11 = i9 - 1;
        byte[] bArr = new byte[i11];
        pVar.e(0, i11, bArr);
        if (i10 == 2) {
            concat = "image/" + a.a.U(new String(bArr, 0, 3, a6.b.f202b));
            if ("image/jpg".equals(concat)) {
                concat = "image/jpeg";
            }
            W0 = 2;
        } else {
            W0 = W0(bArr, 0);
            String U = a.a.U(new String(bArr, 0, W0, a6.b.f202b));
            concat = U.indexOf(47) == -1 ? "image/".concat(U) : U;
        }
        int i12 = bArr[W0 + 1] & 255;
        int i13 = W0 + 2;
        int V0 = V0(i13, t8, bArr);
        String str = new String(bArr, i13, V0 - i13, T0);
        int S0 = S0(t8) + V0;
        return new a(concat, str, i12, i11 <= S0 ? w.f3718f : Arrays.copyOfRange(bArr, S0, i11));
    }

    public static c F0(p pVar, int i9, int i10, boolean z8, int i11, m7.c cVar) {
        int i12 = pVar.f3700b;
        int W0 = W0(pVar.f3699a, i12);
        String str = new String(pVar.f3699a, i12, W0 - i12, a6.b.f202b);
        pVar.F(W0 + 1);
        int g9 = pVar.g();
        int g10 = pVar.g();
        long v8 = pVar.v();
        if (v8 == 4294967295L) {
            v8 = -1;
        }
        long v9 = pVar.v();
        long j5 = v9 == 4294967295L ? -1L : v9;
        ArrayList arrayList = new ArrayList();
        int i13 = i12 + i9;
        while (pVar.f3700b < i13) {
            i I0 = I0(i10, pVar, z8, i11, cVar);
            if (I0 != null) {
                arrayList.add(I0);
            }
        }
        return new c(str, g9, g10, v8, j5, (i[]) arrayList.toArray(new i[0]));
    }

    public static d G0(p pVar, int i9, int i10, boolean z8, int i11, m7.c cVar) {
        int i12 = pVar.f3700b;
        int W0 = W0(pVar.f3699a, i12);
        String str = new String(pVar.f3699a, i12, W0 - i12, a6.b.f202b);
        pVar.F(W0 + 1);
        int t8 = pVar.t();
        boolean z9 = (t8 & 2) != 0;
        boolean z10 = (t8 & 1) != 0;
        int t9 = pVar.t();
        String[] strArr = new String[t9];
        for (int i13 = 0; i13 < t9; i13++) {
            int i14 = pVar.f3700b;
            int W02 = W0(pVar.f3699a, i14);
            strArr[i13] = new String(pVar.f3699a, i14, W02 - i14, a6.b.f202b);
            pVar.F(W02 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i15 = i12 + i9;
        while (pVar.f3700b < i15) {
            i I0 = I0(i10, pVar, z8, i11, cVar);
            if (I0 != null) {
                arrayList.add(I0);
            }
        }
        return new d(str, z9, z10, strArr, (i[]) arrayList.toArray(new i[0]));
    }

    public static e H0(int i9, p pVar) {
        if (i9 < 4) {
            return null;
        }
        int t8 = pVar.t();
        Charset T0 = T0(t8);
        byte[] bArr = new byte[3];
        pVar.e(0, 3, bArr);
        String str = new String(bArr, 0, 3);
        int i10 = i9 - 4;
        byte[] bArr2 = new byte[i10];
        pVar.e(0, i10, bArr2);
        int V0 = V0(0, t8, bArr2);
        String str2 = new String(bArr2, 0, V0, T0);
        int S0 = S0(t8) + V0;
        return new e(str, str2, M0(bArr2, S0, V0(S0, t8, bArr2), T0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:154:0x01a0, code lost:
    
        if (r10 == 67) goto L152;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022f  */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Throwable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static q2.i I0(int r19, g1.p r20, boolean r21, int r22, m7.c r23) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.h.I0(int, g1.p, boolean, int, m7.c):q2.i");
    }

    public static f J0(int i9, p pVar) {
        int t8 = pVar.t();
        Charset T0 = T0(t8);
        int i10 = i9 - 1;
        byte[] bArr = new byte[i10];
        pVar.e(0, i10, bArr);
        int W0 = W0(bArr, 0);
        String k3 = l0.k(new String(bArr, 0, W0, a6.b.f202b));
        int i11 = W0 + 1;
        int V0 = V0(i11, t8, bArr);
        String M0 = M0(bArr, i11, V0, T0);
        int S0 = S0(t8) + V0;
        int V02 = V0(S0, t8, bArr);
        String M02 = M0(bArr, S0, V02, T0);
        int S02 = S0(t8) + V02;
        return new f(k3, M0, M02, i10 <= S02 ? w.f3718f : Arrays.copyOfRange(bArr, S02, i10));
    }

    public static k K0(int i9, p pVar) {
        int z8 = pVar.z();
        int w8 = pVar.w();
        int w9 = pVar.w();
        int t8 = pVar.t();
        int t9 = pVar.t();
        a3.g gVar = new a3.g();
        gVar.n(pVar);
        int i10 = ((i9 - 10) * 8) / (t8 + t9);
        int[] iArr = new int[i10];
        int[] iArr2 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = gVar.i(t8);
            int i13 = gVar.i(t9);
            iArr[i11] = i12;
            iArr2[i11] = i13;
        }
        return new k(z8, w8, iArr, iArr2, w9);
    }

    public static l L0(int i9, p pVar) {
        byte[] bArr = new byte[i9];
        pVar.e(0, i9, bArr);
        int W0 = W0(bArr, 0);
        String str = new String(bArr, 0, W0, a6.b.f202b);
        int i10 = W0 + 1;
        return new l(str, i9 <= i10 ? w.f3718f : Arrays.copyOfRange(bArr, i10, i9));
    }

    public static String M0(byte[] bArr, int i9, int i10, Charset charset) {
        return (i10 <= i9 || i10 > bArr.length) ? "" : new String(bArr, i9, i10 - i9, charset);
    }

    public static m N0(int i9, p pVar, String str) {
        if (i9 < 1) {
            return null;
        }
        int t8 = pVar.t();
        int i10 = i9 - 1;
        byte[] bArr = new byte[i10];
        pVar.e(0, i10, bArr);
        return new m(str, null, O0(t8, 0, bArr));
    }

    public static w0 O0(int i9, int i10, byte[] bArr) {
        Object[] objArr;
        if (i10 >= bArr.length) {
            return g0.q("");
        }
        e0 e0Var = g0.f1391j;
        q.b(4, "initialCapacity");
        Object[] objArr2 = new Object[4];
        int V0 = V0(i10, i9, bArr);
        int i11 = 0;
        boolean z8 = false;
        while (i10 < V0) {
            String str = new String(bArr, i10, V0 - i10, T0(i9));
            int i12 = i11 + 1;
            if (objArr2.length < i12) {
                objArr = Arrays.copyOf(objArr2, a0.d(objArr2.length, i12));
            } else if (z8) {
                objArr = (Object[]) objArr2.clone();
            } else {
                objArr2[i11] = str;
                int S0 = V0 + S0(i9);
                i11++;
                i10 = S0;
                V0 = V0(S0, i9, bArr);
            }
            objArr2 = objArr;
            z8 = false;
            objArr2[i11] = str;
            int S02 = V0 + S0(i9);
            i11++;
            i10 = S02;
            V0 = V0(S02, i9, bArr);
        }
        w0 l4 = g0.l(i11, objArr2);
        return l4.isEmpty() ? g0.q("") : l4;
    }

    public static m P0(int i9, p pVar) {
        if (i9 < 1) {
            return null;
        }
        int t8 = pVar.t();
        int i10 = i9 - 1;
        byte[] bArr = new byte[i10];
        pVar.e(0, i10, bArr);
        int V0 = V0(0, t8, bArr);
        return new m("TXXX", new String(bArr, 0, V0, T0(t8)), O0(t8, S0(t8) + V0, bArr));
    }

    public static n Q0(int i9, p pVar, String str) {
        byte[] bArr = new byte[i9];
        pVar.e(0, i9, bArr);
        return new n(str, null, new String(bArr, 0, W0(bArr, 0), a6.b.f202b));
    }

    public static n R0(int i9, p pVar) {
        if (i9 < 1) {
            return null;
        }
        int t8 = pVar.t();
        int i10 = i9 - 1;
        byte[] bArr = new byte[i10];
        pVar.e(0, i10, bArr);
        int V0 = V0(0, t8, bArr);
        String str = new String(bArr, 0, V0, T0(t8));
        int S0 = S0(t8) + V0;
        return new n("WXXX", str, M0(bArr, S0, W0(bArr, S0), a6.b.f202b));
    }

    public static int S0(int i9) {
        return (i9 == 0 || i9 == 3) ? 1 : 2;
    }

    public static Charset T0(int i9) {
        return i9 != 1 ? i9 != 2 ? i9 != 3 ? a6.b.f202b : a6.b.f203c : a6.b.f204d : a6.b.f206f;
    }

    public static String U0(int i9, int i10, int i11, int i12, int i13) {
        return i9 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
    }

    public static int V0(int i9, int i10, byte[] bArr) {
        int W0 = W0(bArr, i9);
        if (i10 == 0 || i10 == 3) {
            return W0;
        }
        while (W0 < bArr.length - 1) {
            if ((W0 - i9) % 2 == 0 && bArr[W0 + 1] == 0) {
                return W0;
            }
            W0 = W0(bArr, W0 + 1);
        }
        return bArr.length;
    }

    public static int W0(byte[] bArr, int i9) {
        while (i9 < bArr.length) {
            if (bArr[i9] == 0) {
                return i9;
            }
            i9++;
        }
        return bArr.length;
    }

    public static int X0(int i9, p pVar) {
        byte[] bArr = pVar.f3699a;
        int i10 = pVar.f3700b;
        int i11 = i10;
        while (true) {
            int i12 = i11 + 1;
            if (i12 >= i10 + i9) {
                return i9;
            }
            if ((bArr[i11] & 255) == 255 && bArr[i12] == 0) {
                System.arraycopy(bArr, i11 + 2, bArr, i12, (i9 - (i11 - i10)) - 2);
                i9--;
            }
            i11 = i12;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0077, code lost:
    
        if ((r10 & 1) != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0085, code lost:
    
        if ((r10 & 128) != 0) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean Y0(g1.p r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r1.f3700b
        L6:
            int r3 = r1.a()     // Catch: java.lang.Throwable -> L20
            r4 = 1
            r5 = r20
            if (r3 < r5) goto Laa
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L23
            int r7 = r1.g()     // Catch: java.lang.Throwable -> L20
            long r8 = r1.v()     // Catch: java.lang.Throwable -> L20
            int r10 = r1.z()     // Catch: java.lang.Throwable -> L20
            goto L2d
        L20:
            r0 = move-exception
            goto Lae
        L23:
            int r7 = r1.w()     // Catch: java.lang.Throwable -> L20
            int r8 = r1.w()     // Catch: java.lang.Throwable -> L20
            long r8 = (long) r8
            r10 = 0
        L2d:
            r11 = 0
            if (r7 != 0) goto L3b
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3b
            if (r10 != 0) goto L3b
            r1.F(r2)
            return r4
        L3b:
            r7 = 4
            if (r0 != r7) goto L6c
            if (r21 != 0) goto L6c
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L4c
            r1.F(r2)
            return r6
        L4c:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L6c:
            if (r0 != r7) goto L7a
            r3 = r10 & 64
            if (r3 == 0) goto L74
            r3 = 1
            goto L75
        L74:
            r3 = 0
        L75:
            r7 = r10 & 1
            if (r7 == 0) goto L89
            goto L8a
        L7a:
            if (r0 != r3) goto L88
            r3 = r10 & 32
            if (r3 == 0) goto L82
            r3 = 1
            goto L83
        L82:
            r3 = 0
        L83:
            r7 = r10 & 128(0x80, float:1.8E-43)
            if (r7 == 0) goto L89
            goto L8a
        L88:
            r3 = 0
        L89:
            r4 = 0
        L8a:
            if (r4 == 0) goto L8e
            int r3 = r3 + 4
        L8e:
            long r3 = (long) r3
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L97
            r1.F(r2)
            return r6
        L97:
            int r3 = r1.a()     // Catch: java.lang.Throwable -> L20
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto La4
            r1.F(r2)
            return r6
        La4:
            int r3 = (int) r8
            r1.G(r3)     // Catch: java.lang.Throwable -> L20
            goto L6
        Laa:
            r1.F(r2)
            return r4
        Lae:
            r1.F(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.h.Y0(g1.p, int, int, boolean):boolean");
    }

    @Override // android.support.v4.media.session.b
    public final j0 B(l2.a aVar, ByteBuffer byteBuffer) {
        return D0(byteBuffer.array(), byteBuffer.limit());
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final d1.j0 D0(byte[] r13, int r14) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.h.D0(byte[], int):d1.j0");
    }
}
