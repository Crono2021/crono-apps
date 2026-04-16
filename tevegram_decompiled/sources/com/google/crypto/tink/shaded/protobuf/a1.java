package com.google.crypto.tink.shaded.protobuf;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a1 {

    /* renamed from: c, reason: collision with root package name */
    public static final a1 f2198c = new a1();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f2200b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final n0 f2199a = new n0();

    public final d1 a(Class cls) {
        d1 B;
        Class cls2;
        c0.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.f2200b;
        d1 d1Var = (d1) concurrentHashMap.get(cls);
        if (d1Var != null) {
            return d1Var;
        }
        n0 n0Var = this.f2199a;
        n0Var.getClass();
        Class cls3 = e1.f2217a;
        if (!y.class.isAssignableFrom(cls) && (cls2 = e1.f2217a) != null && !cls2.isAssignableFrom(cls)) {
            m7.c.n("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
            return null;
        }
        c1 a9 = ((m0) n0Var.f2279a).a(cls);
        int i9 = a9.f2212d;
        a aVar = a9.f2209a;
        if ((i9 & 2) == 2) {
            if (y.class.isAssignableFrom(cls)) {
                B = new v0(e1.f2220d, s.f2296a, aVar);
            } else {
                h1 h1Var = e1.f2218b;
                r rVar = s.f2297b;
                if (rVar == null) {
                    m7.c.p("Protobuf runtime is not correctly loaded.");
                    return null;
                }
                B = new v0(h1Var, rVar, aVar);
            }
        } else if (y.class.isAssignableFrom(cls)) {
            B = (a9.f2212d & 1) == 1 ? u0.B(a9, x0.f2328b, k0.f2259b, e1.f2220d, s.f2296a, q0.f2294b) : u0.B(a9, x0.f2328b, k0.f2259b, e1.f2220d, null, q0.f2294b);
        } else if ((a9.f2212d & 1) == 1) {
            w0 w0Var = x0.f2327a;
            i0 i0Var = k0.f2258a;
            h1 h1Var2 = e1.f2218b;
            r rVar2 = s.f2297b;
            if (rVar2 == null) {
                m7.c.p("Protobuf runtime is not correctly loaded.");
                return null;
            }
            B = u0.B(a9, w0Var, i0Var, h1Var2, rVar2, q0.f2293a);
        } else {
            B = u0.B(a9, x0.f2327a, k0.f2258a, e1.f2219c, null, q0.f2293a);
        }
        d1 d1Var2 = (d1) concurrentHashMap.putIfAbsent(cls, B);
        return d1Var2 != null ? d1Var2 : B;
    }
}
