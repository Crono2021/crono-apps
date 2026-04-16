package b2;

import android.util.Base64;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class c implements a6.h {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1146i;

    public /* synthetic */ c(int i9) {
        this.f1146i = i9;
    }

    @Override // a6.h
    public final Object get() {
        switch (this.f1146i) {
            case 0:
                try {
                    Class<?> cls = Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
                    Object invoke = cls.getMethod("build", null).invoke(cls.getConstructor(null).newInstance(null), null);
                    invoke.getClass();
                    return (d) invoke;
                } catch (Exception e9) {
                    throw new IllegalStateException(e9);
                }
            case 1:
                return new l1.i(new z1.d(), 50000, 50000, 2500, 5000, false);
            default:
                byte[] bArr = new byte[12];
                m1.s.f6567i.nextBytes(bArr);
                return Base64.encodeToString(bArr, 10);
        }
    }
}
