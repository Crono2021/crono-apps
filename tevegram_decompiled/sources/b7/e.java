package b7;

import a0.l;
import a8.p;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.network.tvgramplayer.data.HistoryItem;
import d1.t0;
import i8.u;
import java.util.ArrayList;
import java.util.List;
import m7.k;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends t7.h implements p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f1491m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f1492n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Object obj, r7.c cVar, int i9) {
        super(2, cVar);
        this.f1491m = i9;
        this.f1492n = obj;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        u uVar = (u) obj;
        r7.c cVar = (r7.c) obj2;
        switch (this.f1491m) {
            case 0:
                return ((e) j(uVar, cVar)).k(n7.g.f7490c);
            case 1:
                return ((e) j(uVar, cVar)).k(n7.g.f7490c);
            default:
                e eVar = (e) j(uVar, cVar);
                n7.g gVar = n7.g.f7490c;
                eVar.k(gVar);
                return gVar;
        }
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        switch (this.f1491m) {
            case 0:
                return new e((l) this.f1492n, cVar, 0);
            case 1:
                return new e((t0) this.f1492n, cVar, 1);
            default:
                return new e((k) this.f1492n, cVar, 2);
        }
    }

    @Override // t7.a
    public final Object k(Object obj) {
        int i9 = this.f1491m;
        Object obj2 = this.f1492n;
        switch (i9) {
            case 0:
                l lVar = (l) obj2;
                o7.p pVar = o7.p.f8013i;
                com.bumptech.glide.c.V(obj);
                try {
                    String string = ((SharedPreferences) lVar.f31j).getString("items", null);
                    if (string == null) {
                        return pVar;
                    }
                    int i10 = 1;
                    int i11 = 0;
                    List list = (List) ((Gson) lVar.f32k).fromJson(string, TypeToken.getParameterized(List.class, HistoryItem.class).getType());
                    if (list == null) {
                        return pVar;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Object obj3 : list) {
                        if (((HistoryItem) obj3).getUrl() != null) {
                            arrayList.add(obj3);
                        }
                    }
                    return o7.h.O0(arrayList, new d(new a0.k(i10), i11));
                } catch (Exception e9) {
                    e9.printStackTrace();
                    return pVar;
                }
            case 1:
                com.bumptech.glide.c.V(obj);
                return new Integer(((t0) obj2).t());
            default:
                com.bumptech.glide.c.V(obj);
                k kVar = (k) obj2;
                Log.i("TelegramNTgCallsManager", "🎬 STARTING HLS PLAYER (Buffered " + kVar.G.get() + ")");
                androidx.activity.d dVar = kVar.f6748w;
                if (dVar != null) {
                    dVar.d();
                }
                return n7.g.f7490c;
        }
    }
}
