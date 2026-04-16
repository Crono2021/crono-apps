package i7;

import com.network.tvgramplayer.ui.MediaExplorerActivity;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class h2 implements a8.l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4882i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ MediaExplorerActivity f4883j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ boolean f4884k;

    public /* synthetic */ h2(MediaExplorerActivity mediaExplorerActivity, boolean z8, int i9) {
        this.f4882i = i9;
        this.f4883j = mediaExplorerActivity;
        this.f4884k = z8;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        int i9 = this.f4882i;
        boolean z8 = this.f4884k;
        MediaExplorerActivity mediaExplorerActivity = this.f4883j;
        List list = (List) obj;
        switch (i9) {
            case 0:
                int i10 = MediaExplorerActivity.Y;
                list.getClass();
                mediaExplorerActivity.runOnUiThread(new i2(mediaExplorerActivity, list, z8, 0));
                break;
            default:
                int i11 = MediaExplorerActivity.Y;
                list.getClass();
                mediaExplorerActivity.runOnUiThread(new i2(mediaExplorerActivity, list, z8, 1));
                break;
        }
        return n7.g.f7490c;
    }
}
