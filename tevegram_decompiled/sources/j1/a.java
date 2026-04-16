package j1;

import android.media.MediaCodec;
import g1.w;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f5348a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f5349b;

    /* renamed from: c, reason: collision with root package name */
    public int f5350c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f5351d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f5352e;

    /* renamed from: f, reason: collision with root package name */
    public int f5353f;

    /* renamed from: g, reason: collision with root package name */
    public int f5354g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public final MediaCodec.CryptoInfo f5355i;

    /* renamed from: j, reason: collision with root package name */
    public final a5.d f5356j;

    public a() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f5355i = cryptoInfo;
        this.f5356j = w.f3713a >= 24 ? new a5.d(cryptoInfo) : null;
    }
}
