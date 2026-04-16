package j0;

import android.media.AudioRecordingConfiguration;
import android.media.MediaCodec;
import android.os.Build;
import android.os.LocaleList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract /* synthetic */ class j {
    public static /* bridge */ /* synthetic */ AudioRecordingConfiguration i(Object obj) {
        return (AudioRecordingConfiguration) obj;
    }

    public static /* synthetic */ MediaCodec.CryptoInfo.Pattern j() {
        return new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    public static /* synthetic */ MediaCodec.CryptoInfo.Pattern k(int i9, int i10) {
        return new MediaCodec.CryptoInfo.Pattern(i9, i10);
    }

    public static /* bridge */ /* synthetic */ LocaleList m(Object obj) {
        return (LocaleList) obj;
    }

    public static /* synthetic */ void p() {
    }

    public static /* synthetic */ void v(ExecutorService executorService) {
        boolean isTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || executorService != ForkJoinPool.commonPool()) && !(isTerminated = executorService.isTerminated())) {
            executorService.shutdown();
            boolean z8 = false;
            while (!isTerminated) {
                try {
                    isTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z8) {
                        executorService.shutdownNow();
                        z8 = true;
                    }
                }
            }
            if (z8) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
