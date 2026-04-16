package y1;

import b6.y;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g implements Comparable {

    /* renamed from: i, reason: collision with root package name */
    public final boolean f10429i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f10430j;

    public g(d1.s sVar, int i9) {
        this.f10429i = (sVar.f2547e & 1) != 0;
        this.f10430j = o.d(i9, false);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        g gVar = (g) obj;
        return y.f1469a.c(this.f10430j, gVar.f10430j).c(this.f10429i, gVar.f10429i).e();
    }
}
