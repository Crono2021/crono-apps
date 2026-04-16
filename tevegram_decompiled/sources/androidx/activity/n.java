package androidx.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.SavedStateHandleAttacher;
import androidx.lifecycle.d0;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.h0;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import androidx.lifecycle.m0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class n extends c0.g implements m0, androidx.lifecycle.h, p3.d {

    /* renamed from: j, reason: collision with root package name */
    public final c.a f298j;

    /* renamed from: k, reason: collision with root package name */
    public final m1.b f299k;

    /* renamed from: l, reason: collision with root package name */
    public final androidx.lifecycle.u f300l;

    /* renamed from: m, reason: collision with root package name */
    public final com.bumptech.glide.manager.s f301m;

    /* renamed from: n, reason: collision with root package name */
    public l0 f302n;

    /* renamed from: o, reason: collision with root package name */
    public x f303o;

    /* renamed from: p, reason: collision with root package name */
    public final m f304p;

    /* renamed from: q, reason: collision with root package name */
    public final com.bumptech.glide.manager.s f305q;

    /* renamed from: r, reason: collision with root package name */
    public final AtomicInteger f306r;

    /* renamed from: s, reason: collision with root package name */
    public final i f307s;

    /* renamed from: t, reason: collision with root package name */
    public final CopyOnWriteArrayList f308t;

    /* renamed from: u, reason: collision with root package name */
    public final CopyOnWriteArrayList f309u;

    /* renamed from: v, reason: collision with root package name */
    public final CopyOnWriteArrayList f310v;

    /* renamed from: w, reason: collision with root package name */
    public final CopyOnWriteArrayList f311w;

    /* renamed from: x, reason: collision with root package name */
    public final CopyOnWriteArrayList f312x;

    public n() {
        this.f1542i = new androidx.lifecycle.u(this);
        this.f298j = new c.a();
        final g.l lVar = (g.l) this;
        this.f299k = new m1.b(new a7.a(lVar, 1));
        androidx.lifecycle.u uVar = new androidx.lifecycle.u(this);
        this.f300l = uVar;
        com.bumptech.glide.manager.s sVar = new com.bumptech.glide.manager.s((p3.d) this);
        this.f301m = sVar;
        p3.c cVar = null;
        this.f303o = null;
        m mVar = new m(lVar);
        this.f304p = mVar;
        this.f305q = new com.bumptech.glide.manager.s(mVar, new d(lVar, 0));
        this.f306r = new AtomicInteger();
        this.f307s = new i(lVar);
        this.f308t = new CopyOnWriteArrayList();
        this.f309u = new CopyOnWriteArrayList();
        this.f310v = new CopyOnWriteArrayList();
        this.f311w = new CopyOnWriteArrayList();
        this.f312x = new CopyOnWriteArrayList();
        uVar.a(new androidx.lifecycle.q() { // from class: androidx.activity.ComponentActivity$2
            @Override // androidx.lifecycle.q
            public final void a(androidx.lifecycle.s sVar2, androidx.lifecycle.l lVar2) {
                if (lVar2 == androidx.lifecycle.l.ON_STOP) {
                    Window window = g.l.this.getWindow();
                    View peekDecorView = window != null ? window.peekDecorView() : null;
                    if (peekDecorView != null) {
                        peekDecorView.cancelPendingInputEvents();
                    }
                }
            }
        });
        uVar.a(new androidx.lifecycle.q() { // from class: androidx.activity.ComponentActivity$3
            @Override // androidx.lifecycle.q
            public final void a(androidx.lifecycle.s sVar2, androidx.lifecycle.l lVar2) {
                if (lVar2 == androidx.lifecycle.l.ON_DESTROY) {
                    g.l.this.f298j.f1528j = null;
                    if (!g.l.this.isChangingConfigurations()) {
                        g.l.this.f().a();
                    }
                    m mVar2 = g.l.this.f304p;
                    g.l lVar3 = mVar2.f297l;
                    lVar3.getWindow().getDecorView().removeCallbacks(mVar2);
                    lVar3.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(mVar2);
                }
            }
        });
        uVar.a(new androidx.lifecycle.q() { // from class: androidx.activity.ComponentActivity$4
            @Override // androidx.lifecycle.q
            public final void a(androidx.lifecycle.s sVar2, androidx.lifecycle.l lVar2) {
                g.l lVar3 = g.l.this;
                if (lVar3.f302n == null) {
                    l lVar4 = (l) lVar3.getLastNonConfigurationInstance();
                    if (lVar4 != null) {
                        lVar3.f302n = lVar4.f293a;
                    }
                    if (lVar3.f302n == null) {
                        lVar3.f302n = new l0();
                    }
                }
                lVar3.f300l.f(this);
            }
        });
        sVar.d();
        androidx.lifecycle.m mVar2 = uVar.f943d;
        if (mVar2 != androidx.lifecycle.m.f929j && mVar2 != androidx.lifecycle.m.f930k) {
            m7.c.n("Failed requirement.");
            throw null;
        }
        n.s sVar2 = (n.s) sVar.f1859l;
        sVar2.getClass();
        Iterator it = ((p.f) sVar2.f7030f).iterator();
        while (true) {
            p.b bVar = (p.b) it;
            if (!bVar.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) bVar.next();
            entry.getClass();
            String str = (String) entry.getKey();
            p3.c cVar2 = (p3.c) entry.getValue();
            if (b8.i.a(str, "androidx.lifecycle.internal.SavedStateHandlesProvider")) {
                cVar = cVar2;
                break;
            }
        }
        if (cVar == null) {
            h0 h0Var = new h0((n.s) this.f301m.f1859l, lVar);
            ((n.s) this.f301m.f1859l).e("androidx.lifecycle.internal.SavedStateHandlesProvider", h0Var);
            this.f300l.a(new SavedStateHandleAttacher(h0Var));
        }
        if (Build.VERSION.SDK_INT <= 23) {
            androidx.lifecycle.u uVar2 = this.f300l;
            ImmLeaksCleaner immLeaksCleaner = new ImmLeaksCleaner();
            immLeaksCleaner.f273i = lVar;
            uVar2.a(immLeaksCleaner);
        }
        ((n.s) this.f301m.f1859l).e("android:support:activity-result", new p3.c() { // from class: androidx.activity.e
            @Override // p3.c
            public final Bundle a() {
                Bundle bundle = new Bundle();
                i iVar = g.l.this.f307s;
                iVar.getClass();
                HashMap hashMap = iVar.f335b;
                bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(hashMap.values()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(hashMap.keySet()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(iVar.f337d));
                bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) iVar.f340g.clone());
                return bundle;
            }
        });
        e(new c.b() { // from class: androidx.activity.f
            @Override // c.b
            public final void a() {
                g.l lVar2 = g.l.this;
                Bundle c9 = ((n.s) lVar2.f301m.f1859l).c("android:support:activity-result");
                if (c9 != null) {
                    i iVar = lVar2.f307s;
                    HashMap hashMap = iVar.f335b;
                    HashMap hashMap2 = iVar.f334a;
                    Bundle bundle = iVar.f340g;
                    ArrayList<Integer> integerArrayList = c9.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                    ArrayList<String> stringArrayList = c9.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                    if (stringArrayList == null || integerArrayList == null) {
                        return;
                    }
                    iVar.f337d = c9.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                    bundle.putAll(c9.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
                    for (int i9 = 0; i9 < stringArrayList.size(); i9++) {
                        String str2 = stringArrayList.get(i9);
                        if (hashMap.containsKey(str2)) {
                            Integer num = (Integer) hashMap.remove(str2);
                            if (!bundle.containsKey(str2)) {
                                hashMap2.remove(num);
                            }
                        }
                        Integer num2 = integerArrayList.get(i9);
                        num2.intValue();
                        String str3 = stringArrayList.get(i9);
                        hashMap2.put(num2, str3);
                        iVar.f335b.put(str3, num2);
                    }
                }
            }
        });
    }

    @Override // p3.d
    public final n.s a() {
        return (n.s) this.f301m.f1859l;
    }

    @Override // androidx.lifecycle.h
    public final b1.b c() {
        b1.a aVar = b1.a.f1131j;
        aVar.getClass();
        b1.c cVar = new b1.c(0);
        ((LinkedHashMap) cVar.f1132i).putAll((LinkedHashMap) aVar.f1132i);
        LinkedHashMap linkedHashMap = (LinkedHashMap) cVar.f1132i;
        if (getApplication() != null) {
            linkedHashMap.put(k0.f925a, getApplication());
        }
        linkedHashMap.put(g0.f914a, this);
        linkedHashMap.put(g0.f915b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            linkedHashMap.put(g0.f916c, getIntent().getExtras());
        }
        return cVar;
    }

    public final void e(c.b bVar) {
        c.a aVar = this.f298j;
        aVar.getClass();
        if (((n) aVar.f1528j) != null) {
            bVar.a();
        }
        ((CopyOnWriteArraySet) aVar.f1527i).add(bVar);
    }

    @Override // androidx.lifecycle.m0
    public final l0 f() {
        if (getApplication() == null) {
            m7.c.p("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
            return null;
        }
        if (this.f302n == null) {
            l lVar = (l) getLastNonConfigurationInstance();
            if (lVar != null) {
                this.f302n = lVar.f293a;
            }
            if (this.f302n == null) {
                this.f302n = new l0();
            }
        }
        return this.f302n;
    }

    @Override // androidx.lifecycle.s
    public final androidx.lifecycle.u g() {
        return this.f300l;
    }

    public final x h() {
        if (this.f303o == null) {
            this.f303o = new x(new j(this, 0));
            this.f300l.a(new androidx.lifecycle.q() { // from class: androidx.activity.ComponentActivity$6
                @Override // androidx.lifecycle.q
                public final void a(androidx.lifecycle.s sVar, androidx.lifecycle.l lVar) {
                    if (lVar != androidx.lifecycle.l.ON_CREATE || Build.VERSION.SDK_INT < 33) {
                        return;
                    }
                    x xVar = n.this.f303o;
                    OnBackInvokedDispatcher a9 = k.a((n) sVar);
                    xVar.getClass();
                    a9.getClass();
                    xVar.f358e = a9;
                    xVar.c(xVar.f360g);
                }
            });
        }
        return this.f303o;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i9, int i10, Intent intent) {
        if (this.f307s.a(i9, i10, intent)) {
            return;
        }
        super.onActivityResult(i9, i10, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        h().b();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator it = this.f308t.iterator();
        while (it.hasNext()) {
            ((k0.d) it.next()).a(configuration);
        }
    }

    @Override // c0.g, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f301m.e(bundle);
        c.a aVar = this.f298j;
        aVar.getClass();
        aVar.f1528j = this;
        Iterator it = ((CopyOnWriteArraySet) aVar.f1527i).iterator();
        while (it.hasNext()) {
            ((c.b) it.next()).a();
        }
        super.onCreate(bundle);
        int i9 = f0.f912j;
        d0.b(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i9, Menu menu) {
        if (i9 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i9, menu);
        getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.f299k.f6511k).iterator();
        if (it.hasNext()) {
            throw g.l(it);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i9, MenuItem menuItem) {
        if (super.onMenuItemSelected(i9, menuItem)) {
            return true;
        }
        if (i9 != 0) {
            return false;
        }
        Iterator it = ((CopyOnWriteArrayList) this.f299k.f6511k).iterator();
        if (it.hasNext()) {
            throw g.l(it);
        }
        return false;
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z8, Configuration configuration) {
        super.onMultiWindowModeChanged(z8, configuration);
        Iterator it = this.f311w.iterator();
        while (it.hasNext()) {
            ((k0.d) it.next()).a(new u5.e(12));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator it = this.f310v.iterator();
        while (it.hasNext()) {
            ((k0.d) it.next()).a(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i9, Menu menu) {
        Iterator it = ((CopyOnWriteArrayList) this.f299k.f6511k).iterator();
        if (it.hasNext()) {
            throw g.l(it);
        }
        super.onPanelClosed(i9, menu);
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z8, Configuration configuration) {
        super.onPictureInPictureModeChanged(z8, configuration);
        Iterator it = this.f312x.iterator();
        while (it.hasNext()) {
            ((k0.d) it.next()).a(new u5.e(13));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i9, View view, Menu menu) {
        if (i9 != 0) {
            return true;
        }
        super.onPreparePanel(i9, view, menu);
        Iterator it = ((CopyOnWriteArrayList) this.f299k.f6511k).iterator();
        if (it.hasNext()) {
            throw g.l(it);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i9, String[] strArr, int[] iArr) {
        if (this.f307s.a(i9, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i9, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        l lVar;
        l0 l0Var = this.f302n;
        if (l0Var == null && (lVar = (l) getLastNonConfigurationInstance()) != null) {
            l0Var = lVar.f293a;
        }
        if (l0Var == null) {
            return null;
        }
        l lVar2 = new l();
        lVar2.f293a = l0Var;
        return lVar2;
    }

    @Override // c0.g, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.u uVar = this.f300l;
        if (uVar != null) {
            uVar.c("setCurrentState");
            uVar.e(androidx.lifecycle.m.f930k);
        }
        super.onSaveInstanceState(bundle);
        this.f301m.f(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i9) {
        super.onTrimMemory(i9);
        Iterator it = this.f309u.iterator();
        while (it.hasNext()) {
            ((k0.d) it.next()).a(Integer.valueOf(i9));
        }
    }

    @Override // android.app.Activity
    public final void reportFullyDrawn() {
        try {
            if (android.support.v4.media.session.b.V()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            com.bumptech.glide.manager.s sVar = this.f305q;
            synchronized (sVar.f1858k) {
                try {
                    sVar.f1857j = true;
                    ArrayList arrayList = (ArrayList) sVar.f1859l;
                    int size = arrayList.size();
                    int i9 = 0;
                    while (i9 < size) {
                        Object obj = arrayList.get(i9);
                        i9++;
                        ((a8.a) obj).d();
                    }
                    ((ArrayList) sVar.f1859l).clear();
                } finally {
                }
            }
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
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
        View decorView5 = getWindow().getDecorView();
        decorView5.getClass();
        decorView5.setTag(2131362324, this);
        View decorView6 = getWindow().getDecorView();
        m mVar = this.f304p;
        if (!mVar.f296k) {
            mVar.f296k = true;
            decorView6.getViewTreeObserver().addOnDrawListener(mVar);
        }
        super.setContentView(view);
    }
}
