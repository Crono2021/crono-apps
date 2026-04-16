package g1;

import android.opengl.GLES20;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import i3.c0;
import i3.d0;
import i3.e0;
import i3.f0;
import i3.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e implements z {

    /* renamed from: i, reason: collision with root package name */
    public final int f3668i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f3669j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f3670k;

    /* renamed from: l, reason: collision with root package name */
    public final Cloneable f3671l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f3672m;

    public e(String str, String str2) {
        int glCreateProgram = GLES20.glCreateProgram();
        this.f3668i = glCreateProgram;
        a.g();
        a(glCreateProgram, 35633, str);
        a(glCreateProgram, 35632, str2);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        a.h("Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(glCreateProgram), iArr[0] == 1);
        GLES20.glUseProgram(glCreateProgram);
        this.f3671l = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35721, iArr2, 0);
        this.f3669j = new d4.t[iArr2[0]];
        for (int i9 = 0; i9 < iArr2[0]; i9++) {
            int i10 = this.f3668i;
            int[] iArr3 = new int[1];
            GLES20.glGetProgramiv(i10, 35722, iArr3, 0);
            int i11 = iArr3[0];
            byte[] bArr = new byte[i11];
            GLES20.glGetActiveAttrib(i10, i9, i11, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            int i12 = 0;
            while (true) {
                if (i12 >= i11) {
                    break;
                }
                if (bArr[i12] == 0) {
                    i11 = i12;
                    break;
                }
                i12++;
            }
            String str3 = new String(bArr, 0, i11);
            GLES20.glGetAttribLocation(i10, str3);
            d4.t tVar = new d4.t(8);
            ((d4.t[]) this.f3669j)[i9] = tVar;
            ((HashMap) this.f3671l).put(str3, tVar);
        }
        this.f3672m = new HashMap();
        int[] iArr4 = new int[1];
        GLES20.glGetProgramiv(this.f3668i, 35718, iArr4, 0);
        this.f3670k = new d4.t[iArr4[0]];
        for (int i13 = 0; i13 < iArr4[0]; i13++) {
            int i14 = this.f3668i;
            int[] iArr5 = new int[1];
            GLES20.glGetProgramiv(i14, 35719, iArr5, 0);
            int i15 = iArr5[0];
            byte[] bArr2 = new byte[i15];
            GLES20.glGetActiveUniform(i14, i13, i15, new int[1], 0, new int[1], 0, new int[1], 0, bArr2, 0);
            int i16 = 0;
            while (true) {
                if (i16 >= i15) {
                    break;
                }
                if (bArr2[i16] == 0) {
                    i15 = i16;
                    break;
                }
                i16++;
            }
            String str4 = new String(bArr2, 0, i15);
            GLES20.glGetUniformLocation(i14, str4);
            d4.t tVar2 = new d4.t(9);
            ((d4.t[]) this.f3670k)[i13] = tVar2;
            ((HashMap) this.f3672m).put(str4, tVar2);
        }
        a.g();
    }

    public static void a(int i9, int i10, String str) {
        int glCreateShader = GLES20.glCreateShader(i10);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        a.h(GLES20.glGetShaderInfoLog(glCreateShader) + ", source: " + str, iArr[0] == 1);
        GLES20.glAttachShader(i9, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        a.g();
    }

    public int b(String str) {
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f3668i, str);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        a.g();
        return glGetAttribLocation;
    }

    @Override // i3.z
    public void c(p pVar) {
        u uVar;
        u uVar2;
        SparseArray sparseArray;
        int i9;
        a3.g gVar;
        int i10;
        int i11;
        u uVar3;
        SparseArray sparseArray2 = (SparseArray) this.f3670k;
        SparseIntArray sparseIntArray = (SparseIntArray) this.f3671l;
        a3.g gVar2 = (a3.g) this.f3669j;
        c0 c0Var = (c0) this.f3672m;
        SparseArray sparseArray3 = c0Var.h;
        SparseBooleanArray sparseBooleanArray = c0Var.f4436i;
        d4.i iVar = c0Var.f4434f;
        List list = c0Var.f4431c;
        int i12 = c0Var.f4429a;
        if (pVar.t() == 2) {
            if (i12 == 1 || i12 == 2 || c0Var.f4441n == 1) {
                uVar = (u) list.get(0);
            } else {
                uVar = new u(((u) list.get(0)).d());
                list.add(uVar);
            }
            if ((pVar.t() & 128) != 0) {
                pVar.G(1);
                int z8 = pVar.z();
                pVar.G(3);
                pVar.e(0, 2, gVar2.f104b);
                gVar2.p(0);
                gVar2.s(3);
                c0Var.f4447t = gVar2.i(13);
                pVar.e(0, 2, gVar2.f104b);
                gVar2.p(0);
                gVar2.s(4);
                pVar.G(gVar2.i(12));
                if (i12 == 2 && c0Var.f4445r == null) {
                    f0 d9 = iVar.d(21, new o(21, null, 0, null, w.f3718f));
                    c0Var.f4445r = d9;
                    if (d9 != null) {
                        d9.f(uVar, c0Var.f4440m, new e0(z8, 21, 8192));
                    }
                }
                sparseArray2.clear();
                sparseIntArray.clear();
                int a9 = pVar.a();
                while (a9 > 0) {
                    pVar.e(0, 5, gVar2.f104b);
                    gVar2.p(0);
                    int i13 = gVar2.i(8);
                    gVar2.s(3);
                    int i14 = gVar2.i(13);
                    gVar2.s(4);
                    int i15 = gVar2.i(12);
                    int i16 = pVar.f3700b;
                    int i17 = i16 + i15;
                    int i18 = a9;
                    String str = null;
                    ArrayList arrayList = null;
                    int i19 = -1;
                    int i20 = 0;
                    while (true) {
                        if (pVar.f3700b >= i17) {
                            gVar = gVar2;
                            break;
                        }
                        int t8 = pVar.t();
                        gVar = gVar2;
                        int t9 = pVar.f3700b + pVar.t();
                        if (t9 > i17) {
                            break;
                        }
                        SparseArray sparseArray4 = sparseArray3;
                        if (t8 == 5) {
                            long v8 = pVar.v();
                            if (v8 == 1094921523) {
                                i19 = 129;
                            } else if (v8 == 1161904947) {
                                i19 = 135;
                            } else {
                                if (v8 != 1094921524) {
                                    if (v8 == 1212503619) {
                                        i19 = 36;
                                    }
                                }
                                i19 = 172;
                            }
                            i10 = t9;
                            i11 = z8;
                            uVar3 = uVar;
                        } else if (t8 == 106) {
                            i10 = t9;
                            i11 = z8;
                            uVar3 = uVar;
                            i19 = 129;
                        } else if (t8 == 122) {
                            i10 = t9;
                            i11 = z8;
                            uVar3 = uVar;
                            i19 = 135;
                        } else if (t8 == 127) {
                            int t10 = pVar.t();
                            if (t10 != 21) {
                                if (t10 == 14) {
                                    i19 = 136;
                                } else if (t10 == 33) {
                                    i19 = 139;
                                }
                                i10 = t9;
                                i11 = z8;
                                uVar3 = uVar;
                            }
                            i19 = 172;
                            i10 = t9;
                            i11 = z8;
                            uVar3 = uVar;
                        } else if (t8 == 123) {
                            i10 = t9;
                            i11 = z8;
                            uVar3 = uVar;
                            i19 = 138;
                        } else if (t8 == 10) {
                            str = pVar.r(3, a6.b.f203c).trim();
                            i10 = t9;
                            i20 = pVar.t();
                            i11 = z8;
                            uVar3 = uVar;
                        } else if (t8 == 89) {
                            ArrayList arrayList2 = new ArrayList();
                            while (pVar.f3700b < t9) {
                                String trim = pVar.r(3, a6.b.f203c).trim();
                                pVar.t();
                                u uVar4 = uVar;
                                byte[] bArr = new byte[4];
                                pVar.e(0, 4, bArr);
                                arrayList2.add(new d0(trim, bArr));
                                uVar = uVar4;
                                t9 = t9;
                                z8 = z8;
                            }
                            i10 = t9;
                            i11 = z8;
                            uVar3 = uVar;
                            arrayList = arrayList2;
                            i19 = 89;
                        } else {
                            i10 = t9;
                            i11 = z8;
                            uVar3 = uVar;
                            if (t8 == 111) {
                                i19 = 257;
                            }
                        }
                        pVar.G(i10 - pVar.f3700b);
                        uVar = uVar3;
                        gVar2 = gVar;
                        sparseArray3 = sparseArray4;
                        z8 = i11;
                    }
                    SparseArray sparseArray5 = sparseArray3;
                    int i21 = z8;
                    u uVar5 = uVar;
                    pVar.F(i17);
                    o oVar = new o(i19, str, i20, arrayList, Arrays.copyOfRange(pVar.f3699a, i16, i17));
                    if (i13 == 6 || i13 == 5) {
                        i13 = i19;
                    }
                    int i22 = i18 - (i15 + 5);
                    int i23 = i12 == 2 ? i13 : i14;
                    if (!sparseBooleanArray.get(i23)) {
                        f0 d10 = (i12 == 2 && i13 == 21) ? c0Var.f4445r : iVar.d(i13, oVar);
                        if (i12 != 2 || i14 < sparseIntArray.get(i23, 8192)) {
                            sparseIntArray.put(i23, i14);
                            sparseArray2.put(i23, d10);
                        }
                    }
                    a9 = i22;
                    uVar = uVar5;
                    gVar2 = gVar;
                    sparseArray3 = sparseArray5;
                    z8 = i21;
                }
                SparseArray sparseArray6 = sparseArray3;
                int i24 = z8;
                u uVar6 = uVar;
                int size = sparseIntArray.size();
                int i25 = 0;
                while (i25 < size) {
                    int keyAt = sparseIntArray.keyAt(i25);
                    int valueAt = sparseIntArray.valueAt(i25);
                    sparseBooleanArray.put(keyAt, true);
                    c0Var.f4437j.put(valueAt, true);
                    f0 f0Var = (f0) sparseArray2.valueAt(i25);
                    if (f0Var != null) {
                        if (f0Var != c0Var.f4445r) {
                            i9 = i24;
                            uVar2 = uVar6;
                            f0Var.f(uVar2, c0Var.f4440m, new e0(i9, keyAt, 8192));
                        } else {
                            uVar2 = uVar6;
                            i9 = i24;
                        }
                        sparseArray = sparseArray6;
                        sparseArray.put(valueAt, f0Var);
                    } else {
                        uVar2 = uVar6;
                        sparseArray = sparseArray6;
                        i9 = i24;
                    }
                    i25++;
                    sparseArray6 = sparseArray;
                    i24 = i9;
                    uVar6 = uVar2;
                }
                SparseArray sparseArray7 = sparseArray6;
                if (i12 == 2) {
                    if (c0Var.f4442o) {
                        return;
                    }
                    c0Var.f4440m.c();
                    c0Var.f4441n = 0;
                    c0Var.f4442o = true;
                    return;
                }
                sparseArray7.remove(this.f3668i);
                int i26 = i12 == 1 ? 0 : c0Var.f4441n - 1;
                c0Var.f4441n = i26;
                if (i26 == 0) {
                    c0Var.f4440m.c();
                    c0Var.f4442o = true;
                }
            }
        }
    }

    @Override // i3.z
    public void f(u uVar, d2.o oVar, e0 e0Var) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(d2.w wVar, a0.b bVar, byte[] bArr, d2.f0[] f0VarArr, int i9) {
        this.f3669j = wVar;
        this.f3670k = bVar;
        this.f3671l = bArr;
        this.f3672m = f0VarArr;
        this.f3668i = i9;
    }

    public e(c0 c0Var, int i9) {
        this.f3672m = c0Var;
        this.f3669j = new a3.g(new byte[5], 5);
        this.f3670k = new SparseArray();
        this.f3671l = new SparseIntArray();
        this.f3668i = i9;
    }
}
