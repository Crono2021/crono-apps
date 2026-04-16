package t;

import b6.d0;
import b6.e0;
import b6.g0;
import z2.k;
import z2.l;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract /* synthetic */ class a {
    public static z2.b a(l lVar, byte[] bArr, int i9) {
        e0 e0Var = g0.f1391j;
        d0 d0Var = new d0();
        lVar.a0(bArr, 0, i9, k.f10620c, new a3.i(d0Var, 26));
        return new z2.b(d0Var.f());
    }

    public static String b(String str, String str2) {
        return str + str2;
    }

    public static StringBuilder c(String str, long j5, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(j5);
        sb.append(str2);
        return sb;
    }

    public static /* synthetic */ boolean d(Object obj) {
        return obj != null;
    }

    public static /* synthetic */ String e(int i9) {
        switch (i9) {
            case 1:
                return "NONE";
            case 2:
                return "LEFT";
            case 3:
                return "TOP";
            case 4:
                return "RIGHT";
            case 5:
                return "BOTTOM";
            case 6:
                return "BASELINE";
            case 7:
                return "CENTER";
            case 8:
                return "CENTER_X";
            case 9:
                return "CENTER_Y";
            default:
                throw null;
        }
    }
}
