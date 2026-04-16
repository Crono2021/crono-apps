package r6;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public enum y0 implements com.google.crypto.tink.shaded.protobuf.a0 {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);


    /* renamed from: i, reason: collision with root package name */
    public final int f8610i;

    y0(int i9) {
        this.f8610i = i9;
    }

    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f8610i;
        }
        m7.c.n("Can't get the number of an unknown enum value.");
        return 0;
    }
}
