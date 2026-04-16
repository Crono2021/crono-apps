package i7;

import android.content.DialogInterface;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import com.network.tvgramplayer.ui.PlayerActivity;
import com.network.tvgramplayer.ui.PlaylistsActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class q2 implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5053i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f5054j;

    public /* synthetic */ q2(Object obj, int i9) {
        this.f5053i = i9;
        this.f5054j = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i9) {
        int i10 = this.f5053i;
        Object obj = this.f5054j;
        switch (i10) {
            case 0:
                int i11 = MediaExplorerActivity.Y;
                ((m2) obj).d();
                break;
            case 1:
                int i12 = PlayerActivity.X;
                ((e3) obj).a(0L);
                break;
            case 2:
                int i13 = PlayerActivity.X;
                ((PlayerActivity) obj).finish();
                break;
            default:
                int i14 = PlaylistsActivity.K;
                ((s3) obj).d();
                break;
        }
    }
}
