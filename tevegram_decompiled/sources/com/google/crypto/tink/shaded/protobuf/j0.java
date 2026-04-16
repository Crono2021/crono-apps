package com.google.crypto.tink.shaded.protobuf;

import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j0 extends k0 {
    @Override // com.google.crypto.tink.shaded.protobuf.k0
    public final void a(long j5, Object obj) {
        ((b) ((b0) p1.f2286c.i(j5, obj))).f2201i = false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.k0
    public final void b(long j5, Object obj, Object obj2) {
        o1 o1Var = p1.f2286c;
        b0 b0Var = (b0) o1Var.i(j5, obj);
        b0 b0Var2 = (b0) o1Var.i(j5, obj2);
        int size = b0Var.size();
        int size2 = b0Var2.size();
        if (size > 0 && size2 > 0) {
            if (!((b) b0Var).f2201i) {
                b0Var = b0Var.a(size2 + size);
            }
            b0Var.addAll(b0Var2);
        }
        if (size > 0) {
            b0Var2 = b0Var;
        }
        p1.p(j5, obj, b0Var2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.k0
    public final List c(long j5, Object obj) {
        b0 b0Var = (b0) p1.f2286c.i(j5, obj);
        if (((b) b0Var).f2201i) {
            return b0Var;
        }
        int size = b0Var.size();
        b0 a9 = b0Var.a(size == 0 ? 10 : size * 2);
        p1.p(j5, obj, a9);
        return a9;
    }
}
