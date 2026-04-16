package androidx.media3.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bumptech.glide.manager.n;
import l3.a;
import l3.b0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class AspectRatioFrameLayout extends FrameLayout {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f993l = 0;

    /* renamed from: i, reason: collision with root package name */
    public final n f994i;

    /* renamed from: j, reason: collision with root package name */
    public float f995j;

    /* renamed from: k, reason: collision with root package name */
    public int f996k;

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f996k = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, b0.f6086a, 0, 0);
            try {
                this.f996k = obtainStyledAttributes.getInt(0, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f994i = new n(this);
    }

    public int getResizeMode() {
        return this.f996k;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        if (r4 > 0.0f) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        r2 = r2 * r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
    
        r1 = r1 / r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0060, code lost:
    
        if (r4 > 0.0f) goto L23;
     */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r9, int r10) {
        /*
            r8 = this;
            super.onMeasure(r9, r10)
            float r9 = r8.f995j
            r10 = 0
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 > 0) goto Lb
            goto L38
        Lb:
            int r9 = r8.getMeasuredWidth()
            int r0 = r8.getMeasuredHeight()
            float r1 = (float) r9
            float r2 = (float) r0
            float r3 = r1 / r2
            float r4 = r8.f995j
            float r4 = r4 / r3
            r3 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 - r3
            float r3 = java.lang.Math.abs(r4)
            r5 = 1008981770(0x3c23d70a, float:0.01)
            r6 = 1
            com.bumptech.glide.manager.n r7 = r8.f994i
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L39
            boolean r9 = r7.f1841j
            if (r9 != 0) goto L38
            r7.f1841j = r6
            java.lang.Object r9 = r7.f1842k
            androidx.media3.ui.AspectRatioFrameLayout r9 = (androidx.media3.ui.AspectRatioFrameLayout) r9
            r9.post(r7)
        L38:
            return
        L39:
            int r3 = r8.f996k
            if (r3 == 0) goto L5c
            if (r3 == r6) goto L58
            r5 = 2
            if (r3 == r5) goto L53
            r5 = 4
            if (r3 == r5) goto L46
            goto L63
        L46:
            int r10 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            float r3 = r8.f995j
            if (r10 <= 0) goto L50
        L4c:
            float r2 = r2 * r3
        L4e:
            int r9 = (int) r2
            goto L63
        L50:
            float r1 = r1 / r3
        L51:
            int r0 = (int) r1
            goto L63
        L53:
            float r9 = r8.f995j
            float r2 = r2 * r9
            goto L4e
        L58:
            float r10 = r8.f995j
            float r1 = r1 / r10
            goto L51
        L5c:
            int r10 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            float r3 = r8.f995j
            if (r10 <= 0) goto L4c
            goto L50
        L63:
            boolean r10 = r7.f1841j
            if (r10 != 0) goto L70
            r7.f1841j = r6
            java.lang.Object r10 = r7.f1842k
            androidx.media3.ui.AspectRatioFrameLayout r10 = (androidx.media3.ui.AspectRatioFrameLayout) r10
            r10.post(r7)
        L70:
            r10 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r10)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r10)
            super.onMeasure(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.AspectRatioFrameLayout.onMeasure(int, int):void");
    }

    public void setAspectRatio(float f9) {
        if (this.f995j != f9) {
            this.f995j = f9;
            requestLayout();
        }
    }

    public void setResizeMode(int i9) {
        if (this.f996k != i9) {
            this.f996k = i9;
            requestLayout();
        }
    }

    public void setAspectRatioListener(a aVar) {
    }
}
