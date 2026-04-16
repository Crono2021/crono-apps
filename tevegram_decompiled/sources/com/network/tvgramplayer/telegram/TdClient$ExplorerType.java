package com.network.tvgramplayer.telegram;

import u7.a;
import u7.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class TdClient$ExplorerType {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ TdClient$ExplorerType[] $VALUES;
    public static final TdClient$ExplorerType VIDEO = new TdClient$ExplorerType("VIDEO", 0);
    public static final TdClient$ExplorerType AUDIO = new TdClient$ExplorerType("AUDIO", 1);
    public static final TdClient$ExplorerType IMAGE = new TdClient$ExplorerType("IMAGE", 2);
    public static final TdClient$ExplorerType LINK = new TdClient$ExplorerType("LINK", 3);
    public static final TdClient$ExplorerType TOPIC = new TdClient$ExplorerType("TOPIC", 4);

    private static final /* synthetic */ TdClient$ExplorerType[] $values() {
        return new TdClient$ExplorerType[]{VIDEO, AUDIO, IMAGE, LINK, TOPIC};
    }

    static {
        TdClient$ExplorerType[] $values = $values();
        $VALUES = $values;
        $values.getClass();
        $ENTRIES = new b($values);
    }

    private TdClient$ExplorerType(String str, int i9) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static TdClient$ExplorerType valueOf(String str) {
        return (TdClient$ExplorerType) Enum.valueOf(TdClient$ExplorerType.class, str);
    }

    public static TdClient$ExplorerType[] values() {
        return (TdClient$ExplorerType[]) $VALUES.clone();
    }
}
