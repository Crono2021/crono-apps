package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import d2.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import m1.b;
import org.webrtc.PeerConnectionFactory;
import org.xmlpull.v1.XmlPullParserException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import w.e;
import w.h;
import y.c;
import y.d;
import y.k;
import y.l;
import y.m;
import y.o;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: i, reason: collision with root package name */
    public final SparseArray f534i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f535j;

    /* renamed from: k, reason: collision with root package name */
    public final e f536k;

    /* renamed from: l, reason: collision with root package name */
    public int f537l;

    /* renamed from: m, reason: collision with root package name */
    public int f538m;

    /* renamed from: n, reason: collision with root package name */
    public int f539n;

    /* renamed from: o, reason: collision with root package name */
    public int f540o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f541p;

    /* renamed from: q, reason: collision with root package name */
    public int f542q;

    /* renamed from: r, reason: collision with root package name */
    public k f543r;

    /* renamed from: s, reason: collision with root package name */
    public b f544s;

    /* renamed from: t, reason: collision with root package name */
    public int f545t;

    /* renamed from: u, reason: collision with root package name */
    public HashMap f546u;

    /* renamed from: v, reason: collision with root package name */
    public final SparseArray f547v;

    /* renamed from: w, reason: collision with root package name */
    public final w f548w;

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f534i = new SparseArray();
        this.f535j = new ArrayList(4);
        this.f536k = new e();
        this.f537l = 0;
        this.f538m = 0;
        this.f539n = Integer.MAX_VALUE;
        this.f540o = Integer.MAX_VALUE;
        this.f541p = true;
        this.f542q = 263;
        this.f543r = null;
        this.f544s = null;
        this.f545t = -1;
        this.f546u = new HashMap();
        this.f547v = new SparseArray();
        this.f548w = new w(this);
        c(attributeSet, 0);
    }

    public static d a() {
        d dVar = new d(-2, -2);
        dVar.f10231a = -1;
        dVar.f10233b = -1;
        dVar.f10235c = -1.0f;
        dVar.f10237d = -1;
        dVar.f10239e = -1;
        dVar.f10241f = -1;
        dVar.f10243g = -1;
        dVar.h = -1;
        dVar.f10246i = -1;
        dVar.f10247j = -1;
        dVar.f10249k = -1;
        dVar.f10251l = -1;
        dVar.f10252m = -1;
        dVar.f10253n = 0;
        dVar.f10254o = 0.0f;
        dVar.f10255p = -1;
        dVar.f10256q = -1;
        dVar.f10257r = -1;
        dVar.f10258s = -1;
        dVar.f10259t = -1;
        dVar.f10260u = -1;
        dVar.f10261v = -1;
        dVar.f10262w = -1;
        dVar.f10263x = -1;
        dVar.f10264y = -1;
        dVar.f10265z = 0.5f;
        dVar.A = 0.5f;
        dVar.B = null;
        dVar.C = 1;
        dVar.D = -1.0f;
        dVar.E = -1.0f;
        dVar.F = 0;
        dVar.G = 0;
        dVar.H = 0;
        dVar.I = 0;
        dVar.J = 0;
        dVar.K = 0;
        dVar.L = 0;
        dVar.M = 0;
        dVar.N = 1.0f;
        dVar.O = 1.0f;
        dVar.P = -1;
        dVar.Q = -1;
        dVar.R = -1;
        dVar.S = false;
        dVar.T = false;
        dVar.U = null;
        dVar.V = true;
        dVar.W = true;
        dVar.X = false;
        dVar.Y = false;
        dVar.Z = false;
        dVar.f10232a0 = -1;
        dVar.f10234b0 = -1;
        dVar.f10236c0 = -1;
        dVar.f10238d0 = -1;
        dVar.f10240e0 = -1;
        dVar.f10242f0 = -1;
        dVar.f10244g0 = 0.5f;
        dVar.f10250k0 = new w.d();
        return dVar;
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int max2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return max2 > 0 ? max2 : max;
    }

    public final w.d b(View view) {
        if (view == this) {
            return this.f536k;
        }
        if (view == null) {
            return null;
        }
        return ((d) view.getLayoutParams()).f10250k0;
    }

    public final void c(AttributeSet attributeSet, int i9) {
        e eVar = this.f536k;
        eVar.U = this;
        w wVar = this.f548w;
        eVar.f9646g0 = wVar;
        eVar.f9645f0.f9993f = wVar;
        this.f534i.put(getId(), this);
        this.f543r = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.f10338b, i9, 0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == 9) {
                    this.f537l = obtainStyledAttributes.getDimensionPixelOffset(index, this.f537l);
                } else if (index == 10) {
                    this.f538m = obtainStyledAttributes.getDimensionPixelOffset(index, this.f538m);
                } else if (index == 7) {
                    this.f539n = obtainStyledAttributes.getDimensionPixelOffset(index, this.f539n);
                } else if (index == 8) {
                    this.f540o = obtainStyledAttributes.getDimensionPixelOffset(index, this.f540o);
                } else if (index == 89) {
                    this.f542q = obtainStyledAttributes.getInt(index, this.f542q);
                } else if (index == 38) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            d(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f544s = null;
                        }
                    }
                } else if (index == 18) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        k kVar = new k();
                        this.f543r = kVar;
                        kVar.e(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f543r = null;
                    }
                    this.f545t = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        int i11 = this.f542q;
        eVar.f9654p0 = i11;
        v.e.f9155p = (i11 & 256) == 256;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof d;
    }

    public final void d(int i9) {
        Context context = getContext();
        b bVar = new b(21, false);
        bVar.f6511k = new SparseArray();
        bVar.f6510j = new SparseArray();
        XmlResourceParser xml = context.getResources().getXml(i9);
        try {
            b3.d dVar = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                bVar.s(context, xml);
                                break;
                            }
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                dVar = new b3.d(context, xml);
                                ((SparseArray) bVar.f6511k).put(dVar.f1286j, dVar);
                                break;
                            }
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                break;
                            }
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                break;
                            }
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                y.e eVar = new y.e(context, xml);
                                if (dVar != null) {
                                    ((ArrayList) dVar.f1288l).add(eVar);
                                    break;
                                } else {
                                    break;
                                }
                            }
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                            break;
                        default:
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                            break;
                    }
                }
            }
        } catch (IOException e9) {
            e9.printStackTrace();
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
        }
        this.f544s = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.f535j;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i9 = 0; i9 < size; i9++) {
                ((y.b) arrayList.get(i9)).getClass();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i11 = (int) ((parseInt / 1080.0f) * width);
                        int i12 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f9 = i11;
                        float f10 = i12;
                        float f11 = i11 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f9, f10, f11, f10, paint);
                        float parseInt4 = i12 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f11, f10, f11, parseInt4, paint);
                        canvas.drawLine(f11, parseInt4, f9, parseInt4, paint);
                        canvas.drawLine(f9, parseInt4, f9, f10, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f9, f10, f11, parseInt4, paint);
                        canvas.drawLine(f9, parseInt4, f11, f10, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.f541p = true;
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return a();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        int i9;
        Context context = getContext();
        d dVar = new d(context, attributeSet);
        dVar.f10231a = -1;
        dVar.f10233b = -1;
        dVar.f10235c = -1.0f;
        dVar.f10237d = -1;
        dVar.f10239e = -1;
        dVar.f10241f = -1;
        dVar.f10243g = -1;
        dVar.h = -1;
        dVar.f10246i = -1;
        dVar.f10247j = -1;
        dVar.f10249k = -1;
        dVar.f10251l = -1;
        dVar.f10252m = -1;
        dVar.f10253n = 0;
        dVar.f10254o = 0.0f;
        dVar.f10255p = -1;
        dVar.f10256q = -1;
        dVar.f10257r = -1;
        dVar.f10258s = -1;
        dVar.f10259t = -1;
        dVar.f10260u = -1;
        dVar.f10261v = -1;
        dVar.f10262w = -1;
        dVar.f10263x = -1;
        dVar.f10264y = -1;
        dVar.f10265z = 0.5f;
        dVar.A = 0.5f;
        dVar.B = null;
        dVar.C = 1;
        dVar.D = -1.0f;
        dVar.E = -1.0f;
        dVar.F = 0;
        dVar.G = 0;
        dVar.H = 0;
        dVar.I = 0;
        dVar.J = 0;
        dVar.K = 0;
        dVar.L = 0;
        dVar.M = 0;
        dVar.N = 1.0f;
        dVar.O = 1.0f;
        dVar.P = -1;
        dVar.Q = -1;
        dVar.R = -1;
        dVar.S = false;
        dVar.T = false;
        dVar.U = null;
        dVar.V = true;
        dVar.W = true;
        dVar.X = false;
        dVar.Y = false;
        dVar.Z = false;
        dVar.f10232a0 = -1;
        dVar.f10234b0 = -1;
        dVar.f10236c0 = -1;
        dVar.f10238d0 = -1;
        dVar.f10240e0 = -1;
        dVar.f10242f0 = -1;
        dVar.f10244g0 = 0.5f;
        dVar.f10250k0 = new w.d();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f10338b);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            int i11 = c.f10230a.get(index);
            switch (i11) {
                case 1:
                    dVar.R = obtainStyledAttributes.getInt(index, dVar.R);
                    break;
                case 2:
                    int resourceId = obtainStyledAttributes.getResourceId(index, dVar.f10252m);
                    dVar.f10252m = resourceId;
                    if (resourceId == -1) {
                        dVar.f10252m = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    dVar.f10253n = obtainStyledAttributes.getDimensionPixelSize(index, dVar.f10253n);
                    break;
                case 4:
                    float f9 = obtainStyledAttributes.getFloat(index, dVar.f10254o) % 360.0f;
                    dVar.f10254o = f9;
                    if (f9 < 0.0f) {
                        dVar.f10254o = (360.0f - f9) % 360.0f;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    dVar.f10231a = obtainStyledAttributes.getDimensionPixelOffset(index, dVar.f10231a);
                    break;
                case 6:
                    dVar.f10233b = obtainStyledAttributes.getDimensionPixelOffset(index, dVar.f10233b);
                    break;
                case 7:
                    dVar.f10235c = obtainStyledAttributes.getFloat(index, dVar.f10235c);
                    break;
                case 8:
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, dVar.f10237d);
                    dVar.f10237d = resourceId2;
                    if (resourceId2 == -1) {
                        dVar.f10237d = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    int resourceId3 = obtainStyledAttributes.getResourceId(index, dVar.f10239e);
                    dVar.f10239e = resourceId3;
                    if (resourceId3 == -1) {
                        dVar.f10239e = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    int resourceId4 = obtainStyledAttributes.getResourceId(index, dVar.f10241f);
                    dVar.f10241f = resourceId4;
                    if (resourceId4 == -1) {
                        dVar.f10241f = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    int resourceId5 = obtainStyledAttributes.getResourceId(index, dVar.f10243g);
                    dVar.f10243g = resourceId5;
                    if (resourceId5 == -1) {
                        dVar.f10243g = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    int resourceId6 = obtainStyledAttributes.getResourceId(index, dVar.h);
                    dVar.h = resourceId6;
                    if (resourceId6 == -1) {
                        dVar.h = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    int resourceId7 = obtainStyledAttributes.getResourceId(index, dVar.f10246i);
                    dVar.f10246i = resourceId7;
                    if (resourceId7 == -1) {
                        dVar.f10246i = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    int resourceId8 = obtainStyledAttributes.getResourceId(index, dVar.f10247j);
                    dVar.f10247j = resourceId8;
                    if (resourceId8 == -1) {
                        dVar.f10247j = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    int resourceId9 = obtainStyledAttributes.getResourceId(index, dVar.f10249k);
                    dVar.f10249k = resourceId9;
                    if (resourceId9 == -1) {
                        dVar.f10249k = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                    int resourceId10 = obtainStyledAttributes.getResourceId(index, dVar.f10251l);
                    dVar.f10251l = resourceId10;
                    if (resourceId10 == -1) {
                        dVar.f10251l = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    int resourceId11 = obtainStyledAttributes.getResourceId(index, dVar.f10255p);
                    dVar.f10255p = resourceId11;
                    if (resourceId11 == -1) {
                        dVar.f10255p = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 18:
                    int resourceId12 = obtainStyledAttributes.getResourceId(index, dVar.f10256q);
                    dVar.f10256q = resourceId12;
                    if (resourceId12 == -1) {
                        dVar.f10256q = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 19:
                    int resourceId13 = obtainStyledAttributes.getResourceId(index, dVar.f10257r);
                    dVar.f10257r = resourceId13;
                    if (resourceId13 == -1) {
                        dVar.f10257r = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 20:
                    int resourceId14 = obtainStyledAttributes.getResourceId(index, dVar.f10258s);
                    dVar.f10258s = resourceId14;
                    if (resourceId14 == -1) {
                        dVar.f10258s = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 21:
                    dVar.f10259t = obtainStyledAttributes.getDimensionPixelSize(index, dVar.f10259t);
                    break;
                case 22:
                    dVar.f10260u = obtainStyledAttributes.getDimensionPixelSize(index, dVar.f10260u);
                    break;
                case 23:
                    dVar.f10261v = obtainStyledAttributes.getDimensionPixelSize(index, dVar.f10261v);
                    break;
                case 24:
                    dVar.f10262w = obtainStyledAttributes.getDimensionPixelSize(index, dVar.f10262w);
                    break;
                case 25:
                    dVar.f10263x = obtainStyledAttributes.getDimensionPixelSize(index, dVar.f10263x);
                    break;
                case 26:
                    dVar.f10264y = obtainStyledAttributes.getDimensionPixelSize(index, dVar.f10264y);
                    break;
                case 27:
                    dVar.S = obtainStyledAttributes.getBoolean(index, dVar.S);
                    break;
                case 28:
                    dVar.T = obtainStyledAttributes.getBoolean(index, dVar.T);
                    break;
                case 29:
                    dVar.f10265z = obtainStyledAttributes.getFloat(index, dVar.f10265z);
                    break;
                case 30:
                    dVar.A = obtainStyledAttributes.getFloat(index, dVar.A);
                    break;
                case 31:
                    int i12 = obtainStyledAttributes.getInt(index, 0);
                    dVar.H = i12;
                    if (i12 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case PeerConnectionFactory.Options.ADAPTER_TYPE_ANY /* 32 */:
                    int i13 = obtainStyledAttributes.getInt(index, 0);
                    dVar.I = i13;
                    if (i13 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case 33:
                    try {
                        dVar.J = obtainStyledAttributes.getDimensionPixelSize(index, dVar.J);
                        break;
                    } catch (Exception unused) {
                        if (obtainStyledAttributes.getInt(index, dVar.J) == -2) {
                            dVar.J = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 34:
                    try {
                        dVar.L = obtainStyledAttributes.getDimensionPixelSize(index, dVar.L);
                        break;
                    } catch (Exception unused2) {
                        if (obtainStyledAttributes.getInt(index, dVar.L) == -2) {
                            dVar.L = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 35:
                    dVar.N = Math.max(0.0f, obtainStyledAttributes.getFloat(index, dVar.N));
                    dVar.H = 2;
                    break;
                case 36:
                    try {
                        dVar.K = obtainStyledAttributes.getDimensionPixelSize(index, dVar.K);
                        break;
                    } catch (Exception unused3) {
                        if (obtainStyledAttributes.getInt(index, dVar.K) == -2) {
                            dVar.K = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 37:
                    try {
                        dVar.M = obtainStyledAttributes.getDimensionPixelSize(index, dVar.M);
                        break;
                    } catch (Exception unused4) {
                        if (obtainStyledAttributes.getInt(index, dVar.M) == -2) {
                            dVar.M = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 38:
                    dVar.O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, dVar.O));
                    dVar.I = 2;
                    break;
                default:
                    switch (i11) {
                        case IjkMediaMeta.FF_PROFILE_H264_CAVLC_444 /* 44 */:
                            String string = obtainStyledAttributes.getString(index);
                            dVar.B = string;
                            dVar.C = -1;
                            if (string != null) {
                                int length = string.length();
                                int indexOf = dVar.B.indexOf(44);
                                if (indexOf <= 0 || indexOf >= length - 1) {
                                    i9 = 0;
                                } else {
                                    String substring = dVar.B.substring(0, indexOf);
                                    if (substring.equalsIgnoreCase("W")) {
                                        dVar.C = 0;
                                    } else if (substring.equalsIgnoreCase("H")) {
                                        dVar.C = 1;
                                    }
                                    i9 = indexOf + 1;
                                }
                                int indexOf2 = dVar.B.indexOf(58);
                                if (indexOf2 < 0 || indexOf2 >= length - 1) {
                                    String substring2 = dVar.B.substring(i9);
                                    if (substring2.length() > 0) {
                                        Float.parseFloat(substring2);
                                        break;
                                    } else {
                                        break;
                                    }
                                } else {
                                    String substring3 = dVar.B.substring(i9, indexOf2);
                                    String substring4 = dVar.B.substring(indexOf2 + 1);
                                    if (substring3.length() > 0 && substring4.length() > 0) {
                                        try {
                                            float parseFloat = Float.parseFloat(substring3);
                                            float parseFloat2 = Float.parseFloat(substring4);
                                            if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                if (dVar.C == 1) {
                                                    Math.abs(parseFloat2 / parseFloat);
                                                    break;
                                                } else {
                                                    Math.abs(parseFloat / parseFloat2);
                                                    break;
                                                }
                                            }
                                        } catch (NumberFormatException unused5) {
                                            break;
                                        }
                                    }
                                }
                            } else {
                                break;
                            }
                            break;
                        case 45:
                            dVar.D = obtainStyledAttributes.getFloat(index, dVar.D);
                            break;
                        case 46:
                            dVar.E = obtainStyledAttributes.getFloat(index, dVar.E);
                            break;
                        case 47:
                            dVar.F = obtainStyledAttributes.getInt(index, 0);
                            break;
                        case 48:
                            dVar.G = obtainStyledAttributes.getInt(index, 0);
                            break;
                        case 49:
                            dVar.P = obtainStyledAttributes.getDimensionPixelOffset(index, dVar.P);
                            break;
                        case l1.k.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY /* 50 */:
                            dVar.Q = obtainStyledAttributes.getDimensionPixelOffset(index, dVar.Q);
                            break;
                        case 51:
                            dVar.U = obtainStyledAttributes.getString(index);
                            break;
                    }
            }
        }
        obtainStyledAttributes.recycle();
        dVar.a();
        return dVar;
    }

    public int getMaxHeight() {
        return this.f540o;
    }

    public int getMaxWidth() {
        return this.f539n;
    }

    public int getMinHeight() {
        return this.f538m;
    }

    public int getMinWidth() {
        return this.f537l;
    }

    public int getOptimizationLevel() {
        return this.f536k.f9654p0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            d dVar = (d) childAt.getLayoutParams();
            w.d dVar2 = dVar.f10250k0;
            if (childAt.getVisibility() != 8 || dVar.Y || dVar.Z || isInEditMode) {
                int m9 = dVar2.m();
                int n4 = dVar2.n();
                childAt.layout(m9, n4, dVar2.l() + m9, dVar2.i() + n4);
            }
        }
        ArrayList arrayList = this.f535j;
        int size = arrayList.size();
        if (size > 0) {
            for (int i14 = 0; i14 < size; i14++) {
                ((y.b) arrayList.get(i14)).getClass();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:264:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x06eb  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x072e  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0766  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x0771  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x079a  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x079f  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x07af  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0822 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:397:0x082d  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x0986  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x09a2  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x0a85  */
    /* JADX WARN: Removed duplicated region for block: B:470:0x0d22  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x0d25  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x0a8a  */
    /* JADX WARN: Removed duplicated region for block: B:511:0x0b07  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x0b0c  */
    /* JADX WARN: Removed duplicated region for block: B:618:0x0ce5  */
    /* JADX WARN: Removed duplicated region for block: B:620:0x0ce7  */
    /* JADX WARN: Removed duplicated region for block: B:682:0x0a77  */
    /* JADX WARN: Removed duplicated region for block: B:706:0x07aa  */
    /* JADX WARN: Removed duplicated region for block: B:707:0x079c  */
    /* JADX WARN: Removed duplicated region for block: B:708:0x0774  */
    /* JADX WARN: Removed duplicated region for block: B:709:0x0769  */
    /* JADX WARN: Removed duplicated region for block: B:717:0x0716  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r42, int r43) {
        /*
            Method dump skipped, instructions count: 3370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        w.d b9 = b(view);
        if ((view instanceof m) && !(b9 instanceof h)) {
            d dVar = (d) view.getLayoutParams();
            h hVar = new h();
            dVar.f10250k0 = hVar;
            dVar.Y = true;
            hVar.B(dVar.R);
        }
        if (view instanceof y.b) {
            y.b bVar = (y.b) view;
            bVar.g();
            ((d) view.getLayoutParams()).Z = true;
            ArrayList arrayList = this.f535j;
            if (!arrayList.contains(bVar)) {
                arrayList.add(bVar);
            }
        }
        this.f534i.put(view.getId(), view);
        this.f541p = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f534i.remove(view.getId());
        w.d b9 = b(view);
        this.f536k.f9643d0.remove(b9);
        b9.I = null;
        this.f535j.remove(view);
        this.f541p = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f541p = true;
        super.requestLayout();
    }

    public void setConstraintSet(k kVar) {
        this.f543r = kVar;
    }

    @Override // android.view.View
    public void setId(int i9) {
        int id = getId();
        SparseArray sparseArray = this.f534i;
        sparseArray.remove(id);
        super.setId(i9);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i9) {
        if (i9 == this.f540o) {
            return;
        }
        this.f540o = i9;
        requestLayout();
    }

    public void setMaxWidth(int i9) {
        if (i9 == this.f539n) {
            return;
        }
        this.f539n = i9;
        requestLayout();
    }

    public void setMinHeight(int i9) {
        if (i9 == this.f538m) {
            return;
        }
        this.f538m = i9;
        requestLayout();
    }

    public void setMinWidth(int i9) {
        if (i9 == this.f537l) {
            return;
        }
        this.f537l = i9;
        requestLayout();
    }

    public void setOnConstraintsChanged(l lVar) {
        b bVar = this.f544s;
        if (bVar != null) {
            bVar.getClass();
        }
    }

    public void setOptimizationLevel(int i9) {
        this.f542q = i9;
        this.f536k.f9654p0 = i9;
        v.e.f9155p = (i9 & 256) == 256;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, i9);
        this.f534i = new SparseArray();
        this.f535j = new ArrayList(4);
        this.f536k = new e();
        this.f537l = 0;
        this.f538m = 0;
        this.f539n = Integer.MAX_VALUE;
        this.f540o = Integer.MAX_VALUE;
        this.f541p = true;
        this.f542q = 263;
        this.f543r = null;
        this.f544s = null;
        this.f545t = -1;
        this.f546u = new HashMap();
        this.f547v = new SparseArray();
        this.f548w = new w(this);
        c(attributeSet, i9);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        d dVar = new d(layoutParams);
        dVar.f10231a = -1;
        dVar.f10233b = -1;
        dVar.f10235c = -1.0f;
        dVar.f10237d = -1;
        dVar.f10239e = -1;
        dVar.f10241f = -1;
        dVar.f10243g = -1;
        dVar.h = -1;
        dVar.f10246i = -1;
        dVar.f10247j = -1;
        dVar.f10249k = -1;
        dVar.f10251l = -1;
        dVar.f10252m = -1;
        dVar.f10253n = 0;
        dVar.f10254o = 0.0f;
        dVar.f10255p = -1;
        dVar.f10256q = -1;
        dVar.f10257r = -1;
        dVar.f10258s = -1;
        dVar.f10259t = -1;
        dVar.f10260u = -1;
        dVar.f10261v = -1;
        dVar.f10262w = -1;
        dVar.f10263x = -1;
        dVar.f10264y = -1;
        dVar.f10265z = 0.5f;
        dVar.A = 0.5f;
        dVar.B = null;
        dVar.C = 1;
        dVar.D = -1.0f;
        dVar.E = -1.0f;
        dVar.F = 0;
        dVar.G = 0;
        dVar.H = 0;
        dVar.I = 0;
        dVar.J = 0;
        dVar.K = 0;
        dVar.L = 0;
        dVar.M = 0;
        dVar.N = 1.0f;
        dVar.O = 1.0f;
        dVar.P = -1;
        dVar.Q = -1;
        dVar.R = -1;
        dVar.S = false;
        dVar.T = false;
        dVar.U = null;
        dVar.V = true;
        dVar.W = true;
        dVar.X = false;
        dVar.Y = false;
        dVar.Z = false;
        dVar.f10232a0 = -1;
        dVar.f10234b0 = -1;
        dVar.f10236c0 = -1;
        dVar.f10238d0 = -1;
        dVar.f10240e0 = -1;
        dVar.f10242f0 = -1;
        dVar.f10244g0 = 0.5f;
        dVar.f10250k0 = new w.d();
        return dVar;
    }
}
