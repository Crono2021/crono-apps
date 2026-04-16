package i7;

import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.util.SubscriptionItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c2 implements l8.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainActivity f4808a;

    public c2(MainActivity mainActivity) {
        this.f4808a = mainActivity;
    }

    @Override // l8.a
    public final Object a(Object obj, t7.c cVar) {
        Object obj2;
        List list = (List) obj;
        MainActivity mainActivity = this.f4808a;
        a0.l lVar = mainActivity.J;
        if (lVar == null) {
            b8.i.d("subscriptionManager");
            throw null;
        }
        List<SubscriptionItem> list2 = (List) ((l8.d) lVar.f32k).d();
        ArrayList arrayList = new ArrayList(o7.j.E0(list2));
        boolean z8 = false;
        for (SubscriptionItem subscriptionItem : list2) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                if (((TdApi.Chat) obj2).id == subscriptionItem.getChatId()) {
                    break;
                }
            }
            TdApi.Chat chat = (TdApi.Chat) obj2;
            if (chat != null) {
                mainActivity.t().getClass();
                boolean p5 = h7.k0.p(chat);
                if (p5 != subscriptionItem.isArchived()) {
                    subscriptionItem = SubscriptionItem.copy$default(subscriptionItem, 0L, null, null, 0L, false, p5, null, 95, null);
                    z8 = true;
                }
            }
            arrayList.add(subscriptionItem);
        }
        if (z8) {
            a0.l lVar2 = mainActivity.J;
            if (lVar2 == null) {
                b8.i.d("subscriptionManager");
                throw null;
            }
            lVar2.v(arrayList);
        }
        return n7.g.f7490c;
    }
}
