package i7;

import android.util.Log;
import android.widget.Toast;
import com.network.tvgramplayer.ui.MediaExplorerActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class w2 extends t7.h implements a8.p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f5172m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Exception f5173n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ MediaExplorerActivity f5174o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w2(Exception exc, MediaExplorerActivity mediaExplorerActivity, r7.c cVar, int i9) {
        super(2, cVar);
        this.f5172m = i9;
        this.f5173n = exc;
        this.f5174o = mediaExplorerActivity;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        i8.u uVar = (i8.u) obj;
        r7.c cVar = (r7.c) obj2;
        switch (this.f5172m) {
            case 0:
                w2 w2Var = (w2) j(uVar, cVar);
                n7.g gVar = n7.g.f7490c;
                w2Var.k(gVar);
                return gVar;
            default:
                w2 w2Var2 = (w2) j(uVar, cVar);
                n7.g gVar2 = n7.g.f7490c;
                w2Var2.k(gVar2);
                return gVar2;
        }
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        switch (this.f5172m) {
            case 0:
                return new w2(this.f5173n, this.f5174o, cVar, 0);
            default:
                return new w2(this.f5173n, this.f5174o, cVar, 1);
        }
    }

    @Override // t7.a
    public final Object k(Object obj) {
        switch (this.f5172m) {
            case 0:
                com.bumptech.glide.c.V(obj);
                Log.e("MediaExplorer", "Error copiando archivo a Downloads", this.f5173n);
                Toast.makeText(this.f5174o, "Error al guardar en Descargas", 0).show();
                break;
            default:
                com.bumptech.glide.c.V(obj);
                Log.e("MediaExplorer", "Error copiando archivo", this.f5173n);
                Toast.makeText(this.f5174o, "Error al guardar el archivo", 0).show();
                break;
        }
        return n7.g.f7490c;
    }
}
