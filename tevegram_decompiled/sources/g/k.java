package g;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import java.util.WeakHashMap;
import n.b2;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k extends Dialog implements DialogInterface, m, androidx.lifecycle.s, p3.d {

    /* renamed from: i, reason: collision with root package name */
    public androidx.lifecycle.u f3571i;

    /* renamed from: j, reason: collision with root package name */
    public final com.bumptech.glide.manager.s f3572j;

    /* renamed from: k, reason: collision with root package name */
    public final androidx.activity.x f3573k;

    /* renamed from: l, reason: collision with root package name */
    public c0 f3574l;

    /* renamed from: m, reason: collision with root package name */
    public final d0 f3575m;

    /* renamed from: n, reason: collision with root package name */
    public final i f3576n;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r2v4, types: [g.d0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public k(android.view.ContextThemeWrapper r6, int r7) {
        /*
            r5 = this;
            int r7 = h(r6, r7)
            r0 = 1
            r1 = 2130968937(0x7f040169, float:1.7546542E38)
            if (r7 != 0) goto L19
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            android.content.res.Resources$Theme r3 = r6.getTheme()
            r3.resolveAttribute(r1, r2, r0)
            int r2 = r2.resourceId
            goto L1a
        L19:
            r2 = r7
        L1a:
            r5.<init>(r6, r2)
            com.bumptech.glide.manager.s r2 = new com.bumptech.glide.manager.s
            r2.<init>(r5)
            r5.f3572j = r2
            androidx.activity.x r2 = new androidx.activity.x
            a7.a r3 = new a7.a
            r4 = 3
            r3.<init>(r5, r4)
            r2.<init>(r3)
            r5.f3573k = r2
            g.d0 r2 = new g.d0
            r2.<init>()
            r5.f3575m = r2
            g.q r2 = r5.c()
            if (r7 != 0) goto L4c
            android.util.TypedValue r7 = new android.util.TypedValue
            r7.<init>()
            android.content.res.Resources$Theme r6 = r6.getTheme()
            r6.resolveAttribute(r1, r7, r0)
            int r7 = r7.resourceId
        L4c:
            r6 = r2
            g.c0 r6 = (g.c0) r6
            r6.f3474b0 = r7
            r2.d()
            g.i r6 = new g.i
            android.content.Context r7 = r5.getContext()
            android.view.Window r0 = r5.getWindow()
            r6.<init>(r7, r5, r0)
            r5.f3576n = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g.k.<init>(android.view.ContextThemeWrapper, int):void");
    }

    public static void b(k kVar) {
        super.onBackPressed();
    }

    public static int h(Context context, int i9) {
        if (((i9 >>> 24) & 255) >= 1) {
            return i9;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130968620, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // p3.d
    public final n.s a() {
        return (n.s) this.f3572j.f1859l;
    }

    @Override // android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c0 c0Var = (c0) c();
        c0Var.w();
        ((ViewGroup) c0Var.I.findViewById(R.id.content)).addView(view, layoutParams);
        c0Var.f3490u.a(c0Var.f3489t.getCallback());
    }

    public final q c() {
        if (this.f3574l == null) {
            i0 i0Var = q.f3619i;
            this.f3574l = new c0(getContext(), getWindow(), this, this);
        }
        return this.f3574l;
    }

    public final void d(Bundle bundle) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            onBackInvokedDispatcher.getClass();
            androidx.activity.x xVar = this.f3573k;
            xVar.getClass();
            xVar.f358e = onBackInvokedDispatcher;
            xVar.c(xVar.f360g);
        }
        this.f3572j.e(bundle);
        androidx.lifecycle.u uVar = this.f3571i;
        if (uVar == null) {
            uVar = new androidx.lifecycle.u(this);
            this.f3571i = uVar;
        }
        uVar.d(androidx.lifecycle.l.ON_CREATE);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        c().f();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return android.support.v4.media.session.b.E(this.f3575m, getWindow().getDecorView(), this, keyEvent);
    }

    public final void e(Bundle bundle) {
        c().a();
        d(bundle);
        c().d();
    }

    public final void f() {
        androidx.lifecycle.u uVar = this.f3571i;
        if (uVar == null) {
            uVar = new androidx.lifecycle.u(this);
            this.f3571i = uVar;
        }
        uVar.d(androidx.lifecycle.l.ON_DESTROY);
        this.f3571i = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public final View findViewById(int i9) {
        c0 c0Var = (c0) c();
        c0Var.w();
        return c0Var.f3489t.findViewById(i9);
    }

    @Override // androidx.lifecycle.s
    public final androidx.lifecycle.u g() {
        androidx.lifecycle.u uVar = this.f3571i;
        if (uVar != null) {
            return uVar;
        }
        androidx.lifecycle.u uVar2 = new androidx.lifecycle.u(this);
        this.f3571i = uVar2;
        return uVar2;
    }

    public final void i(CharSequence charSequence) {
        super.setTitle(charSequence);
        c().m(charSequence);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        c().b();
    }

    public final boolean j(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.f3573k.b();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        int i9;
        ListAdapter listAdapter;
        View view;
        View findViewById;
        e(bundle);
        i iVar = this.f3576n;
        iVar.f3540b.setContentView(iVar.f3563z);
        Context context = iVar.f3539a;
        Window window = iVar.f3541c;
        View findViewById2 = window.findViewById(2131362272);
        View findViewById3 = findViewById2.findViewById(2131362485);
        View findViewById4 = findViewById2.findViewById(2131361979);
        View findViewById5 = findViewById2.findViewById(2131361934);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(2131361986);
        View view2 = iVar.f3545g;
        if (view2 == null) {
            view2 = null;
        }
        int i10 = 0;
        boolean z8 = view2 != null;
        if (!z8 || !i.a(view2)) {
            window.setFlags(131072, 131072);
        }
        if (z8) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(2131361985);
            frameLayout.addView(view2, new ViewGroup.LayoutParams(-1, -1));
            if (iVar.h) {
                frameLayout.setPadding(0, 0, 0, 0);
            }
            if (iVar.f3544f != null) {
                ((LinearLayout.LayoutParams) ((b2) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById6 = viewGroup.findViewById(2131362485);
        View findViewById7 = viewGroup.findViewById(2131361979);
        View findViewById8 = viewGroup.findViewById(2131361934);
        ViewGroup c9 = i.c(findViewById6, findViewById3);
        ViewGroup c10 = i.c(findViewById7, findViewById4);
        ViewGroup c11 = i.c(findViewById8, findViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(2131362342);
        iVar.f3555r = nestedScrollView;
        nestedScrollView.setFocusable(false);
        iVar.f3555r.setNestedScrollingEnabled(false);
        TextView textView = (TextView) c10.findViewById(R.id.message);
        iVar.f3559v = textView;
        if (textView != null) {
            String str = iVar.f3543e;
            if (str != null) {
                textView.setText(str);
            } else {
                textView.setVisibility(8);
                iVar.f3555r.removeView(iVar.f3559v);
                if (iVar.f3544f != null) {
                    ViewGroup viewGroup2 = (ViewGroup) iVar.f3555r.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(iVar.f3555r);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(iVar.f3544f, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    c10.setVisibility(8);
                }
            }
        }
        Button button = (Button) c11.findViewById(R.id.button1);
        iVar.f3546i = button;
        com.google.android.material.datepicker.l lVar = iVar.G;
        button.setOnClickListener(lVar);
        boolean isEmpty = TextUtils.isEmpty(iVar.f3547j);
        Button button2 = iVar.f3546i;
        if (isEmpty) {
            button2.setVisibility(8);
            i9 = 0;
        } else {
            button2.setText(iVar.f3547j);
            iVar.f3546i.setVisibility(0);
            i9 = 1;
        }
        Button button3 = (Button) c11.findViewById(R.id.button2);
        iVar.f3549l = button3;
        button3.setOnClickListener(lVar);
        boolean isEmpty2 = TextUtils.isEmpty(iVar.f3550m);
        Button button4 = iVar.f3549l;
        if (isEmpty2) {
            button4.setVisibility(8);
        } else {
            button4.setText(iVar.f3550m);
            iVar.f3549l.setVisibility(0);
            i9 |= 2;
        }
        Button button5 = (Button) c11.findViewById(R.id.button3);
        iVar.f3552o = button5;
        button5.setOnClickListener(lVar);
        boolean isEmpty3 = TextUtils.isEmpty(iVar.f3553p);
        Button button6 = iVar.f3552o;
        if (isEmpty3) {
            button6.setVisibility(8);
        } else {
            button6.setText(iVar.f3553p);
            iVar.f3552o.setVisibility(0);
            i9 |= 4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130968618, typedValue, true);
        if (typedValue.data != 0) {
            if (i9 == 1) {
                Button button7 = iVar.f3546i;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button7.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button7.setLayoutParams(layoutParams);
            } else if (i9 == 2) {
                Button button8 = iVar.f3549l;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button8.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button8.setLayoutParams(layoutParams2);
            } else if (i9 == 4) {
                Button button9 = iVar.f3552o;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button9.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button9.setLayoutParams(layoutParams3);
            }
        }
        if (i9 == 0) {
            c11.setVisibility(8);
        }
        if (iVar.f3560w != null) {
            c9.addView(iVar.f3560w, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(2131362479).setVisibility(8);
        } else {
            iVar.f3557t = (ImageView) window.findViewById(R.id.icon);
            if (TextUtils.isEmpty(iVar.f3542d) || !iVar.E) {
                window.findViewById(2131362479).setVisibility(8);
                iVar.f3557t.setVisibility(8);
                c9.setVisibility(8);
            } else {
                TextView textView2 = (TextView) window.findViewById(2131361862);
                iVar.f3558u = textView2;
                textView2.setText(iVar.f3542d);
                Drawable drawable = iVar.f3556s;
                if (drawable != null) {
                    iVar.f3557t.setImageDrawable(drawable);
                } else {
                    iVar.f3558u.setPadding(iVar.f3557t.getPaddingLeft(), iVar.f3557t.getPaddingTop(), iVar.f3557t.getPaddingRight(), iVar.f3557t.getPaddingBottom());
                    iVar.f3557t.setVisibility(8);
                }
            }
        }
        boolean z9 = viewGroup.getVisibility() != 8;
        int i11 = (c9 == null || c9.getVisibility() == 8) ? 0 : 1;
        boolean z10 = c11.getVisibility() != 8;
        if (!z10 && (findViewById = c10.findViewById(2131362456)) != null) {
            findViewById.setVisibility(0);
        }
        if (i11 != 0) {
            NestedScrollView nestedScrollView2 = iVar.f3555r;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View findViewById9 = (iVar.f3543e == null && iVar.f3544f == null) ? null : c9.findViewById(2131362478);
            if (findViewById9 != null) {
                findViewById9.setVisibility(0);
            }
        } else {
            View findViewById10 = c10.findViewById(2131362457);
            if (findViewById10 != null) {
                findViewById10.setVisibility(0);
            }
        }
        AlertController$RecycleListView alertController$RecycleListView = iVar.f3544f;
        if (alertController$RecycleListView != null) {
            alertController$RecycleListView.getClass();
            if (!z10 || i11 == 0) {
                alertController$RecycleListView.setPadding(alertController$RecycleListView.getPaddingLeft(), i11 != 0 ? alertController$RecycleListView.getPaddingTop() : alertController$RecycleListView.f361i, alertController$RecycleListView.getPaddingRight(), z10 ? alertController$RecycleListView.getPaddingBottom() : alertController$RecycleListView.f362j);
            }
        }
        if (!z9) {
            View view3 = iVar.f3544f;
            if (view3 == null) {
                view3 = iVar.f3555r;
            }
            if (view3 != null) {
                int i12 = i11 | (z10 ? 2 : 0);
                View findViewById11 = window.findViewById(2131362339);
                View findViewById12 = window.findViewById(2131362338);
                int i13 = Build.VERSION.SDK_INT;
                if (i13 >= 23) {
                    WeakHashMap weakHashMap = t0.f7209a;
                    if (i13 >= 23) {
                        n0.j0.d(view3, i12, 3);
                    }
                    if (findViewById11 != null) {
                        c10.removeView(findViewById11);
                    }
                    if (findViewById12 != null) {
                        c10.removeView(findViewById12);
                    }
                } else {
                    if (findViewById11 != null && (i12 & 1) == 0) {
                        c10.removeView(findViewById11);
                        findViewById11 = null;
                    }
                    if (findViewById12 == null || (i12 & 2) != 0) {
                        view = findViewById12;
                    } else {
                        c10.removeView(findViewById12);
                        view = null;
                    }
                    if (findViewById11 != null || view != null) {
                        if (iVar.f3543e != null) {
                            iVar.f3555r.setOnScrollChangeListener(new a5.d(findViewById11, 15, view));
                            iVar.f3555r.post(new a(iVar, findViewById11, view, i10));
                        } else {
                            AlertController$RecycleListView alertController$RecycleListView2 = iVar.f3544f;
                            if (alertController$RecycleListView2 != null) {
                                alertController$RecycleListView2.setOnScrollListener(new b(findViewById11, view));
                                iVar.f3544f.post(new a(iVar, findViewById11, view, 1));
                            } else {
                                if (findViewById11 != null) {
                                    c10.removeView(findViewById11);
                                }
                                if (view != null) {
                                    c10.removeView(view);
                                }
                            }
                        }
                    }
                }
            }
        }
        AlertController$RecycleListView alertController$RecycleListView3 = iVar.f3544f;
        if (alertController$RecycleListView3 == null || (listAdapter = iVar.f3561x) == null) {
            return;
        }
        alertController$RecycleListView3.setAdapter(listAdapter);
        int i14 = iVar.f3562y;
        if (i14 > -1) {
            alertController$RecycleListView3.setItemChecked(i14, true);
            alertController$RecycleListView3.setSelection(i14);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i9, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f3576n.f3555r;
        if (nestedScrollView == null || !nestedScrollView.i(keyEvent)) {
            return super.onKeyDown(i9, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i9, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f3576n.f3555r;
        if (nestedScrollView == null || !nestedScrollView.i(keyEvent)) {
            return super.onKeyUp(i9, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        onSaveInstanceState.getClass();
        this.f3572j.f(onSaveInstanceState);
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        androidx.lifecycle.u uVar = this.f3571i;
        if (uVar == null) {
            uVar = new androidx.lifecycle.u(this);
            this.f3571i = uVar;
        }
        uVar.d(androidx.lifecycle.l.ON_RESUME);
    }

    @Override // android.app.Dialog
    public final void onStop() {
        f();
        c0 c0Var = (c0) c();
        c0Var.B();
        p0 p0Var = c0Var.f3492w;
        if (p0Var != null) {
            p0Var.f3614t = false;
            l.k kVar = p0Var.f3613s;
            if (kVar != null) {
                kVar.a();
            }
        }
    }

    @Override // android.app.Dialog
    public final void setContentView(int i9) {
        c().i(i9);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i9) {
        super.setTitle(i9);
        c().m(getContext().getString(i9));
    }

    @Override // android.app.Dialog
    public final void setContentView(View view) {
        c().k(view);
    }

    @Override // android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c().l(view, layoutParams);
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        i(charSequence);
        i iVar = this.f3576n;
        iVar.f3542d = charSequence;
        TextView textView = iVar.f3558u;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
