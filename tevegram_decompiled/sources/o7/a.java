package o7;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends b8.a implements ListIterator {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ c f8001l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar, int i9) {
        super(cVar);
        this.f8001l = cVar;
        int f9 = cVar.f();
        if (i9 < 0 || i9 > f9) {
            m7.c.h(", size: ", "index: ", i9, f9);
            throw null;
        }
        this.f1507j = i9;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f1507j > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f1507j;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i9 = this.f1507j - 1;
        this.f1507j = i9;
        return this.f8001l.get(i9);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f1507j - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
