package com.google.crypto.tink.shaded.protobuf;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g0 extends b implements h0, RandomAccess {

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f2236j;

    static {
        new g0(10).f2201i = false;
    }

    public g0(int i9) {
        this(new ArrayList(i9));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0
    public final b0 a(int i9) {
        ArrayList arrayList = this.f2236j;
        if (i9 < arrayList.size()) {
            m7.c.d();
            return null;
        }
        ArrayList arrayList2 = new ArrayList(i9);
        arrayList2.addAll(arrayList);
        return new g0(arrayList2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i9, Object obj) {
        f();
        this.f2236j.add(i9, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b, java.util.AbstractList, java.util.List
    public final boolean addAll(int i9, Collection collection) {
        f();
        if (collection instanceof h0) {
            collection = ((h0) collection).e();
        }
        boolean addAll = this.f2236j.addAll(i9, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h0
    public final void b(j jVar) {
        f();
        this.f2236j.add(jVar);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h0
    public final h0 c() {
        return this.f2201i ? new k1(this) : this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        f();
        this.f2236j.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h0
    public final Object d(int i9) {
        return this.f2236j.get(i9);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h0
    public final List e() {
        return Collections.unmodifiableList(this.f2236j);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i9) {
        String str;
        ArrayList arrayList = this.f2236j;
        Object obj = arrayList.get(i9);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof j)) {
            byte[] bArr = (byte[]) obj;
            String str2 = new String(bArr, c0.f2207a);
            if (s1.f2298a.G(0, bArr.length, bArr)) {
                arrayList.set(i9, str2);
            }
            return str2;
        }
        j jVar = (j) obj;
        Charset charset = c0.f2207a;
        if (jVar.size() == 0) {
            str = "";
        } else {
            i iVar = (i) jVar;
            str = new String(iVar.f2245l, iVar.k(), iVar.size(), charset);
        }
        i iVar2 = (i) jVar;
        int k3 = iVar2.k();
        byte[] bArr2 = iVar2.f2245l;
        if (s1.f2298a.G(k3, iVar2.size() + k3, bArr2)) {
            arrayList.set(i9, str);
        }
        return str;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b, java.util.AbstractList, java.util.List
    public final Object remove(int i9) {
        f();
        Object remove = this.f2236j.remove(i9);
        ((AbstractList) this).modCount++;
        if (remove instanceof String) {
            return (String) remove;
        }
        if (!(remove instanceof j)) {
            return new String((byte[]) remove, c0.f2207a);
        }
        j jVar = (j) remove;
        Charset charset = c0.f2207a;
        if (jVar.size() == 0) {
            return "";
        }
        i iVar = (i) jVar;
        return new String(iVar.f2245l, iVar.k(), iVar.size(), charset);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i9, Object obj) {
        f();
        Object obj2 = this.f2236j.set(i9, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (!(obj2 instanceof j)) {
            return new String((byte[]) obj2, c0.f2207a);
        }
        j jVar = (j) obj2;
        Charset charset = c0.f2207a;
        if (jVar.size() == 0) {
            return "";
        }
        i iVar = (i) jVar;
        return new String(iVar.f2245l, iVar.k(), iVar.size(), charset);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2236j.size();
    }

    public g0(ArrayList arrayList) {
        this.f2236j = arrayList;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.f2236j.size(), collection);
    }
}
