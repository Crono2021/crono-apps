package q3;

import android.security.keystore.KeyGenParameterSpec;
import b6.i0;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.ProviderException;
import java.util.Arrays;
import javax.crypto.KeyGenerator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class d {
    public static a6.d a(i0 i0Var) {
        int i9 = i0Var.f1398j;
        if (i9 == 0 && ((KeyGenParameterSpec) i0Var.f1400l) == null) {
            m7.c.n("build() called before setKeyGenParameterSpec or setKeyScheme.");
            return null;
        }
        if (i9 == 1) {
            i0Var.f1400l = new KeyGenParameterSpec.Builder((String) i0Var.f1399k, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build();
        }
        KeyGenParameterSpec keyGenParameterSpec = (KeyGenParameterSpec) i0Var.f1400l;
        if (keyGenParameterSpec == null) {
            m7.c.o("KeyGenParameterSpec was null after build() check");
            return null;
        }
        Object obj = e.f8473a;
        if (keyGenParameterSpec.getKeySize() != 256) {
            throw new IllegalArgumentException("invalid key size, want 256 bits got " + keyGenParameterSpec.getKeySize() + " bits");
        }
        if (!Arrays.equals(keyGenParameterSpec.getBlockModes(), new String[]{"GCM"})) {
            androidx.fragment.app.a.g(Arrays.toString(keyGenParameterSpec.getBlockModes()), "invalid block mode, want GCM got ");
            return null;
        }
        if (keyGenParameterSpec.getPurposes() != 3) {
            androidx.fragment.app.a.d(keyGenParameterSpec.getPurposes(), "invalid purposes mode, want PURPOSE_ENCRYPT | PURPOSE_DECRYPT got ");
            return null;
        }
        if (!Arrays.equals(keyGenParameterSpec.getEncryptionPaddings(), new String[]{"NoPadding"})) {
            androidx.fragment.app.a.g(Arrays.toString(keyGenParameterSpec.getEncryptionPaddings()), "invalid padding mode, want NoPadding got ");
            return null;
        }
        if (keyGenParameterSpec.isUserAuthenticationRequired() && keyGenParameterSpec.getUserAuthenticationValidityDurationSeconds() < 1) {
            m7.c.n("per-operation authentication is not supported (UserAuthenticationValidityDurationSeconds must be >0)");
            return null;
        }
        synchronized (e.f8473a) {
            String keystoreAlias = keyGenParameterSpec.getKeystoreAlias();
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (!keyStore.containsAlias(keystoreAlias)) {
                try {
                    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                    keyGenerator.init(keyGenParameterSpec);
                    keyGenerator.generateKey();
                } catch (ProviderException e9) {
                    throw new GeneralSecurityException(e9.getMessage(), e9);
                }
            }
        }
        return new a6.d((KeyGenParameterSpec) i0Var.f1400l, keyGenParameterSpec.getKeystoreAlias());
    }

    public static String b(KeyGenParameterSpec keyGenParameterSpec) {
        return keyGenParameterSpec.getKeystoreAlias();
    }
}
