package d1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class c1 {

    /* renamed from: a, reason: collision with root package name */
    public int f2372a = Integer.MAX_VALUE;

    /* renamed from: b, reason: collision with root package name */
    public int f2373b = Integer.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public int f2374c = Integer.MAX_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public int f2375d = Integer.MAX_VALUE;

    /* renamed from: e, reason: collision with root package name */
    public int f2376e = Integer.MAX_VALUE;

    /* renamed from: f, reason: collision with root package name */
    public int f2377f = Integer.MAX_VALUE;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2378g = true;
    public b6.g0 h;

    /* renamed from: i, reason: collision with root package name */
    public b6.g0 f2379i;

    /* renamed from: j, reason: collision with root package name */
    public int f2380j;

    /* renamed from: k, reason: collision with root package name */
    public int f2381k;

    /* renamed from: l, reason: collision with root package name */
    public b6.g0 f2382l;

    /* renamed from: m, reason: collision with root package name */
    public b1 f2383m;

    /* renamed from: n, reason: collision with root package name */
    public b6.g0 f2384n;

    /* renamed from: o, reason: collision with root package name */
    public int f2385o;

    /* renamed from: p, reason: collision with root package name */
    public int f2386p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2387q;

    /* renamed from: r, reason: collision with root package name */
    public HashMap f2388r;

    /* renamed from: s, reason: collision with root package name */
    public HashSet f2389s;

    public c1() {
        b6.e0 e0Var = b6.g0.f1391j;
        b6.w0 w0Var = b6.w0.f1464m;
        this.h = w0Var;
        this.f2379i = w0Var;
        this.f2380j = Integer.MAX_VALUE;
        this.f2381k = Integer.MAX_VALUE;
        this.f2382l = w0Var;
        this.f2383m = b1.f2366a;
        this.f2384n = w0Var;
        this.f2385o = 0;
        this.f2386p = 0;
        this.f2387q = false;
        this.f2388r = new HashMap();
        this.f2389s = new HashSet();
    }

    public static b6.w0 d(String[] strArr) {
        b6.e0 e0Var = b6.g0.f1391j;
        b6.q.b(4, "initialCapacity");
        Object[] objArr = new Object[4];
        int length = strArr.length;
        int i9 = 0;
        int i10 = 0;
        boolean z8 = false;
        while (i9 < length) {
            String str = strArr[i9];
            str.getClass();
            String N = g1.w.N(str);
            N.getClass();
            int i11 = i10 + 1;
            if (objArr.length < i11) {
                objArr = Arrays.copyOf(objArr, b6.a0.d(objArr.length, i11));
            } else if (z8) {
                objArr = (Object[]) objArr.clone();
            } else {
                objArr[i10] = N;
                i9++;
                i10++;
            }
            z8 = false;
            objArr[i10] = N;
            i9++;
            i10++;
        }
        return b6.g0.l(i10, objArr);
    }

    public d1 a() {
        return new d1(this);
    }

    public c1 b(int i9) {
        Iterator it = this.f2388r.values().iterator();
        while (it.hasNext()) {
            if (((a1) it.next()).f2353a.f2618c == i9) {
                it.remove();
            }
        }
        return this;
    }

    public final void c(d1 d1Var) {
        this.f2372a = d1Var.f2390a;
        this.f2373b = d1Var.f2391b;
        this.f2374c = d1Var.f2392c;
        this.f2375d = d1Var.f2393d;
        this.f2376e = d1Var.f2394e;
        this.f2377f = d1Var.f2395f;
        this.f2378g = d1Var.f2396g;
        this.h = d1Var.h;
        this.f2379i = d1Var.f2397i;
        this.f2380j = d1Var.f2398j;
        this.f2381k = d1Var.f2399k;
        this.f2382l = d1Var.f2400l;
        this.f2383m = d1Var.f2401m;
        this.f2384n = d1Var.f2402n;
        this.f2385o = d1Var.f2403o;
        this.f2386p = d1Var.f2404p;
        this.f2387q = d1Var.f2405q;
        this.f2389s = new HashSet(d1Var.f2407s);
        this.f2388r = new HashMap(d1Var.f2406r);
    }

    public c1 e() {
        this.f2386p = -3;
        return this;
    }

    public c1 f(a1 a1Var) {
        z0 z0Var = a1Var.f2353a;
        b(z0Var.f2618c);
        this.f2388r.put(z0Var, a1Var);
        return this;
    }

    public c1 g(int i9) {
        this.f2389s.remove(Integer.valueOf(i9));
        return this;
    }

    public c1 h(int i9, int i10) {
        this.f2376e = i9;
        this.f2377f = i10;
        this.f2378g = true;
        return this;
    }
}
