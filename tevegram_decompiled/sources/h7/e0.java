package h7;

import com.network.tvgramplayer.ui.MainActivity;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class e0 implements a8.l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4088i;

    public /* synthetic */ e0(int i9) {
        this.f4088i = i9;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        switch (this.f4088i) {
            case 0:
                ((Boolean) obj).getClass();
                return n7.g.f7490c;
            default:
                Float f9 = (Float) obj;
                f9.floatValue();
                int i9 = MainActivity.X;
                return String.format("%.2fHz", Arrays.copyOf(new Object[]{f9}, 1));
        }
    }
}
