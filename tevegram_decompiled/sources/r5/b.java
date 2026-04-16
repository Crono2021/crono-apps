package r5;

import android.graphics.Typeface;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends e0.b {
    public final /* synthetic */ a.a h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ d f8560i;

    public b(d dVar, a.a aVar) {
        this.f8560i = dVar;
        this.h = aVar;
    }

    @Override // e0.b
    public final void h(int i9) {
        this.f8560i.f8576m = true;
        this.h.D(i9);
    }

    @Override // e0.b
    public final void i(Typeface typeface) {
        d dVar = this.f8560i;
        Typeface create = Typeface.create(typeface, dVar.f8567c);
        dVar.f8577n = create;
        dVar.f8576m = true;
        this.h.E(create, false);
    }
}
