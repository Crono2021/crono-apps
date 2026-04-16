package p1;

import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends w1.a {

    /* renamed from: j, reason: collision with root package name */
    public byte[] f8104j;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f8105k;

    /* renamed from: l, reason: collision with root package name */
    public byte[] f8106l;

    @Override // z1.m
    public final void a() {
        try {
            this.f9709i.f(this.f9703b);
            int i9 = 0;
            int i10 = 0;
            while (i9 != -1 && !this.f8105k) {
                byte[] bArr = this.f8104j;
                if (bArr.length < i10 + 16384) {
                    this.f8104j = Arrays.copyOf(bArr, bArr.length + 16384);
                }
                i9 = this.f9709i.read(this.f8104j, i10, 16384);
                if (i9 != -1) {
                    i10 += i9;
                }
            }
            if (!this.f8105k) {
                this.f8106l = Arrays.copyOf(this.f8104j, i10);
            }
            com.bumptech.glide.d.i(this.f9709i);
        } catch (Throwable th) {
            com.bumptech.glide.d.i(this.f9709i);
            throw th;
        }
    }

    @Override // z1.m
    public final void b() {
        this.f8105k = true;
    }
}
