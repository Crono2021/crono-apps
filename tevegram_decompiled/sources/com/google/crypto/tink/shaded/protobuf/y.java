package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class y extends a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, y> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize;
    protected g1 unknownFields;

    public y() {
        this.memoizedHashCode = 0;
        this.memoizedSerializedSize = -1;
        this.unknownFields = g1.f2237f;
    }

    public static void g(y yVar) {
        if (!m(yVar, true)) {
            throw new e0(new f1().getMessage());
        }
    }

    public static y j(Class cls) {
        y yVar = defaultInstanceMap.get(cls);
        if (yVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                yVar = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e9) {
                throw new IllegalStateException("Class initialization cannot fail.", e9);
            }
        }
        if (yVar != null) {
            return yVar;
        }
        y a9 = ((y) p1.b(cls)).a();
        if (a9 != null) {
            defaultInstanceMap.put(cls, a9);
            return a9;
        }
        androidx.fragment.app.a.l();
        return null;
    }

    public static Object l(Method method, y yVar, Object... objArr) {
        try {
            return method.invoke(yVar, objArr);
        } catch (IllegalAccessException e9) {
            m7.c.k("Couldn't use Java reflection to implement protocol message reflection.", e9);
            return null;
        } catch (InvocationTargetException e10) {
            Throwable cause = e10.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            m7.c.k("Unexpected exception thrown by generated accessor method.", cause);
            return null;
        }
    }

    public static final boolean m(y yVar, boolean z8) {
        byte byteValue = ((Byte) yVar.i(1)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        a1 a1Var = a1.f2198c;
        a1Var.getClass();
        boolean f9 = a1Var.a(yVar.getClass()).f(yVar);
        if (z8) {
            yVar.i(2);
        }
        return f9;
    }

    public static y r(y yVar, j jVar, q qVar) {
        i iVar = (i) jVar;
        k h = m.h(iVar.f2245l, iVar.k(), iVar.size(), true);
        y s8 = s(yVar, h, qVar);
        h.b(0);
        g(s8);
        return s8;
    }

    public static y s(y yVar, m mVar, q qVar) {
        y q4 = yVar.q();
        try {
            a1 a1Var = a1.f2198c;
            a1Var.getClass();
            d1 a9 = a1Var.a(q4.getClass());
            a5.k kVar = (a5.k) mVar.f2269b;
            if (kVar == null) {
                kVar = new a5.k(mVar);
            }
            a9.d(q4, kVar, qVar);
            a9.e(q4);
            return q4;
        } catch (e0 e9) {
            if (e9.f2216i) {
                throw new e0(e9.getMessage(), e9);
            }
            throw e9;
        } catch (f1 e10) {
            throw new e0(e10.getMessage());
        } catch (IOException e11) {
            if (e11.getCause() instanceof e0) {
                throw ((e0) e11.getCause());
            }
            throw new e0(e11.getMessage(), e11);
        } catch (RuntimeException e12) {
            if (e12.getCause() instanceof e0) {
                throw ((e0) e12.getCause());
            }
            throw e12;
        }
    }

    public static void t(Class cls, y yVar) {
        yVar.o();
        defaultInstanceMap.put(cls, yVar);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a
    public final int b(d1 d1Var) {
        int a9;
        int a10;
        if (n()) {
            if (d1Var == null) {
                a1 a1Var = a1.f2198c;
                a1Var.getClass();
                a10 = a1Var.a(getClass()).a(this);
            } else {
                a10 = d1Var.a(this);
            }
            if (a10 >= 0) {
                return a10;
            }
            m7.c.p(androidx.activity.g.m(a10, "serialized size must be non-negative, was "));
            return 0;
        }
        int i9 = this.memoizedSerializedSize;
        if ((i9 & Integer.MAX_VALUE) != Integer.MAX_VALUE) {
            return i9 & Integer.MAX_VALUE;
        }
        if (d1Var == null) {
            a1 a1Var2 = a1.f2198c;
            a1Var2.getClass();
            a9 = a1Var2.a(getClass()).a(this);
        } else {
            a9 = d1Var.a(this);
        }
        u(a9);
        return a9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a1 a1Var = a1.f2198c;
        a1Var.getClass();
        return a1Var.a(getClass()).g(this, (y) obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a
    public final void f(n nVar) {
        a1 a1Var = a1.f2198c;
        a1Var.getClass();
        d1 a9 = a1Var.a(getClass());
        n0 n0Var = nVar.f2274a;
        if (n0Var == null) {
            n0Var = new n0(nVar);
        }
        a9.h(this, n0Var);
    }

    public final w h() {
        return (w) i(5);
    }

    public final int hashCode() {
        if (n()) {
            a1 a1Var = a1.f2198c;
            a1Var.getClass();
            return a1Var.a(getClass()).j(this);
        }
        if (this.memoizedHashCode == 0) {
            a1 a1Var2 = a1.f2198c;
            a1Var2.getClass();
            this.memoizedHashCode = a1Var2.a(getClass()).j(this);
        }
        return this.memoizedHashCode;
    }

    public abstract Object i(int i9);

    @Override // com.google.crypto.tink.shaded.protobuf.s0
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final y a() {
        return (y) i(6);
    }

    public final boolean n() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public final void o() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final w d() {
        return (w) i(5);
    }

    public final y q() {
        return (y) i(4);
    }

    public final String toString() {
        String obj = super.toString();
        char[] cArr = t0.f2304a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        t0.c(this, sb, 0);
        return sb.toString();
    }

    public final void u(int i9) {
        if (i9 < 0) {
            m7.c.p(androidx.activity.g.m(i9, "serialized size must be non-negative, was "));
        } else {
            this.memoizedSerializedSize = (i9 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
        }
    }

    public final w v() {
        w wVar = (w) i(5);
        if (!wVar.f2325i.equals(this)) {
            wVar.e();
            w.f(wVar.f2326j, this);
        }
        return wVar;
    }
}
