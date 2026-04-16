package f0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class h extends android.support.v4.media.session.b {

    /* renamed from: o, reason: collision with root package name */
    public static Class f3202o = null;

    /* renamed from: p, reason: collision with root package name */
    public static Constructor f3203p = null;

    /* renamed from: q, reason: collision with root package name */
    public static Method f3204q = null;

    /* renamed from: r, reason: collision with root package name */
    public static Method f3205r = null;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f3206s = false;

    public static boolean D0(Object obj, String str, int i9, boolean z8) {
        E0();
        try {
            try {
                return ((Boolean) f3204q.invoke(obj, str, Integer.valueOf(i9), Boolean.valueOf(z8))).booleanValue();
            } catch (InvocationTargetException e9) {
                e = e9;
                throw new RuntimeException(e);
            }
        } catch (IllegalAccessException | InvocationTargetException e10) {
            e = e10;
        }
    }

    public static void E0() {
        Method method;
        Class<?> cls;
        Method method2;
        if (f3206s) {
            return;
        }
        f3206s = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e9) {
            Log.e("TypefaceCompatApi21Impl", e9.getClass().getName(), e9);
            method = null;
            cls = null;
            method2 = null;
        }
        f3203p = constructor;
        f3202o = cls;
        f3204q = method2;
        f3205r = method;
    }

    @Override // android.support.v4.media.session.b
    public Typeface x(Context context, e0.f fVar, Resources resources, int i9) {
        E0();
        try {
            Object newInstance = f3203p.newInstance(null);
            for (e0.g gVar : fVar.f2982a) {
                File z8 = com.bumptech.glide.c.z(context);
                if (z8 == null) {
                    return null;
                }
                try {
                    if (!com.bumptech.glide.c.l(z8, resources, gVar.f2988f)) {
                        return null;
                    }
                    if (!D0(newInstance, z8.getPath(), gVar.f2984b, gVar.f2985c)) {
                        return null;
                    }
                    z8.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    z8.delete();
                }
            }
            E0();
            try {
                Object newInstance2 = Array.newInstance((Class<?>) f3202o, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) f3205r.invoke(null, newInstance2);
            } catch (IllegalAccessException | InvocationTargetException e9) {
                throw new RuntimeException(e9);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.support.v4.media.session.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Typeface y(android.content.Context r4, k0.g[] r5, int r6) {
        /*
            r3 = this;
            int r0 = r5.length
            r1 = 1
            r2 = 0
            if (r0 >= r1) goto L7
            goto La2
        L7:
            k0.g r5 = android.support.v4.media.session.b.H(r5, r6)
            android.content.ContentResolver r6 = r4.getContentResolver()
            android.net.Uri r5 = r5.f5519a     // Catch: java.io.IOException -> La2
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r5 = r6.openFileDescriptor(r5, r0, r2)     // Catch: java.io.IOException -> La2
            if (r5 != 0) goto L1f
            if (r5 == 0) goto La2
            r5.close()     // Catch: java.io.IOException -> La2
            return r2
        L1f:
            java.lang.String r6 = "/proc/self/fd/"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L5a
            r0.<init>(r6)     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L5a
            int r6 = r5.getFd()     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L5a
            r0.append(r6)     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L5a
            java.lang.String r6 = r0.toString()     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L5a
            java.lang.String r6 = android.system.Os.readlink(r6)     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L5a
            android.system.StructStat r0 = android.system.Os.stat(r6)     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L5a
            int r0 = r0.st_mode     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L5a
            boolean r0 = android.system.OsConstants.S_ISREG(r0)     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L5a
            if (r0 == 0) goto L48
            java.io.File r0 = new java.io.File     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L5a
            r0.<init>(r6)     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L5a
            goto L49
        L47:
        L48:
            r0 = r2
        L49:
            if (r0 == 0) goto L5c
            boolean r6 = r0.canRead()     // Catch: java.lang.Throwable -> L5a
            if (r6 != 0) goto L52
            goto L5c
        L52:
            android.graphics.Typeface r4 = android.graphics.Typeface.createFromFile(r0)     // Catch: java.lang.Throwable -> L5a
            r5.close()     // Catch: java.io.IOException -> La2
            return r4
        L5a:
            r4 = move-exception
            goto L99
        L5c:
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L5a
            java.io.FileDescriptor r0 = r5.getFileDescriptor()     // Catch: java.lang.Throwable -> L5a
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L5a
            java.io.File r4 = com.bumptech.glide.c.z(r4)     // Catch: java.lang.Throwable -> L8f
            if (r4 != 0) goto L6d
        L6b:
            r0 = r2
            goto L88
        L6d:
            boolean r0 = com.bumptech.glide.c.m(r4, r6)     // Catch: java.lang.RuntimeException -> L73 java.lang.Throwable -> L83
            if (r0 != 0) goto L77
        L73:
            r4.delete()     // Catch: java.lang.Throwable -> L8f
            goto L6b
        L77:
            java.lang.String r0 = r4.getPath()     // Catch: java.lang.RuntimeException -> L73 java.lang.Throwable -> L83
            android.graphics.Typeface r0 = android.graphics.Typeface.createFromFile(r0)     // Catch: java.lang.RuntimeException -> L73 java.lang.Throwable -> L83
            r4.delete()     // Catch: java.lang.Throwable -> L8f
            goto L88
        L83:
            r0 = move-exception
            r4.delete()     // Catch: java.lang.Throwable -> L8f
            throw r0     // Catch: java.lang.Throwable -> L8f
        L88:
            r6.close()     // Catch: java.lang.Throwable -> L5a
            r5.close()     // Catch: java.io.IOException -> La2
            return r0
        L8f:
            r4 = move-exception
            r6.close()     // Catch: java.lang.Throwable -> L94
            goto L98
        L94:
            r6 = move-exception
            r4.addSuppressed(r6)     // Catch: java.lang.Throwable -> L5a
        L98:
            throw r4     // Catch: java.lang.Throwable -> L5a
        L99:
            r5.close()     // Catch: java.lang.Throwable -> L9d
            goto La1
        L9d:
            r5 = move-exception
            r4.addSuppressed(r5)     // Catch: java.io.IOException -> La2
        La1:
            throw r4     // Catch: java.io.IOException -> La2
        La2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: f0.h.y(android.content.Context, k0.g[], int):android.graphics.Typeface");
    }
}
