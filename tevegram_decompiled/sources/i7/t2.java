package i7;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;
import com.network.tvgramplayer.data.SearchHistoryManager$QuickSearchItem;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import java.util.List;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t2 extends o3.g0 {

    /* renamed from: d, reason: collision with root package name */
    public List f5127d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ MediaExplorerActivity f5128e;

    public t2(MediaExplorerActivity mediaExplorerActivity, List list) {
        this.f5128e = mediaExplorerActivity;
        this.f5127d = list;
    }

    @Override // o3.g0
    public final int a() {
        return this.f5127d.size();
    }

    @Override // o3.g0
    public final void d(o3.d1 d1Var, final int i9) {
        final boolean z8;
        s2 s2Var = (s2) d1Var;
        ImageButton imageButton = s2Var.f5116x;
        final String str = (String) this.f5127d.get(i9);
        s2Var.f5114v.setText(str);
        final MediaExplorerActivity mediaExplorerActivity = this.f5128e;
        TdApi.SearchMessagesFilter searchMessagesFilter = mediaExplorerActivity.V;
        final String str2 = searchMessagesFilter instanceof TdApi.SearchMessagesFilterVideo ? "video" : searchMessagesFilter instanceof TdApi.SearchMessagesFilterDocument ? "document" : null;
        a5.d dVar = mediaExplorerActivity.I;
        if (dVar == null) {
            b8.i.d("searchHistoryManager");
            throw null;
        }
        long j5 = mediaExplorerActivity.K;
        long j9 = mediaExplorerActivity.L;
        str.getClass();
        List<SearchHistoryManager$QuickSearchItem> I0 = dVar.I0();
        if (!I0.isEmpty()) {
            for (SearchHistoryManager$QuickSearchItem searchHistoryManager$QuickSearchItem : I0) {
                if (b8.i.a(searchHistoryManager$QuickSearchItem.getQuery(), str) && searchHistoryManager$QuickSearchItem.getChatId() == j5 && searchHistoryManager$QuickSearchItem.getThreadId() == j9 && b8.i.a(searchHistoryManager$QuickSearchItem.getFilterType(), str2)) {
                    z8 = true;
                    break;
                }
            }
        }
        z8 = false;
        imageButton.setImageResource(z8 ? 2131230973 : 2131230974);
        s2Var.f5113u.setOnClickListener(new b(mediaExplorerActivity, 7, str));
        s2Var.f5115w.setOnClickListener(new u(mediaExplorerActivity, str, this, 2));
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: i7.r2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaExplorerActivity mediaExplorerActivity2 = MediaExplorerActivity.this;
                String str3 = mediaExplorerActivity2.R;
                String str4 = mediaExplorerActivity2.Q;
                if (str3 != null) {
                    str4 = str3 + " > " + str4;
                }
                SearchHistoryManager$QuickSearchItem searchHistoryManager$QuickSearchItem2 = new SearchHistoryManager$QuickSearchItem(str, mediaExplorerActivity2.K, mediaExplorerActivity2.L, str2, str4);
                a5.d dVar2 = mediaExplorerActivity2.I;
                if (dVar2 == null) {
                    b8.i.d("searchHistoryManager");
                    throw null;
                }
                dVar2.X0(searchHistoryManager$QuickSearchItem2);
                this.f7659a.d(i9, 1, null);
                Toast.makeText(mediaExplorerActivity2, !z8 ? "Añadido a favoritos" : "Quitado de favoritos", 0).show();
            }
        });
    }

    @Override // o3.g0
    public final o3.d1 e(ViewGroup viewGroup) {
        View inflate = this.f5128e.getLayoutInflater().inflate(2131558481, viewGroup, false);
        inflate.getClass();
        return new s2(inflate);
    }
}
