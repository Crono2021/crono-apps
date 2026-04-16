package androidx.media3.decoder.ffmpeg;

import d1.f0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class FfmpegLibrary {

    /* renamed from: a, reason: collision with root package name */
    public static String f979a;

    /* renamed from: b, reason: collision with root package name */
    public static int f980b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f981c;

    static {
        f0.a("goog.exo.ffmpeg");
        f980b = -1;
        f981c = false;
    }

    public static String a(String str) {
        str.getClass();
        switch (str) {
            case "audio/eac3-joc":
            case "audio/eac3":
                return "eac3";
            case "audio/amr-wb":
                return "amrwb";
            case "audio/vnd.dts":
            case "audio/vnd.dts.hd":
                return "dca";
            case "audio/vorbis":
                return "vorbis";
            case "audio/mpeg-L1":
            case "audio/mpeg-L2":
            case "audio/mpeg":
                return "mp3";
            case "audio/mp4a-latm":
                return "aac";
            case "audio/ac3":
                return "ac3";
            case "audio/3gpp":
                return "amrnb";
            case "audio/alac":
                return "alac";
            case "audio/flac":
                return "flac";
            case "audio/opus":
                return "opus";
            case "audio/true-hd":
                return "truehd";
            case "audio/g711-alaw":
                return "pcm_alaw";
            case "audio/g711-mlaw":
                return "pcm_mulaw";
            default:
                return null;
        }
    }

    public static int b() {
        if (!d()) {
            return -1;
        }
        if (f980b == -1) {
            f980b = ffmpegGetInputBufferPaddingSize();
        }
        return f980b;
    }

    public static String c() {
        if (!d()) {
            return null;
        }
        if (f979a == null) {
            f979a = ffmpegGetVersion();
        }
        return f979a;
    }

    public static boolean d() {
        if (!f981c) {
            try {
                System.loadLibrary("tmessages.49");
                f981c = true;
            } catch (UnsatisfiedLinkError unused) {
                g1.a.D("FfmpegLibrary", "Failed to load libtmessages.49.so");
            }
        }
        return f981c;
    }

    public static boolean e(String str) {
        String a9;
        if (!d() || (a9 = a(str)) == null) {
            return false;
        }
        if (ffmpegHasDecoder(a9)) {
            return true;
        }
        g1.a.D("FfmpegLibrary", "No " + a9 + " decoder available. Check the FFmpeg build configuration.");
        return false;
    }

    private static native int ffmpegGetInputBufferPaddingSize();

    private static native String ffmpegGetVersion();

    private static native boolean ffmpegHasDecoder(String str);
}
