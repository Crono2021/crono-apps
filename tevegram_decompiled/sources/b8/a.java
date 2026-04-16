package b8;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class a implements Iterator {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1506i = 1;

    /* renamed from: j, reason: collision with root package name */
    public int f1507j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f1508k;

    public a(Object[] objArr) {
        objArr.getClass();
        this.f1508k = objArr;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f1506i) {
            case 0:
                if (this.f1507j < ((Object[]) this.f1508k).length) {
                }
                break;
            default:
                if (this.f1507j < ((o7.c) this.f1508k).f()) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f1506i) {
            case 0:
                try {
                    Object[] objArr = (Object[]) this.f1508k;
                    int i9 = this.f1507j;
                    this.f1507j = i9 + 1;
                    return objArr[i9];
                } catch (ArrayIndexOutOfBoundsException e9) {
                    this.f1507j--;
                    throw new NoSuchElementException(e9.getMessage());
                }
            default:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                o7.c cVar = (o7.c) this.f1508k;
                int i10 = this.f1507j;
                this.f1507j = i10 + 1;
                return cVar.get(i10);
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f1506i) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public a(o7.c cVar) {
        this.f1508k = cVar;
    }
}
