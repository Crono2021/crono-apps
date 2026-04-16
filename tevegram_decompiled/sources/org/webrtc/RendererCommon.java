package org.webrtc;

import android.graphics.Matrix;
import android.graphics.Point;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class RendererCommon {
    private static float BALANCED_VISIBLE_FRACTION = 0.5625f;

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface GlDrawer {
        void drawOes(int i9, int i10, int i11, int i12, int i13, float[] fArr, int i14, int i15, int i16, int i17, int i18, int i19, boolean z8);

        void drawRgb(int i9, int i10, int i11, int i12, int i13, float[] fArr, int i14, int i15, int i16, int i17, int i18, int i19, boolean z8);

        void drawYuv(int[] iArr, int i9, int i10, int i11, int i12, float[] fArr, int i13, int i14, int i15, int i16, int i17, int i18, boolean z8);

        void release();
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface RendererEvents {
        void onFirstFrameRendered();

        void onFrameResolutionChanged(int i9, int i10, int i11);
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public enum ScalingType {
        SCALE_ASPECT_FIT,
        SCALE_ASPECT_FILL,
        SCALE_ASPECT_BALANCED
    }

    private static void adjustOrigin(float[] fArr) {
        float f9 = fArr[12] - ((fArr[0] + fArr[4]) * 0.5f);
        fArr[12] = f9;
        float f10 = fArr[13] - ((fArr[1] + fArr[5]) * 0.5f);
        fArr[13] = f10;
        fArr[12] = f9 + 0.5f;
        fArr[13] = f10 + 0.5f;
    }

    public static float[] convertMatrixFromAndroidGraphicsMatrix(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return new float[]{fArr[0], fArr[3], 0.0f, fArr[6], fArr[1], fArr[4], 0.0f, fArr[7], 0.0f, 0.0f, 1.0f, 0.0f, fArr[2], fArr[5], 0.0f, fArr[8]};
    }

    public static Matrix convertMatrixToAndroidGraphicsMatrix(float[] fArr) {
        float[] fArr2 = {fArr[0], fArr[4], fArr[12], fArr[1], fArr[5], fArr[13], fArr[3], fArr[7], fArr[15]};
        Matrix matrix = new Matrix();
        matrix.setValues(fArr2);
        return matrix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float convertScalingTypeToVisibleFraction(ScalingType scalingType) {
        int ordinal = scalingType.ordinal();
        if (ordinal == 0) {
            return 1.0f;
        }
        if (ordinal == 1) {
            return 0.0f;
        }
        if (ordinal == 2) {
            return BALANCED_VISIBLE_FRACTION;
        }
        m7.c.d();
        return 0.0f;
    }

    public static Point getDisplaySize(float f9, float f10, int i9, int i10) {
        return (f9 == 0.0f || f10 == 0.0f) ? new Point(i9, i10) : new Point(Math.min(i9, Math.round((i10 / f9) * f10)), Math.min(i10, Math.round((i9 / f9) / f10)));
    }

    public static float[] getLayoutMatrix(boolean z8, float f9, float f10) {
        float f11;
        float f12;
        if (f10 > f9) {
            f12 = f9 / f10;
            f11 = 1.0f;
        } else {
            f11 = f10 / f9;
            f12 = 1.0f;
        }
        if (z8) {
            f11 *= -1.0f;
        }
        float[] fArr = new float[16];
        android.opengl.Matrix.setIdentityM(fArr, 0);
        android.opengl.Matrix.scaleM(fArr, 0, f11, f12, 1.0f);
        adjustOrigin(fArr);
        return fArr;
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static class VideoLayoutMeasure {
        private float visibleFractionMatchOrientation;
        private float visibleFractionMismatchOrientation;

        public VideoLayoutMeasure() {
            ScalingType scalingType = ScalingType.SCALE_ASPECT_BALANCED;
            this.visibleFractionMatchOrientation = RendererCommon.convertScalingTypeToVisibleFraction(scalingType);
            this.visibleFractionMismatchOrientation = RendererCommon.convertScalingTypeToVisibleFraction(scalingType);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
        
            if ((r11 > 1.0f) == (r12 > 1.0f)) goto L32;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public android.graphics.Point measure(boolean r8, int r9, int r10, int r11, int r12) {
            /*
                r7 = this;
                r0 = 2147483647(0x7fffffff, float:NaN)
                int r1 = android.view.View.getDefaultSize(r0, r9)
                int r0 = android.view.View.getDefaultSize(r0, r10)
                if (r11 == 0) goto L56
                if (r12 == 0) goto L56
                if (r1 == 0) goto L56
                if (r0 != 0) goto L14
                goto L56
            L14:
                float r11 = (float) r11
                float r12 = (float) r12
                float r11 = r11 / r12
                float r12 = (float) r1
                float r2 = (float) r0
                float r12 = r12 / r2
                r2 = 1065353216(0x3f800000, float:1.0)
                r3 = 0
                r4 = 1
                int r5 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                if (r5 <= 0) goto L24
                r6 = 1
                goto L25
            L24:
                r6 = 0
            L25:
                int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
                if (r12 <= 0) goto L2b
                r2 = 1
                goto L2c
            L2b:
                r2 = 0
            L2c:
                if (r6 != r2) goto L31
                float r2 = r7.visibleFractionMatchOrientation
                goto L33
            L31:
                float r2 = r7.visibleFractionMismatchOrientation
            L33:
                android.graphics.Point r11 = org.webrtc.RendererCommon.getDisplaySize(r2, r11, r1, r0)
                if (r8 != 0) goto L55
                int r8 = android.view.View.MeasureSpec.getMode(r9)
                r9 = 1073741824(0x40000000, float:2.0)
                if (r8 != r9) goto L43
                r11.x = r1
            L43:
                int r8 = android.view.View.MeasureSpec.getMode(r10)
                if (r8 == r9) goto L53
                if (r5 <= 0) goto L4d
                r8 = 1
                goto L4e
            L4d:
                r8 = 0
            L4e:
                if (r12 <= 0) goto L51
                r3 = 1
            L51:
                if (r8 != r3) goto L55
            L53:
                r11.y = r0
            L55:
                return r11
            L56:
                android.graphics.Point r8 = new android.graphics.Point
                r8.<init>(r1, r0)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: org.webrtc.RendererCommon.VideoLayoutMeasure.measure(boolean, int, int, int, int):android.graphics.Point");
        }

        public void setScalingType(ScalingType scalingType, ScalingType scalingType2) {
            this.visibleFractionMatchOrientation = RendererCommon.convertScalingTypeToVisibleFraction(scalingType);
            this.visibleFractionMismatchOrientation = RendererCommon.convertScalingTypeToVisibleFraction(scalingType2);
        }

        public void setVisibleFraction(float f9, float f10) {
            this.visibleFractionMatchOrientation = f9;
            this.visibleFractionMismatchOrientation = f10;
        }

        public void setScalingType(ScalingType scalingType) {
            setScalingType(scalingType, scalingType);
        }

        public Point measure(int i9, int i10, int i11, int i12) {
            return measure(true, i9, i10, i11, i12);
        }
    }

    public static Point getDisplaySize(ScalingType scalingType, float f9, int i9, int i10) {
        return getDisplaySize(convertScalingTypeToVisibleFraction(scalingType), f9, i9, i10);
    }
}
