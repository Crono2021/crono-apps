package org.webrtc;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class StatsReport {
    public final String id;
    public final double timestamp;
    public final String type;
    public final Value[] values;

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static class Value {
        public final String name;
        public final String value;

        @CalledByNative("Value")
        public Value(String str, String str2) {
            this.name = str;
            this.value = str2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            sb.append(this.name);
            sb.append(": ");
            return androidx.activity.g.o(sb, this.value, "]");
        }
    }

    @CalledByNative
    public StatsReport(String str, String str2, double d9, Value[] valueArr) {
        this.id = str;
        this.type = str2;
        this.timestamp = d9;
        this.values = valueArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("id: ");
        sb.append(this.id);
        sb.append(", type: ");
        sb.append(this.type);
        sb.append(", timestamp: ");
        sb.append(this.timestamp);
        sb.append(", values: ");
        int i9 = 0;
        while (true) {
            Value[] valueArr = this.values;
            if (i9 >= valueArr.length) {
                return sb.toString();
            }
            sb.append(valueArr[i9].toString());
            sb.append(", ");
            i9++;
        }
    }
}
