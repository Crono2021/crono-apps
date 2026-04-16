package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import com.bumptech.glide.manager.s;
import d4.n;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends ContextWrapper {

    /* renamed from: k, reason: collision with root package name */
    public static final a f1757k;

    /* renamed from: a, reason: collision with root package name */
    public final e4.f f1758a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a f1759b;

    /* renamed from: c, reason: collision with root package name */
    public final o4.d f1760c;

    /* renamed from: d, reason: collision with root package name */
    public final u5.e f1761d;

    /* renamed from: e, reason: collision with root package name */
    public final List f1762e;

    /* renamed from: f, reason: collision with root package name */
    public final s.d f1763f;

    /* renamed from: g, reason: collision with root package name */
    public final n f1764g;
    public final a0.b h;

    /* renamed from: i, reason: collision with root package name */
    public final int f1765i;

    /* renamed from: j, reason: collision with root package name */
    public s4.e f1766j;

    static {
        a aVar = new a();
        aVar.f1728i = u4.b.f9064a;
        f1757k = aVar;
    }

    public e(Context context, e4.f fVar, s sVar, o4.d dVar, u5.e eVar, s.d dVar2, List list, n nVar, a0.b bVar) {
        super(context.getApplicationContext());
        this.f1758a = fVar;
        this.f1760c = dVar;
        this.f1761d = eVar;
        this.f1762e = list;
        this.f1763f = dVar2;
        this.f1764g = nVar;
        this.h = bVar;
        this.f1765i = 4;
        this.f1759b = new c.a(sVar);
    }

    public final synchronized s4.e a() {
        try {
            if (this.f1766j == null) {
                this.f1761d.getClass();
                s4.e eVar = new s4.e();
                eVar.f8815v = true;
                this.f1766j = eVar;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f1766j;
    }

    public final i b() {
        return (i) this.f1759b.get();
    }
}
