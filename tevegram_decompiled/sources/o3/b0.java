package o3;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b0 extends z {

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ c0 f7595q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(c0 c0Var, Context context) {
        super(context);
        this.f7595q = c0Var;
    }

    @Override // o3.z
    public final float d(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // o3.z
    public final int e(int i9) {
        return Math.min(100, super.e(i9));
    }

    @Override // o3.z
    public final void h(View view, x0 x0Var) {
        c0 c0Var = this.f7595q;
        int[] a9 = c0Var.a(c0Var.f7599a.getLayoutManager(), view);
        int i9 = a9[0];
        int i10 = a9[1];
        int ceil = (int) Math.ceil(e(Math.max(Math.abs(i9), Math.abs(i10))) / 0.3356d);
        if (ceil > 0) {
            x0Var.f7843a = i9;
            x0Var.f7844b = i10;
            x0Var.f7845c = ceil;
            x0Var.f7847e = this.f7861j;
            x0Var.f7848f = true;
        }
    }
}
