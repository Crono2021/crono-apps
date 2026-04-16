package i7;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;
import com.network.tvgramplayer.ui.MediaExplorerActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class j2 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4931i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ MediaExplorerActivity f4932j;

    public /* synthetic */ j2(MediaExplorerActivity mediaExplorerActivity, int i9) {
        this.f4931i = i9;
        this.f4932j = mediaExplorerActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View q4;
        View q7;
        switch (this.f4931i) {
            case 0:
                MediaExplorerActivity mediaExplorerActivity = this.f4932j;
                c7.b bVar = mediaExplorerActivity.E;
                if (bVar == null) {
                    b8.i.d("binding");
                    throw null;
                }
                if (((RecyclerView) bVar.f1655j).hasFocus()) {
                    return;
                }
                c7.b bVar2 = mediaExplorerActivity.E;
                if (bVar2 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                if (((EditText) bVar2.f1653g).hasFocus()) {
                    return;
                }
                mediaExplorerActivity.v();
                return;
            case 1:
                MediaExplorerActivity mediaExplorerActivity2 = this.f4932j;
                c7.b bVar3 = mediaExplorerActivity2.E;
                if (bVar3 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                o3.o0 layoutManager = ((RecyclerView) bVar3.f1654i).getLayoutManager();
                if (layoutManager != null && (q4 = layoutManager.q(0)) != null) {
                    q4.requestFocus();
                    return;
                }
                c7.b bVar4 = mediaExplorerActivity2.E;
                if (bVar4 != null) {
                    ((RecyclerView) bVar4.f1654i).requestFocus();
                    return;
                } else {
                    b8.i.d("binding");
                    throw null;
                }
            case 2:
                MediaExplorerActivity mediaExplorerActivity3 = this.f4932j;
                c7.b bVar5 = mediaExplorerActivity3.E;
                if (bVar5 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                o3.o0 layoutManager2 = ((RecyclerView) bVar5.f1654i).getLayoutManager();
                if (layoutManager2 != null && (q7 = layoutManager2.q(0)) != null) {
                    q7.requestFocus();
                    return;
                }
                c7.b bVar6 = mediaExplorerActivity3.E;
                if (bVar6 != null) {
                    ((RecyclerView) bVar6.f1654i).requestFocus();
                    return;
                } else {
                    b8.i.d("binding");
                    throw null;
                }
            case 3:
                MediaExplorerActivity mediaExplorerActivity4 = this.f4932j;
                c7.b bVar7 = mediaExplorerActivity4.E;
                if (bVar7 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                View findViewById = ((MaterialToolbar) bVar7.f1657l).findViewById(2131361857);
                if (findViewById != null) {
                    findViewById.setBackgroundResource(2131230852);
                }
                if (findViewById != null) {
                    findViewById.setFocusable(true);
                }
                c7.b bVar8 = mediaExplorerActivity4.E;
                if (bVar8 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((TextView) bVar8.f1649c).setNextFocusRightId(2131361857);
                if (findViewById != null) {
                    findViewById.setNextFocusLeftId(2131362462);
                }
                if (findViewById != null) {
                    findViewById.setNextFocusDownId(2131362313);
                    return;
                }
                return;
            case 4:
                MediaExplorerActivity mediaExplorerActivity5 = this.f4932j;
                MediaExplorerActivity.s(mediaExplorerActivity5);
                mediaExplorerActivity5.w(true);
                return;
            default:
                MediaExplorerActivity mediaExplorerActivity6 = this.f4932j;
                MediaExplorerActivity.s(mediaExplorerActivity6);
                mediaExplorerActivity6.w(true);
                return;
        }
    }
}
