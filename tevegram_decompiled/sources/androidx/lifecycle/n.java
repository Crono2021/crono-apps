package androidx.lifecycle;

import android.content.SharedPreferences;
import android.net.Uri;
import android.widget.Toast;
import com.google.gson.Gson;
import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import java.io.File;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n extends t7.h implements a8.p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f934m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ Object f935n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f936o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(Object obj, Object obj2, r7.c cVar, int i9) {
        super(2, cVar);
        this.f934m = i9;
        this.f935n = obj;
        this.f936o = obj2;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        i8.u uVar = (i8.u) obj;
        r7.c cVar = (r7.c) obj2;
        switch (this.f934m) {
            case 0:
                n nVar = (n) j(uVar, cVar);
                n7.g gVar = n7.g.f7490c;
                nVar.k(gVar);
                return gVar;
            case 1:
                n nVar2 = (n) j(uVar, cVar);
                n7.g gVar2 = n7.g.f7490c;
                nVar2.k(gVar2);
                return gVar2;
            case 2:
                n nVar3 = (n) j(uVar, cVar);
                n7.g gVar3 = n7.g.f7490c;
                nVar3.k(gVar3);
                return gVar3;
            case 3:
                n nVar4 = (n) j(uVar, cVar);
                n7.g gVar4 = n7.g.f7490c;
                nVar4.k(gVar4);
                return gVar4;
            default:
                n nVar5 = (n) j(uVar, cVar);
                n7.g gVar5 = n7.g.f7490c;
                nVar5.k(gVar5);
                return gVar5;
        }
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        switch (this.f934m) {
            case 0:
                n nVar = new n((LifecycleCoroutineScopeImpl) this.f936o, cVar);
                nVar.f935n = obj;
                return nVar;
            case 1:
                return new n((a0.l) this.f935n, (ArrayList) this.f936o, cVar, 1);
            case 2:
                return new n((MainActivity) this.f935n, (b8.m) this.f936o, cVar, 2);
            case 3:
                return new n((MainActivity) this.f935n, (Uri) this.f936o, cVar, 3);
            default:
                return new n((MediaExplorerActivity) this.f935n, (b8.o) this.f936o, cVar, 4);
        }
    }

    @Override // t7.a
    public final Object k(Object obj) {
        switch (this.f934m) {
            case 0:
                com.bumptech.glide.c.V(obj);
                i8.u uVar = (i8.u) this.f935n;
                LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl = (LifecycleCoroutineScopeImpl) this.f936o;
                u uVar2 = lifecycleCoroutineScopeImpl.f889i;
                if (uVar2.f943d.compareTo(m.f929j) >= 0) {
                    uVar2.a(lifecycleCoroutineScopeImpl);
                } else {
                    i8.w.b(uVar.c(), null);
                }
                return n7.g.f7490c;
            case 1:
                a0.l lVar = (a0.l) this.f935n;
                com.bumptech.glide.c.V(obj);
                try {
                    ((SharedPreferences) lVar.f31j).edit().putString("items", ((Gson) lVar.f32k).toJson((ArrayList) this.f936o)).apply();
                } catch (Exception e9) {
                    e9.printStackTrace();
                }
                return n7.g.f7490c;
            case 2:
                com.bumptech.glide.c.V(obj);
                c7.d dVar = ((MainActivity) this.f935n).E;
                if (dVar == null) {
                    b8.i.d("binding");
                    throw null;
                }
                dVar.C.setText("Cargando componentes nativos... (" + ((b8.m) this.f936o).f1523i + "%)");
                return n7.g.f7490c;
            case 3:
                com.bumptech.glide.c.V(obj);
                MainActivity mainActivity = (MainActivity) this.f935n;
                c7.d dVar2 = mainActivity.E;
                if (dVar2 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                dVar2.f1693x.setVisibility(0);
                mainActivity.s("> Deep Link Detected: " + ((Uri) this.f936o));
                return n7.g.f7490c;
            default:
                com.bumptech.glide.c.V(obj);
                Toast.makeText((MediaExplorerActivity) this.f935n, "Guardado en Descargas: " + ((File) ((b8.o) this.f936o).f1525i).getName() + " 🎉", 1).show();
                return n7.g.f7490c;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, r7.c cVar) {
        super(2, cVar);
        this.f934m = 0;
        this.f936o = lifecycleCoroutineScopeImpl;
    }
}
