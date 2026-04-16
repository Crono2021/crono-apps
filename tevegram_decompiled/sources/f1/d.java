package f1;

import android.os.Bundle;
import android.text.Spanned;
import g1.w;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3261a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f3262b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f3263c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f3264d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f3265e;

    static {
        int i9 = w.f3713a;
        f3261a = Integer.toString(0, 36);
        f3262b = Integer.toString(1, 36);
        f3263c = Integer.toString(2, 36);
        f3264d = Integer.toString(3, 36);
        f3265e = Integer.toString(4, 36);
    }

    public static Bundle a(Spanned spanned, f fVar, int i9, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt(f3261a, spanned.getSpanStart(fVar));
        bundle2.putInt(f3262b, spanned.getSpanEnd(fVar));
        bundle2.putInt(f3263c, spanned.getSpanFlags(fVar));
        bundle2.putInt(f3264d, i9);
        if (bundle != null) {
            bundle2.putBundle(f3265e, bundle);
        }
        return bundle2;
    }
}
