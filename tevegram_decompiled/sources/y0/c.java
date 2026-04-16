package y0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f10355a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10356b;

    /* renamed from: c, reason: collision with root package name */
    public final long f10357c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f10358d;

    public c(long j5, byte[] bArr, int i9, int i10) {
        this.f10355a = i9;
        this.f10356b = i10;
        this.f10357c = j5;
        this.f10358d = bArr;
    }

    public static c a(long j5, ByteOrder byteOrder) {
        long[] jArr = {j5};
        ByteBuffer wrap = ByteBuffer.wrap(new byte[g.C[4]]);
        wrap.order(byteOrder);
        wrap.putInt((int) jArr[0]);
        return new c(4, 1, wrap.array());
    }

    public static c b(e eVar, ByteOrder byteOrder) {
        e[] eVarArr = {eVar};
        ByteBuffer wrap = ByteBuffer.wrap(new byte[g.C[5]]);
        wrap.order(byteOrder);
        e eVar2 = eVarArr[0];
        wrap.putInt((int) eVar2.f10363a);
        wrap.putInt((int) eVar2.f10364b);
        return new c(5, 1, wrap.array());
    }

    public static c c(int i9, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[g.C[3]]);
        wrap.order(byteOrder);
        wrap.putShort((short) new int[]{i9}[0]);
        return new c(3, 1, wrap.array());
    }

    public final double d(ByteOrder byteOrder) {
        Object g9 = g(byteOrder);
        if (g9 == null) {
            throw new NumberFormatException("NULL can't be converted to a double value");
        }
        if (g9 instanceof String) {
            return Double.parseDouble((String) g9);
        }
        if (g9 instanceof long[]) {
            if (((long[]) g9).length == 1) {
                return r5[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (g9 instanceof int[]) {
            if (((int[]) g9).length == 1) {
                return r5[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (g9 instanceof double[]) {
            double[] dArr = (double[]) g9;
            if (dArr.length == 1) {
                return dArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(g9 instanceof e[])) {
            throw new NumberFormatException("Couldn't find a double value");
        }
        e[] eVarArr = (e[]) g9;
        if (eVarArr.length != 1) {
            throw new NumberFormatException("There are more than one component");
        }
        e eVar = eVarArr[0];
        return eVar.f10363a / eVar.f10364b;
    }

    public final int e(ByteOrder byteOrder) {
        Object g9 = g(byteOrder);
        if (g9 == null) {
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }
        if (g9 instanceof String) {
            return Integer.parseInt((String) g9);
        }
        if (g9 instanceof long[]) {
            long[] jArr = (long[]) g9;
            if (jArr.length == 1) {
                return (int) jArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(g9 instanceof int[])) {
            throw new NumberFormatException("Couldn't find a integer value");
        }
        int[] iArr = (int[]) g9;
        if (iArr.length == 1) {
            return iArr[0];
        }
        throw new NumberFormatException("There are more than one component");
    }

    public final String f(ByteOrder byteOrder) {
        Object g9 = g(byteOrder);
        if (g9 == null) {
            return null;
        }
        if (g9 instanceof String) {
            return (String) g9;
        }
        StringBuilder sb = new StringBuilder();
        int i9 = 0;
        if (g9 instanceof long[]) {
            long[] jArr = (long[]) g9;
            while (i9 < jArr.length) {
                sb.append(jArr[i9]);
                i9++;
                if (i9 != jArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (g9 instanceof int[]) {
            int[] iArr = (int[]) g9;
            while (i9 < iArr.length) {
                sb.append(iArr[i9]);
                i9++;
                if (i9 != iArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (g9 instanceof double[]) {
            double[] dArr = (double[]) g9;
            while (i9 < dArr.length) {
                sb.append(dArr[i9]);
                i9++;
                if (i9 != dArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (!(g9 instanceof e[])) {
            return null;
        }
        e[] eVarArr = (e[]) g9;
        while (i9 < eVarArr.length) {
            sb.append(eVarArr[i9].f10363a);
            sb.append('/');
            sb.append(eVarArr[i9].f10364b);
            i9++;
            if (i9 != eVarArr.length) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0032: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:51), block:B:100:0x0032 */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r14v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v19, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v23, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v24, types: [long[]] */
    /* JADX WARN: Type inference failed for: r14v25, types: [y0.e[]] */
    /* JADX WARN: Type inference failed for: r14v26, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v27, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v28, types: [y0.e[]] */
    /* JADX WARN: Type inference failed for: r14v29, types: [double[]] */
    /* JADX WARN: Type inference failed for: r14v30, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r14v31, types: [double[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable g(java.nio.ByteOrder r14) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.c.g(java.nio.ByteOrder):java.io.Serializable");
    }

    public final String toString() {
        return "(" + g.B[this.f10355a] + ", data length:" + this.f10358d.length + ")";
    }

    public c(int i9, int i10, byte[] bArr) {
        this(-1L, bArr, i9, i10);
    }
}
