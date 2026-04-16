package android.support.v4.media.session;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c8.e;
import d1.j0;
import d1.m0;
import d2.n;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import l0.f;
import n.e1;
import n.t2;
import n0.f0;
import n0.s0;
import n0.t0;
import o1.g;
import org.xmlpull.v1.XmlSerializer;
import r0.o;
import r0.p;
import r0.q;
import r0.r;
import r0.s;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class b implements g {

    /* renamed from: i, reason: collision with root package name */
    public static boolean f259i = false;

    /* renamed from: j, reason: collision with root package name */
    public static Method f260j = null;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f261k = false;

    /* renamed from: l, reason: collision with root package name */
    public static Field f262l;

    /* renamed from: m, reason: collision with root package name */
    public static long f263m;

    /* renamed from: n, reason: collision with root package name */
    public static Method f264n;

    public b() {
        new ConcurrentHashMap();
    }

    public static ActionMode.Callback A0(ActionMode.Callback callback) {
        return (!(callback instanceof s) || Build.VERSION.SDK_INT < 26) ? callback : ((s) callback).f8515a;
    }

    public static byte[] C(String str) {
        if (str.length() % 2 != 0) {
            m7.c.n("Expected a string of even length");
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i9 = 0; i9 < length; i9++) {
            int i10 = i9 * 2;
            int digit = Character.digit(str.charAt(i10), 16);
            int digit2 = Character.digit(str.charAt(i10 + 1), 16);
            if (digit == -1 || digit2 == -1) {
                m7.c.n("input is not hexadecimal");
                return null;
            }
            bArr[i9] = (byte) ((digit * 16) + digit2);
        }
        return bArr;
    }

    public static ActionMode.Callback C0(ActionMode.Callback callback, TextView textView) {
        int i9 = Build.VERSION.SDK_INT;
        return (i9 < 26 || i9 > 27 || (callback instanceof s) || callback == null) ? callback : new s(callback, textView);
    }

    public static boolean D(View view, KeyEvent keyEvent) {
        ArrayList arrayList;
        int size;
        int indexOfKey;
        WeakHashMap weakHashMap = t0.f7209a;
        if (Build.VERSION.SDK_INT < 28) {
            ArrayList arrayList2 = s0.f7196d;
            s0 s0Var = (s0) view.getTag(2131362429);
            WeakReference weakReference = null;
            if (s0Var == null) {
                s0Var = new s0();
                s0Var.f7197a = null;
                s0Var.f7198b = null;
                s0Var.f7199c = null;
                view.setTag(2131362429, s0Var);
            }
            WeakReference weakReference2 = s0Var.f7199c;
            if (weakReference2 == null || weakReference2.get() != keyEvent) {
                s0Var.f7199c = new WeakReference(keyEvent);
                if (s0Var.f7198b == null) {
                    s0Var.f7198b = new SparseArray();
                }
                SparseArray sparseArray = s0Var.f7198b;
                if (keyEvent.getAction() == 1 && (indexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference = (WeakReference) sparseArray.valueAt(indexOfKey);
                    sparseArray.removeAt(indexOfKey);
                }
                if (weakReference == null) {
                    weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
                }
                if (weakReference != null) {
                    View view2 = (View) weakReference.get();
                    if (view2 == null || !f0.b(view2) || (arrayList = (ArrayList) view2.getTag(2131362430)) == null || (size = arrayList.size() - 1) < 0) {
                        return true;
                    }
                    arrayList.get(size).getClass();
                    androidx.fragment.app.a.c();
                    return false;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean E(n0.k r7, android.view.View r8, android.view.Window.Callback r9, android.view.KeyEvent r10) {
        /*
            r0 = 0
            if (r7 != 0) goto L5
            goto Le7
        L5:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L10
            boolean r7 = r7.b(r10)
            return r7
        L10:
            boolean r1 = r9 instanceof android.app.Activity
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L84
            android.app.Activity r9 = (android.app.Activity) r9
            r9.onUserInteraction()
            android.view.Window r7 = r9.getWindow()
            r8 = 8
            boolean r8 = r7.hasFeature(r8)
            if (r8 == 0) goto L67
            android.app.ActionBar r8 = r9.getActionBar()
            int r1 = r10.getKeyCode()
            r4 = 82
            if (r1 != r4) goto L67
            if (r8 == 0) goto L67
            boolean r1 = android.support.v4.media.session.b.f259i
            if (r1 != 0) goto L4d
            java.lang.Class r1 = r8.getClass()     // Catch: java.lang.NoSuchMethodException -> L4b
            java.lang.String r4 = "onMenuKeyEvent"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch: java.lang.NoSuchMethodException -> L4b
            java.lang.Class<android.view.KeyEvent> r6 = android.view.KeyEvent.class
            r5[r0] = r6     // Catch: java.lang.NoSuchMethodException -> L4b
            java.lang.reflect.Method r1 = r1.getMethod(r4, r5)     // Catch: java.lang.NoSuchMethodException -> L4b
            android.support.v4.media.session.b.f260j = r1     // Catch: java.lang.NoSuchMethodException -> L4b
        L4b:
            android.support.v4.media.session.b.f259i = r3
        L4d:
            java.lang.reflect.Method r1 = android.support.v4.media.session.b.f260j
            if (r1 == 0) goto L64
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L63
            r4[r0] = r10     // Catch: java.lang.Throwable -> L63
            java.lang.Object r8 = r1.invoke(r8, r4)     // Catch: java.lang.Throwable -> L63
            if (r8 != 0) goto L5c
            goto L64
        L5c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L63
            boolean r0 = r8.booleanValue()     // Catch: java.lang.Throwable -> L63
            goto L64
        L63:
        L64:
            if (r0 == 0) goto L67
            goto L83
        L67:
            boolean r8 = r7.superDispatchKeyEvent(r10)
            if (r8 == 0) goto L6e
            goto L83
        L6e:
            android.view.View r7 = r7.getDecorView()
            boolean r8 = n0.t0.b(r7, r10)
            if (r8 == 0) goto L79
            goto L83
        L79:
            if (r7 == 0) goto L7f
            android.view.KeyEvent$DispatcherState r2 = r7.getKeyDispatcherState()
        L7f:
            boolean r3 = r10.dispatch(r9, r2, r9)
        L83:
            return r3
        L84:
            boolean r1 = r9 instanceof android.app.Dialog
            if (r1 == 0) goto Ld8
            android.app.Dialog r9 = (android.app.Dialog) r9
            boolean r7 = android.support.v4.media.session.b.f261k
            if (r7 != 0) goto L9d
            java.lang.Class<android.app.Dialog> r7 = android.app.Dialog.class
            java.lang.String r8 = "mOnKeyListener"
            java.lang.reflect.Field r7 = r7.getDeclaredField(r8)     // Catch: java.lang.NoSuchFieldException -> L9b
            android.support.v4.media.session.b.f262l = r7     // Catch: java.lang.NoSuchFieldException -> L9b
            r7.setAccessible(r3)     // Catch: java.lang.NoSuchFieldException -> L9b
        L9b:
            android.support.v4.media.session.b.f261k = r3
        L9d:
            java.lang.reflect.Field r7 = android.support.v4.media.session.b.f262l
            if (r7 == 0) goto La9
            java.lang.Object r7 = r7.get(r9)     // Catch: java.lang.IllegalAccessException -> La8
            android.content.DialogInterface$OnKeyListener r7 = (android.content.DialogInterface.OnKeyListener) r7     // Catch: java.lang.IllegalAccessException -> La8
            goto Laa
        La8:
        La9:
            r7 = r2
        Laa:
            if (r7 == 0) goto Lb7
            int r8 = r10.getKeyCode()
            boolean r7 = r7.onKey(r9, r8, r10)
            if (r7 == 0) goto Lb7
            goto Ld7
        Lb7:
            android.view.Window r7 = r9.getWindow()
            boolean r8 = r7.superDispatchKeyEvent(r10)
            if (r8 == 0) goto Lc2
            goto Ld7
        Lc2:
            android.view.View r7 = r7.getDecorView()
            boolean r8 = n0.t0.b(r7, r10)
            if (r8 == 0) goto Lcd
            goto Ld7
        Lcd:
            if (r7 == 0) goto Ld3
            android.view.KeyEvent$DispatcherState r2 = r7.getKeyDispatcherState()
        Ld3:
            boolean r3 = r10.dispatch(r9, r2, r9)
        Ld7:
            return r3
        Ld8:
            if (r8 == 0) goto Le0
            boolean r8 = n0.t0.b(r8, r10)
            if (r8 != 0) goto Le6
        Le0:
            boolean r7 = r7.b(r10)
            if (r7 == 0) goto Le7
        Le6:
            return r3
        Le7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.b.E(n0.k, android.view.View, android.view.Window$Callback, android.view.KeyEvent):boolean");
    }

    public static String F(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b9 : bArr) {
            int i9 = b9 & 255;
            sb.append("0123456789abcdef".charAt(i9 / 16));
            sb.append("0123456789abcdef".charAt(i9 % 16));
        }
        return sb.toString();
    }

    public static boolean G(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static k0.g H(k0.g[] gVarArr, int i9) {
        int i10 = (i9 & 1) == 0 ? 400 : 700;
        boolean z8 = (i9 & 2) != 0;
        k0.g gVar = null;
        int i11 = Integer.MAX_VALUE;
        for (k0.g gVar2 : gVarArr) {
            int abs = (Math.abs(gVar2.f5521c - i10) * 2) + (gVar2.f5522d == z8 ? 0 : 1);
            if (gVar == null || i11 > abs) {
                gVar = gVar2;
                i11 = abs;
            }
        }
        return gVar;
    }

    public static Drawable I(Context context, int i9) {
        return t2.d().f(context, i9);
    }

    public static float L(String[] strArr, int i9) {
        float parseFloat = Float.parseFloat(strArr[i9]);
        if (parseFloat >= 0.0f && parseFloat <= 1.0f) {
            return parseFloat;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
    }

    public static f R(e1 e1Var) {
        int i9;
        int i10;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            return new f(r.c(e1Var));
        }
        TextPaint textPaint = new TextPaint(e1Var.getPaint());
        if (i11 >= 23) {
            i9 = 1;
            i10 = 1;
        } else {
            i9 = 0;
            i10 = 0;
        }
        TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        if (i11 >= 23) {
            i9 = p.a(e1Var);
            i10 = p.d(e1Var);
        }
        if (e1Var.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else if (i11 < 28 || (e1Var.getInputType() & 15) != 3) {
            boolean z8 = o.b(e1Var) == 1;
            switch (o.c(e1Var)) {
                case 2:
                    textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                    break;
                case 3:
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                    break;
                case 4:
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                    break;
                case 5:
                    textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                    break;
                case 6:
                    break;
                case 7:
                    textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    break;
                default:
                    if (z8) {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                        break;
                    }
                    break;
            }
        } else {
            byte directionality = Character.getDirectionality(r.b(q.a(o.d(e1Var)))[0].codePointAt(0));
            textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        return new f(textPaint, textDirectionHeuristic, i9, i10);
    }

    public static int U(long j5) {
        return (int) (j5 ^ (j5 >>> 32));
    }

    public static boolean V() {
        boolean isEnabled;
        try {
            if (f264n == null) {
                isEnabled = Trace.isEnabled();
                return isEnabled;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (f264n == null) {
                f263m = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f264n = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f264n.invoke(null, Long.valueOf(f263m))).booleanValue();
        } catch (Exception e9) {
            if (!(e9 instanceof InvocationTargetException)) {
                Log.v("Trace", "Unable to call isTagEnabled via reflection", e9);
                return false;
            }
            Throwable cause = e9.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public static boolean X(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public static boolean Y(byte b9) {
        return b9 > -65;
    }

    public static List b0(Object obj) {
        List singletonList = Collections.singletonList(obj);
        singletonList.getClass();
        return singletonList;
    }

    public static Typeface c0(Configuration configuration, Typeface typeface) {
        int i9;
        int i10;
        int weight;
        int i11;
        Typeface create;
        if (Build.VERSION.SDK_INT < 31) {
            return null;
        }
        i9 = configuration.fontWeightAdjustment;
        if (i9 == Integer.MAX_VALUE) {
            return null;
        }
        i10 = configuration.fontWeightAdjustment;
        if (i10 == 0 || typeface == null) {
            return null;
        }
        weight = typeface.getWeight();
        i11 = configuration.fontWeightAdjustment;
        create = Typeface.create(typeface, com.bumptech.glide.c.i(i11 + weight, 1, IjkMediaCodecInfo.RANK_MAX), typeface.isItalic());
        return create;
    }

    public static final int d0(e8.c cVar) {
        c8.a aVar = e.f1727i;
        cVar.getClass();
        if (cVar.isEmpty()) {
            androidx.fragment.app.a.n(cVar, "Cannot get random in empty range: ");
            return 0;
        }
        int i9 = cVar.f3159j;
        int i10 = cVar.f3158i;
        if (i9 < Integer.MAX_VALUE) {
            return e.f1727i.c(i10, i9 + 1);
        }
        if (i10 <= Integer.MIN_VALUE) {
            return e.f1727i.b();
        }
        return e.f1727i.c(i10 - 1, i9) + 1;
    }

    public static void h(Throwable th, Throwable th2) {
        th.getClass();
        th2.getClass();
        if (th != th2) {
            Integer num = w7.a.f9973a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = v7.a.f9588a;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    public static String i(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b9 : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b9)));
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x003c, code lost:
    
        if (r3 != 1918990112) goto L4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01bc A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v14, types: [c2.e] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList k0(g1.p r30) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.b.k0(g1.p):java.util.ArrayList");
    }

    public static void l0(Context context, String str) {
        if (str.equals("")) {
            context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
            return;
        }
        try {
            FileOutputStream openFileOutput = context.openFileOutput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file", 0);
            XmlSerializer newSerializer = Xml.newSerializer();
            try {
                try {
                    try {
                        newSerializer.setOutput(openFileOutput, null);
                        newSerializer.startDocument("UTF-8", Boolean.TRUE);
                        newSerializer.startTag(null, "locales");
                        newSerializer.attribute(null, "application_locales", str);
                        newSerializer.endTag(null, "locales");
                        newSerializer.endDocument();
                        Log.d("AppLocalesStorageHelper", "Storing App Locales : app-locales: " + str + " persisted successfully.");
                        if (openFileOutput != null) {
                            openFileOutput.close();
                        }
                    } catch (Throwable th) {
                        if (openFileOutput != null) {
                            try {
                                openFileOutput.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e9) {
                    Log.w("AppLocalesStorageHelper", "Storing App Locales : Failed to persist app-locales: ".concat(str), e9);
                    if (openFileOutput != null) {
                        openFileOutput.close();
                    }
                }
            } catch (IOException unused2) {
            }
        } catch (FileNotFoundException unused3) {
            Log.w("AppLocalesStorageHelper", "Storing App Locales : FileNotFoundException: Cannot open file androidx.appcompat.app.AppCompatDelegate.application_locales_record_file for writing ");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
    
        if (r3 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x002d, code lost:
    
        if (r6 != 4) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003a, code lost:
    
        if (r4.getName().equals("locales") == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x003c, code lost:
    
        r2 = r4.getAttributeValue(null, "application_locales");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0050, code lost:
    
        if (r3 == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m0(android.content.Context r9) {
        /*
            java.lang.String r0 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.lang.String r1 = "AppLocalesStorageHelper"
            java.lang.String r2 = ""
            java.io.FileInputStream r3 = r9.openFileInput(r0)     // Catch: java.io.FileNotFoundException -> L6d
            org.xmlpull.v1.XmlPullParser r4 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L4b
            java.lang.String r5 = "UTF-8"
            r4.setInput(r3, r5)     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L4b
            int r5 = r4.getDepth()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L4b
        L17:
            int r6 = r4.next()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L4b
            r7 = 1
            if (r6 == r7) goto L43
            r7 = 3
            if (r6 != r7) goto L2a
            int r8 = r4.getDepth()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L4b
            if (r8 <= r5) goto L43
            goto L2a
        L28:
            r9 = move-exception
            goto L67
        L2a:
            if (r6 == r7) goto L17
            r7 = 4
            if (r6 != r7) goto L30
            goto L17
        L30:
            java.lang.String r6 = r4.getName()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L4b
            java.lang.String r7 = "locales"
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L4b
            if (r6 == 0) goto L17
            java.lang.String r5 = "application_locales"
            r6 = 0
            java.lang.String r2 = r4.getAttributeValue(r6, r5)     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L4b
        L43:
            if (r3 == 0) goto L53
        L45:
            r3.close()     // Catch: java.io.IOException -> L49
            goto L53
        L49:
            goto L53
        L4b:
            java.lang.String r4 = "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r1, r4)     // Catch: java.lang.Throwable -> L28
            if (r3 == 0) goto L53
            goto L45
        L53:
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L63
            java.lang.String r9 = "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: "
            java.lang.String r9 = r9.concat(r2)
            android.util.Log.d(r1, r9)
            goto L66
        L63:
            r9.deleteFile(r0)
        L66:
            return r2
        L67:
            if (r3 == 0) goto L6c
            r3.close()     // Catch: java.io.IOException -> L6c
        L6c:
            throw r9
        L6d:
            java.lang.String r9 = "Reading app Locales : Locales record file not found: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r1, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.b.m0(android.content.Context):java.lang.String");
    }

    public static int n0(Context context, int i9, int i10) {
        TypedValue Q = com.bumptech.glide.c.Q(context, i9);
        return (Q == null || Q.type != 16) ? i10 : Q.data;
    }

    public static void o(String str, boolean z8) {
        if (z8) {
            return;
        }
        m7.c.n(str);
    }

    public static TimeInterpolator o0(Context context, int i9, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i9, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            m7.c.n("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
            return null;
        }
        String valueOf = String.valueOf(typedValue.string);
        if (!X(valueOf, "cubic-bezier") && !X(valueOf, "path")) {
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        if (!X(valueOf, "cubic-bezier")) {
            if (X(valueOf, "path")) {
                return p0.a.c(a.a.n(valueOf.substring(5, valueOf.length() - 1)));
            }
            m7.c.n("Invalid motion easing type: ".concat(valueOf));
            return null;
        }
        String[] split = valueOf.substring(13, valueOf.length() - 1).split(",");
        if (split.length == 4) {
            return p0.a.b(L(split, 0), L(split, 1), L(split, 2), L(split, 3));
        }
        androidx.fragment.app.a.d(split.length, "Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: ");
        return null;
    }

    public static void p(int i9) {
        if (i9 >= 0) {
            return;
        }
        m7.c.d();
    }

    public static boolean q(n nVar) {
        g1.p pVar = new g1.p(8);
        int i9 = j3.f.a(nVar, pVar).f5420a;
        if (i9 != 1380533830 && i9 != 1380333108) {
            return false;
        }
        nVar.a(0, 4, pVar.f3699a);
        pVar.F(0);
        int g9 = pVar.g();
        if (g9 == 1463899717) {
            return true;
        }
        g1.a.p("WavHeaderReader", "Unsupported form type: " + g9);
        return false;
    }

    public static void q0(TextView textView, int i9) {
        p(i9);
        if (Build.VERSION.SDK_INT >= 28) {
            r.d(textView, i9);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i10 = r0.n.a(textView) ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i9 > Math.abs(i10)) {
            textView.setPadding(textView.getPaddingLeft(), i9 + i10, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void r(Object obj, String str) {
        if (obj != null) {
            return;
        }
        m7.c.o(str);
    }

    public static void r0(TextView textView, int i9) {
        p(i9);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i10 = r0.n.a(textView) ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i9 > Math.abs(i10)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i9 - i10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0084 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int s(android.content.Context r9, java.lang.String r10) {
        /*
            int r0 = android.os.Process.myPid()
            int r1 = android.os.Process.myUid()
            java.lang.String r2 = r9.getPackageName()
            int r0 = r9.checkPermission(r10, r0, r1)
            r3 = -1
            if (r0 != r3) goto L14
            goto L37
        L14:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 23
            if (r0 < r4) goto L1f
            java.lang.String r10 = c0.e.d(r10)
            goto L20
        L1f:
            r10 = 0
        L20:
            r5 = 0
            if (r10 != 0) goto L24
            goto L83
        L24:
            if (r2 != 0) goto L38
            android.content.pm.PackageManager r2 = r9.getPackageManager()
            java.lang.String[] r2 = r2.getPackagesForUid(r1)
            if (r2 == 0) goto L37
            int r6 = r2.length
            if (r6 > 0) goto L34
            goto L37
        L34:
            r2 = r2[r5]
            goto L38
        L37:
            return r3
        L38:
            int r3 = android.os.Process.myUid()
            java.lang.String r6 = r9.getPackageName()
            r7 = 1
            java.lang.Class<android.app.AppOpsManager> r8 = android.app.AppOpsManager.class
            if (r3 != r1) goto L74
            boolean r3 = m0.a.a(r6, r2)
            if (r3 == 0) goto L74
            r3 = 29
            if (r0 < r3) goto L67
            android.app.AppOpsManager r0 = c0.f.c(r9)
            int r3 = android.os.Binder.getCallingUid()
            int r2 = c0.f.a(r0, r10, r3, r2)
            if (r2 == 0) goto L5e
            goto L81
        L5e:
            java.lang.String r9 = c0.f.b(r9)
            int r2 = c0.f.a(r0, r10, r1, r9)
            goto L81
        L67:
            if (r0 < r4) goto L80
            java.lang.Object r9 = c0.e.a(r9, r8)
            android.app.AppOpsManager r9 = (android.app.AppOpsManager) r9
            int r7 = c0.e.c(r9, r10, r2)
            goto L80
        L74:
            if (r0 < r4) goto L80
            java.lang.Object r9 = c0.e.a(r9, r8)
            android.app.AppOpsManager r9 = (android.app.AppOpsManager) r9
            int r7 = c0.e.c(r9, r10, r2)
        L80:
            r2 = r7
        L81:
            if (r2 != 0) goto L84
        L83:
            return r5
        L84:
            r9 = -2
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.b.s(android.content.Context, java.lang.String):int");
    }

    public static void s0(m1.b bVar, float f9) {
        r.a aVar = (r.a) bVar.f6510j;
        CardView cardView = (CardView) bVar.f6511k;
        boolean useCompatPadding = cardView.getUseCompatPadding();
        boolean preventCornerOverlap = cardView.getPreventCornerOverlap();
        if (f9 != aVar.f8481e || aVar.f8482f != useCompatPadding || aVar.f8483g != preventCornerOverlap) {
            aVar.f8481e = f9;
            aVar.f8482f = useCompatPadding;
            aVar.f8483g = preventCornerOverlap;
            aVar.b(null);
            aVar.invalidateSelf();
        }
        if (!cardView.getUseCompatPadding()) {
            bVar.x(0, 0, 0, 0);
            return;
        }
        r.a aVar2 = (r.a) bVar.f6510j;
        float f10 = aVar2.f8481e;
        float f11 = aVar2.f8477a;
        int ceil = (int) Math.ceil(r.b.a(f10, f11, cardView.getPreventCornerOverlap()));
        int ceil2 = (int) Math.ceil(r.b.b(f10, f11, cardView.getPreventCornerOverlap()));
        bVar.x(ceil, ceil2, ceil, ceil2);
    }

    public static void t0(TextView textView, int i9) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i9);
        } else {
            textView.setTextAppearance(textView.getContext(), i9);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long[] v(Serializable serializable) {
        if (!(serializable instanceof int[])) {
            if (serializable instanceof long[]) {
                return (long[]) serializable;
            }
            return null;
        }
        int[] iArr = (int[]) serializable;
        long[] jArr = new long[iArr.length];
        for (int i9 = 0; i9 < iArr.length; i9++) {
            jArr[i9] = iArr[i9];
        }
        return jArr;
    }

    public static j3.f v0(int i9, n nVar, g1.p pVar) {
        j3.f a9 = j3.f.a(nVar, pVar);
        while (true) {
            int i10 = a9.f5420a;
            if (i10 == i9) {
                return a9;
            }
            androidx.activity.g.t(i10, "Ignoring unknown WAV chunk: ", "WavHeaderReader");
            long j5 = a9.f5421b;
            long j9 = 8 + j5;
            if (j5 % 2 != 0) {
                j9 = 9 + j5;
            }
            if (j9 > 2147483647L) {
                throw m0.c("Chunk is too large (~2GB+) to skip; id: " + i10);
            }
            nVar.i((int) j9);
            a9 = j3.f.a(nVar, pVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.emoji2.text.t w(android.content.Context r8) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto Ld
            androidx.emoji2.text.d r0 = new androidx.emoji2.text.d
            r1 = 2
            r0.<init>(r1)
            goto L13
        Ld:
            u5.e r0 = new u5.e
            r1 = 2
            r0.<init>(r1)
        L13:
            android.content.pm.PackageManager r1 = r8.getPackageManager()
            java.lang.String r2 = "Package manager required to locate emoji font provider"
            r(r1, r2)
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r3 = "androidx.content.action.LOAD_EMOJI_FONT"
            r2.<init>(r3)
            r3 = 0
            java.util.List r2 = r1.queryIntentContentProviders(r2, r3)
            java.util.Iterator r2 = r2.iterator()
        L2c:
            boolean r4 = r2.hasNext()
            r5 = 0
            if (r4 == 0) goto L48
            java.lang.Object r4 = r2.next()
            android.content.pm.ResolveInfo r4 = (android.content.pm.ResolveInfo) r4
            android.content.pm.ProviderInfo r4 = r4.providerInfo
            if (r4 == 0) goto L2c
            android.content.pm.ApplicationInfo r6 = r4.applicationInfo
            if (r6 == 0) goto L2c
            int r6 = r6.flags
            r7 = 1
            r6 = r6 & r7
            if (r6 != r7) goto L2c
            goto L49
        L48:
            r4 = r5
        L49:
            if (r4 != 0) goto L4d
        L4b:
            r1 = r5
            goto L7c
        L4d:
            java.lang.String r2 = r4.authority     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            java.lang.String r4 = r4.packageName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            android.content.pm.Signature[] r0 = r0.i(r1, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            r1.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            int r6 = r0.length     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
        L5b:
            if (r3 >= r6) goto L69
            r7 = r0[r3]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            byte[] r7 = r7.toByteArray()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            r1.add(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            int r3 = r3 + 1
            goto L5b
        L69:
            java.util.List r0 = java.util.Collections.singletonList(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            c7.a r1 = new c7.a     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            java.lang.String r3 = "emojicompat-emoji-font"
            r1.<init>(r2, r4, r3, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            goto L7c
        L75:
            r0 = move-exception
            java.lang.String r1 = "emoji2.text.DefaultEmojiConfig"
            android.util.Log.wtf(r1, r0)
            goto L4b
        L7c:
            if (r1 != 0) goto L7f
            goto L89
        L7f:
            androidx.emoji2.text.t r5 = new androidx.emoji2.text.t
            androidx.emoji2.text.s r0 = new androidx.emoji2.text.s
            r0.<init>(r8, r1)
            r5.<init>(r0)
        L89:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.b.w(android.content.Context):androidx.emoji2.text.t");
    }

    public static Bundle z0(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(b.class.getClassLoader());
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }

    public j0 A(l2.a aVar) {
        ByteBuffer byteBuffer = aVar.f5359m;
        byteBuffer.getClass();
        g1.a.f(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        return B(aVar, byteBuffer);
    }

    public abstract j0 B(l2.a aVar, ByteBuffer byteBuffer);

    public abstract void B0(ViewGroup.MarginLayoutParams marginLayoutParams, int i9, int i10);

    public abstract int J();

    public abstract int K();

    public abstract int M();

    public abstract int N();

    public abstract int O(View view);

    public abstract int P(CoordinatorLayout coordinatorLayout);

    public abstract int Q();

    public int S(View view) {
        return 0;
    }

    public int T() {
        return 0;
    }

    public abstract boolean W(float f9);

    public abstract boolean Z(View view);

    public abstract boolean a0(float f9, float f10);

    public abstract View e0(int i9);

    public abstract boolean f0();

    public abstract void h0(int i9);

    public abstract void i0(View view, int i9, int i10);

    public abstract void j0(View view, float f9, float f10);

    public abstract int l(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract float m(int i9);

    public boolean n() {
        return false;
    }

    public abstract int t(View view, int i9);

    public abstract int u(View view, int i9);

    public abstract boolean u0(View view, float f9);

    public abstract void w0();

    public abstract Typeface x(Context context, e0.f fVar, Resources resources, int i9);

    public abstract void x0();

    public abstract Typeface y(Context context, k0.g[] gVarArr, int i9);

    public abstract boolean y0(View view, int i9);

    public Typeface z(Context context, Resources resources, int i9, String str, int i10) {
        File z8 = com.bumptech.glide.c.z(context);
        if (z8 == null) {
            return null;
        }
        try {
            if (com.bumptech.glide.c.l(z8, resources, i9)) {
                return Typeface.createFromFile(z8.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            z8.delete();
        }
    }

    public void p0() {
    }

    public void g0(View view, int i9) {
    }
}
