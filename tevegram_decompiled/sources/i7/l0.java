package i7;

import android.view.KeyEvent;
import android.widget.TextView;
import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class l0 implements TextView.OnEditorActionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4952a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g.l f4953b;

    public /* synthetic */ l0(g.l lVar, int i9) {
        this.f4952a = i9;
        this.f4953b = lVar;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i9, KeyEvent keyEvent) {
        int i10 = this.f4952a;
        g.l lVar = this.f4953b;
        switch (i10) {
            case 0:
                MainActivity mainActivity = (MainActivity) lVar;
                if (i9 != 2) {
                    int i11 = MainActivity.X;
                    return false;
                }
                c7.d dVar = mainActivity.E;
                if (dVar != null) {
                    dVar.f1681l.performClick();
                    return true;
                }
                b8.i.d("binding");
                throw null;
            default:
                MediaExplorerActivity mediaExplorerActivity = (MediaExplorerActivity) lVar;
                int i12 = MediaExplorerActivity.Y;
                if (i9 != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 0)) {
                    return false;
                }
                String obj = h8.e.u0(textView.getText().toString()).toString();
                if (!b8.i.a(obj, mediaExplorerActivity.U)) {
                    mediaExplorerActivity.U = obj;
                    if (obj.length() > 0) {
                        a5.d dVar2 = mediaExplorerActivity.I;
                        if (dVar2 == null) {
                            b8.i.d("searchHistoryManager");
                            throw null;
                        }
                        long j5 = mediaExplorerActivity.K;
                        long j9 = mediaExplorerActivity.L;
                        if (!h8.e.l0(obj)) {
                            ArrayList arrayList = new ArrayList(dVar2.K0(j5, j9));
                            arrayList.remove(obj);
                            arrayList.add(0, obj);
                            dVar2.W0(j5, j9, o7.h.P0(10, arrayList));
                        }
                    }
                    mediaExplorerActivity.v();
                    mediaExplorerActivity.w(true);
                }
                return true;
        }
    }
}
