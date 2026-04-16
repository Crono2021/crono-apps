package l1;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6032a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6033b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f6034c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f6035d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f6036e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f6037f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f6038g;
    public final Object h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f6039i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f6040j;

    /* renamed from: k, reason: collision with root package name */
    public Object f6041k;

    /* renamed from: l, reason: collision with root package name */
    public Object f6042l;

    public v0() {
        this.f6033b = new u5.s[4];
        this.f6034c = new Matrix[4];
        this.f6035d = new Matrix[4];
        this.f6036e = new PointF();
        this.f6037f = new Path();
        this.f6038g = new Path();
        this.h = new u5.s();
        this.f6039i = new float[2];
        this.f6040j = new float[2];
        this.f6041k = new Path();
        this.f6042l = new Path();
        this.f6032a = true;
        for (int i9 = 0; i9 < 4; i9++) {
            ((u5.s[]) this.f6033b)[i9] = new u5.s();
            ((Matrix[]) this.f6034c)[i9] = new Matrix();
            ((Matrix[]) this.f6035d)[i9] = new Matrix();
        }
    }

    public d1.y0 a(int i9, ArrayList arrayList, v1.y0 y0Var) {
        ArrayList arrayList2 = (ArrayList) this.f6034c;
        if (!arrayList.isEmpty()) {
            this.f6041k = y0Var;
            for (int i10 = i9; i10 < arrayList.size() + i9; i10++) {
                u0 u0Var = (u0) arrayList.get(i10 - i9);
                if (i10 > 0) {
                    u0 u0Var2 = (u0) arrayList2.get(i10 - 1);
                    u0Var.f6028d = u0Var2.f6025a.f9407o.f9357b.o() + u0Var2.f6028d;
                    u0Var.f6029e = false;
                    u0Var.f6027c.clear();
                } else {
                    u0Var.f6028d = 0;
                    u0Var.f6029e = false;
                    u0Var.f6027c.clear();
                }
                int o8 = u0Var.f6025a.f9407o.f9357b.o();
                for (int i11 = i10; i11 < arrayList2.size(); i11++) {
                    ((u0) arrayList2.get(i11)).f6028d += o8;
                }
                arrayList2.add(i10, u0Var);
                ((HashMap) this.f6036e).put(u0Var.f6026b, u0Var);
                if (this.f6032a) {
                    g(u0Var);
                    if (((IdentityHashMap) this.f6035d).isEmpty()) {
                        ((HashSet) this.h).add(u0Var);
                    } else {
                        t0 t0Var = (t0) ((HashMap) this.f6037f).get(u0Var);
                        if (t0Var != null) {
                            t0Var.f6021a.b(t0Var.f6022b);
                        }
                    }
                }
            }
        }
        return c();
    }

    public void b(u5.j jVar, float f9, RectF rectF, i7.x xVar, Path path) {
        int i9;
        char c9;
        float f10;
        i7.x xVar2;
        i7.x xVar3 = xVar;
        Matrix[] matrixArr = (Matrix[]) this.f6035d;
        float[] fArr = (float[]) this.f6039i;
        u5.s[] sVarArr = (u5.s[]) this.f6033b;
        Matrix[] matrixArr2 = (Matrix[]) this.f6034c;
        path.rewind();
        Path path2 = (Path) this.f6037f;
        path2.rewind();
        Path path3 = (Path) this.f6038g;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        int i10 = 0;
        while (true) {
            i9 = 4;
            c9 = 0;
            if (i10 >= 4) {
                break;
            }
            PointF pointF = (PointF) this.f6036e;
            u5.c cVar = i10 != 1 ? i10 != 2 ? i10 != 3 ? jVar.f9108f : jVar.f9107e : jVar.h : jVar.f9109g;
            com.bumptech.glide.c cVar2 = i10 != 1 ? i10 != 2 ? i10 != 3 ? jVar.f9104b : jVar.f9103a : jVar.f9106d : jVar.f9105c;
            u5.s sVar = sVarArr[i10];
            cVar2.getClass();
            Matrix[] matrixArr3 = matrixArr;
            cVar2.w(sVar, f9, cVar.a(rectF));
            int i11 = i10 + 1;
            float f11 = (i11 % 4) * 90;
            matrixArr2[i10].reset();
            if (i10 == 1) {
                pointF.set(rectF.right, rectF.bottom);
            } else if (i10 == 2) {
                pointF.set(rectF.left, rectF.bottom);
            } else if (i10 != 3) {
                pointF.set(rectF.right, rectF.top);
            } else {
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i10].setTranslate(pointF.x, pointF.y);
            matrixArr2[i10].preRotate(f11);
            u5.s sVar2 = sVarArr[i10];
            fArr[0] = sVar2.f9133b;
            fArr[1] = sVar2.f9134c;
            matrixArr2[i10].mapPoints(fArr);
            matrixArr3[i10].reset();
            matrixArr3[i10].setTranslate(fArr[0], fArr[1]);
            matrixArr3[i10].preRotate(f11);
            i10 = i11;
            matrixArr = matrixArr3;
        }
        Matrix[] matrixArr4 = matrixArr;
        int i12 = 0;
        while (i12 < i9) {
            u5.s sVar3 = sVarArr[i12];
            sVar3.getClass();
            fArr[c9] = 0.0f;
            fArr[1] = sVar3.f9132a;
            matrixArr2[i12].mapPoints(fArr);
            if (i12 == 0) {
                path.moveTo(fArr[c9], fArr[1]);
            } else {
                path.lineTo(fArr[c9], fArr[1]);
            }
            sVarArr[i12].b(matrixArr2[i12], path);
            if (xVar3 != null) {
                u5.s sVar4 = sVarArr[i12];
                Matrix matrix = matrixArr2[i12];
                u5.g gVar = (u5.g) xVar3.f5179j;
                BitSet bitSet = gVar.f9087l;
                sVar4.getClass();
                f10 = 0.0f;
                bitSet.set(i12, false);
                u5.r[] rVarArr = gVar.f9085j;
                sVar4.a(sVar4.f9136e);
                rVarArr[i12] = new u5.l(new ArrayList(sVar4.f9138g), new Matrix(matrix));
            } else {
                f10 = 0.0f;
            }
            Path path4 = (Path) this.f6041k;
            u5.s sVar5 = (u5.s) this.h;
            int i13 = i12 + 1;
            int i14 = i13 % 4;
            u5.s sVar6 = sVarArr[i12];
            fArr[0] = sVar6.f9133b;
            fArr[1] = sVar6.f9134c;
            matrixArr2[i12].mapPoints(fArr);
            float[] fArr2 = (float[]) this.f6040j;
            u5.s sVar7 = sVarArr[i14];
            sVar7.getClass();
            fArr2[0] = f10;
            fArr2[1] = sVar7.f9132a;
            matrixArr2[i14].mapPoints(fArr2);
            u5.s[] sVarArr2 = sVarArr;
            Matrix[] matrixArr5 = matrixArr2;
            float max = Math.max(((float) Math.hypot(fArr[0] - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
            u5.s sVar8 = sVarArr2[i12];
            fArr[0] = sVar8.f9133b;
            fArr[1] = sVar8.f9134c;
            matrixArr5[i12].mapPoints(fArr);
            if (i12 == 1 || i12 == 3) {
                Math.abs(rectF.centerX() - fArr[0]);
            } else {
                Math.abs(rectF.centerY() - fArr[1]);
            }
            sVar5.d(0.0f, 270.0f, 0.0f);
            (i12 != 1 ? i12 != 2 ? i12 != 3 ? jVar.f9111j : jVar.f9110i : jVar.f9113l : jVar.f9112k).getClass();
            sVar5.c(max, 0.0f);
            path4.reset();
            sVar5.b(matrixArr4[i12], path4);
            if (this.f6032a && (f(path4, i12) || f(path4, i14))) {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr[0] = 0.0f;
                fArr[1] = sVar5.f9132a;
                matrixArr4[i12].mapPoints(fArr);
                path2.moveTo(fArr[0], fArr[1]);
                sVar5.b(matrixArr4[i12], path2);
            } else {
                sVar5.b(matrixArr4[i12], path);
            }
            if (xVar != null) {
                Matrix matrix2 = matrixArr4[i12];
                xVar2 = xVar;
                u5.g gVar2 = (u5.g) xVar2.f5179j;
                gVar2.f9087l.set(i12 + 4, false);
                u5.r[] rVarArr2 = gVar2.f9086k;
                sVar5.a(sVar5.f9136e);
                rVarArr2[i12] = new u5.l(new ArrayList(sVar5.f9138g), new Matrix(matrix2));
            } else {
                xVar2 = xVar;
            }
            xVar3 = xVar2;
            i12 = i13;
            sVarArr = sVarArr2;
            matrixArr2 = matrixArr5;
            i9 = 4;
            c9 = 0;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    public d1.y0 c() {
        ArrayList arrayList = (ArrayList) this.f6034c;
        if (arrayList.isEmpty()) {
            return d1.y0.f2610a;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            u0 u0Var = (u0) arrayList.get(i10);
            u0Var.f6028d = i9;
            i9 += u0Var.f6025a.f9407o.f9357b.o();
        }
        return new a1(arrayList, (v1.y0) this.f6041k);
    }

    public void d() {
        Iterator it = ((HashSet) this.h).iterator();
        while (it.hasNext()) {
            u0 u0Var = (u0) it.next();
            if (u0Var.f6027c.isEmpty()) {
                t0 t0Var = (t0) ((HashMap) this.f6037f).get(u0Var);
                if (t0Var != null) {
                    t0Var.f6021a.b(t0Var.f6022b);
                }
                it.remove();
            }
        }
    }

    public void e(u0 u0Var) {
        if (u0Var.f6029e && u0Var.f6027c.isEmpty()) {
            t0 t0Var = (t0) ((HashMap) this.f6037f).remove(u0Var);
            t0Var.getClass();
            a5.d dVar = t0Var.f6023c;
            v1.a aVar = t0Var.f6021a;
            aVar.n(t0Var.f6022b);
            aVar.q(dVar);
            aVar.p(dVar);
            ((HashSet) this.h).remove(u0Var);
        }
    }

    public boolean f(Path path, int i9) {
        Path path2 = (Path) this.f6042l;
        path2.reset();
        ((u5.s[]) this.f6033b)[i9].b(((Matrix[]) this.f6034c)[i9], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [l1.p0, v1.a0] */
    public void g(u0 u0Var) {
        v1.u uVar = u0Var.f6025a;
        ?? r12 = new v1.a0() { // from class: l1.p0
            @Override // v1.a0
            public final void a(v1.a aVar, d1.y0 y0Var) {
                ((h0) v0.this.f6038g).f5900p.d(22);
            }
        };
        a5.d dVar = new a5.d(this, u0Var, 29, false);
        ((HashMap) this.f6037f).put(u0Var, new t0(uVar, r12, dVar));
        int i9 = g1.w.f3713a;
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        Handler handler = new Handler(myLooper, null);
        uVar.getClass();
        o1.d dVar2 = uVar.f9235c;
        dVar2.getClass();
        CopyOnWriteArrayList copyOnWriteArrayList = dVar2.f7571c;
        v1.c0 c0Var = new v1.c0();
        c0Var.f9253a = handler;
        c0Var.f9254b = dVar;
        copyOnWriteArrayList.add(c0Var);
        Looper myLooper2 = Looper.myLooper();
        if (myLooper2 == null) {
            myLooper2 = Looper.getMainLooper();
        }
        new Handler(myLooper2, null);
        o1.d dVar3 = uVar.f9236d;
        dVar3.getClass();
        CopyOnWriteArrayList copyOnWriteArrayList2 = dVar3.f7571c;
        o1.c cVar = new o1.c();
        cVar.f7568a = dVar;
        copyOnWriteArrayList2.add(cVar);
        uVar.j(r12, (z1.f) this.f6042l, (m1.x) this.f6033b);
    }

    public void h(v1.x xVar) {
        IdentityHashMap identityHashMap = (IdentityHashMap) this.f6035d;
        u0 u0Var = (u0) identityHashMap.remove(xVar);
        u0Var.getClass();
        u0Var.f6025a.m(xVar);
        u0Var.f6027c.remove(((v1.r) xVar).f9384i);
        if (!identityHashMap.isEmpty()) {
            d();
        }
        e(u0Var);
    }

    public void i(int i9, int i10) {
        ArrayList arrayList = (ArrayList) this.f6034c;
        for (int i11 = i10 - 1; i11 >= i9; i11--) {
            u0 u0Var = (u0) arrayList.remove(i11);
            ((HashMap) this.f6036e).remove(u0Var.f6026b);
            int i12 = -u0Var.f6025a.f9407o.f9357b.o();
            for (int i13 = i11; i13 < arrayList.size(); i13++) {
                ((u0) arrayList.get(i13)).f6028d += i12;
            }
            u0Var.f6029e = true;
            if (this.f6032a) {
                e(u0Var);
            }
        }
    }

    public v0(h0 h0Var, m1.q qVar, g1.t tVar, m1.x xVar) {
        this.f6033b = xVar;
        this.f6038g = h0Var;
        this.f6041k = new v1.y0();
        this.f6035d = new IdentityHashMap();
        this.f6036e = new HashMap();
        this.f6034c = new ArrayList();
        this.f6039i = qVar;
        this.f6040j = tVar;
        this.f6037f = new HashMap();
        this.h = new HashSet();
    }
}
