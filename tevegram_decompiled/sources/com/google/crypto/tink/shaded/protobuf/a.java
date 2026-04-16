package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a implements s0 {
    protected int memoizedHashCode;

    public abstract int b(d1 d1Var);

    public final String c(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public abstract w d();

    public final byte[] e() {
        try {
            int b9 = ((y) this).b(null);
            byte[] bArr = new byte[b9];
            n nVar = new n(bArr, b9);
            f(nVar);
            if (b9 - nVar.f2277d == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e9) {
            m7.c.k(c("byte array"), e9);
            return null;
        }
    }

    public abstract void f(n nVar);
}
