package com.network.tvgramplayer.telegram;

import androidx.activity.g;
import b8.f;
import b8.i;
import java.util.List;
import t.a;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class TdClient$ExplorerItem {
    private final List<TdClient$ExplorerAction> actions;
    private final long chatId;
    private final int date;
    private final String description;
    private final long mediaGroupId;
    private final long messageId;
    private final int thumbnailFileId;
    private final String title;
    private final TdClient$ExplorerType type;

    public /* synthetic */ TdClient$ExplorerItem(long j5, long j9, TdClient$ExplorerType tdClient$ExplorerType, String str, String str2, int i9, List list, int i10, long j10, int i11, f fVar) {
        this((i11 & 1) != 0 ? 0L : j5, j9, tdClient$ExplorerType, str, str2, (i11 & 32) != 0 ? 0 : i9, list, i10, (i11 & 256) != 0 ? 0L : j10);
    }

    public final long component1() {
        return this.chatId;
    }

    public final long component2() {
        return this.messageId;
    }

    public final TdClient$ExplorerType component3() {
        return this.type;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.description;
    }

    public final int component6() {
        return this.thumbnailFileId;
    }

    public final List<TdClient$ExplorerAction> component7() {
        return this.actions;
    }

    public final int component8() {
        return this.date;
    }

    public final long component9() {
        return this.mediaGroupId;
    }

    public final TdClient$ExplorerItem copy(long j5, long j9, TdClient$ExplorerType tdClient$ExplorerType, String str, String str2, int i9, List<TdClient$ExplorerAction> list, int i10, long j10) {
        tdClient$ExplorerType.getClass();
        str.getClass();
        list.getClass();
        return new TdClient$ExplorerItem(j5, j9, tdClient$ExplorerType, str, str2, i9, list, i10, j10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TdClient$ExplorerItem)) {
            return false;
        }
        TdClient$ExplorerItem tdClient$ExplorerItem = (TdClient$ExplorerItem) obj;
        return this.chatId == tdClient$ExplorerItem.chatId && this.messageId == tdClient$ExplorerItem.messageId && this.type == tdClient$ExplorerItem.type && i.a(this.title, tdClient$ExplorerItem.title) && i.a(this.description, tdClient$ExplorerItem.description) && this.thumbnailFileId == tdClient$ExplorerItem.thumbnailFileId && i.a(this.actions, tdClient$ExplorerItem.actions) && this.date == tdClient$ExplorerItem.date && this.mediaGroupId == tdClient$ExplorerItem.mediaGroupId;
    }

    public final List<TdClient$ExplorerAction> getActions() {
        return this.actions;
    }

    public final long getChatId() {
        return this.chatId;
    }

    public final int getDate() {
        return this.date;
    }

    public final String getDescription() {
        return this.description;
    }

    public final long getMediaGroupId() {
        return this.mediaGroupId;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final int getThumbnailFileId() {
        return this.thumbnailFileId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final TdClient$ExplorerType getType() {
        return this.type;
    }

    public int hashCode() {
        long j5 = this.chatId;
        long j9 = this.messageId;
        int k3 = g.k((this.type.hashCode() + (((((int) (j5 ^ (j5 >>> 32))) * 31) + ((int) (j9 ^ (j9 >>> 32)))) * 31)) * 31, 31, this.title);
        String str = this.description;
        int hashCode = (((this.actions.hashCode() + ((((k3 + (str == null ? 0 : str.hashCode())) * 31) + this.thumbnailFileId) * 31)) * 31) + this.date) * 31;
        long j10 = this.mediaGroupId;
        return hashCode + ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        long j5 = this.chatId;
        long j9 = this.messageId;
        TdClient$ExplorerType tdClient$ExplorerType = this.type;
        String str = this.title;
        String str2 = this.description;
        int i9 = this.thumbnailFileId;
        List<TdClient$ExplorerAction> list = this.actions;
        int i10 = this.date;
        long j10 = this.mediaGroupId;
        StringBuilder c9 = a.c("ExplorerItem(chatId=", j5, ", messageId=");
        c9.append(j9);
        c9.append(", type=");
        c9.append(tdClient$ExplorerType);
        c9.append(", title=");
        c9.append(str);
        c9.append(", description=");
        c9.append(str2);
        c9.append(", thumbnailFileId=");
        c9.append(i9);
        c9.append(", actions=");
        c9.append(list);
        c9.append(", date=");
        c9.append(i10);
        c9.append(", mediaGroupId=");
        c9.append(j10);
        c9.append(")");
        return c9.toString();
    }

    public TdClient$ExplorerItem(long j5, long j9, TdClient$ExplorerType tdClient$ExplorerType, String str, String str2, int i9, List<TdClient$ExplorerAction> list, int i10, long j10) {
        tdClient$ExplorerType.getClass();
        str.getClass();
        list.getClass();
        this.chatId = j5;
        this.messageId = j9;
        this.type = tdClient$ExplorerType;
        this.title = str;
        this.description = str2;
        this.thumbnailFileId = i9;
        this.actions = list;
        this.date = i10;
        this.mediaGroupId = j10;
    }
}
