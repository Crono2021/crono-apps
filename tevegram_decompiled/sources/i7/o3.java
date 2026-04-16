package i7;

import android.R;
import com.network.tvgramplayer.data.HistoryItem;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.data.PlaylistItem;
import com.network.tvgramplayer.ui.PlayerActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o3 extends t7.h implements a8.p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f5009m = 1;

    /* renamed from: n, reason: collision with root package name */
    public int f5010n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f5011o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ e7.a f5012p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o3(PlayerActivity playerActivity, e7.a aVar, r7.c cVar) {
        super(2, cVar);
        this.f5011o = playerActivity;
        this.f5012p = aVar;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        i8.u uVar = (i8.u) obj;
        r7.c cVar = (r7.c) obj2;
        switch (this.f5009m) {
        }
        return ((o3) j(uVar, cVar)).k(n7.g.f7490c);
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        switch (this.f5009m) {
            case 0:
                return new o3(this.f5012p, this.f5011o, cVar);
            default:
                return new o3(this.f5011o, this.f5012p, cVar);
        }
    }

    @Override // t7.a
    public final Object k(Object obj) {
        Object obj2;
        boolean z8;
        List<PlaylistItem> items;
        switch (this.f5009m) {
            case 0:
                int i9 = this.f5010n;
                PlayerActivity playerActivity = this.f5011o;
                e7.a aVar = this.f5012p;
                Object obj3 = null;
                boolean z9 = false;
                if (i9 == 0) {
                    com.bumptech.glide.c.V(obj);
                    if (aVar.h != 0) {
                        a0.l lVar = playerActivity.K;
                        if (lVar == null) {
                            b8.i.d("historyManager");
                            throw null;
                        }
                        this.f5010n = 1;
                        obj = lVar.i(this);
                        s7.a aVar2 = s7.a.f8891i;
                        if (obj == aVar2) {
                            return aVar2;
                        }
                    }
                    return Boolean.valueOf(z9);
                }
                if (i9 != 1) {
                    m7.c.p("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                com.bumptech.glide.c.V(obj);
                Iterator it = ((List) obj).iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj2 = it.next();
                        if (((HistoryItem) obj2).getChatId() == aVar.h) {
                        }
                    } else {
                        obj2 = null;
                    }
                }
                HistoryItem historyItem = (HistoryItem) obj2;
                boolean z10 = historyItem != null && historyItem.isFavorite();
                a0.l lVar2 = playerActivity.L;
                if (lVar2 == null) {
                    b8.i.d("playlistManager");
                    throw null;
                }
                Iterator it2 = o7.h.Q0((ArrayList) lVar2.f32k).iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Object next = it2.next();
                        if (b8.i.a(((Playlist) next).getName(), "Favoritos")) {
                            obj3 = next;
                        }
                    }
                }
                Playlist playlist = (Playlist) obj3;
                if (playlist != null && (items = playlist.getItems()) != null && !items.isEmpty()) {
                    Iterator<T> it3 = items.iterator();
                    while (it3.hasNext()) {
                        if (((PlaylistItem) it3.next()).getChatId() == aVar.h) {
                            z8 = true;
                            if (!z10 || z8) {
                                z9 = true;
                            }
                            return Boolean.valueOf(z9);
                        }
                    }
                }
                z8 = false;
                if (!z10) {
                }
                z9 = true;
                return Boolean.valueOf(z9);
            default:
                int i10 = this.f5010n;
                PlayerActivity playerActivity2 = this.f5011o;
                if (i10 == 0) {
                    com.bumptech.glide.c.V(obj);
                    p8.c cVar = i8.c0.f5251b;
                    o3 o3Var = new o3(this.f5012p, playerActivity2, (r7.c) null);
                    this.f5010n = 1;
                    obj = i8.w.q(cVar, o3Var, this);
                    s7.a aVar3 = s7.a.f8891i;
                    if (obj == aVar3) {
                        return aVar3;
                    }
                } else {
                    if (i10 != 1) {
                        m7.c.p("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    com.bumptech.glide.c.V(obj);
                }
                boolean booleanValue = ((Boolean) obj).booleanValue();
                c7.e eVar = playerActivity2.E;
                if (eVar != null) {
                    eVar.f1698c.setImageResource(booleanValue ? R.drawable.btn_star_big_on : R.drawable.btn_star_big_off);
                    return n7.g.f7490c;
                }
                b8.i.d("binding");
                throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o3(e7.a aVar, PlayerActivity playerActivity, r7.c cVar) {
        super(2, cVar);
        this.f5012p = aVar;
        this.f5011o = playerActivity;
    }
}
