package i7;

import android.view.View;
import com.network.tvgramplayer.data.HistoryItem;
import com.network.tvgramplayer.data.SearchHistoryManager$QuickSearchItem;
import com.network.tvgramplayer.telegram.TdClient$ExplorerItem;
import com.network.tvgramplayer.util.SubscriptionItem;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class o implements View.OnLongClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4998i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ o3.g0 f4999j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f5000k;

    public /* synthetic */ o(o3.g0 g0Var, Object obj, int i9) {
        this.f4998i = i9;
        this.f4999j = g0Var;
        this.f5000k = obj;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        switch (this.f4998i) {
            case 0:
                r rVar = (r) this.f4999j;
                ((m0) rVar.f5061i).a((HistoryItem) this.f5000k);
                break;
            case 1:
                b4 b4Var = (b4) this.f4999j;
                ((m0) b4Var.f4796g).a((SearchHistoryManager$QuickSearchItem) this.f5000k);
                break;
            case 2:
                j7.l lVar = (j7.l) this.f4999j;
                TdClient$ExplorerItem tdClient$ExplorerItem = (TdClient$ExplorerItem) this.f5000k;
                e2 e2Var = lVar.h;
                if (e2Var != null) {
                    e2Var.a(tdClient$ExplorerItem);
                    break;
                }
                break;
            default:
                b4 b4Var2 = (b4) this.f4999j;
                ((m0) b4Var2.f4796g).a((SubscriptionItem) this.f5000k);
                break;
        }
        return true;
    }
}
