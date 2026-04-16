package g8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o7.p;

/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class d extends e {
    public static List Z(b bVar) {
        Iterator it = bVar.iterator();
        if (!it.hasNext()) {
            return p.f8013i;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return android.support.v4.media.session.b.b0(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
