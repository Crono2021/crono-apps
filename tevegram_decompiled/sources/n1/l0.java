package n1;

import android.media.AudioDeviceInfo;
import android.media.AudioRouting;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public final AudioTrack f7290a;

    /* renamed from: b, reason: collision with root package name */
    public final j f7291b;

    /* renamed from: c, reason: collision with root package name */
    public k0 f7292c = new AudioRouting.OnRoutingChangedListener() { // from class: n1.k0
        @Override // android.media.AudioRouting.OnRoutingChangedListener
        public final void onRoutingChanged(AudioRouting audioRouting) {
            l0.this.b(audioRouting);
        }
    };

    /* JADX WARN: Type inference failed for: r3v1, types: [n1.k0] */
    public l0(AudioTrack audioTrack, j jVar) {
        this.f7290a = audioTrack;
        this.f7291b = jVar;
        audioTrack.addOnRoutingChangedListener(this.f7292c, new Handler(Looper.myLooper()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AudioRouting audioRouting) {
        AudioDeviceInfo routedDevice;
        AudioDeviceInfo routedDevice2;
        if (this.f7292c == null) {
            return;
        }
        routedDevice = audioRouting.getRoutedDevice();
        if (routedDevice != null) {
            j jVar = this.f7291b;
            routedDevice2 = audioRouting.getRoutedDevice();
            jVar.b(routedDevice2);
        }
    }

    public void c() {
        k0 k0Var = this.f7292c;
        k0Var.getClass();
        this.f7290a.removeOnRoutingChangedListener(k0Var);
        this.f7292c = null;
    }
}
