package w2;

import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends g5.c {

    /* renamed from: k, reason: collision with root package name */
    public final long f9711k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f9712l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f9713m;

    public a(int i9, long j5) {
        super(i9, 2);
        this.f9711k = j5;
        this.f9712l = new ArrayList();
        this.f9713m = new ArrayList();
    }

    public final a k(int i9) {
        ArrayList arrayList = this.f9713m;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = (a) arrayList.get(i10);
            if (aVar.f3748j == i9) {
                return aVar;
            }
        }
        return null;
    }

    public final b l(int i9) {
        ArrayList arrayList = this.f9712l;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = (b) arrayList.get(i10);
            if (bVar.f3748j == i9) {
                return bVar;
            }
        }
        return null;
    }

    @Override // g5.c
    public final String toString() {
        return g5.c.b(this.f3748j) + " leaves: " + Arrays.toString(this.f9712l.toArray()) + " containers: " + Arrays.toString(this.f9713m.toArray());
    }
}
