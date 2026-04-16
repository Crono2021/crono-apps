package com.bumptech.glide.load.data;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l implements e {

    /* renamed from: i, reason: collision with root package name */
    public final h4.g f1807i;

    /* renamed from: j, reason: collision with root package name */
    public final int f1808j;

    /* renamed from: k, reason: collision with root package name */
    public HttpURLConnection f1809k;

    /* renamed from: l, reason: collision with root package name */
    public InputStream f1810l;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f1811m;

    public l(h4.g gVar, int i9) {
        this.f1807i = gVar;
        this.f1808j = i9;
    }

    public static int d(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e9) {
            if (!Log.isLoggable("HttpUrlFetcher", 3)) {
                return -1;
            }
            Log.d("HttpUrlFetcher", "Failed to get a response code", e9);
            return -1;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        InputStream inputStream = this.f1810l;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f1809k;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f1809k = null;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void c(com.bumptech.glide.g gVar, d dVar) {
        h4.g gVar2 = this.f1807i;
        int i9 = w4.h.f9940b;
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            try {
                dVar.K(e(gVar2.d(), 0, null, gVar2.f3981b.a()));
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + w4.h.a(elapsedRealtimeNanos));
                }
            } catch (IOException e9) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e9);
                }
                dVar.x(e9);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + w4.h.a(elapsedRealtimeNanos));
                }
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + w4.h.a(elapsedRealtimeNanos));
            }
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        this.f1811m = true;
    }

    public final InputStream e(URL url, int i9, URL url2, Map map) {
        if (i9 >= 5) {
            throw new b4.c(-1, null, "Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new b4.c(-1, null, "In re-direct loop");
                }
            } catch (URISyntaxException unused) {
            }
        }
        int i10 = this.f1808j;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnection.setConnectTimeout(i10);
            httpURLConnection.setReadTimeout(i10);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setInstanceFollowRedirects(false);
            this.f1809k = httpURLConnection;
            try {
                httpURLConnection.connect();
                this.f1810l = this.f1809k.getInputStream();
                if (this.f1811m) {
                    return null;
                }
                int d9 = d(this.f1809k);
                int i11 = d9 / 100;
                if (i11 == 2) {
                    HttpURLConnection httpURLConnection2 = this.f1809k;
                    try {
                        if (TextUtils.isEmpty(httpURLConnection2.getContentEncoding())) {
                            this.f1810l = new w4.d(httpURLConnection2.getInputStream(), httpURLConnection2.getContentLength());
                        } else {
                            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection2.getContentEncoding());
                            }
                            this.f1810l = httpURLConnection2.getInputStream();
                        }
                        return this.f1810l;
                    } catch (IOException e9) {
                        throw new b4.c(d(httpURLConnection2), e9, "Failed to obtain InputStream");
                    }
                }
                if (i11 != 3) {
                    if (d9 == -1) {
                        throw new b4.c(d9, null, "Http request failed");
                    }
                    try {
                        throw new b4.c(d9, null, this.f1809k.getResponseMessage());
                    } catch (IOException e10) {
                        throw new b4.c(d9, e10, "Failed to get a response message");
                    }
                }
                String headerField = this.f1809k.getHeaderField("Location");
                if (TextUtils.isEmpty(headerField)) {
                    throw new b4.c(d9, null, "Received empty or null redirect url");
                }
                try {
                    URL url3 = new URL(url, headerField);
                    b();
                    return e(url3, i9 + 1, url, map);
                } catch (MalformedURLException e11) {
                    throw new b4.c(d9, e11, t.a.b("Bad redirect url: ", headerField));
                }
            } catch (IOException e12) {
                throw new b4.c(d(this.f1809k), e12, "Failed to connect or obtain data");
            }
        } catch (IOException e13) {
            throw new b4.c(0, e13, "URL.openConnection threw");
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final int getDataSource() {
        return 2;
    }
}
