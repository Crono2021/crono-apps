package k4;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f implements b4.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5564a;

    /* renamed from: b, reason: collision with root package name */
    public final q f5565b;

    public /* synthetic */ f(q qVar, int i9) {
        this.f5564a = i9;
        this.f5565b = qVar;
    }

    @Override // b4.k
    public final d4.a0 a(Object obj, int i9, int i10, b4.i iVar) {
        switch (this.f5564a) {
            case 0:
                q qVar = this.f5565b;
                return qVar.a(new androidx.fragment.app.g((ByteBuffer) obj, qVar.f5591d, qVar.f5590c, 15), i9, i10, iVar, q.f5586k);
            default:
                q qVar2 = this.f5565b;
                return qVar2.a(new androidx.fragment.app.g((ParcelFileDescriptor) obj, qVar2.f5591d, qVar2.f5590c), i9, i10, iVar, q.f5586k);
        }
    }

    @Override // b4.k
    public final boolean b(Object obj, b4.i iVar) {
        switch (this.f5564a) {
            case 0:
                return true;
            default:
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
                String str = Build.MANUFACTURER;
                return (!("HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor.getStatSize() <= IjkMediaMeta.AV_CH_STEREO_LEFT) && !"robolectric".equals(Build.FINGERPRINT);
        }
    }
}
