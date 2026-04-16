package q1;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import d1.j0;
import d1.l0;
import d1.m0;
import d1.r;
import d1.s;
import g1.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p1.t;
import p1.u;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o implements z1.q {

    /* renamed from: i, reason: collision with root package name */
    public final l f8420i;

    /* renamed from: j, reason: collision with root package name */
    public final i f8421j;

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f8404k = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f8405l = Pattern.compile("VIDEO=\"(.+?)\"");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f8406m = Pattern.compile("AUDIO=\"(.+?)\"");

    /* renamed from: n, reason: collision with root package name */
    public static final Pattern f8407n = Pattern.compile("SUBTITLES=\"(.+?)\"");

    /* renamed from: o, reason: collision with root package name */
    public static final Pattern f8408o = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* renamed from: p, reason: collision with root package name */
    public static final Pattern f8409p = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* renamed from: q, reason: collision with root package name */
    public static final Pattern f8410q = Pattern.compile("CHANNELS=\"(.+?)\"");

    /* renamed from: r, reason: collision with root package name */
    public static final Pattern f8411r = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: s, reason: collision with root package name */
    public static final Pattern f8412s = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* renamed from: t, reason: collision with root package name */
    public static final Pattern f8413t = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");

    /* renamed from: u, reason: collision with root package name */
    public static final Pattern f8414u = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* renamed from: v, reason: collision with root package name */
    public static final Pattern f8415v = Pattern.compile("DURATION=([\\d\\.]+)\\b");

    /* renamed from: w, reason: collision with root package name */
    public static final Pattern f8416w = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");

    /* renamed from: x, reason: collision with root package name */
    public static final Pattern f8417x = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* renamed from: y, reason: collision with root package name */
    public static final Pattern f8418y = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* renamed from: z, reason: collision with root package name */
    public static final Pattern f8419z = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
    public static final Pattern A = b("CAN-SKIP-DATERANGES");
    public static final Pattern B = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
    public static final Pattern C = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
    public static final Pattern D = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
    public static final Pattern E = b("CAN-BLOCK-RELOAD");
    public static final Pattern F = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    public static final Pattern G = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    public static final Pattern H = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    public static final Pattern I = Pattern.compile("LAST-MSN=(\\d+)\\b");
    public static final Pattern J = Pattern.compile("LAST-PART=(\\d+)\\b");
    public static final Pattern K = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    public static final Pattern L = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    public static final Pattern M = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    public static final Pattern N = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    public static final Pattern O = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    public static final Pattern P = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    public static final Pattern Q = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    public static final Pattern R = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    public static final Pattern S = Pattern.compile("URI=\"(.+?)\"");
    public static final Pattern T = Pattern.compile("IV=([^,.*]+)");
    public static final Pattern U = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    public static final Pattern V = Pattern.compile("TYPE=(PART|MAP)");
    public static final Pattern W = Pattern.compile("LANGUAGE=\"(.+?)\"");
    public static final Pattern X = Pattern.compile("NAME=\"(.+?)\"");
    public static final Pattern Y = Pattern.compile("GROUP-ID=\"(.+?)\"");
    public static final Pattern Z = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");

    /* renamed from: a0, reason: collision with root package name */
    public static final Pattern f8395a0 = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");

    /* renamed from: b0, reason: collision with root package name */
    public static final Pattern f8396b0 = b("AUTOSELECT");

    /* renamed from: c0, reason: collision with root package name */
    public static final Pattern f8397c0 = b("DEFAULT");

    /* renamed from: d0, reason: collision with root package name */
    public static final Pattern f8398d0 = b("FORCED");

    /* renamed from: e0, reason: collision with root package name */
    public static final Pattern f8399e0 = b("INDEPENDENT");

    /* renamed from: f0, reason: collision with root package name */
    public static final Pattern f8400f0 = b("GAP");

    /* renamed from: g0, reason: collision with root package name */
    public static final Pattern f8401g0 = b("PRECISE");

    /* renamed from: h0, reason: collision with root package name */
    public static final Pattern f8402h0 = Pattern.compile("VALUE=\"(.+?)\"");
    public static final Pattern i0 = Pattern.compile("IMPORT=\"(.+?)\"");

    /* renamed from: j0, reason: collision with root package name */
    public static final Pattern f8403j0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    public o(l lVar, i iVar) {
        this.f8420i = lVar;
        this.f8421j = iVar;
    }

    public static Pattern b(String str) {
        return Pattern.compile(str.concat("=(NO|YES)"));
    }

    public static d1.n c(String str, d1.m[] mVarArr) {
        d1.m[] mVarArr2 = new d1.m[mVarArr.length];
        for (int i9 = 0; i9 < mVarArr.length; i9++) {
            d1.m mVar = mVarArr[i9];
            mVarArr2[i9] = new d1.m(mVar.f2497j, mVar.f2498k, mVar.f2499l, null);
        }
        return new d1.n(str, true, mVarArr2);
    }

    public static d1.m d(String str, String str2, HashMap hashMap) {
        String j5 = j(str, R, "1", hashMap);
        boolean equals = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2);
        Pattern pattern = S;
        if (equals) {
            String k3 = k(str, pattern, hashMap);
            return new d1.m(d1.i.f2481d, null, "video/mp4", Base64.decode(k3.substring(k3.indexOf(44)), 0));
        }
        if ("com.widevine".equals(str2)) {
            UUID uuid = d1.i.f2481d;
            int i9 = w.f3713a;
            return new d1.m(uuid, null, "hls", str.getBytes(a6.b.f203c));
        }
        if (!"com.microsoft.playready".equals(str2) || !"1".equals(j5)) {
            return null;
        }
        String k9 = k(str, pattern, hashMap);
        byte[] decode = Base64.decode(k9.substring(k9.indexOf(44)), 0);
        UUID uuid2 = d1.i.f2482e;
        return new d1.m(uuid2, null, "video/mp4", w2.j.a(uuid2, decode));
    }

    /* JADX WARN: Removed duplicated region for block: B:230:0x086b  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x08a2  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x08a5  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0888  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static q1.i e(q1.l r110, q1.i r111, androidx.fragment.app.g r112, java.lang.String r113) {
        /*
            Method dump skipped, instructions count: 2434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.o.e(q1.l, q1.i, androidx.fragment.app.g, java.lang.String):q1.i");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    public static l f(androidx.fragment.app.g gVar, String str) {
        int i9;
        int i10;
        char c9;
        ArrayList arrayList;
        k kVar;
        String str2;
        ArrayList arrayList2;
        int parseInt;
        String str3;
        k kVar2;
        String str4;
        k kVar3;
        ArrayList arrayList3;
        int i11;
        ArrayList arrayList4;
        int i12;
        int i13;
        ArrayList arrayList5;
        ArrayList arrayList6;
        Uri B2;
        int i14;
        String str5 = str;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        boolean z8 = false;
        boolean z9 = false;
        while (true) {
            boolean a02 = gVar.a0();
            Pattern pattern = S;
            ArrayList arrayList15 = arrayList11;
            Pattern pattern2 = X;
            boolean z10 = z8;
            if (!a02) {
                ArrayList arrayList16 = arrayList8;
                ArrayList arrayList17 = arrayList9;
                ArrayList arrayList18 = arrayList10;
                ArrayList arrayList19 = arrayList14;
                ArrayList arrayList20 = arrayList13;
                boolean z11 = z9;
                ArrayList arrayList21 = new ArrayList();
                HashSet hashSet = new HashSet();
                for (int i15 = 0; i15 < arrayList7.size(); i15++) {
                    k kVar4 = (k) arrayList7.get(i15);
                    Uri uri = kVar4.f8378a;
                    s sVar = kVar4.f8379b;
                    if (hashSet.add(uri)) {
                        g1.a.k(sVar.f2552k == null);
                        ArrayList arrayList22 = (ArrayList) hashMap.get(kVar4.f8378a);
                        arrayList22.getClass();
                        j0 j0Var = new j0(new u(null, null, arrayList22));
                        r a9 = sVar.a();
                        a9.f2526j = j0Var;
                        arrayList21.add(new k(kVar4.f8378a, new s(a9), kVar4.f8380c, kVar4.f8381d, kVar4.f8382e, kVar4.f8383f));
                    }
                }
                int i16 = 0;
                s sVar2 = null;
                List list = null;
                while (i16 < arrayList12.size()) {
                    String str6 = (String) arrayList12.get(i16);
                    String k3 = k(str6, Y, hashMap2);
                    String k9 = k(str6, pattern2, hashMap2);
                    r rVar = new r();
                    rVar.f2518a = k3 + ":" + k9;
                    rVar.f2519b = k9;
                    rVar.f2527k = l0.k("application/x-mpegURL");
                    boolean g9 = g(str6, f8397c0);
                    boolean z12 = g9;
                    if (g(str6, f8398d0)) {
                        z12 = (g9 ? 1 : 0) | 2;
                    }
                    int i17 = z12;
                    if (g(str6, f8396b0)) {
                        i17 = (z12 ? 1 : 0) | 4;
                    }
                    rVar.f2522e = i17;
                    String j5 = j(str6, Z, null, hashMap2);
                    if (TextUtils.isEmpty(j5)) {
                        i9 = i16;
                        i10 = 0;
                    } else {
                        int i18 = w.f3713a;
                        i9 = i16;
                        String[] split = j5.split(",", -1);
                        i10 = w.j(split, "public.accessibility.describes-video") ? IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED : 0;
                        if (w.j(split, "public.accessibility.transcribes-spoken-dialog")) {
                            i10 |= 4096;
                        }
                        if (w.j(split, "public.accessibility.describes-music-and-sound")) {
                            i10 |= 1024;
                        }
                        if (w.j(split, "public.easy-to-read")) {
                            i10 |= 8192;
                        }
                    }
                    rVar.f2523f = i10;
                    rVar.f2521d = j(str6, W, null, hashMap2);
                    String j9 = j(str6, pattern, null, hashMap2);
                    Uri B3 = j9 == null ? null : g1.a.B(str5, j9);
                    ArrayList arrayList23 = arrayList12;
                    j0 j0Var2 = new j0(new u(k3, k9, Collections.EMPTY_LIST));
                    String k10 = k(str6, U, hashMap2);
                    switch (k10.hashCode()) {
                        case -959297733:
                            if (k10.equals("SUBTITLES")) {
                                c9 = 0;
                                break;
                            }
                            c9 = 65535;
                            break;
                        case -333210994:
                            if (k10.equals("CLOSED-CAPTIONS")) {
                                c9 = 1;
                                break;
                            }
                            c9 = 65535;
                            break;
                        case 62628790:
                            if (k10.equals("AUDIO")) {
                                c9 = 2;
                                break;
                            }
                            c9 = 65535;
                            break;
                        case 81665115:
                            if (k10.equals("VIDEO")) {
                                c9 = 3;
                                break;
                            }
                            c9 = 65535;
                            break;
                        default:
                            c9 = 65535;
                            break;
                    }
                    switch (c9) {
                        case 0:
                            arrayList = arrayList17;
                            int i19 = 0;
                            while (true) {
                                if (i19 < arrayList7.size()) {
                                    kVar = (k) arrayList7.get(i19);
                                    if (!k3.equals(kVar.f8382e)) {
                                        i19++;
                                    }
                                } else {
                                    kVar = null;
                                }
                            }
                            if (kVar != null) {
                                String r8 = w.r(3, kVar.f8379b.f2551j);
                                rVar.f2525i = r8;
                                str2 = l0.c(r8);
                            } else {
                                str2 = null;
                            }
                            if (str2 == null) {
                                str2 = "text/vtt";
                            }
                            rVar.f2528l = l0.k(str2);
                            rVar.f2526j = j0Var2;
                            if (B3 != null) {
                                arrayList2 = arrayList18;
                                arrayList2.add(new j(B3, new s(rVar), k9));
                                break;
                            } else {
                                arrayList2 = arrayList18;
                                g1.a.D("HlsPlaylistParser", "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
                                break;
                            }
                        case 1:
                            arrayList = arrayList17;
                            String k11 = k(str6, f8395a0, hashMap2);
                            if (k11.startsWith("CC")) {
                                parseInt = Integer.parseInt(k11.substring(2));
                                str3 = "application/cea-608";
                            } else {
                                parseInt = Integer.parseInt(k11.substring(7));
                                str3 = "application/cea-708";
                            }
                            if (list == null) {
                                list = new ArrayList();
                            }
                            rVar.f2528l = l0.k(str3);
                            rVar.D = parseInt;
                            list.add(new s(rVar));
                            arrayList2 = arrayList18;
                            break;
                        case 2:
                            ArrayList arrayList24 = arrayList16;
                            int i20 = 0;
                            while (true) {
                                if (i20 < arrayList7.size()) {
                                    kVar2 = (k) arrayList7.get(i20);
                                    int i21 = i20;
                                    if (!k3.equals(kVar2.f8381d)) {
                                        i20 = i21 + 1;
                                    }
                                } else {
                                    kVar2 = null;
                                }
                            }
                            if (kVar2 != null) {
                                String r9 = w.r(1, kVar2.f8379b.f2551j);
                                rVar.f2525i = r9;
                                str4 = l0.c(r9);
                            } else {
                                str4 = null;
                            }
                            arrayList16 = arrayList24;
                            String j10 = j(str6, f8410q, null, hashMap2);
                            if (j10 != null) {
                                int i22 = w.f3713a;
                                rVar.f2541y = Integer.parseInt(j10.split("/", 2)[0]);
                                if ("audio/eac3".equals(str4) && j10.endsWith("/JOC")) {
                                    rVar.f2525i = "ec+3";
                                    str4 = "audio/eac3-joc";
                                }
                            }
                            rVar.f2528l = l0.k(str4);
                            if (B3 != null) {
                                rVar.f2526j = j0Var2;
                                arrayList = arrayList17;
                                arrayList.add(new j(B3, new s(rVar), k9));
                            } else {
                                arrayList = arrayList17;
                                if (kVar2 != null) {
                                    sVar2 = new s(rVar);
                                }
                            }
                            arrayList2 = arrayList18;
                            break;
                        case 3:
                            int i23 = 0;
                            while (true) {
                                if (i23 < arrayList7.size()) {
                                    kVar3 = (k) arrayList7.get(i23);
                                    if (!k3.equals(kVar3.f8380c)) {
                                        i23++;
                                    }
                                } else {
                                    kVar3 = null;
                                }
                            }
                            if (kVar3 != null) {
                                s sVar3 = kVar3.f8379b;
                                String r10 = w.r(2, sVar3.f2551j);
                                rVar.f2525i = r10;
                                rVar.f2528l = l0.k(l0.c(r10));
                                rVar.f2533q = sVar3.f2559r;
                                rVar.f2534r = sVar3.f2560s;
                                rVar.f2535s = sVar3.f2561t;
                            }
                            if (B3 != null) {
                                rVar.f2526j = j0Var2;
                                arrayList16.add(new j(B3, new s(rVar), k9));
                            }
                        default:
                            arrayList2 = arrayList18;
                            arrayList = arrayList17;
                            break;
                    }
                    i16 = i9 + 1;
                    str5 = str;
                    arrayList17 = arrayList;
                    arrayList18 = arrayList2;
                    arrayList12 = arrayList23;
                }
                ArrayList arrayList25 = arrayList18;
                ArrayList arrayList26 = arrayList17;
                if (z10) {
                    list = Collections.EMPTY_LIST;
                }
                return new l(str, arrayList19, arrayList21, arrayList16, arrayList26, arrayList25, arrayList15, sVar2, list, z11, hashMap2, arrayList20);
            }
            String f02 = gVar.f0();
            if (f02.startsWith("#EXT")) {
                arrayList14.add(f02);
            }
            boolean startsWith = f02.startsWith("#EXT-X-I-FRAME-STREAM-INF");
            ArrayList arrayList27 = arrayList14;
            if (f02.startsWith("#EXT-X-DEFINE")) {
                hashMap2.put(k(f02, pattern2, hashMap2), k(f02, f8402h0, hashMap2));
            } else {
                if (f02.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                    arrayList6 = arrayList8;
                    arrayList5 = arrayList9;
                    arrayList4 = arrayList10;
                    arrayList3 = arrayList13;
                    z8 = z10;
                    z9 = true;
                } else if (f02.startsWith("#EXT-X-MEDIA")) {
                    arrayList12.add(f02);
                } else if (f02.startsWith("#EXT-X-SESSION-KEY")) {
                    d1.m d9 = d(f02, j(f02, Q, "identity", hashMap2), hashMap2);
                    if (d9 != null) {
                        String k12 = k(f02, P, hashMap2);
                        arrayList13.add(new d1.n(("SAMPLE-AES-CENC".equals(k12) || "SAMPLE-AES-CTR".equals(k12)) ? "cenc" : "cbcs", true, d9));
                    }
                } else if (f02.startsWith("#EXT-X-STREAM-INF") || startsWith) {
                    boolean contains = z10 | f02.contains("CLOSED-CAPTIONS=NONE");
                    int i24 = startsWith ? 16384 : 0;
                    int parseInt2 = Integer.parseInt(k(f02, f8409p, Collections.EMPTY_MAP));
                    Matcher matcher = f8404k.matcher(f02);
                    if (matcher.find()) {
                        arrayList3 = arrayList13;
                        String group = matcher.group(1);
                        group.getClass();
                        i11 = Integer.parseInt(group);
                    } else {
                        arrayList3 = arrayList13;
                        i11 = -1;
                    }
                    boolean z13 = z9;
                    String j11 = j(f02, f8411r, null, hashMap2);
                    String j12 = j(f02, f8412s, null, hashMap2);
                    if (j12 != null) {
                        int i25 = w.f3713a;
                        arrayList4 = arrayList10;
                        String[] split2 = j12.split("x", -1);
                        int parseInt3 = Integer.parseInt(split2[0]);
                        i13 = Integer.parseInt(split2[1]);
                        if (parseInt3 <= 0 || i13 <= 0) {
                            i13 = -1;
                            i14 = -1;
                        } else {
                            i14 = parseInt3;
                        }
                        i12 = i14;
                    } else {
                        arrayList4 = arrayList10;
                        i12 = -1;
                        i13 = -1;
                    }
                    arrayList5 = arrayList9;
                    String j13 = j(f02, f8413t, null, hashMap2);
                    float parseFloat = j13 != null ? Float.parseFloat(j13) : -1.0f;
                    arrayList6 = arrayList8;
                    String j14 = j(f02, f8405l, null, hashMap2);
                    String j15 = j(f02, f8406m, null, hashMap2);
                    String j16 = j(f02, f8407n, null, hashMap2);
                    String j17 = j(f02, f8408o, null, hashMap2);
                    if (startsWith) {
                        B2 = g1.a.B(str5, k(f02, pattern, hashMap2));
                    } else {
                        if (!gVar.a0()) {
                            throw m0.b("#EXT-X-STREAM-INF must be followed by another line");
                        }
                        B2 = g1.a.B(str5, l(gVar.f0(), hashMap2));
                    }
                    Uri uri2 = B2;
                    r rVar2 = new r();
                    rVar2.f2518a = Integer.toString(arrayList7.size());
                    rVar2.f2527k = l0.k("application/x-mpegURL");
                    rVar2.f2525i = j11;
                    rVar2.f2524g = i11;
                    rVar2.h = parseInt2;
                    rVar2.f2533q = i12;
                    rVar2.f2534r = i13;
                    rVar2.f2535s = parseFloat;
                    rVar2.f2523f = i24;
                    arrayList7.add(new k(uri2, new s(rVar2), j14, j15, j16, j17));
                    ArrayList arrayList28 = (ArrayList) hashMap.get(uri2);
                    if (arrayList28 == null) {
                        arrayList28 = new ArrayList();
                        hashMap.put(uri2, arrayList28);
                    }
                    arrayList28.add(new t(i11, j14, parseInt2, j15, j16, j17));
                    z8 = contains;
                    z9 = z13;
                }
                arrayList11 = arrayList15;
                arrayList14 = arrayList27;
                arrayList13 = arrayList3;
                arrayList10 = arrayList4;
                arrayList9 = arrayList5;
                arrayList8 = arrayList6;
            }
            arrayList6 = arrayList8;
            arrayList5 = arrayList9;
            arrayList4 = arrayList10;
            arrayList3 = arrayList13;
            z8 = z10;
            arrayList11 = arrayList15;
            arrayList14 = arrayList27;
            arrayList13 = arrayList3;
            arrayList10 = arrayList4;
            arrayList9 = arrayList5;
            arrayList8 = arrayList6;
        }
    }

    public static boolean g(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return "YES".equals(matcher.group(1));
        }
        return false;
    }

    public static double h(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return -9.223372036854776E18d;
        }
        String group = matcher.group(1);
        group.getClass();
        return Double.parseDouble(group);
    }

    public static long i(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return -1L;
        }
        String group = matcher.group(1);
        group.getClass();
        return Long.parseLong(group);
    }

    public static String j(String str, Pattern pattern, String str2, Map map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = matcher.group(1);
            str2.getClass();
        }
        return (map.isEmpty() || str2 == null) ? str2 : l(str2, map);
    }

    public static String k(String str, Pattern pattern, Map map) {
        String j5 = j(str, pattern, null, map);
        if (j5 != null) {
            return j5;
        }
        throw m0.b("Couldn't match " + pattern.pattern() + " in " + str);
    }

    public static String l(String str, Map map) {
        Matcher matcher = f8403j0.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement((String) map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0068, code lost:
    
        r1 = r0.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x006c, code lost:
    
        if (r1 == null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x006e, code lost:
    
        r1 = r1.trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0076, code lost:
    
        if (r1.isEmpty() == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x007f, code lost:
    
        if (r1.startsWith("#EXT-X-STREAM-INF") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a0, code lost:
    
        if (r1.startsWith("#EXT-X-TARGETDURATION") != false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a8, code lost:
    
        if (r1.startsWith("#EXT-X-MEDIA-SEQUENCE") != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b0, code lost:
    
        if (r1.startsWith("#EXTINF") != false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b8, code lost:
    
        if (r1.startsWith("#EXT-X-KEY") != false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c0, code lost:
    
        if (r1.startsWith("#EXT-X-BYTERANGE") != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c8, code lost:
    
        if (r1.equals("#EXT-X-DISCONTINUITY") != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d0, code lost:
    
        if (r1.equals("#EXT-X-DISCONTINUITY-SEQUENCE") != false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d8, code lost:
    
        if (r1.equals("#EXT-X-ENDLIST") == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00db, code lost:
    
        r8.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00df, code lost:
    
        r8.add(r1);
        r7 = e(r6.f8420i, r6.f8421j, new androidx.fragment.app.g(r8, r0), r7.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f5, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0081, code lost:
    
        r8.add(r1);
        r7 = f(new androidx.fragment.app.g(r8, r0), r7.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0093, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00fb, code lost:
    
        r0.close();
     */
    @Override // z1.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final q1.m a(android.net.Uri r7, i1.j r8) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.o.a(android.net.Uri, i1.j):q1.m");
    }
}
