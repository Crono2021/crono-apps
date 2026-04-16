package i7;

import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import com.network.tvgramplayer.data.SearchHistoryManager$QuickSearchItem;
import com.network.tvgramplayer.ui.MainActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class u0 implements a8.l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5136i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ MainActivity f5137j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f5138k;

    public /* synthetic */ u0(MainActivity mainActivity, RecyclerView recyclerView, int i9) {
        this.f5136i = i9;
        this.f5137j = mainActivity;
        this.f5138k = recyclerView;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        int i9 = this.f5136i;
        RecyclerView recyclerView = this.f5138k;
        MainActivity mainActivity = this.f5137j;
        switch (i9) {
            case 0:
                SearchHistoryManager$QuickSearchItem searchHistoryManager$QuickSearchItem = (SearchHistoryManager$QuickSearchItem) obj;
                int i10 = MainActivity.X;
                searchHistoryManager$QuickSearchItem.getClass();
                EditText editText = new EditText(mainActivity);
                editText.setText(searchHistoryManager$QuickSearchItem.getQuery());
                new g.j(mainActivity).setTitle("Editar Búsqueda").setView(editText).g("Guardar", new x0(editText, mainActivity, searchHistoryManager$QuickSearchItem, recyclerView)).d("Cancelar", null).h();
                break;
            case 1:
                SearchHistoryManager$QuickSearchItem searchHistoryManager$QuickSearchItem2 = (SearchHistoryManager$QuickSearchItem) obj;
                int i11 = MainActivity.X;
                searchHistoryManager$QuickSearchItem2.getClass();
                a5.d dVar = mainActivity.M;
                if (dVar == null) {
                    b8.i.d("searchHistoryManager");
                    throw null;
                }
                dVar.U0(searchHistoryManager$QuickSearchItem2);
                o3.g0 adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    j7.g gVar = (j7.g) adapter;
                    a5.d dVar2 = mainActivity.M;
                    if (dVar2 == null) {
                        b8.i.d("searchHistoryManager");
                        throw null;
                    }
                    gVar.f5455d = dVar2.I0();
                    gVar.c();
                }
                mainActivity.A();
                break;
            default:
                SearchHistoryManager$QuickSearchItem searchHistoryManager$QuickSearchItem3 = (SearchHistoryManager$QuickSearchItem) obj;
                int i12 = MainActivity.X;
                searchHistoryManager$QuickSearchItem3.getClass();
                a5.d dVar3 = mainActivity.M;
                if (dVar3 == null) {
                    b8.i.d("searchHistoryManager");
                    throw null;
                }
                dVar3.X0(SearchHistoryManager$QuickSearchItem.copy$default(searchHistoryManager$QuickSearchItem3, searchHistoryManager$QuickSearchItem3.getQuery() + " (Copia)", 0L, 0L, null, null, 30, null));
                o3.g0 adapter2 = recyclerView.getAdapter();
                if (adapter2 != null) {
                    j7.g gVar2 = (j7.g) adapter2;
                    a5.d dVar4 = mainActivity.M;
                    if (dVar4 == null) {
                        b8.i.d("searchHistoryManager");
                        throw null;
                    }
                    gVar2.f5455d = dVar4.I0();
                    gVar2.c();
                }
                mainActivity.A();
                break;
        }
        return n7.g.f7490c;
    }
}
