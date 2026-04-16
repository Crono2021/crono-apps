package com.google.android.material.datepicker;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j extends n0.c {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f2026d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f2027e;

    public /* synthetic */ j(Object obj, int i9) {
        this.f2026d = i9;
        this.f2027e = obj;
    }

    @Override // n0.c
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f2026d) {
            case 2:
                super.c(view, accessibilityEvent);
                accessibilityEvent.setChecked(((CheckableImageButton) this.f2027e).f2100l);
                break;
            default:
                super.c(view, accessibilityEvent);
                break;
        }
    }

    @Override // n0.c
    public final void d(View view, o0.l lVar) {
        int i9;
        int i10 = this.f2026d;
        Object obj = this.f2027e;
        View.AccessibilityDelegate accessibilityDelegate = this.f7144a;
        switch (i10) {
            case 0:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, lVar.f7564a);
                m mVar = (m) obj;
                lVar.j(mVar.f2042k0.getVisibility() == 0 ? mVar.w().getResources().getString(2131951818) : mVar.w().getResources().getString(2131951816));
                break;
            case 1:
                AccessibilityNodeInfo accessibilityNodeInfo = lVar.f7564a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) obj;
                int i11 = MaterialButtonToggleGroup.f1964s;
                if (view instanceof MaterialButton) {
                    int i12 = 0;
                    for (int i13 = 0; i13 < materialButtonToggleGroup.getChildCount(); i13++) {
                        if (materialButtonToggleGroup.getChildAt(i13) == view) {
                            i9 = i12;
                            accessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(0, 1, i9, 1, false, ((MaterialButton) view).f1961w));
                            break;
                        } else {
                            if ((materialButtonToggleGroup.getChildAt(i13) instanceof MaterialButton) && materialButtonToggleGroup.c(i13)) {
                                i12++;
                            }
                        }
                    }
                }
                i9 = -1;
                accessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(0, 1, i9, 1, false, ((MaterialButton) view).f1961w));
                break;
            case 2:
                AccessibilityNodeInfo accessibilityNodeInfo2 = lVar.f7564a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                CheckableImageButton checkableImageButton = (CheckableImageButton) obj;
                accessibilityNodeInfo2.setCheckable(checkableImageButton.f2101m);
                accessibilityNodeInfo2.setChecked(checkableImageButton.f2100l);
                break;
            default:
                AccessibilityNodeInfo accessibilityNodeInfo3 = lVar.f7564a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo3);
                accessibilityNodeInfo3.setCheckable(((NavigationMenuItemView) obj).F);
                break;
        }
    }
}
