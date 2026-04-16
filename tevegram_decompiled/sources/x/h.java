package x;

import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class h extends g {

    /* renamed from: m, reason: collision with root package name */
    public int f10006m;

    public h(n nVar) {
        super(nVar);
        if (nVar instanceof k) {
            this.f9999e = 2;
        } else {
            this.f9999e = 3;
        }
    }

    @Override // x.g
    public final void d(int i9) {
        if (this.f10003j) {
            return;
        }
        this.f10003j = true;
        this.f10001g = i9;
        ArrayList arrayList = this.f10004k;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            e eVar = (e) obj;
            eVar.a(eVar);
        }
    }
}
