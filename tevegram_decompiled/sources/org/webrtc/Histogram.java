package org.webrtc;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
class Histogram {
    private final long handle;

    private Histogram(long j5) {
        this.handle = j5;
    }

    public static Histogram createCounts(String str, int i9, int i10, int i11) {
        return new Histogram(nativeCreateCounts(str, i9, i10, i11));
    }

    public static Histogram createEnumeration(String str, int i9) {
        return new Histogram(nativeCreateEnumeration(str, i9));
    }

    private static native void nativeAddSample(long j5, int i9);

    private static native long nativeCreateCounts(String str, int i9, int i10, int i11);

    private static native long nativeCreateEnumeration(String str, int i9);

    public void addSample(int i9) {
        nativeAddSample(this.handle, i9);
    }
}
