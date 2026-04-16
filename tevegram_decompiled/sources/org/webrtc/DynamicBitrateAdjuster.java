package org.webrtc;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
class DynamicBitrateAdjuster extends BaseBitrateAdjuster {
    private static final double BITRATE_ADJUSTMENT_MAX_SCALE = 4.0d;
    private static final double BITRATE_ADJUSTMENT_SEC = 3.0d;
    private static final int BITRATE_ADJUSTMENT_STEPS = 20;
    private static final double BITS_PER_BYTE = 8.0d;
    private int bitrateAdjustmentScaleExp;
    private double deviationBytes;
    private double timeSinceLastAdjustmentMs;

    private double getBitrateAdjustmentScale() {
        return Math.pow(BITRATE_ADJUSTMENT_MAX_SCALE, this.bitrateAdjustmentScaleExp / 20.0d);
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public int getAdjustedBitrateBps() {
        return (int) (this.targetBitrateBps * getBitrateAdjustmentScale());
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public void reportEncodedFrame(int i9) {
        double d9 = this.targetFramerateFps;
        if (d9 == 0.0d) {
            return;
        }
        int i10 = this.targetBitrateBps;
        double d10 = (i9 - ((i10 / BITS_PER_BYTE) / d9)) + this.deviationBytes;
        this.deviationBytes = d10;
        this.timeSinceLastAdjustmentMs = (1000.0d / d9) + this.timeSinceLastAdjustmentMs;
        double d11 = i10 / BITS_PER_BYTE;
        double d12 = BITRATE_ADJUSTMENT_SEC * d11;
        double min = Math.min(d10, d12);
        this.deviationBytes = min;
        double max = Math.max(min, -d12);
        this.deviationBytes = max;
        if (this.timeSinceLastAdjustmentMs <= 3000.0d) {
            return;
        }
        if (max > d11) {
            int i11 = this.bitrateAdjustmentScaleExp - ((int) ((max / d11) + 0.5d));
            this.bitrateAdjustmentScaleExp = i11;
            this.bitrateAdjustmentScaleExp = Math.max(i11, -20);
            this.deviationBytes = d11;
        } else {
            double d13 = -d11;
            if (max < d13) {
                int i12 = this.bitrateAdjustmentScaleExp + ((int) (((-max) / d11) + 0.5d));
                this.bitrateAdjustmentScaleExp = i12;
                this.bitrateAdjustmentScaleExp = Math.min(i12, BITRATE_ADJUSTMENT_STEPS);
                this.deviationBytes = d13;
            }
        }
        this.timeSinceLastAdjustmentMs = 0.0d;
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public void setTargets(int i9, double d9) {
        int i10 = this.targetBitrateBps;
        if (i10 > 0 && i9 < i10) {
            this.deviationBytes = (this.deviationBytes * i9) / i10;
        }
        super.setTargets(i9, d9);
    }
}
