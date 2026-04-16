package l8;

import b8.i;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import n7.g;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements a {

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f6350e = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_state");
    private volatile Object _state;

    /* renamed from: a, reason: collision with root package name */
    public f[] f6351a;

    /* renamed from: b, reason: collision with root package name */
    public int f6352b;

    /* renamed from: c, reason: collision with root package name */
    public int f6353c;

    /* renamed from: d, reason: collision with root package name */
    public int f6354d;

    public d(Object obj) {
        this._state = obj;
    }

    @Override // l8.a
    public final Object a(Object obj, t7.c cVar) {
        e(obj);
        return g.f7490c;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ca A[Catch: all -> 0x003f, TryCatch #1 {all -> 0x003f, blocks: (B:13:0x0039, B:15:0x00c2, B:17:0x00ca, B:20:0x00d1, B:21:0x00d5, B:25:0x00d8, B:27:0x00f9, B:30:0x010c, B:31:0x0126, B:37:0x0136, B:33:0x012d, B:36:0x0133, B:46:0x00de, B:49:0x00e5, B:57:0x0053, B:59:0x005e, B:60:0x00b2), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010c A[Catch: all -> 0x003f, TryCatch #1 {all -> 0x003f, blocks: (B:13:0x0039, B:15:0x00c2, B:17:0x00ca, B:20:0x00d1, B:21:0x00d5, B:25:0x00d8, B:27:0x00f9, B:30:0x010c, B:31:0x0126, B:37:0x0136, B:33:0x012d, B:36:0x0133, B:46:0x00de, B:49:0x00e5, B:57:0x0053, B:59:0x005e, B:60:0x00b2), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x010b -> B:15:0x00c2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(l8.a r17, r7.c r18) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l8.d.b(l8.a, r7.c):java.lang.Object");
    }

    public final void c(f fVar) {
        synchronized (this) {
            try {
                int i9 = this.f6352b - 1;
                this.f6352b = i9;
                if (i9 == 0) {
                    this.f6353c = 0;
                }
                fVar.getClass();
                f.f6357a.set(fVar, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Object d() {
        Object obj = f6350e.get(this);
        if (obj == m8.f.f6771a) {
            return null;
        }
        return obj;
    }

    public final void e(Object obj) {
        int i9;
        f[] fVarArr;
        a6.d dVar;
        if (obj == null) {
            obj = m8.f.f6771a;
        }
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6350e;
            if (i.a(atomicReferenceFieldUpdater.get(this), obj)) {
                return;
            }
            atomicReferenceFieldUpdater.set(this, obj);
            int i10 = this.f6354d;
            if ((i10 & 1) != 0) {
                this.f6354d = i10 + 2;
                return;
            }
            int i11 = i10 + 1;
            this.f6354d = i11;
            f[] fVarArr2 = this.f6351a;
            while (true) {
                if (fVarArr2 != null) {
                    for (f fVar : fVarArr2) {
                        if (fVar != null) {
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f.f6357a;
                            while (true) {
                                Object obj2 = atomicReferenceFieldUpdater2.get(fVar);
                                if (obj2 != null && obj2 != (dVar = e.f6356b)) {
                                    a6.d dVar2 = e.f6355a;
                                    if (obj2 != dVar2) {
                                        while (!atomicReferenceFieldUpdater2.compareAndSet(fVar, obj2, dVar2)) {
                                            if (atomicReferenceFieldUpdater2.get(fVar) != obj2) {
                                                break;
                                            }
                                        }
                                        ((i8.f) obj2).g(g.f7490c);
                                        break;
                                    }
                                    while (!atomicReferenceFieldUpdater2.compareAndSet(fVar, obj2, dVar)) {
                                        if (atomicReferenceFieldUpdater2.get(fVar) != obj2) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                synchronized (this) {
                    i9 = this.f6354d;
                    if (i9 == i11) {
                        this.f6354d = i11 + 1;
                        return;
                    }
                    fVarArr = this.f6351a;
                }
                fVarArr2 = fVarArr;
                i11 = i9;
            }
        }
    }
}
