package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.fragment.app.g;
import f.a;
import java.util.WeakHashMap;
import m.a0;
import m.m;
import m.o;
import n0.c0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class ListMenuItemView extends LinearLayout implements a0, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: i, reason: collision with root package name */
    public o f376i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f377j;

    /* renamed from: k, reason: collision with root package name */
    public RadioButton f378k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f379l;

    /* renamed from: m, reason: collision with root package name */
    public CheckBox f380m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f381n;

    /* renamed from: o, reason: collision with root package name */
    public ImageView f382o;

    /* renamed from: p, reason: collision with root package name */
    public ImageView f383p;

    /* renamed from: q, reason: collision with root package name */
    public LinearLayout f384q;

    /* renamed from: r, reason: collision with root package name */
    public final Drawable f385r;

    /* renamed from: s, reason: collision with root package name */
    public final int f386s;

    /* renamed from: t, reason: collision with root package name */
    public final Context f387t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f388u;

    /* renamed from: v, reason: collision with root package name */
    public final Drawable f389v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f390w;

    /* renamed from: x, reason: collision with root package name */
    public LayoutInflater f391x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f392y;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g g02 = g.g0(getContext(), attributeSet, a.f3182r, 2130969252);
        this.f385r = g02.Q(5);
        TypedArray typedArray = (TypedArray) g02.f729k;
        this.f386s = typedArray.getResourceId(1, -1);
        this.f388u = typedArray.getBoolean(7, false);
        this.f387t = context;
        this.f389v = g02.Q(8);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, 2130968964, 0);
        this.f390w = obtainStyledAttributes.hasValue(0);
        g02.i0();
        obtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f391x == null) {
            this.f391x = LayoutInflater.from(getContext());
        }
        return this.f391x;
    }

    private void setSubMenuArrowVisible(boolean z8) {
        ImageView imageView = this.f382o;
        if (imageView != null) {
            imageView.setVisibility(z8 ? 0 : 8);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0056, code lost:
    
        if (r0 == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011d  */
    @Override // m.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(m.o r11) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.a(m.o):void");
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f383p;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f383p.getLayoutParams();
        rect.top = this.f383p.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    @Override // m.a0
    public o getItemData() {
        return this.f376i;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        WeakHashMap weakHashMap = t0.f7209a;
        c0.q(this, this.f385r);
        TextView textView = (TextView) findViewById(2131362477);
        this.f379l = textView;
        int i9 = this.f386s;
        if (i9 != -1) {
            textView.setTextAppearance(this.f387t, i9);
        }
        this.f381n = (TextView) findViewById(2131362358);
        ImageView imageView = (ImageView) findViewById(2131362393);
        this.f382o = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f389v);
        }
        this.f383p = (ImageView) findViewById(2131362117);
        this.f384q = (LinearLayout) findViewById(2131361976);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        if (this.f377j != null && this.f388u) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f377j.getLayoutParams();
            int i11 = layoutParams.height;
            if (i11 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i11;
            }
        }
        super.onMeasure(i9, i10);
    }

    public void setCheckable(boolean z8) {
        CompoundButton compoundButton;
        View view;
        if (!z8 && this.f378k == null && this.f380m == null) {
            return;
        }
        if ((this.f376i.F & 4) != 0) {
            if (this.f378k == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(2131558417, (ViewGroup) this, false);
                this.f378k = radioButton;
                LinearLayout linearLayout = this.f384q;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f378k;
            view = this.f380m;
        } else {
            if (this.f380m == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(2131558414, (ViewGroup) this, false);
                this.f380m = checkBox;
                LinearLayout linearLayout2 = this.f384q;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f380m;
            view = this.f378k;
        }
        if (z8) {
            compoundButton.setChecked(this.f376i.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.f380m;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f378k;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z8) {
        CompoundButton compoundButton;
        if ((this.f376i.F & 4) != 0) {
            if (this.f378k == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(2131558417, (ViewGroup) this, false);
                this.f378k = radioButton;
                LinearLayout linearLayout = this.f384q;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f378k;
        } else {
            if (this.f380m == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(2131558414, (ViewGroup) this, false);
                this.f380m = checkBox;
                LinearLayout linearLayout2 = this.f384q;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f380m;
        }
        compoundButton.setChecked(z8);
    }

    public void setForceShowIcon(boolean z8) {
        this.f392y = z8;
        this.f388u = z8;
    }

    public void setGroupDividerEnabled(boolean z8) {
        ImageView imageView = this.f383p;
        if (imageView != null) {
            imageView.setVisibility((this.f390w || !z8) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        m mVar = this.f376i.f6468v;
        boolean z8 = this.f392y;
        if (z8 || this.f388u) {
            ImageView imageView = this.f377j;
            if (imageView == null && drawable == null && !this.f388u) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(2131558415, (ViewGroup) this, false);
                this.f377j = imageView2;
                LinearLayout linearLayout = this.f384q;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.f388u) {
                this.f377j.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f377j;
            if (!z8) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f377j.getVisibility() != 0) {
                this.f377j.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.f379l;
        if (charSequence == null) {
            if (textView.getVisibility() != 8) {
                this.f379l.setVisibility(8);
            }
        } else {
            textView.setText(charSequence);
            if (this.f379l.getVisibility() != 0) {
                this.f379l.setVisibility(0);
            }
        }
    }
}
