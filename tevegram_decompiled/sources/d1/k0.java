package d1;

import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    public int f2492a;

    /* renamed from: b, reason: collision with root package name */
    public int f2493b;

    public /* synthetic */ k0(int i9, int i10) {
        this.f2492a = i9;
        this.f2493b = i10;
    }

    public int a() {
        int i9 = this.f2493b;
        if (i9 == 2) {
            return 10;
        }
        if (i9 == 5) {
            return 11;
        }
        if (i9 == 29) {
            return 12;
        }
        if (i9 == 42) {
            return 16;
        }
        if (i9 != 22) {
            return i9 != 23 ? 0 : 15;
        }
        return 1073741824;
    }

    public void b(o3.d1 d1Var) {
        View view = d1Var.f7618a;
        this.f2492a = view.getLeft();
        this.f2493b = view.getTop();
        view.getRight();
        view.getBottom();
    }
}
