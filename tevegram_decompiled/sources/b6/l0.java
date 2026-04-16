package b6;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l0 extends k1 {

    /* renamed from: i, reason: collision with root package name */
    public int f1413i;

    /* renamed from: j, reason: collision with root package name */
    public Object f1414j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f1415k;

    /* renamed from: l, reason: collision with root package name */
    public final Iterator f1416l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f1417m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l0(e1 e1Var) {
        this();
        this.f1415k = 1;
        this.f1417m = e1Var;
        this.f1416l = e1Var.f1382i.iterator();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        Object next;
        int i9 = this.f1413i;
        if (i9 == 4) {
            androidx.fragment.app.a.l();
            return false;
        }
        int a9 = v.h.a(i9);
        if (a9 == 0) {
            return true;
        }
        if (a9 == 2) {
            return false;
        }
        this.f1413i = 4;
        switch (this.f1415k) {
            case 0:
                do {
                    Iterator it = this.f1416l;
                    if (!it.hasNext()) {
                        this.f1413i = 3;
                        next = null;
                        break;
                    } else {
                        next = it.next();
                    }
                } while (!((a6.e) this.f1417m).apply(next));
            default:
                do {
                    Iterator it2 = this.f1416l;
                    if (!it2.hasNext()) {
                        this.f1413i = 3;
                        next = null;
                        break;
                    } else {
                        next = it2.next();
                    }
                } while (!((e1) this.f1417m).f1383j.contains(next));
        }
        this.f1414j = next;
        if (this.f1413i == 3) {
            return false;
        }
        this.f1413i = 1;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f1413i = 2;
        Object obj = this.f1414j;
        this.f1414j = null;
        return obj;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l0(Iterator it, a6.e eVar) {
        this();
        this.f1415k = 0;
        this.f1416l = it;
        this.f1417m = eVar;
    }

    public l0() {
        this.f1413i = 2;
    }
}
