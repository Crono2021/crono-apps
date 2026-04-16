package com.google.crypto.tink.shaded.protobuf;

import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static volatile q f2291a;

    /* renamed from: b, reason: collision with root package name */
    public static final q f2292b;

    static {
        q qVar = new q();
        Map map = Collections.EMPTY_MAP;
        f2292b = qVar;
    }

    public static q a() {
        q qVar;
        q qVar2 = f2291a;
        if (qVar2 != null) {
            return qVar2;
        }
        synchronized (q.class) {
            try {
                qVar = f2291a;
                if (qVar == null) {
                    Class cls = p.f2283a;
                    q qVar3 = null;
                    if (cls != null) {
                        try {
                            qVar3 = (q) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                        }
                    }
                    qVar = qVar3 != null ? qVar3 : f2292b;
                    f2291a = qVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return qVar;
    }
}
