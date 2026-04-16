package c6;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1638a = 0;

    static {
        Math.log(2.0d);
    }

    public static boolean a(double d9) {
        if (Math.getExponent(d9) <= 1023) {
            if (d9 != 0.0d) {
                if (!(Math.getExponent(d9) <= 1023)) {
                    m7.c.n("not a normal value");
                    return false;
                }
                int exponent = Math.getExponent(d9);
                long doubleToRawLongBits = Double.doubleToRawLongBits(d9) & 4503599627370495L;
                if (52 - Long.numberOfTrailingZeros(exponent == -1023 ? doubleToRawLongBits << 1 : doubleToRawLongBits | 4503599627370496L) <= Math.getExponent(d9)) {
                }
            }
            return true;
        }
        return false;
    }
}
