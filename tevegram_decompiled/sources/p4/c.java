package p4;

import b4.l;
import b6.e0;
import b6.g0;
import b6.q;
import b6.w0;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements x1.a {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f8251a;

    public c(int i9) {
        switch (i9) {
            case 1:
                this.f8251a = new ArrayList();
                break;
            case 2:
                this.f8251a = new ArrayList();
                break;
            case 3:
                this.f8251a = new ArrayList();
                break;
            case 4:
                this.f8251a = new ArrayList();
                break;
            default:
                this.f8251a = new ArrayList();
                break;
        }
    }

    @Override // x1.a
    public g0 a(long j5) {
        int h = h(j5);
        if (h == 0) {
            e0 e0Var = g0.f1391j;
            return w0.f1464m;
        }
        z2.a aVar = (z2.a) this.f8251a.get(h - 1);
        long j9 = aVar.f10610d;
        if (j9 == -9223372036854775807L || j5 < j9) {
            return aVar.f10607a;
        }
        e0 e0Var2 = g0.f1391j;
        return w0.f1464m;
    }

    @Override // x1.a
    public long b(long j5) {
        ArrayList arrayList = this.f8251a;
        if (arrayList.isEmpty()) {
            return Long.MIN_VALUE;
        }
        if (j5 < ((z2.a) arrayList.get(0)).f10608b) {
            return ((z2.a) arrayList.get(0)).f10608b;
        }
        for (int i9 = 1; i9 < arrayList.size(); i9++) {
            z2.a aVar = (z2.a) arrayList.get(i9);
            long j9 = aVar.f10608b;
            long j10 = aVar.f10608b;
            if (j5 < j9) {
                long j11 = ((z2.a) arrayList.get(i9 - 1)).f10610d;
                return (j11 == -9223372036854775807L || j11 <= j5 || j11 >= j10) ? j10 : j11;
            }
        }
        long j12 = ((z2.a) q.g(arrayList)).f10610d;
        if (j12 == -9223372036854775807L || j5 >= j12) {
            return Long.MIN_VALUE;
        }
        return j12;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    @Override // x1.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c(z2.a r11, long r12) {
        /*
            r10 = this;
            long r0 = r11.f10608b
            r2 = 0
            r3 = 1
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 == 0) goto Lf
            r6 = 1
            goto L10
        Lf:
            r6 = 0
        L10:
            g1.a.f(r6)
            int r6 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r6 > 0) goto L23
            long r6 = r11.f10610d
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 == 0) goto L21
            int r4 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r4 >= 0) goto L23
        L21:
            r4 = 1
            goto L24
        L23:
            r4 = 0
        L24:
            java.util.ArrayList r5 = r10.f8251a
            int r6 = r5.size()
            int r6 = r6 - r3
        L2b:
            if (r6 < 0) goto L4e
            java.lang.Object r7 = r5.get(r6)
            z2.a r7 = (z2.a) r7
            long r7 = r7.f10608b
            int r9 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r9 < 0) goto L3e
            int r6 = r6 + r3
            r5.add(r6, r11)
            return r4
        L3e:
            java.lang.Object r7 = r5.get(r6)
            z2.a r7 = (z2.a) r7
            long r7 = r7.f10608b
            int r9 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r9 > 0) goto L4b
            r4 = 0
        L4b:
            int r6 = r6 + (-1)
            goto L2b
        L4e:
            r5.add(r2, r11)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.c.c(z2.a, long):boolean");
    }

    @Override // x1.a
    public void clear() {
        this.f8251a.clear();
    }

    @Override // x1.a
    public long d(long j5) {
        ArrayList arrayList = this.f8251a;
        if (arrayList.isEmpty() || j5 < ((z2.a) arrayList.get(0)).f10608b) {
            return -9223372036854775807L;
        }
        for (int i9 = 1; i9 < arrayList.size(); i9++) {
            long j9 = ((z2.a) arrayList.get(i9)).f10608b;
            if (j5 == j9) {
                return j9;
            }
            if (j5 < j9) {
                z2.a aVar = (z2.a) arrayList.get(i9 - 1);
                long j10 = aVar.f10610d;
                return (j10 == -9223372036854775807L || j10 > j5) ? aVar.f10608b : j10;
            }
        }
        z2.a aVar2 = (z2.a) q.g(arrayList);
        long j11 = aVar2.f10610d;
        return (j11 == -9223372036854775807L || j5 < j11) ? aVar2.f10608b : j11;
    }

    @Override // x1.a
    public void e(long j5) {
        int h = h(j5);
        if (h > 0) {
            this.f8251a.subList(0, h).clear();
        }
    }

    public synchronized l f(Class cls) {
        int size = this.f8251a.size();
        for (int i9 = 0; i9 < size; i9++) {
            r4.d dVar = (r4.d) this.f8251a.get(i9);
            if (dVar.f8555a.isAssignableFrom(cls)) {
                return dVar.f8556b;
            }
        }
        return null;
    }

    public synchronized a g(Class cls, Class cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return d.f8252j;
        }
        ArrayList arrayList = this.f8251a;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            b bVar = (b) obj;
            if (bVar.f8248a.isAssignableFrom(cls) && cls2.isAssignableFrom(bVar.f8249b)) {
                return bVar.f8250c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public int h(long j5) {
        int i9 = 0;
        while (true) {
            ArrayList arrayList = this.f8251a;
            if (i9 >= arrayList.size()) {
                return arrayList.size();
            }
            if (j5 < ((z2.a) arrayList.get(i9)).f10608b) {
                return i9;
            }
            i9++;
        }
    }

    public synchronized ArrayList i(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        ArrayList arrayList2 = this.f8251a;
        int size = arrayList2.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList2.get(i9);
            i9++;
            b bVar = (b) obj;
            if ((bVar.f8248a.isAssignableFrom(cls) && cls2.isAssignableFrom(bVar.f8249b)) && !arrayList.contains(bVar.f8249b)) {
                arrayList.add(bVar.f8249b);
            }
        }
        return arrayList;
    }
}
