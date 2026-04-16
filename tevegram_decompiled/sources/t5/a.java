package t5;

import android.graphics.Paint;
import android.graphics.Path;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f8969i = new int[3];

    /* renamed from: j, reason: collision with root package name */
    public static final float[] f8970j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f8971k = new int[4];

    /* renamed from: l, reason: collision with root package name */
    public static final float[] f8972l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public final Paint f8973a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f8974b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f8975c;

    /* renamed from: d, reason: collision with root package name */
    public int f8976d;

    /* renamed from: e, reason: collision with root package name */
    public int f8977e;

    /* renamed from: f, reason: collision with root package name */
    public int f8978f;

    /* renamed from: g, reason: collision with root package name */
    public final Path f8979g = new Path();
    public final Paint h;

    public a() {
        Paint paint = new Paint();
        this.h = paint;
        this.f8973a = new Paint();
        a(-16777216);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f8974b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f8975c = new Paint(paint2);
    }

    public final void a(int i9) {
        this.f8976d = f0.a.d(i9, 68);
        this.f8977e = f0.a.d(i9, 20);
        this.f8978f = f0.a.d(i9, 0);
        this.f8973a.setColor(this.f8976d);
    }
}
