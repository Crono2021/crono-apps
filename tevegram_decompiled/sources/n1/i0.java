package n1;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public final d1.s f7261a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7262b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7263c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7264d;

    /* renamed from: e, reason: collision with root package name */
    public final int f7265e;

    /* renamed from: f, reason: collision with root package name */
    public final int f7266f;

    /* renamed from: g, reason: collision with root package name */
    public final int f7267g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final e1.a f7268i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f7269j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f7270k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f7271l;

    public i0(d1.s sVar, int i9, int i10, int i11, int i12, int i13, int i14, int i15, e1.a aVar, boolean z8, boolean z9, boolean z10) {
        this.f7261a = sVar;
        this.f7262b = i9;
        this.f7263c = i10;
        this.f7264d = i11;
        this.f7265e = i12;
        this.f7266f = i13;
        this.f7267g = i14;
        this.h = i15;
        this.f7268i = aVar;
        this.f7269j = z8;
        this.f7270k = z9;
        this.f7271l = z10;
    }

    public static AudioAttributes c(d1.g gVar, boolean z8) {
        return z8 ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : (AudioAttributes) gVar.a().f8j;
    }

    public final AudioTrack a(d1.g gVar, int i9) {
        int i10 = this.f7263c;
        try {
            AudioTrack b9 = b(gVar, i9);
            int state = b9.getState();
            if (state == 1) {
                return b9;
            }
            try {
                b9.release();
            } catch (Exception unused) {
            }
            throw new t(state, this.f7265e, this.f7266f, this.h, this.f7261a, i10 == 1, null);
        } catch (IllegalArgumentException | UnsupportedOperationException e9) {
            throw new t(0, this.f7265e, this.f7266f, this.h, this.f7261a, i10 == 1, e9);
        }
    }

    public final AudioTrack b(d1.g gVar, int i9) {
        AudioTrack.Builder audioAttributes;
        AudioTrack.Builder audioFormat;
        AudioTrack.Builder transferMode;
        AudioTrack.Builder bufferSizeInBytes;
        AudioTrack.Builder sessionId;
        AudioTrack.Builder offloadedPlayback;
        AudioTrack build;
        int i10 = g1.w.f3713a;
        boolean z8 = this.f7271l;
        int i11 = this.f7267g;
        int i12 = this.f7266f;
        int i13 = this.f7265e;
        if (i10 < 29) {
            if (i10 >= 21) {
                return new AudioTrack(c(gVar, z8), g1.w.o(i13, i12, i11), this.h, 1, i9);
            }
            gVar.getClass();
            if (i9 == 0) {
                return new AudioTrack(3, this.f7265e, this.f7266f, this.f7267g, this.h, 1);
            }
            return new AudioTrack(3, this.f7265e, this.f7266f, this.f7267g, this.h, 1, i9);
        }
        AudioFormat o8 = g1.w.o(i13, i12, i11);
        audioAttributes = f.c().setAudioAttributes(c(gVar, z8));
        audioFormat = audioAttributes.setAudioFormat(o8);
        transferMode = audioFormat.setTransferMode(1);
        bufferSizeInBytes = transferMode.setBufferSizeInBytes(this.h);
        sessionId = bufferSizeInBytes.setSessionId(i9);
        offloadedPlayback = sessionId.setOffloadedPlayback(this.f7263c == 1);
        build = offloadedPlayback.build();
        return build;
    }
}
