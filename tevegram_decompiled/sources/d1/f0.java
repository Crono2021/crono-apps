package d1;

import java.util.HashSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet f2419a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public static String f2420b = "media3.common";

    public static synchronized void a(String str) {
        synchronized (f0.class) {
            if (f2419a.add(str)) {
                f2420b += ", " + str;
            }
        }
    }
}
