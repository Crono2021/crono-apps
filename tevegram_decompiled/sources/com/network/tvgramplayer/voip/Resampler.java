package com.network.tvgramplayer.voip;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class Resampler {
    public static native int convert44to48(ByteBuffer byteBuffer, ByteBuffer byteBuffer2);

    public static native int convert48to44(ByteBuffer byteBuffer, ByteBuffer byteBuffer2);
}
