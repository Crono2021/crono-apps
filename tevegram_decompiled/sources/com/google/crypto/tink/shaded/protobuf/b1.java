package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b1 extends b implements RandomAccess {

    /* renamed from: l, reason: collision with root package name */
    public static final b1 f2202l;

    /* renamed from: j, reason: collision with root package name */
    public Object[] f2203j;

    /* renamed from: k, reason: collision with root package name */
    public int f2204k;

    static {
        b1 b1Var = new b1(0, new Object[0]);
        f2202l = b1Var;
        b1Var.f2201i = false;
    }

    public b1(int i9, Object[] objArr) {
        this.f2203j = objArr;
        this.f2204k = i9;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0
    public final b0 a(int i9) {
        if (i9 >= this.f2204k) {
            return new b1(this.f2204k, Arrays.copyOf(this.f2203j, i9));
        }
        m7.c.d();
        return null;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i9, Object obj) {
        int i10;
        f();
        if (i9 < 0 || i9 > (i10 = this.f2204k)) {
            StringBuilder p5 = androidx.activity.g.p(i9, "Index:", ", Size:");
            p5.append(this.f2204k);
            throw new IndexOutOfBoundsException(p5.toString());
        }
        Object[] objArr = this.f2203j;
        if (i10 < objArr.length) {
            System.arraycopy(objArr, i9, objArr, i9 + 1, i10 - i9);
        } else {
            Object[] objArr2 = new Object[((i10 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i9);
            System.arraycopy(this.f2203j, i9, objArr2, i9 + 1, this.f2204k - i9);
            this.f2203j = objArr2;
        }
        this.f2203j[i9] = obj;
        this.f2204k++;
        ((AbstractList) this).modCount++;
    }

    public final void g(int i9) {
        if (i9 < 0 || i9 >= this.f2204k) {
            StringBuilder p5 = androidx.activity.g.p(i9, "Index:", ", Size:");
            p5.append(this.f2204k);
            throw new IndexOutOfBoundsException(p5.toString());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i9) {
        g(i9);
        return this.f2203j[i9];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b, java.util.AbstractList, java.util.List
    public final Object remove(int i9) {
        f();
        g(i9);
        Object[] objArr = this.f2203j;
        Object obj = objArr[i9];
        if (i9 < this.f2204k - 1) {
            System.arraycopy(objArr, i9 + 1, objArr, i9, (r2 - i9) - 1);
        }
        this.f2204k--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i9, Object obj) {
        f();
        g(i9);
        Object[] objArr = this.f2203j;
        Object obj2 = objArr[i9];
        objArr[i9] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2204k;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        f();
        int i9 = this.f2204k;
        Object[] objArr = this.f2203j;
        if (i9 == objArr.length) {
            this.f2203j = Arrays.copyOf(objArr, ((i9 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f2203j;
        int i10 = this.f2204k;
        this.f2204k = i10 + 1;
        objArr2[i10] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
