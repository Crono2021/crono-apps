package tv.danmaku.ijk.media.player;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.activity.g;
import java.io.FileDescriptor;
import java.util.Map;
import m7.c;
import tv.danmaku.ijk.media.player.annotations.AccessedByNative;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class IjkMediaMetadataRetriever {
    public static Bitmap.Config IN_PREFERRED_CONFIG = null;
    public static final String METADATA_KEY_ALBUM = "album";
    public static final String METADATA_KEY_ALBUM_ARTIST = "album_artist";
    public static final String METADATA_KEY_ARTIST = "artist";
    public static final String METADATA_KEY_AUDIO_CODEC = "audio_codec";
    public static final String METADATA_KEY_COMMENT = "comment";
    public static final String METADATA_KEY_COMPOSER = "composer";
    public static final String METADATA_KEY_COPYRIGHT = "copyright";
    public static final String METADATA_KEY_CREATION_TIME = "creation_time";
    public static final String METADATA_KEY_DATE = "date";
    public static final String METADATA_KEY_DISC = "disc";
    public static final String METADATA_KEY_DURATION = "duration";
    public static final String METADATA_KEY_ENCODED_BY = "encoded_by";
    public static final String METADATA_KEY_ENCODER = "encoder";
    public static final String METADATA_KEY_FILENAME = "filename";
    public static final String METADATA_KEY_FRAMERATE = "framerate";
    public static final String METADATA_KEY_GENRE = "genre";
    public static final String METADATA_KEY_ICY_METADATA = "icy_metadata";
    public static final String METADATA_KEY_LANGUAGE = "language";
    public static final String METADATA_KEY_PERFORMER = "performer";
    public static final String METADATA_KEY_PUBLISHER = "publisher";
    public static final String METADATA_KEY_SERVICE_NAME = "service_name";
    public static final String METADATA_KEY_SERVICE_PROVIDER = "service_provider";
    public static final String METADATA_KEY_TITLE = "title";
    public static final String METADATA_KEY_TRACK = "track";
    public static final String METADATA_KEY_VARIANT_BITRATE = "bitrate";
    public static final String METADATA_KEY_VIDEO_CODEC = "video_codec";
    public static final String METADATA_KEY_VIDEO_ROTATION = "rotate";
    public static final int OPTION_CLOSEST = 3;
    public static final int OPTION_CLOSEST_SYNC = 2;
    public static final int OPTION_NEXT_SYNC = 1;
    public static final int OPTION_PREVIOUS_SYNC = 0;

    @AccessedByNative
    private long mNativeContext;
    private static IjkLibLoader sLocalLibLoader = new IjkLibLoader() { // from class: tv.danmaku.ijk.media.player.IjkMediaMetadataRetriever.1
        @Override // tv.danmaku.ijk.media.player.IjkLibLoader
        public void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    };
    private static volatile boolean mIsLibLoaded = false;
    private static volatile boolean mIsNativeInitialized = false;

    public IjkMediaMetadataRetriever(IjkLibLoader ijkLibLoader) {
        loadLibrariesOnce(ijkLibLoader);
        initNativeOnce();
        native_setup();
    }

    private native byte[] _getFrameAtTime(long j5, int i9);

    private native void _setDataSource(String str, String[] strArr, String[] strArr2);

    private Bitmap.Config getInPreferredConfig() {
        Bitmap.Config config = IN_PREFERRED_CONFIG;
        return config != null ? config : Bitmap.Config.RGB_565;
    }

    private static void initNativeOnce() {
        synchronized (IjkMediaMetadataRetriever.class) {
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
        synchronized (IjkMediaMetadataRetriever.class) {
            try {
                if (!mIsLibLoaded) {
                    ijkLibLoader.loadLibrary("ijkffmpeg");
                    ijkLibLoader.loadLibrary("ijkmmr");
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

    public native String extractMetadata(String str);

    public void finalize() {
        try {
            native_finalize();
        } finally {
            super.finalize();
        }
    }

    public native byte[] getEmbeddedPicture();

    public Bitmap getFrameAtTime(long j5, int i9) {
        if (i9 < 0 || i9 > 3) {
            c.n(g.m(i9, "Unsupported option: "));
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = getInPreferredConfig();
        options.inDither = false;
        byte[] _getFrameAtTime = _getFrameAtTime(j5, i9);
        if (_getFrameAtTime != null) {
            return BitmapFactory.decodeByteArray(_getFrameAtTime, 0, _getFrameAtTime.length, options);
        }
        return null;
    }

    public native void release();

    /* JADX WARN: Removed duplicated region for block: B:36:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setDataSource(android.content.Context r9, android.net.Uri r10) {
        /*
            r8 = this;
            if (r10 == 0) goto L8a
            java.lang.String r0 = r10.getScheme()
            if (r0 == 0) goto L10
            java.lang.String r1 = "file"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L13
        L10:
            r2 = r8
            goto L82
        L13:
            r1 = 0
            android.content.ContentResolver r9 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L55 java.lang.SecurityException -> L58
            java.lang.String r0 = "r"
            android.content.res.AssetFileDescriptor r1 = r9.openAssetFileDescriptor(r10, r0)     // Catch: java.lang.Throwable -> L55 java.lang.SecurityException -> L58 java.io.FileNotFoundException -> L68
            if (r1 == 0) goto L61
            java.io.FileDescriptor r3 = r1.getFileDescriptor()     // Catch: java.lang.Throwable -> L55 java.lang.SecurityException -> L58
            boolean r9 = r3.valid()     // Catch: java.lang.Throwable -> L55 java.lang.SecurityException -> L58
            if (r9 == 0) goto L5a
            long r4 = r1.getDeclaredLength()     // Catch: java.lang.Throwable -> L55 java.lang.SecurityException -> L58
            r6 = 0
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 >= 0) goto L40
            r8.setDataSource(r3)     // Catch: java.lang.Throwable -> L39 java.lang.SecurityException -> L3d
            r2 = r8
            goto L4c
        L39:
            r0 = move-exception
            r9 = r0
            r2 = r8
            goto L6f
        L3d:
            r2 = r8
            goto L75
        L40:
            long r4 = r1.getStartOffset()     // Catch: java.lang.Throwable -> L55 java.lang.SecurityException -> L58
            long r6 = r1.getDeclaredLength()     // Catch: java.lang.Throwable -> L55 java.lang.SecurityException -> L58
            r2 = r8
            r2.setDataSource(r3, r4, r6)     // Catch: java.lang.Throwable -> L50 java.lang.SecurityException -> L53
        L4c:
            r1.close()     // Catch: java.io.IOException -> L4f
        L4f:
            return
        L50:
            r0 = move-exception
        L51:
            r9 = r0
            goto L6f
        L53:
            goto L75
        L55:
            r0 = move-exception
            r2 = r8
            goto L51
        L58:
            r2 = r8
            goto L53
        L5a:
            r2 = r8
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L50 java.lang.SecurityException -> L53
            r9.<init>()     // Catch: java.lang.Throwable -> L50 java.lang.SecurityException -> L53
            throw r9     // Catch: java.lang.Throwable -> L50 java.lang.SecurityException -> L53
        L61:
            r2 = r8
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L50 java.lang.SecurityException -> L53
            r9.<init>()     // Catch: java.lang.Throwable -> L50 java.lang.SecurityException -> L53
            throw r9     // Catch: java.lang.Throwable -> L50 java.lang.SecurityException -> L53
        L68:
            r2 = r8
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L50 java.lang.SecurityException -> L53
            r9.<init>()     // Catch: java.lang.Throwable -> L50 java.lang.SecurityException -> L53
            throw r9     // Catch: java.lang.Throwable -> L50 java.lang.SecurityException -> L53
        L6f:
            if (r1 == 0) goto L74
            r1.close()     // Catch: java.io.IOException -> L74
        L74:
            throw r9
        L75:
            if (r1 == 0) goto L7a
            r1.close()     // Catch: java.io.IOException -> L7a
        L7a:
            java.lang.String r9 = r10.toString()
            r8.setDataSource(r9)
            return
        L82:
            java.lang.String r9 = r10.getPath()
            r8.setDataSource(r9)
            return
        L8a:
            r2 = r8
            m7.c.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.ijk.media.player.IjkMediaMetadataRetriever.setDataSource(android.content.Context, android.net.Uri):void");
    }

    public native void setDataSource(FileDescriptor fileDescriptor, long j5, long j9);

    public IjkMediaMetadataRetriever() {
        this(sLocalLibLoader);
    }

    public Bitmap getFrameAtTime(long j5) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = getInPreferredConfig();
        options.inDither = false;
        byte[] _getFrameAtTime = _getFrameAtTime(j5, 2);
        if (_getFrameAtTime != null) {
            return BitmapFactory.decodeByteArray(_getFrameAtTime, 0, _getFrameAtTime.length, options);
        }
        return null;
    }

    public Bitmap getFrameAtTime() {
        return getFrameAtTime(-1L, 2);
    }

    public void setDataSource(String str) {
        _setDataSource(str, null, null);
    }

    public void setDataSource(String str, Map<String, String> map) {
        String[] strArr = new String[map.size()];
        String[] strArr2 = new String[map.size()];
        int i9 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            strArr[i9] = entry.getKey();
            strArr2[i9] = entry.getValue();
            i9++;
        }
        _setDataSource(str, strArr, strArr2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        setDataSource(fileDescriptor, 0L, 576460752303423487L);
    }
}
