package g1;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f3657a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f3658b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f3659c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f3660d;

    static {
        HashMap hashMap = new HashMap();
        f3660d = hashMap;
        androidx.activity.g.u(-984833, hashMap, "aliceblue", -332841, "antiquewhite");
        hashMap.put("aqua", -16711681);
        hashMap.put("aquamarine", -8388652);
        androidx.activity.g.u(-983041, hashMap, "azure", -657956, "beige");
        androidx.activity.g.u(-6972, hashMap, "bisque", -16777216, "black");
        androidx.activity.g.u(-5171, hashMap, "blanchedalmond", -16776961, "blue");
        androidx.activity.g.u(-7722014, hashMap, "blueviolet", -5952982, "brown");
        androidx.activity.g.u(-2180985, hashMap, "burlywood", -10510688, "cadetblue");
        androidx.activity.g.u(-8388864, hashMap, "chartreuse", -2987746, "chocolate");
        androidx.activity.g.u(-32944, hashMap, "coral", -10185235, "cornflowerblue");
        androidx.activity.g.u(-1828, hashMap, "cornsilk", -2354116, "crimson");
        hashMap.put("cyan", -16711681);
        hashMap.put("darkblue", -16777077);
        androidx.activity.g.u(-16741493, hashMap, "darkcyan", -4684277, "darkgoldenrod");
        hashMap.put("darkgray", -5658199);
        hashMap.put("darkgreen", -16751616);
        hashMap.put("darkgrey", -5658199);
        hashMap.put("darkkhaki", -4343957);
        androidx.activity.g.u(-7667573, hashMap, "darkmagenta", -11179217, "darkolivegreen");
        androidx.activity.g.u(-29696, hashMap, "darkorange", -6737204, "darkorchid");
        androidx.activity.g.u(-7667712, hashMap, "darkred", -1468806, "darksalmon");
        androidx.activity.g.u(-7357297, hashMap, "darkseagreen", -12042869, "darkslateblue");
        hashMap.put("darkslategray", -13676721);
        hashMap.put("darkslategrey", -13676721);
        hashMap.put("darkturquoise", -16724271);
        hashMap.put("darkviolet", -7077677);
        androidx.activity.g.u(-60269, hashMap, "deeppink", -16728065, "deepskyblue");
        hashMap.put("dimgray", -9868951);
        hashMap.put("dimgrey", -9868951);
        hashMap.put("dodgerblue", -14774017);
        hashMap.put("firebrick", -5103070);
        androidx.activity.g.u(-1296, hashMap, "floralwhite", -14513374, "forestgreen");
        hashMap.put("fuchsia", -65281);
        hashMap.put("gainsboro", -2302756);
        androidx.activity.g.u(-460545, hashMap, "ghostwhite", -10496, "gold");
        hashMap.put("goldenrod", -2448096);
        hashMap.put("gray", -8355712);
        androidx.activity.g.u(-16744448, hashMap, "green", -5374161, "greenyellow");
        hashMap.put("grey", -8355712);
        hashMap.put("honeydew", -983056);
        androidx.activity.g.u(-38476, hashMap, "hotpink", -3318692, "indianred");
        androidx.activity.g.u(-11861886, hashMap, "indigo", -16, "ivory");
        androidx.activity.g.u(-989556, hashMap, "khaki", -1644806, "lavender");
        androidx.activity.g.u(-3851, hashMap, "lavenderblush", -8586240, "lawngreen");
        androidx.activity.g.u(-1331, hashMap, "lemonchiffon", -5383962, "lightblue");
        androidx.activity.g.u(-1015680, hashMap, "lightcoral", -2031617, "lightcyan");
        hashMap.put("lightgoldenrodyellow", -329006);
        hashMap.put("lightgray", -2894893);
        hashMap.put("lightgreen", -7278960);
        hashMap.put("lightgrey", -2894893);
        androidx.activity.g.u(-18751, hashMap, "lightpink", -24454, "lightsalmon");
        androidx.activity.g.u(-14634326, hashMap, "lightseagreen", -7876870, "lightskyblue");
        hashMap.put("lightslategray", -8943463);
        hashMap.put("lightslategrey", -8943463);
        hashMap.put("lightsteelblue", -5192482);
        hashMap.put("lightyellow", -32);
        androidx.activity.g.u(-16711936, hashMap, "lime", -13447886, "limegreen");
        hashMap.put("linen", -331546);
        hashMap.put("magenta", -65281);
        androidx.activity.g.u(-8388608, hashMap, "maroon", -10039894, "mediumaquamarine");
        androidx.activity.g.u(-16777011, hashMap, "mediumblue", -4565549, "mediumorchid");
        androidx.activity.g.u(-7114533, hashMap, "mediumpurple", -12799119, "mediumseagreen");
        androidx.activity.g.u(-8689426, hashMap, "mediumslateblue", -16713062, "mediumspringgreen");
        androidx.activity.g.u(-12004916, hashMap, "mediumturquoise", -3730043, "mediumvioletred");
        androidx.activity.g.u(-15132304, hashMap, "midnightblue", -655366, "mintcream");
        androidx.activity.g.u(-6943, hashMap, "mistyrose", -6987, "moccasin");
        androidx.activity.g.u(-8531, hashMap, "navajowhite", -16777088, "navy");
        androidx.activity.g.u(-133658, hashMap, "oldlace", -8355840, "olive");
        androidx.activity.g.u(-9728477, hashMap, "olivedrab", -23296, "orange");
        androidx.activity.g.u(-47872, hashMap, "orangered", -2461482, "orchid");
        androidx.activity.g.u(-1120086, hashMap, "palegoldenrod", -6751336, "palegreen");
        androidx.activity.g.u(-5247250, hashMap, "paleturquoise", -2396013, "palevioletred");
        androidx.activity.g.u(-4139, hashMap, "papayawhip", -9543, "peachpuff");
        androidx.activity.g.u(-3308225, hashMap, "peru", -16181, "pink");
        androidx.activity.g.u(-2252579, hashMap, "plum", -5185306, "powderblue");
        androidx.activity.g.u(-8388480, hashMap, "purple", -10079335, "rebeccapurple");
        androidx.activity.g.u(-65536, hashMap, "red", -4419697, "rosybrown");
        androidx.activity.g.u(-12490271, hashMap, "royalblue", -7650029, "saddlebrown");
        androidx.activity.g.u(-360334, hashMap, "salmon", -744352, "sandybrown");
        androidx.activity.g.u(-13726889, hashMap, "seagreen", -2578, "seashell");
        androidx.activity.g.u(-6270419, hashMap, "sienna", -4144960, "silver");
        androidx.activity.g.u(-7876885, hashMap, "skyblue", -9807155, "slateblue");
        hashMap.put("slategray", -9404272);
        hashMap.put("slategrey", -9404272);
        hashMap.put("snow", -1286);
        hashMap.put("springgreen", -16711809);
        androidx.activity.g.u(-12156236, hashMap, "steelblue", -2968436, "tan");
        androidx.activity.g.u(-16744320, hashMap, "teal", -2572328, "thistle");
        androidx.activity.g.u(-40121, hashMap, "tomato", 0, "transparent");
        androidx.activity.g.u(-12525360, hashMap, "turquoise", -1146130, "violet");
        androidx.activity.g.u(-663885, hashMap, "wheat", -1, "white");
        androidx.activity.g.u(-657931, hashMap, "whitesmoke", -256, "yellow");
        hashMap.put("yellowgreen", -6632142);
    }

    public static int a(String str, boolean z8) {
        int parseInt;
        a.f(!TextUtils.isEmpty(str));
        String replace = str.replace(" ", "");
        if (replace.charAt(0) == '#') {
            int parseLong = (int) Long.parseLong(replace.substring(1), 16);
            if (replace.length() == 7) {
                return (-16777216) | parseLong;
            }
            if (replace.length() == 9) {
                return ((parseLong & 255) << 24) | (parseLong >>> 8);
            }
            m7.c.d();
            return 0;
        }
        if (replace.startsWith("rgba")) {
            Matcher matcher = (z8 ? f3659c : f3658b).matcher(replace);
            if (matcher.matches()) {
                if (z8) {
                    String group = matcher.group(4);
                    group.getClass();
                    parseInt = (int) (Float.parseFloat(group) * 255.0f);
                } else {
                    String group2 = matcher.group(4);
                    group2.getClass();
                    parseInt = Integer.parseInt(group2, 10);
                }
                String group3 = matcher.group(1);
                group3.getClass();
                int parseInt2 = Integer.parseInt(group3, 10);
                String group4 = matcher.group(2);
                group4.getClass();
                int parseInt3 = Integer.parseInt(group4, 10);
                String group5 = matcher.group(3);
                group5.getClass();
                return Color.argb(parseInt, parseInt2, parseInt3, Integer.parseInt(group5, 10));
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = f3657a.matcher(replace);
            if (matcher2.matches()) {
                String group6 = matcher2.group(1);
                group6.getClass();
                int parseInt4 = Integer.parseInt(group6, 10);
                String group7 = matcher2.group(2);
                group7.getClass();
                int parseInt5 = Integer.parseInt(group7, 10);
                String group8 = matcher2.group(3);
                group8.getClass();
                return Color.rgb(parseInt4, parseInt5, Integer.parseInt(group8, 10));
            }
        } else {
            Integer num = (Integer) f3660d.get(a.a.U(replace));
            if (num != null) {
                return num.intValue();
            }
        }
        m7.c.d();
        return 0;
    }
}
