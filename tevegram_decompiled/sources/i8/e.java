package i8;

import java.util.concurrent.ScheduledFuture;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e implements b1, a8.l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5254i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f5255j;

    public /* synthetic */ e(Object obj, int i9) {
        this.f5254i = i9;
        this.f5255j = obj;
    }

    @Override // a8.l
    public final /* bridge */ /* synthetic */ Object a(Object obj) {
        switch (this.f5254i) {
            case 0:
                b((Throwable) obj);
                break;
            case 1:
                b((Throwable) obj);
                break;
            default:
                b((Throwable) obj);
                break;
        }
        return n7.g.f7490c;
    }

    public final void b(Throwable th) {
        switch (this.f5254i) {
            case 0:
                if (th != null) {
                    ((ScheduledFuture) this.f5255j).cancel(false);
                    break;
                }
                break;
            case 1:
                ((d0) this.f5255j).dispose();
                break;
            default:
                ((a8.l) this.f5255j).a(th);
                break;
        }
    }

    public final String toString() {
        switch (this.f5254i) {
            case 0:
                return "CancelFutureOnCancel[" + ((ScheduledFuture) this.f5255j) + ']';
            case 1:
                return "DisposeOnCancel[" + ((d0) this.f5255j) + ']';
            default:
                return "InvokeOnCancel[" + ((a8.l) this.f5255j).getClass().getSimpleName() + '@' + w.f(this) + ']';
        }
    }
}
