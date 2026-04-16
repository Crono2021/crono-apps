package com.network.tvgramplayer.ui;

import android.app.Application;
import android.content.Intent;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.d;
import androidx.lifecycle.g0;
import androidx.media3.ui.PlayerView;
import b2.h0;
import b8.i;
import c7.b;
import com.google.gson.Gson;
import com.network.tvgramplayer.TvgramApplication;
import com.network.tvgramplayer.player.RawPlayerJNI;
import com.network.tvgramplayer.ui.LiveStreamActivity;
import g.l;
import g7.e;
import h7.o;
import i7.b0;
import i7.d0;
import i7.e0;
import i7.m3;
import i7.x;
import i7.y;
import i8.c0;
import i8.d1;
import i8.w;
import java.util.concurrent.CopyOnWriteArrayList;
import k7.a;
import m7.k;
import n0.b2;
import n0.c2;
import n0.d2;
import r7.c;
import tv.danmaku.ijk.media.player.IjkMediaMetadataRetriever;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class LiveStreamActivity extends l {

    /* renamed from: a0, reason: collision with root package name */
    public static final /* synthetic */ int f2332a0 = 0;
    public b E;
    public k F;
    public long G;
    public Surface H;
    public boolean J;
    public IjkMediaPlayer K;
    public e L;
    public d1 M;
    public boolean N;
    public AudioTrack O;
    public a P;
    public boolean T;
    public long W;
    public int X;
    public Thread Z;
    public final boolean I = true;
    public final b0 Q = new b0(this, 0);
    public final StringBuilder R = new StringBuilder();
    public final Handler S = new Handler(Looper.getMainLooper());
    public final y U = new y(this, 10);
    public final Object V = new Object();
    public int Y = -1;

    @Override // g.l, c0.g, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getClass();
        if (keyEvent.getKeyCode() != 4) {
            v();
            return super.dispatchKeyEvent(keyEvent);
        }
        Log.i("LiveStreamActivity", "🔙 Back button pressed - finishing activity");
        finish();
        return true;
    }

    @Override // androidx.activity.n, android.app.Activity
    public final void onBackPressed() {
        Log.i("LiveStreamActivity", "🔙 onBackPressed() triggered - finishing activity");
        finish();
    }

    @Override // g.l, androidx.activity.n, c0.g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i("LiveStreamActivity", "🎬 LiveStreamActivity onCreate() iniciado");
        this.P = new a(this);
        try {
            getWindow().addFlags(128);
            b b9 = b.b(getLayoutInflater());
            this.E = b9;
            setContentView((FrameLayout) b9.f1650d);
            Log.i("LiveStreamActivity", "✅ Layout inflado correctamente");
            this.W = getIntent().getLongExtra("chat_id", 0L);
            getIntent().getIntExtra("group_call_id", 0);
            if (this.W == 0) {
                Log.e("LiveStreamActivity", "💥 FATAL CRASH en onCreate(): Chat ID is 0, finishing activity.");
                finish();
                return;
            }
            Log.i("LiveStreamActivity", "🚀 MODE: NATIVE ONLY (FFmpeg Engine)");
            u();
            Log.i("LiveStreamActivity", "⚙️ SETTINGS CHECK:");
            a aVar = this.P;
            c cVar = null;
            if (aVar == null) {
                i.d("settings");
                throw null;
            }
            Log.i("LiveStreamActivity", "   - Sync Auto: " + aVar.f5628b.getBoolean("sync_auto", true));
            a aVar2 = this.P;
            if (aVar2 == null) {
                i.d("settings");
                throw null;
            }
            Log.i("LiveStreamActivity", "   - Smart Sync: " + aVar2.f5628b.getBoolean("smart_sync", true));
            a aVar3 = this.P;
            if (aVar3 == null) {
                i.d("settings");
                throw null;
            }
            Log.i("LiveStreamActivity", "   - MultiThread Dec: " + aVar3.f5628b.getBoolean("multithreaded_decoding", true));
            a aVar4 = this.P;
            if (aVar4 == null) {
                i.d("settings");
                throw null;
            }
            Log.i("LiveStreamActivity", "   - Thread Sync: " + aVar4.f5628b.getBoolean("multithreaded_sync", true));
            b bVar = this.E;
            if (bVar == null) {
                i.d("binding");
                throw null;
            }
            final int i9 = 0;
            ((ImageButton) bVar.f1647a).setOnClickListener(new View.OnClickListener(this) { // from class: i7.z

                /* renamed from: j, reason: collision with root package name */
                public final /* synthetic */ LiveStreamActivity f5225j;

                {
                    this.f5225j = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i10 = i9;
                    LiveStreamActivity liveStreamActivity = this.f5225j;
                    switch (i10) {
                        case 0:
                            int i11 = LiveStreamActivity.f2332a0;
                            Log.i("LiveStreamActivity", "❌ Close button clicked - finishing activity");
                            liveStreamActivity.finish();
                            break;
                        case 1:
                            int i12 = LiveStreamActivity.f2332a0;
                            liveStreamActivity.v();
                            break;
                        default:
                            int i13 = LiveStreamActivity.f2332a0;
                            liveStreamActivity.v();
                            break;
                    }
                }
            });
            b bVar2 = this.E;
            if (bVar2 == null) {
                i.d("binding");
                throw null;
            }
            final int i10 = 1;
            ((FrameLayout) bVar2.f1650d).setOnClickListener(new View.OnClickListener(this) { // from class: i7.z

                /* renamed from: j, reason: collision with root package name */
                public final /* synthetic */ LiveStreamActivity f5225j;

                {
                    this.f5225j = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i102 = i10;
                    LiveStreamActivity liveStreamActivity = this.f5225j;
                    switch (i102) {
                        case 0:
                            int i11 = LiveStreamActivity.f2332a0;
                            Log.i("LiveStreamActivity", "❌ Close button clicked - finishing activity");
                            liveStreamActivity.finish();
                            break;
                        case 1:
                            int i12 = LiveStreamActivity.f2332a0;
                            liveStreamActivity.v();
                            break;
                        default:
                            int i13 = LiveStreamActivity.f2332a0;
                            liveStreamActivity.v();
                            break;
                    }
                }
            });
            b bVar3 = this.E;
            if (bVar3 == null) {
                i.d("binding");
                throw null;
            }
            final int i11 = 2;
            ((FrameLayout) bVar3.f1651e).setOnClickListener(new View.OnClickListener(this) { // from class: i7.z

                /* renamed from: j, reason: collision with root package name */
                public final /* synthetic */ LiveStreamActivity f5225j;

                {
                    this.f5225j = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i102 = i11;
                    LiveStreamActivity liveStreamActivity = this.f5225j;
                    switch (i102) {
                        case 0:
                            int i112 = LiveStreamActivity.f2332a0;
                            Log.i("LiveStreamActivity", "❌ Close button clicked - finishing activity");
                            liveStreamActivity.finish();
                            break;
                        case 1:
                            int i12 = LiveStreamActivity.f2332a0;
                            liveStreamActivity.v();
                            break;
                        default:
                            int i13 = LiveStreamActivity.f2332a0;
                            liveStreamActivity.v();
                            break;
                    }
                }
            });
            getSharedPreferences("stream_history", 0);
            new Gson();
            w.a(c0.f5251b);
            Intent intent = getIntent();
            intent.getClass();
            s(intent);
            w.j(g0.a(this), null, new m3(this, cVar, 2), 3);
            setVolumeControlStream(3);
            this.S.postDelayed(new y(this, 9), 500L);
        } catch (Throwable th) {
            Log.e("LiveStreamActivity", "💥 FATAL CRASH en onCreate(): " + th.getMessage());
            th.printStackTrace();
            finish();
        }
    }

    @Override // g.l, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        Log.i("LiveStreamActivity", "🛑 LiveStreamActivity onDestroy() - Cleaning up resources");
        IjkMediaPlayer ijkMediaPlayer = this.K;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.stop();
            ijkMediaPlayer.release();
        }
        this.K = null;
        e eVar = this.L;
        if (eVar != null) {
            eVar.i();
        }
        this.L = null;
        synchronized (this.V) {
            try {
                long j5 = this.G;
                if (j5 != 0) {
                    if (this.I) {
                        RawPlayerJNI.INSTANCE.nativeReleasePull(j5);
                    } else {
                        RawPlayerJNI.INSTANCE.nativeRelease(j5);
                    }
                    this.G = 0L;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        AudioTrack audioTrack = this.O;
        if (audioTrack != null) {
            audioTrack.stop();
            audioTrack.release();
        }
        this.O = null;
        Object systemService = getSystemService("audio");
        systemService.getClass();
        AudioManager audioManager = (AudioManager) systemService;
        try {
            audioManager.setMode(0);
            audioManager.setSpeakerphoneOn(false);
            if (Build.VERSION.SDK_INT >= 31) {
                audioManager.clearCommunicationDevice();
            }
            Log.i("LiveStreamActivity", "🧹 Audio mode reset to NORMAL");
        } catch (Exception e9) {
            Log.e("LiveStreamActivity", "❌ Failed to reset audio mode", e9);
        }
        k kVar = this.F;
        if (kVar != null) {
            kVar.f6749x = null;
        }
        if (kVar != null) {
            kVar.g();
        }
        this.F = null;
        Thread thread = this.Z;
        if (thread != null) {
            thread.interrupt();
        }
        this.S.removeCallbacksAndMessages(null);
        CopyOnWriteArrayList copyOnWriteArrayList = k.M;
        b0 b0Var = this.Q;
        b0Var.getClass();
        k.M.remove(b0Var);
        getWindow().clearFlags(128);
    }

    @Override // g.l, androidx.activity.n, android.app.Activity
    public final void onNewIntent(Intent intent) {
        intent.getClass();
        super.onNewIntent(intent);
        setIntent(intent);
        Log.i("LiveStreamActivity", "🔄 onNewIntent() recibido - Cambiando de stream");
        Thread thread = this.Z;
        if (thread != null) {
            thread.interrupt();
        }
        k kVar = this.F;
        if (kVar != null) {
            kVar.g();
        }
        this.F = new k(this);
        t();
        s(intent);
    }

    @Override // g.l, android.app.Activity
    public final void onResume() {
        super.onResume();
        getWindow().addFlags(128);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z8) {
        b2 d2Var;
        WindowInsetsController insetsController;
        super.onWindowFocusChanged(z8);
        if (z8) {
            Window window = getWindow();
            x xVar = new x(getWindow().getDecorView());
            int i9 = Build.VERSION.SDK_INT;
            if (i9 >= 30) {
                insetsController = window.getInsetsController();
                d2Var = new b2(insetsController, xVar);
                d2Var.f7141j = window;
            } else {
                d2Var = i9 >= 26 ? new d2(window, xVar) : i9 >= 23 ? new c2(window, xVar) : new b2(window, xVar);
            }
            d2Var.N();
            d2Var.y();
            getWindow().addFlags(128);
        }
    }

    public final void s(Intent intent) {
        int intExtra = intent.getIntExtra("group_call_id", 0);
        long longExtra = intent.getLongExtra("chat_id", 0L);
        String stringExtra = intent.getStringExtra(IjkMediaMetadataRetriever.METADATA_KEY_TITLE);
        if (stringExtra == null) {
            stringExtra = "Directo en Vivo";
        }
        int intExtra2 = intent.getIntExtra("participant_count", 0);
        String stringExtra2 = intent.getStringExtra("invite_link");
        Log.i("LiveStreamActivity", "📊 Intent Data: ChatID " + longExtra + ", GroupCallID " + intExtra + ", Title: " + stringExtra);
        b bVar = this.E;
        if (bVar == null) {
            i.d("binding");
            throw null;
        }
        ((TextView) bVar.f1655j).setText(stringExtra.length() != 0 ? stringExtra : "Directo en Vivo");
        b bVar2 = this.E;
        if (bVar2 == null) {
            i.d("binding");
            throw null;
        }
        ((TextView) bVar2.f1657l).setText(intExtra2 + " espectadores");
        b bVar3 = this.E;
        if (bVar3 == null) {
            i.d("binding");
            throw null;
        }
        ((LinearLayout) bVar3.f1648b).setVisibility(0);
        b bVar4 = this.E;
        if (bVar4 == null) {
            i.d("binding");
            throw null;
        }
        ((TextView) bVar4.f1656k).setText("Cargando...");
        a aVar = this.P;
        if (aVar == null) {
            i.d("settings");
            throw null;
        }
        int i9 = aVar.f5628b.getInt("player_sync_mode", 3);
        boolean z8 = i9 == 2;
        this.J = z8;
        Log.i("LiveStreamActivity", "🎯 Selected Player: " + (z8 ? "IJK" : "NATIVE") + " (SyncMode: " + i9 + ")");
        if (this.J && this.L == null) {
            Application application = getApplication();
            application.getClass();
            e eVar = new e(this, ((TvgramApplication) application).a());
            this.L = eVar;
            Log.i("LiveStreamActivity", "🌐 Local Proxy for IJK: ".concat(eVar.h()));
        }
        CopyOnWriteArrayList copyOnWriteArrayList = k.M;
        b0 b0Var = this.Q;
        b0Var.getClass();
        k.M.add(b0Var);
        if (this.F == null) {
            this.F = new k(this);
            t();
        }
        b bVar5 = this.E;
        if (bVar5 == null) {
            i.d("binding");
            throw null;
        }
        ((PlayerView) bVar5.h).setVisibility(8);
        b bVar6 = this.E;
        if (bVar6 == null) {
            i.d("binding");
            throw null;
        }
        ((FrameLayout) bVar6.f1651e).setVisibility(0);
        b bVar7 = this.E;
        if (bVar7 == null) {
            i.d("binding");
            throw null;
        }
        ((SurfaceView) bVar7.f1653g).setVisibility(0);
        Thread thread = this.Z;
        if (thread != null) {
            thread.interrupt();
        }
        this.X = intExtra;
        this.Y = -1;
        Thread thread2 = new Thread(new h0(this, longExtra, stringExtra2, 2));
        thread2.start();
        this.Z = thread2;
    }

    public final void t() {
        Log.i("LiveStreamActivity", "🔧 setupNTgCallsListeners()...");
        b8.l lVar = new b8.l();
        k kVar = this.F;
        if (kVar != null) {
            kVar.f6749x = new i7.c0(lVar, this);
        }
        if (kVar != null) {
            kVar.f6747v = new b0(this, 1);
        }
        if (kVar != null) {
            kVar.f6748w = new d(this, 4);
        }
    }

    public final void u() {
        if (!this.J) {
            b bVar = this.E;
            if (bVar != null) {
                ((SurfaceView) bVar.f1653g).getHolder().addCallback(new d0(this));
                return;
            } else {
                i.d("binding");
                throw null;
            }
        }
        try {
            Log.i("LiveStreamActivity", "🚀 Initializing IJKPlayer...");
            IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
            ijkMediaPlayer.setOption(4, "packet-buffering", 0L);
            ijkMediaPlayer.setOption(4, "framedrop", 1L);
            ijkMediaPlayer.setOption(4, "infinitesimal-buffer", 1L);
            ijkMediaPlayer.setOption(4, "start-on-prepared", 1L);
            ijkMediaPlayer.setOption(1, "fflags", "nobuffer");
            ijkMediaPlayer.setOption(1, "rtsp_transport", "tcp");
            a aVar = this.P;
            if (aVar == null) {
                i.d("settings");
                throw null;
            }
            if (aVar.c()) {
                ijkMediaPlayer.setOption(4, "mediacodec", 1L);
                ijkMediaPlayer.setOption(4, "mediacodec-auto-rotate", 1L);
                ijkMediaPlayer.setOption(4, "mediacodec-handle-resolution-change", 1L);
                Log.i("LiveStreamActivity", "🚀 IJK: Hardware acceleration ENABLED");
            } else {
                ijkMediaPlayer.setOption(4, "mediacodec", 0L);
                Log.i("LiveStreamActivity", "🛠️ IJK: Software decoding");
            }
            ijkMediaPlayer.setOption(4, "opensles", 1L);
            ijkMediaPlayer.setOnPreparedListener(new a3.i(this, 9));
            ijkMediaPlayer.setOnErrorListener(new o(3));
            b bVar2 = this.E;
            if (bVar2 == null) {
                i.d("binding");
                throw null;
            }
            ijkMediaPlayer.setDisplay(((SurfaceView) bVar2.f1653g).getHolder());
            this.K = ijkMediaPlayer;
            e eVar = this.L;
            String h = eVar != null ? eVar.h() : "";
            IjkMediaPlayer ijkMediaPlayer2 = this.K;
            if (ijkMediaPlayer2 != null) {
                ijkMediaPlayer2.setDataSource(h.concat("/master.m3u8"));
            }
            IjkMediaPlayer ijkMediaPlayer3 = this.K;
            if (ijkMediaPlayer3 != null) {
                ijkMediaPlayer3.prepareAsync();
            }
        } catch (Exception e9) {
            Log.e("LiveStreamActivity", "💥 Error initializing IJKPlayer: " + e9.getMessage(), e9);
        }
    }

    public final void v() {
        b bVar = this.E;
        if (bVar == null) {
            i.d("binding");
            throw null;
        }
        ((LinearLayout) bVar.f1652f).setVisibility(0);
        b bVar2 = this.E;
        if (bVar2 == null) {
            i.d("binding");
            throw null;
        }
        LinearLayout linearLayout = (LinearLayout) bVar2.f1652f;
        y yVar = this.U;
        linearLayout.removeCallbacks(yVar);
        b bVar3 = this.E;
        if (bVar3 != null) {
            ((LinearLayout) bVar3.f1652f).postDelayed(yVar, l1.k.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        } else {
            i.d("binding");
            throw null;
        }
    }

    public final void w(int i9) {
        Handler handler = this.S;
        handler.removeCallbacksAndMessages(null);
        Application application = getApplication();
        application.getClass();
        handler.post(new e0(this, ((TvgramApplication) application).a(), i9));
    }

    public final void x() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        Log.i("LiveStreamActivity", "🔄 [FULL RESYNC] Tearing down and restarting system...");
        synchronized (this.V) {
            try {
                long j5 = this.G;
                if (j5 != 0) {
                    if (this.I) {
                        RawPlayerJNI.INSTANCE.nativeFlushPull(j5);
                    } else {
                        RawPlayerJNI.INSTANCE.nativeFlush(j5);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        k kVar = this.F;
        if (kVar != null) {
            kVar.g();
        }
        this.F = new k(this);
        t();
        int intExtra = getIntent().getIntExtra("group_call_id", 0);
        long longExtra = getIntent().getLongExtra("chat_id", 0L);
        String stringExtra = getIntent().getStringExtra("invite_link");
        Thread thread = this.Z;
        if (thread != null) {
            thread.interrupt();
        }
        this.X = intExtra;
        this.Y = -1;
        Thread thread2 = new Thread(new h0(this, longExtra, stringExtra, 2));
        thread2.start();
        this.Z = thread2;
    }
}
