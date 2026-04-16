package c0;

import android.app.Notification;
import android.content.Context;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class p {
    public static Notification.Builder a(Context context, String str) {
        return new Notification.Builder(context, str);
    }

    public static Notification.Builder b(Notification.Builder builder, int i9) {
        return builder.setBadgeIconType(i9);
    }

    public static Notification.Builder c(Notification.Builder builder, boolean z8) {
        return builder.setColorized(z8);
    }

    public static Notification.Builder d(Notification.Builder builder, int i9) {
        return builder.setGroupAlertBehavior(i9);
    }

    public static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
        return builder.setSettingsText(charSequence);
    }

    public static Notification.Builder f(Notification.Builder builder, String str) {
        return builder.setShortcutId(str);
    }

    public static Notification.Builder g(Notification.Builder builder, long j5) {
        return builder.setTimeoutAfter(j5);
    }
}
