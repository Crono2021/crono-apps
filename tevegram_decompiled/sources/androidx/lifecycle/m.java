package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m {

    /* renamed from: i, reason: collision with root package name */
    public static final m f928i;

    /* renamed from: j, reason: collision with root package name */
    public static final m f929j;

    /* renamed from: k, reason: collision with root package name */
    public static final m f930k;

    /* renamed from: l, reason: collision with root package name */
    public static final m f931l;

    /* renamed from: m, reason: collision with root package name */
    public static final m f932m;

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ m[] f933n;

    static {
        m mVar = new m("DESTROYED", 0);
        f928i = mVar;
        m mVar2 = new m("INITIALIZED", 1);
        f929j = mVar2;
        m mVar3 = new m("CREATED", 2);
        f930k = mVar3;
        m mVar4 = new m("STARTED", 3);
        f931l = mVar4;
        m mVar5 = new m("RESUMED", 4);
        f932m = mVar5;
        f933n = new m[]{mVar, mVar2, mVar3, mVar4, mVar5};
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) f933n.clone();
    }
}
