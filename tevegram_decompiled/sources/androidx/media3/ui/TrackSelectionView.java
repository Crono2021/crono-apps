package androidx.media3.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import com.google.android.material.datepicker.l;
import d1.a1;
import d1.e1;
import d1.z0;
import h4.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import l3.h0;
import l3.i0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class TrackSelectionView extends LinearLayout {

    /* renamed from: i, reason: collision with root package name */
    public final int f1024i;

    /* renamed from: j, reason: collision with root package name */
    public final LayoutInflater f1025j;

    /* renamed from: k, reason: collision with root package name */
    public final CheckedTextView f1026k;

    /* renamed from: l, reason: collision with root package name */
    public final CheckedTextView f1027l;

    /* renamed from: m, reason: collision with root package name */
    public final l f1028m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f1029n;

    /* renamed from: o, reason: collision with root package name */
    public final HashMap f1030o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1031p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1032q;

    /* renamed from: r, reason: collision with root package name */
    public h0 f1033r;

    /* renamed from: s, reason: collision with root package name */
    public CheckedTextView[][] f1034s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1035t;

    public TrackSelectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setOrientation(1);
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.selectableItemBackground});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        this.f1024i = resourceId;
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(context);
        this.f1025j = from;
        l lVar = new l(this, 2);
        this.f1028m = lVar;
        this.f1033r = new x(getResources());
        this.f1029n = new ArrayList();
        this.f1030o = new HashMap();
        CheckedTextView checkedTextView = (CheckedTextView) from.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f1026k = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(2131951711);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(lVar);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(from.inflate(2131558459, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) from.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f1027l = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(2131951710);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(lVar);
        addView(checkedTextView2);
    }

    public final void a() {
        this.f1026k.setChecked(this.f1035t);
        boolean z8 = this.f1035t;
        HashMap hashMap = this.f1030o;
        this.f1027l.setChecked(!z8 && hashMap.size() == 0);
        for (int i9 = 0; i9 < this.f1034s.length; i9++) {
            a1 a1Var = (a1) hashMap.get(((e1) this.f1029n.get(i9)).f2415b);
            int i10 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.f1034s[i9];
                if (i10 < checkedTextViewArr.length) {
                    if (a1Var != null) {
                        Object tag = checkedTextViewArr[i10].getTag();
                        tag.getClass();
                        this.f1034s[i9][i10].setChecked(a1Var.f2354b.contains(Integer.valueOf(((i0) tag).f6159b)));
                    } else {
                        checkedTextViewArr[i10].setChecked(false);
                    }
                    i10++;
                }
            }
        }
    }

    public final void b() {
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        ArrayList arrayList = this.f1029n;
        boolean isEmpty = arrayList.isEmpty();
        CheckedTextView checkedTextView = this.f1027l;
        CheckedTextView checkedTextView2 = this.f1026k;
        if (isEmpty) {
            checkedTextView2.setEnabled(false);
            checkedTextView.setEnabled(false);
            return;
        }
        checkedTextView2.setEnabled(true);
        checkedTextView.setEnabled(true);
        this.f1034s = new CheckedTextView[arrayList.size()][];
        boolean z8 = this.f1032q && arrayList.size() > 1;
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            e1 e1Var = (e1) arrayList.get(i9);
            boolean z9 = this.f1031p && e1Var.f2416c;
            CheckedTextView[][] checkedTextViewArr = this.f1034s;
            int i10 = e1Var.f2414a;
            checkedTextViewArr[i9] = new CheckedTextView[i10];
            i0[] i0VarArr = new i0[i10];
            for (int i11 = 0; i11 < e1Var.f2414a; i11++) {
                i0VarArr[i11] = new i0(e1Var, i11);
            }
            for (int i12 = 0; i12 < i10; i12++) {
                LayoutInflater layoutInflater = this.f1025j;
                if (i12 == 0) {
                    addView(layoutInflater.inflate(2131558459, (ViewGroup) this, false));
                }
                CheckedTextView checkedTextView3 = (CheckedTextView) layoutInflater.inflate((z9 || z8) ? R.layout.simple_list_item_multiple_choice : R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
                checkedTextView3.setBackgroundResource(this.f1024i);
                h0 h0Var = this.f1033r;
                i0 i0Var = i0VarArr[i12];
                checkedTextView3.setText(((x) h0Var).c(i0Var.f6158a.a(i0Var.f6159b)));
                checkedTextView3.setTag(i0VarArr[i12]);
                if (e1Var.c(i12)) {
                    checkedTextView3.setFocusable(true);
                    checkedTextView3.setOnClickListener(this.f1028m);
                } else {
                    checkedTextView3.setFocusable(false);
                    checkedTextView3.setEnabled(false);
                }
                this.f1034s[i9][i12] = checkedTextView3;
                addView(checkedTextView3);
            }
        }
        a();
    }

    public boolean getIsDisabled() {
        return this.f1035t;
    }

    public Map<z0, a1> getOverrides() {
        return this.f1030o;
    }

    public void setAllowAdaptiveSelections(boolean z8) {
        if (this.f1031p != z8) {
            this.f1031p = z8;
            b();
        }
    }

    public void setAllowMultipleOverrides(boolean z8) {
        if (this.f1032q != z8) {
            this.f1032q = z8;
            if (!z8) {
                HashMap hashMap = this.f1030o;
                if (hashMap.size() > 1) {
                    HashMap hashMap2 = new HashMap();
                    int i9 = 0;
                    while (true) {
                        ArrayList arrayList = this.f1029n;
                        if (i9 >= arrayList.size()) {
                            break;
                        }
                        a1 a1Var = (a1) hashMap.get(((e1) arrayList.get(i9)).f2415b);
                        if (a1Var != null && hashMap2.isEmpty()) {
                            hashMap2.put(a1Var.f2353a, a1Var);
                        }
                        i9++;
                    }
                    hashMap.clear();
                    hashMap.putAll(hashMap2);
                }
            }
            b();
        }
    }

    public void setShowDisableOption(boolean z8) {
        this.f1026k.setVisibility(z8 ? 0 : 8);
    }

    public void setTrackNameProvider(h0 h0Var) {
        h0Var.getClass();
        this.f1033r = h0Var;
        b();
    }
}
