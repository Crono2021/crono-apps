package y1;

import d1.z0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f extends m implements Comparable {

    /* renamed from: m, reason: collision with root package name */
    public final int f10427m;

    /* renamed from: n, reason: collision with root package name */
    public final int f10428n;

    public f(int i9, z0 z0Var, int i10, i iVar, int i11) {
        super(i9, z0Var, i10);
        int i12;
        this.f10427m = o.d(i11, iVar.f10443y) ? 1 : 0;
        d1.s sVar = this.f10458l;
        int i13 = sVar.f2559r;
        int i14 = -1;
        if (i13 != -1 && (i12 = sVar.f2560s) != -1) {
            i14 = i13 * i12;
        }
        this.f10428n = i14;
    }

    @Override // y1.m
    public final int a() {
        return this.f10427m;
    }

    @Override // y1.m
    public final /* bridge */ /* synthetic */ boolean b(m mVar) {
        return false;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Integer.compare(this.f10428n, ((f) obj).f10428n);
    }
}
