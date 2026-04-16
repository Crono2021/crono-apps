package i8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class s extends r7.a implements r7.e {

    /* renamed from: j, reason: collision with root package name */
    public static final r f5301j = new r(r7.d.f8614i, q.f5297j);

    public s() {
        super(r7.d.f8614i);
    }

    public abstract void c(r7.g gVar, Runnable runnable);

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        if (((r7.e) r3.f5299i.a(r2)) != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        return r7.h.f8615i;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
    
        if (r7.d.f8614i == r3) goto L15;
     */
    /* JADX WARN: Type inference failed for: r3v3, types: [a8.l, b8.j] */
    @Override // r7.a, r7.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final r7.g e(r7.f r3) {
        /*
            r2 = this;
            r3.getClass()
            boolean r0 = r3 instanceof i8.r
            if (r0 == 0) goto L1e
            i8.r r3 = (i8.r) r3
            r7.f r0 = r2.f8611i
            if (r0 == r3) goto L13
            r7.f r1 = r3.f5300j
            if (r1 != r0) goto L12
            goto L13
        L12:
            return r2
        L13:
            b8.j r3 = r3.f5299i
            java.lang.Object r3 = r3.a(r2)
            r7.e r3 = (r7.e) r3
            if (r3 == 0) goto L25
            goto L22
        L1e:
            r7.d r0 = r7.d.f8614i
            if (r0 != r3) goto L25
        L22:
            r7.h r3 = r7.h.f8615i
            return r3
        L25:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: i8.s.e(r7.f):r7.g");
    }

    public void f(r7.g gVar, Runnable runnable) {
        c(gVar, runnable);
    }

    public boolean g() {
        return !(this instanceof g1);
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [a8.l, b8.j] */
    @Override // r7.a, r7.g
    public final r7.e h(r7.f fVar) {
        r7.e eVar;
        fVar.getClass();
        if (!(fVar instanceof r)) {
            if (r7.d.f8614i == fVar) {
                return this;
            }
            return null;
        }
        r rVar = (r) fVar;
        r7.f fVar2 = this.f8611i;
        if ((fVar2 == rVar || rVar.f5300j == fVar2) && (eVar = (r7.e) rVar.f5299i.a(this)) != null) {
            return eVar;
        }
        return null;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + w.f(this);
    }
}
