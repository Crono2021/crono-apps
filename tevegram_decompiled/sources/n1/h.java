package n1;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h extends AudioDeviceCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f7252a;

    public h(j jVar) {
        this.f7252a = jVar;
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        j jVar = this.f7252a;
        jVar.a(e.c(jVar.f7272a, jVar.f7279i, jVar.h));
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        if (g1.w.j(audioDeviceInfoArr, this.f7252a.h)) {
            this.f7252a.h = null;
        }
        j jVar = this.f7252a;
        jVar.a(e.c(jVar.f7272a, jVar.f7279i, jVar.h));
    }
}
