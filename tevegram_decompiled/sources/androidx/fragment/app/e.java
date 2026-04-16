package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f716a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f717b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f718c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ s0 f719d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h f720e;

    public e(ViewGroup viewGroup, View view, boolean z8, s0 s0Var, h hVar) {
        this.f716a = viewGroup;
        this.f717b = view;
        this.f718c = z8;
        this.f719d = s0Var;
        this.f720e = hVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ViewGroup viewGroup = this.f716a;
        View view = this.f717b;
        viewGroup.endViewTransition(view);
        if (this.f718c) {
            androidx.activity.g.a(view, this.f719d.f860a);
        }
        this.f720e.d();
    }
}
