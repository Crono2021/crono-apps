package n1;

import org.webrtc.PeerConnectionFactory;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q0 {

    /* renamed from: a, reason: collision with root package name */
    public static final q0 f7348a = new q0();

    public static int a(int i9) {
        switch (i9) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
            case 19:
            default:
                m7.c.d();
                return 0;
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                return 256000;
            case 17:
                return 336000;
            case 20:
                return 63750;
        }
    }
}
