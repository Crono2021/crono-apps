package com.google.crypto.tink.shaded.protobuf;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c1 {

    /* renamed from: a, reason: collision with root package name */
    public final a f2209a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2210b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f2211c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2212d;

    public c1(a aVar, String str, Object[] objArr) {
        this.f2209a = aVar;
        this.f2210b = str;
        this.f2211c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f2212d = charAt;
            return;
        }
        int i9 = charAt & 8191;
        int i10 = 13;
        int i11 = 1;
        while (true) {
            int i12 = i11 + 1;
            char charAt2 = str.charAt(i11);
            if (charAt2 < 55296) {
                this.f2212d = i9 | (charAt2 << i10);
                return;
            } else {
                i9 |= (charAt2 & 8191) << i10;
                i10 += 13;
                i11 = i12;
            }
        }
    }
}
