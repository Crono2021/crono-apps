package b2;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import b6.w0;
import d1.g1;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g {

    /* renamed from: l, reason: collision with root package name */
    public static final a f1177l = new a(0);

    /* renamed from: a, reason: collision with root package name */
    public final Context f1178a;

    /* renamed from: b, reason: collision with root package name */
    public final e f1179b;

    /* renamed from: c, reason: collision with root package name */
    public g1.r f1180c;

    /* renamed from: d, reason: collision with root package name */
    public v f1181d;

    /* renamed from: e, reason: collision with root package name */
    public d0 f1182e;

    /* renamed from: f, reason: collision with root package name */
    public g1.t f1183f;

    /* renamed from: g, reason: collision with root package name */
    public List f1184g;
    public Pair h;

    /* renamed from: i, reason: collision with root package name */
    public k0 f1185i;

    /* renamed from: j, reason: collision with root package name */
    public Executor f1186j;

    /* renamed from: k, reason: collision with root package name */
    public int f1187k;

    public g(b bVar) {
        this.f1178a = (Context) bVar.f1138b;
        e eVar = (e) bVar.f1140d;
        g1.a.l(eVar);
        this.f1179b = eVar;
        this.f1180c = g1.r.f3705a;
        this.f1185i = k0.f1211a;
        this.f1186j = f1177l;
        this.f1187k = 0;
    }

    public final void a(d1.s sVar) {
        int i9;
        boolean z8 = false;
        g1.a.k(this.f1187k == 0);
        g1.a.l(this.f1184g);
        if (this.f1182e != null && this.f1181d != null) {
            z8 = true;
        }
        g1.a.k(z8);
        g1.r rVar = this.f1180c;
        Looper myLooper = Looper.myLooper();
        g1.a.l(myLooper);
        this.f1183f = rVar.a(myLooper, null);
        d1.j jVar = sVar.f2566y;
        if (jVar == null || ((i9 = jVar.f2485c) != 7 && i9 != 6)) {
            jVar = d1.j.h;
        }
        if (jVar.f2485c == 7) {
        }
        try {
            e eVar = this.f1179b;
            Objects.requireNonNull(this.f1183f);
            w0 w0Var = w0.f1464m;
            eVar.a();
            Pair pair = this.h;
            if (pair != null) {
                int i10 = ((g1.q) pair.second).f3703a;
            }
            g1.w.J(this.f1178a);
            throw null;
        } catch (g1 e9) {
            throw new l0(e9, sVar);
        }
    }

    public final boolean b() {
        return this.f1187k == 1;
    }

    public final void c(Surface surface, g1.q qVar) {
        Pair pair = this.h;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((g1.q) this.h.second).equals(qVar)) {
            return;
        }
        this.h = Pair.create(surface, qVar);
        int i9 = qVar.f3703a;
    }

    public final void d(long j5) {
        g1.a.l(null);
        throw null;
    }
}
