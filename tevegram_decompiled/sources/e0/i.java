package e0;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class i {
    public static Drawable a(Resources resources, int i9, Resources.Theme theme) {
        return resources.getDrawable(i9, theme);
    }

    public static Drawable b(Resources resources, int i9, int i10, Resources.Theme theme) {
        return resources.getDrawableForDensity(i9, i10, theme);
    }
}
