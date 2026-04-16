package d3;

import android.graphics.Color;
import androidx.activity.g;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f2784a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2785b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f2786c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f2787d;

    /* renamed from: e, reason: collision with root package name */
    public final float f2788e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f2789f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2790g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f2791i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2792j;

    public e(String str, int i9, Integer num, Integer num2, float f9, boolean z8, boolean z9, boolean z10, boolean z11, int i10) {
        this.f2784a = str;
        this.f2785b = i9;
        this.f2786c = num;
        this.f2787d = num2;
        this.f2788e = f9;
        this.f2789f = z8;
        this.f2790g = z9;
        this.h = z10;
        this.f2791i = z11;
        this.f2792j = i10;
    }

    public static int a(String str) {
        boolean z8;
        try {
            int parseInt = Integer.parseInt(str.trim());
            switch (parseInt) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    z8 = true;
                    break;
                default:
                    z8 = false;
                    break;
            }
            if (z8) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        g.x("Ignoring unknown alignment: ", str, "SsaStyle");
        return -1;
    }

    public static boolean b(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            return parseInt == 1 || parseInt == -1;
        } catch (NumberFormatException e9) {
            g1.a.E("SsaStyle", "Failed to parse boolean value: '" + str + "'", e9);
            return false;
        }
    }

    public static Integer c(String str) {
        try {
            long parseLong = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            g1.a.f(parseLong <= 4294967295L);
            return Integer.valueOf(Color.argb(a.a.h(((parseLong >> 24) & 255) ^ 255), a.a.h(parseLong & 255), a.a.h((parseLong >> 8) & 255), a.a.h((parseLong >> 16) & 255)));
        } catch (IllegalArgumentException e9) {
            g1.a.E("SsaStyle", "Failed to parse color expression: '" + str + "'", e9);
            return null;
        }
    }
}
