package i7;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class u implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5132i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f5133j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f5134k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f5135l;

    public /* synthetic */ u(Object obj, Object obj2, Object obj3, int i9) {
        this.f5132i = i9;
        this.f5133j = obj;
        this.f5134k = obj2;
        this.f5135l = obj3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i9 = this.f5132i;
        Object obj = this.f5135l;
        Object obj2 = this.f5134k;
        Object obj3 = this.f5133j;
        switch (i9) {
            case 0:
                CheckBox checkBox = ((v) obj3).f5153v;
                boolean isChecked = checkBox.isChecked();
                checkBox.setChecked(!isChecked);
                androidx.fragment.app.g gVar = (androidx.fragment.app.g) ((w) obj2).f5166f;
                long j5 = ((h7.i0) obj).f4113a;
                gVar.getClass();
                String valueOf = String.valueOf(j5);
                LinkedHashSet linkedHashSet = (LinkedHashSet) gVar.f730l;
                if (isChecked) {
                    linkedHashSet.add(valueOf);
                } else {
                    linkedHashSet.remove(valueOf);
                }
                ((SharedPreferences) gVar.f728j).edit().putStringSet((String) gVar.f729k, linkedHashSet).apply();
                return;
            case 1:
                MainActivity mainActivity = (MainActivity) obj2;
                Button button = (Button) obj;
                int i10 = MainActivity.X;
                String[] strArr = {"ALL", "RETRO", "FRACTAL", "SPACE", "ORGANIC"};
                b8.m mVar = new b8.m();
                int b02 = o7.f.b0(strArr, ((k7.a) obj3).e());
                int i11 = 0;
                if (b02 < 0) {
                    b02 = 0;
                }
                mVar.f1523i = b02;
                k5.b m9 = new k5.b(mainActivity, 0).m("Seleccionar Grupo");
                int i12 = mVar.f1523i;
                a1 a1Var = new a1(mVar, i11);
                g.f fVar = m9.f3568a;
                fVar.f3520p = strArr;
                fVar.f3522r = a1Var;
                fVar.f3527w = i12;
                fVar.f3526v = true;
                m9.l("OK", new b1(strArr, mVar, button, i11));
                m9.h();
                return;
            case 2:
                MediaExplorerActivity mediaExplorerActivity = (MediaExplorerActivity) obj3;
                String str = (String) obj2;
                t2 t2Var = (t2) obj;
                a5.d dVar = mediaExplorerActivity.I;
                if (dVar == null) {
                    b8.i.d("searchHistoryManager");
                    throw null;
                }
                long j9 = mediaExplorerActivity.K;
                long j10 = mediaExplorerActivity.L;
                ArrayList arrayList = new ArrayList(dVar.K0(j9, j10));
                if (arrayList.remove(str)) {
                    dVar.W0(j9, j10, arrayList);
                }
                a5.d dVar2 = mediaExplorerActivity.I;
                if (dVar2 == null) {
                    b8.i.d("searchHistoryManager");
                    throw null;
                }
                t2Var.f5127d = dVar2.K0(mediaExplorerActivity.K, mediaExplorerActivity.L);
                t2Var.c();
                if (t2Var.f5127d.isEmpty()) {
                    mediaExplorerActivity.v();
                    return;
                }
                return;
            default:
                j7.d dVar3 = (j7.d) obj2;
                TdApi.Chat chat = (TdApi.Chat) obj;
                CheckBox checkBox2 = ((j7.c) obj3).f5441v;
                boolean isChecked2 = checkBox2.isChecked();
                boolean z8 = !isChecked2;
                checkBox2.setChecked(z8);
                Set set = dVar3.f5443d;
                long j11 = chat.id;
                if (isChecked2) {
                    set.remove(Long.valueOf(j11));
                } else {
                    set.add(Long.valueOf(j11));
                }
                dVar3.f5444e.h(chat, Boolean.valueOf(z8));
                return;
        }
    }
}
