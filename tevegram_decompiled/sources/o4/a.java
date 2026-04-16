package o4;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import b4.k;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import d4.t;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements k {

    /* renamed from: f, reason: collision with root package name */
    public static final t f7881f = new t(29);

    /* renamed from: g, reason: collision with root package name */
    public static final f4.c f7882g = new f4.c(1);

    /* renamed from: a, reason: collision with root package name */
    public final Context f7883a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f7884b;

    /* renamed from: e, reason: collision with root package name */
    public final m1.b f7887e;

    /* renamed from: d, reason: collision with root package name */
    public final t f7886d = f7881f;

    /* renamed from: c, reason: collision with root package name */
    public final f4.c f7885c = f7882g;

    public a(Context context, ArrayList arrayList, e4.a aVar, e4.f fVar) {
        this.f7883a = context.getApplicationContext();
        this.f7884b = arrayList;
        this.f7887e = new m1.b(aVar, 12, fVar);
    }

    public static int d(a4.b bVar, int i9, int i10) {
        int min = Math.min(bVar.f143g / i10, bVar.f142f / i9);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            StringBuilder q4 = androidx.activity.g.q("Downsampling GIF, sampleSize: ", max, ", target dimens: [", i9, "x");
            q4.append(i10);
            q4.append("], actual dimens: [");
            q4.append(bVar.f142f);
            q4.append("x");
            q4.append(bVar.f143g);
            q4.append("]");
            Log.v("BufferGifDecoder", q4.toString());
        }
        return max;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:30:0x0059
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // b4.k
    public final d4.a0 a(java.lang.Object r8, int r9, int r10, b4.i r11) {
        /*
            r7 = this;
            r2 = r8
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            f4.c r8 = r7.f7885c
            monitor-enter(r8)
            java.util.ArrayDeque r0 = r8.f3374a     // Catch: java.lang.Throwable -> L54
            java.lang.Object r0 = r0.poll()     // Catch: java.lang.Throwable -> L54
            a4.c r0 = (a4.c) r0     // Catch: java.lang.Throwable -> L54
            if (r0 != 0) goto L15
            a4.c r0 = new a4.c     // Catch: java.lang.Throwable -> L17
            r0.<init>()     // Catch: java.lang.Throwable -> L17
        L15:
            r5 = r0
            goto L1b
        L17:
            r0 = move-exception
            r9 = r0
            r1 = r7
            goto L57
        L1b:
            r0 = 0
            r5.f148b = r0     // Catch: java.lang.Throwable -> L54
            byte[] r0 = r5.f147a     // Catch: java.lang.Throwable -> L54
            r1 = 0
            java.util.Arrays.fill(r0, r1)     // Catch: java.lang.Throwable -> L54
            a4.b r0 = new a4.b     // Catch: java.lang.Throwable -> L54
            r0.<init>()     // Catch: java.lang.Throwable -> L54
            r5.f149c = r0     // Catch: java.lang.Throwable -> L54
            r5.f150d = r1     // Catch: java.lang.Throwable -> L54
            java.nio.ByteBuffer r0 = r2.asReadOnlyBuffer()     // Catch: java.lang.Throwable -> L54
            r5.f148b = r0     // Catch: java.lang.Throwable -> L54
            r0.position(r1)     // Catch: java.lang.Throwable -> L54
            java.nio.ByteBuffer r0 = r5.f148b     // Catch: java.lang.Throwable -> L54
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch: java.lang.Throwable -> L54
            r0.order(r1)     // Catch: java.lang.Throwable -> L54
            monitor-exit(r8)
            r1 = r7
            r3 = r9
            r4 = r10
            r6 = r11
            m4.c r8 = r1.c(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L4c
            f4.c r9 = r1.f7885c
            r9.c(r5)
            return r8
        L4c:
            r0 = move-exception
            r8 = r0
            f4.c r9 = r1.f7885c
            r9.c(r5)
            throw r8
        L54:
            r0 = move-exception
            r1 = r7
        L56:
            r9 = r0
        L57:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L59
            throw r9
        L59:
            r0 = move-exception
            goto L56
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.a.a(java.lang.Object, int, int, b4.i):d4.a0");
    }

    @Override // b4.k
    public final boolean b(Object obj, b4.i iVar) {
        return !((Boolean) iVar.c(i.f7928b)).booleanValue() && com.bumptech.glide.d.J(this.f7884b, (ByteBuffer) obj) == ImageHeaderParser$ImageType.GIF;
    }

    public final m4.c c(ByteBuffer byteBuffer, int i9, int i10, a4.c cVar, b4.i iVar) {
        StringBuilder sb;
        int i11 = w4.h.f9940b;
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            a4.b b9 = cVar.b();
            m4.c cVar2 = null;
            if (b9.f139c > 0 && b9.f138b == 0) {
                Bitmap.Config config = iVar.c(i.f7927a) == b4.a.f1321j ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                int d9 = d(b9, i9, i10);
                t tVar = this.f7886d;
                m1.b bVar = this.f7887e;
                tVar.getClass();
                a4.d dVar = new a4.d(bVar, b9, byteBuffer, d9);
                dVar.c(config);
                dVar.f160k = (dVar.f160k + 1) % dVar.f161l.f139c;
                Bitmap b10 = dVar.b();
                if (b10 == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        sb = new StringBuilder("Decoded GIF from stream in ");
                    }
                    return null;
                }
                cVar2 = new m4.c(new c(new b(new h(com.bumptech.glide.b.a(this.f7883a), dVar, i9, i10, b10), 0)), 1);
                if (!Log.isLoggable("BufferGifDecoder", 2)) {
                    return cVar2;
                }
                sb = new StringBuilder("Decoded GIF from stream in ");
                sb.append(w4.h.a(elapsedRealtimeNanos));
                Log.v("BufferGifDecoder", sb.toString());
                return cVar2;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                sb = new StringBuilder("Decoded GIF from stream in ");
                sb.append(w4.h.a(elapsedRealtimeNanos));
                Log.v("BufferGifDecoder", sb.toString());
                return cVar2;
            }
            return null;
        } catch (Throwable th) {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + w4.h.a(elapsedRealtimeNanos));
            }
            throw th;
        }
    }
}
