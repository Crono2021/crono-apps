package i1;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a0 implements h {

    /* renamed from: i, reason: collision with root package name */
    public final h f4287i;

    /* renamed from: j, reason: collision with root package name */
    public long f4288j;

    /* renamed from: k, reason: collision with root package name */
    public Uri f4289k;

    public a0(h hVar) {
        hVar.getClass();
        this.f4287i = hVar;
        this.f4289k = Uri.EMPTY;
        Map map = Collections.EMPTY_MAP;
    }

    @Override // i1.h
    public final void close() {
        this.f4287i.close();
    }

    @Override // i1.h
    public final long f(k kVar) {
        this.f4289k = kVar.f4324a;
        Map map = Collections.EMPTY_MAP;
        h hVar = this.f4287i;
        long f9 = hVar.f(kVar);
        Uri m9 = hVar.m();
        m9.getClass();
        this.f4289k = m9;
        hVar.g();
        return f9;
    }

    @Override // i1.h
    public final Map g() {
        return this.f4287i.g();
    }

    @Override // i1.h
    public final void k(z1.f fVar) {
        fVar.getClass();
        this.f4287i.k(fVar);
    }

    @Override // i1.h
    public final Uri m() {
        return this.f4287i.m();
    }

    @Override // d1.k
    public final int read(byte[] bArr, int i9, int i10) {
        int read = this.f4287i.read(bArr, i9, i10);
        if (read != -1) {
            this.f4288j += read;
        }
        return read;
    }
}
