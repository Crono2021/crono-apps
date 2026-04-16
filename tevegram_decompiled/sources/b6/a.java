package b6;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements Iterator {

    /* renamed from: i, reason: collision with root package name */
    public final Iterator f1339i;

    /* renamed from: j, reason: collision with root package name */
    public Object f1340j = null;

    /* renamed from: k, reason: collision with root package name */
    public Collection f1341k = null;

    /* renamed from: l, reason: collision with root package name */
    public Iterator f1342l = n0.f1422i;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ t0 f1343m;

    public a(t0 t0Var) {
        this.f1343m = t0Var;
        this.f1339i = t0Var.f1447l.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1339i.hasNext() || this.f1342l.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f1342l.hasNext()) {
            Map.Entry entry = (Map.Entry) this.f1339i.next();
            this.f1340j = entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.f1341k = collection;
            this.f1342l = collection.iterator();
        }
        return this.f1342l.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f1342l.remove();
        Collection collection = this.f1341k;
        Objects.requireNonNull(collection);
        if (collection.isEmpty()) {
            this.f1339i.remove();
        }
        t0 t0Var = this.f1343m;
        t0Var.f1448m--;
    }
}
