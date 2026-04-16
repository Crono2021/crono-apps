package x1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import b6.a0;
import b6.g0;
import b6.q;
import b6.w0;
import d1.l0;
import d1.s;
import i7.x;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import l1.b0;
import l1.y;
import w2.k;
import z2.g;
import z2.h;
import z2.i;
import z2.j;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends l1.e implements Handler.Callback {
    public final j1.e A;
    public a B;
    public final c C;
    public boolean D;
    public int E;
    public g F;
    public i G;
    public j H;
    public j I;
    public int J;
    public final Handler K;
    public final d L;
    public final a5.d M;
    public boolean N;
    public boolean O;
    public s P;
    public long Q;
    public long R;
    public long S;
    public final boolean T;

    /* renamed from: z, reason: collision with root package name */
    public final o4.d f10041z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, Looper looper) {
        super(3);
        x xVar = c.h;
        dVar.getClass();
        this.L = dVar;
        this.K = looper == null ? null : new Handler(looper, this);
        this.C = xVar;
        this.f10041z = new o4.d(28);
        this.A = new j1.e(1, 0);
        this.M = new a5.d(28);
        this.S = -9223372036854775807L;
        this.Q = -9223372036854775807L;
        this.R = -9223372036854775807L;
        this.T = true;
    }

    public final void B() {
        boolean z8 = this.T || Objects.equals(this.P.f2554m, "application/cea-608") || Objects.equals(this.P.f2554m, "application/x-mp4-cea-608") || Objects.equals(this.P.f2554m, "application/cea-708");
        String o8 = androidx.activity.g.o(new StringBuilder("Legacy decoding is disabled, can't handle "), this.P.f2554m, " samples (expected application/x-media3-cues).");
        if (z8) {
            return;
        }
        m7.c.p(o8);
    }

    public final long C() {
        if (this.J == -1) {
            return Long.MAX_VALUE;
        }
        this.H.getClass();
        if (this.J >= this.H.u()) {
            return Long.MAX_VALUE;
        }
        return this.H.j(this.J);
    }

    public final long D(long j5) {
        g1.a.k(j5 != -9223372036854775807L);
        g1.a.k(this.Q != -9223372036854775807L);
        return j5 - this.Q;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        if (r3.equals("application/cea-608") == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E() {
        /*
            r7 = this;
            r0 = 1
            r7.D = r0
            d1.s r1 = r7.P
            r1.getClass()
            x1.c r2 = r7.C
            i7.x r2 = (i7.x) r2
            java.lang.Object r2 = r2.f5179j
            z2.c r2 = (z2.c) r2
            java.lang.String r3 = r1.f2554m
            int r4 = r1.E
            if (r3 == 0) goto L50
            int r5 = r3.hashCode()
            r6 = -1
            switch(r5) {
                case 930165504: goto L34;
                case 1566015601: goto L2b;
                case 1566016562: goto L20;
                default: goto L1e;
            }
        L1e:
            r0 = -1
            goto L3e
        L20:
            java.lang.String r0 = "application/cea-708"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L29
            goto L1e
        L29:
            r0 = 2
            goto L3e
        L2b:
            java.lang.String r5 = "application/cea-608"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L3e
            goto L1e
        L34:
            java.lang.String r0 = "application/x-mp4-cea-608"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L3d
            goto L1e
        L3d:
            r0 = 0
        L3e:
            switch(r0) {
                case 0: goto L4a;
                case 1: goto L4a;
                case 2: goto L42;
                default: goto L41;
            }
        L41:
            goto L50
        L42:
            a3.h r0 = new a3.h
            java.util.List r1 = r1.f2556o
            r0.<init>(r4, r1)
            goto L6e
        L4a:
            a3.c r0 = new a3.c
            r0.<init>(r3, r4)
            goto L6e
        L50:
            boolean r0 = r2.b(r1)
            if (r0 == 0) goto L71
            z2.l r0 = r2.a(r1)
            r1.b r1 = new r1.b
            java.lang.Class r2 = r0.getClass()
            java.lang.String r2 = r2.getSimpleName()
            java.lang.String r3 = "Decoder"
            java.lang.String r2 = r2.concat(r3)
            r1.<init>(r2, r0)
            r0 = r1
        L6e:
            r7.F = r0
            return
        L71:
            java.lang.String r0 = "Attempted to create decoder for unsupported MIME type: "
            java.lang.String r0 = t.a.b(r0, r3)
            m7.c.n(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.e.E():void");
    }

    public final void F(f1.c cVar) {
        g0 g0Var = cVar.f3260a;
        y yVar = (y) this.L;
        yVar.f6065i.f5799t.e(27, new a3.i(g0Var, 16));
        b0 b0Var = yVar.f6065i;
        b0Var.f5782j0 = cVar;
        b0Var.f5799t.e(27, new a3.i(cVar, 13));
    }

    public final void G() {
        this.G = null;
        this.J = -1;
        j jVar = this.H;
        if (jVar != null) {
            jVar.l();
            this.H = null;
        }
        j jVar2 = this.I;
        if (jVar2 != null) {
            jVar2.l();
            this.I = null;
        }
    }

    @Override // l1.e, l1.b1
    public final boolean a() {
        return this.O;
    }

    @Override // l1.b1
    public final boolean b() {
        return true;
    }

    @Override // l1.b1
    public final void f(long j5, long j9) {
        boolean z8;
        int i9;
        long j10;
        int i10;
        Object[] objArr;
        if (this.f5839v) {
            long j11 = this.S;
            if (j11 != -9223372036854775807L && j5 >= j11) {
                G();
                this.O = true;
            }
        }
        if (this.O) {
            return;
        }
        s sVar = this.P;
        sVar.getClass();
        boolean equals = Objects.equals(sVar.f2554m, "application/x-media3-cues");
        Handler handler = this.K;
        a5.d dVar = this.M;
        boolean z9 = false;
        if (equals) {
            this.B.getClass();
            if (!this.N) {
                j1.e eVar = this.A;
                if (w(dVar, eVar, 0) == -4) {
                    if (eVar.c(4)) {
                        this.N = true;
                    } else {
                        eVar.n();
                        ByteBuffer byteBuffer = eVar.f5359m;
                        byteBuffer.getClass();
                        long j12 = eVar.f5361o;
                        byte[] array = byteBuffer.array();
                        int arrayOffset = byteBuffer.arrayOffset();
                        int limit = byteBuffer.limit();
                        this.f10041z.getClass();
                        Parcel obtain = Parcel.obtain();
                        obtain.unmarshall(array, arrayOffset, limit);
                        obtain.setDataPosition(0);
                        Bundle readBundle = obtain.readBundle(Bundle.class.getClassLoader());
                        obtain.recycle();
                        ArrayList parcelableArrayList = readBundle.getParcelableArrayList("c");
                        parcelableArrayList.getClass();
                        k kVar = new k(5);
                        q.b(4, "initialCapacity");
                        Object[] objArr2 = new Object[4];
                        int i11 = 0;
                        int i12 = 0;
                        boolean z10 = false;
                        while (i11 < parcelableArrayList.size()) {
                            Bundle bundle = (Bundle) parcelableArrayList.get(i11);
                            bundle.getClass();
                            Object apply = kVar.apply(bundle);
                            int i13 = i12 + 1;
                            j1.e eVar2 = eVar;
                            if (objArr2.length < i13) {
                                objArr = Arrays.copyOf(objArr2, a0.d(objArr2.length, i13));
                            } else if (z10) {
                                objArr = (Object[]) objArr2.clone();
                            } else {
                                objArr2[i12] = apply;
                                i11++;
                                i12++;
                                eVar = eVar2;
                            }
                            objArr2 = objArr;
                            z10 = false;
                            objArr2[i12] = apply;
                            i11++;
                            i12++;
                            eVar = eVar2;
                        }
                        z2.a aVar = new z2.a(j12, readBundle.getLong("d"), g0.l(i12, objArr2));
                        eVar.k();
                        z9 = this.B.c(aVar, j5);
                    }
                }
            }
            long b9 = this.B.b(this.R);
            if (b9 == Long.MIN_VALUE && this.N && !z9) {
                this.O = true;
            }
            if ((b9 == Long.MIN_VALUE || b9 > j5) ? z9 : true) {
                g0 a9 = this.B.a(j5);
                long d9 = this.B.d(j5);
                D(d9);
                f1.c cVar = new f1.c(a9);
                if (handler != null) {
                    handler.obtainMessage(0, cVar).sendToTarget();
                } else {
                    F(cVar);
                }
                this.B.e(d9);
            }
            this.R = j5;
            return;
        }
        B();
        this.R = j5;
        if (this.I == null) {
            g gVar = this.F;
            gVar.getClass();
            gVar.a(j5);
            try {
                g gVar2 = this.F;
                gVar2.getClass();
                this.I = (j) gVar2.c();
            } catch (h e9) {
                g1.a.q("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.P, e9);
                w0 w0Var = w0.f1464m;
                D(this.R);
                f1.c cVar2 = new f1.c(w0Var);
                if (handler != null) {
                    i10 = 0;
                    handler.obtainMessage(0, cVar2).sendToTarget();
                } else {
                    i10 = 0;
                    F(cVar2);
                }
                G();
                g gVar3 = this.F;
                gVar3.getClass();
                gVar3.release();
                this.F = null;
                this.E = i10;
                E();
                return;
            }
        }
        if (this.f5833p != 2) {
            return;
        }
        if (this.H != null) {
            long C = C();
            z8 = false;
            while (C <= j5) {
                this.J++;
                C = C();
                z8 = true;
            }
        } else {
            z8 = false;
        }
        j jVar = this.I;
        if (jVar != null) {
            if (jVar.c(4)) {
                if (!z8 && C() == Long.MAX_VALUE) {
                    if (this.E == 2) {
                        G();
                        g gVar4 = this.F;
                        gVar4.getClass();
                        gVar4.release();
                        this.F = null;
                        this.E = 0;
                        E();
                    } else {
                        G();
                        this.O = true;
                    }
                }
            } else if (jVar.f5365k <= j5) {
                j jVar2 = this.H;
                if (jVar2 != null) {
                    jVar2.l();
                }
                this.J = jVar.g(j5);
                this.H = jVar;
                this.I = null;
                z8 = true;
            }
        }
        if (z8) {
            this.H.getClass();
            int g9 = this.H.g(j5);
            if (g9 == 0 || this.H.u() == 0) {
                j10 = this.H.f5365k;
            } else {
                j jVar3 = this.H;
                j10 = g9 == -1 ? jVar3.j(jVar3.u() - 1) : jVar3.j(g9 - 1);
            }
            D(j10);
            f1.c cVar3 = new f1.c(this.H.q(j5));
            if (handler != null) {
                handler.obtainMessage(0, cVar3).sendToTarget();
            } else {
                F(cVar3);
            }
        }
        if (this.E == 2) {
            return;
        }
        while (!this.N) {
            try {
                i iVar = this.G;
                if (iVar == null) {
                    g gVar5 = this.F;
                    gVar5.getClass();
                    iVar = (i) gVar5.d();
                    if (iVar == null) {
                        return;
                    } else {
                        this.G = iVar;
                    }
                }
                if (this.E == 1) {
                    iVar.f3748j = 4;
                    g gVar6 = this.F;
                    gVar6.getClass();
                    gVar6.b(iVar);
                    this.G = null;
                    this.E = 2;
                    return;
                }
                int w8 = w(dVar, iVar, 0);
                if (w8 == -4) {
                    if (iVar.c(4)) {
                        this.N = true;
                        this.D = false;
                    } else {
                        s sVar2 = (s) dVar.f175k;
                        if (sVar2 == null) {
                            return;
                        }
                        iVar.f10617s = sVar2.f2558q;
                        iVar.n();
                        this.D &= !iVar.c(1);
                    }
                    if (!this.D) {
                        if (iVar.f5361o < this.f5837t) {
                            iVar.a(Integer.MIN_VALUE);
                        }
                        g gVar7 = this.F;
                        gVar7.getClass();
                        gVar7.b(iVar);
                        this.G = null;
                    }
                } else if (w8 == -3) {
                    return;
                }
            } catch (h e10) {
                g1.a.q("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.P, e10);
                w0 w0Var2 = w0.f1464m;
                D(this.R);
                f1.c cVar4 = new f1.c(w0Var2);
                if (handler != null) {
                    i9 = 0;
                    handler.obtainMessage(0, cVar4).sendToTarget();
                } else {
                    i9 = 0;
                    F(cVar4);
                }
                G();
                g gVar8 = this.F;
                gVar8.getClass();
                gVar8.release();
                this.F = null;
                this.E = i9;
                E();
                return;
            }
        }
    }

    @Override // l1.b1
    public final String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 0) {
            F((f1.c) message.obj);
            return true;
        }
        androidx.fragment.app.a.l();
        return false;
    }

    @Override // l1.e
    public final void n() {
        this.P = null;
        this.S = -9223372036854775807L;
        w0 w0Var = w0.f1464m;
        D(this.R);
        f1.c cVar = new f1.c(w0Var);
        Handler handler = this.K;
        if (handler != null) {
            handler.obtainMessage(0, cVar).sendToTarget();
        } else {
            F(cVar);
        }
        this.Q = -9223372036854775807L;
        this.R = -9223372036854775807L;
        if (this.F != null) {
            G();
            g gVar = this.F;
            gVar.getClass();
            gVar.release();
            this.F = null;
            this.E = 0;
        }
    }

    @Override // l1.e
    public final void q(long j5, boolean z8) {
        this.R = j5;
        a aVar = this.B;
        if (aVar != null) {
            aVar.clear();
        }
        w0 w0Var = w0.f1464m;
        D(this.R);
        f1.c cVar = new f1.c(w0Var);
        Handler handler = this.K;
        if (handler != null) {
            handler.obtainMessage(0, cVar).sendToTarget();
        } else {
            F(cVar);
        }
        this.N = false;
        this.O = false;
        this.S = -9223372036854775807L;
        s sVar = this.P;
        if (sVar == null || Objects.equals(sVar.f2554m, "application/x-media3-cues")) {
            return;
        }
        if (this.E == 0) {
            G();
            g gVar = this.F;
            gVar.getClass();
            gVar.flush();
            return;
        }
        G();
        g gVar2 = this.F;
        gVar2.getClass();
        gVar2.release();
        this.F = null;
        this.E = 0;
        E();
    }

    @Override // l1.e
    public final void v(s[] sVarArr, long j5, long j9) {
        this.Q = j9;
        s sVar = sVarArr[0];
        this.P = sVar;
        if (Objects.equals(sVar.f2554m, "application/x-media3-cues")) {
            this.B = this.P.F == 1 ? new b() : new p4.c(4);
            return;
        }
        B();
        if (this.F != null) {
            this.E = 1;
        } else {
            E();
        }
    }

    @Override // l1.e
    public final int z(s sVar) {
        boolean equals = Objects.equals(sVar.f2554m, "application/x-media3-cues");
        String str = sVar.f2554m;
        if (!equals) {
            x xVar = (x) this.C;
            xVar.getClass();
            if (!((z2.c) xVar.f5179j).b(sVar) && !Objects.equals(str, "application/cea-608") && !Objects.equals(str, "application/x-mp4-cea-608") && !Objects.equals(str, "application/cea-708")) {
                return l0.i(str) ? androidx.activity.g.f(1, 0, 0, 0) : androidx.activity.g.f(0, 0, 0, 0);
            }
        }
        return androidx.activity.g.f(sVar.I == 0 ? 4 : 2, 0, 0, 0);
    }
}
