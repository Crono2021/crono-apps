package l;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    public static Configuration f5679f;

    /* renamed from: a, reason: collision with root package name */
    public int f5680a;

    /* renamed from: b, reason: collision with root package name */
    public Resources.Theme f5681b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f5682c;

    /* renamed from: d, reason: collision with root package name */
    public Configuration f5683d;

    /* renamed from: e, reason: collision with root package name */
    public Resources f5684e;

    public d(Context context, int i9) {
        super(context);
        this.f5680a = i9;
    }

    public final void a(Configuration configuration) {
        if (this.f5684e != null) {
            m7.c.p("getResources() or getAssets() has already been called");
        } else if (this.f5683d == null) {
            this.f5683d = new Configuration(configuration);
        } else {
            m7.c.p("Override configuration has already been set");
        }
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.f5681b == null) {
            this.f5681b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f5681b.setTo(theme);
            }
        }
        this.f5681b.applyStyle(this.f5680a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        if (r0.equals(l.d.f5679f) != false) goto L15;
     */
    @Override // android.content.ContextWrapper, android.content.Context
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.content.res.Resources getResources() {
        /*
            r3 = this;
            android.content.res.Resources r0 = r3.f5684e
            if (r0 != 0) goto L38
            android.content.res.Configuration r0 = r3.f5683d
            if (r0 == 0) goto L32
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L25
            android.content.res.Configuration r1 = l.d.f5679f
            if (r1 != 0) goto L1c
            android.content.res.Configuration r1 = new android.content.res.Configuration
            r1.<init>()
            r2 = 0
            r1.fontScale = r2
            l.d.f5679f = r1
        L1c:
            android.content.res.Configuration r1 = l.d.f5679f
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L25
            goto L32
        L25:
            android.content.res.Configuration r0 = r3.f5683d
            android.content.Context r0 = l.c.a(r3, r0)
            android.content.res.Resources r0 = r0.getResources()
            r3.f5684e = r0
            goto L38
        L32:
            android.content.res.Resources r0 = super.getResources()
            r3.f5684e = r0
        L38:
            android.content.res.Resources r0 = r3.f5684e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l.d.getResources():android.content.res.Resources");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f5682c == null) {
            this.f5682c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f5682c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f5681b;
        if (theme != null) {
            return theme;
        }
        if (this.f5680a == 0) {
            this.f5680a = 2132017727;
        }
        b();
        return this.f5681b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i9) {
        if (this.f5680a != i9) {
            this.f5680a = i9;
            b();
        }
    }
}
