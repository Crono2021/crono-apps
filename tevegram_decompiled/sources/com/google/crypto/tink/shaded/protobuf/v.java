package com.google.crypto.tink.shaded.protobuf;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v implements r0 {

    /* renamed from: b, reason: collision with root package name */
    public static final v f2320b = new v(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2321a;

    public /* synthetic */ v(int i9) {
        this.f2321a = i9;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.r0
    public final c1 a(Class cls) {
        switch (this.f2321a) {
            case 0:
                if (y.class.isAssignableFrom(cls)) {
                    try {
                        return (c1) y.j(cls.asSubclass(y.class)).i(3);
                    } catch (Exception e9) {
                        m7.c.k("Unable to get message info for ".concat(cls.getName()), e9);
                    }
                } else {
                    m7.c.n("Unsupported message type: ".concat(cls.getName()));
                }
                return null;
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.r0
    public final boolean b(Class cls) {
        switch (this.f2321a) {
            case 0:
                return y.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
