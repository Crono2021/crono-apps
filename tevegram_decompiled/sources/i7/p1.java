package i7;

import android.content.pm.PackageInfo;
import android.os.Build;
import com.network.tvgramplayer.ui.MainActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p1 extends t7.h implements a8.p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f5020m;

    /* renamed from: n, reason: collision with root package name */
    public int f5021n;

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object f5022o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ MainActivity f5023p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p1(MainActivity mainActivity, r7.c cVar, int i9) {
        super(2, cVar);
        this.f5020m = i9;
        this.f5023p = mainActivity;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        i8.u uVar = (i8.u) obj;
        r7.c cVar = (r7.c) obj2;
        switch (this.f5020m) {
            case 0:
                ((p1) j(uVar, cVar)).k(n7.g.f7490c);
                return s7.a.f8891i;
            default:
                return ((p1) j(uVar, cVar)).k(n7.g.f7490c);
        }
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        switch (this.f5020m) {
            case 0:
                p1 p1Var = new p1(this.f5023p, cVar, 0);
                p1Var.f5022o = obj;
                return p1Var;
            default:
                p1 p1Var2 = new p1(this.f5023p, cVar, 1);
                p1Var2.f5022o = obj;
                return p1Var2;
        }
    }

    @Override // t7.a
    public final Object k(Object obj) {
        long longVersionCode;
        int i9 = this.f5020m;
        MainActivity mainActivity = this.f5023p;
        s7.a aVar = s7.a.f8891i;
        r7.c cVar = null;
        switch (i9) {
            case 0:
                i8.u uVar = (i8.u) this.f5022o;
                int i10 = this.f5021n;
                if (i10 != 0) {
                    if (i10 != 1) {
                        m7.c.p("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    com.bumptech.glide.c.V(obj);
                    throw new androidx.fragment.app.r();
                }
                com.bumptech.glide.c.V(obj);
                int i11 = 0;
                try {
                    PackageInfo packageInfo = mainActivity.getPackageManager().getPackageInfo(mainActivity.getPackageName(), 0);
                    if (Build.VERSION.SDK_INT >= 28) {
                        longVersionCode = packageInfo.getLongVersionCode();
                        i11 = (int) longVersionCode;
                    } else {
                        i11 = packageInfo.versionCode;
                    }
                } catch (Exception unused) {
                }
                k7.a aVar2 = mainActivity.K;
                if (aVar2 == null) {
                    b8.i.d("settings");
                    throw null;
                }
                aVar2.f5628b.edit().putInt("last_app_version", i11).apply();
                int i12 = 2;
                i8.w.j(uVar, null, new h1(mainActivity, cVar, i12), 3);
                l8.d dVar = mainActivity.t().f4135e;
                m1 m1Var = new m1(mainActivity, i12);
                this.f5022o = null;
                this.f5021n = 1;
                dVar.b(m1Var, this);
                return aVar;
            default:
                i8.u uVar2 = (i8.u) this.f5022o;
                int i13 = this.f5021n;
                if (i13 != 0 && i13 != 1) {
                    m7.c.p("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                com.bumptech.glide.c.V(obj);
                do {
                    i8.y0 y0Var = (i8.y0) uVar2.c().h(i8.t.f5304j);
                    if (!(y0Var != null ? y0Var.B() : true)) {
                        return n7.g.f7490c;
                    }
                    int i14 = MainActivity.X;
                    mainActivity.y();
                    this.f5022o = uVar2;
                    this.f5021n = 1;
                } while (i8.w.d(l1.k.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS, this) != aVar);
                return aVar;
        }
    }
}
