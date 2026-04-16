package n6;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o implements f6.m {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f7477a = Logger.getLogger(o.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f7478b = {0};

    /* renamed from: c, reason: collision with root package name */
    public static final o f7479c = new o();

    @Override // f6.m
    public final Class a() {
        return f6.j.class;
    }

    @Override // f6.m
    public final Object b(androidx.fragment.app.g gVar) {
        Iterator it = ((ConcurrentMap) gVar.f728j).values().iterator();
        while (it.hasNext()) {
            for (f6.k kVar : (List) it.next()) {
                f6.b bVar = kVar.h;
                if (bVar instanceof m) {
                    m mVar = (m) bVar;
                    byte[] bArr = kVar.f3429c;
                    t6.a a9 = t6.a.a(bArr == null ? null : Arrays.copyOf(bArr, bArr.length));
                    if (!a9.equals(mVar.b())) {
                        StringBuilder sb = new StringBuilder("Mac Key with parameters ");
                        sb.append(mVar.c());
                        t6.a b9 = mVar.b();
                        sb.append(" has wrong output prefix (");
                        sb.append(b9);
                        sb.append(") instead of (");
                        sb.append(a9);
                        sb.append(")");
                        throw new GeneralSecurityException(sb.toString());
                    }
                }
            }
        }
        return new n(gVar);
    }

    @Override // f6.m
    public final Class c() {
        return f6.j.class;
    }
}
