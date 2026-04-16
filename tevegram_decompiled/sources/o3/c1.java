package o3;

import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c1 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public int f7603i;

    /* renamed from: j, reason: collision with root package name */
    public int f7604j;

    /* renamed from: k, reason: collision with root package name */
    public OverScroller f7605k;

    /* renamed from: l, reason: collision with root package name */
    public Interpolator f7606l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7607m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f7608n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f7609o;

    public c1(RecyclerView recyclerView) {
        this.f7609o = recyclerView;
        e0 e0Var = RecyclerView.N0;
        this.f7606l = e0Var;
        this.f7607m = false;
        this.f7608n = false;
        this.f7605k = new OverScroller(recyclerView.getContext(), e0Var);
    }

    public final void a(int i9, int i10) {
        RecyclerView recyclerView = this.f7609o;
        recyclerView.setScrollState(2);
        this.f7604j = 0;
        this.f7603i = 0;
        Interpolator interpolator = this.f7606l;
        e0 e0Var = RecyclerView.N0;
        if (interpolator != e0Var) {
            this.f7606l = e0Var;
            this.f7605k = new OverScroller(recyclerView.getContext(), e0Var);
        }
        this.f7605k.fling(0, 0, i9, i10, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        b();
    }

    public final void b() {
        if (this.f7607m) {
            this.f7608n = true;
            return;
        }
        RecyclerView recyclerView = this.f7609o;
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = n0.t0.f7209a;
        n0.c0.m(recyclerView, this);
    }

    public final void c(int i9, int i10, int i11, Interpolator interpolator) {
        RecyclerView recyclerView = this.f7609o;
        if (i11 == Integer.MIN_VALUE) {
            int abs = Math.abs(i9);
            int abs2 = Math.abs(i10);
            boolean z8 = abs > abs2;
            int width = z8 ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z8) {
                abs = abs2;
            }
            i11 = Math.min((int) (((abs / width) + 1.0f) * 300.0f), 2000);
        }
        int i12 = i11;
        if (interpolator == null) {
            interpolator = RecyclerView.N0;
        }
        if (this.f7606l != interpolator) {
            this.f7606l = interpolator;
            this.f7605k = new OverScroller(recyclerView.getContext(), interpolator);
        }
        this.f7604j = 0;
        this.f7603i = 0;
        recyclerView.setScrollState(2);
        this.f7605k.startScroll(0, 0, i9, i10, i12);
        if (Build.VERSION.SDK_INT < 23) {
            this.f7605k.computeScrollOffset();
        }
        b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i9;
        int i10;
        int i11;
        int i12;
        boolean awakenScrollBars;
        RecyclerView recyclerView = this.f7609o;
        int[] iArr = recyclerView.A0;
        if (recyclerView.f1080v == null) {
            recyclerView.removeCallbacks(this);
            this.f7605k.abortAnimation();
            return;
        }
        this.f7608n = false;
        this.f7607m = true;
        recyclerView.n();
        OverScroller overScroller = this.f7605k;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i13 = currX - this.f7603i;
            int i14 = currY - this.f7604j;
            this.f7603i = currX;
            this.f7604j = currY;
            int m9 = RecyclerView.m(i13, recyclerView.P, recyclerView.R, recyclerView.getWidth());
            int m10 = RecyclerView.m(i14, recyclerView.Q, recyclerView.S, recyclerView.getHeight());
            int[] iArr2 = recyclerView.A0;
            iArr2[0] = 0;
            iArr2[1] = 0;
            if (recyclerView.s(m9, m10, iArr2, null, 1)) {
                m9 -= iArr[0];
                m10 -= iArr[1];
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.l(m9, m10);
            }
            if (recyclerView.f1078u != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                recyclerView.c0(m9, m10, iArr);
                int i15 = iArr[0];
                int i16 = iArr[1];
                int i17 = m9 - i15;
                int i18 = m10 - i16;
                z zVar = recyclerView.f1080v.f7752e;
                if (zVar != null && !zVar.f7856d && zVar.f7857e) {
                    int b9 = recyclerView.f1067o0.b();
                    if (b9 == 0) {
                        zVar.i();
                    } else if (zVar.f7853a >= b9) {
                        zVar.f7853a = b9 - 1;
                        zVar.g(i15, i16);
                    } else {
                        zVar.g(i15, i16);
                    }
                }
                i9 = i17;
                i11 = i15;
                i10 = i18;
                i12 = i16;
            } else {
                i9 = m9;
                i10 = m10;
                i11 = 0;
                i12 = 0;
            }
            if (!recyclerView.f1084x.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr3 = recyclerView.A0;
            iArr3[0] = 0;
            iArr3[1] = 0;
            recyclerView.t(i11, i12, i9, i10, null, 1, iArr3);
            int i19 = i9 - iArr[0];
            int i20 = i10 - iArr[1];
            if (i11 != 0 || i12 != 0) {
                recyclerView.u(i11, i12);
            }
            awakenScrollBars = recyclerView.awakenScrollBars();
            if (!awakenScrollBars) {
                recyclerView.invalidate();
            }
            boolean z8 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i19 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i20 != 0));
            z zVar2 = recyclerView.f1080v.f7752e;
            if ((zVar2 == null || !zVar2.f7856d) && z8) {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    int i21 = i19 < 0 ? -currVelocity : i19 > 0 ? currVelocity : 0;
                    if (i20 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i20 <= 0) {
                        currVelocity = 0;
                    }
                    if (i21 < 0) {
                        recyclerView.w();
                        if (recyclerView.P.isFinished()) {
                            recyclerView.P.onAbsorb(-i21);
                        }
                    } else if (i21 > 0) {
                        recyclerView.x();
                        if (recyclerView.R.isFinished()) {
                            recyclerView.R.onAbsorb(i21);
                        }
                    }
                    if (currVelocity < 0) {
                        recyclerView.y();
                        if (recyclerView.Q.isFinished()) {
                            recyclerView.Q.onAbsorb(-currVelocity);
                        }
                    } else if (currVelocity > 0) {
                        recyclerView.v();
                        if (recyclerView.S.isFinished()) {
                            recyclerView.S.onAbsorb(currVelocity);
                        }
                    }
                    if (i21 != 0 || currVelocity != 0) {
                        WeakHashMap weakHashMap = n0.t0.f7209a;
                        n0.c0.k(recyclerView);
                    }
                }
                if (RecyclerView.L0) {
                    r rVar = recyclerView.f1065n0;
                    int[] iArr4 = rVar.f7794a;
                    if (iArr4 != null) {
                        Arrays.fill(iArr4, -1);
                    }
                    rVar.f7797d = 0;
                }
            } else {
                b();
                t tVar = recyclerView.f1063m0;
                if (tVar != null) {
                    tVar.a(recyclerView, i11, i12);
                }
            }
        }
        z zVar3 = recyclerView.f1080v.f7752e;
        if (zVar3 != null && zVar3.f7856d) {
            zVar3.g(0, 0);
        }
        this.f7607m = false;
        if (!this.f7608n) {
            recyclerView.setScrollState(0);
            recyclerView.i0(1);
        } else {
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap2 = n0.t0.f7209a;
            n0.c0.m(recyclerView, this);
        }
    }
}
