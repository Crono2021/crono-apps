package x5;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.WeakHashMap;
import n.e1;
import n0.d0;
import n0.f0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p {
    public ColorStateList A;
    public Typeface B;

    /* renamed from: a, reason: collision with root package name */
    public final int f10163a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10164b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10165c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeInterpolator f10166d;

    /* renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f10167e;

    /* renamed from: f, reason: collision with root package name */
    public final TimeInterpolator f10168f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f10169g;
    public final TextInputLayout h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f10170i;

    /* renamed from: j, reason: collision with root package name */
    public int f10171j;

    /* renamed from: k, reason: collision with root package name */
    public FrameLayout f10172k;

    /* renamed from: l, reason: collision with root package name */
    public AnimatorSet f10173l;

    /* renamed from: m, reason: collision with root package name */
    public final float f10174m;

    /* renamed from: n, reason: collision with root package name */
    public int f10175n;

    /* renamed from: o, reason: collision with root package name */
    public int f10176o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f10177p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f10178q;

    /* renamed from: r, reason: collision with root package name */
    public e1 f10179r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f10180s;

    /* renamed from: t, reason: collision with root package name */
    public int f10181t;

    /* renamed from: u, reason: collision with root package name */
    public int f10182u;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f10183v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f10184w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f10185x;

    /* renamed from: y, reason: collision with root package name */
    public e1 f10186y;

    /* renamed from: z, reason: collision with root package name */
    public int f10187z;

    public p(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f10169g = context;
        this.h = textInputLayout;
        this.f10174m = context.getResources().getDimensionPixelSize(2131165325);
        this.f10163a = android.support.v4.media.session.b.n0(context, 2130969357, 217);
        this.f10164b = android.support.v4.media.session.b.n0(context, 2130969353, 167);
        this.f10165c = android.support.v4.media.session.b.n0(context, 2130969357, 167);
        this.f10166d = android.support.v4.media.session.b.o0(context, 2130969362, z4.a.f10662d);
        LinearInterpolator linearInterpolator = z4.a.f10659a;
        this.f10167e = android.support.v4.media.session.b.o0(context, 2130969362, linearInterpolator);
        this.f10168f = android.support.v4.media.session.b.o0(context, 2130969365, linearInterpolator);
    }

    public final void a(e1 e1Var, int i9) {
        if (this.f10170i == null && this.f10172k == null) {
            Context context = this.f10169g;
            LinearLayout linearLayout = new LinearLayout(context);
            this.f10170i = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.f10170i;
            TextInputLayout textInputLayout = this.h;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.f10172k = new FrameLayout(context);
            this.f10170i.addView(this.f10172k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                b();
            }
        }
        if (i9 == 0 || i9 == 1) {
            this.f10172k.setVisibility(0);
            this.f10172k.addView(e1Var);
        } else {
            this.f10170i.addView(e1Var, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f10170i.setVisibility(0);
        this.f10171j++;
    }

    public final void b() {
        if (this.f10170i != null) {
            TextInputLayout textInputLayout = this.h;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.f10169g;
                boolean L = com.bumptech.glide.d.L(context);
                LinearLayout linearLayout = this.f10170i;
                WeakHashMap weakHashMap = t0.f7209a;
                int f9 = d0.f(editText);
                if (L) {
                    f9 = context.getResources().getDimensionPixelSize(2131165785);
                }
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131165784);
                if (L) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(2131165786);
                }
                int e9 = d0.e(editText);
                if (L) {
                    e9 = context.getResources().getDimensionPixelSize(2131165785);
                }
                d0.k(linearLayout, f9, dimensionPixelSize, e9, 0);
            }
        }
    }

    public final void c() {
        AnimatorSet animatorSet = this.f10173l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public final void d(ArrayList arrayList, boolean z8, e1 e1Var, int i9, int i10, int i11) {
        if (e1Var == null || !z8) {
            return;
        }
        if (i9 == i11 || i9 == i10) {
            boolean z9 = i11 == i9;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(e1Var, (Property<e1, Float>) View.ALPHA, z9 ? 1.0f : 0.0f);
            int i12 = this.f10165c;
            ofFloat.setDuration(z9 ? this.f10164b : i12);
            ofFloat.setInterpolator(z9 ? this.f10167e : this.f10168f);
            if (i9 == i11 && i10 != 0) {
                ofFloat.setStartDelay(i12);
            }
            arrayList.add(ofFloat);
            if (i11 != i9 || i10 == 0) {
                return;
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(e1Var, (Property<e1, Float>) View.TRANSLATION_Y, -this.f10174m, 0.0f);
            ofFloat2.setDuration(this.f10163a);
            ofFloat2.setInterpolator(this.f10166d);
            ofFloat2.setStartDelay(i12);
            arrayList.add(ofFloat2);
        }
    }

    public final TextView e(int i9) {
        if (i9 == 1) {
            return this.f10179r;
        }
        if (i9 != 2) {
            return null;
        }
        return this.f10186y;
    }

    public final void f() {
        this.f10177p = null;
        c();
        if (this.f10175n == 1) {
            if (!this.f10185x || TextUtils.isEmpty(this.f10184w)) {
                this.f10176o = 0;
            } else {
                this.f10176o = 2;
            }
        }
        i(this.f10175n, this.f10176o, h(this.f10179r, ""));
    }

    public final void g(e1 e1Var, int i9) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.f10170i;
        if (linearLayout == null) {
            return;
        }
        if ((i9 == 0 || i9 == 1) && (frameLayout = this.f10172k) != null) {
            frameLayout.removeView(e1Var);
        } else {
            linearLayout.removeView(e1Var);
        }
        int i10 = this.f10171j - 1;
        this.f10171j = i10;
        LinearLayout linearLayout2 = this.f10170i;
        if (i10 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean h(e1 e1Var, CharSequence charSequence) {
        WeakHashMap weakHashMap = t0.f7209a;
        TextInputLayout textInputLayout = this.h;
        if (f0.c(textInputLayout) && textInputLayout.isEnabled()) {
            return (this.f10176o == this.f10175n && e1Var != null && TextUtils.equals(e1Var.getText(), charSequence)) ? false : true;
        }
        return false;
    }

    public final void i(int i9, int i10, boolean z8) {
        TextView e9;
        TextView e10;
        p pVar = this;
        if (i9 == i10) {
            return;
        }
        if (z8) {
            AnimatorSet animatorSet = new AnimatorSet();
            pVar.f10173l = animatorSet;
            ArrayList arrayList = new ArrayList();
            pVar.d(arrayList, pVar.f10185x, pVar.f10186y, 2, i9, i10);
            pVar.d(arrayList, pVar.f10178q, pVar.f10179r, 1, i9, i10);
            int size = arrayList.size();
            long j5 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                Animator animator = (Animator) arrayList.get(i11);
                j5 = Math.max(j5, animator.getDuration() + animator.getStartDelay());
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
            ofInt.setDuration(j5);
            arrayList.add(0, ofInt);
            animatorSet.playTogether(arrayList);
            n nVar = new n(this, i10, e(i9), i9, pVar.e(i10));
            pVar = this;
            animatorSet.addListener(nVar);
            animatorSet.start();
        } else if (i9 != i10) {
            if (i10 != 0 && (e10 = pVar.e(i10)) != null) {
                e10.setVisibility(0);
                e10.setAlpha(1.0f);
            }
            if (i9 != 0 && (e9 = e(i9)) != null) {
                e9.setVisibility(4);
                if (i9 == 1) {
                    e9.setText((CharSequence) null);
                }
            }
            pVar.f10175n = i10;
        }
        TextInputLayout textInputLayout = pVar.h;
        textInputLayout.r();
        textInputLayout.u(z8, false);
        textInputLayout.x();
    }
}
