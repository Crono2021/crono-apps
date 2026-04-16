package org.webrtc.voiceengine;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import androidx.activity.g;
import java.util.Arrays;
import java.util.List;
import org.webrtc.ContextUtils;
import org.webrtc.Logging;
import org.webrtc.PeerConnectionFactory;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class WebRtcAudioUtils {
    private static final int DEFAULT_SAMPLE_RATE_HZ = 16000;
    private static final String TAG = "WebRtcAudioUtils";
    private static int defaultSampleRateHz = 16000;
    private static boolean isDefaultSampleRateOverridden;
    private static boolean useWebRtcBasedAcousticEchoCanceler;
    private static boolean useWebRtcBasedNoiseSuppressor;
    private static final String[] BLACKLISTED_OPEN_SL_ES_MODELS = new String[0];
    private static final String[] BLACKLISTED_AEC_MODELS = new String[0];
    private static final String[] BLACKLISTED_NS_MODELS = new String[0];

    public static boolean deviceIsBlacklistedForOpenSLESUsage() {
        return Arrays.asList(BLACKLISTED_OPEN_SL_ES_MODELS).contains(Build.MODEL);
    }

    private static String deviceTypeToString(int i9) {
        switch (i9) {
            case 1:
                return "TYPE_BUILTIN_EARPIECE";
            case 2:
                return "TYPE_BUILTIN_SPEAKER";
            case 3:
                return "TYPE_WIRED_HEADSET";
            case 4:
                return "TYPE_WIRED_HEADPHONES";
            case 5:
                return "TYPE_LINE_ANALOG";
            case 6:
                return "TYPE_LINE_DIGITAL";
            case 7:
                return "TYPE_BLUETOOTH_SCO";
            case 8:
                return "TYPE_BLUETOOTH_A2DP";
            case 9:
                return "TYPE_HDMI";
            case 10:
                return "TYPE_HDMI_ARC";
            case 11:
                return "TYPE_USB_DEVICE";
            case 12:
                return "TYPE_USB_ACCESSORY";
            case 13:
                return "TYPE_DOCK";
            case 14:
                return "TYPE_FM";
            case 15:
                return "TYPE_BUILTIN_MIC";
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                return "TYPE_FM_TUNER";
            case 17:
                return "TYPE_TV_TUNER";
            case 18:
                return "TYPE_TELEPHONY";
            case 19:
                return "TYPE_AUX_LINE";
            case 20:
                return "TYPE_IP";
            case 21:
                return "TYPE_BUS";
            case 22:
                return "TYPE_USB_HEADSET";
            default:
                return "TYPE_UNKNOWN";
        }
    }

    public static List<String> getBlackListedModelsForAecUsage() {
        return Arrays.asList(BLACKLISTED_AEC_MODELS);
    }

    public static List<String> getBlackListedModelsForNsUsage() {
        return Arrays.asList(BLACKLISTED_NS_MODELS);
    }

    public static synchronized int getDefaultSampleRateHz() {
        int i9;
        synchronized (WebRtcAudioUtils.class) {
            i9 = defaultSampleRateHz;
        }
        return i9;
    }

    public static String getThreadInfo() {
        return "@[name=" + Thread.currentThread().getName() + ", id=" + Thread.currentThread().getId() + "]";
    }

    private static boolean hasMicrophone() {
        return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.microphone");
    }

    public static boolean isAcousticEchoCancelerSupported() {
        return WebRtcAudioEffects.canUseAcousticEchoCanceler();
    }

    public static boolean isAutomaticGainControlSupported() {
        return false;
    }

    public static synchronized boolean isDefaultSampleRateOverridden() {
        boolean z8;
        synchronized (WebRtcAudioUtils.class) {
            z8 = isDefaultSampleRateOverridden;
        }
        return z8;
    }

    public static boolean isNoiseSuppressorSupported() {
        return WebRtcAudioEffects.canUseNoiseSuppressor();
    }

    private static boolean isVolumeFixed(AudioManager audioManager) {
        return audioManager.isVolumeFixed();
    }

    private static void logAudioDeviceInfo(String str, AudioManager audioManager) {
        AudioDeviceInfo[] devices;
        int type;
        boolean isSource;
        int[] channelCounts;
        int[] encodings;
        int[] sampleRates;
        int id;
        int[] sampleRates2;
        int[] encodings2;
        int[] channelCounts2;
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        devices = audioManager.getDevices(3);
        if (devices.length == 0) {
            return;
        }
        Logging.d(str, "Audio Devices: ");
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            StringBuilder sb = new StringBuilder("  ");
            type = audioDeviceInfo.getType();
            sb.append(deviceTypeToString(type));
            isSource = audioDeviceInfo.isSource();
            sb.append(isSource ? "(in): " : "(out): ");
            channelCounts = audioDeviceInfo.getChannelCounts();
            if (channelCounts.length > 0) {
                sb.append("channels=");
                channelCounts2 = audioDeviceInfo.getChannelCounts();
                sb.append(Arrays.toString(channelCounts2));
                sb.append(", ");
            }
            encodings = audioDeviceInfo.getEncodings();
            if (encodings.length > 0) {
                sb.append("encodings=");
                encodings2 = audioDeviceInfo.getEncodings();
                sb.append(Arrays.toString(encodings2));
                sb.append(", ");
            }
            sampleRates = audioDeviceInfo.getSampleRates();
            if (sampleRates.length > 0) {
                sb.append("sample rates=");
                sampleRates2 = audioDeviceInfo.getSampleRates();
                sb.append(Arrays.toString(sampleRates2));
                sb.append(", ");
            }
            sb.append("id=");
            id = audioDeviceInfo.getId();
            sb.append(id);
            Logging.d(str, sb.toString());
        }
    }

    public static void logAudioState(String str) {
        logDeviceInfo(str);
        AudioManager audioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");
        logAudioStateBasic(str, audioManager);
        logAudioStateVolume(str, audioManager);
        logAudioDeviceInfo(str, audioManager);
    }

    private static void logAudioStateBasic(String str, AudioManager audioManager) {
        Logging.d(str, "Audio State: audio mode: " + modeToString(audioManager.getMode()) + ", has mic: " + hasMicrophone() + ", mic muted: " + audioManager.isMicrophoneMute() + ", music active: " + audioManager.isMusicActive() + ", speakerphone: " + audioManager.isSpeakerphoneOn() + ", BT SCO: " + audioManager.isBluetoothScoOn());
    }

    private static void logAudioStateVolume(String str, AudioManager audioManager) {
        int[] iArr = {0, 3, 2, 4, 5, 1};
        Logging.d(str, "Audio State: ");
        boolean isVolumeFixed = isVolumeFixed(audioManager);
        Logging.d(str, "  fixed volume=" + isVolumeFixed);
        if (isVolumeFixed) {
            return;
        }
        for (int i9 = 0; i9 < 6; i9++) {
            int i10 = iArr[i9];
            StringBuilder sb = new StringBuilder();
            sb.append("  " + streamTypeToString(i10) + ": ");
            sb.append("volume=");
            sb.append(audioManager.getStreamVolume(i10));
            sb.append(", max=");
            sb.append(audioManager.getStreamMaxVolume(i10));
            logIsStreamMute(str, audioManager, i10, sb);
            Logging.d(str, sb.toString());
        }
    }

    public static void logDeviceInfo(String str) {
        StringBuilder sb = new StringBuilder("Android SDK: ");
        sb.append(Build.VERSION.SDK_INT);
        sb.append(", Release: ");
        sb.append(Build.VERSION.RELEASE);
        sb.append(", Brand: ");
        sb.append(Build.BRAND);
        sb.append(", Device: ");
        sb.append(Build.DEVICE);
        sb.append(", Id: ");
        sb.append(Build.ID);
        sb.append(", Hardware: ");
        sb.append(Build.HARDWARE);
        sb.append(", Manufacturer: ");
        sb.append(Build.MANUFACTURER);
        sb.append(", Model: ");
        sb.append(Build.MODEL);
        sb.append(", Product: ");
        g.y(sb, Build.PRODUCT, str);
    }

    private static void logIsStreamMute(String str, AudioManager audioManager, int i9, StringBuilder sb) {
        boolean isStreamMute;
        if (Build.VERSION.SDK_INT >= 23) {
            sb.append(", muted=");
            isStreamMute = audioManager.isStreamMute(i9);
            sb.append(isStreamMute);
        }
    }

    public static String modeToString(int i9) {
        return i9 != 0 ? i9 != 1 ? i9 != 2 ? i9 != 3 ? "MODE_INVALID" : "MODE_IN_COMMUNICATION" : "MODE_IN_CALL" : "MODE_RINGTONE" : "MODE_NORMAL";
    }

    public static boolean runningOnEmulator() {
        return Build.HARDWARE.equals("goldfish") && Build.BRAND.startsWith("generic_");
    }

    public static synchronized void setDefaultSampleRateHz(int i9) {
        synchronized (WebRtcAudioUtils.class) {
            isDefaultSampleRateOverridden = true;
            defaultSampleRateHz = i9;
        }
    }

    public static synchronized void setWebRtcBasedAcousticEchoCanceler(boolean z8) {
        synchronized (WebRtcAudioUtils.class) {
            useWebRtcBasedAcousticEchoCanceler = z8;
        }
    }

    public static synchronized void setWebRtcBasedAutomaticGainControl(boolean z8) {
        synchronized (WebRtcAudioUtils.class) {
            Logging.w(TAG, "setWebRtcBasedAutomaticGainControl() is deprecated");
        }
    }

    public static synchronized void setWebRtcBasedNoiseSuppressor(boolean z8) {
        synchronized (WebRtcAudioUtils.class) {
            useWebRtcBasedNoiseSuppressor = z8;
        }
    }

    private static String streamTypeToString(int i9) {
        return i9 != 0 ? i9 != 1 ? i9 != 2 ? i9 != 3 ? i9 != 4 ? i9 != 5 ? "STREAM_INVALID" : "STREAM_NOTIFICATION" : "STREAM_ALARM" : "STREAM_MUSIC" : "STREAM_RING" : "STREAM_SYSTEM" : "STREAM_VOICE_CALL";
    }

    public static synchronized boolean useWebRtcBasedAcousticEchoCanceler() {
        boolean z8;
        synchronized (WebRtcAudioUtils.class) {
            try {
                if (useWebRtcBasedAcousticEchoCanceler) {
                    Logging.w(TAG, "Overriding default behavior; now using WebRTC AEC!");
                }
                z8 = useWebRtcBasedAcousticEchoCanceler;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z8;
    }

    public static synchronized boolean useWebRtcBasedAutomaticGainControl() {
        synchronized (WebRtcAudioUtils.class) {
        }
        return true;
    }

    public static synchronized boolean useWebRtcBasedNoiseSuppressor() {
        boolean z8;
        synchronized (WebRtcAudioUtils.class) {
            try {
                if (useWebRtcBasedNoiseSuppressor) {
                    Logging.w(TAG, "Overriding default behavior; now using WebRTC NS!");
                }
                z8 = useWebRtcBasedNoiseSuppressor;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z8;
    }
}
