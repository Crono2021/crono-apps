package v1;

import android.media.MediaCodec;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    public final z1.d f9391a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9392b;

    /* renamed from: c, reason: collision with root package name */
    public final g1.p f9393c;

    /* renamed from: d, reason: collision with root package name */
    public q0 f9394d;

    /* renamed from: e, reason: collision with root package name */
    public q0 f9395e;

    /* renamed from: f, reason: collision with root package name */
    public q0 f9396f;

    /* renamed from: g, reason: collision with root package name */
    public long f9397g;

    public r0(z1.d dVar) {
        this.f9391a = dVar;
        int i9 = dVar.f10543b;
        this.f9392b = i9;
        this.f9393c = new g1.p(32);
        q0 q0Var = new q0(0L, i9);
        this.f9394d = q0Var;
        this.f9395e = q0Var;
        this.f9396f = q0Var;
    }

    public static q0 d(q0 q0Var, long j5, ByteBuffer byteBuffer, int i9) {
        while (j5 >= q0Var.f9381j) {
            q0Var = (q0) q0Var.f9383l;
        }
        while (i9 > 0) {
            int min = Math.min(i9, (int) (q0Var.f9381j - j5));
            z1.a aVar = (z1.a) q0Var.f9382k;
            byteBuffer.put(aVar.f10536a, ((int) (j5 - q0Var.f9380i)) + aVar.f10537b, min);
            i9 -= min;
            j5 += min;
            if (j5 == q0Var.f9381j) {
                q0Var = (q0) q0Var.f9383l;
            }
        }
        return q0Var;
    }

    public static q0 e(q0 q0Var, long j5, byte[] bArr, int i9) {
        while (j5 >= q0Var.f9381j) {
            q0Var = (q0) q0Var.f9383l;
        }
        int i10 = i9;
        while (i10 > 0) {
            int min = Math.min(i10, (int) (q0Var.f9381j - j5));
            z1.a aVar = (z1.a) q0Var.f9382k;
            System.arraycopy(aVar.f10536a, ((int) (j5 - q0Var.f9380i)) + aVar.f10537b, bArr, i9 - i10, min);
            i10 -= min;
            j5 += min;
            if (j5 == q0Var.f9381j) {
                q0Var = (q0) q0Var.f9383l;
            }
        }
        return q0Var;
    }

    public static q0 f(q0 q0Var, j1.e eVar, com.google.crypto.tink.shaded.protobuf.d dVar, g1.p pVar) {
        if (eVar.c(1073741824)) {
            long j5 = dVar.f2214b;
            int i9 = 1;
            pVar.C(1);
            q0 e9 = e(q0Var, j5, pVar.f3699a, 1);
            long j9 = j5 + 1;
            byte b9 = pVar.f3699a[0];
            boolean z8 = (b9 & 128) != 0;
            int i10 = b9 & Byte.MAX_VALUE;
            j1.a aVar = eVar.f5358l;
            byte[] bArr = aVar.f5348a;
            if (bArr == null) {
                aVar.f5348a = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            q0Var = e(e9, j9, aVar.f5348a, i10);
            long j10 = j9 + i10;
            if (z8) {
                pVar.C(2);
                q0Var = e(q0Var, j10, pVar.f3699a, 2);
                j10 += 2;
                i9 = pVar.z();
            }
            int[] iArr = aVar.f5351d;
            if (iArr == null || iArr.length < i9) {
                iArr = new int[i9];
            }
            int[] iArr2 = aVar.f5352e;
            if (iArr2 == null || iArr2.length < i9) {
                iArr2 = new int[i9];
            }
            if (z8) {
                int i11 = i9 * 6;
                pVar.C(i11);
                q0Var = e(q0Var, j10, pVar.f3699a, i11);
                j10 += i11;
                pVar.F(0);
                for (int i12 = 0; i12 < i9; i12++) {
                    iArr[i12] = pVar.z();
                    iArr2[i12] = pVar.x();
                }
            } else {
                iArr[0] = 0;
                iArr2[0] = dVar.f2213a - ((int) (j10 - dVar.f2214b));
            }
            d2.c0 c0Var = (d2.c0) dVar.f2215c;
            int i13 = g1.w.f3713a;
            byte[] bArr2 = c0Var.f2666b;
            byte[] bArr3 = aVar.f5348a;
            int i14 = c0Var.f2665a;
            int i15 = c0Var.f2667c;
            int i16 = c0Var.f2668d;
            aVar.f5353f = i9;
            aVar.f5351d = iArr;
            aVar.f5352e = iArr2;
            aVar.f5349b = bArr2;
            aVar.f5348a = bArr3;
            aVar.f5350c = i14;
            aVar.f5354g = i15;
            aVar.h = i16;
            MediaCodec.CryptoInfo cryptoInfo = aVar.f5355i;
            cryptoInfo.numSubSamples = i9;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr2;
            cryptoInfo.iv = bArr3;
            cryptoInfo.mode = i14;
            if (g1.w.f3713a >= 24) {
                a5.d dVar2 = aVar.f5356j;
                dVar2.getClass();
                ((MediaCodec.CryptoInfo.Pattern) dVar2.f175k).set(i15, i16);
                ((MediaCodec.CryptoInfo) dVar2.f174j).setPattern((MediaCodec.CryptoInfo.Pattern) dVar2.f175k);
            }
            long j11 = dVar.f2214b;
            int i17 = (int) (j10 - j11);
            dVar.f2214b = j11 + i17;
            dVar.f2213a -= i17;
        }
        if (!eVar.c(268435456)) {
            eVar.m(dVar.f2213a);
            return d(q0Var, dVar.f2214b, eVar.f5359m, dVar.f2213a);
        }
        pVar.C(4);
        q0 e10 = e(q0Var, dVar.f2214b, pVar.f3699a, 4);
        int x6 = pVar.x();
        dVar.f2214b += 4;
        dVar.f2213a -= 4;
        eVar.m(x6);
        q0 d9 = d(e10, dVar.f2214b, eVar.f5359m, x6);
        dVar.f2214b += x6;
        int i18 = dVar.f2213a - x6;
        dVar.f2213a = i18;
        ByteBuffer byteBuffer = eVar.f5362p;
        if (byteBuffer == null || byteBuffer.capacity() < i18) {
            eVar.f5362p = ByteBuffer.allocate(i18);
        } else {
            eVar.f5362p.clear();
        }
        return d(d9, dVar.f2214b, eVar.f5362p, dVar.f2213a);
    }

    public final void a(q0 q0Var) {
        if (((z1.a) q0Var.f9382k) == null) {
            return;
        }
        z1.d dVar = this.f9391a;
        synchronized (dVar) {
            q0 q0Var2 = q0Var;
            while (q0Var2 != null) {
                try {
                    z1.a[] aVarArr = dVar.f10547f;
                    int i9 = dVar.f10546e;
                    dVar.f10546e = i9 + 1;
                    z1.a aVar = (z1.a) q0Var2.f9382k;
                    aVar.getClass();
                    aVarArr[i9] = aVar;
                    dVar.f10545d--;
                    q0Var2 = (q0) q0Var2.f9383l;
                    if (q0Var2 == null || ((z1.a) q0Var2.f9382k) == null) {
                        q0Var2 = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            dVar.notifyAll();
        }
        q0Var.f9382k = null;
        q0Var.f9383l = null;
    }

    public final void b(long j5) {
        q0 q0Var;
        if (j5 == -1) {
            return;
        }
        while (true) {
            q0Var = this.f9394d;
            if (j5 < q0Var.f9381j) {
                break;
            }
            z1.d dVar = this.f9391a;
            z1.a aVar = (z1.a) q0Var.f9382k;
            synchronized (dVar) {
                z1.a[] aVarArr = dVar.f10547f;
                int i9 = dVar.f10546e;
                dVar.f10546e = i9 + 1;
                aVarArr[i9] = aVar;
                dVar.f10545d--;
                dVar.notifyAll();
            }
            q0 q0Var2 = this.f9394d;
            q0Var2.f9382k = null;
            q0 q0Var3 = (q0) q0Var2.f9383l;
            q0Var2.f9383l = null;
            this.f9394d = q0Var3;
        }
        if (this.f9395e.f9380i < q0Var.f9380i) {
            this.f9395e = q0Var;
        }
    }

    public final int c(int i9) {
        z1.a aVar;
        q0 q0Var = this.f9396f;
        if (((z1.a) q0Var.f9382k) == null) {
            z1.d dVar = this.f9391a;
            synchronized (dVar) {
                try {
                    int i10 = dVar.f10545d + 1;
                    dVar.f10545d = i10;
                    int i11 = dVar.f10546e;
                    if (i11 > 0) {
                        z1.a[] aVarArr = dVar.f10547f;
                        int i12 = i11 - 1;
                        dVar.f10546e = i12;
                        aVar = aVarArr[i12];
                        aVar.getClass();
                        dVar.f10547f[dVar.f10546e] = null;
                    } else {
                        z1.a aVar2 = new z1.a(new byte[dVar.f10543b], 0);
                        z1.a[] aVarArr2 = dVar.f10547f;
                        if (i10 > aVarArr2.length) {
                            dVar.f10547f = (z1.a[]) Arrays.copyOf(aVarArr2, aVarArr2.length * 2);
                        }
                        aVar = aVar2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            q0 q0Var2 = new q0(this.f9396f.f9381j, this.f9392b);
            q0Var.f9382k = aVar;
            q0Var.f9383l = q0Var2;
        }
        return Math.min(i9, (int) (this.f9396f.f9381j - this.f9397g));
    }
}
