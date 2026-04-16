package i4;

import b4.h;
import b4.i;
import com.bumptech.glide.load.data.l;
import h4.g;
import h4.n;
import h4.o;
import h4.p;
import h4.q;
import java.util.ArrayDeque;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements q {

    /* renamed from: b, reason: collision with root package name */
    public static final h f4699b = h.a(2500, "com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout");

    /* renamed from: a, reason: collision with root package name */
    public final a0.b f4700a;

    public a(a0.b bVar) {
        this.f4700a = bVar;
    }

    @Override // h4.q
    public final p a(Object obj, int i9, int i10, i iVar) {
        g gVar = (g) obj;
        a0.b bVar = this.f4700a;
        if (bVar != null) {
            n nVar = (n) bVar.f8j;
            o a9 = o.a(gVar);
            Object a10 = nVar.a(a9);
            ArrayDeque arrayDeque = o.f3998b;
            synchronized (arrayDeque) {
                arrayDeque.offer(a9);
            }
            g gVar2 = (g) a10;
            if (gVar2 == null) {
                nVar.d(o.a(gVar), gVar);
            } else {
                gVar = gVar2;
            }
        }
        return new p(gVar, new l(gVar, ((Integer) iVar.c(f4699b)).intValue()));
    }

    @Override // h4.q
    public final /* bridge */ /* synthetic */ boolean b(Object obj) {
        return true;
    }
}
