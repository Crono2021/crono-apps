package c8;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Random;
import javax.crypto.Cipher;
import s6.i;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends ThreadLocal {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1725a;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f1725a) {
            case 0:
                return new Random();
            case 1:
                try {
                    return (Cipher) i.f8884b.f8886a.a("AES/GCM/NoPadding");
                } catch (GeneralSecurityException e9) {
                    throw new IllegalStateException(e9);
                }
            case 2:
                try {
                    return (Cipher) i.f8884b.f8886a.a("AES/GCM-SIV/NoPadding");
                } catch (GeneralSecurityException e10) {
                    throw new IllegalStateException(e10);
                }
            case 3:
                try {
                    return (Cipher) i.f8884b.f8886a.a("AES/CTR/NoPadding");
                } catch (GeneralSecurityException e11) {
                    throw new IllegalStateException(e11);
                }
            case 4:
                try {
                    return (Cipher) i.f8884b.f8886a.a("AES/ECB/NOPADDING");
                } catch (GeneralSecurityException e12) {
                    throw new IllegalStateException(e12);
                }
            case 5:
                try {
                    return (Cipher) i.f8884b.f8886a.a("AES/CTR/NOPADDING");
                } catch (GeneralSecurityException e13) {
                    throw new IllegalStateException(e13);
                }
            default:
                SecureRandom secureRandom = new SecureRandom();
                secureRandom.nextLong();
                return secureRandom;
        }
    }
}
