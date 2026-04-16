package com.google.android.material.button;

import a0.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import b7.d;
import com.google.android.material.timepicker.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import n0.c0;
import n0.d0;
import n0.l;
import n0.t0;
import o5.o;
import u5.j;
import z5.a;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f1964s = 0;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f1965i;

    /* renamed from: j, reason: collision with root package name */
    public final b f1966j;

    /* renamed from: k, reason: collision with root package name */
    public final LinkedHashSet f1967k;

    /* renamed from: l, reason: collision with root package name */
    public final d f1968l;

    /* renamed from: m, reason: collision with root package name */
    public Integer[] f1969m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1970n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1971o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1972p;

    /* renamed from: q, reason: collision with root package name */
    public final int f1973q;

    /* renamed from: r, reason: collision with root package name */
    public HashSet f1974r;

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, 2130969277, 2132018232), attributeSet, 2130969277);
        this.f1965i = new ArrayList();
        this.f1966j = new b(this, 19);
        this.f1967k = new LinkedHashSet();
        this.f1968l = new d(this, 1);
        this.f1970n = false;
        this.f1974r = new HashSet();
        TypedArray f9 = o.f(getContext(), attributeSet, y4.a.f10510p, 2130969277, 2132018232, new int[0]);
        setSingleSelection(f9.getBoolean(3, false));
        this.f1973q = f9.getResourceId(1, -1);
        this.f1972p = f9.getBoolean(2, false);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(f9.getBoolean(0, true));
        f9.recycle();
        WeakHashMap weakHashMap = t0.f7209a;
        c0.s(this, 1);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            if (c(i9)) {
                return i9;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (c(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i9 = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            if ((getChildAt(i10) instanceof MaterialButton) && c(i10)) {
                i9++;
            }
        }
        return i9;
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            WeakHashMap weakHashMap = t0.f7209a;
            materialButton.setId(d0.a());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f1966j);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public final void a() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i9 = firstVisibleChildIndex + 1; i9 < getChildCount(); i9++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i9);
            int min = Math.min(materialButton.getStrokeWidth(), ((MaterialButton) getChildAt(i9 - 1)).getStrokeWidth());
            ViewGroup.LayoutParams layoutParams = materialButton.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                l.g(layoutParams2, 0);
                l.h(layoutParams2, -min);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = -min;
                l.h(layoutParams2, 0);
            }
            materialButton.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || firstVisibleChildIndex == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
        } else {
            l.g(layoutParams3, 0);
            l.h(layoutParams3, 0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i9, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i9, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        b(materialButton.getId(), materialButton.f1961w);
        j shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f1965i.add(new e5.d(shapeAppearanceModel.f9107e, shapeAppearanceModel.h, shapeAppearanceModel.f9108f, shapeAppearanceModel.f9109g));
        materialButton.setEnabled(isEnabled());
        t0.p(materialButton, new com.google.android.material.datepicker.j(this, 1));
    }

    public final void b(int i9, boolean z8) {
        if (i9 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i9);
            return;
        }
        HashSet hashSet = new HashSet(this.f1974r);
        if (z8 && !hashSet.contains(Integer.valueOf(i9))) {
            if (this.f1971o && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i9));
        } else {
            if (z8 || !hashSet.contains(Integer.valueOf(i9))) {
                return;
            }
            if (!this.f1972p || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i9));
            }
        }
        d(hashSet);
    }

    public final boolean c(int i9) {
        return getChildAt(i9).getVisibility() != 8;
    }

    public final void d(Set set) {
        HashSet hashSet = this.f1974r;
        this.f1974r = new HashSet(set);
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            int id = ((MaterialButton) getChildAt(i9)).getId();
            boolean contains = set.contains(Integer.valueOf(id));
            View findViewById = findViewById(id);
            if (findViewById instanceof MaterialButton) {
                this.f1970n = true;
                ((MaterialButton) findViewById).setChecked(contains);
                this.f1970n = false;
            }
            if (hashSet.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                set.contains(Integer.valueOf(id));
                Iterator it = this.f1967k.iterator();
                while (it.hasNext()) {
                    ((f) it.next()).a();
                }
            }
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f1968l);
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            treeMap.put((MaterialButton) getChildAt(i9), Integer.valueOf(i9));
        }
        this.f1969m = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void e() {
        e5.d dVar;
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i9 = 0; i9 < childCount; i9++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i9);
            if (materialButton.getVisibility() != 8) {
                c7.b e9 = materialButton.getShapeAppearanceModel().e();
                e5.d dVar2 = (e5.d) this.f1965i.get(i9);
                if (firstVisibleChildIndex != lastVisibleChildIndex) {
                    boolean z8 = getOrientation() == 0;
                    u5.a aVar = e5.d.f3144e;
                    if (i9 == firstVisibleChildIndex) {
                        dVar = z8 ? o.e(this) ? new e5.d(aVar, aVar, dVar2.f3146b, dVar2.f3147c) : new e5.d(dVar2.f3145a, dVar2.f3148d, aVar, aVar) : new e5.d(dVar2.f3145a, aVar, dVar2.f3146b, aVar);
                    } else if (i9 == lastVisibleChildIndex) {
                        dVar = z8 ? o.e(this) ? new e5.d(dVar2.f3145a, dVar2.f3148d, aVar, aVar) : new e5.d(aVar, aVar, dVar2.f3146b, dVar2.f3147c) : new e5.d(aVar, dVar2.f3148d, aVar, dVar2.f3147c);
                    } else {
                        dVar2 = null;
                    }
                    dVar2 = dVar;
                }
                if (dVar2 == null) {
                    e9.c(0.0f);
                } else {
                    e9.f1652f = dVar2.f3145a;
                    e9.f1654i = dVar2.f3148d;
                    e9.f1653g = dVar2.f3146b;
                    e9.h = dVar2.f3147c;
                }
                materialButton.setShapeAppearanceModel(e9.a());
            }
        }
    }

    public int getCheckedButtonId() {
        if (!this.f1971o || this.f1974r.isEmpty()) {
            return -1;
        }
        return ((Integer) this.f1974r.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            int id = ((MaterialButton) getChildAt(i9)).getId();
            if (this.f1974r.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i9, int i10) {
        Integer[] numArr = this.f1969m;
        if (numArr != null && i10 < numArr.length) {
            return numArr[i10].intValue();
        }
        Log.w("MButtonToggleGroup", "Child order wasn't updated");
        return i10;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i9 = this.f1973q;
        if (i9 != -1) {
            d(Collections.singleton(Integer.valueOf(i9)));
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, getVisibleButtonCount(), false, this.f1971o ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        e();
        a();
        super.onMeasure(i9, i10);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f1965i.remove(indexOfChild);
        }
        e();
        a();
    }

    @Override // android.view.View
    public void setEnabled(boolean z8) {
        super.setEnabled(z8);
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            ((MaterialButton) getChildAt(i9)).setEnabled(z8);
        }
    }

    public void setSelectionRequired(boolean z8) {
        this.f1972p = z8;
    }

    public void setSingleSelection(boolean z8) {
        if (this.f1971o != z8) {
            this.f1971o = z8;
            d(new HashSet());
        }
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            ((MaterialButton) getChildAt(i9)).setA11yClassName((this.f1971o ? RadioButton.class : ToggleButton.class).getName());
        }
    }

    public void setSingleSelection(int i9) {
        setSingleSelection(getResources().getBoolean(i9));
    }
}
