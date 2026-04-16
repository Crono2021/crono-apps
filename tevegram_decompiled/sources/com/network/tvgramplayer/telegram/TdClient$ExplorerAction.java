package com.network.tvgramplayer.telegram;

import androidx.activity.g;
import b8.i;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class TdClient$ExplorerAction {
    private final String label;
    private final TdClient$ExplorerType type;
    private final String url;

    public TdClient$ExplorerAction(TdClient$ExplorerType tdClient$ExplorerType, String str, String str2) {
        tdClient$ExplorerType.getClass();
        str.getClass();
        str2.getClass();
        this.type = tdClient$ExplorerType;
        this.label = str;
        this.url = str2;
    }

    public static /* synthetic */ TdClient$ExplorerAction copy$default(TdClient$ExplorerAction tdClient$ExplorerAction, TdClient$ExplorerType tdClient$ExplorerType, String str, String str2, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            tdClient$ExplorerType = tdClient$ExplorerAction.type;
        }
        if ((i9 & 2) != 0) {
            str = tdClient$ExplorerAction.label;
        }
        if ((i9 & 4) != 0) {
            str2 = tdClient$ExplorerAction.url;
        }
        return tdClient$ExplorerAction.copy(tdClient$ExplorerType, str, str2);
    }

    public final TdClient$ExplorerType component1() {
        return this.type;
    }

    public final String component2() {
        return this.label;
    }

    public final String component3() {
        return this.url;
    }

    public final TdClient$ExplorerAction copy(TdClient$ExplorerType tdClient$ExplorerType, String str, String str2) {
        tdClient$ExplorerType.getClass();
        str.getClass();
        str2.getClass();
        return new TdClient$ExplorerAction(tdClient$ExplorerType, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TdClient$ExplorerAction)) {
            return false;
        }
        TdClient$ExplorerAction tdClient$ExplorerAction = (TdClient$ExplorerAction) obj;
        return this.type == tdClient$ExplorerAction.type && i.a(this.label, tdClient$ExplorerAction.label) && i.a(this.url, tdClient$ExplorerAction.url);
    }

    public final String getLabel() {
        return this.label;
    }

    public final TdClient$ExplorerType getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.url.hashCode() + g.k(this.type.hashCode() * 31, 31, this.label);
    }

    public String toString() {
        TdClient$ExplorerType tdClient$ExplorerType = this.type;
        String str = this.label;
        String str2 = this.url;
        StringBuilder sb = new StringBuilder("ExplorerAction(type=");
        sb.append(tdClient$ExplorerType);
        sb.append(", label=");
        sb.append(str);
        sb.append(", url=");
        return g.o(sb, str2, ")");
    }
}
