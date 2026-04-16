package m1;

import d1.e0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class d implements g1.j {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6512i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ a f6513j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f6514k;

    public /* synthetic */ d(int i9, long j5, a aVar) {
        this.f6512i = 3;
        this.f6513j = aVar;
        this.f6514k = i9;
    }

    @Override // g1.j
    public final void a(Object obj) {
        switch (this.f6512i) {
            case 0:
                ((c) obj).o(this.f6513j, this.f6514k);
                break;
            case 1:
                ((c) obj).t(this.f6513j, this.f6514k);
                break;
            case 2:
                ((c) obj).j(this.f6513j, this.f6514k);
                break;
            case 3:
                ((c) obj).f(this.f6513j, this.f6514k);
                break;
            case 4:
                ((c) obj).H(this.f6513j, this.f6514k);
                break;
            default:
                ((c) obj).b(this.f6513j, this.f6514k);
                break;
        }
    }

    public /* synthetic */ d(a aVar, int i9, int i10) {
        this.f6512i = i10;
        this.f6513j = aVar;
        this.f6514k = i9;
    }

    public /* synthetic */ d(a aVar, e0 e0Var, int i9) {
        this.f6512i = 1;
        this.f6513j = aVar;
        this.f6514k = i9;
    }
}
