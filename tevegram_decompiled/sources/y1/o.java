package y1;

import android.content.Context;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import b6.g0;
import b6.v;
import b6.v0;
import b6.w0;
import d1.a1;
import d1.d1;
import d1.z0;
import g1.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.RandomAccess;
import l1.h0;
import v1.c1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o {

    /* renamed from: j, reason: collision with root package name */
    public static final v0 f10473j = new v(new a3.d(7));

    /* renamed from: k, reason: collision with root package name */
    public static final v0 f10474k = new v(new a3.d(8));

    /* renamed from: a, reason: collision with root package name */
    public h0 f10475a;

    /* renamed from: b, reason: collision with root package name */
    public z1.f f10476b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f10477c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f10478d;

    /* renamed from: e, reason: collision with root package name */
    public final o4.d f10479e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f10480f;

    /* renamed from: g, reason: collision with root package name */
    public i f10481g;
    public final b2.b h;

    /* renamed from: i, reason: collision with root package name */
    public d1.g f10482i;

    public o(Context context) {
        Spatializer spatializer;
        o4.d dVar = new o4.d(27);
        int i9 = i.C;
        i iVar = new i(new h(context));
        this.f10477c = new Object();
        b2.b bVar = null;
        this.f10478d = context != null ? context.getApplicationContext() : null;
        this.f10479e = dVar;
        this.f10481g = iVar;
        this.f10482i = d1.g.f2423c;
        boolean z8 = context != null && w.L(context);
        this.f10480f = z8;
        if (!z8 && context != null && w.f3713a >= 32) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager != null) {
                spatializer = audioManager.getSpatializer();
                bVar = new b2.b(spatializer);
            }
            this.h = bVar;
        }
        if (this.f10481g.f10442x && context == null) {
            g1.a.D("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    public static void a(c1 c1Var, i iVar, HashMap hashMap) {
        for (int i9 = 0; i9 < c1Var.f9256a; i9++) {
            a1 a1Var = (a1) iVar.f2406r.get(c1Var.a(i9));
            if (a1Var != null) {
                z0 z0Var = a1Var.f2353a;
                a1 a1Var2 = (a1) hashMap.get(Integer.valueOf(z0Var.f2618c));
                if (a1Var2 == null || (a1Var2.f2354b.isEmpty() && !a1Var.f2354b.isEmpty())) {
                    hashMap.put(Integer.valueOf(z0Var.f2618c), a1Var);
                }
            }
        }
    }

    public static int b(d1.s sVar, String str, boolean z8) {
        if (!TextUtils.isEmpty(str) && str.equals(sVar.f2546d)) {
            return 4;
        }
        String f9 = f(str);
        String f10 = f(sVar.f2546d);
        if (f10 == null || f9 == null) {
            return (z8 && f10 == null) ? 1 : 0;
        }
        if (f10.startsWith(f9) || f9.startsWith(f10)) {
            return 3;
        }
        int i9 = w.f3713a;
        return f10.split("-", 2)[0].equals(f9.split("-", 2)[0]) ? 2 : 0;
    }

    public static boolean d(int i9, boolean z8) {
        int i10 = i9 & 7;
        if (i10 != 4) {
            return z8 && i10 == 3;
        }
        return true;
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    public static Pair i(int i9, s sVar, int[][][] iArr, l lVar, Comparator comparator) {
        int i10;
        RandomAccess randomAccess;
        s sVar2 = sVar;
        ArrayList arrayList = new ArrayList();
        int i11 = sVar2.f10485a;
        int i12 = 0;
        while (i12 < i11) {
            if (i9 == sVar2.f10486b[i12]) {
                c1 c1Var = sVar2.f10487c[i12];
                for (int i13 = 0; i13 < c1Var.f9256a; i13++) {
                    z0 a9 = c1Var.a(i13);
                    w0 d9 = lVar.d(i12, a9, iArr[i12][i13]);
                    int i14 = a9.f2616a;
                    boolean[] zArr = new boolean[i14];
                    int i15 = 0;
                    while (i15 < i14) {
                        m mVar = (m) d9.get(i15);
                        int a10 = mVar.a();
                        if (zArr[i15] || a10 == 0) {
                            i10 = i11;
                        } else {
                            if (a10 == 1) {
                                randomAccess = g0.q(mVar);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(mVar);
                                int i16 = i15 + 1;
                                while (i16 < i14) {
                                    m mVar2 = (m) d9.get(i16);
                                    int i17 = i11;
                                    if (mVar2.a() == 2 && mVar.b(mVar2)) {
                                        arrayList2.add(mVar2);
                                        zArr[i16] = true;
                                    }
                                    i16++;
                                    i11 = i17;
                                }
                                randomAccess = arrayList2;
                            }
                            i10 = i11;
                            arrayList.add(randomAccess);
                        }
                        i15++;
                        i11 = i10;
                    }
                }
            }
            i12++;
            sVar2 = sVar;
            i11 = i11;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i18 = 0; i18 < list.size(); i18++) {
            iArr2[i18] = ((m) list.get(i18)).f10457k;
        }
        m mVar3 = (m) list.get(0);
        return Pair.create(new p(0, mVar3.f10456j, iArr2), Integer.valueOf(mVar3.f10455i));
    }

    public final i c() {
        i iVar;
        synchronized (this.f10477c) {
            iVar = this.f10481g;
        }
        return iVar;
    }

    public final void e() {
        boolean z8;
        h0 h0Var;
        b2.b bVar;
        synchronized (this.f10477c) {
            try {
                z8 = this.f10481g.f10442x && !this.f10480f && w.f3713a >= 32 && (bVar = this.h) != null && bVar.f1137a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z8 || (h0Var = this.f10475a) == null) {
            return;
        }
        h0Var.f5900p.d(10);
    }

    public final void g() {
        synchronized (this.f10477c) {
            this.f10481g.getClass();
        }
    }

    public final void h() {
        b2.b bVar;
        j jVar;
        synchronized (this.f10477c) {
            try {
                if (w.f3713a >= 32 && (bVar = this.h) != null && (jVar = (j) bVar.f1140d) != null && ((Handler) bVar.f1139c) != null) {
                    ((Spatializer) bVar.f1138b).removeOnSpatializerStateChangedListener(jVar);
                    ((Handler) bVar.f1139c).removeCallbacksAndMessages(null);
                    bVar.f1139c = null;
                    bVar.f1140d = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f10475a = null;
        this.f10476b = null;
    }

    public final void j(d1 d1Var) {
        if (d1Var instanceof i) {
            k((i) d1Var);
        }
        h hVar = new h(c());
        hVar.c(d1Var);
        k(new i(hVar));
    }

    public final void k(i iVar) {
        boolean equals;
        iVar.getClass();
        synchronized (this.f10477c) {
            equals = this.f10481g.equals(iVar);
            this.f10481g = iVar;
        }
        if (equals) {
            return;
        }
        if (iVar.f10442x && this.f10478d == null) {
            g1.a.D("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
        h0 h0Var = this.f10475a;
        if (h0Var != null) {
            h0Var.f5900p.d(10);
        }
    }
}
