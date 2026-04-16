package com.bumptech.glide;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g {

    /* renamed from: i, reason: collision with root package name */
    public static final g f1768i;

    /* renamed from: j, reason: collision with root package name */
    public static final g f1769j;

    /* renamed from: k, reason: collision with root package name */
    public static final g f1770k;

    /* renamed from: l, reason: collision with root package name */
    public static final g f1771l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ g[] f1772m;

    static {
        g gVar = new g("IMMEDIATE", 0);
        f1768i = gVar;
        g gVar2 = new g("HIGH", 1);
        f1769j = gVar2;
        g gVar3 = new g("NORMAL", 2);
        f1770k = gVar3;
        g gVar4 = new g("LOW", 3);
        f1771l = gVar4;
        f1772m = new g[]{gVar, gVar2, gVar3, gVar4};
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) f1772m.clone();
    }
}
