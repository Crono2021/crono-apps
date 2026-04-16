package p;

import java.util.HashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends f {

    /* renamed from: m, reason: collision with root package name */
    public final HashMap f8078m = new HashMap();

    @Override // p.f
    public final c f(Object obj) {
        return (c) this.f8078m.get(obj);
    }

    @Override // p.f
    public final Object g(Object obj) {
        Object g9 = super.g(obj);
        this.f8078m.remove(obj);
        return g9;
    }
}
