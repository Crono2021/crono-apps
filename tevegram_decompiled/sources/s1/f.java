package s1;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayDeque;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f extends MediaCodec.Callback {

    /* renamed from: b, reason: collision with root package name */
    public final HandlerThread f8690b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f8691c;
    public MediaFormat h;

    /* renamed from: i, reason: collision with root package name */
    public MediaFormat f8696i;

    /* renamed from: j, reason: collision with root package name */
    public MediaCodec.CodecException f8697j;

    /* renamed from: k, reason: collision with root package name */
    public MediaCodec.CryptoException f8698k;

    /* renamed from: l, reason: collision with root package name */
    public long f8699l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8700m;

    /* renamed from: n, reason: collision with root package name */
    public IllegalStateException f8701n;

    /* renamed from: a, reason: collision with root package name */
    public final Object f8689a = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final o3.r f8692d = new o3.r();

    /* renamed from: e, reason: collision with root package name */
    public final o3.r f8693e = new o3.r();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayDeque f8694f = new ArrayDeque();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayDeque f8695g = new ArrayDeque();

    public f(HandlerThread handlerThread) {
        this.f8690b = handlerThread;
    }

    public final void a() {
        ArrayDeque arrayDeque = this.f8695g;
        if (!arrayDeque.isEmpty()) {
            this.f8696i = (MediaFormat) arrayDeque.getLast();
        }
        o3.r rVar = this.f8692d;
        rVar.f7796c = rVar.f7795b;
        o3.r rVar2 = this.f8693e;
        rVar2.f7796c = rVar2.f7795b;
        this.f8694f.clear();
        arrayDeque.clear();
    }

    public final void b(IllegalStateException illegalStateException) {
        synchronized (this.f8689a) {
            this.f8701n = illegalStateException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onCryptoError(MediaCodec mediaCodec, MediaCodec.CryptoException cryptoException) {
        synchronized (this.f8689a) {
            this.f8698k = cryptoException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f8689a) {
            this.f8697j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i9) {
        synchronized (this.f8689a) {
            this.f8692d.a(i9);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i9, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f8689a) {
            try {
                MediaFormat mediaFormat = this.f8696i;
                if (mediaFormat != null) {
                    this.f8693e.a(-2);
                    this.f8695g.add(mediaFormat);
                    this.f8696i = null;
                }
                this.f8693e.a(i9);
                this.f8694f.add(bufferInfo);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f8689a) {
            this.f8693e.a(-2);
            this.f8695g.add(mediaFormat);
            this.f8696i = null;
        }
    }
}
