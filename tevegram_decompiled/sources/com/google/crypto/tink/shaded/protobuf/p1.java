package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class p1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f2284a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f2285b;

    /* renamed from: c, reason: collision with root package name */
    public static final o1 f2286c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f2287d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f2288e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f2289f;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f2290g;

    static {
        Unsafe j5 = j();
        f2284a = j5;
        f2285b = c.f2205a;
        boolean f9 = f(Long.TYPE);
        boolean f10 = f(Integer.TYPE);
        o1 o1Var = null;
        if (j5 != null) {
            if (!c.a()) {
                o1Var = new n1(j5);
            } else if (f9) {
                o1Var = new m1(j5, 1);
            } else if (f10) {
                o1Var = new m1(j5, 0);
            }
        }
        f2286c = o1Var;
        f2287d = o1Var == null ? false : o1Var.s();
        f2288e = o1Var == null ? false : o1Var.r();
        f2289f = c(byte[].class);
        c(boolean[].class);
        d(boolean[].class);
        c(int[].class);
        d(int[].class);
        c(long[].class);
        d(long[].class);
        c(float[].class);
        d(float[].class);
        c(double[].class);
        d(double[].class);
        c(Object[].class);
        d(Object[].class);
        Field e9 = e();
        if (e9 != null && o1Var != null) {
            o1Var.j(e9);
        }
        f2290g = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static void a(Throwable th) {
        Logger.getLogger(p1.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static Object b(Class cls) {
        try {
            return f2284a.allocateInstance(cls);
        } catch (InstantiationException e9) {
            throw new IllegalStateException(e9);
        }
    }

    public static int c(Class cls) {
        if (f2288e) {
            return f2286c.a(cls);
        }
        return -1;
    }

    public static void d(Class cls) {
        if (f2288e) {
            f2286c.b(cls);
        }
    }

    public static Field e() {
        Field field;
        Field field2;
        if (c.a()) {
            try {
                field2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                field2 = null;
            }
            if (field2 != null) {
                return field2;
            }
        }
        try {
            field = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            field = null;
        }
        if (field == null || field.getType() != Long.TYPE) {
            return null;
        }
        return field;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean f(Class cls) {
        if (!c.a()) {
            return false;
        }
        try {
            Class cls2 = f2285b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static byte g(long j5, byte[] bArr) {
        return f2286c.d(f2289f + j5, bArr);
    }

    public static byte h(long j5, Object obj) {
        return (byte) ((f2286c.g((-4) & j5, obj) >>> ((int) (((~j5) & 3) << 3))) & 255);
    }

    public static byte i(long j5, Object obj) {
        return (byte) ((f2286c.g((-4) & j5, obj) >>> ((int) ((j5 & 3) << 3))) & 255);
    }

    public static Unsafe j() {
        try {
            return (Unsafe) AccessController.doPrivileged(new l1());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void k(byte[] bArr, long j5, byte b9) {
        f2286c.l(bArr, f2289f + j5, b9);
    }

    public static void l(Object obj, long j5, byte b9) {
        long j9 = (-4) & j5;
        int g9 = f2286c.g(j9, obj);
        int i9 = ((~((int) j5)) & 3) << 3;
        n(((255 & b9) << i9) | (g9 & (~(255 << i9))), j9, obj);
    }

    public static void m(Object obj, long j5, byte b9) {
        long j9 = (-4) & j5;
        int i9 = (((int) j5) & 3) << 3;
        n(((255 & b9) << i9) | (f2286c.g(j9, obj) & (~(255 << i9))), j9, obj);
    }

    public static void n(int i9, long j5, Object obj) {
        f2286c.o(i9, j5, obj);
    }

    public static void o(Object obj, long j5, long j9) {
        f2286c.p(obj, j5, j9);
    }

    public static void p(long j5, Object obj, Object obj2) {
        f2286c.q(j5, obj, obj2);
    }
}
