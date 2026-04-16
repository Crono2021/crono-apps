package p;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class f implements Iterable {

    /* renamed from: i, reason: collision with root package name */
    public c f8089i;

    /* renamed from: j, reason: collision with root package name */
    public c f8090j;

    /* renamed from: k, reason: collision with root package name */
    public final WeakHashMap f8091k = new WeakHashMap();

    /* renamed from: l, reason: collision with root package name */
    public int f8092l = 0;

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0048, code lost:
    
        if (r3.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0050, code lost:
    
        if (((p.b) r7).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0052, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0053, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof p.f
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            p.f r7 = (p.f) r7
            int r1 = r6.f8092l
            int r3 = r7.f8092l
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            p.b r3 = (p.b) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            p.b r4 = (p.b) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            p.b r7 = (p.b) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            return r0
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p.f.equals(java.lang.Object):boolean");
    }

    public c f(Object obj) {
        c cVar = this.f8089i;
        while (cVar != null && !cVar.f8082i.equals(obj)) {
            cVar = cVar.f8084k;
        }
        return cVar;
    }

    public Object g(Object obj) {
        c f9 = f(obj);
        if (f9 == null) {
            return null;
        }
        this.f8092l--;
        WeakHashMap weakHashMap = this.f8091k;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((e) it.next()).a(f9);
            }
        }
        c cVar = f9.f8085l;
        c cVar2 = f9.f8084k;
        if (cVar != null) {
            cVar.f8084k = cVar2;
        } else {
            this.f8089i = cVar2;
        }
        c cVar3 = f9.f8084k;
        if (cVar3 != null) {
            cVar3.f8085l = cVar;
        } else {
            this.f8090j = cVar;
        }
        f9.f8084k = null;
        f9.f8085l = null;
        return f9.f8083j;
    }

    public final int hashCode() {
        Iterator it = iterator();
        int i9 = 0;
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return i9;
            }
            i9 += ((Map.Entry) bVar.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        b bVar = new b(this.f8089i, this.f8090j, 0);
        this.f8091k.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) bVar.next()).toString());
            if (bVar.hasNext()) {
                sb.append(", ");
            }
        }
    }
}
