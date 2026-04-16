package a0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g extends ViewGroup.MarginLayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public d f10a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13d;

    /* renamed from: e, reason: collision with root package name */
    public final int f14e;

    /* renamed from: f, reason: collision with root package name */
    public final int f15f;

    /* renamed from: g, reason: collision with root package name */
    public final int f16g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f17i;

    /* renamed from: j, reason: collision with root package name */
    public int f18j;

    /* renamed from: k, reason: collision with root package name */
    public View f19k;

    /* renamed from: l, reason: collision with root package name */
    public View f20l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f21m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f22n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f23o;

    /* renamed from: p, reason: collision with root package name */
    public final Rect f24p;

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11b = false;
        this.f12c = 0;
        this.f13d = 0;
        this.f14e = -1;
        this.f15f = -1;
        this.f16g = 0;
        this.h = 0;
        this.f24p = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.a.f10533b);
        this.f12c = obtainStyledAttributes.getInteger(0, 0);
        this.f15f = obtainStyledAttributes.getResourceId(1, -1);
        this.f13d = obtainStyledAttributes.getInteger(2, 0);
        this.f14e = obtainStyledAttributes.getInteger(6, -1);
        this.f16g = obtainStyledAttributes.getInt(5, 0);
        this.h = obtainStyledAttributes.getInt(4, 0);
        boolean hasValue = obtainStyledAttributes.hasValue(3);
        this.f11b = hasValue;
        if (hasValue) {
            String string = obtainStyledAttributes.getString(3);
            String str = CoordinatorLayout.B;
            d dVar = null;
            if (!TextUtils.isEmpty(string)) {
                if (string.startsWith(".")) {
                    string = context.getPackageName() + string;
                } else if (string.indexOf(46) < 0) {
                    String str2 = CoordinatorLayout.B;
                    if (!TextUtils.isEmpty(str2)) {
                        string = str2 + '.' + string;
                    }
                }
                try {
                    ThreadLocal threadLocal = CoordinatorLayout.D;
                    Map map = (Map) threadLocal.get();
                    if (map == null) {
                        map = new HashMap();
                        threadLocal.set(map);
                    }
                    Constructor<?> constructor = (Constructor) map.get(string);
                    if (constructor == null) {
                        constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.C);
                        constructor.setAccessible(true);
                        map.put(string, constructor);
                    }
                    dVar = (d) constructor.newInstance(context, attributeSet);
                } catch (Exception e9) {
                    m7.c.k("Could not inflate Behavior subclass ".concat(string), e9);
                    throw null;
                }
            }
            this.f10a = dVar;
        }
        obtainStyledAttributes.recycle();
        d dVar2 = this.f10a;
        if (dVar2 != null) {
            dVar2.c(this);
        }
    }

    public final boolean a(int i9) {
        if (i9 == 0) {
            return this.f21m;
        }
        if (i9 != 1) {
            return false;
        }
        return this.f22n;
    }

    public g() {
        super(-2, -2);
        this.f11b = false;
        this.f12c = 0;
        this.f13d = 0;
        this.f14e = -1;
        this.f15f = -1;
        this.f16g = 0;
        this.h = 0;
        this.f24p = new Rect();
    }

    public g(g gVar) {
        super((ViewGroup.MarginLayoutParams) gVar);
        this.f11b = false;
        this.f12c = 0;
        this.f13d = 0;
        this.f14e = -1;
        this.f15f = -1;
        this.f16g = 0;
        this.h = 0;
        this.f24p = new Rect();
    }

    public g(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f11b = false;
        this.f12c = 0;
        this.f13d = 0;
        this.f14e = -1;
        this.f15f = -1;
        this.f16g = 0;
        this.h = 0;
        this.f24p = new Rect();
    }

    public g(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f11b = false;
        this.f12c = 0;
        this.f13d = 0;
        this.f14e = -1;
        this.f15f = -1;
        this.f16g = 0;
        this.h = 0;
        this.f24p = new Rect();
    }
}
