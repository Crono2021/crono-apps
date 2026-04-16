package g5;

import com.google.android.material.carousel.CarouselLayoutManager;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends c {

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f3745k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f3746l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(CarouselLayoutManager carouselLayoutManager, int i9) {
        super(1, 0);
        this.f3745k = i9;
        switch (i9) {
            case 1:
                this.f3746l = carouselLayoutManager;
                super(0, 0);
                break;
            default:
                this.f3746l = carouselLayoutManager;
                break;
        }
    }

    @Override // g5.c
    public final int d() {
        switch (this.f3745k) {
            case 0:
                return this.f3746l.f7761o;
            default:
                CarouselLayoutManager carouselLayoutManager = this.f3746l;
                return carouselLayoutManager.f7761o - carouselLayoutManager.B();
        }
    }

    @Override // g5.c
    public final int e() {
        switch (this.f3745k) {
            case 0:
                return this.f3746l.C();
            default:
                return 0;
        }
    }

    @Override // g5.c
    public final int f() {
        switch (this.f3745k) {
            case 0:
                CarouselLayoutManager carouselLayoutManager = this.f3746l;
                return carouselLayoutManager.f7760n - carouselLayoutManager.D();
            default:
                return this.f3746l.f7760n;
        }
    }

    @Override // g5.c
    public final int h() {
        switch (this.f3745k) {
            case 0:
                return 0;
            default:
                return this.f3746l.E();
        }
    }
}
