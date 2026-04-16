package y;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h {

    /* renamed from: e, reason: collision with root package name */
    public static final SparseIntArray f10311e;

    /* renamed from: a, reason: collision with root package name */
    public int f10312a;

    /* renamed from: b, reason: collision with root package name */
    public int f10313b;

    /* renamed from: c, reason: collision with root package name */
    public float f10314c;

    /* renamed from: d, reason: collision with root package name */
    public float f10315d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f10311e = sparseIntArray;
        sparseIntArray.append(2, 1);
        sparseIntArray.append(4, 2);
        sparseIntArray.append(5, 3);
        sparseIntArray.append(1, 4);
        sparseIntArray.append(0, 5);
        sparseIntArray.append(3, 6);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f10341e);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i9 = 0; i9 < indexCount; i9++) {
            int index = obtainStyledAttributes.getIndex(i9);
            switch (f10311e.get(index)) {
                case 1:
                    this.f10315d = obtainStyledAttributes.getFloat(index, this.f10315d);
                    break;
                case 2:
                    this.f10313b = obtainStyledAttributes.getInt(index, this.f10313b);
                    break;
                case 3:
                    if (obtainStyledAttributes.peekValue(index).type == 3) {
                        obtainStyledAttributes.getString(index);
                        break;
                    } else {
                        String str = u.a.f8989a[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    }
                case 4:
                    obtainStyledAttributes.getInt(index, 0);
                    break;
                case 5:
                    this.f10312a = k.f(obtainStyledAttributes, index, this.f10312a);
                    break;
                case 6:
                    this.f10314c = obtainStyledAttributes.getFloat(index, this.f10314c);
                    break;
            }
        }
        obtainStyledAttributes.recycle();
    }
}
