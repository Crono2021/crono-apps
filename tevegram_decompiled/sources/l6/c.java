package l6;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import javax.crypto.KeyGenerator;
import s6.l;
import s6.m;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f6269b = new Object();

    /* renamed from: a, reason: collision with root package name */
    public KeyStore f6270a;

    public c() {
        if (Build.VERSION.SDK_INT < 23) {
            m7.c.p("need Android Keystore on Android M or newer");
            throw null;
        }
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            this.f6270a = keyStore;
        } catch (IOException | GeneralSecurityException e9) {
            throw new IllegalStateException(e9);
        }
    }

    public static boolean a(String str) {
        c cVar = new c();
        synchronized (f6269b) {
            try {
                if (cVar.d(str)) {
                    return false;
                }
                b(str);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(String str) {
        KeyGenParameterSpec.Builder keySize;
        KeyGenParameterSpec.Builder blockModes;
        KeyGenParameterSpec.Builder encryptionPaddings;
        KeyGenParameterSpec build;
        String b9 = m.b(str);
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keySize = a5.c.k(b9).setKeySize(256);
        blockModes = keySize.setBlockModes("GCM");
        encryptionPaddings = blockModes.setEncryptionPaddings("NoPadding");
        build = encryptionPaddings.build();
        keyGenerator.init(build);
        keyGenerator.generateKey();
    }

    public final synchronized b c(String str) {
        b bVar;
        bVar = new b(m.b(str), this.f6270a);
        byte[] a9 = l.a(10);
        byte[] bArr = new byte[0];
        if (!Arrays.equals(a9, bVar.b(bVar.a(a9, bArr), bArr))) {
            throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
        }
        return bVar;
    }

    public final synchronized boolean d(String str) {
        String b9;
        b9 = m.b(str);
        try {
        } catch (NullPointerException unused) {
            Log.w("c", "Keystore is temporarily unavailable, wait, reinitialize Keystore and try again.");
            try {
                try {
                    Thread.sleep((int) (Math.random() * 40.0d));
                } catch (InterruptedException unused2) {
                }
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.f6270a = keyStore;
                keyStore.load(null);
                return this.f6270a.containsAlias(b9);
            } catch (IOException e9) {
                throw new GeneralSecurityException(e9);
            }
        }
        return this.f6270a.containsAlias(b9);
    }
}
