package n;

import androidx.appcompat.widget.SearchView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class y2 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7107i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ SearchView f7108j;

    public /* synthetic */ y2(SearchView searchView, int i9) {
        this.f7107i = i9;
        this.f7108j = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7107i) {
            case 0:
                this.f7108j.s();
                break;
            default:
                s0.b bVar = this.f7108j.W;
                if (bVar instanceof i3) {
                    bVar.b(null);
                    break;
                }
                break;
        }
    }
}
