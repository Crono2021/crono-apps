package androidx.media3.ui;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import b2.r;
import b6.g0;
import c2.l;
import d0.c;
import d1.a;
import d1.h1;
import d1.o;
import d1.t0;
import g1.w;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import l3.a0;
import l3.b0;
import l3.h;
import l3.p;
import l3.q;
import l3.v;
import l3.x;
import l3.y;
import l3.z;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class PlayerView extends FrameLayout {
    public static final /* synthetic */ int H = 0;
    public boolean A;
    public CharSequence B;
    public int C;
    public boolean D;
    public boolean E;
    public boolean F;
    public int G;

    /* renamed from: i, reason: collision with root package name */
    public final y f997i;

    /* renamed from: j, reason: collision with root package name */
    public final AspectRatioFrameLayout f998j;

    /* renamed from: k, reason: collision with root package name */
    public final View f999k;

    /* renamed from: l, reason: collision with root package name */
    public final View f1000l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f1001m;

    /* renamed from: n, reason: collision with root package name */
    public final ImageView f1002n;

    /* renamed from: o, reason: collision with root package name */
    public final SubtitleView f1003o;

    /* renamed from: p, reason: collision with root package name */
    public final View f1004p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f1005q;

    /* renamed from: r, reason: collision with root package name */
    public final q f1006r;

    /* renamed from: s, reason: collision with root package name */
    public final FrameLayout f1007s;

    /* renamed from: t, reason: collision with root package name */
    public final FrameLayout f1008t;

    /* renamed from: u, reason: collision with root package name */
    public t0 f1009u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1010v;

    /* renamed from: w, reason: collision with root package name */
    public p f1011w;

    /* renamed from: x, reason: collision with root package name */
    public int f1012x;

    /* renamed from: y, reason: collision with root package name */
    public Drawable f1013y;

    /* renamed from: z, reason: collision with root package name */
    public int f1014z;

    public PlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        boolean z8;
        int i9;
        boolean z9;
        int i10;
        int i11;
        int i12;
        boolean z10;
        int i13;
        boolean z11;
        int i14;
        boolean z12;
        boolean z13;
        boolean z14;
        int color;
        y yVar = new y(this);
        this.f997i = yVar;
        if (isInEditMode()) {
            this.f998j = null;
            this.f999k = null;
            this.f1000l = null;
            this.f1001m = false;
            this.f1002n = null;
            this.f1003o = null;
            this.f1004p = null;
            this.f1005q = null;
            this.f1006r = null;
            this.f1007s = null;
            this.f1008t = null;
            ImageView imageView = new ImageView(context);
            if (w.f3713a >= 23) {
                Resources resources = getResources();
                imageView.setImageDrawable(w.s(context, resources, 2131230869));
                color = resources.getColor(2131099747, null);
                imageView.setBackgroundColor(color);
            } else {
                Resources resources2 = getResources();
                imageView.setImageDrawable(w.s(context, resources2, 2131230869));
                imageView.setBackgroundColor(resources2.getColor(2131099747));
            }
            addView(imageView);
            return;
        }
        int i15 = 2131558463;
        int i16 = 5000;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, b0.f6089d, 0, 0);
            try {
                z11 = obtainStyledAttributes.hasValue(28);
                i13 = obtainStyledAttributes.getColor(28, 0);
                i15 = obtainStyledAttributes.getResourceId(15, 2131558463);
                boolean z15 = obtainStyledAttributes.getBoolean(33, true);
                i14 = obtainStyledAttributes.getInt(3, 1);
                int resourceId = obtainStyledAttributes.getResourceId(9, 0);
                z12 = obtainStyledAttributes.getBoolean(34, true);
                int i17 = obtainStyledAttributes.getInt(29, 1);
                int i18 = obtainStyledAttributes.getInt(17, 0);
                i16 = obtainStyledAttributes.getInt(26, 5000);
                boolean z16 = obtainStyledAttributes.getBoolean(11, true);
                boolean z17 = obtainStyledAttributes.getBoolean(4, true);
                int integer = obtainStyledAttributes.getInteger(23, 0);
                this.A = obtainStyledAttributes.getBoolean(12, this.A);
                boolean z18 = obtainStyledAttributes.getBoolean(10, true);
                obtainStyledAttributes.recycle();
                i9 = integer;
                z10 = z17;
                z13 = z15;
                i12 = resourceId;
                i10 = i18;
                i11 = i17;
                z9 = z18;
                z8 = z16;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z8 = true;
            i9 = 0;
            z9 = true;
            i10 = 0;
            i11 = 1;
            i12 = 0;
            z10 = true;
            i13 = 0;
            z11 = false;
            i14 = 1;
            z12 = true;
            z13 = true;
        }
        LayoutInflater.from(context).inflate(i15, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(2131362047);
        this.f998j = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setResizeMode(i10);
        }
        View findViewById = findViewById(2131362080);
        this.f999k = findViewById;
        if (findViewById != null && z11) {
            findViewById.setBackgroundColor(i13);
        }
        if (aspectRatioFrameLayout == null || i11 == 0) {
            this.f1000l = null;
            z14 = false;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i11 == 2) {
                this.f1000l = new TextureView(context);
            } else if (i11 == 3) {
                try {
                    int i19 = l.f1597t;
                    this.f1000l = (View) l.class.getConstructor(Context.class).newInstance(context);
                    z14 = true;
                    this.f1000l.setLayoutParams(layoutParams);
                    this.f1000l.setOnClickListener(yVar);
                    this.f1000l.setClickable(false);
                    aspectRatioFrameLayout.addView(this.f1000l, 0);
                } catch (Exception e9) {
                    throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e9);
                }
            } else if (i11 != 4) {
                SurfaceView surfaceView = new SurfaceView(context);
                if (w.f3713a >= 34) {
                    x.a(surfaceView);
                }
                this.f1000l = surfaceView;
            } else {
                try {
                    int i20 = r.f1257j;
                    this.f1000l = (View) r.class.getConstructor(Context.class).newInstance(context);
                } catch (Exception e10) {
                    throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e10);
                }
            }
            z14 = false;
            this.f1000l.setLayoutParams(layoutParams);
            this.f1000l.setOnClickListener(yVar);
            this.f1000l.setClickable(false);
            aspectRatioFrameLayout.addView(this.f1000l, 0);
        }
        this.f1001m = z14;
        this.f1007s = (FrameLayout) findViewById(2131362039);
        this.f1008t = (FrameLayout) findViewById(2131362065);
        ImageView imageView2 = (ImageView) findViewById(2131362040);
        this.f1002n = imageView2;
        this.f1012x = (!z13 || i14 == 0 || imageView2 == null) ? 0 : i14;
        if (i12 != 0) {
            this.f1013y = c.b(getContext(), i12);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(2131362083);
        this.f1003o = subtitleView;
        if (subtitleView != null) {
            subtitleView.a();
            subtitleView.b();
        }
        View findViewById2 = findViewById(2131362044);
        this.f1004p = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        this.f1014z = i9;
        TextView textView = (TextView) findViewById(2131362052);
        this.f1005q = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        q qVar = (q) findViewById(2131362048);
        View findViewById3 = findViewById(2131362049);
        if (qVar != null) {
            this.f1006r = qVar;
        } else if (findViewById3 != null) {
            q qVar2 = new q(context, attributeSet);
            this.f1006r = qVar2;
            qVar2.setId(2131362048);
            qVar2.setLayoutParams(findViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById3.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById3);
            viewGroup.removeView(findViewById3);
            viewGroup.addView(qVar2, indexOfChild);
        } else {
            this.f1006r = null;
        }
        q qVar3 = this.f1006r;
        this.C = qVar3 != null ? i16 : 0;
        this.F = z8;
        this.D = z10;
        this.E = z9;
        this.f1010v = z12 && qVar3 != null;
        if (qVar3 != null) {
            v vVar = qVar3.f6192i;
            int i21 = vVar.f6260z;
            if (i21 != 3 && i21 != 2) {
                vVar.f();
                vVar.i(2);
            }
            this.f1006r.f6197l.add(yVar);
        }
        if (z12) {
            setClickable(true);
        }
        j();
    }

    public static void a(TextureView textureView, int i9) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != 0.0f && height != 0.0f && i9 != 0) {
            float f9 = width / 2.0f;
            float f10 = height / 2.0f;
            matrix.postRotate(i9, f9, f10);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f9, f10);
        }
        textureView.setTransform(matrix);
    }

    public final boolean b() {
        t0 t0Var = this.f1009u;
        return t0Var != null && t0Var.J(16) && this.f1009u.h() && this.f1009u.p();
    }

    public final void c(boolean z8) {
        if (!(b() && this.E) && m()) {
            q qVar = this.f1006r;
            boolean z9 = qVar.h() && qVar.getShowTimeoutMs() <= 0;
            boolean e9 = e();
            if (z8 || z9 || e9) {
                f(e9);
            }
        }
    }

    public final boolean d(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float f9 = intrinsicWidth / intrinsicHeight;
                ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
                if (this.f1012x == 2) {
                    f9 = getWidth() / getHeight();
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                }
                AspectRatioFrameLayout aspectRatioFrameLayout = this.f998j;
                if (aspectRatioFrameLayout != null) {
                    aspectRatioFrameLayout.setAspectRatio(f9);
                }
                ImageView imageView = this.f1002n;
                imageView.setScaleType(scaleType);
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        t0 t0Var = this.f1009u;
        if (t0Var != null && t0Var.J(16) && this.f1009u.h()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        boolean z8 = keyCode == 19 || keyCode == 270 || keyCode == 22 || keyCode == 271 || keyCode == 20 || keyCode == 269 || keyCode == 21 || keyCode == 268 || keyCode == 23;
        q qVar = this.f1006r;
        if (z8 && m() && !qVar.h()) {
            c(true);
            return true;
        }
        if ((m() && qVar.d(keyEvent)) || super.dispatchKeyEvent(keyEvent)) {
            c(true);
            return true;
        }
        if (z8 && m()) {
            c(true);
        }
        return false;
    }

    public final boolean e() {
        t0 t0Var = this.f1009u;
        if (t0Var != null) {
            int t8 = t0Var.t();
            if (!this.D) {
                return false;
            }
            if (this.f1009u.J(17) && this.f1009u.U().p()) {
                return false;
            }
            if (t8 != 1 && t8 != 4) {
                t0 t0Var2 = this.f1009u;
                t0Var2.getClass();
                if (t0Var2.p()) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void f(boolean z8) {
        if (m()) {
            int i9 = z8 ? 0 : this.C;
            q qVar = this.f1006r;
            qVar.setShowTimeoutMs(i9);
            v vVar = qVar.f6192i;
            q qVar2 = vVar.f6236a;
            if (!qVar2.i()) {
                qVar2.setVisibility(0);
                qVar2.j();
                View view = qVar2.f6219w;
                if (view != null) {
                    view.requestFocus();
                }
            }
            vVar.k();
        }
    }

    public final void g() {
        if (!m() || this.f1009u == null) {
            return;
        }
        q qVar = this.f1006r;
        if (!qVar.h()) {
            c(true);
        } else if (this.F) {
            qVar.g();
        }
    }

    public List<a> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f1008t;
        if (frameLayout != null) {
            arrayList.add(new a(frameLayout));
        }
        q qVar = this.f1006r;
        if (qVar != null) {
            arrayList.add(new a(qVar));
        }
        return g0.m(arrayList);
    }

    public ViewGroup getAdViewGroup() {
        FrameLayout frameLayout = this.f1007s;
        g1.a.m(frameLayout, "exo_ad_overlay must be present for ad playback");
        return frameLayout;
    }

    public int getArtworkDisplayMode() {
        return this.f1012x;
    }

    public boolean getControllerAutoShow() {
        return this.D;
    }

    public boolean getControllerHideOnTouch() {
        return this.F;
    }

    public int getControllerShowTimeoutMs() {
        return this.C;
    }

    public Drawable getDefaultArtwork() {
        return this.f1013y;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.f1008t;
    }

    public t0 getPlayer() {
        return this.f1009u;
    }

    public int getResizeMode() {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f998j;
        g1.a.l(aspectRatioFrameLayout);
        return aspectRatioFrameLayout.getResizeMode();
    }

    public SubtitleView getSubtitleView() {
        return this.f1003o;
    }

    @Deprecated
    public boolean getUseArtwork() {
        return this.f1012x != 0;
    }

    public boolean getUseController() {
        return this.f1010v;
    }

    public View getVideoSurfaceView() {
        return this.f1000l;
    }

    public final void h() {
        t0 t0Var = this.f1009u;
        h1 D = t0Var != null ? t0Var.D() : h1.f2473e;
        int i9 = D.f2474a;
        int i10 = D.f2475b;
        int i11 = D.f2476c;
        float f9 = (i10 == 0 || i9 == 0) ? 0.0f : (i9 * D.f2477d) / i10;
        View view = this.f1000l;
        if (view instanceof TextureView) {
            if (f9 > 0.0f && (i11 == 90 || i11 == 270)) {
                f9 = 1.0f / f9;
            }
            int i12 = this.G;
            y yVar = this.f997i;
            if (i12 != 0) {
                view.removeOnLayoutChangeListener(yVar);
            }
            this.G = i11;
            if (i11 != 0) {
                view.addOnLayoutChangeListener(yVar);
            }
            a((TextureView) view, this.G);
        }
        float f10 = this.f1001m ? 0.0f : f9;
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f998j;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f10);
        }
    }

    public final void i() {
        int i9;
        View view = this.f1004p;
        if (view != null) {
            t0 t0Var = this.f1009u;
            view.setVisibility((t0Var != null && t0Var.t() == 2 && ((i9 = this.f1014z) == 2 || (i9 == 1 && this.f1009u.p()))) ? 0 : 8);
        }
    }

    public final void j() {
        q qVar = this.f1006r;
        if (qVar == null || !this.f1010v) {
            setContentDescription(null);
        } else if (qVar.h()) {
            setContentDescription(this.F ? getResources().getString(2131951673) : null);
        } else {
            setContentDescription(getResources().getString(2131951687));
        }
    }

    public final void k() {
        TextView textView = this.f1005q;
        if (textView != null) {
            CharSequence charSequence = this.B;
            if (charSequence != null) {
                textView.setText(charSequence);
                textView.setVisibility(0);
            } else {
                t0 t0Var = this.f1009u;
                if (t0Var != null) {
                    t0Var.g();
                }
                textView.setVisibility(8);
            }
        }
    }

    public final void l(boolean z8) {
        byte[] bArr;
        t0 t0Var = this.f1009u;
        View view = this.f999k;
        ImageView imageView = this.f1002n;
        boolean z9 = false;
        if (t0Var == null || !t0Var.J(30) || t0Var.v().f2422a.isEmpty()) {
            if (this.A) {
                return;
            }
            if (imageView != null) {
                imageView.setImageResource(R.color.transparent);
                imageView.setVisibility(4);
            }
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        if (z8 && !this.A && view != null) {
            view.setVisibility(0);
        }
        if (t0Var.v().a(2)) {
            if (imageView != null) {
                imageView.setImageResource(R.color.transparent);
                imageView.setVisibility(4);
                return;
            }
            return;
        }
        if (view != null) {
            view.setVisibility(0);
        }
        if (this.f1012x != 0) {
            g1.a.l(imageView);
            if (t0Var.J(18) && (bArr = t0Var.i0().f2455f) != null) {
                z9 = d(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
            }
            if (z9 || d(this.f1013y)) {
                return;
            }
        }
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
            imageView.setVisibility(4);
        }
    }

    public final boolean m() {
        if (!this.f1010v) {
            return false;
        }
        g1.a.l(this.f1006r);
        return true;
    }

    @Override // android.view.View
    public final boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!m() || this.f1009u == null) {
            return false;
        }
        c(true);
        return true;
    }

    @Override // android.view.View
    public final boolean performClick() {
        g();
        return super.performClick();
    }

    public void setArtworkDisplayMode(int i9) {
        g1.a.k(i9 == 0 || this.f1002n != null);
        if (this.f1012x != i9) {
            this.f1012x = i9;
            l(false);
        }
    }

    public void setAspectRatioListener(l3.a aVar) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f998j;
        g1.a.l(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setAspectRatioListener(aVar);
    }

    public void setControllerAnimationEnabled(boolean z8) {
        q qVar = this.f1006r;
        g1.a.l(qVar);
        qVar.setAnimationEnabled(z8);
    }

    public void setControllerAutoShow(boolean z8) {
        this.D = z8;
    }

    public void setControllerHideDuringAds(boolean z8) {
        this.E = z8;
    }

    public void setControllerHideOnTouch(boolean z8) {
        g1.a.l(this.f1006r);
        this.F = z8;
        j();
    }

    @Deprecated
    public void setControllerOnFullScreenModeChangedListener(h hVar) {
        q qVar = this.f1006r;
        g1.a.l(qVar);
        qVar.setOnFullScreenModeChangedListener(hVar);
    }

    public void setControllerShowTimeoutMs(int i9) {
        q qVar = this.f1006r;
        g1.a.l(qVar);
        this.C = i9;
        if (qVar.h()) {
            f(e());
        }
    }

    @Deprecated
    public void setControllerVisibilityListener(p pVar) {
        q qVar = this.f1006r;
        g1.a.l(qVar);
        CopyOnWriteArrayList copyOnWriteArrayList = qVar.f6197l;
        p pVar2 = this.f1011w;
        if (pVar2 == pVar) {
            return;
        }
        if (pVar2 != null) {
            copyOnWriteArrayList.remove(pVar2);
        }
        this.f1011w = pVar;
        if (pVar != null) {
            copyOnWriteArrayList.add(pVar);
            setControllerVisibilityListener((z) null);
        }
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
        g1.a.k(this.f1005q != null);
        this.B = charSequence;
        k();
    }

    public void setDefaultArtwork(Drawable drawable) {
        if (this.f1013y != drawable) {
            this.f1013y = drawable;
            l(false);
        }
    }

    public void setErrorMessageProvider(o oVar) {
        if (oVar != null) {
            k();
        }
    }

    public void setFullscreenButtonClickListener(a0 a0Var) {
        q qVar = this.f1006r;
        g1.a.l(qVar);
        qVar.setOnFullScreenModeChangedListener(this.f997i);
    }

    public void setKeepContentOnPlayerReset(boolean z8) {
        if (this.A != z8) {
            this.A = z8;
            l(false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00be, code lost:
    
        if (r3 != false) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setPlayer(d1.t0 r9) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.PlayerView.setPlayer(d1.t0):void");
    }

    public void setRepeatToggleModes(int i9) {
        q qVar = this.f1006r;
        g1.a.l(qVar);
        qVar.setRepeatToggleModes(i9);
    }

    public void setResizeMode(int i9) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f998j;
        g1.a.l(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setResizeMode(i9);
    }

    public void setShowBuffering(int i9) {
        if (this.f1014z != i9) {
            this.f1014z = i9;
            i();
        }
    }

    public void setShowFastForwardButton(boolean z8) {
        q qVar = this.f1006r;
        g1.a.l(qVar);
        qVar.setShowFastForwardButton(z8);
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z8) {
        q qVar = this.f1006r;
        g1.a.l(qVar);
        qVar.setShowMultiWindowTimeBar(z8);
    }

    public void setShowNextButton(boolean z8) {
        q qVar = this.f1006r;
        g1.a.l(qVar);
        qVar.setShowNextButton(z8);
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z8) {
        q qVar = this.f1006r;
        g1.a.l(qVar);
        qVar.setShowPlayButtonIfPlaybackIsSuppressed(z8);
    }

    public void setShowPreviousButton(boolean z8) {
        q qVar = this.f1006r;
        g1.a.l(qVar);
        qVar.setShowPreviousButton(z8);
    }

    public void setShowRewindButton(boolean z8) {
        q qVar = this.f1006r;
        g1.a.l(qVar);
        qVar.setShowRewindButton(z8);
    }

    public void setShowShuffleButton(boolean z8) {
        q qVar = this.f1006r;
        g1.a.l(qVar);
        qVar.setShowShuffleButton(z8);
    }

    public void setShowSubtitleButton(boolean z8) {
        q qVar = this.f1006r;
        g1.a.l(qVar);
        qVar.setShowSubtitleButton(z8);
    }

    public void setShowVrButton(boolean z8) {
        q qVar = this.f1006r;
        g1.a.l(qVar);
        qVar.setShowVrButton(z8);
    }

    public void setShutterBackgroundColor(int i9) {
        View view = this.f999k;
        if (view != null) {
            view.setBackgroundColor(i9);
        }
    }

    @Deprecated
    public void setUseArtwork(boolean z8) {
        setArtworkDisplayMode(!z8 ? 1 : 0);
    }

    public void setUseController(boolean z8) {
        boolean z9 = true;
        q qVar = this.f1006r;
        g1.a.k((z8 && qVar == null) ? false : true);
        if (!z8 && !hasOnClickListeners()) {
            z9 = false;
        }
        setClickable(z9);
        if (this.f1010v == z8) {
            return;
        }
        this.f1010v = z8;
        if (m()) {
            qVar.setPlayer(this.f1009u);
        } else if (qVar != null) {
            qVar.g();
            qVar.setPlayer(null);
        }
        j();
    }

    @Override // android.view.View
    public void setVisibility(int i9) {
        super.setVisibility(i9);
        View view = this.f1000l;
        if (view instanceof SurfaceView) {
            view.setVisibility(i9);
        }
    }

    public void setControllerVisibilityListener(z zVar) {
        if (zVar != null) {
            setControllerVisibilityListener((p) null);
        }
    }
}
