package b6;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f1344a;

    /* renamed from: b, reason: collision with root package name */
    public int f1345b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1346c;

    public a0() {
        q.b(4, "initialCapacity");
        this.f1344a = new Object[4];
        this.f1345b = 0;
    }

    public static int d(int i9, int i10) {
        if (i10 < 0) {
            m7.c.e("cannot store more than MAX_VALUE elements");
            return 0;
        }
        int i11 = i9 + (i9 >> 1) + 1;
        if (i11 < i10) {
            i11 = Integer.highestOneBit(i10 - 1) << 1;
        }
        if (i11 < 0) {
            return Integer.MAX_VALUE;
        }
        return i11;
    }

    public final void a(Object obj) {
        obj.getClass();
        e(this.f1345b + 1);
        Object[] objArr = this.f1344a;
        int i9 = this.f1345b;
        this.f1345b = i9 + 1;
        objArr[i9] = obj;
    }

    public abstract a0 b(Object obj);

    public final void c(Iterable iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            e(collection.size() + this.f1345b);
            if (collection instanceof b0) {
                this.f1345b = ((b0) collection).g(this.f1345b, this.f1344a);
                return;
            }
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public final void e(int i9) {
        Object[] objArr = this.f1344a;
        if (objArr.length < i9) {
            this.f1344a = Arrays.copyOf(objArr, d(objArr.length, i9));
            this.f1346c = false;
        } else if (this.f1346c) {
            this.f1344a = (Object[]) objArr.clone();
            this.f1346c = false;
        }
    }
}
