package a7;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.m;
import androidx.emoji2.text.s;
import androidx.lifecycle.c0;
import androidx.lifecycle.u;
import androidx.media3.decoder.ffmpeg.b;
import androidx.recyclerview.widget.RecyclerView;
import b8.i;
import com.bumptech.glide.c;
import com.bumptech.glide.d;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.network.tvgramplayer.TvgramApplication;
import com.network.tvgramplayer.service.ProxyService;
import com.network.tvgramplayer.ui.DiscoveryActivity;
import com.network.tvgramplayer.ui.PlayerActivity;
import com.network.tvgramplayer.voip.AudioTrackJNI;
import com.network.tvgramplayer.voip.NativeInstance;
import g.k;
import h7.o;
import i7.x;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.util.Iterator;
import k0.g;
import l1.h0;
import l1.l;
import l1.y;
import l1.y0;
import l3.q;
import n1.p0;
import n1.s0;
import o3.o0;
import org.webrtc.PeerConnectionFactory;
import s1.f;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import u5.e;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f216i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f217j;

    public /* synthetic */ a(h0 h0Var, y0 y0Var) {
        this.f216i = 13;
        this.f217j = y0Var;
    }

    private final void a() {
        y0 y0Var = (y0) this.f217j;
        try {
            synchronized (y0Var) {
            }
            try {
                y0Var.f6066a.g(y0Var.f6069d, y0Var.f6070e);
            } finally {
                y0Var.b(true);
            }
        } catch (l e9) {
            g1.a.q("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e9);
            throw new RuntimeException(e9);
        }
    }

    private final void b() {
        f fVar = (f) this.f217j;
        synchronized (fVar.f8689a) {
            try {
                if (fVar.f8700m) {
                    return;
                }
                long j5 = fVar.f8699l - 1;
                fVar.f8699l = j5;
                if (j5 > 0) {
                    return;
                }
                if (j5 < 0) {
                    fVar.b(new IllegalStateException());
                } else {
                    fVar.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        View q4;
        int i9 = 2;
        Object systemService = null;
        switch (this.f216i) {
            case 0:
                TvgramApplication tvgramApplication = (TvgramApplication) this.f217j;
                boolean z8 = TvgramApplication.f2329j;
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    Log.i("TvgramStartup", "🚀 Background Init Thread Started");
                    Thread.sleep(500L);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    tvgramApplication.a().o();
                    Log.i("TvgramStartup", "⏱️ tdClient.init() took " + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
                    long currentTimeMillis3 = System.currentTimeMillis();
                    IjkMediaPlayer.loadLibrariesOnce(new e(1));
                    IjkMediaPlayer.native_profileBegin("libijkplayer.so");
                    Log.i("TvgramStartup", "⏱️ IJKPlayer init took " + (System.currentTimeMillis() - currentTimeMillis3) + "ms");
                    TvgramApplication.f2329j = true;
                    Log.d("TvgramStartup", "✅ Native components ready. Total background time: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                    return;
                } catch (Throwable th) {
                    Log.e("TvgramStartup", "❌ Async init failed", th);
                    return;
                }
            case 1:
                ((g.l) this.f217j).invalidateOptionsMenu();
                return;
            case 2:
                m mVar = (m) this.f217j;
                Runnable runnable = mVar.f295j;
                if (runnable != null) {
                    runnable.run();
                    mVar.f295j = null;
                    return;
                }
                return;
            case 3:
                k.b((k) this.f217j);
                return;
            case 4:
                s sVar = (s) this.f217j;
                synchronized (sVar.f653l) {
                    try {
                        if (sVar.f657p == null) {
                            return;
                        }
                        try {
                            g d9 = sVar.d();
                            int i10 = d9.f5523e;
                            if (i10 == 2) {
                                synchronized (sVar.f653l) {
                                }
                            }
                            if (i10 != 0) {
                                throw new RuntimeException("fetchFonts result is not OK. (" + i10 + ")");
                            }
                            try {
                                int i11 = j0.m.f5347a;
                                j0.l.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                e eVar = sVar.f652k;
                                Context context = sVar.f650i;
                                eVar.getClass();
                                Typeface y2 = f0.g.f3200a.y(context, new g[]{d9}, 0);
                                MappedByteBuffer K = c.K(sVar.f650i, d9.f5519a);
                                if (K == null || y2 == null) {
                                    throw new RuntimeException("Unable to open file.");
                                }
                                try {
                                    j0.l.a("EmojiCompat.MetadataRepo.create");
                                    a0.l lVar = new a0.l(y2, d.T(K));
                                    j0.l.b();
                                    j0.l.b();
                                    synchronized (sVar.f653l) {
                                        try {
                                            c cVar = sVar.f657p;
                                            if (cVar != null) {
                                                cVar.M(lVar);
                                            }
                                        } finally {
                                        }
                                    }
                                    sVar.b();
                                    return;
                                } finally {
                                    int i12 = j0.m.f5347a;
                                    j0.l.b();
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        } catch (Throwable th3) {
                            synchronized (sVar.f653l) {
                                try {
                                    c cVar2 = sVar.f657p;
                                    if (cVar2 != null) {
                                        cVar2.L(th3);
                                    }
                                    sVar.b();
                                    return;
                                } finally {
                                }
                            }
                        }
                    } finally {
                    }
                }
            case 5:
                c0 c0Var = (c0) this.f217j;
                u uVar = c0Var.f908n;
                if (c0Var.f904j == 0) {
                    c0Var.f905k = true;
                    uVar.d(androidx.lifecycle.l.ON_PAUSE);
                }
                if (c0Var.f903i == 0 && c0Var.f905k) {
                    uVar.d(androidx.lifecycle.l.ON_STOP);
                    c0Var.f906l = true;
                    return;
                }
                return;
            case 6:
                Activity activity = (Activity) this.f217j;
                if (activity.isFinishing()) {
                    return;
                }
                Handler handler = c0.d.f1541g;
                Method method = c0.d.f1540f;
                int i13 = Build.VERSION.SDK_INT;
                if (i13 >= 28) {
                    activity.recreate();
                    return;
                }
                if (((i13 != 26 && i13 != 27) || method != null) && (c0.d.f1539e != null || c0.d.f1538d != null)) {
                    try {
                        Object obj2 = c0.d.f1537c.get(activity);
                        if (obj2 != null && (obj = c0.d.f1536b.get(activity)) != null) {
                            Application application = activity.getApplication();
                            c0.c cVar3 = new c0.c(activity);
                            application.registerActivityLifecycleCallbacks(cVar3);
                            handler.post(new androidx.fragment.app.d(cVar3, i9, obj2));
                            boolean z9 = i13 == 26 || i13 == 27;
                            int i14 = 3;
                            try {
                                if (z9) {
                                    Boolean bool = Boolean.FALSE;
                                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                                } else {
                                    activity.recreate();
                                }
                                handler.post(new androidx.fragment.app.d(application, i14, cVar3));
                                return;
                            } finally {
                                handler.post(new androidx.fragment.app.d(application, i14, cVar3));
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                activity.recreate();
                return;
            case 7:
                c2.l lVar2 = (c2.l) this.f217j;
                Surface surface = lVar2.f1605p;
                if (surface != null) {
                    Iterator it = lVar2.f1598i.iterator();
                    while (it.hasNext()) {
                        ((y) it.next()).f6065i.s0(null);
                    }
                }
                SurfaceTexture surfaceTexture = lVar2.f1604o;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                }
                if (surface != null) {
                    surface.release();
                }
                lVar2.f1604o = null;
                lVar2.f1605p = null;
                return;
            case 8:
                ((com.google.android.material.timepicker.e) this.f217j).e();
                return;
            case 9:
                ((AudioTrackJNI) this.f217j).lambda$startThread$0();
                return;
            case 10:
                ProxyService proxyService = (ProxyService) this.f217j;
                g7.e eVar2 = ProxyService.f2331i;
                try {
                    Context applicationContext = proxyService.getApplicationContext();
                    TvgramApplication tvgramApplication2 = applicationContext instanceof TvgramApplication ? (TvgramApplication) applicationContext : null;
                    if (ProxyService.f2331i != null || tvgramApplication2 == null) {
                        return;
                    }
                    Context applicationContext2 = proxyService.getApplicationContext();
                    applicationContext2.getClass();
                    g7.e eVar3 = new g7.e(applicationContext2, tvgramApplication2.a());
                    ProxyService.f2331i = eVar3;
                    String h = eVar3.h();
                    tvgramApplication2.a().f4132b = h;
                    Log.i("TdClient", "🌐 Proxy URL updated: ".concat(h));
                    return;
                } catch (Exception e9) {
                    Log.e("ProxyService", "Failed to initialize LocalStreamProxy", e9);
                    return;
                }
            case 11:
                DiscoveryActivity discoveryActivity = (DiscoveryActivity) this.f217j;
                c7.a aVar = discoveryActivity.E;
                if (aVar == null) {
                    i.d("binding");
                    throw null;
                }
                o0 layoutManager = ((RecyclerView) aVar.f1644l).getLayoutManager();
                if (layoutManager != null && (q4 = layoutManager.q(0)) != null) {
                    q4.requestFocus();
                    return;
                }
                c7.a aVar2 = discoveryActivity.E;
                if (aVar2 != null) {
                    ((RecyclerView) aVar2.f1644l).requestFocus();
                    return;
                } else {
                    i.d("binding");
                    throw null;
                }
            case 12:
                PlayerActivity playerActivity = (PlayerActivity) this.f217j;
                c7.e eVar4 = playerActivity.E;
                if (eVar4 == null) {
                    i.d("binding");
                    throw null;
                }
                eVar4.f1707m.setVisibility(8);
                c7.e eVar5 = playerActivity.E;
                if (eVar5 == null) {
                    i.d("binding");
                    throw null;
                }
                q qVar = eVar5.f1708n.f1006r;
                if (qVar != null) {
                    qVar.g();
                    return;
                }
                return;
            case 13:
                a();
                return;
            case 14:
                ((l3.d) this.f217j).d(false);
                return;
            case 15:
                ((q) this.f217j).o();
                return;
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                m1.q qVar2 = (m1.q) this.f217j;
                m1.a G = qVar2.G();
                qVar2.L(G, 1028, new o((Object) G, 20));
                qVar2.f6556n.d();
                return;
            case 17:
                NativeInstance nativeInstance = (NativeInstance) this.f217j;
                if (nativeInstance != null) {
                    try {
                        nativeInstance.stopGroup();
                        return;
                    } catch (Exception unused2) {
                        return;
                    }
                }
                return;
            case 18:
                p0 p0Var = (p0) this.f217j;
                if (p0Var.f7329h0 >= z1.g.DEFAULT_LOCATION_EXCLUSION_MS) {
                    x xVar = p0Var.f7338q;
                    switch (xVar.f5178i) {
                        case 11:
                            ((b) xVar.f5179j).W = true;
                            break;
                        default:
                            ((s0) xVar.f5179j).Z0 = true;
                            break;
                    }
                    p0Var.f7329h0 = 0L;
                    return;
                }
                return;
            case 19:
                View view = (View) this.f217j;
                Context context2 = view.getContext();
                int i15 = Build.VERSION.SDK_INT;
                if (i15 >= 23) {
                    systemService = d0.d.b(context2, InputMethodManager.class);
                } else {
                    String c9 = i15 >= 23 ? d0.d.c(context2, InputMethodManager.class) : (String) d0.f.f2344a.get(InputMethodManager.class);
                    if (c9 != null) {
                        systemService = context2.getSystemService(c9);
                    }
                }
                ((InputMethodManager) systemService).showSoftInput(view, 1);
                return;
            case 20:
                ((p1.c) this.f217j).b();
                return;
            case 21:
                b();
                return;
            case 22:
                d5.e eVar6 = (d5.e) this.f217j;
                eVar6.f2958c = false;
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) eVar6.f2960e;
                v0.d dVar = sideSheetBehavior.f2112i;
                if (dVar != null && dVar.f()) {
                    eVar6.a(eVar6.f2957b);
                    return;
                } else {
                    if (sideSheetBehavior.h == 2) {
                        sideSheetBehavior.s(eVar6.f2957b);
                        return;
                    }
                    return;
                }
            case 23:
                ((x5.c) this.f217j).s(true);
                return;
            default:
                x5.i iVar = (x5.i) this.f217j;
                boolean isPopupShowing = iVar.h.isPopupShowing();
                iVar.s(isPopupShowing);
                iVar.f10127m = isPopupShowing;
                return;
        }
    }

    public /* synthetic */ a(Object obj, int i9) {
        this.f216i = i9;
        this.f217j = obj;
    }
}
