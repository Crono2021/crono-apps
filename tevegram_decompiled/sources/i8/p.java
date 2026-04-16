package i8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p extends b8.j implements a8.p {

    /* renamed from: k, reason: collision with root package name */
    public static final p f5292k;

    /* renamed from: l, reason: collision with root package name */
    public static final p f5293l;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f5294j;

    static {
        int i9 = 2;
        f5292k = new p(i9, 0);
        f5293l = new p(i9, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(int i9, int i10) {
        super(i9);
        this.f5294j = i10;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        switch (this.f5294j) {
            case 0:
                return ((r7.g) obj).a((r7.e) obj2);
            case 1:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            default:
                return ((r7.g) obj).a((r7.e) obj2);
        }
    }
}
