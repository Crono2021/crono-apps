package com.google.android.material.chip;

import a5.d;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import i5.f;
import i5.g;
import i5.h;
import i5.i;
import java.util.Iterator;
import java.util.List;
import o5.a;
import o5.e;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class ChipGroup extends e {

    /* renamed from: m, reason: collision with root package name */
    public int f1998m;

    /* renamed from: n, reason: collision with root package name */
    public int f1999n;

    /* renamed from: o, reason: collision with root package name */
    public h f2000o;

    /* renamed from: p, reason: collision with root package name */
    public final a f2001p;

    /* renamed from: q, reason: collision with root package name */
    public final int f2002q;

    /* renamed from: r, reason: collision with root package name */
    public final i f2003r;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ChipGroup(android.content.Context r10, android.util.AttributeSet r11) {
        /*
            r9 = this;
            r0 = 2132018218(0x7f14042a, float:1.9674736E38)
            r4 = 2130968759(0x7f0400b7, float:1.754618E38)
            android.content.Context r10 = z5.a.a(r10, r11, r4, r0)
            r9.<init>(r10, r11, r4)
            r0 = 0
            r9.f7973k = r0
            android.content.res.Resources$Theme r10 = r10.getTheme()
            int[] r1 = y4.a.f10505k
            android.content.res.TypedArray r10 = r10.obtainStyledAttributes(r11, r1, r0, r0)
            r7 = 1
            int r1 = r10.getDimensionPixelSize(r7, r0)
            r9.f7971i = r1
            int r1 = r10.getDimensionPixelSize(r0, r0)
            r9.f7972j = r1
            r10.recycle()
            o5.a r10 = new o5.a
            r10.<init>()
            r9.f2001p = r10
            i5.i r8 = new i5.i
            r8.<init>(r9)
            r9.f2003r = r8
            android.content.Context r1 = r9.getContext()
            r5 = 2132018218(0x7f14042a, float:1.9674736E38)
            int[] r6 = new int[r0]
            int[] r3 = y4.a.f10501f
            r2 = r11
            android.content.res.TypedArray r11 = o5.o.f(r1, r2, r3, r4, r5, r6)
            int r1 = r11.getDimensionPixelOffset(r7, r0)
            r2 = 2
            int r2 = r11.getDimensionPixelOffset(r2, r1)
            r9.setChipSpacingHorizontal(r2)
            r2 = 3
            int r1 = r11.getDimensionPixelOffset(r2, r1)
            r9.setChipSpacingVertical(r1)
            r1 = 5
            boolean r1 = r11.getBoolean(r1, r0)
            r9.setSingleLine(r1)
            r1 = 6
            boolean r1 = r11.getBoolean(r1, r0)
            r9.setSingleSelection(r1)
            r1 = 4
            boolean r1 = r11.getBoolean(r1, r0)
            r9.setSelectionRequired(r1)
            r1 = -1
            int r0 = r11.getResourceId(r0, r1)
            r9.f2002q = r0
            r11.recycle()
            a0.b r11 = new a0.b
            r0 = 29
            r11.<init>(r9, r0)
            r10.f7934c = r11
            super.setOnHierarchyChangeListener(r8)
            java.util.WeakHashMap r10 = n0.t0.f7209a
            n0.c0.s(r9, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipGroup.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private int getVisibleChipCount() {
        int i9 = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            if ((getChildAt(i10) instanceof Chip) && getChildAt(i10).getVisibility() == 0) {
                i9++;
            }
        }
        return i9;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof f);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        return this.f2001p.c();
    }

    public List<Integer> getCheckedChipIds() {
        return this.f2001p.b(this);
    }

    public int getChipSpacingHorizontal() {
        return this.f1998m;
    }

    public int getChipSpacingVertical() {
        return this.f1999n;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i9 = this.f2002q;
        if (i9 != -1) {
            a aVar = this.f2001p;
            o5.h hVar = (o5.h) aVar.f7932a.get(Integer.valueOf(i9));
            if (hVar != null && aVar.a(hVar)) {
                aVar.d();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(getRowCount(), this.f7973k ? getVisibleChipCount() : -1, false, this.f2001p.f7935d ? 1 : 2));
    }

    public void setChipSpacing(int i9) {
        setChipSpacingHorizontal(i9);
        setChipSpacingVertical(i9);
    }

    public void setChipSpacingHorizontal(int i9) {
        if (this.f1998m != i9) {
            this.f1998m = i9;
            setItemSpacing(i9);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i9) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i9));
    }

    public void setChipSpacingResource(int i9) {
        setChipSpacing(getResources().getDimensionPixelOffset(i9));
    }

    public void setChipSpacingVertical(int i9) {
        if (this.f1999n != i9) {
            this.f1999n = i9;
            setLineSpacing(i9);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i9) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i9));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i9) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(g gVar) {
        if (gVar == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new d(this, gVar, 22, false));
        }
    }

    public void setOnCheckedStateChangeListener(h hVar) {
        this.f2000o = hVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f2003r.f4745i = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z8) {
        this.f2001p.f7936e = z8;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i9) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i9) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(int i9) {
        setSingleLine(getResources().getBoolean(i9));
    }

    public void setSingleSelection(boolean z8) {
        a aVar = this.f2001p;
        if (aVar.f7935d != z8) {
            aVar.f7935d = z8;
            boolean isEmpty = aVar.f7933b.isEmpty();
            Iterator it = aVar.f7932a.values().iterator();
            while (it.hasNext()) {
                aVar.e((o5.h) it.next(), false);
            }
            if (isEmpty) {
                return;
            }
            aVar.d();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new f(layoutParams);
    }

    @Override // o5.e
    public void setSingleLine(boolean z8) {
        super.setSingleLine(z8);
    }

    public void setSingleSelection(int i9) {
        setSingleSelection(getResources().getBoolean(i9));
    }
}
