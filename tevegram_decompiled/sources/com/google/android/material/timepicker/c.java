package com.google.android.material.timepicker;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import o0.l;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends n0.c {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f2193d;

    public c(ClockFaceView clockFaceView) {
        this.f2193d = clockFaceView;
    }

    @Override // n0.c
    public final void d(View view, l lVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = lVar.f7564a;
        this.f7144a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        int intValue = ((Integer) view.getTag(2131362196)).intValue();
        if (intValue > 0) {
            View view2 = (View) this.f2193d.E.get(intValue - 1);
            if (Build.VERSION.SDK_INT >= 22) {
                accessibilityNodeInfo.setTraversalAfter(view2);
            }
        }
        accessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(0, 1, intValue, 1, false, view.isSelected()));
        accessibilityNodeInfo.setClickable(true);
        lVar.b(o0.f.f7551e);
    }

    @Override // n0.c
    public final boolean g(View view, int i9, Bundle bundle) {
        ClockFaceView clockFaceView = this.f2193d;
        ClockHandView clockHandView = clockFaceView.A;
        Rect rect = clockFaceView.B;
        if (i9 != 16) {
            return super.g(view, i9, bundle);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        view.getHitRect(rect);
        float centerX = rect.centerX();
        float centerY = rect.centerY();
        clockHandView.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, centerX, centerY, 0));
        clockHandView.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 1, centerX, centerY, 0));
        return true;
    }
}
