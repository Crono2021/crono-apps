package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class e0 extends IOException {

    /* renamed from: i, reason: collision with root package name */
    public boolean f2216i;

    public static e0 a() {
        return new e0("Protocol message contained an invalid tag (zero).");
    }

    public static e0 b() {
        return new e0("Protocol message had invalid UTF-8.");
    }

    public static d0 c() {
        return new d0("Protocol message tag had invalid wire type.");
    }

    public static e0 d() {
        return new e0("CodedInputStream encountered a malformed varint.");
    }

    public static e0 e() {
        return new e0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static e0 f() {
        return new e0("Failed to parse the message.");
    }

    public static e0 g() {
        return new e0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
