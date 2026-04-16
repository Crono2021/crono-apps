package h3;

import g1.p;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f3912c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f3913d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* renamed from: a, reason: collision with root package name */
    public final p f3914a = new p();

    /* renamed from: b, reason: collision with root package name */
    public final StringBuilder f3915b = new StringBuilder();

    public static String a(p pVar, StringBuilder sb) {
        boolean z8 = false;
        sb.setLength(0);
        int i9 = pVar.f3700b;
        int i10 = pVar.f3701c;
        while (i9 < i10 && !z8) {
            char c9 = (char) pVar.f3699a[i9];
            if ((c9 < 'A' || c9 > 'Z') && ((c9 < 'a' || c9 > 'z') && !((c9 >= '0' && c9 <= '9') || c9 == '#' || c9 == '-' || c9 == '.' || c9 == '_'))) {
                z8 = true;
            } else {
                i9++;
                sb.append(c9);
            }
        }
        pVar.G(i9 - pVar.f3700b);
        return sb.toString();
    }

    public static String b(p pVar, StringBuilder sb) {
        c(pVar);
        if (pVar.a() == 0) {
            return null;
        }
        String a9 = a(pVar, sb);
        if (!"".equals(a9)) {
            return a9;
        }
        return "" + ((char) pVar.t());
    }

    public static void c(p pVar) {
        while (true) {
            for (boolean z8 = true; pVar.a() > 0 && z8; z8 = false) {
                int i9 = pVar.f3700b;
                byte[] bArr = pVar.f3699a;
                byte b9 = bArr[i9];
                char c9 = (char) b9;
                if (c9 == '\t' || c9 == '\n' || c9 == '\f' || c9 == '\r' || c9 == ' ') {
                    pVar.G(1);
                } else {
                    int i10 = pVar.f3701c;
                    int i11 = i9 + 2;
                    if (i11 <= i10) {
                        int i12 = i9 + 1;
                        if (b9 == 47 && bArr[i12] == 42) {
                            while (true) {
                                int i13 = i11 + 1;
                                if (i13 >= i10) {
                                    break;
                                }
                                if (((char) bArr[i11]) == '*' && ((char) bArr[i13]) == '/') {
                                    i11 += 2;
                                    i10 = i11;
                                } else {
                                    i11 = i13;
                                }
                            }
                            pVar.G(i10 - pVar.f3700b);
                        }
                    }
                }
            }
            return;
        }
    }
}
