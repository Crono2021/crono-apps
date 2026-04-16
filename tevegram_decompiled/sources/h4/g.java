package h4;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g implements b4.f {

    /* renamed from: b, reason: collision with root package name */
    public final h f3981b;

    /* renamed from: c, reason: collision with root package name */
    public final URL f3982c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3983d;

    /* renamed from: e, reason: collision with root package name */
    public String f3984e;

    /* renamed from: f, reason: collision with root package name */
    public URL f3985f;

    /* renamed from: g, reason: collision with root package name */
    public volatile byte[] f3986g;
    public int h;

    public g(String str) {
        k kVar = h.f3987a;
        this.f3982c = null;
        if (TextUtils.isEmpty(str)) {
            m7.c.n("Must not be null or empty");
            throw null;
        }
        this.f3983d = str;
        w4.f.c(kVar, "Argument must not be null");
        this.f3981b = kVar;
    }

    @Override // b4.f
    public final void b(MessageDigest messageDigest) {
        if (this.f3986g == null) {
            this.f3986g = c().getBytes(b4.f.f1325a);
        }
        messageDigest.update(this.f3986g);
    }

    public final String c() {
        String str = this.f3983d;
        if (str != null) {
            return str;
        }
        URL url = this.f3982c;
        w4.f.c(url, "Argument must not be null");
        return url.toString();
    }

    public final URL d() {
        if (this.f3985f == null) {
            if (TextUtils.isEmpty(this.f3984e)) {
                String str = this.f3983d;
                if (TextUtils.isEmpty(str)) {
                    URL url = this.f3982c;
                    w4.f.c(url, "Argument must not be null");
                    str = url.toString();
                }
                this.f3984e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
            }
            this.f3985f = new URL(this.f3984e);
        }
        return this.f3985f;
    }

    @Override // b4.f
    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (c().equals(gVar.c()) && this.f3981b.equals(gVar.f3981b)) {
                return true;
            }
        }
        return false;
    }

    @Override // b4.f
    public final int hashCode() {
        if (this.h == 0) {
            int hashCode = c().hashCode();
            this.h = hashCode;
            this.h = this.f3981b.hashCode() + (hashCode * 31);
        }
        return this.h;
    }

    public final String toString() {
        return c();
    }

    public g(URL url) {
        k kVar = h.f3987a;
        w4.f.c(url, "Argument must not be null");
        this.f3982c = url;
        this.f3983d = null;
        w4.f.c(kVar, "Argument must not be null");
        this.f3981b = kVar;
    }
}
