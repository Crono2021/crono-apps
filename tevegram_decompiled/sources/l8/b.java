package l8;

import a8.q;
import i7.l1;
import java.io.Serializable;
import n7.g;
import t7.h;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends h implements q {

    /* renamed from: m, reason: collision with root package name */
    public int f6338m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ a f6339n;

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object[] f6340o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ l1 f6341p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(l1 l1Var, r7.c cVar) {
        super(3, cVar);
        this.f6341p = l1Var;
    }

    @Override // a8.q
    public final Object c(Object obj, Object obj2, Serializable serializable) {
        b bVar = new b(this.f6341p, (r7.c) serializable);
        bVar.f6339n = (a) obj;
        bVar.f6340o = (Object[]) obj2;
        return bVar.k(g.f7490c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
    
        if (r0.a(r6, r5) == r3) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        if (r6 == r3) goto L15;
     */
    @Override // t7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.Object r6) {
        /*
            r5 = this;
            int r0 = r5.f6338m
            r1 = 2
            r2 = 1
            s7.a r3 = s7.a.f8891i
            if (r0 == 0) goto L1d
            if (r0 == r2) goto L17
            if (r0 != r1) goto L10
            com.bumptech.glide.c.V(r6)
            goto L42
        L10:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            m7.c.p(r6)
            r6 = 0
            return r6
        L17:
            l8.a r0 = r5.f6339n
            com.bumptech.glide.c.V(r6)
            goto L36
        L1d:
            com.bumptech.glide.c.V(r6)
            l8.a r0 = r5.f6339n
            java.lang.Object[] r6 = r5.f6340o
            r4 = 0
            r4 = r6[r4]
            r6 = r6[r2]
            r5.f6339n = r0
            r5.f6338m = r2
            i7.l1 r2 = r5.f6341p
            java.lang.Object r6 = r2.c(r4, r6, r5)
            if (r6 != r3) goto L36
            goto L41
        L36:
            r2 = 0
            r5.f6339n = r2
            r5.f6338m = r1
            java.lang.Object r6 = r0.a(r6, r5)
            if (r6 != r3) goto L42
        L41:
            return r3
        L42:
            n7.g r6 = n7.g.f7490c
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: l8.b.k(java.lang.Object):java.lang.Object");
    }
}
