package i1;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l implements h {

    /* renamed from: i, reason: collision with root package name */
    public final Context f4331i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f4332j;

    /* renamed from: k, reason: collision with root package name */
    public final h f4333k;

    /* renamed from: l, reason: collision with root package name */
    public s f4334l;

    /* renamed from: m, reason: collision with root package name */
    public b f4335m;

    /* renamed from: n, reason: collision with root package name */
    public e f4336n;

    /* renamed from: o, reason: collision with root package name */
    public h f4337o;

    /* renamed from: p, reason: collision with root package name */
    public c0 f4338p;

    /* renamed from: q, reason: collision with root package name */
    public f f4339q;

    /* renamed from: r, reason: collision with root package name */
    public z f4340r;

    /* renamed from: s, reason: collision with root package name */
    public h f4341s;

    public l(Context context, h hVar) {
        this.f4331i = context.getApplicationContext();
        hVar.getClass();
        this.f4333k = hVar;
        this.f4332j = new ArrayList();
    }

    public static void l(h hVar, z1.f fVar) {
        if (hVar != null) {
            hVar.k(fVar);
        }
    }

    public final void c(h hVar) {
        int i9 = 0;
        while (true) {
            ArrayList arrayList = this.f4332j;
            if (i9 >= arrayList.size()) {
                return;
            }
            hVar.k((z1.f) arrayList.get(i9));
            i9++;
        }
    }

    @Override // i1.h
    public final void close() {
        h hVar = this.f4341s;
        if (hVar != null) {
            try {
                hVar.close();
            } finally {
                this.f4341s = null;
            }
        }
    }

    @Override // i1.h
    public final long f(k kVar) {
        g1.a.k(this.f4341s == null);
        Uri uri = kVar.f4324a;
        String scheme = uri.getScheme();
        int i9 = g1.w.f3713a;
        String scheme2 = uri.getScheme();
        boolean isEmpty = TextUtils.isEmpty(scheme2);
        Context context = this.f4331i;
        if (isEmpty || "file".equals(scheme2)) {
            String path = uri.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.f4334l == null) {
                    s sVar = new s(false);
                    this.f4334l = sVar;
                    c(sVar);
                }
                this.f4341s = this.f4334l;
            } else {
                if (this.f4335m == null) {
                    b bVar = new b(context);
                    this.f4335m = bVar;
                    c(bVar);
                }
                this.f4341s = this.f4335m;
            }
        } else if ("asset".equals(scheme)) {
            if (this.f4335m == null) {
                b bVar2 = new b(context);
                this.f4335m = bVar2;
                c(bVar2);
            }
            this.f4341s = this.f4335m;
        } else if ("content".equals(scheme)) {
            if (this.f4336n == null) {
                e eVar = new e(context);
                this.f4336n = eVar;
                c(eVar);
            }
            this.f4341s = this.f4336n;
        } else {
            boolean equals = "rtmp".equals(scheme);
            h hVar = this.f4333k;
            if (equals) {
                if (this.f4337o == null) {
                    try {
                        h hVar2 = (h) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(null).newInstance(null);
                        this.f4337o = hVar2;
                        c(hVar2);
                    } catch (ClassNotFoundException unused) {
                        g1.a.D("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                    } catch (Exception e9) {
                        m7.c.k("Error instantiating RTMP extension", e9);
                        return 0L;
                    }
                    if (this.f4337o == null) {
                        this.f4337o = hVar;
                    }
                }
                this.f4341s = this.f4337o;
            } else if ("udp".equals(scheme)) {
                if (this.f4338p == null) {
                    c0 c0Var = new c0();
                    this.f4338p = c0Var;
                    c(c0Var);
                }
                this.f4341s = this.f4338p;
            } else if ("data".equals(scheme)) {
                if (this.f4339q == null) {
                    f fVar = new f(false);
                    this.f4339q = fVar;
                    c(fVar);
                }
                this.f4341s = this.f4339q;
            } else if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
                if (this.f4340r == null) {
                    z zVar = new z(context);
                    this.f4340r = zVar;
                    c(zVar);
                }
                this.f4341s = this.f4340r;
            } else {
                this.f4341s = hVar;
            }
        }
        return this.f4341s.f(kVar);
    }

    @Override // i1.h
    public final Map g() {
        h hVar = this.f4341s;
        return hVar == null ? Collections.EMPTY_MAP : hVar.g();
    }

    @Override // i1.h
    public final void k(z1.f fVar) {
        fVar.getClass();
        this.f4333k.k(fVar);
        this.f4332j.add(fVar);
        l(this.f4334l, fVar);
        l(this.f4335m, fVar);
        l(this.f4336n, fVar);
        l(this.f4337o, fVar);
        l(this.f4338p, fVar);
        l(this.f4339q, fVar);
        l(this.f4340r, fVar);
    }

    @Override // i1.h
    public final Uri m() {
        h hVar = this.f4341s;
        if (hVar == null) {
            return null;
        }
        return hVar.m();
    }

    @Override // d1.k
    public final int read(byte[] bArr, int i9, int i10) {
        h hVar = this.f4341s;
        hVar.getClass();
        return hVar.read(bArr, i9, i10);
    }
}
