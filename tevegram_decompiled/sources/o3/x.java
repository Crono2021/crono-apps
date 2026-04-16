package o3;

import android.view.View;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7832a;

    /* renamed from: b, reason: collision with root package name */
    public int f7833b;

    /* renamed from: c, reason: collision with root package name */
    public int f7834c;

    /* renamed from: d, reason: collision with root package name */
    public int f7835d;

    /* renamed from: e, reason: collision with root package name */
    public int f7836e;

    /* renamed from: f, reason: collision with root package name */
    public int f7837f;

    /* renamed from: g, reason: collision with root package name */
    public int f7838g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f7839i;

    /* renamed from: j, reason: collision with root package name */
    public int f7840j;

    /* renamed from: k, reason: collision with root package name */
    public List f7841k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f7842l;

    public final void a(View view) {
        int b9;
        int size = this.f7841k.size();
        View view2 = null;
        int i9 = Integer.MAX_VALUE;
        for (int i10 = 0; i10 < size; i10++) {
            View view3 = ((d1) this.f7841k.get(i10)).f7618a;
            p0 p0Var = (p0) view3.getLayoutParams();
            if (view3 != view && !p0Var.f7765a.h() && (b9 = (p0Var.f7765a.b() - this.f7835d) * this.f7836e) >= 0 && b9 < i9) {
                view2 = view3;
                if (b9 == 0) {
                    break;
                } else {
                    i9 = b9;
                }
            }
        }
        if (view2 == null) {
            this.f7835d = -1;
        } else {
            this.f7835d = ((p0) view2.getLayoutParams()).f7765a.b();
        }
    }

    public final View b(l7.a aVar) {
        List list = this.f7841k;
        if (list == null) {
            View view = aVar.k(this.f7835d, Long.MAX_VALUE).f7618a;
            this.f7835d += this.f7836e;
            return view;
        }
        int size = list.size();
        for (int i9 = 0; i9 < size; i9++) {
            View view2 = ((d1) this.f7841k.get(i9)).f7618a;
            p0 p0Var = (p0) view2.getLayoutParams();
            if (!p0Var.f7765a.h() && this.f7835d == p0Var.f7765a.b()) {
                a(view2);
                return view2;
            }
        }
        return null;
    }
}
