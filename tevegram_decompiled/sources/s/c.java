package s;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements Iterator, Map.Entry {

    /* renamed from: i, reason: collision with root package name */
    public int f8624i;

    /* renamed from: j, reason: collision with root package name */
    public int f8625j = -1;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8626k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ d f8627l;

    public c(d dVar) {
        this.f8627l = dVar;
        this.f8624i = dVar.f8653k - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.f8626k) {
            m7.c.p("This container does not support retaining Map.Entry objects");
            return false;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int i9 = this.f8625j;
        d dVar = this.f8627l;
        Object h = dVar.h(i9);
        if (key != h && (key == null || !key.equals(h))) {
            return false;
        }
        Object value = entry.getValue();
        Object l4 = dVar.l(this.f8625j);
        if (value != l4) {
            return value != null && value.equals(l4);
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (this.f8626k) {
            return this.f8627l.h(this.f8625j);
        }
        m7.c.p("This container does not support retaining Map.Entry objects");
        return null;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f8626k) {
            return this.f8627l.l(this.f8625j);
        }
        m7.c.p("This container does not support retaining Map.Entry objects");
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f8625j < this.f8624i;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.f8626k) {
            m7.c.p("This container does not support retaining Map.Entry objects");
            return 0;
        }
        int i9 = this.f8625j;
        d dVar = this.f8627l;
        Object h = dVar.h(i9);
        Object l4 = dVar.l(this.f8625j);
        return (h == null ? 0 : h.hashCode()) ^ (l4 != null ? l4.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f8625j++;
        this.f8626k = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f8626k) {
            androidx.fragment.app.a.l();
            return;
        }
        this.f8627l.j(this.f8625j);
        this.f8625j--;
        this.f8624i--;
        this.f8626k = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.f8626k) {
            return this.f8627l.k(this.f8625j, obj);
        }
        m7.c.p("This container does not support retaining Map.Entry objects");
        return null;
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
