package b6;

import java.util.List;
import java.util.ListIterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k extends c implements ListIterator {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ l f1404m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(l lVar, int i9) {
        super(lVar, ((List) lVar.f1408j).listIterator(i9));
        this.f1404m = lVar;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        l lVar = this.f1404m;
        boolean isEmpty = lVar.isEmpty();
        b().add(obj);
        lVar.f1412n.f1448m++;
        if (isEmpty) {
            lVar.f();
        }
    }

    public final ListIterator b() {
        a();
        return (ListIterator) this.f1360j;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return b().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return b().nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return b().previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return b().previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        b().set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(l lVar) {
        super(lVar);
        this.f1404m = lVar;
    }
}
