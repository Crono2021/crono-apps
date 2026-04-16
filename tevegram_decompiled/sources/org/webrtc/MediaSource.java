package org.webrtc;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class MediaSource {
    private long nativeSource;
    private final RefCountDelegate refCountDelegate;

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public enum State {
        INITIALIZING,
        LIVE,
        ENDED,
        MUTED;

        @CalledByNative("State")
        public static State fromNativeIndex(int i9) {
            return values()[i9];
        }
    }

    public MediaSource(final long j5) {
        this.refCountDelegate = new RefCountDelegate(new Runnable() { // from class: org.webrtc.i
            @Override // java.lang.Runnable
            public final void run() {
                JniCommon.nativeReleaseRef(j5);
            }
        });
        this.nativeSource = j5;
    }

    private void checkMediaSourceExists() {
        if (this.nativeSource != 0) {
            return;
        }
        m7.c.p("MediaSource has been disposed.");
    }

    private static native State nativeGetState(long j5);

    public void dispose() {
        checkMediaSourceExists();
        this.refCountDelegate.release();
        this.nativeSource = 0L;
    }

    public long getNativeMediaSource() {
        checkMediaSourceExists();
        return this.nativeSource;
    }

    public void runWithReference(Runnable runnable) {
        if (this.refCountDelegate.safeRetain()) {
            try {
                runnable.run();
            } finally {
                this.refCountDelegate.release();
            }
        }
    }

    public State state() {
        checkMediaSourceExists();
        return nativeGetState(this.nativeSource);
    }
}
