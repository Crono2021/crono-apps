package a5;

import android.app.NotificationChannel;
import android.media.AudioFocusRequest;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ NotificationChannel c() {
        return new NotificationChannel("ProxyServiceChannel", "Servicio de Proxy Local (VOD)", 2);
    }

    public static /* synthetic */ AudioFocusRequest.Builder j(int i9) {
        return new AudioFocusRequest.Builder(i9);
    }

    public static /* synthetic */ void p() {
    }
}
