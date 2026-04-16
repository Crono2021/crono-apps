package n;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l1 {

    /* renamed from: l, reason: collision with root package name */
    public static final RectF f6948l = new RectF();

    /* renamed from: m, reason: collision with root package name */
    public static final ConcurrentHashMap f6949m = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public int f6950a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6951b = false;

    /* renamed from: c, reason: collision with root package name */
    public float f6952c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f6953d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    public float f6954e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    public int[] f6955f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public boolean f6956g = false;
    public TextPaint h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f6957i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f6958j;

    /* renamed from: k, reason: collision with root package name */
    public final k1 f6959k;

    static {
        new ConcurrentHashMap();
    }

    public l1(TextView textView) {
        this.f6957i = textView;
        this.f6958j = textView.getContext();
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 29) {
            this.f6959k = new j1();
        } else if (i9 >= 23) {
            this.f6959k = new i1();
        } else {
            this.f6959k = new k1();
        }
    }

    public static int[] b(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i9 : iArr) {
                if (i9 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i9)) < 0) {
                    arrayList.add(Integer.valueOf(i9));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                int[] iArr2 = new int[size];
                for (int i10 = 0; i10 < size; i10++) {
                    iArr2[i10] = ((Integer) arrayList.get(i10)).intValue();
                }
                return iArr2;
            }
        }
        return iArr;
    }

    public static Method d(String str) {
        try {
            ConcurrentHashMap concurrentHashMap = f6949m;
            Method method = (Method) concurrentHashMap.get(str);
            if (method != null || (method = TextView.class.getDeclaredMethod(str, null)) == null) {
                return method;
            }
            method.setAccessible(true);
            concurrentHashMap.put(str, method);
            return method;
        } catch (Exception e9) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e9);
            return null;
        }
    }

    public static Object e(Object obj, Object obj2, String str) {
        try {
            return d(str).invoke(obj, null);
        } catch (Exception e9) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e9);
            return obj2;
        }
    }

    public final void a() {
        if (f()) {
            if (this.f6951b) {
                if (this.f6957i.getMeasuredHeight() <= 0 || this.f6957i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f6959k.b(this.f6957i) ? 1048576 : (this.f6957i.getMeasuredWidth() - this.f6957i.getTotalPaddingLeft()) - this.f6957i.getTotalPaddingRight();
                int height = (this.f6957i.getHeight() - this.f6957i.getCompoundPaddingBottom()) - this.f6957i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f6948l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float c9 = c(rectF);
                        if (c9 != this.f6957i.getTextSize()) {
                            g(0, c9);
                        }
                    } finally {
                    }
                }
            }
            this.f6951b = true;
        }
    }

    public final int c(RectF rectF) {
        CharSequence transformation;
        int length = this.f6955f.length;
        if (length == 0) {
            m7.c.p("No available text sizes to choose from.");
            return 0;
        }
        int i9 = length - 1;
        int i10 = 1;
        int i11 = 0;
        while (true) {
            int[] iArr = this.f6955f;
            if (i10 > i9) {
                return iArr[i11];
            }
            int i12 = (i10 + i9) / 2;
            int i13 = iArr[i12];
            TextView textView = this.f6957i;
            CharSequence text = textView.getText();
            TransformationMethod transformationMethod = textView.getTransformationMethod();
            CharSequence charSequence = (transformationMethod == null || (transformation = transformationMethod.getTransformation(text, textView)) == null) ? text : transformation;
            int b9 = f1.b(textView);
            TextPaint textPaint = this.h;
            if (textPaint == null) {
                this.h = new TextPaint();
            } else {
                textPaint.reset();
            }
            this.h.set(textView.getPaint());
            this.h.setTextSize(i13);
            Layout.Alignment alignment = (Layout.Alignment) e(textView, Layout.Alignment.ALIGN_NORMAL, "getLayoutAlignment");
            int round = Math.round(rectF.right);
            int i14 = Build.VERSION.SDK_INT;
            TextPaint textPaint2 = this.h;
            TextView textView2 = this.f6957i;
            StaticLayout a9 = i14 >= 23 ? h1.a(charSequence, alignment, round, b9, textView2, textPaint2, this.f6959k) : f1.a(charSequence, alignment, round, textView2, textPaint2);
            if ((b9 == -1 || (a9.getLineCount() <= b9 && a9.getLineEnd(a9.getLineCount() - 1) == charSequence.length())) && a9.getHeight() <= rectF.bottom) {
                int i15 = i12 + 1;
                i11 = i10;
                i10 = i15;
            } else {
                i11 = i12 - 1;
                i9 = i11;
            }
        }
    }

    public final boolean f() {
        return j() && this.f6950a != 0;
    }

    public final void g(int i9, float f9) {
        Context context = this.f6958j;
        float applyDimension = TypedValue.applyDimension(i9, f9, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        TextView textView = this.f6957i;
        if (applyDimension != textView.getPaint().getTextSize()) {
            textView.getPaint().setTextSize(applyDimension);
            boolean a9 = g1.a(textView);
            if (textView.getLayout() != null) {
                this.f6951b = false;
                try {
                    Method d9 = d("nullLayouts");
                    if (d9 != null) {
                        d9.invoke(textView, null);
                    }
                } catch (Exception e9) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e9);
                }
                if (a9) {
                    textView.forceLayout();
                } else {
                    textView.requestLayout();
                }
                textView.invalidate();
            }
        }
    }

    public final boolean h() {
        if (j() && this.f6950a == 1) {
            if (!this.f6956g || this.f6955f.length == 0) {
                int floor = ((int) Math.floor((this.f6954e - this.f6953d) / this.f6952c)) + 1;
                int[] iArr = new int[floor];
                for (int i9 = 0; i9 < floor; i9++) {
                    iArr[i9] = Math.round((i9 * this.f6952c) + this.f6953d);
                }
                this.f6955f = b(iArr);
            }
            this.f6951b = true;
        } else {
            this.f6951b = false;
        }
        return this.f6951b;
    }

    public final boolean i() {
        boolean z8 = this.f6955f.length > 0;
        this.f6956g = z8;
        if (z8) {
            this.f6950a = 1;
            this.f6953d = r0[0];
            this.f6954e = r0[r1 - 1];
            this.f6952c = -1.0f;
        }
        return z8;
    }

    public final boolean j() {
        return !(this.f6957i instanceof v);
    }

    public final void k(float f9, float f10, float f11) {
        if (f9 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f9 + "px) is less or equal to (0px)");
        }
        if (f10 <= f9) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f10 + "px) is less or equal to minimum auto-size text size (" + f9 + "px)");
        }
        if (f11 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f11 + "px) is less or equal to (0px)");
        }
        this.f6950a = 1;
        this.f6953d = f9;
        this.f6954e = f10;
        this.f6952c = f11;
        this.f6956g = false;
    }
}
