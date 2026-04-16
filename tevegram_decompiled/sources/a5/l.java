package a5;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import com.google.android.material.appbar.AppBarLayout;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f199a = {R.attr.stateListAnimator};

    public static void a(AppBarLayout appBarLayout, float f9) {
        int integer = appBarLayout.getResources().getInteger(2131427330);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j5 = integer;
        stateListAnimator.addState(new int[]{R.attr.state_enabled, 2130969548, -2130969549}, ObjectAnimator.ofFloat(appBarLayout, "elevation", 0.0f).setDuration(j5));
        stateListAnimator.addState(new int[]{R.attr.state_enabled}, ObjectAnimator.ofFloat(appBarLayout, "elevation", f9).setDuration(j5));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(appBarLayout, "elevation", 0.0f).setDuration(0L));
        appBarLayout.setStateListAnimator(stateListAnimator);
    }
}
