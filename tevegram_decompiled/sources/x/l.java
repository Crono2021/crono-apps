package x;

import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public n f10008a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f10009b;

    public static long a(g gVar, long j5) {
        n nVar = gVar.f9998d;
        ArrayList arrayList = gVar.f10004k;
        if (nVar instanceof j) {
            return j5;
        }
        int size = arrayList.size();
        long j9 = j5;
        for (int i9 = 0; i9 < size; i9++) {
            e eVar = (e) arrayList.get(i9);
            if (eVar instanceof g) {
                g gVar2 = (g) eVar;
                if (gVar2.f9998d != nVar) {
                    j9 = Math.min(j9, a(gVar2, gVar2.f10000f + j5));
                }
            }
        }
        g gVar3 = nVar.f10019i;
        g gVar4 = nVar.h;
        if (gVar != gVar3) {
            return j9;
        }
        long j10 = j5 - nVar.j();
        return Math.min(Math.min(j9, a(gVar4, j10)), j10 - gVar4.f10000f);
    }

    public static long b(g gVar, long j5) {
        n nVar = gVar.f9998d;
        ArrayList arrayList = gVar.f10004k;
        if (nVar instanceof j) {
            return j5;
        }
        int size = arrayList.size();
        long j9 = j5;
        for (int i9 = 0; i9 < size; i9++) {
            e eVar = (e) arrayList.get(i9);
            if (eVar instanceof g) {
                g gVar2 = (g) eVar;
                if (gVar2.f9998d != nVar) {
                    j9 = Math.max(j9, b(gVar2, gVar2.f10000f + j5));
                }
            }
        }
        g gVar3 = nVar.h;
        g gVar4 = nVar.f10019i;
        if (gVar != gVar3) {
            return j9;
        }
        long j10 = nVar.j() + j5;
        return Math.max(Math.max(j9, b(gVar4, j10)), j10 - gVar4.f10000f);
    }
}
