package com.google.crypto.tink.shaded.protobuf;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class w implements s0, Cloneable {

    /* renamed from: i, reason: collision with root package name */
    public final y f2325i;

    /* renamed from: j, reason: collision with root package name */
    public y f2326j;

    public w(y yVar) {
        this.f2325i = yVar;
        if (yVar.n()) {
            m7.c.n("Default instance must be immutable.");
            throw null;
        }
        this.f2326j = yVar.q();
    }

    public static void f(Object obj, Object obj2) {
        a1 a1Var = a1.f2198c;
        a1Var.getClass();
        a1Var.a(obj.getClass()).b(obj, obj2);
    }

    public final y b() {
        y c9 = c();
        c9.getClass();
        if (y.m(c9, true)) {
            return c9;
        }
        throw new f1();
    }

    public final y c() {
        boolean n4 = this.f2326j.n();
        y yVar = this.f2326j;
        if (!n4) {
            return yVar;
        }
        yVar.getClass();
        a1 a1Var = a1.f2198c;
        a1Var.getClass();
        a1Var.a(yVar.getClass()).e(yVar);
        yVar.o();
        return this.f2326j;
    }

    public final w d() {
        w d9 = this.f2325i.d();
        d9.f2326j = c();
        return d9;
    }

    public final void e() {
        if (this.f2326j.n()) {
            return;
        }
        y q4 = this.f2325i.q();
        f(q4, this.f2326j);
        this.f2326j = q4;
    }
}
