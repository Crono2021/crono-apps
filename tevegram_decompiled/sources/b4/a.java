package b4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: i, reason: collision with root package name */
    public static final a f1320i;

    /* renamed from: j, reason: collision with root package name */
    public static final a f1321j;

    /* renamed from: k, reason: collision with root package name */
    public static final a f1322k;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ a[] f1323l;

    static {
        a aVar = new a("PREFER_ARGB_8888", 0);
        f1320i = aVar;
        a aVar2 = new a("PREFER_RGB_565", 1);
        f1321j = aVar2;
        f1323l = new a[]{aVar, aVar2};
        f1322k = aVar;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f1323l.clone();
    }
}
