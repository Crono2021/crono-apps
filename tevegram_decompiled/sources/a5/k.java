package a5;

import android.view.View;
import com.google.crypto.tink.shaded.protobuf.c0;
import com.google.crypto.tink.shaded.protobuf.d1;
import com.google.crypto.tink.shaded.protobuf.e0;
import com.google.crypto.tink.shaded.protobuf.h0;
import com.google.crypto.tink.shaded.protobuf.l0;
import com.google.crypto.tink.shaded.protobuf.m;
import com.google.crypto.tink.shaded.protobuf.o;
import com.google.crypto.tink.shaded.protobuf.q;
import com.google.crypto.tink.shaded.protobuf.u;
import com.google.crypto.tink.shaded.protobuf.z;
import java.util.List;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public int f195a;

    /* renamed from: b, reason: collision with root package name */
    public int f196b;

    /* renamed from: c, reason: collision with root package name */
    public int f197c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f198d;

    public k(m mVar) {
        this.f197c = 0;
        c0.a(mVar, "input");
        this.f198d = mVar;
        mVar.f2269b = this;
    }

    public static void x(int i9) {
        if ((i9 & 3) != 0) {
            throw e0.f();
        }
    }

    public static void y(int i9) {
        if ((i9 & 7) != 0) {
            throw e0.f();
        }
    }

    public void a() {
        View view = (View) this.f198d;
        t0.k(view, this.f197c - (view.getTop() - this.f195a));
        t0.j(view, 0 - (view.getLeft() - this.f196b));
    }

    public int b() {
        int i9 = this.f197c;
        if (i9 != 0) {
            this.f195a = i9;
            this.f197c = 0;
        } else {
            this.f195a = ((m) this.f198d).B();
        }
        int i10 = this.f195a;
        if (i10 == 0 || i10 == this.f196b) {
            return Integer.MAX_VALUE;
        }
        return i10 >>> 3;
    }

    public void c(Object obj, d1 d1Var, q qVar) {
        int i9 = this.f196b;
        this.f196b = ((this.f195a >>> 3) << 3) | 4;
        try {
            d1Var.d(obj, this, qVar);
            if (this.f195a == this.f196b) {
            } else {
                throw e0.f();
            }
        } finally {
            this.f196b = i9;
        }
    }

    public void d(Object obj, d1 d1Var, q qVar) {
        m mVar = (m) this.f198d;
        int C = mVar.C();
        if (mVar.f2268a >= 100) {
            throw new e0("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int l4 = mVar.l(C);
        mVar.f2268a++;
        d1Var.d(obj, this, qVar);
        mVar.b(0);
        mVar.f2268a--;
        mVar.j(l4);
    }

    public void e(List list) {
        int B;
        int B2;
        m mVar = (m) this.f198d;
        boolean z8 = list instanceof com.google.crypto.tink.shaded.protobuf.e;
        int i9 = this.f195a;
        if (!z8) {
            int i10 = i9 & 7;
            if (i10 == 0) {
                do {
                    list.add(Boolean.valueOf(mVar.m()));
                    if (mVar.g()) {
                        return;
                    } else {
                        B = mVar.B();
                    }
                } while (B == this.f195a);
                this.f197c = B;
                return;
            }
            if (i10 != 2) {
                throw e0.c();
            }
            int f9 = mVar.f() + mVar.C();
            do {
                list.add(Boolean.valueOf(mVar.m()));
            } while (mVar.f() < f9);
            v(f9);
            return;
        }
        com.google.crypto.tink.shaded.protobuf.e eVar = (com.google.crypto.tink.shaded.protobuf.e) list;
        int i11 = i9 & 7;
        if (i11 == 0) {
            do {
                eVar.g(mVar.m());
                if (mVar.g()) {
                    return;
                } else {
                    B2 = mVar.B();
                }
            } while (B2 == this.f195a);
            this.f197c = B2;
            return;
        }
        if (i11 != 2) {
            throw e0.c();
        }
        int f10 = mVar.f() + mVar.C();
        do {
            eVar.g(mVar.m());
        } while (mVar.f() < f10);
        v(f10);
    }

    public com.google.crypto.tink.shaded.protobuf.j f() {
        w(2);
        return ((m) this.f198d).n();
    }

    public void g(List list) {
        int B;
        m mVar = (m) this.f198d;
        if ((this.f195a & 7) != 2) {
            throw e0.c();
        }
        do {
            list.add(f());
            if (mVar.g()) {
                return;
            } else {
                B = mVar.B();
            }
        } while (B == this.f195a);
        this.f197c = B;
    }

    public void h(List list) {
        int B;
        int B2;
        m mVar = (m) this.f198d;
        boolean z8 = list instanceof o;
        int i9 = this.f195a;
        if (!z8) {
            int i10 = i9 & 7;
            if (i10 == 1) {
                do {
                    list.add(Double.valueOf(mVar.o()));
                    if (mVar.g()) {
                        return;
                    } else {
                        B = mVar.B();
                    }
                } while (B == this.f195a);
                this.f197c = B;
                return;
            }
            if (i10 != 2) {
                throw e0.c();
            }
            int C = mVar.C();
            y(C);
            int f9 = mVar.f() + C;
            do {
                list.add(Double.valueOf(mVar.o()));
            } while (mVar.f() < f9);
            return;
        }
        o oVar = (o) list;
        int i11 = i9 & 7;
        if (i11 == 1) {
            do {
                oVar.g(mVar.o());
                if (mVar.g()) {
                    return;
                } else {
                    B2 = mVar.B();
                }
            } while (B2 == this.f195a);
            this.f197c = B2;
            return;
        }
        if (i11 != 2) {
            throw e0.c();
        }
        int C2 = mVar.C();
        y(C2);
        int f10 = mVar.f() + C2;
        do {
            oVar.g(mVar.o());
        } while (mVar.f() < f10);
    }

    public void i(List list) {
        int B;
        int B2;
        m mVar = (m) this.f198d;
        boolean z8 = list instanceof z;
        int i9 = this.f195a;
        if (!z8) {
            int i10 = i9 & 7;
            if (i10 == 0) {
                do {
                    list.add(Integer.valueOf(mVar.p()));
                    if (mVar.g()) {
                        return;
                    } else {
                        B = mVar.B();
                    }
                } while (B == this.f195a);
                this.f197c = B;
                return;
            }
            if (i10 != 2) {
                throw e0.c();
            }
            int f9 = mVar.f() + mVar.C();
            do {
                list.add(Integer.valueOf(mVar.p()));
            } while (mVar.f() < f9);
            v(f9);
            return;
        }
        z zVar = (z) list;
        int i11 = i9 & 7;
        if (i11 == 0) {
            do {
                zVar.g(mVar.p());
                if (mVar.g()) {
                    return;
                } else {
                    B2 = mVar.B();
                }
            } while (B2 == this.f195a);
            this.f197c = B2;
            return;
        }
        if (i11 != 2) {
            throw e0.c();
        }
        int f10 = mVar.f() + mVar.C();
        do {
            zVar.g(mVar.p());
        } while (mVar.f() < f10);
        v(f10);
    }

    public void j(List list) {
        int B;
        int B2;
        m mVar = (m) this.f198d;
        boolean z8 = list instanceof z;
        int i9 = this.f195a;
        if (!z8) {
            int i10 = i9 & 7;
            if (i10 == 2) {
                int C = mVar.C();
                x(C);
                int f9 = mVar.f() + C;
                do {
                    list.add(Integer.valueOf(mVar.q()));
                } while (mVar.f() < f9);
                return;
            }
            if (i10 != 5) {
                throw e0.c();
            }
            do {
                list.add(Integer.valueOf(mVar.q()));
                if (mVar.g()) {
                    return;
                } else {
                    B = mVar.B();
                }
            } while (B == this.f195a);
            this.f197c = B;
            return;
        }
        z zVar = (z) list;
        int i11 = i9 & 7;
        if (i11 == 2) {
            int C2 = mVar.C();
            x(C2);
            int f10 = mVar.f() + C2;
            do {
                zVar.g(mVar.q());
            } while (mVar.f() < f10);
            return;
        }
        if (i11 != 5) {
            throw e0.c();
        }
        do {
            zVar.g(mVar.q());
            if (mVar.g()) {
                return;
            } else {
                B2 = mVar.B();
            }
        } while (B2 == this.f195a);
        this.f197c = B2;
    }

    public void k(List list) {
        int B;
        int B2;
        m mVar = (m) this.f198d;
        boolean z8 = list instanceof l0;
        int i9 = this.f195a;
        if (!z8) {
            int i10 = i9 & 7;
            if (i10 == 1) {
                do {
                    list.add(Long.valueOf(mVar.r()));
                    if (mVar.g()) {
                        return;
                    } else {
                        B = mVar.B();
                    }
                } while (B == this.f195a);
                this.f197c = B;
                return;
            }
            if (i10 != 2) {
                throw e0.c();
            }
            int C = mVar.C();
            y(C);
            int f9 = mVar.f() + C;
            do {
                list.add(Long.valueOf(mVar.r()));
            } while (mVar.f() < f9);
            return;
        }
        l0 l0Var = (l0) list;
        int i11 = i9 & 7;
        if (i11 == 1) {
            do {
                l0Var.g(mVar.r());
                if (mVar.g()) {
                    return;
                } else {
                    B2 = mVar.B();
                }
            } while (B2 == this.f195a);
            this.f197c = B2;
            return;
        }
        if (i11 != 2) {
            throw e0.c();
        }
        int C2 = mVar.C();
        y(C2);
        int f10 = mVar.f() + C2;
        do {
            l0Var.g(mVar.r());
        } while (mVar.f() < f10);
    }

    public void l(List list) {
        int B;
        int B2;
        m mVar = (m) this.f198d;
        boolean z8 = list instanceof u;
        int i9 = this.f195a;
        if (!z8) {
            int i10 = i9 & 7;
            if (i10 == 2) {
                int C = mVar.C();
                x(C);
                int f9 = mVar.f() + C;
                do {
                    list.add(Float.valueOf(mVar.s()));
                } while (mVar.f() < f9);
                return;
            }
            if (i10 != 5) {
                throw e0.c();
            }
            do {
                list.add(Float.valueOf(mVar.s()));
                if (mVar.g()) {
                    return;
                } else {
                    B = mVar.B();
                }
            } while (B == this.f195a);
            this.f197c = B;
            return;
        }
        u uVar = (u) list;
        int i11 = i9 & 7;
        if (i11 == 2) {
            int C2 = mVar.C();
            x(C2);
            int f10 = mVar.f() + C2;
            do {
                uVar.g(mVar.s());
            } while (mVar.f() < f10);
            return;
        }
        if (i11 != 5) {
            throw e0.c();
        }
        do {
            uVar.g(mVar.s());
            if (mVar.g()) {
                return;
            } else {
                B2 = mVar.B();
            }
        } while (B2 == this.f195a);
        this.f197c = B2;
    }

    public void m(List list) {
        int B;
        int B2;
        m mVar = (m) this.f198d;
        boolean z8 = list instanceof z;
        int i9 = this.f195a;
        if (!z8) {
            int i10 = i9 & 7;
            if (i10 == 0) {
                do {
                    list.add(Integer.valueOf(mVar.t()));
                    if (mVar.g()) {
                        return;
                    } else {
                        B = mVar.B();
                    }
                } while (B == this.f195a);
                this.f197c = B;
                return;
            }
            if (i10 != 2) {
                throw e0.c();
            }
            int f9 = mVar.f() + mVar.C();
            do {
                list.add(Integer.valueOf(mVar.t()));
            } while (mVar.f() < f9);
            v(f9);
            return;
        }
        z zVar = (z) list;
        int i11 = i9 & 7;
        if (i11 == 0) {
            do {
                zVar.g(mVar.t());
                if (mVar.g()) {
                    return;
                } else {
                    B2 = mVar.B();
                }
            } while (B2 == this.f195a);
            this.f197c = B2;
            return;
        }
        if (i11 != 2) {
            throw e0.c();
        }
        int f10 = mVar.f() + mVar.C();
        do {
            zVar.g(mVar.t());
        } while (mVar.f() < f10);
        v(f10);
    }

    public void n(List list) {
        int B;
        int B2;
        m mVar = (m) this.f198d;
        boolean z8 = list instanceof l0;
        int i9 = this.f195a;
        if (!z8) {
            int i10 = i9 & 7;
            if (i10 == 0) {
                do {
                    list.add(Long.valueOf(mVar.u()));
                    if (mVar.g()) {
                        return;
                    } else {
                        B = mVar.B();
                    }
                } while (B == this.f195a);
                this.f197c = B;
                return;
            }
            if (i10 != 2) {
                throw e0.c();
            }
            int f9 = mVar.f() + mVar.C();
            do {
                list.add(Long.valueOf(mVar.u()));
            } while (mVar.f() < f9);
            v(f9);
            return;
        }
        l0 l0Var = (l0) list;
        int i11 = i9 & 7;
        if (i11 == 0) {
            do {
                l0Var.g(mVar.u());
                if (mVar.g()) {
                    return;
                } else {
                    B2 = mVar.B();
                }
            } while (B2 == this.f195a);
            this.f197c = B2;
            return;
        }
        if (i11 != 2) {
            throw e0.c();
        }
        int f10 = mVar.f() + mVar.C();
        do {
            l0Var.g(mVar.u());
        } while (mVar.f() < f10);
        v(f10);
    }

    public void o(List list) {
        int B;
        int B2;
        m mVar = (m) this.f198d;
        boolean z8 = list instanceof z;
        int i9 = this.f195a;
        if (!z8) {
            int i10 = i9 & 7;
            if (i10 == 2) {
                int C = mVar.C();
                x(C);
                int f9 = mVar.f() + C;
                do {
                    list.add(Integer.valueOf(mVar.v()));
                } while (mVar.f() < f9);
                return;
            }
            if (i10 != 5) {
                throw e0.c();
            }
            do {
                list.add(Integer.valueOf(mVar.v()));
                if (mVar.g()) {
                    return;
                } else {
                    B = mVar.B();
                }
            } while (B == this.f195a);
            this.f197c = B;
            return;
        }
        z zVar = (z) list;
        int i11 = i9 & 7;
        if (i11 == 2) {
            int C2 = mVar.C();
            x(C2);
            int f10 = mVar.f() + C2;
            do {
                zVar.g(mVar.v());
            } while (mVar.f() < f10);
            return;
        }
        if (i11 != 5) {
            throw e0.c();
        }
        do {
            zVar.g(mVar.v());
            if (mVar.g()) {
                return;
            } else {
                B2 = mVar.B();
            }
        } while (B2 == this.f195a);
        this.f197c = B2;
    }

    public void p(List list) {
        int B;
        int B2;
        m mVar = (m) this.f198d;
        boolean z8 = list instanceof l0;
        int i9 = this.f195a;
        if (!z8) {
            int i10 = i9 & 7;
            if (i10 == 1) {
                do {
                    list.add(Long.valueOf(mVar.w()));
                    if (mVar.g()) {
                        return;
                    } else {
                        B = mVar.B();
                    }
                } while (B == this.f195a);
                this.f197c = B;
                return;
            }
            if (i10 != 2) {
                throw e0.c();
            }
            int C = mVar.C();
            y(C);
            int f9 = mVar.f() + C;
            do {
                list.add(Long.valueOf(mVar.w()));
            } while (mVar.f() < f9);
            return;
        }
        l0 l0Var = (l0) list;
        int i11 = i9 & 7;
        if (i11 == 1) {
            do {
                l0Var.g(mVar.w());
                if (mVar.g()) {
                    return;
                } else {
                    B2 = mVar.B();
                }
            } while (B2 == this.f195a);
            this.f197c = B2;
            return;
        }
        if (i11 != 2) {
            throw e0.c();
        }
        int C2 = mVar.C();
        y(C2);
        int f10 = mVar.f() + C2;
        do {
            l0Var.g(mVar.w());
        } while (mVar.f() < f10);
    }

    public void q(List list) {
        int B;
        int B2;
        m mVar = (m) this.f198d;
        boolean z8 = list instanceof z;
        int i9 = this.f195a;
        if (!z8) {
            int i10 = i9 & 7;
            if (i10 == 0) {
                do {
                    list.add(Integer.valueOf(mVar.x()));
                    if (mVar.g()) {
                        return;
                    } else {
                        B = mVar.B();
                    }
                } while (B == this.f195a);
                this.f197c = B;
                return;
            }
            if (i10 != 2) {
                throw e0.c();
            }
            int f9 = mVar.f() + mVar.C();
            do {
                list.add(Integer.valueOf(mVar.x()));
            } while (mVar.f() < f9);
            v(f9);
            return;
        }
        z zVar = (z) list;
        int i11 = i9 & 7;
        if (i11 == 0) {
            do {
                zVar.g(mVar.x());
                if (mVar.g()) {
                    return;
                } else {
                    B2 = mVar.B();
                }
            } while (B2 == this.f195a);
            this.f197c = B2;
            return;
        }
        if (i11 != 2) {
            throw e0.c();
        }
        int f10 = mVar.f() + mVar.C();
        do {
            zVar.g(mVar.x());
        } while (mVar.f() < f10);
        v(f10);
    }

    public void r(List list) {
        int B;
        int B2;
        m mVar = (m) this.f198d;
        boolean z8 = list instanceof l0;
        int i9 = this.f195a;
        if (!z8) {
            int i10 = i9 & 7;
            if (i10 == 0) {
                do {
                    list.add(Long.valueOf(mVar.y()));
                    if (mVar.g()) {
                        return;
                    } else {
                        B = mVar.B();
                    }
                } while (B == this.f195a);
                this.f197c = B;
                return;
            }
            if (i10 != 2) {
                throw e0.c();
            }
            int f9 = mVar.f() + mVar.C();
            do {
                list.add(Long.valueOf(mVar.y()));
            } while (mVar.f() < f9);
            v(f9);
            return;
        }
        l0 l0Var = (l0) list;
        int i11 = i9 & 7;
        if (i11 == 0) {
            do {
                l0Var.g(mVar.y());
                if (mVar.g()) {
                    return;
                } else {
                    B2 = mVar.B();
                }
            } while (B2 == this.f195a);
            this.f197c = B2;
            return;
        }
        if (i11 != 2) {
            throw e0.c();
        }
        int f10 = mVar.f() + mVar.C();
        do {
            l0Var.g(mVar.y());
        } while (mVar.f() < f10);
        v(f10);
    }

    public void s(List list, boolean z8) {
        String z9;
        int B;
        int B2;
        m mVar = (m) this.f198d;
        if ((this.f195a & 7) != 2) {
            throw e0.c();
        }
        if ((list instanceof h0) && !z8) {
            h0 h0Var = (h0) list;
            do {
                h0Var.b(f());
                if (mVar.g()) {
                    return;
                } else {
                    B2 = mVar.B();
                }
            } while (B2 == this.f195a);
            this.f197c = B2;
            return;
        }
        do {
            if (z8) {
                w(2);
                z9 = mVar.A();
            } else {
                w(2);
                z9 = mVar.z();
            }
            list.add(z9);
            if (mVar.g()) {
                return;
            } else {
                B = mVar.B();
            }
        } while (B == this.f195a);
        this.f197c = B;
    }

    public void t(List list) {
        int B;
        int B2;
        m mVar = (m) this.f198d;
        boolean z8 = list instanceof z;
        int i9 = this.f195a;
        if (!z8) {
            int i10 = i9 & 7;
            if (i10 == 0) {
                do {
                    list.add(Integer.valueOf(mVar.C()));
                    if (mVar.g()) {
                        return;
                    } else {
                        B = mVar.B();
                    }
                } while (B == this.f195a);
                this.f197c = B;
                return;
            }
            if (i10 != 2) {
                throw e0.c();
            }
            int f9 = mVar.f() + mVar.C();
            do {
                list.add(Integer.valueOf(mVar.C()));
            } while (mVar.f() < f9);
            v(f9);
            return;
        }
        z zVar = (z) list;
        int i11 = i9 & 7;
        if (i11 == 0) {
            do {
                zVar.g(mVar.C());
                if (mVar.g()) {
                    return;
                } else {
                    B2 = mVar.B();
                }
            } while (B2 == this.f195a);
            this.f197c = B2;
            return;
        }
        if (i11 != 2) {
            throw e0.c();
        }
        int f10 = mVar.f() + mVar.C();
        do {
            zVar.g(mVar.C());
        } while (mVar.f() < f10);
        v(f10);
    }

    public void u(List list) {
        int B;
        int B2;
        m mVar = (m) this.f198d;
        boolean z8 = list instanceof l0;
        int i9 = this.f195a;
        if (!z8) {
            int i10 = i9 & 7;
            if (i10 == 0) {
                do {
                    list.add(Long.valueOf(mVar.D()));
                    if (mVar.g()) {
                        return;
                    } else {
                        B = mVar.B();
                    }
                } while (B == this.f195a);
                this.f197c = B;
                return;
            }
            if (i10 != 2) {
                throw e0.c();
            }
            int f9 = mVar.f() + mVar.C();
            do {
                list.add(Long.valueOf(mVar.D()));
            } while (mVar.f() < f9);
            v(f9);
            return;
        }
        l0 l0Var = (l0) list;
        int i11 = i9 & 7;
        if (i11 == 0) {
            do {
                l0Var.g(mVar.D());
                if (mVar.g()) {
                    return;
                } else {
                    B2 = mVar.B();
                }
            } while (B2 == this.f195a);
            this.f197c = B2;
            return;
        }
        if (i11 != 2) {
            throw e0.c();
        }
        int f10 = mVar.f() + mVar.C();
        do {
            l0Var.g(mVar.D());
        } while (mVar.f() < f10);
        v(f10);
    }

    public void v(int i9) {
        if (((m) this.f198d).f() != i9) {
            throw e0.g();
        }
    }

    public void w(int i9) {
        if ((this.f195a & 7) != i9) {
            throw e0.c();
        }
    }

    public k(View view) {
        this.f198d = view;
    }
}
