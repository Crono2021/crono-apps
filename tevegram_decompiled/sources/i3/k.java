package i3;

import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k {

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f4528f = {0, 0, 1};

    /* renamed from: a, reason: collision with root package name */
    public boolean f4529a;

    /* renamed from: b, reason: collision with root package name */
    public int f4530b;

    /* renamed from: c, reason: collision with root package name */
    public int f4531c;

    /* renamed from: d, reason: collision with root package name */
    public int f4532d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f4533e;

    public final void a(int i9, int i10, byte[] bArr) {
        if (this.f4529a) {
            int i11 = i10 - i9;
            byte[] bArr2 = this.f4533e;
            int length = bArr2.length;
            int i12 = this.f4531c + i11;
            if (length < i12) {
                this.f4533e = Arrays.copyOf(bArr2, i12 * 2);
            }
            System.arraycopy(bArr, i9, this.f4533e, this.f4531c, i11);
            this.f4531c += i11;
        }
    }
}
