package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class e1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f2217a;

    /* renamed from: b, reason: collision with root package name */
    public static final h1 f2218b;

    /* renamed from: c, reason: collision with root package name */
    public static final h1 f2219c;

    /* renamed from: d, reason: collision with root package name */
    public static final h1 f2220d;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.crypto.tink.shaded.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        f2217a = cls;
        f2218b = v(false);
        f2219c = v(true);
        f2220d = new h1();
    }

    public static void A(int i9, List list, n0 n0Var, boolean z8) {
        if (list == null || list.isEmpty()) {
            return;
        }
        n nVar = (n) n0Var.f2279a;
        int i10 = 0;
        if (!z8) {
            while (i10 < list.size()) {
                double doubleValue = ((Double) list.get(i10)).doubleValue();
                nVar.getClass();
                nVar.o(i9, Double.doubleToRawLongBits(doubleValue));
                i10++;
            }
            return;
        }
        nVar.r(i9, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Double) list.get(i12)).getClass();
            Logger logger = n.f2272e;
            i11 += 8;
        }
        nVar.s(i11);
        while (i10 < list.size()) {
            nVar.p(Double.doubleToRawLongBits(((Double) list.get(i10)).doubleValue()));
            i10++;
        }
    }

    public static void B(int i9, List list, n0 n0Var, boolean z8) {
        if (list == null || list.isEmpty()) {
            return;
        }
        n nVar = (n) n0Var.f2279a;
        if (!z8) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                int intValue = ((Integer) list.get(i10)).intValue();
                nVar.r(i9, 0);
                nVar.q(intValue);
            }
            return;
        }
        nVar.r(i9, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            i11 += n.f(((Integer) list.get(i12)).intValue());
        }
        nVar.s(i11);
        for (int i13 = 0; i13 < list.size(); i13++) {
            nVar.q(((Integer) list.get(i13)).intValue());
        }
    }

    public static void C(int i9, List list, n0 n0Var, boolean z8) {
        if (list == null || list.isEmpty()) {
            return;
        }
        n nVar = (n) n0Var.f2279a;
        int i10 = 0;
        if (!z8) {
            while (i10 < list.size()) {
                nVar.m(i9, ((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        nVar.r(i9, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Integer) list.get(i12)).getClass();
            Logger logger = n.f2272e;
            i11 += 4;
        }
        nVar.s(i11);
        while (i10 < list.size()) {
            nVar.n(((Integer) list.get(i10)).intValue());
            i10++;
        }
    }

    public static void D(int i9, List list, n0 n0Var, boolean z8) {
        if (list == null || list.isEmpty()) {
            return;
        }
        n nVar = (n) n0Var.f2279a;
        int i10 = 0;
        if (!z8) {
            while (i10 < list.size()) {
                nVar.o(i9, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        nVar.r(i9, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Long) list.get(i12)).getClass();
            Logger logger = n.f2272e;
            i11 += 8;
        }
        nVar.s(i11);
        while (i10 < list.size()) {
            nVar.p(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static void E(int i9, List list, n0 n0Var, boolean z8) {
        if (list == null || list.isEmpty()) {
            return;
        }
        n nVar = (n) n0Var.f2279a;
        int i10 = 0;
        if (!z8) {
            while (i10 < list.size()) {
                float floatValue = ((Float) list.get(i10)).floatValue();
                nVar.getClass();
                nVar.m(i9, Float.floatToRawIntBits(floatValue));
                i10++;
            }
            return;
        }
        nVar.r(i9, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Float) list.get(i12)).getClass();
            Logger logger = n.f2272e;
            i11 += 4;
        }
        nVar.s(i11);
        while (i10 < list.size()) {
            nVar.n(Float.floatToRawIntBits(((Float) list.get(i10)).floatValue()));
            i10++;
        }
    }

    public static void F(int i9, List list, n0 n0Var, d1 d1Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        n0Var.getClass();
        for (int i10 = 0; i10 < list.size(); i10++) {
            n0Var.b(i9, list.get(i10), d1Var);
        }
    }

    public static void G(int i9, List list, n0 n0Var, boolean z8) {
        if (list == null || list.isEmpty()) {
            return;
        }
        n nVar = (n) n0Var.f2279a;
        if (!z8) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                int intValue = ((Integer) list.get(i10)).intValue();
                nVar.r(i9, 0);
                nVar.q(intValue);
            }
            return;
        }
        nVar.r(i9, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            i11 += n.f(((Integer) list.get(i12)).intValue());
        }
        nVar.s(i11);
        for (int i13 = 0; i13 < list.size(); i13++) {
            nVar.q(((Integer) list.get(i13)).intValue());
        }
    }

    public static void H(int i9, List list, n0 n0Var, boolean z8) {
        if (list == null || list.isEmpty()) {
            return;
        }
        n nVar = (n) n0Var.f2279a;
        int i10 = 0;
        if (!z8) {
            while (i10 < list.size()) {
                nVar.t(i9, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        nVar.r(i9, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            i11 += n.j(((Long) list.get(i12)).longValue());
        }
        nVar.s(i11);
        while (i10 < list.size()) {
            nVar.u(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static void I(int i9, List list, n0 n0Var, d1 d1Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        n0Var.getClass();
        for (int i10 = 0; i10 < list.size(); i10++) {
            n0Var.c(i9, list.get(i10), d1Var);
        }
    }

    public static void J(int i9, List list, n0 n0Var, boolean z8) {
        if (list == null || list.isEmpty()) {
            return;
        }
        n nVar = (n) n0Var.f2279a;
        int i10 = 0;
        if (!z8) {
            while (i10 < list.size()) {
                nVar.m(i9, ((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        nVar.r(i9, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Integer) list.get(i12)).getClass();
            Logger logger = n.f2272e;
            i11 += 4;
        }
        nVar.s(i11);
        while (i10 < list.size()) {
            nVar.n(((Integer) list.get(i10)).intValue());
            i10++;
        }
    }

    public static void K(int i9, List list, n0 n0Var, boolean z8) {
        if (list == null || list.isEmpty()) {
            return;
        }
        n nVar = (n) n0Var.f2279a;
        int i10 = 0;
        if (!z8) {
            while (i10 < list.size()) {
                nVar.o(i9, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        nVar.r(i9, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Long) list.get(i12)).getClass();
            Logger logger = n.f2272e;
            i11 += 8;
        }
        nVar.s(i11);
        while (i10 < list.size()) {
            nVar.p(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static void L(int i9, List list, n0 n0Var, boolean z8) {
        if (list == null || list.isEmpty()) {
            return;
        }
        n nVar = (n) n0Var.f2279a;
        if (!z8) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                int intValue = ((Integer) list.get(i10)).intValue();
                nVar.r(i9, 0);
                nVar.s((intValue >> 31) ^ (intValue << 1));
            }
            return;
        }
        nVar.r(i9, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            int intValue2 = ((Integer) list.get(i12)).intValue();
            i11 += n.i((intValue2 >> 31) ^ (intValue2 << 1));
        }
        nVar.s(i11);
        for (int i13 = 0; i13 < list.size(); i13++) {
            int intValue3 = ((Integer) list.get(i13)).intValue();
            nVar.s((intValue3 >> 31) ^ (intValue3 << 1));
        }
    }

    public static void M(int i9, List list, n0 n0Var, boolean z8) {
        if (list == null || list.isEmpty()) {
            return;
        }
        n nVar = (n) n0Var.f2279a;
        int i10 = 0;
        if (!z8) {
            while (i10 < list.size()) {
                long longValue = ((Long) list.get(i10)).longValue();
                nVar.t(i9, (longValue >> 63) ^ (longValue << 1));
                i10++;
            }
            return;
        }
        nVar.r(i9, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            long longValue2 = ((Long) list.get(i12)).longValue();
            i11 += n.j((longValue2 >> 63) ^ (longValue2 << 1));
        }
        nVar.s(i11);
        while (i10 < list.size()) {
            long longValue3 = ((Long) list.get(i10)).longValue();
            nVar.u((longValue3 >> 63) ^ (longValue3 << 1));
            i10++;
        }
    }

    public static void N(int i9, List list, n0 n0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        n nVar = (n) n0Var.f2279a;
        if (!(list instanceof h0)) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                String str = (String) list.get(i10);
                nVar.r(i9, 2);
                int i11 = nVar.f2276c;
                byte[] bArr = nVar.f2275b;
                int i12 = nVar.f2277d;
                try {
                    int i13 = n.i(str.length() * 3);
                    int i14 = n.i(str.length());
                    if (i14 == i13) {
                        int i15 = i12 + i14;
                        nVar.f2277d = i15;
                        int r8 = s1.f2298a.r(str, bArr, i15, i11 - i15);
                        nVar.f2277d = i12;
                        nVar.s((r8 - i12) - i14);
                        nVar.f2277d = r8;
                    } else {
                        nVar.s(s1.b(str));
                        int i16 = nVar.f2277d;
                        nVar.f2277d = s1.f2298a.r(str, bArr, i16, i11 - i16);
                    }
                } catch (r1 e9) {
                    nVar.f2277d = i12;
                    n.f2272e.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e9);
                    byte[] bytes = str.getBytes(c0.f2207a);
                    try {
                        nVar.s(bytes.length);
                        nVar.l(bytes, 0, bytes.length);
                    } catch (IndexOutOfBoundsException e10) {
                        throw new b4.c(e10);
                    }
                } catch (IndexOutOfBoundsException e11) {
                    throw new b4.c(e11);
                }
            }
            return;
        }
        h0 h0Var = (h0) list;
        for (int i17 = 0; i17 < list.size(); i17++) {
            Object d9 = h0Var.d(i17);
            if (d9 instanceof String) {
                String str2 = (String) d9;
                nVar.r(i9, 2);
                int i18 = nVar.f2276c;
                byte[] bArr2 = nVar.f2275b;
                int i19 = nVar.f2277d;
                try {
                    int i20 = n.i(str2.length() * 3);
                    int i21 = n.i(str2.length());
                    if (i21 == i20) {
                        int i22 = i19 + i21;
                        nVar.f2277d = i22;
                        int r9 = s1.f2298a.r(str2, bArr2, i22, i18 - i22);
                        nVar.f2277d = i19;
                        nVar.s((r9 - i19) - i21);
                        nVar.f2277d = r9;
                    } else {
                        nVar.s(s1.b(str2));
                        int i23 = nVar.f2277d;
                        nVar.f2277d = s1.f2298a.r(str2, bArr2, i23, i18 - i23);
                    }
                } catch (r1 e12) {
                    nVar.f2277d = i19;
                    n.f2272e.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e12);
                    byte[] bytes2 = str2.getBytes(c0.f2207a);
                    try {
                        nVar.s(bytes2.length);
                        nVar.l(bytes2, 0, bytes2.length);
                    } catch (IndexOutOfBoundsException e13) {
                        throw new b4.c(e13);
                    }
                } catch (IndexOutOfBoundsException e14) {
                    throw new b4.c(e14);
                }
            } else {
                j jVar = (j) d9;
                nVar.r(i9, 2);
                nVar.s(jVar.size());
                i iVar = (i) jVar;
                nVar.l(iVar.f2245l, iVar.k(), iVar.size());
            }
        }
    }

    public static void O(int i9, List list, n0 n0Var, boolean z8) {
        if (list == null || list.isEmpty()) {
            return;
        }
        n nVar = (n) n0Var.f2279a;
        if (!z8) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                int intValue = ((Integer) list.get(i10)).intValue();
                nVar.r(i9, 0);
                nVar.s(intValue);
            }
            return;
        }
        nVar.r(i9, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            i11 += n.i(((Integer) list.get(i12)).intValue());
        }
        nVar.s(i11);
        for (int i13 = 0; i13 < list.size(); i13++) {
            nVar.s(((Integer) list.get(i13)).intValue());
        }
    }

    public static void P(int i9, List list, n0 n0Var, boolean z8) {
        if (list == null || list.isEmpty()) {
            return;
        }
        n nVar = (n) n0Var.f2279a;
        int i10 = 0;
        if (!z8) {
            while (i10 < list.size()) {
                nVar.t(i9, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        nVar.r(i9, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            i11 += n.j(((Long) list.get(i12)).longValue());
        }
        nVar.s(i11);
        while (i10 < list.size()) {
            nVar.u(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static int a(int i9, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int h = n.h(i9) * size;
        for (int i10 = 0; i10 < list.size(); i10++) {
            h += n.b((j) list.get(i10));
        }
        return h;
    }

    public static int b(int i9, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (n.h(i9) * size) + c(list);
    }

    public static int c(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof z) {
            z zVar = (z) list;
            if (size <= 0) {
                return 0;
            }
            zVar.h(0);
            throw null;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            i9 += n.f(((Integer) list.get(i10)).intValue());
        }
        return i9;
    }

    public static int d(int i9, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return n.c(i9) * size;
    }

    public static int e(List list) {
        return list.size() * 4;
    }

    public static int f(int i9, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return n.d(i9) * size;
    }

    public static int g(List list) {
        return list.size() * 8;
    }

    public static int h(int i9, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (n.h(i9) * size) + i(list);
    }

    public static int i(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof z) {
            z zVar = (z) list;
            if (size <= 0) {
                return 0;
            }
            zVar.h(0);
            throw null;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            i9 += n.f(((Integer) list.get(i10)).intValue());
        }
        return i9;
    }

    public static int j(int i9, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (n.h(i9) * list.size()) + k(list);
    }

    public static int k(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof l0) {
            l0 l0Var = (l0) list;
            if (size <= 0) {
                return 0;
            }
            l0Var.h(0);
            throw null;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            i9 += n.j(((Long) list.get(i10)).longValue());
        }
        return i9;
    }

    public static int l(int i9, List list, d1 d1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int h = n.h(i9) * size;
        for (int i10 = 0; i10 < size; i10++) {
            int b9 = ((a) list.get(i10)).b(d1Var);
            h += n.i(b9) + b9;
        }
        return h;
    }

    public static int m(int i9, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (n.h(i9) * size) + n(list);
    }

    public static int n(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof z) {
            z zVar = (z) list;
            if (size <= 0) {
                return 0;
            }
            zVar.h(0);
            throw null;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            int intValue = ((Integer) list.get(i10)).intValue();
            i9 += n.i((intValue >> 31) ^ (intValue << 1));
        }
        return i9;
    }

    public static int o(int i9, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (n.h(i9) * size) + p(list);
    }

    public static int p(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof l0) {
            l0 l0Var = (l0) list;
            if (size <= 0) {
                return 0;
            }
            l0Var.h(0);
            throw null;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            long longValue = ((Long) list.get(i10)).longValue();
            i9 += n.j((longValue >> 63) ^ (longValue << 1));
        }
        return i9;
    }

    public static int q(int i9, List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        int h = n.h(i9) * size;
        if (!(list instanceof h0)) {
            while (i10 < size) {
                Object obj = list.get(i10);
                if (obj instanceof j) {
                    int size2 = ((j) obj).size();
                    h = n.i(size2) + size2 + h;
                } else {
                    h = n.g((String) obj) + h;
                }
                i10++;
            }
            return h;
        }
        h0 h0Var = (h0) list;
        while (i10 < size) {
            Object d9 = h0Var.d(i10);
            if (d9 instanceof j) {
                int size3 = ((j) d9).size();
                h = n.i(size3) + size3 + h;
            } else {
                h = n.g((String) d9) + h;
            }
            i10++;
        }
        return h;
    }

    public static int r(int i9, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (n.h(i9) * size) + s(list);
    }

    public static int s(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof z) {
            z zVar = (z) list;
            if (size <= 0) {
                return 0;
            }
            zVar.h(0);
            throw null;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            i9 += n.i(((Integer) list.get(i10)).intValue());
        }
        return i9;
    }

    public static int t(int i9, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (n.h(i9) * size) + u(list);
    }

    public static int u(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof l0) {
            l0 l0Var = (l0) list;
            if (size <= 0) {
                return 0;
            }
            l0Var.h(0);
            throw null;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            i9 += n.j(((Long) list.get(i10)).longValue());
        }
        return i9;
    }

    public static h1 v(boolean z8) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.crypto.tink.shaded.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                return (h1) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z8));
            } catch (Throwable unused2) {
            }
        }
        return null;
    }

    public static void w(h1 h1Var, Object obj, Object obj2) {
        h1Var.getClass();
        y yVar = (y) obj;
        g1 g1Var = yVar.unknownFields;
        g1 g1Var2 = ((y) obj2).unknownFields;
        g1 g1Var3 = g1.f2237f;
        if (!g1Var3.equals(g1Var2)) {
            if (g1Var3.equals(g1Var)) {
                int i9 = g1Var.f2238a + g1Var2.f2238a;
                int[] copyOf = Arrays.copyOf(g1Var.f2239b, i9);
                System.arraycopy(g1Var2.f2239b, 0, copyOf, g1Var.f2238a, g1Var2.f2238a);
                Object[] copyOf2 = Arrays.copyOf(g1Var.f2240c, i9);
                System.arraycopy(g1Var2.f2240c, 0, copyOf2, g1Var.f2238a, g1Var2.f2238a);
                g1Var = new g1(i9, copyOf, copyOf2, true);
            } else {
                g1Var.getClass();
                if (!g1Var2.equals(g1Var3)) {
                    if (!g1Var.f2242e) {
                        androidx.fragment.app.a.p();
                        return;
                    }
                    int i10 = g1Var.f2238a + g1Var2.f2238a;
                    g1Var.a(i10);
                    System.arraycopy(g1Var2.f2239b, 0, g1Var.f2239b, g1Var.f2238a, g1Var2.f2238a);
                    System.arraycopy(g1Var2.f2240c, 0, g1Var.f2240c, g1Var.f2238a, g1Var2.f2238a);
                    g1Var.f2238a = i10;
                }
            }
        }
        yVar.unknownFields = g1Var;
    }

    public static boolean x(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void y(int i9, List list, n0 n0Var, boolean z8) {
        if (list == null || list.isEmpty()) {
            return;
        }
        n nVar = (n) n0Var.f2279a;
        if (!z8) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                boolean booleanValue = ((Boolean) list.get(i10)).booleanValue();
                nVar.r(i9, 0);
                nVar.k(booleanValue ? (byte) 1 : (byte) 0);
            }
            return;
        }
        nVar.r(i9, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Boolean) list.get(i12)).getClass();
            Logger logger = n.f2272e;
            i11++;
        }
        nVar.s(i11);
        for (int i13 = 0; i13 < list.size(); i13++) {
            nVar.k(((Boolean) list.get(i13)).booleanValue() ? (byte) 1 : (byte) 0);
        }
    }

    public static void z(int i9, List list, n0 n0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        n0Var.getClass();
        for (int i10 = 0; i10 < list.size(); i10++) {
            n nVar = (n) n0Var.f2279a;
            j jVar = (j) list.get(i10);
            nVar.r(i9, 2);
            nVar.s(jVar.size());
            i iVar = (i) jVar;
            nVar.l(iVar.f2245l, iVar.k(), iVar.size());
        }
    }
}
