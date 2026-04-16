package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f implements Iterator {

    /* renamed from: i, reason: collision with root package name */
    public int f2221i = 0;

    /* renamed from: j, reason: collision with root package name */
    public final int f2222j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ i f2223k;

    public f(i iVar) {
        this.f2223k = iVar;
        this.f2222j = iVar.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2221i < this.f2222j;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i9 = this.f2221i;
        if (i9 >= this.f2222j) {
            throw new NoSuchElementException();
        }
        this.f2221i = i9 + 1;
        return Byte.valueOf(this.f2223k.l(i9));
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
