package m;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import n0.v0;
import n0.w0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class m implements Menu {
    public static final int[] G = {1, 4, 5, 3, 2, 0};
    public o D;
    public boolean F;

    /* renamed from: i, reason: collision with root package name */
    public final Context f6434i;

    /* renamed from: j, reason: collision with root package name */
    public final Resources f6435j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6436k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f6437l;

    /* renamed from: m, reason: collision with root package name */
    public k f6438m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f6439n;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f6440o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f6441p;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList f6442q;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f6443r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f6444s;

    /* renamed from: u, reason: collision with root package name */
    public CharSequence f6446u;

    /* renamed from: v, reason: collision with root package name */
    public Drawable f6447v;

    /* renamed from: w, reason: collision with root package name */
    public View f6448w;

    /* renamed from: t, reason: collision with root package name */
    public int f6445t = 0;

    /* renamed from: x, reason: collision with root package name */
    public boolean f6449x = false;

    /* renamed from: y, reason: collision with root package name */
    public boolean f6450y = false;

    /* renamed from: z, reason: collision with root package name */
    public boolean f6451z = false;
    public boolean A = false;
    public final ArrayList B = new ArrayList();
    public final CopyOnWriteArrayList C = new CopyOnWriteArrayList();
    public boolean E = false;

    public m(Context context) {
        boolean z8;
        boolean z9 = false;
        this.f6434i = context;
        Resources resources = context.getResources();
        this.f6435j = resources;
        this.f6439n = new ArrayList();
        this.f6440o = new ArrayList();
        this.f6441p = true;
        this.f6442q = new ArrayList();
        this.f6443r = new ArrayList();
        this.f6444s = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Method method = w0.f7225a;
            if (Build.VERSION.SDK_INT >= 28) {
                z8 = v0.b(viewConfiguration);
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                z8 = identifier != 0 && resources2.getBoolean(identifier);
            }
            if (z8) {
                z9 = true;
            }
        }
        this.f6437l = z9;
    }

    public final o a(int i9, int i10, int i11, CharSequence charSequence) {
        int i12;
        int i13 = ((-65536) & i11) >> 16;
        if (i13 < 0 || i13 >= 6) {
            m7.c.n("order does not contain a valid category.");
            return null;
        }
        int i14 = (G[i13] << 16) | (65535 & i11);
        o oVar = new o(this, i9, i10, i11, i14, charSequence, this.f6445t);
        ArrayList arrayList = this.f6439n;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i12 = 0;
                break;
            }
            if (((o) arrayList.get(size)).f6458l <= i14) {
                i12 = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i12, oVar);
        p(true);
        return oVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i9) {
        return a(0, 0, 0, this.f6435j.getString(i9));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i9, int i10, int i11, ComponentName componentName, Intent[] intentArr, Intent intent, int i12, MenuItem[] menuItemArr) {
        int i13;
        PackageManager packageManager = this.f6434i.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i12 & 1) == 0) {
            removeGroup(i9);
        }
        for (int i14 = 0; i14 < size; i14++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i14);
            int i15 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i15 < 0 ? intent : intentArr[i15]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            o a9 = a(i9, i10, i11, resolveInfo.loadLabel(packageManager));
            a9.setIcon(resolveInfo.loadIcon(packageManager));
            a9.f6461o = intent2;
            if (menuItemArr != null && (i13 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i13] = a9;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i9, int i10, int i11, CharSequence charSequence) {
        o a9 = a(i9, i10, i11, charSequence);
        f0 f0Var = new f0(this.f6434i, this, a9);
        a9.f6469w = f0Var;
        f0Var.setHeaderTitle(a9.f6459m);
        return f0Var;
    }

    public final void b(z zVar, Context context) {
        this.C.add(new WeakReference(zVar));
        zVar.g(context, this);
        this.f6444s = true;
    }

    public final void c(boolean z8) {
        if (this.A) {
            return;
        }
        this.A = true;
        CopyOnWriteArrayList copyOnWriteArrayList = this.C;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            z zVar = (z) weakReference.get();
            if (zVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                zVar.a(this, z8);
            }
        }
        this.A = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        o oVar = this.D;
        if (oVar != null) {
            d(oVar);
        }
        this.f6439n.clear();
        p(true);
    }

    public final void clearHeader() {
        this.f6447v = null;
        this.f6446u = null;
        this.f6448w = null;
        p(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(o oVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.C;
        boolean z8 = false;
        if (!copyOnWriteArrayList.isEmpty() && this.D == oVar) {
            w();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                z zVar = (z) weakReference.get();
                if (zVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    z8 = zVar.k(oVar);
                    if (z8) {
                        break;
                    }
                }
            }
            v();
            if (z8) {
                this.D = null;
            }
        }
        return z8;
    }

    public boolean e(m mVar, MenuItem menuItem) {
        k kVar = this.f6438m;
        return kVar != null && kVar.e(mVar, menuItem);
    }

    public boolean f(o oVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.C;
        boolean z8 = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        w();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            z zVar = (z) weakReference.get();
            if (zVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                z8 = zVar.f(oVar);
                if (z8) {
                    break;
                }
            }
        }
        v();
        if (z8) {
            this.D = oVar;
        }
        return z8;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i9) {
        MenuItem findItem;
        ArrayList arrayList = this.f6439n;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            o oVar = (o) arrayList.get(i10);
            if (oVar.f6455i == i9) {
                return oVar;
            }
            if (oVar.hasSubMenu() && (findItem = oVar.f6469w.findItem(i9)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public final o g(int i9, KeyEvent keyEvent) {
        ArrayList arrayList = this.B;
        arrayList.clear();
        h(arrayList, i9, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (o) arrayList.get(0);
        }
        boolean n4 = n();
        for (int i10 = 0; i10 < size; i10++) {
            o oVar = (o) arrayList.get(i10);
            char c9 = n4 ? oVar.f6464r : oVar.f6462p;
            char[] cArr = keyData.meta;
            if ((c9 == cArr[0] && (metaState & 2) == 0) || ((c9 == cArr[2] && (metaState & 2) != 0) || (n4 && c9 == '\b' && i9 == 67))) {
                return oVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i9) {
        return (MenuItem) this.f6439n.get(i9);
    }

    public final void h(List list, int i9, KeyEvent keyEvent) {
        boolean n4 = n();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i9 == 67) {
            ArrayList arrayList = this.f6439n;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                o oVar = (o) arrayList.get(i10);
                if (oVar.hasSubMenu()) {
                    oVar.f6469w.h(list, i9, keyEvent);
                }
                char c9 = n4 ? oVar.f6464r : oVar.f6462p;
                if ((modifiers & 69647) == ((n4 ? oVar.f6465s : oVar.f6463q) & 69647) && c9 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c9 == cArr[0] || c9 == cArr[2] || (n4 && c9 == '\b' && i9 == 67)) && oVar.isEnabled()) {
                        list.add(oVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.F) {
            return true;
        }
        ArrayList arrayList = this.f6439n;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            if (((o) arrayList.get(i9)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList l4 = l();
        if (this.f6444s) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.C;
            Iterator it = copyOnWriteArrayList.iterator();
            boolean z8 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                z zVar = (z) weakReference.get();
                if (zVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    z8 |= zVar.h();
                }
            }
            ArrayList arrayList = this.f6442q;
            ArrayList arrayList2 = this.f6443r;
            if (z8) {
                arrayList.clear();
                arrayList2.clear();
                int size = l4.size();
                for (int i9 = 0; i9 < size; i9++) {
                    o oVar = (o) l4.get(i9);
                    if ((oVar.F & 32) == 32) {
                        arrayList.add(oVar);
                    } else {
                        arrayList2.add(oVar);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(l());
            }
            this.f6444s = false;
        }
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i9, KeyEvent keyEvent) {
        return g(i9, keyEvent) != null;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public final ArrayList l() {
        boolean z8 = this.f6441p;
        ArrayList arrayList = this.f6440o;
        if (!z8) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f6439n;
        int size = arrayList2.size();
        for (int i9 = 0; i9 < size; i9++) {
            o oVar = (o) arrayList2.get(i9);
            if (oVar.isVisible()) {
                arrayList.add(oVar);
            }
        }
        this.f6441p = false;
        this.f6444s = true;
        return arrayList;
    }

    public boolean m() {
        return this.E;
    }

    public boolean n() {
        return this.f6436k;
    }

    public boolean o() {
        return this.f6437l;
    }

    public final void p(boolean z8) {
        if (this.f6449x) {
            this.f6450y = true;
            if (z8) {
                this.f6451z = true;
                return;
            }
            return;
        }
        if (z8) {
            this.f6441p = true;
            this.f6444s = true;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.C;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        w();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            z zVar = (z) weakReference.get();
            if (zVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                zVar.d();
            }
        }
        v();
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i9, int i10) {
        return q(findItem(i9), null, i10);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i9, KeyEvent keyEvent, int i10) {
        o g9 = g(i9, keyEvent);
        boolean q4 = g9 != null ? q(g9, null, i10) : false;
        if ((i10 & 2) != 0) {
            c(true);
        }
        return q4;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(android.view.MenuItem r7, m.z r8, int r9) {
        /*
            r6 = this;
            m.o r7 = (m.o) r7
            r0 = 0
            if (r7 == 0) goto Ld2
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Ld
            goto Ld2
        Ld:
            m.m r1 = r7.f6468v
            android.view.MenuItem$OnMenuItemClickListener r2 = r7.f6470x
            r3 = 1
            if (r2 == 0) goto L1c
            boolean r2 = r2.onMenuItemClick(r7)
            if (r2 == 0) goto L1c
        L1a:
            r1 = 1
            goto L43
        L1c:
            boolean r2 = r1.e(r1, r7)
            if (r2 == 0) goto L23
            goto L1a
        L23:
            android.content.Intent r2 = r7.f6461o
            if (r2 == 0) goto L35
            android.content.Context r1 = r1.f6434i     // Catch: android.content.ActivityNotFoundException -> L2d
            r1.startActivity(r2)     // Catch: android.content.ActivityNotFoundException -> L2d
            goto L1a
        L2d:
            r1 = move-exception
            java.lang.String r2 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r2, r4, r1)
        L35:
            m.p r1 = r7.I
            if (r1 == 0) goto L42
            android.view.ActionProvider r1 = r1.f6473a
            boolean r1 = r1.onPerformDefaultAction()
            if (r1 == 0) goto L42
            goto L1a
        L42:
            r1 = 0
        L43:
            m.p r2 = r7.I
            if (r2 == 0) goto L51
            android.view.ActionProvider r4 = r2.f6473a
            boolean r4 = r4.hasSubMenu()
            if (r4 == 0) goto L51
            r4 = 1
            goto L52
        L51:
            r4 = 0
        L52:
            boolean r5 = r7.e()
            if (r5 == 0) goto L64
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto Ld1
            r6.c(r3)
            goto Ld1
        L64:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L75
            if (r4 == 0) goto L6d
            goto L75
        L6d:
            r7 = r9 & 1
            if (r7 != 0) goto Ld1
            r6.c(r3)
            goto Ld1
        L75:
            r9 = r9 & 4
            if (r9 != 0) goto L7c
            r6.c(r0)
        L7c:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L90
            m.f0 r9 = new m.f0
            android.content.Context r5 = r6.f6434i
            r9.<init>(r5, r6, r7)
            r7.f6469w = r9
            java.lang.CharSequence r5 = r7.f6459m
            r9.setHeaderTitle(r5)
        L90:
            m.f0 r7 = r7.f6469w
            if (r4 == 0) goto L99
            android.view.ActionProvider r9 = r2.f6473a
            r9.onPrepareSubMenu(r7)
        L99:
            java.util.concurrent.CopyOnWriteArrayList r9 = r6.C
            boolean r2 = r9.isEmpty()
            if (r2 == 0) goto La2
            goto Lcb
        La2:
            if (r8 == 0) goto La8
            boolean r0 = r8.i(r7)
        La8:
            java.util.Iterator r8 = r9.iterator()
        Lac:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Lcb
            java.lang.Object r2 = r8.next()
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2
            java.lang.Object r4 = r2.get()
            m.z r4 = (m.z) r4
            if (r4 != 0) goto Lc4
            r9.remove(r2)
            goto Lac
        Lc4:
            if (r0 != 0) goto Lac
            boolean r0 = r4.i(r7)
            goto Lac
        Lcb:
            r1 = r1 | r0
            if (r1 != 0) goto Ld1
            r6.c(r3)
        Ld1:
            return r1
        Ld2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m.m.q(android.view.MenuItem, m.z, int):boolean");
    }

    public final void r(z zVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.C;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            z zVar2 = (z) weakReference.get();
            if (zVar2 == null || zVar2 == zVar) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    @Override // android.view.Menu
    public final void removeGroup(int i9) {
        ArrayList arrayList = this.f6439n;
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                i11 = -1;
                break;
            } else if (((o) arrayList.get(i11)).f6456j == i9) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 >= 0) {
            int size2 = arrayList.size() - i11;
            while (true) {
                int i12 = i10 + 1;
                if (i10 >= size2 || ((o) arrayList.get(i11)).f6456j != i9) {
                    break;
                }
                if (i11 >= 0 && i11 < arrayList.size()) {
                    arrayList.remove(i11);
                }
                i10 = i12;
            }
            p(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i9) {
        ArrayList arrayList = this.f6439n;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (((o) arrayList.get(i10)).f6455i == i9) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 < 0 || i10 >= arrayList.size()) {
            return;
        }
        arrayList.remove(i10);
        p(true);
    }

    public final void s(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(j());
        int size = this.f6439n.size();
        for (int i9 = 0; i9 < size; i9++) {
            MenuItem item = getItem(i9);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((f0) item.getSubMenu()).s(bundle);
            }
        }
        int i10 = bundle.getInt("android:menu:expandedactionview");
        if (i10 <= 0 || (findItem = findItem(i10)) == null) {
            return;
        }
        findItem.expandActionView();
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i9, boolean z8, boolean z9) {
        ArrayList arrayList = this.f6439n;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            o oVar = (o) arrayList.get(i10);
            if (oVar.f6456j == i9) {
                oVar.F = (oVar.F & (-5)) | (z9 ? 4 : 0);
                oVar.setCheckable(z8);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z8) {
        this.E = z8;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i9, boolean z8) {
        ArrayList arrayList = this.f6439n;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            o oVar = (o) arrayList.get(i10);
            if (oVar.f6456j == i9) {
                oVar.setEnabled(z8);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i9, boolean z8) {
        ArrayList arrayList = this.f6439n;
        int size = arrayList.size();
        boolean z9 = false;
        for (int i10 = 0; i10 < size; i10++) {
            o oVar = (o) arrayList.get(i10);
            if (oVar.f6456j == i9) {
                int i11 = oVar.F;
                int i12 = (i11 & (-9)) | (z8 ? 0 : 8);
                oVar.F = i12;
                if (i11 != i12) {
                    z9 = true;
                }
            }
        }
        if (z9) {
            p(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z8) {
        this.f6436k = z8;
        p(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f6439n.size();
    }

    public final void t(Bundle bundle) {
        int size = this.f6439n.size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i9 = 0; i9 < size; i9++) {
            MenuItem item = getItem(i9);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((f0) item.getSubMenu()).t(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    public final void u(int i9, CharSequence charSequence, int i10, Drawable drawable, View view) {
        if (view != null) {
            this.f6448w = view;
            this.f6446u = null;
            this.f6447v = null;
        } else {
            if (i9 > 0) {
                this.f6446u = this.f6435j.getText(i9);
            } else if (charSequence != null) {
                this.f6446u = charSequence;
            }
            if (i10 > 0) {
                this.f6447v = d0.c.b(this.f6434i, i10);
            } else if (drawable != null) {
                this.f6447v = drawable;
            }
            this.f6448w = null;
        }
        p(false);
    }

    public final void v() {
        this.f6449x = false;
        if (this.f6450y) {
            this.f6450y = false;
            p(this.f6451z);
        }
    }

    public final void w() {
        if (this.f6449x) {
            return;
        }
        this.f6449x = true;
        this.f6450y = false;
        this.f6451z = false;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i9, int i10, int i11, CharSequence charSequence) {
        return a(i9, i10, i11, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i9, int i10, int i11, int i12) {
        return a(i9, i10, i11, this.f6435j.getString(i12));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i9) {
        return addSubMenu(0, 0, 0, this.f6435j.getString(i9));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i9, int i10, int i11, int i12) {
        return addSubMenu(i9, i10, i11, this.f6435j.getString(i12));
    }

    public m k() {
        return this;
    }
}
