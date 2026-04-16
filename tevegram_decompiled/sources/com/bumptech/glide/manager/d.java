package com.bumptech.glide.manager;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements ViewTreeObserver.OnDrawListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ View f1829i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ e f1830j;

    public d(e eVar, View view) {
        this.f1830j = eVar;
        this.f1829i = view;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        w4.n.f().post(new androidx.fragment.app.d(this, this, 5, false));
    }
}
