package n1;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class d0 {
    public static l a(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z8) {
        int playbackOffloadSupport;
        playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        if (playbackOffloadSupport == 0) {
            return l.f7286d;
        }
        d4.j jVar = new d4.j();
        boolean z9 = g1.w.f3713a > 32 && playbackOffloadSupport == 2;
        jVar.f2853a = true;
        jVar.f2854b = z9;
        jVar.f2855c = z8;
        return jVar.a();
    }
}
