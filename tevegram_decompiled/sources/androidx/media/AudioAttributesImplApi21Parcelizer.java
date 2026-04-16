package androidx.media;

import android.media.AudioAttributes;
import x3.a;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(a aVar) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f965a = (AudioAttributes) aVar.g(audioAttributesImplApi21.f965a, 1);
        audioAttributesImplApi21.f966b = aVar.f(audioAttributesImplApi21.f966b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, a aVar) {
        aVar.getClass();
        aVar.k(audioAttributesImplApi21.f965a, 1);
        aVar.j(audioAttributesImplApi21.f966b, 2);
    }
}
