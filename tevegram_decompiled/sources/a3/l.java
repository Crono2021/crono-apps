package a3;

import g1.w;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class l implements z2.g {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque f121a = new ArrayDeque();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f122b;

    /* renamed from: c, reason: collision with root package name */
    public final PriorityQueue f123c;

    /* renamed from: d, reason: collision with root package name */
    public j f124d;

    /* renamed from: e, reason: collision with root package name */
    public long f125e;

    /* renamed from: f, reason: collision with root package name */
    public long f126f;

    public l() {
        for (int i9 = 0; i9 < 10; i9++) {
            this.f121a.add(new j());
        }
        this.f122b = new ArrayDeque();
        for (int i10 = 0; i10 < 2; i10++) {
            ArrayDeque arrayDeque = this.f122b;
            i iVar = new i(this, 0);
            k kVar = new k();
            kVar.f120o = iVar;
            arrayDeque.add(kVar);
        }
        this.f123c = new PriorityQueue();
    }

    @Override // z2.g
    public final void a(long j5) {
        this.f125e = j5;
    }

    @Override // j1.b
    public final void b(z2.i iVar) {
        g1.a.f(iVar == this.f124d);
        j jVar = (j) iVar;
        if (jVar.c(Integer.MIN_VALUE)) {
            jVar.k();
            this.f121a.add(jVar);
        } else {
            long j5 = this.f126f;
            this.f126f = 1 + j5;
            jVar.f119t = j5;
            this.f123c.add(jVar);
        }
        this.f124d = null;
    }

    @Override // j1.b
    public final Object d() {
        g1.a.k(this.f124d == null);
        ArrayDeque arrayDeque = this.f121a;
        if (arrayDeque.isEmpty()) {
            return null;
        }
        j jVar = (j) arrayDeque.pollFirst();
        this.f124d = jVar;
        return jVar;
    }

    public abstract a0.b e();

    public abstract void f(j jVar);

    @Override // j1.b
    public void flush() {
        ArrayDeque arrayDeque;
        this.f126f = 0L;
        this.f125e = 0L;
        while (true) {
            PriorityQueue priorityQueue = this.f123c;
            boolean isEmpty = priorityQueue.isEmpty();
            arrayDeque = this.f121a;
            if (isEmpty) {
                break;
            }
            j jVar = (j) priorityQueue.poll();
            int i9 = w.f3713a;
            jVar.k();
            arrayDeque.add(jVar);
        }
        j jVar2 = this.f124d;
        if (jVar2 != null) {
            jVar2.k();
            arrayDeque.add(jVar2);
            this.f124d = null;
        }
    }

    @Override // j1.b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public z2.j c() {
        ArrayDeque arrayDeque = this.f122b;
        if (arrayDeque.isEmpty()) {
            return null;
        }
        while (true) {
            PriorityQueue priorityQueue = this.f123c;
            if (priorityQueue.isEmpty()) {
                return null;
            }
            j jVar = (j) priorityQueue.peek();
            int i9 = w.f3713a;
            if (jVar.f5361o > this.f125e) {
                return null;
            }
            j jVar2 = (j) priorityQueue.poll();
            boolean c9 = jVar2.c(4);
            ArrayDeque arrayDeque2 = this.f121a;
            if (c9) {
                z2.j jVar3 = (z2.j) arrayDeque.pollFirst();
                jVar3.a(4);
                jVar2.k();
                arrayDeque2.add(jVar2);
                return jVar3;
            }
            f(jVar2);
            if (h()) {
                a0.b e9 = e();
                z2.j jVar4 = (z2.j) arrayDeque.pollFirst();
                long j5 = jVar2.f5361o;
                jVar4.f5365k = j5;
                jVar4.f10618m = e9;
                jVar4.f10619n = j5;
                jVar2.k();
                arrayDeque2.add(jVar2);
                return jVar4;
            }
            jVar2.k();
            arrayDeque2.add(jVar2);
        }
    }

    public abstract boolean h();

    @Override // j1.b
    public void release() {
    }
}
