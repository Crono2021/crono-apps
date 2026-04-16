package i7;

import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.util.SubscriptionItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l1 extends t7.h implements a8.q {

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ List f4954m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ List f4955n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ MainActivity f4956o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l1(MainActivity mainActivity, r7.c cVar) {
        super(3, cVar);
        this.f4956o = mainActivity;
    }

    @Override // a8.q
    public final Object c(Object obj, Object obj2, Serializable serializable) {
        l1 l1Var = new l1(this.f4956o, (r7.c) serializable);
        l1Var.f4954m = (List) obj;
        l1Var.f4955n = (List) obj2;
        return l1Var.k(n7.g.f7490c);
    }

    @Override // t7.a
    public final Object k(Object obj) {
        TdApi.File file;
        Object obj2;
        TdApi.ChatPhotoInfo chatPhotoInfo;
        TdApi.ChatPhotoInfo chatPhotoInfo2;
        TdApi.File file2;
        TdApi.LocalFile localFile;
        List<SubscriptionItem> list = this.f4954m;
        List list2 = this.f4955n;
        com.bumptech.glide.c.V(obj);
        ArrayList arrayList = new ArrayList(o7.j.E0(list));
        for (SubscriptionItem subscriptionItem : list) {
            Iterator it = list2.iterator();
            while (true) {
                file = null;
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
            String str = (chat == null || (chatPhotoInfo2 = chat.photo) == null || (file2 = chatPhotoInfo2.small) == null || (localFile = file2.local) == null) ? null : localFile.path;
            if (str == null || str.length() <= 0) {
                if (chat != null && (chatPhotoInfo = chat.photo) != null) {
                    file = chatPhotoInfo.small;
                }
                if (file != null) {
                    String str2 = file.local.path;
                    str2.getClass();
                    if (str2.length() == 0) {
                        int i9 = MainActivity.X;
                        h7.k0 t8 = this.f4956o.t();
                        int i10 = file.id;
                        Client client = t8.f4141l;
                        if (client != null) {
                            client.send(new TdApi.DownloadFile(i10, 1, 0L, 0L, true), new androidx.fragment.app.a(27));
                        }
                    }
                }
            } else {
                subscriptionItem = SubscriptionItem.copy$default(subscriptionItem, 0L, null, null, 0L, false, false, str, 63, null);
            }
            arrayList.add(subscriptionItem);
        }
        return arrayList;
    }
}
