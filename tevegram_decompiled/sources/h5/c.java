package h5;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.activity.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import n.q;
import o5.o;
import w3.d;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends q {
    public static final int[] G = {2130969547};
    public static final int[] H = {2130969546};
    public static final int[][] I = {new int[]{R.attr.state_enabled, 2130969546}, new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public static final int J = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    public int[] A;
    public boolean B;
    public CharSequence C;
    public CompoundButton.OnCheckedChangeListener D;
    public final d E;
    public final a F;

    /* renamed from: m, reason: collision with root package name */
    public final LinkedHashSet f4031m;

    /* renamed from: n, reason: collision with root package name */
    public final LinkedHashSet f4032n;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f4033o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4034p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4035q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4036r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f4037s;

    /* renamed from: t, reason: collision with root package name */
    public Drawable f4038t;

    /* renamed from: u, reason: collision with root package name */
    public Drawable f4039u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4040v;

    /* renamed from: w, reason: collision with root package name */
    public ColorStateList f4041w;

    /* renamed from: x, reason: collision with root package name */
    public ColorStateList f4042x;

    /* renamed from: y, reason: collision with root package name */
    public PorterDuff.Mode f4043y;

    /* renamed from: z, reason: collision with root package name */
    public int f4044z;

    /* JADX WARN: Removed duplicated region for block: B:13:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(android.content.Context r13, android.util.AttributeSet r14) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h5.c.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private String getButtonStateDescription() {
        int i9 = this.f4044z;
        return i9 == 1 ? getResources().getString(2131951776) : i9 == 0 ? getResources().getString(2131951778) : getResources().getString(2131951777);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f4033o == null) {
            int v8 = com.bumptech.glide.c.v(this, 2130968807);
            int v9 = com.bumptech.glide.c.v(this, 2130968810);
            int v10 = com.bumptech.glide.c.v(this, 2130968848);
            int v11 = com.bumptech.glide.c.v(this, 2130968826);
            this.f4033o = new ColorStateList(I, new int[]{com.bumptech.glide.c.H(1.0f, v10, v9), com.bumptech.glide.c.H(1.0f, v10, v8), com.bumptech.glide.c.H(0.54f, v10, v11), com.bumptech.glide.c.H(0.38f, v10, v11), com.bumptech.glide.c.H(0.38f, v10, v11)});
        }
        return this.f4033o;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f4041w;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final void a() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        b5.a aVar;
        this.f4038t = a.a.o(this.f4038t, this.f4041w, r0.b.b(this));
        this.f4039u = a.a.o(this.f4039u, this.f4042x, this.f4043y);
        if (this.f4040v) {
            d dVar = this.E;
            if (dVar != null) {
                w3.c cVar = dVar.f9861j;
                Drawable drawable = dVar.f9868i;
                a aVar2 = this.F;
                if (drawable != null) {
                    AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
                    if (aVar2.f4028a == null) {
                        aVar2.f4028a = new w3.b(aVar2);
                    }
                    animatedVectorDrawable.unregisterAnimationCallback(aVar2.f4028a);
                }
                ArrayList arrayList = dVar.f9864m;
                if (arrayList != null && aVar2 != null) {
                    arrayList.remove(aVar2);
                    if (dVar.f9864m.size() == 0 && (aVar = dVar.f9863l) != null) {
                        cVar.f9857b.removeListener(aVar);
                        dVar.f9863l = null;
                    }
                }
                Drawable drawable2 = dVar.f9868i;
                if (drawable2 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable2 = (AnimatedVectorDrawable) drawable2;
                    if (aVar2.f4028a == null) {
                        aVar2.f4028a = new w3.b(aVar2);
                    }
                    animatedVectorDrawable2.registerAnimationCallback(aVar2.f4028a);
                } else if (aVar2 != null) {
                    if (dVar.f9864m == null) {
                        dVar.f9864m = new ArrayList();
                    }
                    if (!dVar.f9864m.contains(aVar2)) {
                        dVar.f9864m.add(aVar2);
                        if (dVar.f9863l == null) {
                            dVar.f9863l = new b5.a(dVar, 3);
                        }
                        cVar.f9857b.addListener(dVar.f9863l);
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Drawable drawable3 = this.f4038t;
                if ((drawable3 instanceof AnimatedStateListDrawable) && dVar != null) {
                    ((AnimatedStateListDrawable) drawable3).addTransition(2131361948, 2131362509, dVar, false);
                    ((AnimatedStateListDrawable) this.f4038t).addTransition(2131362143, 2131362509, dVar, false);
                }
            }
        }
        Drawable drawable4 = this.f4038t;
        if (drawable4 != null && (colorStateList2 = this.f4041w) != null) {
            g0.b.h(drawable4, colorStateList2);
        }
        Drawable drawable5 = this.f4039u;
        if (drawable5 != null && (colorStateList = this.f4042x) != null) {
            g0.b.h(drawable5, colorStateList);
        }
        Drawable drawable6 = this.f4038t;
        Drawable drawable7 = this.f4039u;
        if (drawable6 == null) {
            drawable6 = drawable7;
        } else if (drawable7 != null) {
            int intrinsicWidth = drawable7.getIntrinsicWidth();
            if (intrinsicWidth == -1) {
                intrinsicWidth = drawable6.getIntrinsicWidth();
            }
            int intrinsicHeight = drawable7.getIntrinsicHeight();
            if (intrinsicHeight == -1) {
                intrinsicHeight = drawable6.getIntrinsicHeight();
            }
            if (intrinsicWidth > drawable6.getIntrinsicWidth() || intrinsicHeight > drawable6.getIntrinsicHeight()) {
                float f9 = intrinsicWidth / intrinsicHeight;
                if (f9 >= drawable6.getIntrinsicWidth() / drawable6.getIntrinsicHeight()) {
                    int intrinsicWidth2 = drawable6.getIntrinsicWidth();
                    intrinsicHeight = (int) (intrinsicWidth2 / f9);
                    intrinsicWidth = intrinsicWidth2;
                } else {
                    intrinsicHeight = drawable6.getIntrinsicHeight();
                    intrinsicWidth = (int) (f9 * intrinsicHeight);
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable6, drawable7});
                layerDrawable.setLayerSize(1, intrinsicWidth, intrinsicHeight);
                layerDrawable.setLayerGravity(1, 17);
                drawable6 = layerDrawable;
            } else {
                LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{drawable6, new l5.a(drawable7, intrinsicWidth, intrinsicHeight).f4286i});
                int max = Math.max((drawable6.getIntrinsicWidth() - intrinsicWidth) / 2, 0);
                int max2 = Math.max((drawable6.getIntrinsicHeight() - intrinsicHeight) / 2, 0);
                layerDrawable2.setLayerInset(1, max, max2, max, max2);
                drawable6 = layerDrawable2;
            }
        }
        super.setButtonDrawable(drawable6);
        refreshDrawableState();
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.f4038t;
    }

    public Drawable getButtonIconDrawable() {
        return this.f4039u;
    }

    public ColorStateList getButtonIconTintList() {
        return this.f4042x;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f4043y;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.f4041w;
    }

    public int getCheckedState() {
        return this.f4044z;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f4037s;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        return this.f4044z == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4034p && this.f4041w == null && this.f4042x == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i9) {
        int[] copyOf;
        int[] onCreateDrawableState = super.onCreateDrawableState(i9 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(onCreateDrawableState, G);
        }
        if (this.f4036r) {
            View.mergeDrawableStates(onCreateDrawableState, H);
        }
        int i10 = 0;
        while (true) {
            if (i10 >= onCreateDrawableState.length) {
                copyOf = Arrays.copyOf(onCreateDrawableState, onCreateDrawableState.length + 1);
                copyOf[onCreateDrawableState.length] = 16842912;
                break;
            }
            int i11 = onCreateDrawableState[i10];
            if (i11 == 16842912) {
                copyOf = onCreateDrawableState;
                break;
            }
            if (i11 == 0) {
                copyOf = (int[]) onCreateDrawableState.clone();
                copyOf[i10] = 16842912;
                break;
            }
            i10++;
        }
        this.A = copyOf;
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable t8;
        if (!this.f4035q || !TextUtils.isEmpty(getText()) || (t8 = com.bumptech.glide.c.t(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - t8.getIntrinsicWidth()) / 2) * (o.e(this) ? -1 : 1);
        int save = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(save);
        if (getBackground() != null) {
            Rect bounds = t8.getBounds();
            g0.b.f(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && this.f4036r) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f4037s));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        setCheckedState(bVar.f4030i);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f4030i = getCheckedState();
        return bVar;
    }

    @Override // n.q, android.widget.CompoundButton
    public void setButtonDrawable(int i9) {
        setButtonDrawable(android.support.v4.media.session.b.I(getContext(), i9));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.f4039u = drawable;
        a();
    }

    public void setButtonIconDrawableResource(int i9) {
        setButtonIconDrawable(android.support.v4.media.session.b.I(getContext(), i9));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.f4042x == colorStateList) {
            return;
        }
        this.f4042x = colorStateList;
        a();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.f4043y == mode) {
            return;
        }
        this.f4043y = mode;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.f4041w == colorStateList) {
            return;
        }
        this.f4041w = colorStateList;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        a();
    }

    public void setCenterIfNoTextEnabled(boolean z8) {
        this.f4035q = z8;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z8) {
        setCheckedState(z8 ? 1 : 0);
    }

    public void setCheckedState(int i9) {
        AutofillManager autofillManager;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f4044z != i9) {
            this.f4044z = i9;
            super.setChecked(i9 == 1);
            refreshDrawableState();
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30 && this.C == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (this.B) {
                return;
            }
            this.B = true;
            LinkedHashSet linkedHashSet = this.f4032n;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    throw g.l(it);
                }
            }
            if (this.f4044z != 2 && (onCheckedChangeListener = this.D) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            if (i10 >= 26 && (autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class)) != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.B = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z8) {
        super.setEnabled(z8);
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f4037s = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i9) {
        setErrorAccessibilityLabel(i9 != 0 ? getResources().getText(i9) : null);
    }

    public void setErrorShown(boolean z8) {
        if (this.f4036r == z8) {
            return;
        }
        this.f4036r = z8;
        refreshDrawableState();
        Iterator it = this.f4031m.iterator();
        if (it.hasNext()) {
            throw g.l(it);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.D = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.C = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else {
            if (Build.VERSION.SDK_INT < 30 || charSequence != null) {
                return;
            }
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z8) {
        this.f4034p = z8;
        if (z8) {
            r0.b.c(this, getMaterialThemeColorsTintList());
        } else {
            r0.b.c(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // n.q, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.f4038t = drawable;
        this.f4040v = false;
        a();
    }
}
