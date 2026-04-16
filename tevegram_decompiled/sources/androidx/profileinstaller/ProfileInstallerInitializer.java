package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import d4.t;
import g.n;
import java.util.Collections;
import java.util.List;
import m3.f;
import r3.b;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class ProfileInstallerInitializer implements b {
    @Override // r3.b
    public final List a() {
        return Collections.EMPTY_LIST;
    }

    @Override // r3.b
    public final Object b(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new t(23);
        }
        f.a(new n(this, context.getApplicationContext()));
        return new t(23);
    }
}
