package n;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b1 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f6789a;

    /* renamed from: b, reason: collision with root package name */
    public o3 f6790b;

    /* renamed from: c, reason: collision with root package name */
    public o3 f6791c;

    /* renamed from: d, reason: collision with root package name */
    public o3 f6792d;

    /* renamed from: e, reason: collision with root package name */
    public o3 f6793e;

    /* renamed from: f, reason: collision with root package name */
    public o3 f6794f;

    /* renamed from: g, reason: collision with root package name */
    public o3 f6795g;
    public o3 h;

    /* renamed from: i, reason: collision with root package name */
    public final l1 f6796i;

    /* renamed from: j, reason: collision with root package name */
    public int f6797j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f6798k = -1;

    /* renamed from: l, reason: collision with root package name */
    public Typeface f6799l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f6800m;

    public b1(TextView textView) {
        this.f6789a = textView;
        this.f6796i = new l1(textView);
    }

    public static o3 c(Context context, t tVar, int i9) {
        ColorStateList i10;
        synchronized (tVar) {
            i10 = tVar.f7034a.i(context, i9);
        }
        if (i10 == null) {
            return null;
        }
        o3 o3Var = new o3();
        o3Var.f6994d = true;
        o3Var.f6991a = i10;
        return o3Var;
    }

    public static void h(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 30 || inputConnection == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (i9 >= 30) {
            q0.b.a(editorInfo, text);
            return;
        }
        text.getClass();
        if (i9 >= 30) {
            q0.b.a(editorInfo, text);
            return;
        }
        int i10 = editorInfo.initialSelStart;
        int i11 = editorInfo.initialSelEnd;
        int i12 = i10 > i11 ? i11 : i10;
        if (i10 <= i11) {
            i10 = i11;
        }
        int length = text.length();
        if (i12 < 0 || i10 > length) {
            q0.c.a(editorInfo, null, 0, 0);
            return;
        }
        int i13 = editorInfo.inputType & 4095;
        if (i13 == 129 || i13 == 225 || i13 == 18) {
            q0.c.a(editorInfo, null, 0, 0);
            return;
        }
        if (length <= 2048) {
            q0.c.a(editorInfo, text, i12, i10);
            return;
        }
        int i14 = i10 - i12;
        int i15 = i14 > 1024 ? 0 : i14;
        int i16 = 2048 - i15;
        int min = Math.min(text.length() - i10, i16 - Math.min(i12, (int) (i16 * 0.8d)));
        int min2 = Math.min(i12, i16 - min);
        int i17 = i12 - min2;
        if (Character.isLowSurrogate(text.charAt(i17))) {
            i17++;
            min2--;
        }
        if (Character.isHighSurrogate(text.charAt((i10 + min) - 1))) {
            min--;
        }
        int i18 = min2 + i15;
        q0.c.a(editorInfo, i15 != i14 ? TextUtils.concat(text.subSequence(i17, i17 + min2), text.subSequence(i10, min + i10)) : text.subSequence(i17, i18 + min + i17), min2, i18);
    }

    public final void a(Drawable drawable, o3 o3Var) {
        if (drawable == null || o3Var == null) {
            return;
        }
        t.e(drawable, o3Var, this.f6789a.getDrawableState());
    }

    public final void b() {
        o3 o3Var = this.f6790b;
        TextView textView = this.f6789a;
        if (o3Var != null || this.f6791c != null || this.f6792d != null || this.f6793e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f6790b);
            a(compoundDrawables[1], this.f6791c);
            a(compoundDrawables[2], this.f6792d);
            a(compoundDrawables[3], this.f6793e);
        }
        if (this.f6794f == null && this.f6795g == null) {
            return;
        }
        Drawable[] a9 = w0.a(textView);
        a(a9[0], this.f6794f);
        a(a9[2], this.f6795g);
    }

    public final ColorStateList d() {
        o3 o3Var = this.h;
        if (o3Var != null) {
            return o3Var.f6991a;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        o3 o3Var = this.h;
        if (o3Var != null) {
            return o3Var.f6992b;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:216:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(android.util.AttributeSet r30, int r31) {
        /*
            Method dump skipped, instructions count: 1125
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.b1.f(android.util.AttributeSet, int):void");
    }

    public final void g(Context context, int i9) {
        String string;
        ColorStateList O;
        ColorStateList O2;
        ColorStateList O3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i9, f.a.f3188x);
        androidx.fragment.app.g gVar = new androidx.fragment.app.g(context, obtainStyledAttributes);
        boolean hasValue = obtainStyledAttributes.hasValue(14);
        TextView textView = this.f6789a;
        if (hasValue) {
            textView.setAllCaps(obtainStyledAttributes.getBoolean(14, false));
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 23) {
            if (obtainStyledAttributes.hasValue(3) && (O3 = gVar.O(3)) != null) {
                textView.setTextColor(O3);
            }
            if (obtainStyledAttributes.hasValue(5) && (O2 = gVar.O(5)) != null) {
                textView.setLinkTextColor(O2);
            }
            if (obtainStyledAttributes.hasValue(4) && (O = gVar.O(4)) != null) {
                textView.setHintTextColor(O);
            }
        }
        if (obtainStyledAttributes.hasValue(0) && obtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, gVar);
        if (i10 >= 26 && obtainStyledAttributes.hasValue(13) && (string = obtainStyledAttributes.getString(13)) != null) {
            z0.d(textView, string);
        }
        gVar.i0();
        Typeface typeface = this.f6799l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f6797j);
        }
    }

    public final void i(int i9, int i10, int i11, int i12) {
        l1 l1Var = this.f6796i;
        if (l1Var.j()) {
            DisplayMetrics displayMetrics = l1Var.f6958j.getResources().getDisplayMetrics();
            l1Var.k(TypedValue.applyDimension(i12, i9, displayMetrics), TypedValue.applyDimension(i12, i10, displayMetrics), TypedValue.applyDimension(i12, i11, displayMetrics));
            if (l1Var.h()) {
                l1Var.a();
            }
        }
    }

    public final void j(int[] iArr, int i9) {
        l1 l1Var = this.f6796i;
        if (l1Var.j()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i9 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = l1Var.f6958j.getResources().getDisplayMetrics();
                    for (int i10 = 0; i10 < length; i10++) {
                        iArr2[i10] = Math.round(TypedValue.applyDimension(i9, iArr[i10], displayMetrics));
                    }
                }
                l1Var.f6955f = l1.b(iArr2);
                if (!l1Var.i()) {
                    androidx.fragment.app.a.g(Arrays.toString(iArr), "None of the preset sizes is valid: ");
                    return;
                }
            } else {
                l1Var.f6956g = false;
            }
            if (l1Var.h()) {
                l1Var.a();
            }
        }
    }

    public final void k(int i9) {
        l1 l1Var = this.f6796i;
        if (l1Var.j()) {
            if (i9 == 0) {
                l1Var.f6950a = 0;
                l1Var.f6953d = -1.0f;
                l1Var.f6954e = -1.0f;
                l1Var.f6952c = -1.0f;
                l1Var.f6955f = new int[0];
                l1Var.f6951b = false;
                return;
            }
            if (i9 != 1) {
                m7.c.n(androidx.activity.g.m(i9, "Unknown auto-size text type: "));
                return;
            }
            DisplayMetrics displayMetrics = l1Var.f6958j.getResources().getDisplayMetrics();
            l1Var.k(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (l1Var.h()) {
                l1Var.a();
            }
        }
    }

    public final void l(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new o3();
        }
        o3 o3Var = this.h;
        o3Var.f6991a = colorStateList;
        o3Var.f6994d = colorStateList != null;
        this.f6790b = o3Var;
        this.f6791c = o3Var;
        this.f6792d = o3Var;
        this.f6793e = o3Var;
        this.f6794f = o3Var;
        this.f6795g = o3Var;
    }

    public final void m(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new o3();
        }
        o3 o3Var = this.h;
        o3Var.f6992b = mode;
        o3Var.f6993c = mode != null;
        this.f6790b = o3Var;
        this.f6791c = o3Var;
        this.f6792d = o3Var;
        this.f6793e = o3Var;
        this.f6794f = o3Var;
        this.f6795g = o3Var;
    }

    public final void n(Context context, androidx.fragment.app.g gVar) {
        String string;
        int i9 = this.f6797j;
        TypedArray typedArray = (TypedArray) gVar.f729k;
        this.f6797j = typedArray.getInt(2, i9);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            int i11 = typedArray.getInt(11, -1);
            this.f6798k = i11;
            if (i11 != -1) {
                this.f6797j &= 2;
            }
        }
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.f6800m = false;
                int i12 = typedArray.getInt(1, 1);
                if (i12 == 1) {
                    this.f6799l = Typeface.SANS_SERIF;
                    return;
                } else if (i12 == 2) {
                    this.f6799l = Typeface.SERIF;
                    return;
                } else {
                    if (i12 != 3) {
                        return;
                    }
                    this.f6799l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f6799l = null;
        int i13 = typedArray.hasValue(12) ? 12 : 10;
        int i14 = this.f6798k;
        int i15 = this.f6797j;
        if (!context.isRestricted()) {
            try {
                Typeface S = gVar.S(i13, this.f6797j, new v0(this, i14, i15, new WeakReference(this.f6789a)));
                if (S != null) {
                    if (i10 < 28 || this.f6798k == -1) {
                        this.f6799l = S;
                    } else {
                        this.f6799l = a1.a(Typeface.create(S, 0), this.f6798k, (this.f6797j & 2) != 0);
                    }
                }
                this.f6800m = this.f6799l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f6799l != null || (string = typedArray.getString(i13)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f6798k == -1) {
            this.f6799l = Typeface.create(string, this.f6797j);
        } else {
            this.f6799l = a1.a(Typeface.create(string, 0), this.f6798k, (this.f6797j & 2) != 0);
        }
    }
}
