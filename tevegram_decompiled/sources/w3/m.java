package w3;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import b6.i0;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m {

    /* renamed from: p, reason: collision with root package name */
    public static final Matrix f9892p = new Matrix();

    /* renamed from: a, reason: collision with root package name */
    public final Path f9893a;

    /* renamed from: b, reason: collision with root package name */
    public final Path f9894b;

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f9895c;

    /* renamed from: d, reason: collision with root package name */
    public Paint f9896d;

    /* renamed from: e, reason: collision with root package name */
    public Paint f9897e;

    /* renamed from: f, reason: collision with root package name */
    public PathMeasure f9898f;

    /* renamed from: g, reason: collision with root package name */
    public final j f9899g;
    public float h;

    /* renamed from: i, reason: collision with root package name */
    public float f9900i;

    /* renamed from: j, reason: collision with root package name */
    public float f9901j;

    /* renamed from: k, reason: collision with root package name */
    public float f9902k;

    /* renamed from: l, reason: collision with root package name */
    public int f9903l;

    /* renamed from: m, reason: collision with root package name */
    public String f9904m;

    /* renamed from: n, reason: collision with root package name */
    public Boolean f9905n;

    /* renamed from: o, reason: collision with root package name */
    public final s.d f9906o;

    public m(m mVar) {
        this.f9895c = new Matrix();
        this.h = 0.0f;
        this.f9900i = 0.0f;
        this.f9901j = 0.0f;
        this.f9902k = 0.0f;
        this.f9903l = 255;
        this.f9904m = null;
        this.f9905n = null;
        s.d dVar = new s.d();
        this.f9906o = dVar;
        this.f9899g = new j(mVar.f9899g, dVar);
        this.f9893a = new Path(mVar.f9893a);
        this.f9894b = new Path(mVar.f9894b);
        this.h = mVar.h;
        this.f9900i = mVar.f9900i;
        this.f9901j = mVar.f9901j;
        this.f9902k = mVar.f9902k;
        this.f9903l = mVar.f9903l;
        this.f9904m = mVar.f9904m;
        String str = mVar.f9904m;
        if (str != null) {
            dVar.put(str, this);
        }
        this.f9905n = mVar.f9905n;
    }

    public final void a(j jVar, Matrix matrix, Canvas canvas, int i9, int i10) {
        int i11;
        float f9;
        int i12;
        float f10;
        Matrix matrix2 = jVar.f9879a;
        ArrayList arrayList = jVar.f9880b;
        matrix2.set(matrix);
        Matrix matrix3 = jVar.f9879a;
        matrix3.preConcat(jVar.f9887j);
        canvas.save();
        char c9 = 0;
        int i13 = 0;
        while (i13 < arrayList.size()) {
            k kVar = (k) arrayList.get(i13);
            if (kVar instanceof j) {
                a((j) kVar, matrix3, canvas, i9, i10);
            } else if (kVar instanceof l) {
                l lVar = (l) kVar;
                float f11 = i9 / this.f9901j;
                float f12 = i10 / this.f9902k;
                float min = Math.min(f11, f12);
                Matrix matrix4 = this.f9895c;
                matrix4.set(matrix3);
                matrix4.postScale(f11, f12);
                float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                matrix3.mapVectors(fArr);
                float hypot = (float) Math.hypot(fArr[c9], fArr[1]);
                i11 = i13;
                float hypot2 = (float) Math.hypot(fArr[2], fArr[3]);
                float f13 = (fArr[0] * fArr[3]) - (fArr[1] * fArr[2]);
                float max = Math.max(hypot, hypot2);
                float abs = max > 0.0f ? Math.abs(f13) / max : 0.0f;
                if (abs != 0.0f) {
                    Path path = this.f9893a;
                    path.reset();
                    f0.f[] fVarArr = lVar.f9889a;
                    if (fVarArr != null) {
                        f0.f.b(fVarArr, path);
                    }
                    Path path2 = this.f9894b;
                    path2.reset();
                    if (lVar instanceof h) {
                        path2.setFillType(lVar.f9891c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                        path2.addPath(path, matrix4);
                        canvas.clipPath(path2);
                    } else {
                        i iVar = (i) lVar;
                        float f14 = iVar.f9873i;
                        if (f14 != 0.0f || iVar.f9874j != 1.0f) {
                            float f15 = iVar.f9875k;
                            float f16 = (f14 + f15) % 1.0f;
                            float f17 = (iVar.f9874j + f15) % 1.0f;
                            if (this.f9898f == null) {
                                this.f9898f = new PathMeasure();
                            }
                            this.f9898f.setPath(path, false);
                            float length = this.f9898f.getLength();
                            float f18 = f16 * length;
                            float f19 = f17 * length;
                            path.reset();
                            PathMeasure pathMeasure = this.f9898f;
                            if (f18 > f19) {
                                pathMeasure.getSegment(f18, length, path, true);
                                f9 = 0.0f;
                                this.f9898f.getSegment(0.0f, f19, path, true);
                            } else {
                                f9 = 0.0f;
                                pathMeasure.getSegment(f18, f19, path, true);
                            }
                            path.rLineTo(f9, f9);
                        }
                        path2.addPath(path, matrix4);
                        i0 i0Var = iVar.f9871f;
                        if (((Shader) i0Var.f1399k) == null && i0Var.f1398j == 0) {
                            i12 = 16777215;
                            f10 = 255.0f;
                        } else {
                            if (this.f9897e == null) {
                                i12 = 16777215;
                                Paint paint = new Paint(1);
                                this.f9897e = paint;
                                paint.setStyle(Paint.Style.FILL);
                            } else {
                                i12 = 16777215;
                            }
                            Paint paint2 = this.f9897e;
                            Shader shader = (Shader) i0Var.f1399k;
                            if (shader != null) {
                                shader.setLocalMatrix(matrix4);
                                paint2.setShader(shader);
                                paint2.setAlpha(Math.round(iVar.h * 255.0f));
                                f10 = 255.0f;
                            } else {
                                paint2.setShader(null);
                                paint2.setAlpha(255);
                                int i14 = i0Var.f1398j;
                                float f20 = iVar.h;
                                PorterDuff.Mode mode = p.f9919r;
                                f10 = 255.0f;
                                paint2.setColor((i14 & i12) | (((int) (Color.alpha(i14) * f20)) << 24));
                            }
                            paint2.setColorFilter(null);
                            path2.setFillType(iVar.f9891c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            canvas.drawPath(path2, paint2);
                        }
                        i0 i0Var2 = iVar.f9869d;
                        if (((Shader) i0Var2.f1399k) != null || i0Var2.f1398j != 0) {
                            if (this.f9896d == null) {
                                Paint paint3 = new Paint(1);
                                this.f9896d = paint3;
                                paint3.setStyle(Paint.Style.STROKE);
                            }
                            Paint paint4 = this.f9896d;
                            Paint.Join join = iVar.f9877m;
                            if (join != null) {
                                paint4.setStrokeJoin(join);
                            }
                            Paint.Cap cap = iVar.f9876l;
                            if (cap != null) {
                                paint4.setStrokeCap(cap);
                            }
                            paint4.setStrokeMiter(iVar.f9878n);
                            Shader shader2 = (Shader) i0Var2.f1399k;
                            if (shader2 != null) {
                                shader2.setLocalMatrix(matrix4);
                                paint4.setShader(shader2);
                                paint4.setAlpha(Math.round(iVar.f9872g * f10));
                            } else {
                                paint4.setShader(null);
                                paint4.setAlpha(255);
                                int i15 = i0Var2.f1398j;
                                float f21 = iVar.f9872g;
                                PorterDuff.Mode mode2 = p.f9919r;
                                paint4.setColor((i15 & i12) | (((int) (Color.alpha(i15) * f21)) << 24));
                            }
                            paint4.setColorFilter(null);
                            paint4.setStrokeWidth(iVar.f9870e * min * abs);
                            canvas.drawPath(path2, paint4);
                        }
                    }
                }
                i13 = i11 + 1;
                c9 = 0;
            }
            i11 = i13;
            i13 = i11 + 1;
            c9 = 0;
        }
        canvas.restore();
    }

    public float getAlpha() {
        return getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.f9903l;
    }

    public void setAlpha(float f9) {
        setRootAlpha((int) (f9 * 255.0f));
    }

    public void setRootAlpha(int i9) {
        this.f9903l = i9;
    }

    public m() {
        this.f9895c = new Matrix();
        this.h = 0.0f;
        this.f9900i = 0.0f;
        this.f9901j = 0.0f;
        this.f9902k = 0.0f;
        this.f9903l = 255;
        this.f9904m = null;
        this.f9905n = null;
        this.f9906o = new s.d();
        this.f9899g = new j();
        this.f9893a = new Path();
        this.f9894b = new Path();
    }
}
