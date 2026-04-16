package y;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import android.util.Xml;
import java.util.HashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f10218a;

    /* renamed from: b, reason: collision with root package name */
    public int f10219b;

    /* renamed from: c, reason: collision with root package name */
    public float f10220c;

    /* renamed from: d, reason: collision with root package name */
    public String f10221d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10222e;

    /* renamed from: f, reason: collision with root package name */
    public int f10223f;

    public a(a aVar, Object obj) {
        aVar.getClass();
        this.f10218a = aVar.f10218a;
        b(obj);
    }

    public static void a(Context context, XmlResourceParser xmlResourceParser, HashMap hashMap) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), o.f10339c);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        int i9 = 0;
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == 0) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == 1) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                i9 = 6;
            } else if (index == 3) {
                obj = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                i9 = 3;
            } else if (index == 2) {
                obj = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                i9 = 4;
            } else {
                if (index == 7) {
                    obj = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == 4) {
                    obj = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == 5) {
                    obj = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                    i9 = 2;
                } else if (index == 6) {
                    obj = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                    i9 = 1;
                } else if (index == 8) {
                    obj = obtainStyledAttributes.getString(index);
                    i9 = 5;
                }
                i9 = 7;
            }
        }
        if (str != null && obj != null) {
            a aVar = new a();
            aVar.f10218a = i9;
            aVar.b(obj);
            hashMap.put(str, aVar);
        }
        obtainStyledAttributes.recycle();
    }

    public final void b(Object obj) {
        switch (v.h.a(this.f10218a)) {
            case 0:
                this.f10219b = ((Integer) obj).intValue();
                break;
            case 1:
                this.f10220c = ((Float) obj).floatValue();
                break;
            case 2:
            case 3:
                this.f10223f = ((Integer) obj).intValue();
                break;
            case 4:
                this.f10221d = (String) obj;
                break;
            case 5:
                this.f10222e = ((Boolean) obj).booleanValue();
                break;
            case 6:
                this.f10220c = ((Float) obj).floatValue();
                break;
        }
    }
}
