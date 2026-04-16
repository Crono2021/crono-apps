package tv.danmaku.ijk.media.player;

import tv.danmaku.ijk.media.player.annotations.AccessedByNative;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class IjkReader implements IMediaOptions {

    @AccessedByNative
    private long mNativeContext;
    private static IjkLibLoader sLocalLibLoader = new IjkLibLoader() { // from class: tv.danmaku.ijk.media.player.IjkReader.1
        @Override // tv.danmaku.ijk.media.player.IjkLibLoader
        public void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    };
    private static volatile boolean mIsLibLoaded = false;
    private static volatile boolean mIsNativeInitialized = false;

    public IjkReader(IjkLibLoader ijkLibLoader) {
        loadLibrariesOnce(ijkLibLoader);
        initNativeOnce();
        native_setup();
    }

    private native void _setOption(int i9, String str, long j5);

    private native void _setOption(int i9, String str, String str2);

    private static void initNativeOnce() {
        synchronized (IjkReader.class) {
            try {
                if (!mIsNativeInitialized) {
                    native_init();
                    mIsNativeInitialized = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void loadLibrariesOnce(IjkLibLoader ijkLibLoader) {
        synchronized (IjkReader.class) {
            try {
                if (!mIsLibLoaded) {
                    if (ijkLibLoader == null) {
                        ijkLibLoader = sLocalLibLoader;
                    }
                    ijkLibLoader.loadLibrary("ijkffmpeg");
                    ijkLibLoader.loadLibrary("ijksdl");
                    ijkLibLoader.loadLibrary("ijkreader");
                    mIsLibLoaded = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final native void native_finalize();

    private static native void native_init();

    private native void native_setup();

    public void finalize() {
        native_finalize();
    }

    public int read(byte[] bArr) {
        return read(bArr, bArr.length);
    }

    public native int read(byte[] bArr, int i9);

    public native void release();

    public native void setDataSource(String str);

    @Override // tv.danmaku.ijk.media.player.IMediaOptions
    public void setOption(int i9, String str, String str2) {
        _setOption(i9, str, str2);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaOptions
    public void setOption(int i9, String str, long j5) {
        _setOption(i9, str, j5);
    }

    public IjkReader() {
        this(sLocalLibLoader);
    }
}
