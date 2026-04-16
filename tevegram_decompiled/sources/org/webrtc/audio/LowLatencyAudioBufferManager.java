package org.webrtc.audio;

import android.media.AudioTrack;
import android.os.Build;
import org.webrtc.Logging;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
class LowLatencyAudioBufferManager {
    private static final String TAG = "LowLatencyAudioBufferManager";
    private int prevUnderrunCount = 0;
    private int ticksUntilNextDecrease = 10;
    private boolean keepLoweringBufferSize = true;
    private int bufferIncreaseCounter = 0;

    public void maybeAdjustBufferSize(AudioTrack audioTrack) {
        int underrunCount;
        int bufferSizeInFrames;
        int bufferSizeInFrames2;
        if (Build.VERSION.SDK_INT >= 26) {
            underrunCount = audioTrack.getUnderrunCount();
            if (underrunCount > this.prevUnderrunCount) {
                if (this.bufferIncreaseCounter < 5) {
                    bufferSizeInFrames2 = audioTrack.getBufferSizeInFrames();
                    int playbackRate = (audioTrack.getPlaybackRate() / 100) + bufferSizeInFrames2;
                    Logging.d(TAG, "Underrun detected! Increasing AudioTrack buffer size from " + bufferSizeInFrames2 + " to " + playbackRate);
                    audioTrack.setBufferSizeInFrames(playbackRate);
                    this.bufferIncreaseCounter = this.bufferIncreaseCounter + 1;
                }
                this.keepLoweringBufferSize = false;
                this.prevUnderrunCount = underrunCount;
                this.ticksUntilNextDecrease = 10;
                return;
            }
            if (this.keepLoweringBufferSize) {
                int i9 = this.ticksUntilNextDecrease - 1;
                this.ticksUntilNextDecrease = i9;
                if (i9 <= 0) {
                    int playbackRate2 = audioTrack.getPlaybackRate() / 100;
                    bufferSizeInFrames = audioTrack.getBufferSizeInFrames();
                    int max = Math.max(playbackRate2, bufferSizeInFrames - playbackRate2);
                    if (max != bufferSizeInFrames) {
                        Logging.d(TAG, "Lowering AudioTrack buffer size from " + bufferSizeInFrames + " to " + max);
                        audioTrack.setBufferSizeInFrames(max);
                    }
                    this.ticksUntilNextDecrease = 10;
                }
            }
        }
    }
}
