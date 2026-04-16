package m7;

import a8.l;
import android.content.Context;
import android.util.Log;
import com.network.tvgramplayer.TvgramApplication;
import com.network.tvgramplayer.voip.NativeInstance;
import h7.k0;
import h7.m;
import i7.k1;
import i8.w;
import java.util.concurrent.ConcurrentHashMap;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class b implements NativeInstance.RequestBroadcastPartCallback, NativeInstance.RequestCurrentTimeCallback {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ k f6692i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6693j;

    public /* synthetic */ b(k kVar, int i9) {
        this.f6692i = kVar;
        this.f6693j = i9;
    }

    @Override // com.network.tvgramplayer.voip.NativeInstance.RequestBroadcastPartCallback
    public void run(long j5, long j9, int i9, int i10) {
        int i11;
        k kVar = this.f6692i;
        ConcurrentHashMap concurrentHashMap = kVar.f6736k;
        Integer num = (Integer) concurrentHashMap.get(i9 + "_" + i10);
        if (num == null) {
            num = (Integer) concurrentHashMap.get(i9 + "_0");
            if (num == null) {
                i11 = j9 <= 500 ? 1 : 0;
                f fVar = new f(j5, j9, i9, i10, this.f6693j, i11, System.currentTimeMillis());
                Context applicationContext = kVar.f6727a.getApplicationContext();
                applicationContext.getClass();
                w.j(kVar.f6751z, null, new k1(kVar, fVar, (TvgramApplication) applicationContext, null), 3);
            }
        }
        i11 = num.intValue();
        f fVar2 = new f(j5, j9, i9, i10, this.f6693j, i11, System.currentTimeMillis());
        Context applicationContext2 = kVar.f6727a.getApplicationContext();
        applicationContext2.getClass();
        w.j(kVar.f6751z, null, new k1(kVar, fVar2, (TvgramApplication) applicationContext2, null), 3);
    }

    @Override // com.network.tvgramplayer.voip.NativeInstance.RequestCurrentTimeCallback
    public void run(final long j5) {
        final k kVar = this.f6692i;
        Long l4 = kVar.h;
        if (l4 != null) {
            long currentTimeMillis = (System.currentTimeMillis() - kVar.f6734i.get()) + l4.longValue();
            NativeInstance nativeInstance = kVar.f6730d;
            if (nativeInstance != null) {
                nativeInstance.onRequestTimeComplete(j5, currentTimeMillis);
                return;
            }
            return;
        }
        Context applicationContext = kVar.f6727a.getApplicationContext();
        applicationContext.getClass();
        final TvgramApplication tvgramApplication = (TvgramApplication) applicationContext;
        tvgramApplication.a().l(this.f6693j, new l() { // from class: m7.d
            @Override // a8.l
            public final Object a(Object obj) {
                TdApi.VideoChatStreams videoChatStreams = (TdApi.VideoChatStreams) obj;
                k kVar2 = k.this;
                long j9 = j5;
                if (videoChatStreams != null) {
                    TdApi.VideoChatStream[] videoChatStreamArr = videoChatStreams.streams;
                    videoChatStreamArr.getClass();
                    if (videoChatStreamArr.length != 0) {
                        long j10 = videoChatStreams.streams[0].timeOffset;
                        Log.i("TelegramNTgCallsManager", "⏱️ Synced with Server Stream Time (via VideoChatStreams): " + j10);
                        kVar2.h = Long.valueOf(j10);
                        kVar2.f6737l.set(j10);
                        kVar2.f6734i.set(System.currentTimeMillis());
                        NativeInstance nativeInstance2 = kVar2.f6730d;
                        if (nativeInstance2 != null) {
                            nativeInstance2.onRequestTimeComplete(j9, j10);
                        }
                        return n7.g.f7490c;
                    }
                }
                k0 a9 = tvgramApplication.a();
                m mVar = new m(1, j9, kVar2);
                Client client = a9.f4141l;
                if (client != null) {
                    client.send(new TdApi.GetOption("unix_time"), new a3.i(mVar, 5));
                }
                return n7.g.f7490c;
            }
        });
    }
}
