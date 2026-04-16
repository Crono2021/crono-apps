package s1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q extends Exception {

    /* renamed from: i, reason: collision with root package name */
    public final String f8721i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f8722j;

    /* renamed from: k, reason: collision with root package name */
    public final n f8723k;

    /* renamed from: l, reason: collision with root package name */
    public final String f8724l;

    public q(d1.s sVar, w wVar, boolean z8, int i9) {
        this("Decoder init failed: [" + i9 + "], " + sVar, wVar, sVar.f2554m, z8, null, "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_" + (i9 < 0 ? "neg_" : "") + Math.abs(i9));
    }

    public q(String str, Throwable th, String str2, boolean z8, n nVar, String str3) {
        super(str, th);
        this.f8721i = str2;
        this.f8722j = z8;
        this.f8723k = nVar;
        this.f8724l = str3;
    }
}
