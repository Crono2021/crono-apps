package y1;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.Display;
import android.view.WindowManager;
import android.view.accessibility.CaptioningManager;
import b6.g0;
import d1.a1;
import d1.c1;
import d1.d1;
import g1.w;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h extends c1 {
    public final SparseArray A;
    public final SparseBooleanArray B;

    /* renamed from: t, reason: collision with root package name */
    public boolean f10431t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f10432u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f10433v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f10434w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f10435x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f10436y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f10437z;

    public h(Context context) {
        Point point;
        Display.Mode mode;
        int physicalWidth;
        int physicalHeight;
        Point point2;
        String[] split;
        DisplayManager displayManager;
        CaptioningManager captioningManager;
        int i9 = w.f3713a;
        if (i9 >= 19 && ((i9 >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled())) {
            this.f2385o = 1088;
            Locale locale = captioningManager.getLocale();
            if (locale != null) {
                this.f2384n = g0.q(i9 >= 21 ? locale.toLanguageTag() : locale.toString());
            }
        }
        Display display = (i9 < 17 || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : displayManager.getDisplay(0);
        if (display == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            windowManager.getClass();
            display = windowManager.getDefaultDisplay();
        }
        if (display.getDisplayId() == 0 && w.L(context)) {
            String C = i9 < 28 ? w.C("sys.display-size") : w.C("vendor.display-size");
            if (!TextUtils.isEmpty(C)) {
                try {
                    split = C.trim().split("x", -1);
                } catch (NumberFormatException unused) {
                }
                if (split.length == 2) {
                    int parseInt = Integer.parseInt(split[0]);
                    int parseInt2 = Integer.parseInt(split[1]);
                    if (parseInt > 0 && parseInt2 > 0) {
                        point2 = new Point(parseInt, parseInt2);
                        h(point2.x, point2.y);
                        this.A = new SparseArray();
                        this.B = new SparseBooleanArray();
                        i();
                    }
                }
                g1.a.p("Util", "Invalid display size: " + C);
            }
            if ("Sony".equals(w.f3715c) && w.f3716d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                point = new Point(3840, 2160);
                point2 = point;
                h(point2.x, point2.y);
                this.A = new SparseArray();
                this.B = new SparseBooleanArray();
                i();
            }
        }
        point = new Point();
        if (i9 >= 23) {
            mode = display.getMode();
            physicalWidth = mode.getPhysicalWidth();
            point.x = physicalWidth;
            physicalHeight = mode.getPhysicalHeight();
            point.y = physicalHeight;
        } else if (i9 >= 17) {
            display.getRealSize(point);
        } else {
            display.getSize(point);
        }
        point2 = point;
        h(point2.x, point2.y);
        this.A = new SparseArray();
        this.B = new SparseBooleanArray();
        i();
    }

    @Override // d1.c1
    public final d1 a() {
        return new i(this);
    }

    @Override // d1.c1
    public final c1 b(int i9) {
        super.b(i9);
        return this;
    }

    @Override // d1.c1
    public final c1 e() {
        this.f2386p = -3;
        return this;
    }

    @Override // d1.c1
    public final c1 f(a1 a1Var) {
        super.f(a1Var);
        return this;
    }

    @Override // d1.c1
    public final c1 g(int i9) {
        super.g(i9);
        return this;
    }

    @Override // d1.c1
    public final c1 h(int i9, int i10) {
        super.h(i9, i10);
        return this;
    }

    public final void i() {
        this.f10431t = true;
        this.f10432u = true;
        this.f10433v = true;
        this.f10434w = true;
        this.f10435x = true;
        this.f10436y = true;
        this.f10437z = true;
    }

    public final void j(Set set) {
        this.f2389s.clear();
        this.f2389s.addAll(set);
    }

    public h(i iVar) {
        c(iVar);
        this.f10431t = iVar.f10438t;
        this.f10432u = iVar.f10439u;
        this.f10433v = iVar.f10440v;
        this.f10434w = iVar.f10441w;
        this.f10435x = iVar.f10442x;
        this.f10436y = iVar.f10443y;
        this.f10437z = iVar.f10444z;
        SparseArray sparseArray = iVar.A;
        SparseArray sparseArray2 = new SparseArray();
        for (int i9 = 0; i9 < sparseArray.size(); i9++) {
            sparseArray2.put(sparseArray.keyAt(i9), new HashMap((Map) sparseArray.valueAt(i9)));
        }
        this.A = sparseArray2;
        this.B = iVar.B.clone();
    }

    public h() {
        this.A = new SparseArray();
        this.B = new SparseBooleanArray();
        i();
    }
}
