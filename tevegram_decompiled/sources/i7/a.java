package i7;

import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class a implements a8.p {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4749i;

    public /* synthetic */ a(int i9) {
        this.f4749i = i9;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        r7.b bVar;
        switch (this.f4749i) {
            case 0:
                ((Boolean) obj2).booleanValue();
                ((TdApi.Chat) obj).getClass();
                return n7.g.f7490c;
            case 1:
                String str = (String) obj;
                r7.e eVar = (r7.e) obj2;
                str.getClass();
                eVar.getClass();
                if (str.length() == 0) {
                    return eVar.toString();
                }
                return str + ", " + eVar;
            default:
                r7.g gVar = (r7.g) obj;
                r7.e eVar2 = (r7.e) obj2;
                gVar.getClass();
                eVar2.getClass();
                r7.g e9 = gVar.e(eVar2.getKey());
                r7.h hVar = r7.h.f8615i;
                if (e9 == hVar) {
                    return eVar2;
                }
                r7.d dVar = r7.d.f8614i;
                i8.s sVar = (i8.s) e9.h(dVar);
                if (sVar == null) {
                    bVar = new r7.b(e9, eVar2);
                } else {
                    r7.g e10 = e9.e(dVar);
                    if (e10 == hVar) {
                        return new r7.b(eVar2, sVar);
                    }
                    bVar = new r7.b(new r7.b(e10, eVar2), sVar);
                }
                return bVar;
        }
    }
}
