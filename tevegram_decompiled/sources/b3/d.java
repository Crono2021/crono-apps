package b3;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;
import n0.a2;
import n0.r;
import y.k;
import y.o;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements r {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1285i;

    /* renamed from: j, reason: collision with root package name */
    public final int f1286j;

    /* renamed from: k, reason: collision with root package name */
    public final int f1287k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f1288l;

    public d(Context context, XmlResourceParser xmlResourceParser) {
        this.f1285i = 3;
        this.f1288l = new ArrayList();
        this.f1287k = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), o.f10343g);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i9 = 0; i9 < indexCount; i9++) {
            int index = obtainStyledAttributes.getIndex(i9);
            if (index == 0) {
                this.f1286j = obtainStyledAttributes.getResourceId(index, this.f1286j);
            } else if (index == 1) {
                int resourceId = obtainStyledAttributes.getResourceId(index, this.f1287k);
                this.f1287k = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new k().b((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            }
        }
        obtainStyledAttributes.recycle();
    }

    public byte a(int i9, int i10) {
        return ((byte[][]) this.f1288l)[i10][i9];
    }

    public void b(int i9, int i10, int i11) {
        ((byte[][]) this.f1288l)[i10][i9] = (byte) i11;
    }

    @Override // n0.r
    public a2 c(View view, a2 a2Var) {
        View view2 = (View) this.f1288l;
        int i9 = a2Var.f7139a.f(7).f3194b;
        int i10 = this.f1286j;
        if (i10 >= 0) {
            view2.getLayoutParams().height = i10 + i9;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        view2.setPadding(view2.getPaddingLeft(), this.f1287k + i9, view2.getPaddingRight(), view2.getPaddingBottom());
        return a2Var;
    }

    public String toString() {
        switch (this.f1285i) {
            case 4:
                int i9 = this.f1286j;
                int i10 = this.f1287k;
                StringBuilder sb = new StringBuilder((i9 * 2 * i10) + 2);
                for (int i11 = 0; i11 < i10; i11++) {
                    byte[] bArr = ((byte[][]) this.f1288l)[i11];
                    for (int i12 = 0; i12 < i9; i12++) {
                        byte b9 = bArr[i12];
                        if (b9 == 0) {
                            sb.append(" 0");
                        } else if (b9 != 1) {
                            sb.append("  ");
                        } else {
                            sb.append(" 1");
                        }
                    }
                    sb.append('\n');
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public d(int i9, int i10) {
        this.f1285i = 4;
        this.f1288l = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i10, i9);
        this.f1286j = i9;
        this.f1287k = i10;
    }

    public d(int i9, int i10, byte[] bArr) {
        this.f1285i = 2;
        this.f1288l = bArr;
        this.f1286j = i9;
        this.f1287k = i10;
    }

    public d(View view, int i9, int i10) {
        this.f1285i = 1;
        this.f1286j = i9;
        this.f1288l = view;
        this.f1287k = i10;
    }

    public d(int i9, int i10, SparseArray sparseArray) {
        this.f1285i = 0;
        this.f1286j = i9;
        this.f1287k = i10;
        this.f1288l = sparseArray;
    }
}
