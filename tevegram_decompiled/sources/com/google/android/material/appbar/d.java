package com.google.android.material.appbar;

import android.view.View;
import o0.x;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements x {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f1899i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ boolean f1900j;

    public d(AppBarLayout appBarLayout, boolean z8) {
        this.f1899i = appBarLayout;
        this.f1900j = z8;
    }

    @Override // o0.x
    public final boolean b(View view) {
        this.f1899i.setExpanded(this.f1900j);
        return true;
    }
}
