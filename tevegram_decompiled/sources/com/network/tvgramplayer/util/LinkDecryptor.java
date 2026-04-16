package com.network.tvgramplayer.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Base64;
import android.util.Log;
import com.network.tvgramplayer.TvgramApplication;
import h8.e;
import h8.m;
import java.security.MessageDigest;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class LinkDecryptor {

    /* renamed from: a, reason: collision with root package name */
    public static final LinkDecryptor f2333a = new LinkDecryptor();

    private final native String decryptNative(byte[] bArr, String str, String str2);

    public final String a(Context context, String str) {
        byte[] bArr;
        String str2;
        String d02 = m.d0(m.d0(e.u0(str).toString(), "\n", ""), "\r", "");
        boolean z8 = TvgramApplication.f2329j;
        if (!TvgramApplication.f2329j) {
            Log.e("LinkDecryptor", "❌ Error: Librería nativa no lista");
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            int length = d02.length();
            for (int i9 = 0; i9 < length; i9++) {
                char charAt = d02.charAt(i9);
                int k02 = e.k0("zxcvbnmASDFGHJKLQWERTYUIOP1234567890-_qwertyuiopasdfghjklZXCVBNM", charAt, 0, 6);
                if (k02 != -1) {
                    sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(k02));
                } else {
                    sb.append(charAt);
                }
            }
            bArr = Base64.decode(sb.toString(), 8);
        } catch (Exception e9) {
            Log.e("LinkDecryptor", "Error decodificando Base64 personalizado", e9);
            bArr = null;
        }
        if (bArr == null) {
            Log.e("LinkDecryptor", "❌ Error: Base64 inválido");
            return null;
        }
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(packageInfo.signatures[0].toByteArray());
            String encodeToString = Base64.encodeToString(messageDigest.digest(), 2);
            encodeToString.getClass();
            str2 = encodeToString.substring(0, 10);
        } catch (Exception unused) {
            str2 = "UNKNOWN";
        }
        packageName.getClass();
        String decryptNative = decryptNative(bArr, packageName, str2);
        if (decryptNative == null) {
            Log.e("LinkDecryptor", "❌ Error en descifrado nativo");
        }
        return decryptNative;
    }
}
