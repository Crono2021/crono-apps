package d4;

import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Log;
import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class t implements x4.a, e4.a, f4.a, h4.r, k4.p, m3.c, m.y, o1.g {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f2923i;

    public t(g5.d dVar, g5.d dVar2) {
        this.f2923i = 11;
        dVar.getClass();
        dVar2.getClass();
        if (0.0f <= 0.0f) {
            return;
        }
        m7.c.d();
        throw null;
    }

    public static final void s(String str) {
        CopyOnWriteArrayList copyOnWriteArrayList = m7.k.M;
        Log.d("TelegramNTgCallsManager", "[UI-LOG] ".concat(str));
        StringBuilder sb = m7.k.O;
        synchronized (sb) {
            sb.append("\n".concat(str));
            if (!m7.k.N) {
                m7.k.N = true;
                m7.k.P.postDelayed(new m7.e(), 500L);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0147, code lost:
    
        if (r14.equals("telegram.me") == false) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        return new d7.a(h8.m.e0(r3, r20.getScheme() + "://", "https://"), r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x014f, code lost:
    
        if (r14.equals("t.me") == false) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0157, code lost:
    
        if (r14.equals("play") == false) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x019e, code lost:
    
        if (b8.i.a(r18.getHost(), "v1") == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x01a0, code lost:
    
        r3 = r18.getPath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x01a4, code lost:
    
        if (r3 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x01a6, code lost:
    
        r12 = h8.e.q0(r3, "/", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x01ae, code lost:
    
        if (r12.length() <= 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01b5, code lost:
    
        return new d7.c(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x01b6, code lost:
    
        r3 = r20.toString();
        r3.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01c4, code lost:
    
        if (h8.e.g0(r3, "url=", false) == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x01c6, code lost:
    
        r1 = h8.e.q0(r3, "url=", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01cf, code lost:
    
        if (r1 != null) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01d2, code lost:
    
        r2 = r20.getQueryParameter(tv.danmaku.ijk.media.player.IjkMediaMetadataRetriever.METADATA_KEY_TITLE);
        r7 = r20.getQueryParameter("channel");
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01e3, code lost:
    
        if (h8.e.g0(r1, "%", false) == false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01e5, code lost:
    
        r1 = android.net.Uri.decode(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01cb, code lost:
    
        r1 = r20.getQueryParameter(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0192, code lost:
    
        if (r14.equals("v1") == false) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0266, code lost:
    
        if (r14.equals("telegram.dog") == false) goto L136;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0240  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.bumptech.glide.c v(android.net.Uri r20) {
        /*
            Method dump skipped, instructions count: 806
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.t.v(android.net.Uri):com.bumptech.glide.c");
    }

    @Override // o1.g
    public i7.x c(o1.d dVar, d1.s sVar) {
        if (sVar.f2557p == null) {
            return null;
        }
        return new i7.x(new o1.b(new o1.i(), 6001), 15);
    }

    @Override // e4.a
    public Bitmap e(int i9, int i10, Bitmap.Config config) {
        return Bitmap.createBitmap(i9, i10, config);
    }

    @Override // e4.a
    public Bitmap f(int i9, int i10, Bitmap.Config config) {
        return Bitmap.createBitmap(i9, i10, config);
    }

    @Override // e4.a
    public void g(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // x4.a
    public Object h() {
        switch (this.f2923i) {
            case 1:
                return new z();
            default:
                try {
                    return new f4.g(MessageDigest.getInstance("SHA-256"));
                } catch (NoSuchAlgorithmException e9) {
                    throw new RuntimeException(e9);
                }
        }
    }

    @Override // h4.r
    public h4.q i(h4.w wVar) {
        return new h4.y(wVar.b(h4.g.class, InputStream.class), 1);
    }

    @Override // o1.g
    public int j(d1.s sVar) {
        return sVar.f2557p != null ? 1 : 0;
    }

    @Override // o1.g
    public /* synthetic */ o1.f k(o1.d dVar, d1.s sVar) {
        return o1.f.f7572a;
    }

    @Override // m.y
    public boolean l(m.m mVar) {
        return false;
    }

    @Override // m3.c
    public void n() {
        switch (this.f2923i) {
            case 21:
                break;
            default:
                Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
                break;
        }
    }

    @Override // m3.c
    public void p(int i9, Object obj) {
        String str;
        switch (this.f2923i) {
            case 21:
                break;
            default:
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
                if (i9 != 6 && i9 != 7 && i9 != 8) {
                    Log.d("ProfileInstaller", str);
                    break;
                } else {
                    Log.e("ProfileInstaller", str, (Throwable) obj);
                    break;
                }
                break;
        }
    }

    @Override // f4.a
    public File r(b4.f fVar) {
        return null;
    }

    public /* synthetic */ t(int i9) {
        this.f2923i = i9;
    }

    private final void t() {
    }

    @Override // o1.g
    public /* synthetic */ void b() {
    }

    @Override // k4.p
    public void m0() {
    }

    @Override // e4.a
    public void q() {
    }

    @Override // o1.g
    public /* synthetic */ void release() {
    }

    @Override // e4.a
    public void m(int i9) {
    }

    private final void u(int i9, Object obj) {
    }

    @Override // m.y
    public void a(m.m mVar, boolean z8) {
    }

    @Override // o1.g
    public void d(Looper looper, m1.x xVar) {
    }

    @Override // k4.p
    public void l0(Bitmap bitmap, e4.a aVar) {
    }

    @Override // f4.a
    public void o(b4.f fVar, androidx.fragment.app.g gVar) {
    }
}
