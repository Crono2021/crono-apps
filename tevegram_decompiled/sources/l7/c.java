package l7;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c {

    /* renamed from: i, reason: collision with root package name */
    public static final c f6284i;

    /* renamed from: j, reason: collision with root package name */
    public static final c f6285j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ c[] f6286k;

    static {
        c cVar = new c("ALL", 0);
        f6284i = cVar;
        c cVar2 = new c("RETRO", 1);
        c cVar3 = new c("FRACTAL", 2);
        c cVar4 = new c("SPACE", 3);
        c cVar5 = new c("ORGANIC", 4);
        f6285j = cVar5;
        f6286k = new c[]{cVar, cVar2, cVar3, cVar4, cVar5};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f6286k.clone();
    }
}
