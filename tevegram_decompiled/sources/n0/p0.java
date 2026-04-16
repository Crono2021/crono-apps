package n0;

import android.view.ContentInfo;
import android.view.View;
import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class p0 {
    public static String[] a(View view) {
        return view.getReceiveContentMimeTypes();
    }

    public static g b(View view, g gVar) {
        ContentInfo o8 = gVar.f7153a.o();
        Objects.requireNonNull(o8);
        ContentInfo j5 = m1.u.j(o8);
        ContentInfo performReceiveContent = view.performReceiveContent(j5);
        if (performReceiveContent == null) {
            return null;
        }
        return performReceiveContent == j5 ? gVar : new g(new i7.x(performReceiveContent));
    }

    public static void c(View view, String[] strArr, s sVar) {
        if (sVar == null) {
            view.setOnReceiveContentListener(strArr, null);
        } else {
            view.setOnReceiveContentListener(strArr, new q0(sVar));
        }
    }
}
