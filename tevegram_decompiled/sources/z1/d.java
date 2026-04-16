package z1;

import g1.w;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    public int f10544c;

    /* renamed from: d, reason: collision with root package name */
    public int f10545d;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10542a = true;

    /* renamed from: b, reason: collision with root package name */
    public final int f10543b = 65536;

    /* renamed from: e, reason: collision with root package name */
    public int f10546e = 0;

    /* renamed from: f, reason: collision with root package name */
    public a[] f10547f = new a[100];

    public final synchronized void a(int i9) {
        boolean z8 = i9 < this.f10544c;
        this.f10544c = i9;
        if (z8) {
            b();
        }
    }

    public final synchronized void b() {
        int max = Math.max(0, w.f(this.f10544c, this.f10543b) - this.f10545d);
        int i9 = this.f10546e;
        if (max >= i9) {
            return;
        }
        Arrays.fill(this.f10547f, max, i9, (Object) null);
        this.f10546e = max;
    }
}
