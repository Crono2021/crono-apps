package h7;

import android.util.Log;
import com.network.tvgramplayer.ui.LiveStreamActivity;
import com.network.tvgramplayer.voip.NativeInstance;
import d1.q0;
import d1.r0;
import java.util.concurrent.CopyOnWriteArrayList;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.webrtc.PeerConnectionFactory;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class o implements Client.ResultHandler, IMediaPlayer.OnErrorListener, a6.c, g1.j, g1.k, NativeInstance.AudioLevelsCallback, NativeInstance.VideoSourcesCallback, NativeInstance.RequestBroadcastPartCallback {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4168i;

    public /* synthetic */ o(int i9, long j5, m1.a aVar) {
        this.f4168i = 15;
    }

    public static /* synthetic */ void c(Object obj, String str) {
        throw new IllegalStateException((str + obj).toString());
    }

    public static /* synthetic */ void d(String str, int i9, Object obj) {
        throw new IllegalArgumentException((str + i9 + obj).toString());
    }

    @Override // g1.j
    public void a(Object obj) {
        switch (this.f4168i) {
            case 6:
                ((r0) obj).f(new l1.l(2, new androidx.fragment.app.r("Player release timed out."), 1003));
                break;
            case 7:
            case 14:
            default:
                ((m1.c) obj).getClass();
                break;
            case 8:
                ((r0) obj).i();
                break;
            case 9:
                ((m1.c) obj).getClass();
                break;
            case 10:
                ((m1.c) obj).getClass();
                break;
            case 11:
                ((m1.c) obj).getClass();
                break;
            case 12:
                ((m1.c) obj).getClass();
                break;
            case 13:
                ((m1.c) obj).getClass();
                break;
            case 15:
                ((m1.c) obj).getClass();
                break;
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                ((m1.c) obj).getClass();
                break;
            case 17:
                ((m1.c) obj).getClass();
                break;
            case 18:
                ((m1.c) obj).getClass();
                break;
            case 19:
                ((m1.c) obj).getClass();
                break;
            case 20:
                ((m1.c) obj).getClass();
                break;
            case 21:
                ((m1.c) obj).getClass();
                break;
            case 22:
                ((m1.c) obj).getClass();
                break;
            case 23:
                ((m1.c) obj).getClass();
                break;
            case 24:
                ((m1.c) obj).getClass();
                break;
            case 25:
                ((m1.c) obj).getClass();
                break;
        }
    }

    @Override // a6.c
    public Object apply(Object obj) {
        return new m1.q((g1.r) obj);
    }

    @Override // g1.k
    public void b(Object obj, d1.q qVar) {
        switch (this.f4168i) {
            case 7:
                ((r0) obj).D(new q0(qVar));
                break;
            default:
                break;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
    public boolean onError(IMediaPlayer iMediaPlayer, int i9, int i10) {
        int i11 = LiveStreamActivity.f2332a0;
        Log.e("LiveStreamActivity", "❌ IJK Error: what=" + i9 + ", extra=" + i10);
        return true;
    }

    @Override // org.drinkless.tdlib.Client.ResultHandler
    public void onResult(TdApi.Object object) {
        switch (this.f4168i) {
            case 0:
                if (!(object instanceof TdApi.Ok)) {
                    k0.r("⚠️ Storage optimizer error: " + object);
                    break;
                } else {
                    k0.r("✅ Storage optimizer configured");
                    break;
                }
            default:
                if (!(object instanceof TdApi.Error)) {
                    Log.i("TdClient", "✅ Scan initiated. Waiting for UpdateNewChat events.");
                    break;
                } else {
                    Log.e("TdClient", "❌ Error scanning chats: " + ((TdApi.Error) object).message);
                    break;
                }
        }
    }

    @Override // com.network.tvgramplayer.voip.NativeInstance.RequestBroadcastPartCallback
    public void run(long j5, long j9, int i9, int i10) {
        CopyOnWriteArrayList copyOnWriteArrayList = m7.k.M;
    }

    @Override // com.network.tvgramplayer.voip.NativeInstance.VideoSourcesCallback
    public void run(long j5, int[] iArr) {
        CopyOnWriteArrayList copyOnWriteArrayList = m7.k.M;
    }

    @Override // com.network.tvgramplayer.voip.NativeInstance.AudioLevelsCallback
    public void run(int[] iArr, float[] fArr, boolean[] zArr) {
        CopyOnWriteArrayList copyOnWriteArrayList = m7.k.M;
    }

    public /* synthetic */ o(int i9) {
        this.f4168i = i9;
    }

    public /* synthetic */ o(Object obj, int i9) {
        this.f4168i = i9;
    }

    public /* synthetic */ o(m1.a aVar, Object obj, int i9) {
        this.f4168i = i9;
    }

    public /* synthetic */ o(m1.a aVar, v1.q qVar, v1.v vVar, int i9) {
        this.f4168i = i9;
    }

    public /* synthetic */ o(m1.a aVar, boolean z8, int i9) {
        this.f4168i = 10;
    }
}
