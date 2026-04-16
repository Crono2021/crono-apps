package l1;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class k {
    public static final long DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS = 5000;
    public static final int EXTENSION_RENDERER_MODE_OFF = 0;
    public static final int EXTENSION_RENDERER_MODE_ON = 1;
    public static final int EXTENSION_RENDERER_MODE_PREFER = 2;
    public static final int MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY = 50;
    private static final String TAG = "DefaultRenderersFactory";
    private final s1.h codecAdapterFactory;
    private final Context context;
    private boolean enableAudioTrackPlaybackParams;
    private boolean enableDecoderFallback;
    private boolean enableFloatOutput;
    private int extensionRendererMode = 0;
    private long allowedVideoJoiningTimeMs = DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
    private s1.t mediaCodecSelector = s1.t.f8756f;

    public k(Context context) {
        this.context = context;
        this.codecAdapterFactory = new s1.h(context);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:3|(1:5)|6|7|8|9|(2:10|11)|12|13|14|15|16|17|19|20|21|22|23|(3:25|26|28)) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:(2:10|11)|19|20|21|22|23|(3:25|26|28)) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:(3:7|8|9)|(7:(2:10|11)|19|20|21|22|23|(3:25|26|28))|12|13|14|15|16|17) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c9, code lost:
    
        r10 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d1, code lost:
    
        r9 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0092, code lost:
    
        r9 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009a, code lost:
    
        r10 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void buildAudioRenderers(android.content.Context r15, int r16, s1.t r17, boolean r18, n1.w r19, android.os.Handler r20, n1.q r21, java.util.ArrayList<l1.b1> r22) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.k.buildAudioRenderers(android.content.Context, int, s1.t, boolean, n1.w, android.os.Handler, n1.q, java.util.ArrayList):void");
    }

    public abstract n1.w buildAudioSink(Context context, boolean z8, boolean z9);

    public void buildCameraMotionRenderers(Context context, int i9, ArrayList<b1> arrayList) {
        arrayList.add(new c2.b());
    }

    public void buildImageRenderers(ArrayList<b1> arrayList) {
        arrayList.add(new r1.g(r1.c.f8525e));
    }

    public void buildMetadataRenderers(Context context, t1.b bVar, Looper looper, int i9, ArrayList<b1> arrayList) {
        arrayList.add(new t1.c(bVar, looper));
    }

    public void buildTextRenderers(Context context, x1.d dVar, Looper looper, int i9, ArrayList<b1> arrayList) {
        arrayList.add(new x1.e(dVar, looper));
    }

    public void buildVideoRenderers(Context context, int i9, s1.t tVar, boolean z8, Handler handler, b2.j0 j0Var, long j5, ArrayList<b1> arrayList) {
        int i10;
        int i11;
        Class<?> cls = Integer.TYPE;
        Class<?> cls2 = Long.TYPE;
        arrayList.add(new b2.n(context, getCodecAdapterFactory(), tVar, j5, z8, handler, j0Var));
        if (i9 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i9 == 2) {
            size--;
        }
        try {
            try {
                i10 = size + 1;
                try {
                    arrayList.add(size, (b1) Class.forName("androidx.media3.decoder.vp9.LibvpxVideoRenderer").getConstructor(cls2, Handler.class, b2.j0.class, cls).newInstance(Long.valueOf(j5), handler, j0Var, 50));
                    g1.a.v(TAG, "Loaded LibvpxVideoRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i10;
                    i10 = size;
                    try {
                        i11 = i10 + 1;
                        arrayList.add(i10, (b1) Class.forName("androidx.media3.decoder.av1.Libgav1VideoRenderer").getConstructor(cls2, Handler.class, b2.j0.class, cls).newInstance(Long.valueOf(j5), handler, j0Var, 50));
                        g1.a.v(TAG, "Loaded Libgav1VideoRenderer.");
                    } catch (ClassNotFoundException unused2) {
                    }
                    arrayList.add(i11, (b1) Class.forName("androidx.media3.decoder.ffmpeg.ExperimentalFfmpegVideoRenderer").getConstructor(cls2, Handler.class, b2.j0.class, cls).newInstance(Long.valueOf(j5), handler, j0Var, 50));
                    g1.a.v(TAG, "Loaded FfmpegVideoRenderer.");
                }
            } catch (Exception e9) {
                m7.c.k("Error instantiating VP9 extension", e9);
                return;
            }
        } catch (ClassNotFoundException unused3) {
        }
        try {
            i11 = i10 + 1;
            try {
                arrayList.add(i10, (b1) Class.forName("androidx.media3.decoder.av1.Libgav1VideoRenderer").getConstructor(cls2, Handler.class, b2.j0.class, cls).newInstance(Long.valueOf(j5), handler, j0Var, 50));
                g1.a.v(TAG, "Loaded Libgav1VideoRenderer.");
            } catch (ClassNotFoundException unused4) {
                i10 = i11;
                i11 = i10;
                arrayList.add(i11, (b1) Class.forName("androidx.media3.decoder.ffmpeg.ExperimentalFfmpegVideoRenderer").getConstructor(cls2, Handler.class, b2.j0.class, cls).newInstance(Long.valueOf(j5), handler, j0Var, 50));
                g1.a.v(TAG, "Loaded FfmpegVideoRenderer.");
            }
            try {
                arrayList.add(i11, (b1) Class.forName("androidx.media3.decoder.ffmpeg.ExperimentalFfmpegVideoRenderer").getConstructor(cls2, Handler.class, b2.j0.class, cls).newInstance(Long.valueOf(j5), handler, j0Var, 50));
                g1.a.v(TAG, "Loaded FfmpegVideoRenderer.");
            } catch (ClassNotFoundException unused5) {
            } catch (Exception e10) {
                m7.c.k("Error instantiating FFmpeg extension", e10);
            }
        } catch (Exception e11) {
            m7.c.k("Error instantiating AV1 extension", e11);
        }
    }

    public b1[] createRenderers(Handler handler, b2.j0 j0Var, n1.q qVar, x1.d dVar, t1.b bVar) {
        Handler handler2;
        ArrayList<b1> arrayList = new ArrayList<>();
        buildVideoRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, this.enableDecoderFallback, handler, j0Var, this.allowedVideoJoiningTimeMs, arrayList);
        n1.w buildAudioSink = buildAudioSink(this.context, this.enableFloatOutput, this.enableAudioTrackPlaybackParams);
        if (buildAudioSink != null) {
            handler2 = handler;
            buildAudioRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, this.enableDecoderFallback, buildAudioSink, handler2, qVar, arrayList);
        } else {
            handler2 = handler;
        }
        buildTextRenderers(this.context, dVar, handler2.getLooper(), this.extensionRendererMode, arrayList);
        buildMetadataRenderers(this.context, bVar, handler2.getLooper(), this.extensionRendererMode, arrayList);
        buildCameraMotionRenderers(this.context, this.extensionRendererMode, arrayList);
        buildImageRenderers(arrayList);
        buildMiscellaneousRenderers(this.context, handler2, this.extensionRendererMode, arrayList);
        return (b1[]) arrayList.toArray(new b1[0]);
    }

    public final k experimentalSetMediaCodecAsyncCryptoFlagEnabled(boolean z8) {
        this.codecAdapterFactory.f8707k = z8;
        return this;
    }

    public final k forceDisableMediaCodecAsynchronousQueueing() {
        this.codecAdapterFactory.f8706j = 2;
        return this;
    }

    public final k forceEnableMediaCodecAsynchronousQueueing() {
        this.codecAdapterFactory.f8706j = 1;
        return this;
    }

    public s1.j getCodecAdapterFactory() {
        return this.codecAdapterFactory;
    }

    public final k setAllowedVideoJoiningTimeMs(long j5) {
        this.allowedVideoJoiningTimeMs = j5;
        return this;
    }

    public final k setEnableAudioFloatOutput(boolean z8) {
        this.enableFloatOutput = z8;
        return this;
    }

    public final k setEnableAudioTrackPlaybackParams(boolean z8) {
        this.enableAudioTrackPlaybackParams = z8;
        return this;
    }

    public final k setEnableDecoderFallback(boolean z8) {
        this.enableDecoderFallback = z8;
        return this;
    }

    public final k setExtensionRendererMode(int i9) {
        this.extensionRendererMode = i9;
        return this;
    }

    public final k setMediaCodecSelector(s1.t tVar) {
        this.mediaCodecSelector = tVar;
        return this;
    }

    public void buildMiscellaneousRenderers(Context context, Handler handler, int i9, ArrayList<b1> arrayList) {
    }
}
