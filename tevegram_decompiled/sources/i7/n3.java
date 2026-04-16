package i7;

import android.widget.Toast;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import com.network.tvgramplayer.ui.PlayerActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n3 extends t7.h implements a8.p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f4996m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f4997n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n3(PlayerActivity playerActivity, r7.c cVar, int i9) {
        super(2, cVar);
        this.f4996m = i9;
        this.f4997n = playerActivity;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        i8.u uVar = (i8.u) obj;
        r7.c cVar = (r7.c) obj2;
        switch (this.f4996m) {
            case 0:
                n3 n3Var = (n3) j(uVar, cVar);
                n7.g gVar = n7.g.f7490c;
                n3Var.k(gVar);
                return gVar;
            case 1:
                n3 n3Var2 = (n3) j(uVar, cVar);
                n7.g gVar2 = n7.g.f7490c;
                n3Var2.k(gVar2);
                return gVar2;
            default:
                n3 n3Var3 = (n3) j(uVar, cVar);
                n7.g gVar3 = n7.g.f7490c;
                n3Var3.k(gVar3);
                return gVar3;
        }
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        switch (this.f4996m) {
            case 0:
                return new n3(this.f4997n, cVar, 0);
            case 1:
                return new n3(this.f4997n, cVar, 1);
            default:
                return new n3(this.f4997n, cVar, 2);
        }
    }

    @Override // t7.a
    public final Object k(Object obj) {
        int i9 = this.f4996m;
        PlayerActivity playerActivity = this.f4997n;
        switch (i9) {
            case 0:
                com.bumptech.glide.c.V(obj);
                Toast.makeText(playerActivity, "Eliminado de Favoritos", 0).show();
                break;
            case 1:
                com.bumptech.glide.c.V(obj);
                Toast.makeText(playerActivity, "Añadido a Favoritos", 0).show();
                break;
            default:
                com.bumptech.glide.c.V(obj);
                e7.a aVar = playerActivity.H;
                if (aVar != null) {
                    LifecycleCoroutineScopeImpl a9 = androidx.lifecycle.g0.a(playerActivity);
                    p8.d dVar = i8.c0.f5250a;
                    i8.w.j(a9, n8.o.f7529a, new o3(playerActivity, aVar, (r7.c) null), 2);
                }
                break;
        }
        return n7.g.f7490c;
    }
}
