package h8;

import d4.q;
import h7.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class e extends m {
    public static boolean g0(CharSequence charSequence, CharSequence charSequence2, boolean z8) {
        charSequence.getClass();
        charSequence2.getClass();
        if (charSequence2 instanceof String) {
            if (j0(charSequence, (String) charSequence2, 0, z8, 2) >= 0) {
                return true;
            }
        } else if (i0(charSequence, charSequence2, 0, charSequence.length(), z8, false) >= 0) {
            return true;
        }
        return false;
    }

    public static int h0(CharSequence charSequence, String str, int i9, boolean z8) {
        charSequence.getClass();
        str.getClass();
        return (z8 || !(charSequence instanceof String)) ? i0(charSequence, str, i9, charSequence.length(), z8, false) : ((String) charSequence).indexOf(str, i9);
    }

    public static final int i0(CharSequence charSequence, CharSequence charSequence2, int i9, int i10, boolean z8, boolean z9) {
        e8.a aVar;
        boolean z10;
        boolean regionMatches;
        if (z9) {
            charSequence.getClass();
            int length = charSequence.length() - 1;
            if (i9 > length) {
                i9 = length;
            }
            if (i10 < 0) {
                i10 = 0;
            }
            aVar = new e8.a(i9, i10, -1);
        } else {
            if (i9 < 0) {
                i9 = 0;
            }
            int length2 = charSequence.length();
            if (i10 > length2) {
                i10 = length2;
            }
            aVar = new e8.c(i9, i10, 1);
        }
        boolean z11 = charSequence instanceof String;
        int i11 = aVar.f3160k;
        int i12 = aVar.f3159j;
        int i13 = aVar.f3158i;
        if (z11 && (charSequence2 instanceof String)) {
            if ((i11 > 0 && i13 <= i12) || (i11 < 0 && i12 <= i13)) {
                int i14 = i13;
                while (true) {
                    String str = (String) charSequence2;
                    String str2 = (String) charSequence;
                    int length3 = str.length();
                    if (z8) {
                        z10 = z8;
                        regionMatches = str.regionMatches(z10, 0, str2, i14, length3);
                    } else {
                        regionMatches = str.regionMatches(0, str2, i14, length3);
                        z10 = z8;
                    }
                    if (!regionMatches) {
                        if (i14 == i12) {
                            break;
                        }
                        i14 += i11;
                        z8 = z10;
                    } else {
                        return i14;
                    }
                }
            }
        } else if ((i11 > 0 && i13 <= i12) || (i11 < 0 && i12 <= i13)) {
            while (!n0(charSequence2, charSequence, i13, charSequence2.length(), z8)) {
                if (i13 != i12) {
                    i13 += i11;
                }
            }
            return i13;
        }
        return -1;
    }

    public static /* synthetic */ int j0(CharSequence charSequence, String str, int i9, boolean z8, int i10) {
        if ((i10 & 2) != 0) {
            i9 = 0;
        }
        if ((i10 & 4) != 0) {
            z8 = false;
        }
        return h0(charSequence, str, i9, z8);
    }

    public static int k0(String str, char c9, int i9, int i10) {
        if ((i10 & 2) != 0) {
            i9 = 0;
        }
        return str.indexOf(c9, i9);
    }

    public static boolean l0(CharSequence charSequence) {
        charSequence.getClass();
        for (int i9 = 0; i9 < charSequence.length(); i9++) {
            char charAt = charSequence.charAt(i9);
            if (!Character.isWhitespace(charAt) && !Character.isSpaceChar(charAt)) {
                return false;
            }
        }
        return true;
    }

    public static int m0(CharSequence charSequence, String str, int i9) {
        int i10;
        if ((i9 & 2) != 0) {
            charSequence.getClass();
            i10 = charSequence.length() - 1;
        } else {
            i10 = 0;
        }
        charSequence.getClass();
        str.getClass();
        return !(charSequence instanceof String) ? i0(charSequence, str, i10, 0, false, true) : ((String) charSequence).lastIndexOf(str, i10);
    }

    public static final boolean n0(CharSequence charSequence, CharSequence charSequence2, int i9, int i10, boolean z8) {
        char upperCase;
        char upperCase2;
        charSequence.getClass();
        charSequence2.getClass();
        if (i9 >= 0 && charSequence.length() - i10 >= 0 && i9 <= charSequence2.length() - i10) {
            for (int i11 = 0; i11 < i10; i11++) {
                char charAt = charSequence.charAt(i11);
                char charAt2 = charSequence2.charAt(i9 + i11);
                boolean z9 = true;
                if (charAt != charAt2 && (!z8 || ((upperCase = Character.toUpperCase(charAt)) != (upperCase2 = Character.toUpperCase(charAt2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)))) {
                    z9 = false;
                }
                if (z9) {
                }
            }
            return true;
        }
        return false;
    }

    public static String o0(String str) {
        str.getClass();
        return m.f0(str, "Grupo: ", false) ? str.substring(7) : str;
    }

    public static List p0(CharSequence charSequence, String[] strArr, int i9) {
        int i10 = (i9 & 4) != 0 ? 0 : 2;
        charSequence.getClass();
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                int h02 = h0(charSequence, str, 0, false);
                if (h02 == -1 || i10 == 1) {
                    return android.support.v4.media.session.b.b0(charSequence.toString());
                }
                boolean z8 = i10 > 0;
                ArrayList arrayList = new ArrayList(z8 ? i10 : 10);
                int i11 = 0;
                do {
                    arrayList.add(charSequence.subSequence(i11, h02).toString());
                    i11 = str.length() + h02;
                    if (z8 && arrayList.size() == i10 - 1) {
                        break;
                    }
                    h02 = h0(charSequence, str, i11, false);
                } while (h02 != -1);
                arrayList.add(charSequence.subSequence(i11, charSequence.length()).toString());
                return arrayList;
            }
        }
        List asList = Arrays.asList(strArr);
        asList.getClass();
        q qVar = new q(new c(charSequence, i10, new n(asList)), 1);
        ArrayList arrayList2 = new ArrayList(o7.j.E0(qVar));
        Iterator it = qVar.iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return arrayList2;
            }
            e8.c cVar = (e8.c) bVar.next();
            cVar.getClass();
            arrayList2.add(charSequence.subSequence(cVar.f3158i, cVar.f3159j + 1).toString());
        }
    }

    public static String q0(String str, String str2, String str3) {
        str.getClass();
        str3.getClass();
        int j02 = j0(str, str2, 0, false, 6);
        return j02 == -1 ? str3 : str.substring(str2.length() + j02, str.length());
    }

    public static String r0(String str, String str2, String str3) {
        str.getClass();
        str3.getClass();
        int m02 = m0(str, str2, 6);
        return m02 == -1 ? str3 : str.substring(str2.length() + m02, str.length());
    }

    public static String s0(String str, String str2) {
        str.getClass();
        str.getClass();
        int j02 = j0(str, str2, 0, false, 6);
        return j02 == -1 ? str : str.substring(0, j02);
    }

    public static String t0(int i9, String str) {
        str.getClass();
        if (i9 < 0) {
            o.d("Requested character count ", i9, " is less than zero.");
            return null;
        }
        int length = str.length();
        if (i9 > length) {
            i9 = length;
        }
        return str.substring(0, i9);
    }

    public static CharSequence u0(String str) {
        str.getClass();
        int length = str.length() - 1;
        int i9 = 0;
        boolean z8 = false;
        while (i9 <= length) {
            char charAt = str.charAt(!z8 ? i9 : length);
            boolean z9 = Character.isWhitespace(charAt) || Character.isSpaceChar(charAt);
            if (z8) {
                if (!z9) {
                    break;
                }
                length--;
            } else if (z9) {
                i9++;
            } else {
                z8 = true;
            }
        }
        return str.subSequence(i9, length + 1);
    }
}
