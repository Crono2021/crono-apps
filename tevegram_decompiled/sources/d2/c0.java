package d2;

import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f2665a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f2666b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2667c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2668d;

    public c0(int i9, int i10, int i11, byte[] bArr) {
        this.f2665a = i9;
        this.f2666b = bArr;
        this.f2667c = i10;
        this.f2668d = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c0.class != obj.getClass()) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.f2665a == c0Var.f2665a && this.f2667c == c0Var.f2667c && this.f2668d == c0Var.f2668d && Arrays.equals(this.f2666b, c0Var.f2666b);
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.f2666b) + (this.f2665a * 31)) * 31) + this.f2667c) * 31) + this.f2668d;
    }
}
