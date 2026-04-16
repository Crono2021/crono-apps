package a2;

import android.os.SystemClock;
import android.text.TextUtils;
import b6.g0;
import d1.e1;
import d1.f1;
import d1.h1;
import d1.j0;
import d1.n0;
import d1.o0;
import d1.s;
import d1.s0;
import d1.t0;
import d1.w0;
import d1.x0;
import d1.y0;
import g1.w;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import l1.f;
import m1.b;
import m1.c;
import n1.r;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import v1.v;
import v1.z;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements c {

    /* renamed from: d, reason: collision with root package name */
    public static final NumberFormat f41d;

    /* renamed from: a, reason: collision with root package name */
    public final x0 f42a = new x0();

    /* renamed from: b, reason: collision with root package name */
    public final w0 f43b = new w0();

    /* renamed from: c, reason: collision with root package name */
    public final long f44c = SystemClock.elapsedRealtime();

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        f41d = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    public static String M(r rVar) {
        return rVar.f7349a + "," + rVar.f7351c + "," + rVar.f7350b + "," + rVar.f7352d + "," + rVar.f7353e + "," + rVar.f7354f;
    }

    public static String P(long j5) {
        if (j5 == -9223372036854775807L) {
            return "?";
        }
        return f41d.format(j5 / 1000.0f);
    }

    @Override // m1.c
    public final void A(m1.a aVar, v vVar, IOException iOException) {
        g1.a.p("ExoPlayerDebug", N(aVar, "internalError", "loadError", iOException));
    }

    @Override // m1.c
    public final void B(m1.a aVar, j0 j0Var) {
        Q("metadata [".concat(O(aVar)));
        T(j0Var, "  ");
        Q("]");
    }

    @Override // m1.c
    public final void C(m1.a aVar) {
        R(aVar, "videoEnabled");
    }

    @Override // m1.c
    public final void D(m1.a aVar, o0 o0Var) {
        S(aVar, "playbackParameters", o0Var.toString());
    }

    @Override // m1.c
    public final void F(m1.a aVar, boolean z8) {
        S(aVar, "shuffleModeEnabled", Boolean.toString(z8));
    }

    @Override // m1.c
    public final void G(m1.a aVar, boolean z8) {
        S(aVar, "isPlaying", Boolean.toString(z8));
    }

    @Override // m1.c
    public final void H(m1.a aVar, int i9) {
        S(aVar, "state", i9 != 1 ? i9 != 2 ? i9 != 3 ? i9 != 4 ? "?" : "ENDED" : "READY" : "BUFFERING" : "IDLE");
    }

    @Override // m1.c
    public final void I(m1.a aVar, boolean z8, int i9) {
        StringBuilder sb = new StringBuilder();
        sb.append(z8);
        sb.append(", ");
        sb.append(i9 != 1 ? i9 != 2 ? i9 != 3 ? i9 != 4 ? i9 != 5 ? "?" : "END_OF_MEDIA_ITEM" : "REMOTE" : "AUDIO_BECOMING_NOISY" : "AUDIO_FOCUS_LOSS" : "USER_REQUEST");
        S(aVar, "playWhenReady", sb.toString());
    }

    @Override // m1.c
    public final void J(m1.a aVar, f fVar) {
        R(aVar, "videoDisabled");
    }

    @Override // m1.c
    public final void K(m1.a aVar, n0 n0Var) {
        g1.a.p("ExoPlayerDebug", N(aVar, "playerFailed", null, n0Var));
    }

    @Override // m1.c
    public final void L(m1.a aVar, v vVar) {
        S(aVar, "downstreamFormat", s.c(vVar.f9439c));
    }

    public final String N(m1.a aVar, String str, String str2, Throwable th) {
        String str3;
        String str4 = str + " [" + O(aVar);
        if (th instanceof n0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str4);
            sb.append(", errorCode=");
            int i9 = ((n0) th).f2507i;
            if (i9 == 7000) {
                str3 = "ERROR_CODE_VIDEO_FRAME_PROCESSOR_INIT_FAILED";
            } else if (i9 != 7001) {
                switch (i9) {
                    case IjkMediaCodecInfo.RANK_MAX /* 1000 */:
                        str3 = "ERROR_CODE_UNSPECIFIED";
                        break;
                    case 1001:
                        str3 = "ERROR_CODE_REMOTE_ERROR";
                        break;
                    case 1002:
                        str3 = "ERROR_CODE_BEHIND_LIVE_WINDOW";
                        break;
                    case 1003:
                        str3 = "ERROR_CODE_TIMEOUT";
                        break;
                    case 1004:
                        str3 = "ERROR_CODE_FAILED_RUNTIME_CHECK";
                        break;
                    default:
                        switch (i9) {
                            case 2000:
                                str3 = "ERROR_CODE_IO_UNSPECIFIED";
                                break;
                            case 2001:
                                str3 = "ERROR_CODE_IO_NETWORK_CONNECTION_FAILED";
                                break;
                            case 2002:
                                str3 = "ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT";
                                break;
                            case 2003:
                                str3 = "ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE";
                                break;
                            case 2004:
                                str3 = "ERROR_CODE_IO_BAD_HTTP_STATUS";
                                break;
                            case 2005:
                                str3 = "ERROR_CODE_IO_FILE_NOT_FOUND";
                                break;
                            case 2006:
                                str3 = "ERROR_CODE_IO_NO_PERMISSION";
                                break;
                            case 2007:
                                str3 = "ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED";
                                break;
                            case 2008:
                                str3 = "ERROR_CODE_IO_READ_POSITION_OUT_OF_RANGE";
                                break;
                            default:
                                switch (i9) {
                                    case 3001:
                                        str3 = "ERROR_CODE_PARSING_CONTAINER_MALFORMED";
                                        break;
                                    case 3002:
                                        str3 = "ERROR_CODE_PARSING_MANIFEST_MALFORMED";
                                        break;
                                    case 3003:
                                        str3 = "ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED";
                                        break;
                                    case 3004:
                                        str3 = "ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED";
                                        break;
                                    default:
                                        switch (i9) {
                                            case 4001:
                                                str3 = "ERROR_CODE_DECODER_INIT_FAILED";
                                                break;
                                            case 4002:
                                                str3 = "ERROR_CODE_DECODER_QUERY_FAILED";
                                                break;
                                            case 4003:
                                                str3 = "ERROR_CODE_DECODING_FAILED";
                                                break;
                                            case 4004:
                                                str3 = "ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES";
                                                break;
                                            case 4005:
                                                str3 = "ERROR_CODE_DECODING_FORMAT_UNSUPPORTED";
                                                break;
                                            default:
                                                switch (i9) {
                                                    case 5001:
                                                        str3 = "ERROR_CODE_AUDIO_TRACK_INIT_FAILED";
                                                        break;
                                                    case 5002:
                                                        str3 = "ERROR_CODE_AUDIO_TRACK_WRITE_FAILED";
                                                        break;
                                                    case 5003:
                                                        str3 = "ERROR_CODE_AUDIO_TRACK_OFFLOAD_WRITE_FAILED";
                                                        break;
                                                    case 5004:
                                                        str3 = "ERROR_CODE_AUDIO_TRACK_OFFLOAD_INIT_FAILED";
                                                        break;
                                                    default:
                                                        switch (i9) {
                                                            case 6000:
                                                                str3 = "ERROR_CODE_DRM_UNSPECIFIED";
                                                                break;
                                                            case 6001:
                                                                str3 = "ERROR_CODE_DRM_SCHEME_UNSUPPORTED";
                                                                break;
                                                            case 6002:
                                                                str3 = "ERROR_CODE_DRM_PROVISIONING_FAILED";
                                                                break;
                                                            case 6003:
                                                                str3 = "ERROR_CODE_DRM_CONTENT_ERROR";
                                                                break;
                                                            case 6004:
                                                                str3 = "ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED";
                                                                break;
                                                            case 6005:
                                                                str3 = "ERROR_CODE_DRM_DISALLOWED_OPERATION";
                                                                break;
                                                            case 6006:
                                                                str3 = "ERROR_CODE_DRM_SYSTEM_ERROR";
                                                                break;
                                                            case 6007:
                                                                str3 = "ERROR_CODE_DRM_DEVICE_REVOKED";
                                                                break;
                                                            case 6008:
                                                                str3 = "ERROR_CODE_DRM_LICENSE_EXPIRED";
                                                                break;
                                                            default:
                                                                if (i9 < 1000000) {
                                                                    str3 = "invalid error code";
                                                                    break;
                                                                } else {
                                                                    str3 = "custom error code";
                                                                    break;
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
            } else {
                str3 = "ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED";
            }
            sb.append(str3);
            str4 = sb.toString();
        }
        if (str2 != null) {
            str4 = str4 + ", " + str2;
        }
        String t8 = g1.a.t(th);
        if (!TextUtils.isEmpty(t8)) {
            str4 = str4 + "\n  " + t8.replace("\n", "\n  ") + '\n';
        }
        return str4.concat("]");
    }

    public final String O(m1.a aVar) {
        String str = "window=" + aVar.f6502c;
        z zVar = aVar.f6503d;
        if (zVar != null) {
            str = str + ", period=" + aVar.f6501b.b(zVar.f9447a);
            if (zVar.b()) {
                str = (str + ", adGroup=" + zVar.f9448b) + ", ad=" + zVar.f9449c;
            }
        }
        return "eventTime=" + P(aVar.f6500a - this.f44c) + ", mediaPos=" + P(aVar.f6504e) + ", " + str;
    }

    public final void Q(String str) {
        g1.a.o("ExoPlayerDebug", str);
    }

    public final void R(m1.a aVar, String str) {
        Q(N(aVar, str, null, null));
    }

    public final void S(m1.a aVar, String str, String str2) {
        Q(N(aVar, str, str2, null));
    }

    public final void T(j0 j0Var, String str) {
        for (int i9 = 0; i9 < j0Var.f2490i.length; i9++) {
            Q(str + j0Var.f2490i[i9]);
        }
    }

    @Override // m1.c
    public final void a(m1.a aVar, s sVar) {
        S(aVar, "audioInputFormat", s.c(sVar));
    }

    @Override // m1.c
    public final void b(m1.a aVar, int i9) {
        S(aVar, "repeatMode", i9 != 0 ? i9 != 1 ? i9 != 2 ? "?" : "ALL" : "ONE" : "OFF");
    }

    @Override // m1.c
    public final void c(m1.a aVar, r rVar) {
        S(aVar, "audioTrackInit", M(rVar));
    }

    @Override // m1.c
    public final void d(m1.a aVar, v vVar) {
        S(aVar, "upstreamDiscarded", s.c(vVar.f9439c));
    }

    @Override // m1.c
    public final void e(m1.a aVar) {
        R(aVar, "audioDisabled");
    }

    @Override // m1.c
    public final void f(m1.a aVar, int i9) {
        S(aVar, "droppedFrames", Integer.toString(i9));
    }

    @Override // m1.c
    public final void g(m1.a aVar, String str) {
        S(aVar, "videoDecoderInitialized", str);
    }

    @Override // m1.c
    public final void h(m1.a aVar, boolean z8) {
        S(aVar, "loading", Boolean.toString(z8));
    }

    @Override // m1.c
    public final void i(m1.a aVar, f1 f1Var) {
        j0 j0Var;
        Q("tracks [".concat(O(aVar)));
        g0 g0Var = f1Var.f2422a;
        for (int i9 = 0; i9 < g0Var.size(); i9++) {
            e1 e1Var = (e1) g0Var.get(i9);
            Q("  group [");
            for (int i10 = 0; i10 < e1Var.f2414a; i10++) {
                String str = e1Var.f2418e[i10] ? "[X]" : "[ ]";
                Q("    " + str + " Track:" + i10 + ", " + s.c(e1Var.a(i10)) + ", supported=" + w.v(e1Var.f2417d[i10]));
            }
            Q("  ]");
        }
        boolean z8 = false;
        for (int i11 = 0; !z8 && i11 < g0Var.size(); i11++) {
            e1 e1Var2 = (e1) g0Var.get(i11);
            for (int i12 = 0; !z8 && i12 < e1Var2.f2414a; i12++) {
                if (e1Var2.f2418e[i12] && (j0Var = e1Var2.a(i12).f2552k) != null && j0Var.f2490i.length > 0) {
                    Q("  Metadata [");
                    T(j0Var, "    ");
                    Q("  ]");
                    z8 = true;
                }
            }
        }
        Q("]");
    }

    @Override // m1.c
    public final void j(m1.a aVar, int i9) {
        S(aVar, "playbackSuppressionReason", i9 != 0 ? i9 != 1 ? "?" : "TRANSIENT_AUDIO_FOCUS_LOSS" : "NONE");
    }

    @Override // m1.c
    public final void k(m1.a aVar) {
        R(aVar, "audioEnabled");
    }

    @Override // m1.c
    public final void l(m1.a aVar, String str) {
        S(aVar, "videoDecoderReleased", str);
    }

    @Override // m1.c
    public final void m(int i9, s0 s0Var, s0 s0Var2, m1.a aVar) {
        String str;
        StringBuilder sb = new StringBuilder("reason=");
        switch (i9) {
            case 0:
                str = "AUTO_TRANSITION";
                break;
            case 1:
                str = "SEEK";
                break;
            case 2:
                str = "SEEK_ADJUSTMENT";
                break;
            case 3:
                str = "SKIP";
                break;
            case 4:
                str = "REMOVE";
                break;
            case 5:
                str = "INTERNAL";
                break;
            case 6:
                str = "SILENCE_SKIP";
                break;
            default:
                str = "?";
                break;
        }
        sb.append(str);
        sb.append(", PositionInfo:old [mediaItem=");
        int i10 = s0Var.f2569b;
        int i11 = s0Var.h;
        sb.append(i10);
        sb.append(", period=");
        sb.append(s0Var.f2572e);
        sb.append(", pos=");
        sb.append(s0Var.f2573f);
        if (i11 != -1) {
            sb.append(", contentPos=");
            sb.append(s0Var.f2574g);
            sb.append(", adGroup=");
            sb.append(i11);
            sb.append(", ad=");
            sb.append(s0Var.f2575i);
        }
        sb.append("], PositionInfo:new [mediaItem=");
        int i12 = s0Var2.f2569b;
        int i13 = s0Var2.h;
        sb.append(i12);
        sb.append(", period=");
        sb.append(s0Var2.f2572e);
        sb.append(", pos=");
        sb.append(s0Var2.f2573f);
        if (i13 != -1) {
            sb.append(", contentPos=");
            sb.append(s0Var2.f2574g);
            sb.append(", adGroup=");
            sb.append(i13);
            sb.append(", ad=");
            sb.append(s0Var2.f2575i);
        }
        sb.append("]");
        S(aVar, "positionDiscontinuity", sb.toString());
    }

    @Override // m1.c
    public final void n(m1.a aVar, Object obj) {
        S(aVar, "renderedFirstFrame", String.valueOf(obj));
    }

    @Override // m1.c
    public final void o(m1.a aVar, int i9) {
        y0 y0Var = aVar.f6501b;
        int h = y0Var.h();
        int o8 = y0Var.o();
        StringBuilder sb = new StringBuilder("timeline [");
        sb.append(O(aVar));
        sb.append(", periodCount=");
        sb.append(h);
        sb.append(", windowCount=");
        sb.append(o8);
        sb.append(", reason=");
        sb.append(i9 != 0 ? i9 != 1 ? "?" : "SOURCE_UPDATE" : "PLAYLIST_CHANGED");
        Q(sb.toString());
        for (int i10 = 0; i10 < Math.min(h, 3); i10++) {
            w0 w0Var = this.f43b;
            y0Var.f(i10, w0Var, false);
            Q("  period [" + P(w.W(w0Var.f2587d)) + "]");
        }
        if (h > 3) {
            Q("  ...");
        }
        for (int i11 = 0; i11 < Math.min(o8, 3); i11++) {
            x0 x0Var = this.f42a;
            y0Var.n(i11, x0Var);
            Q("  window [" + P(w.W(x0Var.f2606n)) + ", seekable=" + x0Var.h + ", dynamic=" + x0Var.f2601i + "]");
        }
        if (o8 > 3) {
            Q("  ...");
        }
        Q("]");
    }

    @Override // m1.c
    public final void q(m1.a aVar, String str) {
        S(aVar, "audioDecoderInitialized", str);
    }

    @Override // m1.c
    public final void r(m1.a aVar, int i9, int i10) {
        S(aVar, "surfaceSize", i9 + ", " + i10);
    }

    @Override // m1.c
    public final void s(m1.a aVar, int i9, long j5, long j9) {
        g1.a.p("ExoPlayerDebug", N(aVar, "audioTrackUnderrun", i9 + ", " + j5 + ", " + j9, null));
    }

    @Override // m1.c
    public final void t(m1.a aVar, int i9) {
        StringBuilder sb = new StringBuilder("mediaItem [");
        sb.append(O(aVar));
        sb.append(", reason=");
        sb.append(i9 != 0 ? i9 != 1 ? i9 != 2 ? i9 != 3 ? "?" : "PLAYLIST_CHANGED" : "SEEK" : "AUTO" : "REPEAT");
        sb.append("]");
        Q(sb.toString());
    }

    @Override // m1.c
    public final void u(m1.a aVar, boolean z8) {
        S(aVar, "skipSilenceEnabled", Boolean.toString(z8));
    }

    @Override // m1.c
    public final void v(m1.a aVar, float f9) {
        S(aVar, "volume", Float.toString(f9));
    }

    @Override // m1.c
    public final void w(m1.a aVar, r rVar) {
        S(aVar, "audioTrackReleased", M(rVar));
    }

    @Override // m1.c
    public final void x(m1.a aVar, h1 h1Var) {
        S(aVar, "videoSize", h1Var.f2474a + ", " + h1Var.f2475b);
    }

    @Override // m1.c
    public final void y(m1.a aVar, String str) {
        S(aVar, "audioDecoderReleased", str);
    }

    @Override // m1.c
    public final void z(m1.a aVar, s sVar) {
        S(aVar, "videoInputFormat", s.c(sVar));
    }

    @Override // m1.c
    public final /* synthetic */ void E(t0 t0Var, b bVar) {
    }

    @Override // m1.c
    public final void p(int i9, long j5, m1.a aVar) {
    }
}
