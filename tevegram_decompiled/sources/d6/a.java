package d6;

import com.bumptech.glide.c;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends AbstractList implements RandomAccess, Serializable {

    /* renamed from: i, reason: collision with root package name */
    public final int[] f2961i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2962j;

    /* renamed from: k, reason: collision with root package name */
    public final int f2963k;

    public a(int i9, int i10, int[] iArr) {
        this.f2961i = iArr;
        this.f2962j = i9;
        this.f2963k = i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof Integer) {
            return a.a.z(this.f2961i, ((Integer) obj).intValue(), this.f2962j, this.f2963k) != -1;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return super.equals(obj);
        }
        a aVar = (a) obj;
        int size = size();
        if (aVar.size() != size) {
            return false;
        }
        for (int i9 = 0; i9 < size; i9++) {
            if (this.f2961i[this.f2962j + i9] != aVar.f2961i[aVar.f2962j + i9]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i9) {
        c.f(i9, size());
        return Integer.valueOf(this.f2961i[this.f2962j + i9]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i9 = 1;
        for (int i10 = this.f2962j; i10 < this.f2963k; i10++) {
            i9 = (i9 * 31) + this.f2961i[i10];
        }
        return i9;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int i9 = this.f2963k;
        int[] iArr = this.f2961i;
        int i10 = this.f2962j;
        int z8 = a.a.z(iArr, intValue, i10, i9);
        if (z8 >= 0) {
            return z8 - i10;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int i9;
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            int i10 = this.f2963k;
            while (true) {
                i10--;
                i9 = this.f2962j;
                if (i10 < i9) {
                    i10 = -1;
                    break;
                }
                if (this.f2961i[i10] == intValue) {
                    break;
                }
            }
            if (i10 >= 0) {
                return i10 - i9;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i9, Object obj) {
        Integer num = (Integer) obj;
        c.f(i9, size());
        int i10 = this.f2962j + i9;
        int[] iArr = this.f2961i;
        int i11 = iArr[i10];
        num.getClass();
        iArr[i10] = num.intValue();
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2963k - this.f2962j;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i9, int i10) {
        c.h(i9, i10, size());
        if (i9 == i10) {
            return Collections.EMPTY_LIST;
        }
        int i11 = this.f2962j;
        return new a(i9 + i11, i11 + i10, this.f2961i);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder(size() * 5);
        sb.append('[');
        int[] iArr = this.f2961i;
        int i9 = this.f2962j;
        sb.append(iArr[i9]);
        while (true) {
            i9++;
            if (i9 >= this.f2963k) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(iArr[i9]);
        }
    }
}
