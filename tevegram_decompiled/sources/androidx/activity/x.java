package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.a0;
import androidx.fragment.app.h0;
import java.util.Iterator;
import java.util.ListIterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f354a;

    /* renamed from: b, reason: collision with root package name */
    public final o7.e f355b = new o7.e();

    /* renamed from: c, reason: collision with root package name */
    public a0 f356c;

    /* renamed from: d, reason: collision with root package name */
    public final OnBackInvokedCallback f357d;

    /* renamed from: e, reason: collision with root package name */
    public OnBackInvokedDispatcher f358e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f359f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f360g;

    public x(Runnable runnable) {
        OnBackInvokedCallback a9;
        this.f354a = runnable;
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 33) {
            if (i9 >= 34) {
                a9 = u.f350a.a(new p(this, 0), new p(this, 1), new q(this, 0), new q(this, 1));
            } else {
                a9 = s.f345a.a(new q(this, 2));
            }
            this.f357d = a9;
        }
    }

    public final void a(androidx.lifecycle.s sVar, a0 a0Var) {
        a0Var.getClass();
        androidx.lifecycle.u g9 = sVar.g();
        if (g9.f943d == androidx.lifecycle.m.f928i) {
            return;
        }
        a0Var.f675b.add(new OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(this, g9, a0Var));
        d();
        a0Var.f676c = new w(0, this, x.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0, 0, 0);
    }

    public final void b() {
        Object obj;
        o7.e eVar = this.f355b;
        ListIterator listIterator = eVar.listIterator(eVar.f8010k);
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            } else {
                obj = listIterator.previous();
                if (((a0) obj).f674a) {
                    break;
                }
            }
        }
        a0 a0Var = (a0) obj;
        this.f356c = null;
        if (a0Var == null) {
            this.f354a.run();
            return;
        }
        h0 h0Var = a0Var.f677d;
        h0Var.w(true);
        if (h0Var.h.f674a) {
            h0Var.J();
        } else {
            h0Var.f742g.b();
        }
    }

    public final void c(boolean z8) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f358e;
        OnBackInvokedCallback onBackInvokedCallback = this.f357d;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        s sVar = s.f345a;
        if (z8 && !this.f359f) {
            sVar.b(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f359f = true;
        } else {
            if (z8 || !this.f359f) {
                return;
            }
            sVar.c(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f359f = false;
        }
    }

    public final void d() {
        boolean z8 = this.f360g;
        boolean z9 = false;
        o7.e eVar = this.f355b;
        if (eVar == null || !eVar.isEmpty()) {
            Iterator it = eVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((a0) it.next()).f674a) {
                    z9 = true;
                    break;
                }
            }
        }
        this.f360g = z9;
        if (z9 == z8 || Build.VERSION.SDK_INT < 33) {
            return;
        }
        c(z9);
    }
}
