package i7;

import android.os.Build;
import android.util.Log;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import com.network.tvgramplayer.ui.MainActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n1 extends t7.h implements a8.p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f4990m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ MainActivity f4991n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n1(long j5, MainActivity mainActivity, r7.c cVar) {
        super(2, cVar);
        this.f4990m = j5;
        this.f4991n = mainActivity;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        n1 n1Var = (n1) j((i8.u) obj, (r7.c) obj2);
        n7.g gVar = n7.g.f7490c;
        n1Var.k(gVar);
        return gVar;
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        return new n1(this.f4990m, this.f4991n, cVar);
    }

    @Override // t7.a
    public final Object k(Object obj) {
        int checkSelfPermission;
        int checkSelfPermission2;
        com.bumptech.glide.c.V(obj);
        Log.i("TvgramStartup", "✨ Native Ready! Hiding Overlay (Total Startup: " + (System.currentTimeMillis() - this.f4990m) + "ms)");
        MainActivity mainActivity = this.f4991n;
        c7.d dVar = mainActivity.E;
        r7.c cVar = null;
        if (dVar == null) {
            b8.i.d("binding");
            throw null;
        }
        dVar.f1685p.animate().alpha(0.0f).setDuration(500L).withEndAction(new s0(mainActivity, 3));
        LifecycleCoroutineScopeImpl a9 = androidx.lifecycle.g0.a(mainActivity);
        p8.d dVar2 = i8.c0.f5250a;
        int i9 = 1;
        i8.w.j(a9, n8.o.f7529a, new p1(mainActivity, cVar, i9), 2);
        i8.w.j(androidx.lifecycle.g0.a(mainActivity), null, new h1(mainActivity, cVar, i9), 3);
        mainActivity.y();
        mainActivity.A();
        ArrayList arrayList = new ArrayList();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23) {
            checkSelfPermission = mainActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
            if (checkSelfPermission != 0) {
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
            if (i10 >= 33) {
                checkSelfPermission2 = mainActivity.checkSelfPermission("android.permission.POST_NOTIFICATIONS");
                if (checkSelfPermission2 != 0) {
                    arrayList.add("android.permission.POST_NOTIFICATIONS");
                }
            }
        }
        int i11 = 0;
        if (arrayList.isEmpty()) {
            mainActivity.s("> Permissions already granted or not needed.");
        } else {
            mainActivity.s("> Requesting permissions: " + arrayList);
            mainActivity.W.Z(arrayList.toArray(new String[0]));
        }
        i8.w.j(androidx.lifecycle.g0.a(mainActivity), i8.c0.f5251b, new h1(mainActivity, cVar, i11), 2);
        i8.w.j(androidx.lifecycle.g0.a(mainActivity), null, new h1(mainActivity, cVar, 4), 3);
        return n7.g.f7490c;
    }
}
