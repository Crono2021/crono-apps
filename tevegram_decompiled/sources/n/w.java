package n;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f7080a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.x f7081b;

    public w(TextView textView) {
        this.f7080a = textView;
        this.f7081b = new i7.x(textView);
    }

    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        return ((com.bumptech.glide.c) this.f7081b.f5179j).y(inputFilterArr);
    }

    public final void b(AttributeSet attributeSet, int i9) {
        TypedArray obtainStyledAttributes = this.f7080a.getContext().obtainStyledAttributes(attributeSet, f.a.f3173i, i9, 0);
        try {
            boolean z8 = obtainStyledAttributes.hasValue(14) ? obtainStyledAttributes.getBoolean(14, true) : true;
            obtainStyledAttributes.recycle();
            d(z8);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void c(boolean z8) {
        ((com.bumptech.glide.c) this.f7081b.f5179j).T(z8);
    }

    public final void d(boolean z8) {
        ((com.bumptech.glide.c) this.f7081b.f5179j).U(z8);
    }
}
