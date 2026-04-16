package r6;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public enum q1 implements com.google.crypto.tink.shaded.protobuf.a0 {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);


    /* renamed from: i, reason: collision with root package name */
    public final int f8595i;

    q1(int i9) {
        this.f8595i = i9;
    }

    public static q1 a(int i9) {
        if (i9 == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i9 == 1) {
            return TINK;
        }
        if (i9 == 2) {
            return LEGACY;
        }
        if (i9 == 3) {
            return RAW;
        }
        if (i9 != 4) {
            return null;
        }
        return CRUNCHY;
    }

    public final int b() {
        if (this != UNRECOGNIZED) {
            return this.f8595i;
        }
        m7.c.n("Can't get the number of an unknown enum value.");
        return 0;
    }
}
