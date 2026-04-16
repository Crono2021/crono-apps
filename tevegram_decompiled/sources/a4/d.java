package a4;

import android.graphics.Bitmap;
import e4.f;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public int[] f151a;

    /* renamed from: c, reason: collision with root package name */
    public final m1.b f153c;

    /* renamed from: d, reason: collision with root package name */
    public ByteBuffer f154d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f155e;

    /* renamed from: f, reason: collision with root package name */
    public short[] f156f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f157g;
    public byte[] h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f158i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f159j;

    /* renamed from: k, reason: collision with root package name */
    public int f160k;

    /* renamed from: l, reason: collision with root package name */
    public b f161l;

    /* renamed from: m, reason: collision with root package name */
    public Bitmap f162m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f163n;

    /* renamed from: o, reason: collision with root package name */
    public int f164o;

    /* renamed from: p, reason: collision with root package name */
    public final int f165p;

    /* renamed from: q, reason: collision with root package name */
    public final int f166q;

    /* renamed from: r, reason: collision with root package name */
    public final int f167r;

    /* renamed from: s, reason: collision with root package name */
    public Boolean f168s;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f152b = new int[256];

    /* renamed from: t, reason: collision with root package name */
    public Bitmap.Config f169t = Bitmap.Config.ARGB_8888;

    public d(m1.b bVar, b bVar2, ByteBuffer byteBuffer, int i9) {
        this.f153c = bVar;
        this.f161l = new b();
        synchronized (this) {
            try {
                if (i9 <= 0) {
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i9);
                }
                int highestOneBit = Integer.highestOneBit(i9);
                int i10 = 0;
                this.f164o = 0;
                this.f161l = bVar2;
                this.f160k = -1;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.f154d = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.f154d.order(ByteOrder.LITTLE_ENDIAN);
                this.f163n = false;
                ArrayList arrayList = bVar2.f141e;
                int size = arrayList.size();
                while (true) {
                    if (i10 >= size) {
                        break;
                    }
                    Object obj = arrayList.get(i10);
                    i10++;
                    if (((a) obj).f133g == 3) {
                        this.f163n = true;
                        break;
                    }
                }
                this.f165p = highestOneBit;
                int i11 = bVar2.f142f;
                this.f167r = i11 / highestOneBit;
                int i12 = bVar2.f143g;
                this.f166q = i12 / highestOneBit;
                int i13 = i11 * i12;
                f fVar = (f) this.f153c.f6511k;
                this.f158i = fVar == null ? new byte[i13] : (byte[]) fVar.d(i13, byte[].class);
                m1.b bVar3 = this.f153c;
                int i14 = this.f167r * this.f166q;
                f fVar2 = (f) bVar3.f6511k;
                this.f159j = fVar2 == null ? new int[i14] : (int[]) fVar2.d(i14, int[].class);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Bitmap a() {
        Boolean bool = this.f168s;
        Bitmap e9 = ((e4.a) this.f153c.f6510j).e(this.f167r, this.f166q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f169t);
        e9.setHasAlpha(true);
        return e9;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0051 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:18:0x005b, B:19:0x0066, B:20:0x005e, B:21:0x0068, B:23:0x0079, B:24:0x0085, B:27:0x008e, B:29:0x0092, B:31:0x009a, B:32:0x00ad, B:36:0x00b1, B:38:0x00b5, B:40:0x00c7, B:42:0x00cb, B:43:0x00cf, B:46:0x008a, B:48:0x00d5, B:50:0x00dd, B:53:0x0017, B:55:0x001f, B:56:0x003e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0079 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:18:0x005b, B:19:0x0066, B:20:0x005e, B:21:0x0068, B:23:0x0079, B:24:0x0085, B:27:0x008e, B:29:0x0092, B:31:0x009a, B:32:0x00ad, B:36:0x00b1, B:38:0x00b5, B:40:0x00c7, B:42:0x00cb, B:43:0x00cf, B:46:0x008a, B:48:0x00d5, B:50:0x00dd, B:53:0x0017, B:55:0x001f, B:56:0x003e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:18:0x005b, B:19:0x0066, B:20:0x005e, B:21:0x0068, B:23:0x0079, B:24:0x0085, B:27:0x008e, B:29:0x0092, B:31:0x009a, B:32:0x00ad, B:36:0x00b1, B:38:0x00b5, B:40:0x00c7, B:42:0x00cb, B:43:0x00cf, B:46:0x008a, B:48:0x00d5, B:50:0x00dd, B:53:0x0017, B:55:0x001f, B:56:0x003e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b1 A[Catch: all -> 0x0014, TRY_ENTER, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:18:0x005b, B:19:0x0066, B:20:0x005e, B:21:0x0068, B:23:0x0079, B:24:0x0085, B:27:0x008e, B:29:0x0092, B:31:0x009a, B:32:0x00ad, B:36:0x00b1, B:38:0x00b5, B:40:0x00c7, B:42:0x00cb, B:43:0x00cf, B:46:0x008a, B:48:0x00d5, B:50:0x00dd, B:53:0x0017, B:55:0x001f, B:56:0x003e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008a A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:18:0x005b, B:19:0x0066, B:20:0x005e, B:21:0x0068, B:23:0x0079, B:24:0x0085, B:27:0x008e, B:29:0x0092, B:31:0x009a, B:32:0x00ad, B:36:0x00b1, B:38:0x00b5, B:40:0x00c7, B:42:0x00cb, B:43:0x00cf, B:46:0x008a, B:48:0x00d5, B:50:0x00dd, B:53:0x0017, B:55:0x001f, B:56:0x003e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00dd A[Catch: all -> 0x0014, TRY_LEAVE, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:18:0x005b, B:19:0x0066, B:20:0x005e, B:21:0x0068, B:23:0x0079, B:24:0x0085, B:27:0x008e, B:29:0x0092, B:31:0x009a, B:32:0x00ad, B:36:0x00b1, B:38:0x00b5, B:40:0x00c7, B:42:0x00cb, B:43:0x00cf, B:46:0x008a, B:48:0x00d5, B:50:0x00dd, B:53:0x0017, B:55:0x001f, B:56:0x003e), top: B:3:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized android.graphics.Bitmap b() {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.d.b():android.graphics.Bitmap");
    }

    public final void c(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.f169t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
    
        if (r5.f145j == r36.h) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap d(a4.a r36, a4.a r37) {
        /*
            Method dump skipped, instructions count: 1044
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.d.d(a4.a, a4.a):android.graphics.Bitmap");
    }
}
