package com.google.android.material.datepicker;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
final class MaterialCalendarGridView extends GridView {

    /* renamed from: i, reason: collision with root package name */
    public final boolean f2004i;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        y.c(null);
        if (o.D(getContext(), R.attr.windowFullscreen)) {
            setNextFocusLeftId(2131361936);
            setNextFocusRightId(2131361972);
        }
        this.f2004i = o.D(getContext(), 2130969388);
        t0.p(this, new g(2));
    }

    public final r a() {
        return (r) super.getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final ListAdapter getAdapter() {
        return (r) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((r) super.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        r rVar = (r) super.getAdapter();
        rVar.getClass();
        int max = Math.max(rVar.a(), getFirstVisiblePosition());
        int min = Math.min(rVar.c(), getLastVisiblePosition());
        rVar.getItem(max);
        rVar.getItem(min);
        throw null;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z8, int i9, Rect rect) {
        if (!z8) {
            super.onFocusChanged(false, i9, rect);
            return;
        }
        if (i9 == 33) {
            setSelection(((r) super.getAdapter()).c());
        } else if (i9 == 130) {
            setSelection(((r) super.getAdapter()).a());
        } else {
            super.onFocusChanged(true, i9, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i9, KeyEvent keyEvent) {
        if (!super.onKeyDown(i9, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= ((r) super.getAdapter()).a()) {
            return true;
        }
        if (19 != i9) {
            return false;
        }
        setSelection(((r) super.getAdapter()).a());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i9, int i10) {
        if (!this.f2004i) {
            super.onMeasure(i9, i10);
            return;
        }
        super.onMeasure(i9, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof r)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), r.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int i9) {
        if (i9 < ((r) super.getAdapter()).a()) {
            super.setSelection(((r) super.getAdapter()).a());
        } else {
            super.setSelection(i9);
        }
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: getAdapter, reason: avoid collision after fix types in other method */
    public final ListAdapter getAdapter2() {
        return (r) super.getAdapter();
    }
}
