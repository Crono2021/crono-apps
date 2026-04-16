package x5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import n.e1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10157a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f10158b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10159c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TextView f10160d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ p f10161e;

    public n(p pVar, int i9, TextView textView, int i10, TextView textView2) {
        this.f10161e = pVar;
        this.f10157a = i9;
        this.f10158b = textView;
        this.f10159c = i10;
        this.f10160d = textView2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        e1 e1Var;
        int i9 = this.f10157a;
        p pVar = this.f10161e;
        pVar.f10175n = i9;
        pVar.f10173l = null;
        TextView textView = this.f10158b;
        if (textView != null) {
            textView.setVisibility(4);
            if (this.f10159c == 1 && (e1Var = pVar.f10179r) != null) {
                e1Var.setText((CharSequence) null);
            }
        }
        TextView textView2 = this.f10160d;
        if (textView2 != null) {
            textView2.setTranslationY(0.0f);
            textView2.setAlpha(1.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        TextView textView = this.f10160d;
        if (textView != null) {
            textView.setVisibility(0);
            textView.setAlpha(0.0f);
        }
    }
}
