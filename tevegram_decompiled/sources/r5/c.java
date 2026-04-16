package r5;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends a.a {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Context f8561i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ TextPaint f8562j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ a.a f8563k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ d f8564l;

    public c(d dVar, Context context, TextPaint textPaint, a.a aVar) {
        this.f8564l = dVar;
        this.f8561i = context;
        this.f8562j = textPaint;
        this.f8563k = aVar;
    }

    @Override // a.a
    public final void D(int i9) {
        this.f8563k.D(i9);
    }

    @Override // a.a
    public final void E(Typeface typeface, boolean z8) {
        this.f8564l.g(this.f8561i, this.f8562j, typeface);
        this.f8563k.E(typeface, z8);
    }
}
