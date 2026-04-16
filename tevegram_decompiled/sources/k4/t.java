package k4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t implements b4.m {

    /* renamed from: b, reason: collision with root package name */
    public final b4.m f5594b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f5595c;

    public t(b4.m mVar, boolean z8) {
        this.f5594b = mVar;
        this.f5595c = z8;
    }

    @Override // b4.m
    public final d4.a0 a(Context context, d4.a0 a0Var, int i9, int i10) {
        e4.a aVar = com.bumptech.glide.b.a(context).f1731i;
        Drawable drawable = (Drawable) a0Var.get();
        d a9 = s.a(aVar, drawable, i9, i10);
        if (a9 == null) {
            if (!this.f5595c) {
                return a0Var;
            }
            androidx.fragment.app.a.m(drawable, " to a Bitmap", "Unable to convert ");
            return null;
        }
        d4.a0 a10 = this.f5594b.a(context, a9, i9, i10);
        if (!a10.equals(a9)) {
            return new d(context.getResources(), a10);
        }
        a10.d();
        return a0Var;
    }

    @Override // b4.f
    public final void b(MessageDigest messageDigest) {
        this.f5594b.b(messageDigest);
    }

    @Override // b4.f
    public final boolean equals(Object obj) {
        if (obj instanceof t) {
            return this.f5594b.equals(((t) obj).f5594b);
        }
        return false;
    }

    @Override // b4.f
    public final int hashCode() {
        return this.f5594b.hashCode();
    }
}
