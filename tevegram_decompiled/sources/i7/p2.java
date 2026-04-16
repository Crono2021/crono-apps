package i7;

import android.media.AudioTrack;
import android.os.Handler;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.ui.MediaExplorerActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class p2 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5024i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f5025j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f5026k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f5027l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f5028m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f5029n;

    public /* synthetic */ p2(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i9) {
        this.f5024i = i9;
        this.f5025j = obj;
        this.f5026k = obj2;
        this.f5027l = obj3;
        this.f5028m = obj4;
        this.f5029n = obj5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5024i) {
            case 0:
                MediaExplorerActivity mediaExplorerActivity = (MediaExplorerActivity) this.f5025j;
                Playlist playlist = (Playlist) this.f5026k;
                Playlist playlist2 = (Playlist) this.f5027l;
                b7.a aVar = (b7.a) this.f5028m;
                m2 m2Var = (m2) this.f5029n;
                int i9 = MediaExplorerActivity.Y;
                k5.b m9 = new k5.b(mediaExplorerActivity, 0).m("Actualización Pendiente");
                m9.f3568a.f3511f = "Existe una versión más reciente en la nube.\n\nLocal: " + playlist.getItems().size() + " tracks\nNube: " + playlist2.getItems().size() + " tracks\n\n¿Deseas actualizar antes de añadir el nuevo contenido?";
                m9.l("Actualizar y Añadir", new b1(mediaExplorerActivity, aVar, m2Var, 3));
                m9.j("Añadir sin actualizar", new q2(m2Var, 0));
                m9.k("Cancelar", null);
                m9.h();
                return;
            default:
                AudioTrack audioTrack = (AudioTrack) this.f5025j;
                x xVar = (x) this.f5026k;
                Handler handler = (Handler) this.f5027l;
                n1.r rVar = (n1.r) this.f5028m;
                d2.f0 f0Var = (d2.f0) this.f5029n;
                try {
                    audioTrack.flush();
                    audioTrack.release();
                    if (xVar != null && handler.getLooper().getThread().isAlive()) {
                        handler.post(new b2.f0(xVar, 15, rVar));
                    }
                    f0Var.b();
                    synchronized (n1.p0.f7312j0) {
                        try {
                            int i10 = n1.p0.f7314l0 - 1;
                            n1.p0.f7314l0 = i10;
                            if (i10 == 0) {
                                n1.p0.f7313k0.shutdown();
                                n1.p0.f7313k0 = null;
                            }
                        } finally {
                        }
                    }
                    return;
                } catch (Throwable th) {
                    if (xVar != null && handler.getLooper().getThread().isAlive()) {
                        handler.post(new b2.f0(xVar, 15, rVar));
                    }
                    f0Var.b();
                    synchronized (n1.p0.f7312j0) {
                        try {
                            int i11 = n1.p0.f7314l0 - 1;
                            n1.p0.f7314l0 = i11;
                            if (i11 == 0) {
                                n1.p0.f7313k0.shutdown();
                                n1.p0.f7313k0 = null;
                            }
                            throw th;
                        } finally {
                        }
                    }
                }
        }
    }
}
