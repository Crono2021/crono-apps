package m6;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final d4.t f6682a = new d4.t(25);

    public static void a(androidx.fragment.app.g gVar) {
        f6.f fVar;
        ArrayList arrayList = new ArrayList();
        p6.a aVar = p6.a.f8254b;
        Iterator it = ((ConcurrentMap) gVar.f728j).values().iterator();
        while (it.hasNext()) {
            for (f6.k kVar : (List) it.next()) {
                int ordinal = kVar.f3430d.ordinal();
                if (ordinal == 1) {
                    fVar = f6.f.f3419c;
                } else if (ordinal == 2) {
                    fVar = f6.f.f3420d;
                } else {
                    if (ordinal != 3) {
                        m7.c.p("Unknown key status");
                        return;
                    }
                    fVar = f6.f.f3421e;
                }
                int i9 = kVar.f3432f;
                String str = kVar.f3433g;
                if (str.startsWith("type.googleapis.com/google.crypto.")) {
                    str = str.substring(34);
                }
                arrayList.add(new p6.b(fVar, i9, str, kVar.f3431e.name()));
            }
        }
        f6.k kVar2 = (f6.k) gVar.f729k;
        Integer valueOf = kVar2 != null ? Integer.valueOf(kVar2.f3432f) : null;
        if (valueOf != null) {
            try {
                int intValue = valueOf.intValue();
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    if (((p6.b) obj).f8257b == intValue) {
                    }
                }
                throw new GeneralSecurityException("primary key ID is not present in entries");
            } catch (GeneralSecurityException e9) {
                throw new IllegalStateException(e9);
            }
        }
        Collections.unmodifiableList(arrayList);
    }
}
