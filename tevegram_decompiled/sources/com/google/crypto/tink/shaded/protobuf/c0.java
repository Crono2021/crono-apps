package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f2207a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f2208b;

    static {
        Charset.forName("US-ASCII");
        f2207a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f2208b = bArr;
        ByteBuffer.wrap(bArr);
        m.h(bArr, 0, 0, false);
    }

    public static void a(Object obj, String str) {
        if (obj != null) {
            return;
        }
        m7.c.o(str);
    }

    public static int b(long j5) {
        return (int) (j5 ^ (j5 >>> 32));
    }
}
