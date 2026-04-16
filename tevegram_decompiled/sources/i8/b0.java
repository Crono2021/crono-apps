package i8;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class b0 extends p8.g {

    /* renamed from: k, reason: collision with root package name */
    public int f5247k;

    public b0(int i9) {
        super(0L, p8.j.f8295g);
        this.f5247k = i9;
    }

    public abstract void c(Object obj, CancellationException cancellationException);

    public abstract r7.c d();

    public Throwable e(Object obj) {
        m mVar = obj instanceof m ? (m) obj : null;
        if (mVar != null) {
            return mVar.f5289a;
        }
        return null;
    }

    public final void i(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            android.support.v4.media.session.b.h(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        th.getClass();
        w.h(d().f(), new v("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object j();

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
    
        r7 = (i8.y0) r7.h(i8.t.f5304j);
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r13 = this;
            n7.g r0 = n7.g.f7490c
            p8.h r1 = r13.f8286j
            r7.c r2 = r13.d()     // Catch: java.lang.Throwable -> L24
            r2.getClass()     // Catch: java.lang.Throwable -> L24
            n8.h r2 = (n8.h) r2     // Catch: java.lang.Throwable -> L24
            t7.c r3 = r2.f7507m     // Catch: java.lang.Throwable -> L24
            java.lang.Object r2 = r2.f7509o     // Catch: java.lang.Throwable -> L24
            r7.g r4 = r3.f8983j     // Catch: java.lang.Throwable -> L24
            r4.getClass()     // Catch: java.lang.Throwable -> L24
            java.lang.Object r2 = n8.a.k(r4, r2)     // Catch: java.lang.Throwable -> L24
            a6.d r5 = n8.a.f7497f     // Catch: java.lang.Throwable -> L24
            r6 = 0
            if (r2 == r5) goto L27
            i8.h1 r5 = i8.w.p(r3, r4, r2)     // Catch: java.lang.Throwable -> L24
            goto L28
        L24:
            r2 = move-exception
            goto La3
        L27:
            r5 = r6
        L28:
            r7.g r7 = r3.f8983j     // Catch: java.lang.Throwable -> L4c
            r7.getClass()     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r8 = r13.j()     // Catch: java.lang.Throwable -> L4c
            java.lang.Throwable r9 = r13.e(r8)     // Catch: java.lang.Throwable -> L4c
            if (r9 != 0) goto L4e
            int r10 = r13.f5247k     // Catch: java.lang.Throwable -> L4c
            r11 = 1
            if (r10 == r11) goto L41
            r12 = 2
            if (r10 != r12) goto L40
            goto L41
        L40:
            r11 = 0
        L41:
            if (r11 == 0) goto L4e
            i8.t r10 = i8.t.f5304j     // Catch: java.lang.Throwable -> L4c
            r7.e r7 = r7.h(r10)     // Catch: java.lang.Throwable -> L4c
            i8.y0 r7 = (i8.y0) r7     // Catch: java.lang.Throwable -> L4c
            goto L4f
        L4c:
            r3 = move-exception
            goto L97
        L4e:
            r7 = r6
        L4f:
            if (r7 == 0) goto L67
            boolean r10 = r7.B()     // Catch: java.lang.Throwable -> L4c
            if (r10 != 0) goto L67
            java.util.concurrent.CancellationException r7 = r7.s()     // Catch: java.lang.Throwable -> L4c
            r13.c(r8, r7)     // Catch: java.lang.Throwable -> L4c
            n7.c r8 = new n7.c     // Catch: java.lang.Throwable -> L4c
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L4c
            r3.g(r8)     // Catch: java.lang.Throwable -> L4c
            goto L79
        L67:
            if (r9 == 0) goto L72
            n7.c r7 = new n7.c     // Catch: java.lang.Throwable -> L4c
            r7.<init>(r9)     // Catch: java.lang.Throwable -> L4c
            r3.g(r7)     // Catch: java.lang.Throwable -> L4c
            goto L79
        L72:
            java.lang.Object r7 = r13.h(r8)     // Catch: java.lang.Throwable -> L4c
            r3.g(r7)     // Catch: java.lang.Throwable -> L4c
        L79:
            if (r5 == 0) goto L81
            boolean r3 = r5.N()     // Catch: java.lang.Throwable -> L24
            if (r3 == 0) goto L84
        L81:
            n8.a.f(r4, r2)     // Catch: java.lang.Throwable -> L24
        L84:
            r1.getClass()     // Catch: java.lang.Throwable -> L88
            goto L8f
        L88:
            r0 = move-exception
            n7.c r1 = new n7.c
            r1.<init>(r0)
            r0 = r1
        L8f:
            java.lang.Throwable r0 = n7.d.a(r0)
            r13.i(r6, r0)
            goto Lb5
        L97:
            if (r5 == 0) goto L9f
            boolean r5 = r5.N()     // Catch: java.lang.Throwable -> L24
            if (r5 == 0) goto La2
        L9f:
            n8.a.f(r4, r2)     // Catch: java.lang.Throwable -> L24
        La2:
            throw r3     // Catch: java.lang.Throwable -> L24
        La3:
            r1.getClass()     // Catch: java.lang.Throwable -> La7
            goto Lae
        La7:
            r0 = move-exception
            n7.c r1 = new n7.c
            r1.<init>(r0)
            r0 = r1
        Lae:
            java.lang.Throwable r0 = n7.d.a(r0)
            r13.i(r2, r0)
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i8.b0.run():void");
    }

    public Object h(Object obj) {
        return obj;
    }
}
