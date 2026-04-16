package com.network.tvgramplayer.voip;

import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
class VLog {
    public static native void d(String str);

    public static native void e(String str);

    public static void e(String str, Throwable th) {
        StringWriter stringWriter = new StringWriter();
        if (!TextUtils.isEmpty(str)) {
            stringWriter.append((CharSequence) str);
            stringWriter.append((CharSequence) ": ");
        }
        th.printStackTrace(new PrintWriter(stringWriter));
        String[] split = stringWriter.toString().split("\n");
        for (String str2 : split) {
            e(str2);
        }
    }

    public static native void i(String str);

    public static native void v(String str);

    public static native void w(String str);

    public static void e(Throwable th) {
        e(null, th);
    }
}
