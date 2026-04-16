package w3;

import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j extends k {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f9879a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f9880b;

    /* renamed from: c, reason: collision with root package name */
    public float f9881c;

    /* renamed from: d, reason: collision with root package name */
    public float f9882d;

    /* renamed from: e, reason: collision with root package name */
    public float f9883e;

    /* renamed from: f, reason: collision with root package name */
    public float f9884f;

    /* renamed from: g, reason: collision with root package name */
    public float f9885g;
    public float h;

    /* renamed from: i, reason: collision with root package name */
    public float f9886i;

    /* renamed from: j, reason: collision with root package name */
    public final Matrix f9887j;

    /* renamed from: k, reason: collision with root package name */
    public String f9888k;

    /* JADX WARN: Multi-variable type inference failed */
    public j(j jVar, s.d dVar) {
        h hVar;
        this.f9879a = new Matrix();
        this.f9880b = new ArrayList();
        this.f9881c = 0.0f;
        this.f9882d = 0.0f;
        this.f9883e = 0.0f;
        this.f9884f = 1.0f;
        this.f9885g = 1.0f;
        this.h = 0.0f;
        this.f9886i = 0.0f;
        Matrix matrix = new Matrix();
        this.f9887j = matrix;
        this.f9888k = null;
        this.f9881c = jVar.f9881c;
        this.f9882d = jVar.f9882d;
        this.f9883e = jVar.f9883e;
        this.f9884f = jVar.f9884f;
        this.f9885g = jVar.f9885g;
        this.h = jVar.h;
        this.f9886i = jVar.f9886i;
        String str = jVar.f9888k;
        this.f9888k = str;
        if (str != null) {
            dVar.put(str, this);
        }
        matrix.set(jVar.f9887j);
        ArrayList arrayList = jVar.f9880b;
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            Object obj = arrayList.get(i9);
            if (obj instanceof j) {
                this.f9880b.add(new j((j) obj, dVar));
            } else {
                if (obj instanceof i) {
                    i iVar = (i) obj;
                    i iVar2 = new i(iVar);
                    iVar2.f9870e = 0.0f;
                    iVar2.f9872g = 1.0f;
                    iVar2.h = 1.0f;
                    iVar2.f9873i = 0.0f;
                    iVar2.f9874j = 1.0f;
                    iVar2.f9875k = 0.0f;
                    iVar2.f9876l = Paint.Cap.BUTT;
                    iVar2.f9877m = Paint.Join.MITER;
                    iVar2.f9878n = 4.0f;
                    iVar2.f9869d = iVar.f9869d;
                    iVar2.f9870e = iVar.f9870e;
                    iVar2.f9872g = iVar.f9872g;
                    iVar2.f9871f = iVar.f9871f;
                    iVar2.f9891c = iVar.f9891c;
                    iVar2.h = iVar.h;
                    iVar2.f9873i = iVar.f9873i;
                    iVar2.f9874j = iVar.f9874j;
                    iVar2.f9875k = iVar.f9875k;
                    iVar2.f9876l = iVar.f9876l;
                    iVar2.f9877m = iVar.f9877m;
                    iVar2.f9878n = iVar.f9878n;
                    hVar = iVar2;
                } else {
                    if (!(obj instanceof h)) {
                        m7.c.p("Unknown object in the tree!");
                        throw null;
                    }
                    hVar = new h((h) obj);
                }
                this.f9880b.add(hVar);
                Object obj2 = hVar.f9890b;
                if (obj2 != null) {
                    dVar.put(obj2, hVar);
                }
            }
        }
    }

    @Override // w3.k
    public final boolean a() {
        int i9 = 0;
        while (true) {
            ArrayList arrayList = this.f9880b;
            if (i9 >= arrayList.size()) {
                return false;
            }
            if (((k) arrayList.get(i9)).a()) {
                return true;
            }
            i9++;
        }
    }

    @Override // w3.k
    public final boolean b(int[] iArr) {
        int i9 = 0;
        boolean z8 = false;
        while (true) {
            ArrayList arrayList = this.f9880b;
            if (i9 >= arrayList.size()) {
                return z8;
            }
            z8 |= ((k) arrayList.get(i9)).b(iArr);
            i9++;
        }
    }

    public final void c() {
        Matrix matrix = this.f9887j;
        matrix.reset();
        matrix.postTranslate(-this.f9882d, -this.f9883e);
        matrix.postScale(this.f9884f, this.f9885g);
        matrix.postRotate(this.f9881c, 0.0f, 0.0f);
        matrix.postTranslate(this.h + this.f9882d, this.f9886i + this.f9883e);
    }

    public String getGroupName() {
        return this.f9888k;
    }

    public Matrix getLocalMatrix() {
        return this.f9887j;
    }

    public float getPivotX() {
        return this.f9882d;
    }

    public float getPivotY() {
        return this.f9883e;
    }

    public float getRotation() {
        return this.f9881c;
    }

    public float getScaleX() {
        return this.f9884f;
    }

    public float getScaleY() {
        return this.f9885g;
    }

    public float getTranslateX() {
        return this.h;
    }

    public float getTranslateY() {
        return this.f9886i;
    }

    public void setPivotX(float f9) {
        if (f9 != this.f9882d) {
            this.f9882d = f9;
            c();
        }
    }

    public void setPivotY(float f9) {
        if (f9 != this.f9883e) {
            this.f9883e = f9;
            c();
        }
    }

    public void setRotation(float f9) {
        if (f9 != this.f9881c) {
            this.f9881c = f9;
            c();
        }
    }

    public void setScaleX(float f9) {
        if (f9 != this.f9884f) {
            this.f9884f = f9;
            c();
        }
    }

    public void setScaleY(float f9) {
        if (f9 != this.f9885g) {
            this.f9885g = f9;
            c();
        }
    }

    public void setTranslateX(float f9) {
        if (f9 != this.h) {
            this.h = f9;
            c();
        }
    }

    public void setTranslateY(float f9) {
        if (f9 != this.f9886i) {
            this.f9886i = f9;
            c();
        }
    }

    public j() {
        this.f9879a = new Matrix();
        this.f9880b = new ArrayList();
        this.f9881c = 0.0f;
        this.f9882d = 0.0f;
        this.f9883e = 0.0f;
        this.f9884f = 1.0f;
        this.f9885g = 1.0f;
        this.h = 0.0f;
        this.f9886i = 0.0f;
        this.f9887j = new Matrix();
        this.f9888k = null;
    }
}
