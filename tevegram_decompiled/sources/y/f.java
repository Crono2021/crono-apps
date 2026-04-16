package y;

import android.view.ViewGroup;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public int f10271a;

    /* renamed from: b, reason: collision with root package name */
    public final i f10272b;

    /* renamed from: c, reason: collision with root package name */
    public final h f10273c;

    /* renamed from: d, reason: collision with root package name */
    public final g f10274d;

    /* renamed from: e, reason: collision with root package name */
    public final j f10275e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f10276f;

    public f() {
        i iVar = new i();
        iVar.f10316a = 0;
        iVar.f10317b = 0;
        iVar.f10318c = 1.0f;
        iVar.f10319d = Float.NaN;
        this.f10272b = iVar;
        h hVar = new h();
        hVar.f10312a = -1;
        hVar.f10313b = -1;
        hVar.f10314c = Float.NaN;
        hVar.f10315d = Float.NaN;
        this.f10273c = hVar;
        g gVar = new g();
        gVar.f10278a = false;
        gVar.f10284d = -1;
        gVar.f10286e = -1;
        gVar.f10288f = -1.0f;
        gVar.f10290g = -1;
        gVar.h = -1;
        gVar.f10293i = -1;
        gVar.f10294j = -1;
        gVar.f10295k = -1;
        gVar.f10296l = -1;
        gVar.f10297m = -1;
        gVar.f10298n = -1;
        gVar.f10299o = -1;
        gVar.f10300p = -1;
        gVar.f10301q = -1;
        gVar.f10302r = -1;
        gVar.f10303s = -1;
        gVar.f10304t = 0.5f;
        gVar.f10305u = 0.5f;
        gVar.f10306v = null;
        gVar.f10307w = -1;
        gVar.f10308x = 0;
        gVar.f10309y = 0.0f;
        gVar.f10310z = -1;
        gVar.A = -1;
        gVar.B = -1;
        gVar.C = -1;
        gVar.D = -1;
        gVar.E = -1;
        gVar.F = -1;
        gVar.G = -1;
        gVar.H = -1;
        gVar.I = -1;
        gVar.J = -1;
        gVar.K = -1;
        gVar.L = -1;
        gVar.M = -1;
        gVar.N = -1;
        gVar.O = -1.0f;
        gVar.P = -1.0f;
        gVar.Q = 0;
        gVar.R = 0;
        gVar.S = 0;
        gVar.T = 0;
        gVar.U = -1;
        gVar.V = -1;
        gVar.W = -1;
        gVar.X = -1;
        gVar.Y = 1.0f;
        gVar.Z = 1.0f;
        gVar.f10279a0 = -1;
        gVar.f10281b0 = 0;
        gVar.f10283c0 = -1;
        gVar.f10291g0 = false;
        gVar.f10292h0 = false;
        gVar.i0 = true;
        this.f10274d = gVar;
        j jVar = new j();
        jVar.f10321a = 0.0f;
        jVar.f10322b = 0.0f;
        jVar.f10323c = 0.0f;
        jVar.f10324d = 1.0f;
        jVar.f10325e = 1.0f;
        jVar.f10326f = Float.NaN;
        jVar.f10327g = Float.NaN;
        jVar.h = 0.0f;
        jVar.f10328i = 0.0f;
        jVar.f10329j = 0.0f;
        jVar.f10330k = false;
        jVar.f10331l = 0.0f;
        this.f10275e = jVar;
        this.f10276f = new HashMap();
    }

    public final void a(d dVar) {
        g gVar = this.f10274d;
        dVar.f10237d = gVar.f10290g;
        dVar.f10239e = gVar.h;
        dVar.f10241f = gVar.f10293i;
        dVar.f10243g = gVar.f10294j;
        dVar.h = gVar.f10295k;
        dVar.f10246i = gVar.f10296l;
        dVar.f10247j = gVar.f10297m;
        dVar.f10249k = gVar.f10298n;
        dVar.f10251l = gVar.f10299o;
        dVar.f10255p = gVar.f10300p;
        dVar.f10256q = gVar.f10301q;
        dVar.f10257r = gVar.f10302r;
        dVar.f10258s = gVar.f10303s;
        ((ViewGroup.MarginLayoutParams) dVar).leftMargin = gVar.C;
        ((ViewGroup.MarginLayoutParams) dVar).rightMargin = gVar.D;
        ((ViewGroup.MarginLayoutParams) dVar).topMargin = gVar.E;
        ((ViewGroup.MarginLayoutParams) dVar).bottomMargin = gVar.F;
        dVar.f10263x = gVar.N;
        dVar.f10264y = gVar.M;
        dVar.f10260u = gVar.J;
        dVar.f10262w = gVar.L;
        dVar.f10265z = gVar.f10304t;
        dVar.A = gVar.f10305u;
        dVar.f10252m = gVar.f10307w;
        dVar.f10253n = gVar.f10308x;
        dVar.f10254o = gVar.f10309y;
        dVar.B = gVar.f10306v;
        dVar.P = gVar.f10310z;
        dVar.Q = gVar.A;
        dVar.E = gVar.O;
        dVar.D = gVar.P;
        dVar.G = gVar.R;
        dVar.F = gVar.Q;
        dVar.S = gVar.f10291g0;
        dVar.T = gVar.f10292h0;
        dVar.H = gVar.S;
        dVar.I = gVar.T;
        dVar.L = gVar.U;
        dVar.M = gVar.V;
        dVar.J = gVar.W;
        dVar.K = gVar.X;
        dVar.N = gVar.Y;
        dVar.O = gVar.Z;
        dVar.R = gVar.B;
        dVar.f10235c = gVar.f10288f;
        dVar.f10231a = gVar.f10284d;
        dVar.f10233b = gVar.f10286e;
        ((ViewGroup.MarginLayoutParams) dVar).width = gVar.f10280b;
        ((ViewGroup.MarginLayoutParams) dVar).height = gVar.f10282c;
        String str = gVar.f10289f0;
        if (str != null) {
            dVar.U = str;
        }
        dVar.setMarginStart(gVar.H);
        dVar.setMarginEnd(gVar.G);
        dVar.a();
    }

    public final Object clone() {
        f fVar = new f();
        g gVar = fVar.f10274d;
        gVar.getClass();
        g gVar2 = this.f10274d;
        gVar.f10278a = gVar2.f10278a;
        gVar.f10280b = gVar2.f10280b;
        gVar.f10282c = gVar2.f10282c;
        gVar.f10284d = gVar2.f10284d;
        gVar.f10286e = gVar2.f10286e;
        gVar.f10288f = gVar2.f10288f;
        gVar.f10290g = gVar2.f10290g;
        gVar.h = gVar2.h;
        gVar.f10293i = gVar2.f10293i;
        gVar.f10294j = gVar2.f10294j;
        gVar.f10295k = gVar2.f10295k;
        gVar.f10296l = gVar2.f10296l;
        gVar.f10297m = gVar2.f10297m;
        gVar.f10298n = gVar2.f10298n;
        gVar.f10299o = gVar2.f10299o;
        gVar.f10300p = gVar2.f10300p;
        gVar.f10301q = gVar2.f10301q;
        gVar.f10302r = gVar2.f10302r;
        gVar.f10303s = gVar2.f10303s;
        gVar.f10304t = gVar2.f10304t;
        gVar.f10305u = gVar2.f10305u;
        gVar.f10306v = gVar2.f10306v;
        gVar.f10307w = gVar2.f10307w;
        gVar.f10308x = gVar2.f10308x;
        gVar.f10309y = gVar2.f10309y;
        gVar.f10310z = gVar2.f10310z;
        gVar.A = gVar2.A;
        gVar.B = gVar2.B;
        gVar.C = gVar2.C;
        gVar.D = gVar2.D;
        gVar.E = gVar2.E;
        gVar.F = gVar2.F;
        gVar.G = gVar2.G;
        gVar.H = gVar2.H;
        gVar.I = gVar2.I;
        gVar.J = gVar2.J;
        gVar.K = gVar2.K;
        gVar.L = gVar2.L;
        gVar.M = gVar2.M;
        gVar.N = gVar2.N;
        gVar.O = gVar2.O;
        gVar.P = gVar2.P;
        gVar.Q = gVar2.Q;
        gVar.R = gVar2.R;
        gVar.S = gVar2.S;
        gVar.T = gVar2.T;
        gVar.U = gVar2.U;
        gVar.V = gVar2.V;
        gVar.W = gVar2.W;
        gVar.X = gVar2.X;
        gVar.Y = gVar2.Y;
        gVar.Z = gVar2.Z;
        gVar.f10279a0 = gVar2.f10279a0;
        gVar.f10281b0 = gVar2.f10281b0;
        gVar.f10283c0 = gVar2.f10283c0;
        gVar.f10289f0 = gVar2.f10289f0;
        int[] iArr = gVar2.f10285d0;
        if (iArr != null) {
            gVar.f10285d0 = Arrays.copyOf(iArr, iArr.length);
        } else {
            gVar.f10285d0 = null;
        }
        gVar.f10287e0 = gVar2.f10287e0;
        gVar.f10291g0 = gVar2.f10291g0;
        gVar.f10292h0 = gVar2.f10292h0;
        gVar.i0 = gVar2.i0;
        h hVar = fVar.f10273c;
        hVar.getClass();
        h hVar2 = this.f10273c;
        hVar2.getClass();
        hVar.f10312a = hVar2.f10312a;
        hVar.f10313b = hVar2.f10313b;
        hVar.f10315d = hVar2.f10315d;
        hVar.f10314c = hVar2.f10314c;
        i iVar = this.f10272b;
        int i9 = iVar.f10316a;
        i iVar2 = fVar.f10272b;
        iVar2.f10316a = i9;
        iVar2.f10318c = iVar.f10318c;
        iVar2.f10319d = iVar.f10319d;
        iVar2.f10317b = iVar.f10317b;
        j jVar = fVar.f10275e;
        jVar.getClass();
        j jVar2 = this.f10275e;
        jVar2.getClass();
        jVar.f10321a = jVar2.f10321a;
        jVar.f10322b = jVar2.f10322b;
        jVar.f10323c = jVar2.f10323c;
        jVar.f10324d = jVar2.f10324d;
        jVar.f10325e = jVar2.f10325e;
        jVar.f10326f = jVar2.f10326f;
        jVar.f10327g = jVar2.f10327g;
        jVar.h = jVar2.h;
        jVar.f10328i = jVar2.f10328i;
        jVar.f10329j = jVar2.f10329j;
        jVar.f10330k = jVar2.f10330k;
        jVar.f10331l = jVar2.f10331l;
        fVar.f10271a = this.f10271a;
        return fVar;
    }
}
