package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class ProcessLifecycleInitializer implements r3.b {
    @Override // r3.b
    public final List a() {
        return o7.p.f8013i;
    }

    @Override // r3.b
    public final Object b(Context context) {
        context.getClass();
        r3.a c9 = r3.a.c(context);
        c9.getClass();
        if (!c9.f8545b.contains(ProcessLifecycleInitializer.class)) {
            m7.c.p("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
            return null;
        }
        if (!p.f937a.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            applicationContext.getClass();
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new o());
        }
        c0 c0Var = c0.f902q;
        c0Var.getClass();
        c0Var.f907m = new Handler();
        c0Var.f908n.d(l.ON_CREATE);
        Context applicationContext2 = context.getApplicationContext();
        applicationContext2.getClass();
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(new b0(c0Var));
        return c0Var;
    }
}
