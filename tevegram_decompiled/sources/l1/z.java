package l1;

import android.media.MediaFormat;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class z implements b2.t, c2.a, x0 {

    /* renamed from: i, reason: collision with root package name */
    public b2.t f6074i;

    /* renamed from: j, reason: collision with root package name */
    public c2.a f6075j;

    /* renamed from: k, reason: collision with root package name */
    public b2.t f6076k;

    /* renamed from: l, reason: collision with root package name */
    public c2.a f6077l;

    @Override // c2.a
    public final void c(long j5, float[] fArr) {
        c2.a aVar = this.f6077l;
        if (aVar != null) {
            aVar.c(j5, fArr);
        }
        c2.a aVar2 = this.f6075j;
        if (aVar2 != null) {
            aVar2.c(j5, fArr);
        }
    }

    @Override // b2.t
    public final void d(long j5, long j9, d1.s sVar, MediaFormat mediaFormat) {
        long j10;
        long j11;
        d1.s sVar2;
        MediaFormat mediaFormat2;
        b2.t tVar = this.f6076k;
        if (tVar != null) {
            tVar.d(j5, j9, sVar, mediaFormat);
            mediaFormat2 = mediaFormat;
            sVar2 = sVar;
            j11 = j9;
            j10 = j5;
        } else {
            j10 = j5;
            j11 = j9;
            sVar2 = sVar;
            mediaFormat2 = mediaFormat;
        }
        b2.t tVar2 = this.f6074i;
        if (tVar2 != null) {
            tVar2.d(j10, j11, sVar2, mediaFormat2);
        }
    }

    @Override // c2.a
    public final void e() {
        c2.a aVar = this.f6077l;
        if (aVar != null) {
            aVar.e();
        }
        c2.a aVar2 = this.f6075j;
        if (aVar2 != null) {
            aVar2.e();
        }
    }

    @Override // l1.x0
    public final void g(int i9, Object obj) {
        if (i9 == 7) {
            this.f6074i = (b2.t) obj;
            return;
        }
        if (i9 == 8) {
            this.f6075j = (c2.a) obj;
            return;
        }
        if (i9 != 10000) {
            return;
        }
        c2.l lVar = (c2.l) obj;
        if (lVar == null) {
            this.f6076k = null;
            this.f6077l = null;
        } else {
            this.f6076k = lVar.getVideoFrameMetadataListener();
            this.f6077l = lVar.getCameraMotionListener();
        }
    }
}
