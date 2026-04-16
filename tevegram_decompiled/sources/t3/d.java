package t3;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final RectF f8924a = new RectF();

    /* renamed from: b, reason: collision with root package name */
    public final Paint f8925b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f8926c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f8927d;

    /* renamed from: e, reason: collision with root package name */
    public float f8928e;

    /* renamed from: f, reason: collision with root package name */
    public float f8929f;

    /* renamed from: g, reason: collision with root package name */
    public float f8930g;
    public float h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f8931i;

    /* renamed from: j, reason: collision with root package name */
    public int f8932j;

    /* renamed from: k, reason: collision with root package name */
    public float f8933k;

    /* renamed from: l, reason: collision with root package name */
    public float f8934l;

    /* renamed from: m, reason: collision with root package name */
    public float f8935m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8936n;

    /* renamed from: o, reason: collision with root package name */
    public Path f8937o;

    /* renamed from: p, reason: collision with root package name */
    public float f8938p;

    /* renamed from: q, reason: collision with root package name */
    public float f8939q;

    /* renamed from: r, reason: collision with root package name */
    public int f8940r;

    /* renamed from: s, reason: collision with root package name */
    public int f8941s;

    /* renamed from: t, reason: collision with root package name */
    public int f8942t;

    /* renamed from: u, reason: collision with root package name */
    public int f8943u;

    public d() {
        Paint paint = new Paint();
        this.f8925b = paint;
        Paint paint2 = new Paint();
        this.f8926c = paint2;
        Paint paint3 = new Paint();
        this.f8927d = paint3;
        this.f8928e = 0.0f;
        this.f8929f = 0.0f;
        this.f8930g = 0.0f;
        this.h = 5.0f;
        this.f8938p = 1.0f;
        this.f8942t = 255;
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint3.setColor(0);
    }

    public final void a(int i9) {
        this.f8932j = i9;
        this.f8943u = this.f8931i[i9];
    }
}
