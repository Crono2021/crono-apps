package h8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class m extends l {
    public static boolean b0(String str, String str2, boolean z8) {
        str.getClass();
        return !z8 ? str.endsWith(str2) : str.regionMatches(true, str.length() - str2.length(), str2, 0, str2.length());
    }

    public static String c0(String str) {
        String replace = str.replace('\n', ' ');
        replace.getClass();
        return replace;
    }

    public static String d0(String str, String str2, String str3) {
        str.getClass();
        int h02 = e.h0(str, str2, 0, false);
        if (h02 < 0) {
            return str;
        }
        int length = str2.length();
        int i9 = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i10 = 0;
        do {
            sb.append((CharSequence) str, i10, h02);
            sb.append(str3);
            i10 = h02 + length;
            if (h02 >= str.length()) {
                break;
            }
            h02 = e.h0(str, str2, h02 + i9, false);
        } while (h02 > 0);
        sb.append((CharSequence) str, i10, str.length());
        return sb.toString();
    }

    public static String e0(String str, String str2, String str3) {
        int j02 = e.j0(str, str2, 0, false, 2);
        if (j02 < 0) {
            return str;
        }
        int length = str2.length() + j02;
        if (length >= j02) {
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) str, 0, j02);
            sb.append((CharSequence) str3);
            sb.append((CharSequence) str, length, str.length());
            return sb.toString();
        }
        throw new IndexOutOfBoundsException("End index (" + length + ") is less than start index (" + j02 + ").");
    }

    public static boolean f0(String str, String str2, boolean z8) {
        str.getClass();
        if (!z8) {
            return str.startsWith(str2);
        }
        int length = str2.length();
        return !z8 ? str.regionMatches(0, str2, 0, length) : str.regionMatches(z8, 0, str2, 0, length);
    }
}
