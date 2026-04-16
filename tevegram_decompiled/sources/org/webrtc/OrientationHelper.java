package org.webrtc;

import android.view.OrientationEventListener;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class OrientationHelper {
    private static final int ORIENTATION_HYSTERESIS = 5;
    public static volatile int cameraOrientation;
    public static volatile int cameraRotation;
    public static volatile boolean cameraRotationDisabled;
    private OrientationEventListener orientationEventListener = new OrientationEventListener(ContextUtils.getApplicationContext()) { // from class: org.webrtc.OrientationHelper.1
        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i9) {
            if (OrientationHelper.this.orientationEventListener == null || i9 == -1) {
                return;
            }
            OrientationHelper orientationHelper = OrientationHelper.this;
            int roundOrientation = orientationHelper.roundOrientation(i9, orientationHelper.rotation);
            if (roundOrientation != OrientationHelper.this.rotation) {
                OrientationHelper orientationHelper2 = OrientationHelper.this;
                orientationHelper2.rotation = roundOrientation;
                orientationHelper2.onOrientationUpdate(roundOrientation);
            }
        }
    };
    private int rotation;

    /* JADX INFO: Access modifiers changed from: private */
    public int roundOrientation(int i9, int i10) {
        if (i10 != -1) {
            int abs = Math.abs(i9 - i10);
            if (Math.min(abs, 360 - abs) < 50) {
                return i10;
            }
        }
        return (((i9 + 45) / 90) * 90) % 360;
    }

    public int getOrientation() {
        if (cameraRotationDisabled) {
            return 0;
        }
        return this.rotation;
    }

    public void start() {
        boolean canDetectOrientation = this.orientationEventListener.canDetectOrientation();
        OrientationEventListener orientationEventListener = this.orientationEventListener;
        if (canDetectOrientation) {
            orientationEventListener.enable();
        } else {
            orientationEventListener.disable();
            this.orientationEventListener = null;
        }
    }

    public void stop() {
        OrientationEventListener orientationEventListener = this.orientationEventListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.orientationEventListener = null;
        }
    }

    public void onOrientationUpdate(int i9) {
    }
}
