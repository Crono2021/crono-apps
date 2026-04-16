package l7;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d {

    /* renamed from: i, reason: collision with root package name */
    public static final d f6287i;

    /* renamed from: j, reason: collision with root package name */
    public static final d f6288j;

    /* renamed from: k, reason: collision with root package name */
    public static final d f6289k;

    /* renamed from: l, reason: collision with root package name */
    public static final d f6290l;

    /* renamed from: m, reason: collision with root package name */
    public static final d f6291m;

    /* renamed from: n, reason: collision with root package name */
    public static final d f6292n;

    /* renamed from: o, reason: collision with root package name */
    public static final d f6293o;

    /* renamed from: p, reason: collision with root package name */
    public static final d f6294p;

    /* renamed from: q, reason: collision with root package name */
    public static final d f6295q;

    /* renamed from: r, reason: collision with root package name */
    public static final d f6296r;

    /* renamed from: s, reason: collision with root package name */
    public static final d f6297s;

    /* renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ d[] f6298t;

    static {
        d dVar = new d("STANDARD", 0);
        f6287i = dVar;
        d dVar2 = new d("CIRCULAR", 1);
        f6288j = dVar2;
        d dVar3 = new d("SPIRAL", 2);
        f6289k = dVar3;
        d dVar4 = new d("DOTS", 3);
        f6290l = dVar4;
        d dVar5 = new d("XY", 4);
        f6291m = dVar5;
        d dVar6 = new d("DOUBLE_SPIRAL", 5);
        f6292n = dVar6;
        d dVar7 = new d("FLOWER", 6);
        f6293o = dVar7;
        d dVar8 = new d("BARS", 7);
        f6294p = dVar8;
        d dVar9 = new d("FLOW_FIELD", 8);
        f6295q = dVar9;
        d dVar10 = new d("SPHERE", 9);
        f6296r = dVar10;
        d dVar11 = new d("POLYGON", 10);
        f6297s = dVar11;
        f6298t = new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8, dVar9, dVar10, dVar11, new d("CUSTOM_SHAPE", 11)};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f6298t.clone();
    }
}
