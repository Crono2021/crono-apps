package com.network.tvgramplayer.data;

import androidx.activity.g;
import b8.i;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class Playlist {
    private final long dateCreated;
    private final String id;
    private boolean isAutoNextEnabled;
    private boolean isLoopEnabled;
    private boolean isPinned;
    private boolean isShuffleEnabled;
    private final List<PlaylistItem> items;
    private long lastModified;
    private String name;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ Playlist(java.lang.String r2, java.lang.String r3, long r4, java.util.List r6, boolean r7, boolean r8, boolean r9, boolean r10, long r11, int r13, b8.f r14) {
        /*
            r1 = this;
            r14 = r13 & 1
            if (r14 == 0) goto Lf
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r2 = r2.toString()
            r2.getClass()
        Lf:
            r14 = r13 & 4
            if (r14 == 0) goto L17
            long r4 = java.lang.System.currentTimeMillis()
        L17:
            r14 = r13 & 8
            if (r14 == 0) goto L20
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L20:
            r14 = r13 & 16
            r0 = 0
            if (r14 == 0) goto L26
            r7 = 0
        L26:
            r14 = r13 & 32
            if (r14 == 0) goto L2b
            r8 = 0
        L2b:
            r14 = r13 & 64
            if (r14 == 0) goto L30
            r9 = 0
        L30:
            r14 = r13 & 128(0x80, float:1.8E-43)
            if (r14 == 0) goto L35
            r10 = 1
        L35:
            r13 = r13 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L44
            r13 = r4
            r11 = r9
            r12 = r10
            r9 = r7
            r10 = r8
            r8 = r6
            r6 = r13
        L40:
            r4 = r2
            r5 = r3
            r3 = r1
            goto L4c
        L44:
            r13 = r11
            r11 = r9
            r12 = r10
            r9 = r7
            r10 = r8
            r8 = r6
            r6 = r4
            goto L40
        L4c:
            r3.<init>(r4, r5, r6, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.network.tvgramplayer.data.Playlist.<init>(java.lang.String, java.lang.String, long, java.util.List, boolean, boolean, boolean, boolean, long, int, b8.f):void");
    }

    public static /* synthetic */ Playlist copy$default(Playlist playlist, String str, String str2, long j5, List list, boolean z8, boolean z9, boolean z10, boolean z11, long j9, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = playlist.id;
        }
        if ((i9 & 2) != 0) {
            str2 = playlist.name;
        }
        if ((i9 & 4) != 0) {
            j5 = playlist.dateCreated;
        }
        if ((i9 & 8) != 0) {
            list = playlist.items;
        }
        if ((i9 & 16) != 0) {
            z8 = playlist.isPinned;
        }
        if ((i9 & 32) != 0) {
            z9 = playlist.isShuffleEnabled;
        }
        if ((i9 & 64) != 0) {
            z10 = playlist.isLoopEnabled;
        }
        if ((i9 & 128) != 0) {
            z11 = playlist.isAutoNextEnabled;
        }
        if ((i9 & 256) != 0) {
            j9 = playlist.lastModified;
        }
        long j10 = j9;
        boolean z12 = z11;
        boolean z13 = z9;
        List list2 = list;
        long j11 = j5;
        return playlist.copy(str, str2, j11, list2, z8, z13, z10, z12, j10);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final long component3() {
        return this.dateCreated;
    }

    public final List<PlaylistItem> component4() {
        return this.items;
    }

    public final boolean component5() {
        return this.isPinned;
    }

    public final boolean component6() {
        return this.isShuffleEnabled;
    }

    public final boolean component7() {
        return this.isLoopEnabled;
    }

    public final boolean component8() {
        return this.isAutoNextEnabled;
    }

    public final long component9() {
        return this.lastModified;
    }

    public final Playlist copy(String str, String str2, long j5, List<PlaylistItem> list, boolean z8, boolean z9, boolean z10, boolean z11, long j9) {
        str.getClass();
        str2.getClass();
        list.getClass();
        return new Playlist(str, str2, j5, list, z8, z9, z10, z11, j9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Playlist)) {
            return false;
        }
        Playlist playlist = (Playlist) obj;
        return i.a(this.id, playlist.id) && i.a(this.name, playlist.name) && this.dateCreated == playlist.dateCreated && i.a(this.items, playlist.items) && this.isPinned == playlist.isPinned && this.isShuffleEnabled == playlist.isShuffleEnabled && this.isLoopEnabled == playlist.isLoopEnabled && this.isAutoNextEnabled == playlist.isAutoNextEnabled && this.lastModified == playlist.lastModified;
    }

    public final long getDateCreated() {
        return this.dateCreated;
    }

    public final String getId() {
        return this.id;
    }

    public final List<PlaylistItem> getItems() {
        return this.items;
    }

    public final long getLastModified() {
        return this.lastModified;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int k3 = g.k(this.id.hashCode() * 31, 31, this.name);
        long j5 = this.dateCreated;
        int hashCode = (((((((this.items.hashCode() + ((k3 + ((int) (j5 ^ (j5 >>> 32)))) * 31)) * 31) + (this.isPinned ? 1231 : 1237)) * 31) + (this.isShuffleEnabled ? 1231 : 1237)) * 31) + (this.isLoopEnabled ? 1231 : 1237)) * 31;
        int i9 = this.isAutoNextEnabled ? 1231 : 1237;
        long j9 = this.lastModified;
        return ((hashCode + i9) * 31) + ((int) (j9 ^ (j9 >>> 32)));
    }

    public final boolean isAutoNextEnabled() {
        return this.isAutoNextEnabled;
    }

    public final boolean isLoopEnabled() {
        return this.isLoopEnabled;
    }

    public final boolean isPinned() {
        return this.isPinned;
    }

    public final boolean isShuffleEnabled() {
        return this.isShuffleEnabled;
    }

    public final void setAutoNextEnabled(boolean z8) {
        this.isAutoNextEnabled = z8;
    }

    public final void setLastModified(long j5) {
        this.lastModified = j5;
    }

    public final void setLoopEnabled(boolean z8) {
        this.isLoopEnabled = z8;
    }

    public final void setName(String str) {
        str.getClass();
        this.name = str;
    }

    public final void setPinned(boolean z8) {
        this.isPinned = z8;
    }

    public final void setShuffleEnabled(boolean z8) {
        this.isShuffleEnabled = z8;
    }

    public String toString() {
        return "Playlist(id=" + this.id + ", name=" + this.name + ", dateCreated=" + this.dateCreated + ", items=" + this.items + ", isPinned=" + this.isPinned + ", isShuffleEnabled=" + this.isShuffleEnabled + ", isLoopEnabled=" + this.isLoopEnabled + ", isAutoNextEnabled=" + this.isAutoNextEnabled + ", lastModified=" + this.lastModified + ")";
    }

    public Playlist(String str, String str2, long j5, List<PlaylistItem> list, boolean z8, boolean z9, boolean z10, boolean z11, long j9) {
        str.getClass();
        str2.getClass();
        list.getClass();
        this.id = str;
        this.name = str2;
        this.dateCreated = j5;
        this.items = list;
        this.isPinned = z8;
        this.isShuffleEnabled = z9;
        this.isLoopEnabled = z10;
        this.isAutoNextEnabled = z11;
        this.lastModified = j9;
    }
}
