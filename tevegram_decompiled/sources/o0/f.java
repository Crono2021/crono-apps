package o0;

import android.R;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f {

    /* renamed from: e, reason: collision with root package name */
    public static final f f7551e;

    /* renamed from: f, reason: collision with root package name */
    public static final f f7552f;

    /* renamed from: g, reason: collision with root package name */
    public static final f f7553g;
    public static final f h;

    /* renamed from: i, reason: collision with root package name */
    public static final f f7554i;

    /* renamed from: j, reason: collision with root package name */
    public static final f f7555j;

    /* renamed from: k, reason: collision with root package name */
    public static final f f7556k;

    /* renamed from: l, reason: collision with root package name */
    public static final f f7557l;

    /* renamed from: a, reason: collision with root package name */
    public final Object f7558a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7559b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f7560c;

    /* renamed from: d, reason: collision with root package name */
    public final x f7561d;

    static {
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction17;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction18;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction19;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction20;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction21;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction22;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction23;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction24;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction25;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction26;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction27;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction28;
        new f(1);
        new f(2);
        new f(4);
        new f(8);
        f7551e = new f(16);
        new f(32);
        new f(64);
        new f(128);
        new f(256, q.class);
        new f(IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED, q.class);
        new f(1024, r.class);
        new f(IjkMediaMeta.FF_PROFILE_H264_INTRA, r.class);
        f7552f = new f(4096);
        f7553g = new f(8192);
        new f(16384);
        new f(32768);
        new f(65536);
        new f(131072, v.class);
        h = new f(262144);
        f7554i = new f(524288);
        f7555j = new f(1048576);
        new f(2097152, w.class);
        int i9 = Build.VERSION.SDK_INT;
        new f(i9 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id.accessibilityActionShowOnScreen, null, null, null);
        if (i9 >= 23) {
            accessibilityAction28 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
            accessibilityAction = accessibilityAction28;
        } else {
            accessibilityAction = null;
        }
        new f(accessibilityAction, R.id.accessibilityActionScrollToPosition, null, null, t.class);
        f7556k = new f(i9 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
        if (i9 >= 23) {
            accessibilityAction27 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
            accessibilityAction2 = accessibilityAction27;
        } else {
            accessibilityAction2 = null;
        }
        new f(accessibilityAction2, R.id.accessibilityActionScrollLeft, null, null, null);
        if (i9 >= 23) {
            accessibilityAction26 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
            accessibilityAction3 = accessibilityAction26;
        } else {
            accessibilityAction3 = null;
        }
        f7557l = new f(accessibilityAction3, R.id.accessibilityActionScrollDown, null, null, null);
        new f(i9 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
        if (i9 >= 29) {
            accessibilityAction25 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
            accessibilityAction4 = accessibilityAction25;
        } else {
            accessibilityAction4 = null;
        }
        new f(accessibilityAction4, R.id.accessibilityActionPageUp, null, null, null);
        if (i9 >= 29) {
            accessibilityAction24 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
            accessibilityAction5 = accessibilityAction24;
        } else {
            accessibilityAction5 = null;
        }
        new f(accessibilityAction5, R.id.accessibilityActionPageDown, null, null, null);
        new f(i9 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
        if (i9 >= 29) {
            accessibilityAction23 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
            accessibilityAction6 = accessibilityAction23;
        } else {
            accessibilityAction6 = null;
        }
        new f(accessibilityAction6, R.id.accessibilityActionPageRight, null, null, null);
        if (i9 >= 23) {
            accessibilityAction22 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
            accessibilityAction7 = accessibilityAction22;
        } else {
            accessibilityAction7 = null;
        }
        new f(accessibilityAction7, R.id.accessibilityActionContextClick, null, null, null);
        if (i9 >= 24) {
            accessibilityAction21 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
            accessibilityAction8 = accessibilityAction21;
        } else {
            accessibilityAction8 = null;
        }
        new f(accessibilityAction8, R.id.accessibilityActionSetProgress, null, null, u.class);
        new f(i9 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, s.class);
        if (i9 >= 28) {
            accessibilityAction20 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
            accessibilityAction9 = accessibilityAction20;
        } else {
            accessibilityAction9 = null;
        }
        new f(accessibilityAction9, R.id.accessibilityActionShowTooltip, null, null, null);
        if (i9 >= 28) {
            accessibilityAction19 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            accessibilityAction10 = accessibilityAction19;
        } else {
            accessibilityAction10 = null;
        }
        new f(accessibilityAction10, R.id.accessibilityActionHideTooltip, null, null, null);
        new f(i9 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
        if (i9 >= 30) {
            accessibilityAction18 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
            accessibilityAction11 = accessibilityAction18;
        } else {
            accessibilityAction11 = null;
        }
        new f(accessibilityAction11, R.id.accessibilityActionImeEnter, null, null, null);
        new f(i9 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
        if (i9 >= 32) {
            accessibilityAction17 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
            accessibilityAction12 = accessibilityAction17;
        } else {
            accessibilityAction12 = null;
        }
        new f(accessibilityAction12, R.id.accessibilityActionDragDrop, null, null, null);
        if (i9 >= 32) {
            accessibilityAction16 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
            accessibilityAction13 = accessibilityAction16;
        } else {
            accessibilityAction13 = null;
        }
        new f(accessibilityAction13, R.id.accessibilityActionDragCancel, null, null, null);
        if (i9 >= 33) {
            accessibilityAction15 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
            accessibilityAction14 = accessibilityAction15;
        } else {
            accessibilityAction14 = null;
        }
        new f(accessibilityAction14, R.id.accessibilityActionShowTextSuggestions, null, null, null);
        new f(i9 >= 34 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION : null, R.id.accessibilityActionScrollInDirection, null, null, null);
    }

    public f(Object obj, int i9, String str, x xVar, Class cls) {
        this.f7559b = i9;
        this.f7561d = xVar;
        if (obj == null) {
            this.f7558a = new AccessibilityNodeInfo.AccessibilityAction(i9, str);
        } else {
            this.f7558a = obj;
        }
        this.f7560c = cls;
    }

    public final int a() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.f7558a).getId();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof f)) {
            return false;
        }
        Object obj2 = ((f) obj).f7558a;
        Object obj3 = this.f7558a;
        return obj3 == null ? obj2 == null : obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.f7558a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AccessibilityActionCompat: ");
        String d9 = l.d(this.f7559b);
        if (d9.equals("ACTION_UNKNOWN")) {
            Object obj = this.f7558a;
            if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                d9 = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
            }
        }
        sb.append(d9);
        return sb.toString();
    }

    public f(int i9, Class cls) {
        this(null, i9, null, null, cls);
    }

    public f(int i9) {
        this(null, i9, null, null, null);
    }
}
