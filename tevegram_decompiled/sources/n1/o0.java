package n1;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f7304a = new Handler(Looper.myLooper());

    /* renamed from: b, reason: collision with root package name */
    public final n0 f7305b = new n0(this);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p0 f7306c;

    public o0(p0 p0Var) {
        this.f7306c = p0Var;
    }

    public void a(AudioTrack audioTrack) {
        Handler handler = this.f7304a;
        Objects.requireNonNull(handler);
        audioTrack.registerStreamEventCallback(new m0(handler), this.f7305b);
    }

    public void b(AudioTrack audioTrack) {
        audioTrack.unregisterStreamEventCallback(this.f7305b);
        this.f7304a.removeCallbacksAndMessages(null);
    }
}
