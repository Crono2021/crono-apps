package o3;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class p0 extends ViewGroup.MarginLayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public d1 f7765a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f7766b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7767c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7768d;

    public p0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7766b = new Rect();
        this.f7767c = true;
        this.f7768d = false;
    }

    public p0(int i9, int i10) {
        super(i9, i10);
        this.f7766b = new Rect();
        this.f7767c = true;
        this.f7768d = false;
    }

    public p0(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f7766b = new Rect();
        this.f7767c = true;
        this.f7768d = false;
    }

    public p0(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f7766b = new Rect();
        this.f7767c = true;
        this.f7768d = false;
    }

    public p0(p0 p0Var) {
        super((ViewGroup.LayoutParams) p0Var);
        this.f7766b = new Rect();
        this.f7767c = true;
        this.f7768d = false;
    }
}
