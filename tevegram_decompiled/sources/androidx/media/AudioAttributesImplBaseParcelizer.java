package androidx.media;

import x3.a;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(a aVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f967a = aVar.f(audioAttributesImplBase.f967a, 1);
        audioAttributesImplBase.f968b = aVar.f(audioAttributesImplBase.f968b, 2);
        audioAttributesImplBase.f969c = aVar.f(audioAttributesImplBase.f969c, 3);
        audioAttributesImplBase.f970d = aVar.f(audioAttributesImplBase.f970d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, a aVar) {
        aVar.getClass();
        aVar.j(audioAttributesImplBase.f967a, 1);
        aVar.j(audioAttributesImplBase.f968b, 2);
        aVar.j(audioAttributesImplBase.f969c, 3);
        aVar.j(audioAttributesImplBase.f970d, 4);
    }
}
