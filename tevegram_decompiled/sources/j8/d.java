package j8;

import android.os.Handler;
import android.os.Looper;
import b8.i;
import i8.c0;
import i8.f;
import i8.s;
import i8.w;
import i8.z;
import java.util.concurrent.CancellationException;
import n8.o;
import r7.g;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d extends s implements z {
    private volatile d _immediate;

    /* renamed from: k, reason: collision with root package name */
    public final Handler f5501k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f5502l;

    /* renamed from: m, reason: collision with root package name */
    public final d f5503m;

    public d(Handler handler, boolean z8) {
        this.f5501k = handler;
        this.f5502l = z8;
        this._immediate = z8 ? this : null;
        d dVar = this._immediate;
        if (dVar == null) {
            dVar = new d(handler, true);
            this._immediate = dVar;
        }
        this.f5503m = dVar;
    }

    @Override // i8.z
    public final void b(long j5, f fVar) {
        androidx.fragment.app.d dVar = new androidx.fragment.app.d(fVar, 8, this);
        if (j5 > 4611686018427387903L) {
            j5 = 4611686018427387903L;
        }
        if (this.f5501k.postDelayed(dVar, j5)) {
            fVar.u(new c(this, dVar));
        } else {
            i(fVar.f5261m, dVar);
        }
    }

    @Override // i8.s
    public final void c(g gVar, Runnable runnable) {
        if (this.f5501k.post(runnable)) {
            return;
        }
        i(gVar, runnable);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof d) && ((d) obj).f5501k == this.f5501k;
    }

    @Override // i8.s
    public final boolean g() {
        return (this.f5502l && i.a(Looper.myLooper(), this.f5501k.getLooper())) ? false : true;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f5501k);
    }

    public final void i(g gVar, Runnable runnable) {
        w.b(gVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        c0.f5251b.c(gVar, runnable);
    }

    @Override // i8.s
    public final String toString() {
        d dVar;
        String str;
        p8.d dVar2 = c0.f5250a;
        d dVar3 = o.f7529a;
        if (this == dVar3) {
            str = "Dispatchers.Main";
        } else {
            try {
                dVar = dVar3.f5503m;
            } catch (UnsupportedOperationException unused) {
                dVar = null;
            }
            str = this == dVar ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String handler = this.f5501k.toString();
        if (!this.f5502l) {
            return handler;
        }
        return handler + ".immediate";
    }
}
