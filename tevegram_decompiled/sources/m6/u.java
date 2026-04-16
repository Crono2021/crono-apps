package m6;

import java.nio.charset.Charset;
import java.security.SecureRandom;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f6691a = 0;

    static {
        Charset.forName("UTF-8");
    }

    public static int a() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        int i9 = 0;
        while (i9 == 0) {
            secureRandom.nextBytes(bArr);
            i9 = ((bArr[0] & Byte.MAX_VALUE) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return i9;
    }

    public static final t6.a b(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i9 = 0; i9 < str.length(); i9++) {
            char charAt = str.charAt(i9);
            if (charAt < '!' || charAt > '~') {
                throw new androidx.fragment.app.r("Not a printable ASCII character: " + charAt);
            }
            bArr[i9] = (byte) charAt;
        }
        return t6.a.a(bArr);
    }
}
