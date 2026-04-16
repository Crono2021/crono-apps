package h7;

import android.util.Log;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.ui.PlaylistsActivity;
import i7.q3;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class u implements a8.l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4186i = 0;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ k0 f4187j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f4188k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f4189l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f4190m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f4191n;

    public /* synthetic */ u(a8.r rVar, TdApi.File file, String str, Long l4, k0 k0Var) {
        this.f4189l = rVar;
        this.f4190m = file;
        this.f4188k = str;
        this.f4191n = l4;
        this.f4187j = k0Var;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        Iterable iterable;
        int i9 = this.f4186i;
        Object obj2 = this.f4191n;
        String str = this.f4188k;
        Object obj3 = this.f4190m;
        Object obj4 = this.f4189l;
        k0 k0Var = this.f4187j;
        switch (i9) {
            case 0:
                a8.r rVar = (a8.r) obj4;
                TdApi.File file = (TdApi.File) obj3;
                Long l4 = (Long) obj2;
                TdApi.Chat chat = (TdApi.Chat) obj;
                TdApi.ChatType chatType = chat != null ? chat.type : null;
                k0Var.getClass();
                rVar.i(file, str, l4, k0.i(chatType));
                break;
            default:
                Playlist playlist = (Playlist) obj4;
                File file2 = (File) obj3;
                PlaylistsActivity playlistsActivity = (PlaylistsActivity) obj2;
                List list = (List) obj;
                int i10 = PlaylistsActivity.K;
                list.getClass();
                if (list.size() >= 5) {
                    int size = list.size() - 4;
                    if (size <= 0) {
                        iterable = o7.p.f8013i;
                    } else if (size == 1) {
                        iterable = android.support.v4.media.session.b.b0(o7.h.K0(list));
                    } else {
                        ArrayList arrayList = new ArrayList(size);
                        if (list instanceof RandomAccess) {
                            int size2 = list.size();
                            for (int i11 = 4; i11 < size2; i11++) {
                                arrayList.add(list.get(i11));
                            }
                        } else {
                            ListIterator listIterator = list.listIterator(4);
                            while (listIterator.hasNext()) {
                                arrayList.add(listIterator.next());
                            }
                        }
                        iterable = arrayList;
                    }
                    ArrayList arrayList2 = new ArrayList(o7.j.E0(iterable));
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(Long.valueOf(((TdApi.Message) it.next()).id));
                    }
                    int size3 = arrayList2.size();
                    long[] jArr = new long[size3];
                    int size4 = arrayList2.size();
                    int i12 = 0;
                    int i13 = 0;
                    while (i13 < size4) {
                        Object obj5 = arrayList2.get(i13);
                        i13++;
                        jArr[i12] = ((Number) obj5).longValue();
                        i12++;
                    }
                    long j5 = k0Var.f4139j;
                    Client client = k0Var.f4141l;
                    if (client != null) {
                        client.send(new TdApi.DeleteMessages(j5, jArr, true), new androidx.fragment.app.a(27));
                    }
                    Log.i("PlaylistsActivity", "🧹 Limpiados " + size3 + " backups antiguos en la nube para " + playlist.getName() + ".");
                }
                k0Var.C(file2, str + " (Sync: " + playlist.getName() + ")", new q3(playlistsActivity, 8));
                break;
        }
        return n7.g.f7490c;
    }

    public /* synthetic */ u(k0 k0Var, Playlist playlist, File file, String str, PlaylistsActivity playlistsActivity) {
        this.f4187j = k0Var;
        this.f4189l = playlist;
        this.f4190m = file;
        this.f4188k = str;
        this.f4191n = playlistsActivity;
    }
}
