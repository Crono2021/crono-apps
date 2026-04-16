package i1;

import android.net.Uri;
import android.util.Base64;
import d1.m0;
import java.net.URLDecoder;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f extends c {

    /* renamed from: m, reason: collision with root package name */
    public k f4314m;

    /* renamed from: n, reason: collision with root package name */
    public byte[] f4315n;

    /* renamed from: o, reason: collision with root package name */
    public int f4316o;

    /* renamed from: p, reason: collision with root package name */
    public int f4317p;

    @Override // i1.h
    public final void close() {
        if (this.f4315n != null) {
            this.f4315n = null;
            l();
        }
        this.f4314m = null;
    }

    @Override // i1.h
    public final long f(k kVar) {
        q();
        this.f4314m = kVar;
        Uri uri = kVar.f4324a;
        long j5 = kVar.f4329f;
        Uri normalizeScheme = uri.normalizeScheme();
        String scheme = normalizeScheme.getScheme();
        g1.a.e("Unsupported scheme: " + scheme, "data".equals(scheme));
        String schemeSpecificPart = normalizeScheme.getSchemeSpecificPart();
        int i9 = g1.w.f3713a;
        String[] split = schemeSpecificPart.split(",", -1);
        if (split.length != 2) {
            throw new m0("Unexpected URI format: " + normalizeScheme, null, true, 0);
        }
        String str = split[1];
        if (split[0].contains(";base64")) {
            try {
                this.f4315n = Base64.decode(str, 0);
            } catch (IllegalArgumentException e9) {
                throw new m0(t.a.b("Error while parsing Base64 encoded string: ", str), e9, true, 0);
            }
        } else {
            this.f4315n = URLDecoder.decode(str, a6.b.f201a.name()).getBytes(a6.b.f203c);
        }
        long j9 = kVar.f4328e;
        byte[] bArr = this.f4315n;
        if (j9 > bArr.length) {
            this.f4315n = null;
            throw new i(2008);
        }
        int i10 = (int) j9;
        this.f4316o = i10;
        int length = bArr.length - i10;
        this.f4317p = length;
        if (j5 != -1) {
            this.f4317p = (int) Math.min(length, j5);
        }
        r(kVar);
        return j5 != -1 ? j5 : this.f4317p;
    }

    @Override // i1.h
    public final Uri m() {
        k kVar = this.f4314m;
        if (kVar != null) {
            return kVar.f4324a;
        }
        return null;
    }

    @Override // d1.k
    public final int read(byte[] bArr, int i9, int i10) {
        if (i10 == 0) {
            return 0;
        }
        int i11 = this.f4317p;
        if (i11 == 0) {
            return -1;
        }
        int min = Math.min(i10, i11);
        byte[] bArr2 = this.f4315n;
        int i12 = g1.w.f3713a;
        System.arraycopy(bArr2, this.f4316o, bArr, i9, min);
        this.f4316o += min;
        this.f4317p -= min;
        c(min);
        return min;
    }
}
