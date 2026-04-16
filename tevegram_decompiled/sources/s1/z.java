package s1;

import android.media.MediaCodecInfo;
import android.util.Pair;
import b6.d0;
import b6.g0;
import b6.w0;
import d1.l0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import org.webrtc.EglBase;
import org.webrtc.PeerConnectionFactory;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f8761a = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f8762b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static int f8763c = -1;

    public static void a(String str, ArrayList arrayList) {
        if ("audio/raw".equals(str)) {
            if (g1.w.f3713a < 26 && g1.w.f3714b.equals("R9") && arrayList.size() == 1 && ((n) arrayList.get(0)).f8714a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                arrayList.add(n.h("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, false));
            }
            Collections.sort(arrayList, new u(new m7.c(23)));
        }
        int i9 = g1.w.f3713a;
        if (i9 < 21 && arrayList.size() > 1) {
            String str2 = ((n) arrayList.get(0)).f8714a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                Collections.sort(arrayList, new u(new m7.c(24)));
            }
        }
        if (i9 >= 32 || arrayList.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(((n) arrayList.get(0)).f8714a)) {
            return;
        }
        arrayList.add((n) arrayList.remove(0));
    }

    public static String b(d1.s sVar) {
        Pair d9;
        if ("audio/eac3-joc".equals(sVar.f2554m)) {
            return "audio/eac3";
        }
        if (!"video/dolby-vision".equals(sVar.f2554m) || (d9 = d(sVar)) == null) {
            return null;
        }
        int intValue = ((Integer) d9.first).intValue();
        if (intValue == 16 || intValue == 256) {
            return "video/hevc";
        }
        if (intValue == 512) {
            return "video/avc";
        }
        return null;
    }

    public static String c(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        if (str2.equals("audio/ac3") && "OMX.lge.ac3.decoder".equals(str)) {
            return "audio/lg-ac3";
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:254:0x05c3  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x05c9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0220  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair d(d1.s r34) {
        /*
            Method dump skipped, instructions count: 2390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.z.d(d1.s):android.util.Pair");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized List e(String str, boolean z8, boolean z9) {
        o4.d dVar;
        int i9;
        synchronized (z.class) {
            try {
                v vVar = new v(str, z8, z9);
                HashMap hashMap = f8762b;
                List list = (List) hashMap.get(vVar);
                if (list != null) {
                    return list;
                }
                int i10 = g1.w.f3713a;
                if (i10 >= 21) {
                    d4.i iVar = new d4.i();
                    if (!z8 && !z9) {
                        i9 = 0;
                        iVar.f2851i = i9;
                        dVar = iVar;
                    }
                    i9 = 1;
                    iVar.f2851i = i9;
                    dVar = iVar;
                } else {
                    dVar = new o4.d(3);
                }
                ArrayList f9 = f(vVar, dVar);
                if (z8 && f9.isEmpty() && 21 <= i10 && i10 <= 23) {
                    f9 = f(vVar, new o4.d(3));
                    if (!f9.isEmpty()) {
                        g1.a.D("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((n) f9.get(0)).f8714a);
                    }
                }
                a(str, f9);
                g0 m9 = g0.m(f9);
                hashMap.put(vVar, m9);
                return m9;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ArrayList f(v vVar, x xVar) {
        String c9;
        String str;
        String str2;
        n h;
        boolean isAlias;
        v vVar2 = vVar;
        boolean z8 = vVar2.f8759b;
        try {
            ArrayList arrayList = new ArrayList();
            String str3 = vVar2.f8758a;
            int i9 = xVar.i();
            boolean q4 = xVar.q();
            int i10 = 0;
            while (i10 < i9) {
                MediaCodecInfo c10 = xVar.c(i10);
                int i11 = g1.w.f3713a;
                if (i11 >= 29) {
                    isAlias = c10.isAlias();
                    if (isAlias) {
                        i10++;
                        vVar2 = vVar;
                    }
                }
                String name = c10.getName();
                if (h(c10, name, q4, str3) && (c9 = c(c10, name, str3)) != null) {
                    try {
                        MediaCodecInfo.CodecCapabilities capabilitiesForType = c10.getCapabilitiesForType(c9);
                        boolean m9 = xVar.m("tunneled-playback", c9, capabilitiesForType);
                        boolean g9 = xVar.g("tunneled-playback", capabilitiesForType);
                        boolean z9 = vVar2.f8760c;
                        if ((z9 || !g9) && (!z9 || m9)) {
                            boolean m10 = xVar.m("secure-playback", c9, capabilitiesForType);
                            boolean g10 = xVar.g("secure-playback", capabilitiesForType);
                            if ((z8 || !g10) && (!z8 || m10)) {
                                boolean isHardwareAccelerated = i11 >= 29 ? c10.isHardwareAccelerated() : !i(c10, str3);
                                i(c10, str3);
                                if (i11 >= 29) {
                                    c10.isVendor();
                                } else {
                                    String U = a.a.U(c10.getName());
                                    if (!U.startsWith("omx.google.") && !U.startsWith("c2.android.")) {
                                        U.startsWith("c2.google.");
                                    }
                                }
                                if (!(q4 && z8 == m10) && (q4 || z8)) {
                                    boolean z10 = isHardwareAccelerated;
                                    str2 = name;
                                    if (!q4 && m10) {
                                        str = c9;
                                        try {
                                            arrayList.add(n.h(str2 + ".secure", str3, str, capabilitiesForType, z10, true));
                                            break;
                                        } catch (Exception e9) {
                                            e = e9;
                                            if (g1.w.f3713a <= 23 || arrayList.isEmpty()) {
                                                g1.a.p("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                                throw e;
                                            }
                                            g1.a.p("MediaCodecUtil", "Skipping codec " + str2 + " (failed to query capabilities)");
                                            i10++;
                                            vVar2 = vVar;
                                        }
                                    }
                                } else {
                                    str = c9;
                                    try {
                                        h = n.h(name, str3, str, capabilitiesForType, isHardwareAccelerated, false);
                                        str2 = name;
                                    } catch (Exception e10) {
                                        e = e10;
                                        str2 = name;
                                    }
                                    try {
                                        arrayList.add(h);
                                    } catch (Exception e11) {
                                        e = e11;
                                        str = str;
                                        if (g1.w.f3713a <= 23) {
                                        }
                                        g1.a.p("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                        throw e;
                                    }
                                }
                            }
                        }
                    } catch (Exception e12) {
                        e = e12;
                        str = c9;
                        str2 = name;
                    }
                }
                i10++;
                vVar2 = vVar;
            }
            return arrayList;
        } catch (Exception e13) {
            throw new w("Failed to query underlying media codecs", e13);
        }
    }

    public static w0 g(t tVar, d1.s sVar, boolean z8, boolean z9) {
        Iterable e9;
        String str = sVar.f2554m;
        m7.c cVar = (m7.c) tVar;
        cVar.getClass();
        List e10 = e(str, z8, z9);
        String b9 = b(sVar);
        if (b9 == null) {
            e9 = w0.f1464m;
        } else {
            cVar.getClass();
            e9 = e(b9, z8, z9);
        }
        d0 d0Var = new d0();
        d0Var.c(e10);
        d0Var.c(e9);
        return d0Var.f();
    }

    public static boolean h(MediaCodecInfo mediaCodecInfo, String str, boolean z8, String str2) {
        if (mediaCodecInfo.isEncoder()) {
            return false;
        }
        if (!z8 && str.endsWith(".secure")) {
            return false;
        }
        int i9 = g1.w.f3713a;
        if (i9 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i9 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = g1.w.f3714b;
            if ("a70".equals(str3)) {
                return false;
            }
            if ("Xiaomi".equals(g1.w.f3715c) && str3.startsWith("HM")) {
                return false;
            }
        }
        if (i9 == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = g1.w.f3714b;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i9 == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = g1.w.f3714b;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i9 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(g1.w.f3715c))) {
            String str6 = g1.w.f3714b;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i9 <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(g1.w.f3715c)) {
            String str7 = g1.w.f3714b;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i9 <= 19 && g1.w.f3714b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return (i9 <= 23 && "audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    public static boolean i(MediaCodecInfo mediaCodecInfo, String str) {
        boolean isSoftwareOnly;
        if (g1.w.f3713a >= 29) {
            isSoftwareOnly = mediaCodecInfo.isSoftwareOnly();
            return isSoftwareOnly;
        }
        if (l0.h(str)) {
            return true;
        }
        String U = a.a.U(mediaCodecInfo.getName());
        if (U.startsWith("arc.")) {
            return false;
        }
        if (U.startsWith("omx.google.") || U.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((U.startsWith("omx.sec.") && U.contains(".sw.")) || U.equals("omx.qcom.video.decoder.hevcswvdec") || U.startsWith("c2.android.") || U.startsWith("c2.google.")) {
            return true;
        }
        return (U.startsWith("omx.") || U.startsWith("c2.")) ? false : true;
    }

    public static int j() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        int i9;
        if (f8763c == -1) {
            int i10 = 0;
            List e9 = e("video/avc", false, false);
            n nVar = e9.isEmpty() ? null : (n) e9.get(0);
            if (nVar != null) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = nVar.f8717d;
                if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                    codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
                }
                int length = codecProfileLevelArr.length;
                int i11 = 0;
                while (i10 < length) {
                    int i12 = codecProfileLevelArr[i10].level;
                    if (i12 != 1 && i12 != 2) {
                        switch (i12) {
                            case 8:
                            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                            case PeerConnectionFactory.Options.ADAPTER_TYPE_ANY /* 32 */:
                                i9 = 101376;
                                break;
                            case EglBase.EGL_OPENGL_ES3_BIT /* 64 */:
                                i9 = 202752;
                                break;
                            case 128:
                            case 256:
                                i9 = 414720;
                                break;
                            case IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED /* 512 */:
                                i9 = 921600;
                                break;
                            case 1024:
                                i9 = 1310720;
                                break;
                            case IjkMediaMeta.FF_PROFILE_H264_INTRA /* 2048 */:
                            case 4096:
                                i9 = 2097152;
                                break;
                            case 8192:
                                i9 = 2228224;
                                break;
                            case 16384:
                                i9 = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i9 = 9437184;
                                break;
                            case 131072:
                            case 262144:
                            case 524288:
                                i9 = 35651584;
                                break;
                            default:
                                i9 = -1;
                                break;
                        }
                    } else {
                        i9 = 25344;
                    }
                    i11 = Math.max(i9, i11);
                    i10++;
                }
                i10 = Math.max(i11, g1.w.f3713a >= 21 ? 345600 : 172800);
            }
            f8763c = i10;
        }
        return f8763c;
    }
}
