package i1;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c0 extends c {

    /* renamed from: m, reason: collision with root package name */
    public final int f4299m;

    /* renamed from: n, reason: collision with root package name */
    public final byte[] f4300n;

    /* renamed from: o, reason: collision with root package name */
    public final DatagramPacket f4301o;

    /* renamed from: p, reason: collision with root package name */
    public Uri f4302p;

    /* renamed from: q, reason: collision with root package name */
    public DatagramSocket f4303q;

    /* renamed from: r, reason: collision with root package name */
    public MulticastSocket f4304r;

    /* renamed from: s, reason: collision with root package name */
    public InetAddress f4305s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4306t;

    /* renamed from: u, reason: collision with root package name */
    public int f4307u;

    public c0() {
        super(true);
        this.f4299m = 8000;
        byte[] bArr = new byte[2000];
        this.f4300n = bArr;
        this.f4301o = new DatagramPacket(bArr, 0, 2000);
    }

    @Override // i1.h
    public final void close() {
        this.f4302p = null;
        MulticastSocket multicastSocket = this.f4304r;
        if (multicastSocket != null) {
            try {
                InetAddress inetAddress = this.f4305s;
                inetAddress.getClass();
                multicastSocket.leaveGroup(inetAddress);
            } catch (IOException unused) {
            }
            this.f4304r = null;
        }
        DatagramSocket datagramSocket = this.f4303q;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f4303q = null;
        }
        this.f4305s = null;
        this.f4307u = 0;
        if (this.f4306t) {
            this.f4306t = false;
            l();
        }
    }

    @Override // i1.h
    public final long f(k kVar) {
        Uri uri = kVar.f4324a;
        this.f4302p = uri;
        String host = uri.getHost();
        host.getClass();
        int port = this.f4302p.getPort();
        q();
        try {
            this.f4305s = InetAddress.getByName(host);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f4305s, port);
            if (this.f4305s.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f4304r = multicastSocket;
                multicastSocket.joinGroup(this.f4305s);
                this.f4303q = this.f4304r;
            } else {
                this.f4303q = new DatagramSocket(inetSocketAddress);
            }
            this.f4303q.setSoTimeout(this.f4299m);
            this.f4306t = true;
            r(kVar);
            return -1L;
        } catch (IOException e9) {
            throw new b0(e9, 2001);
        } catch (SecurityException e10) {
            throw new b0(e10, 2006);
        }
    }

    @Override // i1.h
    public final Uri m() {
        return this.f4302p;
    }

    @Override // d1.k
    public final int read(byte[] bArr, int i9, int i10) {
        if (i10 == 0) {
            return 0;
        }
        int i11 = this.f4307u;
        DatagramPacket datagramPacket = this.f4301o;
        if (i11 == 0) {
            try {
                DatagramSocket datagramSocket = this.f4303q;
                datagramSocket.getClass();
                datagramSocket.receive(datagramPacket);
                int length = datagramPacket.getLength();
                this.f4307u = length;
                c(length);
            } catch (SocketTimeoutException e9) {
                throw new b0(e9, 2002);
            } catch (IOException e10) {
                throw new b0(e10, 2001);
            }
        }
        int length2 = datagramPacket.getLength();
        int i12 = this.f4307u;
        int min = Math.min(i12, i10);
        System.arraycopy(this.f4300n, length2 - i12, bArr, i9, min);
        this.f4307u -= min;
        return min;
    }
}
