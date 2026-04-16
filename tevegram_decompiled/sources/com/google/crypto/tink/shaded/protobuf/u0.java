package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import org.webrtc.EglBase;
import org.webrtc.PeerConnectionFactory;
import sun.misc.Unsafe;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u0 implements d1 {

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f2305o = new int[0];

    /* renamed from: p, reason: collision with root package name */
    public static final Unsafe f2306p = p1.j();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f2307a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f2308b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2309c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2310d;

    /* renamed from: e, reason: collision with root package name */
    public final a f2311e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f2312f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2313g;
    public final int[] h;

    /* renamed from: i, reason: collision with root package name */
    public final int f2314i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2315j;

    /* renamed from: k, reason: collision with root package name */
    public final w0 f2316k;

    /* renamed from: l, reason: collision with root package name */
    public final k0 f2317l;

    /* renamed from: m, reason: collision with root package name */
    public final h1 f2318m;

    /* renamed from: n, reason: collision with root package name */
    public final p0 f2319n;

    public u0(int[] iArr, Object[] objArr, int i9, int i10, a aVar, boolean z8, int[] iArr2, int i11, int i12, w0 w0Var, k0 k0Var, h1 h1Var, r rVar, p0 p0Var) {
        this.f2307a = iArr;
        this.f2308b = objArr;
        this.f2309c = i9;
        this.f2310d = i10;
        this.f2312f = aVar instanceof y;
        this.f2313g = z8;
        this.h = iArr2;
        this.f2314i = i11;
        this.f2315j = i12;
        this.f2316k = w0Var;
        this.f2317l = k0Var;
        this.f2318m = h1Var;
        this.f2311e = aVar;
        this.f2319n = p0Var;
    }

    public static u0 B(c1 c1Var, w0 w0Var, k0 k0Var, h1 h1Var, r rVar, p0 p0Var) {
        if (c1Var instanceof c1) {
            return C(c1Var, w0Var, k0Var, h1Var, rVar, p0Var);
        }
        c1Var.getClass();
        androidx.fragment.app.a.c();
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0277  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.crypto.tink.shaded.protobuf.u0 C(com.google.crypto.tink.shaded.protobuf.c1 r34, com.google.crypto.tink.shaded.protobuf.w0 r35, com.google.crypto.tink.shaded.protobuf.k0 r36, com.google.crypto.tink.shaded.protobuf.h1 r37, com.google.crypto.tink.shaded.protobuf.r r38, com.google.crypto.tink.shaded.protobuf.p0 r39) {
        /*
            Method dump skipped, instructions count: 998
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.u0.C(com.google.crypto.tink.shaded.protobuf.c1, com.google.crypto.tink.shaded.protobuf.w0, com.google.crypto.tink.shaded.protobuf.k0, com.google.crypto.tink.shaded.protobuf.h1, com.google.crypto.tink.shaded.protobuf.r, com.google.crypto.tink.shaded.protobuf.p0):com.google.crypto.tink.shaded.protobuf.u0");
    }

    public static long D(int i9) {
        return i9 & 1048575;
    }

    public static int E(long j5, Object obj) {
        return ((Integer) p1.f2286c.i(j5, obj)).intValue();
    }

    public static long F(long j5, Object obj) {
        return ((Long) p1.f2286c.i(j5, obj)).longValue();
    }

    public static Field P(String str, Class cls) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder r8 = androidx.activity.g.r("Field ", str, " for ");
            r8.append(cls.getName());
            r8.append(" not found. Known fields are ");
            r8.append(Arrays.toString(declaredFields));
            throw new RuntimeException(r8.toString());
        }
    }

    public static int V(int i9) {
        return (i9 & 267386880) >>> 20;
    }

    public static void Y(int i9, Object obj, n0 n0Var) {
        if (!(obj instanceof String)) {
            n0Var.a(i9, (j) obj);
            return;
        }
        String str = (String) obj;
        n nVar = (n) n0Var.f2279a;
        nVar.r(i9, 2);
        int i10 = nVar.f2276c;
        byte[] bArr = nVar.f2275b;
        int i11 = nVar.f2277d;
        try {
            int i12 = n.i(str.length() * 3);
            int i13 = n.i(str.length());
            if (i13 != i12) {
                nVar.s(s1.b(str));
                int i14 = nVar.f2277d;
                nVar.f2277d = s1.f2298a.r(str, bArr, i14, i10 - i14);
                return;
            }
            int i15 = i11 + i13;
            nVar.f2277d = i15;
            int r8 = s1.f2298a.r(str, bArr, i15, i10 - i15);
            nVar.f2277d = i11;
            nVar.s((r8 - i11) - i13);
            nVar.f2277d = r8;
        } catch (r1 e9) {
            nVar.f2277d = i11;
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

    public static void l(Object obj) {
        if (t(obj)) {
            return;
        }
        androidx.fragment.app.a.n(obj, "Mutating immutable message: ");
    }

    public static boolean t(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof y) {
            return ((y) obj).n();
        }
        return true;
    }

    public static List v(y yVar, long j5) {
        return (List) p1.f2286c.i(j5, yVar);
    }

    public final Object A(int i9, int i10, Object obj) {
        d1 p5 = p(i10);
        if (!u(i9, i10, obj)) {
            return p5.i();
        }
        Object object = f2306p.getObject(obj, W(i10) & 1048575);
        if (t(object)) {
            return object;
        }
        Object i11 = p5.i();
        if (object != null) {
            p5.b(i11, object);
        }
        return i11;
    }

    public final void G(int i9, long j5, Object obj) {
        Unsafe unsafe = f2306p;
        Object o8 = o(i9);
        Object object = unsafe.getObject(obj, j5);
        this.f2319n.getClass();
        if (!((o0) object).f2281i) {
            o0 c9 = o0.f2280j.c();
            p0.b(c9, object);
            unsafe.putObject(obj, j5, c9);
        }
        androidx.activity.g.w(o8);
        throw null;
    }

    public final int H(Object obj, byte[] bArr, int i9, int i10, int i11, int i12, int i13, int i14, int i15, long j5, int i16, d dVar) {
        int i17;
        Unsafe unsafe = f2306p;
        long j9 = this.f2307a[i16 + 2] & 1048575;
        switch (i15) {
            case 51:
                if (i13 != 1) {
                    return i9;
                }
                unsafe.putObject(obj, j5, Double.valueOf(Double.longBitsToDouble(com.bumptech.glide.d.p(bArr, i9))));
                int i18 = i9 + 8;
                unsafe.putInt(obj, j9, i12);
                return i18;
            case 52:
                if (i13 != 5) {
                    return i9;
                }
                unsafe.putObject(obj, j5, Float.valueOf(Float.intBitsToFloat(com.bumptech.glide.d.o(bArr, i9))));
                int i19 = i9 + 4;
                unsafe.putInt(obj, j9, i12);
                return i19;
            case 53:
            case 54:
                if (i13 != 0) {
                    return i9;
                }
                int x6 = com.bumptech.glide.d.x(bArr, i9, dVar);
                unsafe.putObject(obj, j5, Long.valueOf(dVar.f2214b));
                unsafe.putInt(obj, j9, i12);
                return x6;
            case 55:
            case 62:
                if (i13 != 0) {
                    return i9;
                }
                int v8 = com.bumptech.glide.d.v(bArr, i9, dVar);
                unsafe.putObject(obj, j5, Integer.valueOf(dVar.f2213a));
                unsafe.putInt(obj, j9, i12);
                return v8;
            case 56:
            case 65:
                if (i13 != 1) {
                    return i9;
                }
                unsafe.putObject(obj, j5, Long.valueOf(com.bumptech.glide.d.p(bArr, i9)));
                int i20 = i9 + 8;
                unsafe.putInt(obj, j9, i12);
                return i20;
            case 57:
            case EglBase.EGL_OPENGL_ES3_BIT /* 64 */:
                if (i13 != 5) {
                    return i9;
                }
                unsafe.putObject(obj, j5, Integer.valueOf(com.bumptech.glide.d.o(bArr, i9)));
                int i21 = i9 + 4;
                unsafe.putInt(obj, j9, i12);
                return i21;
            case 58:
                if (i13 != 0) {
                    return i9;
                }
                int x8 = com.bumptech.glide.d.x(bArr, i9, dVar);
                unsafe.putObject(obj, j5, Boolean.valueOf(dVar.f2214b != 0));
                unsafe.putInt(obj, j9, i12);
                return x8;
            case 59:
                if (i13 != 2) {
                    return i9;
                }
                int v9 = com.bumptech.glide.d.v(bArr, i9, dVar);
                int i22 = dVar.f2213a;
                if (i22 == 0) {
                    unsafe.putObject(obj, j5, "");
                } else {
                    if ((i14 & 536870912) != 0) {
                        if (!s1.f2298a.G(v9, v9 + i22, bArr)) {
                            throw e0.b();
                        }
                    }
                    unsafe.putObject(obj, j5, new String(bArr, v9, i22, c0.f2207a));
                    v9 += i22;
                }
                unsafe.putInt(obj, j9, i12);
                return v9;
            case 60:
                i17 = i9;
                if (i13 == 2) {
                    Object A = A(i12, i16, obj);
                    int N = com.bumptech.glide.d.N(A, p(i16), bArr, i17, i10, dVar);
                    U(i12, i16, obj, A);
                    return N;
                }
                break;
            case 61:
                i17 = i9;
                if (i13 == 2) {
                    int n4 = com.bumptech.glide.d.n(bArr, i17, dVar);
                    unsafe.putObject(obj, j5, dVar.f2215c);
                    unsafe.putInt(obj, j9, i12);
                    return n4;
                }
                break;
            case 63:
                i17 = i9;
                if (i13 == 0) {
                    int v10 = com.bumptech.glide.d.v(bArr, i17, dVar);
                    int i23 = dVar.f2213a;
                    n(i16);
                    unsafe.putObject(obj, j5, Integer.valueOf(i23));
                    unsafe.putInt(obj, j9, i12);
                    return v10;
                }
                break;
            case IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
                i17 = i9;
                if (i13 == 0) {
                    int v11 = com.bumptech.glide.d.v(bArr, i17, dVar);
                    unsafe.putObject(obj, j5, Integer.valueOf(m.d(dVar.f2213a)));
                    unsafe.putInt(obj, j9, i12);
                    return v11;
                }
                break;
            case 67:
                i17 = i9;
                if (i13 == 0) {
                    int x9 = com.bumptech.glide.d.x(bArr, i17, dVar);
                    unsafe.putObject(obj, j5, Long.valueOf(m.e(dVar.f2214b)));
                    unsafe.putInt(obj, j9, i12);
                    return x9;
                }
                break;
            case 68:
                if (i13 == 3) {
                    Object A2 = A(i12, i16, obj);
                    int I = ((u0) p(i16)).I(A2, bArr, i9, i10, (i11 & (-8)) | 4, dVar);
                    dVar.f2215c = A2;
                    U(i12, i16, obj, A2);
                    return I;
                }
            default:
                return i9;
        }
        return i17;
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0145, code lost:
    
        r4 = r9;
        r9 = r25 | r23;
        r3 = r7;
        r7 = r13;
        r13 = r4;
        r4 = r33;
        r5 = r2;
        r2 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x025c, code lost:
    
        r4 = r9;
        r9 = r25 | r23;
        r3 = r4;
        r4 = r13;
        r13 = r7;
        r7 = r4;
        r4 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x046d, code lost:
    
        if (r8 == 1048575) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x046f, code lost:
    
        r15.putInt(r10, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0473, code lost:
    
        r0 = r6.f2314i;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0477, code lost:
    
        if (r0 >= r6.f2315j) goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0479, code lost:
    
        r6.m(r10, r6.h[r0], r32);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0485, code lost:
    
        if (r34 != 0) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0487, code lost:
    
        if (r5 != r4) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x048e, code lost:
    
        throw com.google.crypto.tink.shaded.protobuf.e0.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0493, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x048f, code lost:
    
        if (r5 > r4) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0491, code lost:
    
        if (r12 != r34) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0498, code lost:
    
        throw com.google.crypto.tink.shaded.protobuf.e0.f();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int I(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, com.google.crypto.tink.shaded.protobuf.d r35) {
        /*
            Method dump skipped, instructions count: 1218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.u0.I(java.lang.Object, byte[], int, int, int, com.google.crypto.tink.shaded.protobuf.d):int");
    }

    public final void J(Object obj, byte[] bArr, int i9, int i10, d dVar) {
        int S;
        Object obj2;
        int i11;
        Unsafe unsafe;
        int i12;
        int i13;
        int i14;
        int i15;
        Unsafe unsafe2;
        Object obj3;
        byte[] bArr2;
        int i16;
        byte[] bArr3;
        Object obj4;
        byte[] bArr4;
        Unsafe unsafe3;
        int i17;
        Object obj5;
        Object obj6;
        int i18;
        int i19;
        int i20;
        u0 u0Var = this;
        Object obj7 = obj;
        byte[] bArr5 = bArr;
        int i21 = i10;
        d dVar2 = dVar;
        l(obj7);
        Unsafe unsafe4 = f2306p;
        int i22 = i9;
        int i23 = -1;
        int i24 = 0;
        int i25 = 1048575;
        int i26 = 0;
        while (i22 < i21) {
            int i27 = i22 + 1;
            int i28 = bArr5[i22];
            if (i28 < 0) {
                i27 = com.bumptech.glide.d.u(i28, bArr5, i27, dVar2);
                i28 = dVar2.f2213a;
            }
            int i29 = i28 >>> 3;
            int i30 = i28 & 7;
            int i31 = u0Var.f2310d;
            int i32 = u0Var.f2309c;
            if (i29 > i23) {
                S = (i29 < i32 || i29 > i31) ? -1 : u0Var.S(i29, i24 / 3);
            } else {
                S = (i29 < i32 || i29 > i31) ? -1 : u0Var.S(i29, 0);
            }
            int i33 = S;
            if (i33 == -1) {
                int i34 = i27;
                obj2 = obj7;
                i11 = i34;
                unsafe = unsafe4;
                i12 = i28;
                i13 = i29;
                i14 = 0;
            } else {
                int[] iArr = u0Var.f2307a;
                int i35 = iArr[i33 + 1];
                int V = V(i35);
                int i36 = i28;
                long j5 = i35 & 1048575;
                if (V <= 17) {
                    int i37 = iArr[i33 + 2];
                    int i38 = 1 << (i37 >>> 20);
                    int i39 = i37 & 1048575;
                    if (i39 != i25) {
                        int i40 = 1048575;
                        i15 = i35;
                        if (i25 != 1048575) {
                            unsafe4.putInt(obj7, i25, i26);
                            i40 = 1048575;
                        }
                        if (i39 != i40) {
                            i26 = unsafe4.getInt(obj7, i39);
                        }
                        i25 = i39;
                    } else {
                        i15 = i35;
                    }
                    switch (V) {
                        case 0:
                            unsafe2 = unsafe4;
                            bArr2 = bArr5;
                            i16 = i27;
                            if (i30 != 1) {
                                obj3 = obj7;
                                i12 = i36;
                                obj2 = obj3;
                                i11 = i16;
                                i13 = i29;
                                unsafe = unsafe2;
                                i14 = i33;
                                break;
                            } else {
                                p1.f2286c.m(obj7, j5, Double.longBitsToDouble(com.bumptech.glide.d.p(bArr2, i16)));
                                i22 = i16 + 8;
                                i26 |= i38;
                                bArr5 = bArr2;
                                i24 = i33;
                                i23 = i29;
                                unsafe4 = unsafe2;
                                i21 = i10;
                                break;
                            }
                        case 1:
                            unsafe2 = unsafe4;
                            bArr2 = bArr5;
                            i16 = i27;
                            if (i30 != 5) {
                                obj3 = obj7;
                                i12 = i36;
                                obj2 = obj3;
                                i11 = i16;
                                i13 = i29;
                                unsafe = unsafe2;
                                i14 = i33;
                                break;
                            } else {
                                p1.f2286c.n(obj7, j5, Float.intBitsToFloat(com.bumptech.glide.d.o(bArr2, i16)));
                                i22 = i16 + 4;
                                i26 |= i38;
                                bArr5 = bArr2;
                                i24 = i33;
                                i23 = i29;
                                unsafe4 = unsafe2;
                                i21 = i10;
                                break;
                            }
                        case 2:
                        case 3:
                            bArr3 = bArr5;
                            i16 = i27;
                            if (i30 != 0) {
                                unsafe2 = unsafe4;
                                obj3 = obj7;
                                i12 = i36;
                                obj2 = obj3;
                                i11 = i16;
                                i13 = i29;
                                unsafe = unsafe2;
                                i14 = i33;
                                break;
                            } else {
                                int x6 = com.bumptech.glide.d.x(bArr3, i16, dVar2);
                                unsafe4.putLong(obj7, j5, dVar2.f2214b);
                                i26 |= i38;
                                i22 = x6;
                                bArr5 = bArr3;
                                i24 = i33;
                                i23 = i29;
                                i21 = i10;
                                break;
                            }
                        case 4:
                        case 11:
                            bArr3 = bArr5;
                            i16 = i27;
                            if (i30 != 0) {
                                unsafe2 = unsafe4;
                                obj3 = obj7;
                                i12 = i36;
                                obj2 = obj3;
                                i11 = i16;
                                i13 = i29;
                                unsafe = unsafe2;
                                i14 = i33;
                                break;
                            } else {
                                int v8 = com.bumptech.glide.d.v(bArr3, i16, dVar2);
                                unsafe4.putInt(obj7, j5, dVar2.f2213a);
                                i26 |= i38;
                                i22 = v8;
                                bArr5 = bArr3;
                                i24 = i33;
                                i23 = i29;
                                i21 = i10;
                                break;
                            }
                        case 5:
                        case 14:
                            Object obj8 = obj7;
                            bArr3 = bArr5;
                            Unsafe unsafe5 = unsafe4;
                            int i41 = i27;
                            if (i30 != 1) {
                                i16 = i41;
                                unsafe2 = unsafe5;
                                obj3 = obj8;
                                i12 = i36;
                                obj2 = obj3;
                                i11 = i16;
                                i13 = i29;
                                unsafe = unsafe2;
                                i14 = i33;
                                break;
                            } else {
                                long p5 = com.bumptech.glide.d.p(bArr3, i41);
                                unsafe4 = unsafe5;
                                obj7 = obj8;
                                unsafe4.putLong(obj7, j5, p5);
                                i22 = i41 + 8;
                                i26 |= i38;
                                bArr5 = bArr3;
                                i24 = i33;
                                i23 = i29;
                                i21 = i10;
                                break;
                            }
                        case 6:
                        case 13:
                            obj4 = obj7;
                            bArr4 = bArr5;
                            unsafe3 = unsafe4;
                            i17 = i27;
                            if (i30 != 5) {
                                Unsafe unsafe6 = unsafe3;
                                i16 = i17;
                                obj3 = obj4;
                                unsafe2 = unsafe6;
                                i12 = i36;
                                obj2 = obj3;
                                i11 = i16;
                                i13 = i29;
                                unsafe = unsafe2;
                                i14 = i33;
                                break;
                            } else {
                                unsafe3.putInt(obj4, j5, com.bumptech.glide.d.o(bArr4, i17));
                                i22 = i17 + 4;
                                i26 |= i38;
                                unsafe4 = unsafe3;
                                bArr5 = bArr4;
                                i24 = i33;
                                i23 = i29;
                                obj7 = obj4;
                                i21 = i10;
                                break;
                            }
                        case 7:
                            obj4 = obj7;
                            bArr4 = bArr5;
                            unsafe3 = unsafe4;
                            i17 = i27;
                            if (i30 != 0) {
                                Unsafe unsafe62 = unsafe3;
                                i16 = i17;
                                obj3 = obj4;
                                unsafe2 = unsafe62;
                                i12 = i36;
                                obj2 = obj3;
                                i11 = i16;
                                i13 = i29;
                                unsafe = unsafe2;
                                i14 = i33;
                                break;
                            } else {
                                i22 = com.bumptech.glide.d.x(bArr4, i17, dVar2);
                                p1.f2286c.k(obj4, j5, dVar2.f2214b != 0);
                                i26 |= i38;
                                unsafe4 = unsafe3;
                                bArr5 = bArr4;
                                i24 = i33;
                                i23 = i29;
                                obj7 = obj4;
                                i21 = i10;
                                break;
                            }
                        case 8:
                            obj4 = obj7;
                            bArr4 = bArr5;
                            unsafe3 = unsafe4;
                            i17 = i27;
                            if (i30 != 2) {
                                Unsafe unsafe622 = unsafe3;
                                i16 = i17;
                                obj3 = obj4;
                                unsafe2 = unsafe622;
                                i12 = i36;
                                obj2 = obj3;
                                i11 = i16;
                                i13 = i29;
                                unsafe = unsafe2;
                                i14 = i33;
                                break;
                            } else {
                                i22 = (i15 & 536870912) == 0 ? com.bumptech.glide.d.r(bArr4, i17, dVar2) : com.bumptech.glide.d.s(bArr4, i17, dVar2);
                                unsafe3.putObject(obj4, j5, dVar2.f2215c);
                                i26 |= i38;
                                unsafe4 = unsafe3;
                                bArr5 = bArr4;
                                i24 = i33;
                                i23 = i29;
                                obj7 = obj4;
                                i21 = i10;
                                break;
                            }
                        case 9:
                            obj4 = obj7;
                            if (i30 != 2) {
                                Unsafe unsafe7 = unsafe4;
                                obj3 = obj4;
                                unsafe2 = unsafe7;
                                i16 = i27;
                                i12 = i36;
                                obj2 = obj3;
                                i11 = i16;
                                i13 = i29;
                                unsafe = unsafe2;
                                i14 = i33;
                                break;
                            } else {
                                Unsafe unsafe8 = unsafe4;
                                Object z8 = u0Var.z(i33, obj4);
                                byte[] bArr6 = bArr5;
                                unsafe3 = unsafe8;
                                int N = com.bumptech.glide.d.N(z8, u0Var.p(i33), bArr6, i27, i21, dVar2);
                                bArr4 = bArr6;
                                u0Var.T(obj4, i33, z8);
                                i26 |= i38;
                                i22 = N;
                                unsafe4 = unsafe3;
                                bArr5 = bArr4;
                                i24 = i33;
                                i23 = i29;
                                obj7 = obj4;
                                i21 = i10;
                                break;
                            }
                        case 10:
                            obj5 = obj7;
                            if (i30 != 2) {
                                Object obj9 = obj5;
                                unsafe2 = unsafe4;
                                obj3 = obj9;
                                i16 = i27;
                                i12 = i36;
                                obj2 = obj3;
                                i11 = i16;
                                i13 = i29;
                                unsafe = unsafe2;
                                i14 = i33;
                                break;
                            } else {
                                i22 = com.bumptech.glide.d.n(bArr5, i27, dVar2);
                                unsafe4.putObject(obj5, j5, dVar2.f2215c);
                                i26 |= i38;
                                i24 = i33;
                                i23 = i29;
                                obj7 = obj5;
                                break;
                            }
                        case 12:
                            obj5 = obj7;
                            if (i30 != 0) {
                                Object obj92 = obj5;
                                unsafe2 = unsafe4;
                                obj3 = obj92;
                                i16 = i27;
                                i12 = i36;
                                obj2 = obj3;
                                i11 = i16;
                                i13 = i29;
                                unsafe = unsafe2;
                                i14 = i33;
                                break;
                            } else {
                                i22 = com.bumptech.glide.d.v(bArr5, i27, dVar2);
                                unsafe4.putInt(obj5, j5, dVar2.f2213a);
                                i26 |= i38;
                                i24 = i33;
                                i23 = i29;
                                obj7 = obj5;
                                break;
                            }
                        case 15:
                            obj5 = obj7;
                            if (i30 != 0) {
                                Object obj922 = obj5;
                                unsafe2 = unsafe4;
                                obj3 = obj922;
                                i16 = i27;
                                i12 = i36;
                                obj2 = obj3;
                                i11 = i16;
                                i13 = i29;
                                unsafe = unsafe2;
                                i14 = i33;
                                break;
                            } else {
                                i22 = com.bumptech.glide.d.v(bArr5, i27, dVar2);
                                unsafe4.putInt(obj5, j5, m.d(dVar2.f2213a));
                                i26 |= i38;
                                i24 = i33;
                                i23 = i29;
                                obj7 = obj5;
                                break;
                            }
                        case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                            if (i30 != 0) {
                                unsafe2 = unsafe4;
                                obj3 = obj7;
                                i16 = i27;
                                i12 = i36;
                                obj2 = obj3;
                                i11 = i16;
                                i13 = i29;
                                unsafe = unsafe2;
                                i14 = i33;
                                break;
                            } else {
                                int x8 = com.bumptech.glide.d.x(bArr5, i27, dVar2);
                                unsafe4.putLong(obj7, j5, m.e(dVar2.f2214b));
                                i26 |= i38;
                                i24 = i33;
                                i23 = i29;
                                i22 = x8;
                                break;
                            }
                        default:
                            unsafe2 = unsafe4;
                            obj3 = obj7;
                            i16 = i27;
                            i12 = i36;
                            obj2 = obj3;
                            i11 = i16;
                            i13 = i29;
                            unsafe = unsafe2;
                            i14 = i33;
                            break;
                    }
                } else {
                    Object obj10 = obj7;
                    Unsafe unsafe9 = unsafe4;
                    byte[] bArr7 = bArr5;
                    int i42 = i27;
                    if (V != 27) {
                        i12 = i36;
                        i18 = i42;
                        if (V <= 49) {
                            unsafe = unsafe9;
                            i13 = i29;
                            int i43 = i25;
                            int i44 = i26;
                            int K = u0Var.K(obj, bArr, i18, i10, i12, i30, i33, i35, V, j5, dVar);
                            i14 = i33;
                            if (K != i18) {
                                bArr5 = bArr;
                                i21 = i10;
                                dVar2 = dVar;
                                obj7 = obj;
                                i22 = K;
                                i24 = i14;
                                i25 = i43;
                                i26 = i44;
                                i23 = i13;
                                unsafe4 = unsafe;
                            } else {
                                i11 = K;
                                i25 = i43;
                                i26 = i44;
                                obj2 = obj;
                            }
                        } else {
                            unsafe = unsafe9;
                            i13 = i29;
                            i14 = i33;
                            i19 = i25;
                            obj6 = obj;
                            i20 = i26;
                            if (V != 50) {
                                int H = u0Var.H(obj6, bArr, i18, i10, i12, i13, i30, i35, V, j5, i14, dVar);
                                obj2 = obj6;
                                if (H != i18) {
                                    u0Var = this;
                                    i21 = i10;
                                    dVar2 = dVar;
                                    obj7 = obj2;
                                    i22 = H;
                                    i24 = i14;
                                    i25 = i19;
                                    i26 = i20;
                                    i23 = i13;
                                    unsafe4 = unsafe;
                                    bArr5 = bArr;
                                } else {
                                    i11 = H;
                                    i25 = i19;
                                    i26 = i20;
                                }
                            } else if (i30 == 2) {
                                u0Var.G(i14, j5, obj6);
                                throw null;
                            }
                        }
                    } else if (i30 == 2) {
                        b0 b0Var = (b0) unsafe9.getObject(obj10, j5);
                        if (!((b) b0Var).f2201i) {
                            int size = b0Var.size();
                            b0Var = b0Var.a(size == 0 ? 10 : size * 2);
                            unsafe9.putObject(obj10, j5, b0Var);
                        }
                        int q4 = com.bumptech.glide.d.q(u0Var.p(i33), i36, bArr7, i42, i10, b0Var, dVar2);
                        obj7 = obj;
                        bArr5 = bArr;
                        dVar2 = dVar;
                        i22 = q4;
                        unsafe4 = unsafe9;
                        i24 = i33;
                        i23 = i29;
                        i21 = i10;
                    } else {
                        obj6 = obj;
                        i12 = i36;
                        unsafe = unsafe9;
                        i18 = i42;
                        i19 = i25;
                        i20 = i26;
                        i13 = i29;
                        i14 = i33;
                    }
                    i11 = i18;
                    obj2 = obj6;
                    i25 = i19;
                    i26 = i20;
                }
            }
            y yVar = (y) obj2;
            g1 g1Var = yVar.unknownFields;
            if (g1Var == g1.f2237f) {
                g1Var = g1.c();
                yVar.unknownFields = g1Var;
            }
            int t8 = com.bumptech.glide.d.t(i12, bArr, i11, i10, g1Var, dVar);
            bArr5 = bArr;
            dVar2 = dVar;
            i21 = i10;
            obj7 = obj2;
            i24 = i14;
            i23 = i13;
            unsafe4 = unsafe;
            i22 = t8;
            u0Var = this;
        }
        Unsafe unsafe10 = unsafe4;
        Object obj11 = obj7;
        int i45 = i21;
        int i46 = i25;
        int i47 = i26;
        if (i46 != 1048575) {
            unsafe10.putInt(obj11, i46, i47);
        }
        if (i22 != i45) {
            throw e0.f();
        }
    }

    public final int K(Object obj, byte[] bArr, int i9, int i10, int i11, int i12, int i13, long j5, int i14, long j9, d dVar) {
        int i15;
        int i16;
        int i17;
        int i18;
        int w8;
        Unsafe unsafe = f2306p;
        b0 b0Var = (b0) unsafe.getObject(obj, j9);
        if (!((b) b0Var).f2201i) {
            int size = b0Var.size();
            b0Var = b0Var.a(size == 0 ? 10 : size * 2);
            unsafe.putObject(obj, j9, b0Var);
        }
        b0 b0Var2 = b0Var;
        switch (i14) {
            case 18:
            case 35:
                int i19 = i9;
                if (i12 == 2) {
                    o oVar = (o) b0Var2;
                    int v8 = com.bumptech.glide.d.v(bArr, i19, dVar);
                    int i20 = dVar.f2213a + v8;
                    while (v8 < i20) {
                        oVar.g(Double.longBitsToDouble(com.bumptech.glide.d.p(bArr, v8)));
                        v8 += 8;
                    }
                    if (v8 == i20) {
                        return v8;
                    }
                    throw e0.g();
                }
                if (i12 != 1) {
                    return i19;
                }
                o oVar2 = (o) b0Var2;
                oVar2.g(Double.longBitsToDouble(com.bumptech.glide.d.p(bArr, i9)));
                while (true) {
                    i15 = i19 + 8;
                    if (i15 < i10) {
                        i19 = com.bumptech.glide.d.v(bArr, i15, dVar);
                        if (i11 == dVar.f2213a) {
                            oVar2.g(Double.longBitsToDouble(com.bumptech.glide.d.p(bArr, i19)));
                        }
                    }
                }
                return i15;
            case 19:
            case 36:
                int i21 = i9;
                if (i12 == 2) {
                    u uVar = (u) b0Var2;
                    int v9 = com.bumptech.glide.d.v(bArr, i21, dVar);
                    int i22 = dVar.f2213a + v9;
                    while (v9 < i22) {
                        uVar.g(Float.intBitsToFloat(com.bumptech.glide.d.o(bArr, v9)));
                        v9 += 4;
                    }
                    if (v9 == i22) {
                        return v9;
                    }
                    throw e0.g();
                }
                if (i12 != 5) {
                    return i21;
                }
                u uVar2 = (u) b0Var2;
                uVar2.g(Float.intBitsToFloat(com.bumptech.glide.d.o(bArr, i9)));
                while (true) {
                    i16 = i21 + 4;
                    if (i16 < i10) {
                        i21 = com.bumptech.glide.d.v(bArr, i16, dVar);
                        if (i11 == dVar.f2213a) {
                            uVar2.g(Float.intBitsToFloat(com.bumptech.glide.d.o(bArr, i21)));
                        }
                    }
                }
                return i16;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i12 == 2) {
                    l0 l0Var = (l0) b0Var2;
                    int v10 = com.bumptech.glide.d.v(bArr, i9, dVar);
                    int i23 = dVar.f2213a + v10;
                    while (v10 < i23) {
                        v10 = com.bumptech.glide.d.x(bArr, v10, dVar);
                        l0Var.g(dVar.f2214b);
                    }
                    if (v10 == i23) {
                        return v10;
                    }
                    throw e0.g();
                }
                if (i12 != 0) {
                    return i9;
                }
                l0 l0Var2 = (l0) b0Var2;
                int x6 = com.bumptech.glide.d.x(bArr, i9, dVar);
                l0Var2.g(dVar.f2214b);
                while (x6 < i10) {
                    int v11 = com.bumptech.glide.d.v(bArr, x6, dVar);
                    if (i11 != dVar.f2213a) {
                        return x6;
                    }
                    x6 = com.bumptech.glide.d.x(bArr, v11, dVar);
                    l0Var2.g(dVar.f2214b);
                }
                return x6;
            case 22:
            case 29:
            case 39:
            case 43:
                i17 = i9;
                if (i12 != 2) {
                    if (i12 == 0) {
                        return com.bumptech.glide.d.w(i11, bArr, i17, i10, b0Var2, dVar);
                    }
                    return i17;
                }
                z zVar = (z) b0Var2;
                int v12 = com.bumptech.glide.d.v(bArr, i17, dVar);
                int i24 = dVar.f2213a + v12;
                while (v12 < i24) {
                    v12 = com.bumptech.glide.d.v(bArr, v12, dVar);
                    zVar.g(dVar.f2213a);
                }
                if (v12 == i24) {
                    return v12;
                }
                throw e0.g();
            case 23:
            case PeerConnectionFactory.Options.ADAPTER_TYPE_ANY /* 32 */:
            case 40:
            case 46:
                i17 = i9;
                if (i12 == 2) {
                    l0 l0Var3 = (l0) b0Var2;
                    int v13 = com.bumptech.glide.d.v(bArr, i17, dVar);
                    int i25 = dVar.f2213a + v13;
                    while (v13 < i25) {
                        l0Var3.g(com.bumptech.glide.d.p(bArr, v13));
                        v13 += 8;
                    }
                    if (v13 == i25) {
                        return v13;
                    }
                    throw e0.g();
                }
                if (i12 == 1) {
                    l0 l0Var4 = (l0) b0Var2;
                    l0Var4.g(com.bumptech.glide.d.p(bArr, i9));
                    int i26 = i17 + 8;
                    while (i26 < i10) {
                        int v14 = com.bumptech.glide.d.v(bArr, i26, dVar);
                        if (i11 != dVar.f2213a) {
                            return i26;
                        }
                        l0Var4.g(com.bumptech.glide.d.p(bArr, v14));
                        i26 = v14 + 8;
                    }
                    return i26;
                }
                return i17;
            case 24:
            case 31:
            case 41:
            case 45:
                i17 = i9;
                if (i12 == 2) {
                    z zVar2 = (z) b0Var2;
                    int v15 = com.bumptech.glide.d.v(bArr, i17, dVar);
                    int i27 = dVar.f2213a + v15;
                    while (v15 < i27) {
                        zVar2.g(com.bumptech.glide.d.o(bArr, v15));
                        v15 += 4;
                    }
                    if (v15 == i27) {
                        return v15;
                    }
                    throw e0.g();
                }
                if (i12 == 5) {
                    z zVar3 = (z) b0Var2;
                    zVar3.g(com.bumptech.glide.d.o(bArr, i9));
                    int i28 = i17 + 4;
                    while (i28 < i10) {
                        int v16 = com.bumptech.glide.d.v(bArr, i28, dVar);
                        if (i11 != dVar.f2213a) {
                            return i28;
                        }
                        zVar3.g(com.bumptech.glide.d.o(bArr, v16));
                        i28 = v16 + 4;
                    }
                    return i28;
                }
                return i17;
            case 25:
            case 42:
                i17 = i9;
                if (i12 == 2) {
                    e eVar = (e) b0Var2;
                    int v17 = com.bumptech.glide.d.v(bArr, i17, dVar);
                    int i29 = dVar.f2213a + v17;
                    while (v17 < i29) {
                        v17 = com.bumptech.glide.d.x(bArr, v17, dVar);
                        eVar.g(dVar.f2214b != 0);
                    }
                    if (v17 == i29) {
                        return v17;
                    }
                    throw e0.g();
                }
                if (i12 == 0) {
                    e eVar2 = (e) b0Var2;
                    int x8 = com.bumptech.glide.d.x(bArr, i17, dVar);
                    eVar2.g(dVar.f2214b != 0);
                    while (x8 < i10) {
                        int v18 = com.bumptech.glide.d.v(bArr, x8, dVar);
                        if (i11 != dVar.f2213a) {
                            return x8;
                        }
                        x8 = com.bumptech.glide.d.x(bArr, v18, dVar);
                        eVar2.g(dVar.f2214b != 0);
                    }
                    return x8;
                }
                return i17;
            case 26:
                i17 = i9;
                if (i12 == 2) {
                    if ((j5 & IjkMediaMeta.AV_CH_STEREO_LEFT) == 0) {
                        int v19 = com.bumptech.glide.d.v(bArr, i17, dVar);
                        int i30 = dVar.f2213a;
                        if (i30 < 0) {
                            throw e0.e();
                        }
                        if (i30 == 0) {
                            b0Var2.add("");
                        } else {
                            b0Var2.add(new String(bArr, v19, i30, c0.f2207a));
                            v19 += i30;
                        }
                        while (v19 < i10) {
                            int v20 = com.bumptech.glide.d.v(bArr, v19, dVar);
                            if (i11 != dVar.f2213a) {
                                return v19;
                            }
                            v19 = com.bumptech.glide.d.v(bArr, v20, dVar);
                            int i31 = dVar.f2213a;
                            if (i31 < 0) {
                                throw e0.e();
                            }
                            if (i31 == 0) {
                                b0Var2.add("");
                            } else {
                                b0Var2.add(new String(bArr, v19, i31, c0.f2207a));
                                v19 += i31;
                            }
                        }
                        return v19;
                    }
                    int v21 = com.bumptech.glide.d.v(bArr, i17, dVar);
                    int i32 = dVar.f2213a;
                    if (i32 < 0) {
                        throw e0.e();
                    }
                    if (i32 == 0) {
                        b0Var2.add("");
                    } else {
                        int i33 = v21 + i32;
                        if (!s1.f2298a.G(v21, i33, bArr)) {
                            throw e0.b();
                        }
                        b0Var2.add(new String(bArr, v21, i32, c0.f2207a));
                        v21 = i33;
                    }
                    while (v21 < i10) {
                        int v22 = com.bumptech.glide.d.v(bArr, v21, dVar);
                        if (i11 != dVar.f2213a) {
                            return v21;
                        }
                        v21 = com.bumptech.glide.d.v(bArr, v22, dVar);
                        int i34 = dVar.f2213a;
                        if (i34 < 0) {
                            throw e0.e();
                        }
                        if (i34 == 0) {
                            b0Var2.add("");
                        } else {
                            int i35 = v21 + i34;
                            if (!s1.f2298a.G(v21, i35, bArr)) {
                                throw e0.b();
                            }
                            b0Var2.add(new String(bArr, v21, i34, c0.f2207a));
                            v21 = i35;
                        }
                    }
                    return v21;
                }
                return i17;
            case 27:
                return i12 == 2 ? com.bumptech.glide.d.q(p(i13), i11, bArr, i9, i10, b0Var2, dVar) : i9;
            case 28:
                if (i12 != 2) {
                    return i9;
                }
                int v23 = com.bumptech.glide.d.v(bArr, i9, dVar);
                int i36 = dVar.f2213a;
                if (i36 < 0) {
                    throw e0.e();
                }
                if (i36 > bArr.length - v23) {
                    throw e0.g();
                }
                if (i36 == 0) {
                    b0Var2.add(j.f2248j);
                } else {
                    b0Var2.add(j.h(v23, i36, bArr));
                    v23 += i36;
                }
                while (v23 < i10) {
                    int v24 = com.bumptech.glide.d.v(bArr, v23, dVar);
                    if (i11 != dVar.f2213a) {
                        return v23;
                    }
                    v23 = com.bumptech.glide.d.v(bArr, v24, dVar);
                    int i37 = dVar.f2213a;
                    if (i37 < 0) {
                        throw e0.e();
                    }
                    if (i37 > bArr.length - v23) {
                        throw e0.g();
                    }
                    if (i37 == 0) {
                        b0Var2.add(j.f2248j);
                    } else {
                        b0Var2.add(j.h(v23, i37, bArr));
                        v23 += i37;
                    }
                }
                return v23;
            case 30:
            case IjkMediaMeta.FF_PROFILE_H264_CAVLC_444 /* 44 */:
                i18 = i9;
                if (i12 != 2) {
                    if (i12 == 0) {
                        w8 = com.bumptech.glide.d.w(i11, bArr, i18, i10, b0Var2, dVar);
                    }
                    return i18;
                }
                z zVar4 = (z) b0Var2;
                w8 = com.bumptech.glide.d.v(bArr, i18, dVar);
                int i38 = dVar.f2213a + w8;
                while (w8 < i38) {
                    w8 = com.bumptech.glide.d.v(bArr, w8, dVar);
                    zVar4.g(dVar.f2213a);
                }
                if (w8 != i38) {
                    throw e0.g();
                }
                n(i13);
                Class cls = e1.f2217a;
                return w8;
            case 33:
            case 47:
                i18 = i9;
                if (i12 == 2) {
                    z zVar5 = (z) b0Var2;
                    int v25 = com.bumptech.glide.d.v(bArr, i18, dVar);
                    int i39 = dVar.f2213a + v25;
                    while (v25 < i39) {
                        v25 = com.bumptech.glide.d.v(bArr, v25, dVar);
                        zVar5.g(m.d(dVar.f2213a));
                    }
                    if (v25 == i39) {
                        return v25;
                    }
                    throw e0.g();
                }
                if (i12 == 0) {
                    z zVar6 = (z) b0Var2;
                    int v26 = com.bumptech.glide.d.v(bArr, i18, dVar);
                    zVar6.g(m.d(dVar.f2213a));
                    while (v26 < i10) {
                        int v27 = com.bumptech.glide.d.v(bArr, v26, dVar);
                        if (i11 != dVar.f2213a) {
                            return v26;
                        }
                        v26 = com.bumptech.glide.d.v(bArr, v27, dVar);
                        zVar6.g(m.d(dVar.f2213a));
                    }
                    return v26;
                }
                return i18;
            case 34:
            case 48:
                i18 = i9;
                if (i12 == 2) {
                    l0 l0Var5 = (l0) b0Var2;
                    int v28 = com.bumptech.glide.d.v(bArr, i18, dVar);
                    int i40 = dVar.f2213a + v28;
                    while (v28 < i40) {
                        v28 = com.bumptech.glide.d.x(bArr, v28, dVar);
                        l0Var5.g(m.e(dVar.f2214b));
                    }
                    if (v28 == i40) {
                        return v28;
                    }
                    throw e0.g();
                }
                if (i12 == 0) {
                    l0 l0Var6 = (l0) b0Var2;
                    int x9 = com.bumptech.glide.d.x(bArr, i18, dVar);
                    l0Var6.g(m.e(dVar.f2214b));
                    while (x9 < i10) {
                        int v29 = com.bumptech.glide.d.v(bArr, x9, dVar);
                        if (i11 != dVar.f2213a) {
                            return x9;
                        }
                        x9 = com.bumptech.glide.d.x(bArr, v29, dVar);
                        l0Var6.g(m.e(dVar.f2214b));
                    }
                    return x9;
                }
                return i18;
            case 49:
                if (i12 == 3) {
                    d1 p5 = p(i13);
                    int i41 = (i11 & (-8)) | 4;
                    Object i42 = p5.i();
                    u0 u0Var = (u0) p5;
                    int I = u0Var.I(i42, bArr, i9, i10, i41, dVar);
                    dVar.f2215c = i42;
                    p5.e(i42);
                    dVar.f2215c = i42;
                    b0Var2.add(i42);
                    while (I < i10) {
                        int v30 = com.bumptech.glide.d.v(bArr, I, dVar);
                        if (i11 != dVar.f2213a) {
                            return I;
                        }
                        Object i43 = p5.i();
                        I = u0Var.I(i43, bArr, v30, i10, i41, dVar);
                        dVar.f2215c = i43;
                        p5.e(i43);
                        dVar.f2215c = i43;
                        b0Var2.add(i43);
                    }
                    return I;
                }
            default:
                return i9;
        }
    }

    public final void L(Object obj, long j5, a5.k kVar, d1 d1Var, q qVar) {
        int B;
        List c9 = this.f2317l.c(j5, obj);
        m mVar = (m) kVar.f198d;
        int i9 = kVar.f195a;
        if ((i9 & 7) != 3) {
            throw e0.c();
        }
        do {
            Object i10 = d1Var.i();
            kVar.c(i10, d1Var, qVar);
            d1Var.e(i10);
            c9.add(i10);
            if (mVar.g() || kVar.f197c != 0) {
                return;
            } else {
                B = mVar.B();
            }
        } while (B == i9);
        kVar.f197c = B;
    }

    public final void M(Object obj, int i9, a5.k kVar, d1 d1Var, q qVar) {
        int B;
        List c9 = this.f2317l.c(i9 & 1048575, obj);
        m mVar = (m) kVar.f198d;
        int i10 = kVar.f195a;
        if ((i10 & 7) != 2) {
            throw e0.c();
        }
        do {
            Object i11 = d1Var.i();
            kVar.d(i11, d1Var, qVar);
            d1Var.e(i11);
            c9.add(i11);
            if (mVar.g() || kVar.f197c != 0) {
                return;
            } else {
                B = mVar.B();
            }
        } while (B == i10);
        kVar.f197c = B;
    }

    public final void N(Object obj, int i9, a5.k kVar) {
        m mVar = (m) kVar.f198d;
        if ((536870912 & i9) != 0) {
            kVar.w(2);
            p1.p(i9 & 1048575, obj, mVar.A());
        } else if (!this.f2312f) {
            p1.p(i9 & 1048575, obj, kVar.f());
        } else {
            kVar.w(2);
            p1.p(i9 & 1048575, obj, mVar.z());
        }
    }

    public final void O(Object obj, int i9, a5.k kVar) {
        boolean z8 = (536870912 & i9) != 0;
        k0 k0Var = this.f2317l;
        if (z8) {
            kVar.s(k0Var.c(i9 & 1048575, obj), true);
        } else {
            kVar.s(k0Var.c(i9 & 1048575, obj), false);
        }
    }

    public final void Q(int i9, Object obj) {
        int i10 = this.f2307a[i9 + 2];
        long j5 = 1048575 & i10;
        if (j5 == 1048575) {
            return;
        }
        p1.n((1 << (i10 >>> 20)) | p1.f2286c.g(j5, obj), j5, obj);
    }

    public final void R(int i9, int i10, Object obj) {
        p1.n(i9, this.f2307a[i10 + 2] & 1048575, obj);
    }

    public final int S(int i9, int i10) {
        int[] iArr = this.f2307a;
        int length = (iArr.length / 3) - 1;
        while (i10 <= length) {
            int i11 = (length + i10) >>> 1;
            int i12 = i11 * 3;
            int i13 = iArr[i12];
            if (i9 == i13) {
                return i12;
            }
            if (i9 < i13) {
                length = i11 - 1;
            } else {
                i10 = i11 + 1;
            }
        }
        return -1;
    }

    public final void T(Object obj, int i9, Object obj2) {
        f2306p.putObject(obj, W(i9) & 1048575, obj2);
        Q(i9, obj);
    }

    public final void U(int i9, int i10, Object obj, Object obj2) {
        f2306p.putObject(obj, W(i10) & 1048575, obj2);
        R(i9, i10, obj);
    }

    public final int W(int i9) {
        return this.f2307a[i9 + 1];
    }

    public final void X(Object obj, n0 n0Var) {
        int i9;
        int i10;
        int i11;
        int[] iArr = this.f2307a;
        int length = iArr.length;
        Unsafe unsafe = f2306p;
        int i12 = 1048575;
        int i13 = 0;
        for (int i14 = 0; i14 < length; i14 = i11 + 3) {
            int W = W(i14);
            int i15 = iArr[i14];
            int V = V(W);
            if (V <= 17) {
                int i16 = iArr[i14 + 2];
                i9 = 1048575;
                int i17 = i16 & 1048575;
                if (i17 != i12) {
                    i13 = unsafe.getInt(obj, i17);
                    i12 = i17;
                }
                i10 = 1 << (i16 >>> 20);
            } else {
                i9 = 1048575;
                i10 = 0;
            }
            int i18 = i14;
            long j5 = W & i9;
            switch (V) {
                case 0:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        double e9 = p1.f2286c.e(j5, obj);
                        n nVar = (n) n0Var.f2279a;
                        nVar.getClass();
                        nVar.o(i15, Double.doubleToRawLongBits(e9));
                        continue;
                    }
                case 1:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        float f9 = p1.f2286c.f(j5, obj);
                        n nVar2 = (n) n0Var.f2279a;
                        nVar2.getClass();
                        nVar2.m(i15, Float.floatToRawIntBits(f9));
                    } else {
                        continue;
                    }
                case 2:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((n) n0Var.f2279a).t(i15, unsafe.getLong(obj, j5));
                    } else {
                        continue;
                    }
                case 3:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((n) n0Var.f2279a).t(i15, unsafe.getLong(obj, j5));
                    } else {
                        continue;
                    }
                case 4:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        int i19 = unsafe.getInt(obj, j5);
                        n nVar3 = (n) n0Var.f2279a;
                        nVar3.r(i15, 0);
                        nVar3.q(i19);
                    }
                    break;
                case 5:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((n) n0Var.f2279a).o(i15, unsafe.getLong(obj, j5));
                        break;
                    }
                    break;
                case 6:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((n) n0Var.f2279a).m(i15, unsafe.getInt(obj, j5));
                        break;
                    }
                    break;
                case 7:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        boolean c9 = p1.f2286c.c(j5, obj);
                        n nVar4 = (n) n0Var.f2279a;
                        nVar4.r(i15, 0);
                        nVar4.k(c9 ? (byte) 1 : (byte) 0);
                        break;
                    }
                    break;
                case 8:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        Y(i15, unsafe.getObject(obj, j5), n0Var);
                        break;
                    }
                    break;
                case 9:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        n0Var.c(i15, unsafe.getObject(obj, j5), p(i11));
                        break;
                    }
                    break;
                case 10:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        n0Var.a(i15, (j) unsafe.getObject(obj, j5));
                        break;
                    }
                    break;
                case 11:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        int i20 = unsafe.getInt(obj, j5);
                        n nVar5 = (n) n0Var.f2279a;
                        nVar5.r(i15, 0);
                        nVar5.s(i20);
                        break;
                    }
                    break;
                case 12:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        int i21 = unsafe.getInt(obj, j5);
                        n nVar6 = (n) n0Var.f2279a;
                        nVar6.r(i15, 0);
                        nVar6.q(i21);
                    }
                    break;
                case 13:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((n) n0Var.f2279a).m(i15, unsafe.getInt(obj, j5));
                        break;
                    }
                    break;
                case 14:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((n) n0Var.f2279a).o(i15, unsafe.getLong(obj, j5));
                        break;
                    }
                    break;
                case 15:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        int i22 = unsafe.getInt(obj, j5);
                        n nVar7 = (n) n0Var.f2279a;
                        nVar7.r(i15, 0);
                        nVar7.s((i22 >> 31) ^ (i22 << 1));
                        break;
                    }
                    break;
                case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        long j9 = unsafe.getLong(obj, j5);
                        ((n) n0Var.f2279a).t(i15, (j9 << 1) ^ (j9 >> 63));
                        break;
                    }
                    break;
                case 17:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        n0Var.b(i15, unsafe.getObject(obj, j5), p(i11));
                        break;
                    }
                    break;
                case 18:
                    i11 = i18;
                    e1.A(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, false);
                    break;
                case 19:
                    i11 = i18;
                    e1.E(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, false);
                    continue;
                case 20:
                    i11 = i18;
                    e1.H(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, false);
                    continue;
                case 21:
                    i11 = i18;
                    e1.P(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, false);
                    continue;
                case 22:
                    i11 = i18;
                    e1.G(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, false);
                    continue;
                case 23:
                    i11 = i18;
                    e1.D(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, false);
                    continue;
                case 24:
                    i11 = i18;
                    e1.C(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, false);
                    continue;
                case 25:
                    i11 = i18;
                    e1.y(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, false);
                    continue;
                case 26:
                    i11 = i18;
                    e1.N(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var);
                    break;
                case 27:
                    i11 = i18;
                    e1.I(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, p(i11));
                    break;
                case 28:
                    i11 = i18;
                    e1.z(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var);
                    break;
                case 29:
                    i11 = i18;
                    e1.O(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, false);
                    break;
                case 30:
                    i11 = i18;
                    e1.B(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, false);
                    continue;
                case 31:
                    i11 = i18;
                    e1.J(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, false);
                    continue;
                case PeerConnectionFactory.Options.ADAPTER_TYPE_ANY /* 32 */:
                    i11 = i18;
                    e1.K(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, false);
                    continue;
                case 33:
                    i11 = i18;
                    e1.L(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, false);
                    continue;
                case 34:
                    i11 = i18;
                    e1.M(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, false);
                    continue;
                case 35:
                    i11 = i18;
                    e1.A(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, true);
                    break;
                case 36:
                    i11 = i18;
                    e1.E(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, true);
                    break;
                case 37:
                    i11 = i18;
                    e1.H(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, true);
                    break;
                case 38:
                    i11 = i18;
                    e1.P(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, true);
                    break;
                case 39:
                    i11 = i18;
                    e1.G(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, true);
                    break;
                case 40:
                    i11 = i18;
                    e1.D(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, true);
                    break;
                case 41:
                    i11 = i18;
                    e1.C(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, true);
                    break;
                case 42:
                    i11 = i18;
                    e1.y(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, true);
                    break;
                case 43:
                    i11 = i18;
                    e1.O(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, true);
                    break;
                case IjkMediaMeta.FF_PROFILE_H264_CAVLC_444 /* 44 */:
                    i11 = i18;
                    e1.B(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, true);
                    break;
                case 45:
                    i11 = i18;
                    e1.J(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, true);
                    break;
                case 46:
                    i11 = i18;
                    e1.K(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, true);
                    break;
                case 47:
                    i11 = i18;
                    e1.L(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, true);
                    break;
                case 48:
                    i11 = i18;
                    e1.M(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, true);
                    break;
                case 49:
                    i11 = i18;
                    e1.F(iArr[i11], (List) unsafe.getObject(obj, j5), n0Var, p(i11));
                    break;
                case l1.k.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY /* 50 */:
                    i11 = i18;
                    if (unsafe.getObject(obj, j5) != null) {
                        Object o8 = o(i11);
                        this.f2319n.getClass();
                        androidx.activity.g.w(o8);
                        throw null;
                    }
                    break;
                case 51:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        double doubleValue = ((Double) p1.f2286c.i(j5, obj)).doubleValue();
                        n nVar8 = (n) n0Var.f2279a;
                        nVar8.getClass();
                        nVar8.o(i15, Double.doubleToRawLongBits(doubleValue));
                        break;
                    }
                    break;
                case 52:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        float floatValue = ((Float) p1.f2286c.i(j5, obj)).floatValue();
                        n nVar9 = (n) n0Var.f2279a;
                        nVar9.getClass();
                        nVar9.m(i15, Float.floatToRawIntBits(floatValue));
                        break;
                    }
                    break;
                case 53:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        ((n) n0Var.f2279a).t(i15, F(j5, obj));
                        break;
                    }
                    break;
                case 54:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        ((n) n0Var.f2279a).t(i15, F(j5, obj));
                        break;
                    }
                    break;
                case 55:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        int E = E(j5, obj);
                        n nVar10 = (n) n0Var.f2279a;
                        nVar10.r(i15, 0);
                        nVar10.q(E);
                        break;
                    }
                    break;
                case 56:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        ((n) n0Var.f2279a).o(i15, F(j5, obj));
                        break;
                    }
                    break;
                case 57:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        ((n) n0Var.f2279a).m(i15, E(j5, obj));
                        break;
                    }
                    break;
                case 58:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        boolean booleanValue = ((Boolean) p1.f2286c.i(j5, obj)).booleanValue();
                        n nVar11 = (n) n0Var.f2279a;
                        nVar11.r(i15, 0);
                        nVar11.k(booleanValue ? (byte) 1 : (byte) 0);
                        break;
                    }
                    break;
                case 59:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        Y(i15, unsafe.getObject(obj, j5), n0Var);
                        break;
                    }
                    break;
                case 60:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        n0Var.c(i15, unsafe.getObject(obj, j5), p(i11));
                        break;
                    }
                    break;
                case 61:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        n0Var.a(i15, (j) unsafe.getObject(obj, j5));
                        break;
                    }
                    break;
                case 62:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        int E2 = E(j5, obj);
                        n nVar12 = (n) n0Var.f2279a;
                        nVar12.r(i15, 0);
                        nVar12.s(E2);
                        break;
                    }
                    break;
                case 63:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        int E3 = E(j5, obj);
                        n nVar13 = (n) n0Var.f2279a;
                        nVar13.r(i15, 0);
                        nVar13.q(E3);
                    }
                    break;
                case EglBase.EGL_OPENGL_ES3_BIT /* 64 */:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        ((n) n0Var.f2279a).m(i15, E(j5, obj));
                        break;
                    }
                    break;
                case 65:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        ((n) n0Var.f2279a).o(i15, F(j5, obj));
                        break;
                    }
                    break;
                case IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        int E4 = E(j5, obj);
                        n nVar14 = (n) n0Var.f2279a;
                        nVar14.r(i15, 0);
                        nVar14.s((E4 >> 31) ^ (E4 << 1));
                        break;
                    }
                    break;
                case 67:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        long F = F(j5, obj);
                        ((n) n0Var.f2279a).t(i15, (F << 1) ^ (F >> 63));
                        break;
                    }
                    break;
                case 68:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        n0Var.b(i15, unsafe.getObject(obj, j5), p(i11));
                        break;
                    }
                    break;
                default:
                    i11 = i18;
                    break;
            }
        }
        this.f2318m.getClass();
        ((y) obj).unknownFields.e(n0Var);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.d1
    public final int a(y yVar) {
        return this.f2313g ? r(yVar) : q(yVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.crypto.tink.shaded.protobuf.d1
    public final void b(Object obj, Object obj2) {
        Object obj3;
        l(obj);
        obj2.getClass();
        int i9 = 0;
        while (true) {
            int[] iArr = this.f2307a;
            if (i9 >= iArr.length) {
                e1.w(this.f2318m, obj, obj2);
                return;
            }
            int W = W(i9);
            long j5 = 1048575 & W;
            int i10 = iArr[i9];
            switch (V(W)) {
                case 0:
                    if (s(i9, obj2)) {
                        o1 o1Var = p1.f2286c;
                        obj3 = obj;
                        o1Var.m(obj3, j5, o1Var.e(j5, obj2));
                        Q(i9, obj3);
                        break;
                    }
                    obj3 = obj;
                    break;
                case 1:
                    if (s(i9, obj2)) {
                        o1 o1Var2 = p1.f2286c;
                        o1Var2.n(obj, j5, o1Var2.f(j5, obj2));
                        Q(i9, obj);
                    }
                    obj3 = obj;
                    break;
                case 2:
                    if (s(i9, obj2)) {
                        p1.o(obj, j5, p1.f2286c.h(j5, obj2));
                        Q(i9, obj);
                    }
                    obj3 = obj;
                    break;
                case 3:
                    if (s(i9, obj2)) {
                        p1.o(obj, j5, p1.f2286c.h(j5, obj2));
                        Q(i9, obj);
                    }
                    obj3 = obj;
                    break;
                case 4:
                    if (s(i9, obj2)) {
                        p1.n(p1.f2286c.g(j5, obj2), j5, obj);
                        Q(i9, obj);
                    }
                    obj3 = obj;
                    break;
                case 5:
                    if (s(i9, obj2)) {
                        p1.o(obj, j5, p1.f2286c.h(j5, obj2));
                        Q(i9, obj);
                    }
                    obj3 = obj;
                    break;
                case 6:
                    if (s(i9, obj2)) {
                        p1.n(p1.f2286c.g(j5, obj2), j5, obj);
                        Q(i9, obj);
                    }
                    obj3 = obj;
                    break;
                case 7:
                    if (s(i9, obj2)) {
                        o1 o1Var3 = p1.f2286c;
                        o1Var3.k(obj, j5, o1Var3.c(j5, obj2));
                        Q(i9, obj);
                    }
                    obj3 = obj;
                    break;
                case 8:
                    if (s(i9, obj2)) {
                        p1.p(j5, obj, p1.f2286c.i(j5, obj2));
                        Q(i9, obj);
                    }
                    obj3 = obj;
                    break;
                case 9:
                    x(obj, i9, obj2);
                    obj3 = obj;
                    break;
                case 10:
                    if (s(i9, obj2)) {
                        p1.p(j5, obj, p1.f2286c.i(j5, obj2));
                        Q(i9, obj);
                    }
                    obj3 = obj;
                    break;
                case 11:
                    if (s(i9, obj2)) {
                        p1.n(p1.f2286c.g(j5, obj2), j5, obj);
                        Q(i9, obj);
                    }
                    obj3 = obj;
                    break;
                case 12:
                    if (s(i9, obj2)) {
                        p1.n(p1.f2286c.g(j5, obj2), j5, obj);
                        Q(i9, obj);
                    }
                    obj3 = obj;
                    break;
                case 13:
                    if (s(i9, obj2)) {
                        p1.n(p1.f2286c.g(j5, obj2), j5, obj);
                        Q(i9, obj);
                    }
                    obj3 = obj;
                    break;
                case 14:
                    if (s(i9, obj2)) {
                        p1.o(obj, j5, p1.f2286c.h(j5, obj2));
                        Q(i9, obj);
                    }
                    obj3 = obj;
                    break;
                case 15:
                    if (s(i9, obj2)) {
                        p1.n(p1.f2286c.g(j5, obj2), j5, obj);
                        Q(i9, obj);
                    }
                    obj3 = obj;
                    break;
                case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                    if (s(i9, obj2)) {
                        p1.o(obj, j5, p1.f2286c.h(j5, obj2));
                        Q(i9, obj);
                    }
                    obj3 = obj;
                    break;
                case 17:
                    x(obj, i9, obj2);
                    obj3 = obj;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case PeerConnectionFactory.Options.ADAPTER_TYPE_ANY /* 32 */:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case IjkMediaMeta.FF_PROFILE_H264_CAVLC_444 /* 44 */:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.f2317l.b(j5, obj, obj2);
                    obj3 = obj;
                    break;
                case l1.k.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY /* 50 */:
                    Class cls = e1.f2217a;
                    o1 o1Var4 = p1.f2286c;
                    Object i11 = o1Var4.i(j5, obj);
                    Object i12 = o1Var4.i(j5, obj2);
                    this.f2319n.getClass();
                    p1.p(j5, obj, p0.b(i11, i12));
                    obj3 = obj;
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (u(i10, i9, obj2)) {
                        p1.p(j5, obj, p1.f2286c.i(j5, obj2));
                        R(i10, i9, obj);
                    }
                    obj3 = obj;
                    break;
                case 60:
                    y(obj, i9, obj2);
                    obj3 = obj;
                    break;
                case 61:
                case 62:
                case 63:
                case EglBase.EGL_OPENGL_ES3_BIT /* 64 */:
                case 65:
                case IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
                case 67:
                    if (u(i10, i9, obj2)) {
                        p1.p(j5, obj, p1.f2286c.i(j5, obj2));
                        R(i10, i9, obj);
                    }
                    obj3 = obj;
                    break;
                case 68:
                    y(obj, i9, obj2);
                    obj3 = obj;
                    break;
                default:
                    obj3 = obj;
                    break;
            }
            i9 += 3;
            obj = obj3;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.d1
    public final void c(Object obj, byte[] bArr, int i9, int i10, d dVar) {
        if (this.f2313g) {
            J(obj, bArr, i9, i10, dVar);
        } else {
            I(obj, bArr, i9, i10, 0, dVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:184:0x0067, code lost:
    
        if (r13 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a0, code lost:
    
        if (r13 != null) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x061d A[Catch: all -> 0x044b, TryCatch #7 {all -> 0x044b, blocks: (B:39:0x0618, B:41:0x061d, B:42:0x0622, B:132:0x043f, B:135:0x0453, B:136:0x046f, B:137:0x048c, B:138:0x04a9, B:139:0x04c8, B:140:0x04e4, B:141:0x04f9, B:142:0x0514, B:143:0x0521, B:144:0x053f, B:145:0x055c, B:146:0x0579, B:147:0x0595, B:148:0x05b1, B:149:0x05cd, B:150:0x05eb, B:155:0x0609), top: B:38:0x0618 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0628 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0647 A[LOOP:3: B:56:0x0645->B:57:0x0647, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0651  */
    @Override // com.google.crypto.tink.shaded.protobuf.d1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(java.lang.Object r20, a5.k r21, com.google.crypto.tink.shaded.protobuf.q r22) {
        /*
            Method dump skipped, instructions count: 1768
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.u0.d(java.lang.Object, a5.k, com.google.crypto.tink.shaded.protobuf.q):void");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.d1
    public final void e(Object obj) {
        if (t(obj)) {
            if (obj instanceof y) {
                y yVar = (y) obj;
                yVar.u(Integer.MAX_VALUE);
                yVar.memoizedHashCode = 0;
                yVar.o();
            }
            int length = this.f2307a.length;
            for (int i9 = 0; i9 < length; i9 += 3) {
                int W = W(i9);
                long j5 = 1048575 & W;
                int V = V(W);
                if (V != 9) {
                    switch (V) {
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case PeerConnectionFactory.Options.ADAPTER_TYPE_ANY /* 32 */:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case IjkMediaMeta.FF_PROFILE_H264_CAVLC_444 /* 44 */:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            this.f2317l.a(j5, obj);
                            break;
                        case l1.k.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY /* 50 */:
                            Unsafe unsafe = f2306p;
                            Object object = unsafe.getObject(obj, j5);
                            if (object != null) {
                                this.f2319n.getClass();
                                ((o0) object).f2281i = false;
                                unsafe.putObject(obj, j5, object);
                                break;
                            } else {
                                break;
                            }
                    }
                }
                if (s(i9, obj)) {
                    p(i9).e(f2306p.getObject(obj, j5));
                }
            }
            this.f2318m.getClass();
            ((y) obj).unknownFields.f2242e = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x00f0, code lost:
    
        return false;
     */
    @Override // com.google.crypto.tink.shaded.protobuf.d1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.u0.f(java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0074, code lost:
    
        if (com.google.crypto.tink.shaded.protobuf.e1.x(r5.i(r7, r12), r5.i(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008a, code lost:
    
        if (r5.h(r7, r12) == r5.h(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009e, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b4, code lost:
    
        if (r5.h(r7, r12) == r5.h(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c8, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00dc, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f0, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0108, code lost:
    
        if (com.google.crypto.tink.shaded.protobuf.e1.x(r5.i(r7, r12), r5.i(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0120, code lost:
    
        if (com.google.crypto.tink.shaded.protobuf.e1.x(r5.i(r7, r12), r5.i(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0138, code lost:
    
        if (com.google.crypto.tink.shaded.protobuf.e1.x(r5.i(r7, r12), r5.i(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x014c, code lost:
    
        if (r5.c(r7, r12) == r5.c(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0160, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0176, code lost:
    
        if (r5.h(r7, r12) == r5.h(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x018a, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x019f, code lost:
    
        if (r5.h(r7, r12) == r5.h(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01b4, code lost:
    
        if (r5.h(r7, r12) == r5.h(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01cf, code lost:
    
        if (java.lang.Float.floatToIntBits(r5.f(r7, r12)) == java.lang.Float.floatToIntBits(r5.f(r7, r13))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01ec, code lost:
    
        if (java.lang.Double.doubleToLongBits(r5.e(r7, r12)) == java.lang.Double.doubleToLongBits(r5.e(r7, r13))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
    
        if (com.google.crypto.tink.shaded.protobuf.e1.x(r9.i(r7, r12), r9.i(r7, r13)) != false) goto L105;
     */
    @Override // com.google.crypto.tink.shaded.protobuf.d1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(com.google.crypto.tink.shaded.protobuf.y r12, com.google.crypto.tink.shaded.protobuf.y r13) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.u0.g(com.google.crypto.tink.shaded.protobuf.y, com.google.crypto.tink.shaded.protobuf.y):boolean");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.d1
    public final void h(Object obj, n0 n0Var) {
        n0Var.getClass();
        n nVar = (n) n0Var.f2279a;
        if (!this.f2313g) {
            X(obj, n0Var);
            return;
        }
        int[] iArr = this.f2307a;
        int length = iArr.length;
        for (int i9 = 0; i9 < length; i9 += 3) {
            int W = W(i9);
            int i10 = iArr[i9];
            switch (V(W)) {
                case 0:
                    if (s(i9, obj)) {
                        double e9 = p1.f2286c.e(W & 1048575, obj);
                        nVar.getClass();
                        nVar.o(i10, Double.doubleToRawLongBits(e9));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (s(i9, obj)) {
                        float f9 = p1.f2286c.f(W & 1048575, obj);
                        nVar.getClass();
                        nVar.m(i10, Float.floatToRawIntBits(f9));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (s(i9, obj)) {
                        nVar.t(i10, p1.f2286c.h(W & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (s(i9, obj)) {
                        nVar.t(i10, p1.f2286c.h(W & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (s(i9, obj)) {
                        int g9 = p1.f2286c.g(W & 1048575, obj);
                        nVar.r(i10, 0);
                        nVar.q(g9);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (s(i9, obj)) {
                        nVar.o(i10, p1.f2286c.h(W & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (s(i9, obj)) {
                        nVar.m(i10, p1.f2286c.g(W & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (s(i9, obj)) {
                        boolean c9 = p1.f2286c.c(W & 1048575, obj);
                        nVar.r(i10, 0);
                        nVar.k(c9 ? (byte) 1 : (byte) 0);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (s(i9, obj)) {
                        Y(i10, p1.f2286c.i(W & 1048575, obj), n0Var);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (s(i9, obj)) {
                        n0Var.c(i10, p1.f2286c.i(W & 1048575, obj), p(i9));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (s(i9, obj)) {
                        n0Var.a(i10, (j) p1.f2286c.i(W & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (s(i9, obj)) {
                        int g10 = p1.f2286c.g(W & 1048575, obj);
                        nVar.r(i10, 0);
                        nVar.s(g10);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (s(i9, obj)) {
                        int g11 = p1.f2286c.g(W & 1048575, obj);
                        nVar.r(i10, 0);
                        nVar.q(g11);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (s(i9, obj)) {
                        nVar.m(i10, p1.f2286c.g(W & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (s(i9, obj)) {
                        nVar.o(i10, p1.f2286c.h(W & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (s(i9, obj)) {
                        int g12 = p1.f2286c.g(W & 1048575, obj);
                        nVar.r(i10, 0);
                        nVar.s((g12 >> 31) ^ (g12 << 1));
                        break;
                    } else {
                        break;
                    }
                case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                    if (s(i9, obj)) {
                        long h = p1.f2286c.h(W & 1048575, obj);
                        nVar.t(i10, (h >> 63) ^ (h << 1));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (s(i9, obj)) {
                        n0Var.b(i10, p1.f2286c.i(W & 1048575, obj), p(i9));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    e1.A(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, false);
                    break;
                case 19:
                    e1.E(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, false);
                    break;
                case 20:
                    e1.H(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, false);
                    break;
                case 21:
                    e1.P(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, false);
                    break;
                case 22:
                    e1.G(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, false);
                    break;
                case 23:
                    e1.D(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, false);
                    break;
                case 24:
                    e1.C(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, false);
                    break;
                case 25:
                    e1.y(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, false);
                    break;
                case 26:
                    e1.N(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var);
                    break;
                case 27:
                    e1.I(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, p(i9));
                    break;
                case 28:
                    e1.z(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var);
                    break;
                case 29:
                    e1.O(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, false);
                    break;
                case 30:
                    e1.B(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, false);
                    break;
                case 31:
                    e1.J(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, false);
                    break;
                case PeerConnectionFactory.Options.ADAPTER_TYPE_ANY /* 32 */:
                    e1.K(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, false);
                    break;
                case 33:
                    e1.L(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, false);
                    break;
                case 34:
                    e1.M(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, false);
                    break;
                case 35:
                    e1.A(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, true);
                    break;
                case 36:
                    e1.E(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, true);
                    break;
                case 37:
                    e1.H(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, true);
                    break;
                case 38:
                    e1.P(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, true);
                    break;
                case 39:
                    e1.G(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, true);
                    break;
                case 40:
                    e1.D(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, true);
                    break;
                case 41:
                    e1.C(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, true);
                    break;
                case 42:
                    e1.y(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, true);
                    break;
                case 43:
                    e1.O(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, true);
                    break;
                case IjkMediaMeta.FF_PROFILE_H264_CAVLC_444 /* 44 */:
                    e1.B(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, true);
                    break;
                case 45:
                    e1.J(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, true);
                    break;
                case 46:
                    e1.K(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, true);
                    break;
                case 47:
                    e1.L(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, true);
                    break;
                case 48:
                    e1.M(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, true);
                    break;
                case 49:
                    e1.F(iArr[i9], (List) p1.f2286c.i(W & 1048575, obj), n0Var, p(i9));
                    break;
                case l1.k.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY /* 50 */:
                    if (p1.f2286c.i(W & 1048575, obj) != null) {
                        Object o8 = o(i9);
                        this.f2319n.getClass();
                        androidx.activity.g.w(o8);
                        throw null;
                    }
                    break;
                case 51:
                    if (u(i10, i9, obj)) {
                        double doubleValue = ((Double) p1.f2286c.i(W & 1048575, obj)).doubleValue();
                        nVar.getClass();
                        nVar.o(i10, Double.doubleToRawLongBits(doubleValue));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (u(i10, i9, obj)) {
                        float floatValue = ((Float) p1.f2286c.i(W & 1048575, obj)).floatValue();
                        nVar.getClass();
                        nVar.m(i10, Float.floatToRawIntBits(floatValue));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (u(i10, i9, obj)) {
                        nVar.t(i10, F(W & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (u(i10, i9, obj)) {
                        nVar.t(i10, F(W & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (u(i10, i9, obj)) {
                        int E = E(W & 1048575, obj);
                        nVar.r(i10, 0);
                        nVar.q(E);
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (u(i10, i9, obj)) {
                        nVar.o(i10, F(W & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (u(i10, i9, obj)) {
                        nVar.m(i10, E(W & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (u(i10, i9, obj)) {
                        boolean booleanValue = ((Boolean) p1.f2286c.i(W & 1048575, obj)).booleanValue();
                        nVar.r(i10, 0);
                        nVar.k(booleanValue ? (byte) 1 : (byte) 0);
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (u(i10, i9, obj)) {
                        Y(i10, p1.f2286c.i(W & 1048575, obj), n0Var);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (u(i10, i9, obj)) {
                        n0Var.c(i10, p1.f2286c.i(W & 1048575, obj), p(i9));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (u(i10, i9, obj)) {
                        n0Var.a(i10, (j) p1.f2286c.i(W & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (u(i10, i9, obj)) {
                        int E2 = E(W & 1048575, obj);
                        nVar.r(i10, 0);
                        nVar.s(E2);
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (u(i10, i9, obj)) {
                        int E3 = E(W & 1048575, obj);
                        nVar.r(i10, 0);
                        nVar.q(E3);
                        break;
                    } else {
                        break;
                    }
                case EglBase.EGL_OPENGL_ES3_BIT /* 64 */:
                    if (u(i10, i9, obj)) {
                        nVar.m(i10, E(W & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (u(i10, i9, obj)) {
                        nVar.o(i10, F(W & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
                    if (u(i10, i9, obj)) {
                        int E4 = E(W & 1048575, obj);
                        nVar.r(i10, 0);
                        nVar.s((E4 >> 31) ^ (E4 << 1));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (u(i10, i9, obj)) {
                        long F = F(W & 1048575, obj);
                        nVar.t(i10, (F >> 63) ^ (F << 1));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (u(i10, i9, obj)) {
                        n0Var.b(i10, p1.f2286c.i(W & 1048575, obj), p(i9));
                        break;
                    } else {
                        break;
                    }
            }
        }
        this.f2318m.getClass();
        ((y) obj).unknownFields.e(n0Var);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.d1
    public final Object i() {
        this.f2316k.getClass();
        return ((y) this.f2311e).q();
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0217, code lost:
    
        if (r4 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00df, code lost:
    
        if (r4 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e1, code lost:
    
        r8 = 1231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e3, code lost:
    
        r3 = r8 + r3;
     */
    @Override // com.google.crypto.tink.shaded.protobuf.d1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int j(com.google.crypto.tink.shaded.protobuf.y r12) {
        /*
            Method dump skipped, instructions count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.u0.j(com.google.crypto.tink.shaded.protobuf.y):int");
    }

    public final boolean k(y yVar, y yVar2, int i9) {
        return s(i9, yVar) == s(i9, yVar2);
    }

    public final void m(Object obj, int i9, Object obj2) {
        int i10 = this.f2307a[i9];
        if (p1.f2286c.i(W(i9) & 1048575, obj) == null) {
            return;
        }
        n(i9);
    }

    public final void n(int i9) {
        if (this.f2308b[((i9 / 3) * 2) + 1] == null) {
            return;
        }
        androidx.fragment.app.a.c();
    }

    public final Object o(int i9) {
        return this.f2308b[(i9 / 3) * 2];
    }

    public final d1 p(int i9) {
        int i10 = (i9 / 3) * 2;
        Object[] objArr = this.f2308b;
        d1 d1Var = (d1) objArr[i10];
        if (d1Var != null) {
            return d1Var;
        }
        d1 a9 = a1.f2198c.a((Class) objArr[i10 + 1]);
        objArr[i10] = a9;
        return a9;
    }

    public final int q(y yVar) {
        int i9;
        int h;
        int j5;
        int h9;
        int f9;
        int d9;
        int h10;
        int g9;
        int j9;
        int i10;
        Unsafe unsafe = f2306p;
        int i11 = 1048575;
        int i12 = 0;
        int i13 = 0;
        int i14 = 1048575;
        int i15 = 0;
        while (true) {
            int[] iArr = this.f2307a;
            if (i12 >= iArr.length) {
                this.f2318m.getClass();
                return yVar.unknownFields.b() + i13;
            }
            int W = W(i12);
            int i16 = iArr[i12];
            int V = V(W);
            if (V <= 17) {
                int i17 = iArr[i12 + 2];
                int i18 = i17 & i11;
                i9 = 1 << (i17 >>> 20);
                if (i18 != i14) {
                    i15 = unsafe.getInt(yVar, i18);
                    i14 = i18;
                }
            } else {
                i9 = 0;
            }
            long j10 = W & i11;
            switch (V) {
                case 0:
                    if ((i15 & i9) != 0) {
                        i13 = androidx.activity.g.i(i16, 8, i13);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i15 & i9) != 0) {
                        i13 = androidx.activity.g.i(i16, 4, i13);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i9 & i15) != 0) {
                        long j11 = unsafe.getLong(yVar, j10);
                        h = n.h(i16);
                        j5 = n.j(j11);
                        d9 = j5 + h;
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i9 & i15) != 0) {
                        long j12 = unsafe.getLong(yVar, j10);
                        h = n.h(i16);
                        j5 = n.j(j12);
                        d9 = j5 + h;
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i9 & i15) != 0) {
                        int i19 = unsafe.getInt(yVar, j10);
                        h9 = n.h(i16);
                        f9 = n.f(i19);
                        d9 = f9 + h9;
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i15 & i9) != 0) {
                        d9 = n.d(i16);
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i15 & i9) != 0) {
                        d9 = n.c(i16);
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i15 & i9) != 0) {
                        i13 = androidx.activity.g.i(i16, 1, i13);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i9 & i15) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(yVar, j10);
                        if (object instanceof j) {
                            int h11 = n.h(i16);
                            int size = ((j) object).size();
                            j9 = androidx.activity.g.j(size, size, h11, i13);
                            i13 = j9;
                            break;
                        } else {
                            h10 = n.h(i16);
                            g9 = n.g((String) object);
                            j9 = g9 + h10 + i13;
                            i13 = j9;
                        }
                    }
                case 9:
                    if ((i9 & i15) != 0) {
                        Object object2 = unsafe.getObject(yVar, j10);
                        d1 p5 = p(i12);
                        Class cls = e1.f2217a;
                        int h12 = n.h(i16);
                        int b9 = ((a) object2).b(p5);
                        i13 = androidx.activity.g.j(b9, b9, h12, i13);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i9 & i15) != 0) {
                        d9 = n.a(i16, (j) unsafe.getObject(yVar, j10));
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i9 & i15) != 0) {
                        int i20 = unsafe.getInt(yVar, j10);
                        h9 = n.h(i16);
                        f9 = n.i(i20);
                        d9 = f9 + h9;
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i9 & i15) != 0) {
                        int i21 = unsafe.getInt(yVar, j10);
                        h9 = n.h(i16);
                        f9 = n.f(i21);
                        d9 = f9 + h9;
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i15 & i9) != 0) {
                        i13 = androidx.activity.g.i(i16, 4, i13);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((i15 & i9) != 0) {
                        i13 = androidx.activity.g.i(i16, 8, i13);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((i9 & i15) != 0) {
                        int i22 = unsafe.getInt(yVar, j10);
                        h9 = n.h(i16);
                        f9 = n.i((i22 >> 31) ^ (i22 << 1));
                        d9 = f9 + h9;
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                    if ((i9 & i15) != 0) {
                        long j13 = unsafe.getLong(yVar, j10);
                        h = n.h(i16);
                        j5 = n.j((j13 >> 63) ^ (j13 << 1));
                        d9 = j5 + h;
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i9 & i15) != 0) {
                        d9 = n.e(i16, (a) unsafe.getObject(yVar, j10), p(i12));
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    d9 = e1.f(i16, (List) unsafe.getObject(yVar, j10));
                    i13 += d9;
                    break;
                case 19:
                    d9 = e1.d(i16, (List) unsafe.getObject(yVar, j10));
                    i13 += d9;
                    break;
                case 20:
                    d9 = e1.j(i16, (List) unsafe.getObject(yVar, j10));
                    i13 += d9;
                    break;
                case 21:
                    d9 = e1.t(i16, (List) unsafe.getObject(yVar, j10));
                    i13 += d9;
                    break;
                case 22:
                    d9 = e1.h(i16, (List) unsafe.getObject(yVar, j10));
                    i13 += d9;
                    break;
                case 23:
                    d9 = e1.f(i16, (List) unsafe.getObject(yVar, j10));
                    i13 += d9;
                    break;
                case 24:
                    d9 = e1.d(i16, (List) unsafe.getObject(yVar, j10));
                    i13 += d9;
                    break;
                case 25:
                    List list = (List) unsafe.getObject(yVar, j10);
                    Class cls2 = e1.f2217a;
                    int size2 = list.size();
                    i13 += size2 == 0 ? 0 : (n.h(i16) + 1) * size2;
                    break;
                case 26:
                    d9 = e1.q(i16, (List) unsafe.getObject(yVar, j10));
                    i13 += d9;
                    break;
                case 27:
                    d9 = e1.l(i16, (List) unsafe.getObject(yVar, j10), p(i12));
                    i13 += d9;
                    break;
                case 28:
                    d9 = e1.a(i16, (List) unsafe.getObject(yVar, j10));
                    i13 += d9;
                    break;
                case 29:
                    d9 = e1.r(i16, (List) unsafe.getObject(yVar, j10));
                    i13 += d9;
                    break;
                case 30:
                    d9 = e1.b(i16, (List) unsafe.getObject(yVar, j10));
                    i13 += d9;
                    break;
                case 31:
                    d9 = e1.d(i16, (List) unsafe.getObject(yVar, j10));
                    i13 += d9;
                    break;
                case PeerConnectionFactory.Options.ADAPTER_TYPE_ANY /* 32 */:
                    d9 = e1.f(i16, (List) unsafe.getObject(yVar, j10));
                    i13 += d9;
                    break;
                case 33:
                    d9 = e1.m(i16, (List) unsafe.getObject(yVar, j10));
                    i13 += d9;
                    break;
                case 34:
                    d9 = e1.o(i16, (List) unsafe.getObject(yVar, j10));
                    i13 += d9;
                    break;
                case 35:
                    int g10 = e1.g((List) unsafe.getObject(yVar, j10));
                    if (g10 > 0) {
                        i13 = androidx.activity.g.j(g10, n.h(i16), g10, i13);
                        break;
                    } else {
                        break;
                    }
                case 36:
                    int e9 = e1.e((List) unsafe.getObject(yVar, j10));
                    if (e9 > 0) {
                        i13 = androidx.activity.g.j(e9, n.h(i16), e9, i13);
                        break;
                    } else {
                        break;
                    }
                case 37:
                    int k3 = e1.k((List) unsafe.getObject(yVar, j10));
                    if (k3 > 0) {
                        i13 = androidx.activity.g.j(k3, n.h(i16), k3, i13);
                        break;
                    } else {
                        break;
                    }
                case 38:
                    int u3 = e1.u((List) unsafe.getObject(yVar, j10));
                    if (u3 > 0) {
                        i13 = androidx.activity.g.j(u3, n.h(i16), u3, i13);
                        break;
                    } else {
                        break;
                    }
                case 39:
                    int i23 = e1.i((List) unsafe.getObject(yVar, j10));
                    if (i23 > 0) {
                        i13 = androidx.activity.g.j(i23, n.h(i16), i23, i13);
                        break;
                    } else {
                        break;
                    }
                case 40:
                    int g11 = e1.g((List) unsafe.getObject(yVar, j10));
                    if (g11 > 0) {
                        i13 = androidx.activity.g.j(g11, n.h(i16), g11, i13);
                        break;
                    } else {
                        break;
                    }
                case 41:
                    int e10 = e1.e((List) unsafe.getObject(yVar, j10));
                    if (e10 > 0) {
                        i13 = androidx.activity.g.j(e10, n.h(i16), e10, i13);
                        break;
                    } else {
                        break;
                    }
                case 42:
                    List list2 = (List) unsafe.getObject(yVar, j10);
                    Class cls3 = e1.f2217a;
                    int size3 = list2.size();
                    if (size3 > 0) {
                        i13 = androidx.activity.g.j(size3, n.h(i16), size3, i13);
                        break;
                    } else {
                        break;
                    }
                case 43:
                    int s8 = e1.s((List) unsafe.getObject(yVar, j10));
                    if (s8 > 0) {
                        i13 = androidx.activity.g.j(s8, n.h(i16), s8, i13);
                        break;
                    } else {
                        break;
                    }
                case IjkMediaMeta.FF_PROFILE_H264_CAVLC_444 /* 44 */:
                    int c9 = e1.c((List) unsafe.getObject(yVar, j10));
                    if (c9 > 0) {
                        i13 = androidx.activity.g.j(c9, n.h(i16), c9, i13);
                        break;
                    } else {
                        break;
                    }
                case 45:
                    int e11 = e1.e((List) unsafe.getObject(yVar, j10));
                    if (e11 > 0) {
                        i13 = androidx.activity.g.j(e11, n.h(i16), e11, i13);
                        break;
                    } else {
                        break;
                    }
                case 46:
                    int g12 = e1.g((List) unsafe.getObject(yVar, j10));
                    if (g12 > 0) {
                        i13 = androidx.activity.g.j(g12, n.h(i16), g12, i13);
                        break;
                    } else {
                        break;
                    }
                case 47:
                    int n4 = e1.n((List) unsafe.getObject(yVar, j10));
                    if (n4 > 0) {
                        i13 = androidx.activity.g.j(n4, n.h(i16), n4, i13);
                        break;
                    } else {
                        break;
                    }
                case 48:
                    int p7 = e1.p((List) unsafe.getObject(yVar, j10));
                    if (p7 > 0) {
                        i13 = androidx.activity.g.j(p7, n.h(i16), p7, i13);
                        break;
                    } else {
                        break;
                    }
                case 49:
                    List list3 = (List) unsafe.getObject(yVar, j10);
                    d1 p9 = p(i12);
                    Class cls4 = e1.f2217a;
                    int size4 = list3.size();
                    if (size4 == 0) {
                        i10 = 0;
                    } else {
                        i10 = 0;
                        for (int i24 = 0; i24 < size4; i24++) {
                            i10 += n.e(i16, (a) list3.get(i24), p9);
                        }
                    }
                    i13 += i10;
                    break;
                case l1.k.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY /* 50 */:
                    Object object3 = unsafe.getObject(yVar, j10);
                    Object o8 = o(i12);
                    this.f2319n.getClass();
                    p0.a(object3, o8);
                    break;
                case 51:
                    if (u(i16, i12, yVar)) {
                        i13 = androidx.activity.g.i(i16, 8, i13);
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (u(i16, i12, yVar)) {
                        i13 = androidx.activity.g.i(i16, 4, i13);
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (u(i16, i12, yVar)) {
                        long F = F(j10, yVar);
                        h = n.h(i16);
                        j5 = n.j(F);
                        d9 = j5 + h;
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (u(i16, i12, yVar)) {
                        long F2 = F(j10, yVar);
                        h = n.h(i16);
                        j5 = n.j(F2);
                        d9 = j5 + h;
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (u(i16, i12, yVar)) {
                        int E = E(j10, yVar);
                        h9 = n.h(i16);
                        f9 = n.f(E);
                        d9 = f9 + h9;
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (u(i16, i12, yVar)) {
                        d9 = n.d(i16);
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (u(i16, i12, yVar)) {
                        d9 = n.c(i16);
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (u(i16, i12, yVar)) {
                        i13 = androidx.activity.g.i(i16, 1, i13);
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!u(i16, i12, yVar)) {
                        break;
                    } else {
                        Object object4 = unsafe.getObject(yVar, j10);
                        if (object4 instanceof j) {
                            int h13 = n.h(i16);
                            int size5 = ((j) object4).size();
                            j9 = androidx.activity.g.j(size5, size5, h13, i13);
                            i13 = j9;
                            break;
                        } else {
                            h10 = n.h(i16);
                            g9 = n.g((String) object4);
                            j9 = g9 + h10 + i13;
                            i13 = j9;
                        }
                    }
                case 60:
                    if (u(i16, i12, yVar)) {
                        Object object5 = unsafe.getObject(yVar, j10);
                        d1 p10 = p(i12);
                        Class cls5 = e1.f2217a;
                        int h14 = n.h(i16);
                        int b10 = ((a) object5).b(p10);
                        i13 = androidx.activity.g.j(b10, b10, h14, i13);
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (u(i16, i12, yVar)) {
                        d9 = n.a(i16, (j) unsafe.getObject(yVar, j10));
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (u(i16, i12, yVar)) {
                        int E2 = E(j10, yVar);
                        h9 = n.h(i16);
                        f9 = n.i(E2);
                        d9 = f9 + h9;
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (u(i16, i12, yVar)) {
                        int E3 = E(j10, yVar);
                        h9 = n.h(i16);
                        f9 = n.f(E3);
                        d9 = f9 + h9;
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case EglBase.EGL_OPENGL_ES3_BIT /* 64 */:
                    if (u(i16, i12, yVar)) {
                        i13 = androidx.activity.g.i(i16, 4, i13);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (u(i16, i12, yVar)) {
                        i13 = androidx.activity.g.i(i16, 8, i13);
                        break;
                    } else {
                        break;
                    }
                case IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
                    if (u(i16, i12, yVar)) {
                        int E4 = E(j10, yVar);
                        h9 = n.h(i16);
                        f9 = n.i((E4 >> 31) ^ (E4 << 1));
                        d9 = f9 + h9;
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (u(i16, i12, yVar)) {
                        long F3 = F(j10, yVar);
                        h = n.h(i16);
                        j5 = n.j((F3 >> 63) ^ (F3 << 1));
                        d9 = j5 + h;
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (u(i16, i12, yVar)) {
                        d9 = n.e(i16, (a) unsafe.getObject(yVar, j10), p(i12));
                        i13 += d9;
                        break;
                    } else {
                        break;
                    }
            }
            i12 += 3;
            i11 = 1048575;
        }
    }

    public final int r(y yVar) {
        int h;
        int j5;
        int h9;
        int f9;
        int d9;
        int h10;
        int g9;
        int h11;
        int j9;
        int i9;
        Unsafe unsafe = f2306p;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int[] iArr = this.f2307a;
            if (i10 >= iArr.length) {
                this.f2318m.getClass();
                return yVar.unknownFields.b() + i11;
            }
            int W = W(i10);
            int V = V(W);
            int i12 = iArr[i10];
            long j10 = W & 1048575;
            if (V >= t.f2299j.f2303i && V <= t.f2300k.f2303i) {
                int i13 = iArr[i10 + 2];
            }
            switch (V) {
                case 0:
                    if (s(i10, yVar)) {
                        i11 = androidx.activity.g.i(i12, 8, i11);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (s(i10, yVar)) {
                        i11 = androidx.activity.g.i(i12, 4, i11);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (s(i10, yVar)) {
                        long h12 = p1.f2286c.h(j10, yVar);
                        h = n.h(i12);
                        j5 = n.j(h12);
                        d9 = j5 + h;
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (s(i10, yVar)) {
                        long h13 = p1.f2286c.h(j10, yVar);
                        h = n.h(i12);
                        j5 = n.j(h13);
                        d9 = j5 + h;
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (s(i10, yVar)) {
                        int g10 = p1.f2286c.g(j10, yVar);
                        h9 = n.h(i12);
                        f9 = n.f(g10);
                        d9 = f9 + h9;
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (s(i10, yVar)) {
                        d9 = n.d(i12);
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (s(i10, yVar)) {
                        d9 = n.c(i12);
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (s(i10, yVar)) {
                        i11 = androidx.activity.g.i(i12, 1, i11);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (s(i10, yVar)) {
                        Object i14 = p1.f2286c.i(j10, yVar);
                        if (i14 instanceof j) {
                            int h14 = n.h(i12);
                            int size = ((j) i14).size();
                            i11 = androidx.activity.g.j(size, size, h14, i11);
                            break;
                        } else {
                            h10 = n.h(i12);
                            g9 = n.g((String) i14);
                            i11 = g9 + h10 + i11;
                            break;
                        }
                    } else {
                        break;
                    }
                case 9:
                    if (s(i10, yVar)) {
                        Object i15 = p1.f2286c.i(j10, yVar);
                        d1 p5 = p(i10);
                        Class cls = e1.f2217a;
                        int h15 = n.h(i12);
                        int b9 = ((a) i15).b(p5);
                        i11 = androidx.activity.g.j(b9, b9, h15, i11);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (s(i10, yVar)) {
                        d9 = n.a(i12, (j) p1.f2286c.i(j10, yVar));
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (s(i10, yVar)) {
                        int g11 = p1.f2286c.g(j10, yVar);
                        h9 = n.h(i12);
                        f9 = n.i(g11);
                        d9 = f9 + h9;
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (s(i10, yVar)) {
                        int g12 = p1.f2286c.g(j10, yVar);
                        h9 = n.h(i12);
                        f9 = n.f(g12);
                        d9 = f9 + h9;
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (s(i10, yVar)) {
                        i11 = androidx.activity.g.i(i12, 4, i11);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (s(i10, yVar)) {
                        i11 = androidx.activity.g.i(i12, 8, i11);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (s(i10, yVar)) {
                        int g13 = p1.f2286c.g(j10, yVar);
                        h9 = n.h(i12);
                        f9 = n.i((g13 >> 31) ^ (g13 << 1));
                        d9 = f9 + h9;
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                    if (s(i10, yVar)) {
                        long h16 = p1.f2286c.h(j10, yVar);
                        h11 = n.h(i12);
                        j9 = n.j((h16 >> 63) ^ (h16 << 1));
                        d9 = j9 + h11;
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (s(i10, yVar)) {
                        d9 = n.e(i12, (a) p1.f2286c.i(j10, yVar), p(i10));
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    d9 = e1.f(i12, v(yVar, j10));
                    i11 += d9;
                    break;
                case 19:
                    d9 = e1.d(i12, v(yVar, j10));
                    i11 += d9;
                    break;
                case 20:
                    d9 = e1.j(i12, v(yVar, j10));
                    i11 += d9;
                    break;
                case 21:
                    d9 = e1.t(i12, v(yVar, j10));
                    i11 += d9;
                    break;
                case 22:
                    d9 = e1.h(i12, v(yVar, j10));
                    i11 += d9;
                    break;
                case 23:
                    d9 = e1.f(i12, v(yVar, j10));
                    i11 += d9;
                    break;
                case 24:
                    d9 = e1.d(i12, v(yVar, j10));
                    i11 += d9;
                    break;
                case 25:
                    List v8 = v(yVar, j10);
                    Class cls2 = e1.f2217a;
                    int size2 = v8.size();
                    i11 += size2 == 0 ? 0 : (n.h(i12) + 1) * size2;
                    break;
                case 26:
                    d9 = e1.q(i12, v(yVar, j10));
                    i11 += d9;
                    break;
                case 27:
                    d9 = e1.l(i12, v(yVar, j10), p(i10));
                    i11 += d9;
                    break;
                case 28:
                    d9 = e1.a(i12, v(yVar, j10));
                    i11 += d9;
                    break;
                case 29:
                    d9 = e1.r(i12, v(yVar, j10));
                    i11 += d9;
                    break;
                case 30:
                    d9 = e1.b(i12, v(yVar, j10));
                    i11 += d9;
                    break;
                case 31:
                    d9 = e1.d(i12, v(yVar, j10));
                    i11 += d9;
                    break;
                case PeerConnectionFactory.Options.ADAPTER_TYPE_ANY /* 32 */:
                    d9 = e1.f(i12, v(yVar, j10));
                    i11 += d9;
                    break;
                case 33:
                    d9 = e1.m(i12, v(yVar, j10));
                    i11 += d9;
                    break;
                case 34:
                    d9 = e1.o(i12, v(yVar, j10));
                    i11 += d9;
                    break;
                case 35:
                    int g14 = e1.g((List) unsafe.getObject(yVar, j10));
                    if (g14 > 0) {
                        i11 = androidx.activity.g.j(g14, n.h(i12), g14, i11);
                        break;
                    } else {
                        break;
                    }
                case 36:
                    int e9 = e1.e((List) unsafe.getObject(yVar, j10));
                    if (e9 > 0) {
                        i11 = androidx.activity.g.j(e9, n.h(i12), e9, i11);
                        break;
                    } else {
                        break;
                    }
                case 37:
                    int k3 = e1.k((List) unsafe.getObject(yVar, j10));
                    if (k3 > 0) {
                        i11 = androidx.activity.g.j(k3, n.h(i12), k3, i11);
                        break;
                    } else {
                        break;
                    }
                case 38:
                    int u3 = e1.u((List) unsafe.getObject(yVar, j10));
                    if (u3 > 0) {
                        i11 = androidx.activity.g.j(u3, n.h(i12), u3, i11);
                        break;
                    } else {
                        break;
                    }
                case 39:
                    int i16 = e1.i((List) unsafe.getObject(yVar, j10));
                    if (i16 > 0) {
                        i11 = androidx.activity.g.j(i16, n.h(i12), i16, i11);
                        break;
                    } else {
                        break;
                    }
                case 40:
                    int g15 = e1.g((List) unsafe.getObject(yVar, j10));
                    if (g15 > 0) {
                        i11 = androidx.activity.g.j(g15, n.h(i12), g15, i11);
                        break;
                    } else {
                        break;
                    }
                case 41:
                    int e10 = e1.e((List) unsafe.getObject(yVar, j10));
                    if (e10 > 0) {
                        i11 = androidx.activity.g.j(e10, n.h(i12), e10, i11);
                        break;
                    } else {
                        break;
                    }
                case 42:
                    List list = (List) unsafe.getObject(yVar, j10);
                    Class cls3 = e1.f2217a;
                    int size3 = list.size();
                    if (size3 > 0) {
                        i11 = androidx.activity.g.j(size3, n.h(i12), size3, i11);
                        break;
                    } else {
                        break;
                    }
                case 43:
                    int s8 = e1.s((List) unsafe.getObject(yVar, j10));
                    if (s8 > 0) {
                        i11 = androidx.activity.g.j(s8, n.h(i12), s8, i11);
                        break;
                    } else {
                        break;
                    }
                case IjkMediaMeta.FF_PROFILE_H264_CAVLC_444 /* 44 */:
                    int c9 = e1.c((List) unsafe.getObject(yVar, j10));
                    if (c9 > 0) {
                        i11 = androidx.activity.g.j(c9, n.h(i12), c9, i11);
                        break;
                    } else {
                        break;
                    }
                case 45:
                    int e11 = e1.e((List) unsafe.getObject(yVar, j10));
                    if (e11 > 0) {
                        i11 = androidx.activity.g.j(e11, n.h(i12), e11, i11);
                        break;
                    } else {
                        break;
                    }
                case 46:
                    int g16 = e1.g((List) unsafe.getObject(yVar, j10));
                    if (g16 > 0) {
                        i11 = androidx.activity.g.j(g16, n.h(i12), g16, i11);
                        break;
                    } else {
                        break;
                    }
                case 47:
                    int n4 = e1.n((List) unsafe.getObject(yVar, j10));
                    if (n4 > 0) {
                        i11 = androidx.activity.g.j(n4, n.h(i12), n4, i11);
                        break;
                    } else {
                        break;
                    }
                case 48:
                    int p7 = e1.p((List) unsafe.getObject(yVar, j10));
                    if (p7 > 0) {
                        i11 = androidx.activity.g.j(p7, n.h(i12), p7, i11);
                        break;
                    } else {
                        break;
                    }
                case 49:
                    List v9 = v(yVar, j10);
                    d1 p9 = p(i10);
                    Class cls4 = e1.f2217a;
                    int size4 = v9.size();
                    if (size4 == 0) {
                        i9 = 0;
                    } else {
                        i9 = 0;
                        for (int i17 = 0; i17 < size4; i17++) {
                            i9 += n.e(i12, (a) v9.get(i17), p9);
                        }
                    }
                    i11 += i9;
                    break;
                case l1.k.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY /* 50 */:
                    Object i18 = p1.f2286c.i(j10, yVar);
                    Object o8 = o(i10);
                    this.f2319n.getClass();
                    p0.a(i18, o8);
                    break;
                case 51:
                    if (u(i12, i10, yVar)) {
                        i11 = androidx.activity.g.i(i12, 8, i11);
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (u(i12, i10, yVar)) {
                        i11 = androidx.activity.g.i(i12, 4, i11);
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (u(i12, i10, yVar)) {
                        long F = F(j10, yVar);
                        h = n.h(i12);
                        j5 = n.j(F);
                        d9 = j5 + h;
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (u(i12, i10, yVar)) {
                        long F2 = F(j10, yVar);
                        h = n.h(i12);
                        j5 = n.j(F2);
                        d9 = j5 + h;
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (u(i12, i10, yVar)) {
                        int E = E(j10, yVar);
                        h9 = n.h(i12);
                        f9 = n.f(E);
                        d9 = f9 + h9;
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (u(i12, i10, yVar)) {
                        d9 = n.d(i12);
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (u(i12, i10, yVar)) {
                        d9 = n.c(i12);
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (u(i12, i10, yVar)) {
                        i11 = androidx.activity.g.i(i12, 1, i11);
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (u(i12, i10, yVar)) {
                        Object i19 = p1.f2286c.i(j10, yVar);
                        if (i19 instanceof j) {
                            int h17 = n.h(i12);
                            int size5 = ((j) i19).size();
                            i11 = androidx.activity.g.j(size5, size5, h17, i11);
                            break;
                        } else {
                            h10 = n.h(i12);
                            g9 = n.g((String) i19);
                            i11 = g9 + h10 + i11;
                            break;
                        }
                    } else {
                        break;
                    }
                case 60:
                    if (u(i12, i10, yVar)) {
                        Object i20 = p1.f2286c.i(j10, yVar);
                        d1 p10 = p(i10);
                        Class cls5 = e1.f2217a;
                        int h18 = n.h(i12);
                        int b10 = ((a) i20).b(p10);
                        i11 = androidx.activity.g.j(b10, b10, h18, i11);
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (u(i12, i10, yVar)) {
                        d9 = n.a(i12, (j) p1.f2286c.i(j10, yVar));
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (u(i12, i10, yVar)) {
                        int E2 = E(j10, yVar);
                        h9 = n.h(i12);
                        f9 = n.i(E2);
                        d9 = f9 + h9;
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (u(i12, i10, yVar)) {
                        int E3 = E(j10, yVar);
                        h9 = n.h(i12);
                        f9 = n.f(E3);
                        d9 = f9 + h9;
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case EglBase.EGL_OPENGL_ES3_BIT /* 64 */:
                    if (u(i12, i10, yVar)) {
                        i11 = androidx.activity.g.i(i12, 4, i11);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (u(i12, i10, yVar)) {
                        i11 = androidx.activity.g.i(i12, 8, i11);
                        break;
                    } else {
                        break;
                    }
                case IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
                    if (u(i12, i10, yVar)) {
                        int E4 = E(j10, yVar);
                        h9 = n.h(i12);
                        f9 = n.i((E4 >> 31) ^ (E4 << 1));
                        d9 = f9 + h9;
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (u(i12, i10, yVar)) {
                        long F3 = F(j10, yVar);
                        h11 = n.h(i12);
                        j9 = n.j((F3 >> 63) ^ (F3 << 1));
                        d9 = j9 + h11;
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (u(i12, i10, yVar)) {
                        d9 = n.e(i12, (a) p1.f2286c.i(j10, yVar), p(i10));
                        i11 += d9;
                        break;
                    } else {
                        break;
                    }
            }
            i10 += 3;
        }
    }

    public final boolean s(int i9, Object obj) {
        int i10 = this.f2307a[i9 + 2];
        long j5 = i10 & 1048575;
        if (j5 == 1048575) {
            int W = W(i9);
            long j9 = W & 1048575;
            switch (V(W)) {
                case 0:
                    if (Double.doubleToRawLongBits(p1.f2286c.e(j9, obj)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(p1.f2286c.f(j9, obj)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (p1.f2286c.h(j9, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (p1.f2286c.h(j9, obj) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (p1.f2286c.g(j9, obj) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (p1.f2286c.h(j9, obj) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (p1.f2286c.g(j9, obj) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return p1.f2286c.c(j9, obj);
                case 8:
                    Object i11 = p1.f2286c.i(j9, obj);
                    if (i11 instanceof String) {
                        return !((String) i11).isEmpty();
                    }
                    if (i11 instanceof j) {
                        return !j.f2248j.equals(i11);
                    }
                    m7.c.d();
                    return false;
                case 9:
                    if (p1.f2286c.i(j9, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    return !j.f2248j.equals(p1.f2286c.i(j9, obj));
                case 11:
                    if (p1.f2286c.g(j9, obj) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (p1.f2286c.g(j9, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (p1.f2286c.g(j9, obj) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (p1.f2286c.h(j9, obj) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (p1.f2286c.g(j9, obj) == 0) {
                        return false;
                    }
                    break;
                case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                    if (p1.f2286c.h(j9, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (p1.f2286c.i(j9, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    m7.c.d();
                    return false;
            }
        } else if (((1 << (i10 >>> 20)) & p1.f2286c.g(j5, obj)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean u(int i9, int i10, Object obj) {
        return p1.f2286c.g((long) (this.f2307a[i10 + 2] & 1048575), obj) == i9;
    }

    public final void w(Object obj, int i9, Object obj2) {
        long W = W(i9) & 1048575;
        Object i10 = p1.f2286c.i(W, obj);
        p0 p0Var = this.f2319n;
        if (i10 != null) {
            p0Var.getClass();
            if (!((o0) i10).f2281i) {
                o0 c9 = o0.f2280j.c();
                p0.b(c9, i10);
                p1.p(W, obj, c9);
                i10 = c9;
            }
        } else {
            p0Var.getClass();
            i10 = o0.f2280j.c();
            p1.p(W, obj, i10);
        }
        p0Var.getClass();
        androidx.activity.g.w(obj2);
        throw null;
    }

    public final void x(Object obj, int i9, Object obj2) {
        if (s(i9, obj2)) {
            long W = W(i9) & 1048575;
            Unsafe unsafe = f2306p;
            Object object = unsafe.getObject(obj2, W);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f2307a[i9] + " is present but null: " + obj2);
            }
            d1 p5 = p(i9);
            if (!s(i9, obj)) {
                if (t(object)) {
                    Object i10 = p5.i();
                    p5.b(i10, object);
                    unsafe.putObject(obj, W, i10);
                } else {
                    unsafe.putObject(obj, W, object);
                }
                Q(i9, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, W);
            if (!t(object2)) {
                Object i11 = p5.i();
                p5.b(i11, object2);
                unsafe.putObject(obj, W, i11);
                object2 = i11;
            }
            p5.b(object2, object);
        }
    }

    public final void y(Object obj, int i9, Object obj2) {
        int[] iArr = this.f2307a;
        int i10 = iArr[i9];
        if (u(i10, i9, obj2)) {
            long W = W(i9) & 1048575;
            Unsafe unsafe = f2306p;
            Object object = unsafe.getObject(obj2, W);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i9] + " is present but null: " + obj2);
            }
            d1 p5 = p(i9);
            if (!u(i10, i9, obj)) {
                if (t(object)) {
                    Object i11 = p5.i();
                    p5.b(i11, object);
                    unsafe.putObject(obj, W, i11);
                } else {
                    unsafe.putObject(obj, W, object);
                }
                R(i10, i9, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, W);
            if (!t(object2)) {
                Object i12 = p5.i();
                p5.b(i12, object2);
                unsafe.putObject(obj, W, i12);
                object2 = i12;
            }
            p5.b(object2, object);
        }
    }

    public final Object z(int i9, Object obj) {
        d1 p5 = p(i9);
        long W = W(i9) & 1048575;
        if (!s(i9, obj)) {
            return p5.i();
        }
        Object object = f2306p.getObject(obj, W);
        if (t(object)) {
            return object;
        }
        Object i10 = p5.i();
        if (object != null) {
            p5.b(i10, object);
        }
        return i10;
    }
}
