package com.google.gson.internal.bind.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class ISO8601Utils {
    private static final String UTC_ID = "UTC";
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);

    private static boolean checkOffset(String str, int i9, char c9) {
        return i9 < str.length() && str.charAt(i9) == c9;
    }

    public static String format(Date date, boolean z8, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z8 ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z8) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i9 = offset / 60000;
            int abs = Math.abs(i9 / 60);
            int abs2 = Math.abs(i9 % 60);
            sb.append(offset >= 0 ? '+' : '-');
            padInt(sb, abs, 2);
            sb.append(':');
            padInt(sb, abs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    private static int indexOfNonDigit(String str, int i9) {
        while (i9 < str.length()) {
            char charAt = str.charAt(i9);
            if (charAt < '0' || charAt > '9') {
                return i9;
            }
            i9++;
        }
        return str.length();
    }

    private static void padInt(StringBuilder sb, int i9, int i10) {
        String num = Integer.toString(i9);
        for (int length = i10 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00eb A[Catch: IllegalArgumentException -> 0x0056, NumberFormatException -> 0x0059, IndexOutOfBoundsException -> 0x005c, TryCatch #2 {IllegalArgumentException -> 0x0056, IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0059, blocks: (B:3:0x000c, B:5:0x001f, B:6:0x0021, B:8:0x002d, B:9:0x002f, B:11:0x003f, B:13:0x0045, B:18:0x0065, B:20:0x0075, B:21:0x0077, B:23:0x0083, B:24:0x0086, B:26:0x008c, B:30:0x0096, B:35:0x00a6, B:37:0x00ae, B:43:0x00e5, B:45:0x00eb, B:47:0x00f1, B:48:0x0182, B:55:0x0102, B:56:0x0118, B:57:0x0119, B:60:0x0129, B:62:0x0136, B:65:0x013f, B:67:0x0151, B:70:0x0160, B:71:0x017d, B:73:0x0180, B:74:0x0125, B:75:0x01b4, B:76:0x01bb, B:77:0x00c8, B:78:0x00cb), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01b4 A[Catch: IllegalArgumentException -> 0x0056, NumberFormatException -> 0x0059, IndexOutOfBoundsException -> 0x005c, TryCatch #2 {IllegalArgumentException -> 0x0056, IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0059, blocks: (B:3:0x000c, B:5:0x001f, B:6:0x0021, B:8:0x002d, B:9:0x002f, B:11:0x003f, B:13:0x0045, B:18:0x0065, B:20:0x0075, B:21:0x0077, B:23:0x0083, B:24:0x0086, B:26:0x008c, B:30:0x0096, B:35:0x00a6, B:37:0x00ae, B:43:0x00e5, B:45:0x00eb, B:47:0x00f1, B:48:0x0182, B:55:0x0102, B:56:0x0118, B:57:0x0119, B:60:0x0129, B:62:0x0136, B:65:0x013f, B:67:0x0151, B:70:0x0160, B:71:0x017d, B:73:0x0180, B:74:0x0125, B:75:0x01b4, B:76:0x01bb, B:77:0x00c8, B:78:0x00cb), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date parse(java.lang.String r19, java.text.ParsePosition r20) {
        /*
            Method dump skipped, instructions count: 541
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int parseInt(String str, int i9, int i10) {
        int i11;
        int i12;
        if (i9 < 0 || i10 > str.length() || i9 > i10) {
            throw new NumberFormatException(str);
        }
        if (i9 < i10) {
            i12 = i9 + 1;
            int digit = Character.digit(str.charAt(i9), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: ".concat(str.substring(i9, i10)));
            }
            i11 = -digit;
        } else {
            i11 = 0;
            i12 = i9;
        }
        while (i12 < i10) {
            int i13 = i12 + 1;
            int digit2 = Character.digit(str.charAt(i12), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: ".concat(str.substring(i9, i10)));
            }
            i11 = (i11 * 10) - digit2;
            i12 = i13;
        }
        return -i11;
    }

    public static String format(Date date, boolean z8) {
        return format(date, z8, TIMEZONE_UTC);
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }
}
