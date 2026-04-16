package e8;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements Iterator {

    /* renamed from: i, reason: collision with root package name */
    public final int f3161i;

    /* renamed from: j, reason: collision with root package name */
    public final int f3162j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3163k;

    /* renamed from: l, reason: collision with root package name */
    public int f3164l;

    public b(int i9, int i10, int i11) {
        this.f3161i = i11;
        this.f3162j = i10;
        boolean z8 = false;
        if (i11 <= 0 ? i9 >= i10 : i9 <= i10) {
            z8 = true;
        }
        this.f3163k = z8;
        this.f3164l = z8 ? i9 : i10;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3163k;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i9 = this.f3164l;
        if (i9 != this.f3162j) {
            this.f3164l = this.f3161i + i9;
        } else {
            if (!this.f3163k) {
                throw new NoSuchElementException();
            }
            this.f3163k = false;
        }
        return Integer.valueOf(i9);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
