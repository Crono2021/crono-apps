package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class EmojiCompatInitializer implements r3.b {
    @Override // r3.b
    public final List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // r3.b
    public final Object b(Context context) {
        t tVar = new t(new o(context));
        tVar.f617a = 1;
        if (l.f624j == null) {
            synchronized (l.f623i) {
                try {
                    if (l.f624j == null) {
                        l.f624j = new l(tVar);
                    }
                } finally {
                }
            }
        }
        c(context);
        return Boolean.TRUE;
    }

    public final void c(Context context) {
        Object obj;
        r3.a c9 = r3.a.c(context);
        c9.getClass();
        synchronized (r3.a.f8543e) {
            try {
                obj = c9.f8544a.get(ProcessLifecycleInitializer.class);
                if (obj == null) {
                    obj = c9.b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        final androidx.lifecycle.u g9 = ((androidx.lifecycle.s) obj).g();
        g9.a(new androidx.lifecycle.d(this) { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.d
            public final void b() {
                (Build.VERSION.SDK_INT >= 28 ? c.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new p(), 500L);
                g9.f(this);
            }
        });
    }
}
