package h4;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u implements com.bumptech.glide.load.data.e, com.bumptech.glide.load.data.d {

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f4006i;

    /* renamed from: j, reason: collision with root package name */
    public final m0.c f4007j;

    /* renamed from: k, reason: collision with root package name */
    public int f4008k;

    /* renamed from: l, reason: collision with root package name */
    public com.bumptech.glide.g f4009l;

    /* renamed from: m, reason: collision with root package name */
    public com.bumptech.glide.load.data.d f4010m;

    /* renamed from: n, reason: collision with root package name */
    public List f4011n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f4012o;

    public u(ArrayList arrayList, m0.c cVar) {
        this.f4007j = cVar;
        if (arrayList.isEmpty()) {
            m7.c.n("Must not be empty.");
            throw null;
        }
        this.f4006i = arrayList;
        this.f4008k = 0;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void K(Object obj) {
        if (obj != null) {
            this.f4010m.K(obj);
        } else {
            d();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        return ((com.bumptech.glide.load.data.e) this.f4006i.get(0)).a();
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        List list = this.f4011n;
        if (list != null) {
            this.f4007j.a(list);
        }
        this.f4011n = null;
        ArrayList arrayList = this.f4006i;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            ((com.bumptech.glide.load.data.e) obj).b();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void c(com.bumptech.glide.g gVar, com.bumptech.glide.load.data.d dVar) {
        this.f4009l = gVar;
        this.f4010m = dVar;
        this.f4011n = (List) this.f4007j.b();
        ((com.bumptech.glide.load.data.e) this.f4006i.get(this.f4008k)).c(gVar, this);
        if (this.f4012o) {
            cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        this.f4012o = true;
        ArrayList arrayList = this.f4006i;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            ((com.bumptech.glide.load.data.e) obj).cancel();
        }
    }

    public final void d() {
        if (this.f4012o) {
            return;
        }
        if (this.f4008k < this.f4006i.size() - 1) {
            this.f4008k++;
            c(this.f4009l, this.f4010m);
        } else {
            w4.f.b(this.f4011n);
            this.f4010m.x(new d4.w("Fetch failed", new ArrayList(this.f4011n)));
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final int getDataSource() {
        return ((com.bumptech.glide.load.data.e) this.f4006i.get(0)).getDataSource();
    }

    @Override // com.bumptech.glide.load.data.d
    public final void x(Exception exc) {
        List list = this.f4011n;
        w4.f.c(list, "Argument must not be null");
        list.add(exc);
        d();
    }
}
