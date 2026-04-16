package c0;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public Object f1529a;

    /* renamed from: b, reason: collision with root package name */
    public Activity f1530b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1531c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1532d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1533e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1534f = false;

    public c(Activity activity) {
        this.f1530b = activity;
        this.f1531c = activity.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (this.f1530b == activity) {
            this.f1530b = null;
            this.f1533e = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (!this.f1533e || this.f1534f || this.f1532d) {
            return;
        }
        Object obj = this.f1529a;
        try {
            Object obj2 = d.f1537c.get(activity);
            if (obj2 == obj && activity.hashCode() == this.f1531c) {
                d.f1541g.postAtFrontOfQueue(new androidx.fragment.app.d(d.f1536b.get(activity), 4, obj2));
                this.f1534f = true;
                this.f1529a = null;
            }
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (this.f1530b == activity) {
            this.f1532d = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
