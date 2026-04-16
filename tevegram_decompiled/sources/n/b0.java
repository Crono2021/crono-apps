package n;

import android.graphics.drawable.LayerDrawable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class b0 {
    public static void a(LayerDrawable layerDrawable, LayerDrawable layerDrawable2, int i9) {
        layerDrawable2.setLayerGravity(i9, layerDrawable.getLayerGravity(i9));
        layerDrawable2.setLayerWidth(i9, layerDrawable.getLayerWidth(i9));
        layerDrawable2.setLayerHeight(i9, layerDrawable.getLayerHeight(i9));
        layerDrawable2.setLayerInsetLeft(i9, layerDrawable.getLayerInsetLeft(i9));
        layerDrawable2.setLayerInsetRight(i9, layerDrawable.getLayerInsetRight(i9));
        layerDrawable2.setLayerInsetTop(i9, layerDrawable.getLayerInsetTop(i9));
        layerDrawable2.setLayerInsetBottom(i9, layerDrawable.getLayerInsetBottom(i9));
        layerDrawable2.setLayerInsetStart(i9, layerDrawable.getLayerInsetStart(i9));
        layerDrawable2.setLayerInsetEnd(i9, layerDrawable.getLayerInsetEnd(i9));
    }
}
