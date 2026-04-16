package e0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import b6.i0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final float[][] f2974a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* renamed from: b, reason: collision with root package name */
    public static final float[][] f2975b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* renamed from: c, reason: collision with root package name */
    public static final float[] f2976c = {95.047f, 100.0f, 108.883f};

    /* renamed from: d, reason: collision with root package name */
    public static final float[][] f2977d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    /* renamed from: e, reason: collision with root package name */
    public static final Object f2978e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public static Method f2979f;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f2980g;

    public static i0 b(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i9) {
        i0 i0Var;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i9, typedValue);
            int i10 = typedValue.type;
            if (i10 >= 28 && i10 <= 31) {
                return new i0((Shader) null, (ColorStateList) null, typedValue.data);
            }
            try {
                i0Var = i0.b(typedArray.getResources(), typedArray.getResourceId(i9, 0), theme);
            } catch (Exception e9) {
                Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e9);
                i0Var = null;
            }
            if (i0Var != null) {
                return i0Var;
            }
        }
        return new i0((Shader) null, (ColorStateList) null, 0);
    }

    public static String c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i9) {
        if (d(xmlPullParser, str)) {
            return typedArray.getString(i9);
        }
        return null;
    }

    public static boolean d(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static int e(float f9) {
        if (f9 < 1.0f) {
            return -16777216;
        }
        if (f9 > 99.0f) {
            return -1;
        }
        float f10 = (f9 + 16.0f) / 116.0f;
        float f11 = f9 > 8.0f ? f10 * f10 * f10 : f9 / 903.2963f;
        float f12 = f10 * f10 * f10;
        boolean z8 = f12 > 0.008856452f;
        float f13 = z8 ? f12 : ((f10 * 116.0f) - 16.0f) / 903.2963f;
        if (!z8) {
            f12 = ((f10 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f2976c;
        return f0.a.a(f13 * fArr[0], f11 * fArr[1], f12 * fArr[2]);
    }

    public static float f(int i9) {
        float f9 = i9 / 255.0f;
        return (f9 <= 0.04045f ? f9 / 12.92f : (float) Math.pow((f9 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    public static TypedArray g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static e j(XmlResourceParser xmlResourceParser, Resources resources) {
        int next;
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        xmlResourceParser.require(2, null, "font-family");
        if (!xmlResourceParser.getName().equals("font-family")) {
            m(xmlResourceParser);
            return null;
        }
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), b0.a.f1127b);
        String string = obtainAttributes.getString(0);
        String string2 = obtainAttributes.getString(4);
        String string3 = obtainAttributes.getString(5);
        int resourceId = obtainAttributes.getResourceId(1, 0);
        int integer = obtainAttributes.getInteger(2, 1);
        int integer2 = obtainAttributes.getInteger(3, 500);
        String string4 = obtainAttributes.getString(6);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlResourceParser.next() != 3) {
                m(xmlResourceParser);
            }
            return new h(new c7.a(string, string2, string3, k(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlResourceParser.next() != 3) {
            if (xmlResourceParser.getEventType() == 2) {
                if (xmlResourceParser.getName().equals("font")) {
                    TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), b0.a.f1128c);
                    int i9 = obtainAttributes2.getInt(obtainAttributes2.hasValue(8) ? 8 : 1, 400);
                    boolean z8 = 1 == obtainAttributes2.getInt(obtainAttributes2.hasValue(6) ? 6 : 2, 0);
                    int i10 = obtainAttributes2.hasValue(9) ? 9 : 3;
                    String string5 = obtainAttributes2.getString(obtainAttributes2.hasValue(7) ? 7 : 4);
                    int i11 = obtainAttributes2.getInt(i10, 0);
                    int i12 = obtainAttributes2.hasValue(5) ? 5 : 0;
                    int resourceId2 = obtainAttributes2.getResourceId(i12, 0);
                    String string6 = obtainAttributes2.getString(i12);
                    obtainAttributes2.recycle();
                    while (xmlResourceParser.next() != 3) {
                        m(xmlResourceParser);
                    }
                    arrayList.add(new g(string6, i9, z8, string5, i11, resourceId2));
                } else {
                    m(xmlResourceParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new f((g[]) arrayList.toArray(new g[0]));
    }

    public static List k(Resources resources, int i9) {
        if (i9 == 0) {
            return Collections.EMPTY_LIST;
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i9);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            if (d.a(obtainTypedArray, 0) == 1) {
                for (int i10 = 0; i10 < obtainTypedArray.length(); i10++) {
                    int resourceId = obtainTypedArray.getResourceId(i10, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i9);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    public static void l(Resources.Theme theme) {
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 29) {
            n.a(theme);
            return;
        }
        if (i9 >= 23) {
            synchronized (f2978e) {
                if (!f2980g) {
                    try {
                        Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", null);
                        f2979f = declaredMethod;
                        declaredMethod.setAccessible(true);
                    } catch (NoSuchMethodException e9) {
                        Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e9);
                    }
                    f2980g = true;
                }
                Method method = f2979f;
                if (method != null) {
                    try {
                        method.invoke(theme, null);
                    } catch (IllegalAccessException | InvocationTargetException e10) {
                        Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e10);
                        f2979f = null;
                    }
                }
            }
        }
    }

    public static void m(XmlPullParser xmlPullParser) {
        int i9 = 1;
        while (i9 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i9++;
            } else if (next == 3) {
                i9--;
            }
        }
    }

    public static float n() {
        return ((float) Math.pow((50.0f + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }

    public void a(int i9) {
        new Handler(Looper.getMainLooper()).post(new m(i9, 0, this));
    }

    public abstract void h(int i9);

    public abstract void i(Typeface typeface);
}
