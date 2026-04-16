package l3;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v {
    public boolean A;
    public boolean B;

    /* renamed from: a, reason: collision with root package name */
    public final q f6236a;

    /* renamed from: b, reason: collision with root package name */
    public final View f6237b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f6238c;

    /* renamed from: d, reason: collision with root package name */
    public final ViewGroup f6239d;

    /* renamed from: e, reason: collision with root package name */
    public final ViewGroup f6240e;

    /* renamed from: f, reason: collision with root package name */
    public final ViewGroup f6241f;

    /* renamed from: g, reason: collision with root package name */
    public final ViewGroup f6242g;
    public final ViewGroup h;

    /* renamed from: i, reason: collision with root package name */
    public final ViewGroup f6243i;

    /* renamed from: j, reason: collision with root package name */
    public final View f6244j;

    /* renamed from: k, reason: collision with root package name */
    public final View f6245k;

    /* renamed from: l, reason: collision with root package name */
    public final AnimatorSet f6246l;

    /* renamed from: m, reason: collision with root package name */
    public final AnimatorSet f6247m;

    /* renamed from: n, reason: collision with root package name */
    public final AnimatorSet f6248n;

    /* renamed from: o, reason: collision with root package name */
    public final AnimatorSet f6249o;

    /* renamed from: p, reason: collision with root package name */
    public final AnimatorSet f6250p;

    /* renamed from: q, reason: collision with root package name */
    public final ValueAnimator f6251q;

    /* renamed from: r, reason: collision with root package name */
    public final ValueAnimator f6252r;

    /* renamed from: s, reason: collision with root package name */
    public final r f6253s = new r(this, 0);

    /* renamed from: t, reason: collision with root package name */
    public final r f6254t = new r(this, 3);

    /* renamed from: u, reason: collision with root package name */
    public final r f6255u = new r(this, 4);

    /* renamed from: v, reason: collision with root package name */
    public final r f6256v = new r(this, 5);

    /* renamed from: w, reason: collision with root package name */
    public final r f6257w = new r(this, 6);

    /* renamed from: x, reason: collision with root package name */
    public final e f6258x = new e(this, 1);
    public boolean C = true;

    /* renamed from: z, reason: collision with root package name */
    public int f6260z = 0;

    /* renamed from: y, reason: collision with root package name */
    public final ArrayList f6259y = new ArrayList();

    public v(q qVar) {
        this.f6236a = qVar;
        final int i9 = 0;
        final int i10 = 3;
        final int i11 = 1;
        this.f6237b = qVar.findViewById(2131362050);
        this.f6238c = (ViewGroup) qVar.findViewById(2131362045);
        this.f6240e = (ViewGroup) qVar.findViewById(2131362060);
        ViewGroup viewGroup = (ViewGroup) qVar.findViewById(2131362043);
        this.f6239d = viewGroup;
        this.f6243i = (ViewGroup) qVar.findViewById(2131362085);
        View findViewById = qVar.findViewById(2131362072);
        this.f6244j = findViewById;
        this.f6241f = (ViewGroup) qVar.findViewById(2131362042);
        this.f6242g = (ViewGroup) qVar.findViewById(2131362053);
        this.h = (ViewGroup) qVar.findViewById(2131362054);
        View findViewById2 = qVar.findViewById(2131362064);
        this.f6245k = findViewById2;
        View findViewById3 = qVar.findViewById(2131362063);
        if (findViewById2 != null && findViewById3 != null) {
            int i12 = 8;
            findViewById2.setOnClickListener(new com.google.android.material.datepicker.n(this, i12));
            findViewById3.setOnClickListener(new com.google.android.material.datepicker.n(this, i12));
        }
        final int i13 = 2;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: l3.s

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ v f6230b;

            {
                this.f6230b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i10) {
                    case 0:
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        v vVar = this.f6230b;
                        View view = vVar.f6237b;
                        if (view != null) {
                            view.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup2 = vVar.f6238c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup3 = vVar.f6240e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(floatValue);
                            break;
                        }
                        break;
                    case 1:
                        this.f6230b.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    case 2:
                        this.f6230b.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        v vVar2 = this.f6230b;
                        View view2 = vVar2.f6237b;
                        if (view2 != null) {
                            view2.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup4 = vVar2.f6238c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup5 = vVar2.f6240e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(floatValue2);
                            break;
                        }
                        break;
                }
            }
        });
        ofFloat.addListener(new t(this, i9));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: l3.s

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ v f6230b;

            {
                this.f6230b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i9) {
                    case 0:
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        v vVar = this.f6230b;
                        View view = vVar.f6237b;
                        if (view != null) {
                            view.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup2 = vVar.f6238c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup3 = vVar.f6240e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(floatValue);
                            break;
                        }
                        break;
                    case 1:
                        this.f6230b.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    case 2:
                        this.f6230b.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        v vVar2 = this.f6230b;
                        View view2 = vVar2.f6237b;
                        if (view2 != null) {
                            view2.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup4 = vVar2.f6238c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup5 = vVar2.f6240e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(floatValue2);
                            break;
                        }
                        break;
                }
            }
        });
        ofFloat2.addListener(new t(this, i11));
        Resources resources = qVar.getResources();
        float dimension = resources.getDimension(2131165352) - resources.getDimension(2131165357);
        float dimension2 = resources.getDimension(2131165352);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f6246l = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new u(this, qVar, i9));
        animatorSet.play(ofFloat).with(d(findViewById, 0.0f, dimension)).with(d(viewGroup, 0.0f, dimension));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f6247m = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new u(this, qVar, i11));
        animatorSet2.play(d(findViewById, dimension, dimension2)).with(d(viewGroup, dimension, dimension2));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f6248n = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new u(this, qVar, i13));
        animatorSet3.play(ofFloat).with(d(findViewById, 0.0f, dimension2)).with(d(viewGroup, 0.0f, dimension2));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f6249o = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new t(this, i13));
        animatorSet4.play(ofFloat2).with(d(findViewById, dimension, 0.0f)).with(d(viewGroup, dimension, 0.0f));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.f6250p = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new t(this, i10));
        animatorSet5.play(ofFloat2).with(d(findViewById, dimension2, 0.0f)).with(d(viewGroup, dimension2, 0.0f));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f6251q = ofFloat3;
        ofFloat3.setDuration(250L);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: l3.s

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ v f6230b;

            {
                this.f6230b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i11) {
                    case 0:
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        v vVar = this.f6230b;
                        View view = vVar.f6237b;
                        if (view != null) {
                            view.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup2 = vVar.f6238c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup3 = vVar.f6240e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(floatValue);
                            break;
                        }
                        break;
                    case 1:
                        this.f6230b.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    case 2:
                        this.f6230b.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        v vVar2 = this.f6230b;
                        View view2 = vVar2.f6237b;
                        if (view2 != null) {
                            view2.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup4 = vVar2.f6238c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup5 = vVar2.f6240e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(floatValue2);
                            break;
                        }
                        break;
                }
            }
        });
        ofFloat3.addListener(new t(this, 4));
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f6252r = ofFloat4;
        ofFloat4.setDuration(250L);
        ofFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: l3.s

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ v f6230b;

            {
                this.f6230b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i13) {
                    case 0:
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        v vVar = this.f6230b;
                        View view = vVar.f6237b;
                        if (view != null) {
                            view.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup2 = vVar.f6238c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup3 = vVar.f6240e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(floatValue);
                            break;
                        }
                        break;
                    case 1:
                        this.f6230b.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    case 2:
                        this.f6230b.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        v vVar2 = this.f6230b;
                        View view2 = vVar2.f6237b;
                        if (view2 != null) {
                            view2.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup4 = vVar2.f6238c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup5 = vVar2.f6240e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(floatValue2);
                            break;
                        }
                        break;
                }
            }
        });
        ofFloat4.addListener(new t(this, 5));
    }

    public static int c(View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + width;
    }

    public static ObjectAnimator d(View view, float f9, float f10) {
        return ObjectAnimator.ofFloat(view, "translationY", f9, f10);
    }

    public static boolean j(View view) {
        int id = view.getId();
        return id == 2131362043 || id == 2131362071 || id == 2131362062 || id == 2131362075 || id == 2131362076 || id == 2131362055 || id == 2131362056;
    }

    public final void a(float f9) {
        ViewGroup viewGroup = this.h;
        if (viewGroup != null) {
            viewGroup.setTranslationX((int) ((1.0f - f9) * viewGroup.getWidth()));
        }
        ViewGroup viewGroup2 = this.f6243i;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f9);
        }
        ViewGroup viewGroup3 = this.f6241f;
        if (viewGroup3 != null) {
            viewGroup3.setAlpha(1.0f - f9);
        }
    }

    public final boolean b(View view) {
        return view != null && this.f6259y.contains(view);
    }

    public final void e(Runnable runnable, long j5) {
        if (j5 >= 0) {
            this.f6236a.postDelayed(runnable, j5);
        }
    }

    public final void f() {
        r rVar = this.f6257w;
        q qVar = this.f6236a;
        qVar.removeCallbacks(rVar);
        qVar.removeCallbacks(this.f6254t);
        qVar.removeCallbacks(this.f6256v);
        qVar.removeCallbacks(this.f6255u);
    }

    public final void g() {
        if (this.f6260z == 3) {
            return;
        }
        f();
        int showTimeoutMs = this.f6236a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.C) {
                e(this.f6257w, showTimeoutMs);
            } else if (this.f6260z == 1) {
                e(this.f6255u, 2000L);
            } else {
                e(this.f6256v, showTimeoutMs);
            }
        }
    }

    public final void h(View view, boolean z8) {
        if (view == null) {
            return;
        }
        ArrayList arrayList = this.f6259y;
        if (!z8) {
            view.setVisibility(8);
            arrayList.remove(view);
            return;
        }
        if (this.A && j(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        arrayList.add(view);
    }

    public final void i(int i9) {
        int i10 = this.f6260z;
        this.f6260z = i9;
        q qVar = this.f6236a;
        if (i9 == 2) {
            qVar.setVisibility(8);
        } else if (i10 == 2) {
            qVar.setVisibility(0);
        }
        if (i10 != i9) {
            Iterator it = qVar.f6197l.iterator();
            while (it.hasNext()) {
                p pVar = (p) it.next();
                qVar.getVisibility();
                ((y) pVar).f6263k.j();
            }
        }
    }

    public final void k() {
        if (!this.C) {
            i(0);
            g();
            return;
        }
        int i9 = this.f6260z;
        if (i9 == 1) {
            this.f6249o.start();
        } else if (i9 == 2) {
            this.f6250p.start();
        } else if (i9 == 3) {
            this.B = true;
        } else if (i9 == 4) {
            return;
        }
        g();
    }
}
