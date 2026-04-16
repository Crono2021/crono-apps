package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class i extends j {

    /* renamed from: l, reason: collision with root package name */
    public final byte[] f2245l;

    public i(byte[] bArr) {
        this.f2250i = 0;
        bArr.getClass();
        this.f2245l = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j) || size() != ((j) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof i)) {
            return obj.equals(this);
        }
        i iVar = (i) obj;
        int i9 = this.f2250i;
        int i10 = iVar.f2250i;
        if (i9 != 0 && i10 != 0 && i9 != i10) {
            return false;
        }
        int size = size();
        if (size > iVar.size()) {
            throw new IllegalArgumentException("Length too large: " + size + size());
        }
        if (size > iVar.size()) {
            StringBuilder p5 = androidx.activity.g.p(size, "Ran off end of other: 0, ", ", ");
            p5.append(iVar.size());
            throw new IllegalArgumentException(p5.toString());
        }
        byte[] bArr = iVar.f2245l;
        int k3 = k() + size;
        int k9 = k();
        int k10 = iVar.k();
        while (k9 < k3) {
            if (this.f2245l[k9] != bArr[k10]) {
                return false;
            }
            k9++;
            k10++;
        }
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.j
    public byte f(int i9) {
        return this.f2245l[i9];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.j
    public void i(byte[] bArr, int i9) {
        System.arraycopy(this.f2245l, 0, bArr, 0, i9);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new f(this);
    }

    public int k() {
        return 0;
    }

    public byte l(int i9) {
        return this.f2245l[i9];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.j
    public int size() {
        return this.f2245l.length;
    }
}
