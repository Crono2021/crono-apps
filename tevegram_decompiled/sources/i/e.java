package i;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends g implements g0.e {
    public int A;
    public boolean B;

    /* renamed from: v, reason: collision with root package name */
    public b f4266v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f4267w;

    /* renamed from: x, reason: collision with root package name */
    public b f4268x;

    /* renamed from: y, reason: collision with root package name */
    public android.support.v4.media.session.b f4269y;

    /* renamed from: z, reason: collision with root package name */
    public int f4270z;

    public e(b bVar, Resources resources) {
        this.f4278m = 255;
        this.f4280o = -1;
        this.f4270z = -1;
        this.A = -1;
        d(new b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0272, code lost:
    
        r5.onStateChange(r5.getState());
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0279, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static i.e e(android.content.Context r24, android.content.res.Resources r25, android.content.res.XmlResourceParser r26, android.util.AttributeSet r27, android.content.res.Resources.Theme r28) {
        /*
            Method dump skipped, instructions count: 664
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i.e.e(android.content.Context, android.content.res.Resources, android.content.res.XmlResourceParser, android.util.AttributeSet, android.content.res.Resources$Theme):i.e");
    }

    @Override // i.g, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // i.g
    public final void d(b bVar) {
        this.f4274i = bVar;
        int i9 = this.f4280o;
        if (i9 >= 0) {
            Drawable d9 = bVar.d(i9);
            this.f4276k = d9;
            if (d9 != null) {
                b(d9);
            }
        }
        this.f4277l = null;
        this.f4266v = bVar;
        this.f4268x = bVar;
    }

    public final Drawable f() {
        if (!this.f4267w) {
            super.mutate();
            b bVar = this.f4266v;
            bVar.I = bVar.I.clone();
            bVar.J = bVar.J.clone();
            this.f4267w = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return true;
    }

    @Override // i.g, android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        super.jumpToCurrentState();
        android.support.v4.media.session.b bVar = this.f4269y;
        if (bVar != null) {
            bVar.x0();
            this.f4269y = null;
            c(this.f4270z);
            this.f4270z = -1;
            this.A = -1;
        }
    }

    @Override // i.g, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.B) {
            f();
            b bVar = this.f4268x;
            bVar.I = bVar.I.clone();
            bVar.J = bVar.J.clone();
            this.B = true;
        }
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00fd, code lost:
    
        if (c(r5) != false) goto L52;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onStateChange(int[] r18) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i.e.onStateChange(int[]):boolean");
    }

    @Override // i.g, android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z8, boolean z9) {
        boolean visible = super.setVisible(z8, z9);
        android.support.v4.media.session.b bVar = this.f4269y;
        if (bVar != null && (visible || z9)) {
            if (z8) {
                bVar.w0();
                return visible;
            }
            jumpToCurrentState();
        }
        return visible;
    }
}
