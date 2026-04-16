package org.webrtc;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class MediaStreamTrack {
    public static final String AUDIO_TRACK_KIND = "audio";
    public static final String VIDEO_TRACK_KIND = "video";
    private long nativeTrack;

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public enum MediaType {
        MEDIA_TYPE_AUDIO(0),
        MEDIA_TYPE_VIDEO(1);

        private final int nativeIndex;

        MediaType(int i9) {
            this.nativeIndex = i9;
        }

        @CalledByNative("MediaType")
        public static MediaType fromNativeIndex(int i9) {
            for (MediaType mediaType : values()) {
                if (mediaType.getNative() == i9) {
                    return mediaType;
                }
            }
            m7.c.n(androidx.activity.g.m(i9, "Unknown native media type: "));
            return null;
        }

        @CalledByNative("MediaType")
        public int getNative() {
            return this.nativeIndex;
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public enum State {
        LIVE,
        ENDED;

        @CalledByNative("State")
        public static State fromNativeIndex(int i9) {
            return values()[i9];
        }
    }

    public MediaStreamTrack(long j5) {
        if (j5 != 0) {
            this.nativeTrack = j5;
        } else {
            m7.c.n("nativeTrack may not be null");
            throw null;
        }
    }

    private void checkMediaStreamTrackExists() {
        if (this.nativeTrack != 0) {
            return;
        }
        m7.c.p("MediaStreamTrack has been disposed.");
    }

    public static MediaStreamTrack createMediaStreamTrack(long j5) {
        if (j5 == 0) {
            return null;
        }
        String nativeGetKind = nativeGetKind(j5);
        if (nativeGetKind.equals("audio")) {
            return new AudioTrack(j5);
        }
        if (nativeGetKind.equals("video")) {
            return new VideoTrack(j5);
        }
        return null;
    }

    private static native boolean nativeGetEnabled(long j5);

    private static native String nativeGetId(long j5);

    private static native String nativeGetKind(long j5);

    private static native State nativeGetState(long j5);

    private static native boolean nativeSetEnabled(long j5, boolean z8);

    public void dispose() {
        checkMediaStreamTrackExists();
        JniCommon.nativeReleaseRef(this.nativeTrack);
        this.nativeTrack = 0L;
    }

    public boolean enabled() {
        checkMediaStreamTrackExists();
        return nativeGetEnabled(this.nativeTrack);
    }

    public long getNativeMediaStreamTrack() {
        checkMediaStreamTrackExists();
        return this.nativeTrack;
    }

    public String id() {
        checkMediaStreamTrackExists();
        return nativeGetId(this.nativeTrack);
    }

    public String kind() {
        checkMediaStreamTrackExists();
        return nativeGetKind(this.nativeTrack);
    }

    public boolean setEnabled(boolean z8) {
        checkMediaStreamTrackExists();
        return nativeSetEnabled(this.nativeTrack, z8);
    }

    public State state() {
        checkMediaStreamTrackExists();
        return nativeGetState(this.nativeTrack);
    }
}
