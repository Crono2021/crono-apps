package com.network.tvgramplayer.util;

import androidx.activity.g;
import b8.f;
import b8.i;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class SubscriptionItem {
    private final long addedAt;
    private final long chatId;
    private final boolean isArchived;
    private final boolean isForum;
    private final String photoPath;
    private final String title;
    private final String url;

    public /* synthetic */ SubscriptionItem(long j5, String str, String str2, long j9, boolean z8, boolean z9, String str3, int i9, f fVar) {
        this(j5, str, str2, (i9 & 8) != 0 ? System.currentTimeMillis() : j9, (i9 & 16) != 0 ? false : z8, (i9 & 32) != 0 ? false : z9, (i9 & 64) != 0 ? null : str3);
    }

    public static /* synthetic */ SubscriptionItem copy$default(SubscriptionItem subscriptionItem, long j5, String str, String str2, long j9, boolean z8, boolean z9, String str3, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            j5 = subscriptionItem.chatId;
        }
        long j10 = j5;
        if ((i9 & 2) != 0) {
            str = subscriptionItem.url;
        }
        String str4 = str;
        if ((i9 & 4) != 0) {
            str2 = subscriptionItem.title;
        }
        return subscriptionItem.copy(j10, str4, str2, (i9 & 8) != 0 ? subscriptionItem.addedAt : j9, (i9 & 16) != 0 ? subscriptionItem.isForum : z8, (i9 & 32) != 0 ? subscriptionItem.isArchived : z9, (i9 & 64) != 0 ? subscriptionItem.photoPath : str3);
    }

    public final long component1() {
        return this.chatId;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.title;
    }

    public final long component4() {
        return this.addedAt;
    }

    public final boolean component5() {
        return this.isForum;
    }

    public final boolean component6() {
        return this.isArchived;
    }

    public final String component7() {
        return this.photoPath;
    }

    public final SubscriptionItem copy(long j5, String str, String str2, long j9, boolean z8, boolean z9, String str3) {
        str.getClass();
        str2.getClass();
        return new SubscriptionItem(j5, str, str2, j9, z8, z9, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionItem)) {
            return false;
        }
        SubscriptionItem subscriptionItem = (SubscriptionItem) obj;
        return this.chatId == subscriptionItem.chatId && i.a(this.url, subscriptionItem.url) && i.a(this.title, subscriptionItem.title) && this.addedAt == subscriptionItem.addedAt && this.isForum == subscriptionItem.isForum && this.isArchived == subscriptionItem.isArchived && i.a(this.photoPath, subscriptionItem.photoPath);
    }

    public final long getAddedAt() {
        return this.addedAt;
    }

    public final long getChatId() {
        return this.chatId;
    }

    public final String getPhotoPath() {
        return this.photoPath;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        long j5 = this.chatId;
        int k3 = g.k(g.k(((int) (j5 ^ (j5 >>> 32))) * 31, 31, this.url), 31, this.title);
        long j9 = this.addedAt;
        int i9 = (((((k3 + ((int) (j9 ^ (j9 >>> 32)))) * 31) + (this.isForum ? 1231 : 1237)) * 31) + (this.isArchived ? 1231 : 1237)) * 31;
        String str = this.photoPath;
        return i9 + (str == null ? 0 : str.hashCode());
    }

    public final boolean isArchived() {
        return this.isArchived;
    }

    public final boolean isForum() {
        return this.isForum;
    }

    public String toString() {
        return "SubscriptionItem(chatId=" + this.chatId + ", url=" + this.url + ", title=" + this.title + ", addedAt=" + this.addedAt + ", isForum=" + this.isForum + ", isArchived=" + this.isArchived + ", photoPath=" + this.photoPath + ")";
    }

    public SubscriptionItem(long j5, String str, String str2, long j9, boolean z8, boolean z9, String str3) {
        str.getClass();
        str2.getClass();
        this.chatId = j5;
        this.url = str;
        this.title = str2;
        this.addedAt = j9;
        this.isForum = z8;
        this.isArchived = z9;
        this.photoPath = str3;
    }
}
