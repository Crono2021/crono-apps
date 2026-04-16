package v1;

import java.io.IOException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f extends IOException {
    public f(int i9) {
        super("Illegal clipping: ".concat(i9 != 0 ? i9 != 1 ? i9 != 2 ? IjkMediaMeta.IJKM_VAL_TYPE__UNKNOWN : "start exceeds end" : "not seekable to start" : "invalid period count"));
    }
}
