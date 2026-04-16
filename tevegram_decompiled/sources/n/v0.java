package n;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v0 extends e0.b {
    public final /* synthetic */ int h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7069i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ WeakReference f7070j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ b1 f7071k;

    public v0(b1 b1Var, int i9, int i10, WeakReference weakReference) {
        this.f7071k = b1Var;
        this.h = i9;
        this.f7069i = i10;
        this.f7070j = weakReference;
    }

    @Override // e0.b
    public final void i(Typeface typeface) {
        int i9;
        if (Build.VERSION.SDK_INT >= 28 && (i9 = this.h) != -1) {
            typeface = a1.a(typeface, i9, (this.f7069i & 2) != 0);
        }
        b1 b1Var = this.f7071k;
        if (b1Var.f6800m) {
            b1Var.f6799l = typeface;
            TextView textView = (TextView) this.f7070j.get();
            if (textView != null) {
                WeakHashMap weakHashMap = n0.t0.f7209a;
                boolean b9 = n0.f0.b(textView);
                int i10 = b1Var.f6797j;
                if (b9) {
                    textView.post(new androidx.activity.h(i10, 4, textView, typeface));
                } else {
                    textView.setTypeface(typeface, i10);
                }
            }
        }
    }

    @Override // e0.b
    public final void h(int i9) {
    }
}
