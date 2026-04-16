package b6;

import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class j1 implements Iterator {

    /* renamed from: i, reason: collision with root package name */
    public final Iterator f1403i;

    public j1(Iterator it) {
        it.getClass();
        this.f1403i = it;
    }

    public abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1403i.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.f1403i.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f1403i.remove();
    }
}
