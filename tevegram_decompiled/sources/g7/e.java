package g7;

import android.content.Context;
import android.util.Log;
import h7.k0;
import h8.l;
import i8.w;
import j1.g;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3831a;

    /* renamed from: b, reason: collision with root package name */
    public final k0 f3832b;

    /* renamed from: c, reason: collision with root package name */
    public ServerSocket f3833c;

    /* renamed from: j, reason: collision with root package name */
    public int f3839j;

    /* renamed from: k, reason: collision with root package name */
    public int f3840k;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f3834d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    public final String f3835e = "LocalStreamProxy";

    /* renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap f3836f = new ConcurrentHashMap();

    /* renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap f3837g = new ConcurrentHashMap();
    public final List h = Collections.synchronizedList(new ArrayList());

    /* renamed from: i, reason: collision with root package name */
    public final List f3838i = Collections.synchronizedList(new ArrayList());

    /* renamed from: l, reason: collision with root package name */
    public final int f3841l = 40;

    /* renamed from: m, reason: collision with root package name */
    public final int f3842m = 200;

    /* renamed from: n, reason: collision with root package name */
    public final ExecutorService f3843n = Executors.newFixedThreadPool(16);

    public e(Context context, k0 k0Var) {
        this.f3831a = context;
        this.f3832b = k0Var;
    }

    public static void c(OutputStream outputStream) {
        byte[] bytes = "HTTP/1.1 404 Not Found\r\nConnection: close\r\n\r\n".getBytes(h8.a.f4218a);
        bytes.getClass();
        outputStream.write(bytes);
    }

    public static void d(OutputStream outputStream, String str) {
        byte[] bytes = ("HTTP/1.1 200 OK\r\nContent-Type: application/vnd.apple.mpegurl\r\nConnection: close\r\nAccess-Control-Allow-Origin: *\r\nContent-Length: " + str.length() + "\r\n\r\n" + str).getBytes(h8.a.f4218a);
        bytes.getClass();
        outputStream.write(bytes);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(int r10, long r11, byte[] r13) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g7.e.a(int, long, byte[]):void");
    }

    public final String b(int i9) {
        List list = i9 == 1 ? this.h : this.f3838i;
        StringBuilder sb = new StringBuilder("#EXTM3U\n#EXT-X-VERSION:3\n#EXT-X-TARGETDURATION:5\n");
        list.getClass();
        synchronized (list) {
            try {
                int i10 = i9 == 1 ? this.f3839j : this.f3840k;
                int size = list.size() - this.f3841l;
                if (size < 0) {
                    size = 0;
                }
                List subList = list.subList(size, list.size());
                sb.append("#EXT-X-MEDIA-SEQUENCE:" + (i10 + size) + "\n");
                if (this.f3837g.containsKey(Integer.valueOf(i9))) {
                    sb.append("#EXT-X-MAP:URI=\"init_" + i9 + ".mp4\"\n");
                }
                Iterator it = subList.iterator();
                while (it.hasNext()) {
                    long longValue = ((Number) ((n7.b) it.next()).f7480i).longValue();
                    sb.append("#EXTINF:" + (((Number) r1.f7481j).longValue() / 1000.0d) + ",\n");
                    sb.append("segment_" + longValue + ".m4v?ch=" + i9 + "\n");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb.toString();
    }

    public final void e(OutputStream outputStream, String str) {
        try {
            Integer Z = l.Z(h8.e.s0(h8.e.q0(str, "init_", str), ".mp4"));
            byte[] bArr = (byte[]) this.f3837g.get(Integer.valueOf(Z != null ? Z.intValue() : 0));
            if (bArr == null) {
                c(outputStream);
                return;
            }
            Charset charset = h8.a.f4218a;
            byte[] bytes = "HTTP/1.1 200 OK\r\n".getBytes(charset);
            bytes.getClass();
            outputStream.write(bytes);
            byte[] bytes2 = "Content-Type: video/mp4\r\n".getBytes(charset);
            bytes2.getClass();
            outputStream.write(bytes2);
            byte[] bytes3 = ("Content-Length: " + bArr.length + "\r\n").getBytes(charset);
            bytes3.getClass();
            outputStream.write(bytes3);
            byte[] bytes4 = "Connection: close\r\n".getBytes(charset);
            bytes4.getClass();
            outputStream.write(bytes4);
            byte[] bytes5 = "\r\n".getBytes(charset);
            bytes5.getClass();
            outputStream.write(bytes5);
            outputStream.write(bArr);
            outputStream.flush();
        } catch (Exception e9) {
            Log.e(this.f3835e, "Error serving init: " + e9.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0101, code lost:
    
        android.util.Log.w(r1, "Segment not found: ts=" + r4 + " ch=" + r14 + " (Wait timed out)");
        c(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0125, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.io.OutputStream r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g7.e.f(java.io.OutputStream, java.lang.String):void");
    }

    public final void g(OutputStream outputStream, int i9, String str) {
        e eVar;
        try {
            eVar = this;
            try {
                w.m(new d(eVar, i9, outputStream, str, null));
            } catch (Exception e9) {
                e = e9;
                Log.e(eVar.f3835e, "Error serving static file: " + e.getMessage());
            }
        } catch (Exception e10) {
            e = e10;
            eVar = this;
        }
    }

    public final String h() {
        String str = this.f3835e;
        try {
            ServerSocket serverSocket = new ServerSocket(0, 50, InetAddress.getByName("127.0.0.1"));
            this.f3833c = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f3834d.set(true);
            g gVar = new g(new androidx.activity.d(this, 1));
            gVar.setName("ProxyAcceptor");
            gVar.start();
            Log.i(str, "🚀 HLS Proxy started on port " + localPort);
            return "http://127.0.0.1:" + localPort;
        } catch (Exception e9) {
            Log.e(str, "Failed to start proxy", e9);
            return "";
        }
    }

    public final void i() {
        Log.i(this.f3835e, "🛑 Stopping HLS proxy...");
        this.f3834d.set(false);
        try {
            ServerSocket serverSocket = this.f3833c;
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (Exception unused) {
        }
        this.f3836f.clear();
        this.h.clear();
        this.f3838i.clear();
    }
}
