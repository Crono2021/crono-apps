package i7;

import android.widget.Toast;
import com.network.tvgramplayer.data.HistoryItem;
import com.network.tvgramplayer.ui.MainActivity;
import i7.a2;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class u1 implements a8.r {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ MainActivity f5139i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f5140j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f5141k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f5142l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ h7.k0 f5143m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f5144n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ boolean f5145o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f5146p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ long f5147q;

    public /* synthetic */ u1(MainActivity mainActivity, String str, String str2, String str3, h7.k0 k0Var, String str4, boolean z8, String str5, long j5) {
        this.f5139i = mainActivity;
        this.f5140j = str;
        this.f5141k = str2;
        this.f5142l = str3;
        this.f5143m = k0Var;
        this.f5144n = str4;
        this.f5145o = z8;
        this.f5146p = str5;
        this.f5147q = j5;
    }

    @Override // a8.r
    public final void i(Object obj, Object obj2, Object obj3, Object obj4) {
        final String str = (String) obj;
        final Long l4 = (Long) obj2;
        final TdApi.File file = (TdApi.File) obj3;
        final String str2 = (String) obj4;
        final MainActivity mainActivity = this.f5139i;
        final String str3 = this.f5140j;
        final String str4 = this.f5141k;
        final String str5 = this.f5142l;
        final h7.k0 k0Var = this.f5143m;
        final String str6 = this.f5144n;
        final boolean z8 = this.f5145o;
        final String str7 = this.f5146p;
        final long j5 = this.f5147q;
        mainActivity.runOnUiThread(new Runnable() { // from class: i7.y1
            @Override // java.lang.Runnable
            public final void run() {
                final Long l9;
                MainActivity mainActivity2;
                String str8;
                String str9 = str;
                MainActivity mainActivity3 = mainActivity;
                if (str9 == null || (l9 = l4) == null) {
                    mainActivity3.s("> Invalid Link or Chat Not Found.");
                    mainActivity3.U = false;
                    return;
                }
                mainActivity3.s("> Chat Found: " + str9 + " (ID: " + l9 + ")");
                String str10 = str3;
                final String str11 = str4;
                String str12 = str10 == null ? str11 : str10;
                String str13 = str5;
                if (str13 != null) {
                    mainActivity2 = mainActivity3;
                    str8 = str13;
                } else if (str10 == null || !h8.e.g0(str10, "/play", false)) {
                    str8 = "join";
                    mainActivity2 = mainActivity3;
                } else {
                    mainActivity2 = mainActivity3;
                    str8 = "play";
                }
                String str14 = str12;
                String str15 = str2;
                MainActivity mainActivity4 = mainActivity2;
                HistoryItem historyItem = new HistoryItem(l9.longValue(), str14, str9, str9, str15, false, 0L, 0L, null, null, str8, 992, null);
                if (str8.equals("play")) {
                    a0.l lVar = mainActivity4.G;
                    if (lVar == null) {
                        b8.i.d("historyManager");
                        throw null;
                    }
                    lVar.b(historyItem);
                    mainActivity4.y();
                }
                Toast.makeText(mainActivity4, "Entrando a: " + str9 + "...", 0).show();
                mainActivity4.s("> Joining Chat...");
                String str16 = str6;
                TdApi.File file2 = file;
                final a2 a2Var = new a2(mainActivity4, file2, str13, str9, new z1(mainActivity4, l9, str16, str9, str11, str15, file2, str10, z8, str8, str7, j5), str11, str10, str16, str15);
                str11.getClass();
                long longValue = l9.longValue();
                final h7.k0 k0Var2 = k0Var;
                if (longValue != 0) {
                    Client client = k0Var2.f4141l;
                    if (client != null) {
                        client.send(new TdApi.JoinChat(l9.longValue()), new Client.ResultHandler() { // from class: h7.d0
                            @Override // org.drinkless.tdlib.Client.ResultHandler
                            public final void onResult(TdApi.Object object) {
                                int constructor = object.getConstructor();
                                a2 a2Var2 = a2.this;
                                Long l10 = l9;
                                if (constructor == -722616727) {
                                    a2Var2.a(l10);
                                    return;
                                }
                                if ((object instanceof TdApi.Error) && b8.i.a(((TdApi.Error) object).message, "USER_ALREADY_PARTICIPANT")) {
                                    a2Var2.a(l10);
                                    return;
                                }
                                String str17 = str11;
                                if (!h8.e.g0(str17, "+", false) && !h8.e.g0(str17, "joinchat/", false)) {
                                    a2Var2.a(l10);
                                    return;
                                }
                                Client client2 = k0Var2.f4141l;
                                if (client2 != null) {
                                    client2.send(new TdApi.JoinChatByInviteLink(str17), new e(a2Var2, 2, l10));
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (!h8.e.g0(str11, "+", false) && !h8.e.g0(str11, "joinchat/", false)) {
                    a2Var.a(null);
                    return;
                }
                Client client2 = k0Var2.f4141l;
                if (client2 != null) {
                    client2.send(new TdApi.JoinChatByInviteLink(str11), new h7.i(a2Var, k0Var2, str11, 2));
                }
            }
        });
    }
}
