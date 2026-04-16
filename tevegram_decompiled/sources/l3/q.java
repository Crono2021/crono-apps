package l3;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import d1.d1;
import d1.e1;
import d1.f1;
import d1.o0;
import d1.t0;
import d1.w0;
import d1.x0;
import d1.y0;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q extends FrameLayout {
    public static final float[] G0;
    public final TextView A;
    public long[] A0;
    public final ImageView B;
    public boolean[] B0;
    public final ImageView C;
    public final long[] C0;
    public final View D;
    public final boolean[] D0;
    public final ImageView E;
    public long E0;
    public final ImageView F;
    public boolean F0;
    public final ImageView G;
    public final View H;
    public final View I;
    public final View J;
    public final TextView K;
    public final TextView L;
    public final d M;
    public final StringBuilder N;
    public final Formatter O;
    public final w0 P;
    public final x0 Q;
    public final a7.a R;
    public final Drawable S;
    public final Drawable T;
    public final Drawable U;
    public final String V;
    public final String W;

    /* renamed from: a0, reason: collision with root package name */
    public final String f6184a0;

    /* renamed from: b0, reason: collision with root package name */
    public final Drawable f6185b0;

    /* renamed from: c0, reason: collision with root package name */
    public final Drawable f6186c0;

    /* renamed from: d0, reason: collision with root package name */
    public final float f6187d0;

    /* renamed from: e0, reason: collision with root package name */
    public final float f6188e0;

    /* renamed from: f0, reason: collision with root package name */
    public final String f6189f0;

    /* renamed from: g0, reason: collision with root package name */
    public final String f6190g0;

    /* renamed from: h0, reason: collision with root package name */
    public final Drawable f6191h0;

    /* renamed from: i, reason: collision with root package name */
    public final v f6192i;
    public final Drawable i0;

    /* renamed from: j, reason: collision with root package name */
    public final Resources f6193j;

    /* renamed from: j0, reason: collision with root package name */
    public final String f6194j0;

    /* renamed from: k, reason: collision with root package name */
    public final g f6195k;

    /* renamed from: k0, reason: collision with root package name */
    public final String f6196k0;

    /* renamed from: l, reason: collision with root package name */
    public final CopyOnWriteArrayList f6197l;

    /* renamed from: l0, reason: collision with root package name */
    public final Drawable f6198l0;

    /* renamed from: m, reason: collision with root package name */
    public final RecyclerView f6199m;

    /* renamed from: m0, reason: collision with root package name */
    public final Drawable f6200m0;

    /* renamed from: n, reason: collision with root package name */
    public final i7.l f6201n;

    /* renamed from: n0, reason: collision with root package name */
    public final String f6202n0;

    /* renamed from: o, reason: collision with root package name */
    public final j f6203o;

    /* renamed from: o0, reason: collision with root package name */
    public final String f6204o0;

    /* renamed from: p, reason: collision with root package name */
    public final f f6205p;

    /* renamed from: p0, reason: collision with root package name */
    public t0 f6206p0;

    /* renamed from: q, reason: collision with root package name */
    public final f f6207q;

    /* renamed from: q0, reason: collision with root package name */
    public h f6208q0;

    /* renamed from: r, reason: collision with root package name */
    public final h4.x f6209r;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f6210r0;

    /* renamed from: s, reason: collision with root package name */
    public final PopupWindow f6211s;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f6212s0;

    /* renamed from: t, reason: collision with root package name */
    public final int f6213t;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f6214t0;

    /* renamed from: u, reason: collision with root package name */
    public final View f6215u;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f6216u0;

    /* renamed from: v, reason: collision with root package name */
    public final View f6217v;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f6218v0;

    /* renamed from: w, reason: collision with root package name */
    public final View f6219w;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f6220w0;

    /* renamed from: x, reason: collision with root package name */
    public final View f6221x;

    /* renamed from: x0, reason: collision with root package name */
    public int f6222x0;

    /* renamed from: y, reason: collision with root package name */
    public final View f6223y;

    /* renamed from: y0, reason: collision with root package name */
    public int f6224y0;

    /* renamed from: z, reason: collision with root package name */
    public final TextView f6225z;

    /* renamed from: z0, reason: collision with root package name */
    public int f6226z0;

    static {
        d1.f0.a("media3.ui");
        G0 = new float[]{0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
    }

    public q(Context context, AttributeSet attributeSet) {
        super(context, null, 0);
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        ImageView imageView;
        g gVar;
        boolean z19;
        boolean z20;
        Typeface b9;
        this.f6216u0 = true;
        this.f6222x0 = 5000;
        this.f6226z0 = 0;
        this.f6224y0 = 200;
        int i9 = 2131558462;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, b0.f6088c, 0, 0);
            try {
                i9 = obtainStyledAttributes.getResourceId(6, 2131558462);
                this.f6222x0 = obtainStyledAttributes.getInt(21, this.f6222x0);
                this.f6226z0 = obtainStyledAttributes.getInt(9, this.f6226z0);
                boolean z21 = obtainStyledAttributes.getBoolean(18, true);
                boolean z22 = obtainStyledAttributes.getBoolean(15, true);
                boolean z23 = obtainStyledAttributes.getBoolean(17, true);
                boolean z24 = obtainStyledAttributes.getBoolean(16, true);
                boolean z25 = obtainStyledAttributes.getBoolean(19, false);
                boolean z26 = obtainStyledAttributes.getBoolean(20, false);
                boolean z27 = obtainStyledAttributes.getBoolean(22, false);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(23, this.f6224y0));
                boolean z28 = obtainStyledAttributes.getBoolean(2, true);
                obtainStyledAttributes.recycle();
                z12 = z27;
                z8 = z26;
                z9 = z28;
                z13 = z21;
                z10 = z24;
                z14 = z22;
                z11 = z25;
                z15 = z23;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z8 = false;
            z9 = true;
            z10 = true;
            z11 = false;
            z12 = false;
            z13 = true;
            z14 = true;
            z15 = true;
        }
        LayoutInflater.from(context).inflate(i9, this);
        setDescendantFocusability(262144);
        g gVar2 = new g(this);
        this.f6195k = gVar2;
        this.f6197l = new CopyOnWriteArrayList();
        this.P = new w0();
        this.Q = new x0();
        StringBuilder sb = new StringBuilder();
        this.N = sb;
        this.O = new Formatter(sb, Locale.getDefault());
        this.A0 = new long[0];
        this.B0 = new boolean[0];
        this.C0 = new long[0];
        this.D0 = new boolean[0];
        this.R = new a7.a(this, 15);
        this.K = (TextView) findViewById(2131362051);
        this.L = (TextView) findViewById(2131362070);
        ImageView imageView2 = (ImageView) findViewById(2131362082);
        this.E = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(gVar2);
        }
        ImageView imageView3 = (ImageView) findViewById(2131362057);
        this.F = imageView3;
        com.google.android.material.datepicker.n nVar = new com.google.android.material.datepicker.n(this, 4);
        if (imageView3 != null) {
            imageView3.setVisibility(8);
            imageView3.setOnClickListener(nVar);
        }
        ImageView imageView4 = (ImageView) findViewById(2131362061);
        this.G = imageView4;
        com.google.android.material.datepicker.n nVar2 = new com.google.android.material.datepicker.n(this, 4);
        if (imageView4 != null) {
            imageView4.setVisibility(8);
            imageView4.setOnClickListener(nVar2);
        }
        View findViewById = findViewById(2131362077);
        this.H = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(gVar2);
        }
        View findViewById2 = findViewById(2131362069);
        this.I = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(gVar2);
        }
        View findViewById3 = findViewById(2131362041);
        this.J = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(gVar2);
        }
        d dVar = (d) findViewById(2131362072);
        View findViewById4 = findViewById(2131362073);
        if (dVar != null) {
            this.M = dVar;
        } else if (findViewById4 != null) {
            d dVar2 = new d(context, attributeSet);
            dVar2.setId(2131362072);
            dVar2.setLayoutParams(findViewById4.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById4.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById4);
            viewGroup.removeView(findViewById4);
            viewGroup.addView(dVar2, indexOfChild);
            this.M = dVar2;
        } else {
            this.M = null;
        }
        d dVar3 = this.M;
        if (dVar3 != null) {
            dVar3.F.add(gVar2);
        }
        View findViewById5 = findViewById(2131362068);
        this.f6219w = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(gVar2);
        }
        View findViewById6 = findViewById(2131362071);
        this.f6215u = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(gVar2);
        }
        View findViewById7 = findViewById(2131362062);
        this.f6217v = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(gVar2);
        }
        ThreadLocal threadLocal = e0.o.f3001a;
        if (context.isRestricted()) {
            z18 = z8;
            z17 = z9;
            z16 = z11;
            z19 = z12;
            imageView = imageView2;
            b9 = null;
            gVar = gVar2;
            z20 = z10;
        } else {
            z16 = z11;
            z17 = z9;
            z18 = z8;
            imageView = imageView2;
            gVar = gVar2;
            z19 = z12;
            z20 = z10;
            b9 = e0.o.b(context, 2131296256, new TypedValue(), 0, null, false, false);
        }
        View findViewById8 = findViewById(2131362075);
        TextView textView = findViewById8 == null ? (TextView) findViewById(2131362076) : null;
        this.A = textView;
        if (textView != null) {
            textView.setTypeface(b9);
        }
        findViewById8 = findViewById8 == null ? textView : findViewById8;
        this.f6223y = findViewById8;
        if (findViewById8 != null) {
            findViewById8.setOnClickListener(gVar);
        }
        View findViewById9 = findViewById(2131362055);
        TextView textView2 = findViewById9 == null ? (TextView) findViewById(2131362056) : null;
        this.f6225z = textView2;
        if (textView2 != null) {
            textView2.setTypeface(b9);
        }
        findViewById9 = findViewById9 == null ? textView2 : findViewById9;
        this.f6221x = findViewById9;
        if (findViewById9 != null) {
            findViewById9.setOnClickListener(gVar);
        }
        ImageView imageView5 = (ImageView) findViewById(2131362074);
        this.B = imageView5;
        if (imageView5 != null) {
            imageView5.setOnClickListener(gVar);
        }
        ImageView imageView6 = (ImageView) findViewById(2131362079);
        this.C = imageView6;
        if (imageView6 != null) {
            imageView6.setOnClickListener(gVar);
        }
        Resources resources = context.getResources();
        this.f6193j = resources;
        this.f6187d0 = resources.getInteger(2131427337) / 100.0f;
        this.f6188e0 = resources.getInteger(2131427336) / 100.0f;
        View findViewById10 = findViewById(2131362087);
        this.D = findViewById10;
        if (findViewById10 != null) {
            k(findViewById10, false);
        }
        v vVar = new v(this);
        this.f6192i = vVar;
        vVar.C = z17;
        i7.l lVar = new i7.l(this, new String[]{resources.getString(2131951679), resources.getString(2131951712)}, new Drawable[]{g1.w.s(context, resources, 2131230944), g1.w.s(context, resources, 2131230926)});
        this.f6201n = lVar;
        this.f6213t = resources.getDimensionPixelSize(2131165344);
        boolean z29 = z20;
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(2131558464, (ViewGroup) null);
        this.f6199m = recyclerView;
        recyclerView.setAdapter(lVar);
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        PopupWindow popupWindow = new PopupWindow((View) recyclerView, -2, -2, true);
        this.f6211s = popupWindow;
        if (g1.w.f3713a < 23) {
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        }
        popupWindow.setOnDismissListener(gVar);
        this.F0 = true;
        this.f6209r = new h4.x(getResources());
        this.f6191h0 = g1.w.s(context, resources, 2131230946);
        this.i0 = g1.w.s(context, resources, 2131230945);
        this.f6194j0 = resources.getString(2131951668);
        this.f6196k0 = resources.getString(2131951667);
        this.f6205p = new f(this, 1);
        this.f6207q = new f(this, 0);
        this.f6203o = new j(this, resources.getStringArray(2130903040), G0);
        this.f6198l0 = g1.w.s(context, resources, 2131230930);
        this.f6200m0 = g1.w.s(context, resources, 2131230929);
        this.S = g1.w.s(context, resources, 2131230938);
        this.T = g1.w.s(context, resources, 2131230939);
        this.U = g1.w.s(context, resources, 2131230937);
        this.f6185b0 = g1.w.s(context, resources, 2131230943);
        this.f6186c0 = g1.w.s(context, resources, 2131230942);
        this.f6202n0 = resources.getString(2131951672);
        this.f6204o0 = resources.getString(2131951671);
        this.V = resources.getString(2131951682);
        this.W = resources.getString(2131951683);
        this.f6184a0 = resources.getString(2131951681);
        this.f6189f0 = resources.getString(2131951689);
        this.f6190g0 = resources.getString(2131951688);
        vVar.h((ViewGroup) findViewById(2131362043), true);
        vVar.h(findViewById9, z14);
        vVar.h(findViewById8, z13);
        vVar.h(findViewById6, z15);
        vVar.h(findViewById7, z29);
        vVar.h(imageView6, z16);
        vVar.h(imageView, z18);
        vVar.h(findViewById10, z19);
        vVar.h(imageView5, this.f6226z0 != 0);
        addOnLayoutChangeListener(new e(this, 0));
    }

    public static void a(q qVar) {
        String str = qVar.f6204o0;
        Drawable drawable = qVar.f6200m0;
        String str2 = qVar.f6202n0;
        Drawable drawable2 = qVar.f6198l0;
        if (qVar.f6208q0 == null) {
            return;
        }
        boolean z8 = qVar.f6210r0;
        qVar.f6210r0 = !z8;
        ImageView imageView = qVar.F;
        if (imageView != null) {
            if (z8) {
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
            } else {
                imageView.setImageDrawable(drawable2);
                imageView.setContentDescription(str2);
            }
        }
        ImageView imageView2 = qVar.G;
        boolean z9 = qVar.f6210r0;
        if (imageView2 == null) {
            return;
        }
        if (z9) {
            imageView2.setImageDrawable(drawable2);
            imageView2.setContentDescription(str2);
        } else {
            imageView2.setImageDrawable(drawable);
            imageView2.setContentDescription(str);
        }
    }

    public static boolean c(t0 t0Var, x0 x0Var) {
        y0 U;
        int o8;
        if (t0Var.J(17) && (o8 = (U = t0Var.U()).o()) > 1 && o8 <= 100) {
            for (int i9 = 0; i9 < o8; i9++) {
                if (U.m(i9, x0Var, 0L).f2606n != -9223372036854775807L) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f9) {
        t0 t0Var = this.f6206p0;
        if (t0Var == null || !t0Var.J(13)) {
            return;
        }
        t0 t0Var2 = this.f6206p0;
        t0Var2.e(new o0(f9, t0Var2.d().f2511b));
    }

    public final boolean d(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        t0 t0Var = this.f6206p0;
        if (t0Var == null) {
            return false;
        }
        if (keyCode != 90 && keyCode != 89 && keyCode != 85 && keyCode != 79 && keyCode != 126 && keyCode != 127 && keyCode != 87 && keyCode != 88) {
            return false;
        }
        if (keyEvent.getAction() == 0) {
            if (keyCode == 90) {
                if (t0Var.t() != 4 && t0Var.J(12)) {
                    t0Var.d0();
                }
            } else if (keyCode == 89 && t0Var.J(11)) {
                t0Var.g0();
            } else if (keyEvent.getRepeatCount() == 0) {
                if (keyCode == 79 || keyCode == 85) {
                    if (g1.w.U(t0Var, this.f6216u0)) {
                        g1.w.E(t0Var);
                    } else if (t0Var.J(1)) {
                        t0Var.pause();
                    }
                } else if (keyCode != 87) {
                    if (keyCode != 88) {
                        if (keyCode == 126) {
                            g1.w.E(t0Var);
                        } else if (keyCode == 127) {
                            int i9 = g1.w.f3713a;
                            if (t0Var.J(1)) {
                                t0Var.pause();
                            }
                        }
                    } else if (t0Var.J(7)) {
                        t0Var.j0();
                    }
                } else if (t0Var.J(9)) {
                    t0Var.c0();
                }
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return d(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public final void e(o3.g0 g0Var, View view) {
        this.f6199m.setAdapter(g0Var);
        q();
        this.F0 = false;
        PopupWindow popupWindow = this.f6211s;
        popupWindow.dismiss();
        this.F0 = true;
        int width = getWidth() - popupWindow.getWidth();
        int i9 = this.f6213t;
        popupWindow.showAsDropDown(view, width - i9, (-popupWindow.getHeight()) - i9);
    }

    public final b6.w0 f(f1 f1Var, int i9) {
        b6.q.b(4, "initialCapacity");
        Object[] objArr = new Object[4];
        b6.g0 g0Var = f1Var.f2422a;
        int i10 = 0;
        for (int i11 = 0; i11 < g0Var.size(); i11++) {
            e1 e1Var = (e1) g0Var.get(i11);
            if (e1Var.f2415b.f2618c == i9) {
                for (int i12 = 0; i12 < e1Var.f2414a; i12++) {
                    if (e1Var.c(i12)) {
                        d1.s a9 = e1Var.a(i12);
                        if ((a9.f2547e & 2) == 0) {
                            n nVar = new n(f1Var, i11, i12, this.f6209r.c(a9));
                            int i13 = i10 + 1;
                            if (objArr.length < i13) {
                                objArr = Arrays.copyOf(objArr, b6.a0.d(objArr.length, i13));
                            }
                            objArr[i10] = nVar;
                            i10 = i13;
                        }
                    }
                }
            }
        }
        return b6.g0.l(i10, objArr);
    }

    public final void g() {
        v vVar = this.f6192i;
        int i9 = vVar.f6260z;
        if (i9 == 3 || i9 == 2) {
            return;
        }
        vVar.f();
        if (!vVar.C) {
            vVar.i(2);
        } else if (vVar.f6260z == 1) {
            vVar.f6247m.start();
        } else {
            vVar.f6248n.start();
        }
    }

    public t0 getPlayer() {
        return this.f6206p0;
    }

    public int getRepeatToggleModes() {
        return this.f6226z0;
    }

    public boolean getShowShuffleButton() {
        return this.f6192i.b(this.C);
    }

    public boolean getShowSubtitleButton() {
        return this.f6192i.b(this.E);
    }

    public int getShowTimeoutMs() {
        return this.f6222x0;
    }

    public boolean getShowVrButton() {
        return this.f6192i.b(this.D);
    }

    public final boolean h() {
        v vVar = this.f6192i;
        return vVar.f6260z == 0 && vVar.f6236a.i();
    }

    public final boolean i() {
        return getVisibility() == 0;
    }

    public final void j() {
        m();
        l();
        p();
        r();
        t();
        n();
        s();
    }

    public final void k(View view, boolean z8) {
        if (view == null) {
            return;
        }
        view.setEnabled(z8);
        view.setAlpha(z8 ? this.f6187d0 : this.f6188e0);
    }

    public final void l() {
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        if (i() && this.f6212s0) {
            t0 t0Var = this.f6206p0;
            if (t0Var != null) {
                z9 = (this.f6214t0 && c(t0Var, this.Q)) ? t0Var.J(10) : t0Var.J(5);
                z10 = t0Var.J(7);
                z11 = t0Var.J(11);
                z12 = t0Var.J(12);
                z8 = t0Var.J(9);
            } else {
                z8 = false;
                z9 = false;
                z10 = false;
                z11 = false;
                z12 = false;
            }
            Resources resources = this.f6193j;
            View view = this.f6223y;
            if (z11) {
                t0 t0Var2 = this.f6206p0;
                int k02 = (int) ((t0Var2 != null ? t0Var2.k0() : l1.k.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS) / 1000);
                TextView textView = this.A;
                if (textView != null) {
                    textView.setText(String.valueOf(k02));
                }
                if (view != null) {
                    view.setContentDescription(resources.getQuantityString(2131820545, k02, Integer.valueOf(k02)));
                }
            }
            View view2 = this.f6221x;
            if (z12) {
                t0 t0Var3 = this.f6206p0;
                int i9 = (int) ((t0Var3 != null ? t0Var3.i() : 15000L) / 1000);
                TextView textView2 = this.f6225z;
                if (textView2 != null) {
                    textView2.setText(String.valueOf(i9));
                }
                if (view2 != null) {
                    view2.setContentDescription(resources.getQuantityString(2131820544, i9, Integer.valueOf(i9)));
                }
            }
            k(this.f6215u, z10);
            k(view, z11);
            k(view2, z12);
            k(this.f6217v, z8);
            d dVar = this.M;
            if (dVar != null) {
                dVar.setEnabled(z9);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
    
        if (r6.f6206p0.U().p() == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m() {
        /*
            r6 = this;
            boolean r0 = r6.i()
            if (r0 == 0) goto L66
            boolean r0 = r6.f6212s0
            if (r0 != 0) goto Lb
            goto L66
        Lb:
            android.view.View r0 = r6.f6219w
            if (r0 == 0) goto L66
            d1.t0 r1 = r6.f6206p0
            boolean r2 = r6.f6216u0
            boolean r1 = g1.w.U(r1, r2)
            if (r1 == 0) goto L1d
            r2 = 2131230935(0x7f0800d7, float:1.8077937E38)
            goto L20
        L1d:
            r2 = 2131230934(0x7f0800d6, float:1.8077935E38)
        L20:
            if (r1 == 0) goto L26
            r1 = 2131951678(0x7f13003e, float:1.9539777E38)
            goto L29
        L26:
            r1 = 2131951677(0x7f13003d, float:1.9539775E38)
        L29:
            r3 = r0
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            android.content.Context r4 = r6.getContext()
            android.content.res.Resources r5 = r6.f6193j
            android.graphics.drawable.Drawable r2 = g1.w.s(r4, r5, r2)
            r3.setImageDrawable(r2)
            java.lang.String r1 = r5.getString(r1)
            r0.setContentDescription(r1)
            d1.t0 r1 = r6.f6206p0
            if (r1 == 0) goto L62
            r2 = 1
            boolean r1 = r1.J(r2)
            if (r1 == 0) goto L62
            d1.t0 r1 = r6.f6206p0
            r3 = 17
            boolean r1 = r1.J(r3)
            if (r1 == 0) goto L63
            d1.t0 r1 = r6.f6206p0
            d1.y0 r1 = r1.U()
            boolean r1 = r1.p()
            if (r1 != 0) goto L62
            goto L63
        L62:
            r2 = 0
        L63:
            r6.k(r0, r2)
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.q.m():void");
    }

    public final void n() {
        j jVar;
        t0 t0Var = this.f6206p0;
        if (t0Var == null) {
            return;
        }
        float f9 = t0Var.d().f2510a;
        float f10 = Float.MAX_VALUE;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            jVar = this.f6203o;
            float[] fArr = jVar.f6161e;
            if (i9 >= fArr.length) {
                break;
            }
            float abs = Math.abs(f9 - fArr[i9]);
            if (abs < f10) {
                i10 = i9;
                f10 = abs;
            }
            i9++;
        }
        jVar.f6162f = i10;
        String str = jVar.f6160d[i10];
        i7.l lVar = this.f6201n;
        ((String[]) lVar.f4949e)[0] = str;
        k(this.H, lVar.f(1) || lVar.f(0));
    }

    public final void o() {
        long j5;
        long j9;
        if (i() && this.f6212s0) {
            t0 t0Var = this.f6206p0;
            if (t0Var == null || !t0Var.J(16)) {
                j5 = 0;
                j9 = 0;
            } else {
                j5 = t0Var.j() + this.E0;
                j9 = t0Var.Z() + this.E0;
            }
            TextView textView = this.L;
            if (textView != null && !this.f6220w0) {
                textView.setText(g1.w.B(this.N, this.O, j5));
            }
            d dVar = this.M;
            if (dVar != null) {
                dVar.setPosition(j5);
                dVar.setBufferedPosition(j9);
            }
            a7.a aVar = this.R;
            removeCallbacks(aVar);
            int t8 = t0Var == null ? 1 : t0Var.t();
            if (t0Var != null && t0Var.isPlaying()) {
                long min = Math.min(dVar != null ? dVar.getPreferredUpdateDelay() : 1000L, 1000 - (j5 % 1000));
                float f9 = t0Var.d().f2510a;
                postDelayed(aVar, g1.w.i(f9 > 0.0f ? (long) (min / f9) : 1000L, this.f6224y0, 1000L));
            } else {
                if (t8 == 4 || t8 == 1) {
                    return;
                }
                postDelayed(aVar, 1000L);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        v vVar = this.f6192i;
        vVar.f6236a.addOnLayoutChangeListener(vVar.f6258x);
        this.f6212s0 = true;
        if (h()) {
            vVar.g();
        }
        j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v vVar = this.f6192i;
        vVar.f6236a.removeOnLayoutChangeListener(vVar.f6258x);
        this.f6212s0 = false;
        removeCallbacks(this.R);
        vVar.f();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        View view = this.f6192i.f6237b;
        if (view != null) {
            view.layout(0, 0, i11 - i9, i12 - i10);
        }
    }

    public final void p() {
        ImageView imageView;
        if (i() && this.f6212s0 && (imageView = this.B) != null) {
            if (this.f6226z0 == 0) {
                k(imageView, false);
                return;
            }
            t0 t0Var = this.f6206p0;
            String str = this.V;
            Drawable drawable = this.S;
            if (t0Var == null || !t0Var.J(15)) {
                k(imageView, false);
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
                return;
            }
            k(imageView, true);
            int S = t0Var.S();
            if (S == 0) {
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
            } else if (S == 1) {
                imageView.setImageDrawable(this.T);
                imageView.setContentDescription(this.W);
            } else {
                if (S != 2) {
                    return;
                }
                imageView.setImageDrawable(this.U);
                imageView.setContentDescription(this.f6184a0);
            }
        }
    }

    public final void q() {
        RecyclerView recyclerView = this.f6199m;
        recyclerView.measure(0, 0);
        int width = getWidth();
        int i9 = this.f6213t;
        int min = Math.min(recyclerView.getMeasuredWidth(), width - (i9 * 2));
        PopupWindow popupWindow = this.f6211s;
        popupWindow.setWidth(min);
        popupWindow.setHeight(Math.min(getHeight() - (i9 * 2), recyclerView.getMeasuredHeight()));
    }

    public final void r() {
        ImageView imageView;
        if (i() && this.f6212s0 && (imageView = this.C) != null) {
            t0 t0Var = this.f6206p0;
            if (!this.f6192i.b(imageView)) {
                k(imageView, false);
                return;
            }
            String str = this.f6190g0;
            Drawable drawable = this.f6186c0;
            if (t0Var == null || !t0Var.J(14)) {
                k(imageView, false);
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
                return;
            }
            k(imageView, true);
            if (t0Var.X()) {
                drawable = this.f6185b0;
            }
            imageView.setImageDrawable(drawable);
            if (t0Var.X()) {
                str = this.f6189f0;
            }
            imageView.setContentDescription(str);
        }
    }

    public final void s() {
        boolean z8;
        long j5;
        int i9;
        int i10;
        y0 y0Var;
        boolean[] zArr;
        boolean z9;
        t0 t0Var = this.f6206p0;
        if (t0Var == null) {
            return;
        }
        boolean z10 = this.f6214t0;
        x0 x0Var = this.Q;
        boolean z11 = false;
        boolean z12 = true;
        this.f6218v0 = z10 && c(t0Var, x0Var);
        long j9 = 0;
        this.E0 = 0L;
        y0 U = t0Var.J(17) ? t0Var.U() : y0.f2610a;
        long j10 = -9223372036854775807L;
        if (U.p()) {
            z8 = true;
            if (t0Var.J(16)) {
                long z13 = t0Var.z();
                if (z13 != -9223372036854775807L) {
                    j5 = g1.w.M(z13);
                    i9 = 0;
                }
            }
            j5 = 0;
            i9 = 0;
        } else {
            int I = t0Var.I();
            boolean z14 = this.f6218v0;
            int i11 = z14 ? 0 : I;
            int o8 = z14 ? U.o() - 1 : I;
            long j11 = 0;
            i9 = 0;
            while (true) {
                if (i11 > o8) {
                    break;
                }
                long j12 = j9;
                if (i11 == I) {
                    this.E0 = g1.w.W(j11);
                }
                U.n(i11, x0Var);
                if (x0Var.f2606n == j10) {
                    g1.a.k(this.f6218v0 ^ z12);
                    break;
                }
                int i12 = x0Var.f2607o;
                while (i12 <= x0Var.f2608p) {
                    w0 w0Var = this.P;
                    U.f(i12, w0Var, z11);
                    long j13 = j10;
                    d1.c cVar = w0Var.f2590g;
                    cVar.getClass();
                    int i13 = cVar.f2369a;
                    int i14 = 0;
                    while (i14 < i13) {
                        w0Var.d(i14);
                        long j14 = w0Var.f2588e;
                        if (j14 >= j12) {
                            long[] jArr = this.A0;
                            i10 = I;
                            if (i9 == jArr.length) {
                                int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                this.A0 = Arrays.copyOf(jArr, length);
                                this.B0 = Arrays.copyOf(this.B0, length);
                            }
                            this.A0[i9] = g1.w.W(j14 + j11);
                            boolean[] zArr2 = this.B0;
                            d1.b a9 = w0Var.f2590g.a(i14);
                            int i15 = a9.f2355a;
                            if (i15 == -1) {
                                zArr = zArr2;
                                y0Var = U;
                            } else {
                                int i16 = 0;
                                while (i16 < i15) {
                                    zArr = zArr2;
                                    int i17 = a9.f2359e[i16];
                                    y0Var = U;
                                    if (i17 != 0 && i17 != 1) {
                                        i16++;
                                        zArr2 = zArr;
                                        U = y0Var;
                                    }
                                }
                                zArr = zArr2;
                                y0Var = U;
                                z9 = false;
                                zArr[i9] = !z9;
                                i9++;
                            }
                            z9 = true;
                            zArr[i9] = !z9;
                            i9++;
                        } else {
                            i10 = I;
                            y0Var = U;
                        }
                        i14++;
                        I = i10;
                        U = y0Var;
                        j12 = 0;
                    }
                    i12++;
                    j10 = j13;
                    U = U;
                    z11 = false;
                    j12 = 0;
                }
                j11 += x0Var.f2606n;
                i11++;
                U = U;
                z11 = false;
                z12 = true;
                j9 = 0;
            }
            z8 = true;
            j5 = j11;
        }
        long W = g1.w.W(j5);
        TextView textView = this.K;
        if (textView != null) {
            textView.setText(g1.w.B(this.N, this.O, W));
        }
        d dVar = this.M;
        if (dVar != null) {
            dVar.setDuration(W);
            long[] jArr2 = this.C0;
            int length2 = jArr2.length;
            int i18 = i9 + length2;
            long[] jArr3 = this.A0;
            if (i18 > jArr3.length) {
                this.A0 = Arrays.copyOf(jArr3, i18);
                this.B0 = Arrays.copyOf(this.B0, i18);
            }
            System.arraycopy(jArr2, 0, this.A0, i9, length2);
            System.arraycopy(this.D0, 0, this.B0, i9, length2);
            long[] jArr4 = this.A0;
            boolean[] zArr3 = this.B0;
            if (i18 != 0 && (jArr4 == null || zArr3 == null)) {
                z8 = false;
            }
            g1.a.f(z8);
            dVar.U = i18;
            dVar.V = jArr4;
            dVar.W = zArr3;
            dVar.e();
        }
        o();
    }

    public void setAnimationEnabled(boolean z8) {
        this.f6192i.C = z8;
    }

    @Deprecated
    public void setOnFullScreenModeChangedListener(h hVar) {
        this.f6208q0 = hVar;
        boolean z8 = hVar != null;
        ImageView imageView = this.F;
        if (imageView != null) {
            if (z8) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        boolean z9 = hVar != null;
        ImageView imageView2 = this.G;
        if (imageView2 == null) {
            return;
        }
        if (z9) {
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(8);
        }
    }

    public void setPlayer(t0 t0Var) {
        g1.a.k(Looper.myLooper() == Looper.getMainLooper());
        g1.a.f(t0Var == null || t0Var.W() == Looper.getMainLooper());
        t0 t0Var2 = this.f6206p0;
        if (t0Var2 == t0Var) {
            return;
        }
        g gVar = this.f6195k;
        if (t0Var2 != null) {
            t0Var2.E(gVar);
        }
        this.f6206p0 = t0Var;
        if (t0Var != null) {
            t0Var.u(gVar);
        }
        j();
    }

    public void setRepeatToggleModes(int i9) {
        this.f6226z0 = i9;
        t0 t0Var = this.f6206p0;
        if (t0Var != null && t0Var.J(15)) {
            int S = this.f6206p0.S();
            if (i9 == 0 && S != 0) {
                this.f6206p0.M(0);
            } else if (i9 == 1 && S == 2) {
                this.f6206p0.M(1);
            } else if (i9 == 2 && S == 1) {
                this.f6206p0.M(2);
            }
        }
        this.f6192i.h(this.B, i9 != 0);
        p();
    }

    public void setShowFastForwardButton(boolean z8) {
        this.f6192i.h(this.f6221x, z8);
        l();
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z8) {
        this.f6214t0 = z8;
        s();
    }

    public void setShowNextButton(boolean z8) {
        this.f6192i.h(this.f6217v, z8);
        l();
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z8) {
        this.f6216u0 = z8;
        m();
    }

    public void setShowPreviousButton(boolean z8) {
        this.f6192i.h(this.f6215u, z8);
        l();
    }

    public void setShowRewindButton(boolean z8) {
        this.f6192i.h(this.f6223y, z8);
        l();
    }

    public void setShowShuffleButton(boolean z8) {
        this.f6192i.h(this.C, z8);
        r();
    }

    public void setShowSubtitleButton(boolean z8) {
        this.f6192i.h(this.E, z8);
    }

    public void setShowTimeoutMs(int i9) {
        this.f6222x0 = i9;
        if (h()) {
            this.f6192i.g();
        }
    }

    public void setShowVrButton(boolean z8) {
        this.f6192i.h(this.D, z8);
    }

    public void setTimeBarMinUpdateInterval(int i9) {
        this.f6224y0 = g1.w.h(i9, 16, IjkMediaCodecInfo.RANK_MAX);
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        View view = this.D;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            k(view, onClickListener != null);
        }
    }

    public final void t() {
        f fVar = this.f6205p;
        fVar.getClass();
        List list = Collections.EMPTY_LIST;
        fVar.f6126d = list;
        f fVar2 = this.f6207q;
        fVar2.getClass();
        fVar2.f6126d = list;
        t0 t0Var = this.f6206p0;
        ImageView imageView = this.E;
        if (t0Var != null && t0Var.J(30) && this.f6206p0.J(29)) {
            f1 v8 = this.f6206p0.v();
            b6.w0 f9 = f(v8, 1);
            fVar2.f6126d = f9;
            q qVar = fVar2.f6129g;
            t0 t0Var2 = qVar.f6206p0;
            i7.l lVar = qVar.f6201n;
            t0Var2.getClass();
            d1 Y = t0Var2.Y();
            if (!f9.isEmpty()) {
                if (fVar2.f(Y)) {
                    int i9 = 0;
                    while (true) {
                        if (i9 >= f9.f1466l) {
                            break;
                        }
                        n nVar = (n) f9.get(i9);
                        if (nVar.f6177a.f2418e[nVar.f6178b]) {
                            ((String[]) lVar.f4949e)[1] = nVar.f6179c;
                            break;
                        }
                        i9++;
                    }
                } else {
                    ((String[]) lVar.f4949e)[1] = qVar.getResources().getString(2131951710);
                }
            } else {
                ((String[]) lVar.f4949e)[1] = qVar.getResources().getString(2131951711);
            }
            if (this.f6192i.b(imageView)) {
                fVar.g(f(v8, 3));
            } else {
                fVar.g(b6.w0.f1464m);
            }
        }
        k(imageView, fVar.a() > 0);
        i7.l lVar2 = this.f6201n;
        k(this.H, lVar2.f(1) || lVar2.f(0));
    }

    public void setProgressUpdateListener(k kVar) {
    }
}
