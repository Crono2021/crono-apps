package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class o1 {

    /* renamed from: a, reason: collision with root package name */
    public final Unsafe f2282a;

    public o1(Unsafe unsafe) {
        this.f2282a = unsafe;
    }

    public final int a(Class cls) {
        return this.f2282a.arrayBaseOffset(cls);
    }

    public final int b(Class cls) {
        return this.f2282a.arrayIndexScale(cls);
    }

    public abstract boolean c(long j5, Object obj);

    public abstract byte d(long j5, Object obj);

    public abstract double e(long j5, Object obj);

    public abstract float f(long j5, Object obj);

    public final int g(long j5, Object obj) {
        return this.f2282a.getInt(obj, j5);
    }

    public final long h(long j5, Object obj) {
        return this.f2282a.getLong(obj, j5);
    }

    public final Object i(long j5, Object obj) {
        return this.f2282a.getObject(obj, j5);
    }

    public final long j(Field field) {
        return this.f2282a.objectFieldOffset(field);
    }

    public abstract void k(Object obj, long j5, boolean z8);

    public abstract void l(Object obj, long j5, byte b9);

    public abstract void m(Object obj, long j5, double d9);

    public abstract void n(Object obj, long j5, float f9);

    public final void o(int i9, long j5, Object obj) {
        this.f2282a.putInt(obj, j5, i9);
    }

    public final void p(Object obj, long j5, long j9) {
        this.f2282a.putLong(obj, j5, j9);
    }

    public final void q(long j5, Object obj, Object obj2) {
        this.f2282a.putObject(obj, j5, obj2);
    }

    public boolean r() {
        Unsafe unsafe = this.f2282a;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            return true;
        } catch (Throwable th) {
            p1.a(th);
            return false;
        }
    }

    public abstract boolean s();
}
