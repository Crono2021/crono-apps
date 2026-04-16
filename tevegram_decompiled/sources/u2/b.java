package u2;

import d2.n;
import i7.x;
import java.util.ArrayDeque;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f8994a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f8995b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final e f8996c = new e();

    /* renamed from: d, reason: collision with root package name */
    public x f8997d;

    /* renamed from: e, reason: collision with root package name */
    public int f8998e;

    /* renamed from: f, reason: collision with root package name */
    public int f8999f;

    /* renamed from: g, reason: collision with root package name */
    public long f9000g;

    public final long a(n nVar, int i9) {
        nVar.readFully(this.f8994a, 0, i9);
        long j5 = 0;
        for (int i10 = 0; i10 < i9; i10++) {
            j5 = (j5 << 8) | (r0[i10] & 255);
        }
        return j5;
    }
}
