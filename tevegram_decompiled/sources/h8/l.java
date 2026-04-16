package h8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class l extends k {
    public static Integer Z(String str) {
        boolean z8;
        int i9;
        int i10;
        str.getClass();
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i11 = 0;
        char charAt = str.charAt(0);
        int i12 = -2147483647;
        if (charAt < '0') {
            i9 = 1;
            if (length == 1) {
                return null;
            }
            if (charAt == '+') {
                z8 = false;
            } else {
                if (charAt != '-') {
                    return null;
                }
                i12 = Integer.MIN_VALUE;
                z8 = true;
            }
        } else {
            z8 = false;
            i9 = 0;
        }
        int i13 = -59652323;
        while (i9 < length) {
            int digit = Character.digit((int) str.charAt(i9), 10);
            if (digit < 0) {
                return null;
            }
            if ((i11 < i13 && (i13 != -59652323 || i11 < (i13 = i12 / 10))) || (i10 = i11 * 10) < i12 + digit) {
                return null;
            }
            i11 = i10 - digit;
            i9++;
        }
        return z8 ? Integer.valueOf(i11) : Integer.valueOf(-i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Long a0(java.lang.String r17) {
        /*
            r0 = r17
            r0.getClass()
            int r1 = r0.length()
            if (r1 != 0) goto Lc
            goto L5e
        Lc:
            r2 = 0
            char r3 = r0.charAt(r2)
            r4 = 48
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r3 >= r4) goto L2c
            r4 = 1
            if (r1 != r4) goto L1e
            goto L5e
        L1e:
            r7 = 43
            if (r3 == r7) goto L2b
            r2 = 45
            if (r3 == r2) goto L27
            goto L5e
        L27:
            r5 = -9223372036854775808
            r2 = 1
            goto L2d
        L2b:
            r2 = 1
        L2c:
            r4 = 0
        L2d:
            r7 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            r9 = 0
            r11 = r7
        L35:
            if (r2 >= r1) goto L64
            char r3 = r0.charAt(r2)
            r13 = 10
            int r3 = java.lang.Character.digit(r3, r13)
            if (r3 >= 0) goto L44
            goto L5e
        L44:
            int r14 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r14 >= 0) goto L54
            int r14 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r14 != 0) goto L5e
            long r11 = (long) r13
            long r11 = r5 / r11
            int r14 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r14 >= 0) goto L54
            goto L5e
        L54:
            long r13 = (long) r13
            long r9 = r9 * r13
            long r13 = (long) r3
            long r15 = r5 + r13
            int r3 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r3 >= 0) goto L60
        L5e:
            r0 = 0
            return r0
        L60:
            long r9 = r9 - r13
            int r2 = r2 + 1
            goto L35
        L64:
            if (r4 == 0) goto L6b
            java.lang.Long r0 = java.lang.Long.valueOf(r9)
            return r0
        L6b:
            long r0 = -r9
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h8.l.a0(java.lang.String):java.lang.Long");
    }
}
