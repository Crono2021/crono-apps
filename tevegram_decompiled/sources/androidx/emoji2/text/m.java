package androidx.emoji2.text;

import android.net.Uri;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.lifecycle.g0;
import b2.j0;
import b6.d0;
import b6.w0;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import d1.t0;
import i8.c0;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import l1.n0;
import org.webrtc.EglBase;
import org.webrtc.EglRenderer;
import org.webrtc.VideoFileRenderer;
import org.webrtc.VideoFrame;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f632i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f633j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f634k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f635l;

    public /* synthetic */ m(Object obj, Object obj2, Object obj3, int i9) {
        this.f632i = i9;
        this.f633j = obj;
        this.f634k = obj2;
        this.f635l = obj3;
    }

    /* JADX WARN: Type inference failed for: r1v25, types: [java.lang.Object, v1.d0] */
    @Override // java.lang.Runnable
    public final void run() {
        final int i9 = 0;
        switch (this.f632i) {
            case 0:
                o oVar = (o) this.f633j;
                com.bumptech.glide.c cVar = (com.bumptech.glide.c) this.f634k;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f635l;
                try {
                    t w8 = android.support.v4.media.session.b.w(oVar.f639j);
                    if (w8 == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    s sVar = (s) ((k) w8.f618b);
                    synchronized (sVar.f653l) {
                        sVar.f655n = threadPoolExecutor;
                    }
                    ((k) w8.f618b).a(new n(cVar, threadPoolExecutor));
                    return;
                } catch (Throwable th) {
                    cVar.L(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 1:
                a5.d dVar = (a5.d) this.f633j;
                final d1.s sVar2 = (d1.s) this.f634k;
                final l1.g gVar = (l1.g) this.f635l;
                j0 j0Var = (j0) dVar.f175k;
                int i10 = g1.w.f3713a;
                j0Var.getClass();
                m1.q qVar = ((l1.y) j0Var).f6065i.f5804y;
                final m1.a K = qVar.K();
                qVar.L(K, 1017, new g1.j(K, sVar2, gVar, i9) { // from class: m1.j

                    /* renamed from: i, reason: collision with root package name */
                    public final /* synthetic */ int f6528i;

                    /* renamed from: j, reason: collision with root package name */
                    public final /* synthetic */ a f6529j;

                    /* renamed from: k, reason: collision with root package name */
                    public final /* synthetic */ d1.s f6530k;

                    {
                        this.f6528i = i9;
                    }

                    @Override // g1.j
                    public final void a(Object obj) {
                        c cVar2 = (c) obj;
                        switch (this.f6528i) {
                            case 0:
                                cVar2.getClass();
                                cVar2.z(this.f6529j, this.f6530k);
                                break;
                            default:
                                cVar2.getClass();
                                cVar2.a(this.f6529j, this.f6530k);
                                break;
                        }
                    }
                });
                return;
            case 2:
                MediaExplorerActivity mediaExplorerActivity = (MediaExplorerActivity) this.f633j;
                String str = (String) this.f634k;
                Uri uri = (Uri) this.f635l;
                c7.b bVar = mediaExplorerActivity.E;
                r7.c cVar2 = null;
                if (bVar == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((ProgressBar) bVar.h).setVisibility(8);
                if (str == null || str.length() == 0) {
                    Toast.makeText(mediaExplorerActivity, "Error al descargar el archivo desde Telegram", 0).show();
                    return;
                } else {
                    i8.w.j(g0.a(mediaExplorerActivity), c0.f5251b, new b7.c(str, mediaExplorerActivity, uri, cVar2, 3), 2);
                    return;
                }
            case 3:
                MediaExplorerActivity mediaExplorerActivity2 = (MediaExplorerActivity) this.f633j;
                String str2 = (String) this.f634k;
                String str3 = (String) this.f635l;
                c7.b bVar2 = mediaExplorerActivity2.E;
                r7.c cVar3 = null;
                if (bVar2 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((ProgressBar) bVar2.h).setVisibility(8);
                if (str2 == null || str2.length() == 0) {
                    Toast.makeText(mediaExplorerActivity2, "Error al descargar el archivo desde Telegram", 0).show();
                    return;
                } else {
                    i8.w.j(g0.a(mediaExplorerActivity2), c0.f5251b, new b7.c(str2, str3, mediaExplorerActivity2, cVar3, 2), 2);
                    return;
                }
            case 4:
                n0 n0Var = (n0) this.f633j;
                d0 d0Var = (d0) this.f634k;
                v1.z zVar = (v1.z) this.f635l;
                m1.q qVar2 = n0Var.f5967c;
                w0 f9 = d0Var.f();
                m6.p pVar = qVar2.f6554l;
                t0 t0Var = qVar2.f6557o;
                t0Var.getClass();
                pVar.getClass();
                pVar.f6677b = b6.g0.m(f9);
                if (!f9.isEmpty()) {
                    pVar.f6680e = (v1.z) f9.get(0);
                    zVar.getClass();
                    pVar.f6681f = zVar;
                }
                if (((v1.z) pVar.f6679d) == null) {
                    pVar.f6679d = m6.p.e(t0Var, (b6.g0) pVar.f6677b, (v1.z) pVar.f6680e, (d1.w0) pVar.f6676a);
                }
                pVar.j(t0Var.U());
                return;
            case 5:
                m1.b bVar3 = (m1.b) this.f633j;
                final d1.s sVar3 = (d1.s) this.f634k;
                final l1.g gVar2 = (l1.g) this.f635l;
                n1.q qVar3 = (n1.q) bVar3.f6511k;
                int i11 = g1.w.f3713a;
                qVar3.getClass();
                m1.q qVar4 = ((l1.y) qVar3).f6065i.f5804y;
                final m1.a K2 = qVar4.K();
                final int i12 = 1;
                qVar4.L(K2, 1009, new g1.j(K2, sVar3, gVar2, i12) { // from class: m1.j

                    /* renamed from: i, reason: collision with root package name */
                    public final /* synthetic */ int f6528i;

                    /* renamed from: j, reason: collision with root package name */
                    public final /* synthetic */ a f6529j;

                    /* renamed from: k, reason: collision with root package name */
                    public final /* synthetic */ d1.s f6530k;

                    {
                        this.f6528i = i12;
                    }

                    @Override // g1.j
                    public final void a(Object obj) {
                        c cVar22 = (c) obj;
                        switch (this.f6528i) {
                            case 0:
                                cVar22.getClass();
                                cVar22.z(this.f6529j, this.f6530k);
                                break;
                            default:
                                cVar22.getClass();
                                cVar22.a(this.f6529j, this.f6530k);
                                break;
                        }
                    }
                });
                return;
            case 6:
                ((EglRenderer) this.f633j).lambda$init$0((EglBase.Context) this.f634k, (int[]) this.f635l);
                return;
            case 7:
                ((EglRenderer) this.f633j).lambda$removeFrameListener$4((CountDownLatch) this.f634k, (EglRenderer.FrameListener) this.f635l);
                return;
            case 8:
                ((VideoFileRenderer) this.f633j).lambda$renderFrameOnRenderThread$1((VideoFrame.I420Buffer) this.f634k, (VideoFrame) this.f635l);
                return;
            default:
                o1.d dVar2 = (o1.d) this.f633j;
                this.f634k.m(dVar2.f7569a, dVar2.f7570b, (v1.v) this.f635l);
                return;
        }
    }
}
