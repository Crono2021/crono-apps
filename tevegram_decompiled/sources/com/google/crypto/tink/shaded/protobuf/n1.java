package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n1 extends o1 {
    @Override // com.google.crypto.tink.shaded.protobuf.o1
    public final boolean c(long j5, Object obj) {
        return this.f2282a.getBoolean(obj, j5);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o1
    public final byte d(long j5, Object obj) {
        return this.f2282a.getByte(obj, j5);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o1
    public final double e(long j5, Object obj) {
        return this.f2282a.getDouble(obj, j5);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o1
    public final float f(long j5, Object obj) {
        return this.f2282a.getFloat(obj, j5);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o1
    public final void k(Object obj, long j5, boolean z8) {
        this.f2282a.putBoolean(obj, j5, z8);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o1
    public final void l(Object obj, long j5, byte b9) {
        this.f2282a.putByte(obj, j5, b9);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o1
    public final void m(Object obj, long j5, double d9) {
        this.f2282a.putDouble(obj, j5, d9);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o1
    public final void n(Object obj, long j5, float f9) {
        this.f2282a.putFloat(obj, j5, f9);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o1
    public final boolean r() {
        if (!super.r()) {
            return false;
        }
        try {
            Class<?> cls = this.f2282a.getClass();
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            p1.a(th);
            return false;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.o1
    public final boolean s() {
        Unsafe unsafe = this.f2282a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getLong", Object.class, cls2);
                if (p1.e() != null) {
                    try {
                        Class<?> cls3 = this.f2282a.getClass();
                        cls3.getMethod("getByte", cls2);
                        cls3.getMethod("putByte", cls2, Byte.TYPE);
                        cls3.getMethod("getInt", cls2);
                        cls3.getMethod("putInt", cls2, Integer.TYPE);
                        cls3.getMethod("getLong", cls2);
                        cls3.getMethod("putLong", cls2, cls2);
                        cls3.getMethod("copyMemory", cls2, cls2, cls2);
                        cls3.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                        return true;
                    } catch (Throwable th) {
                        p1.a(th);
                        return false;
                    }
                }
            } catch (Throwable th2) {
                p1.a(th2);
            }
        }
        return false;
    }
}
