package e4;

import android.graphics.Bitmap;
import android.os.Build;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import w4.n;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k {

    /* renamed from: d, reason: collision with root package name */
    public static final Bitmap.Config[] f3116d;

    /* renamed from: e, reason: collision with root package name */
    public static final Bitmap.Config[] f3117e;

    /* renamed from: f, reason: collision with root package name */
    public static final Bitmap.Config[] f3118f;

    /* renamed from: g, reason: collision with root package name */
    public static final Bitmap.Config[] f3119g;
    public static final Bitmap.Config[] h;

    /* renamed from: a, reason: collision with root package name */
    public final e f3120a = new e(1);

    /* renamed from: b, reason: collision with root package name */
    public final a5.d f3121b = new a5.d(11);

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f3122c = new HashMap();

    static {
        Bitmap.Config config;
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            int length = configArr.length - 1;
            config = Bitmap.Config.RGBA_F16;
            configArr[length] = config;
        }
        f3116d = configArr;
        f3117e = configArr;
        f3118f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f3119g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public static String c(int i9, Bitmap.Config config) {
        return "[" + i9 + "](" + config + ")";
    }

    public final void a(Integer num, Bitmap bitmap) {
        NavigableMap d9 = d(bitmap.getConfig());
        Integer num2 = (Integer) d9.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                d9.remove(num);
                return;
            } else {
                d9.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        StringBuilder sb = new StringBuilder("Tried to decrement empty size, size: ");
        sb.append(num);
        String c9 = c(n.c(bitmap), bitmap.getConfig());
        sb.append(", removed: ");
        sb.append(c9);
        sb.append(", this: ");
        sb.append(this);
        throw new NullPointerException(sb.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a7 A[EDGE_INSN: B:34:0x00a7->B:20:0x00a7 BREAK  A[LOOP:0: B:10:0x0059->B:32:0x00a4], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap b(int r11, int r12, android.graphics.Bitmap.Config r13) {
        /*
            r10 = this;
            int r0 = r11 * r12
            int r1 = w4.n.d(r13)
            int r1 = r1 * r0
            e4.e r0 = r10.f3120a
            java.lang.Object r2 = r0.f1132i
            java.util.ArrayDeque r2 = (java.util.ArrayDeque) r2
            java.lang.Object r2 = r2.poll()
            e4.h r2 = (e4.h) r2
            if (r2 != 0) goto L1a
            e4.h r2 = r0.f()
        L1a:
            e4.j r2 = (e4.j) r2
            r2.f3114b = r1
            r2.f3115c = r13
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 26
            r5 = 0
            if (r3 < r4) goto L34
            android.graphics.Bitmap$Config r3 = a5.a.A()
            boolean r3 = r3.equals(r13)
            if (r3 == 0) goto L34
            android.graphics.Bitmap$Config[] r3 = e4.k.f3117e
            goto L58
        L34:
            int[] r3 = e4.i.f3112a
            int r4 = r13.ordinal()
            r3 = r3[r4]
            r4 = 1
            if (r3 == r4) goto L56
            r6 = 2
            if (r3 == r6) goto L53
            r6 = 3
            if (r3 == r6) goto L50
            r6 = 4
            if (r3 == r6) goto L4d
            android.graphics.Bitmap$Config[] r3 = new android.graphics.Bitmap.Config[r4]
            r3[r5] = r13
            goto L58
        L4d:
            android.graphics.Bitmap$Config[] r3 = e4.k.h
            goto L58
        L50:
            android.graphics.Bitmap$Config[] r3 = e4.k.f3119g
            goto L58
        L53:
            android.graphics.Bitmap$Config[] r3 = e4.k.f3118f
            goto L58
        L56:
            android.graphics.Bitmap$Config[] r3 = e4.k.f3116d
        L58:
            int r4 = r3.length
        L59:
            if (r5 >= r4) goto La7
            r6 = r3[r5]
            java.util.NavigableMap r7 = r10.d(r6)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r1)
            java.lang.Object r7 = r7.ceilingKey(r8)
            java.lang.Integer r7 = (java.lang.Integer) r7
            if (r7 == 0) goto La4
            int r8 = r7.intValue()
            int r9 = r1 * 8
            if (r8 > r9) goto La4
            int r3 = r7.intValue()
            if (r3 != r1) goto L86
            if (r6 != 0) goto L80
            if (r13 == 0) goto La7
            goto L86
        L80:
            boolean r1 = r6.equals(r13)
            if (r1 != 0) goto La7
        L86:
            r0.c(r2)
            int r1 = r7.intValue()
            java.lang.Object r2 = r0.f1132i
            java.util.ArrayDeque r2 = (java.util.ArrayDeque) r2
            java.lang.Object r2 = r2.poll()
            e4.h r2 = (e4.h) r2
            if (r2 != 0) goto L9d
            e4.h r2 = r0.f()
        L9d:
            e4.j r2 = (e4.j) r2
            r2.f3114b = r1
            r2.f3115c = r6
            goto La7
        La4:
            int r5 = r5 + 1
            goto L59
        La7:
            a5.d r0 = r10.f3121b
            java.lang.Object r0 = r0.F0(r2)
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            if (r0 == 0) goto Lbd
            int r1 = r2.f3114b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.a(r1, r0)
            r0.reconfigure(r11, r12, r13)
        Lbd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.k.b(int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap");
    }

    public final NavigableMap d(Bitmap.Config config) {
        HashMap hashMap = this.f3122c;
        NavigableMap navigableMap = (NavigableMap) hashMap.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        hashMap.put(config, treeMap);
        return treeMap;
    }

    public final void e(Bitmap bitmap) {
        int c9 = n.c(bitmap);
        Bitmap.Config config = bitmap.getConfig();
        e eVar = this.f3120a;
        h hVar = (h) ((ArrayDeque) eVar.f1132i).poll();
        if (hVar == null) {
            hVar = eVar.f();
        }
        j jVar = (j) hVar;
        jVar.f3114b = c9;
        jVar.f3115c = config;
        this.f3121b.R0(jVar, bitmap);
        NavigableMap d9 = d(bitmap.getConfig());
        Integer num = (Integer) d9.get(Integer.valueOf(jVar.f3114b));
        d9.put(Integer.valueOf(jVar.f3114b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f3121b);
        sb.append(", sortedSizes=(");
        HashMap hashMap = this.f3122c;
        for (Map.Entry entry : hashMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!hashMap.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}
