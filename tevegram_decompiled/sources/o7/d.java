package o7;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements Collection {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f8005i = 1;

    /* renamed from: j, reason: collision with root package name */
    public final Object f8006j;

    public d(Object[] objArr) {
        objArr.getClass();
        this.f8006j = objArr;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        switch (this.f8005i) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.f8005i) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Collection
    public final void clear() {
        switch (this.f8005i) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                ((s.d) this.f8006j).clear();
                return;
        }
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f8005i) {
            case 0:
                Object[] objArr = (Object[]) this.f8006j;
                objArr.getClass();
                if (f.b0(objArr, obj) >= 0) {
                }
                break;
            default:
                if (((s.d) this.f8006j).g(obj) >= 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        switch (this.f8005i) {
            case 0:
                collection.getClass();
                if (!collection.isEmpty()) {
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        if (!contains(it.next())) {
                            break;
                        }
                    }
                    break;
                }
                break;
            default:
                Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    if (!contains(it2.next())) {
                        break;
                    }
                }
                break;
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        switch (this.f8005i) {
            case 0:
                return ((Object[]) this.f8006j).length == 0;
            default:
                return ((s.d) this.f8006j).isEmpty();
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f8005i) {
            case 0:
                return b8.r.b((Object[]) this.f8006j);
            default:
                return new s.a((s.d) this.f8006j, 1);
        }
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        switch (this.f8005i) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                s.d dVar = (s.d) this.f8006j;
                int g9 = dVar.g(obj);
                if (g9 < 0) {
                    return false;
                }
                dVar.j(g9);
                return true;
        }
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.f8005i) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                s.d dVar = (s.d) this.f8006j;
                int i9 = dVar.f8653k;
                int i10 = 0;
                boolean z8 = false;
                while (i10 < i9) {
                    if (collection.contains(dVar.l(i10))) {
                        dVar.j(i10);
                        i10--;
                        i9--;
                        z8 = true;
                    }
                    i10++;
                }
                return z8;
        }
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.f8005i) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                s.d dVar = (s.d) this.f8006j;
                int i9 = dVar.f8653k;
                int i10 = 0;
                boolean z8 = false;
                while (i10 < i9) {
                    if (!collection.contains(dVar.l(i10))) {
                        dVar.j(i10);
                        i10--;
                        i9--;
                        z8 = true;
                    }
                    i10++;
                }
                return z8;
        }
    }

    @Override // java.util.Collection
    public final int size() {
        switch (this.f8005i) {
            case 0:
                return ((Object[]) this.f8006j).length;
            default:
                return ((s.d) this.f8006j).f8653k;
        }
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        switch (this.f8005i) {
            case 0:
                Object[] objArr = (Object[]) this.f8006j;
                objArr.getClass();
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
                copyOf.getClass();
                return copyOf;
            default:
                s.d dVar = (s.d) this.f8006j;
                int i9 = dVar.f8653k;
                Object[] objArr2 = new Object[i9];
                for (int i10 = 0; i10 < i9; i10++) {
                    objArr2[i10] = dVar.l(i10);
                }
                return objArr2;
        }
    }

    public d(s.d dVar) {
        this.f8006j = dVar;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.f8005i) {
            case 0:
                objArr.getClass();
                return b8.i.f(this, objArr);
            default:
                return ((s.d) this.f8006j).m(1, objArr);
        }
    }
}
