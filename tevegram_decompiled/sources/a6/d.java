package a6;

import android.os.Build;
import g1.p;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f207a;

    /* renamed from: b, reason: collision with root package name */
    public final String f208b;

    public d(Object obj, String str) {
        this.f207a = 4;
        this.f208b = str;
        if (Build.VERSION.SDK_INT >= 23) {
            q3.c.p(obj);
        }
    }

    public static d b(p pVar) {
        String str;
        pVar.G(2);
        int t8 = pVar.t();
        int i9 = t8 >> 1;
        int t9 = ((pVar.t() >> 3) & 31) | ((t8 & 1) << 5);
        if (i9 == 4 || i9 == 5 || i9 == 7) {
            str = "dvhe";
        } else if (i9 == 8) {
            str = "hev1";
        } else {
            if (i9 != 9) {
                return null;
            }
            str = "avc3";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".0");
        sb.append(i9);
        sb.append(t9 >= 10 ? "." : ".0");
        sb.append(t9);
        return new d(sb.toString(), 1);
    }

    public void a(StringBuilder sb, Iterator it) {
        try {
            if (it.hasNext()) {
                Object next = it.next();
                Objects.requireNonNull(next);
                sb.append(next instanceof CharSequence ? (CharSequence) next : next.toString());
                while (it.hasNext()) {
                    sb.append((CharSequence) this.f208b);
                    Object next2 = it.next();
                    Objects.requireNonNull(next2);
                    sb.append(next2 instanceof CharSequence ? (CharSequence) next2 : next2.toString());
                }
            }
        } catch (IOException e9) {
            m7.c.e(e9);
        }
    }

    public String toString() {
        switch (this.f207a) {
            case 3:
                return "<" + this.f208b + '>';
            case 4:
                StringBuilder sb = new StringBuilder("MasterKey{keyAlias=");
                String str = this.f208b;
                sb.append(str);
                sb.append(", isKeyStoreBacked=");
                boolean z8 = false;
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                        keyStore.load(null);
                        z8 = keyStore.containsAlias(str);
                    } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException unused) {
                    }
                }
                sb.append(z8);
                sb.append("}");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public d(String str) {
        this.f207a = 0;
        str.getClass();
        this.f208b = str;
    }

    public /* synthetic */ d(String str, int i9) {
        this.f207a = i9;
        this.f208b = str;
    }
}
