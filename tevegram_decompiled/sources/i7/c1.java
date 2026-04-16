package i7;

import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;
import com.network.tvgramplayer.ui.LiveStreamActivity;
import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import com.network.tvgramplayer.util.SubscriptionItem;
import java.util.ArrayList;
import java.util.Collection;
import tv.danmaku.ijk.media.player.IjkMediaMetadataRetriever;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class c1 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ MainActivity f4801i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f4802j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f4803k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f4804l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f4805m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f4806n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f4807o;

    public /* synthetic */ c1(long j5, MainActivity mainActivity, String str, String str2, String str3, String str4, String str5) {
        this.f4801i = mainActivity;
        this.f4802j = str;
        this.f4803k = str2;
        this.f4804l = j5;
        this.f4805m = str3;
        this.f4806n = str4;
        this.f4807o = str5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final MainActivity mainActivity = this.f4801i;
        mainActivity.U = false;
        String[] strArr = {"🔴 Ver Livestream Activo", "▶️ Explorar Videos (VOD)", "⭐ Suscribirse a este Canal"};
        g.j jVar = new g.j(mainActivity);
        final String str = this.f4802j;
        final String str2 = this.f4803k;
        String str3 = str == null ? str2 : str;
        final long j5 = this.f4804l;
        final String str4 = this.f4805m;
        final String str5 = this.f4806n;
        final String str6 = this.f4807o;
        g.k create = jVar.setTitle(str3).b(strArr, new DialogInterface.OnClickListener() { // from class: i7.d1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i9) {
                int i10 = MainActivity.X;
                MainActivity mainActivity2 = mainActivity;
                long j9 = j5;
                String str7 = str;
                String str8 = str2;
                String str9 = str4;
                String str10 = str5;
                if (i9 == 0) {
                    mainActivity2.s("> Opción: Ver Livestream");
                    Intent intent = new Intent(mainActivity2, (Class<?>) LiveStreamActivity.class);
                    intent.putExtra("chat_id", j9);
                    if (str7 == null) {
                        str7 = str8;
                    }
                    intent.putExtra(IjkMediaMetadataRetriever.METADATA_KEY_TITLE, str7);
                    intent.putExtra("invite_link", str9);
                    intent.putExtra("EXTRA_CHAT_TYPE", str10);
                    mainActivity2.startActivity(intent);
                    return;
                }
                if (i9 == 1) {
                    mainActivity2.s("> Opción: Explorar Canal");
                    Intent intent2 = new Intent(mainActivity2, (Class<?>) MediaExplorerActivity.class);
                    intent2.putExtra("chat_id", j9);
                    if (str7 == null) {
                        str7 = str8;
                    }
                    intent2.putExtra("chat_title", str7);
                    intent2.putExtra("EXTRA_CHAT_TYPE", str10);
                    mainActivity2.startActivity(intent2);
                    return;
                }
                if (i9 != 2) {
                    return;
                }
                mainActivity2.s("> Opción: Suscribirse");
                if (str7 == null) {
                    str7 = str8;
                }
                String str11 = str6;
                SubscriptionItem subscriptionItem = new SubscriptionItem(j9, str11 == null ? str9 : str11, str7, 0L, false, false, null, 120, null);
                a0.l lVar = mainActivity2.J;
                if (lVar == null) {
                    b8.i.d("subscriptionManager");
                    throw null;
                }
                Collection collection = (Collection) ((l8.d) lVar.f32k).d();
                collection.getClass();
                ArrayList arrayList = new ArrayList(collection);
                o7.n.F0(arrayList, new b7.b(subscriptionItem, 5));
                arrayList.add(0, subscriptionItem);
                lVar.v(arrayList);
                Toast.makeText(mainActivity2, "Suscripción guardada.", 0).show();
            }
        }).f(new e1(mainActivity, 0)).create();
        create.getClass();
        create.setOnShowListener(new f1(create, 0));
        create.show();
    }
}
