package m1;

import d1.w0;
import d1.x0;
import d1.y0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import v1.z;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s {
    public static final b2.c h = new b2.c(2);

    /* renamed from: i, reason: collision with root package name */
    public static final Random f6567i = new Random();

    /* renamed from: d, reason: collision with root package name */
    public v f6571d;

    /* renamed from: f, reason: collision with root package name */
    public String f6573f;

    /* renamed from: a, reason: collision with root package name */
    public final x0 f6568a = new x0();

    /* renamed from: b, reason: collision with root package name */
    public final w0 f6569b = new w0();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f6570c = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public y0 f6572e = y0.f2610a;

    /* renamed from: g, reason: collision with root package name */
    public long f6574g = -1;

    public final void a(r rVar) {
        long j5 = rVar.f6562c;
        if (j5 != -1) {
            this.f6574g = j5;
        }
        this.f6573f = null;
    }

    public final synchronized void b(a aVar) {
        v vVar;
        try {
            String str = this.f6573f;
            if (str != null) {
                r rVar = (r) this.f6570c.get(str);
                rVar.getClass();
                a(rVar);
            }
            Iterator it = this.f6570c.values().iterator();
            while (it.hasNext()) {
                r rVar2 = (r) it.next();
                it.remove();
                if (rVar2.f6564e && (vVar = this.f6571d) != null) {
                    vVar.P(aVar, rVar2.f6560a);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
    
        if (r12 != (-1)) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009b A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final m1.r c(int r19, v1.z r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            java.util.HashMap r3 = r0.f6570c
            java.util.Collection r4 = r3.values()
            java.util.Iterator r4 = r4.iterator()
            r5 = 0
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L16:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L9f
            java.lang.Object r8 = r4.next()
            m1.r r8 = (m1.r) r8
            long r9 = r8.f6562c
            v1.z r11 = r8.f6563d
            r12 = -1
            int r14 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r14 != 0) goto L57
            int r9 = r8.f6561b
            if (r1 != r9) goto L57
            if (r2 == 0) goto L57
            long r9 = r2.f9450d
            m1.s r14 = r8.f6566g
            java.util.HashMap r15 = r14.f6570c
            r16 = r12
            java.lang.String r12 = r14.f6573f
            java.lang.Object r12 = r15.get(r12)
            m1.r r12 = (m1.r) r12
            if (r12 == 0) goto L4b
            long r12 = r12.f6562c
            int r15 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r15 == 0) goto L4b
            goto L50
        L4b:
            long r12 = r14.f6574g
            r14 = 1
            long r12 = r12 + r14
        L50:
            int r14 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r14 < 0) goto L59
            r8.f6562c = r9
            goto L59
        L57:
            r16 = r12
        L59:
            if (r2 != 0) goto L60
            int r9 = r8.f6561b
            if (r1 != r9) goto L16
            goto L83
        L60:
            long r9 = r2.f9450d
            if (r11 != 0) goto L71
            boolean r12 = r2.b()
            if (r12 != 0) goto L16
            long r12 = r8.f6562c
            int r14 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r14 != 0) goto L16
            goto L83
        L71:
            long r12 = r11.f9450d
            int r14 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r14 != 0) goto L16
            int r9 = r2.f9448b
            int r10 = r11.f9448b
            if (r9 != r10) goto L16
            int r9 = r2.f9449c
            int r10 = r11.f9449c
            if (r9 != r10) goto L16
        L83:
            long r9 = r8.f6562c
            int r12 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r12 == 0) goto L9b
            int r12 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r12 >= 0) goto L8e
            goto L9b
        L8e:
            if (r12 != 0) goto L16
            int r9 = g1.w.f3713a
            v1.z r9 = r5.f6563d
            if (r9 == 0) goto L16
            if (r11 == 0) goto L16
            r5 = r8
            goto L16
        L9b:
            r5 = r8
            r6 = r9
            goto L16
        L9f:
            if (r5 != 0) goto Lb1
            b2.c r4 = m1.s.h
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            m1.r r5 = new m1.r
            r5.<init>(r0, r4, r1, r2)
            r3.put(r4, r5)
        Lb1:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.s.c(int, v1.z):m1.r");
    }

    public final synchronized String d(y0 y0Var, z zVar) {
        return c(y0Var.g(zVar.f9447a, this.f6569b).f2586c, zVar).f6560a;
    }

    public final void e(a aVar) {
        z zVar;
        y0 y0Var = aVar.f6501b;
        int i9 = aVar.f6502c;
        z zVar2 = aVar.f6503d;
        boolean p5 = y0Var.p();
        String str = this.f6573f;
        HashMap hashMap = this.f6570c;
        if (p5) {
            if (str != null) {
                r rVar = (r) hashMap.get(str);
                rVar.getClass();
                a(rVar);
                return;
            }
            return;
        }
        r rVar2 = (r) hashMap.get(str);
        this.f6573f = c(i9, zVar2).f6560a;
        f(aVar);
        if (zVar2 != null) {
            long j5 = zVar2.f9450d;
            if (zVar2.b()) {
                if (rVar2 != null && rVar2.f6562c == j5 && (zVar = rVar2.f6563d) != null && zVar.f9448b == zVar2.f9448b && zVar.f9449c == zVar2.f9449c) {
                    return;
                }
                c(i9, new z(j5, zVar2.f9447a));
                this.f6571d.getClass();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036 A[Catch: all -> 0x0050, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0010, B:10:0x0014, B:12:0x0024, B:19:0x0036, B:21:0x0042, B:23:0x0048, B:27:0x002b, B:29:0x0053, B:31:0x005f, B:32:0x0063, B:34:0x0068, B:36:0x006e, B:38:0x0085, B:39:0x00b2, B:41:0x00b6, B:42:0x00bd, B:44:0x00c7, B:46:0x00cb, B:48:0x00d8, B:51:0x00df), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void f(m1.a r10) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.s.f(m1.a):void");
    }

    public final synchronized void g(a aVar, int i9) {
        try {
            this.f6571d.getClass();
            boolean z8 = i9 == 0;
            Iterator it = this.f6570c.values().iterator();
            while (it.hasNext()) {
                r rVar = (r) it.next();
                if (rVar.a(aVar)) {
                    it.remove();
                    if (rVar.f6564e) {
                        boolean equals = rVar.f6560a.equals(this.f6573f);
                        if (z8 && equals) {
                            boolean z9 = rVar.f6565f;
                        }
                        if (equals) {
                            a(rVar);
                        }
                        this.f6571d.P(aVar, rVar.f6560a);
                    }
                }
            }
            e(aVar);
        } catch (Throwable th) {
            throw th;
        }
    }
}
