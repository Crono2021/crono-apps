package com.network.tvgramplayer.data;

import androidx.activity.g;
import b8.i;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class PlaylistItem {
    private final long chatId;
    private final long dateAdded;
    private final int duration;
    private final String id;
    private final long mediaGroupId;
    private final long msgId;
    private final String title;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ PlaylistItem(java.lang.String r1, long r2, long r4, java.lang.String r6, int r7, long r8, long r10, int r12, b8.f r13) {
        /*
            r0 = this;
            r13 = r12 & 1
            if (r13 == 0) goto Lf
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r1 = r1.toString()
            r1.getClass()
        Lf:
            r13 = r12 & 16
            if (r13 == 0) goto L14
            r7 = 0
        L14:
            r13 = r12 & 32
            if (r13 == 0) goto L1a
            r8 = 0
        L1a:
            r12 = r12 & 64
            if (r12 == 0) goto L22
            long r10 = java.lang.System.currentTimeMillis()
        L22:
            r12 = r10
            r10 = r8
            r8 = r6
            r9 = r7
            r6 = r4
            r4 = r2
            r2 = r0
            r3 = r1
            r2.<init>(r3, r4, r6, r8, r9, r10, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.network.tvgramplayer.data.PlaylistItem.<init>(java.lang.String, long, long, java.lang.String, int, long, long, int, b8.f):void");
    }

    public static /* synthetic */ PlaylistItem copy$default(PlaylistItem playlistItem, String str, long j5, long j9, String str2, int i9, long j10, long j11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = playlistItem.id;
        }
        if ((i10 & 2) != 0) {
            j5 = playlistItem.chatId;
        }
        if ((i10 & 4) != 0) {
            j9 = playlistItem.msgId;
        }
        if ((i10 & 8) != 0) {
            str2 = playlistItem.title;
        }
        if ((i10 & 16) != 0) {
            i9 = playlistItem.duration;
        }
        if ((i10 & 32) != 0) {
            j10 = playlistItem.mediaGroupId;
        }
        if ((i10 & 64) != 0) {
            j11 = playlistItem.dateAdded;
        }
        long j12 = j11;
        long j13 = j9;
        return playlistItem.copy(str, j5, j13, str2, i9, j10, j12);
    }

    public final String component1() {
        return this.id;
    }

    public final long component2() {
        return this.chatId;
    }

    public final long component3() {
        return this.msgId;
    }

    public final String component4() {
        return this.title;
    }

    public final int component5() {
        return this.duration;
    }

    public final long component6() {
        return this.mediaGroupId;
    }

    public final long component7() {
        return this.dateAdded;
    }

    public final PlaylistItem copy(String str, long j5, long j9, String str2, int i9, long j10, long j11) {
        str.getClass();
        str2.getClass();
        return new PlaylistItem(str, j5, j9, str2, i9, j10, j11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaylistItem)) {
            return false;
        }
        PlaylistItem playlistItem = (PlaylistItem) obj;
        return i.a(this.id, playlistItem.id) && this.chatId == playlistItem.chatId && this.msgId == playlistItem.msgId && i.a(this.title, playlistItem.title) && this.duration == playlistItem.duration && this.mediaGroupId == playlistItem.mediaGroupId && this.dateAdded == playlistItem.dateAdded;
    }

    public final long getChatId() {
        return this.chatId;
    }

    public final long getDateAdded() {
        return this.dateAdded;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final String getId() {
        return this.id;
    }

    public final long getMediaGroupId() {
        return this.mediaGroupId;
    }

    public final long getMsgId() {
        return this.msgId;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = this.id.hashCode() * 31;
        long j5 = this.chatId;
        int i9 = (hashCode + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j9 = this.msgId;
        int k3 = (g.k((i9 + ((int) (j9 ^ (j9 >>> 32)))) * 31, 31, this.title) + this.duration) * 31;
        long j10 = this.mediaGroupId;
        long j11 = this.dateAdded;
        return ((k3 + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "PlaylistItem(id=" + this.id + ", chatId=" + this.chatId + ", msgId=" + this.msgId + ", title=" + this.title + ", duration=" + this.duration + ", mediaGroupId=" + this.mediaGroupId + ", dateAdded=" + this.dateAdded + ")";
    }

    public PlaylistItem(String str, long j5, long j9, String str2, int i9, long j10, long j11) {
        str.getClass();
        str2.getClass();
        this.id = str;
        this.chatId = j5;
        this.msgId = j9;
        this.title = str2;
        this.duration = i9;
        this.mediaGroupId = j10;
        this.dateAdded = j11;
    }
}
