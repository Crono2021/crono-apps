package b6;

import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j0 extends a0 {
    @Override // b6.a0
    public final a0 b(Object obj) {
        obj.getClass();
        a(obj);
        return this;
    }

    public final k0 f() {
        int i9 = this.f1345b;
        if (i9 == 0) {
            int i10 = k0.f1405k;
            return c1.f1366r;
        }
        Object[] objArr = this.f1344a;
        if (i9 != 1) {
            k0 m9 = k0.m(i9, objArr);
            this.f1345b = m9.size();
            this.f1346c = true;
            return m9;
        }
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        int i11 = k0.f1405k;
        return new i1(obj);
    }
}
