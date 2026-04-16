package i7;

import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.network.tvgramplayer.telegram.TdClient$ExplorerItem;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import java.util.List;
import org.webrtc.EglRenderer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class i2 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4899i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f4900j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f4901k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f4902l;

    public /* synthetic */ i2(EglRenderer eglRenderer, boolean z8, Runnable runnable) {
        this.f4899i = 2;
        this.f4900j = eglRenderer;
        this.f4902l = z8;
        this.f4901k = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4899i) {
            case 0:
                MediaExplorerActivity mediaExplorerActivity = (MediaExplorerActivity) this.f4900j;
                List list = (List) this.f4901k;
                mediaExplorerActivity.N = false;
                c7.b bVar = mediaExplorerActivity.E;
                if (bVar == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((ProgressBar) bVar.h).setVisibility(8);
                c7.b bVar2 = mediaExplorerActivity.E;
                if (bVar2 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((SwipeRefreshLayout) bVar2.f1656k).setRefreshing(false);
                boolean isEmpty = list.isEmpty();
                boolean z8 = this.f4902l;
                if (isEmpty) {
                    mediaExplorerActivity.O = false;
                    if (z8) {
                        Toast.makeText(mediaExplorerActivity, "No se encontró contenido multimedia.", 0).show();
                        return;
                    }
                    return;
                }
                mediaExplorerActivity.M = ((TdClient$ExplorerItem) o7.h.K0(list)).getMessageId();
                j7.l lVar = mediaExplorerActivity.F;
                if (lVar == null) {
                    b8.i.d("adapter");
                    throw null;
                }
                lVar.f(list, !z8);
                if (z8) {
                    c7.b bVar3 = mediaExplorerActivity.E;
                    if (bVar3 == null) {
                        b8.i.d("binding");
                        throw null;
                    }
                    ((RecyclerView) bVar3.f1654i).post(new j2(mediaExplorerActivity, 2));
                }
                if (list.isEmpty()) {
                    mediaExplorerActivity.O = false;
                    return;
                }
                return;
            case 1:
                MediaExplorerActivity mediaExplorerActivity2 = (MediaExplorerActivity) this.f4900j;
                List list2 = (List) this.f4901k;
                mediaExplorerActivity2.N = false;
                c7.b bVar4 = mediaExplorerActivity2.E;
                if (bVar4 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((ProgressBar) bVar4.h).setVisibility(8);
                c7.b bVar5 = mediaExplorerActivity2.E;
                if (bVar5 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((SwipeRefreshLayout) bVar5.f1656k).setRefreshing(false);
                boolean isEmpty2 = list2.isEmpty();
                boolean z9 = this.f4902l;
                if (isEmpty2) {
                    mediaExplorerActivity2.O = false;
                    if (z9) {
                        mediaExplorerActivity2.P = false;
                        mediaExplorerActivity2.w(true);
                        return;
                    }
                    return;
                }
                mediaExplorerActivity2.S = ((TdClient$ExplorerItem) o7.h.K0(list2)).getDate();
                mediaExplorerActivity2.T = (int) (((TdClient$ExplorerItem) o7.h.K0(list2)).getMessageId() >> 20);
                j7.l lVar2 = mediaExplorerActivity2.F;
                if (lVar2 == null) {
                    b8.i.d("adapter");
                    throw null;
                }
                lVar2.f(list2, !z9);
                if (z9) {
                    c7.b bVar6 = mediaExplorerActivity2.E;
                    if (bVar6 == null) {
                        b8.i.d("binding");
                        throw null;
                    }
                    ((RecyclerView) bVar6.f1654i).post(new j2(mediaExplorerActivity2, 1));
                }
                if (list2.size() < 100) {
                    mediaExplorerActivity2.O = false;
                    return;
                }
                return;
            default:
                ((EglRenderer) this.f4900j).lambda$releaseEglSurface$5(this.f4902l, (Runnable) this.f4901k);
                return;
        }
    }

    public /* synthetic */ i2(MediaExplorerActivity mediaExplorerActivity, List list, boolean z8, int i9) {
        this.f4899i = i9;
        this.f4900j = mediaExplorerActivity;
        this.f4901k = list;
        this.f4902l = z8;
    }
}
