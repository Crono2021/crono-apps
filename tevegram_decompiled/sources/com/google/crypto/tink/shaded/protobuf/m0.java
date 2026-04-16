package com.google.crypto.tink.shaded.protobuf;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m0 implements r0 {

    /* renamed from: a, reason: collision with root package name */
    public r0[] f2270a;

    @Override // com.google.crypto.tink.shaded.protobuf.r0
    public final c1 a(Class cls) {
        for (r0 r0Var : this.f2270a) {
            if (r0Var.b(cls)) {
                return r0Var.a(cls);
            }
        }
        androidx.fragment.app.a.h("No factory is available for message type: ".concat(cls.getName()));
        return null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.r0
    public final boolean b(Class cls) {
        for (r0 r0Var : this.f2270a) {
            if (r0Var.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
