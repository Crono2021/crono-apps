package androidx.emoji2.text;

import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n extends com.bumptech.glide.c {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ com.bumptech.glide.c f636p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f637q;

    public n(com.bumptech.glide.c cVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f636p = cVar;
        this.f637q = threadPoolExecutor;
    }

    @Override // com.bumptech.glide.c
    public final void L(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f637q;
        try {
            this.f636p.L(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // com.bumptech.glide.c
    public final void M(a0.l lVar) {
        ThreadPoolExecutor threadPoolExecutor = this.f637q;
        try {
            this.f636p.M(lVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
