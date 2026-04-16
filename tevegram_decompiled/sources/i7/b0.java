package i7;

import android.util.Log;
import com.network.tvgramplayer.ui.LiveStreamActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class b0 implements a8.l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4774i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ LiveStreamActivity f4775j;

    public /* synthetic */ b0(LiveStreamActivity liveStreamActivity, int i9) {
        this.f4774i = i9;
        this.f4775j = liveStreamActivity;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        switch (this.f4774i) {
            case 0:
                LiveStreamActivity liveStreamActivity = this.f4775j;
                String str = (String) obj;
                int i9 = LiveStreamActivity.f2332a0;
                str.getClass();
                synchronized (liveStreamActivity.R) {
                    liveStreamActivity.R.append("\n".concat(str));
                    if (!liveStreamActivity.T) {
                        liveStreamActivity.T = true;
                        liveStreamActivity.S.postDelayed(new y(liveStreamActivity, 1), 1000L);
                    }
                    break;
                }
            default:
                LiveStreamActivity liveStreamActivity2 = this.f4775j;
                String str2 = (String) obj;
                int i10 = LiveStreamActivity.f2332a0;
                str2.getClass();
                Log.w("LiveStreamActivity", "🔄 [RESYNC TRIGGERED] Reason: ".concat(str2));
                liveStreamActivity2.runOnUiThread(new y(liveStreamActivity2, 2));
                break;
        }
        return n7.g.f7490c;
    }
}
