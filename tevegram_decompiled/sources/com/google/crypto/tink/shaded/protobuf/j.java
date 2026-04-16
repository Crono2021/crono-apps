package com.google.crypto.tink.shaded.protobuf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class j implements Iterable, Serializable {

    /* renamed from: j, reason: collision with root package name */
    public static final i f2248j = new i(c0.f2208b);

    /* renamed from: k, reason: collision with root package name */
    public static final g f2249k;

    /* renamed from: i, reason: collision with root package name */
    public int f2250i;

    static {
        f2249k = c.a() ? new g(1) : new g(0);
    }

    public static int g(int i9, int i10, int i11) {
        int i12 = i10 - i9;
        if ((i9 | i10 | i12 | (i11 - i10)) >= 0) {
            return i12;
        }
        if (i9 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i9 + " < 0");
        }
        if (i10 < i9) {
            m7.c.h(", ", "Beginning index larger than ending index: ", i9, i10);
            return 0;
        }
        m7.c.h(" >= ", "End index: ", i10, i11);
        return 0;
    }

    public static i h(int i9, int i10, byte[] bArr) {
        byte[] copyOfRange;
        g(i9, i9 + i10, bArr.length);
        switch (f2249k.f2235a) {
            case 0:
                copyOfRange = Arrays.copyOfRange(bArr, i9, i10 + i9);
                break;
            default:
                copyOfRange = new byte[i10];
                System.arraycopy(bArr, i9, copyOfRange, 0, i10);
                break;
        }
        return new i(copyOfRange);
    }

    public abstract byte f(int i9);

    public final int hashCode() {
        int i9 = this.f2250i;
        if (i9 != 0) {
            return i9;
        }
        int size = size();
        i iVar = (i) this;
        int k3 = iVar.k();
        int i10 = size;
        for (int i11 = k3; i11 < k3 + size; i11++) {
            i10 = (i10 * 31) + iVar.f2245l[i11];
        }
        if (i10 == 0) {
            i10 = 1;
        }
        this.f2250i = i10;
        return i10;
    }

    public abstract void i(byte[] bArr, int i9);

    public final byte[] j() {
        int size = size();
        if (size == 0) {
            return c0.f2208b;
        }
        byte[] bArr = new byte[size];
        i(bArr, size);
        return bArr;
    }

    public abstract int size();

    public final String toString() {
        i hVar;
        String concat;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            concat = a.a.s(this);
        } else {
            i iVar = (i) this;
            int g9 = g(0, 47, iVar.size());
            if (g9 == 0) {
                hVar = f2248j;
            } else {
                hVar = new h(iVar.k(), g9, iVar.f2245l);
            }
            concat = a.a.s(hVar).concat("...");
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(size);
        sb.append(" contents=\"");
        return androidx.activity.g.o(sb, concat, "\">");
    }
}
