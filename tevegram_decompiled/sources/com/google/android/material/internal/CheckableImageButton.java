package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import com.google.android.material.datepicker.j;
import n.x;
import n0.t0;
import o5.b;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class CheckableImageButton extends x implements Checkable {

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f2099o = {R.attr.state_checked};

    /* renamed from: l, reason: collision with root package name */
    public boolean f2100l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2101m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2102n;

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969118);
        this.f2101m = true;
        this.f2102n = true;
        t0.p(this, new j(this, 2));
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f2100l;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i9) {
        return this.f2100l ? View.mergeDrawableStates(super.onCreateDrawableState(i9 + 1), f2099o) : super.onCreateDrawableState(i9);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.f8991i);
        setChecked(bVar.f7937k);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f7937k = this.f2100l;
        return bVar;
    }

    public void setCheckable(boolean z8) {
        if (this.f2101m != z8) {
            this.f2101m = z8;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z8) {
        if (!this.f2101m || this.f2100l == z8) {
            return;
        }
        this.f2100l = z8;
        refreshDrawableState();
        sendAccessibilityEvent(IjkMediaMeta.FF_PROFILE_H264_INTRA);
    }

    public void setPressable(boolean z8) {
        this.f2102n = z8;
    }

    @Override // android.view.View
    public void setPressed(boolean z8) {
        if (this.f2102n) {
            super.setPressed(z8);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f2100l);
    }
}
