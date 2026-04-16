package b7;

import a0.l;
import a8.p;
import com.network.tvgramplayer.data.HistoryItem;
import i8.u;
import java.util.ArrayList;
import java.util.Collection;
import o7.n;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h extends t7.h implements p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f1498m;

    /* renamed from: n, reason: collision with root package name */
    public int f1499n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ l f1500o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ long f1501p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(l lVar, long j5, r7.c cVar, int i9) {
        super(2, cVar);
        this.f1498m = i9;
        this.f1500o = lVar;
        this.f1501p = j5;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        u uVar = (u) obj;
        r7.c cVar = (r7.c) obj2;
        switch (this.f1498m) {
        }
        return ((h) j(uVar, cVar)).k(n7.g.f7490c);
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        switch (this.f1498m) {
            case 0:
                return new h(this.f1500o, this.f1501p, cVar, 0);
            default:
                return new h(this.f1500o, this.f1501p, cVar, 1);
        }
    }

    @Override // t7.a
    public final Object k(Object obj) {
        switch (this.f1498m) {
            case 0:
                int i9 = this.f1499n;
                l lVar = this.f1500o;
                s7.a aVar = s7.a.f8891i;
                if (i9 == 0) {
                    com.bumptech.glide.c.V(obj);
                    this.f1499n = 1;
                    obj = lVar.i(this);
                    if (obj == aVar) {
                    }
                } else if (i9 == 1) {
                    com.bumptech.glide.c.V(obj);
                } else if (i9 != 2) {
                    m7.c.p("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    com.bumptech.glide.c.V(obj);
                    break;
                }
                Collection collection = (Collection) obj;
                collection.getClass();
                ArrayList arrayList = new ArrayList(collection);
                final long j5 = this.f1501p;
                n.F0(arrayList, new a8.l() { // from class: b7.g
                    @Override // a8.l
                    public final Object a(Object obj2) {
                        return Boolean.valueOf(((HistoryItem) obj2).getChatId() == j5);
                    }
                });
                this.f1499n = 2;
                if (l.a(lVar, arrayList, this) == aVar) {
                }
                break;
            default:
                int i10 = this.f1499n;
                l lVar2 = this.f1500o;
                s7.a aVar2 = s7.a.f8891i;
                if (i10 == 0) {
                    com.bumptech.glide.c.V(obj);
                    this.f1499n = 1;
                    obj = lVar2.i(this);
                    if (obj == aVar2) {
                    }
                } else if (i10 == 1) {
                    com.bumptech.glide.c.V(obj);
                } else if (i10 != 2) {
                    m7.c.p("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    com.bumptech.glide.c.V(obj);
                    break;
                }
                Collection collection2 = (Collection) obj;
                collection2.getClass();
                ArrayList arrayList2 = new ArrayList(collection2);
                int size = arrayList2.size();
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    if (i12 < size) {
                        Object obj2 = arrayList2.get(i12);
                        i12++;
                        if (((HistoryItem) obj2).getChatId() != this.f1501p) {
                            i11++;
                        }
                    } else {
                        i11 = -1;
                    }
                }
                if (i11 != -1) {
                    ((HistoryItem) arrayList2.get(i11)).setFavorite(true ^ ((HistoryItem) arrayList2.get(i11)).isFavorite());
                    this.f1499n = 2;
                    if (l.a(lVar2, arrayList2, this) == aVar2) {
                    }
                }
                break;
        }
        return n7.g.f7490c;
    }
}
