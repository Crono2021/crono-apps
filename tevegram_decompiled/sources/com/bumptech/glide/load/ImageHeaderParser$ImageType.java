package com.bumptech.glide.load;

import b4.d;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public enum ImageHeaderParser$ImageType {
    GIF(true),
    JPEG(false),
    RAW(false),
    PNG_A(true),
    PNG(false),
    WEBP_A(true),
    WEBP(false),
    ANIMATED_WEBP(true),
    AVIF(true),
    ANIMATED_AVIF(true),
    UNKNOWN(false);


    /* renamed from: i, reason: collision with root package name */
    public final boolean f1787i;

    ImageHeaderParser$ImageType(boolean z8) {
        this.f1787i = z8;
    }

    public boolean hasAlpha() {
        return this.f1787i;
    }

    public boolean isWebp() {
        int i9 = d.f1324a[ordinal()];
        return i9 == 1 || i9 == 2 || i9 == 3;
    }
}
