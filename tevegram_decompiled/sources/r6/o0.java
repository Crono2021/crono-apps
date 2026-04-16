package r6;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public enum o0 implements com.google.crypto.tink.shaded.protobuf.a0 {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA384(2),
    SHA256(3),
    SHA512(4),
    SHA224(5),
    UNRECOGNIZED(-1);


    /* renamed from: i, reason: collision with root package name */
    public final int f8587i;

    o0(int i9) {
        this.f8587i = i9;
    }

    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f8587i;
        }
        m7.c.n("Can't get the number of an unknown enum value.");
        return 0;
    }
}
