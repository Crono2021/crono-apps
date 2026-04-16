package com.network.tvgramplayer.voip;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class VoIPServerConfig {
    private static final String TAG = "VoIPServerConfig";
    private static JSONObject config = new JSONObject();

    public static boolean getBoolean(String str, boolean z8) {
        return config.optBoolean(str, z8);
    }

    public static double getDouble(String str, double d9) {
        return config.optDouble(str, d9);
    }

    public static int getInt(String str, int i9) {
        return config.optInt(str, i9);
    }

    public static String getString(String str, String str2) {
        return config.optString(str, str2);
    }

    private static native void nativeSetConfig(String str);

    public static void setConfig(String str) {
        try {
            config = new JSONObject(str);
            nativeSetConfig(str);
        } catch (JSONException e9) {
            Log.e(TAG, "Error parsing VoIP config", e9);
        }
    }
}
