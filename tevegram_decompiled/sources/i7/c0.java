package i7;

import com.network.tvgramplayer.player.RawPlayerJNI;
import com.network.tvgramplayer.ui.LiveStreamActivity;
import java.io.Serializable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class c0 implements a8.q {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ b8.l f4799i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ LiveStreamActivity f4800j;

    public /* synthetic */ c0(b8.l lVar, LiveStreamActivity liveStreamActivity) {
        this.f4799i = lVar;
        this.f4800j = liveStreamActivity;
    }

    @Override // a8.q
    public final Object c(Object obj, Object obj2, Serializable serializable) {
        b8.l lVar = this.f4799i;
        LiveStreamActivity liveStreamActivity = this.f4800j;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        byte[] bArr = (byte[]) obj2;
        long longValue = ((Long) serializable).longValue();
        int i9 = LiveStreamActivity.f2332a0;
        bArr.getClass();
        if (booleanValue && !lVar.f1522i) {
            lVar.f1522i = true;
            liveStreamActivity.runOnUiThread(new y(liveStreamActivity, 3));
        }
        if (liveStreamActivity.J) {
            g7.e eVar = liveStreamActivity.L;
            if (eVar != null) {
                eVar.a(booleanValue ? 1 : 0, longValue, bArr);
            }
        } else {
            synchronized (liveStreamActivity.V) {
                try {
                    long j5 = liveStreamActivity.G;
                    if (j5 != 0) {
                        if (liveStreamActivity.I) {
                            RawPlayerJNI.INSTANCE.nativeFeedDataPull(j5, booleanValue, bArr, longValue);
                        } else {
                            RawPlayerJNI.INSTANCE.nativeFeedData(j5, booleanValue, bArr, longValue);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return n7.g.f7490c;
    }
}
