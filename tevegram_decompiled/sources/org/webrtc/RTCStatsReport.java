package org.webrtc;

import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class RTCStatsReport {
    private final Map<String, RTCStats> stats;
    private final long timestampUs;

    public RTCStatsReport(long j5, Map<String, RTCStats> map) {
        this.timestampUs = j5;
        this.stats = map;
    }

    @CalledByNative
    private static RTCStatsReport create(long j5, Map map) {
        return new RTCStatsReport(j5, map);
    }

    public Map<String, RTCStats> getStatsMap() {
        return this.stats;
    }

    public double getTimestampUs() {
        return this.timestampUs;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{ timestampUs: ");
        sb.append(this.timestampUs);
        sb.append(", stats: [\n");
        boolean z8 = true;
        for (RTCStats rTCStats : this.stats.values()) {
            if (!z8) {
                sb.append(",\n");
            }
            sb.append(rTCStats);
            z8 = false;
        }
        sb.append(" ] }");
        return sb.toString();
    }
}
