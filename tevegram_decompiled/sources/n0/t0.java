package n0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class t0 {

    /* renamed from: a, reason: collision with root package name */
    public static WeakHashMap f7209a;

    /* renamed from: b, reason: collision with root package name */
    public static Field f7210b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f7211c;

    /* renamed from: d, reason: collision with root package name */
    public static ThreadLocal f7212d;

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f7213e;

    /* renamed from: f, reason: collision with root package name */
    public static final x f7214f;

    /* renamed from: g, reason: collision with root package name */
    public static final z f7215g;

    static {
        new AtomicInteger(1);
        f7209a = null;
        f7211c = false;
        f7213e = new int[]{2131361808, 2131361809, 2131361820, 2131361831, 2131361834, 2131361835, 2131361836, 2131361837, 2131361838, 2131361839, 2131361810, 2131361811, 2131361812, 2131361813, 2131361814, 2131361815, 2131361816, 2131361817, 2131361818, 2131361819, 2131361821, 2131361822, 2131361823, 2131361824, 2131361825, 2131361826, 2131361827, 2131361828, 2131361829, 2131361830, 2131361832, 2131361833};
        f7214f = new x();
        f7215g = new z();
    }

    public static c1 a(View view) {
        if (f7209a == null) {
            f7209a = new WeakHashMap();
        }
        c1 c1Var = (c1) f7209a.get(view);
        if (c1Var != null) {
            return c1Var;
        }
        c1 c1Var2 = new c1(view);
        f7209a.put(view, c1Var2);
        return c1Var2;
    }

    public static boolean b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = s0.f7196d;
        s0 s0Var = (s0) view.getTag(2131362429);
        if (s0Var == null) {
            s0Var = new s0();
            s0Var.f7197a = null;
            s0Var.f7198b = null;
            s0Var.f7199c = null;
            view.setTag(2131362429, s0Var);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = s0Var.f7197a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = s0.f7196d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (s0Var.f7197a == null) {
                            s0Var.f7197a = new WeakHashMap();
                        }
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            ArrayList arrayList3 = s0.f7196d;
                            View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                s0Var.f7197a.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    s0Var.f7197a.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        }
        View a9 = s0Var.a(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (a9 != null && !KeyEvent.isModifierKey(keyCode)) {
                if (s0Var.f7198b == null) {
                    s0Var.f7198b = new SparseArray();
                }
                s0Var.f7198b.put(keyCode, new WeakReference(a9));
            }
        }
        return a9 != null;
    }

    public static View.AccessibilityDelegate c(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return n0.a(view);
        }
        if (f7211c) {
            return null;
        }
        if (f7210b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f7210b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f7211c = true;
                return null;
            }
        }
        try {
            Object obj = f7210b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f7211c = true;
            return null;
        }
    }

    public static CharSequence d(View view) {
        Object tag;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = m0.b(view);
        } else {
            tag = view.getTag(2131362422);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        return (CharSequence) tag;
    }

    public static ArrayList e(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(2131362419);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(2131362419, arrayList2);
        return arrayList2;
    }

    public static Rect f() {
        if (f7212d == null) {
            f7212d = new ThreadLocal();
        }
        Rect rect = (Rect) f7212d.get();
        if (rect == null) {
            rect = new Rect();
            f7212d.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static String[] g(n.v vVar) {
        return Build.VERSION.SDK_INT >= 31 ? p0.a(vVar) : (String[]) vVar.getTag(2131362425);
    }

    public static a2 h(View view) {
        return Build.VERSION.SDK_INT >= 23 ? j0.a(view) : i0.j(view);
    }

    public static void i(View view, int i9) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z8 = d(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (f0.a(view) != 0 || z8) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z8 ? 32 : IjkMediaMeta.FF_PROFILE_H264_INTRA);
                f0.g(obtain, i9);
                if (z8) {
                    obtain.getText().add(d(view));
                    if (c0.c(view) == 0) {
                        c0.s(view, 1);
                    }
                }
                view.sendAccessibilityEventUnchecked(obtain);
                return;
            }
            if (i9 != 32) {
                if (view.getParent() != null) {
                    try {
                        f0.e(view.getParent(), view, view, i9);
                        return;
                    } catch (AbstractMethodError e9) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e9);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(obtain2);
            obtain2.setEventType(32);
            f0.g(obtain2, i9);
            obtain2.setSource(view);
            view.onPopulateAccessibilityEvent(obtain2);
            obtain2.getText().add(d(view));
            accessibilityManager.sendAccessibilityEvent(obtain2);
        }
    }

    public static void j(View view, int i9) {
        boolean z8;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i9);
            return;
        }
        Rect f9 = f();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            f9.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z8 = !f9.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z8 = false;
        }
        view.offsetLeftAndRight(i9);
        if (view.getVisibility() == 0) {
            s(view);
            Object parent2 = view.getParent();
            if (parent2 instanceof View) {
                s((View) parent2);
            }
        }
        if (z8 && f9.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(f9);
        }
    }

    public static void k(View view, int i9) {
        boolean z8;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i9);
            return;
        }
        Rect f9 = f();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            f9.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z8 = !f9.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z8 = false;
        }
        view.offsetTopAndBottom(i9);
        if (view.getVisibility() == 0) {
            s(view);
            Object parent2 = view.getParent();
            if (parent2 instanceof View) {
                s((View) parent2);
            }
        }
        if (z8 && f9.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(f9);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static g l(View view, g gVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + gVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return p0.b(view, gVar);
        }
        s sVar = (s) view.getTag(2131362424);
        t tVar = f7214f;
        if (sVar == null) {
            if (view instanceof t) {
                tVar = (t) view;
            }
            return tVar.a(gVar);
        }
        g a9 = ((r0.t) sVar).a(view, gVar);
        if (a9 == null) {
            return null;
        }
        if (view instanceof t) {
            tVar = (t) view;
        }
        return tVar.a(a9);
    }

    public static void m(View view, int i9) {
        ArrayList e9 = e(view);
        for (int i10 = 0; i10 < e9.size(); i10++) {
            if (((o0.f) e9.get(i10)).a() == i9) {
                e9.remove(i10);
                return;
            }
        }
    }

    public static void n(View view, o0.f fVar, o0.x xVar) {
        o0.f fVar2 = new o0.f(null, fVar.f7559b, null, xVar, fVar.f7560c);
        View.AccessibilityDelegate c9 = c(view);
        c cVar = c9 == null ? null : c9 instanceof a ? ((a) c9).f7130a : new c(c9);
        if (cVar == null) {
            cVar = new c();
        }
        p(view, cVar);
        m(view, fVar2.a());
        e(view).add(fVar2);
        i(view, 0);
    }

    public static void o(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i9) {
        if (Build.VERSION.SDK_INT >= 29) {
            n0.d(view, context, iArr, attributeSet, typedArray, i9, 0);
        }
    }

    public static void p(View view, c cVar) {
        if (cVar == null && (c(view) instanceof a)) {
            cVar = new c();
        }
        if (c0.c(view) == 0) {
            c0.s(view, 1);
        }
        view.setAccessibilityDelegate(cVar == null ? null : cVar.f7145b);
    }

    public static void q(View view, CharSequence charSequence) {
        new y(2131362422, CharSequence.class, 8, 28, 1).d(view, charSequence);
        z zVar = f7215g;
        if (charSequence == null) {
            zVar.f7240i.remove(view);
            view.removeOnAttachStateChangeListener(zVar);
            c0.o(view.getViewTreeObserver(), zVar);
        } else {
            zVar.f7240i.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(zVar);
            if (f0.b(view)) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(zVar);
            }
        }
    }

    public static void r(View view, ColorStateList colorStateList) {
        i0.q(view, colorStateList);
        if (Build.VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            boolean z8 = (i0.g(view) == null && i0.h(view) == null) ? false : true;
            if (background == null || !z8) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            c0.q(view, background);
        }
    }

    public static void s(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}
