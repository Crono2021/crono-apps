package com.bumptech.glide.manager;

import androidx.media3.ui.AspectRatioFrameLayout;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1840i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1841j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f1842k;

    public /* synthetic */ n(Object obj, boolean z8, int i9) {
        this.f1840i = i9;
        this.f1842k = obj;
        this.f1841j = z8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i9 = this.f1840i;
        Object obj = this.f1842k;
        switch (i9) {
            case 0:
                boolean z8 = this.f1841j;
                w4.n.a();
                b2.b bVar = ((o) obj).f1843a;
                boolean z9 = bVar.f1137a;
                bVar.f1137a = z8;
                if (z9 != z8) {
                    ((l) bVar.f1138b).a(z8);
                    break;
                }
                break;
            case 1:
                ((r) obj).f1850b.a(this.f1841j);
                break;
            default:
                this.f1841j = false;
                int i10 = AspectRatioFrameLayout.f993l;
                break;
        }
    }

    public n(AspectRatioFrameLayout aspectRatioFrameLayout) {
        this.f1840i = 2;
        this.f1842k = aspectRatioFrameLayout;
    }
}
