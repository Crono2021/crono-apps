package i7;

import android.widget.Toast;
import com.network.tvgramplayer.ui.MainActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class s0 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5100i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ MainActivity f5101j;

    public /* synthetic */ s0(MainActivity mainActivity, int i9) {
        this.f5100i = i9;
        this.f5101j = mainActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5100i) {
            case 0:
                MainActivity mainActivity = this.f5101j;
                int i9 = MainActivity.X;
                if (mainActivity.isFinishing() || mainActivity.isDestroyed()) {
                    return;
                }
                synchronized (mainActivity.R) {
                    if (mainActivity.R.length() == 0) {
                        mainActivity.T = false;
                    } else {
                        String sb = mainActivity.R.toString();
                        mainActivity.R.setLength(0);
                        mainActivity.T = false;
                        c7.d dVar = mainActivity.E;
                        if (dVar == null) {
                            b8.i.d("binding");
                            throw null;
                        }
                        CharSequence text = dVar.D.getText();
                        if (text.length() > 5000) {
                            c7.d dVar2 = mainActivity.E;
                            if (dVar2 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            dVar2.D.setText(text.subSequence(text.length() - 2000, text.length()));
                        }
                        c7.d dVar3 = mainActivity.E;
                        if (dVar3 == null) {
                            b8.i.d("binding");
                            throw null;
                        }
                        dVar3.D.append(sb);
                        c7.d dVar4 = mainActivity.E;
                        if (dVar4 == null) {
                            b8.i.d("binding");
                            throw null;
                        }
                        if (dVar4.f1693x.getVisibility() == 0) {
                            c7.d dVar5 = mainActivity.E;
                            if (dVar5 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            dVar5.f1693x.post(new s0(mainActivity, 2));
                        }
                    }
                }
                return;
            case 1:
                MainActivity mainActivity2 = this.f5101j;
                int i10 = MainActivity.X;
                Toast.makeText(mainActivity2, "No hay app para este enlace", 0).show();
                return;
            case 2:
                MainActivity mainActivity3 = this.f5101j;
                int i11 = MainActivity.X;
                if (mainActivity3.isFinishing() || mainActivity3.isDestroyed()) {
                    return;
                }
                c7.d dVar6 = mainActivity3.E;
                if (dVar6 != null) {
                    dVar6.f1693x.fullScroll(130);
                    return;
                } else {
                    b8.i.d("binding");
                    throw null;
                }
            case 3:
                MainActivity mainActivity4 = this.f5101j;
                c7.d dVar7 = mainActivity4.E;
                if (dVar7 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                dVar7.f1685p.setVisibility(8);
                c7.d dVar8 = mainActivity4.E;
                if (dVar8 != null) {
                    dVar8.f1683n.requestFocus();
                    return;
                } else {
                    b8.i.d("binding");
                    throw null;
                }
            default:
                Toast.makeText(this.f5101j, "Error: Componentes nativos no cargados", 1).show();
                return;
        }
    }
}
