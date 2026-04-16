package o4;

import android.content.Context;
import android.graphics.Bitmap;
import b4.m;
import d4.a0;
import java.security.MessageDigest;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e implements m {

    /* renamed from: b, reason: collision with root package name */
    public final m f7902b;

    public e(m mVar) {
        w4.f.c(mVar, "Argument must not be null");
        this.f7902b = mVar;
    }

    @Override // b4.m
    public final a0 a(Context context, a0 a0Var, int i9, int i10) {
        c cVar = (c) a0Var.get();
        a0 dVar = new k4.d(((h) cVar.f7890i.f7889b).f7922l, com.bumptech.glide.b.a(context).f1731i);
        m mVar = this.f7902b;
        a0 a9 = mVar.a(context, dVar, i9, i10);
        if (!dVar.equals(a9)) {
            dVar.d();
        }
        ((h) cVar.f7890i.f7889b).c(mVar, (Bitmap) a9.get());
        return a0Var;
    }

    @Override // b4.f
    public final void b(MessageDigest messageDigest) {
        this.f7902b.b(messageDigest);
    }

    @Override // b4.f
    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f7902b.equals(((e) obj).f7902b);
        }
        return false;
    }

    @Override // b4.f
    public final int hashCode() {
        return this.f7902b.hashCode();
    }
}
