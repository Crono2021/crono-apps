package androidx.activity;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m implements ViewTreeObserver.OnDrawListener, Runnable, Executor {

    /* renamed from: j, reason: collision with root package name */
    public Runnable f295j;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ g.l f297l;

    /* renamed from: i, reason: collision with root package name */
    public final long f294i = SystemClock.uptimeMillis() + 10000;

    /* renamed from: k, reason: collision with root package name */
    public boolean f296k = false;

    public m(g.l lVar) {
        this.f297l = lVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f295j = runnable;
        View decorView = this.f297l.getWindow().getDecorView();
        if (!this.f296k) {
            decorView.postOnAnimation(new a7.a(this, 2));
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            decorView.invalidate();
        } else {
            decorView.postInvalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        boolean z8;
        Runnable runnable = this.f295j;
        if (runnable == null) {
            if (SystemClock.uptimeMillis() > this.f294i) {
                this.f296k = false;
                this.f297l.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        runnable.run();
        this.f295j = null;
        com.bumptech.glide.manager.s sVar = this.f297l.f305q;
        synchronized (sVar.f1858k) {
            z8 = sVar.f1857j;
        }
        if (z8) {
            this.f296k = false;
            this.f297l.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f297l.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}
