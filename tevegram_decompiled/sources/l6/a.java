package l6;

import android.content.Context;
import android.preference.PreferenceManager;
import androidx.fragment.app.g;
import f6.f;
import n.c4;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f6266b = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final f f6267a;

    public a(c4 c4Var) {
        Context context = (Context) c4Var.f6834a;
        String str = (String) c4Var.f6835b;
        String str2 = (String) c4Var.f6836c;
        if (str == null) {
            m7.c.n("keysetName cannot be null");
            throw null;
        }
        Context applicationContext = context.getApplicationContext();
        if (str2 == null) {
            PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
        } else {
            applicationContext.getSharedPreferences(str2, 0).edit();
        }
        this.f6267a = (f) c4Var.f6840g;
    }

    public final synchronized g a() {
        return this.f6267a.c();
    }
}
