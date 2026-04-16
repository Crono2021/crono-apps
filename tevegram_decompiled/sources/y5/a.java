package y5;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import com.bumptech.glide.c;
import n.e1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends e1 {
    public static int f(Context context, TypedArray typedArray, int... iArr) {
        int i9 = -1;
        for (int i10 = 0; i10 < iArr.length && i9 < 0; i10++) {
            int i11 = iArr[i10];
            TypedValue typedValue = new TypedValue();
            if (typedArray.getValue(i11, typedValue) && typedValue.type == 2) {
                TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, -1);
                obtainStyledAttributes.recycle();
                i9 = dimensionPixelSize;
            } else {
                i9 = typedArray.getDimensionPixelSize(i11, -1);
            }
        }
        return i9;
    }

    @Override // n.e1, android.widget.TextView
    public final void setTextAppearance(Context context, int i9) {
        super.setTextAppearance(context, i9);
        if (c.R(context, 2130969634, true)) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(i9, y4.a.f10517w);
            int f9 = f(getContext(), obtainStyledAttributes, 1, 2);
            obtainStyledAttributes.recycle();
            if (f9 >= 0) {
                setLineHeight(f9);
            }
        }
    }
}
