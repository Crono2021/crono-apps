package q5;

import android.R;
import android.content.res.ColorStateList;
import com.bumptech.glide.c;
import n.d0;
import r0.b;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends d0 {

    /* renamed from: o, reason: collision with root package name */
    public static final int[][] f8474o = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f8475m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8476n;

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f8475m == null) {
            int v8 = c.v(this, 2130968807);
            int v9 = c.v(this, 2130968826);
            int v10 = c.v(this, 2130968848);
            this.f8475m = new ColorStateList(f8474o, new int[]{c.H(1.0f, v10, v8), c.H(0.54f, v10, v9), c.H(0.38f, v10, v9), c.H(0.38f, v10, v9)});
        }
        return this.f8475m;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f8476n && b.a(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z8) {
        this.f8476n = z8;
        if (z8) {
            b.c(this, getMaterialThemeColorsTintList());
        } else {
            b.c(this, null);
        }
    }
}
