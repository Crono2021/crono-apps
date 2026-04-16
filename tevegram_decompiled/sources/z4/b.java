package z4;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import s.h;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final h f10664a = new h();

    /* renamed from: b, reason: collision with root package name */
    public final h f10665b = new h();

    public static b a(Context context, int i9) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i9);
            if (loadAnimator instanceof AnimatorSet) {
                return b(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return b(arrayList);
        } catch (Exception e9) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i9), e9);
            return null;
        }
    }

    public static b b(ArrayList arrayList) {
        b bVar = new b();
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            Animator animator = (Animator) arrayList.get(i9);
            if (!(animator instanceof ObjectAnimator)) {
                androidx.fragment.app.a.n(animator, "Animator must be an ObjectAnimator: ");
                return null;
            }
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            bVar.f10665b.put(objectAnimator.getPropertyName(), objectAnimator.getValues());
            String propertyName = objectAnimator.getPropertyName();
            long startDelay = objectAnimator.getStartDelay();
            long duration = objectAnimator.getDuration();
            TimeInterpolator interpolator = objectAnimator.getInterpolator();
            if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                interpolator = a.f10660b;
            } else if (interpolator instanceof AccelerateInterpolator) {
                interpolator = a.f10661c;
            } else if (interpolator instanceof DecelerateInterpolator) {
                interpolator = a.f10662d;
            }
            c cVar = new c();
            cVar.f10669d = 0;
            cVar.f10670e = 1;
            cVar.f10666a = startDelay;
            cVar.f10667b = duration;
            cVar.f10668c = interpolator;
            cVar.f10669d = objectAnimator.getRepeatCount();
            cVar.f10670e = objectAnimator.getRepeatMode();
            bVar.f10664a.put(propertyName, cVar);
        }
        return bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f10664a.equals(((b) obj).f10664a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f10664a.hashCode();
    }

    public final String toString() {
        return "\n" + b.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f10664a + "}\n";
    }
}
