package u5;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public com.bumptech.glide.c f9103a = new i();

    /* renamed from: b, reason: collision with root package name */
    public com.bumptech.glide.c f9104b = new i();

    /* renamed from: c, reason: collision with root package name */
    public com.bumptech.glide.c f9105c = new i();

    /* renamed from: d, reason: collision with root package name */
    public com.bumptech.glide.c f9106d = new i();

    /* renamed from: e, reason: collision with root package name */
    public c f9107e = new a(0.0f);

    /* renamed from: f, reason: collision with root package name */
    public c f9108f = new a(0.0f);

    /* renamed from: g, reason: collision with root package name */
    public c f9109g = new a(0.0f);
    public c h = new a(0.0f);

    /* renamed from: i, reason: collision with root package name */
    public e f9110i;

    /* renamed from: j, reason: collision with root package name */
    public e f9111j;

    /* renamed from: k, reason: collision with root package name */
    public e f9112k;

    /* renamed from: l, reason: collision with root package name */
    public e f9113l;

    public j() {
        int i9 = 0;
        this.f9110i = new e(i9);
        this.f9111j = new e(i9);
        this.f9112k = new e(i9);
        this.f9113l = new e(i9);
    }

    public static c7.b a(Context context, int i9, int i10, a aVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i9);
        if (i10 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i10);
        }
        TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(y4.a.B);
        try {
            int i11 = obtainStyledAttributes.getInt(0, 0);
            int i12 = obtainStyledAttributes.getInt(3, i11);
            int i13 = obtainStyledAttributes.getInt(4, i11);
            int i14 = obtainStyledAttributes.getInt(2, i11);
            int i15 = obtainStyledAttributes.getInt(1, i11);
            c c9 = c(obtainStyledAttributes, 5, aVar);
            c c10 = c(obtainStyledAttributes, 8, c9);
            c c11 = c(obtainStyledAttributes, 9, c9);
            c c12 = c(obtainStyledAttributes, 7, c9);
            c c13 = c(obtainStyledAttributes, 6, c9);
            c7.b bVar = new c7.b();
            bVar.f1650d = com.bumptech.glide.d.l(i12);
            bVar.f1652f = c10;
            bVar.f1651e = com.bumptech.glide.d.l(i13);
            bVar.f1653g = c11;
            bVar.f1647a = com.bumptech.glide.d.l(i14);
            bVar.h = c12;
            bVar.f1648b = com.bumptech.glide.d.l(i15);
            bVar.f1654i = c13;
            return bVar;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static c7.b b(Context context, AttributeSet attributeSet, int i9, int i10) {
        a aVar = new a(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y4.a.f10516v, i9, i10);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, aVar);
    }

    public static c c(TypedArray typedArray, int i9, c cVar) {
        TypedValue peekValue = typedArray.peekValue(i9);
        if (peekValue != null) {
            int i10 = peekValue.type;
            if (i10 == 5) {
                return new a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i10 == 6) {
                return new h(peekValue.getFraction(1.0f, 1.0f));
            }
        }
        return cVar;
    }

    public final boolean d(RectF rectF) {
        boolean z8 = this.f9113l.getClass().equals(e.class) && this.f9111j.getClass().equals(e.class) && this.f9110i.getClass().equals(e.class) && this.f9112k.getClass().equals(e.class);
        float a9 = this.f9107e.a(rectF);
        return z8 && ((this.f9108f.a(rectF) > a9 ? 1 : (this.f9108f.a(rectF) == a9 ? 0 : -1)) == 0 && (this.h.a(rectF) > a9 ? 1 : (this.h.a(rectF) == a9 ? 0 : -1)) == 0 && (this.f9109g.a(rectF) > a9 ? 1 : (this.f9109g.a(rectF) == a9 ? 0 : -1)) == 0) && ((this.f9104b instanceof i) && (this.f9103a instanceof i) && (this.f9105c instanceof i) && (this.f9106d instanceof i));
    }

    public final c7.b e() {
        c7.b bVar = new c7.b();
        bVar.f1650d = this.f9103a;
        bVar.f1651e = this.f9104b;
        bVar.f1647a = this.f9105c;
        bVar.f1648b = this.f9106d;
        bVar.f1652f = this.f9107e;
        bVar.f1653g = this.f9108f;
        bVar.h = this.f9109g;
        bVar.f1654i = this.h;
        bVar.f1649c = this.f9110i;
        bVar.f1655j = this.f9111j;
        bVar.f1656k = this.f9112k;
        bVar.f1657l = this.f9113l;
        return bVar;
    }
}
