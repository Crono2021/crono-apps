package e0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.SparseArray;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f3001a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f3002b = new WeakHashMap(0);

    /* renamed from: c, reason: collision with root package name */
    public static final Object f3003c = new Object();

    public static void a(l lVar, int i9, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f3003c) {
            try {
                WeakHashMap weakHashMap = f3002b;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(lVar);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(lVar, sparseArray);
                }
                sparseArray.append(i9, new k(colorStateList, lVar.f2996a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00ce A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface b(android.content.Context r12, int r13, android.util.TypedValue r14, int r15, e0.b r16, boolean r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e0.o.b(android.content.Context, int, android.util.TypedValue, int, e0.b, boolean, boolean):android.graphics.Typeface");
    }
}
