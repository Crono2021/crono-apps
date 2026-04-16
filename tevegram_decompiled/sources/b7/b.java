package b7;

import a8.l;
import android.util.Log;
import b2.f0;
import com.network.tvgramplayer.data.HistoryItem;
import com.network.tvgramplayer.data.SearchHistoryManager$QuickSearchItem;
import com.network.tvgramplayer.util.SubscriptionItem;
import h7.k0;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class b implements l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1482i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f1483j;

    public /* synthetic */ b(Object obj, int i9) {
        this.f1482i = i9;
        this.f1483j = obj;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        ArrayList arrayList;
        switch (this.f1482i) {
            case 0:
                return Boolean.valueOf(b8.i.a(((HistoryItem) obj).getUrl(), ((HistoryItem) this.f1483j).getUrl()));
            case 1:
                SearchHistoryManager$QuickSearchItem searchHistoryManager$QuickSearchItem = (SearchHistoryManager$QuickSearchItem) this.f1483j;
                SearchHistoryManager$QuickSearchItem searchHistoryManager$QuickSearchItem2 = (SearchHistoryManager$QuickSearchItem) obj;
                searchHistoryManager$QuickSearchItem2.getClass();
                return Boolean.valueOf(b8.i.a(searchHistoryManager$QuickSearchItem2.getQuery(), searchHistoryManager$QuickSearchItem.getQuery()) && searchHistoryManager$QuickSearchItem2.getChatId() == searchHistoryManager$QuickSearchItem.getChatId() && searchHistoryManager$QuickSearchItem2.getThreadId() == searchHistoryManager$QuickSearchItem.getThreadId() && b8.i.a(searchHistoryManager$QuickSearchItem2.getFilterType(), searchHistoryManager$QuickSearchItem.getFilterType()));
            case 2:
                k0 k0Var = (k0) this.f1483j;
                int i9 = 0;
                boolean z8 = ((String) obj) != null;
                synchronized (k0Var.f4148s) {
                    k0Var.f4147r = false;
                    arrayList = new ArrayList(k0Var.f4148s);
                    k0Var.f4148s.clear();
                }
                if (z8) {
                    Log.i("TdClient", "✅ Silent rejoin successful.");
                } else {
                    Log.e("TdClient", "❌ Silent rejoin failed.");
                }
                int size = arrayList.size();
                while (i9 < size) {
                    Object obj2 = arrayList.get(i9);
                    i9++;
                    ((l) obj2).a(Boolean.valueOf(z8));
                }
                return n7.g.f7490c;
            case 3:
                i7.j jVar = (i7.j) this.f1483j;
                String str = (String) obj;
                if (str != null && str.length() != 0) {
                    jVar.f7618a.post(new f0(jVar, 10, str));
                }
                return n7.g.f7490c;
            case 4:
                j7.j jVar2 = (j7.j) this.f1483j;
                String str2 = (String) obj;
                if (str2 != null && str2.length() != 0) {
                    jVar2.f7618a.post(new f0(jVar2, 12, str2));
                }
                return n7.g.f7490c;
            case 5:
                SubscriptionItem subscriptionItem = (SubscriptionItem) this.f1483j;
                SubscriptionItem subscriptionItem2 = (SubscriptionItem) obj;
                subscriptionItem2.getClass();
                return Boolean.valueOf(b8.i.a(subscriptionItem2.getUrl(), subscriptionItem.getUrl()) || subscriptionItem2.getChatId() == subscriptionItem.getChatId());
            default:
                return obj == ((o7.c) this.f1483j) ? "(this Collection)" : String.valueOf(obj);
        }
    }
}
