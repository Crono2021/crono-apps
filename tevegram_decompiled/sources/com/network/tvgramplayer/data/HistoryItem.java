package com.network.tvgramplayer.data;

import androidx.activity.g;
import b8.f;
import b8.i;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class HistoryItem {
    private String audioTrackId;
    private final long chatId;
    private final String chatType;
    private final String groupName;
    private boolean isFavorite;
    private long positionMs;
    private String subtitleTrackId;
    private final long timestamp;
    private final String title;
    private final String type;
    private final String url;

    public /* synthetic */ HistoryItem(long j5, String str, String str2, String str3, String str4, boolean z8, long j9, long j10, String str5, String str6, String str7, int i9, f fVar) {
        this(j5, str, str2, (i9 & 8) != 0 ? null : str3, (i9 & 16) != 0 ? null : str4, (i9 & 32) != 0 ? false : z8, (i9 & 64) != 0 ? System.currentTimeMillis() : j9, (i9 & 128) != 0 ? 0L : j10, (i9 & 256) != 0 ? null : str5, (i9 & IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED) != 0 ? null : str6, (i9 & 1024) != 0 ? "auto" : str7);
    }

    public final long component1() {
        return this.chatId;
    }

    public final String component10() {
        return this.audioTrackId;
    }

    public final String component11() {
        return this.type;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.groupName;
    }

    public final String component5() {
        return this.chatType;
    }

    public final boolean component6() {
        return this.isFavorite;
    }

    public final long component7() {
        return this.timestamp;
    }

    public final long component8() {
        return this.positionMs;
    }

    public final String component9() {
        return this.subtitleTrackId;
    }

    public final HistoryItem copy(long j5, String str, String str2, String str3, String str4, boolean z8, long j9, long j10, String str5, String str6, String str7) {
        str.getClass();
        str2.getClass();
        return new HistoryItem(j5, str, str2, str3, str4, z8, j9, j10, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HistoryItem)) {
            return false;
        }
        HistoryItem historyItem = (HistoryItem) obj;
        return this.chatId == historyItem.chatId && i.a(this.url, historyItem.url) && i.a(this.title, historyItem.title) && i.a(this.groupName, historyItem.groupName) && i.a(this.chatType, historyItem.chatType) && this.isFavorite == historyItem.isFavorite && this.timestamp == historyItem.timestamp && this.positionMs == historyItem.positionMs && i.a(this.subtitleTrackId, historyItem.subtitleTrackId) && i.a(this.audioTrackId, historyItem.audioTrackId) && i.a(this.type, historyItem.type);
    }

    public final String getAudioTrackId() {
        return this.audioTrackId;
    }

    public final long getChatId() {
        return this.chatId;
    }

    public final String getChatType() {
        return this.chatType;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final long getPositionMs() {
        return this.positionMs;
    }

    public final String getSubtitleTrackId() {
        return this.subtitleTrackId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        long j5 = this.chatId;
        int k3 = g.k(g.k(((int) (j5 ^ (j5 >>> 32))) * 31, 31, this.url), 31, this.title);
        String str = this.groupName;
        int hashCode = (k3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.chatType;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        int i9 = this.isFavorite ? 1231 : 1237;
        long j9 = this.timestamp;
        int i10 = (((hashCode2 + i9) * 31) + ((int) (j9 ^ (j9 >>> 32)))) * 31;
        long j10 = this.positionMs;
        int i11 = (i10 + ((int) ((j10 >>> 32) ^ j10))) * 31;
        String str3 = this.subtitleTrackId;
        int hashCode3 = (i11 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.audioTrackId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.type;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    public final void setAudioTrackId(String str) {
        this.audioTrackId = str;
    }

    public final void setFavorite(boolean z8) {
        this.isFavorite = z8;
    }

    public final void setPositionMs(long j5) {
        this.positionMs = j5;
    }

    public final void setSubtitleTrackId(String str) {
        this.subtitleTrackId = str;
    }

    public String toString() {
        return "HistoryItem(chatId=" + this.chatId + ", url=" + this.url + ", title=" + this.title + ", groupName=" + this.groupName + ", chatType=" + this.chatType + ", isFavorite=" + this.isFavorite + ", timestamp=" + this.timestamp + ", positionMs=" + this.positionMs + ", subtitleTrackId=" + this.subtitleTrackId + ", audioTrackId=" + this.audioTrackId + ", type=" + this.type + ")";
    }

    public HistoryItem(long j5, String str, String str2, String str3, String str4, boolean z8, long j9, long j10, String str5, String str6, String str7) {
        str.getClass();
        str2.getClass();
        this.chatId = j5;
        this.url = str;
        this.title = str2;
        this.groupName = str3;
        this.chatType = str4;
        this.isFavorite = z8;
        this.timestamp = j9;
        this.positionMs = j10;
        this.subtitleTrackId = str5;
        this.audioTrackId = str6;
        this.type = str7;
    }
}
