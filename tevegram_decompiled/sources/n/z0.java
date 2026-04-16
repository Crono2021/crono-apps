package n;

import android.widget.TextView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class z0 {
    public static int a(TextView textView) {
        return textView.getAutoSizeStepGranularity();
    }

    public static void b(TextView textView, int i9, int i10, int i11, int i12) {
        textView.setAutoSizeTextTypeUniformWithConfiguration(i9, i10, i11, i12);
    }

    public static void c(TextView textView, int[] iArr, int i9) {
        textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i9);
    }

    public static boolean d(TextView textView, String str) {
        return textView.setFontVariationSettings(str);
    }
}
