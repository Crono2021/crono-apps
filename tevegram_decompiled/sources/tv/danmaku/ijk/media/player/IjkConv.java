package tv.danmaku.ijk.media.player;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class IjkConv {
    private static IjkLibLoader sLocalLibLoader = new IjkLibLoader() { // from class: tv.danmaku.ijk.media.player.IjkConv.1
        @Override // tv.danmaku.ijk.media.player.IjkLibLoader
        public void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    };
    private static volatile boolean mIsLibLoaded = false;
    private static volatile boolean mIsNativeInitialized = false;

    public IjkConv(IjkLibLoader ijkLibLoader) {
        loadLibrariesOnce(ijkLibLoader);
    }

    private static void initNativeOnce() {
        synchronized (IjkConv.class) {
            try {
                if (!mIsNativeInitialized) {
                    mIsNativeInitialized = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void loadLibrariesOnce(IjkLibLoader ijkLibLoader) {
        synchronized (IjkConv.class) {
            try {
                if (!mIsLibLoaded) {
                    if (ijkLibLoader == null) {
                        ijkLibLoader = sLocalLibLoader;
                    }
                    ijkLibLoader.loadLibrary("ijkffmpeg");
                    ijkLibLoader.loadLibrary("ijksdl");
                    ijkLibLoader.loadLibrary("ijkconv");
                    mIsLibLoaded = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private native int run(String[] strArr);

    public native boolean await(int i9);

    public int process(String[] strArr) {
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = "ffmpeg";
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return run(strArr2);
    }

    public native void stop(int i9);

    public IjkConv() {
        this(sLocalLibLoader);
    }
}
