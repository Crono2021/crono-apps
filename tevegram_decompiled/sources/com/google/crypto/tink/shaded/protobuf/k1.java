package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k1 extends AbstractList implements h0, RandomAccess {

    /* renamed from: i, reason: collision with root package name */
    public final g0 f2260i;

    public k1(g0 g0Var) {
        this.f2260i = g0Var;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h0
    public final void b(j jVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h0
    public final Object d(int i9) {
        return this.f2260i.f2236j.get(i9);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h0
    public final List e() {
        return Collections.unmodifiableList(this.f2260i.f2236j);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i9) {
        return (String) this.f2260i.get(i9);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        j1 j1Var = new j1();
        j1Var.f2251i = this.f2260i.iterator();
        return j1Var;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i9) {
        i1 i1Var = new i1();
        i1Var.f2247i = this.f2260i.listIterator(i9);
        return i1Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2260i.size();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h0
    public final h0 c() {
        return this;
    }
}
