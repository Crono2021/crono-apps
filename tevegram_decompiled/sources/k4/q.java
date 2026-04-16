package k4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q {

    /* renamed from: f, reason: collision with root package name */
    public static final b4.h f5582f = b4.h.a(b4.a.f1322k, "com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat");

    /* renamed from: g, reason: collision with root package name */
    public static final b4.h f5583g = new b4.h("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", null, b4.h.f1326e);
    public static final b4.h h;

    /* renamed from: i, reason: collision with root package name */
    public static final b4.h f5584i;

    /* renamed from: j, reason: collision with root package name */
    public static final Set f5585j;

    /* renamed from: k, reason: collision with root package name */
    public static final d4.t f5586k;

    /* renamed from: l, reason: collision with root package name */
    public static final ArrayDeque f5587l;

    /* renamed from: a, reason: collision with root package name */
    public final e4.a f5588a;

    /* renamed from: b, reason: collision with root package name */
    public final DisplayMetrics f5589b;

    /* renamed from: c, reason: collision with root package name */
    public final e4.f f5590c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f5591d;

    /* renamed from: e, reason: collision with root package name */
    public final w f5592e = w.a();

    static {
        o oVar = o.f5575b;
        Boolean bool = Boolean.FALSE;
        h = b4.h.a(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize");
        f5584i = b4.h.a(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");
        f5585j = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f5586k = new d4.t(14);
        Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser$ImageType.JPEG, ImageHeaderParser$ImageType.PNG_A, ImageHeaderParser$ImageType.PNG));
        char[] cArr = w4.n.f9951a;
        f5587l = new ArrayDeque(0);
    }

    public q(ArrayList arrayList, DisplayMetrics displayMetrics, e4.a aVar, e4.f fVar) {
        this.f5591d = arrayList;
        w4.f.c(displayMetrics, "Argument must not be null");
        this.f5589b = displayMetrics;
        w4.f.c(aVar, "Argument must not be null");
        this.f5588a = aVar;
        w4.f.c(fVar, "Argument must not be null");
        this.f5590c = fVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        throw r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap c(androidx.fragment.app.g r9, android.graphics.BitmapFactory.Options r10, k4.p r11, e4.a r12) {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r10.inJustDecodeBounds
            if (r1 != 0) goto L22
            r11.m0()
            int r1 = r9.f727i
            switch(r1) {
                case 15: goto L22;
                case 16: goto Lf;
                default: goto Le;
            }
        Le:
            goto L22
        Lf:
            java.lang.Object r1 = r9.f728j
            com.bumptech.glide.load.data.i r1 = (com.bumptech.glide.load.data.i) r1
            java.lang.Object r1 = r1.f1801j
            k4.x r1 = (k4.x) r1
            monitor-enter(r1)
            byte[] r2 = r1.f5604i     // Catch: java.lang.Throwable -> L1f
            int r2 = r2.length     // Catch: java.lang.Throwable -> L1f
            r1.f5606k = r2     // Catch: java.lang.Throwable -> L1f
            monitor-exit(r1)
            goto L22
        L1f:
            r9 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1f
            throw r9
        L22:
            int r1 = r10.outWidth
            int r2 = r10.outHeight
            java.lang.String r3 = r10.outMimeType
            java.util.concurrent.locks.Lock r4 = k4.z.f5613d
            r4.lock()
            android.graphics.Bitmap r9 = r9.G(r10)     // Catch: java.lang.IllegalArgumentException -> L35 java.lang.Throwable -> L7c
            r4.unlock()
            return r9
        L35:
            r4 = move-exception
            java.io.IOException r5 = new java.io.IOException     // Catch: java.lang.Throwable -> L7c
            java.lang.String r6 = "Exception decoding bitmap, outWidth: "
            java.lang.String r7 = ", outHeight: "
            java.lang.String r8 = ", outMimeType: "
            java.lang.StringBuilder r1 = androidx.activity.g.q(r6, r1, r7, r2, r8)     // Catch: java.lang.Throwable -> L7c
            r1.append(r3)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r2 = ", inBitmap: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L7c
            android.graphics.Bitmap r2 = r10.inBitmap     // Catch: java.lang.Throwable -> L7c
            java.lang.String r2 = d(r2)     // Catch: java.lang.Throwable -> L7c
            r1.append(r2)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L7c
            r5.<init>(r1, r4)     // Catch: java.lang.Throwable -> L7c
            r1 = 3
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> L7c
            if (r1 == 0) goto L66
            java.lang.String r1 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r1, r5)     // Catch: java.lang.Throwable -> L7c
        L66:
            android.graphics.Bitmap r0 = r10.inBitmap     // Catch: java.lang.Throwable -> L7c
            if (r0 == 0) goto L7b
            r12.g(r0)     // Catch: java.io.IOException -> L7a java.lang.Throwable -> L7c
            r0 = 0
            r10.inBitmap = r0     // Catch: java.io.IOException -> L7a java.lang.Throwable -> L7c
            android.graphics.Bitmap r9 = c(r9, r10, r11, r12)     // Catch: java.io.IOException -> L7a java.lang.Throwable -> L7c
            java.util.concurrent.locks.Lock r10 = k4.z.f5613d
            r10.unlock()
            return r9
        L7a:
            throw r5     // Catch: java.lang.Throwable -> L7c
        L7b:
            throw r5     // Catch: java.lang.Throwable -> L7c
        L7c:
            r9 = move-exception
            java.util.concurrent.locks.Lock r10 = k4.z.f5613d
            r10.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.q.c(androidx.fragment.app.g, android.graphics.BitmapFactory$Options, k4.p, e4.a):android.graphics.Bitmap");
    }

    public static String d(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    public static void e(BitmapFactory.Options options) {
        f(options);
        ArrayDeque arrayDeque = f5587l;
        synchronized (arrayDeque) {
            arrayDeque.offer(options);
        }
    }

    public static void f(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public final d a(androidx.fragment.app.g gVar, int i9, int i10, b4.i iVar, p pVar) {
        BitmapFactory.Options options;
        BitmapFactory.Options options2;
        byte[] bArr = (byte[]) this.f5590c.d(65536, byte[].class);
        synchronized (q.class) {
            ArrayDeque arrayDeque = f5587l;
            synchronized (arrayDeque) {
                options = (BitmapFactory.Options) arrayDeque.poll();
            }
            if (options == null) {
                options = new BitmapFactory.Options();
                f(options);
            }
            options2 = options;
        }
        options2.inTempStorage = bArr;
        b4.a aVar = (b4.a) iVar.c(f5582f);
        b4.j jVar = (b4.j) iVar.c(f5583g);
        o oVar = (o) iVar.c(o.f5580g);
        boolean booleanValue = ((Boolean) iVar.c(h)).booleanValue();
        b4.h hVar = f5584i;
        try {
            return d.b(b(gVar, options2, oVar, aVar, jVar, iVar.c(hVar) != null && ((Boolean) iVar.c(hVar)).booleanValue(), i9, i10, booleanValue, pVar), this.f5588a);
        } finally {
            e(options2);
            this.f5590c.h(bArr);
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02c0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0411 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0497 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x04da  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x058d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap b(androidx.fragment.app.g r44, android.graphics.BitmapFactory.Options r45, k4.o r46, b4.a r47, b4.j r48, boolean r49, int r50, int r51, boolean r52, k4.p r53) {
        /*
            Method dump skipped, instructions count: 1656
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.q.b(androidx.fragment.app.g, android.graphics.BitmapFactory$Options, k4.o, b4.a, b4.j, boolean, int, int, boolean, k4.p):android.graphics.Bitmap");
    }
}
