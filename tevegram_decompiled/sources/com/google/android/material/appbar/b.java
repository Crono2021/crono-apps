package com.google.android.material.appbar;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ScrollView;
import com.google.android.material.appbar.AppBarLayout;
import o0.l;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends n0.c {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f1893d;

    public b(AppBarLayout.BaseBehavior baseBehavior) {
        this.f1893d = baseBehavior;
    }

    @Override // n0.c
    public final void d(View view, l lVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = lVar.f7564a;
        this.f7144a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        accessibilityNodeInfo.setScrollable(this.f1893d.f1884o);
        lVar.i(ScrollView.class.getName());
    }
}
