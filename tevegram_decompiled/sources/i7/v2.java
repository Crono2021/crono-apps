package i7;

import android.widget.Toast;
import com.network.tvgramplayer.ui.MediaExplorerActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v2 extends t7.h implements a8.p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f5160m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ MediaExplorerActivity f5161n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v2(MediaExplorerActivity mediaExplorerActivity, r7.c cVar, int i9) {
        super(2, cVar);
        this.f5160m = i9;
        this.f5161n = mediaExplorerActivity;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        i8.u uVar = (i8.u) obj;
        r7.c cVar = (r7.c) obj2;
        switch (this.f5160m) {
            case 0:
                v2 v2Var = (v2) j(uVar, cVar);
                n7.g gVar = n7.g.f7490c;
                v2Var.k(gVar);
                return gVar;
            case 1:
                v2 v2Var2 = (v2) j(uVar, cVar);
                n7.g gVar2 = n7.g.f7490c;
                v2Var2.k(gVar2);
                return gVar2;
            default:
                v2 v2Var3 = (v2) j(uVar, cVar);
                n7.g gVar3 = n7.g.f7490c;
                v2Var3.k(gVar3);
                return gVar3;
        }
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        switch (this.f5160m) {
            case 0:
                return new v2(this.f5161n, cVar, 0);
            case 1:
                return new v2(this.f5161n, cVar, 1);
            default:
                return new v2(this.f5161n, cVar, 2);
        }
    }

    @Override // t7.a
    public final Object k(Object obj) {
        switch (this.f5160m) {
            case 0:
                com.bumptech.glide.c.V(obj);
                Toast.makeText(this.f5161n, "Archivo no encontrado en caché", 0).show();
                break;
            case 1:
                com.bumptech.glide.c.V(obj);
                Toast.makeText(this.f5161n, "Archivo no encontrado en caché", 0).show();
                break;
            default:
                com.bumptech.glide.c.V(obj);
                Toast.makeText(this.f5161n, "Archivo guardado correctamente 🎉", 0).show();
                break;
        }
        return n7.g.f7490c;
    }
}
