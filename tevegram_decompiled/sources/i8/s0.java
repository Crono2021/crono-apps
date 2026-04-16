package i8;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class s0 extends y0 {

    /* renamed from: k, reason: collision with root package name */
    public final boolean f5302k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0() {
        super(true);
        boolean z8 = true;
        z(null);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = y0.f5332j;
        i iVar = (i) atomicReferenceFieldUpdater.get(this);
        j jVar = iVar instanceof j ? (j) iVar : null;
        if (jVar != null) {
            y0 o8 = jVar.o();
            while (!o8.t()) {
                i iVar2 = (i) atomicReferenceFieldUpdater.get(o8);
                j jVar2 = iVar2 instanceof j ? (j) iVar2 : null;
                if (jVar2 != null) {
                    o8 = jVar2.o();
                }
            }
            this.f5302k = z8;
        }
        z8 = false;
        this.f5302k = z8;
    }

    @Override // i8.y0
    public final boolean t() {
        return this.f5302k;
    }

    @Override // i8.y0
    public final boolean u() {
        return true;
    }
}
