package a6;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g implements Iterator {

    /* renamed from: j, reason: collision with root package name */
    public String f211j;

    /* renamed from: k, reason: collision with root package name */
    public final CharSequence f212k;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ a0.b f215n;

    /* renamed from: i, reason: collision with root package name */
    public int f210i = 2;

    /* renamed from: l, reason: collision with root package name */
    public int f213l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f214m = Integer.MAX_VALUE;

    public g(a0.b bVar, a0.b bVar2, CharSequence charSequence) {
        this.f215n = bVar;
        this.f212k = charSequence;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        String str;
        int i9 = this.f210i;
        if (i9 == 4) {
            androidx.fragment.app.a.l();
            return false;
        }
        int a9 = v.h.a(i9);
        if (a9 == 0) {
            return true;
        }
        if (a9 == 2) {
            return false;
        }
        this.f210i = 4;
        int i10 = this.f213l;
        while (true) {
            int i11 = this.f213l;
            if (i11 == -1) {
                this.f210i = 3;
                str = null;
                break;
            }
            a aVar = (a) this.f215n.f8j;
            CharSequence charSequence = this.f212k;
            int length = charSequence.length();
            com.bumptech.glide.c.g(i11, length);
            while (true) {
                if (i11 >= length) {
                    i11 = -1;
                    break;
                }
                if (aVar.a(charSequence.charAt(i11))) {
                    break;
                }
                i11++;
            }
            if (i11 == -1) {
                i11 = charSequence.length();
                this.f213l = -1;
            } else {
                this.f213l = i11 + 1;
            }
            int i12 = this.f213l;
            if (i12 == i10) {
                int i13 = i12 + 1;
                this.f213l = i13;
                if (i13 > charSequence.length()) {
                    this.f213l = -1;
                }
            } else {
                if (i10 < i11) {
                    charSequence.charAt(i10);
                }
                if (i11 > i10) {
                    charSequence.charAt(i11 - 1);
                }
                int i14 = this.f214m;
                if (i14 == 1) {
                    i11 = charSequence.length();
                    this.f213l = -1;
                    if (i11 > i10) {
                        charSequence.charAt(i11 - 1);
                    }
                } else {
                    this.f214m = i14 - 1;
                }
                str = charSequence.subSequence(i10, i11).toString();
            }
        }
        this.f211j = str;
        if (this.f210i == 3) {
            return false;
        }
        this.f210i = 1;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f210i = 2;
        String str = this.f211j;
        this.f211j = null;
        return str;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
