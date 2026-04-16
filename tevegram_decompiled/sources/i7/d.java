package i7;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d extends o3.r0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4813a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4814b;

    public /* synthetic */ d(Object obj, int i9) {
        this.f4813a = i9;
        this.f4814b = obj;
    }

    @Override // o3.r0
    public final void b(RecyclerView recyclerView, int i9, int i10) {
        Client client;
        switch (this.f4813a) {
            case 0:
                o3.o0 layoutManager = recyclerView.getLayoutManager();
                layoutManager.getClass();
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                if (linearLayoutManager.z() <= linearLayoutManager.J0() + 40 && (client = ((h) this.f4814b).f4873b.f4141l) != null) {
                    client.send(new TdApi.LoadChats(new TdApi.ChatListMain(), 100), new androidx.fragment.app.a(29));
                    break;
                }
                break;
            case 1:
                o3.o0 layoutManager2 = recyclerView.getLayoutManager();
                layoutManager2.getClass();
                LinearLayoutManager linearLayoutManager2 = (LinearLayoutManager) layoutManager2;
                int z8 = linearLayoutManager2.z();
                int J0 = linearLayoutManager2.J0();
                MediaExplorerActivity mediaExplorerActivity = (MediaExplorerActivity) this.f4814b;
                boolean z9 = mediaExplorerActivity.N;
                if (z9 || !mediaExplorerActivity.O || !mediaExplorerActivity.P || mediaExplorerActivity.L != 0 || J0 < z8 - 5) {
                    if (!z9 && mediaExplorerActivity.O && !mediaExplorerActivity.P && mediaExplorerActivity.L == 0 && J0 >= z8 - 5) {
                        mediaExplorerActivity.w(false);
                        break;
                    } else if (!z9 && mediaExplorerActivity.O && mediaExplorerActivity.L != 0 && J0 >= z8 - 5) {
                        mediaExplorerActivity.w(false);
                        break;
                    }
                } else {
                    mediaExplorerActivity.x(false);
                    break;
                }
                break;
            default:
                o3.q qVar = (o3.q) this.f4814b;
                int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
                int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                int i11 = qVar.f7769a;
                int computeVerticalScrollRange = qVar.f7786s.computeVerticalScrollRange();
                int i12 = qVar.f7785r;
                qVar.f7787t = computeVerticalScrollRange - i12 > 0 && i12 >= i11;
                int computeHorizontalScrollRange = qVar.f7786s.computeHorizontalScrollRange();
                int i13 = qVar.f7784q;
                boolean z10 = computeHorizontalScrollRange - i13 > 0 && i13 >= i11;
                qVar.f7788u = z10;
                boolean z11 = qVar.f7787t;
                if (!z11 && !z10) {
                    if (qVar.f7789v != 0) {
                        qVar.f(0);
                        break;
                    }
                } else {
                    if (z11) {
                        float f9 = i12;
                        qVar.f7779l = (int) ((((f9 / 2.0f) + computeVerticalScrollOffset) * f9) / computeVerticalScrollRange);
                        qVar.f7778k = Math.min(i12, (i12 * i12) / computeVerticalScrollRange);
                    }
                    if (qVar.f7788u) {
                        float f10 = computeHorizontalScrollOffset;
                        float f11 = i13;
                        qVar.f7782o = (int) ((((f11 / 2.0f) + f10) * f11) / computeHorizontalScrollRange);
                        qVar.f7781n = Math.min(i13, (i13 * i13) / computeHorizontalScrollRange);
                    }
                    int i14 = qVar.f7789v;
                    if (i14 == 0 || i14 == 1) {
                        qVar.f(1);
                        break;
                    }
                }
                break;
        }
    }
}
