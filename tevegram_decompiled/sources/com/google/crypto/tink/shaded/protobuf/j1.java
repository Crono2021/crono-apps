package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j1 implements Iterator {

    /* renamed from: i, reason: collision with root package name */
    public Iterator f2251i;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2251i.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.f2251i.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
