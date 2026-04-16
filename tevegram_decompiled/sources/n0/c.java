package n0;

import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    public static final View.AccessibilityDelegate f7143c = new View.AccessibilityDelegate();

    /* renamed from: a, reason: collision with root package name */
    public final View.AccessibilityDelegate f7144a;

    /* renamed from: b, reason: collision with root package name */
    public final a f7145b;

    public c(View.AccessibilityDelegate accessibilityDelegate) {
        this.f7144a = accessibilityDelegate;
        this.f7145b = new a(this);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f7144a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public i7.x b(View view) {
        AccessibilityNodeProvider a9 = b.a(this.f7144a, view);
        if (a9 != null) {
            return new i7.x(a9, 14);
        }
        return null;
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f7144a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, o0.l lVar) {
        this.f7144a.onInitializeAccessibilityNodeInfo(view, lVar.f7564a);
    }

    public void e(View view, AccessibilityEvent accessibilityEvent) {
        this.f7144a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f7144a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean g(View view, int i9, Bundle bundle) {
        boolean z8;
        WeakReference weakReference;
        ClickableSpan clickableSpan;
        List list = (List) view.getTag(2131362419);
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        boolean z9 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= list.size()) {
                break;
            }
            o0.f fVar = (o0.f) list.get(i10);
            if (fVar.a() == i9) {
                Class cls = fVar.f7560c;
                o0.x xVar = fVar.f7561d;
                if (xVar != null) {
                    if (cls != null) {
                        try {
                            if (cls.getDeclaredConstructor(null).newInstance(null) == null) {
                                throw null;
                            }
                            throw new ClassCastException();
                        } catch (Exception e9) {
                            Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: ".concat(cls.getName()), e9);
                        }
                    }
                    z8 = xVar.b(view);
                }
            } else {
                i10++;
            }
        }
        z8 = false;
        if (!z8) {
            z8 = b.b(this.f7144a, view, i9, bundle);
        }
        if (z8 || i9 != 2131361807 || bundle == null) {
            return z8;
        }
        int i11 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(2131362420);
        if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i11)) != null && (clickableSpan = (ClickableSpan) weakReference.get()) != null) {
            CharSequence text = view.createAccessibilityNodeInfo().getText();
            ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
            int i12 = 0;
            while (true) {
                if (clickableSpanArr == null || i12 >= clickableSpanArr.length) {
                    break;
                }
                if (clickableSpan.equals(clickableSpanArr[i12])) {
                    clickableSpan.onClick(view);
                    z9 = true;
                    break;
                }
                i12++;
            }
        }
        return z9;
    }

    public void h(View view, int i9) {
        this.f7144a.sendAccessibilityEvent(view, i9);
    }

    public void i(View view, AccessibilityEvent accessibilityEvent) {
        this.f7144a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public c() {
        this(f7143c);
    }
}
