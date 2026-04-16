package com.google.crypto.tink.shaded.protobuf;

import java.nio.charset.Charset;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n0 {

    /* renamed from: b, reason: collision with root package name */
    public static final v f2278b = new v(1);

    /* renamed from: a, reason: collision with root package name */
    public final Object f2279a;

    public n0() {
        r0 r0Var;
        try {
            r0Var = (r0) Class.forName("com.google.crypto.tink.shaded.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            r0Var = f2278b;
        }
        r0[] r0VarArr = {v.f2320b, r0Var};
        m0 m0Var = new m0();
        m0Var.f2270a = r0VarArr;
        Charset charset = c0.f2207a;
        this.f2279a = m0Var;
    }

    public void a(int i9, j jVar) {
        n nVar = (n) this.f2279a;
        nVar.r(i9, 2);
        nVar.s(jVar.size());
        i iVar = (i) jVar;
        nVar.l(iVar.f2245l, iVar.k(), iVar.size());
    }

    public void b(int i9, Object obj, d1 d1Var) {
        n nVar = (n) this.f2279a;
        nVar.r(i9, 3);
        d1Var.h((a) obj, nVar.f2274a);
        nVar.r(i9, 4);
    }

    public void c(int i9, Object obj, d1 d1Var) {
        n nVar = (n) this.f2279a;
        a aVar = (a) obj;
        nVar.r(i9, 2);
        nVar.s(aVar.b(d1Var));
        d1Var.h(aVar, nVar.f2274a);
    }

    public n0(n nVar) {
        c0.a(nVar, "output");
        this.f2279a = nVar;
        nVar.f2274a = this;
    }
}
