package i8;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class w0 implements n0 {

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f5320j = AtomicIntegerFieldUpdater.newUpdater(w0.class, "_isCompleting");

    /* renamed from: k, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f5321k = AtomicReferenceFieldUpdater.newUpdater(w0.class, Object.class, "_rootCause");

    /* renamed from: l, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f5322l = AtomicReferenceFieldUpdater.newUpdater(w0.class, Object.class, "_exceptionsHolder");
    private volatile Object _exceptionsHolder;
    private volatile int _isCompleting = 0;
    private volatile Object _rootCause;

    /* renamed from: i, reason: collision with root package name */
    public final z0 f5323i;

    public w0(z0 z0Var, Throwable th) {
        this.f5323i = z0Var;
        this._rootCause = th;
    }

    public final void a(Throwable th) {
        Throwable c9 = c();
        if (c9 == null) {
            f5321k.set(this, th);
            return;
        }
        if (th == c9) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5322l;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            atomicReferenceFieldUpdater.set(this, th);
            return;
        }
        if (!(obj instanceof Throwable)) {
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(th);
                return;
            } else {
                h7.o.c(obj, "State is ");
                return;
            }
        }
        if (th == obj) {
            return;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(th);
        atomicReferenceFieldUpdater.set(this, arrayList);
    }

    @Override // i8.n0
    public final boolean b() {
        return c() == null;
    }

    public final Throwable c() {
        return (Throwable) f5321k.get(this);
    }

    public final boolean d() {
        return c() != null;
    }

    public final boolean e() {
        return f5320j.get(this) != 0;
    }

    public final ArrayList f(Throwable th) {
        ArrayList arrayList;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5322l;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            arrayList = new ArrayList(4);
        } else if (obj instanceof Throwable) {
            ArrayList arrayList2 = new ArrayList(4);
            arrayList2.add(obj);
            arrayList = arrayList2;
        } else {
            if (!(obj instanceof ArrayList)) {
                h7.o.c(obj, "State is ");
                return null;
            }
            arrayList = (ArrayList) obj;
        }
        Throwable c9 = c();
        if (c9 != null) {
            arrayList.add(0, c9);
        }
        if (th != null && !th.equals(c9)) {
            arrayList.add(th);
        }
        atomicReferenceFieldUpdater.set(this, w.h);
        return arrayList;
    }

    @Override // i8.n0
    public final z0 g() {
        return this.f5323i;
    }

    public final String toString() {
        return "Finishing[cancelling=" + d() + ", completing=" + e() + ", rootCause=" + c() + ", exceptions=" + f5322l.get(this) + ", list=" + this.f5323i + ']';
    }
}
