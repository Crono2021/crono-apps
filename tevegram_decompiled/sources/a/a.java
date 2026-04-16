package a;

import a8.l;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import b8.r;
import c0.h;
import com.google.crypto.tink.shaded.protobuf.j;
import f0.f;
import f3.g;
import g0.b;
import g1.p;
import i8.w;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k8.d;
import m7.c;
import n.a0;
import n.b4;
import n.z3;
import n0.y0;
import n8.s;
import r0.m;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static Method f0a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f1b;

    /* renamed from: c, reason: collision with root package name */
    public static Field f2c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f3d;

    /* renamed from: e, reason: collision with root package name */
    public static Method f4e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f5f;

    /* renamed from: g, reason: collision with root package name */
    public static Field f6g;
    public static boolean h;

    public static boolean A(int i9, Rect rect, Rect rect2) {
        if (i9 == 17) {
            int i10 = rect.right;
            int i11 = rect2.right;
            return (i10 > i11 || rect.left >= i11) && rect.left > rect2.left;
        }
        if (i9 == 33) {
            int i12 = rect.bottom;
            int i13 = rect2.bottom;
            return (i12 > i13 || rect.top >= i13) && rect.top > rect2.top;
        }
        if (i9 == 66) {
            int i14 = rect.left;
            int i15 = rect2.left;
            return (i14 < i15 || rect.right <= i15) && rect.right < rect2.right;
        }
        if (i9 != 130) {
            c.n("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            return false;
        }
        int i16 = rect.top;
        int i17 = rect2.top;
        return (i16 < i17 || rect.bottom <= i17) && rect.bottom < rect2.bottom;
    }

    public static int B(int i9, Rect rect, Rect rect2) {
        int i10;
        int i11;
        if (i9 == 17) {
            i10 = rect.left;
            i11 = rect2.right;
        } else if (i9 == 33) {
            i10 = rect.top;
            i11 = rect2.bottom;
        } else if (i9 == 66) {
            i10 = rect2.left;
            i11 = rect.right;
        } else {
            if (i9 != 130) {
                c.n("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                return 0;
            }
            i10 = rect2.top;
            i11 = rect.bottom;
        }
        return Math.max(0, i10 - i11);
    }

    public static int C(int i9, Rect rect, Rect rect2) {
        if (i9 != 17) {
            if (i9 != 33) {
                if (i9 != 66) {
                    if (i9 != 130) {
                        c.n("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        return 0;
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }

    public static void F(String str) {
        try {
            Class<?> cls = Class.forName(str);
            try {
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + cls.getDeclaredConstructor(null).newInstance(null));
            } catch (IllegalAccessException e9) {
                S(cls, e9);
                throw null;
            } catch (InstantiationException e10) {
                S(cls, e10);
                throw null;
            } catch (NoSuchMethodException e11) {
                S(cls, e11);
                throw null;
            } catch (InvocationTargetException e12) {
                S(cls, e12);
                throw null;
            }
        } catch (ClassNotFoundException e13) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e13);
        }
    }

    public static long G(p pVar, int i9, int i10) {
        pVar.F(i9);
        if (pVar.a() < 5) {
            return -9223372036854775807L;
        }
        int g9 = pVar.g();
        if ((8388608 & g9) != 0 || ((2096896 & g9) >> 8) != i10 || (g9 & 32) == 0 || pVar.t() < 7 || pVar.a() < 7 || (pVar.t() & 16) != 16) {
            return -9223372036854775807L;
        }
        pVar.e(0, 6, new byte[6]);
        return ((r0[0] & 255) << 25) | ((r0[1] & 255) << 17) | ((r0[2] & 255) << 9) | ((r0[3] & 255) << 1) | ((255 & r0[4]) >> 7);
    }

    public static g H(g gVar, String[] strArr, Map map) {
        int i9 = 0;
        if (gVar == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return (g) map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                g gVar2 = new g();
                int length = strArr.length;
                while (i9 < length) {
                    gVar2.a((g) map.get(strArr[i9]));
                    i9++;
                }
                return gVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                gVar.a((g) map.get(strArr[0]));
                return gVar;
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i9 < length2) {
                    gVar.a((g) map.get(strArr[i9]));
                    i9++;
                }
            }
        }
        return gVar;
    }

    public static int I(long j5) {
        if (j5 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j5 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j5;
    }

    public static void M(a0 a0Var, boolean z8) {
        if (Build.VERSION.SDK_INT >= 23) {
            m.c(a0Var, z8);
            return;
        }
        if (!f3d) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f2c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e9) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e9);
            }
            f3d = true;
        }
        Field field = f2c;
        if (field != null) {
            try {
                field.set(a0Var, Boolean.valueOf(z8));
            } catch (IllegalAccessException e10) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e10);
            }
        }
    }

    public static void O(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            z3.a(view, charSequence);
            return;
        }
        b4 b4Var = b4.f6801s;
        if (b4Var != null && b4Var.f6803i == view) {
            b4.b(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new b4(view, charSequence);
            return;
        }
        b4 b4Var2 = b4.f6802t;
        if (b4Var2 != null && b4Var2.f6803i == view) {
            b4Var2.a();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public static void Q(PopupWindow popupWindow, int i9) {
        if (Build.VERSION.SDK_INT >= 23) {
            m.d(popupWindow, i9);
            return;
        }
        if (!f1b) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f0a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f1b = true;
        }
        Method method = f0a;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i9));
            } catch (Exception unused2) {
            }
        }
    }

    public static final Object R(s sVar, s sVar2, a8.p pVar) {
        Object mVar;
        Object D;
        try {
            r.a(2, pVar);
            mVar = pVar.h(sVar2, sVar);
        } catch (Throwable th) {
            mVar = new i8.m(th, false);
        }
        s7.a aVar = s7.a.f8891i;
        if (mVar == aVar || (D = sVar.D(mVar)) == w.f5315e) {
            return aVar;
        }
        if (D instanceof i8.m) {
            throw ((i8.m) D).f5289a;
        }
        return w.o(D);
    }

    public static void S(Class cls, ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, reflectiveOperationException);
    }

    public static int[] T(Collection collection) {
        if (collection instanceof d6.a) {
            d6.a aVar = (d6.a) collection;
            return Arrays.copyOfRange(aVar.f2961i, aVar.f2962j, aVar.f2963k);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i9 = 0; i9 < length; i9++) {
            Object obj = array[i9];
            obj.getClass();
            iArr[i9] = ((Number) obj).intValue();
        }
        return iArr;
    }

    public static String U(String str) {
        int length = str.length();
        int i9 = 0;
        while (i9 < length) {
            char charAt = str.charAt(i9);
            if (charAt >= 'A' && charAt <= 'Z') {
                char[] charArray = str.toCharArray();
                while (i9 < length) {
                    char c9 = charArray[i9];
                    if (c9 >= 'A' && c9 <= 'Z') {
                        charArray[i9] = (char) (c9 ^ ' ');
                    }
                    i9++;
                }
                return String.valueOf(charArray);
            }
            i9++;
        }
        return str;
    }

    public static String V(String str) {
        int length = str.length();
        int i9 = 0;
        while (i9 < length) {
            char charAt = str.charAt(i9);
            if (charAt >= 'a' && charAt <= 'z') {
                char[] charArray = str.toCharArray();
                while (i9 < length) {
                    char c9 = charArray[i9];
                    if (c9 >= 'a' && c9 <= 'z') {
                        charArray[i9] = (char) (c9 ^ ' ');
                    }
                    i9++;
                }
                return String.valueOf(charArray);
            }
            i9++;
        }
        return str;
    }

    public static final void W(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i9) {
        if (i9 < 0 || byteBuffer2.remaining() < i9 || byteBuffer3.remaining() < i9 || byteBuffer.remaining() < i9) {
            c.n("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
            return;
        }
        for (int i10 = 0; i10 < i9; i10++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    public static final byte[] X(byte[] bArr, int i9, byte[] bArr2, int i10, int i11) {
        if (i11 < 0 || bArr.length - i11 < i9 || bArr2.length - i11 < i10) {
            c.n("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
            return null;
        }
        byte[] bArr3 = new byte[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            bArr3[i12] = (byte) (bArr[i12 + i9] ^ bArr2[i12 + i10]);
        }
        return bArr3;
    }

    public static final byte[] Y(byte[] bArr, byte[] bArr2) {
        if (bArr.length == bArr2.length) {
            return X(bArr, 0, bArr2, 0, bArr.length);
        }
        c.n("The lengths of x and y should match.");
        return null;
    }

    public static List a(int... iArr) {
        return iArr.length == 0 ? Collections.EMPTY_LIST : new d6.a(0, iArr.length, iArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        if (r9.bottom <= r11.top) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
    
        if (r8 == 17) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
    
        if (r8 != 66) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0046, code lost:
    
        r10 = B(r8, r9, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
    
        if (r8 == 17) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
    
        if (r8 == 33) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
    
        if (r8 == 66) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0050, code lost:
    
        if (r8 != 130) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
    
        r8 = r11.bottom;
        r9 = r9.bottom;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
    
        if (r10 >= java.lang.Math.max(1, r8 - r9)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        m7.c.n("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        r8 = r11.right;
        r9 = r9.right;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
    
        r8 = r9.top;
        r9 = r11.top;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
    
        r8 = r9.left;
        r9 = r11.left;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0031, code lost:
    
        if (r9.right <= r11.left) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0038, code lost:
    
        if (r9.top >= r11.bottom) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x003f, code lost:
    
        if (r9.left >= r11.right) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(int r8, android.graphics.Rect r9, android.graphics.Rect r10, android.graphics.Rect r11) {
        /*
            boolean r0 = c(r8, r9, r10)
            boolean r1 = c(r8, r9, r11)
            if (r1 != 0) goto L72
            if (r0 != 0) goto Le
            goto L72
        Le:
            java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1 = 130(0x82, float:1.82E-43)
            r2 = 33
            r3 = 66
            r4 = 17
            r5 = 1
            if (r8 == r4) goto L3b
            if (r8 == r2) goto L34
            if (r8 == r3) goto L2d
            if (r8 != r1) goto L28
            int r6 = r9.bottom
            int r7 = r11.top
            if (r6 > r7) goto L71
            goto L41
        L28:
            m7.c.n(r0)
        L2b:
            r8 = 0
            return r8
        L2d:
            int r6 = r9.right
            int r7 = r11.left
            if (r6 > r7) goto L71
            goto L41
        L34:
            int r6 = r9.top
            int r7 = r11.bottom
            if (r6 < r7) goto L71
            goto L41
        L3b:
            int r6 = r9.left
            int r7 = r11.right
            if (r6 < r7) goto L71
        L41:
            if (r8 == r4) goto L71
            if (r8 != r3) goto L46
            goto L71
        L46:
            int r10 = B(r8, r9, r10)
            if (r8 == r4) goto L66
            if (r8 == r2) goto L61
            if (r8 == r3) goto L5c
            if (r8 != r1) goto L58
            int r8 = r11.bottom
            int r9 = r9.bottom
        L56:
            int r8 = r8 - r9
            goto L6b
        L58:
            m7.c.n(r0)
            goto L2b
        L5c:
            int r8 = r11.right
            int r9 = r9.right
            goto L56
        L61:
            int r8 = r9.top
            int r9 = r11.top
            goto L56
        L66:
            int r8 = r9.left
            int r9 = r11.left
            goto L56
        L6b:
            int r8 = java.lang.Math.max(r5, r8)
            if (r10 >= r8) goto L72
        L71:
            return r5
        L72:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.b(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static boolean c(int i9, Rect rect, Rect rect2) {
        if (i9 != 17) {
            if (i9 != 33) {
                if (i9 != 66) {
                    if (i9 != 130) {
                        c.n("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        return false;
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static final void d(View view) {
        view.getClass();
        y0 y0Var = new y0(view, null);
        g8.c cVar = new g8.c();
        cVar.f3848l = y0Var.j(cVar, cVar);
        while (cVar.hasNext()) {
            View view2 = (View) cVar.next();
            t0.a aVar = (t0.a) view2.getTag(2131362286);
            if (aVar == null) {
                aVar = new t0.a();
                view2.setTag(2131362286, aVar);
            }
            ArrayList arrayList = aVar.f8915a;
            arrayList.getClass();
            int size = arrayList.size() - 1;
            if (-1 < size) {
                arrayList.get(size).getClass();
                androidx.fragment.app.a.c();
                return;
            }
        }
    }

    public static boolean e(f[] fVarArr, f[] fVarArr2) {
        if (fVarArr == null || fVarArr2 == null || fVarArr.length != fVarArr2.length) {
            return false;
        }
        for (int i9 = 0; i9 < fVarArr.length; i9++) {
            f fVar = fVarArr[i9];
            char c9 = fVar.f3198a;
            f fVar2 = fVarArr2[i9];
            if (c9 != fVar2.f3198a || fVar.f3199b.length != fVar2.f3199b.length) {
                return false;
            }
        }
        return true;
    }

    public static void f(String str, long j5) {
        if (j5 >= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " (" + j5 + ") must be >= 0");
    }

    public static int g(Context context, String str) {
        boolean z8;
        if (str == null) {
            c.o("permission must be non-null");
            return 0;
        }
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        c0.s sVar = new c0.s(context);
        if (i9 >= 24) {
            z8 = c0.r.a(sVar.f1543a);
        } else {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i10 = applicationInfo.uid;
            try {
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class<?> cls2 = Integer.TYPE;
                Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
                Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
                num.getClass();
                if (((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i10), packageName)).intValue() != 0) {
                    z8 = false;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            }
            z8 = true;
        }
        return z8 ? 0 : -1;
    }

    public static int h(long j5) {
        int i9 = (int) j5;
        com.bumptech.glide.c.e(j5, "Out of range: %s", ((long) i9) == j5);
        return i9;
    }

    public static void i(d dVar) {
        boolean z8;
        long j5;
        int i9;
        d dVar2;
        Object obj;
        AtomicLongFieldUpdater atomicLongFieldUpdater = d.f5638c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d.f5644j;
        a6.d dVar3 = k8.f.f5665s;
        while (true) {
            if (atomicReferenceFieldUpdater.compareAndSet(dVar, dVar3, null)) {
                z8 = true;
                break;
            } else if (atomicReferenceFieldUpdater.get(dVar) != dVar3) {
                z8 = false;
                break;
            }
        }
        while (true) {
            long j9 = atomicLongFieldUpdater.get(dVar);
            int i10 = (int) (j9 >> 60);
            if (i10 == 0) {
                j5 = j9 & 1152921504606846975L;
                i9 = 2;
            } else if (i10 != 1) {
                dVar2 = dVar;
                break;
            } else {
                j5 = j9 & 1152921504606846975L;
                i9 = 3;
            }
            d dVar4 = dVar;
            boolean compareAndSet = atomicLongFieldUpdater.compareAndSet(dVar4, j9, (i9 << 60) + j5);
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = atomicLongFieldUpdater;
            dVar2 = dVar4;
            if (compareAndSet) {
                break;
            }
            dVar = dVar2;
            atomicLongFieldUpdater = atomicLongFieldUpdater2;
        }
        dVar2.h();
        if (z8) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = d.f5645k;
            loop2: while (true) {
                obj = atomicReferenceFieldUpdater2.get(dVar2);
                a6.d dVar5 = obj == null ? k8.f.f5663q : k8.f.f5664r;
                while (!atomicReferenceFieldUpdater2.compareAndSet(dVar2, obj, dVar5)) {
                    if (atomicReferenceFieldUpdater2.get(dVar2) != obj) {
                        break;
                    }
                }
            }
            if (obj == null) {
                return;
            }
            r.a(1, obj);
            ((l) obj).a(dVar2.l());
        }
    }

    public static byte[] j(byte[]... bArr) {
        int i9 = 0;
        for (byte[] bArr2 : bArr) {
            if (i9 > Integer.MAX_VALUE - bArr2.length) {
                androidx.fragment.app.a.o("exceeded size limit");
                return null;
            }
            i9 += bArr2.length;
        }
        byte[] bArr3 = new byte[i9];
        int i10 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, i10, bArr4.length);
            i10 += bArr4.length;
        }
        return bArr3;
    }

    public static int k(int i9, int i10) {
        if (i10 <= 1073741823) {
            return Math.min(Math.max(i9, i10), 1073741823);
        }
        c.n(com.bumptech.glide.d.M("min (%s) must be less than or equal to max (%s)", Integer.valueOf(i10), 1073741823));
        return 0;
    }

    public static float[] l(float[] fArr, int i9) {
        if (i9 < 0) {
            c.d();
            return null;
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int min = Math.min(i9, length);
        float[] fArr2 = new float[i9];
        System.arraycopy(fArr, 0, fArr2, 0, min);
        return fArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009c A[Catch: NumberFormatException -> 0x00b0, LOOP:3: B:29:0x006e->B:39:0x009c, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00b0, blocks: (B:26:0x005a, B:29:0x006e, B:31:0x0074, B:35:0x0080, B:39:0x009c, B:43:0x00a2, B:48:0x00b7, B:60:0x00ba), top: B:25:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a2 A[Catch: NumberFormatException -> 0x00b0, TryCatch #0 {NumberFormatException -> 0x00b0, blocks: (B:26:0x005a, B:29:0x006e, B:31:0x0074, B:35:0x0080, B:39:0x009c, B:43:0x00a2, B:48:0x00b7, B:60:0x00ba), top: B:25:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b7 A[Catch: NumberFormatException -> 0x00b0, TryCatch #0 {NumberFormatException -> 0x00b0, blocks: (B:26:0x005a, B:29:0x006e, B:31:0x0074, B:35:0x0080, B:39:0x009c, B:43:0x00a2, B:48:0x00b7, B:60:0x00ba), top: B:25:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static f0.f[] m(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.m(java.lang.String):f0.f[]");
    }

    public static Path n(String str) {
        Path path = new Path();
        f[] m9 = m(str);
        if (m9 == null) {
            return null;
        }
        try {
            f.b(m9, path);
            return path;
        } catch (RuntimeException e9) {
            c.k("Error in parsing ".concat(str), e9);
            return null;
        }
    }

    public static Drawable o(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        boolean z8 = Build.VERSION.SDK_INT < 23;
        if (drawable == null) {
            return null;
        }
        if (colorStateList == null) {
            if (z8) {
                drawable.mutate();
            }
            return drawable;
        }
        Drawable mutate = com.bumptech.glide.d.f0(drawable).mutate();
        if (mode != null) {
            b.i(mutate, mode);
        }
        return mutate;
    }

    public static f[] p(f[] fVarArr) {
        if (fVarArr == null) {
            return null;
        }
        f[] fVarArr2 = new f[fVarArr.length];
        for (int i9 = 0; i9 < fVarArr.length; i9++) {
            f fVar = fVarArr[i9];
            f fVar2 = new f();
            fVar2.f3198a = fVar.f3198a;
            float[] fArr = fVar.f3199b;
            fVar2.f3199b = l(fArr, fArr.length);
            fVarArr2[i9] = fVar2;
        }
        return fVarArr2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:231:0x052f, code lost:
    
        r1 = new w6.b[]{r14, r3}[1].f9972b;
        r3 = r4 - r1.length;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0541, code lost:
    
        if (r5 >= r3) goto L550;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0543, code lost:
    
        r9[r30 + r5] = 0;
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x054a, code lost:
    
        java.lang.System.arraycopy(r1, 0, r9, r30 + r3, r1.length);
        r1 = new byte[r4];
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0553, code lost:
    
        if (r2 >= r4) goto L551;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0555, code lost:
    
        r1[r2] = (byte) r9[r7 + r2];
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x055f, code lost:
    
        r0.add(new z6.a(r10, r1));
        r11 = java.lang.Math.max(r11, r7);
        r13 = java.lang.Math.max(r13, r4);
        r5 = r33 + r15[0];
        r4 = r21 + 1;
        r9 = r25;
        r1 = r28;
        r8 = r29;
        r2 = r31;
        r3 = r32;
        r7 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x06f2, code lost:
    
        if (r8 == false) goto L389;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x06d8  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x06ff  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x074d  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0778 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:425:0x0771  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:556:0x016d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static v6.b q(java.lang.String r41) {
        /*
            Method dump skipped, instructions count: 2313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.q(java.lang.String):v6.b");
    }

    public static boolean r(CharSequence charSequence, String str) {
        int i9;
        char c9;
        int length = charSequence.length();
        if (charSequence == str) {
            return true;
        }
        if (length == str.length()) {
            while (i9 < length) {
                char charAt = charSequence.charAt(i9);
                char charAt2 = str.charAt(i9);
                i9 = (charAt == charAt2 || ((c9 = (char) ((charAt | ' ') + (-97))) < 26 && c9 == ((char) ((charAt2 | ' ') + (-97))))) ? i9 + 1 : 0;
            }
            return true;
        }
        return false;
    }

    public static String s(j jVar) {
        StringBuilder sb = new StringBuilder(jVar.size());
        for (int i9 = 0; i9 < jVar.size(); i9++) {
            byte f9 = jVar.f(i9);
            if (f9 == 34) {
                sb.append("\\\"");
            } else if (f9 == 39) {
                sb.append("\\'");
            } else if (f9 != 92) {
                switch (f9) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (f9 < 32 || f9 > 126) {
                            sb.append('\\');
                            sb.append((char) (((f9 >>> 6) & 3) + 48));
                            sb.append((char) (((f9 >>> 3) & 7) + 48));
                            sb.append((char) ((f9 & 7) + 48));
                            break;
                        } else {
                            sb.append((char) f9);
                            break;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static int t(Context context, int i9) {
        return Build.VERSION.SDK_INT >= 23 ? d0.d.a(context, i9) : context.getResources().getColor(i9);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0046, code lost:
    
        if (r5.f2995c == r8.hashCode()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList u(android.content.Context r8, int r9) {
        /*
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.Resources$Theme r8 = r8.getTheme()
            e0.l r1 = new e0.l
            r1.<init>(r0, r8)
            java.lang.Object r2 = e0.o.f3003c
            monitor-enter(r2)
            java.util.WeakHashMap r3 = e0.o.f3002b     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L3c
            android.util.SparseArray r3 = (android.util.SparseArray) r3     // Catch: java.lang.Throwable -> L3c
            r4 = 0
            if (r3 == 0) goto L4f
            int r5 = r3.size()     // Catch: java.lang.Throwable -> L3c
            if (r5 <= 0) goto L4f
            java.lang.Object r5 = r3.get(r9)     // Catch: java.lang.Throwable -> L3c
            e0.k r5 = (e0.k) r5     // Catch: java.lang.Throwable -> L3c
            if (r5 == 0) goto L4f
            android.content.res.Configuration r6 = r5.f2994b     // Catch: java.lang.Throwable -> L3c
            android.content.res.Configuration r7 = r0.getConfiguration()     // Catch: java.lang.Throwable -> L3c
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L4c
            if (r8 != 0) goto L3e
            int r6 = r5.f2995c     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L48
            goto L3e
        L3c:
            r8 = move-exception
            goto L9c
        L3e:
            if (r8 == 0) goto L4c
            int r6 = r5.f2995c     // Catch: java.lang.Throwable -> L3c
            int r7 = r8.hashCode()     // Catch: java.lang.Throwable -> L3c
            if (r6 != r7) goto L4c
        L48:
            android.content.res.ColorStateList r3 = r5.f2993a     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            goto L51
        L4c:
            r3.remove(r9)     // Catch: java.lang.Throwable -> L3c
        L4f:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            r3 = r4
        L51:
            if (r3 == 0) goto L54
            return r3
        L54:
            java.lang.ThreadLocal r2 = e0.o.f3001a
            java.lang.Object r3 = r2.get()
            android.util.TypedValue r3 = (android.util.TypedValue) r3
            if (r3 != 0) goto L66
            android.util.TypedValue r3 = new android.util.TypedValue
            r3.<init>()
            r2.set(r3)
        L66:
            r2 = 1
            r0.getValue(r9, r3, r2)
            int r2 = r3.type
            r3 = 28
            if (r2 < r3) goto L75
            r3 = 31
            if (r2 > r3) goto L75
            goto L86
        L75:
            android.content.res.XmlResourceParser r2 = r0.getXml(r9)
            android.content.res.ColorStateList r4 = e0.c.a(r0, r2, r8)     // Catch: java.lang.Exception -> L7e
            goto L86
        L7e:
            r2 = move-exception
            java.lang.String r3 = "ResourcesCompat"
            java.lang.String r5 = "Failed to inflate ColorStateList, leaving it to the framework"
            android.util.Log.w(r3, r5, r2)
        L86:
            if (r4 == 0) goto L8c
            e0.o.a(r1, r9, r4, r8)
            goto L9b
        L8c:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r1 < r2) goto L97
            android.content.res.ColorStateList r4 = e0.j.b(r0, r9, r8)
            goto L9b
        L97:
            android.content.res.ColorStateList r4 = r0.getColorStateList(r9)
        L9b:
            return r4
        L9c:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.u(android.content.Context, int):android.content.res.ColorStateList");
    }

    public static Intent v(g.l lVar) {
        Intent a9 = h.a(lVar);
        if (a9 != null) {
            return a9;
        }
        try {
            String x6 = x(lVar, lVar.getComponentName());
            if (x6 == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(lVar, x6);
            try {
                return x(lVar, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + x6 + "' in manifest");
                return null;
            }
        } catch (PackageManager.NameNotFoundException e9) {
            throw new IllegalArgumentException(e9);
        }
    }

    public static Intent w(g.l lVar, ComponentName componentName) {
        String x6 = x(lVar, componentName);
        if (x6 == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), x6);
        return x(lVar, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String x(Context context, ComponentName componentName) {
        String string;
        PackageManager packageManager = context.getPackageManager();
        int i9 = Build.VERSION.SDK_INT;
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i9 >= 29 ? 269222528 : i9 >= 24 ? 787072 : 640);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    public static int z(int[] iArr, int i9, int i10, int i11) {
        while (i10 < i11) {
            if (iArr[i10] == i9) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public abstract void D(int i9);

    public abstract void E(Typeface typeface, boolean z8);

    public void L(View view, int i9, int i10, int i11, int i12) {
        if (!f5f) {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = View.class.getDeclaredMethod("setFrame", cls, cls, cls, cls);
                f4e = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e9) {
                Log.i("ViewUtilsBase", "Failed to retrieve setFrame method", e9);
            }
            f5f = true;
        }
        Method method = f4e;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e10) {
                throw new RuntimeException(e10.getCause());
            }
        }
    }

    public abstract void N();

    public void P(View view, int i9) {
        if (!h) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f6g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            h = true;
        }
        Field field = f6g;
        if (field != null) {
            try {
                f6g.setInt(view, i9 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public abstract void y();

    public void J(boolean z8) {
    }

    public void K(boolean z8) {
    }
}
