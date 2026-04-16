package n1;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t0 {

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f7359d = {79, 103, 103, 83, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, -43, -59, -9, 1, 19, 79, 112, 117, 115, 72, 101, 97, 100, 1, 2, 56, 1, Byte.MIN_VALUE, -69, 0, 0, 0, 0, 0};

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f7360e = {79, 103, 103, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 11, -103, 87, 83, 1, 16, 79, 112, 117, 115, 84, 97, 103, 115, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f7361a;

    /* renamed from: b, reason: collision with root package name */
    public int f7362b;

    /* renamed from: c, reason: collision with root package name */
    public int f7363c;

    public static void a(ByteBuffer byteBuffer, long j5, int i9, int i10, boolean z8) {
        byteBuffer.put((byte) 79);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 83);
        byteBuffer.put((byte) 0);
        byteBuffer.put(z8 ? (byte) 2 : (byte) 0);
        byteBuffer.putLong(j5);
        byteBuffer.putInt(0);
        byteBuffer.putInt(i9);
        byteBuffer.putInt(0);
        long j9 = i10;
        com.bumptech.glide.c.e(j9, "out of range: %s", (j9 >> 8) == 0);
        byteBuffer.put((byte) j9);
    }
}
