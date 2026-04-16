package q3;

import android.security.keystore.KeyGenParameterSpec;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f8473a;

    static {
        KeyGenParameterSpec.Builder blockModes;
        KeyGenParameterSpec.Builder encryptionPaddings;
        KeyGenParameterSpec.Builder keySize;
        blockModes = c.c().setBlockModes("GCM");
        encryptionPaddings = blockModes.setEncryptionPaddings("NoPadding");
        keySize = encryptionPaddings.setKeySize(256);
        keySize.build();
        f8473a = new Object();
    }
}
