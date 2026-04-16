package a5;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class e {
    /* JADX INFO: Access modifiers changed from: private */
    public static ColorStateList b(Drawable drawable) {
        ColorStateList colorStateList;
        if (!a0.a.r(drawable)) {
            return null;
        }
        colorStateList = a0.a.d(drawable).getColorStateList();
        return colorStateList;
    }
}
