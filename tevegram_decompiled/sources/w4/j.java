package w4;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f9943a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b, reason: collision with root package name */
    public final long f9944b;

    /* renamed from: c, reason: collision with root package name */
    public long f9945c;

    public j(long j5) {
        this.f9944b = j5;
    }

    public final synchronized Object a(Object obj) {
        i iVar;
        iVar = (i) this.f9943a.get(obj);
        return iVar != null ? iVar.f9941a : null;
    }

    public int b(Object obj) {
        return 1;
    }

    public final synchronized Object d(Object obj, Object obj2) {
        int b9 = b(obj2);
        long j5 = b9;
        if (j5 >= this.f9944b) {
            c(obj, obj2);
            return null;
        }
        if (obj2 != null) {
            this.f9945c += j5;
        }
        i iVar = (i) this.f9943a.put(obj, obj2 == null ? null : new i(obj2, b9));
        if (iVar != null) {
            this.f9945c -= iVar.f9942b;
            if (!iVar.f9941a.equals(obj2)) {
                c(obj, iVar.f9941a);
            }
        }
        e(this.f9944b);
        return iVar != null ? iVar.f9941a : null;
    }

    public final synchronized void e(long j5) {
        while (this.f9945c > j5) {
            Iterator it = this.f9943a.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            i iVar = (i) entry.getValue();
            this.f9945c -= iVar.f9942b;
            Object key = entry.getKey();
            it.remove();
            c(key, iVar.f9941a);
        }
    }

    public void c(Object obj, Object obj2) {
    }
}
