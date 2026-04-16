package c7;

import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.media3.ui.PlayerView;
import u5.i;
import u5.j;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public Object f1649c;

    /* renamed from: j, reason: collision with root package name */
    public Object f1655j;

    /* renamed from: k, reason: collision with root package name */
    public Object f1656k;

    /* renamed from: l, reason: collision with root package name */
    public Object f1657l;

    /* renamed from: d, reason: collision with root package name */
    public Object f1650d = new i();

    /* renamed from: e, reason: collision with root package name */
    public Object f1651e = new i();

    /* renamed from: a, reason: collision with root package name */
    public Object f1647a = new i();

    /* renamed from: b, reason: collision with root package name */
    public Object f1648b = new i();

    /* renamed from: f, reason: collision with root package name */
    public Object f1652f = new u5.a(0.0f);

    /* renamed from: g, reason: collision with root package name */
    public Object f1653g = new u5.a(0.0f);
    public Object h = new u5.a(0.0f);

    /* renamed from: i, reason: collision with root package name */
    public Object f1654i = new u5.a(0.0f);

    public b() {
        int i9 = 0;
        this.f1649c = new u5.e(i9);
        this.f1655j = new u5.e(i9);
        this.f1656k = new u5.e(i9);
        this.f1657l = new u5.e(i9);
    }

    public static b b(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(2131558430, (ViewGroup) null, false);
        int i9 = 2131361892;
        ImageButton imageButton = (ImageButton) com.bumptech.glide.d.z(inflate, 2131361892);
        if (imageButton != null) {
            i9 = 2131362171;
            LinearLayout linearLayout = (LinearLayout) com.bumptech.glide.d.z(inflate, 2131362171);
            if (linearLayout != null) {
                i9 = 2131362234;
                SurfaceView surfaceView = (SurfaceView) com.bumptech.glide.d.z(inflate, 2131362234);
                if (surfaceView != null) {
                    i9 = 2131362285;
                    PlayerView playerView = (PlayerView) com.bumptech.glide.d.z(inflate, 2131362285);
                    if (playerView != null) {
                        i9 = 2131362340;
                        ScrollView scrollView = (ScrollView) com.bumptech.glide.d.z(inflate, 2131362340);
                        if (scrollView != null) {
                            i9 = 2131362442;
                            TextView textView = (TextView) com.bumptech.glide.d.z(inflate, 2131362442);
                            if (textView != null) {
                                i9 = 2131362443;
                                if (((TextView) com.bumptech.glide.d.z(inflate, 2131362443)) != null) {
                                    i9 = 2131362444;
                                    TextView textView2 = (TextView) com.bumptech.glide.d.z(inflate, 2131362444);
                                    if (textView2 != null) {
                                        i9 = 2131362445;
                                        TextView textView3 = (TextView) com.bumptech.glide.d.z(inflate, 2131362445);
                                        if (textView3 != null) {
                                            i9 = 2131362465;
                                            TextView textView4 = (TextView) com.bumptech.glide.d.z(inflate, 2131362465);
                                            if (textView4 != null) {
                                                i9 = 2131362484;
                                                LinearLayout linearLayout2 = (LinearLayout) com.bumptech.glide.d.z(inflate, 2131362484);
                                                if (linearLayout2 != null) {
                                                    i9 = 2131362514;
                                                    FrameLayout frameLayout = (FrameLayout) com.bumptech.glide.d.z(inflate, 2131362514);
                                                    if (frameLayout != null) {
                                                        b bVar = new b();
                                                        bVar.f1650d = (FrameLayout) inflate;
                                                        bVar.f1647a = imageButton;
                                                        bVar.f1648b = linearLayout;
                                                        bVar.f1653g = surfaceView;
                                                        bVar.h = playerView;
                                                        bVar.f1654i = scrollView;
                                                        bVar.f1649c = textView;
                                                        bVar.f1655j = textView2;
                                                        bVar.f1656k = textView3;
                                                        bVar.f1657l = textView4;
                                                        bVar.f1652f = linearLayout2;
                                                        bVar.f1651e = frameLayout;
                                                        return bVar;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        m7.c.o("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i9)));
        return null;
    }

    public j a() {
        j jVar = new j();
        jVar.f9103a = (com.bumptech.glide.c) this.f1650d;
        jVar.f9104b = (com.bumptech.glide.c) this.f1651e;
        jVar.f9105c = (com.bumptech.glide.c) this.f1647a;
        jVar.f9106d = (com.bumptech.glide.c) this.f1648b;
        jVar.f9107e = (u5.c) this.f1652f;
        jVar.f9108f = (u5.c) this.f1653g;
        jVar.f9109g = (u5.c) this.h;
        jVar.h = (u5.c) this.f1654i;
        jVar.f9110i = (u5.e) this.f1649c;
        jVar.f9111j = (u5.e) this.f1655j;
        jVar.f9112k = (u5.e) this.f1656k;
        jVar.f9113l = (u5.e) this.f1657l;
        return jVar;
    }

    public void c(float f9) {
        this.f1652f = new u5.a(f9);
        this.f1653g = new u5.a(f9);
        this.h = new u5.a(f9);
        this.f1654i = new u5.a(f9);
    }
}
