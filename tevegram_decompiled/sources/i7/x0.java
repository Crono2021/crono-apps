package i7;

import android.content.DialogInterface;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.network.tvgramplayer.data.SearchHistoryManager$QuickSearchItem;
import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.ui.PlayerActivity;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class x0 implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5180i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ g.l f5181j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f5182k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f5183l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f5184m;

    public /* synthetic */ x0(EditText editText, MainActivity mainActivity, SearchHistoryManager$QuickSearchItem searchHistoryManager$QuickSearchItem, RecyclerView recyclerView) {
        this.f5180i = 1;
        this.f5182k = editText;
        this.f5181j = mainActivity;
        this.f5183l = searchHistoryManager$QuickSearchItem;
        this.f5184m = recyclerView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i9) {
        int i10 = this.f5180i;
        g.l lVar = this.f5181j;
        Object obj = this.f5184m;
        Object obj2 = this.f5183l;
        Object obj3 = this.f5182k;
        switch (i10) {
            case 0:
                String[] strArr = (String[]) obj3;
                boolean[] zArr = (boolean[]) obj2;
                k7.a aVar = (k7.a) obj;
                MainActivity mainActivity = (MainActivity) lVar;
                int i11 = MainActivity.X;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                int length = strArr.length;
                for (int i12 = 0; i12 < length; i12++) {
                    if (zArr[i12]) {
                        linkedHashSet.add(strArr[i12]);
                    }
                }
                aVar.f5628b.edit().putStringSet("enabled_uri_schemes", linkedHashSet).apply();
                Toast.makeText(mainActivity, "Esquemas actualizados", 0).show();
                return;
            case 1:
                MainActivity mainActivity2 = (MainActivity) lVar;
                SearchHistoryManager$QuickSearchItem searchHistoryManager$QuickSearchItem = (SearchHistoryManager$QuickSearchItem) obj2;
                RecyclerView recyclerView = (RecyclerView) obj;
                int i13 = MainActivity.X;
                String obj4 = ((EditText) obj3).getText().toString();
                if (obj4.length() > 0) {
                    a5.d dVar = mainActivity2.M;
                    if (dVar == null) {
                        b8.i.d("searchHistoryManager");
                        throw null;
                    }
                    dVar.U0(searchHistoryManager$QuickSearchItem);
                    a5.d dVar2 = mainActivity2.M;
                    if (dVar2 == null) {
                        b8.i.d("searchHistoryManager");
                        throw null;
                    }
                    dVar2.X0(SearchHistoryManager$QuickSearchItem.copy$default(searchHistoryManager$QuickSearchItem, obj4, 0L, 0L, null, null, 30, null));
                    o3.g0 adapter = recyclerView.getAdapter();
                    if (adapter != null) {
                        j7.g gVar = (j7.g) adapter;
                        a5.d dVar3 = mainActivity2.M;
                        if (dVar3 == null) {
                            b8.i.d("searchHistoryManager");
                            throw null;
                        }
                        gVar.f5455d = dVar3.I0();
                        gVar.c();
                    }
                    mainActivity2.A();
                    return;
                }
                return;
            case 2:
                int i14 = PlayerActivity.X;
                String str = ((String[]) obj3)[((b8.m) obj2).f1523i];
                ((k7.a) obj).j(str);
                l7.g gVar2 = ((PlayerActivity) lVar).S;
                if (gVar2 != null) {
                    try {
                        l7.c valueOf = l7.c.valueOf(str);
                        valueOf.getClass();
                        gVar2.f6332u = valueOf;
                        gVar2.f();
                    } catch (Exception e9) {
                        Log.e("PlayerActivity", "Error setting group", e9);
                    }
                }
                dialogInterface.dismiss();
                return;
            default:
                int i15 = PlayerActivity.X;
                String str2 = (String) ((ArrayList) obj3).get(i9);
                ((c7.f) obj2).f1724k.setText(str2);
                str2.getClass();
                ((k7.a) obj).f5628b.edit().putString("storage_path", str2).apply();
                Toast.makeText((PlayerActivity) lVar, "Ruta seleccionada. Guarda y reinicia la app.", 1).show();
                return;
        }
    }

    public /* synthetic */ x0(Object obj, Object obj2, k7.a aVar, g.l lVar, int i9) {
        this.f5180i = i9;
        this.f5182k = obj;
        this.f5183l = obj2;
        this.f5184m = aVar;
        this.f5181j = lVar;
    }
}
