package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public int f2268a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2269b;

    public static int d(int i9) {
        return (-(i9 & 1)) ^ (i9 >>> 1);
    }

    public static long e(long j5) {
        return (-(j5 & 1)) ^ (j5 >>> 1);
    }

    public static k h(byte[] bArr, int i9, int i10, boolean z8) {
        k kVar = new k(bArr, i9, i10, z8);
        try {
            kVar.l(i10);
            return kVar;
        } catch (e0 e9) {
            throw new IllegalArgumentException(e9);
        }
    }

    public abstract String A();

    public abstract int B();

    public abstract int C();

    public abstract long D();

    public ByteBuffer a(byte[] bArr, int i9) {
        int[] c9 = c(h6.a.c(bArr), i9);
        int[] iArr = (int[]) c9.clone();
        h6.a.b(iArr);
        for (int i10 = 0; i10 < c9.length; i10++) {
            c9[i10] = c9[i10] + iArr[i10];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(c9, 0, 16);
        return order;
    }

    public abstract void b(int i9);

    public abstract int[] c(int[] iArr, int i9);

    public abstract int f();

    public abstract boolean g();

    public abstract int i();

    public abstract void j(int i9);

    public void k(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (bArr.length != i()) {
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + i());
        }
        int remaining = byteBuffer2.remaining();
        int i9 = remaining / 64;
        int i10 = i9 + 1;
        for (int i11 = 0; i11 < i10; i11++) {
            ByteBuffer a9 = a(bArr, this.f2268a + i11);
            if (i11 == i9) {
                a.a.W(byteBuffer, byteBuffer2, a9, remaining % 64);
            } else {
                a.a.W(byteBuffer, byteBuffer2, a9, 64);
            }
        }
    }

    public abstract int l(int i9);

    public abstract boolean m();

    public abstract i n();

    public abstract double o();

    public abstract int p();

    public abstract int q();

    public abstract long r();

    public abstract float s();

    public abstract int t();

    public abstract long u();

    public abstract int v();

    public abstract long w();

    public abstract int x();

    public abstract long y();

    public abstract String z();
}
