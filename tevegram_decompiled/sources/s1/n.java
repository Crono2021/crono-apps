package s1;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import d1.l0;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final String f8714a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8715b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8716c;

    /* renamed from: d, reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f8717d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f8718e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f8719f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f8720g;
    public final boolean h;

    public n(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z8, boolean z9, boolean z10) {
        str.getClass();
        this.f8714a = str;
        this.f8715b = str2;
        this.f8716c = str3;
        this.f8717d = codecCapabilities;
        this.f8720g = z8;
        this.f8718e = z9;
        this.f8719f = z10;
        this.h = l0.j(str2);
    }

    public static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i9, int i10, double d9) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        Point point = new Point(g1.w.f(i9, widthAlignment) * widthAlignment, g1.w.f(i10, heightAlignment) * heightAlignment);
        int i11 = point.x;
        int i12 = point.y;
        return (d9 == -1.0d || d9 < 1.0d) ? videoCapabilities.isSizeSupported(i11, i12) : videoCapabilities.areSizeAndRateSupported(i11, i12, Math.floor(d9));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
    
        if ("Nexus 10".equals(r3) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        if ("OMX.Exynos.AVC.Decoder.secure".equals(r8) == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static s1.n h(java.lang.String r8, java.lang.String r9, java.lang.String r10, android.media.MediaCodecInfo.CodecCapabilities r11, boolean r12, boolean r13) {
        /*
            s1.n r0 = new s1.n
            r1 = 0
            r2 = 1
            if (r11 == 0) goto L3d
            int r3 = g1.w.f3713a
            r4 = 19
            if (r3 < r4) goto L3d
            java.lang.String r4 = "adaptive-playback"
            boolean r4 = r11.isFeatureSupported(r4)
            if (r4 == 0) goto L3d
            r4 = 22
            if (r3 > r4) goto L3b
            java.lang.String r3 = g1.w.f3716d
            java.lang.String r4 = "ODROID-XU3"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L2a
            java.lang.String r4 = "Nexus 10"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L3b
        L2a:
            java.lang.String r3 = "OMX.Exynos.AVC.Decoder"
            boolean r3 = r3.equals(r8)
            if (r3 != 0) goto L3d
            java.lang.String r3 = "OMX.Exynos.AVC.Decoder.secure"
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L3b
            goto L3d
        L3b:
            r6 = 1
            goto L3e
        L3d:
            r6 = 0
        L3e:
            r3 = 21
            if (r11 == 0) goto L4c
            int r4 = g1.w.f3713a
            if (r4 < r3) goto L4c
            java.lang.String r4 = "tunneled-playback"
            boolean r4 = r11.isFeatureSupported(r4)
        L4c:
            if (r13 != 0) goto L64
            if (r11 == 0) goto L5d
            int r13 = g1.w.f3713a
            if (r13 < r3) goto L5d
            java.lang.String r13 = "secure-playback"
            boolean r13 = r11.isFeatureSupported(r13)
            if (r13 == 0) goto L5d
            goto L64
        L5d:
            r7 = 0
        L5e:
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            goto L66
        L64:
            r7 = 1
            goto L5e
        L66:
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.n.h(java.lang.String, java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean):s1.n");
    }

    public final l1.g b(d1.s sVar, d1.s sVar2) {
        d1.s sVar3;
        d1.s sVar4;
        String str = sVar.f2554m;
        d1.j jVar = sVar.f2566y;
        String str2 = sVar2.f2554m;
        d1.j jVar2 = sVar2.f2566y;
        int i9 = !g1.w.a(str, str2) ? 8 : 0;
        if (this.h) {
            if (sVar.f2562u != sVar2.f2562u) {
                i9 |= 1024;
            }
            if (!this.f8718e && (sVar.f2559r != sVar2.f2559r || sVar.f2560s != sVar2.f2560s)) {
                i9 |= IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED;
            }
            if ((!d1.j.b(jVar) || !d1.j.b(jVar2)) && !g1.w.a(jVar, jVar2)) {
                i9 |= IjkMediaMeta.FF_PROFILE_H264_INTRA;
            }
            if (g1.w.f3716d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(this.f8714a) && !sVar.b(sVar2)) {
                i9 |= 2;
            }
            if (i9 == 0) {
                return new l1.g(this.f8714a, sVar, sVar2, sVar.b(sVar2) ? 3 : 2, 0);
            }
            sVar3 = sVar;
            sVar4 = sVar2;
        } else {
            sVar3 = sVar;
            sVar4 = sVar2;
            if (sVar3.f2567z != sVar4.f2567z) {
                i9 |= 4096;
            }
            if (sVar3.A != sVar4.A) {
                i9 |= 8192;
            }
            if (sVar3.B != sVar4.B) {
                i9 |= 16384;
            }
            String str3 = this.f8715b;
            if (i9 == 0 && "audio/mp4a-latm".equals(str3)) {
                Pair d9 = z.d(sVar3);
                Pair d10 = z.d(sVar4);
                if (d9 != null && d10 != null) {
                    int intValue = ((Integer) d9.first).intValue();
                    int intValue2 = ((Integer) d10.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new l1.g(this.f8714a, sVar3, sVar4, 3, 0);
                    }
                }
            }
            if (!sVar3.b(sVar4)) {
                i9 |= 32;
            }
            if ("audio/opus".equals(str3)) {
                i9 |= 2;
            }
            if (i9 == 0) {
                return new l1.g(this.f8714a, sVar3, sVar4, 1, 0);
            }
        }
        return new l1.g(this.f8714a, sVar3, sVar4, 0, i9);
    }

    public final boolean c(d1.s sVar, boolean z8) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        Pair d9 = z.d(sVar);
        if (d9 != null) {
            int intValue = ((Integer) d9.first).intValue();
            int intValue2 = ((Integer) d9.second).intValue();
            boolean equals = "video/dolby-vision".equals(sVar.f2554m);
            int i9 = 8;
            String str = this.f8715b;
            if (equals) {
                if ("video/avc".equals(str)) {
                    intValue2 = 0;
                    intValue = 8;
                } else if ("video/hevc".equals(str)) {
                    intValue2 = 0;
                    intValue = 2;
                }
            }
            if (this.h || intValue == 42) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = this.f8717d;
                if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                    codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
                }
                if (g1.w.f3713a <= 23 && "video/x-vnd.on2.vp9".equals(str) && codecProfileLevelArr.length == 0) {
                    int intValue3 = (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) ? 0 : videoCapabilities.getBitrateRange().getUpper().intValue();
                    if (intValue3 >= 180000000) {
                        i9 = 1024;
                    } else if (intValue3 >= 120000000) {
                        i9 = IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED;
                    } else if (intValue3 >= 60000000) {
                        i9 = 256;
                    } else if (intValue3 >= 30000000) {
                        i9 = 128;
                    } else if (intValue3 >= 18000000) {
                        i9 = 64;
                    } else if (intValue3 >= 12000000) {
                        i9 = 32;
                    } else if (intValue3 >= 7200000) {
                        i9 = 16;
                    } else if (intValue3 < 3600000) {
                        i9 = intValue3 >= 1800000 ? 4 : intValue3 >= 800000 ? 2 : 1;
                    }
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
                    codecProfileLevel.profile = 1;
                    codecProfileLevel.level = i9;
                    codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
                }
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel2 : codecProfileLevelArr) {
                    if (codecProfileLevel2.profile == intValue && (codecProfileLevel2.level >= intValue2 || !z8)) {
                        if ("video/hevc".equals(str) && 2 == intValue) {
                            String str2 = g1.w.f3714b;
                            if (!"sailfish".equals(str2) && !"marlin".equals(str2)) {
                            }
                        }
                    }
                }
                g("codec.profileLevel, " + sVar.f2551j + ", " + this.f8716c);
                return false;
            }
        }
        return true;
    }

    public final boolean d(d1.s sVar) {
        String str = sVar.f2554m;
        String str2 = this.f8715b;
        boolean z8 = str2.equals(str) || str2.equals(z.b(sVar));
        int i9 = sVar.f2560s;
        int i10 = sVar.f2559r;
        if (!z8 || !c(sVar, true)) {
            return false;
        }
        if (!this.h) {
            int i11 = g1.w.f3713a;
            if (i11 >= 21) {
                int i12 = sVar.A;
                MediaCodecInfo.CodecCapabilities codecCapabilities = this.f8717d;
                if (i12 != -1) {
                    if (codecCapabilities == null) {
                        g("sampleRate.caps");
                        return false;
                    }
                    MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
                    if (audioCapabilities == null) {
                        g("sampleRate.aCaps");
                        return false;
                    }
                    if (!audioCapabilities.isSampleRateSupported(i12)) {
                        g("sampleRate.support, " + i12);
                        return false;
                    }
                }
                int i13 = sVar.f2567z;
                if (i13 != -1) {
                    if (codecCapabilities == null) {
                        g("channelCount.caps");
                        return false;
                    }
                    MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities.getAudioCapabilities();
                    if (audioCapabilities2 == null) {
                        g("channelCount.aCaps");
                        return false;
                    }
                    int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                    if (maxInputChannelCount <= 1 && ((i11 < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2))) {
                        int i14 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
                        g1.a.D("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + this.f8714a + ", [" + maxInputChannelCount + " to " + i14 + "]");
                        maxInputChannelCount = i14;
                    }
                    if (maxInputChannelCount < i13) {
                        g("channelCount.support, " + i13);
                        return false;
                    }
                }
            }
        } else if (i10 > 0 && i9 > 0) {
            if (g1.w.f3713a >= 21) {
                return f(i10, i9, sVar.f2561t);
            }
            boolean z9 = i10 * i9 <= z.j();
            if (!z9) {
                g("legacyFrameSize, " + i10 + "x" + i9);
            }
            return z9;
        }
        return true;
    }

    public final boolean e(d1.s sVar) {
        if (this.h) {
            return this.f8718e;
        }
        Pair d9 = z.d(sVar);
        return d9 != null && ((Integer) d9.first).intValue() == 42;
    }

    public final boolean f(int i9, int i10, double d9) {
        Boolean bool;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f8717d;
        if (codecCapabilities == null) {
            g("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            g("sizeAndRate.vCaps");
            return false;
        }
        int i11 = g1.w.f3713a;
        if (i11 >= 29) {
            int a9 = (i11 < 29 || ((bool = com.bumptech.glide.c.f1751o) != null && bool.booleanValue())) ? 0 : o.a(videoCapabilities, i9, i10, d9);
            if (a9 == 2) {
                return true;
            }
            if (a9 == 1) {
                StringBuilder q4 = androidx.activity.g.q("sizeAndRate.cover, ", i9, "x", i10, "@");
                q4.append(d9);
                g(q4.toString());
                return false;
            }
        }
        if (!a(videoCapabilities, i9, i10, d9)) {
            if (i9 < i10) {
                String str = this.f8714a;
                if ((!"OMX.MTK.VIDEO.DECODER.HEVC".equals(str) || !"mcv5a".equals(g1.w.f3714b)) && a(videoCapabilities, i10, i9, d9)) {
                    StringBuilder q7 = androidx.activity.g.q("sizeAndRate.rotated, ", i9, "x", i10, "@");
                    q7.append(d9);
                    g1.a.o("MediaCodecInfo", "AssumedSupport [" + q7.toString() + "] [" + str + ", " + this.f8715b + "] [" + g1.w.f3717e + "]");
                }
            }
            StringBuilder q8 = androidx.activity.g.q("sizeAndRate.support, ", i9, "x", i10, "@");
            q8.append(d9);
            g(q8.toString());
            return false;
        }
        return true;
    }

    public final void g(String str) {
        StringBuilder r8 = androidx.activity.g.r("NoSupport [", str, "] [");
        r8.append(this.f8714a);
        r8.append(", ");
        r8.append(this.f8715b);
        r8.append("] [");
        r8.append(g1.w.f3717e);
        r8.append("]");
        g1.a.o("MediaCodecInfo", r8.toString());
    }

    public final String toString() {
        return this.f8714a;
    }
}
