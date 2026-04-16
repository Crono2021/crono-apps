package i7;

import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.network.tvgramplayer.ui.MainActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class w0 implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5167i = 0;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ k7.a f5168j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ MainActivity f5169k;

    public /* synthetic */ w0(MainActivity mainActivity, k7.a aVar) {
        this.f5169k = mainActivity;
        this.f5168j = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i9) {
        int i10 = this.f5167i;
        MainActivity mainActivity = this.f5169k;
        k7.a aVar = this.f5168j;
        switch (i10) {
            case 0:
                int i11 = MainActivity.X;
                EditText editText = new EditText(mainActivity);
                editText.setHint("ej: vlc, smb, nfs");
                editText.setSingleLine();
                int i12 = (int) (16 * mainActivity.getResources().getDisplayMetrics().density);
                FrameLayout frameLayout = new FrameLayout(mainActivity);
                frameLayout.setPadding(i12, i12 / 2, i12, 0);
                frameLayout.addView(editText);
                k5.b n4 = new k5.b(mainActivity, 0).m("Nuevo Esquema").n(frameLayout);
                n4.l("Añadir", new b1(editText, aVar, mainActivity, 1));
                n4.j("Cancelar", new w0(aVar, mainActivity));
                n4.h();
                break;
            default:
                MainActivity.D(mainActivity, aVar);
                break;
        }
    }

    public /* synthetic */ w0(k7.a aVar, MainActivity mainActivity) {
        this.f5168j = aVar;
        this.f5169k = mainActivity;
    }
}
