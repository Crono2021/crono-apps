package tv.danmaku.ijk.media.player;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import org.webrtc.EglBase;
import org.webrtc.PeerConnectionFactory;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class IjkMediaCodecInfo {
    public static final int RANK_ACCEPTABLE = 700;
    public static final int RANK_LAST_CHANCE = 600;
    public static final int RANK_MAX = 1000;
    public static final int RANK_NON_STANDARD = 100;
    public static final int RANK_NO_SENSE = 0;
    public static final int RANK_SECURE = 300;
    public static final int RANK_SOFTWARE = 200;
    public static final int RANK_TESTED = 800;
    private static final String TAG = "IjkMediaCodecInfo";
    private static Map<String, Integer> sKnownCodecList;
    public MediaCodecInfo mCodecInfo;
    public String mMimeType;
    public int mRank = 0;

    private static synchronized Map<String, Integer> getKnownCodecList() {
        synchronized (IjkMediaCodecInfo.class) {
            Map<String, Integer> map = sKnownCodecList;
            if (map != null) {
                return map;
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            sKnownCodecList = treeMap;
            treeMap.put("OMX.Nvidia.h264.decode", 800);
            sKnownCodecList.put("OMX.Nvidia.h264.decode.secure", Integer.valueOf(RANK_SECURE));
            sKnownCodecList.put("OMX.Intel.hw_vd.h264", Integer.valueOf(IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE));
            sKnownCodecList.put("OMX.Intel.VideoDecoder.AVC", 800);
            sKnownCodecList.put("OMX.qcom.video.decoder.avc", 800);
            sKnownCodecList.put("OMX.ittiam.video.decoder.avc", 0);
            sKnownCodecList.put("OMX.SEC.avc.dec", 800);
            sKnownCodecList.put("OMX.SEC.AVC.Decoder", 799);
            sKnownCodecList.put("OMX.SEC.avcdec", 798);
            sKnownCodecList.put("OMX.SEC.avc.sw.dec", 200);
            sKnownCodecList.put("OMX.Exynos.avc.dec", 800);
            sKnownCodecList.put("OMX.Exynos.AVC.Decoder", 799);
            sKnownCodecList.put("OMX.k3.video.decoder.avc", 800);
            sKnownCodecList.put("OMX.IMG.MSVDX.Decoder.AVC", 800);
            sKnownCodecList.put("OMX.TI.DUCATI1.VIDEO.DECODER", 800);
            sKnownCodecList.put("OMX.rk.video_decoder.avc", 800);
            sKnownCodecList.put("OMX.amlogic.avc.decoder.awesome", 800);
            sKnownCodecList.put("OMX.MARVELL.VIDEO.HW.CODA7542DECODER", 800);
            sKnownCodecList.put("OMX.MARVELL.VIDEO.H264DECODER", 200);
            sKnownCodecList.remove("OMX.Action.Video.Decoder");
            sKnownCodecList.remove("OMX.allwinner.video.decoder.avc");
            sKnownCodecList.remove("OMX.BRCM.vc4.decoder.avc");
            sKnownCodecList.remove("OMX.brcm.video.h264.hw.decoder");
            sKnownCodecList.remove("OMX.brcm.video.h264.decoder");
            sKnownCodecList.remove("OMX.cosmo.video.decoder.avc");
            sKnownCodecList.remove("OMX.duos.h264.decoder");
            sKnownCodecList.remove("OMX.hantro.81x0.video.decoder");
            sKnownCodecList.remove("OMX.hantro.G1.video.decoder");
            sKnownCodecList.remove("OMX.hisi.video.decoder");
            sKnownCodecList.remove("OMX.LG.decoder.video.avc");
            sKnownCodecList.remove("OMX.MS.AVC.Decoder");
            sKnownCodecList.remove("OMX.RENESAS.VIDEO.DECODER.H264");
            sKnownCodecList.remove("OMX.RTK.video.decoder");
            sKnownCodecList.remove("OMX.sprd.h264.decoder");
            sKnownCodecList.remove("OMX.ST.VFM.H264Dec");
            sKnownCodecList.remove("OMX.vpu.video_decoder.avc");
            sKnownCodecList.remove("OMX.WMT.decoder.avc");
            sKnownCodecList.remove("OMX.bluestacks.hw.decoder");
            sKnownCodecList.put("OMX.google.h264.decoder", 200);
            sKnownCodecList.put("OMX.google.h264.lc.decoder", 200);
            sKnownCodecList.put("OMX.k3.ffmpeg.decoder", 200);
            sKnownCodecList.put("OMX.ffmpeg.video.decoder", 200);
            sKnownCodecList.put("OMX.sprd.soft.h264.decoder", 200);
            return sKnownCodecList;
        }
    }

    public static String getLevelName(int i9) {
        if (i9 == 1) {
            return "1";
        }
        if (i9 == 2) {
            return "1b";
        }
        switch (i9) {
            case 4:
                return "11";
            case 8:
                return "12";
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                return "13";
            case PeerConnectionFactory.Options.ADAPTER_TYPE_ANY /* 32 */:
                return "2";
            case EglBase.EGL_OPENGL_ES3_BIT /* 64 */:
                return "21";
            case 128:
                return "22";
            case 256:
                return "3";
            case IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED /* 512 */:
                return "31";
            case 1024:
                return "32";
            case IjkMediaMeta.FF_PROFILE_H264_INTRA /* 2048 */:
                return "4";
            case 4096:
                return "41";
            case 8192:
                return "42";
            case 16384:
                return "5";
            case 32768:
                return "51";
            case 65536:
                return "52";
            default:
                return "0";
        }
    }

    public static String getProfileLevelName(int i9, int i10) {
        Locale locale = Locale.US;
        return " " + getProfileName(i9) + " Profile Level " + getLevelName(i10) + " (" + i9 + "," + i10 + ")";
    }

    public static String getProfileName(int i9) {
        return i9 != 1 ? i9 != 2 ? i9 != 4 ? i9 != 8 ? i9 != 16 ? i9 != 32 ? i9 != 64 ? "Unknown" : "High444" : "High422" : "High10" : "High" : "Extends" : "Main" : "Baseline";
    }

    @TargetApi(PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK)
    public static IjkMediaCodecInfo setupCandidate(MediaCodecInfo mediaCodecInfo, String str) {
        int i9;
        if (mediaCodecInfo == null) {
            return null;
        }
        String name = mediaCodecInfo.getName();
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        String lowerCase = name.toLowerCase(Locale.US);
        if (!lowerCase.startsWith("omx.")) {
            i9 = 100;
        } else if (lowerCase.startsWith("omx.pv") || lowerCase.startsWith("omx.google.") || lowerCase.startsWith("omx.ffmpeg.") || lowerCase.startsWith("omx.k3.ffmpeg.") || lowerCase.startsWith("omx.avcodec.")) {
            i9 = 200;
        } else if (lowerCase.startsWith("omx.ittiam.")) {
            i9 = 0;
        } else if (lowerCase.startsWith("omx.mtk.")) {
            i9 = 800;
        } else {
            Integer num = getKnownCodecList().get(lowerCase);
            if (num != null) {
                i9 = num.intValue();
            } else {
                i9 = RANK_LAST_CHANCE;
                try {
                    if (mediaCodecInfo.getCapabilitiesForType(str) != null) {
                        i9 = 700;
                    }
                } catch (Throwable unused) {
                }
            }
        }
        IjkMediaCodecInfo ijkMediaCodecInfo = new IjkMediaCodecInfo();
        ijkMediaCodecInfo.mCodecInfo = mediaCodecInfo;
        ijkMediaCodecInfo.mRank = i9;
        ijkMediaCodecInfo.mMimeType = str;
        return ijkMediaCodecInfo;
    }

    @TargetApi(PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK)
    public void dumpProfileLevels(String str) {
        int i9;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        try {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = this.mCodecInfo.getCapabilitiesForType(str);
            int i10 = 0;
            if (capabilitiesForType == null || (codecProfileLevelArr = capabilitiesForType.profileLevels) == null) {
                i9 = 0;
            } else {
                int length = codecProfileLevelArr.length;
                int i11 = 0;
                i9 = 0;
                while (i10 < length) {
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = codecProfileLevelArr[i10];
                    if (codecProfileLevel != null) {
                        i11 = Math.max(i11, codecProfileLevel.profile);
                        i9 = Math.max(i9, codecProfileLevel.level);
                    }
                    i10++;
                }
                i10 = i11;
            }
            Locale locale = Locale.US;
            Log.i(TAG, getProfileLevelName(i10, i9));
        } catch (Throwable unused) {
            Log.i(TAG, "profile-level: exception");
        }
    }
}
