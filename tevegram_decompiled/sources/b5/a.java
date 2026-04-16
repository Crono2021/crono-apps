package b5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.ColorStateList;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import h5.c;
import java.util.ArrayList;
import v3.k;
import w3.d;
import x5.i;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1334a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1335b;

    public /* synthetic */ a(Object obj, int i9) {
        this.f1334a = i9;
        this.f1335b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f1334a) {
            case 1:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f1335b;
                actionBarOverlayLayout.E = null;
                actionBarOverlayLayout.f430s = false;
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f1334a) {
            case 0:
                ((HideBottomViewOnScrollBehavior) this.f1335b).h = null;
                break;
            case 1:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f1335b;
                actionBarOverlayLayout.E = null;
                actionBarOverlayLayout.f430s = false;
                break;
            case 2:
                ((k) this.f1335b).l();
                animator.removeListener(this);
                break;
            case 3:
                d dVar = (d) this.f1335b;
                ArrayList arrayList = new ArrayList(dVar.f9864m);
                int size = arrayList.size();
                for (int i9 = 0; i9 < size; i9++) {
                    ColorStateList colorStateList = ((h5.a) arrayList.get(i9)).f4029b.f4041w;
                    if (colorStateList != null) {
                        g0.b.h(dVar, colorStateList);
                    }
                }
                break;
            default:
                i iVar = (i) this.f1335b;
                iVar.p();
                iVar.f10132r.start();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f1334a) {
            case 3:
                d dVar = (d) this.f1335b;
                ArrayList arrayList = new ArrayList(dVar.f9864m);
                int size = arrayList.size();
                for (int i9 = 0; i9 < size; i9++) {
                    c cVar = ((h5.a) arrayList.get(i9)).f4029b;
                    ColorStateList colorStateList = cVar.f4041w;
                    if (colorStateList != null) {
                        g0.b.g(dVar, colorStateList.getColorForState(cVar.A, colorStateList.getDefaultColor()));
                    }
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
