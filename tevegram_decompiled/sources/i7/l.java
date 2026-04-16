package i7;

import android.R;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.chip.Chip;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.telegram.TdClient$ExplorerItem;
import com.network.tvgramplayer.ui.DiscoveryActivity;
import i7.q3;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l extends o3.g0 {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4948d;

    /* renamed from: e, reason: collision with root package name */
    public Object f4949e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f4950f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f4951g;
    public final Object h;

    public l(DiscoveryActivity discoveryActivity, i iVar) {
        this.f4948d = 0;
        this.h = discoveryActivity;
        this.f4950f = iVar;
        this.f4949e = o7.p.f8013i;
        this.f4951g = new SimpleDateFormat("HH:mm", Locale.getDefault());
    }

    @Override // o3.g0
    public final int a() {
        switch (this.f4948d) {
            case 0:
                return ((List) this.f4949e).size();
            case 1:
                return ((List) this.f4949e).size();
            default:
                return ((String[]) this.f4950f).length;
        }
    }

    @Override // o3.g0
    public long b(int i9) {
        switch (this.f4948d) {
            case 2:
                return i9;
            default:
                return super.b(i9);
        }
    }

    @Override // o3.g0
    public final void d(o3.d1 d1Var, int i9) {
        int i10 = this.f4948d;
        Object obj = this.f4951g;
        final int i11 = 2;
        final int i12 = 1;
        final int i13 = 0;
        switch (i10) {
            case 0:
                j jVar = (j) d1Var;
                TextView textView = jVar.f4915w;
                TdClient$ExplorerItem tdClient$ExplorerItem = (TdClient$ExplorerItem) ((List) this.f4949e).get(i9);
                jVar.f4914v.setText(tdClient$ExplorerItem.getTitle());
                String description = tdClient$ExplorerItem.getDescription();
                List p02 = description != null ? h8.e.p0(description, new String[]{" • "}, 2) : o7.i.D0("Canal", "");
                jVar.f4916x.setText((CharSequence) p02.get(0));
                if (p02.size() <= 1 || h8.e.l0((CharSequence) p02.get(1))) {
                    textView.setVisibility(8);
                } else {
                    textView.setText((CharSequence) p02.get(1));
                    textView.setVisibility(0);
                }
                Date date = new Date(tdClient$ExplorerItem.getDate() * 1000);
                jVar.f4917y.setText(System.currentTimeMillis() - (((long) tdClient$ExplorerItem.getDate()) * 1000) < 86400000 ? t.a.b("Hoy ", ((SimpleDateFormat) obj).format(date)) : new SimpleDateFormat("dd/MM HH:mm", Locale.getDefault()).format(date));
                long currentTimeMillis = System.currentTimeMillis() - (tdClient$ExplorerItem.getDate() * 1000);
                TextView textView2 = jVar.f4918z;
                if (currentTimeMillis < 14400000) {
                    textView2.setVisibility(0);
                } else {
                    textView2.setVisibility(8);
                }
                Chip chip = jVar.A;
                int i14 = k.f4934a[tdClient$ExplorerItem.getType().ordinal()];
                int i15 = 3;
                chip.setText(i14 != 1 ? i14 != 2 ? i14 != 3 ? tdClient$ExplorerItem.getType().name() : "ENLACE" : "IMAGEN" : "VIDEO");
                if (tdClient$ExplorerItem.getThumbnailFileId() != 0) {
                    DiscoveryActivity discoveryActivity = (DiscoveryActivity) this.h;
                    int i16 = DiscoveryActivity.J;
                    ((h7.k0) discoveryActivity.F.a()).c(tdClient$ExplorerItem.getThumbnailFileId(), new b7.b(jVar, i15));
                } else {
                    jVar.f4913u.setImageResource(R.color.black);
                }
                jVar.f7618a.setOnClickListener(new b(this, i12, tdClient$ExplorerItem));
                break;
            case 1:
                j7.q qVar = (j7.q) d1Var;
                final Playlist playlist = (Playlist) ((List) this.f4949e).get(i9);
                qVar.f5488u.setText(playlist.getName());
                qVar.f5489v.setText(playlist.getItems().size() + " pistas locales");
                View view = qVar.f5492y;
                view.setOnClickListener(new View.OnClickListener(this) { // from class: j7.p

                    /* renamed from: j, reason: collision with root package name */
                    public final /* synthetic */ i7.l f5486j;

                    {
                        this.f5486j = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        switch (i13) {
                            case 0:
                                ((q3) this.f5486j.f4950f).a(playlist);
                                break;
                            case 1:
                                ((q3) this.f5486j.f4951g).a(playlist);
                                break;
                            default:
                                ((q3) this.f5486j.h).a(playlist);
                                break;
                        }
                    }
                });
                ImageView imageView = qVar.f5490w;
                imageView.setOnClickListener(new View.OnClickListener(this) { // from class: j7.p

                    /* renamed from: j, reason: collision with root package name */
                    public final /* synthetic */ i7.l f5486j;

                    {
                        this.f5486j = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        switch (i12) {
                            case 0:
                                ((q3) this.f5486j.f4950f).a(playlist);
                                break;
                            case 1:
                                ((q3) this.f5486j.f4951g).a(playlist);
                                break;
                            default:
                                ((q3) this.f5486j.h).a(playlist);
                                break;
                        }
                    }
                });
                ImageView imageView2 = qVar.f5491x;
                imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: j7.p

                    /* renamed from: j, reason: collision with root package name */
                    public final /* synthetic */ i7.l f5486j;

                    {
                        this.f5486j = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        switch (i11) {
                            case 0:
                                ((q3) this.f5486j.f4950f).a(playlist);
                                break;
                            case 1:
                                ((q3) this.f5486j.f4951g).a(playlist);
                                break;
                            default:
                                ((q3) this.f5486j.h).a(playlist);
                                break;
                        }
                    }
                });
                j7.i iVar = new j7.i(2);
                view.setOnFocusChangeListener(iVar);
                imageView.setOnFocusChangeListener(iVar);
                imageView2.setOnFocusChangeListener(iVar);
                break;
            default:
                l3.l lVar = (l3.l) d1Var;
                boolean f9 = f(i9);
                View view2 = lVar.f7618a;
                if (f9) {
                    view2.setLayoutParams(new o3.p0(-1, -2));
                } else {
                    view2.setLayoutParams(new o3.p0(0, 0));
                }
                lVar.f6165u.setText(((String[]) this.f4950f)[i9]);
                String str = ((String[]) this.f4949e)[i9];
                TextView textView3 = lVar.f6166v;
                if (str == null) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setText(str);
                }
                Drawable drawable = ((Drawable[]) obj)[i9];
                ImageView imageView3 = lVar.f6167w;
                if (drawable != null) {
                    imageView3.setImageDrawable(drawable);
                    break;
                } else {
                    imageView3.setVisibility(8);
                    break;
                }
        }
    }

    @Override // o3.g0
    public final o3.d1 e(ViewGroup viewGroup) {
        switch (this.f4948d) {
            case 0:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558471, viewGroup, false);
                inflate.getClass();
                return new j(inflate);
            case 1:
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(2131558478, viewGroup, false);
                inflate2.getClass();
                return new j7.q(inflate2);
            default:
                l3.q qVar = (l3.q) this.h;
                return new l3.l(qVar, LayoutInflater.from(qVar.getContext()).inflate(2131558465, viewGroup, false));
        }
    }

    public boolean f(int i9) {
        l3.q qVar = (l3.q) this.h;
        d1.t0 t0Var = qVar.f6206p0;
        if (t0Var == null) {
            return false;
        }
        return i9 != 0 ? i9 != 1 || (t0Var.J(30) && qVar.f6206p0.J(29)) : t0Var.J(13);
    }

    public l(q3 q3Var, q3 q3Var2, q3 q3Var3) {
        this.f4948d = 1;
        this.f4949e = o7.p.f8013i;
        this.f4950f = q3Var;
        this.f4951g = q3Var2;
        this.h = q3Var3;
    }

    public l(l3.q qVar, String[] strArr, Drawable[] drawableArr) {
        this.f4948d = 2;
        this.h = qVar;
        this.f4950f = strArr;
        this.f4949e = new String[strArr.length];
        this.f4951g = drawableArr;
    }
}
