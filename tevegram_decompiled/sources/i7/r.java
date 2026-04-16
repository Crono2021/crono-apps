package i7;

import android.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.network.tvgramplayer.data.HistoryItem;
import com.network.tvgramplayer.data.PlaylistItem;
import i7.q3;
import java.util.Arrays;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r extends o3.g0 {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f5057d = 0;

    /* renamed from: e, reason: collision with root package name */
    public List f5058e = o7.p.f8013i;

    /* renamed from: f, reason: collision with root package name */
    public final a8.l f5059f;

    /* renamed from: g, reason: collision with root package name */
    public final a8.l f5060g;
    public final a8.l h;

    /* renamed from: i, reason: collision with root package name */
    public final a8.l f5061i;

    public r(m0 m0Var, m0 m0Var2, m0 m0Var3, m0 m0Var4) {
        this.f5059f = m0Var;
        this.f5060g = m0Var2;
        this.h = m0Var3;
        this.f5061i = m0Var4;
    }

    @Override // o3.g0
    public final int a() {
        switch (this.f5057d) {
        }
        return this.f5058e.size();
    }

    @Override // o3.g0
    public final void d(o3.d1 d1Var, int i9) {
        String url;
        final int i10 = 3;
        final int i11 = 2;
        final int i12 = 1;
        final int i13 = 0;
        switch (this.f5057d) {
            case 0:
                q qVar = (q) d1Var;
                View view = qVar.f5037z;
                ImageView imageView = qVar.f5035x;
                TextView textView = qVar.f5034w;
                final HistoryItem historyItem = (HistoryItem) this.f5058e.get(i9);
                qVar.f5032u.setText(historyItem.getTitle());
                String groupName = historyItem.getGroupName();
                if (groupName != null && groupName.length() != 0) {
                    String chatType = historyItem.getChatType();
                    String n4 = (chatType == null || chatType.length() == 0) ? "" : androidx.activity.g.n("[", historyItem.getChatType(), "] ");
                    url = n4 + historyItem.getGroupName();
                } else if (h8.m.f0(historyItem.getUrl(), "tg://msg", false)) {
                    url = "Mensaje Directo";
                } else if (h8.e.g0(historyItem.getUrl(), "tg://resolve?", false)) {
                    url = "Enlace de Telegram";
                } else if (h8.e.g0(historyItem.getUrl(), "t.me/", false)) {
                    String url2 = historyItem.getUrl();
                    url = h8.e.s0(h8.e.q0(url2, "t.me/", url2), "?");
                    if (url.length() == 0) {
                        url = "Telegram";
                    }
                } else {
                    url = historyItem.getUrl();
                }
                qVar.f5033v.setText(url);
                imageView.setImageResource(historyItem.isFavorite() ? R.drawable.btn_star_big_on : R.drawable.btn_star_big_off);
                if (historyItem.getPositionMs() > 0) {
                    long positionMs = historyItem.getPositionMs() / IjkMediaCodecInfo.RANK_MAX;
                    long j5 = 60;
                    long j9 = positionMs / j5;
                    long j10 = positionMs % j5;
                    long j11 = j9 / j5;
                    textView.setText(j11 > 0 ? String.format("Visto hasta: %d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j11), Long.valueOf(j9 % j5), Long.valueOf(j10)}, 3)) : String.format("Visto hasta: %02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j9), Long.valueOf(j10)}, 2)));
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                view.setOnClickListener(new View.OnClickListener(this) { // from class: i7.n

                    /* renamed from: j, reason: collision with root package name */
                    public final /* synthetic */ r f4986j;

                    {
                        this.f4986j = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        switch (i13) {
                            case 0:
                                ((m0) this.f4986j.f5059f).a(historyItem);
                                break;
                            case 1:
                                ((m0) this.f4986j.f5060g).a(historyItem);
                                break;
                            default:
                                ((m0) this.f4986j.h).a(historyItem);
                                break;
                        }
                    }
                });
                view.setOnLongClickListener(new o(this, historyItem, i13));
                imageView.setOnClickListener(new View.OnClickListener(this) { // from class: i7.n

                    /* renamed from: j, reason: collision with root package name */
                    public final /* synthetic */ r f4986j;

                    {
                        this.f4986j = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        switch (i12) {
                            case 0:
                                ((m0) this.f4986j.f5059f).a(historyItem);
                                break;
                            case 1:
                                ((m0) this.f4986j.f5060g).a(historyItem);
                                break;
                            default:
                                ((m0) this.f4986j.h).a(historyItem);
                                break;
                        }
                    }
                });
                qVar.f5036y.setOnClickListener(new View.OnClickListener(this) { // from class: i7.n

                    /* renamed from: j, reason: collision with root package name */
                    public final /* synthetic */ r f4986j;

                    {
                        this.f4986j = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        switch (i11) {
                            case 0:
                                ((m0) this.f4986j.f5059f).a(historyItem);
                                break;
                            case 1:
                                ((m0) this.f4986j.f5060g).a(historyItem);
                                break;
                            default:
                                ((m0) this.f4986j.h).a(historyItem);
                                break;
                        }
                    }
                });
                break;
            default:
                j7.o oVar = (j7.o) d1Var;
                final PlaylistItem playlistItem = (PlaylistItem) this.f5058e.get(i9);
                oVar.f5480u.setText(playlistItem.getTitle());
                View view2 = oVar.f5484y;
                view2.setOnClickListener(new View.OnClickListener(this) { // from class: j7.n

                    /* renamed from: j, reason: collision with root package name */
                    public final /* synthetic */ i7.r f5478j;

                    {
                        this.f5478j = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        switch (i13) {
                            case 0:
                                ((q3) this.f5478j.f5059f).a(playlistItem);
                                break;
                            case 1:
                                ((q3) this.f5478j.f5060g).a(playlistItem);
                                break;
                            case 2:
                                ((q3) this.f5478j.h).a(playlistItem);
                                break;
                            default:
                                ((q3) this.f5478j.f5061i).a(playlistItem);
                                break;
                        }
                    }
                });
                ImageView imageView2 = oVar.f5481v;
                imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: j7.n

                    /* renamed from: j, reason: collision with root package name */
                    public final /* synthetic */ i7.r f5478j;

                    {
                        this.f5478j = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        switch (i12) {
                            case 0:
                                ((q3) this.f5478j.f5059f).a(playlistItem);
                                break;
                            case 1:
                                ((q3) this.f5478j.f5060g).a(playlistItem);
                                break;
                            case 2:
                                ((q3) this.f5478j.h).a(playlistItem);
                                break;
                            default:
                                ((q3) this.f5478j.f5061i).a(playlistItem);
                                break;
                        }
                    }
                });
                ImageView imageView3 = oVar.f5482w;
                imageView3.setOnClickListener(new View.OnClickListener(this) { // from class: j7.n

                    /* renamed from: j, reason: collision with root package name */
                    public final /* synthetic */ i7.r f5478j;

                    {
                        this.f5478j = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        switch (i11) {
                            case 0:
                                ((q3) this.f5478j.f5059f).a(playlistItem);
                                break;
                            case 1:
                                ((q3) this.f5478j.f5060g).a(playlistItem);
                                break;
                            case 2:
                                ((q3) this.f5478j.h).a(playlistItem);
                                break;
                            default:
                                ((q3) this.f5478j.f5061i).a(playlistItem);
                                break;
                        }
                    }
                });
                ImageView imageView4 = oVar.f5483x;
                imageView4.setOnClickListener(new View.OnClickListener(this) { // from class: j7.n

                    /* renamed from: j, reason: collision with root package name */
                    public final /* synthetic */ i7.r f5478j;

                    {
                        this.f5478j = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        switch (i10) {
                            case 0:
                                ((q3) this.f5478j.f5059f).a(playlistItem);
                                break;
                            case 1:
                                ((q3) this.f5478j.f5060g).a(playlistItem);
                                break;
                            case 2:
                                ((q3) this.f5478j.h).a(playlistItem);
                                break;
                            default:
                                ((q3) this.f5478j.f5061i).a(playlistItem);
                                break;
                        }
                    }
                });
                j7.i iVar = new j7.i(1);
                view2.setOnFocusChangeListener(iVar);
                imageView3.setOnFocusChangeListener(iVar);
                imageView4.setOnFocusChangeListener(iVar);
                imageView2.setOnFocusChangeListener(iVar);
                break;
        }
    }

    @Override // o3.g0
    public final o3.d1 e(ViewGroup viewGroup) {
        switch (this.f5057d) {
            case 0:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558473, viewGroup, false);
                inflate.getClass();
                return new q(inflate);
            default:
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(2131558479, viewGroup, false);
                inflate2.getClass();
                return new j7.o(inflate2);
        }
    }

    public r(q3 q3Var, q3 q3Var2, q3 q3Var3, q3 q3Var4) {
        this.f5059f = q3Var;
        this.f5060g = q3Var2;
        this.h = q3Var3;
        this.f5061i = q3Var4;
    }
}
