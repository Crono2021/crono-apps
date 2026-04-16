package d3;

import android.text.TextUtils;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f2758a;

    /* renamed from: b, reason: collision with root package name */
    public int f2759b;

    /* renamed from: c, reason: collision with root package name */
    public int f2760c;

    /* renamed from: d, reason: collision with root package name */
    public int f2761d;

    /* renamed from: e, reason: collision with root package name */
    public int f2762e;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static a b(String str) {
        char c9;
        g1.a.f(str.startsWith("Format:"));
        String[] split = TextUtils.split(str.substring(7), ",");
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < split.length; i13++) {
            String U = a.a.U(split[i13].trim());
            U.getClass();
            switch (U.hashCode()) {
                case 100571:
                    if (U.equals("end")) {
                        c9 = 0;
                        break;
                    }
                    c9 = 65535;
                    break;
                case 3556653:
                    if (U.equals("text")) {
                        c9 = 1;
                        break;
                    }
                    c9 = 65535;
                    break;
                case 109757538:
                    if (U.equals("start")) {
                        c9 = 2;
                        break;
                    }
                    c9 = 65535;
                    break;
                case 109780401:
                    if (U.equals("style")) {
                        c9 = 3;
                        break;
                    }
                    c9 = 65535;
                    break;
                default:
                    c9 = 65535;
                    break;
            }
            switch (c9) {
                case 0:
                    i10 = i13;
                    break;
                case 1:
                    i11 = i13;
                    break;
                case 2:
                    i9 = i13;
                    break;
                case 3:
                    i12 = i13;
                    break;
            }
        }
        if (i9 == -1 || i10 == -1 || i11 == -1) {
            return null;
        }
        int length = split.length;
        a aVar = new a();
        aVar.f2758a = i9;
        aVar.f2759b = i10;
        aVar.f2760c = i12;
        aVar.f2761d = i11;
        aVar.f2762e = length;
        return aVar;
    }

    public boolean a() {
        int i9 = this.f2758a;
        int i10 = 2;
        if ((i9 & 7) != 0) {
            int i11 = this.f2761d;
            int i12 = this.f2759b;
            if (((i11 > i12 ? 1 : i11 == i12 ? 2 : 4) & i9) == 0) {
                return false;
            }
        }
        if ((i9 & 112) != 0) {
            int i13 = this.f2761d;
            int i14 = this.f2760c;
            if ((((i13 > i14 ? 1 : i13 == i14 ? 2 : 4) << 4) & i9) == 0) {
                return false;
            }
        }
        if ((i9 & 1792) != 0) {
            int i15 = this.f2762e;
            int i16 = this.f2759b;
            if ((((i15 > i16 ? 1 : i15 == i16 ? 2 : 4) << 8) & i9) == 0) {
                return false;
            }
        }
        if ((i9 & 28672) != 0) {
            int i17 = this.f2762e;
            int i18 = this.f2760c;
            if (i17 > i18) {
                i10 = 1;
            } else if (i17 != i18) {
                i10 = 4;
            }
            if ((i9 & (i10 << 12)) == 0) {
                return false;
            }
        }
        return true;
    }
}
