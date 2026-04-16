package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f927a = new LinkedHashMap();

    public final void a() {
        for (j0 j0Var : this.f927a.values()) {
            HashMap hashMap = j0Var.f922a;
            if (hashMap != null) {
                synchronized (hashMap) {
                    try {
                        for (Object obj : j0Var.f922a.values()) {
                            if (obj instanceof Closeable) {
                                try {
                                    ((Closeable) obj).close();
                                } catch (IOException e9) {
                                    throw new RuntimeException(e9);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
            LinkedHashSet linkedHashSet = j0Var.f923b;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    try {
                        for (Closeable closeable : j0Var.f923b) {
                            if (t.a.d(closeable)) {
                                try {
                                    closeable.close();
                                } catch (IOException e10) {
                                    throw new RuntimeException(e10);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
            j0Var.a();
        }
        this.f927a.clear();
    }
}
