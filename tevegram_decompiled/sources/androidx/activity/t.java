package androidx.activity;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t implements OnBackAnimationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a8.l f346a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a8.l f347b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a8.a f348c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a8.a f349d;

    public t(a8.l lVar, a8.l lVar2, a8.a aVar, a8.a aVar2) {
        this.f346a = lVar;
        this.f347b = lVar2;
        this.f348c = aVar;
        this.f349d = aVar2;
    }

    @Override // android.window.OnBackAnimationCallback
    public final void onBackCancelled() {
        this.f349d.d();
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        this.f348c.d();
    }

    @Override // android.window.OnBackAnimationCallback
    public final void onBackProgressed(BackEvent backEvent) {
        backEvent.getClass();
        this.f347b.a(new b(backEvent));
    }

    @Override // android.window.OnBackAnimationCallback
    public final void onBackStarted(BackEvent backEvent) {
        backEvent.getClass();
        this.f346a.a(new b(backEvent));
    }
}
