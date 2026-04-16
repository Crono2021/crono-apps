package androidx.activity;

import android.app.Application;
import android.util.Log;
import b2.f0;
import com.network.tvgramplayer.TvgramApplication;
import com.network.tvgramplayer.ui.DiscoveryActivity;
import com.network.tvgramplayer.ui.ImageViewerActivity;
import com.network.tvgramplayer.ui.LiveStreamActivity;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import i7.y;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class d implements a8.a {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f283i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f284j;

    public /* synthetic */ d(Object obj, int i9) {
        this.f283i = i9;
        this.f284j = obj;
    }

    @Override // a8.a
    public final Object d() {
        ServerSocket serverSocket;
        Socket accept;
        int i9 = this.f283i;
        Object obj = this.f284j;
        switch (i9) {
            case 0:
                ((g.l) obj).reportFullyDrawn();
                return null;
            case 1:
                g7.e eVar = (g7.e) obj;
                AtomicBoolean atomicBoolean = eVar.f3834d;
                while (atomicBoolean.get()) {
                    try {
                        serverSocket = eVar.f3833c;
                    } catch (Exception e9) {
                        if (atomicBoolean.get()) {
                            Log.e(eVar.f3835e, "Accept error", e9);
                        }
                    }
                    if (serverSocket != null && (accept = serverSocket.accept()) != null) {
                        eVar.f3843n.execute(new f0(eVar, 8, accept));
                    }
                    return n7.g.f7490c;
                    break;
                }
                return n7.g.f7490c;
            case 2:
                int i10 = DiscoveryActivity.J;
                Application application = ((DiscoveryActivity) obj).getApplication();
                application.getClass();
                return ((TvgramApplication) application).a();
            case 3:
                int i11 = ImageViewerActivity.I;
                Application application2 = ((ImageViewerActivity) obj).getApplication();
                application2.getClass();
                return ((TvgramApplication) application2).a();
            case 4:
                LiveStreamActivity liveStreamActivity = (LiveStreamActivity) obj;
                int i12 = LiveStreamActivity.f2332a0;
                liveStreamActivity.runOnUiThread(new y(liveStreamActivity, 0));
                return n7.g.f7490c;
            default:
                int i13 = MediaExplorerActivity.Y;
                Application application3 = ((MediaExplorerActivity) obj).getApplication();
                application3.getClass();
                return ((TvgramApplication) application3).a();
        }
    }
}
