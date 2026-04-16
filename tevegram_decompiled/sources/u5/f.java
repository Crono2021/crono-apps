package u5;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class f extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public j f9069a;

    /* renamed from: b, reason: collision with root package name */
    public m5.a f9070b;

    /* renamed from: c, reason: collision with root package name */
    public ColorStateList f9071c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f9072d;

    /* renamed from: e, reason: collision with root package name */
    public ColorStateList f9073e;

    /* renamed from: f, reason: collision with root package name */
    public PorterDuff.Mode f9074f;

    /* renamed from: g, reason: collision with root package name */
    public Rect f9075g;
    public final float h;

    /* renamed from: i, reason: collision with root package name */
    public float f9076i;

    /* renamed from: j, reason: collision with root package name */
    public float f9077j;

    /* renamed from: k, reason: collision with root package name */
    public int f9078k;

    /* renamed from: l, reason: collision with root package name */
    public float f9079l;

    /* renamed from: m, reason: collision with root package name */
    public float f9080m;

    /* renamed from: n, reason: collision with root package name */
    public int f9081n;

    /* renamed from: o, reason: collision with root package name */
    public int f9082o;

    /* renamed from: p, reason: collision with root package name */
    public final Paint.Style f9083p;

    public f(f fVar) {
        this.f9071c = null;
        this.f9072d = null;
        this.f9073e = null;
        this.f9074f = PorterDuff.Mode.SRC_IN;
        this.f9075g = null;
        this.h = 1.0f;
        this.f9076i = 1.0f;
        this.f9078k = 255;
        this.f9079l = 0.0f;
        this.f9080m = 0.0f;
        this.f9081n = 0;
        this.f9082o = 0;
        this.f9083p = Paint.Style.FILL_AND_STROKE;
        this.f9069a = fVar.f9069a;
        this.f9070b = fVar.f9070b;
        this.f9077j = fVar.f9077j;
        this.f9071c = fVar.f9071c;
        this.f9072d = fVar.f9072d;
        this.f9074f = fVar.f9074f;
        this.f9073e = fVar.f9073e;
        this.f9078k = fVar.f9078k;
        this.h = fVar.h;
        this.f9082o = fVar.f9082o;
        this.f9076i = fVar.f9076i;
        this.f9079l = fVar.f9079l;
        this.f9080m = fVar.f9080m;
        this.f9081n = fVar.f9081n;
        this.f9083p = fVar.f9083p;
        if (fVar.f9075g != null) {
            this.f9075g = new Rect(fVar.f9075g);
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        g gVar = new g(this);
        gVar.f9088m = true;
        return gVar;
    }

    public f(j jVar) {
        this.f9071c = null;
        this.f9072d = null;
        this.f9073e = null;
        this.f9074f = PorterDuff.Mode.SRC_IN;
        this.f9075g = null;
        this.h = 1.0f;
        this.f9076i = 1.0f;
        this.f9078k = 255;
        this.f9079l = 0.0f;
        this.f9080m = 0.0f;
        this.f9081n = 0;
        this.f9082o = 0;
        this.f9083p = Paint.Style.FILL_AND_STROKE;
        this.f9069a = jVar;
        this.f9070b = null;
    }
}
