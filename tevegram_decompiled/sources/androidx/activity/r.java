package androidx.activity;

import android.window.OnBackInvokedCallback;
import g.c0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class r implements OnBackInvokedCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f317a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f318b;

    public /* synthetic */ r(Object obj, int i9) {
        this.f317a = i9;
        this.f318b = obj;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        switch (this.f317a) {
            case 0:
                ((a8.a) this.f318b).d();
                break;
            case 1:
                ((c0) this.f318b).E();
                break;
            default:
                ((Runnable) this.f318b).run();
                break;
        }
    }
}
