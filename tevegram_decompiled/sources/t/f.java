package t;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f extends com.bumptech.glide.d {
    @Override // com.bumptech.glide.d
    public final void R(g gVar, g gVar2) {
        gVar.f8907b = gVar2;
    }

    @Override // com.bumptech.glide.d
    public final void S(g gVar, Thread thread) {
        gVar.f8906a = thread;
    }

    @Override // com.bumptech.glide.d
    public final boolean d(h hVar, d dVar, d dVar2) {
        synchronized (hVar) {
            try {
                if (hVar.f8913j != dVar) {
                    return false;
                }
                hVar.f8913j = dVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.d
    public final boolean e(h hVar, Object obj, Object obj2) {
        synchronized (hVar) {
            try {
                if (hVar.f8912i != obj) {
                    return false;
                }
                hVar.f8912i = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.d
    public final boolean f(h hVar, g gVar, g gVar2) {
        synchronized (hVar) {
            try {
                if (hVar.f8914k != gVar) {
                    return false;
                }
                hVar.f8914k = gVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
