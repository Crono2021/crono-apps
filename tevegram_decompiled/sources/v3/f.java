package v3;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.WeakHashMap;
import n.j3;
import n0.f0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f extends k {
    public static final String[] E = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final j3 F;
    public static final j3 G;
    public static final j3 H;
    public static final j3 I;
    public static final j3 J;

    static {
        new b(PointF.class, "boundsOrigin").f9505a = new Rect();
        F = new j3(PointF.class, "topLeft", 1);
        G = new j3(PointF.class, "bottomRight", 2);
        H = new j3(PointF.class, "bottomRight", 3);
        I = new j3(PointF.class, "topLeft", 4);
        J = new j3(PointF.class, "position", 5);
    }

    public static void F(q qVar) {
        View view = qVar.f9549b;
        HashMap hashMap = qVar.f9548a;
        WeakHashMap weakHashMap = t0.f7209a;
        if (!f0.c(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        hashMap.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        hashMap.put("android:changeBounds:parent", view.getParent());
    }

    @Override // v3.k
    public final void c(q qVar) {
        F(qVar);
    }

    @Override // v3.k
    public final void f(q qVar) {
        F(qVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // v3.k
    public final Animator j(ViewGroup viewGroup, q qVar, q qVar2) {
        int i9;
        f fVar;
        ObjectAnimator ofObject;
        if (qVar != null) {
            HashMap hashMap = qVar.f9548a;
            if (qVar2 != null) {
                HashMap hashMap2 = qVar2.f9548a;
                ViewGroup viewGroup2 = (ViewGroup) hashMap.get("android:changeBounds:parent");
                ViewGroup viewGroup3 = (ViewGroup) hashMap2.get("android:changeBounds:parent");
                if (viewGroup2 != null && viewGroup3 != null) {
                    View view = qVar2.f9549b;
                    Rect rect = (Rect) hashMap.get("android:changeBounds:bounds");
                    Rect rect2 = (Rect) hashMap2.get("android:changeBounds:bounds");
                    int i10 = rect.left;
                    int i11 = rect2.left;
                    int i12 = rect.top;
                    int i13 = rect2.top;
                    int i14 = rect.right;
                    int i15 = rect2.right;
                    int i16 = rect.bottom;
                    int i17 = rect2.bottom;
                    int i18 = i14 - i10;
                    int i19 = i16 - i12;
                    int i20 = i15 - i11;
                    int i21 = i17 - i13;
                    Rect rect3 = (Rect) hashMap.get("android:changeBounds:clip");
                    Rect rect4 = (Rect) hashMap2.get("android:changeBounds:clip");
                    if ((i18 == 0 || i19 == 0) && (i20 == 0 || i21 == 0)) {
                        i9 = 0;
                    } else {
                        i9 = (i10 == i11 && i12 == i13) ? 0 : 1;
                        if (i14 != i15 || i16 != i17) {
                            i9++;
                        }
                    }
                    if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                        i9++;
                    }
                    int i22 = i9;
                    if (i22 > 0) {
                        r.a(view, i10, i12, i14, i16);
                        if (i22 != 2) {
                            fVar = this;
                            if (i10 == i11 && i12 == i13) {
                                fVar.A.getClass();
                                ofObject = ObjectAnimator.ofObject(view, H, (TypeConverter) null, o4.d.v(i14, i16, i15, i17));
                            } else {
                                fVar.A.getClass();
                                ofObject = ObjectAnimator.ofObject(view, I, (TypeConverter) null, o4.d.v(i10, i12, i11, i13));
                            }
                        } else if (i18 == i20 && i19 == i21) {
                            fVar = this;
                            fVar.A.getClass();
                            ofObject = ObjectAnimator.ofObject(view, J, (TypeConverter) null, o4.d.v(i10, i12, i11, i13));
                        } else {
                            fVar = this;
                            e eVar = new e();
                            eVar.f9512e = view;
                            fVar.A.getClass();
                            ObjectAnimator ofObject2 = ObjectAnimator.ofObject(eVar, F, (TypeConverter) null, o4.d.v(i10, i12, i11, i13));
                            fVar.A.getClass();
                            ObjectAnimator ofObject3 = ObjectAnimator.ofObject(eVar, G, (TypeConverter) null, o4.d.v(i14, i16, i15, i17));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(ofObject2, ofObject3);
                            animatorSet.addListener(new c(eVar));
                            ofObject = animatorSet;
                        }
                        if (view.getParent() instanceof ViewGroup) {
                            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                            com.bumptech.glide.d.d0(viewGroup4, true);
                            fVar.a(new d(viewGroup4));
                        }
                        return ofObject;
                    }
                }
            }
        }
        return null;
    }

    @Override // v3.k
    public final String[] o() {
        return E;
    }
}
