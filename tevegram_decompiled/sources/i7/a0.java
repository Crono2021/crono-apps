package i7;

import android.util.Log;
import com.google.gson.Gson;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.ui.LiveStreamActivity;
import com.network.tvgramplayer.ui.PlaylistsActivity;
import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CountDownLatch;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class a0 implements a8.l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4750i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f4751j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f4752k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f4753l;

    public /* synthetic */ a0(Object obj, Object obj2, Object obj3, int i9) {
        this.f4750i = i9;
        this.f4751j = obj;
        this.f4752k = obj2;
        this.f4753l = obj3;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        TdApi.Document document;
        int i9 = this.f4750i;
        final int i10 = 1;
        Object obj2 = this.f4753l;
        Object obj3 = this.f4752k;
        Object obj4 = this.f4751j;
        final int i11 = 0;
        switch (i9) {
            case 0:
                b8.n nVar = (b8.n) obj4;
                CountDownLatch countDownLatch = (CountDownLatch) obj3;
                LiveStreamActivity liveStreamActivity = (LiveStreamActivity) obj2;
                TdApi.VideoChatStreams videoChatStreams = (TdApi.VideoChatStreams) obj;
                int i12 = LiveStreamActivity.f2332a0;
                if (videoChatStreams != null) {
                    TdApi.VideoChatStream[] videoChatStreamArr = videoChatStreams.streams;
                    videoChatStreamArr.getClass();
                    if (videoChatStreamArr.length != 0) {
                        TdApi.VideoChatStream[] videoChatStreamArr2 = videoChatStreams.streams;
                        videoChatStreamArr2.getClass();
                        for (TdApi.VideoChatStream videoChatStream : videoChatStreamArr2) {
                            Log.i("LiveStreamActivity", "📺 Found Stream: ch=" + videoChatStream.channelId + ", scale=" + videoChatStream.scale);
                            m7.k kVar = liveStreamActivity.F;
                            if (kVar != null) {
                                kVar.f6736k.put(videoChatStream.channelId + "_0", Integer.valueOf(videoChatStream.scale));
                            }
                        }
                        TdApi.VideoChatStream[] videoChatStreamArr3 = videoChatStreams.streams;
                        videoChatStreamArr3.getClass();
                        if (videoChatStreamArr3.length == 0) {
                            throw new NoSuchElementException();
                        }
                        long j5 = videoChatStreamArr3[0].timeOffset;
                        int length = videoChatStreamArr3.length - 1;
                        if (1 <= length) {
                            while (true) {
                                long j9 = videoChatStreamArr3[i10].timeOffset;
                                if (j5 < j9) {
                                    j5 = j9;
                                }
                                if (i10 != length) {
                                    i10++;
                                }
                            }
                        }
                        nVar.f1524i = j5;
                    }
                }
                countDownLatch.countDown();
                return n7.g.f7490c;
            case 1:
                PlaylistsActivity playlistsActivity = (PlaylistsActivity) obj4;
                h7.k0 k0Var = (h7.k0) obj3;
                String str = (String) obj2;
                List list = (List) obj;
                int i13 = PlaylistsActivity.K;
                list.getClass();
                if (list.isEmpty()) {
                    playlistsActivity.runOnUiThread(new v3(playlistsActivity, 0));
                } else {
                    TdApi.MessageContent messageContent = ((TdApi.Message) o7.h.H0(list)).content;
                    TdApi.MessageDocument messageDocument = messageContent instanceof TdApi.MessageDocument ? (TdApi.MessageDocument) messageContent : null;
                    if (messageDocument != null && (document = messageDocument.document) != null) {
                        k0Var.c(document.document.id, new h7.c(playlistsActivity, 9, str));
                    }
                }
                return n7.g.f7490c;
            case 2:
                b8.m mVar = (b8.m) obj4;
                final PlaylistsActivity playlistsActivity2 = (PlaylistsActivity) obj3;
                String str2 = (String) obj2;
                String str3 = (String) obj;
                int i14 = PlaylistsActivity.K;
                mVar.f1523i--;
                if (str3 != null) {
                    try {
                        final b7.a aVar = (b7.a) new Gson().fromJson(com.bumptech.glide.c.P(new File(str3)), b7.a.class);
                        Playlist playlist = aVar.f1481d;
                        a0.l lVar = playlistsActivity2.F;
                        if (lVar == null) {
                            b8.i.d("playlistManager");
                            throw null;
                        }
                        Playlist k3 = lVar.k(str2);
                        if (k3 == null) {
                            Log.i("PlaylistsActivity", "✨ Nueva lista encontrada en nube: " + playlist.getName());
                            playlistsActivity2.runOnUiThread(new Runnable() { // from class: i7.w3
                                @Override // java.lang.Runnable
                                public final void run() {
                                    int i15 = i11;
                                    b7.a aVar2 = aVar;
                                    PlaylistsActivity playlistsActivity3 = playlistsActivity2;
                                    switch (i15) {
                                        case 0:
                                            int i16 = PlaylistsActivity.K;
                                            new g.j(playlistsActivity3).setTitle("Lista en la nube encontrada ☁️").c("¿Deseas importar '" + aVar2.f1481d.getName() + "' desde tu cuenta de Telegram?").g("Importar", new y3(playlistsActivity3, aVar2, 1)).d("Cerrar", null).h();
                                            break;
                                        default:
                                            int i17 = PlaylistsActivity.K;
                                            playlistsActivity3.y(aVar2);
                                            break;
                                    }
                                }
                            });
                        } else if (playlist.getLastModified() > k3.getLastModified()) {
                            Log.i("PlaylistsActivity", "🆙 Actualización disponible para: " + playlist.getName() + " (Cloud:" + playlist.getLastModified() + " > Local:" + k3.getLastModified() + ")");
                            playlistsActivity2.runOnUiThread(new Runnable() { // from class: i7.w3
                                @Override // java.lang.Runnable
                                public final void run() {
                                    int i15 = i10;
                                    b7.a aVar2 = aVar;
                                    PlaylistsActivity playlistsActivity3 = playlistsActivity2;
                                    switch (i15) {
                                        case 0:
                                            int i16 = PlaylistsActivity.K;
                                            new g.j(playlistsActivity3).setTitle("Lista en la nube encontrada ☁️").c("¿Deseas importar '" + aVar2.f1481d.getName() + "' desde tu cuenta de Telegram?").g("Importar", new y3(playlistsActivity3, aVar2, 1)).d("Cerrar", null).h();
                                            break;
                                        default:
                                            int i17 = PlaylistsActivity.K;
                                            playlistsActivity3.y(aVar2);
                                            break;
                                    }
                                }
                            });
                        }
                    } catch (Exception e9) {
                        Log.e("PlaylistsActivity", "⚠️ Error al procesar sync file: " + e9.getMessage());
                    }
                }
                if (mVar.f1523i <= 0) {
                    playlistsActivity2.w(false);
                }
                return n7.g.f7490c;
            default:
                PlaylistsActivity playlistsActivity3 = (PlaylistsActivity) obj4;
                String str4 = (String) obj3;
                s3 s3Var = (s3) obj2;
                String str5 = (String) obj;
                int i15 = PlaylistsActivity.K;
                playlistsActivity3.w(false);
                if (str5 != null) {
                    try {
                        b7.a aVar2 = (b7.a) new Gson().fromJson(com.bumptech.glide.c.P(new File(str5)), b7.a.class);
                        Playlist playlist2 = aVar2.f1481d;
                        a0.l lVar2 = playlistsActivity3.F;
                        if (lVar2 == null) {
                            b8.i.d("playlistManager");
                            throw null;
                        }
                        Playlist k9 = lVar2.k(str4);
                        if (k9 == null || playlist2.getLastModified() <= k9.getLastModified()) {
                            playlistsActivity3.runOnUiThread(new z3(s3Var, 2));
                        } else {
                            playlistsActivity3.runOnUiThread(new com.network.tvgramplayer.voip.a(playlistsActivity3, playlist2, aVar2, s3Var, 2));
                        }
                    } catch (Exception unused) {
                        playlistsActivity3.runOnUiThread(new z3(s3Var, 3));
                    }
                } else {
                    playlistsActivity3.runOnUiThread(new z3(s3Var, 4));
                }
                return n7.g.f7490c;
        }
    }
}
