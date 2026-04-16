package org.webrtc.audio;

import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.NoiseSuppressor;
import androidx.activity.g;
import java.util.UUID;
import m7.c;
import org.webrtc.Logging;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
class WebRtcAudioEffects {
    private static final UUID AOSP_ACOUSTIC_ECHO_CANCELER = UUID.fromString("bb392ec0-8d4d-11e0-a896-0002a5d5c51b");
    private static final UUID AOSP_NOISE_SUPPRESSOR = UUID.fromString("c06c8400-8e06-11e0-9cb6-0002a5d5c51b");
    private static final boolean DEBUG = false;
    private static final String TAG = "WebRtcAudioEffectsExternal";
    private static AudioEffect.Descriptor[] cachedEffects;
    private AcousticEchoCanceler aec;
    private NoiseSuppressor ns;
    private boolean shouldEnableAec;
    private boolean shouldEnableNs;

    public WebRtcAudioEffects() {
        g.y(new StringBuilder("ctor"), WebRtcAudioUtils.getThreadInfo(), TAG);
    }

    private static void assertTrue(boolean z8) {
        if (z8) {
            return;
        }
        c.e("Expected condition to be true");
    }

    private boolean effectTypeIsVoIP(UUID uuid) {
        if (AudioEffect.EFFECT_TYPE_AEC.equals(uuid) && isAcousticEchoCancelerSupported()) {
            return true;
        }
        if (AudioEffect.EFFECT_TYPE_NS.equals(uuid) && isNoiseSuppressorSupported()) {
            return true;
        }
        return DEBUG;
    }

    private static AudioEffect.Descriptor[] getAvailableEffects() {
        AudioEffect.Descriptor[] descriptorArr = cachedEffects;
        if (descriptorArr != null) {
            return descriptorArr;
        }
        AudioEffect.Descriptor[] queryEffects = AudioEffect.queryEffects();
        cachedEffects = queryEffects;
        return queryEffects;
    }

    public static boolean isAcousticEchoCancelerSupported() {
        return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_AEC, AOSP_ACOUSTIC_ECHO_CANCELER);
    }

    private static boolean isEffectTypeAvailable(UUID uuid, UUID uuid2) {
        AudioEffect.Descriptor[] availableEffects = getAvailableEffects();
        if (availableEffects == null) {
            return DEBUG;
        }
        for (AudioEffect.Descriptor descriptor : availableEffects) {
            if (descriptor.type.equals(uuid)) {
                return !r4.uuid.equals(uuid2);
            }
        }
        return DEBUG;
    }

    public static boolean isNoiseSuppressorSupported() {
        return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_NS, AOSP_NOISE_SUPPRESSOR);
    }

    public void enable(int i9) {
        Logging.d(TAG, "enable(audioSession=" + i9 + ")");
        AcousticEchoCanceler acousticEchoCanceler = this.aec;
        boolean z8 = DEBUG;
        assertTrue(acousticEchoCanceler == null ? true : DEBUG);
        assertTrue(this.ns == null ? true : DEBUG);
        if (isAcousticEchoCancelerSupported()) {
            AcousticEchoCanceler create = AcousticEchoCanceler.create(i9);
            this.aec = create;
            if (create != null) {
                boolean enabled = create.getEnabled();
                boolean z9 = (this.shouldEnableAec && isAcousticEchoCancelerSupported()) ? true : DEBUG;
                if (this.aec.setEnabled(z9) != 0) {
                    Logging.e(TAG, "Failed to set the AcousticEchoCanceler state");
                }
                StringBuilder sb = new StringBuilder("AcousticEchoCanceler: was ");
                sb.append(enabled ? "enabled" : "disabled");
                sb.append(", enable: ");
                sb.append(z9);
                sb.append(", is now: ");
                g.y(sb, this.aec.getEnabled() ? "enabled" : "disabled", TAG);
            } else {
                Logging.e(TAG, "Failed to create the AcousticEchoCanceler instance");
            }
        }
        if (isNoiseSuppressorSupported()) {
            NoiseSuppressor create2 = NoiseSuppressor.create(i9);
            this.ns = create2;
            if (create2 == null) {
                Logging.e(TAG, "Failed to create the NoiseSuppressor instance");
                return;
            }
            boolean enabled2 = create2.getEnabled();
            if (this.shouldEnableNs && isNoiseSuppressorSupported()) {
                z8 = true;
            }
            if (this.ns.setEnabled(z8) != 0) {
                Logging.e(TAG, "Failed to set the NoiseSuppressor state");
            }
            StringBuilder sb2 = new StringBuilder("NoiseSuppressor: was ");
            sb2.append(enabled2 ? "enabled" : "disabled");
            sb2.append(", enable: ");
            sb2.append(z8);
            sb2.append(", is now: ");
            g.y(sb2, this.ns.getEnabled() ? "enabled" : "disabled", TAG);
        }
    }

    public void release() {
        Logging.d(TAG, "release");
        AcousticEchoCanceler acousticEchoCanceler = this.aec;
        if (acousticEchoCanceler != null) {
            acousticEchoCanceler.release();
            this.aec = null;
        }
        NoiseSuppressor noiseSuppressor = this.ns;
        if (noiseSuppressor != null) {
            noiseSuppressor.release();
            this.ns = null;
        }
    }

    public boolean setAEC(boolean z8) {
        Logging.d(TAG, "setAEC(" + z8 + ")");
        if (!isAcousticEchoCancelerSupported()) {
            Logging.w(TAG, "Platform AEC is not supported");
            this.shouldEnableAec = DEBUG;
            return DEBUG;
        }
        if (this.aec == null || z8 == this.shouldEnableAec) {
            this.shouldEnableAec = z8;
            return true;
        }
        Logging.e(TAG, "Platform AEC state can't be modified while recording");
        return DEBUG;
    }

    public boolean setNS(boolean z8) {
        Logging.d(TAG, "setNS(" + z8 + ")");
        if (!isNoiseSuppressorSupported()) {
            Logging.w(TAG, "Platform NS is not supported");
            this.shouldEnableNs = DEBUG;
            return DEBUG;
        }
        if (this.ns == null || z8 == this.shouldEnableNs) {
            this.shouldEnableNs = z8;
            return true;
        }
        Logging.e(TAG, "Platform NS state can't be modified while recording");
        return DEBUG;
    }

    public boolean toggleNS(boolean z8) {
        if (this.ns == null) {
            Logging.e(TAG, "Attempting to enable or disable nonexistent NoiseSuppressor.");
            return DEBUG;
        }
        Logging.d(TAG, "toggleNS(" + z8 + ")");
        if (this.ns.setEnabled(z8) == 0) {
            return true;
        }
        return DEBUG;
    }
}
