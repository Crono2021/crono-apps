package i7;

import android.view.View;
import com.network.tvgramplayer.ui.PlayerActivity;
import java.io.File;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class c3 implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4809i = 1;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f4810j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ c7.f f4811k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ k7.a f4812l;

    public /* synthetic */ c3(PlayerActivity playerActivity, c7.f fVar, k7.a aVar) {
        this.f4810j = playerActivity;
        this.f4811k = fVar;
        this.f4812l = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f4809i) {
            case 0:
                int i9 = PlayerActivity.X;
                String[] strArr = {"ALL", "RETRO", "FRACTAL", "SPACE", "ORGANIC"};
                b8.m mVar = new b8.m();
                int b02 = o7.f.b0(strArr, this.f4812l.e());
                if (b02 < 0) {
                    b02 = 0;
                }
                mVar.f1523i = b02;
                k5.b m9 = new k5.b(this.f4810j, 0).m("Seleccionar Grupo");
                int i10 = mVar.f1523i;
                a1 a1Var = new a1(mVar, 2);
                g.f fVar = m9.f3568a;
                fVar.f3520p = strArr;
                fVar.f3522r = a1Var;
                fVar.f3527w = i10;
                fVar.f3526v = true;
                m9.l("OK", new b1(strArr, mVar, this.f4811k, 4));
                m9.h();
                break;
            default:
                int i11 = PlayerActivity.X;
                PlayerActivity playerActivity = this.f4810j;
                File[] externalFilesDirs = playerActivity.getExternalFilesDirs(null);
                externalFilesDirs.getClass();
                ArrayList arrayList = new ArrayList();
                for (File file : externalFilesDirs) {
                    if (file != null) {
                        arrayList.add(file);
                    }
                }
                ArrayList arrayList2 = new ArrayList(o7.j.E0(arrayList));
                int size = arrayList.size();
                int i12 = 0;
                while (i12 < size) {
                    Object obj = arrayList.get(i12);
                    i12++;
                    arrayList2.add(((File) obj).getAbsolutePath());
                }
                if (!arrayList2.isEmpty()) {
                    ArrayList arrayList3 = new ArrayList(o7.j.E0(arrayList2));
                    int size2 = arrayList2.size();
                    int i13 = 0;
                    while (i13 < size2) {
                        Object obj2 = arrayList2.get(i13);
                        i13++;
                        String str = (String) obj2;
                        str.getClass();
                        arrayList3.add((h8.e.g0(str, "emulated", false) ? "Interno: " : "SD/USB: ").concat(str));
                    }
                    new g.j(playerActivity).setTitle("Elige ubicación").b((String[]) arrayList3.toArray(new String[0]), new x0(arrayList2, this.f4811k, this.f4812l, playerActivity, 3)).h();
                    break;
                }
                break;
        }
    }

    public /* synthetic */ c3(k7.a aVar, PlayerActivity playerActivity, c7.f fVar) {
        this.f4812l = aVar;
        this.f4810j = playerActivity;
        this.f4811k = fVar;
    }
}
