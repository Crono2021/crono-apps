package com.google.crypto.tink.shaded.protobuf;

import sun.misc.Unsafe;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m1 extends o1 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2271b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m1(Unsafe unsafe, int i9) {
        super(unsafe);
        this.f2271b = i9;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o1
    public final boolean c(long j5, Object obj) {
        switch (this.f2271b) {
            case 0:
                if (p1.f2290g) {
                    if (p1.h(j5, obj) != 0) {
                    }
                } else if (p1.i(j5, obj) != 0) {
                }
                break;
            default:
                if (p1.f2290g) {
                    if (p1.h(j5, obj) != 0) {
                    }
                } else if (p1.i(j5, obj) != 0) {
                }
                break;
        }
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o1
    public final byte d(long j5, Object obj) {
        switch (this.f2271b) {
            case 0:
                if (!p1.f2290g) {
                    break;
                } else {
                    break;
                }
            default:
                if (!p1.f2290g) {
                    break;
                } else {
                    break;
                }
        }
        return p1.i(j5, obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o1
    public final double e(long j5, Object obj) {
        switch (this.f2271b) {
        }
        return Double.longBitsToDouble(h(j5, obj));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o1
    public final float f(long j5, Object obj) {
        switch (this.f2271b) {
        }
        return Float.intBitsToFloat(g(j5, obj));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o1
    public final void k(Object obj, long j5, boolean z8) {
        switch (this.f2271b) {
            case 0:
                if (!p1.f2290g) {
                    p1.m(obj, j5, z8 ? (byte) 1 : (byte) 0);
                    break;
                } else {
                    p1.l(obj, j5, z8 ? (byte) 1 : (byte) 0);
                    break;
                }
            default:
                if (!p1.f2290g) {
                    p1.m(obj, j5, z8 ? (byte) 1 : (byte) 0);
                    break;
                } else {
                    p1.l(obj, j5, z8 ? (byte) 1 : (byte) 0);
                    break;
                }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o1
    public final void l(Object obj, long j5, byte b9) {
        switch (this.f2271b) {
            case 0:
                if (!p1.f2290g) {
                    p1.m(obj, j5, b9);
                    break;
                } else {
                    p1.l(obj, j5, b9);
                    break;
                }
            default:
                if (!p1.f2290g) {
                    p1.m(obj, j5, b9);
                    break;
                } else {
                    p1.l(obj, j5, b9);
                    break;
                }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o1
    public final void m(Object obj, long j5, double d9) {
        switch (this.f2271b) {
            case 0:
                p(obj, j5, Double.doubleToLongBits(d9));
                break;
            default:
                p(obj, j5, Double.doubleToLongBits(d9));
                break;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o1
    public final void n(Object obj, long j5, float f9) {
        switch (this.f2271b) {
            case 0:
                o(Float.floatToIntBits(f9), j5, obj);
                break;
            default:
                o(Float.floatToIntBits(f9), j5, obj);
                break;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o1
    public final boolean s() {
        switch (this.f2271b) {
        }
        return false;
    }
}
