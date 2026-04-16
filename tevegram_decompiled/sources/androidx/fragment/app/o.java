package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.PrintWriter;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class o extends s implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public final l Z;

    /* renamed from: a0, reason: collision with root package name */
    public final m f805a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f806b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f807c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f808d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f809e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f810f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f811g0;

    /* renamed from: h0, reason: collision with root package name */
    public final a0.b f812h0;
    public Dialog i0;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f813j0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f814k0;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f815l0;

    public o() {
        new androidx.activity.j(this, 2);
        this.Z = new l(this);
        this.f805a0 = new m(this);
        this.f806b0 = 0;
        this.f807c0 = 0;
        this.f808d0 = true;
        this.f809e0 = true;
        this.f810f0 = -1;
        this.f812h0 = new a0.b(this, 6);
        this.f815l0 = false;
    }

    public Dialog A() {
        if (h0.D(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(w(), this.f807c0);
    }

    @Override // androidx.fragment.app.s
    public final android.support.v4.media.session.b b() {
        return new n(this, new p(this));
    }

    @Override // androidx.fragment.app.s
    public final void l(Context context) {
        super.l(context);
        this.V.d(this.f812h0);
        this.f814k0 = false;
    }

    @Override // androidx.fragment.app.s
    public void m(Bundle bundle) {
        super.m(bundle);
        new Handler();
        this.f809e0 = this.E == 0;
        if (bundle != null) {
            this.f806b0 = bundle.getInt("android:style", 0);
            this.f807c0 = bundle.getInt("android:theme", 0);
            this.f808d0 = bundle.getBoolean("android:cancelable", true);
            this.f809e0 = bundle.getBoolean("android:showsDialog", this.f809e0);
            this.f810f0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.s
    public final void o() {
        this.K = true;
        Dialog dialog = this.i0;
        if (dialog != null) {
            this.f813j0 = true;
            dialog.setOnDismissListener(null);
            this.i0.dismiss();
            if (!this.f814k0) {
                onDismiss(this.i0);
            }
            this.i0 = null;
            this.f815l0 = false;
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f813j0) {
            return;
        }
        if (h0.D(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        if (this.f814k0) {
            return;
        }
        this.f814k0 = true;
        Dialog dialog = this.i0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.i0.dismiss();
        }
        this.f813j0 = true;
        if (this.f810f0 >= 0) {
            h0 j5 = j();
            int i9 = this.f810f0;
            if (i9 < 0) {
                m7.c.n(androidx.activity.g.m(i9, "Bad id: "));
                return;
            } else {
                j5.u(new g0(j5, i9), false);
                this.f810f0 = -1;
                return;
            }
        }
        b bVar = new b(j());
        h0 h0Var = this.f859z;
        if (h0Var != null && h0Var != bVar.f692p) {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + toString() + " is already attached to a FragmentManager.");
        }
        bVar.b(new o0(3, this));
        if (bVar.f693q) {
            m7.c.p("commit already called");
            return;
        }
        if (h0.D(2)) {
            Log.v("FragmentManager", "Commit: " + bVar);
            PrintWriter printWriter = new PrintWriter(new q0());
            bVar.d("  ", printWriter, true);
            printWriter.close();
        }
        bVar.f693q = true;
        boolean z8 = bVar.f684g;
        h0 h0Var2 = bVar.f692p;
        if (z8) {
            bVar.f694r = h0Var2.f743i.getAndIncrement();
        } else {
            bVar.f694r = -1;
        }
        h0Var2.u(bVar, true);
    }

    @Override // androidx.fragment.app.s
    public final void p() {
        this.K = true;
        if (!this.f814k0) {
            this.f814k0 = true;
        }
        androidx.lifecycle.y yVar = this.V;
        yVar.getClass();
        androidx.lifecycle.y.a("removeObserver");
        androidx.lifecycle.x xVar = (androidx.lifecycle.x) yVar.f956b.g(this.f812h0);
        if (xVar == null) {
            return;
        }
        xVar.d();
        xVar.c(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0048 A[Catch: all -> 0x0050, TryCatch #0 {all -> 0x0050, blocks: (B:10:0x001a, B:12:0x0026, B:18:0x003e, B:20:0x0048, B:21:0x0052, B:23:0x0030, B:25:0x0036, B:26:0x003b, B:27:0x006a), top: B:9:0x001a }] */
    @Override // androidx.fragment.app.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.LayoutInflater q(android.os.Bundle r8) {
        /*
            r7 = this;
            android.view.LayoutInflater r8 = super.q(r8)
            boolean r0 = r7.f809e0
            java.lang.String r1 = "FragmentManager"
            r2 = 2
            if (r0 == 0) goto L9c
            boolean r3 = r7.f811g0
            if (r3 == 0) goto L11
            goto L9c
        L11:
            if (r0 != 0) goto L14
            goto L73
        L14:
            boolean r0 = r7.f815l0
            if (r0 != 0) goto L73
            r0 = 0
            r3 = 1
            r7.f811g0 = r3     // Catch: java.lang.Throwable -> L50
            android.app.Dialog r4 = r7.A()     // Catch: java.lang.Throwable -> L50
            r7.i0 = r4     // Catch: java.lang.Throwable -> L50
            boolean r5 = r7.f809e0     // Catch: java.lang.Throwable -> L50
            if (r5 == 0) goto L6a
            int r5 = r7.f806b0     // Catch: java.lang.Throwable -> L50
            if (r5 == r3) goto L3b
            if (r5 == r2) goto L3b
            r6 = 3
            if (r5 == r6) goto L30
            goto L3e
        L30:
            android.view.Window r5 = r4.getWindow()     // Catch: java.lang.Throwable -> L50
            if (r5 == 0) goto L3b
            r6 = 24
            r5.addFlags(r6)     // Catch: java.lang.Throwable -> L50
        L3b:
            r4.requestWindowFeature(r3)     // Catch: java.lang.Throwable -> L50
        L3e:
            android.content.Context r4 = r7.h()     // Catch: java.lang.Throwable -> L50
            boolean r5 = t.a.d(r4)     // Catch: java.lang.Throwable -> L50
            if (r5 == 0) goto L52
            android.app.Dialog r5 = r7.i0     // Catch: java.lang.Throwable -> L50
            android.app.Activity r4 = (android.app.Activity) r4     // Catch: java.lang.Throwable -> L50
            r5.setOwnerActivity(r4)     // Catch: java.lang.Throwable -> L50
            goto L52
        L50:
            r8 = move-exception
            goto L70
        L52:
            android.app.Dialog r4 = r7.i0     // Catch: java.lang.Throwable -> L50
            boolean r5 = r7.f808d0     // Catch: java.lang.Throwable -> L50
            r4.setCancelable(r5)     // Catch: java.lang.Throwable -> L50
            android.app.Dialog r4 = r7.i0     // Catch: java.lang.Throwable -> L50
            androidx.fragment.app.l r5 = r7.Z     // Catch: java.lang.Throwable -> L50
            r4.setOnCancelListener(r5)     // Catch: java.lang.Throwable -> L50
            android.app.Dialog r4 = r7.i0     // Catch: java.lang.Throwable -> L50
            androidx.fragment.app.m r5 = r7.f805a0     // Catch: java.lang.Throwable -> L50
            r4.setOnDismissListener(r5)     // Catch: java.lang.Throwable -> L50
            r7.f815l0 = r3     // Catch: java.lang.Throwable -> L50
            goto L6d
        L6a:
            r3 = 0
            r7.i0 = r3     // Catch: java.lang.Throwable -> L50
        L6d:
            r7.f811g0 = r0
            goto L73
        L70:
            r7.f811g0 = r0
            throw r8
        L73:
            boolean r0 = androidx.fragment.app.h0.D(r2)
            if (r0 == 0) goto L8f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "get layout inflater for DialogFragment "
            r0.<init>(r2)
            r0.append(r7)
            java.lang.String r2 = " from dialog context"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        L8f:
            android.app.Dialog r0 = r7.i0
            if (r0 == 0) goto Lc7
            android.content.Context r0 = r0.getContext()
            android.view.LayoutInflater r8 = r8.cloneInContext(r0)
            return r8
        L9c:
            boolean r0 = androidx.fragment.app.h0.D(r2)
            if (r0 == 0) goto Lc7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "getting layout inflater for DialogFragment "
            r0.<init>(r2)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            boolean r2 = r7.f809e0
            if (r2 != 0) goto Lbe
            java.lang.String r2 = "mShowsDialog = false: "
            java.lang.String r0 = r2.concat(r0)
            android.util.Log.d(r1, r0)
            return r8
        Lbe:
            java.lang.String r2 = "mCreatingDialog = true: "
            java.lang.String r0 = r2.concat(r0)
            android.util.Log.d(r1, r0)
        Lc7:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.o.q(android.os.Bundle):android.view.LayoutInflater");
    }

    @Override // androidx.fragment.app.s
    public void r(Bundle bundle) {
        Dialog dialog = this.i0;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i9 = this.f806b0;
        if (i9 != 0) {
            bundle.putInt("android:style", i9);
        }
        int i10 = this.f807c0;
        if (i10 != 0) {
            bundle.putInt("android:theme", i10);
        }
        boolean z8 = this.f808d0;
        if (!z8) {
            bundle.putBoolean("android:cancelable", z8);
        }
        boolean z9 = this.f809e0;
        if (!z9) {
            bundle.putBoolean("android:showsDialog", z9);
        }
        int i11 = this.f810f0;
        if (i11 != -1) {
            bundle.putInt("android:backStackId", i11);
        }
    }

    @Override // androidx.fragment.app.s
    public void s() {
        this.K = true;
        Dialog dialog = this.i0;
        if (dialog != null) {
            this.f813j0 = false;
            dialog.show();
            View decorView = this.i0.getWindow().getDecorView();
            decorView.getClass();
            decorView.setTag(2131362517, this);
            decorView.setTag(2131362520, this);
            decorView.setTag(2131362519, this);
        }
    }

    @Override // androidx.fragment.app.s
    public void t() {
        this.K = true;
        Dialog dialog = this.i0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.s
    public final void u(Bundle bundle) {
        Bundle bundle2;
        this.K = true;
        if (this.i0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.i0.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.s
    public final void v(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.v(layoutInflater, viewGroup, bundle);
        if (this.M != null || this.i0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.i0.onRestoreInstanceState(bundle2);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }
}
