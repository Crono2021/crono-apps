package i7;

import android.util.Log;
import com.network.tvgramplayer.ui.MainActivity;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h1 extends t7.h implements a8.p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f4879m;

    /* renamed from: n, reason: collision with root package name */
    public int f4880n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ MainActivity f4881o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h1(MainActivity mainActivity, r7.c cVar, int i9) {
        super(2, cVar);
        this.f4879m = i9;
        this.f4881o = mainActivity;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        i8.u uVar = (i8.u) obj;
        r7.c cVar = (r7.c) obj2;
        switch (this.f4879m) {
            case 0:
                return ((h1) j(uVar, cVar)).k(n7.g.f7490c);
            case 1:
                return ((h1) j(uVar, cVar)).k(n7.g.f7490c);
            case 2:
                ((h1) j(uVar, cVar)).k(n7.g.f7490c);
                return s7.a.f8891i;
            case 3:
                return ((h1) j(uVar, cVar)).k(n7.g.f7490c);
            default:
                ((h1) j(uVar, cVar)).k(n7.g.f7490c);
                return s7.a.f8891i;
        }
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        switch (this.f4879m) {
            case 0:
                return new h1(this.f4881o, cVar, 0);
            case 1:
                return new h1(this.f4881o, cVar, 1);
            case 2:
                return new h1(this.f4881o, cVar, 2);
            case 3:
                return new h1(this.f4881o, cVar, 3);
            default:
                return new h1(this.f4881o, cVar, 4);
        }
    }

    @Override // t7.a
    public final Object k(Object obj) {
        int i9 = this.f4879m;
        int i10 = 0;
        s7.a aVar = s7.a.f8891i;
        MainActivity mainActivity = this.f4881o;
        r7.c cVar = null;
        int i11 = 1;
        switch (i9) {
            case 0:
                int i12 = this.f4880n;
                try {
                } catch (Exception e9) {
                    Log.e("MainActivity", "Internet Integrity Check: FAILED", e9);
                    p8.d dVar = i8.c0.f5250a;
                    j8.d dVar2 = n8.o.f7529a;
                    g1 g1Var = new g1(mainActivity, cVar, i11);
                    this.f4880n = 2;
                    if (i8.w.q(dVar2, g1Var, this) == aVar) {
                        return aVar;
                    }
                }
                if (i12 == 0) {
                    com.bumptech.glide.c.V(obj);
                    URLConnection openConnection = new URL("https://www.google.com").openConnection();
                    openConnection.getClass();
                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    httpURLConnection.setConnectTimeout(3000);
                    httpURLConnection.setReadTimeout(3000);
                    httpURLConnection.connect();
                    Log.i("MainActivity", "Internet Integrity Check: Success (Code " + httpURLConnection.getResponseCode() + ")");
                    p8.d dVar3 = i8.c0.f5250a;
                    j8.d dVar4 = n8.o.f7529a;
                    g1 g1Var2 = new g1(mainActivity, cVar, i10);
                    this.f4880n = 1;
                    if (i8.w.q(dVar4, g1Var2, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i12 != 1) {
                        if (i12 == 2) {
                            com.bumptech.glide.c.V(obj);
                            return n7.g.f7490c;
                        }
                        m7.c.p("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    com.bumptech.glide.c.V(obj);
                }
                return n7.g.f7490c;
            case 1:
                n7.g gVar = n7.g.f7490c;
                int i13 = this.f4880n;
                if (i13 == 0) {
                    com.bumptech.glide.c.V(obj);
                    a0.l lVar = mainActivity.J;
                    if (lVar == null) {
                        b8.i.d("subscriptionManager");
                        throw null;
                    }
                    l8.d dVar5 = (l8.d) lVar.f33l;
                    l8.d dVar6 = mainActivity.t().A;
                    l1 l1Var = new l1(mainActivity, null);
                    m1 m1Var = new m1(mainActivity, i10);
                    this.f4880n = 1;
                    m8.d dVar7 = new m8.d(new l8.d[]{dVar5, dVar6}, new l8.b(l1Var, null), m1Var, null);
                    r7.g gVar2 = this.f8983j;
                    gVar2.getClass();
                    m8.e eVar = new m8.e(gVar2, this);
                    Object R = a.a.R(eVar, eVar, dVar7);
                    if (R != aVar) {
                        R = gVar;
                    }
                    if (R != aVar) {
                        R = gVar;
                    }
                    if (R == aVar) {
                        return aVar;
                    }
                } else {
                    if (i13 != 1) {
                        m7.c.p("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    com.bumptech.glide.c.V(obj);
                }
                return gVar;
            case 2:
                int i14 = this.f4880n;
                if (i14 != 0) {
                    if (i14 != 1) {
                        m7.c.p("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    com.bumptech.glide.c.V(obj);
                    throw new androidx.fragment.app.r();
                }
                com.bumptech.glide.c.V(obj);
                int i15 = MainActivity.X;
                l8.d dVar8 = mainActivity.t().f4151v;
                m1 m1Var2 = new m1(mainActivity, i11);
                this.f4880n = 1;
                dVar8.b(m1Var2, this);
                return aVar;
            case 3:
                int i16 = this.f4880n;
                if (i16 == 0) {
                    com.bumptech.glide.c.V(obj);
                    a0.l lVar2 = mainActivity.G;
                    if (lVar2 == null) {
                        b8.i.d("historyManager");
                        throw null;
                    }
                    this.f4880n = 1;
                    obj = lVar2.i(this);
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (i16 != 1) {
                        m7.c.p("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    com.bumptech.glide.c.V(obj);
                }
                List list = (List) obj;
                if (list.isEmpty()) {
                    c7.d dVar9 = mainActivity.E;
                    if (dVar9 == null) {
                        b8.i.d("binding");
                        throw null;
                    }
                    dVar9.f1688s.setVisibility(8);
                    c7.d dVar10 = mainActivity.E;
                    if (dVar10 == null) {
                        b8.i.d("binding");
                        throw null;
                    }
                    dVar10.B.setVisibility(8);
                } else {
                    r rVar = mainActivity.H;
                    if (rVar == null) {
                        b8.i.d("historyAdapter");
                        throw null;
                    }
                    o3.k c9 = o3.o.c(new p(rVar.f5058e, list));
                    rVar.f5058e = list;
                    c9.a(rVar);
                    c7.d dVar11 = mainActivity.E;
                    if (dVar11 == null) {
                        b8.i.d("binding");
                        throw null;
                    }
                    dVar11.f1688s.setVisibility(0);
                    c7.d dVar12 = mainActivity.E;
                    if (dVar12 == null) {
                        b8.i.d("binding");
                        throw null;
                    }
                    dVar12.B.setVisibility(0);
                }
                return n7.g.f7490c;
            default:
                int i17 = this.f4880n;
                if (i17 != 0) {
                    if (i17 != 1) {
                        m7.c.p("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    com.bumptech.glide.c.V(obj);
                    throw new androidx.fragment.app.r();
                }
                com.bumptech.glide.c.V(obj);
                int i18 = MainActivity.X;
                l8.d dVar13 = mainActivity.t().A;
                c2 c2Var = new c2(mainActivity);
                this.f4880n = 1;
                dVar13.b(c2Var, this);
                return aVar;
        }
    }
}
