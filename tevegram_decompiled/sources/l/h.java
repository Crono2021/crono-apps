package l;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.Constructor;
import m.o;
import m.p;
import m.t;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h {
    public CharSequence A;
    public CharSequence B;
    public final /* synthetic */ i E;

    /* renamed from: a, reason: collision with root package name */
    public final Menu f5696a;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public int f5703i;

    /* renamed from: j, reason: collision with root package name */
    public int f5704j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f5705k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f5706l;

    /* renamed from: m, reason: collision with root package name */
    public int f5707m;

    /* renamed from: n, reason: collision with root package name */
    public char f5708n;

    /* renamed from: o, reason: collision with root package name */
    public int f5709o;

    /* renamed from: p, reason: collision with root package name */
    public char f5710p;

    /* renamed from: q, reason: collision with root package name */
    public int f5711q;

    /* renamed from: r, reason: collision with root package name */
    public int f5712r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f5713s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f5714t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f5715u;

    /* renamed from: v, reason: collision with root package name */
    public int f5716v;

    /* renamed from: w, reason: collision with root package name */
    public int f5717w;

    /* renamed from: x, reason: collision with root package name */
    public String f5718x;

    /* renamed from: y, reason: collision with root package name */
    public String f5719y;

    /* renamed from: z, reason: collision with root package name */
    public p f5720z;
    public ColorStateList C = null;
    public PorterDuff.Mode D = null;

    /* renamed from: b, reason: collision with root package name */
    public int f5697b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f5698c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f5699d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f5700e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5701f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5702g = true;

    public h(i iVar, Menu menu) {
        this.E = iVar;
        this.f5696a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.E.f5725c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e9) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e9);
            return null;
        }
    }

    public final void b(MenuItem menuItem) {
        i iVar = this.E;
        Context context = iVar.f5725c;
        boolean z8 = false;
        menuItem.setChecked(this.f5713s).setVisible(this.f5714t).setEnabled(this.f5715u).setCheckable(this.f5712r >= 1).setTitleCondensed(this.f5706l).setIcon(this.f5707m);
        int i9 = this.f5716v;
        if (i9 >= 0) {
            menuItem.setShowAsAction(i9);
        }
        if (this.f5719y != null) {
            if (context.isRestricted()) {
                m7.c.p("The android:onClick attribute cannot be used within a restricted context");
                return;
            }
            if (iVar.f5726d == null) {
                iVar.f5726d = i.a(context);
            }
            Object obj = iVar.f5726d;
            String str = this.f5719y;
            g gVar = new g();
            gVar.f5694a = obj;
            Class<?> cls = obj.getClass();
            try {
                gVar.f5695b = cls.getMethod(str, g.f5693c);
                menuItem.setOnMenuItemClickListener(gVar);
            } catch (Exception e9) {
                StringBuilder r8 = androidx.activity.g.r("Couldn't resolve menu item onClick handler ", str, " in class ");
                r8.append(cls.getName());
                InflateException inflateException = new InflateException(r8.toString());
                inflateException.initCause(e9);
                throw inflateException;
            }
        }
        if (this.f5712r >= 2) {
            if (menuItem instanceof o) {
                o oVar = (o) menuItem;
                oVar.F = (oVar.F & (-5)) | 4;
            } else if (menuItem instanceof t) {
                t tVar = (t) menuItem;
                h0.a aVar = tVar.f6480k;
                try {
                    if (tVar.f6481l == null) {
                        tVar.f6481l = aVar.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    tVar.f6481l.invoke(aVar, Boolean.TRUE);
                } catch (Exception e10) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e10);
                }
            }
        }
        String str2 = this.f5718x;
        if (str2 != null) {
            menuItem.setActionView((View) a(str2, i.f5721e, iVar.f5723a));
            z8 = true;
        }
        int i10 = this.f5717w;
        if (i10 > 0) {
            if (z8) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i10);
            }
        }
        p pVar = this.f5720z;
        if (pVar != null) {
            if (menuItem instanceof h0.a) {
                ((h0.a) menuItem).a(pVar);
            } else {
                Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
        CharSequence charSequence = this.A;
        boolean z9 = menuItem instanceof h0.a;
        if (z9) {
            ((h0.a) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            n0.m.h(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.B;
        if (z9) {
            ((h0.a) menuItem).setTooltipText(charSequence2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            n0.m.m(menuItem, charSequence2);
        }
        char c9 = this.f5708n;
        int i11 = this.f5709o;
        if (z9) {
            ((h0.a) menuItem).setAlphabeticShortcut(c9, i11);
        } else if (Build.VERSION.SDK_INT >= 26) {
            n0.m.g(menuItem, c9, i11);
        }
        char c10 = this.f5710p;
        int i12 = this.f5711q;
        if (z9) {
            ((h0.a) menuItem).setNumericShortcut(c10, i12);
        } else if (Build.VERSION.SDK_INT >= 26) {
            n0.m.k(menuItem, c10, i12);
        }
        PorterDuff.Mode mode = this.D;
        if (mode != null) {
            if (z9) {
                ((h0.a) menuItem).setIconTintMode(mode);
            } else if (Build.VERSION.SDK_INT >= 26) {
                n0.m.j(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.C;
        if (colorStateList != null) {
            if (z9) {
                ((h0.a) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                n0.m.i(menuItem, colorStateList);
            }
        }
    }
}
