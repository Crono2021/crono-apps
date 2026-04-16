package androidx.emoji2.text;

import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f extends com.bumptech.glide.c {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ g f613p;

    public f(g gVar) {
        this.f613p = gVar;
    }

    @Override // com.bumptech.glide.c
    public final void L(Throwable th) {
        this.f613p.f614a.d(th);
    }

    @Override // com.bumptech.glide.c
    public final void M(a0.l lVar) {
        g gVar = this.f613p;
        gVar.f616c = lVar;
        gVar.f615b = new a5.d(gVar.f616c, new u5.e(3), gVar.f614a.h);
        l lVar2 = gVar.f614a;
        ArrayList arrayList = new ArrayList();
        lVar2.f625a.writeLock().lock();
        try {
            lVar2.f627c = 1;
            arrayList.addAll(lVar2.f626b);
            lVar2.f626b.clear();
            lVar2.f625a.writeLock().unlock();
            lVar2.f628d.post(new j(arrayList, lVar2.f627c, (Throwable) null));
        } catch (Throwable th) {
            lVar2.f625a.writeLock().unlock();
            throw th;
        }
    }
}
