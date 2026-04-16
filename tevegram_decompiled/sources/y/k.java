package y;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.webrtc.EglBase;
import org.webrtc.PeerConnectionFactory;
import org.xmlpull.v1.XmlPullParserException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f10332d = {0, 4, 8};

    /* renamed from: e, reason: collision with root package name */
    public static final SparseIntArray f10333e;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f10334a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10335b = true;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f10336c = new HashMap();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f10333e = sparseIntArray;
        sparseIntArray.append(76, 25);
        sparseIntArray.append(77, 26);
        sparseIntArray.append(79, 29);
        sparseIntArray.append(80, 30);
        sparseIntArray.append(86, 36);
        sparseIntArray.append(85, 35);
        sparseIntArray.append(58, 4);
        sparseIntArray.append(57, 3);
        sparseIntArray.append(55, 1);
        sparseIntArray.append(94, 6);
        sparseIntArray.append(95, 7);
        sparseIntArray.append(65, 17);
        sparseIntArray.append(66, 18);
        sparseIntArray.append(67, 19);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(81, 32);
        sparseIntArray.append(82, 33);
        sparseIntArray.append(64, 10);
        sparseIntArray.append(63, 9);
        sparseIntArray.append(98, 13);
        sparseIntArray.append(101, 16);
        sparseIntArray.append(99, 14);
        sparseIntArray.append(96, 11);
        sparseIntArray.append(100, 15);
        sparseIntArray.append(97, 12);
        sparseIntArray.append(89, 40);
        sparseIntArray.append(74, 39);
        sparseIntArray.append(73, 41);
        sparseIntArray.append(88, 42);
        sparseIntArray.append(72, 20);
        sparseIntArray.append(87, 37);
        sparseIntArray.append(62, 5);
        sparseIntArray.append(75, 82);
        sparseIntArray.append(84, 82);
        sparseIntArray.append(78, 82);
        sparseIntArray.append(56, 82);
        sparseIntArray.append(54, 82);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(2, 22);
        sparseIntArray.append(13, 43);
        sparseIntArray.append(26, 44);
        sparseIntArray.append(21, 45);
        sparseIntArray.append(22, 46);
        sparseIntArray.append(20, 60);
        sparseIntArray.append(18, 47);
        sparseIntArray.append(19, 48);
        sparseIntArray.append(14, 49);
        sparseIntArray.append(15, 50);
        sparseIntArray.append(16, 51);
        sparseIntArray.append(17, 52);
        sparseIntArray.append(25, 53);
        sparseIntArray.append(90, 54);
        sparseIntArray.append(68, 55);
        sparseIntArray.append(91, 56);
        sparseIntArray.append(69, 57);
        sparseIntArray.append(92, 58);
        sparseIntArray.append(70, 59);
        sparseIntArray.append(59, 61);
        sparseIntArray.append(61, 62);
        sparseIntArray.append(60, 63);
        sparseIntArray.append(27, 64);
        sparseIntArray.append(106, 65);
        sparseIntArray.append(33, 66);
        sparseIntArray.append(107, 67);
        sparseIntArray.append(103, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(102, 68);
        sparseIntArray.append(93, 69);
        sparseIntArray.append(71, 70);
        sparseIntArray.append(31, 71);
        sparseIntArray.append(29, 72);
        sparseIntArray.append(30, 73);
        sparseIntArray.append(32, 74);
        sparseIntArray.append(28, 75);
        sparseIntArray.append(104, 76);
        sparseIntArray.append(83, 77);
        sparseIntArray.append(108, 78);
        sparseIntArray.append(53, 80);
        sparseIntArray.append(52, 81);
    }

    public static int[] c(Barrier barrier, String str) {
        int i9;
        String[] split = str.split(",");
        Context context = barrier.getContext();
        int[] iArr = new int[split.length];
        int i10 = 0;
        int i11 = 0;
        while (i10 < split.length) {
            String trim = split[i10].trim();
            Object obj = null;
            try {
                i9 = n.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i9 = 0;
            }
            if (i9 == 0) {
                i9 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i9 == 0 && barrier.isInEditMode() && (barrier.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) barrier.getParent();
                if (t.a.d(trim)) {
                    HashMap hashMap = constraintLayout.f546u;
                    if (hashMap != null && hashMap.containsKey(trim)) {
                        obj = constraintLayout.f546u.get(trim);
                    }
                } else {
                    constraintLayout.getClass();
                }
                if (obj != null && (obj instanceof Integer)) {
                    i9 = ((Integer) obj).intValue();
                }
            }
            iArr[i11] = i9;
            i10++;
            i11++;
        }
        return i11 != split.length ? Arrays.copyOf(iArr, i11) : iArr;
    }

    public static f d(Context context, AttributeSet attributeSet) {
        f fVar = new f();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f10337a);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i9 = 0; i9 < indexCount; i9++) {
            int index = obtainStyledAttributes.getIndex(i9);
            h hVar = fVar.f10273c;
            j jVar = fVar.f10275e;
            g gVar = fVar.f10274d;
            if (index != 1 && 23 != index && 24 != index) {
                hVar.getClass();
                gVar.getClass();
                jVar.getClass();
            }
            SparseIntArray sparseIntArray = f10333e;
            int i10 = sparseIntArray.get(index);
            i iVar = fVar.f10272b;
            switch (i10) {
                case 1:
                    gVar.f10299o = f(obtainStyledAttributes, index, gVar.f10299o);
                    break;
                case 2:
                    gVar.F = obtainStyledAttributes.getDimensionPixelSize(index, gVar.F);
                    break;
                case 3:
                    gVar.f10298n = f(obtainStyledAttributes, index, gVar.f10298n);
                    break;
                case 4:
                    gVar.f10297m = f(obtainStyledAttributes, index, gVar.f10297m);
                    break;
                case 5:
                    gVar.f10306v = obtainStyledAttributes.getString(index);
                    break;
                case 6:
                    gVar.f10310z = obtainStyledAttributes.getDimensionPixelOffset(index, gVar.f10310z);
                    break;
                case 7:
                    gVar.A = obtainStyledAttributes.getDimensionPixelOffset(index, gVar.A);
                    break;
                case 8:
                    gVar.G = obtainStyledAttributes.getDimensionPixelSize(index, gVar.G);
                    break;
                case 9:
                    gVar.f10303s = f(obtainStyledAttributes, index, gVar.f10303s);
                    break;
                case 10:
                    gVar.f10302r = f(obtainStyledAttributes, index, gVar.f10302r);
                    break;
                case 11:
                    gVar.L = obtainStyledAttributes.getDimensionPixelSize(index, gVar.L);
                    break;
                case 12:
                    gVar.M = obtainStyledAttributes.getDimensionPixelSize(index, gVar.M);
                    break;
                case 13:
                    gVar.I = obtainStyledAttributes.getDimensionPixelSize(index, gVar.I);
                    break;
                case 14:
                    gVar.K = obtainStyledAttributes.getDimensionPixelSize(index, gVar.K);
                    break;
                case 15:
                    gVar.N = obtainStyledAttributes.getDimensionPixelSize(index, gVar.N);
                    break;
                case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                    gVar.J = obtainStyledAttributes.getDimensionPixelSize(index, gVar.J);
                    break;
                case 17:
                    gVar.f10284d = obtainStyledAttributes.getDimensionPixelOffset(index, gVar.f10284d);
                    break;
                case 18:
                    gVar.f10286e = obtainStyledAttributes.getDimensionPixelOffset(index, gVar.f10286e);
                    break;
                case 19:
                    gVar.f10288f = obtainStyledAttributes.getFloat(index, gVar.f10288f);
                    break;
                case 20:
                    gVar.f10304t = obtainStyledAttributes.getFloat(index, gVar.f10304t);
                    break;
                case 21:
                    gVar.f10282c = obtainStyledAttributes.getLayoutDimension(index, gVar.f10282c);
                    break;
                case 22:
                    int i11 = obtainStyledAttributes.getInt(index, iVar.f10316a);
                    iVar.f10316a = i11;
                    iVar.f10316a = f10332d[i11];
                    break;
                case 23:
                    gVar.f10280b = obtainStyledAttributes.getLayoutDimension(index, gVar.f10280b);
                    break;
                case 24:
                    gVar.C = obtainStyledAttributes.getDimensionPixelSize(index, gVar.C);
                    break;
                case 25:
                    gVar.f10290g = f(obtainStyledAttributes, index, gVar.f10290g);
                    break;
                case 26:
                    gVar.h = f(obtainStyledAttributes, index, gVar.h);
                    break;
                case 27:
                    gVar.B = obtainStyledAttributes.getInt(index, gVar.B);
                    break;
                case 28:
                    gVar.D = obtainStyledAttributes.getDimensionPixelSize(index, gVar.D);
                    break;
                case 29:
                    gVar.f10293i = f(obtainStyledAttributes, index, gVar.f10293i);
                    break;
                case 30:
                    gVar.f10294j = f(obtainStyledAttributes, index, gVar.f10294j);
                    break;
                case 31:
                    gVar.H = obtainStyledAttributes.getDimensionPixelSize(index, gVar.H);
                    break;
                case PeerConnectionFactory.Options.ADAPTER_TYPE_ANY /* 32 */:
                    gVar.f10300p = f(obtainStyledAttributes, index, gVar.f10300p);
                    break;
                case 33:
                    gVar.f10301q = f(obtainStyledAttributes, index, gVar.f10301q);
                    break;
                case 34:
                    gVar.E = obtainStyledAttributes.getDimensionPixelSize(index, gVar.E);
                    break;
                case 35:
                    gVar.f10296l = f(obtainStyledAttributes, index, gVar.f10296l);
                    break;
                case 36:
                    gVar.f10295k = f(obtainStyledAttributes, index, gVar.f10295k);
                    break;
                case 37:
                    gVar.f10305u = obtainStyledAttributes.getFloat(index, gVar.f10305u);
                    break;
                case 38:
                    fVar.f10271a = obtainStyledAttributes.getResourceId(index, fVar.f10271a);
                    break;
                case 39:
                    gVar.P = obtainStyledAttributes.getFloat(index, gVar.P);
                    break;
                case 40:
                    gVar.O = obtainStyledAttributes.getFloat(index, gVar.O);
                    break;
                case 41:
                    gVar.Q = obtainStyledAttributes.getInt(index, gVar.Q);
                    break;
                case 42:
                    gVar.R = obtainStyledAttributes.getInt(index, gVar.R);
                    break;
                case 43:
                    iVar.f10318c = obtainStyledAttributes.getFloat(index, iVar.f10318c);
                    break;
                case IjkMediaMeta.FF_PROFILE_H264_CAVLC_444 /* 44 */:
                    jVar.f10330k = true;
                    jVar.f10331l = obtainStyledAttributes.getDimension(index, jVar.f10331l);
                    break;
                case 45:
                    jVar.f10322b = obtainStyledAttributes.getFloat(index, jVar.f10322b);
                    break;
                case 46:
                    jVar.f10323c = obtainStyledAttributes.getFloat(index, jVar.f10323c);
                    break;
                case 47:
                    jVar.f10324d = obtainStyledAttributes.getFloat(index, jVar.f10324d);
                    break;
                case 48:
                    jVar.f10325e = obtainStyledAttributes.getFloat(index, jVar.f10325e);
                    break;
                case 49:
                    jVar.f10326f = obtainStyledAttributes.getDimension(index, jVar.f10326f);
                    break;
                case l1.k.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY /* 50 */:
                    jVar.f10327g = obtainStyledAttributes.getDimension(index, jVar.f10327g);
                    break;
                case 51:
                    jVar.h = obtainStyledAttributes.getDimension(index, jVar.h);
                    break;
                case 52:
                    jVar.f10328i = obtainStyledAttributes.getDimension(index, jVar.f10328i);
                    break;
                case 53:
                    jVar.f10329j = obtainStyledAttributes.getDimension(index, jVar.f10329j);
                    break;
                case 54:
                    gVar.S = obtainStyledAttributes.getInt(index, gVar.S);
                    break;
                case 55:
                    gVar.T = obtainStyledAttributes.getInt(index, gVar.T);
                    break;
                case 56:
                    gVar.U = obtainStyledAttributes.getDimensionPixelSize(index, gVar.U);
                    break;
                case 57:
                    gVar.V = obtainStyledAttributes.getDimensionPixelSize(index, gVar.V);
                    break;
                case 58:
                    gVar.W = obtainStyledAttributes.getDimensionPixelSize(index, gVar.W);
                    break;
                case 59:
                    gVar.X = obtainStyledAttributes.getDimensionPixelSize(index, gVar.X);
                    break;
                case 60:
                    jVar.f10321a = obtainStyledAttributes.getFloat(index, jVar.f10321a);
                    break;
                case 61:
                    gVar.f10307w = f(obtainStyledAttributes, index, gVar.f10307w);
                    break;
                case 62:
                    gVar.f10308x = obtainStyledAttributes.getDimensionPixelSize(index, gVar.f10308x);
                    break;
                case 63:
                    gVar.f10309y = obtainStyledAttributes.getFloat(index, gVar.f10309y);
                    break;
                case EglBase.EGL_OPENGL_ES3_BIT /* 64 */:
                    hVar.f10312a = f(obtainStyledAttributes, index, hVar.f10312a);
                    break;
                case 65:
                    if (obtainStyledAttributes.peekValue(index).type == 3) {
                        obtainStyledAttributes.getString(index);
                        hVar.getClass();
                        break;
                    } else {
                        String str = u.a.f8989a[obtainStyledAttributes.getInteger(index, 0)];
                        hVar.getClass();
                        break;
                    }
                case IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
                    obtainStyledAttributes.getInt(index, 0);
                    hVar.getClass();
                    break;
                case 67:
                    hVar.f10315d = obtainStyledAttributes.getFloat(index, hVar.f10315d);
                    break;
                case 68:
                    iVar.f10319d = obtainStyledAttributes.getFloat(index, iVar.f10319d);
                    break;
                case 69:
                    gVar.Y = obtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 70:
                    gVar.Z = obtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    gVar.f10279a0 = obtainStyledAttributes.getInt(index, gVar.f10279a0);
                    break;
                case 73:
                    gVar.f10281b0 = obtainStyledAttributes.getDimensionPixelSize(index, gVar.f10281b0);
                    break;
                case 74:
                    gVar.f10287e0 = obtainStyledAttributes.getString(index);
                    break;
                case 75:
                    gVar.i0 = obtainStyledAttributes.getBoolean(index, gVar.i0);
                    break;
                case 76:
                    hVar.f10313b = obtainStyledAttributes.getInt(index, hVar.f10313b);
                    break;
                case IjkMediaMeta.FF_PROFILE_H264_MAIN /* 77 */:
                    gVar.f10289f0 = obtainStyledAttributes.getString(index);
                    break;
                case 78:
                    iVar.f10317b = obtainStyledAttributes.getInt(index, iVar.f10317b);
                    break;
                case 79:
                    hVar.f10314c = obtainStyledAttributes.getFloat(index, hVar.f10314c);
                    break;
                case 80:
                    gVar.f10291g0 = obtainStyledAttributes.getBoolean(index, gVar.f10291g0);
                    break;
                case 81:
                    gVar.f10292h0 = obtainStyledAttributes.getBoolean(index, gVar.f10292h0);
                    break;
                case 82:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                    break;
            }
        }
        obtainStyledAttributes.recycle();
        return fVar;
    }

    public static int f(TypedArray typedArray, int i9, int i10) {
        int resourceId = typedArray.getResourceId(i9, i10);
        return resourceId == -1 ? typedArray.getInt(i9, -1) : resourceId;
    }

    public final void a(ConstraintLayout constraintLayout) {
        int i9;
        HashSet hashSet;
        int i10;
        int i11;
        String str;
        k kVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap hashMap = kVar.f10336c;
        HashSet hashSet2 = new HashSet(hashMap.keySet());
        int i12 = 0;
        while (i12 < childCount) {
            View childAt = constraintLayout.getChildAt(i12);
            int id = childAt.getId();
            if (!hashMap.containsKey(Integer.valueOf(id))) {
                StringBuilder sb = new StringBuilder("id unknown ");
                try {
                    str = childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                    str = "UNKNOWN";
                }
                sb.append(str);
                Log.w("ConstraintSet", sb.toString());
            } else {
                if (kVar.f10335b && id == -1) {
                    m7.c.i("All children of ConstraintLayout must have ids to use ConstraintSet");
                    return;
                }
                if (id != -1) {
                    if (hashMap.containsKey(Integer.valueOf(id))) {
                        hashSet2.remove(Integer.valueOf(id));
                        f fVar = (f) hashMap.get(Integer.valueOf(id));
                        if (childAt instanceof Barrier) {
                            fVar.f10274d.f10283c0 = 1;
                        }
                        g gVar = fVar.f10274d;
                        i iVar = fVar.f10272b;
                        j jVar = fVar.f10275e;
                        int i13 = gVar.f10283c0;
                        if (i13 != -1 && i13 == 1) {
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.setType(gVar.f10279a0);
                            barrier.setMargin(gVar.f10281b0);
                            barrier.setAllowsGoneWidget(gVar.i0);
                            int[] iArr = gVar.f10285d0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str2 = gVar.f10287e0;
                                if (str2 != null) {
                                    int[] c9 = c(barrier, str2);
                                    gVar.f10285d0 = c9;
                                    barrier.setReferencedIds(c9);
                                }
                            }
                        }
                        d dVar = (d) childAt.getLayoutParams();
                        dVar.a();
                        fVar.a(dVar);
                        HashMap hashMap2 = fVar.f10276f;
                        Class<?> cls = childAt.getClass();
                        for (String str3 : hashMap2.keySet()) {
                            a aVar = (a) hashMap2.get(str3);
                            int i14 = childCount;
                            String b9 = t.a.b("set", str3);
                            HashSet hashSet3 = hashSet2;
                            try {
                                int a9 = v.h.a(aVar.f10218a);
                                Class<?> cls2 = Integer.TYPE;
                                Class<?> cls3 = Float.TYPE;
                                switch (a9) {
                                    case 0:
                                        i11 = i12;
                                        cls.getMethod(b9, cls2).invoke(childAt, Integer.valueOf(aVar.f10219b));
                                        break;
                                    case 1:
                                        i11 = i12;
                                        cls.getMethod(b9, cls3).invoke(childAt, Float.valueOf(aVar.f10220c));
                                        break;
                                    case 2:
                                        i11 = i12;
                                        cls.getMethod(b9, cls2).invoke(childAt, Integer.valueOf(aVar.f10223f));
                                        break;
                                    case 3:
                                        i11 = i12;
                                        Method method = cls.getMethod(b9, Drawable.class);
                                        ColorDrawable colorDrawable = new ColorDrawable();
                                        colorDrawable.setColor(aVar.f10223f);
                                        method.invoke(childAt, colorDrawable);
                                        break;
                                    case 4:
                                        i11 = i12;
                                        cls.getMethod(b9, CharSequence.class).invoke(childAt, aVar.f10221d);
                                        break;
                                    case 5:
                                        i11 = i12;
                                        cls.getMethod(b9, Boolean.TYPE).invoke(childAt, Boolean.valueOf(aVar.f10222e));
                                        break;
                                    case 6:
                                        i11 = i12;
                                        try {
                                            cls.getMethod(b9, cls3).invoke(childAt, Float.valueOf(aVar.f10220c));
                                        } catch (IllegalAccessException e9) {
                                            e = e9;
                                            StringBuilder r8 = androidx.activity.g.r(" Custom Attribute \"", str3, "\" not found on ");
                                            r8.append(cls.getName());
                                            Log.e("TransitionLayout", r8.toString());
                                            e.printStackTrace();
                                            childCount = i14;
                                            hashSet2 = hashSet3;
                                            i12 = i11;
                                        } catch (NoSuchMethodException e10) {
                                            e = e10;
                                            Log.e("TransitionLayout", e.getMessage());
                                            Log.e("TransitionLayout", " Custom Attribute \"" + str3 + "\" not found on " + cls.getName());
                                            Log.e("TransitionLayout", cls.getName() + " must have a method " + b9);
                                            childCount = i14;
                                            hashSet2 = hashSet3;
                                            i12 = i11;
                                        } catch (InvocationTargetException e11) {
                                            e = e11;
                                            StringBuilder r9 = androidx.activity.g.r(" Custom Attribute \"", str3, "\" not found on ");
                                            r9.append(cls.getName());
                                            Log.e("TransitionLayout", r9.toString());
                                            e.printStackTrace();
                                            childCount = i14;
                                            hashSet2 = hashSet3;
                                            i12 = i11;
                                        }
                                    default:
                                        i11 = i12;
                                        break;
                                }
                            } catch (IllegalAccessException e12) {
                                e = e12;
                                i11 = i12;
                            } catch (NoSuchMethodException e13) {
                                e = e13;
                                i11 = i12;
                            } catch (InvocationTargetException e14) {
                                e = e14;
                                i11 = i12;
                            }
                            childCount = i14;
                            hashSet2 = hashSet3;
                            i12 = i11;
                        }
                        i9 = childCount;
                        hashSet = hashSet2;
                        i10 = i12;
                        childAt.setLayoutParams(dVar);
                        if (iVar.f10317b == 0) {
                            childAt.setVisibility(iVar.f10316a);
                        }
                        childAt.setAlpha(iVar.f10318c);
                        childAt.setRotation(jVar.f10321a);
                        childAt.setRotationX(jVar.f10322b);
                        childAt.setRotationY(jVar.f10323c);
                        childAt.setScaleX(jVar.f10324d);
                        childAt.setScaleY(jVar.f10325e);
                        if (!Float.isNaN(jVar.f10326f)) {
                            childAt.setPivotX(jVar.f10326f);
                        }
                        if (!Float.isNaN(jVar.f10327g)) {
                            childAt.setPivotY(jVar.f10327g);
                        }
                        childAt.setTranslationX(jVar.h);
                        childAt.setTranslationY(jVar.f10328i);
                        childAt.setTranslationZ(jVar.f10329j);
                        if (jVar.f10330k) {
                            childAt.setElevation(jVar.f10331l);
                        }
                    } else {
                        i9 = childCount;
                        hashSet = hashSet2;
                        i10 = i12;
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                    i12 = i10 + 1;
                    kVar = this;
                    childCount = i9;
                    hashSet2 = hashSet;
                }
            }
            i9 = childCount;
            hashSet = hashSet2;
            i10 = i12;
            i12 = i10 + 1;
            kVar = this;
            childCount = i9;
            hashSet2 = hashSet;
        }
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            f fVar2 = (f) hashMap.get(num);
            g gVar2 = fVar2.f10274d;
            int i15 = gVar2.f10283c0;
            if (i15 != -1 && i15 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                int[] iArr2 = gVar2.f10285d0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str4 = gVar2.f10287e0;
                    if (str4 != null) {
                        int[] c10 = c(barrier2, str4);
                        gVar2.f10285d0 = c10;
                        barrier2.setReferencedIds(c10);
                    }
                }
                barrier2.setType(gVar2.f10279a0);
                barrier2.setMargin(gVar2.f10281b0);
                d a10 = ConstraintLayout.a();
                barrier2.g();
                fVar2.a(a10);
                constraintLayout.addView(barrier2, a10);
            }
            if (gVar2.f10278a) {
                View mVar = new m(constraintLayout.getContext());
                mVar.setId(num.intValue());
                d a11 = ConstraintLayout.a();
                fVar2.a(a11);
                constraintLayout.addView(mVar, a11);
            }
        }
    }

    public final void b(ConstraintLayout constraintLayout) {
        k kVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap hashMap = kVar.f10336c;
        hashMap.clear();
        int i9 = 0;
        while (i9 < childCount) {
            View childAt = constraintLayout.getChildAt(i9);
            d dVar = (d) childAt.getLayoutParams();
            int id = childAt.getId();
            if (kVar.f10335b && id == -1) {
                m7.c.i("All children of ConstraintLayout must have ids to use ConstraintSet");
                return;
            }
            if (!hashMap.containsKey(Integer.valueOf(id))) {
                hashMap.put(Integer.valueOf(id), new f());
            }
            f fVar = (f) hashMap.get(Integer.valueOf(id));
            HashMap hashMap2 = new HashMap();
            Class<?> cls = childAt.getClass();
            HashMap hashMap3 = kVar.f10334a;
            for (String str : hashMap3.keySet()) {
                a aVar = (a) hashMap3.get(str);
                try {
                    if (str.equals("BackgroundColor")) {
                        hashMap2.put(str, new a(aVar, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                    } else {
                        hashMap2.put(str, new a(aVar, cls.getMethod("getMap" + str, null).invoke(childAt, null)));
                    }
                } catch (IllegalAccessException e9) {
                    e9.printStackTrace();
                } catch (NoSuchMethodException e10) {
                    e10.printStackTrace();
                } catch (InvocationTargetException e11) {
                    e11.printStackTrace();
                }
            }
            fVar.f10276f = hashMap2;
            i iVar = fVar.f10272b;
            g gVar = fVar.f10274d;
            j jVar = fVar.f10275e;
            fVar.f10271a = id;
            gVar.f10290g = dVar.f10237d;
            gVar.h = dVar.f10239e;
            gVar.f10293i = dVar.f10241f;
            gVar.f10294j = dVar.f10243g;
            gVar.f10295k = dVar.h;
            gVar.f10296l = dVar.f10246i;
            gVar.f10297m = dVar.f10247j;
            gVar.f10298n = dVar.f10249k;
            gVar.f10299o = dVar.f10251l;
            gVar.f10300p = dVar.f10255p;
            gVar.f10301q = dVar.f10256q;
            gVar.f10302r = dVar.f10257r;
            gVar.f10303s = dVar.f10258s;
            gVar.f10304t = dVar.f10265z;
            gVar.f10305u = dVar.A;
            gVar.f10306v = dVar.B;
            gVar.f10307w = dVar.f10252m;
            gVar.f10308x = dVar.f10253n;
            gVar.f10309y = dVar.f10254o;
            gVar.f10310z = dVar.P;
            gVar.A = dVar.Q;
            gVar.B = dVar.R;
            gVar.f10288f = dVar.f10235c;
            gVar.f10284d = dVar.f10231a;
            gVar.f10286e = dVar.f10233b;
            gVar.f10280b = ((ViewGroup.MarginLayoutParams) dVar).width;
            gVar.f10282c = ((ViewGroup.MarginLayoutParams) dVar).height;
            gVar.C = ((ViewGroup.MarginLayoutParams) dVar).leftMargin;
            gVar.D = ((ViewGroup.MarginLayoutParams) dVar).rightMargin;
            gVar.E = ((ViewGroup.MarginLayoutParams) dVar).topMargin;
            gVar.F = ((ViewGroup.MarginLayoutParams) dVar).bottomMargin;
            gVar.O = dVar.E;
            gVar.P = dVar.D;
            gVar.R = dVar.G;
            gVar.Q = dVar.F;
            gVar.f10291g0 = dVar.S;
            gVar.f10292h0 = dVar.T;
            gVar.S = dVar.H;
            gVar.T = dVar.I;
            gVar.U = dVar.L;
            gVar.V = dVar.M;
            gVar.W = dVar.J;
            gVar.X = dVar.K;
            gVar.Y = dVar.N;
            gVar.Z = dVar.O;
            gVar.f10289f0 = dVar.U;
            gVar.J = dVar.f10260u;
            gVar.L = dVar.f10262w;
            gVar.I = dVar.f10259t;
            gVar.K = dVar.f10261v;
            gVar.N = dVar.f10263x;
            gVar.M = dVar.f10264y;
            gVar.G = dVar.getMarginEnd();
            gVar.H = dVar.getMarginStart();
            iVar.f10316a = childAt.getVisibility();
            iVar.f10318c = childAt.getAlpha();
            jVar.f10321a = childAt.getRotation();
            jVar.f10322b = childAt.getRotationX();
            jVar.f10323c = childAt.getRotationY();
            jVar.f10324d = childAt.getScaleX();
            jVar.f10325e = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != 0.0d || pivotY != 0.0d) {
                jVar.f10326f = pivotX;
                jVar.f10327g = pivotY;
            }
            jVar.h = childAt.getTranslationX();
            jVar.f10328i = childAt.getTranslationY();
            jVar.f10329j = childAt.getTranslationZ();
            if (jVar.f10330k) {
                jVar.f10331l = childAt.getElevation();
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                gVar.i0 = barrier.f533q.f9590g0;
                gVar.f10285d0 = barrier.getReferencedIds();
                gVar.f10279a0 = barrier.getType();
                gVar.f10281b0 = barrier.getMargin();
            }
            i9++;
            kVar = this;
        }
    }

    public final void e(Context context, int i9) {
        XmlResourceParser xml = context.getResources().getXml(i9);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    f d9 = d(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        d9.f10274d.f10278a = true;
                    }
                    this.f10336c.put(Integer.valueOf(d9.f10271a), d9);
                }
            }
        } catch (IOException e9) {
            e9.printStackTrace();
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
        }
    }
}
