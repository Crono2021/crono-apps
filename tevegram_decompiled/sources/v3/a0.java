package v3;

import android.view.ViewGroup;
import android.view.WindowId;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final WindowId f9504a;

    public a0(ViewGroup viewGroup) {
        this.f9504a = viewGroup.getWindowId();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a0) && ((a0) obj).f9504a.equals(this.f9504a);
    }

    public final int hashCode() {
        return this.f9504a.hashCode();
    }
}
