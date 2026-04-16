package n0;

import android.os.Build;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends View.AccessibilityDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final c f7130a;

    public a(c cVar) {
        this.f7130a = cVar;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.f7130a.a(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        i7.x b9 = this.f7130a.b(view);
        if (b9 != null) {
            return (AccessibilityNodeProvider) b9.f5179j;
        }
        return null;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f7130a.c(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        Object tag;
        Object tag2;
        Object tag3;
        int i9;
        o0.l lVar = new o0.l(accessibilityNodeInfo);
        WeakHashMap weakHashMap = t0.f7209a;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = Boolean.valueOf(m0.d(view));
        } else {
            tag = view.getTag(2131362426);
            if (!Boolean.class.isInstance(tag)) {
                tag = null;
            }
        }
        Boolean bool = (Boolean) tag;
        boolean z8 = bool != null && bool.booleanValue();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            accessibilityNodeInfo.setScreenReaderFocusable(z8);
        } else {
            lVar.h(1, z8);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            tag2 = Boolean.valueOf(m0.c(view));
        } else {
            tag2 = view.getTag(2131362421);
            if (!Boolean.class.isInstance(tag2)) {
                tag2 = null;
            }
        }
        Boolean bool2 = (Boolean) tag2;
        boolean z9 = bool2 != null && bool2.booleanValue();
        if (i10 >= 28) {
            accessibilityNodeInfo.setHeading(z9);
        } else {
            lVar.h(2, z9);
        }
        CharSequence d9 = t0.d(view);
        if (i10 >= 28) {
            accessibilityNodeInfo.setPaneTitle(d9);
        } else {
            o0.g.c(accessibilityNodeInfo).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", d9);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            tag3 = o0.b(view);
        } else {
            tag3 = view.getTag(2131362427);
            if (!CharSequence.class.isInstance(tag3)) {
                tag3 = null;
            }
        }
        CharSequence charSequence = (CharSequence) tag3;
        if (i10 >= 30) {
            o0.h.c(accessibilityNodeInfo, charSequence);
        } else {
            o0.g.c(accessibilityNodeInfo).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
        this.f7130a.d(view, lVar);
        CharSequence text = accessibilityNodeInfo.getText();
        if (i10 < 26) {
            o0.g.c(accessibilityNodeInfo).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            o0.g.c(accessibilityNodeInfo).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            o0.g.c(accessibilityNodeInfo).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            o0.g.c(accessibilityNodeInfo).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SparseArray sparseArray = (SparseArray) view.getTag(2131362420);
            if (sparseArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                    if (((WeakReference) sparseArray.valueAt(i11)).get() == null) {
                        arrayList.add(Integer.valueOf(i11));
                    }
                }
                for (int i12 = 0; i12 < arrayList.size(); i12++) {
                    sparseArray.remove(((Integer) arrayList.get(i12)).intValue());
                }
            }
            ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
            if (clickableSpanArr != null && clickableSpanArr.length > 0) {
                o0.g.c(accessibilityNodeInfo).putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", 2131361807);
                SparseArray sparseArray2 = (SparseArray) view.getTag(2131362420);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    view.setTag(2131362420, sparseArray2);
                }
                for (int i13 = 0; i13 < clickableSpanArr.length; i13++) {
                    ClickableSpan clickableSpan = clickableSpanArr[i13];
                    int i14 = 0;
                    while (true) {
                        if (i14 >= sparseArray2.size()) {
                            i9 = o0.l.f7563c;
                            o0.l.f7563c = i9 + 1;
                            break;
                        } else {
                            if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray2.valueAt(i14)).get())) {
                                i9 = sparseArray2.keyAt(i14);
                                break;
                            }
                            i14++;
                        }
                    }
                    sparseArray2.put(i9, new WeakReference(clickableSpanArr[i13]));
                    ClickableSpan clickableSpan2 = clickableSpanArr[i13];
                    Spanned spanned = (Spanned) text;
                    lVar.c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan2)));
                    lVar.c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan2)));
                    lVar.c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan2)));
                    lVar.c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i9));
                }
            }
        }
        List list = (List) view.getTag(2131362419);
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        for (int i15 = 0; i15 < list.size(); i15++) {
            lVar.b((o0.f) list.get(i15));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f7130a.e(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f7130a.f(viewGroup, view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean performAccessibilityAction(View view, int i9, Bundle bundle) {
        return this.f7130a.g(view, i9, bundle);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEvent(View view, int i9) {
        this.f7130a.h(view, i9);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.f7130a.i(view, accessibilityEvent);
    }
}
