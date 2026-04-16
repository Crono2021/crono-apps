package l1;

import android.media.AudioManager;
import android.os.Handler;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f5806a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f5807b;

    public c(d dVar, Handler handler) {
        this.f5807b = dVar;
        this.f5806a = handler;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i9) {
        this.f5806a.post(new e0.m(i9, 1, this));
    }
}
