package p1;

import android.net.Uri;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements i1.h {

    /* renamed from: i, reason: collision with root package name */
    public final i1.h f8093i;

    /* renamed from: j, reason: collision with root package name */
    public final byte[] f8094j;

    /* renamed from: k, reason: collision with root package name */
    public final byte[] f8095k;

    /* renamed from: l, reason: collision with root package name */
    public CipherInputStream f8096l;

    public a(i1.h hVar, byte[] bArr, byte[] bArr2) {
        this.f8093i = hVar;
        this.f8094j = bArr;
        this.f8095k = bArr2;
    }

    @Override // i1.h
    public final void close() {
        if (this.f8096l != null) {
            this.f8096l = null;
            this.f8093i.close();
        }
    }

    @Override // i1.h
    public final long f(i1.k kVar) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                cipher.init(2, new SecretKeySpec(this.f8094j, "AES"), new IvParameterSpec(this.f8095k));
                i1.j jVar = new i1.j(this.f8093i, kVar);
                this.f8096l = new CipherInputStream(jVar, cipher);
                jVar.a();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e9) {
                throw new RuntimeException(e9);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // i1.h
    public final Map g() {
        return this.f8093i.g();
    }

    @Override // i1.h
    public final void k(z1.f fVar) {
        fVar.getClass();
        this.f8093i.k(fVar);
    }

    @Override // i1.h
    public final Uri m() {
        return this.f8093i.m();
    }

    @Override // d1.k
    public final int read(byte[] bArr, int i9, int i10) {
        this.f8096l.getClass();
        int read = this.f8096l.read(bArr, i9, i10);
        if (read < 0) {
            return -1;
        }
        return read;
    }
}
