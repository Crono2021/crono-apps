package d4;

import java.io.File;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements g, com.bumptech.glide.load.data.d {

    /* renamed from: i, reason: collision with root package name */
    public final List f2815i;

    /* renamed from: j, reason: collision with root package name */
    public final h f2816j;

    /* renamed from: k, reason: collision with root package name */
    public final f f2817k;

    /* renamed from: l, reason: collision with root package name */
    public int f2818l = -1;

    /* renamed from: m, reason: collision with root package name */
    public b4.f f2819m;

    /* renamed from: n, reason: collision with root package name */
    public List f2820n;

    /* renamed from: o, reason: collision with root package name */
    public int f2821o;

    /* renamed from: p, reason: collision with root package name */
    public volatile h4.p f2822p;

    /* renamed from: q, reason: collision with root package name */
    public File f2823q;

    public d(List list, h hVar, f fVar) {
        this.f2815i = list;
        this.f2816j = hVar;
        this.f2817k = fVar;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void K(Object obj) {
        this.f2817k.a(this.f2819m, obj, this.f2822p.f4002c, 3, this.f2819m);
    }

    @Override // d4.g
    public final boolean b() {
        while (true) {
            List list = this.f2820n;
            boolean z8 = false;
            if (list != null && this.f2821o < list.size()) {
                this.f2822p = null;
                while (!z8 && this.f2821o < this.f2820n.size()) {
                    List list2 = this.f2820n;
                    int i9 = this.f2821o;
                    this.f2821o = i9 + 1;
                    h4.q qVar = (h4.q) list2.get(i9);
                    File file = this.f2823q;
                    h hVar = this.f2816j;
                    this.f2822p = qVar.a(file, hVar.f2838e, hVar.f2839f, hVar.f2841i);
                    if (this.f2822p != null && this.f2816j.c(this.f2822p.f4002c.a()) != null) {
                        this.f2822p.f4002c.c(this.f2816j.f2847o, this);
                        z8 = true;
                    }
                }
                return z8;
            }
            int i10 = this.f2818l + 1;
            this.f2818l = i10;
            if (i10 >= this.f2815i.size()) {
                return false;
            }
            b4.f fVar = (b4.f) this.f2815i.get(this.f2818l);
            h hVar2 = this.f2816j;
            File r8 = hVar2.h.a().r(new e(fVar, hVar2.f2846n));
            this.f2823q = r8;
            if (r8 != null) {
                this.f2819m = fVar;
                this.f2820n = this.f2816j.f2836c.b().g(r8);
                this.f2821o = 0;
            }
        }
    }

    @Override // d4.g
    public final void cancel() {
        h4.p pVar = this.f2822p;
        if (pVar != null) {
            pVar.f4002c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void x(Exception exc) {
        this.f2817k.c(this.f2819m, exc, this.f2822p.f4002c, 3);
    }
}
