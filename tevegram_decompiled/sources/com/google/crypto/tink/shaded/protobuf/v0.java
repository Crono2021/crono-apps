package com.google.crypto.tink.shaded.protobuf;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v0 implements d1 {

    /* renamed from: a, reason: collision with root package name */
    public final a f2322a;

    /* renamed from: b, reason: collision with root package name */
    public final h1 f2323b;

    /* renamed from: c, reason: collision with root package name */
    public final r f2324c;

    public v0(h1 h1Var, r rVar, a aVar) {
        this.f2323b = h1Var;
        rVar.getClass();
        this.f2324c = rVar;
        this.f2322a = aVar;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.d1
    public final int a(y yVar) {
        this.f2323b.getClass();
        g1 g1Var = yVar.unknownFields;
        int i9 = g1Var.f2241d;
        if (i9 != -1) {
            return i9;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < g1Var.f2238a; i11++) {
            int i12 = g1Var.f2239b[i11] >>> 3;
            j jVar = (j) g1Var.f2240c[i11];
            i10 += n.a(3, jVar) + n.i(i12) + n.h(2) + (n.h(1) * 2);
        }
        g1Var.f2241d = i10;
        return i10;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.d1
    public final void b(Object obj, Object obj2) {
        e1.w(this.f2323b, obj, obj2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.d1
    public final void c(Object obj, byte[] bArr, int i9, int i10, d dVar) {
        y yVar = (y) obj;
        if (yVar.unknownFields == g1.f2237f) {
            yVar.unknownFields = g1.c();
        }
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.d1
    public final void d(Object obj, a5.k kVar, q qVar) {
        this.f2323b.getClass();
        h1.a(obj);
        this.f2324c.getClass();
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.d1
    public final void e(Object obj) {
        this.f2323b.getClass();
        ((y) obj).unknownFields.f2242e = false;
        this.f2324c.getClass();
        androidx.activity.g.w(obj);
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.d1
    public final boolean f(Object obj) {
        this.f2324c.getClass();
        androidx.activity.g.w(obj);
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.d1
    public final boolean g(y yVar, y yVar2) {
        this.f2323b.getClass();
        return yVar.unknownFields.equals(yVar2.unknownFields);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.d1
    public final void h(Object obj, n0 n0Var) {
        this.f2324c.getClass();
        androidx.activity.g.w(obj);
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.d1
    public final Object i() {
        a aVar = this.f2322a;
        return aVar instanceof y ? ((y) aVar).q() : aVar.d().c();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.d1
    public final int j(y yVar) {
        this.f2323b.getClass();
        return yVar.unknownFields.hashCode();
    }
}
