package n;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t2 {

    /* renamed from: i, reason: collision with root package name */
    public static t2 f7048i;

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap f7050a;

    /* renamed from: b, reason: collision with root package name */
    public s.h f7051b;

    /* renamed from: c, reason: collision with root package name */
    public s.i f7052c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakHashMap f7053d = new WeakHashMap(0);

    /* renamed from: e, reason: collision with root package name */
    public TypedValue f7054e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7055f;

    /* renamed from: g, reason: collision with root package name */
    public m6.p f7056g;
    public static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j, reason: collision with root package name */
    public static final r2 f7049j = new r2(6);

    public static synchronized t2 d() {
        t2 t2Var;
        synchronized (t2.class) {
            try {
                if (f7048i == null) {
                    t2 t2Var2 = new t2();
                    f7048i = t2Var2;
                    j(t2Var2);
                }
                t2Var = f7048i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return t2Var;
    }

    public static synchronized PorterDuffColorFilter h(int i9, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (t2.class) {
            r2 r2Var = f7049j;
            r2Var.getClass();
            int i10 = (31 + i9) * 31;
            porterDuffColorFilter = (PorterDuffColorFilter) r2Var.d(Integer.valueOf(mode.hashCode() + i10));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i9, mode);
            }
        }
        return porterDuffColorFilter;
    }

    public static void j(t2 t2Var) {
        if (Build.VERSION.SDK_INT < 24) {
            t2Var.a("vector", new s2(3));
            t2Var.a("animated-vector", new s2(2));
            t2Var.a("animated-selector", new s2(1));
            t2Var.a("drawable", new s2(0));
        }
    }

    public final void a(String str, s2 s2Var) {
        if (this.f7051b == null) {
            this.f7051b = new s.h();
        }
        this.f7051b.put(str, s2Var);
    }

    public final synchronized void b(Context context, long j5, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                s.g gVar = (s.g) this.f7053d.get(context);
                if (gVar == null) {
                    gVar = new s.g();
                    this.f7053d.put(context, gVar);
                }
                gVar.f(j5, new WeakReference(constantState));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Drawable c(Context context, int i9) {
        if (this.f7054e == null) {
            this.f7054e = new TypedValue();
        }
        TypedValue typedValue = this.f7054e;
        context.getResources().getValue(i9, typedValue, true);
        long j5 = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable e9 = e(context, j5);
        if (e9 != null) {
            return e9;
        }
        LayerDrawable layerDrawable = null;
        if (this.f7056g != null) {
            if (i9 == 2131230776) {
                layerDrawable = new LayerDrawable(new Drawable[]{f(context, 2131230775), f(context, 2131230777)});
            } else if (i9 == 2131230811) {
                layerDrawable = m6.p.f(this, context, 2131165243);
            } else if (i9 == 2131230810) {
                layerDrawable = m6.p.f(this, context, 2131165244);
            } else if (i9 == 2131230812) {
                layerDrawable = m6.p.f(this, context, 2131165245);
            }
        }
        if (layerDrawable != null) {
            layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, j5, layerDrawable);
        }
        return layerDrawable;
    }

    public final synchronized Drawable e(Context context, long j5) {
        s.g gVar = (s.g) this.f7053d.get(context);
        if (gVar == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) gVar.e(j5, null);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int b9 = s.f.b(gVar.f8644j, gVar.f8646l, j5);
            if (b9 >= 0) {
                Object[] objArr = gVar.f8645k;
                Object obj = objArr[b9];
                Object obj2 = s.g.f8642m;
                if (obj != obj2) {
                    objArr[b9] = obj2;
                    gVar.f8643i = true;
                }
            }
        }
        return null;
    }

    public final synchronized Drawable f(Context context, int i9) {
        return g(context, i9, false);
    }

    public final synchronized Drawable g(Context context, int i9, boolean z8) {
        Drawable k3;
        try {
            if (!this.f7055f) {
                this.f7055f = true;
                Drawable f9 = f(context, 2131230838);
                if (f9 == null || (!(f9 instanceof w3.p) && !"android.graphics.drawable.VectorDrawable".equals(f9.getClass().getName()))) {
                    this.f7055f = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            k3 = k(context, i9);
            if (k3 == null) {
                k3 = c(context, i9);
            }
            if (k3 == null) {
                k3 = d0.c.b(context, i9);
            }
            if (k3 != null) {
                k3 = n(context, i9, z8, k3);
            }
            if (k3 != null) {
                r1.a(k3);
            }
        } catch (Throwable th) {
            throw th;
        }
        return k3;
    }

    public final synchronized ColorStateList i(Context context, int i9) {
        ColorStateList colorStateList;
        s.i iVar;
        WeakHashMap weakHashMap = this.f7050a;
        ColorStateList colorStateList2 = null;
        colorStateList = (weakHashMap == null || (iVar = (s.i) weakHashMap.get(context)) == null) ? null : (ColorStateList) iVar.c(i9, null);
        if (colorStateList == null) {
            m6.p pVar = this.f7056g;
            if (pVar != null) {
                colorStateList2 = pVar.g(context, i9);
            }
            if (colorStateList2 != null) {
                if (this.f7050a == null) {
                    this.f7050a = new WeakHashMap();
                }
                s.i iVar2 = (s.i) this.f7050a.get(context);
                if (iVar2 == null) {
                    iVar2 = new s.i();
                    this.f7050a.put(context, iVar2);
                }
                iVar2.a(i9, colorStateList2);
            }
            colorStateList = colorStateList2;
        }
        return colorStateList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        if (r11.f7051b.getOrDefault(r0, null) != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable k(android.content.Context r12, int r13) {
        /*
            r11 = this;
            s.h r0 = r11.f7051b
            r1 = 0
            if (r0 == 0) goto Lba
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Lba
            s.i r0 = r11.f7052c
            java.lang.String r2 = "appcompat_skip_skip"
            if (r0 == 0) goto L29
            java.lang.Object r0 = r0.c(r13, r1)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = r2.equals(r0)
            if (r3 != 0) goto Lba
            if (r0 == 0) goto L30
            s.h r3 = r11.f7051b
            java.lang.Object r0 = r3.getOrDefault(r0, r1)
            if (r0 != 0) goto L30
            goto Lba
        L29:
            s.i r0 = new s.i
            r0.<init>()
            r11.f7052c = r0
        L30:
            android.util.TypedValue r0 = r11.f7054e
            if (r0 != 0) goto L3b
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r11.f7054e = r0
        L3b:
            android.util.TypedValue r0 = r11.f7054e
            android.content.res.Resources r3 = r12.getResources()
            r4 = 1
            r3.getValue(r13, r0, r4)
            int r5 = r0.assetCookie
            long r5 = (long) r5
            r7 = 32
            long r5 = r5 << r7
            int r7 = r0.data
            long r7 = (long) r7
            long r5 = r5 | r7
            android.graphics.drawable.Drawable r7 = r11.e(r12, r5)
            if (r7 == 0) goto L56
            return r7
        L56:
            java.lang.CharSequence r8 = r0.string
            if (r8 == 0) goto Lb2
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = ".xml"
            boolean r8 = r8.endsWith(r9)
            if (r8 == 0) goto Lb2
            android.content.res.XmlResourceParser r3 = r3.getXml(r13)     // Catch: java.lang.Exception -> L96
            android.util.AttributeSet r8 = android.util.Xml.asAttributeSet(r3)     // Catch: java.lang.Exception -> L96
        L6e:
            int r9 = r3.next()     // Catch: java.lang.Exception -> L96
            r10 = 2
            if (r9 == r10) goto L78
            if (r9 == r4) goto L78
            goto L6e
        L78:
            if (r9 != r10) goto La3
            java.lang.String r4 = r3.getName()     // Catch: java.lang.Exception -> L96
            s.i r9 = r11.f7052c     // Catch: java.lang.Exception -> L96
            r9.a(r13, r4)     // Catch: java.lang.Exception -> L96
            s.h r9 = r11.f7051b     // Catch: java.lang.Exception -> L96
            java.lang.Object r1 = r9.getOrDefault(r4, r1)     // Catch: java.lang.Exception -> L96
            n.s2 r1 = (n.s2) r1     // Catch: java.lang.Exception -> L96
            if (r1 == 0) goto L98
            android.content.res.Resources$Theme r4 = r12.getTheme()     // Catch: java.lang.Exception -> L96
            android.graphics.drawable.Drawable r7 = r1.a(r12, r3, r8, r4)     // Catch: java.lang.Exception -> L96
            goto L98
        L96:
            r12 = move-exception
            goto Lab
        L98:
            if (r7 == 0) goto Lb2
            int r0 = r0.changingConfigurations     // Catch: java.lang.Exception -> L96
            r7.setChangingConfigurations(r0)     // Catch: java.lang.Exception -> L96
            r11.b(r12, r5, r7)     // Catch: java.lang.Exception -> L96
            goto Lb2
        La3:
            org.xmlpull.v1.XmlPullParserException r12 = new org.xmlpull.v1.XmlPullParserException     // Catch: java.lang.Exception -> L96
            java.lang.String r0 = "No start tag found"
            r12.<init>(r0)     // Catch: java.lang.Exception -> L96
            throw r12     // Catch: java.lang.Exception -> L96
        Lab:
            java.lang.String r0 = "ResourceManagerInternal"
            java.lang.String r1 = "Exception while inflating drawable"
            android.util.Log.e(r0, r1, r12)
        Lb2:
            if (r7 != 0) goto Lb9
            s.i r12 = r11.f7052c
            r12.a(r13, r2)
        Lb9:
            return r7
        Lba:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: n.t2.k(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    public final synchronized void l(Context context) {
        s.g gVar = (s.g) this.f7053d.get(context);
        if (gVar != null) {
            gVar.b();
        }
    }

    public final synchronized void m(m6.p pVar) {
        this.f7056g = pVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable n(android.content.Context r10, int r11, boolean r12, android.graphics.drawable.Drawable r13) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.t2.n(android.content.Context, int, boolean, android.graphics.drawable.Drawable):android.graphics.drawable.Drawable");
    }
}
