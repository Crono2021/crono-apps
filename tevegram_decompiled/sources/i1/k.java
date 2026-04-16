package i1;

import android.net.Uri;
import d1.f0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k {
    public static final /* synthetic */ int h = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Uri f4324a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4325b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f4326c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f4327d;

    /* renamed from: e, reason: collision with root package name */
    public final long f4328e;

    /* renamed from: f, reason: collision with root package name */
    public final long f4329f;

    /* renamed from: g, reason: collision with root package name */
    public final int f4330g;

    static {
        f0.a("media3.datasource");
    }

    public k(Uri uri, int i9, byte[] bArr, Map map, long j5, long j9, int i10) {
        g1.a.f(j5 >= 0);
        g1.a.f(j5 >= 0);
        g1.a.f(j9 > 0 || j9 == -1);
        this.f4324a = uri;
        this.f4325b = i9;
        this.f4326c = (bArr == null || bArr.length == 0) ? null : bArr;
        this.f4327d = Collections.unmodifiableMap(new HashMap(map));
        this.f4328e = j5;
        this.f4329f = j9;
        this.f4330g = i10;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("DataSpec[");
        int i9 = this.f4325b;
        if (i9 == 1) {
            str = "GET";
        } else if (i9 == 2) {
            str = "POST";
        } else {
            if (i9 != 3) {
                androidx.fragment.app.a.l();
                return null;
            }
            str = "HEAD";
        }
        sb.append(str);
        sb.append(" ");
        sb.append(this.f4324a);
        sb.append(", ");
        sb.append(this.f4328e);
        sb.append(", ");
        sb.append(this.f4329f);
        sb.append(", null, ");
        sb.append(this.f4330g);
        sb.append("]");
        return sb.toString();
    }
}
