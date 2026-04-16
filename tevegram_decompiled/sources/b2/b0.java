package b2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b0 implements Choreographer.FrameCallback, Handler.Callback {

    /* renamed from: m, reason: collision with root package name */
    public static final b0 f1141m = new b0();

    /* renamed from: i, reason: collision with root package name */
    public volatile long f1142i = -9223372036854775807L;

    /* renamed from: j, reason: collision with root package name */
    public final Handler f1143j;

    /* renamed from: k, reason: collision with root package name */
    public Choreographer f1144k;

    /* renamed from: l, reason: collision with root package name */
    public int f1145l;

    public b0() {
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        int i9 = g1.w.f3713a;
        Handler handler = new Handler(looper, this);
        this.f1143j = handler;
        handler.sendEmptyMessage(0);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j5) {
        this.f1142i = j5;
        Choreographer choreographer = this.f1144k;
        choreographer.getClass();
        choreographer.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i9 = message.what;
        if (i9 == 0) {
            try {
                this.f1144k = Choreographer.getInstance();
            } catch (RuntimeException e9) {
                g1.a.E("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e9);
            }
            return true;
        }
        if (i9 == 1) {
            Choreographer choreographer = this.f1144k;
            if (choreographer != null) {
                int i10 = this.f1145l + 1;
                this.f1145l = i10;
                if (i10 == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
            return true;
        }
        if (i9 != 2) {
            return false;
        }
        Choreographer choreographer2 = this.f1144k;
        if (choreographer2 != null) {
            int i11 = this.f1145l - 1;
            this.f1145l = i11;
            if (i11 == 0) {
                choreographer2.removeFrameCallback(this);
                this.f1142i = -9223372036854775807L;
            }
        }
        return true;
    }
}
