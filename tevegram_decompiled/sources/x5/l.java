package x5;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.m0;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import n.e1;
import n0.c0;
import n0.d0;
import n0.f0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l extends LinearLayout {
    public EditText A;
    public final AccessibilityManager B;
    public o0.d C;
    public final j D;

    /* renamed from: i, reason: collision with root package name */
    public final TextInputLayout f10135i;

    /* renamed from: j, reason: collision with root package name */
    public final FrameLayout f10136j;

    /* renamed from: k, reason: collision with root package name */
    public final CheckableImageButton f10137k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f10138l;

    /* renamed from: m, reason: collision with root package name */
    public PorterDuff.Mode f10139m;

    /* renamed from: n, reason: collision with root package name */
    public View.OnLongClickListener f10140n;

    /* renamed from: o, reason: collision with root package name */
    public final CheckableImageButton f10141o;

    /* renamed from: p, reason: collision with root package name */
    public final c2.f f10142p;

    /* renamed from: q, reason: collision with root package name */
    public int f10143q;

    /* renamed from: r, reason: collision with root package name */
    public final LinkedHashSet f10144r;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f10145s;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f10146t;

    /* renamed from: u, reason: collision with root package name */
    public int f10147u;

    /* renamed from: v, reason: collision with root package name */
    public ImageView.ScaleType f10148v;

    /* renamed from: w, reason: collision with root package name */
    public View.OnLongClickListener f10149w;

    /* renamed from: x, reason: collision with root package name */
    public CharSequence f10150x;

    /* renamed from: y, reason: collision with root package name */
    public final e1 f10151y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f10152z;

    public l(TextInputLayout textInputLayout, androidx.fragment.app.g gVar) {
        super(textInputLayout.getContext());
        CharSequence text;
        this.f10143q = 0;
        this.f10144r = new LinkedHashSet();
        this.D = new j(this);
        k kVar = new k(this);
        this.B = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f10135i = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f10136j = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        CheckableImageButton a9 = a(this, from, 2131362467);
        this.f10137k = a9;
        CheckableImageButton a10 = a(frameLayout, from, 2131362466);
        this.f10141o = a10;
        c2.f fVar = new c2.f();
        fVar.f1556c = new SparseArray();
        fVar.f1557d = this;
        TypedArray typedArray = (TypedArray) gVar.f729k;
        fVar.f1554a = typedArray.getResourceId(28, 0);
        fVar.f1555b = typedArray.getResourceId(52, 0);
        this.f10142p = fVar;
        e1 e1Var = new e1(getContext(), null);
        this.f10151y = e1Var;
        TypedArray typedArray2 = (TypedArray) gVar.f729k;
        if (typedArray2.hasValue(38)) {
            this.f10138l = com.bumptech.glide.d.C(getContext(), gVar, 38);
        }
        if (typedArray2.hasValue(39)) {
            this.f10139m = o5.o.g(typedArray2.getInt(39, -1), null);
        }
        if (typedArray2.hasValue(37)) {
            i(gVar.Q(37));
        }
        a9.setContentDescription(getResources().getText(2131951666));
        WeakHashMap weakHashMap = t0.f7209a;
        c0.s(a9, 2);
        a9.setClickable(false);
        a9.setPressable(false);
        a9.setFocusable(false);
        if (!typedArray2.hasValue(53)) {
            if (typedArray2.hasValue(32)) {
                this.f10145s = com.bumptech.glide.d.C(getContext(), gVar, 32);
            }
            if (typedArray2.hasValue(33)) {
                this.f10146t = o5.o.g(typedArray2.getInt(33, -1), null);
            }
        }
        if (typedArray2.hasValue(30)) {
            g(typedArray2.getInt(30, 0));
            if (typedArray2.hasValue(27) && a10.getContentDescription() != (text = typedArray2.getText(27))) {
                a10.setContentDescription(text);
            }
            a10.setCheckable(typedArray2.getBoolean(26, true));
        } else if (typedArray2.hasValue(53)) {
            if (typedArray2.hasValue(54)) {
                this.f10145s = com.bumptech.glide.d.C(getContext(), gVar, 54);
            }
            if (typedArray2.hasValue(55)) {
                this.f10146t = o5.o.g(typedArray2.getInt(55, -1), null);
            }
            g(typedArray2.getBoolean(53, false) ? 1 : 0);
            CharSequence text2 = typedArray2.getText(51);
            if (a10.getContentDescription() != text2) {
                a10.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = typedArray2.getDimensionPixelSize(29, getResources().getDimensionPixelSize(2131165918));
        if (dimensionPixelSize < 0) {
            m7.c.n("endIconSize cannot be less than 0");
            throw null;
        }
        if (dimensionPixelSize != this.f10147u) {
            this.f10147u = dimensionPixelSize;
            a10.setMinimumWidth(dimensionPixelSize);
            a10.setMinimumHeight(dimensionPixelSize);
            a9.setMinimumWidth(dimensionPixelSize);
            a9.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray2.hasValue(31)) {
            ImageView.ScaleType k3 = com.bumptech.glide.d.k(typedArray2.getInt(31, -1));
            this.f10148v = k3;
            a10.setScaleType(k3);
            a9.setScaleType(k3);
        }
        e1Var.setVisibility(8);
        e1Var.setId(2131362474);
        e1Var.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        f0.f(e1Var, 1);
        android.support.v4.media.session.b.t0(e1Var, typedArray2.getResourceId(72, 0));
        if (typedArray2.hasValue(73)) {
            e1Var.setTextColor(gVar.O(73));
        }
        CharSequence text3 = typedArray2.getText(71);
        this.f10150x = TextUtils.isEmpty(text3) ? null : text3;
        e1Var.setText(text3);
        n();
        frameLayout.addView(a10);
        addView(e1Var);
        addView(frameLayout);
        addView(a9);
        textInputLayout.f2147m0.add(kVar);
        if (textInputLayout.f2144l != null) {
            kVar.a(textInputLayout);
        }
        addOnAttachStateChangeListener(new m0(this, 3));
    }

    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i9) {
        Drawable b9;
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(2131558450, viewGroup, false);
        checkableImageButton.setId(i9);
        if (Build.VERSION.SDK_INT <= 22) {
            Context context = checkableImageButton.getContext();
            int applyDimension = (int) TypedValue.applyDimension(1, 4, checkableImageButton.getContext().getResources().getDisplayMetrics());
            int[] iArr = s5.b.f8857a;
            b9 = s5.a.b(context, applyDimension);
            checkableImageButton.setBackground(b9);
        }
        if (com.bumptech.glide.d.L(getContext())) {
            n0.l.h((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    public final m b() {
        m dVar;
        int i9 = this.f10143q;
        c2.f fVar = this.f10142p;
        SparseArray sparseArray = (SparseArray) fVar.f1556c;
        m mVar = (m) sparseArray.get(i9);
        if (mVar != null) {
            return mVar;
        }
        l lVar = (l) fVar.f1557d;
        if (i9 == -1) {
            dVar = new d(lVar, 0);
        } else if (i9 == 0) {
            dVar = new d(lVar, 1);
        } else if (i9 == 1) {
            dVar = new s(lVar, fVar.f1555b);
        } else if (i9 == 2) {
            dVar = new c(lVar);
        } else {
            if (i9 != 3) {
                m7.c.n(androidx.activity.g.m(i9, "Invalid end icon mode: "));
                return null;
            }
            dVar = new i(lVar);
        }
        sparseArray.append(i9, dVar);
        return dVar;
    }

    public final int c() {
        int c9;
        if (d() || e()) {
            CheckableImageButton checkableImageButton = this.f10141o;
            c9 = n0.l.c((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()) + checkableImageButton.getMeasuredWidth();
        } else {
            c9 = 0;
        }
        WeakHashMap weakHashMap = t0.f7209a;
        return d0.e(this.f10151y) + d0.e(this) + c9;
    }

    public final boolean d() {
        return this.f10136j.getVisibility() == 0 && this.f10141o.getVisibility() == 0;
    }

    public final boolean e() {
        return this.f10137k.getVisibility() == 0;
    }

    public final void f(boolean z8) {
        boolean z9;
        boolean isActivated;
        boolean z10;
        m b9 = b();
        boolean j5 = b9.j();
        CheckableImageButton checkableImageButton = this.f10141o;
        boolean z11 = true;
        if (!j5 || (z10 = checkableImageButton.f2100l) == b9.k()) {
            z9 = false;
        } else {
            checkableImageButton.setChecked(!z10);
            z9 = true;
        }
        if (!(b9 instanceof i) || (isActivated = checkableImageButton.isActivated()) == ((i) b9).f10126l) {
            z11 = z9;
        } else {
            checkableImageButton.setActivated(!isActivated);
        }
        if (z8 || z11) {
            com.bumptech.glide.d.V(this.f10135i, checkableImageButton, this.f10145s);
        }
    }

    public final void g(int i9) {
        if (this.f10143q == i9) {
            return;
        }
        m b9 = b();
        o0.d dVar = this.C;
        AccessibilityManager accessibilityManager = this.B;
        if (dVar != null && accessibilityManager != null) {
            o0.c.b(accessibilityManager, dVar);
        }
        this.C = null;
        b9.r();
        this.f10143q = i9;
        Iterator it = this.f10144r.iterator();
        if (it.hasNext()) {
            throw androidx.activity.g.l(it);
        }
        h(i9 != 0);
        m b10 = b();
        int i10 = this.f10142p.f1554a;
        if (i10 == 0) {
            i10 = b10.d();
        }
        Drawable I = i10 != 0 ? android.support.v4.media.session.b.I(getContext(), i10) : null;
        CheckableImageButton checkableImageButton = this.f10141o;
        checkableImageButton.setImageDrawable(I);
        TextInputLayout textInputLayout = this.f10135i;
        if (I != null) {
            com.bumptech.glide.d.c(textInputLayout, checkableImageButton, this.f10145s, this.f10146t);
            com.bumptech.glide.d.V(textInputLayout, checkableImageButton, this.f10145s);
        }
        int c9 = b10.c();
        CharSequence text = c9 != 0 ? getResources().getText(c9) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(b10.j());
        if (!b10.i(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i9);
        }
        b10.q();
        o0.d h = b10.h();
        this.C = h;
        if (h != null && accessibilityManager != null) {
            WeakHashMap weakHashMap = t0.f7209a;
            if (f0.b(this)) {
                o0.c.a(accessibilityManager, this.C);
            }
        }
        View.OnClickListener f9 = b10.f();
        View.OnLongClickListener onLongClickListener = this.f10149w;
        checkableImageButton.setOnClickListener(f9);
        com.bumptech.glide.d.Z(checkableImageButton, onLongClickListener);
        EditText editText = this.A;
        if (editText != null) {
            b10.l(editText);
            j(b10);
        }
        com.bumptech.glide.d.c(textInputLayout, checkableImageButton, this.f10145s, this.f10146t);
        f(true);
    }

    public final void h(boolean z8) {
        if (d() != z8) {
            this.f10141o.setVisibility(z8 ? 0 : 8);
            k();
            m();
            this.f10135i.q();
        }
    }

    public final void i(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f10137k;
        checkableImageButton.setImageDrawable(drawable);
        l();
        com.bumptech.glide.d.c(this.f10135i, checkableImageButton, this.f10138l, this.f10139m);
    }

    public final void j(m mVar) {
        if (this.A == null) {
            return;
        }
        if (mVar.e() != null) {
            this.A.setOnFocusChangeListener(mVar.e());
        }
        if (mVar.g() != null) {
            this.f10141o.setOnFocusChangeListener(mVar.g());
        }
    }

    public final void k() {
        this.f10136j.setVisibility((this.f10141o.getVisibility() != 0 || e()) ? 8 : 0);
        setVisibility((d() || e() || ((this.f10150x == null || this.f10152z) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    public final void l() {
        CheckableImageButton checkableImageButton = this.f10137k;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.f10135i;
        checkableImageButton.setVisibility((drawable != null && textInputLayout.f2156r.f10178q && textInputLayout.m()) ? 0 : 8);
        k();
        m();
        if (this.f10143q != 0) {
            return;
        }
        textInputLayout.q();
    }

    public final void m() {
        int i9;
        TextInputLayout textInputLayout = this.f10135i;
        if (textInputLayout.f2144l == null) {
            return;
        }
        if (d() || e()) {
            i9 = 0;
        } else {
            EditText editText = textInputLayout.f2144l;
            WeakHashMap weakHashMap = t0.f7209a;
            i9 = d0.e(editText);
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(2131165787);
        int paddingTop = textInputLayout.f2144l.getPaddingTop();
        int paddingBottom = textInputLayout.f2144l.getPaddingBottom();
        WeakHashMap weakHashMap2 = t0.f7209a;
        d0.k(this.f10151y, dimensionPixelSize, paddingTop, i9, paddingBottom);
    }

    public final void n() {
        e1 e1Var = this.f10151y;
        int visibility = e1Var.getVisibility();
        int i9 = (this.f10150x == null || this.f10152z) ? 8 : 0;
        if (visibility != i9) {
            b().o(i9 == 0);
        }
        k();
        e1Var.setVisibility(i9);
        this.f10135i.q();
    }
}
