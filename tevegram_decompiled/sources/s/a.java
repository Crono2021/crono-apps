package s;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements Iterator {

    /* renamed from: i, reason: collision with root package name */
    public int f8618i;

    /* renamed from: j, reason: collision with root package name */
    public int f8619j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8620k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f8621l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f8622m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(d dVar, int i9) {
        this(dVar.f8653k);
        this.f8621l = i9;
        switch (i9) {
            case 1:
                this.f8622m = dVar;
                this(dVar.f8653k);
                break;
            default:
                this.f8622m = dVar;
                break;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f8619j < this.f8618i;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object h;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i9 = this.f8619j;
        switch (this.f8621l) {
            case 0:
                h = ((d) this.f8622m).h(i9);
                break;
            case 1:
                h = ((d) this.f8622m).l(i9);
                break;
            default:
                h = ((e) this.f8622m).f8638j[i9];
                break;
        }
        this.f8619j++;
        this.f8620k = true;
        return h;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f8620k) {
            androidx.fragment.app.a.l();
            return;
        }
        int i9 = this.f8619j - 1;
        this.f8619j = i9;
        switch (this.f8621l) {
            case 0:
                ((d) this.f8622m).j(i9);
                break;
            case 1:
                ((d) this.f8622m).j(i9);
                break;
            default:
                ((e) this.f8622m).j(i9);
                break;
        }
        this.f8618i--;
        this.f8620k = false;
    }

    public a(int i9) {
        this.f8618i = i9;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        this(eVar.f8639k);
        this.f8621l = 2;
        this.f8622m = eVar;
    }
}
