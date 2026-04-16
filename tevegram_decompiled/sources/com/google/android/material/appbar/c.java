package com.google.android.material.appbar;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import o0.x;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements x {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f1894i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f1895j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ View f1896k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f1897l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f1898m;

    public c(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i9) {
        this.f1898m = baseBehavior;
        this.f1894i = coordinatorLayout;
        this.f1895j = appBarLayout;
        this.f1896k = view;
        this.f1897l = i9;
    }

    @Override // o0.x
    public final boolean b(View view) {
        this.f1898m.z(this.f1894i, this.f1895j, this.f1896k, this.f1897l, new int[]{0, 0});
        return true;
    }
}
