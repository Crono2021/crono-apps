package androidx.media;

import androidx.activity.g;
import java.util.Arrays;
import org.webrtc.PeerConnectionFactory;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f967a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f968b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f969c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f970d = -1;

    public final boolean equals(Object obj) {
        int i9;
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f968b == audioAttributesImplBase.f968b) {
            int i10 = this.f969c;
            int i11 = audioAttributesImplBase.f969c;
            int i12 = audioAttributesImplBase.f970d;
            if (i12 == -1) {
                int i13 = audioAttributesImplBase.f967a;
                int i14 = AudioAttributesCompat.f963b;
                if ((i11 & 1) != 1) {
                    i9 = 4;
                    if ((i11 & 4) != 4) {
                        switch (i13) {
                            case 2:
                                i9 = 0;
                                break;
                            case 3:
                                i9 = 8;
                                break;
                            case 4:
                                break;
                            case 5:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                                i9 = 5;
                                break;
                            case 6:
                                i9 = 2;
                                break;
                            case 11:
                                i9 = 10;
                                break;
                            case 12:
                            default:
                                i9 = 3;
                                break;
                            case 13:
                                i9 = 1;
                                break;
                        }
                    } else {
                        i9 = 6;
                    }
                } else {
                    i9 = 7;
                }
            } else {
                i9 = i12;
            }
            if (i9 == 6) {
                i11 |= 4;
            } else if (i9 == 7) {
                i11 |= 1;
            }
            if (i10 == (i11 & 273) && this.f967a == audioAttributesImplBase.f967a && this.f970d == i12) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f968b), Integer.valueOf(this.f969c), Integer.valueOf(this.f967a), Integer.valueOf(this.f970d)});
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f970d != -1) {
            sb.append(" stream=");
            sb.append(this.f970d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        int i9 = this.f967a;
        int i10 = AudioAttributesCompat.f963b;
        switch (i9) {
            case 0:
                str = "USAGE_UNKNOWN";
                break;
            case 1:
                str = "USAGE_MEDIA";
                break;
            case 2:
                str = "USAGE_VOICE_COMMUNICATION";
                break;
            case 3:
                str = "USAGE_VOICE_COMMUNICATION_SIGNALLING";
                break;
            case 4:
                str = "USAGE_ALARM";
                break;
            case 5:
                str = "USAGE_NOTIFICATION";
                break;
            case 6:
                str = "USAGE_NOTIFICATION_RINGTONE";
                break;
            case 7:
                str = "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
                break;
            case 8:
                str = "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
                break;
            case 9:
                str = "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
                break;
            case 10:
                str = "USAGE_NOTIFICATION_EVENT";
                break;
            case 11:
                str = "USAGE_ASSISTANCE_ACCESSIBILITY";
                break;
            case 12:
                str = "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
                break;
            case 13:
                str = "USAGE_ASSISTANCE_SONIFICATION";
                break;
            case 14:
                str = "USAGE_GAME";
                break;
            case 15:
            default:
                str = g.m(i9, "unknown usage ");
                break;
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                str = "USAGE_ASSISTANT";
                break;
        }
        sb.append(str);
        sb.append(" content=");
        sb.append(this.f968b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f969c).toUpperCase());
        return sb.toString();
    }
}
