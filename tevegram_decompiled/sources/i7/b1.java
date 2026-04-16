package i7;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.gson.Gson;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.telegram.TdClient$ExplorerItem;
import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import com.network.tvgramplayer.ui.PlayerActivity;
import com.network.tvgramplayer.ui.PlaylistsActivity;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class b1 implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4776i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f4777j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f4778k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f4779l;

    public /* synthetic */ b1(Object obj, Object obj2, Object obj3, int i9) {
        this.f4776i = i9;
        this.f4777j = obj;
        this.f4778k = obj2;
        this.f4779l = obj3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i9) {
        Object obj;
        switch (this.f4776i) {
            case 0:
                String[] strArr = (String[]) this.f4777j;
                b8.m mVar = (b8.m) this.f4778k;
                Button button = (Button) this.f4779l;
                int i10 = MainActivity.X;
                button.setText("Grupo: " + strArr[mVar.f1523i]);
                dialogInterface.dismiss();
                return;
            case 1:
                EditText editText = (EditText) this.f4777j;
                k7.a aVar = (k7.a) this.f4778k;
                SharedPreferences sharedPreferences = aVar.f5628b;
                MainActivity mainActivity = (MainActivity) this.f4779l;
                int i11 = MainActivity.X;
                String lowerCase = h8.e.u0(editText.getText().toString()).toString().toLowerCase(Locale.ROOT);
                lowerCase.getClass();
                if (lowerCase.length() > 0) {
                    Set<String> set = k7.a.f5626c;
                    Set<String> stringSet = sharedPreferences.getStringSet("enabled_uri_schemes", set);
                    if (stringSet != null) {
                        set = stringSet;
                    }
                    set.getClass();
                    LinkedHashSet linkedHashSet = new LinkedHashSet(o7.t.b0(set.size() + 1));
                    linkedHashSet.addAll(set);
                    linkedHashSet.add(lowerCase);
                    sharedPreferences.edit().putStringSet("enabled_uri_schemes", linkedHashSet).apply();
                    MainActivity.D(mainActivity, aVar);
                    return;
                }
                return;
            case 2:
                MediaExplorerActivity mediaExplorerActivity = (MediaExplorerActivity) this.f4777j;
                TdClient$ExplorerItem tdClient$ExplorerItem = (TdClient$ExplorerItem) this.f4778k;
                List list = (List) this.f4779l;
                a0.l lVar = mediaExplorerActivity.J;
                if (lVar != null) {
                    mediaExplorerActivity.z(tdClient$ExplorerItem, lVar, list, i9 == 1);
                    return;
                } else {
                    b8.i.d("playlistManager");
                    throw null;
                }
            case 3:
                MediaExplorerActivity mediaExplorerActivity2 = (MediaExplorerActivity) this.f4777j;
                b7.a aVar2 = (b7.a) this.f4778k;
                m2 m2Var = (m2) this.f4779l;
                a0.l lVar2 = mediaExplorerActivity2.J;
                if (lVar2 == null) {
                    b8.i.d("playlistManager");
                    throw null;
                }
                String json = new Gson().toJson(aVar2);
                json.getClass();
                if (lVar2.l(json)) {
                    m2Var.d();
                    return;
                }
                return;
            case 4:
                String[] strArr2 = (String[]) this.f4777j;
                b8.m mVar2 = (b8.m) this.f4778k;
                c7.f fVar = (c7.f) this.f4779l;
                int i12 = PlayerActivity.X;
                String str = strArr2[mVar2.f1523i];
                fVar.f1715a.setText("Grupo: " + str);
                dialogInterface.dismiss();
                return;
            case 5:
                EditText editText2 = (EditText) this.f4777j;
                Playlist playlist = (Playlist) this.f4778k;
                PlaylistsActivity playlistsActivity = (PlaylistsActivity) this.f4779l;
                int i13 = PlaylistsActivity.K;
                String obj2 = h8.e.u0(editText2.getText().toString()).toString();
                if (obj2.length() <= 0 || obj2.equals(playlist.getName())) {
                    return;
                }
                a0.l lVar3 = playlistsActivity.F;
                if (lVar3 == null) {
                    b8.i.d("playlistManager");
                    throw null;
                }
                String id = playlist.getId();
                synchronized (lVar3) {
                    try {
                        id.getClass();
                        ArrayList arrayList = (ArrayList) lVar3.f32k;
                        int size = arrayList.size();
                        int i14 = 0;
                        while (true) {
                            if (i14 < size) {
                                obj = arrayList.get(i14);
                                i14++;
                                if (b8.i.a(((Playlist) obj).getId(), id)) {
                                }
                            } else {
                                obj = null;
                            }
                        }
                        Playlist playlist2 = (Playlist) obj;
                        if (playlist2 != null) {
                            playlist2.setName(obj2);
                            playlist2.setLastModified(System.currentTimeMillis());
                            lVar3.w();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                c7.c cVar = playlistsActivity.E;
                if (cVar == null) {
                    b8.i.d("binding");
                    throw null;
                }
                cVar.f1670n.setText("Editando: ".concat(obj2));
                Toast.makeText(playlistsActivity, "Nombre actualizado", 0).show();
                return;
            default:
                PlaylistsActivity playlistsActivity2 = (PlaylistsActivity) this.f4777j;
                b7.a aVar3 = (b7.a) this.f4778k;
                s3 s3Var = (s3) this.f4779l;
                a0.l lVar4 = playlistsActivity2.F;
                if (lVar4 == null) {
                    b8.i.d("playlistManager");
                    throw null;
                }
                String json2 = new Gson().toJson(aVar3);
                json2.getClass();
                if (lVar4.l(json2)) {
                    playlistsActivity2.t();
                    s3Var.d();
                    return;
                }
                return;
        }
    }
}
