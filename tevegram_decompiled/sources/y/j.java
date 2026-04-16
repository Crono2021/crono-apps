package y;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j {

    /* renamed from: m, reason: collision with root package name */
    public static final SparseIntArray f10320m;

    /* renamed from: a, reason: collision with root package name */
    public float f10321a;

    /* renamed from: b, reason: collision with root package name */
    public float f10322b;

    /* renamed from: c, reason: collision with root package name */
    public float f10323c;

    /* renamed from: d, reason: collision with root package name */
    public float f10324d;

    /* renamed from: e, reason: collision with root package name */
    public float f10325e;

    /* renamed from: f, reason: collision with root package name */
    public float f10326f;

    /* renamed from: g, reason: collision with root package name */
    public float f10327g;
    public float h;

    /* renamed from: i, reason: collision with root package name */
    public float f10328i;

    /* renamed from: j, reason: collision with root package name */
    public float f10329j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10330k;

    /* renamed from: l, reason: collision with root package name */
    public float f10331l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f10320m = sparseIntArray;
        sparseIntArray.append(6, 1);
        sparseIntArray.append(7, 2);
        sparseIntArray.append(8, 3);
        sparseIntArray.append(4, 4);
        sparseIntArray.append(5, 5);
        sparseIntArray.append(0, 6);
        sparseIntArray.append(1, 7);
        sparseIntArray.append(2, 8);
        sparseIntArray.append(3, 9);
        sparseIntArray.append(9, 10);
        sparseIntArray.append(10, 11);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.h);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i9 = 0; i9 < indexCount; i9++) {
            int index = obtainStyledAttributes.getIndex(i9);
            switch (f10320m.get(index)) {
                case 1:
                    this.f10321a = obtainStyledAttributes.getFloat(index, this.f10321a);
                    break;
                case 2:
                    this.f10322b = obtainStyledAttributes.getFloat(index, this.f10322b);
                    break;
                case 3:
                    this.f10323c = obtainStyledAttributes.getFloat(index, this.f10323c);
                    break;
                case 4:
                    this.f10324d = obtainStyledAttributes.getFloat(index, this.f10324d);
                    break;
                case 5:
                    this.f10325e = obtainStyledAttributes.getFloat(index, this.f10325e);
                    break;
                case 6:
                    this.f10326f = obtainStyledAttributes.getDimension(index, this.f10326f);
                    break;
                case 7:
                    this.f10327g = obtainStyledAttributes.getDimension(index, this.f10327g);
                    break;
                case 8:
                    this.h = obtainStyledAttributes.getDimension(index, this.h);
                    break;
                case 9:
                    this.f10328i = obtainStyledAttributes.getDimension(index, this.f10328i);
                    break;
                case 10:
                    this.f10329j = obtainStyledAttributes.getDimension(index, this.f10329j);
                    break;
                case 11:
                    this.f10330k = true;
                    this.f10331l = obtainStyledAttributes.getDimension(index, this.f10331l);
                    break;
            }
        }
        obtainStyledAttributes.recycle();
    }
}
