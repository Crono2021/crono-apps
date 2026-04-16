package i7;

import com.google.gson.Gson;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import java.io.File;
import java.util.List;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class n2 implements a8.l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4992i = 0;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ MediaExplorerActivity f4993j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f4994k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ m2 f4995l;

    public /* synthetic */ n2(MediaExplorerActivity mediaExplorerActivity, m2 m2Var, String str) {
        this.f4993j = mediaExplorerActivity;
        this.f4995l = m2Var;
        this.f4994k = str;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        TdApi.Document document;
        int i9 = this.f4992i;
        String str = this.f4994k;
        switch (i9) {
            case 0:
                List list = (List) obj;
                int i10 = MediaExplorerActivity.Y;
                list.getClass();
                boolean isEmpty = list.isEmpty();
                MediaExplorerActivity mediaExplorerActivity = this.f4993j;
                final m2 m2Var = this.f4995l;
                if (isEmpty) {
                    final int i11 = 0;
                    mediaExplorerActivity.runOnUiThread(new Runnable() { // from class: i7.o2
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i12 = i11;
                            m2 m2Var2 = m2Var;
                            switch (i12) {
                                case 0:
                                    int i13 = MediaExplorerActivity.Y;
                                    m2Var2.d();
                                    break;
                                case 1:
                                    int i14 = MediaExplorerActivity.Y;
                                    m2Var2.d();
                                    break;
                                case 2:
                                    int i15 = MediaExplorerActivity.Y;
                                    m2Var2.d();
                                    break;
                                case 3:
                                    int i16 = MediaExplorerActivity.Y;
                                    m2Var2.d();
                                    break;
                                default:
                                    int i17 = MediaExplorerActivity.Y;
                                    m2Var2.d();
                                    break;
                            }
                        }
                    });
                } else {
                    TdApi.MessageContent messageContent = ((TdApi.Message) o7.h.H0(list)).content;
                    TdApi.MessageDocument messageDocument = messageContent instanceof TdApi.MessageDocument ? (TdApi.MessageDocument) messageContent : null;
                    if (messageDocument == null || (document = messageDocument.document) == null) {
                        final int i12 = 1;
                        mediaExplorerActivity.runOnUiThread(new Runnable() { // from class: i7.o2
                            @Override // java.lang.Runnable
                            public final void run() {
                                int i122 = i12;
                                m2 m2Var2 = m2Var;
                                switch (i122) {
                                    case 0:
                                        int i13 = MediaExplorerActivity.Y;
                                        m2Var2.d();
                                        break;
                                    case 1:
                                        int i14 = MediaExplorerActivity.Y;
                                        m2Var2.d();
                                        break;
                                    case 2:
                                        int i15 = MediaExplorerActivity.Y;
                                        m2Var2.d();
                                        break;
                                    case 3:
                                        int i16 = MediaExplorerActivity.Y;
                                        m2Var2.d();
                                        break;
                                    default:
                                        int i17 = MediaExplorerActivity.Y;
                                        m2Var2.d();
                                        break;
                                }
                            }
                        });
                    } else {
                        mediaExplorerActivity.u().c(document.document.id, new n2(mediaExplorerActivity, str, m2Var));
                    }
                }
                return n7.g.f7490c;
            default:
                String str2 = (String) obj;
                int i13 = MediaExplorerActivity.Y;
                MediaExplorerActivity mediaExplorerActivity2 = this.f4993j;
                final m2 m2Var2 = this.f4995l;
                if (str2 != null) {
                    try {
                        b7.a aVar = (b7.a) new Gson().fromJson(com.bumptech.glide.c.P(new File(str2)), b7.a.class);
                        Playlist playlist = aVar.f1481d;
                        a0.l lVar = mediaExplorerActivity2.J;
                        if (lVar == null) {
                            b8.i.d("playlistManager");
                            throw null;
                        }
                        Playlist k3 = lVar.k(str);
                        if (k3 == null || playlist.getLastModified() <= k3.getLastModified()) {
                            final int i14 = 2;
                            mediaExplorerActivity2.runOnUiThread(new Runnable() { // from class: i7.o2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    int i122 = i14;
                                    m2 m2Var22 = m2Var2;
                                    switch (i122) {
                                        case 0:
                                            int i132 = MediaExplorerActivity.Y;
                                            m2Var22.d();
                                            break;
                                        case 1:
                                            int i142 = MediaExplorerActivity.Y;
                                            m2Var22.d();
                                            break;
                                        case 2:
                                            int i15 = MediaExplorerActivity.Y;
                                            m2Var22.d();
                                            break;
                                        case 3:
                                            int i16 = MediaExplorerActivity.Y;
                                            m2Var22.d();
                                            break;
                                        default:
                                            int i17 = MediaExplorerActivity.Y;
                                            m2Var22.d();
                                            break;
                                    }
                                }
                            });
                        } else {
                            mediaExplorerActivity2.runOnUiThread(new p2(mediaExplorerActivity2, k3, playlist, aVar, m2Var2, 0));
                        }
                    } catch (Exception unused) {
                        final int i15 = 3;
                        mediaExplorerActivity2.runOnUiThread(new Runnable() { // from class: i7.o2
                            @Override // java.lang.Runnable
                            public final void run() {
                                int i122 = i15;
                                m2 m2Var22 = m2Var2;
                                switch (i122) {
                                    case 0:
                                        int i132 = MediaExplorerActivity.Y;
                                        m2Var22.d();
                                        break;
                                    case 1:
                                        int i142 = MediaExplorerActivity.Y;
                                        m2Var22.d();
                                        break;
                                    case 2:
                                        int i152 = MediaExplorerActivity.Y;
                                        m2Var22.d();
                                        break;
                                    case 3:
                                        int i16 = MediaExplorerActivity.Y;
                                        m2Var22.d();
                                        break;
                                    default:
                                        int i17 = MediaExplorerActivity.Y;
                                        m2Var22.d();
                                        break;
                                }
                            }
                        });
                    }
                } else {
                    final int i16 = 4;
                    mediaExplorerActivity2.runOnUiThread(new Runnable() { // from class: i7.o2
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i122 = i16;
                            m2 m2Var22 = m2Var2;
                            switch (i122) {
                                case 0:
                                    int i132 = MediaExplorerActivity.Y;
                                    m2Var22.d();
                                    break;
                                case 1:
                                    int i142 = MediaExplorerActivity.Y;
                                    m2Var22.d();
                                    break;
                                case 2:
                                    int i152 = MediaExplorerActivity.Y;
                                    m2Var22.d();
                                    break;
                                case 3:
                                    int i162 = MediaExplorerActivity.Y;
                                    m2Var22.d();
                                    break;
                                default:
                                    int i17 = MediaExplorerActivity.Y;
                                    m2Var22.d();
                                    break;
                            }
                        }
                    });
                }
                return n7.g.f7490c;
        }
    }

    public /* synthetic */ n2(MediaExplorerActivity mediaExplorerActivity, String str, m2 m2Var) {
        this.f4993j = mediaExplorerActivity;
        this.f4994k = str;
        this.f4995l = m2Var;
    }
}
