package o4;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bumptech.glide.k;
import com.bumptech.glide.m;
import java.util.ArrayList;
import w4.n;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final a4.d f7912a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f7913b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f7914c;

    /* renamed from: d, reason: collision with root package name */
    public final m f7915d;

    /* renamed from: e, reason: collision with root package name */
    public final e4.a f7916e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7917f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7918g;
    public k h;

    /* renamed from: i, reason: collision with root package name */
    public f f7919i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7920j;

    /* renamed from: k, reason: collision with root package name */
    public f f7921k;

    /* renamed from: l, reason: collision with root package name */
    public Bitmap f7922l;

    /* renamed from: m, reason: collision with root package name */
    public f f7923m;

    /* renamed from: n, reason: collision with root package name */
    public int f7924n;

    /* renamed from: o, reason: collision with root package name */
    public int f7925o;

    /* renamed from: p, reason: collision with root package name */
    public int f7926p;

    public h(com.bumptech.glide.b bVar, a4.d dVar, int i9, int i10, Bitmap bitmap) {
        e4.a aVar = bVar.f1731i;
        com.bumptech.glide.e eVar = bVar.f1733k;
        m d9 = com.bumptech.glide.b.d(eVar.getBaseContext());
        m d10 = com.bumptech.glide.b.d(eVar.getBaseContext());
        d10.getClass();
        k a9 = new k(d10.f1815i, d10, Bitmap.class, d10.f1816j).a(m.f1814s).a(((s4.e) ((s4.e) ((s4.e) new s4.e().d(d4.m.f2879b)).s()).o()).i(i9, i10));
        this.f7914c = new ArrayList();
        this.f7915d = d9;
        Handler handler = new Handler(Looper.getMainLooper(), new g(this, 0));
        this.f7916e = aVar;
        this.f7913b = handler;
        this.h = a9;
        this.f7912a = dVar;
        c(j4.c.f5434b, bitmap);
    }

    public final void a() {
        int i9;
        if (!this.f7917f || this.f7918g) {
            return;
        }
        f fVar = this.f7923m;
        if (fVar != null) {
            this.f7923m = null;
            b(fVar);
            return;
        }
        this.f7918g = true;
        a4.d dVar = this.f7912a;
        int i10 = dVar.f161l.f139c;
        long uptimeMillis = SystemClock.uptimeMillis() + ((i10 <= 0 || (i9 = dVar.f160k) < 0) ? 0 : (i9 < 0 || i9 >= i10) ? -1 : ((a4.a) r2.f141e.get(i9)).f134i);
        int i11 = (dVar.f160k + 1) % dVar.f161l.f139c;
        dVar.f160k = i11;
        this.f7921k = new f(this.f7913b, i11, uptimeMillis);
        k z8 = this.h.a((s4.e) new s4.e().n(new v4.b(Double.valueOf(Math.random())))).z(dVar);
        z8.y(this.f7921k, z8);
    }

    public final void b(f fVar) {
        this.f7918g = false;
        boolean z8 = this.f7920j;
        Handler handler = this.f7913b;
        if (z8) {
            handler.obtainMessage(2, fVar).sendToTarget();
            return;
        }
        if (!this.f7917f) {
            this.f7923m = fVar;
            return;
        }
        if (fVar.f7909o != null) {
            Bitmap bitmap = this.f7922l;
            if (bitmap != null) {
                this.f7916e.g(bitmap);
                this.f7922l = null;
            }
            f fVar2 = this.f7919i;
            this.f7919i = fVar;
            ArrayList arrayList = this.f7914c;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                c cVar = (c) arrayList.get(size);
                Object callback = cVar.getCallback();
                while (callback instanceof Drawable) {
                    callback = ((Drawable) callback).getCallback();
                }
                if (callback == null) {
                    cVar.stop();
                    cVar.invalidateSelf();
                } else {
                    cVar.invalidateSelf();
                    f fVar3 = ((h) cVar.f7890i.f7889b).f7919i;
                    if ((fVar3 != null ? fVar3.f7907m : -1) == r5.f7912a.f161l.f139c - 1) {
                        cVar.f7895n++;
                    }
                    int i9 = cVar.f7896o;
                    if (i9 != -1 && cVar.f7895n >= i9) {
                        cVar.stop();
                    }
                }
            }
            if (fVar2 != null) {
                handler.obtainMessage(2, fVar2).sendToTarget();
            }
        }
        a();
    }

    public final void c(b4.m mVar, Bitmap bitmap) {
        w4.f.c(mVar, "Argument must not be null");
        w4.f.c(bitmap, "Argument must not be null");
        this.f7922l = bitmap;
        this.h = this.h.a(new s4.e().p(mVar, true));
        this.f7924n = n.c(bitmap);
        this.f7925o = bitmap.getWidth();
        this.f7926p = bitmap.getHeight();
    }
}
