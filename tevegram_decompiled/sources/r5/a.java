package r5;

import android.graphics.Typeface;
import i7.x;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends a.a {

    /* renamed from: i, reason: collision with root package name */
    public final Typeface f8557i;

    /* renamed from: j, reason: collision with root package name */
    public final x f8558j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8559k;

    public a(x xVar, Typeface typeface) {
        this.f8557i = typeface;
        this.f8558j = xVar;
    }

    @Override // a.a
    public final void D(int i9) {
        if (this.f8559k) {
            return;
        }
        o5.c cVar = (o5.c) this.f8558j.f5179j;
        if (cVar.j(this.f8557i)) {
            cVar.h(false);
        }
    }

    @Override // a.a
    public final void E(Typeface typeface, boolean z8) {
        if (this.f8559k) {
            return;
        }
        o5.c cVar = (o5.c) this.f8558j.f5179j;
        if (cVar.j(typeface)) {
            cVar.h(false);
        }
    }
}
