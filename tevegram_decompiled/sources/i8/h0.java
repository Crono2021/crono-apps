package i8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class h0 implements Runnable, Comparable, d0 {
    private volatile Object _heap;

    /* renamed from: i, reason: collision with root package name */
    public long f5272i;

    /* renamed from: j, reason: collision with root package name */
    public int f5273j;

    public final n8.x a() {
        Object obj = this._heap;
        if (obj instanceof n8.x) {
            return (n8.x) obj;
        }
        return null;
    }

    public final int b(long j5, i0 i0Var, j0 j0Var) {
        synchronized (this) {
            if (this._heap == w.f5312b) {
                return 2;
            }
            synchronized (i0Var) {
                try {
                    h0[] h0VarArr = i0Var.f7541a;
                    h0 h0Var = h0VarArr != null ? h0VarArr[0] : null;
                    if (j0.f5280q.get(j0Var) != 0) {
                        return 1;
                    }
                    if (h0Var == null) {
                        i0Var.f5275c = j5;
                    } else {
                        long j9 = h0Var.f5272i;
                        if (j9 - j5 < 0) {
                            j5 = j9;
                        }
                        if (j5 - i0Var.f5275c > 0) {
                            i0Var.f5275c = j5;
                        }
                    }
                    long j10 = this.f5272i;
                    long j11 = i0Var.f5275c;
                    if (j10 - j11 < 0) {
                        this.f5272i = j11;
                    }
                    i0Var.a(this);
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void c(i0 i0Var) {
        if (this._heap != w.f5312b) {
            this._heap = i0Var;
        } else {
            m7.c.n("Failed requirement.");
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j5 = this.f5272i - ((h0) obj).f5272i;
        if (j5 > 0) {
            return 1;
        }
        return j5 < 0 ? -1 : 0;
    }

    @Override // i8.d0
    public final void dispose() {
        synchronized (this) {
            try {
                Object obj = this._heap;
                a6.d dVar = w.f5312b;
                if (obj == dVar) {
                    return;
                }
                i0 i0Var = obj instanceof i0 ? (i0) obj : null;
                if (i0Var != null) {
                    i0Var.c(this);
                }
                this._heap = dVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return "Delayed[nanos=" + this.f5272i + ']';
    }
}
