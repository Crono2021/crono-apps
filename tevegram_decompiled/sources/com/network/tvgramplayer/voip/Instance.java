package com.network.tvgramplayer.voip;

import android.content.Context;
import android.util.Log;
import com.network.tvgramplayer.voip.NativeInstance;
import org.json.JSONObject;
import org.webrtc.ContextUtils;
import org.webrtc.VideoSink;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class Instance {
    public static final int AUDIO_STATE_ACTIVE = 1;
    public static final int AUDIO_STATE_MUTED = 0;
    public static final int DATA_SAVING_ALWAYS = 2;
    public static final int DATA_SAVING_MOBILE = 1;
    public static final int DATA_SAVING_NEVER = 0;
    public static final int DATA_SAVING_ROAMING = 3;
    public static final int ENDPOINT_TYPE_INET = 0;
    public static final int ENDPOINT_TYPE_LAN = 1;
    public static final int ENDPOINT_TYPE_TCP_RELAY = 3;
    public static final int ENDPOINT_TYPE_UDP_RELAY = 2;
    public static final String ERROR_AUDIO_IO = "ERROR_AUDIO_IO";
    public static final String ERROR_CONNECTION_SERVICE = "ERROR_CONNECTION_SERVICE";
    public static final String ERROR_INCOMPATIBLE = "ERROR_INCOMPATIBLE";
    public static final String ERROR_INSECURE_UPGRADE = "ERROR_INSECURE_UPGRADE";
    public static final String ERROR_LOCALIZED = "ERROR_LOCALIZED";
    public static final String ERROR_PEER_OUTDATED = "ERROR_PEER_OUTDATED";
    public static final String ERROR_PRIVACY = "ERROR_PRIVACY";
    public static final String ERROR_TIMEOUT = "ERROR_TIMEOUT";
    public static final String ERROR_UNKNOWN = "ERROR_UNKNOWN";
    public static final int NET_TYPE_3G = 3;
    public static final int NET_TYPE_DIALUP = 10;
    public static final int NET_TYPE_EDGE = 2;
    public static final int NET_TYPE_ETHERNET = 7;
    public static final int NET_TYPE_GPRS = 1;
    public static final int NET_TYPE_HSPA = 4;
    public static final int NET_TYPE_LTE = 5;
    public static final int NET_TYPE_OTHER_HIGH_SPEED = 8;
    public static final int NET_TYPE_OTHER_LOW_SPEED = 9;
    public static final int NET_TYPE_OTHER_MOBILE = 11;
    public static final int NET_TYPE_UNKNOWN = 0;
    public static final int NET_TYPE_WIFI = 6;
    public static final int PEER_CAP_GROUP_CALLS = 1;
    public static final int STATE_ESTABLISHED = 3;
    public static final int STATE_FAILED = 4;
    public static final int STATE_RECONNECTING = 5;
    public static final int STATE_WAIT_INIT = 1;
    public static final int STATE_WAIT_INIT_ACK = 2;
    private static final String TAG = "Instance";
    public static final int VIDEO_STATE_ACTIVE = 2;
    public static final int VIDEO_STATE_INACTIVE = 0;
    public static final int VIDEO_STATE_PAUSED = 1;
    private static Context applicationContext;
    private static int bufferSize;
    private static ServerConfig globalServerConfig = new ServerConfig(new JSONObject());
    private static NativeInstance instance;

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static final class Config {
        public final String customParameters;
        public final int dataSaving;
        public final boolean enableAec;
        public final boolean enableAgc;
        public final boolean enableCallUpgrade;
        public final boolean enableNs;
        public final boolean enableP2p;
        public final boolean enableSm;
        public final double initializationTimeout;
        public final String logPath;
        public final int maxApiLayer;
        public final double receiveTimeout;
        public final String statsLogPath;

        public Config(double d9, double d10, int i9, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, String str, String str2, int i10, String str3) {
            this.initializationTimeout = d9;
            this.receiveTimeout = d10;
            this.dataSaving = i9;
            this.enableP2p = z8;
            this.enableAec = z9;
            this.enableNs = z10;
            this.enableAgc = z11;
            this.enableCallUpgrade = z12;
            this.logPath = str;
            this.statsLogPath = str2;
            this.maxApiLayer = i10;
            this.enableSm = z13;
            this.customParameters = str3;
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static final class EncryptionKey {
        public final boolean isOutgoing;
        public final byte[] value;

        public EncryptionKey(byte[] bArr, boolean z8) {
            this.value = bArr;
            this.isOutgoing = z8;
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static final class Endpoint {
        public final long id;
        public final String ipv4;
        public final String ipv6;
        public final boolean isRtc;
        public final String password;
        public final byte[] peerTag;
        public final int port;
        public int reflectorId;
        public final boolean stun;
        public final boolean tcp;
        public final boolean turn;
        public final int type;
        public final String username;

        public Endpoint(boolean z8, long j5, String str, String str2, int i9, int i10, byte[] bArr, boolean z9, boolean z10, String str3, String str4, boolean z11) {
            this.isRtc = z8;
            this.id = j5;
            this.ipv4 = str;
            this.ipv6 = str2;
            this.port = i9;
            this.type = i10;
            this.peerTag = bArr;
            this.turn = z9;
            this.stun = z10;
            if (z8) {
                this.username = str3;
                this.password = str4;
            } else if (bArr != null) {
                this.username = "reflector";
                this.password = bytesToHex(bArr);
            } else {
                this.username = null;
                this.password = null;
            }
            this.tcp = z11;
        }

        private static String bytesToHex(byte[] bArr) {
            StringBuilder sb = new StringBuilder();
            for (byte b9 : bArr) {
                sb.append(String.format("%02x", Byte.valueOf(b9)));
            }
            return sb.toString();
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static final class FinalState {
        public String debugLog;
        public final boolean isRatingSuggested;
        public final byte[] persistentState;
        public final TrafficStats trafficStats;

        public FinalState(byte[] bArr, String str, TrafficStats trafficStats, boolean z8) {
            this.persistentState = bArr;
            this.debugLog = str;
            this.trafficStats = trafficStats;
            this.isRatingSuggested = z8;
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static final class Fingerprint {
        public final String fingerprint;
        public final String hash;
        public final String setup;

        public Fingerprint(String str, String str2, String str3) {
            this.hash = str;
            this.setup = str2;
            this.fingerprint = str3;
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface OnRemoteMediaStateUpdatedListener {
        void onMediaStateUpdated(int i9, int i10);
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface OnSignalBarsUpdatedListener {
        void onSignalBarsUpdated(int i9);
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface OnSignalingDataListener {
        void onSignalingData(byte[] bArr);
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface OnStateUpdatedListener {
        void onStateUpdated(int i9, boolean z8);
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static final class Proxy {
        public final String host;
        public final String login;
        public final String password;
        public final int port;

        public Proxy(String str, int i9, String str2, String str3) {
            this.host = str;
            this.port = i9;
            this.login = str2;
            this.password = str3;
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static final class TrafficStats {
        public final long bytesReceivedMobile;
        public final long bytesReceivedWifi;
        public final long bytesSentMobile;
        public final long bytesSentWifi;

        public TrafficStats(long j5, long j9, long j10, long j11) {
            this.bytesSentWifi = j5;
            this.bytesReceivedWifi = j9;
            this.bytesSentMobile = j10;
            this.bytesReceivedMobile = j11;
        }
    }

    public static int getConnectionMaxLayer() {
        return 92;
    }

    public static ServerConfig getGlobalServerConfig() {
        return globalServerConfig;
    }

    public static NativeInstance makeInstance(String str, Config config, String str2, Endpoint[] endpointArr, Proxy proxy, int i9, EncryptionKey encryptionKey, VideoSink videoSink, long j5, NativeInstance.AudioLevelsCallback audioLevelsCallback) {
        Context context;
        if (!"2.4.4".equals(str) && (context = applicationContext) != null) {
            ContextUtils.initialize(context);
        }
        instance = NativeInstance.make(str, config, str2, endpointArr, proxy, i9, encryptionKey, videoSink, j5, audioLevelsCallback);
        setBufferSize(bufferSize);
        return instance;
    }

    public static void setBufferSize(int i9) {
        bufferSize = i9;
        NativeInstance nativeInstance = instance;
        if (nativeInstance != null) {
            nativeInstance.setBufferSize(i9);
        }
    }

    public static void setContext(Context context) {
        applicationContext = context;
    }

    public static void setGlobalServerConfig(String str) {
        try {
            if (instance != null) {
                globalServerConfig = new ServerConfig(new JSONObject(str));
                instance.setGlobalServerConfig(str);
            }
        } catch (Exception e9) {
            Log.e(TAG, "failed to set server config", e9);
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static final class ServerConfig {
        public final boolean enableStunMarking;
        public final boolean enable_h264_decoder;
        public final boolean enable_h264_encoder;
        public final boolean enable_h265_decoder;
        public final boolean enable_h265_encoder;
        public final boolean enable_vp8_decoder;
        public final boolean enable_vp8_encoder;
        public final boolean enable_vp9_decoder;
        public final boolean enable_vp9_encoder;
        public final double hangupUiTimeout;
        private final JSONObject jsonObject;
        public final boolean useSystemAec;
        public final boolean useSystemNs;

        public ServerConfig(JSONObject jSONObject) {
            this.jsonObject = jSONObject;
            this.useSystemNs = jSONObject.optBoolean("use_system_ns", true);
            this.useSystemAec = jSONObject.optBoolean("use_system_aec", true);
            this.enableStunMarking = jSONObject.optBoolean("voip_enable_stun_marking", false);
            this.hangupUiTimeout = jSONObject.optDouble("hangup_ui_timeout", 5.0d);
            this.enable_vp8_encoder = jSONObject.optBoolean("enable_vp8_encoder", true);
            this.enable_vp8_decoder = jSONObject.optBoolean("enable_vp8_decoder", true);
            this.enable_vp9_encoder = jSONObject.optBoolean("enable_vp9_encoder", true);
            this.enable_vp9_decoder = jSONObject.optBoolean("enable_vp9_decoder", true);
            this.enable_h265_encoder = jSONObject.optBoolean("enable_h265_encoder", true);
            this.enable_h265_decoder = jSONObject.optBoolean("enable_h265_decoder", true);
            this.enable_h264_encoder = jSONObject.optBoolean("enable_h264_encoder", true);
            this.enable_h264_decoder = jSONObject.optBoolean("enable_h264_decoder", true);
        }

        public String getString(String str) {
            return getString(str, "");
        }

        public String getString(String str, String str2) {
            return this.jsonObject.optString(str, str2);
        }
    }
}
