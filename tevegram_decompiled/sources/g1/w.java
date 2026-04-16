package g1;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioFormat;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.network.tvgramplayer.voip.VoIPController;
import d1.l0;
import d1.t0;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.regex.Pattern;
import org.webrtc.PeerConnectionFactory;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static final int f3713a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f3714b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f3715c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f3716d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f3717e;

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f3718f;

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f3719g;
    public static final Pattern h;

    /* renamed from: i, reason: collision with root package name */
    public static HashMap f3720i;

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f3721j;

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f3722k;

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f3723l;

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f3724m;

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f3725n;

    static {
        int i9 = Build.VERSION.SDK_INT;
        f3713a = i9;
        String str = Build.DEVICE;
        f3714b = str;
        String str2 = Build.MANUFACTURER;
        f3715c = str2;
        String str3 = Build.MODEL;
        f3716d = str3;
        f3717e = str + ", " + str3 + ", " + str2 + ", " + i9;
        f3718f = new byte[0];
        f3719g = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        Pattern.compile("%([A-Fa-f0-9]{2})");
        h = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
        f3721j = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        f3722k = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        f3723l = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        f3724m = new int[]{0, 4129, 8258, 12387, 16516, 20645, 24774, 28903, 33032, 37161, 41290, 45419, 49548, 53677, 57806, 61935};
        f3725n = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 151, 158, 153, 140, 139, 130, 133, 168, 175, 166, 161, 180, 179, 186, 189, 199, 192, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, IjkMediaMeta.FF_PROFILE_H264_HIGH_422, 137, 142, 135, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, IjkMediaMeta.FF_PROFILE_H264_HIGH_10, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 243};
    }

    public static long A(long j5, float f9) {
        return f9 == 1.0f ? j5 : Math.round(j5 / f9);
    }

    public static String B(StringBuilder sb, Formatter formatter, long j5) {
        if (j5 == -9223372036854775807L) {
            j5 = 0;
        }
        String str = j5 < 0 ? "-" : "";
        long abs = (Math.abs(j5) + 500) / 1000;
        long j9 = abs % 60;
        long j10 = (abs / 60) % 60;
        long j11 = abs / 3600;
        sb.setLength(0);
        return j11 > 0 ? formatter.format("%s%d:%02d:%02d", str, Long.valueOf(j11), Long.valueOf(j10), Long.valueOf(j9)).toString() : formatter.format("%s%02d:%02d", str, Long.valueOf(j10), Long.valueOf(j9)).toString();
    }

    public static String C(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e9) {
            a.q("Util", "Failed to read system property ".concat(str), e9);
            return null;
        }
    }

    public static String D(int i9) {
        switch (i9) {
            case VoIPController.ERROR_PRIVACY /* -2 */:
                return "none";
            case VoIPController.ERROR_PEER_OUTDATED /* -1 */:
                return IjkMediaMeta.IJKM_VAL_TYPE__UNKNOWN;
            case 0:
                return "default";
            case 1:
                return "audio";
            case 2:
                return "video";
            case 3:
                return "text";
            case 4:
                return "image";
            case 5:
                return "metadata";
            case 6:
                return "camera motion";
            default:
                if (i9 < 10000) {
                    return "?";
                }
                return "custom (" + i9 + ")";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean E(d1.t0 r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            int r1 = r4.t()
            r2 = 1
            if (r1 != r2) goto L17
            r3 = 2
            boolean r3 = r4.J(r3)
            if (r3 == 0) goto L17
            r4.b()
        L15:
            r0 = 1
            goto L24
        L17:
            r3 = 4
            if (r1 != r3) goto L24
            boolean r1 = r4.J(r3)
            if (r1 == 0) goto L24
            r4.G()
            goto L15
        L24:
            boolean r1 = r4.J(r2)
            if (r1 == 0) goto L2e
            r4.F()
            return r2
        L2e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.w.E(d1.t0):boolean");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d9 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int F(android.net.Uri r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.w.F(android.net.Uri, java.lang.String):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean G(g1.p r3, g1.p r4, java.util.zip.Inflater r5) {
        /*
            int r0 = r3.a()
            r1 = 0
            if (r0 > 0) goto L8
            return r1
        L8:
            byte[] r0 = r4.f3699a
            int r0 = r0.length
            int r2 = r3.a()
            if (r0 >= r2) goto L1a
            int r0 = r3.a()
            int r0 = r0 * 2
            r4.b(r0)
        L1a:
            if (r5 != 0) goto L21
            java.util.zip.Inflater r5 = new java.util.zip.Inflater
            r5.<init>()
        L21:
            byte[] r0 = r3.f3699a
            int r2 = r3.f3700b
            int r3 = r3.a()
            r5.setInput(r0, r2, r3)
            r3 = 0
        L2d:
            byte[] r0 = r4.f3699a     // Catch: java.lang.Throwable -> L44 java.util.zip.DataFormatException -> L67
            int r2 = r0.length     // Catch: java.lang.Throwable -> L44 java.util.zip.DataFormatException -> L67
            int r2 = r2 - r3
            int r0 = r5.inflate(r0, r3, r2)     // Catch: java.lang.Throwable -> L44 java.util.zip.DataFormatException -> L67
            int r3 = r3 + r0
            boolean r0 = r5.finished()     // Catch: java.lang.Throwable -> L44 java.util.zip.DataFormatException -> L67
            if (r0 == 0) goto L46
            r4.E(r3)     // Catch: java.lang.Throwable -> L44 java.util.zip.DataFormatException -> L67
            r5.reset()
            r3 = 1
            return r3
        L44:
            r3 = move-exception
            goto L63
        L46:
            boolean r0 = r5.needsDictionary()     // Catch: java.lang.Throwable -> L44 java.util.zip.DataFormatException -> L67
            if (r0 != 0) goto L5f
            boolean r0 = r5.needsInput()     // Catch: java.lang.Throwable -> L44 java.util.zip.DataFormatException -> L67
            if (r0 == 0) goto L53
            goto L5f
        L53:
            byte[] r0 = r4.f3699a     // Catch: java.lang.Throwable -> L44 java.util.zip.DataFormatException -> L67
            int r2 = r0.length     // Catch: java.lang.Throwable -> L44 java.util.zip.DataFormatException -> L67
            if (r3 != r2) goto L2d
            int r0 = r0.length     // Catch: java.lang.Throwable -> L44 java.util.zip.DataFormatException -> L67
            int r0 = r0 * 2
            r4.b(r0)     // Catch: java.lang.Throwable -> L44 java.util.zip.DataFormatException -> L67
            goto L2d
        L5f:
            r5.reset()
            return r1
        L63:
            r5.reset()
            throw r3
        L67:
            r5.reset()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.w.G(g1.p, g1.p, java.util.zip.Inflater):boolean");
    }

    public static void H(int i9) {
        Integer.toString(i9, 36);
    }

    public static boolean I(int i9) {
        return i9 == 3 || i9 == 2 || i9 == 268435456 || i9 == 21 || i9 == 1342177280 || i9 == 22 || i9 == 1610612736 || i9 == 4;
    }

    public static boolean J(Context context) {
        int i9 = f3713a;
        if (i9 < 29 || context.getApplicationInfo().targetSdkVersion < 29) {
            return true;
        }
        if (i9 != 30) {
            return false;
        }
        String str = f3716d;
        return a.a.r(str, "moto g(20)") || a.a.r(str, "rmx3231");
    }

    public static boolean K(int i9) {
        return i9 == 10 || i9 == 13;
    }

    public static boolean L(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static long M(long j5) {
        return (j5 == -9223372036854775807L || j5 == Long.MIN_VALUE) ? j5 : j5 * 1000;
    }

    public static String N(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !replace.equals("und")) {
            str = replace;
        }
        String U = a.a.U(str);
        int i9 = 0;
        String str2 = U.split("-", 2)[0];
        if (f3720i == null) {
            String[] iSOLanguages = Locale.getISOLanguages();
            int length = iSOLanguages.length;
            String[] strArr = f3721j;
            HashMap hashMap = new HashMap(length + strArr.length);
            for (String str3 : iSOLanguages) {
                try {
                    String iSO3Language = new Locale(str3).getISO3Language();
                    if (!TextUtils.isEmpty(iSO3Language)) {
                        hashMap.put(iSO3Language, str3);
                    }
                } catch (MissingResourceException unused) {
                }
            }
            for (int i10 = 0; i10 < strArr.length; i10 += 2) {
                hashMap.put(strArr[i10], strArr[i10 + 1]);
            }
            f3720i = hashMap;
        }
        String str4 = (String) f3720i.get(str2);
        if (str4 != null) {
            U = str4.concat(U.substring(str2.length()));
            str2 = str4;
        }
        if (!"no".equals(str2) && !"i".equals(str2) && !"zh".equals(str2)) {
            return U;
        }
        while (true) {
            String[] strArr2 = f3722k;
            if (i9 >= strArr2.length) {
                return U;
            }
            if (U.startsWith(strArr2[i9])) {
                return strArr2[i9 + 1] + U.substring(strArr2[i9].length());
            }
            i9 += 2;
        }
    }

    public static Object[] O(int i9, Object[] objArr) {
        a.f(i9 <= objArr.length);
        return Arrays.copyOf(objArr, i9);
    }

    public static void P(Handler handler, Runnable runnable) {
        if (handler.getLooper().getThread().isAlive()) {
            if (handler.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }
    }

    public static long Q(int i9, long j5) {
        return S(j5, 1000000L, i9, RoundingMode.FLOOR);
    }

    public static void R(long j5, long[] jArr) {
        long j9;
        RoundingMode roundingMode = RoundingMode.FLOOR;
        int i9 = 0;
        if (j5 >= 1000000 && j5 % 1000000 == 0) {
            long y2 = com.bumptech.glide.d.y(j5, 1000000L, RoundingMode.UNNECESSARY);
            while (i9 < jArr.length) {
                jArr[i9] = com.bumptech.glide.d.y(jArr[i9], y2, roundingMode);
                i9++;
            }
            return;
        }
        if (j5 < 1000000 && 1000000 % j5 == 0) {
            long y3 = com.bumptech.glide.d.y(1000000L, j5, RoundingMode.UNNECESSARY);
            while (i9 < jArr.length) {
                jArr[i9] = com.bumptech.glide.d.Y(jArr[i9], y3);
                i9++;
            }
            return;
        }
        int i10 = 0;
        while (i10 < jArr.length) {
            long j10 = jArr[i10];
            if (j10 != 0) {
                if (j5 >= j10 && j5 % j10 == 0) {
                    jArr[i10] = com.bumptech.glide.d.y(1000000L, com.bumptech.glide.d.y(j5, j10, RoundingMode.UNNECESSARY), roundingMode);
                } else if (j5 >= j10 || j10 % j5 != 0) {
                    j9 = j5;
                    jArr[i10] = T(j10, 1000000L, j9, roundingMode);
                    i10++;
                    j5 = j9;
                } else {
                    jArr[i10] = com.bumptech.glide.d.Y(1000000L, com.bumptech.glide.d.y(j10, j5, RoundingMode.UNNECESSARY));
                }
            }
            j9 = j5;
            i10++;
            j5 = j9;
        }
    }

    public static long S(long j5, long j9, long j10, RoundingMode roundingMode) {
        if (j5 == 0 || j9 == 0) {
            return 0L;
        }
        return (j10 < j9 || j10 % j9 != 0) ? (j10 >= j9 || j9 % j10 != 0) ? (j10 < j5 || j10 % j5 != 0) ? (j10 >= j5 || j5 % j10 != 0) ? T(j5, j9, j10, roundingMode) : com.bumptech.glide.d.Y(j9, com.bumptech.glide.d.y(j5, j10, RoundingMode.UNNECESSARY)) : com.bumptech.glide.d.y(j9, com.bumptech.glide.d.y(j10, j5, RoundingMode.UNNECESSARY), roundingMode) : com.bumptech.glide.d.Y(j5, com.bumptech.glide.d.y(j9, j10, RoundingMode.UNNECESSARY)) : com.bumptech.glide.d.y(j5, com.bumptech.glide.d.y(j10, j9, RoundingMode.UNNECESSARY), roundingMode);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0095, code lost:
    
        if (java.lang.Math.abs(r9 - r2) == 0.5d) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long T(long r9, long r11, long r13, java.math.RoundingMode r15) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.w.T(long, long, long, java.math.RoundingMode):long");
    }

    public static boolean U(t0 t0Var, boolean z8) {
        return t0Var == null || !t0Var.p() || t0Var.t() == 1 || t0Var.t() == 4 || (z8 && t0Var.R() != 0);
    }

    public static String[] V(String str) {
        return TextUtils.isEmpty(str) ? new String[0] : str.trim().split("(\\s*,\\s*)", -1);
    }

    public static long W(long j5) {
        return (j5 == -9223372036854775807L || j5 == Long.MIN_VALUE) ? j5 : j5 / 1000;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int b(long j5, long[] jArr, boolean z8) {
        int i9;
        int binarySearch = Arrays.binarySearch(jArr, j5);
        if (binarySearch < 0) {
            return ~binarySearch;
        }
        while (true) {
            i9 = binarySearch + 1;
            if (i9 >= jArr.length || jArr[i9] != j5) {
                break;
            }
            binarySearch = i9;
        }
        return z8 ? binarySearch : i9;
    }

    public static int c(long j5, long[] jArr, boolean z8) {
        int i9;
        int binarySearch = Arrays.binarySearch(jArr, j5);
        if (binarySearch < 0) {
            i9 = -(binarySearch + 2);
        } else {
            while (true) {
                int i10 = binarySearch - 1;
                if (i10 < 0 || jArr[i10] != j5) {
                    break;
                }
                binarySearch = i10;
            }
            i9 = binarySearch;
        }
        return z8 ? Math.max(0, i9) : i9;
    }

    public static int d(List list, Long l4, boolean z8) {
        int i9;
        int binarySearch = Collections.binarySearch(list, l4);
        if (binarySearch < 0) {
            i9 = -(binarySearch + 2);
        } else {
            while (true) {
                int i10 = binarySearch - 1;
                if (i10 < 0 || ((Comparable) list.get(i10)).compareTo(l4) != 0) {
                    break;
                }
                binarySearch = i10;
            }
            i9 = binarySearch;
        }
        return z8 ? Math.max(0, i9) : i9;
    }

    public static int e(int[] iArr, int i9, boolean z8, boolean z9) {
        int i10;
        int i11;
        int binarySearch = Arrays.binarySearch(iArr, i9);
        if (binarySearch < 0) {
            i11 = -(binarySearch + 2);
        } else {
            while (true) {
                i10 = binarySearch - 1;
                if (i10 < 0 || iArr[i10] != i9) {
                    break;
                }
                binarySearch = i10;
            }
            i11 = z8 ? binarySearch : i10;
        }
        return z9 ? Math.max(0, i11) : i11;
    }

    public static int f(int i9, int i10) {
        return ((i9 + i10) - 1) / i10;
    }

    public static float g(float f9, float f10, float f11) {
        return Math.max(f10, Math.min(f9, f11));
    }

    public static int h(int i9, int i10, int i11) {
        return Math.max(i10, Math.min(i9, i11));
    }

    public static long i(long j5, long j9, long j10) {
        return Math.max(j9, Math.min(j5, j10));
    }

    public static boolean j(Object[] objArr, Object obj) {
        for (Object obj2 : objArr) {
            if (a(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static int k(int i9, int i10, int i11, byte[] bArr) {
        while (i9 < i10) {
            i11 = f3723l[((i11 >>> 24) ^ (bArr[i9] & 255)) & 255] ^ (i11 << 8);
            i9++;
        }
        return i11;
    }

    public static Handler l(b2.m mVar) {
        Looper myLooper = Looper.myLooper();
        a.l(myLooper);
        return new Handler(myLooper, mVar);
    }

    public static String m(byte[] bArr) {
        return new String(bArr, a6.b.f203c);
    }

    public static int n(int i9) {
        if (i9 == 20) {
            return 30;
        }
        if (i9 == 22) {
            return 31;
        }
        if (i9 == 30) {
            return 34;
        }
        switch (i9) {
            case 2:
            case 3:
                return 3;
            case 4:
            case 5:
            case 6:
                return 21;
            case 7:
            case 8:
                return 23;
            case 9:
            case 10:
            case 11:
            case 12:
                return 28;
            default:
                switch (i9) {
                    case 14:
                        return 25;
                    case 15:
                    case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                    case 17:
                    case 18:
                        return 28;
                    default:
                        return Integer.MAX_VALUE;
                }
        }
    }

    public static AudioFormat o(int i9, int i10, int i11) {
        return new AudioFormat.Builder().setSampleRate(i9).setChannelMask(i10).setEncoding(i11).build();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0015 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int p(int r2) {
        /*
            r0 = 6396(0x18fc, float:8.963E-42)
            switch(r2) {
                case 1: goto L28;
                case 2: goto L25;
                case 3: goto L22;
                case 4: goto L1f;
                case 5: goto L1c;
                case 6: goto L19;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L5;
                case 10: goto Lb;
                case 11: goto L5;
                case 12: goto L7;
                default: goto L5;
            }
        L5:
            r2 = 0
            return r2
        L7:
            r2 = 743676(0xb58fc, float:1.042112E-39)
            return r2
        Lb:
            int r2 = g1.w.f3713a
            r1 = 32
            if (r2 < r1) goto L15
            r2 = 737532(0xb40fc, float:1.033502E-39)
            return r2
        L15:
            return r0
        L16:
            r2 = 1276(0x4fc, float:1.788E-42)
            return r2
        L19:
            r2 = 252(0xfc, float:3.53E-43)
            return r2
        L1c:
            r2 = 220(0xdc, float:3.08E-43)
            return r2
        L1f:
            r2 = 204(0xcc, float:2.86E-43)
            return r2
        L22:
            r2 = 28
            return r2
        L25:
            r2 = 12
            return r2
        L28:
            r2 = 4
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.w.p(int):int");
    }

    public static int q(int i9, String str) {
        int i10 = 0;
        for (String str2 : V(str)) {
            if (i9 == l0.g(l0.c(str2))) {
                i10++;
            }
        }
        return i10;
    }

    public static String r(int i9, String str) {
        String[] V = V(str);
        if (V.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : V) {
            if (i9 == l0.g(l0.c(str2))) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static Drawable s(Context context, Resources resources, int i9) {
        return f3713a >= 21 ? v.a(context, resources, i9) : resources.getDrawable(i9);
    }

    public static int t(int i9) {
        if (i9 == 2 || i9 == 4) {
            return 6005;
        }
        if (i9 == 10) {
            return 6004;
        }
        if (i9 == 7) {
            return 6005;
        }
        if (i9 == 8) {
            return 6003;
        }
        switch (i9) {
            case 15:
                return 6003;
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
            case 18:
                return 6005;
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i9) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return 6002;
                    default:
                        return 6006;
                }
        }
    }

    public static int u(String str) {
        String[] split;
        int length;
        int i9 = 0;
        if (str == null || (length = (split = str.split("_", -1)).length) < 2) {
            return 0;
        }
        String str2 = split[length - 1];
        boolean z8 = length >= 3 && "neg".equals(split[length - 2]);
        try {
            str2.getClass();
            i9 = Integer.parseInt(str2);
            if (z8) {
                return -i9;
            }
        } catch (NumberFormatException unused) {
        }
        return i9;
    }

    public static String v(int i9) {
        if (i9 == 0) {
            return "NO";
        }
        if (i9 == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (i9 == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i9 == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (i9 == 4) {
            return "YES";
        }
        androidx.fragment.app.a.l();
        return null;
    }

    public static long w(long j5, float f9) {
        return f9 == 1.0f ? j5 : Math.round(j5 * f9);
    }

    public static int x(int i9) {
        if (i9 == 8) {
            return 3;
        }
        if (i9 == 16) {
            return 2;
        }
        if (i9 != 24) {
            return i9 != 32 ? 0 : 22;
        }
        return 21;
    }

    public static d1.s y(int i9, int i10, int i11) {
        d1.r rVar = new d1.r();
        rVar.f2528l = l0.k("audio/raw");
        rVar.f2541y = i10;
        rVar.f2542z = i11;
        rVar.A = i9;
        return new d1.s(rVar);
    }

    public static int z(int i9, int i10) {
        if (i9 != 2) {
            if (i9 == 3) {
                return i10;
            }
            if (i9 != 4) {
                if (i9 != 21) {
                    if (i9 != 22) {
                        if (i9 != 268435456) {
                            if (i9 != 1342177280) {
                                if (i9 != 1610612736) {
                                    m7.c.d();
                                    return 0;
                                }
                            }
                        }
                    }
                }
                return i10 * 3;
            }
            return i10 * 4;
        }
        return i10 * 2;
    }
}
