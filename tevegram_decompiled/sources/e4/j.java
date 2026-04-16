package e4;

import android.graphics.Bitmap;
import w4.n;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j implements h {

    /* renamed from: a, reason: collision with root package name */
    public final e f3113a;

    /* renamed from: b, reason: collision with root package name */
    public int f3114b;

    /* renamed from: c, reason: collision with root package name */
    public Bitmap.Config f3115c;

    public j(e eVar) {
        this.f3113a = eVar;
    }

    @Override // e4.h
    public final void a() {
        this.f3113a.c(this);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (this.f3114b == jVar.f3114b && n.b(this.f3115c, jVar.f3115c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i9 = this.f3114b * 31;
        Bitmap.Config config = this.f3115c;
        return i9 + (config != null ? config.hashCode() : 0);
    }

    public final String toString() {
        return k.c(this.f3114b, this.f3115c);
    }
}
