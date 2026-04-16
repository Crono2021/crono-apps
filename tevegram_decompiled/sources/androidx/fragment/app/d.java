package androidx.fragment.app;

import android.app.Application;
import android.graphics.Typeface;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f712i;

    /* renamed from: j, reason: collision with root package name */
    public Object f713j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f714k;

    public d(k kVar, ArrayList arrayList, s0 s0Var) {
        this.f712i = 0;
        this.f713j = arrayList;
        this.f714k = s0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i9 = 0;
        switch (this.f712i) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f713j;
                s0 s0Var = (s0) this.f714k;
                if (arrayList.contains(s0Var)) {
                    arrayList.remove(s0Var);
                    androidx.activity.g.a(s0Var.f862c.M, s0Var.f860a);
                    return;
                }
                return;
            case 1:
                v0.d dVar = ((SwipeDismissBehavior) this.f714k).f1913a;
                if (dVar == null || !dVar.f()) {
                    return;
                }
                View view = (View) this.f713j;
                WeakHashMap weakHashMap = n0.t0.f7209a;
                n0.c0.m(view, this);
                return;
            case 2:
                ((c0.c) this.f713j).f1529a = this.f714k;
                return;
            case 3:
                ((Application) this.f713j).unregisterActivityLifecycleCallbacks((c0.c) this.f714k);
                return;
            case 4:
                Object obj = this.f714k;
                Object obj2 = this.f713j;
                try {
                    Method method = c0.d.f1538d;
                    if (method != null) {
                        method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        c0.d.f1539e.invoke(obj2, obj, Boolean.FALSE);
                    }
                    return;
                } catch (RuntimeException e9) {
                    if (e9.getClass() == RuntimeException.class && e9.getMessage() != null && e9.getMessage().startsWith("Unable to stop")) {
                        throw e9;
                    }
                    return;
                } catch (Throwable th) {
                    Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    return;
                }
            case 5:
                k4.w a9 = k4.w.a();
                a9.getClass();
                w4.n.a();
                a9.f5603d.set(true);
                ((com.bumptech.glide.manager.d) this.f714k).f1830j.f1832j = true;
                ((com.bumptech.glide.manager.d) this.f714k).f1829i.getViewTreeObserver().removeOnDrawListener((com.bumptech.glide.manager.d) this.f713j);
                ((com.bumptech.glide.manager.d) this.f714k).f1830j.f1831i.clear();
                return;
            case 6:
                g4.c cVar = (g4.c) this.f714k;
                if (cVar.f3738d) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    ((Runnable) this.f713j).run();
                    return;
                } catch (Throwable th2) {
                    cVar.f3737c.getClass();
                    if (Log.isLoggable("GlideExecutor", 6)) {
                        Log.e("GlideExecutor", "Request threw uncaught throwable", th2);
                        return;
                    }
                    return;
                }
            case 7:
                ((i8.f) this.f714k).B((i8.l0) this.f713j);
                return;
            case 8:
                ((i8.f) this.f713j).B((j8.d) this.f714k);
                return;
            case 9:
                a0.b bVar = (a0.b) this.f713j;
                Typeface typeface = (Typeface) this.f714k;
                e0.b bVar2 = (e0.b) bVar.f8j;
                if (bVar2 != null) {
                    bVar2.i(typeface);
                    return;
                }
                return;
            case 10:
                ((k0.d) this.f713j).a(this.f714k);
                return;
            default:
                n8.i iVar = (n8.i) this.f714k;
                i8.s sVar = iVar.f7511k;
                while (true) {
                    try {
                        ((Runnable) this.f713j).run();
                    } catch (Throwable th3) {
                        i8.w.h(r7.h.f8615i, th3);
                    }
                    Runnable i10 = iVar.i();
                    if (i10 == null) {
                        return;
                    }
                    this.f713j = i10;
                    i9++;
                    if (i9 >= 16 && sVar.g()) {
                        sVar.c(iVar, this);
                        return;
                    }
                }
                break;
        }
    }

    public /* synthetic */ d(Object obj, Object obj2, int i9, boolean z8) {
        this.f712i = i9;
        this.f714k = obj;
        this.f713j = obj2;
    }

    public /* synthetic */ d(Object obj, int i9, Object obj2) {
        this.f712i = i9;
        this.f713j = obj;
        this.f714k = obj2;
    }

    public d(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z8) {
        this.f712i = 1;
        this.f714k = swipeDismissBehavior;
        this.f713j = view;
    }
}
