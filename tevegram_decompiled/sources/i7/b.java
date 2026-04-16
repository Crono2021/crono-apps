package i7;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.data.SearchHistoryManager$QuickSearchItem;
import com.network.tvgramplayer.player.PlayerManager;
import com.network.tvgramplayer.telegram.TdClient$ExplorerItem;
import com.network.tvgramplayer.ui.LoginActivity;
import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import com.network.tvgramplayer.util.SubscriptionItem;
import java.util.List;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4771i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f4772j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f4773k;

    public /* synthetic */ b(Object obj, int i9, Object obj2) {
        this.f4771i = i9;
        this.f4772j = obj;
        this.f4773k = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i9 = this.f4771i;
        int i10 = 1;
        Object obj = this.f4773k;
        Object obj2 = this.f4772j;
        switch (i9) {
            case 0:
                h hVar = (h) obj2;
                i8.w.j(androidx.lifecycle.g0.a(hVar.f4872a), null, new g(hVar, (g.k) obj, (List) hVar.f4873b.A.d(), (List) ((l8.d) hVar.f4874c.f32k).d(), null), 3);
                return;
            case 1:
                ((i) ((l) obj2).f4950f).a((TdClient$ExplorerItem) obj);
                return;
            case 2:
                ((n0) ((x) obj2).f5179j).d();
                ((g.k) obj).dismiss();
                return;
            case 3:
                ((g0) obj2).f4866e.a((h7.i0) obj);
                return;
            case 4:
                LoginActivity loginActivity = (LoginActivity) obj2;
                h7.k0 k0Var = (h7.k0) obj;
                l8.d dVar = k0Var.f4136f;
                c7.c cVar = loginActivity.E;
                if (cVar == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((Button) cVar.f1660c).setEnabled(false);
                c7.c cVar2 = loginActivity.E;
                if (cVar2 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                int visibility = ((LinearLayout) cVar2.f1667k).getVisibility();
                c7.c cVar3 = loginActivity.E;
                if (visibility == 0) {
                    if (cVar3 == null) {
                        b8.i.d("binding");
                        throw null;
                    }
                    ((RadioButton) cVar3.f1669m).setChecked(true);
                    c7.c cVar4 = loginActivity.E;
                    if (cVar4 != null) {
                        ((Button) cVar4.f1660c).setEnabled(true);
                        return;
                    } else {
                        b8.i.d("binding");
                        throw null;
                    }
                }
                if (cVar3 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                int visibility2 = ((TextInputLayout) cVar3.f1662e).getVisibility();
                c7.c cVar5 = loginActivity.E;
                if (visibility2 == 0) {
                    if (cVar5 == null) {
                        b8.i.d("binding");
                        throw null;
                    }
                    String valueOf = String.valueOf(((TextInputEditText) cVar5.h).getText());
                    if (valueOf.length() > 0) {
                        dVar.e(null);
                        Client client = k0Var.f4141l;
                        if (client != null) {
                            client.send(new TdApi.CheckAuthenticationPassword(valueOf), new h7.f(k0Var, 7));
                            return;
                        }
                        return;
                    }
                    c7.c cVar6 = loginActivity.E;
                    if (cVar6 != null) {
                        ((Button) cVar6.f1660c).setEnabled(true);
                        return;
                    } else {
                        b8.i.d("binding");
                        throw null;
                    }
                }
                if (cVar5 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                int visibility3 = ((TextInputLayout) cVar5.f1661d).getVisibility();
                c7.c cVar7 = loginActivity.E;
                if (visibility3 == 0) {
                    if (cVar7 == null) {
                        b8.i.d("binding");
                        throw null;
                    }
                    String valueOf2 = String.valueOf(((TextInputEditText) cVar7.f1664g).getText());
                    if (valueOf2.length() > 0) {
                        dVar.e(null);
                        Client client2 = k0Var.f4141l;
                        if (client2 != null) {
                            client2.send(new TdApi.CheckAuthenticationCode(valueOf2), new h7.f(k0Var, 8));
                            return;
                        }
                        return;
                    }
                    c7.c cVar8 = loginActivity.E;
                    if (cVar8 != null) {
                        ((Button) cVar8.f1660c).setEnabled(true);
                        return;
                    } else {
                        b8.i.d("binding");
                        throw null;
                    }
                }
                if (cVar7 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                String d02 = h8.m.d0(String.valueOf(((TextInputEditText) cVar7.f1665i).getText()), " ", "");
                if (d02.length() > 0) {
                    dVar.e(null);
                    Client client3 = k0Var.f4141l;
                    if (client3 != null) {
                        client3.send(new TdApi.SetAuthenticationPhoneNumber(d02, null), new h7.f(k0Var, 10));
                        return;
                    }
                    return;
                }
                c7.c cVar9 = loginActivity.E;
                if (cVar9 != null) {
                    ((Button) cVar9.f1660c).setEnabled(true);
                    return;
                } else {
                    b8.i.d("binding");
                    throw null;
                }
            case 5:
                MainActivity mainActivity = (MainActivity) obj2;
                int i11 = MainActivity.X;
                new g.j(mainActivity).setTitle("Limpiar Caché").c("¿Estás seguro de que quieres borrar todos los archivos temporales de Telegram? Esto liberará espacio en disco.").g("Borrar", new t0(mainActivity, (TextView) obj, i10)).d("Cancelar", null).h();
                return;
            case 6:
                MainActivity.D((MainActivity) obj, (k7.a) obj2);
                return;
            case 7:
                MediaExplorerActivity mediaExplorerActivity = (MediaExplorerActivity) obj2;
                String str = (String) obj;
                c7.b bVar = mediaExplorerActivity.E;
                if (bVar == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((EditText) bVar.f1653g).setText(str);
                mediaExplorerActivity.U = str;
                mediaExplorerActivity.v();
                mediaExplorerActivity.w(true);
                return;
            case 8:
                ((m0) ((b4) obj2).f4795f).a((SearchHistoryManager$QuickSearchItem) obj);
                return;
            case 9:
                ((j7.b) obj2).f5439e.a((PlayerManager.AudioTrack) obj);
                return;
            case 10:
                ((m0) ((w) obj2).f5166f).a((Playlist) obj);
                return;
            case 11:
                ((m0) ((b4) obj2).f4795f).a((SubscriptionItem) obj);
                return;
            default:
                ((j7.t) obj2).f5498e.a((PlayerManager.SubtitleTrack) obj);
                return;
        }
    }
}
