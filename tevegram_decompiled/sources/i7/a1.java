package i7;

import android.content.DialogInterface;
import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.ui.PlayerActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class a1 implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4754i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ b8.m f4755j;

    public /* synthetic */ a1(b8.m mVar, int i9) {
        this.f4754i = i9;
        this.f4755j = mVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i9) {
        int i10 = this.f4754i;
        b8.m mVar = this.f4755j;
        switch (i10) {
            case 0:
                int i11 = MainActivity.X;
                mVar.f1523i = i9;
                break;
            case 1:
                int i12 = PlayerActivity.X;
                mVar.f1523i = i9;
                break;
            default:
                int i13 = PlayerActivity.X;
                mVar.f1523i = i9;
                break;
        }
    }
}
