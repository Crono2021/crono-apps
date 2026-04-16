package h8;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements Iterator {

    /* renamed from: i, reason: collision with root package name */
    public final String f4228i;

    /* renamed from: j, reason: collision with root package name */
    public int f4229j;

    /* renamed from: k, reason: collision with root package name */
    public int f4230k;

    /* renamed from: l, reason: collision with root package name */
    public int f4231l;

    /* renamed from: m, reason: collision with root package name */
    public int f4232m;

    public d(String str) {
        this.f4228i = str;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i9;
        int i10;
        int i11 = this.f4229j;
        if (i11 != 0) {
            return i11 == 1;
        }
        if (this.f4232m < 0) {
            this.f4229j = 2;
            return false;
        }
        String str = this.f4228i;
        int length = str.length();
        int length2 = str.length();
        for (int i12 = this.f4230k; i12 < length2; i12++) {
            char charAt = str.charAt(i12);
            if (charAt == '\n' || charAt == '\r') {
                i9 = (charAt == '\r' && (i10 = i12 + 1) < str.length() && str.charAt(i10) == '\n') ? 2 : 1;
                length = i12;
                this.f4229j = 1;
                this.f4232m = i9;
                this.f4231l = length;
                return true;
            }
        }
        i9 = -1;
        this.f4229j = 1;
        this.f4232m = i9;
        this.f4231l = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f4229j = 0;
        int i9 = this.f4231l;
        int i10 = this.f4230k;
        this.f4230k = this.f4232m + i9;
        return this.f4228i.subSequence(i10, i9).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
