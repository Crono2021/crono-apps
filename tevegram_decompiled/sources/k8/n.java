package k8;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import o7.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n extends d {

    /* renamed from: l, reason: collision with root package name */
    public final int f5674l;

    public n(int i9, int i10) {
        super(i9);
        String c9;
        this.f5674l = i10;
        if (i10 != 1) {
            if (i9 >= 1) {
                return;
            }
            h7.o.d("Buffered channel capacity must be at least 1, but ", i9, " was specified");
            throw null;
        }
        StringBuilder sb = new StringBuilder("This implementation does not support suspension for senders, use ");
        b8.p.f1526a.getClass();
        String str = null;
        if (!d.class.isAnonymousClass()) {
            if (d.class.isLocalClass()) {
                str = d.class.getSimpleName();
                Method enclosingMethod = d.class.getEnclosingMethod();
                if (enclosingMethod == null) {
                    Constructor<?> enclosingConstructor = d.class.getEnclosingConstructor();
                    if (enclosingConstructor == null) {
                        int k02 = h8.e.k0(str, '$', 0, 6);
                        if (k02 != -1) {
                            str = str.substring(k02 + 1, str.length());
                        }
                    } else {
                        str = h8.e.q0(str, enclosingConstructor.getName() + '$', str);
                    }
                } else {
                    str = h8.e.q0(str, enclosingMethod.getName() + '$', str);
                }
            } else if (d.class.isArray()) {
                Class<?> componentType = d.class.getComponentType();
                if (componentType.isPrimitive() && (c9 = b8.i.c(componentType.getName())) != null) {
                    str = c9.concat("Array");
                }
                if (str == null) {
                    str = "Array";
                }
            } else {
                str = b8.i.c(d.class.getName());
                if (str == null) {
                    str = d.class.getSimpleName();
                }
            }
        }
        throw new IllegalArgumentException(androidx.activity.g.o(sb, str, " instead").toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b9, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object C(java.lang.Object r17, boolean r18) {
        /*
            r16 = this;
            r0 = r16
            n7.g r8 = n7.g.f7490c
            int r1 = r0.f5674l
            r9 = 3
            if (r1 != r9) goto L18
            java.lang.Object r1 = super.a(r17)
            boolean r2 = r1 instanceof k8.j
            if (r2 == 0) goto L17
            boolean r2 = r1 instanceof k8.i
            if (r2 == 0) goto L16
            goto L17
        L16:
            return r8
        L17:
            return r1
        L18:
            a6.d r6 = k8.f.f5651d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = k8.d.f5642g
            java.lang.Object r1 = r1.get(r0)
            k8.l r1 = (k8.l) r1
        L22:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = k8.d.f5638c
            long r2 = r2.getAndIncrement(r0)
            r4 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r4 = r4 & r2
            r7 = 0
            boolean r7 = r0.p(r2, r7)
            int r10 = k8.f.f5649b
            long r11 = (long) r10
            long r2 = r4 / r11
            long r13 = r4 % r11
            int r14 = (int) r13
            r13 = r10
            long r9 = r1.f7533k
            int r15 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r15 == 0) goto L57
            k8.l r2 = k8.d.c(r0, r2, r1)
            if (r2 != 0) goto L56
            if (r7 == 0) goto L54
            java.lang.Throwable r1 = r0.m()
            k8.i r2 = new k8.i
            r2.<init>(r1)
            return r2
        L54:
            r9 = 3
            goto L22
        L56:
            r1 = r2
        L57:
            r3 = r17
            r2 = r14
            int r9 = k8.d.e(r0, r1, r2, r3, r4, r6, r7)
            if (r9 == 0) goto Lba
            r3 = 1
            if (r9 == r3) goto Lb9
            r3 = 2
            if (r9 == r3) goto L92
            r3 = 3
            if (r9 == r3) goto L8b
            r2 = 4
            if (r9 == r2) goto L74
            r2 = 5
            if (r9 == r2) goto L70
            goto L54
        L70:
            r1.a()
            goto L54
        L74:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = k8.d.f5639d
            long r2 = r2.get(r0)
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 >= 0) goto L81
            r1.a()
        L81:
            java.lang.Throwable r1 = r0.m()
            k8.i r2 = new k8.i
            r2.<init>(r1)
            return r2
        L8b:
            java.lang.String r1 = "unexpected"
            m7.c.p(r1)
            r1 = 0
            return r1
        L92:
            if (r7 == 0) goto La1
            r1.h()
            java.lang.Throwable r1 = r0.m()
            k8.i r2 = new k8.i
            r2.<init>(r1)
            return r2
        La1:
            boolean r3 = r6 instanceof i8.j1
            if (r3 == 0) goto La8
            i8.j1 r6 = (i8.j1) r6
            goto La9
        La8:
            r6 = 0
        La9:
            if (r6 == 0) goto Lb0
            int r14 = r2 + r13
            r6.a(r1, r14)
        Lb0:
            long r3 = r1.f7533k
            long r3 = r3 * r11
            long r1 = (long) r2
            long r3 = r3 + r1
            r0.i(r3)
        Lb9:
            return r8
        Lba:
            r1.a()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.n.C(java.lang.Object, boolean):java.lang.Object");
    }

    @Override // k8.d, k8.h
    public final Object a(Object obj) {
        return C(obj, false);
    }

    @Override // k8.d, k8.h
    public final Object b(s sVar, m8.a aVar) {
        if (C(sVar, true) instanceof i) {
            throw m();
        }
        return n7.g.f7490c;
    }

    @Override // k8.d
    public final boolean q() {
        return this.f5674l == 2;
    }
}
