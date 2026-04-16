package androidx.media3.decoder.ffmpeg;

import d1.s;
import g1.p;
import g1.w;
import j1.c;
import j1.e;
import j1.f;
import j1.h;
import j1.i;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class FfmpegAudioDecoder extends h {

    /* renamed from: o, reason: collision with root package name */
    public final String f971o;

    /* renamed from: p, reason: collision with root package name */
    public final byte[] f972p;

    /* renamed from: q, reason: collision with root package name */
    public final int f973q;

    /* renamed from: r, reason: collision with root package name */
    public final int f974r;

    /* renamed from: s, reason: collision with root package name */
    public long f975s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f976t;

    /* renamed from: u, reason: collision with root package name */
    public volatile int f977u;

    /* renamed from: v, reason: collision with root package name */
    public volatile int f978v;

    public FfmpegAudioDecoder(int i9, s sVar, boolean z8) {
        super(new e[16], new i[16]);
        List list;
        byte[] bArr;
        byte[] bArr2;
        if (!FfmpegLibrary.d()) {
            throw new k1.a("Failed to load decoder native libraries.");
        }
        String str = sVar.f2554m;
        str.getClass();
        String a9 = FfmpegLibrary.a(str);
        a9.getClass();
        this.f971o = a9;
        list = sVar.f2556o;
        switch (str) {
            case "audio/vorbis":
                byte[] bArr3 = (byte[]) list.get(0);
                byte[] bArr4 = (byte[]) list.get(1);
                byte[] bArr5 = new byte[bArr3.length + bArr4.length + 6];
                bArr5[0] = (byte) (bArr3.length >> 8);
                bArr5[1] = (byte) (bArr3.length & 255);
                System.arraycopy(bArr3, 0, bArr5, 2, bArr3.length);
                bArr5[bArr3.length + 2] = 0;
                bArr5[bArr3.length + 3] = 0;
                bArr5[bArr3.length + 4] = (byte) (bArr4.length >> 8);
                bArr5[bArr3.length + 5] = (byte) (bArr4.length & 255);
                System.arraycopy(bArr4, 0, bArr5, bArr3.length + 6, bArr4.length);
                bArr = bArr5;
                break;
            case "audio/mp4a-latm":
            case "audio/opus":
                bArr2 = (byte[]) list.get(0);
                bArr = bArr2;
                break;
            case "audio/alac":
                byte[] bArr6 = (byte[]) list.get(0);
                int length = bArr6.length + 12;
                ByteBuffer allocate = ByteBuffer.allocate(length);
                allocate.putInt(length);
                allocate.putInt(1634492771);
                allocate.putInt(0);
                allocate.put(bArr6, 0, bArr6.length);
                bArr2 = allocate.array();
                bArr = bArr2;
                break;
            default:
                bArr2 = null;
                bArr = bArr2;
                break;
        }
        this.f972p = bArr;
        this.f973q = z8 ? 4 : 2;
        this.f974r = z8 ? 131072 : 65536;
        long ffmpegInitialize = ffmpegInitialize(a9, bArr, z8, sVar.A, sVar.f2567z);
        this.f975s = ffmpegInitialize;
        if (ffmpegInitialize == 0) {
            throw new k1.a("Initialization failed.");
        }
        int i10 = this.f5375g;
        e[] eVarArr = this.f5373e;
        g1.a.k(i10 == eVarArr.length);
        for (e eVar : eVarArr) {
            eVar.m(i9);
        }
    }

    private native int ffmpegDecode(long j5, ByteBuffer byteBuffer, int i9, ByteBuffer byteBuffer2, int i10);

    private native int ffmpegGetChannelCount(long j5);

    private native int ffmpegGetSampleRate(long j5);

    private native long ffmpegInitialize(String str, byte[] bArr, boolean z8, int i9, int i10);

    private native void ffmpegRelease(long j5);

    private native long ffmpegReset(long j5, byte[] bArr);

    @Override // j1.h
    public final e e() {
        return new e(2, FfmpegLibrary.b());
    }

    @Override // j1.h
    public final f f() {
        return new i(new a(this));
    }

    @Override // j1.h
    public final c g(Throwable th) {
        return new k1.a("Unexpected decode error", th);
    }

    @Override // j1.h
    public final c h(e eVar, f fVar, boolean z8) {
        i iVar = (i) fVar;
        if (z8) {
            long ffmpegReset = ffmpegReset(this.f975s, this.f972p);
            this.f975s = ffmpegReset;
            if (ffmpegReset == 0) {
                return new k1.a("Error resetting (see logcat).");
            }
        }
        ByteBuffer byteBuffer = eVar.f5359m;
        int i9 = w.f3713a;
        int limit = byteBuffer.limit();
        long j5 = eVar.f5361o;
        int i10 = this.f974r;
        iVar.f5365k = j5;
        ByteBuffer byteBuffer2 = iVar.f5383n;
        if (byteBuffer2 == null || byteBuffer2.capacity() < i10) {
            iVar.f5383n = ByteBuffer.allocateDirect(i10).order(ByteOrder.nativeOrder());
        }
        iVar.f5383n.position(0);
        iVar.f5383n.limit(i10);
        ByteBuffer byteBuffer3 = iVar.f5383n;
        int ffmpegDecode = ffmpegDecode(this.f975s, byteBuffer, limit, byteBuffer3, this.f974r);
        if (ffmpegDecode == -2) {
            return new k1.a("Error decoding (see logcat).");
        }
        if (ffmpegDecode == -1) {
            iVar.f3748j = Integer.MIN_VALUE;
            return null;
        }
        if (ffmpegDecode == 0) {
            iVar.f3748j = Integer.MIN_VALUE;
            return null;
        }
        if (!this.f976t) {
            this.f977u = ffmpegGetChannelCount(this.f975s);
            this.f978v = ffmpegGetSampleRate(this.f975s);
            if (this.f978v == 0 && "alac".equals(this.f971o)) {
                this.f972p.getClass();
                p pVar = new p(this.f972p);
                pVar.F(this.f972p.length - 4);
                this.f978v = pVar.x();
            }
            this.f976t = true;
        }
        byteBuffer3.position(0);
        byteBuffer3.limit(ffmpegDecode);
        return null;
    }

    public final String o() {
        return "ffmpeg" + FfmpegLibrary.c() + "-" + this.f971o;
    }

    @Override // j1.h, j1.b
    public final void release() {
        super.release();
        ffmpegRelease(this.f975s);
        this.f975s = 0L;
    }
}
