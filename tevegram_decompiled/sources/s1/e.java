package s1;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.HandlerThread;
import d2.f0;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e implements l {

    /* renamed from: o, reason: collision with root package name */
    public static final ArrayDeque f8681o = new ArrayDeque();

    /* renamed from: p, reason: collision with root package name */
    public static final Object f8682p = new Object();

    /* renamed from: i, reason: collision with root package name */
    public final MediaCodec f8683i;

    /* renamed from: j, reason: collision with root package name */
    public final HandlerThread f8684j;

    /* renamed from: k, reason: collision with root package name */
    public g.g f8685k;

    /* renamed from: l, reason: collision with root package name */
    public final AtomicReference f8686l;

    /* renamed from: m, reason: collision with root package name */
    public final f0 f8687m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8688n;

    public e(MediaCodec mediaCodec, HandlerThread handlerThread) {
        f0 f0Var = new f0();
        this.f8683i = mediaCodec;
        this.f8684j = handlerThread;
        this.f8687m = f0Var;
        this.f8686l = new AtomicReference();
    }

    public static d a() {
        ArrayDeque arrayDeque = f8681o;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new d();
                }
                return (d) arrayDeque.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void c(d dVar) {
        ArrayDeque arrayDeque = f8681o;
        synchronized (arrayDeque) {
            arrayDeque.add(dVar);
        }
    }

    @Override // s1.l
    public final void b(int i9, j1.a aVar, long j5, int i10) {
        i();
        d a9 = a();
        a9.f8676a = i9;
        a9.f8677b = 0;
        a9.f8679d = j5;
        a9.f8680e = i10;
        MediaCodec.CryptoInfo cryptoInfo = a9.f8678c;
        cryptoInfo.numSubSamples = aVar.f5353f;
        int[] iArr = aVar.f5351d;
        int[] iArr2 = cryptoInfo.numBytesOfClearData;
        if (iArr != null) {
            if (iArr2 == null || iArr2.length < iArr.length) {
                iArr2 = Arrays.copyOf(iArr, iArr.length);
            } else {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            }
        }
        cryptoInfo.numBytesOfClearData = iArr2;
        int[] iArr3 = aVar.f5352e;
        int[] iArr4 = cryptoInfo.numBytesOfEncryptedData;
        if (iArr3 != null) {
            if (iArr4 == null || iArr4.length < iArr3.length) {
                iArr4 = Arrays.copyOf(iArr3, iArr3.length);
            } else {
                System.arraycopy(iArr3, 0, iArr4, 0, iArr3.length);
            }
        }
        cryptoInfo.numBytesOfEncryptedData = iArr4;
        byte[] bArr = aVar.f5349b;
        byte[] bArr2 = cryptoInfo.key;
        if (bArr != null) {
            if (bArr2 == null || bArr2.length < bArr.length) {
                bArr2 = Arrays.copyOf(bArr, bArr.length);
            } else {
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            }
        }
        bArr2.getClass();
        cryptoInfo.key = bArr2;
        byte[] bArr3 = aVar.f5348a;
        byte[] bArr4 = cryptoInfo.iv;
        if (bArr3 != null) {
            if (bArr4 == null || bArr4.length < bArr3.length) {
                bArr4 = Arrays.copyOf(bArr3, bArr3.length);
            } else {
                System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
            }
        }
        bArr4.getClass();
        cryptoInfo.iv = bArr4;
        cryptoInfo.mode = aVar.f5350c;
        if (g1.w.f3713a >= 24) {
            j0.j.p();
            cryptoInfo.setPattern(j0.j.k(aVar.f5354g, aVar.h));
        }
        this.f8685k.obtainMessage(1, a9).sendToTarget();
    }

    @Override // s1.l
    public final void d(long j5, int i9, int i10, int i11) {
        i();
        d a9 = a();
        a9.f8676a = i9;
        a9.f8677b = i10;
        a9.f8679d = j5;
        a9.f8680e = i11;
        g.g gVar = this.f8685k;
        int i12 = g1.w.f3713a;
        gVar.obtainMessage(0, a9).sendToTarget();
    }

    @Override // s1.l
    public final void flush() {
        if (this.f8688n) {
            try {
                g.g gVar = this.f8685k;
                gVar.getClass();
                gVar.removeCallbacksAndMessages(null);
                f0 f0Var = this.f8687m;
                f0Var.a();
                g.g gVar2 = this.f8685k;
                gVar2.getClass();
                gVar2.obtainMessage(2).sendToTarget();
                synchronized (f0Var) {
                    while (!f0Var.f2689a) {
                        f0Var.wait();
                    }
                }
            } catch (InterruptedException e9) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e9);
            }
        }
    }

    @Override // s1.l
    public final void i() {
        RuntimeException runtimeException = (RuntimeException) this.f8686l.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    @Override // s1.l
    public final void setParameters(Bundle bundle) {
        i();
        g.g gVar = this.f8685k;
        int i9 = g1.w.f3713a;
        gVar.obtainMessage(3, bundle).sendToTarget();
    }

    @Override // s1.l
    public final void shutdown() {
        if (this.f8688n) {
            flush();
            this.f8684j.quit();
        }
        this.f8688n = false;
    }

    @Override // s1.l
    public final void start() {
        if (this.f8688n) {
            return;
        }
        HandlerThread handlerThread = this.f8684j;
        handlerThread.start();
        this.f8685k = new g.g(this, handlerThread.getLooper());
        this.f8688n = true;
    }
}
