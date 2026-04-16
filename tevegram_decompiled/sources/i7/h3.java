package i7;

import android.util.Log;
import com.network.tvgramplayer.player.PlayerManager;
import com.network.tvgramplayer.ui.PlayerActivity;
import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h3 extends t7.h implements a8.p {

    /* renamed from: m, reason: collision with root package name */
    public int f4885m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ b8.o f4886n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ b8.o f4887o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f4888p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h3(b8.o oVar, b8.o oVar2, PlayerActivity playerActivity, r7.c cVar) {
        super(2, cVar);
        this.f4886n = oVar;
        this.f4887o = oVar2;
        this.f4888p = playerActivity;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        return ((h3) j((i8.u) obj, (r7.c) obj2)).k(n7.g.f7490c);
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        return new h3(this.f4886n, this.f4887o, this.f4888p, cVar);
    }

    @Override // t7.a
    public final Object k(Object obj) {
        Object obj2;
        Object obj3;
        int i9 = this.f4885m;
        if (i9 == 0) {
            com.bumptech.glide.c.V(obj);
            this.f4885m = 1;
            Object d9 = i8.w.d(1500L, this);
            s7.a aVar = s7.a.f8891i;
            if (d9 == aVar) {
                return aVar;
            }
        } else {
            if (i9 != 1) {
                m7.c.p("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            com.bumptech.glide.c.V(obj);
        }
        String str = (String) this.f4886n.f1525i;
        PlayerActivity playerActivity = this.f4888p;
        if (str != null) {
            PlayerManager playerManager = playerActivity.F;
            if (playerManager == null) {
                b8.i.d("playerManager");
                throw null;
            }
            Iterator<T> it = playerManager.getSubtitleTracks().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj3 = null;
                    break;
                }
                obj3 = it.next();
                if (b8.i.a(((PlayerManager.SubtitleTrack) obj3).getId(), str)) {
                    break;
                }
            }
            PlayerManager.SubtitleTrack subtitleTrack = (PlayerManager.SubtitleTrack) obj3;
            if (subtitleTrack != null) {
                PlayerManager playerManager2 = playerActivity.F;
                if (playerManager2 == null) {
                    b8.i.d("playerManager");
                    throw null;
                }
                playerManager2.selectSubtitleTrack(subtitleTrack);
                Log.i("PlayerActivity", "Restored subtitle track: " + subtitleTrack.getLabel());
            }
        }
        String str2 = (String) this.f4887o.f1525i;
        if (str2 != null) {
            PlayerManager playerManager3 = playerActivity.F;
            if (playerManager3 == null) {
                b8.i.d("playerManager");
                throw null;
            }
            Iterator<T> it2 = playerManager3.getAudioTracks().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it2.next();
                if (b8.i.a(((PlayerManager.AudioTrack) obj2).getId(), str2)) {
                    break;
                }
            }
            PlayerManager.AudioTrack audioTrack = (PlayerManager.AudioTrack) obj2;
            if (audioTrack != null) {
                PlayerManager playerManager4 = playerActivity.F;
                if (playerManager4 == null) {
                    b8.i.d("playerManager");
                    throw null;
                }
                playerManager4.selectAudioTrack(audioTrack);
                Log.i("PlayerActivity", "Restored audio track: " + audioTrack.getLabel());
            }
        }
        return n7.g.f7490c;
    }
}
