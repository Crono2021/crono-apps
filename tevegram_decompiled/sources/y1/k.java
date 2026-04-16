package y1;

import b6.g0;
import b6.u0;
import b6.y;
import d1.z0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k extends m implements Comparable {

    /* renamed from: m, reason: collision with root package name */
    public final int f10446m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f10447n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f10448o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f10449p;

    /* renamed from: q, reason: collision with root package name */
    public final int f10450q;

    /* renamed from: r, reason: collision with root package name */
    public final int f10451r;

    /* renamed from: s, reason: collision with root package name */
    public final int f10452s;

    /* renamed from: t, reason: collision with root package name */
    public final int f10453t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f10454u;

    public k(int i9, z0 z0Var, int i10, i iVar, int i11, String str) {
        super(i9, z0Var, i10);
        int i12;
        int i13 = 0;
        this.f10447n = o.d(i11, false);
        int i14 = this.f10458l.f2547e;
        int i15 = iVar.f2404p;
        g0 g0Var = iVar.f2402n;
        int i16 = i14 & (~i15);
        this.f10448o = (i16 & 1) != 0;
        this.f10449p = (i16 & 2) != 0;
        g0 q4 = g0Var.isEmpty() ? g0.q("") : g0Var;
        int i17 = 0;
        while (true) {
            if (i17 >= q4.size()) {
                i17 = Integer.MAX_VALUE;
                i12 = 0;
                break;
            } else {
                i12 = o.b(this.f10458l, (String) q4.get(i17), iVar.f2405q);
                if (i12 > 0) {
                    break;
                } else {
                    i17++;
                }
            }
        }
        this.f10450q = i17;
        this.f10451r = i12;
        int i18 = this.f10458l.f2548f;
        int i19 = iVar.f2403o;
        int bitCount = (i18 == 0 || i18 != i19) ? Integer.bitCount(i18 & i19) : Integer.MAX_VALUE;
        this.f10452s = bitCount;
        this.f10454u = (this.f10458l.f2548f & 1088) != 0;
        int b9 = o.b(this.f10458l, str, o.f(str) == null);
        this.f10453t = b9;
        boolean z8 = i12 > 0 || (g0Var.isEmpty() && bitCount > 0) || this.f10448o || (this.f10449p && b9 > 0);
        if (o.d(i11, iVar.f10443y) && z8) {
            i13 = 1;
        }
        this.f10446m = i13;
    }

    @Override // y1.m
    public final int a() {
        return this.f10446m;
    }

    @Override // y1.m
    public final /* bridge */ /* synthetic */ boolean b(m mVar) {
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final int compareTo(k kVar) {
        y c9 = y.f1469a.c(this.f10447n, kVar.f10447n);
        Integer valueOf = Integer.valueOf(this.f10450q);
        Integer valueOf2 = Integer.valueOf(kVar.f10450q);
        u0 u0Var = u0.f1460j;
        u0 u0Var2 = u0.f1461k;
        y b9 = c9.b(valueOf, valueOf2, u0Var2);
        int i9 = kVar.f10451r;
        int i10 = this.f10451r;
        y a9 = b9.a(i10, i9);
        int i11 = kVar.f10452s;
        int i12 = this.f10452s;
        y c10 = a9.a(i12, i11).c(this.f10448o, kVar.f10448o);
        Boolean valueOf3 = Boolean.valueOf(this.f10449p);
        Boolean valueOf4 = Boolean.valueOf(kVar.f10449p);
        if (i10 != 0) {
            u0Var = u0Var2;
        }
        y a10 = c10.b(valueOf3, valueOf4, u0Var).a(this.f10453t, kVar.f10453t);
        if (i12 == 0) {
            a10 = a10.d(this.f10454u, kVar.f10454u);
        }
        return a10.e();
    }
}
