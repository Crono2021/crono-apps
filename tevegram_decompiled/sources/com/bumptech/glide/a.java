package com.bumptech.glide;

import w4.n;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements Cloneable {

    /* renamed from: i, reason: collision with root package name */
    public u4.a f1728i;

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e9) {
            throw new RuntimeException(e9);
        }
    }

    public final boolean b(Object obj) {
        if (obj instanceof a) {
            return n.b(this.f1728i, ((a) obj).f1728i);
        }
        return false;
    }

    public final int c() {
        u4.a aVar = this.f1728i;
        if (aVar != null) {
            return aVar.hashCode();
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b(obj);
    }

    public final int hashCode() {
        return c();
    }
}
