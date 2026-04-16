package n;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class y3 implements o1 {

    /* renamed from: a, reason: collision with root package name */
    public Toolbar f7109a;

    /* renamed from: b, reason: collision with root package name */
    public int f7110b;

    /* renamed from: c, reason: collision with root package name */
    public View f7111c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f7112d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f7113e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f7114f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7115g;
    public CharSequence h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f7116i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f7117j;

    /* renamed from: k, reason: collision with root package name */
    public Window.Callback f7118k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f7119l;

    /* renamed from: m, reason: collision with root package name */
    public j f7120m;

    /* renamed from: n, reason: collision with root package name */
    public int f7121n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f7122o;

    public final void a(int i9) {
        View view;
        Toolbar toolbar = this.f7109a;
        int i10 = this.f7110b ^ i9;
        this.f7110b = i9;
        if (i10 != 0) {
            if ((i10 & 4) != 0) {
                if ((i9 & 4) != 0) {
                    b();
                }
                if ((this.f7110b & 4) != 0) {
                    Drawable drawable = this.f7114f;
                    if (drawable == null) {
                        drawable = this.f7122o;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i10 & 3) != 0) {
                c();
            }
            if ((i10 & 8) != 0) {
                if ((i9 & 8) != 0) {
                    toolbar.setTitle(this.h);
                    toolbar.setSubtitle(this.f7116i);
                } else {
                    toolbar.setTitle((CharSequence) null);
                    toolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((i10 & 16) == 0 || (view = this.f7111c) == null) {
                return;
            }
            if ((i9 & 16) != 0) {
                toolbar.addView(view);
            } else {
                toolbar.removeView(view);
            }
        }
    }

    public final void b() {
        if ((this.f7110b & 4) != 0) {
            boolean isEmpty = TextUtils.isEmpty(this.f7117j);
            Toolbar toolbar = this.f7109a;
            if (isEmpty) {
                toolbar.setNavigationContentDescription(this.f7121n);
            } else {
                toolbar.setNavigationContentDescription(this.f7117j);
            }
        }
    }

    public final void c() {
        Drawable drawable;
        int i9 = this.f7110b;
        if ((i9 & 2) == 0) {
            drawable = null;
        } else if ((i9 & 1) != 0) {
            drawable = this.f7113e;
            if (drawable == null) {
                drawable = this.f7112d;
            }
        } else {
            drawable = this.f7112d;
        }
        this.f7109a.setLogo(drawable);
    }
}
