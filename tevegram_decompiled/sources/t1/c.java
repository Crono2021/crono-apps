package t1;

import a3.i;
import a5.d;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.activity.g;
import d1.g0;
import d1.h0;
import d1.i0;
import d1.j0;
import d1.s;
import g1.m;
import g1.w;
import java.util.ArrayList;
import l1.b0;
import l1.e;
import l1.y;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends e implements Handler.Callback {
    public final b A;
    public final Handler B;
    public final l2.a C;
    public android.support.v4.media.session.b D;
    public boolean E;
    public boolean F;
    public long G;
    public j0 H;
    public long I;

    /* renamed from: z, reason: collision with root package name */
    public final a f8917z;

    public c(b bVar, Looper looper) {
        super(5);
        bVar.getClass();
        this.A = bVar;
        this.B = looper == null ? null : new Handler(looper, this);
        this.f8917z = a.f8916a;
        this.C = new l2.a(1, 0);
        this.I = -9223372036854775807L;
    }

    public final void B(j0 j0Var, ArrayList arrayList) {
        int i9 = 0;
        while (true) {
            i0[] i0VarArr = j0Var.f2490i;
            if (i9 >= i0VarArr.length) {
                return;
            }
            s b9 = i0VarArr[i9].b();
            if (b9 != null) {
                a aVar = this.f8917z;
                if (aVar.b(b9)) {
                    android.support.v4.media.session.b a9 = aVar.a(b9);
                    byte[] c9 = i0VarArr[i9].c();
                    c9.getClass();
                    l2.a aVar2 = this.C;
                    aVar2.k();
                    aVar2.m(c9.length);
                    aVar2.f5359m.put(c9);
                    aVar2.n();
                    j0 A = a9.A(aVar2);
                    if (A != null) {
                        B(A, arrayList);
                    }
                    i9++;
                }
            }
            arrayList.add(i0VarArr[i9]);
            i9++;
        }
    }

    public final long C(long j5) {
        g1.a.k(j5 != -9223372036854775807L);
        g1.a.k(this.I != -9223372036854775807L);
        return j5 - this.I;
    }

    public final void D(j0 j0Var) {
        y yVar = (y) this.A;
        b0 b0Var = yVar.f6065i;
        h0 h0Var = b0Var.f5790n0;
        m mVar = b0Var.f5799t;
        g0 a9 = h0Var.a();
        int i9 = 0;
        while (true) {
            i0[] i0VarArr = j0Var.f2490i;
            if (i9 >= i0VarArr.length) {
                break;
            }
            i0VarArr[i9].a(a9);
            i9++;
        }
        b0Var.f5790n0 = new h0(a9);
        h0 c9 = b0Var.c();
        if (!c9.equals(b0Var.U)) {
            b0Var.U = c9;
            mVar.c(14, new i(yVar, 14));
        }
        mVar.c(28, new i(j0Var, 15));
        mVar.b();
    }

    @Override // l1.e, l1.b1
    public final boolean a() {
        return this.F;
    }

    @Override // l1.b1
    public final boolean b() {
        return true;
    }

    @Override // l1.b1
    public final void f(long j5, long j9) {
        boolean z8 = true;
        while (z8) {
            if (!this.E && this.H == null) {
                l2.a aVar = this.C;
                aVar.k();
                d dVar = this.f5828k;
                dVar.o0();
                int w8 = w(dVar, aVar, 0);
                if (w8 == -4) {
                    if (aVar.c(4)) {
                        this.E = true;
                    } else if (aVar.f5361o >= this.f5837t) {
                        aVar.f6080s = this.G;
                        aVar.n();
                        android.support.v4.media.session.b bVar = this.D;
                        int i9 = w.f3713a;
                        j0 A = bVar.A(aVar);
                        if (A != null) {
                            ArrayList arrayList = new ArrayList(A.f2490i.length);
                            B(A, arrayList);
                            if (!arrayList.isEmpty()) {
                                this.H = new j0(C(aVar.f5361o), (i0[]) arrayList.toArray(new i0[0]));
                            }
                        }
                    }
                } else if (w8 == -5) {
                    s sVar = (s) dVar.f175k;
                    sVar.getClass();
                    this.G = sVar.f2558q;
                }
            }
            j0 j0Var = this.H;
            if (j0Var == null || j0Var.f2491j > C(j5)) {
                z8 = false;
            } else {
                j0 j0Var2 = this.H;
                Handler handler = this.B;
                if (handler != null) {
                    handler.obtainMessage(0, j0Var2).sendToTarget();
                } else {
                    D(j0Var2);
                }
                this.H = null;
                z8 = true;
            }
            if (this.E && this.H == null) {
                this.F = true;
            }
        }
    }

    @Override // l1.b1
    public final String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 0) {
            D((j0) message.obj);
            return true;
        }
        androidx.fragment.app.a.l();
        return false;
    }

    @Override // l1.e
    public final void n() {
        this.H = null;
        this.D = null;
        this.I = -9223372036854775807L;
    }

    @Override // l1.e
    public final void q(long j5, boolean z8) {
        this.H = null;
        this.E = false;
        this.F = false;
    }

    @Override // l1.e
    public final void v(s[] sVarArr, long j5, long j9) {
        this.D = this.f8917z.a(sVarArr[0]);
        j0 j0Var = this.H;
        if (j0Var != null) {
            long j10 = j0Var.f2491j;
            long j11 = (this.I + j10) - j9;
            if (j10 != j11) {
                j0Var = new j0(j11, j0Var.f2490i);
            }
            this.H = j0Var;
        }
        this.I = j9;
    }

    @Override // l1.e
    public final int z(s sVar) {
        if (this.f8917z.b(sVar)) {
            return g.f(sVar.I == 0 ? 4 : 2, 0, 0, 0);
        }
        return g.f(0, 0, 0, 0);
    }
}
