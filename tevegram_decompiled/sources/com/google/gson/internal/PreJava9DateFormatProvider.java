package com.google.gson.internal;

import androidx.activity.g;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import m7.c;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class PreJava9DateFormatProvider {
    private static String getDateFormatPattern(int i9) {
        if (i9 == 0) {
            return "EEEE, MMMM d, y";
        }
        if (i9 == 1) {
            return "MMMM d, y";
        }
        if (i9 == 2) {
            return "MMM d, y";
        }
        if (i9 == 3) {
            return "M/d/yy";
        }
        c.n(g.m(i9, "Unknown DateFormat style: "));
        return null;
    }

    private static String getDatePartOfDateTimePattern(int i9) {
        if (i9 == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i9 == 1) {
            return "MMMM d, yyyy";
        }
        if (i9 == 2) {
            return "MMM d, yyyy";
        }
        if (i9 == 3) {
            return "M/d/yy";
        }
        c.n(g.m(i9, "Unknown DateFormat style: "));
        return null;
    }

    private static String getTimePartOfDateTimePattern(int i9) {
        if (i9 == 0 || i9 == 1) {
            return "h:mm:ss a z";
        }
        if (i9 == 2) {
            return "h:mm:ss a";
        }
        if (i9 == 3) {
            return "h:mm a";
        }
        c.n(g.m(i9, "Unknown DateFormat style: "));
        return null;
    }

    public static DateFormat getUSDateFormat(int i9) {
        return new SimpleDateFormat(getDateFormatPattern(i9), Locale.US);
    }

    public static DateFormat getUSDateTimeFormat(int i9, int i10) {
        return new SimpleDateFormat(getDatePartOfDateTimePattern(i9) + " " + getTimePartOfDateTimePattern(i10), Locale.US);
    }
}
