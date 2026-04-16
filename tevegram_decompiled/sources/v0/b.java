package v0;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import i5.e;
import i7.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
import n0.c0;
import n0.d0;
import n0.t0;
import o0.l;
import o0.p;
import s.i;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class b extends n0.c {

    /* renamed from: n, reason: collision with root package name */
    public static final Rect f9196n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: o, reason: collision with root package name */
    public static final o4.d f9197o = new o4.d(13);

    /* renamed from: p, reason: collision with root package name */
    public static final o4.d f9198p = new o4.d(14);
    public final AccessibilityManager h;

    /* renamed from: i, reason: collision with root package name */
    public final Chip f9203i;

    /* renamed from: j, reason: collision with root package name */
    public a f9204j;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f9199d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    public final Rect f9200e = new Rect();

    /* renamed from: f, reason: collision with root package name */
    public final Rect f9201f = new Rect();

    /* renamed from: g, reason: collision with root package name */
    public final int[] f9202g = new int[2];

    /* renamed from: k, reason: collision with root package name */
    public int f9205k = Integer.MIN_VALUE;

    /* renamed from: l, reason: collision with root package name */
    public int f9206l = Integer.MIN_VALUE;

    /* renamed from: m, reason: collision with root package name */
    public int f9207m = Integer.MIN_VALUE;

    public b(Chip chip) {
        this.f9203i = chip;
        this.h = (AccessibilityManager) chip.getContext().getSystemService("accessibility");
        chip.setFocusable(true);
        WeakHashMap weakHashMap = t0.f7209a;
        if (c0.c(chip) == 0) {
            c0.s(chip, 1);
        }
    }

    @Override // n0.c
    public final x b(View view) {
        if (this.f9204j == null) {
            this.f9204j = new a(this);
        }
        return this.f9204j;
    }

    @Override // n0.c
    public final void d(View view, l lVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = lVar.f7564a;
        this.f7144a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        Chip chip = ((i5.c) this).f4719q;
        e eVar = chip.f1984m;
        accessibilityNodeInfo.setCheckable(eVar != null && eVar.Y);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        lVar.i(chip.getAccessibilityClassName());
        CharSequence text = chip.getText();
        if (Build.VERSION.SDK_INT >= 23) {
            lVar.k(text);
        } else {
            accessibilityNodeInfo.setContentDescription(text);
        }
    }

    public final boolean j(int i9) {
        if (this.f9206l != i9) {
            return false;
        }
        this.f9206l = Integer.MIN_VALUE;
        i5.c cVar = (i5.c) this;
        if (i9 == 1) {
            Chip chip = cVar.f4719q;
            chip.f1993v = false;
            chip.refreshDrawableState();
        }
        q(i9, 8);
        return true;
    }

    public final l k(int i9) {
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
        l lVar = new l(obtain);
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        lVar.i("android.view.View");
        Rect rect = f9196n;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        Chip chip = this.f9203i;
        obtain.setParent(chip);
        o(i9, lVar);
        if (lVar.g() == null && obtain.getContentDescription() == null) {
            m7.c.i("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
            return null;
        }
        Rect rect2 = this.f9200e;
        lVar.f(rect2);
        if (rect2.equals(rect)) {
            m7.c.i("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
            return null;
        }
        int actions = obtain.getActions();
        if ((actions & 64) != 0) {
            m7.c.i("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            return null;
        }
        if ((actions & 128) != 0) {
            m7.c.i("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            return null;
        }
        obtain.setPackageName(chip.getContext().getPackageName());
        lVar.f7565b = i9;
        obtain.setSource(chip, i9);
        if (this.f9205k == i9) {
            obtain.setAccessibilityFocused(true);
            lVar.a(128);
        } else {
            obtain.setAccessibilityFocused(false);
            lVar.a(64);
        }
        boolean z8 = this.f9206l == i9;
        if (z8) {
            lVar.a(2);
        } else if (obtain.isFocusable()) {
            lVar.a(1);
        }
        obtain.setFocused(z8);
        int[] iArr = this.f9202g;
        chip.getLocationOnScreen(iArr);
        Rect rect3 = this.f9199d;
        obtain.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            lVar.f(rect3);
            rect3.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
        }
        Rect rect4 = this.f9201f;
        if (chip.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
            if (rect3.intersect(rect4)) {
                obtain.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && chip.getWindowVisibility() == 0) {
                    Object parent = chip.getParent();
                    while (true) {
                        if (parent instanceof View) {
                            View view = (View) parent;
                            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                                break;
                            }
                            parent = view.getParent();
                        } else if (parent != null) {
                            obtain.setVisibleToUser(true);
                        }
                    }
                }
            }
        }
        return lVar;
    }

    public abstract void l(ArrayList arrayList);

    public final boolean m(int i9, Rect rect) {
        Object obj;
        l lVar;
        ArrayList arrayList = new ArrayList();
        l(arrayList);
        i iVar = new i();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            iVar.d(((Integer) arrayList.get(i10)).intValue(), k(((Integer) arrayList.get(i10)).intValue()));
        }
        int i11 = this.f9206l;
        int i12 = Integer.MIN_VALUE;
        l lVar2 = i11 == Integer.MIN_VALUE ? null : (l) iVar.c(i11, null);
        o4.d dVar = f9197o;
        o4.d dVar2 = f9198p;
        Chip chip = this.f9203i;
        int i13 = -1;
        if (i9 == 1 || i9 == 2) {
            WeakHashMap weakHashMap = t0.f7209a;
            boolean z8 = d0.d(chip) == 1;
            dVar2.getClass();
            int i14 = iVar.f8657k;
            ArrayList arrayList2 = new ArrayList(i14);
            for (int i15 = 0; i15 < i14; i15++) {
                arrayList2.add((l) iVar.f8656j[i15]);
            }
            Collections.sort(arrayList2, new c(z8, dVar));
            if (i9 == 1) {
                int size = arrayList2.size();
                if (lVar2 != null) {
                    size = arrayList2.indexOf(lVar2);
                }
                int i16 = size - 1;
                obj = i16 >= 0 ? arrayList2.get(i16) : null;
            } else {
                if (i9 != 2) {
                    m7.c.n("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
                    return false;
                }
                int size2 = arrayList2.size();
                int lastIndexOf = (lVar2 == null ? -1 : arrayList2.lastIndexOf(lVar2)) + 1;
                obj = lastIndexOf < size2 ? arrayList2.get(lastIndexOf) : null;
            }
            lVar = (l) obj;
        } else {
            if (i9 != 17 && i9 != 33 && i9 != 66 && i9 != 130) {
                m7.c.n("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                return false;
            }
            Rect rect2 = new Rect();
            int i17 = this.f9206l;
            if (i17 != Integer.MIN_VALUE) {
                n(i17).f(rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                int width = chip.getWidth();
                int height = chip.getHeight();
                if (i9 == 17) {
                    rect2.set(width, 0, width, height);
                } else if (i9 == 33) {
                    rect2.set(0, height, width, height);
                } else if (i9 == 66) {
                    rect2.set(-1, 0, -1, height);
                } else {
                    if (i9 != 130) {
                        m7.c.n("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        return false;
                    }
                    rect2.set(0, -1, width, -1);
                }
            }
            Rect rect3 = new Rect(rect2);
            if (i9 == 17) {
                rect3.offset(rect2.width() + 1, 0);
            } else if (i9 == 33) {
                rect3.offset(0, rect2.height() + 1);
            } else if (i9 == 66) {
                rect3.offset(-(rect2.width() + 1), 0);
            } else {
                if (i9 != 130) {
                    m7.c.n("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    return false;
                }
                rect3.offset(0, -(rect2.height() + 1));
            }
            dVar2.getClass();
            int i18 = iVar.f8657k;
            Rect rect4 = new Rect();
            lVar = null;
            for (int i19 = 0; i19 < i18; i19++) {
                l lVar3 = (l) iVar.f8656j[i19];
                if (lVar3 != lVar2) {
                    dVar.getClass();
                    lVar3.f(rect4);
                    if (a.a.A(i9, rect2, rect4)) {
                        if (a.a.A(i9, rect2, rect3) && !a.a.b(i9, rect2, rect4, rect3)) {
                            if (!a.a.b(i9, rect2, rect3, rect4)) {
                                int B = a.a.B(i9, rect2, rect4);
                                int C = a.a.C(i9, rect2, rect4);
                                int i20 = (C * C) + (B * 13 * B);
                                int B2 = a.a.B(i9, rect2, rect3);
                                int C2 = a.a.C(i9, rect2, rect3);
                                if (i20 >= (C2 * C2) + (B2 * 13 * B2)) {
                                }
                            }
                        }
                        rect3.set(rect4);
                        lVar = lVar3;
                    }
                }
            }
        }
        l lVar4 = lVar;
        if (lVar4 != null) {
            int i21 = 0;
            while (true) {
                if (i21 >= iVar.f8657k) {
                    break;
                }
                if (iVar.f8656j[i21] == lVar4) {
                    i13 = i21;
                    break;
                }
                i21++;
            }
            i12 = iVar.f8655i[i13];
        }
        return p(i12);
    }

    public final l n(int i9) {
        if (i9 != -1) {
            return k(i9);
        }
        Chip chip = this.f9203i;
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(chip);
        l lVar = new l(obtain);
        WeakHashMap weakHashMap = t0.f7209a;
        chip.onInitializeAccessibilityNodeInfo(obtain);
        ArrayList arrayList = new ArrayList();
        l(arrayList);
        if (obtain.getChildCount() > 0 && arrayList.size() > 0) {
            m7.c.i("Views cannot have both real and virtual children");
            return null;
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            lVar.f7564a.addChild(chip, ((Integer) arrayList.get(i10)).intValue());
        }
        return lVar;
    }

    public abstract void o(int i9, l lVar);

    public final boolean p(int i9) {
        int i10;
        Chip chip = this.f9203i;
        if ((!chip.isFocused() && !chip.requestFocus()) || (i10 = this.f9206l) == i9) {
            return false;
        }
        if (i10 != Integer.MIN_VALUE) {
            j(i10);
        }
        if (i9 == Integer.MIN_VALUE) {
            return false;
        }
        this.f9206l = i9;
        i5.c cVar = (i5.c) this;
        if (i9 == 1) {
            Chip chip2 = cVar.f4719q;
            chip2.f1993v = true;
            chip2.refreshDrawableState();
        }
        q(i9, 8);
        return true;
    }

    public final void q(int i9, int i10) {
        View view;
        ViewParent parent;
        AccessibilityEvent obtain;
        if (i9 == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = (view = this.f9203i).getParent()) == null) {
            return;
        }
        if (i9 != -1) {
            obtain = AccessibilityEvent.obtain(i10);
            l n4 = n(i9);
            obtain.getText().add(n4.g());
            AccessibilityNodeInfo accessibilityNodeInfo = n4.f7564a;
            obtain.setContentDescription(accessibilityNodeInfo.getContentDescription());
            obtain.setScrollable(accessibilityNodeInfo.isScrollable());
            obtain.setPassword(accessibilityNodeInfo.isPassword());
            obtain.setEnabled(accessibilityNodeInfo.isEnabled());
            obtain.setChecked(accessibilityNodeInfo.isChecked());
            if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
                m7.c.i("Callbacks must add text or a content description in populateEventForVirtualViewId()");
                return;
            } else {
                obtain.setClassName(accessibilityNodeInfo.getClassName());
                p.a(obtain, view, i9);
                obtain.setPackageName(view.getContext().getPackageName());
            }
        } else {
            obtain = AccessibilityEvent.obtain(i10);
            view.onInitializeAccessibilityEvent(obtain);
        }
        parent.requestSendAccessibilityEvent(view, obtain);
    }
}
