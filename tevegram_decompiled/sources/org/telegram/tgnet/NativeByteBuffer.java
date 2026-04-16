package org.telegram.tgnet;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class NativeByteBuffer {
    public static native long native_getFreeBuffer(int i9);

    public static native ByteBuffer native_getJavaByteBuffer(long j5);

    public static native int native_limit(long j5);

    public static native int native_position(long j5);

    public static native void native_reuse(long j5);
}
