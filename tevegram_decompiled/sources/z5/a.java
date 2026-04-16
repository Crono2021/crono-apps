package z5;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import l.d;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f10671a = {R.attr.theme, 2130969661};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f10672b = {2130969312};

    public static Context a(Context context, AttributeSet attributeSet, int i9, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f10672b, i9, i10);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        boolean z8 = (context instanceof d) && ((d) context).f5680a == resourceId;
        if (resourceId == 0 || z8) {
            return context;
        }
        d dVar = new d(context, resourceId);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f10671a);
        int resourceId2 = obtainStyledAttributes2.getResourceId(0, 0);
        int resourceId3 = obtainStyledAttributes2.getResourceId(1, 0);
        obtainStyledAttributes2.recycle();
        if (resourceId2 == 0) {
            resourceId2 = resourceId3;
        }
        if (resourceId2 != 0) {
            dVar.getTheme().applyStyle(resourceId2, true);
        }
        return dVar;
    }
}
