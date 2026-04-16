package x5;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;
import i7.f2;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends m {

    /* renamed from: e, reason: collision with root package name */
    public final int f10108e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10109f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f10110g;
    public final TimeInterpolator h;

    /* renamed from: i, reason: collision with root package name */
    public EditText f10111i;

    /* renamed from: j, reason: collision with root package name */
    public final com.google.android.material.datepicker.n f10112j;

    /* renamed from: k, reason: collision with root package name */
    public final f2 f10113k;

    /* renamed from: l, reason: collision with root package name */
    public AnimatorSet f10114l;

    /* renamed from: m, reason: collision with root package name */
    public ValueAnimator f10115m;

    public c(l lVar) {
        super(lVar);
        this.f10112j = new com.google.android.material.datepicker.n(this, 9);
        this.f10113k = new f2(this, 3);
        this.f10108e = android.support.v4.media.session.b.n0(lVar.getContext(), 2130969356, 100);
        this.f10109f = android.support.v4.media.session.b.n0(lVar.getContext(), 2130969356, 150);
        this.f10110g = android.support.v4.media.session.b.o0(lVar.getContext(), 2130969365, z4.a.f10659a);
        this.h = android.support.v4.media.session.b.o0(lVar.getContext(), 2130969363, z4.a.f10662d);
    }

    @Override // x5.m
    public final void a() {
        if (this.f10154b.f10150x != null) {
            return;
        }
        s(t());
    }

    @Override // x5.m
    public final int c() {
        return 2131951664;
    }

    @Override // x5.m
    public final int d() {
        return 2131231015;
    }

    @Override // x5.m
    public final View.OnFocusChangeListener e() {
        return this.f10113k;
    }

    @Override // x5.m
    public final View.OnClickListener f() {
        return this.f10112j;
    }

    @Override // x5.m
    public final View.OnFocusChangeListener g() {
        return this.f10113k;
    }

    @Override // x5.m
    public final void l(EditText editText) {
        this.f10111i = editText;
        this.f10153a.setEndIconVisible(t());
    }

    @Override // x5.m
    public final void o(boolean z8) {
        if (this.f10154b.f10150x == null) {
            return;
        }
        s(z8);
    }

    @Override // x5.m
    public final void q() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(this.h);
        ofFloat.setDuration(this.f10109f);
        final int i9 = 1;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: x5.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f10105b;

            {
                this.f10105b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i9) {
                    case 0:
                        this.f10105b.f10156d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = this.f10105b.f10156d;
                        checkableImageButton.setScaleX(floatValue);
                        checkableImageButton.setScaleY(floatValue);
                        break;
                }
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f10110g;
        ofFloat2.setInterpolator(timeInterpolator);
        int i10 = this.f10108e;
        ofFloat2.setDuration(i10);
        final int i11 = 0;
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: x5.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f10105b;

            {
                this.f10105b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i11) {
                    case 0:
                        this.f10105b.f10156d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = this.f10105b.f10156d;
                        checkableImageButton.setScaleX(floatValue);
                        checkableImageButton.setScaleY(floatValue);
                        break;
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.f10114l = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.f10114l.addListener(new b(this, i11));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat3.setInterpolator(timeInterpolator);
        ofFloat3.setDuration(i10);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: x5.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f10105b;

            {
                this.f10105b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i11) {
                    case 0:
                        this.f10105b.f10156d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = this.f10105b.f10156d;
                        checkableImageButton.setScaleX(floatValue);
                        checkableImageButton.setScaleY(floatValue);
                        break;
                }
            }
        });
        this.f10115m = ofFloat3;
        ofFloat3.addListener(new b(this, i9));
    }

    @Override // x5.m
    public final void r() {
        EditText editText = this.f10111i;
        if (editText != null) {
            editText.post(new a7.a(this, 23));
        }
    }

    public final void s(boolean z8) {
        boolean z9 = this.f10154b.d() == z8;
        if (z8 && !this.f10114l.isRunning()) {
            this.f10115m.cancel();
            this.f10114l.start();
            if (z9) {
                this.f10114l.end();
                return;
            }
            return;
        }
        if (z8) {
            return;
        }
        this.f10114l.cancel();
        this.f10115m.start();
        if (z9) {
            this.f10115m.end();
        }
    }

    public final boolean t() {
        EditText editText = this.f10111i;
        if (editText != null) {
            return (editText.hasFocus() || this.f10156d.hasFocus()) && this.f10111i.getText().length() > 0;
        }
        return false;
    }
}
