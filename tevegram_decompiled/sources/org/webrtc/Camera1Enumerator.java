package org.webrtc;

import android.hardware.Camera;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;
import org.webrtc.CameraEnumerationAndroid;
import org.webrtc.CameraVideoCapturer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class Camera1Enumerator implements CameraEnumerator {
    private static final String TAG = "Camera1Enumerator";
    private static List<List<CameraEnumerationAndroid.CaptureFormat>> cachedSupportedFormats;
    private final boolean captureToTexture;

    public Camera1Enumerator(boolean z8) {
        this.captureToTexture = z8;
    }

    public static List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates(List<int[]> list) {
        ArrayList arrayList = new ArrayList();
        for (int[] iArr : list) {
            arrayList.add(new CameraEnumerationAndroid.CaptureFormat.FramerateRange(iArr[0], iArr[1]));
        }
        return arrayList;
    }

    public static List<Size> convertSizes(List<Camera.Size> list) {
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size : list) {
            arrayList.add(new Size(size.width, size.height));
        }
        return arrayList;
    }

    private static List<CameraEnumerationAndroid.CaptureFormat> enumerateFormats(int i9) {
        int i10;
        Logging.d(TAG, "Get supported formats for camera index " + i9 + ".");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Camera camera = null;
        try {
            try {
                Logging.d(TAG, "Opening camera with index " + i9);
                camera = Camera.open(i9);
                Camera.Parameters parameters = camera.getParameters();
                camera.release();
                ArrayList arrayList = new ArrayList();
                try {
                    List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                    int i11 = 0;
                    if (supportedPreviewFpsRange != null) {
                        int[] iArr = supportedPreviewFpsRange.get(supportedPreviewFpsRange.size() - 1);
                        i11 = iArr[0];
                        i10 = iArr[1];
                    } else {
                        i10 = 0;
                    }
                    for (Camera.Size size : parameters.getSupportedPreviewSizes()) {
                        arrayList.add(new CameraEnumerationAndroid.CaptureFormat(size.width, size.height, i11, i10));
                    }
                } catch (Exception e9) {
                    Logging.e(TAG, "getSupportedFormats() failed on camera index " + i9, e9);
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                StringBuilder p5 = androidx.activity.g.p(i9, "Get supported formats for camera index ", " done. Time spent: ");
                p5.append(elapsedRealtime2 - elapsedRealtime);
                p5.append(" ms.");
                Logging.d(TAG, p5.toString());
                return arrayList;
            } catch (RuntimeException e10) {
                Logging.e(TAG, "Open camera failed on camera index " + i9, e10);
                ArrayList arrayList2 = new ArrayList();
                if (camera != null) {
                    camera.release();
                }
                return arrayList2;
            }
        } catch (Throwable th) {
            if (camera != null) {
                camera.release();
            }
            throw th;
        }
    }

    public static int getCameraIndex(String str) {
        Logging.d(TAG, "getCameraIndex: " + str);
        for (int i9 = 0; i9 < Camera.getNumberOfCameras(); i9++) {
            if (str.equals(getDeviceName(i9))) {
                return i9;
            }
        }
        m7.c.n(t.a.b("No such camera: ", str));
        return 0;
    }

    private static Camera.CameraInfo getCameraInfo(int i9) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        try {
            Camera.getCameraInfo(i9, cameraInfo);
            return cameraInfo;
        } catch (Exception e9) {
            Logging.e(TAG, "getCameraInfo failed on index " + i9, e9);
            return null;
        }
    }

    public static String getDeviceName(int i9) {
        Camera.CameraInfo cameraInfo = getCameraInfo(i9);
        if (cameraInfo == null) {
            return null;
        }
        return "Camera " + i9 + ", Facing " + (cameraInfo.facing == 1 ? "front" : "back") + ", Orientation " + cameraInfo.orientation;
    }

    public static synchronized List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(int i9) {
        List<CameraEnumerationAndroid.CaptureFormat> list;
        synchronized (Camera1Enumerator.class) {
            try {
                if (cachedSupportedFormats == null) {
                    cachedSupportedFormats = new ArrayList();
                    for (int i10 = 0; i10 < Camera.getNumberOfCameras(); i10++) {
                        cachedSupportedFormats.add(enumerateFormats(i10));
                    }
                }
                list = cachedSupportedFormats.get(i9);
            } catch (Throwable th) {
                throw th;
            }
        }
        return list;
    }

    @Override // org.webrtc.CameraEnumerator
    public CameraVideoCapturer createCapturer(String str, CameraVideoCapturer.CameraEventsHandler cameraEventsHandler) {
        return new Camera1Capturer(str, cameraEventsHandler, this.captureToTexture);
    }

    @Override // org.webrtc.CameraEnumerator
    public String[] getDeviceNames() {
        ArrayList arrayList = new ArrayList();
        for (int i9 = 0; i9 < Camera.getNumberOfCameras(); i9++) {
            String deviceName = getDeviceName(i9);
            if (deviceName != null) {
                arrayList.add(deviceName);
                StringBuilder sb = new StringBuilder("Index: ");
                sb.append(i9);
                sb.append(". ");
                androidx.activity.g.y(sb, deviceName, TAG);
            } else {
                Logging.e(TAG, "Index: " + i9 + ". Failed to query camera name.");
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // org.webrtc.CameraEnumerator
    public boolean isBackFacing(String str) {
        Camera.CameraInfo cameraInfo = getCameraInfo(getCameraIndex(str));
        return cameraInfo != null && cameraInfo.facing == 0;
    }

    @Override // org.webrtc.CameraEnumerator
    public boolean isFrontFacing(String str) {
        Camera.CameraInfo cameraInfo = getCameraInfo(getCameraIndex(str));
        return cameraInfo != null && cameraInfo.facing == 1;
    }

    public Camera1Enumerator() {
        this(true);
    }

    @Override // org.webrtc.CameraEnumerator
    public List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String str) {
        return getSupportedFormats(getCameraIndex(str));
    }
}
