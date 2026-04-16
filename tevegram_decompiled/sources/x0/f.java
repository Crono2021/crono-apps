package x0;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f extends com.bumptech.glide.c {

    /* renamed from: p, reason: collision with root package name */
    public final TextView f10031p;

    /* renamed from: q, reason: collision with root package name */
    public final d f10032q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f10033r = true;

    public f(TextView textView) {
        this.f10031p = textView;
        this.f10032q = new d(textView);
    }

    @Override // com.bumptech.glide.c
    public final boolean E() {
        return this.f10033r;
    }

    @Override // com.bumptech.glide.c
    public final void T(boolean z8) {
        if (z8) {
            TextView textView = this.f10031p;
            textView.setTransformationMethod(Y(textView.getTransformationMethod()));
        }
    }

    @Override // com.bumptech.glide.c
    public final void U(boolean z8) {
        this.f10033r = z8;
        TextView textView = this.f10031p;
        textView.setTransformationMethod(Y(textView.getTransformationMethod()));
        textView.setFilters(y(textView.getFilters()));
    }

    @Override // com.bumptech.glide.c
    public final TransformationMethod Y(TransformationMethod transformationMethod) {
        return this.f10033r ? transformationMethod instanceof i ? transformationMethod : transformationMethod instanceof PasswordTransformationMethod ? transformationMethod : new i(transformationMethod) : transformationMethod instanceof i ? ((i) transformationMethod).f10038i : transformationMethod;
    }

    @Override // com.bumptech.glide.c
    public final InputFilter[] y(InputFilter[] inputFilterArr) {
        if (!this.f10033r) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i9 = 0; i9 < inputFilterArr.length; i9++) {
                InputFilter inputFilter = inputFilterArr[i9];
                if (inputFilter instanceof d) {
                    sparseArray.put(i9, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                if (sparseArray.indexOfKey(i11) < 0) {
                    inputFilterArr2[i10] = inputFilterArr[i11];
                    i10++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i12 = 0;
        while (true) {
            d dVar = this.f10032q;
            if (i12 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = dVar;
                return inputFilterArr3;
            }
            if (inputFilterArr[i12] == dVar) {
                return inputFilterArr;
            }
            i12++;
        }
    }
}
