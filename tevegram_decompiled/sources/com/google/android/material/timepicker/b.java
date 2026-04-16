package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f2192i;

    public b(ClockFaceView clockFaceView) {
        this.f2192i = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ClockFaceView clockFaceView = this.f2192i;
        ClockHandView clockHandView = clockFaceView.A;
        if (clockFaceView.isShown()) {
            clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
            int height = ((clockFaceView.getHeight() / 2) - clockHandView.f2179l) - clockFaceView.I;
            if (height != clockFaceView.f2195y) {
                clockFaceView.f2195y = height;
                clockFaceView.e();
                clockHandView.f2187t = clockFaceView.f2195y;
                clockHandView.invalidate();
            }
        }
        return true;
    }
}
