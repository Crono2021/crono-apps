package y;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class b extends View {

    /* renamed from: i, reason: collision with root package name */
    public int[] f10224i;

    /* renamed from: j, reason: collision with root package name */
    public int f10225j;

    /* renamed from: k, reason: collision with root package name */
    public Context f10226k;

    /* renamed from: l, reason: collision with root package name */
    public w.i f10227l;

    /* renamed from: m, reason: collision with root package name */
    public String f10228m;

    /* renamed from: n, reason: collision with root package name */
    public HashMap f10229n;

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10224i = new int[32];
        this.f10229n = new HashMap();
        this.f10226k = context;
        e(attributeSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r6) {
        /*
            r5 = this;
            android.content.Context r0 = r5.f10226k
            int r1 = r6.length()
            if (r1 != 0) goto La
            goto Laa
        La:
            if (r0 != 0) goto Le
            goto Laa
        Le:
            java.lang.String r6 = r6.trim()
            android.view.ViewParent r1 = r5.getParent()
            boolean r1 = r1 instanceof androidx.constraintlayout.widget.ConstraintLayout
            if (r1 == 0) goto L20
            android.view.ViewParent r1 = r5.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
        L20:
            android.view.ViewParent r1 = r5.getParent()
            boolean r1 = r1 instanceof androidx.constraintlayout.widget.ConstraintLayout
            r2 = 0
            if (r1 == 0) goto L30
            android.view.ViewParent r1 = r5.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            goto L31
        L30:
            r1 = r2
        L31:
            boolean r3 = r5.isInEditMode()
            if (r3 == 0) goto L5c
            if (r1 == 0) goto L5c
            boolean r3 = t.a.d(r6)
            if (r3 == 0) goto L50
            java.util.HashMap r3 = r1.f546u
            if (r3 == 0) goto L50
            boolean r3 = r3.containsKey(r6)
            if (r3 == 0) goto L50
            java.util.HashMap r3 = r1.f546u
            java.lang.Object r3 = r3.get(r6)
            goto L51
        L50:
            r3 = r2
        L51:
            boolean r4 = r3 instanceof java.lang.Integer
            if (r4 == 0) goto L5c
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L5d
        L5c:
            r3 = 0
        L5d:
            if (r3 != 0) goto L65
            if (r1 == 0) goto L65
            int r3 = r5.d(r1, r6)
        L65:
            if (r3 != 0) goto L73
            java.lang.Class<y.n> r1 = y.n.class
            java.lang.reflect.Field r1 = r1.getField(r6)     // Catch: java.lang.Exception -> L72
            int r3 = r1.getInt(r2)     // Catch: java.lang.Exception -> L72
            goto L73
        L72:
        L73:
            if (r3 != 0) goto L83
            android.content.res.Resources r1 = r0.getResources()
            java.lang.String r2 = "id"
            java.lang.String r0 = r0.getPackageName()
            int r3 = r1.getIdentifier(r6, r2, r0)
        L83:
            if (r3 == 0) goto L92
            java.util.HashMap r0 = r5.f10229n
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r0.put(r1, r6)
            r5.b(r3)
            goto Laa
        L92:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Could not find id of \""
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r6 = "\""
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r0 = "ConstraintHelper"
            android.util.Log.w(r0, r6)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y.b.a(java.lang.String):void");
    }

    public final void b(int i9) {
        if (i9 == getId()) {
            return;
        }
        int i10 = this.f10225j + 1;
        int[] iArr = this.f10224i;
        if (i10 > iArr.length) {
            this.f10224i = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f10224i;
        int i11 = this.f10225j;
        iArr2[i11] = i9;
        this.f10225j = i11 + 1;
    }

    public final void c() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) parent;
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i9 = 0; i9 < this.f10225j; i9++) {
            View view = (View) constraintLayout.f534i.get(this.f10224i[i9]);
            if (view != null) {
                view.setVisibility(visibility);
                if (elevation > 0.0f) {
                    view.setTranslationZ(view.getTranslationZ() + elevation);
                }
            }
        }
    }

    public final int d(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String str2;
        if (str != null && (resources = this.f10226k.getResources()) != null) {
            int childCount = constraintLayout.getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = constraintLayout.getChildAt(i9);
                if (childAt.getId() != -1) {
                    try {
                        str2 = resources.getResourceEntryName(childAt.getId());
                    } catch (Resources.NotFoundException unused) {
                        str2 = null;
                    }
                    if (str.equals(str2)) {
                        return childAt.getId();
                    }
                }
            }
        }
        return 0;
    }

    public void e(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.f10338b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i9 = 0; i9 < indexCount; i9++) {
                int index = obtainStyledAttributes.getIndex(i9);
                if (index == 19) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f10228m = string;
                    setIds(string);
                }
            }
        }
    }

    public abstract void f(w.d dVar, boolean z8);

    public final void g() {
        if (this.f10227l == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof d) {
            ((d) layoutParams).f10250k0 = this.f10227l;
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f10224i, this.f10225j);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f10228m;
        if (str != null) {
            setIds(str);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i9, int i10) {
        setMeasuredDimension(0, 0);
    }

    public void setIds(String str) {
        this.f10228m = str;
        if (str == null) {
            return;
        }
        int i9 = 0;
        this.f10225j = 0;
        while (true) {
            int indexOf = str.indexOf(44, i9);
            if (indexOf == -1) {
                a(str.substring(i9));
                return;
            } else {
                a(str.substring(i9, indexOf));
                i9 = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f10228m = null;
        this.f10225j = 0;
        for (int i9 : iArr) {
            b(i9);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }
}
