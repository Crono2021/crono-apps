package b2;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.Spatializer;
import android.net.ConnectivityManager;
import android.net.Network;
import android.opengl.Matrix;
import android.util.Log;
import java.io.File;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements com.bumptech.glide.manager.m {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1137a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1138b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1139c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1140d;

    public b() {
        this.f1138b = new float[16];
        this.f1139c = new float[16];
        this.f1140d = new c2.f();
    }

    public static void e(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float f9 = fArr2[10];
        float f10 = fArr2[8];
        float sqrt = (float) Math.sqrt((f10 * f10) + (f9 * f9));
        float f11 = fArr2[10] / sqrt;
        fArr[0] = f11;
        float f12 = fArr2[8];
        fArr[2] = f12 / sqrt;
        fArr[8] = (-f12) / sqrt;
        fArr[10] = f11;
    }

    @Override // com.bumptech.glide.manager.m
    public void a() {
        ((ConnectivityManager) ((c.a) this.f1139c).get()).unregisterNetworkCallback((com.bumptech.glide.manager.o) this.f1140d);
    }

    @Override // com.bumptech.glide.manager.m
    public boolean b() {
        Network activeNetwork;
        c.a aVar = (c.a) this.f1139c;
        activeNetwork = ((ConnectivityManager) aVar.get()).getActiveNetwork();
        this.f1137a = activeNetwork != null;
        try {
            ((ConnectivityManager) aVar.get()).registerDefaultNetworkCallback((com.bumptech.glide.manager.o) this.f1140d);
            return true;
        } catch (RuntimeException e9) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register callback", e9);
            }
            return false;
        }
    }

    public void c() {
        z3.d.a((z3.d) this.f1140d, this, false);
    }

    public boolean d(d1.g gVar, d1.s sVar) {
        boolean canBeSpatialized;
        String str = sVar.f2554m;
        int i9 = sVar.f2567z;
        if ("audio/eac3-joc".equals(str) && i9 == 16) {
            i9 = 12;
        }
        AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(g1.w.p(i9));
        int i10 = sVar.A;
        if (i10 != -1) {
            channelMask.setSampleRate(i10);
        }
        canBeSpatialized = ((Spatializer) this.f1138b).canBeSpatialized((AudioAttributes) gVar.a().f8j, channelMask.build());
        return canBeSpatialized;
    }

    public File f() {
        File file;
        synchronized (((z3.d) this.f1140d)) {
            try {
                z3.c cVar = (z3.c) this.f1138b;
                if (cVar.f10636f != this) {
                    throw new IllegalStateException();
                }
                if (!cVar.f10635e) {
                    ((boolean[]) this.f1139c)[0] = true;
                }
                file = cVar.f10634d[0];
                ((z3.d) this.f1140d).f10638i.mkdirs();
            } catch (Throwable th) {
                throw th;
            }
        }
        return file;
    }

    public b(Context context) {
        this.f1138b = context;
    }

    public b(c.a aVar, com.bumptech.glide.manager.l lVar) {
        this.f1140d = new com.bumptech.glide.manager.o(this);
        this.f1139c = aVar;
        this.f1138b = lVar;
    }

    public b(z3.d dVar, z3.c cVar) {
        this.f1140d = dVar;
        this.f1138b = cVar;
        this.f1139c = cVar.f10635e ? null : new boolean[dVar.f10644o];
    }

    public b(Spatializer spatializer) {
        int immersiveAudioLevel;
        this.f1138b = spatializer;
        immersiveAudioLevel = spatializer.getImmersiveAudioLevel();
        this.f1137a = immersiveAudioLevel != 0;
    }
}
