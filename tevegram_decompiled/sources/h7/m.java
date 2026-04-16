package h7;

import com.network.tvgramplayer.telegram.TdClient$ExplorerAction;
import com.network.tvgramplayer.telegram.TdClient$ExplorerItem;
import com.network.tvgramplayer.telegram.TdClient$ExplorerType;
import com.network.tvgramplayer.voip.NativeInstance;
import i7.h2;
import java.util.ArrayList;
import java.util.List;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class m implements a8.l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4160i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ long f4161j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f4162k;

    public /* synthetic */ m(int i9, long j5, Object obj) {
        this.f4160i = i9;
        this.f4162k = obj;
        this.f4161j = j5;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        switch (this.f4160i) {
            case 0:
                h2 h2Var = (h2) this.f4162k;
                TdApi.ForumTopics forumTopics = (TdApi.ForumTopics) obj;
                if (forumTopics != null) {
                    TdApi.ForumTopic[] forumTopicArr = forumTopics.topics;
                    forumTopicArr.getClass();
                    ArrayList arrayList = new ArrayList(forumTopicArr.length);
                    int length = forumTopicArr.length;
                    int i9 = 0;
                    while (i9 < length) {
                        TdApi.ForumTopic forumTopic = forumTopicArr[i9];
                        TdApi.ForumTopicInfo forumTopicInfo = forumTopic.info;
                        long j5 = forumTopicInfo.forumTopicId << 20;
                        TdClient$ExplorerType tdClient$ExplorerType = TdClient$ExplorerType.TOPIC;
                        String str = forumTopicInfo.name;
                        str.getClass();
                        String str2 = "ID del tema: " + forumTopicInfo.forumTopicId + ". " + forumTopic.unreadCount + " mensajes sin leer";
                        TdClient$ExplorerType tdClient$ExplorerType2 = TdClient$ExplorerType.LINK;
                        int i10 = i9;
                        StringBuilder c9 = t.a.c("tvgram://explore?chat_id=", this.f4161j, "&thread_id=");
                        c9.append(j5);
                        List b02 = android.support.v4.media.session.b.b0(new TdClient$ExplorerAction(tdClient$ExplorerType2, "Abrir Tema", c9.toString()));
                        TdApi.Message message = forumTopic.lastMessage;
                        arrayList.add(new TdClient$ExplorerItem(0L, j5, tdClient$ExplorerType, str, str2, 0, b02, message != null ? message.date : 0, 0L, 257, null));
                        i9 = i10 + 1;
                    }
                    h2Var.a(arrayList);
                } else {
                    h2Var.a(o7.p.f8013i);
                }
                break;
            default:
                m7.k kVar = (m7.k) this.f4162k;
                long longValue = ((Long) obj).longValue();
                if (!kVar.f6728b) {
                    kVar.f6735j.set(longValue - System.currentTimeMillis());
                    kVar.f6737l.set(longValue);
                    NativeInstance nativeInstance = kVar.f6730d;
                    if (nativeInstance != null) {
                        nativeInstance.onRequestTimeComplete(this.f4161j, longValue);
                    }
                }
                break;
        }
        return n7.g.f7490c;
    }
}
