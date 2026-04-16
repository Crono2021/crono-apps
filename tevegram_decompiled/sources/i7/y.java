package i7;

import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.network.tvgramplayer.ui.LiveStreamActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class y implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5202i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ LiveStreamActivity f5203j;

    public /* synthetic */ y(LiveStreamActivity liveStreamActivity, int i9) {
        this.f5202i = i9;
        this.f5203j = liveStreamActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String sb;
        switch (this.f5202i) {
            case 0:
                LiveStreamActivity liveStreamActivity = this.f5203j;
                c7.b bVar = liveStreamActivity.E;
                if (bVar == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((LinearLayout) bVar.f1648b).setVisibility(8);
                Log.i("LiveStreamActivity", "🎬 First segment signal!");
                if (liveStreamActivity.J) {
                    i8.d1 d1Var = liveStreamActivity.M;
                    if (d1Var != null) {
                        i8.w.c(d1Var);
                    }
                    liveStreamActivity.M = i8.w.j(androidx.lifecycle.g0.a(liveStreamActivity), null, new b7.c(liveStreamActivity, null), 3);
                    return;
                }
                return;
            case 1:
                LiveStreamActivity liveStreamActivity2 = this.f5203j;
                int i9 = LiveStreamActivity.f2332a0;
                if (liveStreamActivity2.isFinishing() || liveStreamActivity2.isDestroyed()) {
                    return;
                }
                synchronized (liveStreamActivity2.R) {
                    sb = liveStreamActivity2.R.toString();
                    liveStreamActivity2.R.setLength(0);
                    liveStreamActivity2.T = false;
                }
                c7.b bVar2 = liveStreamActivity2.E;
                if (bVar2 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                CharSequence text = ((TextView) bVar2.f1649c).getText();
                if (text.length() > 5000) {
                    c7.b bVar3 = liveStreamActivity2.E;
                    if (bVar3 == null) {
                        b8.i.d("binding");
                        throw null;
                    }
                    ((TextView) bVar3.f1649c).setText(text.subSequence(text.length() - 2500, text.length()));
                }
                c7.b bVar4 = liveStreamActivity2.E;
                if (bVar4 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((TextView) bVar4.f1649c).append(sb);
                c7.b bVar5 = liveStreamActivity2.E;
                if (bVar5 != null) {
                    ((ScrollView) bVar5.f1654i).post(new y(liveStreamActivity2, 4));
                    return;
                } else {
                    b8.i.d("binding");
                    throw null;
                }
            case 2:
                LiveStreamActivity liveStreamActivity3 = this.f5203j;
                int i10 = LiveStreamActivity.f2332a0;
                liveStreamActivity3.x();
                return;
            case 3:
                LiveStreamActivity liveStreamActivity4 = this.f5203j;
                c7.b bVar6 = liveStreamActivity4.E;
                if (bVar6 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((LinearLayout) bVar6.f1648b).setVisibility(8);
                c7.b bVar7 = liveStreamActivity4.E;
                if (bVar7 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((ScrollView) bVar7.f1654i).setVisibility(8);
                liveStreamActivity4.v();
                return;
            case 4:
                LiveStreamActivity liveStreamActivity5 = this.f5203j;
                int i11 = LiveStreamActivity.f2332a0;
                if (liveStreamActivity5.isFinishing() || liveStreamActivity5.isDestroyed()) {
                    return;
                }
                c7.b bVar8 = liveStreamActivity5.E;
                if (bVar8 != null) {
                    ((ScrollView) bVar8.f1654i).fullScroll(130);
                    return;
                } else {
                    b8.i.d("binding");
                    throw null;
                }
            case 5:
                c7.b bVar9 = this.f5203j.E;
                if (bVar9 != null) {
                    ((LinearLayout) bVar9.f1648b).setVisibility(8);
                    return;
                } else {
                    b8.i.d("binding");
                    throw null;
                }
            case 6:
                LiveStreamActivity liveStreamActivity6 = this.f5203j;
                c7.b bVar10 = liveStreamActivity6.E;
                if (bVar10 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((LinearLayout) bVar10.f1648b).setVisibility(0);
                c7.b bVar11 = liveStreamActivity6.E;
                if (bVar11 != null) {
                    ((TextView) bVar11.f1656k).setText("Esperando a que el directo comience...");
                    return;
                } else {
                    b8.i.d("binding");
                    throw null;
                }
            case 7:
                LiveStreamActivity liveStreamActivity7 = this.f5203j;
                c7.b bVar12 = liveStreamActivity7.E;
                if (bVar12 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((LinearLayout) bVar12.f1648b).setVisibility(0);
                c7.b bVar13 = liveStreamActivity7.E;
                if (bVar13 != null) {
                    ((TextView) bVar13.f1656k).setText("Conectando al directo...");
                    return;
                } else {
                    b8.i.d("binding");
                    throw null;
                }
            case 8:
                c7.b bVar14 = this.f5203j.E;
                if (bVar14 != null) {
                    ((LinearLayout) bVar14.f1648b).setVisibility(8);
                    return;
                } else {
                    b8.i.d("binding");
                    throw null;
                }
            case 9:
                LiveStreamActivity liveStreamActivity8 = this.f5203j;
                int i12 = LiveStreamActivity.f2332a0;
                if (liveStreamActivity8.isFinishing() || liveStreamActivity8.isDestroyed()) {
                    return;
                }
                c7.b bVar15 = liveStreamActivity8.E;
                if (bVar15 != null) {
                    ((FrameLayout) bVar15.f1650d).requestFocus();
                    return;
                } else {
                    b8.i.d("binding");
                    throw null;
                }
            case 10:
                LiveStreamActivity liveStreamActivity9 = this.f5203j;
                int i13 = LiveStreamActivity.f2332a0;
                if (liveStreamActivity9.isFinishing() || liveStreamActivity9.isDestroyed()) {
                    return;
                }
                c7.b bVar16 = liveStreamActivity9.E;
                if (bVar16 != null) {
                    ((LinearLayout) bVar16.f1652f).setVisibility(8);
                    return;
                } else {
                    b8.i.d("binding");
                    throw null;
                }
            case 11:
                c7.b bVar17 = this.f5203j.E;
                if (bVar17 != null) {
                    ((LinearLayout) bVar17.f1648b).setVisibility(8);
                    return;
                } else {
                    b8.i.d("binding");
                    throw null;
                }
            case 12:
                LiveStreamActivity liveStreamActivity10 = this.f5203j;
                c7.b bVar18 = liveStreamActivity10.E;
                if (bVar18 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                if (((LinearLayout) bVar18.f1648b).getVisibility() == 0) {
                    c7.b bVar19 = liveStreamActivity10.E;
                    if (bVar19 != null) {
                        ((LinearLayout) bVar19.f1648b).setVisibility(8);
                        return;
                    } else {
                        b8.i.d("binding");
                        throw null;
                    }
                }
                return;
            case 13:
                LiveStreamActivity liveStreamActivity11 = this.f5203j;
                int i14 = LiveStreamActivity.f2332a0;
                liveStreamActivity11.x();
                return;
            default:
                LiveStreamActivity liveStreamActivity12 = this.f5203j;
                c7.b bVar20 = liveStreamActivity12.E;
                if (bVar20 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((LinearLayout) bVar20.f1648b).setVisibility(0);
                c7.b bVar21 = liveStreamActivity12.E;
                if (bVar21 != null) {
                    ((TextView) bVar21.f1656k).setText("La señal se ha interrumpido. Reintentando...");
                    return;
                } else {
                    b8.i.d("binding");
                    throw null;
                }
        }
    }
}
