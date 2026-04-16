package b6;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r implements Iterator {

    /* renamed from: i, reason: collision with root package name */
    public int f1435i;

    /* renamed from: j, reason: collision with root package name */
    public int f1436j;

    /* renamed from: k, reason: collision with root package name */
    public int f1437k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ u f1438l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f1439m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ u f1440n;

    public r(u uVar, int i9) {
        this.f1439m = i9;
        this.f1440n = uVar;
        this.f1438l = uVar;
        this.f1435i = uVar.f1455m;
        this.f1436j = uVar.isEmpty() ? -1 : 0;
        this.f1437k = -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1436j >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object obj;
        u uVar = this.f1438l;
        if (uVar.f1455m != this.f1435i) {
            throw new ConcurrentModificationException();
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i9 = this.f1436j;
        this.f1437k = i9;
        switch (this.f1439m) {
            case 0:
                obj = this.f1440n.i()[i9];
                break;
            case 1:
                obj = new t(this.f1440n, i9);
                break;
            default:
                obj = this.f1440n.j()[i9];
                break;
        }
        int i10 = this.f1436j + 1;
        if (i10 >= uVar.f1456n) {
            i10 = -1;
        }
        this.f1436j = i10;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        u uVar = this.f1438l;
        int i9 = uVar.f1455m;
        int i10 = this.f1435i;
        if (i9 != i10) {
            throw new ConcurrentModificationException();
        }
        int i11 = this.f1437k;
        if (!(i11 >= 0)) {
            m7.c.p("no calls to next() since the last call to remove()");
            return;
        }
        this.f1435i = i10 + 32;
        uVar.remove(uVar.i()[i11]);
        this.f1436j--;
        this.f1437k = -1;
    }
}
