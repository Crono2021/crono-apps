package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import f.a;
import m.a0;
import m.b;
import m.c;
import m.l;
import m.m;
import m.o;
import n.e1;
import n.k;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class ActionMenuItemView extends e1 implements a0, View.OnClickListener, k {

    /* renamed from: p, reason: collision with root package name */
    public o f363p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f364q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f365r;

    /* renamed from: s, reason: collision with root package name */
    public l f366s;

    /* renamed from: t, reason: collision with root package name */
    public b f367t;

    /* renamed from: u, reason: collision with root package name */
    public c f368u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f369v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f370w;

    /* renamed from: x, reason: collision with root package name */
    public final int f371x;

    /* renamed from: y, reason: collision with root package name */
    public int f372y;

    /* renamed from: z, reason: collision with root package name */
    public final int f373z;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.f369v = f();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f3168c, 0, 0);
        this.f371x = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.f373z = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f372y = -1;
        setSaveEnabled(false);
    }

    @Override // m.a0
    public final void a(o oVar) {
        this.f363p = oVar;
        setIcon(oVar.getIcon());
        setTitle(oVar.getTitleCondensed());
        setId(oVar.f6455i);
        setVisibility(oVar.isVisible() ? 0 : 8);
        setEnabled(oVar.isEnabled());
        if (oVar.hasSubMenu() && this.f367t == null) {
            this.f367t = new b(this);
        }
    }

    @Override // n.k
    public final boolean b() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // n.k
    public final boolean c() {
        return !TextUtils.isEmpty(getText()) && this.f363p.getIcon() == null;
    }

    public final boolean f() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i9 = configuration.screenWidthDp;
        int i10 = configuration.screenHeightDp;
        if (i9 < 480) {
            return (i9 >= 640 && i10 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    public final void g() {
        boolean z8 = true;
        boolean z9 = !TextUtils.isEmpty(this.f364q);
        if (this.f365r != null && ((this.f363p.G & 4) != 4 || (!this.f369v && !this.f370w))) {
            z8 = false;
        }
        boolean z10 = z9 & z8;
        setText(z10 ? this.f364q : null);
        CharSequence charSequence = this.f363p.f6471y;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z10 ? null : this.f363p.f6459m);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.f363p.f6472z;
        if (TextUtils.isEmpty(charSequence2)) {
            a.a.O(this, z10 ? null : this.f363p.f6459m);
        } else {
            a.a.O(this, charSequence2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // m.a0
    public o getItemData() {
        return this.f363p;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        l lVar = this.f366s;
        if (lVar != null) {
            lVar.c(this.f363p);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f369v = f();
        g();
    }

    @Override // n.e1, android.widget.TextView, android.view.View
    public final void onMeasure(int i9, int i10) {
        int i11;
        boolean isEmpty = TextUtils.isEmpty(getText());
        if (!isEmpty && (i11 = this.f372y) >= 0) {
            super.setPadding(i11, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i9, i10);
        int mode = View.MeasureSpec.getMode(i9);
        int size = View.MeasureSpec.getSize(i9);
        int measuredWidth = getMeasuredWidth();
        int i12 = this.f371x;
        int min = mode == Integer.MIN_VALUE ? Math.min(size, i12) : i12;
        if (mode != 1073741824 && i12 > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i10);
        }
        if (!isEmpty || this.f365r == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f365r.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        if (this.f363p.hasSubMenu() && (bVar = this.f367t) != null && bVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setExpandedFormat(boolean z8) {
        if (this.f370w != z8) {
            this.f370w = z8;
            o oVar = this.f363p;
            if (oVar != null) {
                m mVar = oVar.f6468v;
                mVar.f6444s = true;
                mVar.p(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f365r = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i9 = this.f373z;
            if (intrinsicWidth > i9) {
                intrinsicHeight = (int) (intrinsicHeight * (i9 / intrinsicWidth));
                intrinsicWidth = i9;
            }
            if (intrinsicHeight > i9) {
                intrinsicWidth = (int) (intrinsicWidth * (i9 / intrinsicHeight));
            } else {
                i9 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i9);
        }
        setCompoundDrawables(drawable, null, null, null);
        g();
    }

    public void setItemInvoker(l lVar) {
        this.f366s = lVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i9, int i10, int i11, int i12) {
        this.f372y = i9;
        super.setPadding(i9, i10, i11, i12);
    }

    public void setPopupCallback(c cVar) {
        this.f368u = cVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f364q = charSequence;
        g();
    }

    public void setCheckable(boolean z8) {
    }

    public void setChecked(boolean z8) {
    }
}
