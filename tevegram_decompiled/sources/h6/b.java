package h6;

import android.os.Build;
import androidx.activity.g;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Objects;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import m6.u;
import s6.m;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final c8.b f4046c = new c8.b(1);

    /* renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f4047a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f4048b;

    public b(byte[] bArr) {
        if (!g.e(2)) {
            androidx.fragment.app.a.o("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
            throw null;
        }
        m.a(bArr.length);
        this.f4047a = new SecretKeySpec(bArr, "AES");
        this.f4048b = true;
    }

    public static AlgorithmParameterSpec a(byte[] bArr) {
        int length = bArr.length;
        if ("The Android Project".equals(System.getProperty("java.vendor"))) {
            int i9 = u.f6691a;
            Integer valueOf = !Objects.equals(System.getProperty("java.vendor"), "The Android Project") ? null : Integer.valueOf(Build.VERSION.SDK_INT);
            if ((valueOf != null ? valueOf.intValue() : -1) <= 19) {
                return new IvParameterSpec(bArr, 0, length);
            }
        }
        return new GCMParameterSpec(128, bArr, 0, length);
    }
}
