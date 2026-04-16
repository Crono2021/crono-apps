package t4;

import a0.h;
import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import java.util.ArrayList;
import w4.f;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static Integer f8965d;

    /* renamed from: a, reason: collision with root package name */
    public final View f8966a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f8967b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public h f8968c;

    public c(ImageView imageView) {
        this.f8966a = imageView;
    }

    public final int a(int i9, int i10, int i11) {
        int i12 = i10 - i11;
        if (i12 > 0) {
            return i12;
        }
        int i13 = i9 - i11;
        if (i13 > 0) {
            return i13;
        }
        View view = this.f8966a;
        if (view.isLayoutRequested() || i10 != -2) {
            return 0;
        }
        if (Log.isLoggable("ViewTarget", 4)) {
            Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
        }
        Context context = view.getContext();
        if (f8965d == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            f.c(windowManager, "Argument must not be null");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            f8965d = Integer.valueOf(Math.max(point.x, point.y));
        }
        return f8965d.intValue();
    }
}
