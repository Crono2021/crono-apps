package d4;

import android.os.SystemClock;
import android.util.Log;
import java.util.Collections;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e0 implements g, f {

    /* renamed from: i, reason: collision with root package name */
    public final h f2827i;

    /* renamed from: j, reason: collision with root package name */
    public final k f2828j;

    /* renamed from: k, reason: collision with root package name */
    public volatile int f2829k;

    /* renamed from: l, reason: collision with root package name */
    public volatile d f2830l;

    /* renamed from: m, reason: collision with root package name */
    public volatile Object f2831m;

    /* renamed from: n, reason: collision with root package name */
    public volatile h4.p f2832n;

    /* renamed from: o, reason: collision with root package name */
    public volatile e f2833o;

    public e0(h hVar, k kVar) {
        this.f2827i = hVar;
        this.f2828j = kVar;
    }

    @Override // d4.f
    public final void a(b4.f fVar, Object obj, com.bumptech.glide.load.data.e eVar, int i9, b4.f fVar2) {
        this.f2828j.a(fVar, obj, eVar, this.f2832n.f4002c.getDataSource(), fVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
    
        if (d(r0) == false) goto L16;
     */
    @Override // d4.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f2831m
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L20
            java.lang.Object r0 = r7.f2831m
            r7.f2831m = r1
            boolean r0 = r7.d(r0)     // Catch: java.io.IOException -> L11
            if (r0 != 0) goto L20
            goto L2c
        L11:
            r0 = move-exception
            r3 = 3
            java.lang.String r4 = "SourceGenerator"
            boolean r3 = android.util.Log.isLoggable(r4, r3)
            if (r3 == 0) goto L20
            java.lang.String r3 = "Failed to properly rewind or write data to cache"
            android.util.Log.d(r4, r3, r0)
        L20:
            d4.d r0 = r7.f2830l
            if (r0 == 0) goto L2d
            d4.d r0 = r7.f2830l
            boolean r0 = r0.b()
            if (r0 == 0) goto L2d
        L2c:
            return r2
        L2d:
            r7.f2830l = r1
            r7.f2832n = r1
            r0 = 0
        L32:
            if (r0 != 0) goto L93
            int r1 = r7.f2829k
            d4.h r3 = r7.f2827i
            java.util.ArrayList r3 = r3.b()
            int r3 = r3.size()
            if (r1 >= r3) goto L93
            d4.h r1 = r7.f2827i
            java.util.ArrayList r1 = r1.b()
            int r3 = r7.f2829k
            int r4 = r3 + 1
            r7.f2829k = r4
            java.lang.Object r1 = r1.get(r3)
            h4.p r1 = (h4.p) r1
            r7.f2832n = r1
            h4.p r1 = r7.f2832n
            if (r1 == 0) goto L32
            d4.h r1 = r7.f2827i
            d4.m r1 = r1.f2848p
            h4.p r3 = r7.f2832n
            com.bumptech.glide.load.data.e r3 = r3.f4002c
            int r3 = r3.getDataSource()
            boolean r1 = r1.a(r3)
            if (r1 != 0) goto L7c
            d4.h r1 = r7.f2827i
            h4.p r3 = r7.f2832n
            com.bumptech.glide.load.data.e r3 = r3.f4002c
            java.lang.Class r3 = r3.a()
            d4.y r1 = r1.c(r3)
            if (r1 == 0) goto L32
        L7c:
            h4.p r0 = r7.f2832n
            h4.p r1 = r7.f2832n
            com.bumptech.glide.load.data.e r1 = r1.f4002c
            d4.h r3 = r7.f2827i
            com.bumptech.glide.g r3 = r3.f2847o
            a5.d r4 = new a5.d
            r5 = 9
            r6 = 0
            r4.<init>(r7, r0, r5, r6)
            r1.c(r3, r4)
            r0 = 1
            goto L32
        L93:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.e0.b():boolean");
    }

    @Override // d4.f
    public final void c(b4.f fVar, Exception exc, com.bumptech.glide.load.data.e eVar, int i9) {
        this.f2828j.c(fVar, exc, eVar, this.f2832n.f4002c.getDataSource());
    }

    @Override // d4.g
    public final void cancel() {
        h4.p pVar = this.f2832n;
        if (pVar != null) {
            pVar.f4002c.cancel();
        }
    }

    public final boolean d(Object obj) {
        Throwable th;
        int i9 = w4.h.f9940b;
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        boolean z8 = false;
        try {
            com.bumptech.glide.load.data.g h = this.f2827i.f2836c.b().h(obj);
            Object a9 = h.a();
            b4.b d9 = this.f2827i.d(a9);
            androidx.fragment.app.g gVar = new androidx.fragment.app.g(d9, a9, this.f2827i.f2841i, 4);
            b4.f fVar = this.f2832n.f4000a;
            h hVar = this.f2827i;
            e eVar = new e(fVar, hVar.f2846n);
            f4.a a10 = hVar.h.a();
            a10.o(eVar, gVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + eVar + ", data: " + obj + ", encoder: " + d9 + ", duration: " + w4.h.a(elapsedRealtimeNanos));
            }
            if (a10.r(eVar) != null) {
                this.f2833o = eVar;
                this.f2830l = new d(Collections.singletonList(this.f2832n.f4000a), this.f2827i, this);
                this.f2832n.f4002c.b();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Attempt to write: " + this.f2833o + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.f2828j.a(this.f2832n.f4000a, h.a(), this.f2832n.f4002c, this.f2832n.f4002c.getDataSource(), this.f2832n.f4000a);
                return false;
            } catch (Throwable th2) {
                th = th2;
                z8 = true;
                if (z8) {
                    throw th;
                }
                this.f2832n.f4002c.b();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
