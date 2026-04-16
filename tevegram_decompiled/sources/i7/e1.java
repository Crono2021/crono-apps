package i7;

import android.content.DialogInterface;
import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.ui.PlayerActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class e1 implements DialogInterface.OnCancelListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4830i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f4831j;

    public /* synthetic */ e1(Object obj, int i9) {
        this.f4830i = i9;
        this.f4831j = obj;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        int i9 = this.f4830i;
        Object obj = this.f4831j;
        switch (i9) {
            case 0:
                int i10 = MainActivity.X;
                ((MainActivity) obj).s("> Cancelado por el usuario.");
                break;
            default:
                int i11 = PlayerActivity.X;
                ((e3) obj).a(0L);
                break;
        }
    }
}
