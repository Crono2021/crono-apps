package com.google.crypto.tink.shaded.protobuf;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h1 {
    public static g1 a(Object obj) {
        y yVar = (y) obj;
        g1 g1Var = yVar.unknownFields;
        if (g1Var != g1.f2237f) {
            return g1Var;
        }
        g1 c9 = g1.c();
        yVar.unknownFields = c9;
        return c9;
    }

    public static boolean b(Object obj, a5.k kVar) {
        m mVar = (m) kVar.f198d;
        int i9 = kVar.f195a;
        int i10 = i9 >>> 3;
        int i11 = i9 & 7;
        if (i11 == 0) {
            kVar.w(0);
            ((g1) obj).d(i10 << 3, Long.valueOf(mVar.u()));
            return true;
        }
        if (i11 == 1) {
            kVar.w(1);
            ((g1) obj).d((i10 << 3) | 1, Long.valueOf(mVar.r()));
            return true;
        }
        if (i11 == 2) {
            ((g1) obj).d((i10 << 3) | 2, kVar.f());
            return true;
        }
        if (i11 != 3) {
            if (i11 == 4) {
                return false;
            }
            if (i11 != 5) {
                throw e0.c();
            }
            kVar.w(5);
            ((g1) obj).d((i10 << 3) | 5, Integer.valueOf(mVar.q()));
            return true;
        }
        g1 c9 = g1.c();
        int i12 = i10 << 3;
        int i13 = i12 | 4;
        while (kVar.b() != Integer.MAX_VALUE && b(c9, kVar)) {
        }
        if (i13 != kVar.f195a) {
            throw new e0("Protocol message end-group tag did not match expected tag.");
        }
        c9.f2242e = false;
        ((g1) obj).d(i12 | 3, c9);
        return true;
    }
}
