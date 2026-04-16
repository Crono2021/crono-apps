package x5;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.textfield.TextInputLayout;
import i7.f2;
import java.util.WeakHashMap;
import n0.c0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i extends m {

    /* renamed from: e, reason: collision with root package name */
    public final int f10120e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10121f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f10122g;
    public AutoCompleteTextView h;

    /* renamed from: i, reason: collision with root package name */
    public final com.google.android.material.datepicker.n f10123i;

    /* renamed from: j, reason: collision with root package name */
    public final f2 f10124j;

    /* renamed from: k, reason: collision with root package name */
    public final a3.i f10125k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f10126l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f10127m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f10128n;

    /* renamed from: o, reason: collision with root package name */
    public long f10129o;

    /* renamed from: p, reason: collision with root package name */
    public AccessibilityManager f10130p;

    /* renamed from: q, reason: collision with root package name */
    public ValueAnimator f10131q;

    /* renamed from: r, reason: collision with root package name */
    public ValueAnimator f10132r;

    public i(l lVar) {
        super(lVar);
        this.f10123i = new com.google.android.material.datepicker.n(this, 10);
        this.f10124j = new f2(this, 4);
        this.f10125k = new a3.i(this, 24);
        this.f10129o = Long.MAX_VALUE;
        this.f10121f = android.support.v4.media.session.b.n0(lVar.getContext(), 2130969356, 67);
        this.f10120e = android.support.v4.media.session.b.n0(lVar.getContext(), 2130969356, 50);
        this.f10122g = android.support.v4.media.session.b.o0(lVar.getContext(), 2130969365, z4.a.f10659a);
    }

    @Override // x5.m
    public final void a() {
        if (this.f10130p.isTouchExplorationEnabled() && this.h.getInputType() != 0 && !this.f10156d.hasFocus()) {
            this.h.dismissDropDown();
        }
        this.h.post(new a7.a(this, 24));
    }

    @Override // x5.m
    public final int c() {
        return 2131951721;
    }

    @Override // x5.m
    public final int d() {
        return 2131231012;
    }

    @Override // x5.m
    public final View.OnFocusChangeListener e() {
        return this.f10124j;
    }

    @Override // x5.m
    public final View.OnClickListener f() {
        return this.f10123i;
    }

    @Override // x5.m
    public final o0.d h() {
        return this.f10125k;
    }

    @Override // x5.m
    public final boolean i(int i9) {
        return i9 != 0;
    }

    @Override // x5.m
    public final boolean k() {
        return this.f10128n;
    }

    @Override // x5.m
    public final void l(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            m7.c.i("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
            return;
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.h = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: x5.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    i iVar = i.this;
                    long j5 = currentTimeMillis - iVar.f10129o;
                    if (j5 < 0 || j5 > 300) {
                        iVar.f10127m = false;
                    }
                    iVar.t();
                    iVar.f10127m = true;
                    iVar.f10129o = System.currentTimeMillis();
                }
                return false;
            }
        });
        this.h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: x5.h
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                i iVar = i.this;
                iVar.f10127m = true;
                iVar.f10129o = System.currentTimeMillis();
                iVar.s(false);
            }
        });
        this.h.setThreshold(0);
        TextInputLayout textInputLayout = this.f10153a;
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (editText.getInputType() == 0 && this.f10130p.isTouchExplorationEnabled()) {
            WeakHashMap weakHashMap = t0.f7209a;
            c0.s(this.f10156d, 2);
        }
        textInputLayout.setEndIconVisible(true);
    }

    @Override // x5.m
    public final void m(o0.l lVar) {
        if (this.h.getInputType() == 0) {
            lVar.i(Spinner.class.getName());
        }
        if (Build.VERSION.SDK_INT >= 26 ? lVar.f7564a.isShowingHintText() : lVar.e(4)) {
            lVar.j(null);
        }
    }

    @Override // x5.m
    public final void n(AccessibilityEvent accessibilityEvent) {
        if (this.f10130p.isEnabled() && this.h.getInputType() == 0) {
            boolean z8 = accessibilityEvent.getEventType() == 32768 && this.f10128n && !this.h.isPopupShowing();
            if (accessibilityEvent.getEventType() == 1 || z8) {
                t();
                this.f10127m = true;
                this.f10129o = System.currentTimeMillis();
            }
        }
    }

    @Override // x5.m
    public final void q() {
        int i9 = 2;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f10122g;
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.setDuration(this.f10121f);
        ofFloat.addUpdateListener(new f5.b(this, i9));
        this.f10132r = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration(this.f10120e);
        ofFloat2.addUpdateListener(new f5.b(this, i9));
        this.f10131q = ofFloat2;
        ofFloat2.addListener(new b5.a(this, 4));
        this.f10130p = (AccessibilityManager) this.f10155c.getSystemService("accessibility");
    }

    @Override // x5.m
    public final void r() {
        AutoCompleteTextView autoCompleteTextView = this.h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.h.setOnDismissListener(null);
        }
    }

    public final void s(boolean z8) {
        if (this.f10128n != z8) {
            this.f10128n = z8;
            this.f10132r.cancel();
            this.f10131q.start();
        }
    }

    public final void t() {
        if (this.h == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f10129o;
        if (currentTimeMillis < 0 || currentTimeMillis > 300) {
            this.f10127m = false;
        }
        if (this.f10127m) {
            this.f10127m = false;
            return;
        }
        s(!this.f10128n);
        boolean z8 = this.f10128n;
        AutoCompleteTextView autoCompleteTextView = this.h;
        if (!z8) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            this.h.showDropDown();
        }
    }
}
