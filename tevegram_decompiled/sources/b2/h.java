package b2;

import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public long f1192a;

    /* renamed from: b, reason: collision with root package name */
    public long f1193b;

    /* renamed from: c, reason: collision with root package name */
    public long f1194c;

    /* renamed from: d, reason: collision with root package name */
    public long f1195d;

    /* renamed from: e, reason: collision with root package name */
    public long f1196e;

    /* renamed from: f, reason: collision with root package name */
    public long f1197f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean[] f1198g = new boolean[15];
    public int h;

    public final boolean a() {
        return this.f1195d > 15 && this.h == 0;
    }

    public final void b(long j5) {
        long j9 = this.f1195d;
        if (j9 == 0) {
            this.f1192a = j5;
        } else if (j9 == 1) {
            long j10 = j5 - this.f1192a;
            this.f1193b = j10;
            this.f1197f = j10;
            this.f1196e = 1L;
        } else {
            long j11 = j5 - this.f1194c;
            int i9 = (int) (j9 % 15);
            long abs = Math.abs(j11 - this.f1193b);
            boolean[] zArr = this.f1198g;
            if (abs <= 1000000) {
                this.f1196e++;
                this.f1197f += j11;
                if (zArr[i9]) {
                    zArr[i9] = false;
                    this.h--;
                }
            } else if (!zArr[i9]) {
                zArr[i9] = true;
                this.h++;
            }
        }
        this.f1195d++;
        this.f1194c = j5;
    }

    public final void c() {
        this.f1195d = 0L;
        this.f1196e = 0L;
        this.f1197f = 0L;
        this.h = 0;
        Arrays.fill(this.f1198g, false);
    }
}
