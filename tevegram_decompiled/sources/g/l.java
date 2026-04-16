package g;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import n.d4;
import n.y3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class l extends androidx.activity.n implements m {
    public boolean A;
    public boolean B;
    public c0 D;

    /* renamed from: y, reason: collision with root package name */
    public final a0.b f3577y = new a0.b(new androidx.fragment.app.v(this), 7);

    /* renamed from: z, reason: collision with root package name */
    public final androidx.lifecycle.u f3578z = new androidx.lifecycle.u(this);
    public boolean C = true;

    public l() {
        ((n.s) this.f301m.f1859l).e("android:support:fragments", new androidx.fragment.app.t(this, 0));
        e(new androidx.fragment.app.u(this, 0));
        ((n.s) this.f301m.f1859l).e("androidx:appcompat", new androidx.fragment.app.t(this, 1));
        e(new androidx.fragment.app.u(this, 1));
    }

    public static boolean k(androidx.fragment.app.h0 h0Var) {
        boolean z8 = false;
        for (androidx.fragment.app.s sVar : h0Var.f738c.T()) {
            if (sVar != null) {
                androidx.fragment.app.v vVar = sVar.A;
                if ((vVar == null ? null : vVar.f875s) != null) {
                    z8 |= k(sVar.e());
                }
                androidx.fragment.app.p0 p0Var = sVar.U;
                androidx.lifecycle.m mVar = androidx.lifecycle.m.f930k;
                androidx.lifecycle.m mVar2 = androidx.lifecycle.m.f931l;
                if (p0Var != null) {
                    p0Var.d();
                    if (p0Var.f825j.f943d.compareTo(mVar2) >= 0) {
                        androidx.lifecycle.u uVar = sVar.U.f825j;
                        uVar.c("setCurrentState");
                        uVar.e(mVar);
                        z8 = true;
                    }
                }
                if (sVar.T.f943d.compareTo(mVar2) >= 0) {
                    androidx.lifecycle.u uVar2 = sVar.T;
                    uVar2.c("setCurrentState");
                    uVar2.e(mVar);
                    z8 = true;
                }
            }
        }
        return z8;
    }

    @Override // android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        j();
        c0 c0Var = (c0) i();
        c0Var.w();
        ((ViewGroup) c0Var.I.findViewById(R.id.content)).addView(view, layoutParams);
        c0Var.f3490u.a(c0Var.f3489t.getCallback());
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        c0 c0Var = (c0) i();
        c0Var.W = true;
        int i17 = c0Var.f3473a0;
        if (i17 == -100) {
            i17 = q.f3620j;
        }
        int D = c0Var.D(context, i17);
        if (q.c(context) && q.c(context)) {
            if (!j0.b.a()) {
                synchronized (q.f3627q) {
                    try {
                        j0.g gVar = q.f3621k;
                        if (gVar == null) {
                            if (q.f3622l == null) {
                                q.f3622l = j0.g.b(android.support.v4.media.session.b.m0(context));
                            }
                            if (!q.f3622l.f5342a.isEmpty()) {
                                q.f3621k = q.f3622l;
                            }
                        } else if (!gVar.equals(q.f3622l)) {
                            j0.g gVar2 = q.f3621k;
                            q.f3622l = gVar2;
                            android.support.v4.media.session.b.l0(context, gVar2.f5342a.a());
                        }
                    } finally {
                    }
                }
            } else if (!q.f3624n) {
                q.f3619i.execute(new n(context, 0));
            }
        }
        j0.g p5 = c0.p(context);
        Configuration configuration = null;
        if (c0.f3472s0 && (context instanceof ContextThemeWrapper)) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(c0.t(context, D, p5, null, false));
            } catch (IllegalStateException unused) {
            }
            super.attachBaseContext(context);
        }
        if (context instanceof l.d) {
            try {
                ((l.d) context).a(c0.t(context, D, p5, null, false));
            } catch (IllegalStateException unused2) {
            }
            super.attachBaseContext(context);
        }
        if (c0.f3471r0) {
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = 0.0f;
            Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (!configuration3.equals(configuration4)) {
                configuration = new Configuration();
                configuration.fontScale = 0.0f;
                if (configuration3.diff(configuration4) != 0) {
                    float f9 = configuration3.fontScale;
                    float f10 = configuration4.fontScale;
                    if (f9 != f10) {
                        configuration.fontScale = f10;
                    }
                    int i18 = configuration3.mcc;
                    int i19 = configuration4.mcc;
                    if (i18 != i19) {
                        configuration.mcc = i19;
                    }
                    int i20 = configuration3.mnc;
                    int i21 = configuration4.mnc;
                    if (i20 != i21) {
                        configuration.mnc = i21;
                    }
                    int i22 = Build.VERSION.SDK_INT;
                    if (i22 >= 24) {
                        w.a(configuration3, configuration4, configuration);
                    } else if (!m0.a.a(configuration3.locale, configuration4.locale)) {
                        configuration.locale = configuration4.locale;
                    }
                    int i23 = configuration3.touchscreen;
                    int i24 = configuration4.touchscreen;
                    if (i23 != i24) {
                        configuration.touchscreen = i24;
                    }
                    int i25 = configuration3.keyboard;
                    int i26 = configuration4.keyboard;
                    if (i25 != i26) {
                        configuration.keyboard = i26;
                    }
                    int i27 = configuration3.keyboardHidden;
                    int i28 = configuration4.keyboardHidden;
                    if (i27 != i28) {
                        configuration.keyboardHidden = i28;
                    }
                    int i29 = configuration3.navigation;
                    int i30 = configuration4.navigation;
                    if (i29 != i30) {
                        configuration.navigation = i30;
                    }
                    int i31 = configuration3.navigationHidden;
                    int i32 = configuration4.navigationHidden;
                    if (i31 != i32) {
                        configuration.navigationHidden = i32;
                    }
                    int i33 = configuration3.orientation;
                    int i34 = configuration4.orientation;
                    if (i33 != i34) {
                        configuration.orientation = i34;
                    }
                    int i35 = configuration3.screenLayout & 15;
                    int i36 = configuration4.screenLayout & 15;
                    if (i35 != i36) {
                        configuration.screenLayout |= i36;
                    }
                    int i37 = configuration3.screenLayout & 192;
                    int i38 = configuration4.screenLayout & 192;
                    if (i37 != i38) {
                        configuration.screenLayout |= i38;
                    }
                    int i39 = configuration3.screenLayout & 48;
                    int i40 = configuration4.screenLayout & 48;
                    if (i39 != i40) {
                        configuration.screenLayout |= i40;
                    }
                    int i41 = configuration3.screenLayout & 768;
                    int i42 = configuration4.screenLayout & 768;
                    if (i41 != i42) {
                        configuration.screenLayout |= i42;
                    }
                    if (i22 >= 26) {
                        i9 = configuration3.colorMode;
                        int i43 = i9 & 3;
                        i10 = configuration4.colorMode;
                        if (i43 != (i10 & 3)) {
                            i15 = configuration.colorMode;
                            i16 = configuration4.colorMode;
                            configuration.colorMode = i15 | (i16 & 3);
                        }
                        i11 = configuration3.colorMode;
                        int i44 = i11 & 12;
                        i12 = configuration4.colorMode;
                        if (i44 != (i12 & 12)) {
                            i13 = configuration.colorMode;
                            i14 = configuration4.colorMode;
                            configuration.colorMode = i13 | (i14 & 12);
                        }
                    }
                    int i45 = configuration3.uiMode & 15;
                    int i46 = configuration4.uiMode & 15;
                    if (i45 != i46) {
                        configuration.uiMode |= i46;
                    }
                    int i47 = configuration3.uiMode & 48;
                    int i48 = configuration4.uiMode & 48;
                    if (i47 != i48) {
                        configuration.uiMode |= i48;
                    }
                    int i49 = configuration3.screenWidthDp;
                    int i50 = configuration4.screenWidthDp;
                    if (i49 != i50) {
                        configuration.screenWidthDp = i50;
                    }
                    int i51 = configuration3.screenHeightDp;
                    int i52 = configuration4.screenHeightDp;
                    if (i51 != i52) {
                        configuration.screenHeightDp = i52;
                    }
                    int i53 = configuration3.smallestScreenWidthDp;
                    int i54 = configuration4.smallestScreenWidthDp;
                    if (i53 != i54) {
                        configuration.smallestScreenWidthDp = i54;
                    }
                    int i55 = configuration3.densityDpi;
                    int i56 = configuration4.densityDpi;
                    if (i55 != i56) {
                        configuration.densityDpi = i56;
                    }
                }
            }
            Configuration t8 = c0.t(context, D, p5, configuration, true);
            l.d dVar = new l.d(context, 2132017726);
            dVar.a(t8);
            try {
                if (context.getTheme() != null) {
                    e0.b.l(dVar.getTheme());
                }
            } catch (NullPointerException unused3) {
            }
            context = dVar;
        }
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity
    public final void closeOptionsMenu() {
        ((c0) i()).B();
        if (getWindow().hasFeature(0)) {
            super.closeOptionsMenu();
        }
    }

    @Override // c0.g, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getKeyCode();
        ((c0) i()).B();
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        c1.a aVar;
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.A);
        printWriter.print(" mResumed=");
        printWriter.print(this.B);
        printWriter.print(" mStopped=");
        printWriter.print(this.C);
        if (getApplication() != null) {
            androidx.lifecycle.l0 f9 = f();
            f9.getClass();
            b1.a aVar2 = b1.a.f1131j;
            aVar2.getClass();
            String canonicalName = c1.a.class.getCanonicalName();
            if (canonicalName == null) {
                m7.c.n("Local and anonymous classes can not be ViewModels");
                return;
            }
            String concat = "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName);
            LinkedHashMap linkedHashMap = f9.f927a;
            androidx.lifecycle.j0 j0Var = (androidx.lifecycle.j0) linkedHashMap.get(concat);
            if (c1.a.class.isInstance(j0Var)) {
                j0Var.getClass();
            } else {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.putAll((LinkedHashMap) aVar2.f1132i);
                linkedHashMap2.put(androidx.lifecycle.k0.f926b, concat);
                try {
                    aVar = new c1.a();
                } catch (AbstractMethodError unused) {
                    aVar = new c1.a();
                }
                j0Var = aVar;
                androidx.lifecycle.j0 j0Var2 = (androidx.lifecycle.j0) linkedHashMap.put(concat, j0Var);
                if (j0Var2 != null) {
                    j0Var2.a();
                }
            }
            s.i iVar = ((c1.a) j0Var).f1544c;
            if (iVar.f8657k > 0) {
                printWriter.print(str2);
                printWriter.println("Loaders:");
                if (iVar.f8657k > 0) {
                    if (iVar.f8656j[0] != null) {
                        androidx.fragment.app.a.c();
                        return;
                    }
                    printWriter.print(str2);
                    printWriter.print("  #");
                    printWriter.print(iVar.f8655i[0]);
                    printWriter.print(": ");
                    throw null;
                }
            }
        }
        ((androidx.fragment.app.v) this.f3577y.f8j).f874r.t(str, fileDescriptor, printWriter, strArr);
    }

    @Override // android.app.Activity
    public final View findViewById(int i9) {
        c0 c0Var = (c0) i();
        c0Var.w();
        return c0Var.f3489t.findViewById(i9);
    }

    @Override // android.app.Activity
    public final MenuInflater getMenuInflater() {
        c0 c0Var = (c0) i();
        if (c0Var.f3493x == null) {
            c0Var.B();
            p0 p0Var = c0Var.f3492w;
            c0Var.f3493x = new l.i(p0Var != null ? p0Var.b() : c0Var.f3488s);
        }
        return c0Var.f3493x;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        int i9 = d4.f6848a;
        return super.getResources();
    }

    public final q i() {
        if (this.D == null) {
            i0 i0Var = q.f3619i;
            this.D = new c0(this, null, this, this);
        }
        return this.D;
    }

    @Override // android.app.Activity
    public final void invalidateOptionsMenu() {
        i().b();
    }

    public final void j() {
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        decorView.setTag(2131362517, this);
        View decorView2 = getWindow().getDecorView();
        decorView2.getClass();
        decorView2.setTag(2131362520, this);
        View decorView3 = getWindow().getDecorView();
        decorView3.getClass();
        decorView3.setTag(2131362519, this);
        View decorView4 = getWindow().getDecorView();
        decorView4.getClass();
        decorView4.setTag(2131362518, this);
    }

    public final void l(Configuration configuration) {
        a0.b bVar = this.f3577y;
        bVar.f();
        super.onConfigurationChanged(configuration);
        ((androidx.fragment.app.v) bVar.f8j).f874r.h();
    }

    public final void m() {
        super.onDestroy();
        ((androidx.fragment.app.v) this.f3577y.f8j).f874r.k();
        this.f3578z.d(androidx.lifecycle.l.ON_DESTROY);
    }

    public final boolean n(int i9, MenuItem menuItem) {
        if (super.onMenuItemSelected(i9, menuItem)) {
            return true;
        }
        a0.b bVar = this.f3577y;
        if (i9 == 0) {
            return ((androidx.fragment.app.v) bVar.f8j).f874r.n();
        }
        if (i9 != 6) {
            return false;
        }
        return ((androidx.fragment.app.v) bVar.f8j).f874r.i();
    }

    public final void o(int i9, Menu menu) {
        if (i9 == 0) {
            ((androidx.fragment.app.v) this.f3577y.f8j).f874r.o();
        }
        super.onPanelClosed(i9, menu);
    }

    @Override // androidx.activity.n, android.app.Activity
    public final void onActivityResult(int i9, int i10, Intent intent) {
        this.f3577y.f();
        super.onActivityResult(i9, i10, intent);
    }

    @Override // androidx.activity.n, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        l(configuration);
        c0 c0Var = (c0) i();
        if (c0Var.N && c0Var.H) {
            c0Var.B();
            p0 p0Var = c0Var.f3492w;
            if (p0Var != null) {
                p0Var.e(p0Var.f3596a.getResources().getBoolean(2131034112));
            }
        }
        n.t a9 = n.t.a();
        Context context = c0Var.f3488s;
        synchronized (a9) {
            a9.f7034a.l(context);
        }
        c0Var.Z = new Configuration(c0Var.f3488s.getResources().getConfiguration());
        c0Var.n(false, false);
    }

    @Override // androidx.activity.n, c0.g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3578z.d(androidx.lifecycle.l.ON_CREATE);
        androidx.fragment.app.h0 h0Var = ((androidx.fragment.app.v) this.f3577y.f8j).f874r;
        h0Var.f759y = false;
        h0Var.f760z = false;
        h0Var.F.h = false;
        h0Var.s(1);
    }

    @Override // androidx.activity.n, android.app.Activity, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i9, Menu menu) {
        if (i9 != 0) {
            super.onCreatePanelMenu(i9, menu);
            return true;
        }
        super.onCreatePanelMenu(i9, menu);
        getMenuInflater();
        ((androidx.fragment.app.v) this.f3577y.f8j).f874r.j();
        return true;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView = ((androidx.fragment.app.v) this.f3577y.f8j).f874r.f741f.onCreateView(null, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(str, context, attributeSet) : onCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        m();
        i().f();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i9, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return super.onKeyDown(i9, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onLowMemory() {
        super.onLowMemory();
        ((androidx.fragment.app.v) this.f3577y.f8j).f874r.l();
    }

    @Override // androidx.activity.n, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i9, MenuItem menuItem) {
        Intent v8;
        if (!n(i9, menuItem)) {
            c0 c0Var = (c0) i();
            c0Var.B();
            p0 p0Var = c0Var.f3492w;
            if (menuItem.getItemId() != 16908332 || p0Var == null || (((y3) p0Var.f3600e).f7110b & 4) == 0 || (v8 = a.a.v(this)) == null) {
                return false;
            }
            if (!c0.h.c(this, v8)) {
                c0.h.b(this, v8);
                return true;
            }
            ArrayList arrayList = new ArrayList();
            Intent v9 = a.a.v(this);
            if (v9 == null) {
                v9 = a.a.v(this);
            }
            if (v9 != null) {
                ComponentName component = v9.getComponent();
                if (component == null) {
                    component = v9.resolveActivity(getPackageManager());
                }
                int size = arrayList.size();
                try {
                    Intent w8 = a.a.w(this, component);
                    while (w8 != null) {
                        arrayList.add(size, w8);
                        w8 = a.a.w(this, w8.getComponent());
                    }
                    arrayList.add(v9);
                } catch (PackageManager.NameNotFoundException e9) {
                    Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                    throw new IllegalArgumentException(e9);
                }
            }
            if (arrayList.isEmpty()) {
                m7.c.p("No intents added to TaskStackBuilder; cannot startActivities");
                return false;
            }
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            d0.a.a(this, intentArr, null);
            try {
                c0.a.a(this);
            } catch (IllegalStateException unused) {
                finish();
            }
        }
        return true;
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z8) {
        ((androidx.fragment.app.v) this.f3577y.f8j).f874r.m();
    }

    @Override // androidx.activity.n, android.app.Activity
    public void onNewIntent(Intent intent) {
        this.f3577y.f();
        super.onNewIntent(intent);
    }

    @Override // androidx.activity.n, android.app.Activity, android.view.Window.Callback
    public final void onPanelClosed(int i9, Menu menu) {
        o(i9, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.B = false;
        ((androidx.fragment.app.v) this.f3577y.f8j).f874r.s(5);
        this.f3578z.d(androidx.lifecycle.l.ON_PAUSE);
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z8) {
        ((androidx.fragment.app.v) this.f3577y.f8j).f874r.q();
    }

    @Override // android.app.Activity
    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((c0) i()).w();
    }

    @Override // android.app.Activity
    public final void onPostResume() {
        p();
        c0 c0Var = (c0) i();
        c0Var.B();
        p0 p0Var = c0Var.f3492w;
        if (p0Var != null) {
            p0Var.f3614t = true;
        }
    }

    @Override // androidx.activity.n, android.app.Activity, android.view.Window.Callback
    public final boolean onPreparePanel(int i9, View view, Menu menu) {
        if (i9 != 0) {
            super.onPreparePanel(i9, view, menu);
            return true;
        }
        super.onPreparePanel(0, view, menu);
        ((androidx.fragment.app.v) this.f3577y.f8j).f874r.r();
        return true;
    }

    @Override // androidx.activity.n, android.app.Activity
    public final void onRequestPermissionsResult(int i9, String[] strArr, int[] iArr) {
        this.f3577y.f();
        super.onRequestPermissionsResult(i9, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        a0.b bVar = this.f3577y;
        bVar.f();
        super.onResume();
        this.B = true;
        ((androidx.fragment.app.v) bVar.f8j).f874r.w(true);
    }

    @Override // android.app.Activity
    public final void onStart() {
        q();
        ((c0) i()).n(true, false);
    }

    @Override // android.app.Activity
    public final void onStateNotSaved() {
        this.f3577y.f();
    }

    @Override // android.app.Activity
    public void onStop() {
        r();
        c0 c0Var = (c0) i();
        c0Var.B();
        p0 p0Var = c0Var.f3492w;
        if (p0Var != null) {
            p0Var.f3614t = false;
            l.k kVar = p0Var.f3613s;
            if (kVar != null) {
                kVar.a();
            }
        }
    }

    @Override // android.app.Activity
    public final void onTitleChanged(CharSequence charSequence, int i9) {
        super.onTitleChanged(charSequence, i9);
        i().m(charSequence);
    }

    @Override // android.app.Activity
    public final void openOptionsMenu() {
        ((c0) i()).B();
        if (getWindow().hasFeature(0)) {
            super.openOptionsMenu();
        }
    }

    public final void p() {
        super.onPostResume();
        this.f3578z.d(androidx.lifecycle.l.ON_RESUME);
        androidx.fragment.app.h0 h0Var = ((androidx.fragment.app.v) this.f3577y.f8j).f874r;
        h0Var.f759y = false;
        h0Var.f760z = false;
        h0Var.F.h = false;
        h0Var.s(7);
    }

    public final void q() {
        a0.b bVar = this.f3577y;
        bVar.f();
        androidx.fragment.app.v vVar = (androidx.fragment.app.v) bVar.f8j;
        super.onStart();
        this.C = false;
        if (!this.A) {
            this.A = true;
            androidx.fragment.app.h0 h0Var = vVar.f874r;
            h0Var.f759y = false;
            h0Var.f760z = false;
            h0Var.F.h = false;
            h0Var.s(4);
        }
        vVar.f874r.w(true);
        this.f3578z.d(androidx.lifecycle.l.ON_START);
        androidx.fragment.app.h0 h0Var2 = vVar.f874r;
        h0Var2.f759y = false;
        h0Var2.f760z = false;
        h0Var2.F.h = false;
        h0Var2.s(5);
    }

    public final void r() {
        a0.b bVar;
        super.onStop();
        this.C = true;
        do {
            bVar = this.f3577y;
        } while (k(((androidx.fragment.app.v) bVar.f8j).f874r));
        androidx.fragment.app.h0 h0Var = ((androidx.fragment.app.v) bVar.f8j).f874r;
        h0Var.f760z = true;
        h0Var.F.h = true;
        h0Var.s(4);
        this.f3578z.d(androidx.lifecycle.l.ON_STOP);
    }

    @Override // android.app.Activity
    public final void setContentView(int i9) {
        j();
        i().i(i9);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i9) {
        super.setTheme(i9);
        ((c0) i()).f3474b0 = i9;
    }

    @Override // androidx.activity.n, android.app.Activity
    public void setContentView(View view) {
        j();
        i().k(view);
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        j();
        i().l(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView = ((androidx.fragment.app.v) this.f3577y.f8j).f874r.f741f.onCreateView(view, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(view, str, context, attributeSet) : onCreateView;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
    }
}
