package c8;

import java.util.Random;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a extends e {
    @Override // c8.e
    public final int a(int i9) {
        return ((-i9) >> 31) & (d().nextInt() >>> (32 - i9));
    }

    @Override // c8.e
    public final int b() {
        return d().nextInt();
    }

    public abstract Random d();

    public final int e(int i9) {
        return d().nextInt(i9);
    }
}
