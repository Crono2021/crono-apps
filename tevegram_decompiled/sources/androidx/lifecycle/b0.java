package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b0 extends f {
    final /* synthetic */ c0 this$0;

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static final class a extends f {
        final /* synthetic */ c0 this$0;

        public a(c0 c0Var) {
            this.this$0 = c0Var;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            activity.getClass();
            this.this$0.b();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            activity.getClass();
            c0 c0Var = this.this$0;
            int i9 = c0Var.f903i + 1;
            c0Var.f903i = i9;
            if (i9 == 1 && c0Var.f906l) {
                c0Var.f908n.d(l.ON_START);
                c0Var.f906l = false;
            }
        }
    }

    public b0(c0 c0Var) {
        this.this$0 = c0Var;
    }

    @Override // androidx.lifecycle.f, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        activity.getClass();
        if (Build.VERSION.SDK_INT < 29) {
            int i9 = f0.f912j;
            Fragment findFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            findFragmentByTag.getClass();
            ((f0) findFragmentByTag).f913i = this.this$0.f910p;
        }
    }

    @Override // androidx.lifecycle.f, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        activity.getClass();
        c0 c0Var = this.this$0;
        int i9 = c0Var.f904j - 1;
        c0Var.f904j = i9;
        if (i9 == 0) {
            Handler handler = c0Var.f907m;
            handler.getClass();
            handler.postDelayed(c0Var.f909o, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        activity.getClass();
        a0.a(activity, new a(this.this$0));
    }

    @Override // androidx.lifecycle.f, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        activity.getClass();
        c0 c0Var = this.this$0;
        int i9 = c0Var.f903i - 1;
        c0Var.f903i = i9;
        if (i9 == 0 && c0Var.f905k) {
            c0Var.f908n.d(l.ON_STOP);
            c0Var.f906l = true;
        }
    }
}
