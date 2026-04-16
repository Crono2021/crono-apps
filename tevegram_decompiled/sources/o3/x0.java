package o3;

import android.util.Log;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    public int f7843a;

    /* renamed from: b, reason: collision with root package name */
    public int f7844b;

    /* renamed from: c, reason: collision with root package name */
    public int f7845c;

    /* renamed from: d, reason: collision with root package name */
    public int f7846d;

    /* renamed from: e, reason: collision with root package name */
    public Interpolator f7847e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7848f;

    /* renamed from: g, reason: collision with root package name */
    public int f7849g;

    public final void a(RecyclerView recyclerView) {
        int i9 = this.f7846d;
        if (i9 >= 0) {
            this.f7846d = -1;
            recyclerView.N(i9);
            this.f7848f = false;
            return;
        }
        if (!this.f7848f) {
            this.f7849g = 0;
            return;
        }
        Interpolator interpolator = this.f7847e;
        if (interpolator != null && this.f7845c < 1) {
            m7.c.p("If you provide an interpolator, you must set a positive duration");
            return;
        }
        int i10 = this.f7845c;
        if (i10 < 1) {
            m7.c.p("Scroll duration must be a positive number");
            return;
        }
        recyclerView.f1061l0.c(this.f7843a, this.f7844b, i10, interpolator);
        int i11 = this.f7849g + 1;
        this.f7849g = i11;
        if (i11 > 10) {
            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
        }
        this.f7848f = false;
    }
}
