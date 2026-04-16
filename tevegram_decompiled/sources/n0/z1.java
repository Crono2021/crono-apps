package n0;

import android.view.WindowInsets;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class z1 {
    public static int a(int i9) {
        int statusBars;
        int i10 = 0;
        for (int i11 = 1; i11 <= 256; i11 <<= 1) {
            if ((i9 & i11) != 0) {
                if (i11 == 1) {
                    statusBars = WindowInsets.Type.statusBars();
                } else if (i11 == 2) {
                    statusBars = WindowInsets.Type.navigationBars();
                } else if (i11 == 4) {
                    statusBars = WindowInsets.Type.captionBar();
                } else if (i11 == 8) {
                    statusBars = WindowInsets.Type.ime();
                } else if (i11 == 16) {
                    statusBars = WindowInsets.Type.systemGestures();
                } else if (i11 == 32) {
                    statusBars = WindowInsets.Type.mandatorySystemGestures();
                } else if (i11 == 64) {
                    statusBars = WindowInsets.Type.tappableElement();
                } else if (i11 == 128) {
                    statusBars = WindowInsets.Type.displayCutout();
                }
                i10 |= statusBars;
            }
        }
        return i10;
    }
}
