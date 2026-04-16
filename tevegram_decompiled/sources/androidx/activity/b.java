package androidx.activity;

import android.window.BackEvent;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final float f279a;

    /* renamed from: b, reason: collision with root package name */
    public final float f280b;

    /* renamed from: c, reason: collision with root package name */
    public final float f281c;

    /* renamed from: d, reason: collision with root package name */
    public final int f282d;

    public b(BackEvent backEvent) {
        a aVar = a.f278a;
        float d9 = aVar.d(backEvent);
        float e9 = aVar.e(backEvent);
        float b9 = aVar.b(backEvent);
        int c9 = aVar.c(backEvent);
        this.f279a = d9;
        this.f280b = e9;
        this.f281c = b9;
        this.f282d = c9;
    }

    public final String toString() {
        return "BackEventCompat{touchX=" + this.f279a + ", touchY=" + this.f280b + ", progress=" + this.f281c + ", swipeEdge=" + this.f282d + '}';
    }
}
