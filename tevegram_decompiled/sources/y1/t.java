package y1;

import d1.f1;
import g1.w;
import l1.c1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final int f10491a;

    /* renamed from: b, reason: collision with root package name */
    public final c1[] f10492b;

    /* renamed from: c, reason: collision with root package name */
    public final q[] f10493c;

    /* renamed from: d, reason: collision with root package name */
    public final f1 f10494d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f10495e;

    public t(c1[] c1VarArr, q[] qVarArr, f1 f1Var, s sVar) {
        this.f10492b = c1VarArr;
        this.f10493c = (q[]) qVarArr.clone();
        this.f10494d = f1Var;
        this.f10495e = sVar;
        this.f10491a = c1VarArr.length;
    }

    public final boolean a(t tVar, int i9) {
        return tVar != null && w.a(this.f10492b[i9], tVar.f10492b[i9]) && w.a(this.f10493c[i9], tVar.f10493c[i9]);
    }

    public final boolean b(int i9) {
        return this.f10492b[i9] != null;
    }
}
