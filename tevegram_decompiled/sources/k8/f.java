package k8;

import i8.b1;
import i8.w;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final l f5648a = new l(-1, null, null, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final int f5649b = n8.a.j(32, 12, "kotlinx.coroutines.bufferedChannel.segmentSize");

    /* renamed from: c, reason: collision with root package name */
    public static final int f5650c = n8.a.j(10000, 12, "kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations");

    /* renamed from: d, reason: collision with root package name */
    public static final a6.d f5651d = new a6.d("BUFFERED", 3);

    /* renamed from: e, reason: collision with root package name */
    public static final a6.d f5652e = new a6.d("SHOULD_BUFFER", 3);

    /* renamed from: f, reason: collision with root package name */
    public static final a6.d f5653f = new a6.d("S_RESUMING_BY_RCV", 3);

    /* renamed from: g, reason: collision with root package name */
    public static final a6.d f5654g = new a6.d("RESUMING_BY_EB", 3);
    public static final a6.d h = new a6.d("POISONED", 3);

    /* renamed from: i, reason: collision with root package name */
    public static final a6.d f5655i = new a6.d("DONE_RCV", 3);

    /* renamed from: j, reason: collision with root package name */
    public static final a6.d f5656j = new a6.d("INTERRUPTED_SEND", 3);

    /* renamed from: k, reason: collision with root package name */
    public static final a6.d f5657k = new a6.d("INTERRUPTED_RCV", 3);

    /* renamed from: l, reason: collision with root package name */
    public static final a6.d f5658l = new a6.d("CHANNEL_CLOSED", 3);

    /* renamed from: m, reason: collision with root package name */
    public static final a6.d f5659m = new a6.d("SUSPEND", 3);

    /* renamed from: n, reason: collision with root package name */
    public static final a6.d f5660n = new a6.d("SUSPEND_NO_WAITER", 3);

    /* renamed from: o, reason: collision with root package name */
    public static final a6.d f5661o = new a6.d("FAILED", 3);

    /* renamed from: p, reason: collision with root package name */
    public static final a6.d f5662p = new a6.d("NO_RECEIVE_RESULT", 3);

    /* renamed from: q, reason: collision with root package name */
    public static final a6.d f5663q = new a6.d("CLOSE_HANDLER_CLOSED", 3);

    /* renamed from: r, reason: collision with root package name */
    public static final a6.d f5664r = new a6.d("CLOSE_HANDLER_INVOKED", 3);

    /* renamed from: s, reason: collision with root package name */
    public static final a6.d f5665s = new a6.d("NO_CLOSE_CAUSE", 3);

    public static final boolean a(i8.f fVar, Object obj, n8.p pVar) {
        fVar.getClass();
        a6.d dVar = w.f5311a;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i8.f.f5258o;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(fVar);
            if (!(obj2 instanceof b1)) {
                dVar = null;
                break;
            }
            Object C = i8.f.C((b1) obj2, obj, fVar.f5247k, pVar);
            while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj2, C)) {
                if (atomicReferenceFieldUpdater.get(fVar) != obj2) {
                    break;
                }
            }
            if (!fVar.w()) {
                fVar.o();
            }
        }
        if (dVar == null) {
            return false;
        }
        fVar.p(fVar.f5247k);
        return true;
    }
}
