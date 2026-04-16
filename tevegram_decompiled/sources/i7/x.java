package i7;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.media.MediaCodec;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.profileinstaller.ProfileInstallReceiver;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class x implements k4.m, n.l2, m3.c, m.y, m.k, n.c1, n0.d, n0.f, o5.g, r1.c, s1.l, x1.c {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5178i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f5179j;

    public x(int i9) {
        this.f5178i = i9;
        switch (i9) {
            case 21:
                this.f5179j = new m7.c(21);
                break;
            case 29:
                this.f5179j = new z2.c(0);
                break;
            default:
                if (Build.VERSION.SDK_INT < 26) {
                    this.f5179j = new o0.m(this);
                    break;
                } else {
                    this.f5179j = new o0.n(this);
                    break;
                }
        }
    }

    public o1.b A() {
        return (o1.b) this.f5179j;
    }

    public UUID B() {
        return d1.i.f2478a;
    }

    public int C() {
        return 1;
    }

    public void D(int i9, long j5) {
        u2.d dVar = (u2.d) this.f5179j;
        if (i9 == 20529) {
            if (j5 == 0) {
                return;
            }
            throw d1.m0.a(null, "ContentEncodingOrder " + j5 + " not supported");
        }
        if (i9 == 20530) {
            if (j5 == 1) {
                return;
            }
            throw d1.m0.a(null, "ContentEncodingScope " + j5 + " not supported");
        }
        switch (i9) {
            case 131:
                dVar.e(i9);
                dVar.f9056w.f9004d = (int) j5;
                return;
            case 136:
                dVar.e(i9);
                dVar.f9056w.W = j5 == 1;
                return;
            case 155:
                dVar.K = dVar.l(j5);
                return;
            case 159:
                dVar.e(i9);
                dVar.f9056w.P = (int) j5;
                return;
            case 176:
                dVar.e(i9);
                dVar.f9056w.f9012m = (int) j5;
                return;
            case 179:
                dVar.b(i9);
                dVar.E.a(dVar.l(j5));
                return;
            case 186:
                dVar.e(i9);
                dVar.f9056w.f9013n = (int) j5;
                return;
            case 215:
                dVar.e(i9);
                dVar.f9056w.f9003c = (int) j5;
                return;
            case 231:
                dVar.D = dVar.l(j5);
                return;
            case 238:
                dVar.R = (int) j5;
                return;
            case 241:
                if (dVar.G) {
                    return;
                }
                dVar.b(i9);
                dVar.F.a(j5);
                dVar.G = true;
                return;
            case 251:
                dVar.S = true;
                return;
            case 16871:
                dVar.e(i9);
                dVar.f9056w.f9007g = (int) j5;
                return;
            case 16980:
                if (j5 == 3) {
                    return;
                }
                throw d1.m0.a(null, "ContentCompAlgo " + j5 + " not supported");
            case 17029:
                if (j5 < 1 || j5 > 2) {
                    throw d1.m0.a(null, "DocTypeReadVersion " + j5 + " not supported");
                }
                return;
            case 17143:
                if (j5 == 1) {
                    return;
                }
                throw d1.m0.a(null, "EBMLReadVersion " + j5 + " not supported");
            case 18401:
                if (j5 == 5) {
                    return;
                }
                throw d1.m0.a(null, "ContentEncAlgo " + j5 + " not supported");
            case 18408:
                if (j5 == 1) {
                    return;
                }
                throw d1.m0.a(null, "AESSettingsCipherMode " + j5 + " not supported");
            case 21420:
                dVar.f9059z = j5 + dVar.f9052s;
                return;
            case 21432:
                int i10 = (int) j5;
                dVar.e(i9);
                if (i10 == 0) {
                    dVar.f9056w.f9023x = 0;
                    return;
                }
                if (i10 == 1) {
                    dVar.f9056w.f9023x = 2;
                    return;
                } else if (i10 == 3) {
                    dVar.f9056w.f9023x = 1;
                    return;
                } else {
                    if (i10 != 15) {
                        return;
                    }
                    dVar.f9056w.f9023x = 3;
                    return;
                }
            case 21680:
                dVar.e(i9);
                dVar.f9056w.f9015p = (int) j5;
                return;
            case 21682:
                dVar.e(i9);
                dVar.f9056w.f9017r = (int) j5;
                return;
            case 21690:
                dVar.e(i9);
                dVar.f9056w.f9016q = (int) j5;
                return;
            case 21930:
                dVar.e(i9);
                dVar.f9056w.V = j5 == 1;
                return;
            case 21938:
                dVar.e(i9);
                u2.c cVar = dVar.f9056w;
                cVar.f9024y = true;
                cVar.f9014o = (int) j5;
                return;
            case 21998:
                dVar.e(i9);
                dVar.f9056w.f9006f = (int) j5;
                return;
            case 22186:
                dVar.e(i9);
                dVar.f9056w.S = j5;
                return;
            case 22203:
                dVar.e(i9);
                dVar.f9056w.T = j5;
                return;
            case 25188:
                dVar.e(i9);
                dVar.f9056w.Q = (int) j5;
                return;
            case 30114:
                dVar.T = j5;
                return;
            case 30321:
                dVar.e(i9);
                int i11 = (int) j5;
                if (i11 == 0) {
                    dVar.f9056w.f9018s = 0;
                    return;
                }
                if (i11 == 1) {
                    dVar.f9056w.f9018s = 1;
                    return;
                } else if (i11 == 2) {
                    dVar.f9056w.f9018s = 2;
                    return;
                } else {
                    if (i11 != 3) {
                        return;
                    }
                    dVar.f9056w.f9018s = 3;
                    return;
                }
            case 2352003:
                dVar.e(i9);
                dVar.f9056w.f9005e = (int) j5;
                return;
            case 2807729:
                dVar.f9053t = j5;
                return;
            default:
                switch (i9) {
                    case 21945:
                        dVar.e(i9);
                        int i12 = (int) j5;
                        if (i12 == 1) {
                            dVar.f9056w.B = 2;
                            return;
                        } else {
                            if (i12 != 2) {
                                return;
                            }
                            dVar.f9056w.B = 1;
                            return;
                        }
                    case 21946:
                        dVar.e(i9);
                        int d9 = d1.j.d((int) j5);
                        if (d9 != -1) {
                            dVar.f9056w.A = d9;
                            return;
                        }
                        return;
                    case 21947:
                        dVar.e(i9);
                        dVar.f9056w.f9024y = true;
                        int c9 = d1.j.c((int) j5);
                        if (c9 != -1) {
                            dVar.f9056w.f9025z = c9;
                            return;
                        }
                        return;
                    case 21948:
                        dVar.e(i9);
                        dVar.f9056w.C = (int) j5;
                        return;
                    case 21949:
                        dVar.e(i9);
                        dVar.f9056w.D = (int) j5;
                        return;
                    default:
                        return;
                }
        }
    }

    public void F(Exception exc) {
        switch (this.f5178i) {
            case 11:
                g1.a.q("DecoderAudioRenderer", "Audio sink error", exc);
                m1.b bVar = ((androidx.media3.decoder.ffmpeg.b) this.f5179j).f983z;
                Handler handler = (Handler) bVar.f6510j;
                if (handler != null) {
                    handler.post(new n1.o(bVar, exc, 1));
                    break;
                }
                break;
            default:
                g1.a.q("MediaCodecAudioRenderer", "Audio sink error", exc);
                m1.b bVar2 = ((n1.s0) this.f5179j).O0;
                Handler handler2 = (Handler) bVar2.f6510j;
                if (handler2 != null) {
                    handler2.post(new n1.o(bVar2, exc, 1));
                    break;
                }
                break;
        }
    }

    public void G() {
        switch (this.f5178i) {
            case 11:
                break;
            default:
                l1.c0 c0Var = ((n1.s0) this.f5179j).Y0;
                if (c0Var != null) {
                    c0Var.f5808a.f5900p.d(2);
                    break;
                }
                break;
        }
    }

    public boolean J(int i9, int i10, Bundle bundle) {
        return false;
    }

    public boolean L(String str) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0069, code lost:
    
        if (g1.w.f3713a >= 26) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int M(d1.s r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.f2554m
            r1 = 0
            if (r0 == 0) goto L75
            java.lang.String r2 = "image"
            java.lang.String r3 = d1.l0.f(r0)
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L19
            java.lang.String r2 = "application/x-image-uri"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L75
        L19:
            java.lang.String r6 = r6.f2554m
            int r0 = g1.w.f3713a
            r6.getClass()
            int r0 = r6.hashCode()
            r2 = 4
            r3 = 1
            r4 = -1
            switch(r0) {
                case -1487464690: goto L57;
                case -1487394660: goto L4c;
                case -1487018032: goto L41;
                case -879272239: goto L36;
                case -879258763: goto L2b;
                default: goto L2a;
            }
        L2a:
            goto L61
        L2b:
            java.lang.String r0 = "image/png"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L34
            goto L61
        L34:
            r4 = 4
            goto L61
        L36:
            java.lang.String r0 = "image/bmp"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L3f
            goto L61
        L3f:
            r4 = 3
            goto L61
        L41:
            java.lang.String r0 = "image/webp"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L4a
            goto L61
        L4a:
            r4 = 2
            goto L61
        L4c:
            java.lang.String r0 = "image/jpeg"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L55
            goto L61
        L55:
            r4 = 1
            goto L61
        L57:
            java.lang.String r0 = "image/heif"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L60
            goto L61
        L60:
            r4 = 0
        L61:
            switch(r4) {
                case 0: goto L65;
                case 1: goto L6b;
                case 2: goto L6b;
                case 3: goto L6b;
                case 4: goto L6b;
                default: goto L64;
            }
        L64:
            goto L70
        L65:
            int r6 = g1.w.f3713a
            r0 = 26
            if (r6 < r0) goto L70
        L6b:
            int r6 = androidx.activity.g.f(r2, r1, r1, r1)
            return r6
        L70:
            int r6 = androidx.activity.g.f(r3, r1, r1, r1)
            return r6
        L75:
            int r6 = androidx.activity.g.f(r1, r1, r1, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: i7.x.M(d1.s):int");
    }

    @Override // m.y
    public void a(m.m mVar, boolean z8) {
        if (mVar instanceof m.f0) {
            ((m.f0) mVar).H.k().c(false);
        }
        m.y yVar = ((n.j) this.f5179j).f6908m;
        if (yVar != null) {
            yVar.a(mVar, z8);
        }
    }

    @Override // s1.l
    public void b(int i9, j1.a aVar, long j5, int i10) {
        ((MediaCodec) this.f5179j).queueSecureInputBuffer(i9, 0, aVar.f5355i, j5, i10);
    }

    @Override // n0.d
    public n0.g build() {
        ContentInfo build;
        build = ((ContentInfo.Builder) this.f5179j).build();
        return new n0.g(new x(build));
    }

    @Override // n0.f
    public ClipData c() {
        ClipData clip;
        clip = ((ContentInfo) this.f5179j).getClip();
        return clip;
    }

    @Override // s1.l
    public void d(long j5, int i9, int i10, int i11) {
        ((MediaCodec) this.f5179j).queueInputBuffer(i9, 0, i10, j5, i11);
    }

    @Override // m.k
    public boolean e(m.m mVar, MenuItem menuItem) {
        n.m mVar2 = ((ActionMenuView) this.f5179j).H;
        if (mVar2 != null) {
            Toolbar toolbar = ((n.r3) mVar2).f7024i;
            Iterator it = ((CopyOnWriteArrayList) toolbar.O.f6511k).iterator();
            if (it.hasNext()) {
                throw androidx.activity.g.l(it);
            }
            n.v3 v3Var = toolbar.Q;
            if (v3Var != null) {
                MediaExplorerActivity mediaExplorerActivity = ((d2) v3Var).f4823i;
                int i9 = MediaExplorerActivity.Y;
                if (menuItem.getItemId() == 2131361857) {
                    c7.b bVar = mediaExplorerActivity.E;
                    if (bVar == null) {
                        b8.i.d("binding");
                        throw null;
                    }
                    int visibility = ((LinearLayout) bVar.f1648b).getVisibility();
                    c7.b bVar2 = mediaExplorerActivity.E;
                    if (visibility != 0) {
                        if (bVar2 == null) {
                            b8.i.d("binding");
                            throw null;
                        }
                        ((LinearLayout) bVar2.f1648b).setVisibility(0);
                        c7.b bVar3 = mediaExplorerActivity.E;
                        if (bVar3 == null) {
                            b8.i.d("binding");
                            throw null;
                        }
                        ((EditText) bVar3.f1653g).requestFocus();
                        mediaExplorerActivity.B();
                        return true;
                    }
                    if (bVar2 == null) {
                        b8.i.d("binding");
                        throw null;
                    }
                    ((LinearLayout) bVar2.f1648b).setVisibility(8);
                    if (mediaExplorerActivity.U.length() <= 0) {
                        return true;
                    }
                    mediaExplorerActivity.U = "";
                    c7.b bVar4 = mediaExplorerActivity.E;
                    if (bVar4 == null) {
                        b8.i.d("binding");
                        throw null;
                    }
                    ((EditText) bVar4.f1653g).setText("");
                    mediaExplorerActivity.w(true);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // n.l2
    public void f(m.m mVar, m.o oVar) {
        m.g gVar = (m.g) this.f5179j;
        Handler handler = gVar.f6407n;
        handler.removeCallbacksAndMessages(null);
        ArrayList arrayList = gVar.f6409p;
        int size = arrayList.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size) {
                i9 = -1;
                break;
            } else if (mVar == ((m.f) arrayList.get(i9)).f6401b) {
                break;
            } else {
                i9++;
            }
        }
        if (i9 == -1) {
            return;
        }
        int i10 = i9 + 1;
        handler.postAtTime(new m.e(this, i10 < arrayList.size() ? (m.f) arrayList.get(i10) : null, oVar, mVar), mVar, SystemClock.uptimeMillis() + 200);
    }

    @Override // k4.m
    public short h() {
        int read = ((InputStream) this.f5179j).read();
        if (read != -1) {
            return (short) read;
        }
        throw new k4.l();
    }

    @Override // m.k
    public void j(m.m mVar) {
        n.r3 r3Var = ((ActionMenuView) this.f5179j).C;
        if (r3Var != null) {
            r3Var.j(mVar);
        }
    }

    @Override // k4.m
    public int k() {
        return (h() << 8) | h();
    }

    @Override // m.y
    public boolean l(m.m mVar) {
        n.j jVar = (n.j) this.f5179j;
        if (mVar == jVar.f6906k) {
            return false;
        }
        ((m.f0) mVar).I.getClass();
        m.y yVar = jVar.f6908m;
        if (yVar != null) {
            return yVar.l(mVar);
        }
        return false;
    }

    @Override // n0.f
    public int m() {
        int flags;
        flags = ((ContentInfo) this.f5179j).getFlags();
        return flags;
    }

    @Override // m3.c
    public void n() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // n0.f
    public ContentInfo o() {
        return (ContentInfo) this.f5179j;
    }

    @Override // m3.c
    public void p(int i9, Object obj) {
        String str;
        switch (i9) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i9 == 6 || i9 == 7 || i9 == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        } else {
            Log.d("ProfileInstaller", str);
        }
        ((ProfileInstallReceiver) this.f5179j).setResultCode(i9);
    }

    @Override // n.l2
    public void q(m.m mVar, MenuItem menuItem) {
        ((m.g) this.f5179j).f6407n.removeCallbacksAndMessages(mVar);
    }

    @Override // k4.m
    public int read(byte[] bArr, int i9) {
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9 && (i11 = ((InputStream) this.f5179j).read(bArr, i10, i9 - i10)) != -1) {
            i10 += i11;
        }
        if (i10 == 0 && i11 == -1) {
            throw new k4.l();
        }
        return i10;
    }

    @Override // n0.d
    public void s(Uri uri) {
        ((ContentInfo.Builder) this.f5179j).setLinkUri(uri);
    }

    @Override // n0.d
    public void setExtras(Bundle bundle) {
        ((ContentInfo.Builder) this.f5179j).setExtras(bundle);
    }

    @Override // s1.l
    public void setParameters(Bundle bundle) {
        ((MediaCodec) this.f5179j).setParameters(bundle);
    }

    @Override // k4.m
    public long skip(long j5) {
        InputStream inputStream = (InputStream) this.f5179j;
        if (j5 < 0) {
            return 0L;
        }
        long j9 = j5;
        while (j9 > 0) {
            long skip = inputStream.skip(j9);
            if (skip <= 0) {
                if (inputStream.read() == -1) {
                    break;
                }
                skip = 1;
            }
            j9 -= skip;
        }
        return j5 - j9;
    }

    @Override // n0.f
    public int t() {
        int source;
        source = ((ContentInfo) this.f5179j).getSource();
        return source;
    }

    public String toString() {
        switch (this.f5178i) {
            case 9:
                return "ContentInfoCompat{" + ((ContentInfo) this.f5179j) + "}";
            default:
                return super.toString();
        }
    }

    @Override // n0.d
    public void u(int i9) {
        ((ContentInfo.Builder) this.f5179j).setFlags(i9);
    }

    public void w(int i9, int i10, d2.n nVar) {
        char c9;
        char c10;
        long j5;
        int i11;
        int i12;
        int[] iArr;
        int i13;
        int i14;
        u2.d dVar = (u2.d) this.f5179j;
        u2.e eVar = dVar.f9033b;
        SparseArray sparseArray = dVar.f9035c;
        g1.p pVar = dVar.f9044k;
        g1.p pVar2 = dVar.f9042i;
        int i15 = 1;
        int i16 = 0;
        if (i9 != 161 && i9 != 163) {
            if (i9 == 165) {
                if (dVar.I != 2) {
                    return;
                }
                u2.c cVar = (u2.c) sparseArray.get(dVar.O);
                int i17 = dVar.R;
                g1.p pVar3 = dVar.f9049p;
                if (i17 != 4 || !"V_VP9".equals(cVar.f9002b)) {
                    nVar.i(i10);
                    return;
                } else {
                    pVar3.C(i10);
                    nVar.readFully(pVar3.f3699a, 0, i10);
                    return;
                }
            }
            if (i9 == 16877) {
                dVar.e(i9);
                u2.c cVar2 = dVar.f9056w;
                int i18 = cVar2.f9007g;
                if (i18 != 1685485123 && i18 != 1685480259) {
                    nVar.i(i10);
                    return;
                }
                byte[] bArr = new byte[i10];
                cVar2.O = bArr;
                nVar.readFully(bArr, 0, i10);
                return;
            }
            if (i9 == 16981) {
                dVar.e(i9);
                byte[] bArr2 = new byte[i10];
                dVar.f9056w.f9008i = bArr2;
                nVar.readFully(bArr2, 0, i10);
                return;
            }
            if (i9 == 18402) {
                byte[] bArr3 = new byte[i10];
                nVar.readFully(bArr3, 0, i10);
                dVar.e(i9);
                dVar.f9056w.f9009j = new d2.c0(1, 0, 0, bArr3);
                return;
            }
            if (i9 == 21419) {
                Arrays.fill(pVar.f3699a, (byte) 0);
                nVar.readFully(pVar.f3699a, 4 - i10, i10);
                pVar.F(0);
                dVar.f9058y = (int) pVar.v();
                return;
            }
            if (i9 == 25506) {
                dVar.e(i9);
                byte[] bArr4 = new byte[i10];
                dVar.f9056w.f9010k = bArr4;
                nVar.readFully(bArr4, 0, i10);
                return;
            }
            if (i9 != 30322) {
                throw d1.m0.a(null, "Unexpected id: " + i9);
            }
            dVar.e(i9);
            byte[] bArr5 = new byte[i10];
            dVar.f9056w.f9022w = bArr5;
            nVar.readFully(bArr5, 0, i10);
            return;
        }
        if (dVar.I == 0) {
            dVar.O = (int) eVar.b(nVar, false, true, 8);
            dVar.P = eVar.f9063c;
            dVar.K = -9223372036854775807L;
            dVar.I = 1;
            pVar2.C(0);
        }
        u2.c cVar3 = (u2.c) sparseArray.get(dVar.O);
        if (cVar3 == null) {
            nVar.i(i10 - dVar.P);
            dVar.I = 0;
            return;
        }
        cVar3.Y.getClass();
        if (dVar.I == 1) {
            dVar.j(nVar, 3);
            int i19 = (pVar2.f3699a[2] & 6) >> 1;
            byte b9 = 255;
            if (i19 == 0) {
                dVar.M = 1;
                int[] iArr2 = dVar.N;
                if (iArr2 == null) {
                    iArr2 = new int[1];
                } else if (iArr2.length < 1) {
                    iArr2 = new int[Math.max(iArr2.length * 2, 1)];
                }
                dVar.N = iArr2;
                iArr2[0] = (i10 - dVar.P) - 3;
            } else {
                dVar.j(nVar, 4);
                int i20 = (pVar2.f3699a[3] & 255) + 1;
                dVar.M = i20;
                int[] iArr3 = dVar.N;
                if (iArr3 == null) {
                    iArr3 = new int[i20];
                } else if (iArr3.length < i20) {
                    iArr3 = new int[Math.max(iArr3.length * 2, i20)];
                }
                dVar.N = iArr3;
                if (i19 == 2) {
                    int i21 = (i10 - dVar.P) - 4;
                    int i22 = dVar.M;
                    Arrays.fill(iArr3, 0, i22, i21 / i22);
                } else {
                    if (i19 != 1) {
                        if (i19 != 3) {
                            throw d1.m0.a(null, "Unexpected lacing value: " + i19);
                        }
                        int i23 = 0;
                        int i24 = 0;
                        int i25 = 4;
                        while (true) {
                            int i26 = dVar.M - i15;
                            int[] iArr4 = dVar.N;
                            if (i23 >= i26) {
                                c9 = 1;
                                c10 = 0;
                                iArr4[i26] = ((i10 - dVar.P) - i25) - i24;
                                break;
                            }
                            iArr4[i23] = i16;
                            int i27 = i25 + 1;
                            dVar.j(nVar, i27);
                            if (pVar2.f3699a[i25] == 0) {
                                throw d1.m0.a(null, "No valid varint length mask found");
                            }
                            int i28 = 0;
                            while (true) {
                                if (i28 >= 8) {
                                    j5 = 0;
                                    i11 = i27;
                                    break;
                                }
                                int i29 = 1 << (7 - i28);
                                if ((pVar2.f3699a[i25] & i29) != 0) {
                                    i11 = i27 + i28;
                                    dVar.j(nVar, i11);
                                    j5 = pVar2.f3699a[i25] & b9 & (~i29);
                                    while (i27 < i11) {
                                        j5 = (j5 << 8) | (pVar2.f3699a[i27] & b9);
                                        i27++;
                                        b9 = 255;
                                    }
                                    if (i23 > 0) {
                                        j5 -= (1 << ((i28 * 7) + 6)) - 1;
                                    }
                                } else {
                                    i28++;
                                    b9 = 255;
                                }
                            }
                            if (j5 < -2147483648L || j5 > 2147483647L) {
                                break;
                            }
                            int i30 = (int) j5;
                            int[] iArr5 = dVar.N;
                            if (i23 != 0) {
                                i30 += iArr5[i23 - 1];
                            }
                            iArr5[i23] = i30;
                            i24 += i30;
                            i23++;
                            i25 = i11;
                            b9 = 255;
                            i15 = 1;
                            i16 = 0;
                        }
                        throw d1.m0.a(null, "EBML lacing sample size out of range.");
                    }
                    int i31 = 0;
                    int i32 = 0;
                    int i33 = 4;
                    while (true) {
                        i12 = dVar.M - 1;
                        iArr = dVar.N;
                        if (i31 >= i12) {
                            break;
                        }
                        iArr[i31] = 0;
                        while (true) {
                            i13 = i33 + 1;
                            dVar.j(nVar, i13);
                            int i34 = pVar2.f3699a[i33] & 255;
                            int[] iArr6 = dVar.N;
                            i14 = iArr6[i31] + i34;
                            iArr6[i31] = i14;
                            if (i34 != 255) {
                                break;
                            } else {
                                i33 = i13;
                            }
                        }
                        i32 += i14;
                        i31++;
                        i33 = i13;
                    }
                    iArr[i12] = ((i10 - dVar.P) - i33) - i32;
                }
            }
            c9 = 1;
            c10 = 0;
            byte[] bArr6 = pVar2.f3699a;
            dVar.J = dVar.l((bArr6[c9] & 255) | (bArr6[c10] << 8)) + dVar.D;
            dVar.Q = (cVar3.f9004d == 2 || (i9 == 163 && (pVar2.f3699a[2] & 128) == 128)) ? 1 : 0;
            dVar.I = 2;
            dVar.L = 0;
        }
        if (i9 == 163) {
            while (true) {
                int i35 = dVar.L;
                if (i35 >= dVar.M) {
                    dVar.I = 0;
                    return;
                } else {
                    dVar.f(cVar3, ((dVar.L * cVar3.f9005e) / IjkMediaCodecInfo.RANK_MAX) + dVar.J, dVar.Q, dVar.m(nVar, cVar3, dVar.N[i35], false), 0);
                    dVar.L++;
                }
            }
        } else {
            while (true) {
                int i36 = dVar.L;
                if (i36 >= dVar.M) {
                    return;
                }
                int[] iArr7 = dVar.N;
                iArr7[i36] = dVar.m(nVar, cVar3, iArr7[i36], true);
                dVar.L++;
            }
        }
    }

    public o0.l x(int i9) {
        return null;
    }

    public o0.l y(int i9) {
        return null;
    }

    public o1.h z() {
        return null;
    }

    private final /* synthetic */ void E() {
    }

    private final /* synthetic */ void H() {
    }

    private final /* synthetic */ void I() {
    }

    @Override // s1.l
    public void flush() {
    }

    @Override // s1.l
    public void i() {
    }

    @Override // s1.l
    public void shutdown() {
    }

    @Override // s1.l
    public void start() {
    }

    public void K(o1.d dVar) {
    }

    @Override // n.c1
    public void g(int i9) {
    }

    @Override // n.c1
    public void r(int i9) {
    }

    public void v(o1.d dVar) {
    }

    public x(Context context, List list, androidx.fragment.app.g gVar, n0 n0Var) {
        this.f5178i = 0;
        list.getClass();
        gVar.getClass();
        this.f5179j = n0Var;
    }

    public x(View view) {
        this.f5178i = 10;
        if (Build.VERSION.SDK_INT >= 30) {
            n0.w wVar = new n0.w(view);
            wVar.f7224b = view;
            this.f5179j = wVar;
            return;
        }
        this.f5179j = new d1.a(view);
    }

    public x(TextView textView) {
        this.f5178i = 28;
        this.f5179j = new x0.g(textView);
    }

    public x(EditText editText) {
        this.f5178i = 27;
        this.f5179j = new m1.b(editText);
    }

    public /* synthetic */ x(Object obj, int i9) {
        this.f5178i = i9;
        this.f5179j = obj;
    }

    public x(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f5178i = 20;
        if (Build.VERSION.SDK_INT >= 25) {
            this.f5179j = new q0.f(uri, clipDescription, uri2);
        } else {
            this.f5179j = new androidx.fragment.app.g(uri, clipDescription, uri2, 25);
        }
    }

    public x(UUID uuid, int i9, byte[] bArr) {
        this.f5178i = 26;
        this.f5179j = uuid;
    }

    public x(ContentInfo contentInfo) {
        this.f5178i = 9;
        contentInfo.getClass();
        this.f5179j = m1.u.j(contentInfo);
    }

    public x(ClipData clipData, int i9) {
        this.f5178i = 8;
        this.f5179j = m1.u.h(clipData, i9);
    }
}
