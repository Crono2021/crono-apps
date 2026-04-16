package i7;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.Button;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.recyclerview.widget.RecyclerView;
import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.ui.MediaExplorerActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class f1 implements DialogInterface.OnShowListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4845a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f4846b;

    public /* synthetic */ f1(KeyEvent.Callback callback, int i9) {
        this.f4845a = i9;
        this.f4846b = callback;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        int i9 = this.f4845a;
        KeyEvent.Callback callback = this.f4846b;
        switch (i9) {
            case 0:
                int i10 = MainActivity.X;
                AlertController$RecycleListView alertController$RecycleListView = ((g.k) callback).f3576n.f3544f;
                if (alertController$RecycleListView != null) {
                    alertController$RecycleListView.requestFocus();
                    break;
                }
                break;
            case 1:
                Button button = ((g.k) callback).f3576n.f3546i;
                if (button != null) {
                    button.requestFocus();
                    break;
                }
                break;
            case 2:
                int i11 = MediaExplorerActivity.Y;
                AlertController$RecycleListView alertController$RecycleListView2 = ((g.k) callback).f3576n.f3544f;
                if (alertController$RecycleListView2 != null) {
                    alertController$RecycleListView2.requestFocus();
                    break;
                }
                break;
            default:
                int i12 = MainActivity.X;
                ((RecyclerView) callback).requestFocus();
                break;
        }
    }
}
