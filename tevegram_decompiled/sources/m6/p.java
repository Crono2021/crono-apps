package m6;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import b6.b1;
import b6.e0;
import b6.g0;
import b6.i0;
import d1.t0;
import d1.y0;
import g1.w;
import java.io.Serializable;
import n.m3;
import n.r1;
import n.t2;
import r6.q1;
import r6.w0;
import v1.z;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6676a;

    /* renamed from: b, reason: collision with root package name */
    public Object f6677b;

    /* renamed from: c, reason: collision with root package name */
    public Serializable f6678c;

    /* renamed from: d, reason: collision with root package name */
    public Object f6679d;

    /* renamed from: e, reason: collision with root package name */
    public Object f6680e;

    /* renamed from: f, reason: collision with root package name */
    public Object f6681f;

    /* JADX WARN: Type inference failed for: r0v3, types: [int[], java.io.Serializable] */
    public p() {
        this.f6676a = new int[]{2131230836, 2131230834, 2131230760};
        this.f6677b = new int[]{2131230784, 2131230819, 2131230791, 2131230786, 2131230787, 2131230790, 2131230789};
        this.f6678c = new int[]{2131230833, 2131230835, 2131230777, 2131230829, 2131230830, 2131230831, 2131230832};
        this.f6679d = new int[]{2131230809, 2131230775, 2131230808};
        this.f6680e = new int[]{2131230827, 2131230837};
        this.f6681f = new int[]{2131230763, 2131230769, 2131230764, 2131230770};
    }

    public static boolean b(int[] iArr, int i9) {
        for (int i10 : iArr) {
            if (i10 == i9) {
                return true;
            }
        }
        return false;
    }

    public static p c(String str, com.google.crypto.tink.shaded.protobuf.j jVar, w0 w0Var, q1 q1Var, Integer num) {
        if (q1Var == q1.RAW) {
            if (num != null) {
                androidx.fragment.app.a.o("Keys with output prefix type raw should not have an id requirement.");
                return null;
            }
        } else if (num == null) {
            androidx.fragment.app.a.o("Keys with output prefix type different from raw should have an id requirement.");
            return null;
        }
        return new p(str, jVar, w0Var, q1Var, num);
    }

    public static ColorStateList d(Context context, int i9) {
        int c9 = m3.c(context, 2130968808);
        return new ColorStateList(new int[][]{m3.f6970b, m3.f6972d, m3.f6971c, m3.f6974f}, new int[]{m3.b(context, 2130968805), f0.a.b(c9, i9), f0.a.b(c9, i9), i9});
    }

    public static z e(t0 t0Var, g0 g0Var, z zVar, d1.w0 w0Var) {
        y0 U = t0Var.U();
        int A = t0Var.A();
        Object l4 = U.p() ? null : U.l(A);
        int b9 = (t0Var.h() || U.p()) ? -1 : U.f(A, w0Var, false).b(w.M(t0Var.getCurrentPosition()) - w0Var.f2588e);
        for (int i9 = 0; i9 < g0Var.size(); i9++) {
            z zVar2 = (z) g0Var.get(i9);
            if (h(zVar2, l4, t0Var.h(), t0Var.H(), t0Var.N(), b9)) {
                return zVar2;
            }
        }
        if (g0Var.isEmpty() && zVar != null && h(zVar, l4, t0Var.h(), t0Var.H(), t0Var.N(), b9)) {
            return zVar;
        }
        return null;
    }

    public static LayerDrawable f(t2 t2Var, Context context, int i9) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i9);
        Drawable f9 = t2Var.f(context, 2131230823);
        Drawable f10 = t2Var.f(context, 2131230824);
        if ((f9 instanceof BitmapDrawable) && f9.getIntrinsicWidth() == dimensionPixelSize && f9.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) f9;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            f9.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            f9.draw(canvas);
            bitmapDrawable = new BitmapDrawable(createBitmap);
            bitmapDrawable2 = new BitmapDrawable(createBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((f10 instanceof BitmapDrawable) && f10.getIntrinsicWidth() == dimensionPixelSize && f10.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) f10;
        } else {
            Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            f10.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            f10.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(createBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.secondaryProgress);
        layerDrawable.setId(2, R.id.progress);
        return layerDrawable;
    }

    public static boolean h(z zVar, Object obj, boolean z8, int i9, int i10, int i11) {
        Object obj2 = zVar.f9447a;
        int i12 = zVar.f9448b;
        if (!obj2.equals(obj)) {
            return false;
        }
        if (z8 && i12 == i9 && zVar.f9449c == i10) {
            return true;
        }
        return !z8 && i12 == -1 && zVar.f9451e == i11;
    }

    public static void i(Drawable drawable, int i9, PorterDuff.Mode mode) {
        int[] iArr = r1.f7021a;
        Drawable mutate = drawable.mutate();
        if (mode == null) {
            mode = n.t.f7032b;
        }
        mutate.setColorFilter(n.t.c(i9, mode));
    }

    public void a(i0 i0Var, z zVar, y0 y0Var) {
        if (zVar == null) {
            return;
        }
        if (y0Var.b(zVar.f9447a) != -1) {
            i0Var.g(zVar, y0Var);
            return;
        }
        y0 y0Var2 = (y0) ((b1) this.f6678c).get(zVar);
        if (y0Var2 != null) {
            i0Var.g(zVar, y0Var2);
        }
    }

    public ColorStateList g(Context context, int i9) {
        if (i9 == 2131230780) {
            return a.a.u(context, 2131099669);
        }
        if (i9 == 2131230826) {
            return a.a.u(context, 2131099672);
        }
        if (i9 != 2131230825) {
            if (i9 == 2131230768) {
                return d(context, m3.c(context, 2130968805));
            }
            if (i9 == 2131230762) {
                return d(context, 0);
            }
            if (i9 == 2131230767) {
                return d(context, m3.c(context, 2130968803));
            }
            if (i9 == 2131230821 || i9 == 2131230822) {
                return a.a.u(context, 2131099671);
            }
            if (b((int[]) this.f6677b, i9)) {
                return m3.d(context, 2130968809);
            }
            if (b((int[]) this.f6680e, i9)) {
                return a.a.u(context, 2131099668);
            }
            if (b((int[]) this.f6681f, i9)) {
                return a.a.u(context, 2131099667);
            }
            if (i9 == 2131230818) {
                return a.a.u(context, 2131099670);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList d9 = m3.d(context, 2130968858);
        if (d9 == null || !d9.isStateful()) {
            iArr[0] = m3.f6970b;
            iArr2[0] = m3.b(context, 2130968858);
            iArr[1] = m3.f6973e;
            iArr2[1] = m3.c(context, 2130968807);
            iArr[2] = m3.f6974f;
            iArr2[2] = m3.c(context, 2130968858);
        } else {
            int[] iArr3 = m3.f6970b;
            iArr[0] = iArr3;
            iArr2[0] = d9.getColorForState(iArr3, 0);
            iArr[1] = m3.f6973e;
            iArr2[1] = m3.c(context, 2130968807);
            iArr[2] = m3.f6974f;
            iArr2[2] = d9.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public void j(y0 y0Var) {
        g0 g0Var;
        i0 i0Var = new i0(4);
        if (((g0) this.f6677b).isEmpty()) {
            a(i0Var, (z) this.f6680e, y0Var);
            if (!android.support.v4.media.session.b.G((z) this.f6681f, (z) this.f6680e)) {
                a(i0Var, (z) this.f6681f, y0Var);
            }
            if (!android.support.v4.media.session.b.G((z) this.f6679d, (z) this.f6680e) && !android.support.v4.media.session.b.G((z) this.f6679d, (z) this.f6681f)) {
                a(i0Var, (z) this.f6679d, y0Var);
            }
        } else {
            int i9 = 0;
            while (true) {
                int size = ((g0) this.f6677b).size();
                g0Var = (g0) this.f6677b;
                if (i9 >= size) {
                    break;
                }
                a(i0Var, (z) g0Var.get(i9), y0Var);
                i9++;
            }
            if (!g0Var.contains((z) this.f6679d)) {
                a(i0Var, (z) this.f6679d, y0Var);
            }
        }
        this.f6678c = i0Var.a();
    }

    public p(String str, com.google.crypto.tink.shaded.protobuf.j jVar, w0 w0Var, q1 q1Var, Integer num) {
        this.f6676a = str;
        this.f6677b = u.b(str);
        this.f6678c = jVar;
        this.f6679d = w0Var;
        this.f6680e = q1Var;
        this.f6681f = num;
    }

    public p(d1.w0 w0Var) {
        this.f6676a = w0Var;
        e0 e0Var = g0.f1391j;
        this.f6677b = b6.w0.f1464m;
        this.f6678c = b1.f1352o;
    }
}
