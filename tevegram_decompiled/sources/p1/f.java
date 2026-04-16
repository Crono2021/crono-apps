package p1;

import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f implements w1.b {

    /* renamed from: i, reason: collision with root package name */
    public final long f8107i;

    /* renamed from: j, reason: collision with root package name */
    public long f8108j = -1;

    /* renamed from: k, reason: collision with root package name */
    public final List f8109k;

    /* renamed from: l, reason: collision with root package name */
    public final long f8110l;

    public f(long j5, List list) {
        this.f8107i = list.size() - 1;
        this.f8110l = j5;
        this.f8109k = list;
    }

    @Override // w1.b
    public final long a() {
        long j5 = this.f8108j;
        if (j5 < 0 || j5 > this.f8107i) {
            throw new NoSuchElementException();
        }
        q1.g gVar = (q1.g) this.f8109k.get((int) j5);
        return this.f8110l + gVar.f8345m + gVar.f8343k;
    }

    @Override // w1.b
    public final long k() {
        long j5 = this.f8108j;
        if (j5 < 0 || j5 > this.f8107i) {
            throw new NoSuchElementException();
        }
        return this.f8110l + ((q1.g) this.f8109k.get((int) j5)).f8345m;
    }

    @Override // w1.b
    public final boolean next() {
        long j5 = this.f8108j + 1;
        this.f8108j = j5;
        return !(j5 > this.f8107i);
    }
}
