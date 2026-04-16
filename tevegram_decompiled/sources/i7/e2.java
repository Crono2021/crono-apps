package i7;

import android.content.Intent;
import android.widget.Toast;
import com.network.tvgramplayer.telegram.TdClient$ExplorerAction;
import com.network.tvgramplayer.telegram.TdClient$ExplorerItem;
import com.network.tvgramplayer.telegram.TdClient$ExplorerType;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class e2 implements a8.l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4832i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ MediaExplorerActivity f4833j;

    public /* synthetic */ e2(MediaExplorerActivity mediaExplorerActivity, int i9) {
        this.f4832i = i9;
        this.f4833j = mediaExplorerActivity;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        int i9 = this.f4832i;
        MediaExplorerActivity mediaExplorerActivity = this.f4833j;
        switch (i9) {
            case 0:
                TdClient$ExplorerItem tdClient$ExplorerItem = (TdClient$ExplorerItem) obj;
                int i10 = MediaExplorerActivity.Y;
                tdClient$ExplorerItem.getClass();
                mediaExplorerActivity.A(tdClient$ExplorerItem);
                break;
            case 1:
                TdClient$ExplorerItem tdClient$ExplorerItem2 = (TdClient$ExplorerItem) obj;
                int i11 = MediaExplorerActivity.Y;
                tdClient$ExplorerItem2.getClass();
                if (tdClient$ExplorerItem2.getType() == TdClient$ExplorerType.TOPIC) {
                    Intent intent = new Intent(mediaExplorerActivity, (Class<?>) MediaExplorerActivity.class);
                    intent.putExtra("chat_id", mediaExplorerActivity.K);
                    intent.putExtra("thread_id", tdClient$ExplorerItem2.getMessageId());
                    intent.putExtra("chat_title", tdClient$ExplorerItem2.getTitle());
                    intent.putExtra("parent_title", mediaExplorerActivity.Q);
                    mediaExplorerActivity.startActivity(intent);
                } else if (tdClient$ExplorerItem2.getActions().size() > 1) {
                    List<TdClient$ExplorerAction> actions = tdClient$ExplorerItem2.getActions();
                    ArrayList arrayList = new ArrayList(o7.j.E0(actions));
                    Iterator<T> it = actions.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((TdClient$ExplorerAction) it.next()).getLabel());
                    }
                    String[] strArr = (String[]) arrayList.toArray(new String[0]);
                    k5.b m9 = new k5.b(mediaExplorerActivity, 0).m(tdClient$ExplorerItem2.getTitle());
                    m9.i(strArr, new t0(mediaExplorerActivity, tdClient$ExplorerItem2, 3));
                    g.k create = m9.create();
                    create.setOnShowListener(new f1(create, 2));
                    create.show();
                } else if (tdClient$ExplorerItem2.getActions().size() == 1) {
                    mediaExplorerActivity.t((TdClient$ExplorerAction) o7.h.H0(tdClient$ExplorerItem2.getActions()), tdClient$ExplorerItem2.getTitle(), tdClient$ExplorerItem2.getDescription());
                } else {
                    Toast.makeText(mediaExplorerActivity, "Sin acciones disponibles for este item", 0).show();
                }
                return n7.g.f7490c;
            case 2:
                TdClient$ExplorerItem tdClient$ExplorerItem3 = (TdClient$ExplorerItem) obj;
                int i12 = MediaExplorerActivity.Y;
                tdClient$ExplorerItem3.getClass();
                if (tdClient$ExplorerItem3.getType() == TdClient$ExplorerType.VIDEO || tdClient$ExplorerItem3.getType() == TdClient$ExplorerType.AUDIO) {
                    mediaExplorerActivity.A(tdClient$ExplorerItem3);
                } else {
                    Toast.makeText(mediaExplorerActivity, "Solo se pueden añadir Video o Audio a las listas", 0).show();
                }
                return n7.g.f7490c;
            default:
                mediaExplorerActivity.P = ((Boolean) obj).booleanValue();
                mediaExplorerActivity.runOnUiThread(new j2(mediaExplorerActivity, 5));
                break;
        }
        return n7.g.f7490c;
    }
}
