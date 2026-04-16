package h3;

import d1.m0;
import g1.p;
import g1.w;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f3958a = Pattern.compile("^NOTE([ \t].*)?$");

    public static boolean a(p pVar) {
        pVar.getClass();
        String h = pVar.h(a6.b.f203c);
        return h != null && h.startsWith("WEBVTT");
    }

    public static float b(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long c(String str) {
        int i9 = w.f3713a;
        String[] split = str.split("\\.", 2);
        long j5 = 0;
        for (String str2 : split[0].split(":", -1)) {
            j5 = (j5 * 60) + Long.parseLong(str2);
        }
        long j9 = j5 * 1000;
        if (split.length == 2) {
            j9 += Long.parseLong(split[1]);
        }
        return j9 * 1000;
    }

    public static void d(p pVar) {
        int i9 = pVar.f3700b;
        if (a(pVar)) {
            return;
        }
        pVar.F(i9);
        throw m0.a(null, "Expected WEBVTT. Got " + pVar.h(a6.b.f203c));
    }
}
