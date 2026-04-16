package tv.danmaku.ijk.media.player.misc;

import android.text.TextUtils;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class IjkTrackInfo implements ITrackInfo {
    private IjkMediaMeta.IjkStreamMeta mStreamMeta;
    private int mTrackType = 0;

    public IjkTrackInfo(IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        this.mStreamMeta = ijkStreamMeta;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public IMediaFormat getFormat() {
        return new IjkMediaFormat(this.mStreamMeta);
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public String getInfoInline() {
        StringBuilder sb = new StringBuilder(128);
        int i9 = this.mTrackType;
        if (i9 == 1) {
            sb.append("VIDEO, ");
            sb.append(this.mStreamMeta.getCodecShortNameInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getBitrateInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getResolutionInline());
        } else if (i9 == 2) {
            sb.append("AUDIO, ");
            sb.append(this.mStreamMeta.getCodecShortNameInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getBitrateInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getSampleRateInline());
        } else if (i9 == 3) {
            sb.append("TIMEDTEXT, ");
            sb.append(this.mStreamMeta.mLanguage);
        } else if (i9 != 4) {
            sb.append("UNKNOWN");
        } else {
            sb.append("SUBTITLE");
        }
        return sb.toString();
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public String getLanguage() {
        IjkMediaMeta.IjkStreamMeta ijkStreamMeta = this.mStreamMeta;
        return (ijkStreamMeta == null || TextUtils.isEmpty(ijkStreamMeta.mLanguage)) ? "und" : this.mStreamMeta.mLanguage;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public int getTrackType() {
        return this.mTrackType;
    }

    public void setMediaMeta(IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        this.mStreamMeta = ijkStreamMeta;
    }

    public void setTrackType(int i9) {
        this.mTrackType = i9;
    }

    public String toString() {
        return getClass().getSimpleName() + '{' + getInfoInline() + "}";
    }
}
