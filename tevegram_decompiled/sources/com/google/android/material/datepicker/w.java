package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.material.carousel.CarouselLayoutManager;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class w extends o3.z {

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f2080q = 0;

    public /* synthetic */ w(Context context) {
        super(context);
    }

    @Override // o3.z
    public int b(View view, int i9) {
        switch (this.f2080q) {
            case 1:
                return 0;
            default:
                return super.b(view, i9);
        }
    }

    @Override // o3.z
    public int c(View view, int i9) {
        switch (this.f2080q) {
            case 1:
                return 0;
            default:
                return super.c(view, i9);
        }
    }

    @Override // o3.z
    public float d(DisplayMetrics displayMetrics) {
        switch (this.f2080q) {
            case 0:
                return 100.0f / displayMetrics.densityDpi;
            default:
                return super.d(displayMetrics);
        }
    }

    @Override // o3.z
    public PointF f(int i9) {
        switch (this.f2080q) {
            case 1:
                return null;
            default:
                return super.f(i9);
        }
    }

    public w(CarouselLayoutManager carouselLayoutManager, Context context) {
        super(context);
    }
}
