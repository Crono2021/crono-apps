package g;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
import n.f4;
import n.o1;
import n.t3;
import n.y3;
import n0.c1;
import n0.t0;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c0 extends q implements m.k, LayoutInflater.Factory2 {

    /* renamed from: p0, reason: collision with root package name */
    public static final s.h f3469p0 = new s.h();

    /* renamed from: q0, reason: collision with root package name */
    public static final int[] f3470q0 = {R.attr.windowBackground};

    /* renamed from: r0, reason: collision with root package name */
    public static final boolean f3471r0 = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: s0, reason: collision with root package name */
    public static final boolean f3472s0 = true;
    public s A;
    public s B;
    public l.a C;
    public ActionBarContextView D;
    public PopupWindow E;
    public r F;
    public boolean H;
    public ViewGroup I;
    public TextView J;
    public View K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public b0[] T;
    public b0 U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public Configuration Z;

    /* renamed from: a0, reason: collision with root package name */
    public final int f3473a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f3474b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f3475c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f3476d0;

    /* renamed from: e0, reason: collision with root package name */
    public z f3477e0;

    /* renamed from: f0, reason: collision with root package name */
    public z f3478f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f3479g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f3480h0;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f3481j0;

    /* renamed from: k0, reason: collision with root package name */
    public Rect f3482k0;

    /* renamed from: l0, reason: collision with root package name */
    public Rect f3483l0;

    /* renamed from: m0, reason: collision with root package name */
    public f0 f3484m0;

    /* renamed from: n0, reason: collision with root package name */
    public OnBackInvokedDispatcher f3485n0;

    /* renamed from: o0, reason: collision with root package name */
    public OnBackInvokedCallback f3486o0;

    /* renamed from: r, reason: collision with root package name */
    public final Object f3487r;

    /* renamed from: s, reason: collision with root package name */
    public final Context f3488s;

    /* renamed from: t, reason: collision with root package name */
    public Window f3489t;

    /* renamed from: u, reason: collision with root package name */
    public y f3490u;

    /* renamed from: v, reason: collision with root package name */
    public final Object f3491v;

    /* renamed from: w, reason: collision with root package name */
    public p0 f3492w;

    /* renamed from: x, reason: collision with root package name */
    public l.i f3493x;

    /* renamed from: y, reason: collision with root package name */
    public CharSequence f3494y;

    /* renamed from: z, reason: collision with root package name */
    public ActionBarOverlayLayout f3495z;
    public c1 G = null;
    public final r i0 = new r(this, 0);

    public c0(Context context, Window window, m mVar, Object obj) {
        l lVar;
        this.f3473a0 = -100;
        this.f3488s = context;
        this.f3491v = mVar;
        this.f3487r = obj;
        if (obj instanceof Dialog) {
            while (context != null) {
                if (!(context instanceof l)) {
                    if (!(context instanceof ContextWrapper)) {
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                } else {
                    lVar = (l) context;
                    break;
                }
            }
            lVar = null;
            if (lVar != null) {
                this.f3473a0 = ((c0) lVar.i()).f3473a0;
            }
        }
        if (this.f3473a0 == -100) {
            String name = this.f3487r.getClass().getName();
            s.h hVar = f3469p0;
            Integer num = (Integer) hVar.getOrDefault(name, null);
            if (num != null) {
                this.f3473a0 = num.intValue();
                hVar.remove(this.f3487r.getClass().getName());
            }
        }
        if (window != null) {
            o(window);
        }
        n.t.d();
    }

    public static j0.g p(Context context) {
        j0.g gVar;
        j0.g b9;
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 33 || (gVar = q.f3621k) == null) {
            return null;
        }
        j0.i iVar = gVar.f5342a;
        j0.g z8 = z(context.getApplicationContext().getResources().getConfiguration());
        int i10 = 0;
        if (i9 < 24) {
            b9 = iVar.isEmpty() ? j0.g.f5341b : j0.g.b(iVar.get(0).toString());
        } else if (iVar.isEmpty()) {
            b9 = j0.g.f5341b;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (i10 < z8.f5342a.size() + iVar.size()) {
                Locale locale = i10 < iVar.size() ? iVar.get(i10) : z8.f5342a.get(i10 - iVar.size());
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i10++;
            }
            b9 = j0.g.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
        }
        return b9.f5342a.isEmpty() ? z8 : b9;
    }

    public static Configuration t(Context context, int i9, j0.g gVar, Configuration configuration, boolean z8) {
        int i10 = i9 != 1 ? i9 != 2 ? z8 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i10 | (configuration2.uiMode & (-49));
        if (gVar != null) {
            j0.i iVar = gVar.f5342a;
            if (Build.VERSION.SDK_INT >= 24) {
                w.d(configuration2, gVar);
                return configuration2;
            }
            u.b(configuration2, iVar.get(0));
            u.a(configuration2, iVar.get(0));
        }
        return configuration2;
    }

    public static j0.g z(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? w.b(configuration) : j0.g.b(v.a(configuration.locale));
    }

    public final b0 A(int i9) {
        b0[] b0VarArr = this.T;
        if (b0VarArr == null || b0VarArr.length <= i9) {
            b0[] b0VarArr2 = new b0[i9 + 1];
            if (b0VarArr != null) {
                System.arraycopy(b0VarArr, 0, b0VarArr2, 0, b0VarArr.length);
            }
            this.T = b0VarArr2;
            b0VarArr = b0VarArr2;
        }
        b0 b0Var = b0VarArr[i9];
        if (b0Var != null) {
            return b0Var;
        }
        b0 b0Var2 = new b0();
        b0Var2.f3452a = i9;
        b0Var2.f3464n = false;
        b0VarArr[i9] = b0Var2;
        return b0Var2;
    }

    public final void B() {
        w();
        if (this.N && this.f3492w == null) {
            Object obj = this.f3487r;
            if (obj instanceof Activity) {
                this.f3492w = new p0((Activity) obj, this.O);
            } else if (obj instanceof Dialog) {
                this.f3492w = new p0((Dialog) obj);
            }
            p0 p0Var = this.f3492w;
            if (p0Var != null) {
                p0Var.d(this.f3481j0);
            }
        }
    }

    public final void C(int i9) {
        this.f3480h0 = (1 << i9) | this.f3480h0;
        if (this.f3479g0) {
            return;
        }
        View decorView = this.f3489t.getDecorView();
        WeakHashMap weakHashMap = t0.f7209a;
        n0.c0.m(decorView, this.i0);
        this.f3479g0 = true;
    }

    public final int D(Context context, int i9) {
        if (i9 != -100) {
            if (i9 != -1) {
                if (i9 != 0) {
                    if (i9 != 1 && i9 != 2) {
                        if (i9 != 3) {
                            m7.c.p("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                            return 0;
                        }
                        if (this.f3478f0 == null) {
                            this.f3478f0 = new z(this, context);
                        }
                        return this.f3478f0.h();
                    }
                } else if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return y(context).h();
                }
            }
            return i9;
        }
        return -1;
    }

    public final boolean E() {
        o1 o1Var;
        t3 t3Var;
        boolean z8 = this.V;
        this.V = false;
        b0 A = A(0);
        if (!A.f3463m) {
            l.a aVar = this.C;
            if (aVar != null) {
                aVar.a();
                return true;
            }
            B();
            p0 p0Var = this.f3492w;
            if (p0Var == null || (o1Var = p0Var.f3600e) == null || (t3Var = ((y3) o1Var).f7109a.U) == null || t3Var.f7058j == null) {
                return false;
            }
            t3 t3Var2 = ((y3) o1Var).f7109a.U;
            m.o oVar = t3Var2 == null ? null : t3Var2.f7058j;
            if (oVar != null) {
                oVar.collapseActionView();
            }
        } else if (!z8) {
            s(A, true);
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0176, code lost:
    
        if (r2.f6427n.getCount() > 0) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0156, code lost:
    
        if (r2 != null) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F(g.b0 r18, android.view.KeyEvent r19) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g.c0.F(g.b0, android.view.KeyEvent):void");
    }

    public final boolean G(b0 b0Var, int i9, KeyEvent keyEvent) {
        m.m mVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((b0Var.f3461k || H(b0Var, keyEvent)) && (mVar = b0Var.h) != null) {
            return mVar.performShortcut(i9, keyEvent, 1);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00cb, code lost:
    
        if (r13.h == null) goto L78;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean H(g.b0 r13, android.view.KeyEvent r14) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g.c0.H(g.b0, android.view.KeyEvent):boolean");
    }

    public final void I() {
        if (this.H) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void J() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z8 = false;
            if (this.f3485n0 != null && (A(0).f3463m || this.C != null)) {
                z8 = true;
            }
            if (z8 && this.f3486o0 == null) {
                this.f3486o0 = x.b(this.f3485n0, this);
            } else {
                if (z8 || (onBackInvokedCallback = this.f3486o0) == null) {
                    return;
                }
                x.c(this.f3485n0, onBackInvokedCallback);
            }
        }
    }

    @Override // g.q
    public final void a() {
        LayoutInflater from = LayoutInflater.from(this.f3488s);
        if (from.getFactory() == null) {
            from.setFactory2(this);
        } else {
            if (from.getFactory2() instanceof c0) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // g.q
    public final void b() {
        if (this.f3492w != null) {
            B();
            this.f3492w.getClass();
            C(0);
        }
    }

    @Override // g.q
    public final void d() {
        String str;
        this.W = true;
        n(false, true);
        x();
        Object obj = this.f3487r;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    str = a.a.x(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e9) {
                    throw new IllegalArgumentException(e9);
                }
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                p0 p0Var = this.f3492w;
                if (p0Var == null) {
                    this.f3481j0 = true;
                } else {
                    p0Var.d(true);
                }
            }
            synchronized (q.f3626p) {
                q.g(this);
                q.f3625o.add(new WeakReference(this));
            }
        }
        this.Z = new Configuration(this.f3488s.getResources().getConfiguration());
        this.X = true;
    }

    @Override // m.k
    public final boolean e(m.m mVar, MenuItem menuItem) {
        b0 b0Var;
        Window.Callback callback = this.f3489t.getCallback();
        if (callback != null && !this.Y) {
            m.m k3 = mVar.k();
            b0[] b0VarArr = this.T;
            int length = b0VarArr != null ? b0VarArr.length : 0;
            int i9 = 0;
            while (true) {
                if (i9 < length) {
                    b0Var = b0VarArr[i9];
                    if (b0Var != null && b0Var.h == k3) {
                        break;
                    }
                    i9++;
                } else {
                    b0Var = null;
                    break;
                }
            }
            if (b0Var != null) {
                return callback.onMenuItemSelected(b0Var.f3452a, menuItem);
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // g.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f3487r
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = g.q.f3626p
            monitor-enter(r0)
            g.q.g(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r1
        L11:
            boolean r0 = r3.f3479g0
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.f3489t
            android.view.View r0 = r0.getDecorView()
            g.r r1 = r3.i0
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.Y = r0
            int r0 = r3.f3473a0
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.f3487r
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            s.h r0 = g.c0.f3469p0
            java.lang.Object r1 = r3.f3487r
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f3473a0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            s.h r0 = g.c0.f3469p0
            java.lang.Object r1 = r3.f3487r
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            g.z r0 = r3.f3477e0
            if (r0 == 0) goto L63
            r0.c()
        L63:
            g.z r0 = r3.f3478f0
            if (r0 == 0) goto L6a
            r0.c()
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g.c0.f():void");
    }

    @Override // g.q
    public final boolean h(int i9) {
        if (i9 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i9 = 108;
        } else if (i9 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i9 = 109;
        }
        if (this.R && i9 == 108) {
            return false;
        }
        if (this.N && i9 == 1) {
            this.N = false;
        }
        if (i9 == 1) {
            I();
            this.R = true;
            return true;
        }
        if (i9 == 2) {
            I();
            this.L = true;
            return true;
        }
        if (i9 == 5) {
            I();
            this.M = true;
            return true;
        }
        if (i9 == 10) {
            I();
            this.P = true;
            return true;
        }
        if (i9 == 108) {
            I();
            this.N = true;
            return true;
        }
        if (i9 != 109) {
            return this.f3489t.requestFeature(i9);
        }
        I();
        this.O = true;
        return true;
    }

    @Override // g.q
    public final void i(int i9) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.I.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f3488s).inflate(i9, viewGroup);
        this.f3490u.a(this.f3489t.getCallback());
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
    
        if (r6.e() != false) goto L20;
     */
    @Override // m.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(m.m r6) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g.c0.j(m.m):void");
    }

    @Override // g.q
    public final void k(View view) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.I.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f3490u.a(this.f3489t.getCallback());
    }

    @Override // g.q
    public final void l(View view, ViewGroup.LayoutParams layoutParams) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.I.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f3490u.a(this.f3489t.getCallback());
    }

    @Override // g.q
    public final void m(CharSequence charSequence) {
        this.f3494y = charSequence;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f3495z;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setWindowTitle(charSequence);
            return;
        }
        p0 p0Var = this.f3492w;
        if (p0Var == null) {
            TextView textView = this.J;
            if (textView != null) {
                textView.setText(charSequence);
                return;
            }
            return;
        }
        y3 y3Var = (y3) p0Var.f3600e;
        if (y3Var.f7115g) {
            return;
        }
        Toolbar toolbar = y3Var.f7109a;
        y3Var.h = charSequence;
        if ((y3Var.f7110b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (y3Var.f7115g) {
                t0.q(toolbar.getRootView(), charSequence);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x024a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ec A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n(boolean r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 661
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g.c0.n(boolean, boolean):boolean");
    }

    public final void o(Window window) {
        Drawable drawable;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback;
        int resourceId;
        if (this.f3489t != null) {
            m7.c.p("AppCompat has already installed itself into the Window");
            return;
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof y) {
            m7.c.p("AppCompat has already installed itself into the Window");
            return;
        }
        y yVar = new y(this, callback);
        this.f3490u = yVar;
        window.setCallback(yVar);
        Context context = this.f3488s;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, f3470q0);
        if (!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0) {
            drawable = null;
        } else {
            n.t a9 = n.t.a();
            synchronized (a9) {
                drawable = a9.f7034a.g(context, resourceId, true);
            }
        }
        if (drawable != null) {
            window.setBackgroundDrawable(drawable);
        }
        obtainStyledAttributes.recycle();
        this.f3489t = window;
        if (Build.VERSION.SDK_INT < 33 || (onBackInvokedDispatcher = this.f3485n0) != null) {
            return;
        }
        Object obj = this.f3487r;
        if (onBackInvokedDispatcher != null && (onBackInvokedCallback = this.f3486o0) != null) {
            x.c(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f3486o0 = null;
        }
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            if (activity.getWindow() != null) {
                this.f3485n0 = x.a(activity);
                J();
            }
        }
        this.f3485n0 = null;
        J();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:68:0x01de
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.LayoutInflater.Factory2
    public final android.view.View onCreateView(android.view.View r9, java.lang.String r10, android.content.Context r11, android.util.AttributeSet r12) {
        /*
            Method dump skipped, instructions count: 722
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g.c0.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public final void q(int i9, b0 b0Var, m.m mVar) {
        if (mVar == null) {
            if (b0Var == null && i9 >= 0) {
                b0[] b0VarArr = this.T;
                if (i9 < b0VarArr.length) {
                    b0Var = b0VarArr[i9];
                }
            }
            if (b0Var != null) {
                mVar = b0Var.h;
            }
        }
        if ((b0Var == null || b0Var.f3463m) && !this.Y) {
            y yVar = this.f3490u;
            Window.Callback callback = this.f3489t.getCallback();
            yVar.getClass();
            try {
                yVar.f3637l = true;
                callback.onPanelClosed(i9, mVar);
            } finally {
                yVar.f3637l = false;
            }
        }
    }

    public final void r(m.m mVar) {
        n.j jVar;
        if (this.S) {
            return;
        }
        this.S = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f3495z;
        actionBarOverlayLayout.k();
        ActionMenuView actionMenuView = ((y3) actionBarOverlayLayout.f424m).f7109a.f499i;
        if (actionMenuView != null && (jVar = actionMenuView.B) != null) {
            jVar.c();
            n.f fVar = jVar.B;
            if (fVar != null && fVar.b()) {
                fVar.f6491i.dismiss();
            }
        }
        Window.Callback callback = this.f3489t.getCallback();
        if (callback != null && !this.Y) {
            callback.onPanelClosed(108, mVar);
        }
        this.S = false;
    }

    public final void s(b0 b0Var, boolean z8) {
        a0 a0Var;
        ActionBarOverlayLayout actionBarOverlayLayout;
        n.j jVar;
        if (z8 && b0Var.f3452a == 0 && (actionBarOverlayLayout = this.f3495z) != null) {
            actionBarOverlayLayout.k();
            ActionMenuView actionMenuView = ((y3) actionBarOverlayLayout.f424m).f7109a.f499i;
            if (actionMenuView != null && (jVar = actionMenuView.B) != null && jVar.e()) {
                r(b0Var.h);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.f3488s.getSystemService("window");
        if (windowManager != null && b0Var.f3463m && (a0Var = b0Var.f3456e) != null) {
            windowManager.removeView(a0Var);
            if (z8) {
                q(b0Var.f3452a, b0Var, null);
            }
        }
        b0Var.f3461k = false;
        b0Var.f3462l = false;
        b0Var.f3463m = false;
        b0Var.f3457f = null;
        b0Var.f3464n = true;
        if (this.U == b0Var) {
            this.U = null;
        }
        if (b0Var.f3452a == 0) {
            J();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
    
        if (r4.dispatchKeyEvent(r7) != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d6, code lost:
    
        if (r7.c() != false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00fa, code lost:
    
        if (r7.l() != false) goto L91;
     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean u(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g.c0.u(android.view.KeyEvent):boolean");
    }

    public final void v(int i9) {
        b0 A = A(i9);
        if (A.h != null) {
            Bundle bundle = new Bundle();
            A.h.t(bundle);
            if (bundle.size() > 0) {
                A.f3466p = bundle;
            }
            A.h.w();
            A.h.clear();
        }
        A.f3465o = true;
        A.f3464n = true;
        if ((i9 == 108 || i9 == 0) && this.f3495z != null) {
            b0 A2 = A(0);
            A2.f3461k = false;
            H(A2, null);
        }
    }

    public final void w() {
        ViewGroup viewGroup;
        if (this.H) {
            return;
        }
        Context context = this.f3488s;
        int[] iArr = f.a.f3174j;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!obtainStyledAttributes.hasValue(117)) {
            obtainStyledAttributes.recycle();
            m7.c.p("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
            return;
        }
        int i9 = 0;
        int i10 = 1;
        if (obtainStyledAttributes.getBoolean(126, false)) {
            h(1);
        } else if (obtainStyledAttributes.getBoolean(117, false)) {
            h(108);
        }
        if (obtainStyledAttributes.getBoolean(118, false)) {
            h(109);
        }
        if (obtainStyledAttributes.getBoolean(119, false)) {
            h(10);
        }
        this.Q = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        x();
        this.f3489t.getDecorView();
        LayoutInflater from = LayoutInflater.from(context);
        if (this.R) {
            viewGroup = this.P ? (ViewGroup) from.inflate(2131558422, (ViewGroup) null) : (ViewGroup) from.inflate(2131558421, (ViewGroup) null);
        } else if (this.Q) {
            viewGroup = (ViewGroup) from.inflate(2131558412, (ViewGroup) null);
            this.O = false;
            this.N = false;
        } else if (this.N) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(2130968585, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new l.d(context, typedValue.resourceId) : context).inflate(2131558423, (ViewGroup) null);
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) viewGroup.findViewById(2131361991);
            this.f3495z = actionBarOverlayLayout;
            actionBarOverlayLayout.setWindowCallback(this.f3489t.getCallback());
            if (this.O) {
                this.f3495z.j(109);
            }
            if (this.L) {
                this.f3495z.j(2);
            }
            if (this.M) {
                this.f3495z.j(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.N + ", windowActionBarOverlay: " + this.O + ", android:windowIsFloating: " + this.Q + ", windowActionModeOverlay: " + this.P + ", windowNoTitle: " + this.R + " }");
        }
        s sVar = new s(this, i9);
        WeakHashMap weakHashMap = t0.f7209a;
        n0.i0.u(viewGroup, sVar);
        if (this.f3495z == null) {
            this.J = (TextView) viewGroup.findViewById(2131362477);
        }
        Method method = f4.f6863a;
        try {
            Method method2 = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method2.isAccessible()) {
                method2.setAccessible(true);
            }
            method2.invoke(viewGroup, null);
        } catch (IllegalAccessException e9) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e9);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e10) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e10);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(2131361842);
        ViewGroup viewGroup2 = (ViewGroup) this.f3489t.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f3489t.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new s(this, i10));
        this.I = viewGroup;
        Object obj = this.f3487r;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.f3494y;
        if (!TextUtils.isEmpty(title)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f3495z;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setWindowTitle(title);
            } else {
                p0 p0Var = this.f3492w;
                if (p0Var != null) {
                    y3 y3Var = (y3) p0Var.f3600e;
                    if (!y3Var.f7115g) {
                        Toolbar toolbar = y3Var.f7109a;
                        y3Var.h = title;
                        if ((y3Var.f7110b & 8) != 0) {
                            toolbar.setTitle(title);
                            if (y3Var.f7115g) {
                                t0.q(toolbar.getRootView(), title);
                            }
                        }
                    }
                } else {
                    TextView textView = this.J;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.I.findViewById(R.id.content);
        View decorView = this.f3489t.getDecorView();
        contentFrameLayout2.f451o.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        WeakHashMap weakHashMap2 = t0.f7209a;
        if (n0.f0.c(contentFrameLayout2)) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(iArr);
        obtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
        obtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
        if (obtainStyledAttributes2.hasValue(IjkMediaMeta.FF_PROFILE_H264_HIGH_422)) {
            obtainStyledAttributes2.getValue(IjkMediaMeta.FF_PROFILE_H264_HIGH_422, contentFrameLayout2.getFixedWidthMajor());
        }
        if (obtainStyledAttributes2.hasValue(123)) {
            obtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
        }
        if (obtainStyledAttributes2.hasValue(120)) {
            obtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
        }
        if (obtainStyledAttributes2.hasValue(121)) {
            obtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
        }
        obtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.H = true;
        b0 A = A(0);
        if (this.Y || A.h != null) {
            return;
        }
        C(108);
    }

    public final void x() {
        if (this.f3489t == null) {
            Object obj = this.f3487r;
            if (obj instanceof Activity) {
                o(((Activity) obj).getWindow());
            }
        }
        if (this.f3489t != null) {
            return;
        }
        m7.c.p("We have not been given a Window");
    }

    public final androidx.fragment.app.i y(Context context) {
        if (this.f3477e0 == null) {
            if (androidx.fragment.app.g.f726m == null) {
                Context applicationContext = context.getApplicationContext();
                androidx.fragment.app.g.f726m = new androidx.fragment.app.g(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.f3477e0 = new z(this, androidx.fragment.app.g.f726m);
        }
        return this.f3477e0;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
