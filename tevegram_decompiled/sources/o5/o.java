package o5;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;
import n0.d0;
import n0.t0;
import org.webrtc.PeerConnectionFactory;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f7998a = {2130968835};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f7999b = {2130968842};

    /* renamed from: c, reason: collision with root package name */
    public static final a0.k f8000c = new a0.k(12);

    public static void a(Context context, AttributeSet attributeSet, int i9, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y4.a.I, i9, i10);
        boolean z8 = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
        if (z8) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(2130969131, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                c(context, f7999b, "Theme.MaterialComponents");
            }
        }
        c(context, f7998a, "Theme.AppCompat");
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (r0.getResourceId(0, -1) != (-1)) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(android.content.Context r5, android.util.AttributeSet r6, int[] r7, int r8, int r9, int... r10) {
        /*
            int[] r0 = y4.a.I
            android.content.res.TypedArray r0 = r5.obtainStyledAttributes(r6, r0, r8, r9)
            r1 = 2
            r2 = 0
            boolean r1 = r0.getBoolean(r1, r2)
            if (r1 != 0) goto L12
            r0.recycle()
            return
        L12:
            int r1 = r10.length
            r3 = 1
            r4 = -1
            if (r1 != 0) goto L1f
            int r5 = r0.getResourceId(r2, r4)
            if (r5 == r4) goto L3a
        L1d:
            r2 = 1
            goto L3a
        L1f:
            android.content.res.TypedArray r5 = r5.obtainStyledAttributes(r6, r7, r8, r9)
            int r6 = r10.length
            r7 = 0
        L25:
            if (r7 >= r6) goto L36
            r8 = r10[r7]
            int r8 = r5.getResourceId(r8, r4)
            if (r8 != r4) goto L33
            r5.recycle()
            goto L3a
        L33:
            int r7 = r7 + 1
            goto L25
        L36:
            r5.recycle()
            goto L1d
        L3a:
            r0.recycle()
            if (r2 == 0) goto L40
            return
        L40:
            java.lang.String r5 = "This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant)."
            m7.c.n(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o5.o.b(android.content.Context, android.util.AttributeSet, int[], int, int, int[]):void");
    }

    public static void c(Context context, int[] iArr, String str) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i9 = 0; i9 < iArr.length; i9++) {
            if (!obtainStyledAttributes.hasValue(i9)) {
                obtainStyledAttributes.recycle();
                m7.c.n(androidx.activity.g.n("The style on this component requires your app theme to be ", str, " (or a descendant)."));
                return;
            }
        }
        obtainStyledAttributes.recycle();
    }

    public static ArrayList d(MaterialToolbar materialToolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i9 = 0; i9 < materialToolbar.getChildCount(); i9++) {
            View childAt = materialToolbar.getChildAt(i9);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    public static boolean e(View view) {
        WeakHashMap weakHashMap = t0.f7209a;
        return d0.d(view) == 1;
    }

    public static TypedArray f(Context context, AttributeSet attributeSet, int[] iArr, int i9, int i10, int... iArr2) {
        a(context, attributeSet, i9, i10);
        b(context, attributeSet, iArr, i9, i10, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i9, i10);
    }

    public static PorterDuff.Mode g(int i9, PorterDuff.Mode mode) {
        if (i9 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i9 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i9 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i9) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
