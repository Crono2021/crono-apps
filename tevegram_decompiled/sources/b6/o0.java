package b6;

import java.util.AbstractList;
import java.util.ListIterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o0 extends j1 implements ListIterator {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1427j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ AbstractList f1428k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o0(AbstractList abstractList, ListIterator listIterator, int i9) {
        super(listIterator);
        this.f1427j = i9;
        this.f1428k = abstractList;
    }

    @Override // b6.j1
    public final Object a(Object obj) {
        switch (this.f1427j) {
            case 0:
                return ((p0) this.f1428k).f1432j.apply(obj);
            default:
                return ((q0) this.f1428k).f1434j.apply(obj);
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return ((ListIterator) this.f1403i).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return ((ListIterator) this.f1403i).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return a(((ListIterator) this.f1403i).previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return ((ListIterator) this.f1403i).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
