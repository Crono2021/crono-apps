package b6;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e0 extends k1 implements ListIterator {

    /* renamed from: i, reason: collision with root package name */
    public final int f1379i;

    /* renamed from: j, reason: collision with root package name */
    public int f1380j;

    /* renamed from: k, reason: collision with root package name */
    public final g0 f1381k;

    public e0(g0 g0Var, int i9) {
        int size = g0Var.size();
        com.bumptech.glide.c.g(i9, size);
        this.f1379i = size;
        this.f1380j = i9;
        this.f1381k = g0Var;
    }

    public final Object a(int i9) {
        return this.f1381k.get(i9);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f1380j < this.f1379i;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f1380j > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i9 = this.f1380j;
        this.f1380j = i9 + 1;
        return a(i9);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f1380j;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i9 = this.f1380j - 1;
        this.f1380j = i9;
        return a(i9);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f1380j - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
