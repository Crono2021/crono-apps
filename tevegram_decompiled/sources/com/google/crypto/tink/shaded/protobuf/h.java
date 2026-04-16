package com.google.crypto.tink.shaded.protobuf;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h extends i {

    /* renamed from: m, reason: collision with root package name */
    public final int f2243m;

    /* renamed from: n, reason: collision with root package name */
    public final int f2244n;

    public h(int i9, int i10, byte[] bArr) {
        super(bArr);
        j.g(i9, i9 + i10, bArr.length);
        this.f2243m = i9;
        this.f2244n = i10;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.i, com.google.crypto.tink.shaded.protobuf.j
    public final byte f(int i9) {
        int i10 = this.f2244n;
        if (((i10 - (i9 + 1)) | i9) >= 0) {
            return this.f2245l[this.f2243m + i9];
        }
        if (i9 < 0) {
            throw new ArrayIndexOutOfBoundsException(androidx.activity.g.m(i9, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i9 + ", " + i10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.i, com.google.crypto.tink.shaded.protobuf.j
    public final void i(byte[] bArr, int i9) {
        System.arraycopy(this.f2245l, this.f2243m, bArr, 0, i9);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.i
    public final int k() {
        return this.f2243m;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.i
    public final byte l(int i9) {
        return this.f2245l[this.f2243m + i9];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.i, com.google.crypto.tink.shaded.protobuf.j
    public final int size() {
        return this.f2244n;
    }
}
