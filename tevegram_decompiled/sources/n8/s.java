package n8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class s extends i8.a implements t7.d {

    /* renamed from: l, reason: collision with root package name */
    public final r7.c f7531l;

    public s(r7.g gVar, r7.c cVar) {
        super(gVar, true);
        this.f7531l = cVar;
    }

    @Override // i8.y0
    public final boolean C() {
        return true;
    }

    @Override // t7.d
    public final t7.d b() {
        r7.c cVar = this.f7531l;
        if (cVar instanceof t7.d) {
            return (t7.d) cVar;
        }
        return null;
    }

    @Override // i8.y0
    public void j(Object obj) {
        a.g(i8.w.k(obj), com.bumptech.glide.c.C(this.f7531l));
    }

    @Override // i8.y0
    public void k(Object obj) {
        this.f7531l.g(i8.w.k(obj));
    }
}
