package z1;

import android.net.Uri;
import g1.w;
import i1.a0;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r implements m {

    /* renamed from: a, reason: collision with root package name */
    public final long f10590a;

    /* renamed from: b, reason: collision with root package name */
    public final i1.k f10591b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10592c;

    /* renamed from: d, reason: collision with root package name */
    public final a0 f10593d;

    /* renamed from: e, reason: collision with root package name */
    public final q f10594e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f10595f;

    public r(i1.h hVar, Uri uri, q qVar) {
        Map map = Collections.EMPTY_MAP;
        g1.a.m(uri, "The uri must be set.");
        i1.k kVar = new i1.k(uri, 1, null, map, 0L, -1L, 1);
        this.f10593d = new a0(hVar);
        this.f10591b = kVar;
        this.f10592c = 4;
        this.f10594e = qVar;
        this.f10590a = v1.q.f9378b.getAndIncrement();
    }

    @Override // z1.m
    public final void a() {
        this.f10593d.f4288j = 0L;
        i1.j jVar = new i1.j(this.f10593d, this.f10591b);
        try {
            jVar.a();
            Uri m9 = this.f10593d.f4287i.m();
            m9.getClass();
            this.f10595f = this.f10594e.a(m9, jVar);
            try {
                jVar.close();
            } catch (IOException unused) {
            }
        } finally {
            int i9 = w.f3713a;
            try {
                jVar.close();
            } catch (IOException unused2) {
            }
        }
    }

    @Override // z1.m
    public final void b() {
    }
}
