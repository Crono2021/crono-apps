package g8;

import java.util.Iterator;
import java.util.NoSuchElementException;
import r7.g;
import r7.h;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements Iterator, r7.c {

    /* renamed from: i, reason: collision with root package name */
    public int f3845i;

    /* renamed from: j, reason: collision with root package name */
    public Object f3846j;

    /* renamed from: k, reason: collision with root package name */
    public Iterator f3847k;

    /* renamed from: l, reason: collision with root package name */
    public r7.c f3848l;

    public final RuntimeException a() {
        int i9 = this.f3845i;
        if (i9 == 4) {
            return new NoSuchElementException();
        }
        if (i9 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f3845i);
    }

    @Override // r7.c
    public final g f() {
        return h.f8615i;
    }

    @Override // r7.c
    public final void g(Object obj) {
        com.bumptech.glide.c.V(obj);
        this.f3845i = 4;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i9 = this.f3845i;
            if (i9 != 0) {
                if (i9 != 1) {
                    if (i9 == 2 || i9 == 3) {
                        return true;
                    }
                    if (i9 == 4) {
                        return false;
                    }
                    throw a();
                }
                Iterator it = this.f3847k;
                it.getClass();
                if (it.hasNext()) {
                    this.f3845i = 2;
                    return true;
                }
                this.f3847k = null;
            }
            this.f3845i = 5;
            r7.c cVar = this.f3848l;
            cVar.getClass();
            this.f3848l = null;
            cVar.g(n7.g.f7490c);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i9 = this.f3845i;
        if (i9 == 0 || i9 == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i9 == 2) {
            this.f3845i = 1;
            Iterator it = this.f3847k;
            it.getClass();
            return it.next();
        }
        if (i9 != 3) {
            throw a();
        }
        this.f3845i = 0;
        Object obj = this.f3846j;
        this.f3846j = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
