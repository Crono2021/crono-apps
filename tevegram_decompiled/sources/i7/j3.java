package i7;

import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.data.PlaylistItem;
import com.network.tvgramplayer.ui.PlayerActivity;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j3 implements d1.r0 {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f4933i;

    public j3(PlayerActivity playerActivity) {
        this.f4933i = playerActivity;
    }

    @Override // d1.r0
    public final void C(d1.e0 e0Var, int i9) {
        PlayerActivity playerActivity;
        Playlist playlist;
        String str;
        if (i9 != 1 || (playlist = (playerActivity = this.f4933i).O) == null || playerActivity.P >= playlist.getItems().size() - 1) {
            return;
        }
        playerActivity.P++;
        PlaylistItem playlistItem = playlist.getItems().get(playerActivity.P);
        c7.e eVar = playerActivity.E;
        if (eVar == null) {
            b8.i.d("binding");
            throw null;
        }
        eVar.f1713s.setText(playlistItem.getTitle());
        c7.e eVar2 = playerActivity.E;
        if (eVar2 == null) {
            b8.i.d("binding");
            throw null;
        }
        TextView textView = eVar2.f1710p;
        e7.a aVar = playerActivity.R;
        if (aVar == null || (str = aVar.f3153c) == null) {
            str = "";
        }
        textView.setText(str);
        playerActivity.H = playerActivity.R;
        PlayerActivity.s(playerActivity, null);
        playerActivity.R = null;
        playerActivity.A();
        playerActivity.y();
        Log.i("PlayerActivity", "✨ Transición Seamless completada: " + playlistItem.getTitle());
    }

    @Override // d1.r0
    public final void f(d1.n0 n0Var) {
        n0Var.getClass();
        Log.e("PlayerActivity", "❌ Player Error: " + n0Var.getMessage(), n0Var);
        int i9 = PlayerActivity.X;
        PlayerActivity playerActivity = this.f4933i;
        playerActivity.x(true);
        c7.e eVar = playerActivity.E;
        if (eVar == null) {
            b8.i.d("binding");
            throw null;
        }
        eVar.f1706l.setVisibility(8);
        Toast.makeText(playerActivity, "Error de red o reproducción: Reintentando...", 1).show();
    }

    @Override // d1.r0
    public final void i() {
        Log.d("PlayerActivity", "🎬 First frame rendered!");
        PlayerActivity playerActivity = this.f4933i;
        c7.e eVar = playerActivity.E;
        if (eVar == null) {
            b8.i.d("binding");
            throw null;
        }
        eVar.f1708n.setVisibility(0);
        c7.e eVar2 = playerActivity.E;
        if (eVar2 == null) {
            b8.i.d("binding");
            throw null;
        }
        eVar2.f1706l.setVisibility(8);
        playerActivity.getWindow().addFlags(128);
        playerActivity.y();
        playerActivity.x(true);
    }

    @Override // d1.r0
    public final void j(d1.h0 h0Var) {
        d1.f1 v8;
        b6.g0 g0Var;
        h0Var.getClass();
        CharSequence charSequence = h0Var.f2450a;
        PlayerActivity playerActivity = this.f4933i;
        if (charSequence != null) {
            c7.e eVar = playerActivity.E;
            if (eVar == null) {
                b8.i.d("binding");
                throw null;
            }
            eVar.f1713s.setText(charSequence);
        }
        CharSequence charSequence2 = h0Var.f2451b;
        if (charSequence2 != null) {
            c7.e eVar2 = playerActivity.E;
            if (eVar2 == null) {
                b8.i.d("binding");
                throw null;
            }
            eVar2.f1710p.setText(charSequence2);
        }
        c7.e eVar3 = playerActivity.E;
        if (eVar3 == null) {
            b8.i.d("binding");
            throw null;
        }
        d1.t0 player = eVar3.f1708n.getPlayer();
        if (player != null && (v8 = player.v()) != null && (g0Var = v8.f2422a) != null && !g0Var.isEmpty()) {
            int size = g0Var.size();
            int i9 = 0;
            while (i9 < size) {
                Object obj = g0Var.get(i9);
                i9++;
                d1.e1 e1Var = (d1.e1) obj;
                if (e1Var.f2415b.f2618c == 2 && e1Var.b()) {
                    return;
                }
            }
        }
        PlayerActivity.s(playerActivity, h0Var);
    }

    @Override // d1.r0
    public final void r(d1.f1 f1Var) {
        boolean z8;
        f1Var.getClass();
        b6.g0 g0Var = f1Var.f2422a;
        g0Var.getClass();
        if (!g0Var.isEmpty()) {
            int size = g0Var.size();
            int i9 = 0;
            while (i9 < size) {
                Object obj = g0Var.get(i9);
                i9++;
                d1.e1 e1Var = (d1.e1) obj;
                if (e1Var.f2415b.f2618c == 2 && e1Var.b()) {
                    z8 = true;
                    break;
                }
            }
        }
        z8 = false;
        PlayerActivity playerActivity = this.f4933i;
        c7.e eVar = playerActivity.E;
        if (eVar == null) {
            b8.i.d("binding");
            throw null;
        }
        eVar.f1714t.setVisibility(!z8 ? 0 : 8);
        c7.e eVar2 = playerActivity.E;
        if (z8) {
            if (eVar2 == null) {
                b8.i.d("binding");
                throw null;
            }
            eVar2.f1705k.setVisibility(8);
            c7.e eVar3 = playerActivity.E;
            if (eVar3 == null) {
                b8.i.d("binding");
                throw null;
            }
            eVar3.f1708n.setShutterBackgroundColor(-16777216);
            c7.e eVar4 = playerActivity.E;
            if (eVar4 == null) {
                b8.i.d("binding");
                throw null;
            }
            eVar4.f1708n.setUseController(true);
            c7.e eVar5 = playerActivity.E;
            if (eVar5 == null) {
                b8.i.d("binding");
                throw null;
            }
            l3.q qVar = eVar5.f1708n.f1006r;
            if (qVar != null) {
                qVar.g();
            }
        } else {
            if (eVar2 == null) {
                b8.i.d("binding");
                throw null;
            }
            eVar2.f1708n.setShutterBackgroundColor(0);
            c7.e eVar6 = playerActivity.E;
            if (eVar6 == null) {
                b8.i.d("binding");
                throw null;
            }
            d1.t0 player = eVar6.f1708n.getPlayer();
            PlayerActivity.s(playerActivity, player != null ? player.i0() : null);
        }
        playerActivity.C();
    }

    @Override // d1.r0
    public final void s(int i9) {
        Playlist playlist;
        List<PlaylistItem> items;
        PlayerActivity playerActivity = this.f4933i;
        androidx.activity.j jVar = playerActivity.V;
        Log.d("PlayerActivity", "▶️ Playback State Changed: ".concat(i9 != 1 ? i9 != 2 ? i9 != 3 ? i9 != 4 ? "UNKNOWN" : "ENDED" : "READY" : "BUFFERING" : "IDLE"));
        int i10 = 0;
        if (i9 == 3) {
            c7.e eVar = playerActivity.E;
            if (eVar == null) {
                b8.i.d("binding");
                throw null;
            }
            eVar.f1706l.setVisibility(8);
            c7.e eVar2 = playerActivity.E;
            if (eVar2 == null) {
                b8.i.d("binding");
                throw null;
            }
            eVar2.f1708n.setVisibility(0);
        }
        if (i9 == 4 && (playlist = playerActivity.O) != null) {
            boolean isLoopEnabled = playlist.isLoopEnabled();
            Playlist playlist2 = playerActivity.O;
            if (isLoopEnabled) {
                if (playlist2 == null || (items = playlist2.getItems()) == null || items.size() != 1) {
                    playerActivity.v();
                } else {
                    c7.e eVar3 = playerActivity.E;
                    if (eVar3 == null) {
                        b8.i.d("binding");
                        throw null;
                    }
                    d1.t0 player = eVar3.f1708n.getPlayer();
                    if (player != null) {
                        player.seekTo(0L);
                    }
                    c7.e eVar4 = playerActivity.E;
                    if (eVar4 == null) {
                        b8.i.d("binding");
                        throw null;
                    }
                    d1.t0 player2 = eVar4.f1708n.getPlayer();
                    if (player2 != null) {
                        player2.F();
                    }
                }
            } else if (playlist2 != null && playlist2.isAutoNextEnabled()) {
                playerActivity.v();
            }
        }
        c7.e eVar5 = playerActivity.E;
        if (eVar5 == null) {
            b8.i.d("binding");
            throw null;
        }
        ProgressBar progressBar = eVar5.f1709o;
        TextView textView = eVar5.f1711q;
        if (i9 == 2) {
            textView.post(jVar);
            c7.e eVar6 = playerActivity.E;
            if (eVar6 == null) {
                b8.i.d("binding");
                throw null;
            }
            eVar6.f1712r.setText("Bufferizando / Reconectando...");
        } else {
            textView.removeCallbacks(jVar);
            if (i9 == 3) {
                c7.e eVar7 = playerActivity.E;
                if (eVar7 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                eVar7.f1711q.setText("");
                c7.e eVar8 = playerActivity.E;
                if (eVar8 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                eVar8.f1712r.setText("");
            }
            i10 = 8;
        }
        progressBar.setVisibility(i10);
    }

    @Override // d1.r0
    public final /* synthetic */ void A(f1.c cVar) {
    }

    @Override // d1.r0
    public final /* synthetic */ void B(d1.h1 h1Var) {
    }

    @Override // d1.r0
    public final /* synthetic */ void D(d1.q0 q0Var) {
    }

    @Override // d1.r0
    public final /* synthetic */ void F(boolean z8) {
    }

    @Override // d1.r0
    public final /* synthetic */ void a(int i9) {
    }

    @Override // d1.r0
    public final /* synthetic */ void b(d1.p0 p0Var) {
    }

    @Override // d1.r0
    public final /* synthetic */ void d(boolean z8) {
    }

    @Override // d1.r0
    public final /* synthetic */ void e(int i9) {
    }

    @Override // d1.r0
    public final /* synthetic */ void g(int i9) {
    }

    @Override // d1.r0
    public final /* synthetic */ void h(boolean z8) {
    }

    @Override // d1.r0
    public final /* synthetic */ void k(boolean z8) {
    }

    @Override // d1.r0
    public final /* synthetic */ void l(List list) {
    }

    @Override // d1.r0
    public final /* synthetic */ void q(float f9) {
    }

    @Override // d1.r0
    public final /* synthetic */ void t(d1.o0 o0Var) {
    }

    @Override // d1.r0
    public final /* synthetic */ void u(d1.n0 n0Var) {
    }

    @Override // d1.r0
    public final /* synthetic */ void v(d1.d1 d1Var) {
    }

    @Override // d1.r0
    public final /* synthetic */ void w(boolean z8) {
    }

    @Override // d1.r0
    public final /* synthetic */ void z(d1.j0 j0Var) {
    }

    @Override // d1.r0
    public final /* synthetic */ void E(d1.y0 y0Var, int i9) {
    }

    @Override // d1.r0
    public final /* synthetic */ void n(int i9, boolean z8) {
    }

    @Override // d1.r0
    public final /* synthetic */ void p(int i9, boolean z8) {
    }

    @Override // d1.r0
    public final /* synthetic */ void x(int i9, int i10) {
    }

    @Override // d1.r0
    public final /* synthetic */ void c(d1.s0 s0Var, d1.s0 s0Var2, int i9) {
    }
}
