package f0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i extends android.support.v4.media.session.b {

    /* renamed from: o, reason: collision with root package name */
    public static final Class f3207o;

    /* renamed from: p, reason: collision with root package name */
    public static final Constructor f3208p;

    /* renamed from: q, reason: collision with root package name */
    public static final Method f3209q;

    /* renamed from: r, reason: collision with root package name */
    public static final Method f3210r;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e9) {
            Log.e("TypefaceCompatApi24Impl", e9.getClass().getName(), e9);
            cls = null;
            method = null;
            method2 = null;
        }
        f3208p = constructor;
        f3207o = cls;
        f3209q = method2;
        f3210r = method;
    }

    public static boolean D0(Object obj, ByteBuffer byteBuffer, int i9, int i10, boolean z8) {
        try {
            return ((Boolean) f3209q.invoke(obj, byteBuffer, Integer.valueOf(i9), null, Integer.valueOf(i10), Boolean.valueOf(z8))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface E0(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) f3207o, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f3210r.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // android.support.v4.media.session.b
    public final Typeface x(Context context, e0.f fVar, Resources resources, int i9) {
        Object obj;
        int i10;
        MappedByteBuffer mappedByteBuffer;
        FileInputStream fileInputStream;
        try {
            obj = f3208p.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj != null) {
            e0.g[] gVarArr = fVar.f2982a;
            int length = gVarArr.length;
            while (i10 < length) {
                e0.g gVar = gVarArr[i10];
                int i11 = gVar.f2988f;
                File z8 = com.bumptech.glide.c.z(context);
                if (z8 != null) {
                    try {
                        if (com.bumptech.glide.c.l(z8, resources, i11)) {
                            try {
                                fileInputStream = new FileInputStream(z8);
                            } catch (IOException unused2) {
                                mappedByteBuffer = null;
                            }
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                                fileInputStream.close();
                                i10 = (mappedByteBuffer == null && D0(obj, mappedByteBuffer, gVar.f2987e, gVar.f2984b, gVar.f2985c)) ? i10 + 1 : 0;
                            } finally {
                            }
                        }
                    } finally {
                        z8.delete();
                    }
                }
                mappedByteBuffer = null;
                if (mappedByteBuffer == null) {
                }
            }
            return E0(obj);
        }
        return null;
    }

    @Override // android.support.v4.media.session.b
    public final Typeface y(Context context, k0.g[] gVarArr, int i9) {
        Object obj;
        try {
            obj = f3208p.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj != null) {
            s.h hVar = new s.h();
            int length = gVarArr.length;
            int i10 = 0;
            while (true) {
                if (i10 < length) {
                    k0.g gVar = gVarArr[i10];
                    Uri uri = gVar.f5519a;
                    ByteBuffer byteBuffer = (ByteBuffer) hVar.getOrDefault(uri, null);
                    if (byteBuffer == null) {
                        byteBuffer = com.bumptech.glide.c.K(context, uri);
                        hVar.put(uri, byteBuffer);
                    }
                    if (byteBuffer == null || !D0(obj, byteBuffer, gVar.f5520b, gVar.f5521c, gVar.f5522d)) {
                        break;
                    }
                    i10++;
                } else {
                    Typeface E0 = E0(obj);
                    if (E0 != null) {
                        return Typeface.create(E0, i9);
                    }
                }
            }
        }
        return null;
    }
}
