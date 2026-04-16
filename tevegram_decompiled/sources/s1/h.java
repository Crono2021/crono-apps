package s1;

import android.content.Context;
import d1.l0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h implements j {

    /* renamed from: i, reason: collision with root package name */
    public final Context f8705i;

    /* renamed from: j, reason: collision with root package name */
    public int f8706j = 0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8707k = true;

    public h(Context context) {
        this.f8705i = context;
    }

    @Override // s1.j
    public final k j(i iVar) {
        int i9;
        Context context;
        int i10 = g1.w.f3713a;
        if (i10 < 23 || ((i9 = this.f8706j) != 1 && (i9 != 0 || (i10 < 31 && ((context = this.f8705i) == null || i10 < 28 || !context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen")))))) {
            return new o4.d(4).j(iVar);
        }
        int g9 = l0.g(iVar.f8710c.f2554m);
        g1.a.v("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type ".concat(g1.w.D(g9)));
        com.bumptech.glide.manager.s sVar = new com.bumptech.glide.manager.s(g9);
        sVar.f1857j = this.f8707k;
        return sVar.j(iVar);
    }
}
