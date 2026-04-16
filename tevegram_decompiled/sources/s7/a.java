package s7;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: i, reason: collision with root package name */
    public static final a f8891i;

    /* renamed from: j, reason: collision with root package name */
    public static final a f8892j;

    /* renamed from: k, reason: collision with root package name */
    public static final a f8893k;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ a[] f8894l;

    static {
        a aVar = new a("COROUTINE_SUSPENDED", 0);
        f8891i = aVar;
        a aVar2 = new a("UNDECIDED", 1);
        f8892j = aVar2;
        a aVar3 = new a("RESUMED", 2);
        f8893k = aVar3;
        f8894l = new a[]{aVar, aVar2, aVar3};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f8894l.clone();
    }
}
