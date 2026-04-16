package d0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class c {
    public static File a(Context context) {
        return context.getCodeCacheDir();
    }

    public static Drawable b(Context context, int i9) {
        return context.getDrawable(i9);
    }

    public static File c(Context context) {
        return context.getNoBackupFilesDir();
    }
}
