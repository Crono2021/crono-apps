package i2;

import g1.p;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends b1.b {

    /* renamed from: j, reason: collision with root package name */
    public long f4392j;

    /* renamed from: k, reason: collision with root package name */
    public long[] f4393k;

    /* renamed from: l, reason: collision with root package name */
    public long[] f4394l;

    public static Serializable f(int i9, p pVar) {
        if (i9 == 0) {
            return Double.valueOf(Double.longBitsToDouble(pVar.n()));
        }
        if (i9 == 1) {
            return Boolean.valueOf(pVar.t() == 1);
        }
        if (i9 == 2) {
            return h(pVar);
        }
        if (i9 != 3) {
            if (i9 == 8) {
                return g(pVar);
            }
            if (i9 != 10) {
                if (i9 != 11) {
                    return null;
                }
                Date date = new Date((long) Double.longBitsToDouble(pVar.n()));
                pVar.G(2);
                return date;
            }
            int x6 = pVar.x();
            ArrayList arrayList = new ArrayList(x6);
            for (int i10 = 0; i10 < x6; i10++) {
                Serializable f9 = f(pVar.t(), pVar);
                if (f9 != null) {
                    arrayList.add(f9);
                }
            }
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        while (true) {
            String h = h(pVar);
            int t8 = pVar.t();
            if (t8 == 9) {
                return hashMap;
            }
            Serializable f10 = f(t8, pVar);
            if (f10 != null) {
                hashMap.put(h, f10);
            }
        }
    }

    public static HashMap g(p pVar) {
        int x6 = pVar.x();
        HashMap hashMap = new HashMap(x6);
        for (int i9 = 0; i9 < x6; i9++) {
            String h = h(pVar);
            Serializable f9 = f(pVar.t(), pVar);
            if (f9 != null) {
                hashMap.put(h, f9);
            }
        }
        return hashMap;
    }

    public static String h(p pVar) {
        int z8 = pVar.z();
        int i9 = pVar.f3700b;
        pVar.G(z8);
        return new String(pVar.f3699a, i9, z8);
    }
}
