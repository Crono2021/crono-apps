package n1;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import b6.a1;
import b6.b1;
import b6.k1;
import b6.z0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class b {
    public static b6.g0 a(d1.g gVar) {
        boolean isDirectPlaybackSupported;
        b6.e0 e0Var = b6.g0.f1391j;
        b6.d0 d0Var = new b6.d0();
        b1 b1Var = e.f7249e;
        z0 z0Var = b1Var.f1354j;
        if (z0Var == null) {
            z0 z0Var2 = new z0(b1Var, new a1(b1Var.f1357m, 0, b1Var.f1358n));
            b1Var.f1354j = z0Var2;
            z0Var = z0Var2;
        }
        k1 it = z0Var.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            int intValue = num.intValue();
            if (g1.w.f3713a >= g1.w.n(intValue)) {
                isDirectPlaybackSupported = AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(intValue).setSampleRate(48000).build(), (AudioAttributes) gVar.a().f8j);
                if (isDirectPlaybackSupported) {
                    d0Var.a(num);
                }
            }
        }
        d0Var.a(2);
        return d0Var.f();
    }

    public static int b(int i9, int i10, d1.g gVar) {
        boolean isDirectPlaybackSupported;
        for (int i11 = 10; i11 > 0; i11--) {
            int p5 = g1.w.p(i11);
            if (p5 != 0) {
                isDirectPlaybackSupported = AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i9).setSampleRate(i10).setChannelMask(p5).build(), (AudioAttributes) gVar.a().f8j);
                if (isDirectPlaybackSupported) {
                    return i11;
                }
            }
        }
        return 0;
    }
}
