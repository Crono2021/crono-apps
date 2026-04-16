package t1;

import d1.s;
import q2.h;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f8916a = new a();

    public final android.support.v4.media.session.b a(s sVar) {
        String str = sVar.f2554m;
        if (str != null) {
            switch (str) {
                case "application/vnd.dvb.ait":
                    return new m2.b(0);
                case "application/x-icy":
                    return new p2.a();
                case "application/id3":
                    return new h(null);
                case "application/x-emsg":
                    return new m2.b(1);
                case "application/x-scte35":
                    return new s2.c();
            }
        }
        m7.c.n(t.a.b("Attempted to create decoder for unsupported MIME type: ", str));
        return null;
    }

    public final boolean b(s sVar) {
        String str = sVar.f2554m;
        return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
    }
}
