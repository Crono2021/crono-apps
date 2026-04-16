package org.webrtc;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class EncodedImage implements RefCounted {
    public final ByteBuffer buffer;
    public final long captureTimeMs;
    public final long captureTimeNs;
    public final int encodedHeight;
    public final int encodedWidth;
    public final FrameType frameType;
    public final Integer qp;
    private final RefCountDelegate refCountDelegate;
    public final int rotation;

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public enum FrameType {
        EmptyFrame(0),
        VideoFrameKey(3),
        VideoFrameDelta(4);

        private final int nativeIndex;

        FrameType(int i9) {
            this.nativeIndex = i9;
        }

        @CalledByNative("FrameType")
        public static FrameType fromNativeIndex(int i9) {
            for (FrameType frameType : values()) {
                if (frameType.getNative() == i9) {
                    return frameType;
                }
            }
            m7.c.n(androidx.activity.g.m(i9, "Unknown native frame type: "));
            return null;
        }

        public int getNative() {
            return this.nativeIndex;
        }
    }

    @CalledByNative
    private EncodedImage(ByteBuffer byteBuffer, Runnable runnable, int i9, int i10, long j5, FrameType frameType, int i11, Integer num) {
        this.buffer = byteBuffer;
        this.encodedWidth = i9;
        this.encodedHeight = i10;
        this.captureTimeMs = j5 / 1000000;
        this.captureTimeNs = j5;
        this.frameType = frameType;
        this.rotation = i11;
        this.qp = num;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }

    public static Builder builder() {
        return new Builder(0);
    }

    @CalledByNative
    private ByteBuffer getBuffer() {
        return this.buffer;
    }

    @CalledByNative
    private long getCaptureTimeNs() {
        return this.captureTimeNs;
    }

    @CalledByNative
    private int getEncodedHeight() {
        return this.encodedHeight;
    }

    @CalledByNative
    private int getEncodedWidth() {
        return this.encodedWidth;
    }

    @CalledByNative
    private int getFrameType() {
        return this.frameType.getNative();
    }

    @CalledByNative
    private Integer getQp() {
        return this.qp;
    }

    @CalledByNative
    private int getRotation() {
        return this.rotation;
    }

    @Override // org.webrtc.RefCounted
    public void release() {
        this.refCountDelegate.release();
    }

    @Override // org.webrtc.RefCounted
    public void retain() {
        this.refCountDelegate.retain();
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static class Builder {
        private ByteBuffer buffer;
        private long captureTimeNs;
        private int encodedHeight;
        private int encodedWidth;
        private FrameType frameType;
        private Integer qp;
        private Runnable releaseCallback;
        private int rotation;

        public /* synthetic */ Builder(int i9) {
            this();
        }

        public EncodedImage createEncodedImage() {
            return new EncodedImage(this.buffer, this.releaseCallback, this.encodedWidth, this.encodedHeight, this.captureTimeNs, this.frameType, this.rotation, this.qp, 0);
        }

        public Builder setBuffer(ByteBuffer byteBuffer, Runnable runnable) {
            this.buffer = byteBuffer;
            this.releaseCallback = runnable;
            return this;
        }

        @Deprecated
        public Builder setCaptureTimeMs(long j5) {
            this.captureTimeNs = TimeUnit.MILLISECONDS.toNanos(j5);
            return this;
        }

        public Builder setCaptureTimeNs(long j5) {
            this.captureTimeNs = j5;
            return this;
        }

        public Builder setEncodedHeight(int i9) {
            this.encodedHeight = i9;
            return this;
        }

        public Builder setEncodedWidth(int i9) {
            this.encodedWidth = i9;
            return this;
        }

        public Builder setFrameType(FrameType frameType) {
            this.frameType = frameType;
            return this;
        }

        public Builder setQp(Integer num) {
            this.qp = num;
            return this;
        }

        public Builder setRotation(int i9) {
            this.rotation = i9;
            return this;
        }

        private Builder() {
        }
    }

    public /* synthetic */ EncodedImage(ByteBuffer byteBuffer, Runnable runnable, int i9, int i10, long j5, FrameType frameType, int i11, Integer num, int i12) {
        this(byteBuffer, runnable, i9, i10, j5, frameType, i11, num);
    }
}
