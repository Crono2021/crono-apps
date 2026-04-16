package i;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends android.support.v4.media.session.b {

    /* renamed from: o, reason: collision with root package name */
    public final ObjectAnimator f4261o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f4262p;

    public c(AnimationDrawable animationDrawable, boolean z8, boolean z9) {
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        int i9 = z8 ? numberOfFrames - 1 : 0;
        int i10 = z8 ? 0 : numberOfFrames - 1;
        d dVar = new d();
        int numberOfFrames2 = animationDrawable.getNumberOfFrames();
        dVar.f4264b = numberOfFrames2;
        int[] iArr = dVar.f4263a;
        if (iArr == null || iArr.length < numberOfFrames2) {
            dVar.f4263a = new int[numberOfFrames2];
        }
        int[] iArr2 = dVar.f4263a;
        int i11 = 0;
        for (int i12 = 0; i12 < numberOfFrames2; i12++) {
            int duration = animationDrawable.getDuration(z8 ? (numberOfFrames2 - i12) - 1 : i12);
            iArr2[i12] = duration;
            i11 += duration;
        }
        dVar.f4265c = i11;
        ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i9, i10);
        j.a.a(ofInt, true);
        ofInt.setDuration(dVar.f4265c);
        ofInt.setInterpolator(dVar);
        this.f4262p = z9;
        this.f4261o = ofInt;
    }

    @Override // android.support.v4.media.session.b
    public final boolean n() {
        return this.f4262p;
    }

    @Override // android.support.v4.media.session.b
    public final void p0() {
        this.f4261o.reverse();
    }

    @Override // android.support.v4.media.session.b
    public final void w0() {
        this.f4261o.start();
    }

    @Override // android.support.v4.media.session.b
    public final void x0() {
        this.f4261o.cancel();
    }
}
