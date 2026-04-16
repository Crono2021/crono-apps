package n1;

import android.media.AudioTrack;
import android.media.metrics.LogSessionId;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class g0 {
    public static void a(AudioTrack audioTrack, m1.x xVar) {
        boolean equals;
        LogSessionId unused;
        m1.w wVar = xVar.f6602a;
        wVar.getClass();
        LogSessionId logSessionId = wVar.f6601a;
        unused = LogSessionId.LOG_SESSION_ID_NONE;
        equals = logSessionId.equals(LogSessionId.LOG_SESSION_ID_NONE);
        if (equals) {
            return;
        }
        audioTrack.setLogSessionId(logSessionId);
    }
}
