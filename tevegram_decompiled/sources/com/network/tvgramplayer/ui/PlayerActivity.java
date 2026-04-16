package com.network.tvgramplayer.ui;

import a5.d;
import android.R;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioManager;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.j;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import androidx.lifecycle.g0;
import androidx.media3.ui.PlayerView;
import b8.i;
import c7.e;
import com.bumptech.glide.b;
import com.bumptech.glide.k;
import com.google.android.material.imageview.ShapeableImageView;
import com.network.tvgramplayer.TvgramApplication;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.data.PlaylistItem;
import com.network.tvgramplayer.player.PlayerManager;
import com.network.tvgramplayer.ui.PlayerActivity;
import d1.h0;
import d1.t0;
import d4.t;
import e7.a;
import g.l;
import h7.k0;
import i7.d3;
import i7.j3;
import i7.l3;
import i7.m3;
import i7.x;
import i7.y2;
import i8.c0;
import i8.d1;
import i8.w;
import java.util.NoSuchElementException;
import k4.h;
import k4.o;
import l7.c;
import l7.g;
import n0.b2;
import n0.c2;
import n0.d2;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class PlayerActivity extends l {
    public static final /* synthetic */ int X = 0;
    public e E;
    public PlayerManager F;
    public a H;
    public k0 I;
    public d J;
    public a0.l K;
    public a0.l L;
    public d1 M;
    public boolean N;
    public Playlist O;
    public d1 Q;
    public a R;
    public g S;
    public final t G = new t(2);
    public int P = -1;
    public final a0.l T = new a0.l(8);
    public final j3 U = new j3(this);
    public final j V = new j(this, 9);
    public final a7.a W = new a7.a(this, 12);

    public static final void s(PlayerActivity playerActivity, h0 h0Var) {
        String str;
        a aVar = playerActivity.H;
        if (aVar == null || (str = aVar.f3154d) == null) {
            str = null;
        }
        if (str == null || str.length() == 0) {
            e eVar = playerActivity.E;
            if (eVar != null) {
                eVar.f1705k.setVisibility(8);
                return;
            } else {
                i.d("binding");
                throw null;
            }
        }
        e eVar2 = playerActivity.E;
        if (eVar2 == null) {
            i.d("binding");
            throw null;
        }
        eVar2.f1705k.setVisibility(0);
        k n4 = b.a(playerActivity).f1735m.c(playerActivity).n(str);
        n4.getClass();
        k kVar = (k) ((k) ((k) n4.r(o.f5577d, new h())).j(R.drawable.ic_menu_gallery)).e(R.drawable.ic_menu_gallery);
        e eVar3 = playerActivity.E;
        if (eVar3 != null) {
            kVar.x(eVar3.f1705k);
        } else {
            i.d("binding");
            throw null;
        }
    }

    public static final void z(Switch r02, String str, boolean z8, String str2, String str3) {
        r02.setText(str + ": " + (z8 ? "HABILITADO ✔️ ".concat(str2) : "DESACTIVADO ⚠️ ".concat(str3)));
        r02.setTextColor(z8 ? -16711936 : Color.parseColor("#FF9800"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
    
        if (r9.P >= (((r0 == null || (r0 = r0.getItems()) == null) ? 0 : r0.size()) - 1)) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A() {
        /*
            r9 = this;
            com.network.tvgramplayer.data.Playlist r0 = r9.O
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L8
            r3 = 1
            goto L9
        L8:
            r3 = 0
        L9:
            c7.e r4 = r9.E
            r5 = 0
            java.lang.String r6 = "binding"
            if (r4 == 0) goto L84
            android.widget.ImageButton r4 = r4.f1700e
            r7 = 8
            if (r3 == 0) goto L29
            int r8 = r9.P
            if (r0 == 0) goto L25
            java.util.List r0 = r0.getItems()
            if (r0 == 0) goto L25
            int r0 = r0.size()
            goto L26
        L25:
            r0 = 0
        L26:
            int r0 = r0 - r1
            if (r8 < r0) goto L33
        L29:
            com.network.tvgramplayer.data.Playlist r0 = r9.O
            if (r0 == 0) goto L35
            boolean r0 = r0.isLoopEnabled()
            if (r0 != r1) goto L35
        L33:
            r0 = 0
            goto L37
        L35:
            r0 = 8
        L37:
            r4.setVisibility(r0)
            c7.e r0 = r9.E
            if (r0 == 0) goto L80
            android.widget.ImageButton r0 = r0.f1701f
            if (r3 == 0) goto L46
            int r4 = r9.P
            if (r4 > 0) goto L50
        L46:
            com.network.tvgramplayer.data.Playlist r4 = r9.O
            if (r4 == 0) goto L52
            boolean r4 = r4.isLoopEnabled()
            if (r4 != r1) goto L52
        L50:
            r1 = 0
            goto L54
        L52:
            r1 = 8
        L54:
            r0.setVisibility(r1)
            c7.e r0 = r9.E
            if (r0 == 0) goto L7c
            android.widget.ImageButton r0 = r0.h
            if (r3 == 0) goto L61
            r1 = 0
            goto L63
        L61:
            r1 = 8
        L63:
            r0.setVisibility(r1)
            c7.e r0 = r9.E
            if (r0 == 0) goto L78
            android.widget.ImageButton r0 = r0.f1699d
            if (r3 == 0) goto L6f
            goto L71
        L6f:
            r2 = 8
        L71:
            r0.setVisibility(r2)
            r9.B()
            return
        L78:
            b8.i.d(r6)
            throw r5
        L7c:
            b8.i.d(r6)
            throw r5
        L80:
            b8.i.d(r6)
            throw r5
        L84:
            b8.i.d(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.network.tvgramplayer.ui.PlayerActivity.A():void");
    }

    public final void B() {
        Playlist playlist = this.O;
        if (playlist == null) {
            return;
        }
        int parseColor = playlist.isShuffleEnabled() ? Color.parseColor("#00E5FF") : -1;
        e eVar = this.E;
        if (eVar == null) {
            i.d("binding");
            throw null;
        }
        eVar.h.setColorFilter(parseColor);
        int parseColor2 = playlist.isLoopEnabled() ? Color.parseColor("#00E5FF") : -1;
        e eVar2 = this.E;
        if (eVar2 != null) {
            eVar2.f1699d.setColorFilter(parseColor2);
        } else {
            i.d("binding");
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C() {
        /*
            r10 = this;
            k7.a r0 = new k7.a
            r0.<init>(r10)
            c7.e r1 = r10.E
            r2 = 0
            java.lang.String r3 = "binding"
            if (r1 == 0) goto L77
            androidx.media3.ui.PlayerView r1 = r1.f1708n
            d1.t0 r1 = r1.getPlayer()
            r4 = 0
            if (r1 == 0) goto L43
            d1.f1 r1 = r1.v()
            if (r1 == 0) goto L43
            b6.g0 r1 = r1.f2422a
            if (r1 == 0) goto L43
            boolean r5 = r1.isEmpty()
            if (r5 == 0) goto L26
            goto L43
        L26:
            int r5 = r1.size()
            r6 = 0
        L2b:
            if (r6 >= r5) goto L43
            java.lang.Object r7 = r1.get(r6)
            int r6 = r6 + 1
            d1.e1 r7 = (d1.e1) r7
            d1.z0 r8 = r7.f2415b
            int r8 = r8.f2618c
            r9 = 2
            if (r8 != r9) goto L2b
            boolean r7 = r7.b()
            if (r7 == 0) goto L2b
            goto L4b
        L43:
            boolean r1 = r0.d()
            if (r1 == 0) goto L4b
            r1 = 1
            goto L4c
        L4b:
            r1 = 0
        L4c:
            c7.e r5 = r10.E
            if (r5 == 0) goto L73
            android.opengl.GLSurfaceView r5 = r5.f1714t
            if (r1 == 0) goto L55
            goto L57
        L55:
            r4 = 8
        L57:
            r5.setVisibility(r4)
            c7.e r1 = r10.E
            if (r1 == 0) goto L6f
            android.widget.ImageButton r1 = r1.f1704j
            boolean r0 = r0.d()
            if (r0 == 0) goto L68
            r0 = -1
            goto L6b
        L68:
            r0 = -7829368(0xffffffffff888888, float:NaN)
        L6b:
            r1.setColorFilter(r0)
            return
        L6f:
            b8.i.d(r3)
            throw r2
        L73:
            b8.i.d(r3)
            throw r2
        L77:
            b8.i.d(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.network.tvgramplayer.ui.PlayerActivity.C():void");
    }

    @Override // g.l, c0.g, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getClass();
        if (keyEvent.getKeyCode() == 4) {
            finish();
            return true;
        }
        y();
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.activity.n, android.app.Activity
    public final void onBackPressed() {
        finish();
    }

    @Override // g.l, androidx.activity.n, c0.g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        b2 d2Var;
        c valueOf;
        g gVar;
        WindowInsetsController insetsController;
        super.onCreate(bundle);
        r7.c cVar = null;
        int i9 = 0;
        View inflate = getLayoutInflater().inflate(2131558434, (ViewGroup) null, false);
        int i10 = 2131361886;
        ImageButton imageButton = (ImageButton) com.bumptech.glide.d.z(inflate, 2131361886);
        if (imageButton != null) {
            i10 = 2131361892;
            ImageButton imageButton2 = (ImageButton) com.bumptech.glide.d.z(inflate, 2131361892);
            if (imageButton2 != null) {
                i10 = 2131361908;
                ImageButton imageButton3 = (ImageButton) com.bumptech.glide.d.z(inflate, 2131361908);
                if (imageButton3 != null) {
                    i10 = 2131361914;
                    ImageButton imageButton4 = (ImageButton) com.bumptech.glide.d.z(inflate, 2131361914);
                    if (imageButton4 != null) {
                        i10 = 2131361916;
                        ImageButton imageButton5 = (ImageButton) com.bumptech.glide.d.z(inflate, 2131361916);
                        if (imageButton5 != null) {
                            i10 = 2131361919;
                            ImageButton imageButton6 = (ImageButton) com.bumptech.glide.d.z(inflate, 2131361919);
                            if (imageButton6 != null) {
                                i10 = 2131361921;
                                ImageButton imageButton7 = (ImageButton) com.bumptech.glide.d.z(inflate, 2131361921);
                                if (imageButton7 != null) {
                                    i10 = 2131361922;
                                    ImageButton imageButton8 = (ImageButton) com.bumptech.glide.d.z(inflate, 2131361922);
                                    if (imageButton8 != null) {
                                        i10 = 2131361925;
                                        ImageButton imageButton9 = (ImageButton) com.bumptech.glide.d.z(inflate, 2131361925);
                                        if (imageButton9 != null) {
                                            i10 = 2131361928;
                                            ImageButton imageButton10 = (ImageButton) com.bumptech.glide.d.z(inflate, 2131361928);
                                            if (imageButton10 != null) {
                                                i10 = 2131362134;
                                                ShapeableImageView shapeableImageView = (ShapeableImageView) com.bumptech.glide.d.z(inflate, 2131362134);
                                                if (shapeableImageView != null) {
                                                    i10 = 2131362171;
                                                    LinearLayout linearLayout = (LinearLayout) com.bumptech.glide.d.z(inflate, 2131362171);
                                                    if (linearLayout != null) {
                                                        i10 = 2131362268;
                                                        LinearLayout linearLayout2 = (LinearLayout) com.bumptech.glide.d.z(inflate, 2131362268);
                                                        if (linearLayout2 != null) {
                                                            i10 = 2131362285;
                                                            PlayerView playerView = (PlayerView) com.bumptech.glide.d.z(inflate, 2131362285);
                                                            if (playerView != null) {
                                                                i10 = 2131362290;
                                                                ProgressBar progressBar = (ProgressBar) com.bumptech.glide.d.z(inflate, 2131362290);
                                                                if (progressBar != null) {
                                                                    i10 = 2131362434;
                                                                    TextView textView = (TextView) com.bumptech.glide.d.z(inflate, 2131362434);
                                                                    if (textView != null) {
                                                                        i10 = 2131362450;
                                                                        TextView textView2 = (TextView) com.bumptech.glide.d.z(inflate, 2131362450);
                                                                        if (textView2 != null) {
                                                                            i10 = 2131362451;
                                                                            if (((TextView) com.bumptech.glide.d.z(inflate, 2131362451)) != null) {
                                                                                i10 = 2131362459;
                                                                                TextView textView3 = (TextView) com.bumptech.glide.d.z(inflate, 2131362459);
                                                                                if (textView3 != null) {
                                                                                    i10 = 2131362460;
                                                                                    TextView textView4 = (TextView) com.bumptech.glide.d.z(inflate, 2131362460);
                                                                                    if (textView4 != null) {
                                                                                        i10 = 2131362523;
                                                                                        GLSurfaceView gLSurfaceView = (GLSurfaceView) com.bumptech.glide.d.z(inflate, 2131362523);
                                                                                        if (gLSurfaceView != null) {
                                                                                            FrameLayout frameLayout = (FrameLayout) inflate;
                                                                                            this.E = new e(frameLayout, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8, imageButton9, imageButton10, shapeableImageView, linearLayout, linearLayout2, playerView, progressBar, textView, textView2, textView3, textView4, gLSurfaceView);
                                                                                            setContentView(frameLayout);
                                                                                            getWindow().addFlags(128);
                                                                                            Window window = getWindow();
                                                                                            x xVar = new x(getWindow().getDecorView());
                                                                                            int i11 = Build.VERSION.SDK_INT;
                                                                                            int i12 = 23;
                                                                                            if (i11 >= 30) {
                                                                                                insetsController = window.getInsetsController();
                                                                                                d2Var = new b2(insetsController, xVar);
                                                                                                d2Var.f7141j = window;
                                                                                            } else {
                                                                                                d2Var = i11 >= 26 ? new d2(window, xVar) : i11 >= 23 ? new c2(window, xVar) : new b2(window, xVar);
                                                                                            }
                                                                                            d2Var.N();
                                                                                            d2Var.y();
                                                                                            Object systemService = getSystemService("audio");
                                                                                            systemService.getClass();
                                                                                            AudioManager audioManager = (AudioManager) systemService;
                                                                                            audioManager.setMode(0);
                                                                                            if (i11 >= 31) {
                                                                                                audioManager.clearCommunicationDevice();
                                                                                            }
                                                                                            int i13 = 3;
                                                                                            setVolumeControlStream(3);
                                                                                            e eVar = this.E;
                                                                                            if (eVar == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            int i14 = 4;
                                                                                            eVar.f1708n.setVisibility(4);
                                                                                            e eVar2 = this.E;
                                                                                            if (eVar2 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            eVar2.f1706l.setVisibility(0);
                                                                                            e eVar3 = this.E;
                                                                                            if (eVar3 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            eVar3.f1706l.setBackgroundColor(-16777216);
                                                                                            PlayerManager playerManager = new PlayerManager(this);
                                                                                            this.F = playerManager;
                                                                                            e eVar4 = this.E;
                                                                                            if (eVar4 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            playerManager.setupPlayer(eVar4.f1708n);
                                                                                            e eVar5 = this.E;
                                                                                            if (eVar5 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            t0 player = eVar5.f1708n.getPlayer();
                                                                                            if (player != null) {
                                                                                                player.u(this.U);
                                                                                            }
                                                                                            Application application = getApplication();
                                                                                            application.getClass();
                                                                                            k0 a9 = ((TvgramApplication) application).a();
                                                                                            this.I = a9;
                                                                                            this.J = new d(a9, 14, this);
                                                                                            this.K = new a0.l((l) this);
                                                                                            this.L = new a0.l((Context) this);
                                                                                            e eVar6 = this.E;
                                                                                            if (eVar6 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            t0 player2 = eVar6.f1708n.getPlayer();
                                                                                            if (player2 != null) {
                                                                                                d dVar = new d(player2, i12, this);
                                                                                                e eVar7 = this.E;
                                                                                                if (eVar7 == null) {
                                                                                                    i.d("binding");
                                                                                                    throw null;
                                                                                                }
                                                                                                eVar7.f1708n.setPlayer(dVar);
                                                                                            }
                                                                                            t(getIntent());
                                                                                            k7.a aVar = new k7.a(this);
                                                                                            this.S = new g(this);
                                                                                            e eVar8 = this.E;
                                                                                            if (eVar8 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            int i15 = 2;
                                                                                            eVar8.f1714t.setEGLContextClientVersion(2);
                                                                                            e eVar9 = this.E;
                                                                                            if (eVar9 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            GLSurfaceView gLSurfaceView2 = eVar9.f1714t;
                                                                                            g gVar2 = this.S;
                                                                                            if (gVar2 == null) {
                                                                                                i.d("visualizerRenderer");
                                                                                                throw null;
                                                                                            }
                                                                                            gLSurfaceView2.setRenderer(gVar2);
                                                                                            e eVar10 = this.E;
                                                                                            if (eVar10 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            int i16 = 1;
                                                                                            eVar10.f1714t.setRenderMode(1);
                                                                                            e eVar11 = this.E;
                                                                                            if (eVar11 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            eVar11.f1714t.setZOrderMediaOverlay(true);
                                                                                            try {
                                                                                                valueOf = c.valueOf(aVar.e());
                                                                                                gVar = this.S;
                                                                                            } catch (Exception unused) {
                                                                                                g gVar3 = this.S;
                                                                                                if (gVar3 == null) {
                                                                                                    i.d("visualizerRenderer");
                                                                                                    throw null;
                                                                                                }
                                                                                                gVar3.f6332u = c.f6284i;
                                                                                                gVar3.f();
                                                                                            }
                                                                                            if (gVar == null) {
                                                                                                i.d("visualizerRenderer");
                                                                                                throw null;
                                                                                            }
                                                                                            valueOf.getClass();
                                                                                            gVar.f6332u = valueOf;
                                                                                            gVar.f();
                                                                                            PlayerManager playerManager2 = this.F;
                                                                                            if (playerManager2 == null) {
                                                                                                i.d("playerManager");
                                                                                                throw null;
                                                                                            }
                                                                                            l7.b visualizerProcessor = playerManager2.getVisualizerProcessor();
                                                                                            if (visualizerProcessor != null) {
                                                                                                visualizerProcessor.f6283g = new d3(this, 0);
                                                                                            }
                                                                                            this.T.f33l = new d3(this, 1);
                                                                                            e eVar12 = this.E;
                                                                                            if (eVar12 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            View findViewById = eVar12.f1708n.findViewById(2131362062);
                                                                                            if (findViewById != null) {
                                                                                                findViewById.setOnClickListener(new y2(this, 9));
                                                                                            }
                                                                                            e eVar13 = this.E;
                                                                                            if (eVar13 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            View findViewById2 = eVar13.f1708n.findViewById(2131362071);
                                                                                            if (findViewById2 != null) {
                                                                                                findViewById2.setOnClickListener(new y2(this, 10));
                                                                                            }
                                                                                            e eVar14 = this.E;
                                                                                            if (eVar14 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            eVar14.f1702g.setOnClickListener(new y2(this, 11));
                                                                                            e eVar15 = this.E;
                                                                                            if (eVar15 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            eVar15.f1703i.setOnClickListener(new y2(this, 12));
                                                                                            e eVar16 = this.E;
                                                                                            if (eVar16 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            eVar16.f1696a.setOnClickListener(new y2(this, 13));
                                                                                            e eVar17 = this.E;
                                                                                            if (eVar17 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            eVar17.f1698c.setOnClickListener(new y2(this, i9));
                                                                                            e eVar18 = this.E;
                                                                                            if (eVar18 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            eVar18.f1697b.setOnClickListener(new y2(this, i16));
                                                                                            e eVar19 = this.E;
                                                                                            if (eVar19 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            eVar19.f1700e.setOnClickListener(new y2(this, i15));
                                                                                            e eVar20 = this.E;
                                                                                            if (eVar20 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            eVar20.f1701f.setOnClickListener(new y2(this, i13));
                                                                                            e eVar21 = this.E;
                                                                                            if (eVar21 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            eVar21.h.setOnClickListener(new y2(this, i14));
                                                                                            e eVar22 = this.E;
                                                                                            if (eVar22 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            eVar22.f1699d.setOnClickListener(new y2(this, 7));
                                                                                            e eVar23 = this.E;
                                                                                            if (eVar23 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            eVar23.f1704j.setOnClickListener(new y2(this, 8));
                                                                                            e eVar24 = this.E;
                                                                                            if (eVar24 == null) {
                                                                                                i.d("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            eVar24.f1704j.setOnLongClickListener(new View.OnLongClickListener() { // from class: i7.g3
                                                                                                @Override // android.view.View.OnLongClickListener
                                                                                                public final boolean onLongClick(View view) {
                                                                                                    int i17 = PlayerActivity.X;
                                                                                                    String[] strArr = {"ALL", "RETRO", "FRACTAL", "SPACE", "ORGANIC"};
                                                                                                    PlayerActivity playerActivity = PlayerActivity.this;
                                                                                                    k7.a aVar2 = new k7.a(playerActivity);
                                                                                                    b8.m mVar = new b8.m();
                                                                                                    int b02 = o7.f.b0(strArr, aVar2.e());
                                                                                                    if (b02 < 0) {
                                                                                                        b02 = 0;
                                                                                                    }
                                                                                                    mVar.f1523i = b02;
                                                                                                    k5.b m9 = new k5.b(playerActivity, 0).m("Grupo de Espectros");
                                                                                                    int i18 = mVar.f1523i;
                                                                                                    a1 a1Var = new a1(mVar, 1);
                                                                                                    g.f fVar = m9.f3568a;
                                                                                                    fVar.f3520p = strArr;
                                                                                                    fVar.f3522r = a1Var;
                                                                                                    fVar.f3527w = i18;
                                                                                                    fVar.f3526v = true;
                                                                                                    m9.l("Aplicar", new x0(strArr, mVar, aVar2, playerActivity, 2));
                                                                                                    m9.j("Cancelar", new z2());
                                                                                                    m9.h();
                                                                                                    return true;
                                                                                                }
                                                                                            });
                                                                                            C();
                                                                                            SharedPreferences sharedPreferences = new k7.a(this).f5628b;
                                                                                            sharedPreferences.getBoolean("playlist_auto_next", true);
                                                                                            sharedPreferences.getBoolean("playlist_use_personal_selection", true);
                                                                                            LifecycleCoroutineScopeImpl a10 = g0.a(this);
                                                                                            p8.d dVar2 = c0.f5250a;
                                                                                            w.j(a10, n8.o.f7529a, new m3(this, cVar, i9), 2);
                                                                                            w.j(g0.a(this), null, new m3(this, cVar, i16), 3);
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        m7.c.o("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    @Override // g.l, android.app.Activity
    public final void onDestroy() {
        e eVar;
        Log.d("PlayerActivity", "♻️ onDestroy: Releasing resources safely");
        getWindow().clearFlags(128);
        try {
            eVar = this.E;
        } catch (Exception e9) {
            Log.w("PlayerActivity", "Non-critical error stopping player: " + e9.getMessage());
        }
        if (eVar == null) {
            i.d("binding");
            throw null;
        }
        t0 player = eVar.f1708n.getPlayer();
        if (player != null) {
            player.stop();
            player.q();
        }
        PlayerManager playerManager = this.F;
        if (playerManager == null) {
            i.d("playerManager");
            throw null;
        }
        playerManager.release();
        super.onDestroy();
    }

    @Override // g.l, androidx.activity.n, android.app.Activity
    public final void onNewIntent(Intent intent) {
        intent.getClass();
        super.onNewIntent(intent);
        setIntent(intent);
        Log.d("PlayerActivity", "♻️ onNewIntent Called. Recycling Activity for new video.");
        x(false);
        e eVar = this.E;
        if (eVar == null) {
            i.d("binding");
            throw null;
        }
        if (eVar.f1708n.getPlayer() == null) {
            PlayerManager playerManager = this.F;
            if (playerManager == null) {
                i.d("playerManager");
                throw null;
            }
            e eVar2 = this.E;
            if (eVar2 == null) {
                i.d("binding");
                throw null;
            }
            playerManager.setupPlayer(eVar2.f1708n);
            e eVar3 = this.E;
            if (eVar3 == null) {
                i.d("binding");
                throw null;
            }
            t0 player = eVar3.f1708n.getPlayer();
            if (player != null) {
                player.u(this.U);
            }
        }
        d1 d1Var = this.M;
        if (d1Var != null) {
            w.c(d1Var);
        }
        e eVar4 = this.E;
        if (eVar4 == null) {
            i.d("binding");
            throw null;
        }
        eVar4.f1708n.setVisibility(4);
        e eVar5 = this.E;
        if (eVar5 == null) {
            i.d("binding");
            throw null;
        }
        eVar5.f1706l.setVisibility(0);
        e eVar6 = this.E;
        if (eVar6 == null) {
            i.d("binding");
            throw null;
        }
        eVar6.f1712r.setText("Cambiando video...");
        t(intent);
    }

    @Override // g.l, android.app.Activity
    public final void onPause() {
        super.onPause();
        x(false);
        if (this.S != null) {
            e eVar = this.E;
            if (eVar != null) {
                eVar.f1714t.onPause();
            } else {
                i.d("binding");
                throw null;
            }
        }
    }

    @Override // g.l, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.S != null) {
            e eVar = this.E;
            if (eVar == null) {
                i.d("binding");
                throw null;
            }
            eVar.f1714t.onResume();
        }
        getWindow().addFlags(128);
    }

    @Override // g.l, android.app.Activity
    public final void onStop() {
        super.onStop();
        x(false);
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

    /* JADX WARN: Removed duplicated region for block: B:39:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(android.content.Intent r14) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.network.tvgramplayer.ui.PlayerActivity.t(android.content.Intent):void");
    }

    public final void u() {
        x(true);
        Playlist playlist = this.O;
        if (playlist == null) {
            return;
        }
        PlaylistItem playlistItem = playlist.getItems().get(this.P);
        long chatId = playlistItem.getChatId();
        long msgId = playlistItem.getMsgId();
        String encode = Uri.encode(playlistItem.getTitle());
        StringBuilder c9 = t.a.c("tg://msg?chat_id=", chatId, "&msg_id=");
        c9.append(msgId);
        c9.append("&title=");
        c9.append(encode);
        String b9 = t.a.b("tvgram://play?url=", Uri.encode(c9.toString()));
        Intent intent = getIntent();
        if (intent != null) {
            intent.setData(Uri.parse(b9));
        }
        Intent intent2 = getIntent();
        if (intent2 != null) {
            intent2.putExtra("CHAT_ID", playlistItem.getChatId());
        }
        Intent intent3 = getIntent();
        if (intent3 != null) {
            intent3.putExtra("MESSAGE_ID", playlistItem.getMsgId());
        }
        Intent intent4 = getIntent();
        if (intent4 != null) {
            intent4.putExtra("FILE_NAME", playlistItem.getTitle());
        }
        e eVar = this.E;
        if (eVar == null) {
            i.d("binding");
            throw null;
        }
        eVar.f1713s.setText(playlistItem.getTitle());
        e eVar2 = this.E;
        if (eVar2 == null) {
            i.d("binding");
            throw null;
        }
        eVar2.f1712r.setText("Siguiente: " + playlistItem.getTitle());
        A();
        d1 d1Var = this.M;
        if (d1Var != null) {
            w.c(d1Var);
        }
        e eVar3 = this.E;
        if (eVar3 == null) {
            i.d("binding");
            throw null;
        }
        eVar3.f1706l.setVisibility(0);
        t(getIntent());
    }

    public final void v() {
        Playlist playlist = this.O;
        if (playlist == null) {
            return;
        }
        if (playlist.isShuffleEnabled()) {
            e8.c e02 = com.bumptech.glide.d.e0(0, playlist.getItems().size());
            c8.a aVar = c8.e.f1727i;
            e02.getClass();
            try {
                this.P = android.support.v4.media.session.b.d0(e02);
                u();
                return;
            } catch (IllegalArgumentException e9) {
                throw new NoSuchElementException(e9.getMessage());
            }
        }
        if (this.P < playlist.getItems().size() - 1) {
            this.P++;
            u();
        } else if (!playlist.isLoopEnabled()) {
            Toast.makeText(this, "Fin de la lista", 0).show();
        } else {
            this.P = 0;
            u();
        }
    }

    public final void w() {
        Playlist playlist = this.O;
        if (playlist == null) {
            return;
        }
        if (playlist.isShuffleEnabled()) {
            e8.c e02 = com.bumptech.glide.d.e0(0, playlist.getItems().size());
            c8.a aVar = c8.e.f1727i;
            e02.getClass();
            try {
                this.P = android.support.v4.media.session.b.d0(e02);
                u();
                return;
            } catch (IllegalArgumentException e9) {
                throw new NoSuchElementException(e9.getMessage());
            }
        }
        int i9 = this.P;
        if (i9 > 0) {
            this.P = i9 - 1;
            u();
        } else if (playlist.isLoopEnabled()) {
            this.P = playlist.getItems().size() - 1;
            u();
        }
    }

    public final void x(boolean z8) {
        Uri uri;
        String str;
        e eVar = this.E;
        if (eVar == null) {
            i.d("binding");
            throw null;
        }
        t0 player = eVar.f1708n.getPlayer();
        if (player != null) {
            if (z8 || !(player.t() == 1 || player.t() == 4)) {
                long currentPosition = player.getCurrentPosition();
                if (z8 || currentPosition > l1.k.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS) {
                    Intent intent = getIntent();
                    if (intent == null || (uri = intent.getData()) == null) {
                        uri = Uri.EMPTY;
                    }
                    uri.getClass();
                    this.G.getClass();
                    com.bumptech.glide.c v8 = t.v(uri);
                    a aVar = v8 instanceof d7.b ? ((d7.b) v8).f2966p : null;
                    Intent intent2 = getIntent();
                    String stringExtra = intent2 != null ? intent2.getStringExtra("EXTRA_CONTEXT_URL") : null;
                    if (stringExtra == null) {
                        str = aVar != null ? aVar.f3151a : null;
                    } else {
                        str = stringExtra;
                    }
                    if (str == null || this.N) {
                        return;
                    }
                    w.j(g0.a(this), c0.f5251b, new l3(this, str, currentPosition, aVar, player, null), 2);
                }
            }
        }
    }

    public final void y() {
        e eVar = this.E;
        if (eVar == null) {
            i.d("binding");
            throw null;
        }
        eVar.f1707m.setVisibility(0);
        e eVar2 = this.E;
        if (eVar2 == null) {
            i.d("binding");
            throw null;
        }
        PlayerView playerView = eVar2.f1708n;
        playerView.f(playerView.e());
        e eVar3 = this.E;
        if (eVar3 == null) {
            i.d("binding");
            throw null;
        }
        LinearLayout linearLayout = eVar3.f1707m;
        a7.a aVar = this.W;
        linearLayout.removeCallbacks(aVar);
        e eVar4 = this.E;
        if (eVar4 != null) {
            eVar4.f1707m.postDelayed(aVar, l1.k.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        } else {
            i.d("binding");
            throw null;
        }
    }
}
