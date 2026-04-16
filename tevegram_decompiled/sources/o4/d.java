package o4;

import android.graphics.Path;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.util.Log;
import b4.l;
import d2.n;
import d2.y;
import d4.a0;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Signature;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import q1.o;
import q1.p;
import s1.k;
import s1.x;
import v1.v0;
import z1.q;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements l, p, x, s1.j, v0, w1.b, x2.g, x4.a {

    /* renamed from: j, reason: collision with root package name */
    public static d f7900j;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7901i;

    public /* synthetic */ d(int i9) {
        this.f7901i = i9;
    }

    public static MediaCodec t(s1.i iVar) {
        String str = iVar.f8708a.f8714a;
        g1.a.b("createCodec:" + str);
        MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
        g1.a.r();
        return createByCodecName;
    }

    public static Path v(float f9, float f10, float f11, float f12) {
        Path path = new Path();
        path.moveTo(f9, f10);
        path.lineTo(f11, f12);
        return path;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0045, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0082, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0075, code lost:
    
        if (r11 != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00a2, code lost:
    
        if (r10 != (-1)) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean w(x0.b r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.d.w(x0.b, android.text.Editable, int, int, boolean):boolean");
    }

    @Override // b4.l
    public int L(b4.i iVar) {
        return 1;
    }

    @Override // w1.b
    public long a() {
        throw new NoSuchElementException();
    }

    @Override // v1.v0
    public boolean b() {
        return true;
    }

    @Override // s1.x
    public MediaCodecInfo c(int i9) {
        return MediaCodecList.getCodecInfoAt(i9);
    }

    @Override // q1.p
    public q d(q1.l lVar, q1.i iVar) {
        return new o(lVar, iVar);
    }

    @Override // x2.g
    public y e() {
        return new d2.p(-9223372036854775807L);
    }

    @Override // x2.g
    public long f(n nVar) {
        return -1L;
    }

    @Override // s1.x
    public boolean g(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }

    @Override // x4.a
    public Object h() {
        return new ArrayList();
    }

    @Override // s1.x
    public int i() {
        return MediaCodecList.getCodecCount();
    }

    @Override // s1.j
    public k j(s1.i iVar) {
        MediaCodec mediaCodec = null;
        try {
            mediaCodec = t(iVar);
            g1.a.b("configureCodec");
            mediaCodec.configure(iVar.f8709b, iVar.f8711d, iVar.f8712e, 0);
            g1.a.r();
            g1.a.b("startCodec");
            mediaCodec.start();
            g1.a.r();
            return new androidx.fragment.app.g(mediaCodec);
        } catch (IOException | RuntimeException e9) {
            if (mediaCodec != null) {
                mediaCodec.release();
            }
            throw e9;
        }
    }

    @Override // w1.b
    public long k() {
        throw new NoSuchElementException();
    }

    @Override // q1.p
    public q l() {
        return new o(q1.l.f8384l, null);
    }

    @Override // s1.x
    public boolean m(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "secure-playback".equals(str) && "video/avc".equals(str2);
    }

    @Override // w1.b
    public boolean next() {
        return false;
    }

    @Override // v1.v0
    public int o(long j5) {
        return 0;
    }

    @Override // s1.x
    public boolean q() {
        return false;
    }

    @Override // v1.v0
    public int r(a5.d dVar, j1.e eVar, int i9) {
        eVar.f3748j = 4;
        return -4;
    }

    @Override // b4.b
    public boolean s(Object obj, File file, b4.i iVar) {
        try {
            w4.b.d(((h) ((c) ((a0) obj).get()).f7890i.f7889b).f7912a.f154d.asReadOnlyBuffer(), file);
            return true;
        } catch (IOException e9) {
            if (!Log.isLoggable("GifEncoder", 5)) {
                return false;
            }
            Log.w("GifEncoder", "Failed to encode GIF drawable data", e9);
            return false;
        }
    }

    public Object u(String str, Provider provider) {
        switch (this.f7901i) {
            case 5:
                return provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
            case 6:
                return provider == null ? KeyAgreement.getInstance(str) : KeyAgreement.getInstance(str, provider);
            case 7:
                return provider == null ? KeyFactory.getInstance(str) : KeyFactory.getInstance(str, provider);
            case 8:
                return provider == null ? KeyPairGenerator.getInstance(str) : KeyPairGenerator.getInstance(str, provider);
            case 9:
                return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
            case 10:
                return provider == null ? MessageDigest.getInstance(str) : MessageDigest.getInstance(str, provider);
            default:
                return provider == null ? Signature.getInstance(str) : Signature.getInstance(str, provider);
        }
    }

    @Override // v1.v0
    public void n() {
    }

    private final void x(Object obj) {
    }

    @Override // x2.g
    public void p(long j5) {
    }
}
