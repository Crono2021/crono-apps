package i7;

import com.network.tvgramplayer.player.PlayerManager;
import com.network.tvgramplayer.ui.PlayerActivity;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class e3 implements a8.l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ boolean f4834i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ e7.a f4835j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f4836k;

    public /* synthetic */ e3(boolean z8, e7.a aVar, PlayerActivity playerActivity) {
        this.f4834i = z8;
        this.f4835j = aVar;
        this.f4836k = playerActivity;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        long longValue = ((Long) obj).longValue();
        int i9 = PlayerActivity.X;
        boolean z8 = this.f4834i;
        e7.a aVar = this.f4835j;
        if (!z8 && longValue > 0) {
            aVar = e7.a.a(aVar, null, (int) (longValue / IjkMediaCodecInfo.RANK_MAX), null, 0L, 223);
        }
        PlayerActivity playerActivity = this.f4836k;
        PlayerManager playerManager = playerActivity.F;
        if (playerManager == null) {
            b8.i.d("playerManager");
            throw null;
        }
        playerManager.play(aVar);
        if (z8 && longValue > 0) {
            PlayerManager playerManager2 = playerActivity.F;
            if (playerManager2 == null) {
                b8.i.d("playerManager");
                throw null;
            }
            playerManager2.seekTo(longValue);
        }
        c7.e eVar = playerActivity.E;
        if (eVar == null) {
            b8.i.d("binding");
            throw null;
        }
        eVar.f1711q.post(playerActivity.V);
        playerActivity.y();
        c7.e eVar2 = playerActivity.E;
        if (eVar2 == null) {
            b8.i.d("binding");
            throw null;
        }
        d1.t0 player = eVar2.f1708n.getPlayer();
        if (player != null) {
            player.F();
        }
        c7.e eVar3 = playerActivity.E;
        if (eVar3 != null) {
            return Boolean.valueOf(eVar3.f1708n.requestFocus());
        }
        b8.i.d("binding");
        throw null;
    }
}
