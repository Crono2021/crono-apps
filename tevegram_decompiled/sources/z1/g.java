package z1;

import d1.m0;
import i1.w;
import java.io.FileNotFoundException;
import java.io.IOException;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class g {
    private static final int DEFAULT_BEHAVIOR_MIN_LOADABLE_RETRY_COUNT = -1;
    public static final long DEFAULT_LOCATION_EXCLUSION_MS = 300000;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_PROGRESSIVE_LIVE = 6;

    @Deprecated
    public static final long DEFAULT_TRACK_BLACKLIST_MS = 60000;
    public static final long DEFAULT_TRACK_EXCLUSION_MS = 60000;
    private final int minimumLoadableRetryCount = -1;

    public i getFallbackSelectionFor(h hVar, j jVar) {
        if (!isEligibleForFallback(jVar.f10572a)) {
            return null;
        }
        hVar.getClass();
        if (hVar.f10568a - hVar.f10569b > 1) {
            return new i(2, 60000L);
        }
        return null;
    }

    public int getMinimumLoadableRetryCount(int i9) {
        int i10 = this.minimumLoadableRetryCount;
        return i10 == -1 ? i9 == 7 ? 6 : 3 : i10;
    }

    public long getRetryDelayMsFor(j jVar) {
        Throwable th = jVar.f10572a;
        if ((th instanceof m0) || (th instanceof FileNotFoundException) || (th instanceof i1.t) || (th instanceof o)) {
            return -9223372036854775807L;
        }
        while (th != null) {
            if ((th instanceof i1.i) && ((i1.i) th).f4318i == 2008) {
                return -9223372036854775807L;
            }
            th = th.getCause();
        }
        return Math.min((jVar.f10573b - 1) * IjkMediaCodecInfo.RANK_MAX, 5000);
    }

    public boolean isEligibleForFallback(IOException iOException) {
        if (!(iOException instanceof w)) {
            return false;
        }
        int i9 = ((w) iOException).f4364k;
        return i9 == 403 || i9 == 404 || i9 == 410 || i9 == 416 || i9 == 500 || i9 == 503;
    }

    public void onLoadTaskConcluded(long j5) {
    }
}
