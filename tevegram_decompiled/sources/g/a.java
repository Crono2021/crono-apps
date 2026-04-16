package g;

import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f3445i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ View f3446j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ View f3447k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ i f3448l;

    public /* synthetic */ a(i iVar, View view, View view2, int i9) {
        this.f3445i = i9;
        this.f3448l = iVar;
        this.f3446j = view;
        this.f3447k = view2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3445i) {
            case 0:
                i.b(this.f3448l.f3555r, this.f3446j, this.f3447k);
                break;
            default:
                i.b(this.f3448l.f3544f, this.f3446j, this.f3447k);
                break;
        }
    }
}
