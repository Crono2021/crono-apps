package c0;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a {
    public static void a(Activity activity) {
        activity.finishAffinity();
    }

    public static void b(Activity activity, Intent intent, int i9, Bundle bundle) {
        activity.startActivityForResult(intent, i9, bundle);
    }

    public static void c(Activity activity, IntentSender intentSender, int i9, Intent intent, int i10, int i11, int i12, Bundle bundle) {
        activity.startIntentSenderForResult(intentSender, i9, intent, i10, i11, i12, bundle);
    }
}
