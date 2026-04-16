package w3;

import android.R;
import android.animation.PropertyValuesHolder;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.InflateException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f9845a = {R.attr.name, R.attr.tint, R.attr.height, R.attr.width, R.attr.alpha, R.attr.autoMirrored, R.attr.tintMode, R.attr.viewportWidth, R.attr.viewportHeight};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f9846b = {R.attr.name, R.attr.pivotX, R.attr.pivotY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.translateX, R.attr.translateY};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f9847c = {R.attr.name, R.attr.fillColor, R.attr.pathData, R.attr.strokeColor, R.attr.strokeWidth, R.attr.trimPathStart, R.attr.trimPathEnd, R.attr.trimPathOffset, R.attr.strokeLineCap, R.attr.strokeLineJoin, R.attr.strokeMiterLimit, R.attr.strokeAlpha, R.attr.fillAlpha, R.attr.fillType};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f9848d = {R.attr.name, R.attr.pathData, R.attr.fillType};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f9849e = {R.attr.drawable};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f9850f = {R.attr.name, R.attr.animation};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f9851g = {R.attr.interpolator, R.attr.duration, R.attr.startOffset, R.attr.repeatCount, R.attr.repeatMode, R.attr.valueFrom, R.attr.valueTo, R.attr.valueType};
    public static final int[] h = {R.attr.ordering};

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f9852i = {R.attr.valueFrom, R.attr.valueTo, R.attr.valueType, R.attr.propertyName};

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f9853j = {R.attr.value, R.attr.interpolator, R.attr.valueType, R.attr.fraction};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f9854k = {R.attr.propertyName, R.attr.pathData, R.attr.propertyXName, R.attr.propertyYName};

    /* JADX WARN: Code restructure failed: missing block: B:10:0x038f, code lost:
    
        r2 = new android.animation.Animator[r10.size()];
        r3 = r10.size();
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x039a, code lost:
    
        if (r1 >= r3) goto L221;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x039c, code lost:
    
        r4 = r10.get(r1);
        r1 = r1 + 1;
        r2[r11] = (android.animation.Animator) r4;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x03aa, code lost:
    
        if (r32 != 0) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x03ac, code lost:
    
        r31.playTogether(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x03af, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x03b0, code lost:
    
        r31.playSequentially(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x03b3, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x038b, code lost:
    
        if (r31 == null) goto L213;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x038d, code lost:
    
        if (r10 == null) goto L213;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0370 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0374  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.animation.Animator a(android.content.Context r26, android.content.res.Resources r27, android.content.res.Resources.Theme r28, org.xmlpull.v1.XmlPullParser r29, android.util.AttributeSet r30, android.animation.AnimatorSet r31, int r32) {
        /*
            Method dump skipped, instructions count: 948
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.a.a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int):android.animation.Animator");
    }

    public static PropertyValuesHolder b(TypedArray typedArray, int i9, int i10, int i11, String str) {
        PropertyValuesHolder ofFloat;
        TypedValue peekValue = typedArray.peekValue(i10);
        boolean z8 = peekValue != null;
        int i12 = z8 ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i11);
        boolean z9 = peekValue2 != null;
        int i13 = z9 ? peekValue2.type : 0;
        if (i9 == 4) {
            i9 = ((z8 && c(i12)) || (z9 && c(i13))) ? 3 : 0;
        }
        boolean z10 = i9 == 0;
        PropertyValuesHolder propertyValuesHolder = null;
        if (i9 == 2) {
            String string = typedArray.getString(i10);
            String string2 = typedArray.getString(i11);
            f0.f[] m9 = a.a.m(string);
            f0.f[] m10 = a.a.m(string2);
            if (m9 != null || m10 != null) {
                if (m9 != null) {
                    e eVar = new e();
                    if (m10 == null) {
                        return PropertyValuesHolder.ofObject(str, eVar, m9);
                    }
                    if (a.a.e(m9, m10)) {
                        return PropertyValuesHolder.ofObject(str, eVar, m9, m10);
                    }
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                if (m10 != null) {
                    return PropertyValuesHolder.ofObject(str, new e(), m10);
                }
            }
            return null;
        }
        f fVar = i9 == 3 ? f.f9867a : null;
        if (z10) {
            if (z8) {
                float dimension = i12 == 5 ? typedArray.getDimension(i10, 0.0f) : typedArray.getFloat(i10, 0.0f);
                if (z9) {
                    ofFloat = PropertyValuesHolder.ofFloat(str, dimension, i13 == 5 ? typedArray.getDimension(i11, 0.0f) : typedArray.getFloat(i11, 0.0f));
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, dimension);
                }
            } else {
                ofFloat = PropertyValuesHolder.ofFloat(str, i13 == 5 ? typedArray.getDimension(i11, 0.0f) : typedArray.getFloat(i11, 0.0f));
            }
            propertyValuesHolder = ofFloat;
        } else if (z8) {
            int dimension2 = i12 == 5 ? (int) typedArray.getDimension(i10, 0.0f) : c(i12) ? typedArray.getColor(i10, 0) : typedArray.getInt(i10, 0);
            if (z9) {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, dimension2, i13 == 5 ? (int) typedArray.getDimension(i11, 0.0f) : c(i13) ? typedArray.getColor(i11, 0) : typedArray.getInt(i11, 0));
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, dimension2);
            }
        } else if (z9) {
            propertyValuesHolder = PropertyValuesHolder.ofInt(str, i13 == 5 ? (int) typedArray.getDimension(i11, 0.0f) : c(i13) ? typedArray.getColor(i11, 0) : typedArray.getInt(i11, 0));
        }
        if (propertyValuesHolder != null && fVar != null) {
            propertyValuesHolder.setEvaluator(fVar);
        }
        return propertyValuesHolder;
    }

    public static boolean c(int i9) {
        return i9 >= 28 && i9 <= 31;
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.animation.ValueAnimator d(android.content.Context r20, android.content.res.Resources r21, android.content.res.Resources.Theme r22, android.util.AttributeSet r23, android.animation.ObjectAnimator r24, org.xmlpull.v1.XmlPullParser r25) {
        /*
            Method dump skipped, instructions count: 527
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.a.d(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, android.util.AttributeSet, android.animation.ObjectAnimator, org.xmlpull.v1.XmlPullParser):android.animation.ValueAnimator");
    }
}
