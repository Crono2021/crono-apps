package n8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class w extends b8.j implements a8.p {

    /* renamed from: k, reason: collision with root package name */
    public static final w f7536k;

    /* renamed from: l, reason: collision with root package name */
    public static final w f7537l;

    /* renamed from: m, reason: collision with root package name */
    public static final w f7538m;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7539j;

    static {
        int i9 = 2;
        f7536k = new w(i9, 0);
        f7537l = new w(i9, 1);
        f7538m = new w(i9, 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(int i9, int i10) {
        super(i9);
        this.f7539j = i10;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        switch (this.f7539j) {
            case 0:
                return obj;
            case 1:
                if (obj == null) {
                    return null;
                }
                androidx.fragment.app.a.c();
                return null;
            default:
                return (y) obj;
        }
    }
}
