package d4;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends WeakReference {

    /* renamed from: a, reason: collision with root package name */
    public final b4.f f2794a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2795b;

    /* renamed from: c, reason: collision with root package name */
    public a0 f2796c;

    public b(b4.f fVar, u uVar, ReferenceQueue referenceQueue) {
        super(uVar, referenceQueue);
        w4.f.c(fVar, "Argument must not be null");
        this.f2794a = fVar;
        boolean z8 = uVar.f2924i;
        this.f2796c = null;
        this.f2795b = z8;
    }
}
