package i1;

import android.net.Uri;
import b6.b1;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p extends c {

    /* renamed from: m, reason: collision with root package name */
    public final boolean f4348m;

    /* renamed from: n, reason: collision with root package name */
    public final int f4349n;

    /* renamed from: o, reason: collision with root package name */
    public final int f4350o;

    /* renamed from: p, reason: collision with root package name */
    public final a5.d f4351p;

    /* renamed from: q, reason: collision with root package name */
    public final a5.d f4352q;

    /* renamed from: r, reason: collision with root package name */
    public HttpURLConnection f4353r;

    /* renamed from: s, reason: collision with root package name */
    public InputStream f4354s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4355t;

    /* renamed from: u, reason: collision with root package name */
    public int f4356u;

    /* renamed from: v, reason: collision with root package name */
    public long f4357v;

    /* renamed from: w, reason: collision with root package name */
    public long f4358w;

    public p(int i9, int i10, boolean z8, a5.d dVar) {
        super(true);
        this.f4349n = i9;
        this.f4350o = i10;
        this.f4348m = z8;
        this.f4351p = dVar;
        this.f4352q = new a5.d(19);
    }

    public static void w(HttpURLConnection httpURLConnection, long j5) {
        int i9;
        if (httpURLConnection == null || (i9 = g1.w.f3713a) < 19 || i9 > 20) {
            return;
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (j5 == -1) {
                if (inputStream.read() == -1) {
                    return;
                }
            } else if (j5 <= IjkMediaMeta.AV_CH_TOP_CENTER) {
                return;
            }
            String name = inputStream.getClass().getName();
            if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                Class<? super Object> superclass = inputStream.getClass().getSuperclass();
                superclass.getClass();
                Method declaredMethod = superclass.getDeclaredMethod("unexpectedEndOfInput", null);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, null);
            }
        } catch (Exception unused) {
        }
    }

    @Override // i1.h
    public final void close() {
        try {
            InputStream inputStream = this.f4354s;
            if (inputStream != null) {
                long j5 = this.f4357v;
                long j9 = -1;
                if (j5 != -1) {
                    j9 = j5 - this.f4358w;
                }
                w(this.f4353r, j9);
                try {
                    inputStream.close();
                } catch (IOException e9) {
                    int i9 = g1.w.f3713a;
                    throw new u(e9, 2000, 3);
                }
            }
        } finally {
            this.f4354s = null;
            s();
            if (this.f4355t) {
                this.f4355t = false;
                l();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x011d A[Catch: IOException -> 0x0128, TRY_LEAVE, TryCatch #1 {IOException -> 0x0128, blocks: (B:19:0x0115, B:21:0x011d), top: B:18:0x0115 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010b  */
    @Override // i1.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long f(i1.k r27) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.p.f(i1.k):long");
    }

    @Override // i1.c, i1.h
    public final Map g() {
        HttpURLConnection httpURLConnection = this.f4353r;
        return httpURLConnection == null ? b1.f1352o : new o(httpURLConnection.getHeaderFields());
    }

    @Override // i1.h
    public final Uri m() {
        HttpURLConnection httpURLConnection = this.f4353r;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // d1.k
    public final int read(byte[] bArr, int i9, int i10) {
        if (i10 == 0) {
            return 0;
        }
        try {
            long j5 = this.f4357v;
            if (j5 != -1) {
                long j9 = j5 - this.f4358w;
                if (j9 == 0) {
                    return -1;
                }
                i10 = (int) Math.min(i10, j9);
            }
            InputStream inputStream = this.f4354s;
            int i11 = g1.w.f3713a;
            int read = inputStream.read(bArr, i9, i10);
            if (read != -1) {
                this.f4358w += read;
                c(read);
                return read;
            }
            return -1;
        } catch (IOException e9) {
            int i12 = g1.w.f3713a;
            throw u.a(e9, 2);
        }
    }

    public final void s() {
        HttpURLConnection httpURLConnection = this.f4353r;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e9) {
                g1.a.q("DefaultHttpDataSource", "Unexpected error while disconnecting", e9);
            }
            this.f4353r = null;
        }
    }

    public final URL t(URL url, String str) {
        if (str == null) {
            throw new u("Null location redirect", 2001);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new u(t.a.b("Unsupported protocol redirect: ", protocol), 2001);
            }
            if (this.f4348m || protocol.equals(url.getProtocol())) {
                return url2;
            }
            throw new u("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", 2001);
        } catch (MalformedURLException e9) {
            throw new u(e9, 2001, 1);
        }
    }

    public final HttpURLConnection u(k kVar) {
        HttpURLConnection v8;
        URL url = new URL(kVar.f4324a.toString());
        int i9 = kVar.f4325b;
        byte[] bArr = kVar.f4326c;
        long j5 = kVar.f4328e;
        long j9 = kVar.f4329f;
        int i10 = 1;
        int i11 = 0;
        boolean z8 = (kVar.f4330g & 1) == 1;
        if (!this.f4348m) {
            return v(url, i9, bArr, j5, j9, z8, true, kVar.f4327d);
        }
        while (true) {
            int i12 = i11 + 1;
            if (i11 > 20) {
                throw new u(new NoRouteToHostException(androidx.activity.g.m(i12, "Too many redirects: ")), 2001, 1);
            }
            v8 = v(url, i9, bArr, j5, j9, z8, false, kVar.f4327d);
            int responseCode = v8.getResponseCode();
            String headerField = v8.getHeaderField("Location");
            if ((i9 == i10 || i9 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                v8.disconnect();
                url = t(url, headerField);
            } else {
                if (i9 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    break;
                }
                v8.disconnect();
                url = t(url, headerField);
                bArr = null;
                i9 = 1;
            }
            i11 = i12;
            i10 = 1;
        }
        return v8;
    }

    public final HttpURLConnection v(URL url, int i9, byte[] bArr, long j5, long j9, boolean z8, boolean z9, Map map) {
        String sb;
        String str;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f4349n);
        httpURLConnection.setReadTimeout(this.f4350o);
        HashMap hashMap = new HashMap();
        a5.d dVar = this.f4351p;
        if (dVar != null) {
            hashMap.putAll(dVar.L0());
        }
        hashMap.putAll(this.f4352q.L0());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        Pattern pattern = x.f4365a;
        if (j5 == 0 && j9 == -1) {
            sb = null;
        } else {
            StringBuilder c9 = t.a.c("bytes=", j5, "-");
            if (j9 != -1) {
                c9.append((j5 + j9) - 1);
            }
            sb = c9.toString();
        }
        if (sb != null) {
            httpURLConnection.setRequestProperty("Range", sb);
        }
        httpURLConnection.setRequestProperty("Accept-Encoding", z8 ? "gzip" : "identity");
        httpURLConnection.setInstanceFollowRedirects(z9);
        httpURLConnection.setDoOutput(bArr != null);
        int i10 = k.h;
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
        httpURLConnection.setRequestMethod(str);
        if (bArr == null) {
            httpURLConnection.connect();
            return httpURLConnection;
        }
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        httpURLConnection.connect();
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(bArr);
        outputStream.close();
        return httpURLConnection;
    }

    public final void x(long j5) {
        if (j5 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j5 > 0) {
            int min = (int) Math.min(j5, 4096);
            InputStream inputStream = this.f4354s;
            int i9 = g1.w.f3713a;
            int read = inputStream.read(bArr, 0, min);
            if (Thread.currentThread().isInterrupted()) {
                throw new u(new InterruptedIOException(), 2000, 1);
            }
            if (read == -1) {
                throw new u();
            }
            j5 -= read;
            c(read);
        }
    }
}
