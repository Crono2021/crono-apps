package o7;

import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends c implements RandomAccess {

    /* renamed from: i, reason: collision with root package name */
    public final c f8002i;

    /* renamed from: j, reason: collision with root package name */
    public final int f8003j;

    /* renamed from: k, reason: collision with root package name */
    public final int f8004k;

    public b(c cVar, int i9, int i10) {
        this.f8002i = cVar;
        this.f8003j = i9;
        com.bumptech.glide.d.g(i9, i10, cVar.f());
        this.f8004k = i10 - i9;
    }

    @Override // o7.c
    public final int f() {
        return this.f8004k;
    }

    @Override // java.util.List
    public final Object get(int i9) {
        int i10 = this.f8004k;
        if (i9 < 0 || i9 >= i10) {
            m7.c.h(", size: ", "index: ", i9, i10);
            return null;
        }
        return this.f8002i.get(this.f8003j + i9);
    }

    @Override // o7.c, java.util.List
    public final List subList(int i9, int i10) {
        com.bumptech.glide.d.g(i9, i10, this.f8004k);
        int i11 = this.f8003j;
        return new b(this.f8002i, i9 + i11, i11 + i10);
    }
}
