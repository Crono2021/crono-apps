package n0;

import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;
import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q0 implements OnReceiveContentListener {

    /* renamed from: a, reason: collision with root package name */
    public final s f7193a;

    public q0(s sVar) {
        this.f7193a = sVar;
    }

    @Override // android.view.OnReceiveContentListener
    public final ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
        g gVar = new g(new i7.x(contentInfo));
        g a9 = ((r0.t) this.f7193a).a(view, gVar);
        if (a9 == null) {
            return null;
        }
        if (a9 == gVar) {
            return contentInfo;
        }
        ContentInfo o8 = a9.f7153a.o();
        Objects.requireNonNull(o8);
        return m1.u.j(o8);
    }
}
