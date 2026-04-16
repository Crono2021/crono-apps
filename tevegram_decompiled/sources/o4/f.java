package o4;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import w4.n;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f implements t4.b {

    /* renamed from: i, reason: collision with root package name */
    public final int f7903i;

    /* renamed from: j, reason: collision with root package name */
    public final int f7904j;

    /* renamed from: k, reason: collision with root package name */
    public s4.c f7905k;

    /* renamed from: l, reason: collision with root package name */
    public final Handler f7906l;

    /* renamed from: m, reason: collision with root package name */
    public final int f7907m;

    /* renamed from: n, reason: collision with root package name */
    public final long f7908n;

    /* renamed from: o, reason: collision with root package name */
    public Bitmap f7909o;

    public f(Handler handler, int i9, long j5) {
        if (!n.i(Integer.MIN_VALUE, Integer.MIN_VALUE)) {
            m7.c.n("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: -2147483648 and height: -2147483648");
            throw null;
        }
        this.f7903i = Integer.MIN_VALUE;
        this.f7904j = Integer.MIN_VALUE;
        this.f7906l = handler;
        this.f7907m = i9;
        this.f7908n = j5;
    }

    @Override // t4.b
    public final void a(s4.c cVar) {
        this.f7905k = cVar;
    }

    @Override // t4.b
    public final void e(s4.f fVar) {
        fVar.l(this.f7903i, this.f7904j);
    }

    @Override // t4.b
    public final s4.c g() {
        return this.f7905k;
    }

    @Override // t4.b
    public final void h(Drawable drawable) {
        this.f7909o = null;
    }

    @Override // t4.b
    public final void i(Object obj) {
        this.f7909o = (Bitmap) obj;
        Handler handler = this.f7906l;
        handler.sendMessageAtTime(handler.obtainMessage(1, this), this.f7908n);
    }

    @Override // com.bumptech.glide.manager.h
    public final void c() {
    }

    @Override // com.bumptech.glide.manager.h
    public final void j() {
    }

    @Override // com.bumptech.glide.manager.h
    public final void k() {
    }

    @Override // t4.b
    public final void b(Drawable drawable) {
    }

    @Override // t4.b
    public final void d(s4.f fVar) {
    }

    @Override // t4.b
    public final void f(Drawable drawable) {
    }
}
