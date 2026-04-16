package l;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import n0.c1;
import n0.d1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k {

    /* renamed from: c, reason: collision with root package name */
    public Interpolator f5733c;

    /* renamed from: d, reason: collision with root package name */
    public d1 f5734d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5735e;

    /* renamed from: b, reason: collision with root package name */
    public long f5732b = -1;

    /* renamed from: f, reason: collision with root package name */
    public final j f5736f = new j(this);

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f5731a = new ArrayList();

    public final void a() {
        if (this.f5735e) {
            ArrayList arrayList = this.f5731a;
            int size = arrayList.size();
            int i9 = 0;
            while (i9 < size) {
                Object obj = arrayList.get(i9);
                i9++;
                ((c1) obj).b();
            }
            this.f5735e = false;
        }
    }

    public final void b() {
        View view;
        if (this.f5735e) {
            return;
        }
        ArrayList arrayList = this.f5731a;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            c1 c1Var = (c1) obj;
            long j5 = this.f5732b;
            if (j5 >= 0) {
                c1Var.c(j5);
            }
            Interpolator interpolator = this.f5733c;
            if (interpolator != null && (view = (View) c1Var.f7146a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.f5734d != null) {
                c1Var.d(this.f5736f);
            }
            View view2 = (View) c1Var.f7146a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.f5735e = true;
    }
}
