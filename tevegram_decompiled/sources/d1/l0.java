package d1;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class l0 {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f2494a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f2495b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    public static String a(String str, String str2) {
        if (str != null && str2 != null) {
            String[] V = g1.w.V(str);
            StringBuilder sb = new StringBuilder();
            for (String str3 : V) {
                if (str2.equals(c(str3))) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(str3);
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
        }
        return null;
    }

    public static int b(String str, String str2) {
        k0 e9;
        str.getClass();
        switch (str) {
            case "audio/eac3-joc":
                return 18;
            case "audio/vnd.dts.hd;profile=lbr":
                return 8;
            case "audio/vnd.dts":
                return 7;
            case "audio/mp4a-latm":
                if (str2 == null || (e9 = e(str2)) == null) {
                    return 0;
                }
                return e9.a();
            case "audio/ac3":
                return 5;
            case "audio/ac4":
                return 17;
            case "audio/vnd.dts.uhd;profile=p2":
                return 30;
            case "audio/eac3":
                return 6;
            case "audio/mpeg":
                return 9;
            case "audio/opus":
                return 20;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    public static String c(String str) {
        k0 e9;
        String str2 = null;
        if (str != null) {
            String U = a.a.U(str.trim());
            if (U.startsWith("avc1") || U.startsWith("avc3")) {
                return "video/avc";
            }
            if (U.startsWith("hev1") || U.startsWith("hvc1")) {
                return "video/hevc";
            }
            if (U.startsWith("dvav") || U.startsWith("dva1") || U.startsWith("dvhe") || U.startsWith("dvh1")) {
                return "video/dolby-vision";
            }
            if (U.startsWith("av01")) {
                return "video/av01";
            }
            if (U.startsWith("vp9") || U.startsWith("vp09")) {
                return "video/x-vnd.on2.vp9";
            }
            if (U.startsWith("vp8") || U.startsWith("vp08")) {
                return "video/x-vnd.on2.vp8";
            }
            if (U.startsWith("mp4a")) {
                if (U.startsWith("mp4a.") && (e9 = e(U)) != null) {
                    str2 = d(e9.f2492a);
                }
                return str2 == null ? "audio/mp4a-latm" : str2;
            }
            if (U.startsWith("mha1")) {
                return "audio/mha1";
            }
            if (U.startsWith("mhm1")) {
                return "audio/mhm1";
            }
            if (U.startsWith("ac-3") || U.startsWith("dac3")) {
                return "audio/ac3";
            }
            if (U.startsWith("ec-3") || U.startsWith("dec3")) {
                return "audio/eac3";
            }
            if (U.startsWith("ec+3")) {
                return "audio/eac3-joc";
            }
            if (U.startsWith("ac-4") || U.startsWith("dac4")) {
                return "audio/ac4";
            }
            if (U.startsWith("dtsc")) {
                return "audio/vnd.dts";
            }
            if (U.startsWith("dtse")) {
                return "audio/vnd.dts.hd;profile=lbr";
            }
            if (U.startsWith("dtsh") || U.startsWith("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if (U.startsWith("dtsx")) {
                return "audio/vnd.dts.uhd;profile=p2";
            }
            if (U.startsWith("opus")) {
                return "audio/opus";
            }
            if (U.startsWith("vorbis")) {
                return "audio/vorbis";
            }
            if (U.startsWith("flac")) {
                return "audio/flac";
            }
            if (U.startsWith("stpp")) {
                return "application/ttml+xml";
            }
            if (U.startsWith("wvtt")) {
                return "text/vtt";
            }
            if (U.contains("cea708")) {
                return "application/cea-708";
            }
            if (U.contains("eia608") || U.contains("cea608")) {
                return "application/cea-608";
            }
            ArrayList arrayList = f2494a;
            if (arrayList.size() > 0) {
                arrayList.get(0).getClass();
                androidx.fragment.app.a.c();
                return null;
            }
        }
        return null;
    }

    public static String d(int i9) {
        if (i9 == 32) {
            return "video/mp4v-es";
        }
        if (i9 == 33) {
            return "video/avc";
        }
        if (i9 == 35) {
            return "video/hevc";
        }
        if (i9 == 64) {
            return "audio/mp4a-latm";
        }
        if (i9 == 163) {
            return "video/wvc1";
        }
        if (i9 == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i9 == 221) {
            return "audio/vorbis";
        }
        if (i9 == 165) {
            return "audio/ac3";
        }
        if (i9 == 166) {
            return "audio/eac3";
        }
        switch (i9) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            default:
                switch (i9) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    public static k0 e(String str) {
        Matcher matcher = f2495b.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(1);
        group.getClass();
        String group2 = matcher.group(2);
        try {
            return new k0(Integer.parseInt(group, 16), group2 != null ? Integer.parseInt(group2) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String f(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    public static int g(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (h(str)) {
            return 1;
        }
        if (j(str)) {
            return 2;
        }
        if (i(str)) {
            return 3;
        }
        if ("image".equals(f(str)) || "application/x-image-uri".equals(str)) {
            return 4;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        ArrayList arrayList = f2494a;
        if (arrayList.size() <= 0) {
            return -1;
        }
        arrayList.get(0).getClass();
        androidx.fragment.app.a.c();
        return 0;
    }

    public static boolean h(String str) {
        return "audio".equals(f(str));
    }

    public static boolean i(String str) {
        return "text".equals(f(str)) || "application/x-media3-cues".equals(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str);
    }

    public static boolean j(String str) {
        return "video".equals(f(str));
    }

    public static String k(String str) {
        String U;
        if (str == null) {
            return null;
        }
        U = a.a.U(str);
        U.getClass();
        switch (U) {
            case "audio/x-flac":
                return "audio/flac";
            case "application/x-mpegurl":
                return "application/x-mpegURL";
            case "audio/x-wav":
                return "audio/wav";
            case "audio/mpeg-l1":
                return "audio/mpeg-L1";
            case "audio/mpeg-l2":
                return "audio/mpeg-L2";
            case "audio/mp3":
                return "audio/mpeg";
            default:
                return U;
        }
    }
}
