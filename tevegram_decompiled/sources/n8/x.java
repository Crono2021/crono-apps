package n8;

import i8.h0;
import i8.i0;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class x {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f7540b = AtomicIntegerFieldUpdater.newUpdater(x.class, "_size");
    private volatile int _size;

    /* renamed from: a, reason: collision with root package name */
    public h0[] f7541a;

    public final void a(h0 h0Var) {
        h0Var.c((i0) this);
        h0[] h0VarArr = this.f7541a;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f7540b;
        if (h0VarArr == null) {
            h0VarArr = new h0[4];
            this.f7541a = h0VarArr;
        } else if (atomicIntegerFieldUpdater.get(this) >= h0VarArr.length) {
            h0VarArr = (h0[]) Arrays.copyOf(h0VarArr, atomicIntegerFieldUpdater.get(this) * 2);
            this.f7541a = h0VarArr;
        }
        int i9 = atomicIntegerFieldUpdater.get(this);
        atomicIntegerFieldUpdater.set(this, i9 + 1);
        h0VarArr[i9] = h0Var;
        h0Var.f5273j = i9;
        e(i9);
    }

    public final h0 b() {
        h0 h0Var;
        synchronized (this) {
            h0[] h0VarArr = this.f7541a;
            h0Var = h0VarArr != null ? h0VarArr[0] : null;
        }
        return h0Var;
    }

    public final void c(h0 h0Var) {
        synchronized (this) {
            if (h0Var.a() != null) {
                d(h0Var.f5273j);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0060, code lost:
    
        if (r6.compareTo(r7) < 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final i8.h0 d(int r9) {
        /*
            r8 = this;
            i8.h0[] r0 = r8.f7541a
            r0.getClass()
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = n8.x.f7540b
            int r2 = r1.get(r8)
            r3 = -1
            int r2 = r2 + r3
            r1.set(r8, r2)
            int r2 = r1.get(r8)
            if (r9 >= r2) goto L7a
            int r2 = r1.get(r8)
            r8.f(r9, r2)
            int r2 = r9 + (-1)
            int r2 = r2 / 2
            if (r9 <= 0) goto L3a
            r4 = r0[r9]
            r4.getClass()
            r5 = r0[r2]
            r5.getClass()
            int r4 = r4.compareTo(r5)
            if (r4 >= 0) goto L3a
            r8.f(r9, r2)
            r8.e(r2)
            goto L7a
        L3a:
            int r2 = r9 * 2
            int r4 = r2 + 1
            int r5 = r1.get(r8)
            if (r4 < r5) goto L45
            goto L7a
        L45:
            i8.h0[] r5 = r8.f7541a
            r5.getClass()
            int r2 = r2 + 2
            int r6 = r1.get(r8)
            if (r2 >= r6) goto L63
            r6 = r5[r2]
            r6.getClass()
            r7 = r5[r4]
            r7.getClass()
            int r6 = r6.compareTo(r7)
            if (r6 >= 0) goto L63
            goto L64
        L63:
            r2 = r4
        L64:
            r4 = r5[r9]
            r4.getClass()
            r5 = r5[r2]
            r5.getClass()
            int r4 = r4.compareTo(r5)
            if (r4 > 0) goto L75
            goto L7a
        L75:
            r8.f(r9, r2)
            r9 = r2
            goto L3a
        L7a:
            int r9 = r1.get(r8)
            r9 = r0[r9]
            r9.getClass()
            r2 = 0
            r9.c(r2)
            r9.f5273j = r3
            int r1 = r1.get(r8)
            r0[r1] = r2
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: n8.x.d(int):i8.h0");
    }

    public final void e(int i9) {
        while (i9 > 0) {
            h0[] h0VarArr = this.f7541a;
            h0VarArr.getClass();
            int i10 = (i9 - 1) / 2;
            h0 h0Var = h0VarArr[i10];
            h0Var.getClass();
            h0 h0Var2 = h0VarArr[i9];
            h0Var2.getClass();
            if (h0Var.compareTo(h0Var2) <= 0) {
                return;
            }
            f(i9, i10);
            i9 = i10;
        }
    }

    public final void f(int i9, int i10) {
        h0[] h0VarArr = this.f7541a;
        h0VarArr.getClass();
        h0 h0Var = h0VarArr[i10];
        h0Var.getClass();
        h0 h0Var2 = h0VarArr[i9];
        h0Var2.getClass();
        h0VarArr[i9] = h0Var;
        h0VarArr[i10] = h0Var2;
        h0Var.f5273j = i9;
        h0Var2.f5273j = i10;
    }
}
