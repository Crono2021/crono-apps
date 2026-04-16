package a3;

import a8.p;
import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Display;
import android.widget.Toast;
import b2.c0;
import b6.a0;
import b6.d0;
import b6.e0;
import b6.g0;
import b6.q;
import b6.w0;
import b8.r;
import com.network.tvgramplayer.telegram.TdClient$ExplorerAction;
import com.network.tvgramplayer.ui.LiveStreamActivity;
import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.voip.NativeInstance;
import d1.d1;
import d1.h0;
import d1.h1;
import d1.j0;
import d1.r0;
import d1.s;
import d1.z0;
import g1.w;
import h7.k0;
import h7.m;
import i7.x;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import n.v;
import n0.t0;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.webrtc.PeerConnectionFactory;
import s1.n;
import s1.y;
import s1.z;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class i implements d2.f, Client.ResultHandler, i5.g, IMediaPlayer.OnPreparedListener, androidx.activity.result.b, g1.j, NativeInstance.PayloadCallback, y, o0.d, y1.l, g1.c {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f117i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f118j;

    public /* synthetic */ i(k0 k0Var, p pVar) {
        this.f117i = 6;
        this.f118j = pVar;
    }

    @Override // g1.j
    public void a(Object obj) {
        switch (this.f117i) {
            case 11:
                ((r0) obj).j((h0) this.f118j);
                break;
            case 12:
                ((r0) obj).v((d1) this.f118j);
                break;
            case 13:
                ((r0) obj).A((f1.c) this.f118j);
                break;
            case 14:
                ((r0) obj).j(((l1.y) this.f118j).f6065i.U);
                break;
            case 15:
                ((r0) obj).z((j0) this.f118j);
                break;
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                ((r0) obj).l((List) this.f118j);
                break;
            default:
                ((r0) obj).B((h1) this.f118j);
                break;
        }
    }

    @Override // g1.c
    public void accept(Object obj) {
        ((d0) this.f118j).a((z2.a) obj);
    }

    @Override // androidx.activity.result.b
    public void b(Object obj) {
        MainActivity mainActivity = (MainActivity) this.f118j;
        Map map = (Map) obj;
        int i9 = MainActivity.X;
        for (Map.Entry entry : map.entrySet()) {
            Log.i("MainActivity", "Permission " + entry.getKey() + " = " + entry.getValue());
        }
        if (!map.isEmpty()) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                    mainActivity.s("> Some permissions denied ❌");
                    Toast.makeText(mainActivity, "Permissions are required for connectivity", 1).show();
                    return;
                }
            }
        }
        mainActivity.s("> All permissions granted ✅");
    }

    @Override // s1.y
    public int c(Object obj) {
        s sVar = (s) this.f118j;
        n nVar = (n) obj;
        String str = nVar.f8715b;
        return ((str.equals(sVar.f2554m) || str.equals(z.b(sVar))) && nVar.c(sVar, false)) ? 1 : 0;
    }

    @Override // y1.l
    public w0 d(int i9, z0 z0Var, int[] iArr) {
        Object[] objArr;
        y1.i iVar = (y1.i) this.f118j;
        e0 e0Var = g0.f1391j;
        q.b(4, "initialCapacity");
        Object[] objArr2 = new Object[4];
        int i10 = 0;
        int i11 = 0;
        boolean z8 = false;
        while (i10 < z0Var.f2616a) {
            int i12 = i9;
            z0 z0Var2 = z0Var;
            y1.f fVar = new y1.f(i12, z0Var2, i10, iVar, iArr[i10]);
            int i13 = i11 + 1;
            if (objArr2.length < i13) {
                objArr = Arrays.copyOf(objArr2, a0.d(objArr2.length, i13));
            } else if (z8) {
                objArr = (Object[]) objArr2.clone();
            } else {
                objArr2[i11] = fVar;
                i10++;
                i11++;
                i9 = i12;
                z0Var = z0Var2;
            }
            objArr2 = objArr;
            z8 = false;
            objArr2[i11] = fVar;
            i10++;
            i11++;
            i9 = i12;
            z0Var = z0Var2;
        }
        return g0.l(i11, objArr2);
    }

    @Override // d2.f
    public long e(long j5) {
        return w.i((j5 * r0.f2722e) / 1000000, 0L, ((d2.q) this.f118j).f2726j - 1);
    }

    public boolean f(x xVar, int i9, Bundle bundle) {
        n0.d dVar;
        v vVar = (v) this.f118j;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 25 && (i9 & 1) != 0) {
            try {
                ((q0.g) xVar.f5179j).n();
                Parcelable parcelable = (Parcelable) ((q0.g) xVar.f5179j).l();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e9) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e9);
                return false;
            }
        }
        q0.g gVar = (q0.g) xVar.f5179j;
        ClipData clipData = new ClipData(gVar.a(), new ClipData.Item(gVar.m()));
        if (i10 >= 31) {
            dVar = new x(clipData, 2);
        } else {
            n0.e eVar = new n0.e();
            eVar.f7148j = clipData;
            eVar.f7149k = 2;
            dVar = eVar;
        }
        dVar.s(gVar.p());
        dVar.setExtras(bundle);
        return t0.l(vVar, dVar.build()) == null;
    }

    public void g(Display display) {
        c0 c0Var = (c0) this.f118j;
        c0Var.getClass();
        if (display != null) {
            long refreshRate = (long) (1.0E9d / display.getRefreshRate());
            c0Var.f1156k = refreshRate;
            c0Var.f1157l = (refreshRate * 80) / 100;
        } else {
            g1.a.D("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            c0Var.f1156k = -9223372036854775807L;
            c0Var.f1157l = -9223372036854775807L;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
    public void onPrepared(IMediaPlayer iMediaPlayer) {
        LiveStreamActivity liveStreamActivity = (LiveStreamActivity) this.f118j;
        int i9 = LiveStreamActivity.f2332a0;
        Log.i("LiveStreamActivity", "✅ IJK: Prepared and playing");
        iMediaPlayer.start();
        liveStreamActivity.runOnUiThread(new i7.y(liveStreamActivity, 5));
    }

    @Override // org.drinkless.tdlib.Client.ResultHandler
    public void onResult(TdApi.Object object) {
        TdClient$ExplorerAction tdClient$ExplorerAction;
        switch (this.f117i) {
            case 3:
                h7.c cVar = (h7.c) this.f118j;
                if (!(object instanceof TdApi.StorageStatistics)) {
                    cVar.a(0L);
                    break;
                } else {
                    cVar.a(Long.valueOf(((TdApi.StorageStatistics) object).size));
                    break;
                }
            case 4:
                h7.c cVar2 = (h7.c) this.f118j;
                if (object.getConstructor() != -77484353) {
                    Log.e("TdClient", "❌ Error obteniendo Chat Info: " + object);
                    cVar2.a(null);
                    break;
                } else {
                    cVar2.a((TdApi.Chat) object);
                    break;
                }
            case 5:
                m mVar = (m) this.f118j;
                if (!(object instanceof TdApi.OptionValueInteger)) {
                    mVar.a(Long.valueOf(System.currentTimeMillis()));
                    break;
                } else {
                    mVar.a(Long.valueOf(((TdApi.OptionValueInteger) object).value * 1000));
                    break;
                }
            case 6:
                p pVar = (p) this.f118j;
                if (object.getConstructor() == -16498159) {
                    b8.a b9 = r.b(((TdApi.Messages) object).messages);
                    while (b9.hasNext()) {
                        TdApi.Message message = (TdApi.Message) b9.next();
                        TdApi.File f9 = k0.f(message.content);
                        if (f9 != null) {
                            Log.d("TdClient", "¡Video auto-descubierto en el historial!");
                            pVar.h(f9, null);
                            break;
                        } else {
                            TdApi.MessageContent messageContent = message.content;
                            String url = (messageContent == null || (tdClient$ExplorerAction = (TdClient$ExplorerAction) o7.h.I0(k0.e(messageContent))) == null) ? null : tdClient$ExplorerAction.getUrl();
                            if (url != null) {
                                Log.i("TdClient", "🔗 Link detectado en historial: ".concat(url));
                                pVar.h(null, "EXTRACTED_LINK:::".concat(url));
                                break;
                            }
                        }
                    }
                }
                pVar.h(null, "NO_VIDEO_OR_LIVE_FOUND");
                break;
            default:
                g7.a aVar = (g7.a) this.f118j;
                Integer num = null;
                if (!(object instanceof TdApi.Message)) {
                    aVar.a(null);
                    break;
                } else {
                    TdApi.MessageContent messageContent2 = ((TdApi.Message) object).content;
                    if (messageContent2 instanceof TdApi.MessageVideo) {
                        num = Integer.valueOf(((TdApi.MessageVideo) messageContent2).video.video.id);
                    } else if (messageContent2 instanceof TdApi.MessageAudio) {
                        num = Integer.valueOf(((TdApi.MessageAudio) messageContent2).audio.audio.id);
                    } else if (messageContent2 instanceof TdApi.MessageVoiceNote) {
                        num = Integer.valueOf(((TdApi.MessageVoiceNote) messageContent2).voiceNote.voice.id);
                    } else if (messageContent2 instanceof TdApi.MessageDocument) {
                        num = Integer.valueOf(((TdApi.MessageDocument) messageContent2).document.document.id);
                    } else if (messageContent2 instanceof TdApi.MessageAnimation) {
                        num = Integer.valueOf(((TdApi.MessageAnimation) messageContent2).animation.animation.id);
                    }
                    aVar.a(num);
                    break;
                }
        }
    }

    @Override // com.network.tvgramplayer.voip.NativeInstance.PayloadCallback
    public void run(int i9, String str) {
        m7.k kVar = (m7.k) this.f118j;
        kVar.f6733g = str;
        CountDownLatch countDownLatch = kVar.f6732f;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public /* synthetic */ i(Object obj, int i9) {
        this.f117i = i9;
        this.f118j = obj;
    }
}
