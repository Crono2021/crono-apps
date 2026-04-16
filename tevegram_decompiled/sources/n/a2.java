package n;

import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a2 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: i, reason: collision with root package name */
    public final float f6776i;

    /* renamed from: j, reason: collision with root package name */
    public final int f6777j;

    /* renamed from: k, reason: collision with root package name */
    public final int f6778k;

    /* renamed from: l, reason: collision with root package name */
    public final View f6779l;

    /* renamed from: m, reason: collision with root package name */
    public z1 f6780m;

    /* renamed from: n, reason: collision with root package name */
    public z1 f6781n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f6782o;

    /* renamed from: p, reason: collision with root package name */
    public int f6783p;

    /* renamed from: q, reason: collision with root package name */
    public final int[] f6784q = new int[2];

    public a2(View view) {
        this.f6779l = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f6776i = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f6777j = tapTimeout;
        this.f6778k = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        z1 z1Var = this.f6781n;
        View view = this.f6779l;
        if (z1Var != null) {
            view.removeCallbacks(z1Var);
        }
        z1 z1Var2 = this.f6780m;
        if (z1Var2 != null) {
            view.removeCallbacks(z1Var2);
        }
    }

    public abstract m.d0 b();

    public abstract boolean c();

    public boolean d() {
        m.d0 b9 = b();
        if (b9 == null || !b9.b()) {
            return true;
        }
        b9.dismiss();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        if (r14 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007b, code lost:
    
        if (r4 != 3) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0100  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.a2.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f6782o = false;
        this.f6783p = -1;
        z1 z1Var = this.f6780m;
        if (z1Var != null) {
            this.f6779l.removeCallbacks(z1Var);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
