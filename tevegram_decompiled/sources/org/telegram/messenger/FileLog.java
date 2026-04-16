package org.telegram.messenger;

import android.util.Log;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class FileLog {
    private static final String TAG = "FileLog";

    public static void d(String str) {
        Log.d(TAG, str);
    }

    public static void e(Throwable th) {
        Log.e(TAG, "Exception: ", th);
    }

    public static void w(String str) {
        Log.w(TAG, str);
    }

    public static void e(String str, Throwable th) {
        Log.e(TAG, str, th);
    }

    public static void e(String str) {
        Log.e(TAG, str);
    }
}
