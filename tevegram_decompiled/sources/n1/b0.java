package n1;

import android.media.AudioDeviceInfo;
import android.media.AudioTrack;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class b0 {
    public static void a(w wVar, Object obj) {
        k kVar;
        AudioDeviceInfo h = a5.c.h(obj);
        p0 p0Var = (p0) wVar;
        if (h == null) {
            kVar = null;
        } else {
            p0Var.getClass();
            kVar = new k(h);
        }
        p0Var.Z = kVar;
        j jVar = p0Var.f7344w;
        if (jVar != null) {
            jVar.b(h);
        }
        AudioTrack audioTrack = p0Var.f7342u;
        if (audioTrack != null) {
            f0.a(audioTrack, p0Var.Z);
        }
    }
}
