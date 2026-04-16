package i7;

import android.widget.TextView;
import com.network.tvgramplayer.ui.MainActivity;
import java.util.Arrays;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class z0 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5226i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ long f5227j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f5228k;

    public /* synthetic */ z0(long j5, TextView textView) {
        this.f5226i = 0;
        this.f5227j = j5;
        this.f5228k = textView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i9 = this.f5226i;
        long j5 = this.f5227j;
        Object obj = this.f5228k;
        switch (i9) {
            case 0:
                TextView textView = (TextView) obj;
                int i10 = MainActivity.X;
                long j9 = j5 / 1048576;
                if (j9 <= 1000) {
                    textView.setText("Uso actual: " + j9 + " MB");
                    return;
                }
                textView.setText("Uso actual: " + String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(j9 / 1024.0d)}, 1)) + " GB");
                return;
            case 1:
                c7.d dVar = ((MainActivity) obj).E;
                if (dVar == null) {
                    b8.i.d("binding");
                    throw null;
                }
                dVar.E.setText("Sincronizando... " + ((System.currentTimeMillis() - j5) / IjkMediaCodecInfo.RANK_MAX) + "s");
                return;
            default:
                n1.q qVar = (n1.q) ((m1.b) obj).f6511k;
                int i11 = g1.w.f3713a;
                m1.q qVar2 = ((l1.y) qVar).f6065i.f5804y;
                m1.a K = qVar2.K();
                qVar2.L(K, 1010, new h7.o(K, j5));
                return;
        }
    }

    public /* synthetic */ z0(int i9, long j5, Object obj) {
        this.f5226i = i9;
        this.f5228k = obj;
        this.f5227j = j5;
    }
}
