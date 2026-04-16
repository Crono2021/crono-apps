package d5;

import android.view.View;
import androidx.activity.j;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import n0.c0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2956a;

    /* renamed from: b, reason: collision with root package name */
    public int f2957b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2958c;

    /* renamed from: d, reason: collision with root package name */
    public final Runnable f2959d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ a0.d f2960e;

    public e(SideSheetBehavior sideSheetBehavior) {
        this.f2956a = 1;
        this.f2960e = sideSheetBehavior;
        this.f2959d = new a7.a(this, 22);
    }

    public final void a(int i9) {
        int i10 = this.f2956a;
        Runnable runnable = this.f2959d;
        a0.d dVar = this.f2960e;
        switch (i10) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) dVar;
                WeakReference weakReference = bottomSheetBehavior.U;
                if (weakReference != null && weakReference.get() != null) {
                    this.f2957b = i9;
                    if (!this.f2958c) {
                        WeakHashMap weakHashMap = t0.f7209a;
                        c0.m((View) bottomSheetBehavior.U.get(), (j) runnable);
                        this.f2958c = true;
                        break;
                    }
                }
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) dVar;
                WeakReference weakReference2 = sideSheetBehavior.f2119p;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.f2957b = i9;
                    if (!this.f2958c) {
                        WeakHashMap weakHashMap2 = t0.f7209a;
                        c0.m((View) sideSheetBehavior.f2119p.get(), (a7.a) runnable);
                        this.f2958c = true;
                        break;
                    }
                }
                break;
        }
    }

    public e(BottomSheetBehavior bottomSheetBehavior) {
        this.f2956a = 0;
        this.f2960e = bottomSheetBehavior;
        this.f2959d = new j(this, 7);
    }
}
