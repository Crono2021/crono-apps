package com.google.android.material.snackbar;

import android.content.Context;
import android.support.v4.media.session.b;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.WeakHashMap;
import n0.d0;
import n0.t0;
import z4.a;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* renamed from: i, reason: collision with root package name */
    public TextView f2126i;

    /* renamed from: j, reason: collision with root package name */
    public Button f2127j;

    /* renamed from: k, reason: collision with root package name */
    public int f2128k;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b.o0(context, 2130969363, a.f10660b);
    }

    public final boolean a(int i9, int i10, int i11) {
        boolean z8;
        if (i9 != getOrientation()) {
            setOrientation(i9);
            z8 = true;
        } else {
            z8 = false;
        }
        if (this.f2126i.getPaddingTop() == i10 && this.f2126i.getPaddingBottom() == i11) {
            return z8;
        }
        TextView textView = this.f2126i;
        WeakHashMap weakHashMap = t0.f7209a;
        if (d0.g(textView)) {
            d0.k(textView, d0.f(textView), i10, d0.e(textView), i11);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i10, textView.getPaddingRight(), i11);
        return true;
    }

    public Button getActionView() {
        return this.f2127j;
    }

    public TextView getMessageView() {
        return this.f2126i;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f2126i = (TextView) findViewById(2131362366);
        this.f2127j = (Button) findViewById(2131362365);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131165319);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131165318);
        Layout layout = this.f2126i.getLayout();
        boolean z8 = layout != null && layout.getLineCount() > 1;
        if (!z8 || this.f2128k <= 0 || this.f2127j.getMeasuredWidth() <= this.f2128k) {
            if (!z8) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!a(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i9, i10);
    }

    public void setMaxInlineActionWidth(int i9) {
        this.f2128k = i9;
    }
}
