package k7;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import java.util.LinkedHashSet;
import o7.t;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final LinkedHashSet f5626c;

    /* renamed from: a, reason: collision with root package name */
    public final Context f5627a;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f5628b;

    static {
        String[] strArr = {"http", "https", "magnet", "acestream", "tg", "telegram"};
        LinkedHashSet linkedHashSet = new LinkedHashSet(t.b0(6));
        for (int i9 = 0; i9 < 6; i9++) {
            linkedHashSet.add(strArr[i9]);
        }
        f5626c = linkedHashSet;
    }

    public a(Context context) {
        context.getClass();
        this.f5627a = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("tvgram_settings", 0);
        sharedPreferences.getClass();
        this.f5628b = sharedPreferences;
    }

    public final int a() {
        return this.f5628b.getInt("afr_strategy", 0);
    }

    public final boolean b() {
        return this.f5628b.getBoolean("auto_frame_rate_enabled", false);
    }

    public final boolean c() {
        SharedPreferences sharedPreferences = this.f5628b;
        if (sharedPreferences.contains("use_hw_accel")) {
            return sharedPreferences.getBoolean("use_hw_accel", false);
        }
        String str = Build.MANUFACTURER;
        boolean z8 = (str == null ? false : str.equalsIgnoreCase("Amazon")) || this.f5627a.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv");
        if (z8) {
            Log.i("SettingsManager", "🚀 Amazon device detected: Enabling Hardware Acceleration by default.");
        }
        return z8;
    }

    public final boolean d() {
        return this.f5628b.getBoolean("visualizer_enabled", true);
    }

    public final String e() {
        String string = this.f5628b.getString("visualizer_group", "ALL");
        return string == null ? "ALL" : string;
    }

    public final void f(boolean z8) {
        this.f5628b.edit().putBoolean("adaptive_buffer_enabled", z8).apply();
    }

    public final void g(boolean z8) {
        this.f5628b.edit().putBoolean("multithreaded_sync", z8).apply();
    }

    public final void h(boolean z8) {
        this.f5628b.edit().putBoolean("smart_sync", z8).apply();
    }

    public final void i(boolean z8) {
        this.f5628b.edit().putBoolean("sync_auto", z8).apply();
    }

    public final void j(String str) {
        str.getClass();
        this.f5628b.edit().putString("visualizer_group", str).apply();
    }
}
