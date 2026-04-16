package w3;

import android.graphics.Paint;
import b6.i0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i extends l {

    /* renamed from: d, reason: collision with root package name */
    public i0 f9869d;

    /* renamed from: e, reason: collision with root package name */
    public float f9870e;

    /* renamed from: f, reason: collision with root package name */
    public i0 f9871f;

    /* renamed from: g, reason: collision with root package name */
    public float f9872g;
    public float h;

    /* renamed from: i, reason: collision with root package name */
    public float f9873i;

    /* renamed from: j, reason: collision with root package name */
    public float f9874j;

    /* renamed from: k, reason: collision with root package name */
    public float f9875k;

    /* renamed from: l, reason: collision with root package name */
    public Paint.Cap f9876l;

    /* renamed from: m, reason: collision with root package name */
    public Paint.Join f9877m;

    /* renamed from: n, reason: collision with root package name */
    public float f9878n;

    @Override // w3.k
    public final boolean a() {
        return this.f9871f.e() || this.f9869d.e();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // w3.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(int[] r7) {
        /*
            r6 = this;
            b6.i0 r0 = r6.f9871f
            boolean r1 = r0.e()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.f1400l
            android.content.res.ColorStateList r1 = (android.content.res.ColorStateList) r1
            int r4 = r1.getDefaultColor()
            int r1 = r1.getColorForState(r7, r4)
            int r4 = r0.f1398j
            if (r1 == r4) goto L1e
            r0.f1398j = r1
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            b6.i0 r1 = r6.f9869d
            boolean r4 = r1.e()
            if (r4 == 0) goto L3a
            java.lang.Object r4 = r1.f1400l
            android.content.res.ColorStateList r4 = (android.content.res.ColorStateList) r4
            int r5 = r4.getDefaultColor()
            int r7 = r4.getColorForState(r7, r5)
            int r4 = r1.f1398j
            if (r7 == r4) goto L3a
            r1.f1398j = r7
            goto L3b
        L3a:
            r2 = 0
        L3b:
            r7 = r0 | r2
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.i.b(int[]):boolean");
    }

    public float getFillAlpha() {
        return this.h;
    }

    public int getFillColor() {
        return this.f9871f.f1398j;
    }

    public float getStrokeAlpha() {
        return this.f9872g;
    }

    public int getStrokeColor() {
        return this.f9869d.f1398j;
    }

    public float getStrokeWidth() {
        return this.f9870e;
    }

    public float getTrimPathEnd() {
        return this.f9874j;
    }

    public float getTrimPathOffset() {
        return this.f9875k;
    }

    public float getTrimPathStart() {
        return this.f9873i;
    }

    public void setFillAlpha(float f9) {
        this.h = f9;
    }

    public void setFillColor(int i9) {
        this.f9871f.f1398j = i9;
    }

    public void setStrokeAlpha(float f9) {
        this.f9872g = f9;
    }

    public void setStrokeColor(int i9) {
        this.f9869d.f1398j = i9;
    }

    public void setStrokeWidth(float f9) {
        this.f9870e = f9;
    }

    public void setTrimPathEnd(float f9) {
        this.f9874j = f9;
    }

    public void setTrimPathOffset(float f9) {
        this.f9875k = f9;
    }

    public void setTrimPathStart(float f9) {
        this.f9873i = f9;
    }
}
