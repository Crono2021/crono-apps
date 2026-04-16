package k0;

import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5511a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5512b;

    public /* synthetic */ d(Object obj, int i9) {
        this.f5511a = i9;
        this.f5512b = obj;
    }

    public final void a(Object obj) {
        switch (this.f5511a) {
            case 0:
                e eVar = (e) obj;
                if (eVar == null) {
                    eVar = new e(-3);
                }
                ((a5.d) this.f5512b).Q0(eVar);
                return;
            default:
                e eVar2 = (e) obj;
                synchronized (f.f5517c) {
                    try {
                        s.h hVar = f.f5518d;
                        ArrayList arrayList = (ArrayList) hVar.getOrDefault((String) this.f5512b, null);
                        if (arrayList == null) {
                            return;
                        }
                        hVar.remove((String) this.f5512b);
                        for (int i9 = 0; i9 < arrayList.size(); i9++) {
                            ((d) arrayList.get(i9)).a(eVar2);
                        }
                        return;
                    } finally {
                    }
                }
        }
    }
}
