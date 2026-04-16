package d4;

import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f2890i;

    /* renamed from: j, reason: collision with root package name */
    public final s4.f f2891j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ r f2892k;

    public /* synthetic */ o(r rVar, s4.f fVar, int i9) {
        this.f2890i = i9;
        this.f2892k = rVar;
        this.f2891j = fVar;
    }

    private final void a() {
        s4.f fVar = this.f2891j;
        fVar.f8826b.a();
        synchronized (fVar.f8827c) {
            synchronized (this.f2892k) {
                try {
                    if (((ArrayList) this.f2892k.f2897i.f2896j).contains(new p(this.f2891j, w4.f.f9938b))) {
                        r rVar = this.f2892k;
                        try {
                            this.f2891j.f(rVar.f2913y, 5);
                        } catch (Throwable th) {
                            throw new c(th);
                        }
                    }
                    this.f2892k.d();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2890i) {
            case 0:
                a();
                return;
            default:
                s4.f fVar = this.f2891j;
                fVar.f8826b.a();
                synchronized (fVar.f8827c) {
                    synchronized (this.f2892k) {
                        try {
                            if (((ArrayList) this.f2892k.f2897i.f2896j).contains(new p(this.f2891j, w4.f.f9938b))) {
                                this.f2892k.A.a();
                                r rVar = this.f2892k;
                                try {
                                    this.f2891j.h(rVar.A, rVar.f2911w);
                                    this.f2892k.j(this.f2891j);
                                } catch (Throwable th) {
                                    throw new c(th);
                                }
                            }
                            this.f2892k.d();
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                return;
        }
    }
}
