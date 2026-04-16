package com.network.tvgramplayer.data;

import b8.i;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class SearchHistoryManager$QuickSearchItem {
    private final long chatId;
    private final String chatTitle;
    private final String filterType;
    private final String query;
    private final long threadId;

    public SearchHistoryManager$QuickSearchItem(String str, long j5, long j9, String str2, String str3) {
        str.getClass();
        str3.getClass();
        this.query = str;
        this.chatId = j5;
        this.threadId = j9;
        this.filterType = str2;
        this.chatTitle = str3;
    }

    public static /* synthetic */ SearchHistoryManager$QuickSearchItem copy$default(SearchHistoryManager$QuickSearchItem searchHistoryManager$QuickSearchItem, String str, long j5, long j9, String str2, String str3, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = searchHistoryManager$QuickSearchItem.query;
        }
        if ((i9 & 2) != 0) {
            j5 = searchHistoryManager$QuickSearchItem.chatId;
        }
        if ((i9 & 4) != 0) {
            j9 = searchHistoryManager$QuickSearchItem.threadId;
        }
        if ((i9 & 8) != 0) {
            str2 = searchHistoryManager$QuickSearchItem.filterType;
        }
        if ((i9 & 16) != 0) {
            str3 = searchHistoryManager$QuickSearchItem.chatTitle;
        }
        long j10 = j9;
        return searchHistoryManager$QuickSearchItem.copy(str, j5, j10, str2, str3);
    }

    public final String component1() {
        return this.query;
    }

    public final long component2() {
        return this.chatId;
    }

    public final long component3() {
        return this.threadId;
    }

    public final String component4() {
        return this.filterType;
    }

    public final String component5() {
        return this.chatTitle;
    }

    public final SearchHistoryManager$QuickSearchItem copy(String str, long j5, long j9, String str2, String str3) {
        str.getClass();
        str3.getClass();
        return new SearchHistoryManager$QuickSearchItem(str, j5, j9, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchHistoryManager$QuickSearchItem)) {
            return false;
        }
        SearchHistoryManager$QuickSearchItem searchHistoryManager$QuickSearchItem = (SearchHistoryManager$QuickSearchItem) obj;
        return i.a(this.query, searchHistoryManager$QuickSearchItem.query) && this.chatId == searchHistoryManager$QuickSearchItem.chatId && this.threadId == searchHistoryManager$QuickSearchItem.threadId && i.a(this.filterType, searchHistoryManager$QuickSearchItem.filterType) && i.a(this.chatTitle, searchHistoryManager$QuickSearchItem.chatTitle);
    }

    public final long getChatId() {
        return this.chatId;
    }

    public final String getChatTitle() {
        return this.chatTitle;
    }

    public final String getFilterType() {
        return this.filterType;
    }

    public final String getQuery() {
        return this.query;
    }

    public final long getThreadId() {
        return this.threadId;
    }

    public int hashCode() {
        int hashCode = this.query.hashCode() * 31;
        long j5 = this.chatId;
        int i9 = (hashCode + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j9 = this.threadId;
        int i10 = (i9 + ((int) (j9 ^ (j9 >>> 32)))) * 31;
        String str = this.filterType;
        return this.chatTitle.hashCode() + ((i10 + (str == null ? 0 : str.hashCode())) * 31);
    }

    public String toString() {
        return "QuickSearchItem(query=" + this.query + ", chatId=" + this.chatId + ", threadId=" + this.threadId + ", filterType=" + this.filterType + ", chatTitle=" + this.chatTitle + ")";
    }
}
