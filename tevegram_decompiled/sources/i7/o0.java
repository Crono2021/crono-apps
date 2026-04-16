package i7;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.network.tvgramplayer.ui.MainActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class o0 implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5001i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ MainActivity f5002j;

    public /* synthetic */ o0(MainActivity mainActivity, int i9) {
        this.f5001i = i9;
        this.f5002j = mainActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i9) {
        int i10 = this.f5001i;
        MainActivity mainActivity = this.f5002j;
        switch (i10) {
            case 0:
                int i11 = MainActivity.X;
                mainActivity.t().s();
                break;
            case 1:
                int i12 = MainActivity.X;
                new g.j(mainActivity).setTitle("Confirmar Desconexión").c("Esto cerrará la sesión actual y limpiará el cliente para permitir un nuevo inicio limpio. ¿Continuar?").g("Sí, Desconectar", new o0(mainActivity, 3)).d("No", null).h();
                break;
            case 2:
                int i13 = MainActivity.X;
                mainActivity.s("> Reintentando conexión manualmente...");
                mainActivity.t().o();
                break;
            case 3:
                int i14 = MainActivity.X;
                mainActivity.t().s();
                break;
            case 4:
                int i15 = MainActivity.X;
                try {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.parse("package:" + mainActivity.getPackageName()));
                    mainActivity.startActivity(intent);
                    break;
                } catch (Exception unused) {
                    Toast.makeText(mainActivity, "No se pudo abrir ajustes", 0).show();
                    return;
                }
            default:
                int i16 = MainActivity.X;
                mainActivity.z();
                mainActivity.s("> Favoritos de home actualizados.");
                break;
        }
    }
}
