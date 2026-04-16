package a5;

import android.media.AudioDeviceInfo;
import android.media.MediaDrmResetException;
import android.security.keystore.KeyGenParameterSpec;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract /* synthetic */ class c {
    public static /* bridge */ /* synthetic */ AudioDeviceInfo h(Object obj) {
        return (AudioDeviceInfo) obj;
    }

    public static /* synthetic */ KeyGenParameterSpec.Builder k(String str) {
        return new KeyGenParameterSpec.Builder(str, 3);
    }

    public static /* bridge */ /* synthetic */ ThemedSpinnerAdapter n(SpinnerAdapter spinnerAdapter) {
        return (ThemedSpinnerAdapter) spinnerAdapter;
    }

    public static /* synthetic */ void p() {
    }

    public static /* bridge */ /* synthetic */ boolean y(SpinnerAdapter spinnerAdapter) {
        return spinnerAdapter instanceof ThemedSpinnerAdapter;
    }

    public static /* bridge */ /* synthetic */ boolean z(Throwable th) {
        return th instanceof MediaDrmResetException;
    }
}
