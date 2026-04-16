package m4;

import android.graphics.ImageDecoder;
import android.os.Build;
import b4.i;
import b4.k;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import d4.a0;
import e4.f;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6641a;

    /* renamed from: b, reason: collision with root package name */
    public final m1.b f6642b;

    public /* synthetic */ b(m1.b bVar, int i9) {
        this.f6641a = i9;
        this.f6642b = bVar;
    }

    @Override // b4.k
    public final a0 a(Object obj, int i9, int i10, i iVar) {
        ImageDecoder.Source createSource;
        ImageDecoder.Source createSource2;
        switch (this.f6641a) {
            case 0:
                createSource = ImageDecoder.createSource((ByteBuffer) obj);
                return m1.b.g(createSource, i9, i10, iVar);
            default:
                createSource2 = ImageDecoder.createSource(w4.b.b((InputStream) obj));
                return m1.b.g(createSource2, i9, i10, iVar);
        }
    }

    @Override // b4.k
    public final boolean b(Object obj, i iVar) {
        switch (this.f6641a) {
            case 0:
                ImageHeaderParser$ImageType J = com.bumptech.glide.d.J((ArrayList) this.f6642b.f6510j, (ByteBuffer) obj);
                if (J == ImageHeaderParser$ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && J == ImageHeaderParser$ImageType.ANIMATED_AVIF)) {
                }
                break;
            default:
                m1.b bVar = this.f6642b;
                ImageHeaderParser$ImageType I = com.bumptech.glide.d.I((ArrayList) bVar.f6510j, (InputStream) obj, (f) bVar.f6511k);
                if (I == ImageHeaderParser$ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && I == ImageHeaderParser$ImageType.ANIMATED_AVIF)) {
                }
                break;
        }
        return true;
    }
}
