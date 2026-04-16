package g;

import android.os.Build;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class y implements Window.Callback {

    /* renamed from: i, reason: collision with root package name */
    public final Window.Callback f3634i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3635j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3636k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3637l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ c0 f3638m;

    public y(c0 c0Var, Window.Callback callback) {
        this.f3638m = c0Var;
        if (callback != null) {
            this.f3634i = callback;
        } else {
            m7.c.n("Window callback may not be null");
            throw null;
        }
    }

    public final void a(Window.Callback callback) {
        try {
            this.f3635j = true;
            callback.onContentChanged();
        } finally {
            this.f3635j = false;
        }
    }

    public final boolean b(int i9, Menu menu) {
        return this.f3634i.onMenuOpened(i9, menu);
    }

    public final void c(int i9, Menu menu) {
        this.f3634i.onPanelClosed(i9, menu);
    }

    public final void d(List list, Menu menu, int i9) {
        l.m.a(this.f3634i, list, menu, i9);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f3634i.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z8 = this.f3636k;
        Window.Callback callback = this.f3634i;
        return z8 ? callback.dispatchKeyEvent(keyEvent) : this.f3638m.u(keyEvent) || callback.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
    
        if (r7 != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0039, code lost:
    
        if (r0 != false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x006e A[RETURN] */
    @Override // android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyShortcutEvent(android.view.KeyEvent r7) {
        /*
            r6 = this;
            android.view.Window$Callback r0 = r6.f3634i
            boolean r0 = r0.dispatchKeyShortcutEvent(r7)
            r1 = 1
            if (r0 != 0) goto L6f
            int r0 = r7.getKeyCode()
            g.c0 r2 = r6.f3638m
            r2.B()
            g.p0 r3 = r2.f3492w
            r4 = 0
            if (r3 == 0) goto L3d
            g.o0 r3 = r3.f3603i
            if (r3 != 0) goto L1d
        L1b:
            r0 = 0
            goto L39
        L1d:
            m.m r3 = r3.f3590l
            if (r3 == 0) goto L1b
            int r5 = r7.getDeviceId()
            android.view.KeyCharacterMap r5 = android.view.KeyCharacterMap.load(r5)
            int r5 = r5.getKeyboardType()
            if (r5 == r1) goto L31
            r5 = 1
            goto L32
        L31:
            r5 = 0
        L32:
            r3.setQwertyMode(r5)
            boolean r0 = r3.performShortcut(r0, r7, r4)
        L39:
            if (r0 == 0) goto L3d
        L3b:
            r7 = 1
            goto L6b
        L3d:
            g.b0 r0 = r2.U
            if (r0 == 0) goto L52
            int r3 = r7.getKeyCode()
            boolean r0 = r2.G(r0, r3, r7)
            if (r0 == 0) goto L52
            g.b0 r7 = r2.U
            if (r7 == 0) goto L3b
            r7.f3462l = r1
            goto L3b
        L52:
            g.b0 r0 = r2.U
            if (r0 != 0) goto L6a
            g.b0 r0 = r2.A(r4)
            r2.H(r0, r7)
            int r3 = r7.getKeyCode()
            boolean r7 = r2.G(r0, r3, r7)
            r0.f3461k = r4
            if (r7 == 0) goto L6a
            goto L3b
        L6a:
            r7 = 0
        L6b:
            if (r7 == 0) goto L6e
            goto L6f
        L6e:
            return r4
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g.y.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f3634i.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f3634i.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f3634i.dispatchTrackballEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final l.f e(android.view.ActionMode.Callback r11) {
        /*
            Method dump skipped, instructions count: 506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g.y.e(android.view.ActionMode$Callback):l.f");
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f3634i.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f3634i.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f3634i.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.f3635j) {
            this.f3634i.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i9, Menu menu) {
        if (i9 != 0 || (menu instanceof m.m)) {
            return this.f3634i.onCreatePanelMenu(i9, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i9) {
        return this.f3634i.onCreatePanelView(i9);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f3634i.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i9, MenuItem menuItem) {
        return this.f3634i.onMenuItemSelected(i9, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i9, Menu menu) {
        b(i9, menu);
        if (i9 == 108) {
            c0 c0Var = this.f3638m;
            c0Var.B();
            p0 p0Var = c0Var.f3492w;
            if (p0Var != null) {
                ArrayList arrayList = p0Var.f3607m;
                if (true != p0Var.f3606l) {
                    p0Var.f3606l = true;
                    if (arrayList.size() > 0) {
                        arrayList.get(0).getClass();
                        androidx.fragment.app.a.c();
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i9, Menu menu) {
        if (this.f3637l) {
            this.f3634i.onPanelClosed(i9, menu);
            return;
        }
        c(i9, menu);
        c0 c0Var = this.f3638m;
        if (i9 != 108) {
            if (i9 == 0) {
                b0 A = c0Var.A(i9);
                if (A.f3463m) {
                    c0Var.s(A, false);
                    return;
                }
                return;
            }
            return;
        }
        c0Var.B();
        p0 p0Var = c0Var.f3492w;
        if (p0Var != null) {
            ArrayList arrayList = p0Var.f3607m;
            if (p0Var.f3606l) {
                p0Var.f3606l = false;
                if (arrayList.size() <= 0) {
                    return;
                }
                arrayList.get(0).getClass();
                androidx.fragment.app.a.c();
            }
        }
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z8) {
        l.n.a(this.f3634i, z8);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i9, View view, Menu menu) {
        m.m mVar = menu instanceof m.m ? (m.m) menu : null;
        if (i9 == 0 && mVar == null) {
            return false;
        }
        if (mVar != null) {
            mVar.F = true;
        }
        boolean onPreparePanel = this.f3634i.onPreparePanel(i9, view, menu);
        if (mVar != null) {
            mVar.F = false;
        }
        return onPreparePanel;
    }

    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i9) {
        m.m mVar = this.f3638m.A(0).h;
        if (mVar != null) {
            d(list, mVar, i9);
        } else {
            d(list, menu, i9);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return l.l.a(this.f3634i, searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f3634i.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z8) {
        this.f3634i.onWindowFocusChanged(z8);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i9) {
        return i9 != 0 ? l.l.b(this.f3634i, callback, i9) : e(callback);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f3634i.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        if (Build.VERSION.SDK_INT >= 23) {
            return null;
        }
        return e(callback);
    }
}
