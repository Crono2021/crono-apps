package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class w extends AnimationSet implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final ViewGroup f876i;

    /* renamed from: j, reason: collision with root package name */
    public final View f877j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f878k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f879l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f880m;

    public w(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.f880m = true;
        this.f876i = viewGroup;
        this.f877j = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j5, Transformation transformation) {
        this.f880m = true;
        if (this.f878k) {
            return !this.f879l;
        }
        if (!super.getTransformation(j5, transformation)) {
            this.f878k = true;
            n0.u.a(this.f876i, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z8 = this.f878k;
        ViewGroup viewGroup = this.f876i;
        if (z8 || !this.f880m) {
            viewGroup.endViewTransition(this.f877j);
            this.f879l = true;
        } else {
            this.f880m = false;
            viewGroup.post(this);
        }
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j5, Transformation transformation, float f9) {
        this.f880m = true;
        if (this.f878k) {
            return !this.f879l;
        }
        if (!super.getTransformation(j5, transformation, f9)) {
            this.f878k = true;
            n0.u.a(this.f876i, this);
        }
        return true;
    }
}
