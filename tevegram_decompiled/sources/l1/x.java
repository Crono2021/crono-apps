package l1;

import android.content.Context;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackSession;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class x {
    public static m1.x a(Context context, b0 b0Var, boolean z8) {
        PlaybackSession createPlaybackSession;
        m1.v vVar;
        LogSessionId sessionId;
        LogSessionId logSessionId;
        MediaMetricsManager d9 = d5.a.d(context.getSystemService("media_metrics"));
        if (d9 == null) {
            vVar = null;
        } else {
            createPlaybackSession = d9.createPlaybackSession();
            vVar = new m1.v(context, createPlaybackSession);
        }
        if (vVar == null) {
            g1.a.D("ExoPlayerImpl", "MediaMetricsService unavailable.");
            logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
            return new m1.x(logSessionId);
        }
        if (z8) {
            m1.q qVar = b0Var.f5804y;
            qVar.getClass();
            qVar.f6556n.a(vVar);
        }
        sessionId = vVar.f6577c.getSessionId();
        return new m1.x(sessionId);
    }
}
