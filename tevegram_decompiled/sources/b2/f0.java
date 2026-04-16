package b2;

import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.network.tvgramplayer.ui.DiscoveryActivity;
import com.network.tvgramplayer.ui.LiveStreamActivity;
import com.network.tvgramplayer.voip.AudioRecordJNI;
import d1.h1;
import d1.y0;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import l1.a1;
import l1.w0;
import n1.s0;
import org.webrtc.PeerConnectionFactory;
import v1.m0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class f0 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1174i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f1175j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f1176k;

    public /* synthetic */ f0(Object obj, int i9, Object obj2) {
        this.f1174i = i9;
        this.f1175j = obj;
        this.f1176k = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        List list;
        Object obj;
        long j5;
        boolean z8;
        long j9 = -9223372036854775807L;
        boolean z9 = false;
        switch (this.f1174i) {
            case 0:
                a5.d dVar = (a5.d) this.f1175j;
                h1 h1Var = (h1) this.f1176k;
                j0 j0Var = (j0) dVar.f175k;
                int i9 = g1.w.f3713a;
                l1.b0 b0Var = ((l1.y) j0Var).f6065i;
                b0Var.f5788m0 = h1Var;
                b0Var.f5799t.e(25, new a3.i(h1Var, 17));
                return;
            case 1:
                a5.d dVar2 = (a5.d) this.f1175j;
                Exception exc = (Exception) this.f1176k;
                j0 j0Var2 = (j0) dVar2.f175k;
                int i10 = g1.w.f3713a;
                m1.q qVar = ((l1.y) j0Var2).f6065i.f5804y;
                m1.a K = qVar.K();
                qVar.L(K, 1030, new h7.o(K, exc, 9));
                return;
            case 2:
                a5.d dVar3 = (a5.d) this.f1175j;
                String str = (String) this.f1176k;
                j0 j0Var3 = (j0) dVar3.f175k;
                int i11 = g1.w.f3713a;
                m1.q qVar2 = ((l1.y) j0Var3).f6065i.f5804y;
                m1.a K2 = qVar2.K();
                qVar2.L(K2, 1019, new m1.g(K2, str, r9));
                return;
            case 3:
                c2.l lVar = (c2.l) this.f1175j;
                SurfaceTexture surfaceTexture = (SurfaceTexture) this.f1176k;
                SurfaceTexture surfaceTexture2 = lVar.f1604o;
                Surface surface = lVar.f1605p;
                Surface surface2 = new Surface(surfaceTexture);
                lVar.f1604o = surfaceTexture;
                lVar.f1605p = surface2;
                Iterator it = lVar.f1598i.iterator();
                while (it.hasNext()) {
                    ((l1.y) it.next()).f6065i.s0(surface2);
                }
                if (surfaceTexture2 != null) {
                    surfaceTexture2.release();
                }
                if (surface != null) {
                    surface.release();
                    return;
                }
                return;
            case 4:
                ((AudioRecordJNI) this.f1175j).lambda$startThread$0((ByteBuffer) this.f1176k);
                return;
            case 5:
                ((e0.b) this.f1175j).i((Typeface) this.f1176k);
                return;
            case 6:
                g.i0 i0Var = (g.i0) this.f1175j;
                try {
                    ((Runnable) this.f1176k).run();
                    return;
                } finally {
                    i0Var.a();
                }
            case 7:
                ((z1.e) this.f1176k).a(((g1.o) this.f1175j).d());
                return;
            case 8:
                g7.e eVar = (g7.e) this.f1175j;
                Socket socket = (Socket) this.f1176k;
                String str2 = eVar.f3835e;
                try {
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();
                    byte[] bArr = new byte[4096];
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        h8.d dVar4 = new h8.d(new String(bArr, 0, read, h8.a.f4218a));
                        if (dVar4.hasNext()) {
                            Object next = dVar4.next();
                            if (dVar4.hasNext()) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(next);
                                while (dVar4.hasNext()) {
                                    arrayList.add(dVar4.next());
                                }
                                list = arrayList;
                            } else {
                                list = android.support.v4.media.session.b.b0(next);
                            }
                        } else {
                            list = o7.p.f8013i;
                        }
                        String str3 = (String) o7.h.I0(list);
                        if (str3 == null) {
                            str3 = "";
                        }
                        List p02 = h8.e.p0(str3, new String[]{" "}, 6);
                        String str4 = (String) (1 < p02.size() ? p02.get(1) : null);
                        if (str4 == null) {
                            str4 = "/";
                        }
                        Iterator it2 = list.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                Object next2 = it2.next();
                                if (h8.m.f0((String) next2, "Range:", true)) {
                                    obj = next2;
                                }
                            } else {
                                obj = null;
                            }
                        }
                        String str5 = (String) obj;
                        Log.d(str2, "🌍 Proxy Request: " + str4 + " " + (str5 == null ? "" : str5));
                        if (str4.equals("/master.m3u8")) {
                            outputStream.getClass();
                            g7.e.d(outputStream, "#EXTM3U\n#EXT-X-VERSION:3\n#EXT-X-MEDIA:TYPE=AUDIO,GROUP-ID=\"audio0\",NAME=\"Main Audio\",URI=\"audio.m3u8\",AUTOSELECT=YES,DEFAULT=YES\n#EXT-X-STREAM-INF:BANDWIDTH=1000000,CODECS=\"avc1.64001F,mp4a.40.2\",AUDIO=\"audio0\"\nvideo.m3u8");
                        } else if (str4.equals("/video.m3u8")) {
                            outputStream.getClass();
                            g7.e.d(outputStream, eVar.b(1));
                        } else if (str4.equals("/audio.m3u8")) {
                            outputStream.getClass();
                            g7.e.d(outputStream, eVar.b(0));
                        } else if (h8.m.f0(str4, "/segment_", false)) {
                            outputStream.getClass();
                            eVar.f(outputStream, str4);
                        } else if (h8.m.f0(str4, "/init_", false)) {
                            outputStream.getClass();
                            eVar.e(outputStream, str4);
                        } else if (h8.m.f0(str4, "/file/", false)) {
                            Integer Z = h8.l.Z(h8.e.s0(h8.e.s0(h8.e.q0(str4, "/file/", str4), "?"), "/"));
                            if (Z != null) {
                                outputStream.getClass();
                                eVar.g(outputStream, Z.intValue(), str5);
                            } else {
                                Log.w(str2, "❌ 404 Not Found. FileId nulo (Path: " + str4 + ")");
                                outputStream.getClass();
                                g7.e.c(outputStream);
                            }
                        } else if (h8.m.f0(str4, "/resolve", false)) {
                            List<String> p03 = h8.e.p0(h8.e.q0(str4, "?", ""), new String[]{"&"}, 6);
                            int b02 = o7.t.b0(o7.j.E0(p03));
                            if (b02 < 16) {
                                b02 = 16;
                            }
                            LinkedHashMap linkedHashMap = new LinkedHashMap(b02);
                            for (String str6 : p03) {
                                List p04 = h8.e.p0(str6, new String[]{"="}, 6);
                                n7.b bVar = p04.size() == 2 ? new n7.b(p04.get(0), p04.get(1)) : new n7.b(str6, "");
                                linkedHashMap.put(bVar.f7480i, bVar.f7481j);
                            }
                            String str7 = (String) linkedHashMap.get("chat_id");
                            Long a02 = str7 != null ? h8.l.a0(str7) : null;
                            String str8 = (String) linkedHashMap.get("msg_id");
                            Long a03 = str8 != null ? h8.l.a0(str8) : null;
                            if (a02 == null || a03 == null) {
                                Log.w(str2, "❌ 400 Bad Request. Faltan chat_id o msg_id (Path: " + str4 + ")");
                                outputStream.getClass();
                                g7.e.c(outputStream);
                            } else {
                                outputStream.getClass();
                                try {
                                    i8.w.m(new g7.b(eVar, outputStream, str5, a02.longValue(), a03.longValue(), null));
                                } catch (Exception e9) {
                                    Log.e(str2, "Error resolving and serving file: " + e9.getMessage());
                                    g7.e.c(outputStream);
                                }
                            }
                        } else {
                            Log.w(str2, "❌ 404 Not Found. Unknown path (Path: " + str4 + ")");
                            outputStream.getClass();
                            g7.e.c(outputStream);
                        }
                    }
                    outputStream.flush();
                    socket.close();
                    return;
                } catch (Exception e10) {
                    Log.e(str2, "Connection error", e10);
                    return;
                }
            case 9:
                DiscoveryActivity discoveryActivity = (DiscoveryActivity) this.f1175j;
                List list2 = (List) this.f1176k;
                c7.a aVar = discoveryActivity.E;
                if (aVar == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((ProgressBar) aVar.f1643k).setVisibility(8);
                if (list2.isEmpty()) {
                    c7.a aVar2 = discoveryActivity.E;
                    if (aVar2 != null) {
                        ((TextView) aVar2.f1646n).setVisibility(0);
                        return;
                    } else {
                        b8.i.d("binding");
                        throw null;
                    }
                }
                i7.l lVar2 = discoveryActivity.G;
                if (lVar2 == null) {
                    b8.i.d("adapter");
                    throw null;
                }
                lVar2.f4949e = list2;
                lVar2.c();
                c7.a aVar3 = discoveryActivity.E;
                if (aVar3 != null) {
                    ((RecyclerView) aVar3.f1644l).post(new a7.a(discoveryActivity, 11));
                    return;
                } else {
                    b8.i.d("binding");
                    throw null;
                }
            case 10:
                i7.j jVar = (i7.j) this.f1175j;
                ((com.bumptech.glide.k) com.bumptech.glide.b.d(jVar.f7618a.getContext()).n((String) this.f1176k).j(2131231051)).x(jVar.f4913u);
                return;
            case 11:
                LiveStreamActivity liveStreamActivity = (LiveStreamActivity) this.f1175j;
                b8.m mVar = (b8.m) this.f1176k;
                c7.b bVar2 = liveStreamActivity.E;
                if (bVar2 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((LinearLayout) bVar2.f1648b).setVisibility(0);
                c7.b bVar3 = liveStreamActivity.E;
                if (bVar3 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((TextView) bVar3.f1656k).setText("Buffering... (Target: " + mVar.f1523i + ")");
                return;
            case 12:
                j7.j jVar2 = (j7.j) this.f1175j;
                ((com.bumptech.glide.k) com.bumptech.glide.b.d(jVar2.f7618a.getContext()).n((String) this.f1176k).j(2131231051)).x(jVar2.f5464v);
                return;
            case 13:
                l1.b0 b0Var2 = (l1.b0) this.f1175j;
                l1.e0 e0Var = (l1.e0) this.f1176k;
                int i12 = b0Var2.N - e0Var.f5845c;
                b0Var2.N = i12;
                if (e0Var.f5846d) {
                    b0Var2.O = e0Var.f5847e;
                    b0Var2.P = true;
                }
                if (e0Var.f5848f) {
                    b0Var2.Q = e0Var.f5849g;
                }
                if (i12 == 0) {
                    y0 y0Var = e0Var.f5844b.f6047a;
                    if (!b0Var2.f5792o0.f6047a.p() && y0Var.p()) {
                        b0Var2.f5794p0 = -1;
                        b0Var2.f5796q0 = 0L;
                    }
                    if (!y0Var.p()) {
                        List asList = Arrays.asList(((a1) y0Var).h);
                        g1.a.k(asList.size() == b0Var2.f5802w.size());
                        for (int i13 = 0; i13 < asList.size(); i13++) {
                            ((l1.a0) b0Var2.f5802w.get(i13)).f5762b = (y0) asList.get(i13);
                        }
                    }
                    if (b0Var2.P) {
                        if (e0Var.f5844b.f6048b.equals(b0Var2.f5792o0.f6048b) && e0Var.f5844b.f6050d == b0Var2.f5792o0.f6063r) {
                            r9 = 0;
                        }
                        if (r9 != 0) {
                            if (y0Var.p() || e0Var.f5844b.f6048b.b()) {
                                j9 = e0Var.f5844b.f6050d;
                            } else {
                                w0 w0Var = e0Var.f5844b;
                                v1.z zVar = w0Var.f6048b;
                                long j10 = w0Var.f6050d;
                                Object obj2 = zVar.f9447a;
                                d1.w0 w0Var2 = b0Var2.f5801v;
                                y0Var.g(obj2, w0Var2);
                                j9 = j10 + w0Var2.f2588e;
                            }
                        }
                        j5 = j9;
                        z8 = r9;
                    } else {
                        j5 = -9223372036854775807L;
                        z8 = 0;
                    }
                    b0Var2.P = false;
                    b0Var2.w0(e0Var.f5844b, 1, b0Var2.Q, z8, b0Var2.O, j5, -1, false);
                    return;
                }
                return;
            case 14:
                m1.b bVar4 = (m1.b) this.f1175j;
                String str9 = (String) this.f1176k;
                n1.q qVar3 = (n1.q) bVar4.f6511k;
                int i14 = g1.w.f3713a;
                m1.q qVar4 = ((l1.y) qVar3).f6065i.f5804y;
                m1.a K3 = qVar4.K();
                qVar4.L(K3, 1012, new m1.g(K3, str9, 3));
                return;
            case 15:
                i7.x xVar = (i7.x) this.f1175j;
                n1.r rVar = (n1.r) this.f1176k;
                switch (xVar.f5178i) {
                    case 11:
                        m1.b bVar5 = ((androidx.media3.decoder.ffmpeg.b) xVar.f5179j).f983z;
                        Handler handler = (Handler) bVar5.f6510j;
                        if (handler != null) {
                            handler.post(new n1.n(bVar5, rVar, r9));
                            return;
                        }
                        return;
                    default:
                        m1.b bVar6 = ((s0) xVar.f5179j).O0;
                        Handler handler2 = (Handler) bVar6.f6510j;
                        if (handler2 != null) {
                            handler2.post(new n1.n(bVar6, rVar, r9));
                            return;
                        }
                        return;
                }
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                q1.b bVar7 = (q1.b) this.f1175j;
                Uri uri = (Uri) this.f1176k;
                bVar7.f8316q = false;
                bVar7.b(uri);
                return;
            default:
                m0 m0Var = (m0) this.f1175j;
                d2.y yVar = (d2.y) this.f1176k;
                m0Var.G = m0Var.f9349z == null ? yVar : new d2.p(-9223372036854775807L);
                if (yVar.k() == -9223372036854775807L && m0Var.H != -9223372036854775807L) {
                    m0Var.G = new v1.i0(m0Var, m0Var.G);
                }
                m0Var.H = m0Var.G.k();
                if (!m0Var.N && yVar.k() == -9223372036854775807L) {
                    z9 = true;
                }
                m0Var.I = z9;
                m0Var.J = z9 ? 7 : 1;
                m0Var.f9338o.t(m0Var.H, yVar.e(), m0Var.I);
                if (m0Var.D) {
                    return;
                }
                m0Var.z();
                return;
        }
    }
}
