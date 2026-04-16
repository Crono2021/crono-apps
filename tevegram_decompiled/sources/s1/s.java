package s1;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import n1.t0;
import v1.v0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class s extends l1.e {
    public static final byte[] M0 = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    public final t A;
    public boolean A0;
    public final boolean B;
    public long B0;
    public final float C;
    public long C0;
    public final j1.e D;
    public boolean D0;
    public final j1.e E;
    public boolean E0;
    public final j1.e F;
    public boolean F0;
    public final g G;
    public boolean G0;
    public final MediaCodec.BufferInfo H;
    public l1.l H0;
    public final ArrayDeque I;
    public l1.f I0;
    public final t0 J;
    public r J0;
    public d1.s K;
    public long K0;
    public d1.s L;
    public boolean L0;
    public i7.x M;
    public i7.x N;
    public MediaCrypto O;
    public boolean P;
    public final long Q;
    public float R;
    public k S;
    public d1.s T;
    public MediaFormat U;
    public boolean V;
    public float W;
    public ArrayDeque X;
    public q Y;
    public n Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f8730a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f8731b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f8732c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f8733d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f8734e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f8735f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f8736g0;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f8737h0;
    public boolean i0;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f8738j0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f8739k0;

    /* renamed from: l0, reason: collision with root package name */
    public long f8740l0;

    /* renamed from: m0, reason: collision with root package name */
    public int f8741m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f8742n0;

    /* renamed from: o0, reason: collision with root package name */
    public ByteBuffer f8743o0;

    /* renamed from: p0, reason: collision with root package name */
    public boolean f8744p0;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f8745q0;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f8746r0;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f8747s0;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f8748t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f8749u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f8750v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f8751w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f8752x0;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f8753y0;

    /* renamed from: z, reason: collision with root package name */
    public final j f8754z;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f8755z0;

    public s(int i9, j jVar, t tVar, boolean z8, float f9) {
        super(i9);
        this.f8754z = jVar;
        tVar.getClass();
        this.A = tVar;
        this.B = z8;
        this.C = f9;
        this.D = new j1.e(0, 0);
        this.E = new j1.e(0, 0);
        this.F = new j1.e(2, 0);
        g gVar = new g(2, 0);
        gVar.f8704u = 32;
        this.G = gVar;
        this.H = new MediaCodec.BufferInfo();
        this.R = 1.0f;
        this.Q = -9223372036854775807L;
        this.I = new ArrayDeque();
        this.J0 = r.f8725e;
        gVar.m(0);
        gVar.f5359m.order(ByteOrder.nativeOrder());
        t0 t0Var = new t0();
        t0Var.f7361a = e1.d.f3023a;
        t0Var.f7363c = 0;
        t0Var.f7362b = 2;
        this.J = t0Var;
        this.W = -1.0f;
        this.f8730a0 = 0;
        this.f8750v0 = 0;
        this.f8741m0 = -1;
        this.f8742n0 = -1;
        this.f8740l0 = -9223372036854775807L;
        this.B0 = -9223372036854775807L;
        this.C0 = -9223372036854775807L;
        this.K0 = -9223372036854775807L;
        this.f8751w0 = 0;
        this.f8752x0 = 0;
        this.I0 = new l1.f();
    }

    @Override // l1.e
    public final int A() {
        return 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public final boolean B(long j5, long j9) {
        g gVar;
        int i9;
        int i10;
        g1.a.k(!this.E0);
        g gVar2 = this.G;
        if (gVar2.p()) {
            ByteBuffer byteBuffer = gVar2.f5359m;
            int i11 = this.f8742n0;
            int i12 = gVar2.f8703t;
            long j10 = gVar2.f5361o;
            boolean S = S(this.f5837t, gVar2.f8702s);
            boolean c9 = gVar2.c(4);
            d1.s sVar = this.L;
            sVar.getClass();
            gVar = gVar2;
            if (!g0(j5, j9, null, byteBuffer, i11, 0, i12, j10, S, c9, sVar)) {
                return false;
            }
            b0(gVar.f8702s);
            gVar.k();
        } else {
            gVar = gVar2;
        }
        if (this.D0) {
            this.E0 = true;
            return false;
        }
        ?? r22 = 0;
        boolean z8 = this.f8747s0;
        j1.e eVar = this.F;
        if (z8) {
            g1.a.k(gVar.o(eVar));
            this.f8747s0 = false;
        }
        if (this.f8748t0) {
            if (gVar.p()) {
                return true;
            }
            E();
            this.f8748t0 = false;
            T();
            if (!this.f8746r0) {
                return false;
            }
        }
        g1.a.k(!this.D0);
        a5.d dVar = this.f5828k;
        dVar.o0();
        eVar.k();
        while (true) {
            eVar.k();
            int w8 = w(dVar, eVar, r22);
            if (w8 == -5) {
                Y(dVar);
                break;
            }
            if (w8 != -4) {
                if (w8 != -3) {
                    androidx.fragment.app.a.l();
                    return false;
                }
            } else {
                if (eVar.c(4)) {
                    this.D0 = true;
                    break;
                }
                byte[] bArr = null;
                if (this.F0) {
                    d1.s sVar2 = this.K;
                    sVar2.getClass();
                    this.L = sVar2;
                    if (Objects.equals(sVar2.f2554m, "audio/opus") && !this.L.f2556o.isEmpty()) {
                        byte[] bArr2 = (byte[]) this.L.f2556o.get(r22);
                        int i13 = (bArr2[10] & 255) | ((bArr2[11] & 255) << 8);
                        d1.s sVar3 = this.L;
                        sVar3.getClass();
                        d1.r a9 = sVar3.a();
                        a9.B = i13;
                        this.L = new d1.s(a9);
                    }
                    Z(this.L, null);
                    this.F0 = r22;
                }
                eVar.n();
                d1.s sVar4 = this.L;
                if (sVar4 != null && Objects.equals(sVar4.f2554m, "audio/opus")) {
                    if (eVar.c(268435456)) {
                        eVar.f5357k = this.L;
                        Q(eVar);
                    }
                    if (this.f5837t - eVar.f5361o <= 80000) {
                        d1.s sVar5 = this.L;
                        sVar5.getClass();
                        List list = sVar5.f2556o;
                        t0 t0Var = this.J;
                        t0Var.getClass();
                        eVar.f5359m.getClass();
                        if (eVar.f5359m.limit() - eVar.f5359m.position() != 0) {
                            if (t0Var.f7362b == 2 && (list.size() == 1 || list.size() == 3)) {
                                bArr = (byte[]) list.get(r22);
                            }
                            ByteBuffer byteBuffer2 = eVar.f5359m;
                            int position = byteBuffer2.position();
                            int limit = byteBuffer2.limit();
                            int i14 = limit - position;
                            int i15 = (i14 + 255) / 255;
                            int i16 = i15 + 27 + i14;
                            if (t0Var.f7362b == 2) {
                                i9 = bArr != null ? bArr.length + 28 : 47;
                                i16 = i9 + 44 + i16;
                            } else {
                                i9 = 0;
                            }
                            int i17 = i16;
                            if (t0Var.f7361a.capacity() < i17) {
                                t0Var.f7361a = ByteBuffer.allocate(i17).order(ByteOrder.LITTLE_ENDIAN);
                            } else {
                                t0Var.f7361a.clear();
                            }
                            ByteBuffer byteBuffer3 = t0Var.f7361a;
                            if (t0Var.f7362b == 2) {
                                if (bArr != null) {
                                    t0.a(byteBuffer3, 0L, 0, 1, true);
                                    i10 = limit;
                                    long length = bArr.length;
                                    com.bumptech.glide.c.e(length, "out of range: %s", (length >> 8) == 0);
                                    byteBuffer3.put((byte) length);
                                    byteBuffer3.put(bArr);
                                    byteBuffer3.putInt(22, g1.w.k(byteBuffer3.arrayOffset(), bArr.length + 28, 0, byteBuffer3.array()));
                                    byteBuffer3.position(bArr.length + 28);
                                } else {
                                    i10 = limit;
                                    byteBuffer3.put(t0.f7359d);
                                }
                                byteBuffer3.put(t0.f7360e);
                            } else {
                                i10 = limit;
                            }
                            int j11 = t0Var.f7363c + ((int) ((d2.b.j(byteBuffer2.get(0), byteBuffer2.limit() > 1 ? byteBuffer2.get(1) : (byte) 0) * 48000) / 1000000));
                            t0Var.f7363c = j11;
                            t0.a(byteBuffer3, j11, t0Var.f7362b, i15, false);
                            for (int i18 = 0; i18 < i15; i18++) {
                                if (i14 >= 255) {
                                    byteBuffer3.put((byte) -1);
                                    i14 -= 255;
                                } else {
                                    byteBuffer3.put((byte) i14);
                                    i14 = 0;
                                }
                            }
                            int i19 = i10;
                            while (position < i19) {
                                byteBuffer3.put(byteBuffer2.get(position));
                                position++;
                            }
                            byteBuffer2.position(byteBuffer2.limit());
                            byteBuffer3.flip();
                            if (t0Var.f7362b == 2) {
                                byteBuffer3.putInt(i9 + 66, g1.w.k(byteBuffer3.arrayOffset() + i9 + 44, byteBuffer3.limit() - byteBuffer3.position(), 0, byteBuffer3.array()));
                            } else {
                                byteBuffer3.putInt(22, g1.w.k(byteBuffer3.arrayOffset(), byteBuffer3.limit() - byteBuffer3.position(), 0, byteBuffer3.array()));
                            }
                            t0Var.f7362b++;
                            t0Var.f7361a = byteBuffer3;
                            eVar.k();
                            eVar.m(t0Var.f7361a.remaining());
                            eVar.f5359m.put(t0Var.f7361a);
                            eVar.n();
                        }
                    }
                }
                if (gVar.p()) {
                    long j12 = this.f5837t;
                    if (S(j12, gVar.f8702s) != S(j12, eVar.f5361o)) {
                        break;
                    }
                }
                if (!gVar.o(eVar)) {
                    break;
                }
                r22 = 0;
            }
        }
        this.f8747s0 = true;
        if (gVar.p()) {
            gVar.n();
        }
        return gVar.p() || this.D0 || this.f8748t0;
    }

    public abstract l1.g C(n nVar, d1.s sVar, d1.s sVar2);

    public m D(IllegalStateException illegalStateException, n nVar) {
        return new m(illegalStateException, nVar);
    }

    public final void E() {
        this.f8748t0 = false;
        this.G.k();
        this.F.k();
        this.f8747s0 = false;
        this.f8746r0 = false;
        t0 t0Var = this.J;
        t0Var.getClass();
        t0Var.f7361a = e1.d.f3023a;
        t0Var.f7363c = 0;
        t0Var.f7362b = 2;
    }

    public final boolean F() {
        if (!this.f8753y0) {
            s0();
            return true;
        }
        this.f8751w0 = 1;
        if (this.f8732c0 || this.f8734e0) {
            this.f8752x0 = 3;
            return false;
        }
        this.f8752x0 = 2;
        return true;
    }

    public final boolean G(long j5, long j9) {
        MediaCodec.BufferInfo bufferInfo;
        boolean z8;
        boolean z9;
        boolean g02;
        int e9;
        k kVar = this.S;
        kVar.getClass();
        int i9 = this.f8742n0;
        MediaCodec.BufferInfo bufferInfo2 = this.H;
        if (i9 < 0) {
            if (this.f8735f0 && this.f8755z0) {
                try {
                    e9 = kVar.e(bufferInfo2);
                } catch (IllegalStateException unused) {
                    f0();
                    if (this.E0) {
                        i0();
                    }
                }
            } else {
                e9 = kVar.e(bufferInfo2);
            }
            if (e9 < 0) {
                if (e9 != -2) {
                    if (this.f8739k0 && (this.D0 || this.f8751w0 == 2)) {
                        f0();
                        return false;
                    }
                    return false;
                }
                this.A0 = true;
                k kVar2 = this.S;
                kVar2.getClass();
                MediaFormat outputFormat = kVar2.getOutputFormat();
                if (this.f8730a0 != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                    this.f8738j0 = true;
                    return true;
                }
                if (this.f8737h0) {
                    outputFormat.setInteger("channel-count", 1);
                }
                this.U = outputFormat;
                this.V = true;
                return true;
            }
            if (this.f8738j0) {
                this.f8738j0 = false;
                kVar.releaseOutputBuffer(e9, false);
                return true;
            }
            if (bufferInfo2.size == 0 && (bufferInfo2.flags & 4) != 0) {
                f0();
                return false;
            }
            this.f8742n0 = e9;
            ByteBuffer outputBuffer = kVar.getOutputBuffer(e9);
            this.f8743o0 = outputBuffer;
            if (outputBuffer != null) {
                outputBuffer.position(bufferInfo2.offset);
                this.f8743o0.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            if (this.f8736g0 && bufferInfo2.presentationTimeUs == 0 && (bufferInfo2.flags & 4) != 0 && this.B0 != -9223372036854775807L) {
                bufferInfo2.presentationTimeUs = this.C0;
            }
            long j10 = bufferInfo2.presentationTimeUs;
            this.f8744p0 = j10 < this.f5837t;
            long j11 = this.C0;
            this.f8745q0 = j11 != -9223372036854775807L && j11 <= j10;
            t0(j10);
        }
        if (this.f8735f0 && this.f8755z0) {
            try {
                ByteBuffer byteBuffer = this.f8743o0;
                int i10 = this.f8742n0;
                int i11 = bufferInfo2.flags;
                long j12 = bufferInfo2.presentationTimeUs;
                boolean z10 = this.f8744p0;
                boolean z11 = this.f8745q0;
                d1.s sVar = this.L;
                sVar.getClass();
                bufferInfo = bufferInfo2;
                z8 = false;
                z9 = true;
                try {
                    g02 = g0(j5, j9, kVar, byteBuffer, i10, i11, 1, j12, z10, z11, sVar);
                } catch (IllegalStateException unused2) {
                    f0();
                    if (!this.E0) {
                        return z8;
                    }
                    i0();
                    return z8;
                }
            } catch (IllegalStateException unused3) {
                z8 = false;
            }
        } else {
            bufferInfo = bufferInfo2;
            z8 = false;
            z9 = true;
            ByteBuffer byteBuffer2 = this.f8743o0;
            int i12 = this.f8742n0;
            int i13 = bufferInfo.flags;
            long j13 = bufferInfo.presentationTimeUs;
            boolean z12 = this.f8744p0;
            boolean z13 = this.f8745q0;
            d1.s sVar2 = this.L;
            sVar2.getClass();
            g02 = g0(j5, j9, kVar, byteBuffer2, i12, i13, 1, j13, z12, z13, sVar2);
        }
        if (!g02) {
            return z8;
        }
        b0(bufferInfo.presentationTimeUs);
        boolean z14 = (bufferInfo.flags & 4) != 0;
        this.f8742n0 = -1;
        this.f8743o0 = null;
        if (!z14) {
            return z9;
        }
        f0();
        return z8;
    }

    public final boolean H() {
        k kVar = this.S;
        if (kVar != null && this.f8751w0 != 2 && !this.D0) {
            int i9 = this.f8741m0;
            j1.e eVar = this.E;
            if (i9 < 0) {
                int s8 = kVar.s();
                this.f8741m0 = s8;
                if (s8 >= 0) {
                    eVar.f5359m = kVar.getInputBuffer(s8);
                    eVar.k();
                }
            }
            if (this.f8751w0 == 1) {
                if (!this.f8739k0) {
                    this.f8755z0 = true;
                    kVar.d(0L, this.f8741m0, 0, 4);
                    this.f8741m0 = -1;
                    eVar.f5359m = null;
                }
                this.f8751w0 = 2;
                return false;
            }
            if (this.i0) {
                this.i0 = false;
                ByteBuffer byteBuffer = eVar.f5359m;
                byteBuffer.getClass();
                byteBuffer.put(M0);
                kVar.d(0L, this.f8741m0, 38, 0);
                this.f8741m0 = -1;
                eVar.f5359m = null;
                this.f8753y0 = true;
                return true;
            }
            if (this.f8750v0 == 1) {
                int i10 = 0;
                while (true) {
                    d1.s sVar = this.T;
                    sVar.getClass();
                    if (i10 >= sVar.f2556o.size()) {
                        break;
                    }
                    byte[] bArr = (byte[]) this.T.f2556o.get(i10);
                    ByteBuffer byteBuffer2 = eVar.f5359m;
                    byteBuffer2.getClass();
                    byteBuffer2.put(bArr);
                    i10++;
                }
                this.f8750v0 = 2;
            }
            ByteBuffer byteBuffer3 = eVar.f5359m;
            byteBuffer3.getClass();
            int position = byteBuffer3.position();
            a5.d dVar = this.f5828k;
            dVar.o0();
            try {
                int w8 = w(dVar, eVar, 0);
                if (w8 == -3) {
                    if (m()) {
                        this.C0 = this.B0;
                        return false;
                    }
                } else {
                    if (w8 == -5) {
                        if (this.f8750v0 == 2) {
                            eVar.k();
                            this.f8750v0 = 1;
                        }
                        Y(dVar);
                        return true;
                    }
                    if (!eVar.c(4)) {
                        if (this.f8753y0 || eVar.c(1)) {
                            boolean c9 = eVar.c(1073741824);
                            if (c9) {
                                j1.a aVar = eVar.f5358l;
                                if (position == 0) {
                                    aVar.getClass();
                                } else {
                                    if (aVar.f5351d == null) {
                                        int[] iArr = new int[1];
                                        aVar.f5351d = iArr;
                                        aVar.f5355i.numBytesOfClearData = iArr;
                                    }
                                    int[] iArr2 = aVar.f5351d;
                                    iArr2[0] = iArr2[0] + position;
                                }
                            }
                            if (this.f8731b0 && !c9) {
                                ByteBuffer byteBuffer4 = eVar.f5359m;
                                byteBuffer4.getClass();
                                int position2 = byteBuffer4.position();
                                int i11 = 0;
                                int i12 = 0;
                                while (true) {
                                    int i13 = i11 + 1;
                                    if (i13 >= position2) {
                                        byteBuffer4.clear();
                                        break;
                                    }
                                    int i14 = byteBuffer4.get(i11) & 255;
                                    if (i12 == 3) {
                                        if (i14 == 1 && (byteBuffer4.get(i13) & 31) == 7) {
                                            ByteBuffer duplicate = byteBuffer4.duplicate();
                                            duplicate.position(i11 - 3);
                                            duplicate.limit(position2);
                                            byteBuffer4.position(0);
                                            byteBuffer4.put(duplicate);
                                            break;
                                        }
                                    } else if (i14 == 0) {
                                        i12++;
                                    }
                                    if (i14 != 0) {
                                        i12 = 0;
                                    }
                                    i11 = i13;
                                }
                                ByteBuffer byteBuffer5 = eVar.f5359m;
                                byteBuffer5.getClass();
                                if (byteBuffer5.position() != 0) {
                                    this.f8731b0 = false;
                                }
                            }
                            long j5 = eVar.f5361o;
                            if (this.F0) {
                                ArrayDeque arrayDeque = this.I;
                                if (arrayDeque.isEmpty()) {
                                    c2.f fVar = this.J0.f8729d;
                                    d1.s sVar2 = this.K;
                                    sVar2.getClass();
                                    fVar.a(j5, sVar2);
                                } else {
                                    c2.f fVar2 = ((r) arrayDeque.peekLast()).f8729d;
                                    d1.s sVar3 = this.K;
                                    sVar3.getClass();
                                    fVar2.a(j5, sVar3);
                                }
                                this.F0 = false;
                            }
                            this.B0 = Math.max(this.B0, j5);
                            if (m() || eVar.c(536870912)) {
                                this.C0 = this.B0;
                            }
                            eVar.n();
                            if (eVar.c(268435456)) {
                                Q(eVar);
                            }
                            d0(eVar);
                            int L = L(eVar);
                            int i15 = this.f8741m0;
                            try {
                                if (c9) {
                                    kVar.b(i15, eVar.f5358l, j5, L);
                                } else {
                                    ByteBuffer byteBuffer6 = eVar.f5359m;
                                    byteBuffer6.getClass();
                                    kVar.d(j5, i15, byteBuffer6.limit(), L);
                                }
                                this.f8741m0 = -1;
                                eVar.f5359m = null;
                                this.f8753y0 = true;
                                this.f8750v0 = 0;
                                this.I0.f5857c++;
                                return true;
                            } catch (MediaCodec.CryptoException e9) {
                                throw l(e9, this.K, false, g1.w.t(e9.getErrorCode()));
                            }
                        }
                        eVar.k();
                        if (this.f8750v0 == 2) {
                            this.f8750v0 = 1;
                            return true;
                        }
                        return true;
                    }
                    this.C0 = this.B0;
                    if (this.f8750v0 == 2) {
                        eVar.k();
                        this.f8750v0 = 1;
                    }
                    this.D0 = true;
                    if (!this.f8753y0) {
                        f0();
                        return false;
                    }
                    try {
                        if (!this.f8739k0) {
                            this.f8755z0 = true;
                            kVar.d(0L, this.f8741m0, 0, 4);
                            this.f8741m0 = -1;
                            eVar.f5359m = null;
                            return false;
                        }
                    } catch (MediaCodec.CryptoException e10) {
                        throw l(e10, this.K, false, g1.w.t(e10.getErrorCode()));
                    }
                }
            } catch (j1.d e11) {
                V(e11);
                h0(0);
                I();
                return true;
            }
        }
        return false;
    }

    public final void I() {
        try {
            k kVar = this.S;
            g1.a.l(kVar);
            kVar.flush();
        } finally {
            k0();
        }
    }

    public final boolean J() {
        if (this.S == null) {
            return false;
        }
        int i9 = this.f8752x0;
        if (i9 == 3 || this.f8732c0 || ((this.f8733d0 && !this.A0) || (this.f8734e0 && this.f8755z0))) {
            i0();
            return true;
        }
        if (i9 == 2) {
            int i10 = g1.w.f3713a;
            g1.a.k(i10 >= 23);
            if (i10 >= 23) {
                try {
                    s0();
                } catch (l1.l e9) {
                    g1.a.E("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e9);
                    i0();
                    return true;
                }
            }
        }
        I();
        return false;
    }

    public final List K(boolean z8) {
        d1.s sVar = this.K;
        sVar.getClass();
        t tVar = this.A;
        ArrayList O = O(tVar, sVar, z8);
        if (!O.isEmpty() || !z8) {
            return O;
        }
        ArrayList O2 = O(tVar, sVar, false);
        if (!O2.isEmpty()) {
            g1.a.D("MediaCodecRenderer", "Drm session requires secure decoder for " + sVar.f2554m + ", but no secure decoder available. Trying to proceed with " + O2 + ".");
        }
        return O2;
    }

    public int L(j1.e eVar) {
        return 0;
    }

    public boolean M() {
        return false;
    }

    public abstract float N(float f9, d1.s[] sVarArr);

    public abstract ArrayList O(t tVar, d1.s sVar, boolean z8);

    public abstract i P(n nVar, d1.s sVar, MediaCrypto mediaCrypto, float f9);

    public abstract void Q(j1.e eVar);

    /* JADX WARN: Code restructure failed: missing block: B:135:0x018d, code lost:
    
        if ("stvm8".equals(r3) == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x019d, code lost:
    
        if ("OMX.amlogic.avc.decoder.awesome.secure".equals(r6) == false) goto L91;
     */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0290  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R(s1.n r17, android.media.MediaCrypto r18) {
        /*
            Method dump skipped, instructions count: 689
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.s.R(s1.n, android.media.MediaCrypto):void");
    }

    public final boolean S(long j5, long j9) {
        if (j9 >= j5) {
            return false;
        }
        d1.s sVar = this.L;
        return sVar == null || !Objects.equals(sVar.f2554m, "audio/opus") || j5 - j9 > 80000;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006f, code lost:
    
        if (r0.A() != null) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T() {
        /*
            r4 = this;
            s1.k r0 = r4.S
            if (r0 != 0) goto L93
            boolean r0 = r4.f8746r0
            if (r0 != 0) goto L93
            d1.s r0 = r4.K
            if (r0 != 0) goto Le
            goto L93
        Le:
            i7.x r1 = r4.N
            r2 = 1
            if (r1 != 0) goto L4a
            boolean r0 = r4.p0(r0)
            if (r0 == 0) goto L4a
            d1.s r0 = r4.K
            r4.E()
            java.lang.String r0 = r0.f2554m
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r1 = r1.equals(r0)
            s1.g r3 = r4.G
            if (r1 != 0) goto L40
            java.lang.String r1 = "audio/mpeg"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L40
            java.lang.String r1 = "audio/opus"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L40
            r3.getClass()
            r3.f8704u = r2
            goto L47
        L40:
            r3.getClass()
            r0 = 32
            r3.f8704u = r0
        L47:
            r4.f8746r0 = r2
            return
        L4a:
            i7.x r0 = r4.N
            r4.m0(r0)
            i7.x r0 = r4.M
            r1 = 0
            if (r0 == 0) goto L71
            android.media.MediaCrypto r0 = r4.O
            if (r0 != 0) goto L59
            goto L5a
        L59:
            r2 = 0
        L5a:
            g1.a.k(r2)
            i7.x r0 = r4.M
            d1.s r2 = r4.K
            r2.getClass()
            java.lang.String r2 = r2.f2554m
            r0.z()
            boolean r2 = o1.h.f7574a
            o1.b r0 = r0.A()
            if (r0 == 0) goto L78
        L71:
            android.media.MediaCrypto r0 = r4.O     // Catch: s1.q -> L89
            boolean r2 = r4.P     // Catch: s1.q -> L89
            r4.U(r0, r2)     // Catch: s1.q -> L89
        L78:
            android.media.MediaCrypto r0 = r4.O
            if (r0 == 0) goto L93
            s1.k r2 = r4.S
            if (r2 != 0) goto L93
            r0.release()
            r0 = 0
            r4.O = r0
            r4.P = r1
            return
        L89:
            r0 = move-exception
            d1.s r2 = r4.K
            r3 = 4001(0xfa1, float:5.607E-42)
            l1.l r0 = r4.l(r0, r2, r1, r3)
            throw r0
        L93:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.s.T():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0103 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U(android.media.MediaCrypto r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.s.U(android.media.MediaCrypto, boolean):void");
    }

    public abstract void V(Exception exc);

    public abstract void W(long j5, long j9, String str);

    public abstract void X(String str);

    /* JADX WARN: Code restructure failed: missing block: B:41:0x007b, code lost:
    
        if (F() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ae, code lost:
    
        if (F() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c0, code lost:
    
        if (F() == false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public l1.g Y(a5.d r13) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.s.Y(a5.d):l1.g");
    }

    public abstract void Z(d1.s sVar, MediaFormat mediaFormat);

    @Override // l1.b1
    public boolean b() {
        boolean b9;
        if (this.K != null) {
            if (m()) {
                b9 = this.f5839v;
            } else {
                v0 v0Var = this.f5834q;
                v0Var.getClass();
                b9 = v0Var.b();
            }
            if (!b9) {
                if (!(this.f8742n0 >= 0)) {
                    if (this.f8740l0 != -9223372036854775807L) {
                        this.f5832o.getClass();
                        if (SystemClock.elapsedRealtime() < this.f8740l0) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public void b0(long j5) {
        this.K0 = j5;
        while (true) {
            ArrayDeque arrayDeque = this.I;
            if (arrayDeque.isEmpty() || j5 < ((r) arrayDeque.peek()).f8726a) {
                return;
            }
            r rVar = (r) arrayDeque.poll();
            rVar.getClass();
            n0(rVar);
            c0();
        }
    }

    public abstract void c0();

    /* JADX WARN: Removed duplicated region for block: B:42:0x0075 A[LOOP:1: B:33:0x0050->B:42:0x0075, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0076 A[EDGE_INSN: B:43:0x0076->B:44:? BREAK  A[LOOP:1: B:33:0x0050->B:42:0x0075], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0096 A[LOOP:2: B:45:0x0076->B:54:0x0096, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0097 A[EDGE_INSN: B:55:0x0097->B:56:0x0097 BREAK  A[LOOP:2: B:45:0x0076->B:54:0x0096], SYNTHETIC] */
    @Override // l1.b1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(long r12, long r14) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.s.f(long, long):void");
    }

    public final void f0() {
        int i9 = this.f8752x0;
        if (i9 == 1) {
            I();
            return;
        }
        if (i9 == 2) {
            I();
            s0();
        } else if (i9 != 3) {
            this.E0 = true;
            j0();
        } else {
            i0();
            T();
        }
    }

    public abstract boolean g0(long j5, long j9, k kVar, ByteBuffer byteBuffer, int i9, int i10, int i11, long j10, boolean z8, boolean z9, d1.s sVar);

    public final boolean h0(int i9) {
        a5.d dVar = this.f5828k;
        dVar.o0();
        j1.e eVar = this.D;
        eVar.k();
        int w8 = w(dVar, eVar, i9 | 4);
        if (w8 == -5) {
            Y(dVar);
            return true;
        }
        if (w8 != -4 || !eVar.c(4)) {
            return false;
        }
        this.D0 = true;
        f0();
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i0() {
        try {
            k kVar = this.S;
            if (kVar != null) {
                kVar.release();
                this.I0.f5856b++;
                n nVar = this.Z;
                nVar.getClass();
                X(nVar.f8714a);
            }
            this.S = null;
            try {
                MediaCrypto mediaCrypto = this.O;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.S = null;
            try {
                MediaCrypto mediaCrypto2 = this.O;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    @Override // l1.e, l1.b1
    public void k(float f9, float f10) {
        this.R = f10;
        r0(this.T);
    }

    public void k0() {
        this.f8741m0 = -1;
        this.E.f5359m = null;
        this.f8742n0 = -1;
        this.f8743o0 = null;
        this.f8740l0 = -9223372036854775807L;
        this.f8755z0 = false;
        this.f8753y0 = false;
        this.i0 = false;
        this.f8738j0 = false;
        this.f8744p0 = false;
        this.f8745q0 = false;
        this.B0 = -9223372036854775807L;
        this.C0 = -9223372036854775807L;
        this.K0 = -9223372036854775807L;
        this.f8751w0 = 0;
        this.f8752x0 = 0;
        this.f8750v0 = this.f8749u0 ? 1 : 0;
    }

    public final void l0() {
        k0();
        this.H0 = null;
        this.X = null;
        this.Z = null;
        this.T = null;
        this.U = null;
        this.V = false;
        this.A0 = false;
        this.W = -1.0f;
        this.f8730a0 = 0;
        this.f8731b0 = false;
        this.f8732c0 = false;
        this.f8733d0 = false;
        this.f8734e0 = false;
        this.f8735f0 = false;
        this.f8736g0 = false;
        this.f8737h0 = false;
        this.f8739k0 = false;
        this.f8749u0 = false;
        this.f8750v0 = 0;
        this.P = false;
    }

    public final void m0(i7.x xVar) {
        androidx.activity.g.z(this.M, xVar);
        this.M = xVar;
    }

    @Override // l1.e
    public void n() {
        this.K = null;
        n0(r.f8725e);
        this.I.clear();
        J();
    }

    public final void n0(r rVar) {
        this.J0 = rVar;
        if (rVar.f8728c != -9223372036854775807L) {
            this.L0 = true;
            a0();
        }
    }

    public boolean o0(n nVar) {
        return true;
    }

    public boolean p0(d1.s sVar) {
        return false;
    }

    @Override // l1.e
    public void q(long j5, boolean z8) {
        int i9;
        this.D0 = false;
        this.E0 = false;
        this.G0 = false;
        if (this.f8746r0) {
            this.G.k();
            this.F.k();
            this.f8747s0 = false;
            t0 t0Var = this.J;
            t0Var.getClass();
            t0Var.f7361a = e1.d.f3023a;
            t0Var.f7363c = 0;
            t0Var.f7362b = 2;
        } else if (J()) {
            T();
        }
        c2.f fVar = this.J0.f8729d;
        synchronized (fVar) {
            i9 = fVar.f1555b;
        }
        if (i9 > 0) {
            this.F0 = true;
        }
        this.J0.f8729d.b();
        this.I.clear();
    }

    public abstract int q0(t tVar, d1.s sVar);

    public final boolean r0(d1.s sVar) {
        if (g1.w.f3713a >= 23 && this.S != null && this.f8752x0 != 3 && this.f5833p != 0) {
            float f9 = this.R;
            sVar.getClass();
            d1.s[] sVarArr = this.f5835r;
            sVarArr.getClass();
            float N = N(f9, sVarArr);
            float f10 = this.W;
            if (f10 != N) {
                if (N == -1.0f) {
                    if (this.f8753y0) {
                        this.f8751w0 = 1;
                        this.f8752x0 = 3;
                        return false;
                    }
                    i0();
                    T();
                    return false;
                }
                if (f10 != -1.0f || N > this.C) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", N);
                    k kVar = this.S;
                    kVar.getClass();
                    kVar.setParameters(bundle);
                    this.W = N;
                }
            }
        }
        return true;
    }

    public final void s0() {
        i7.x xVar = this.N;
        xVar.getClass();
        xVar.z();
        m0(this.N);
        this.f8751w0 = 0;
        this.f8752x0 = 0;
    }

    public final void t0(long j5) {
        Object f9;
        d1.s sVar = (d1.s) this.J0.f8729d.e(j5);
        if (sVar == null && this.L0 && this.U != null) {
            c2.f fVar = this.J0.f8729d;
            synchronized (fVar) {
                f9 = fVar.f1555b == 0 ? null : fVar.f();
            }
            sVar = (d1.s) f9;
        }
        if (sVar != null) {
            this.L = sVar;
        } else if (!this.V || this.L == null) {
            return;
        }
        d1.s sVar2 = this.L;
        sVar2.getClass();
        Z(sVar2, this.U);
        this.V = false;
        this.L0 = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
    
        if (r4 >= r0) goto L14;
     */
    @Override // l1.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(d1.s[] r13, long r14, long r16) {
        /*
            r12 = this;
            s1.r r13 = r12.J0
            long r0 = r13.f8728c
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L1e
            s1.r r4 = new s1.r
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r14
            r9 = r16
            r4.<init>(r5, r7, r9)
            r12.n0(r4)
            return
        L1e:
            java.util.ArrayDeque r13 = r12.I
            boolean r0 = r13.isEmpty()
            if (r0 == 0) goto L52
            long r0 = r12.B0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L36
            long r4 = r12.K0
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L52
            int r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r6 < 0) goto L52
        L36:
            s1.r r5 = new s1.r
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.n0(r5)
            s1.r r13 = r12.J0
            long r0 = r13.f8728c
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L51
            r12.c0()
        L51:
            return
        L52:
            s1.r r5 = new s1.r
            long r6 = r12.B0
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r13.add(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.s.v(d1.s[], long, long):void");
    }

    @Override // l1.e
    public final int z(d1.s sVar) {
        try {
            return q0(this.A, sVar);
        } catch (w e9) {
            throw l(e9, sVar, false, 4002);
        }
    }

    public void a0() {
    }

    public void j0() {
    }

    public void d0(j1.e eVar) {
    }

    public void e0(d1.s sVar) {
    }
}
