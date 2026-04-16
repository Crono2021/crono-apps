package androidx.media;

import android.media.AudioAttributes;
import x3.a;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(a aVar) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.f965a = (AudioAttributes) aVar.g(audioAttributesImplApi26.f965a, 1);
        audioAttributesImplApi26.f966b = aVar.f(audioAttributesImplApi26.f966b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, a aVar) {
        aVar.getClass();
        aVar.k(audioAttributesImplApi26.f965a, 1);
        aVar.j(audioAttributesImplApi26.f966b, 2);
    }
}
