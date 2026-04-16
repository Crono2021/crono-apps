package f0;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class j extends h {

    /* renamed from: t, reason: collision with root package name */
    public final Class f3211t;

    /* renamed from: u, reason: collision with root package name */
    public final Constructor f3212u;

    /* renamed from: v, reason: collision with root package name */
    public final Method f3213v;

    /* renamed from: w, reason: collision with root package name */
    public final Method f3214w;

    /* renamed from: x, reason: collision with root package name */
    public final Method f3215x;

    /* renamed from: y, reason: collision with root package name */
    public final Method f3216y;

    /* renamed from: z, reason: collision with root package name */
    public final Method f3217z;

    public j() {
        Method method;
        Constructor<?> constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            method2 = I0(cls2);
            Class<?> cls3 = Integer.TYPE;
            method3 = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method4 = cls2.getMethod("freeze", null);
            method5 = cls2.getMethod("abortCreation", null);
            method = J0(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e9) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e9.getClass().getName()), e9);
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f3211t = cls;
        this.f3212u = constructor;
        this.f3213v = method2;
        this.f3214w = method3;
        this.f3215x = method4;
        this.f3216y = method5;
        this.f3217z = method;
    }

    public static Method I0(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public final boolean F0(Context context, Object obj, String str, int i9, int i10, int i11, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f3213v.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface G0(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) this.f3211t, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f3217z.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean H0(Object obj) {
        try {
            return ((Boolean) this.f3215x.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Method J0(Class cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>) cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @Override // f0.h, android.support.v4.media.session.b
    public final Typeface x(Context context, e0.f fVar, Resources resources, int i9) {
        Object obj;
        Method method = this.f3213v;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.x(context, fVar, resources, i9);
        }
        try {
            obj = this.f3212u.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj != null) {
            e0.g[] gVarArr = fVar.f2982a;
            int length = gVarArr.length;
            int i10 = 0;
            while (true) {
                if (i10 < length) {
                    e0.g gVar = gVarArr[i10];
                    Context context2 = context;
                    if (F0(context2, obj, gVar.f2983a, gVar.f2987e, gVar.f2984b, gVar.f2985c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(gVar.f2986d))) {
                        i10++;
                        context = context2;
                    } else {
                        try {
                            this.f3216y.invoke(obj, null);
                            break;
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                        }
                    }
                } else if (H0(obj)) {
                    return G0(obj);
                }
            }
        }
        return null;
    }

    @Override // f0.h, android.support.v4.media.session.b
    public final Typeface y(Context context, k0.g[] gVarArr, int i9) {
        Object obj;
        Typeface G0;
        boolean z8;
        if (gVarArr.length >= 1) {
            Method method = this.f3213v;
            if (method == null) {
                Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
            }
            try {
                if (method != null) {
                    HashMap hashMap = new HashMap();
                    for (k0.g gVar : gVarArr) {
                        if (gVar.f5523e == 0) {
                            Uri uri = gVar.f5519a;
                            if (!hashMap.containsKey(uri)) {
                                hashMap.put(uri, com.bumptech.glide.c.K(context, uri));
                            }
                        }
                    }
                    Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
                    try {
                        obj = this.f3212u.newInstance(null);
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                        obj = null;
                    }
                    if (obj != null) {
                        int length = gVarArr.length;
                        int i10 = 0;
                        boolean z9 = false;
                        while (true) {
                            Method method2 = this.f3216y;
                            if (i10 < length) {
                                k0.g gVar2 = gVarArr[i10];
                                ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(gVar2.f5519a);
                                if (byteBuffer != null) {
                                    try {
                                        z8 = ((Boolean) this.f3214w.invoke(obj, byteBuffer, Integer.valueOf(gVar2.f5520b), null, Integer.valueOf(gVar2.f5521c), Integer.valueOf(gVar2.f5522d ? 1 : 0))).booleanValue();
                                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                                        z8 = false;
                                    }
                                    if (!z8) {
                                        method2.invoke(obj, null);
                                        break;
                                    }
                                    z9 = true;
                                }
                                i10++;
                            } else if (!z9) {
                                method2.invoke(obj, null);
                            } else if (H0(obj) && (G0 = G0(obj)) != null) {
                                return Typeface.create(G0, i9);
                            }
                        }
                    }
                } else {
                    k0.g H = android.support.v4.media.session.b.H(gVarArr, i9);
                    ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(H.f5519a, "r", null);
                    if (openFileDescriptor != null) {
                        try {
                            Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(H.f5521c).setItalic(H.f5522d).build();
                            openFileDescriptor.close();
                            return build;
                        } finally {
                        }
                    } else if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                        return null;
                    }
                }
            } catch (IOException | IllegalAccessException | InvocationTargetException unused3) {
            }
        }
        return null;
    }

    @Override // android.support.v4.media.session.b
    public final Typeface z(Context context, Resources resources, int i9, String str, int i10) {
        Object obj;
        Method method = this.f3213v;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.z(context, resources, i9, str, i10);
        }
        try {
            obj = this.f3212u.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj != null) {
            if (!F0(context, obj, str, 0, -1, -1, null)) {
                try {
                    this.f3216y.invoke(obj, null);
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
            } else if (H0(obj)) {
                return G0(obj);
            }
        }
        return null;
    }
}
