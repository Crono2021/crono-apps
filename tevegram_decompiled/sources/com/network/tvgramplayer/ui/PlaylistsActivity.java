package com.network.tvgramplayer.ui;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b7.a;
import b8.i;
import c7.c;
import com.bumptech.glide.d;
import com.google.android.material.chip.Chip;
import com.network.tvgramplayer.TvgramApplication;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.data.PlaylistItem;
import com.network.tvgramplayer.ui.PlayerActivity;
import com.network.tvgramplayer.ui.PlaylistsActivity;
import g.j;
import g.l;
import h7.k0;
import h8.e;
import h8.m;
import i7.q3;
import i7.r;
import i7.r3;
import i7.u3;
import i7.y3;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import o7.h;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class PlaylistsActivity extends l {
    public static final /* synthetic */ int K = 0;
    public c E;
    public a0.l F;
    public i7.l G;
    public r H;
    public Playlist I;
    public boolean J;

    @Override // androidx.activity.n, android.app.Activity
    public final void onBackPressed() {
        if (this.I != null) {
            t();
        } else {
            super.onBackPressed();
        }
    }

    @Override // g.l, androidx.activity.n, c0.g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = getLayoutInflater().inflate(2131558435, (ViewGroup) null, false);
        int i9 = 2131361895;
        ImageButton imageButton = (ImageButton) d.z(inflate, 2131361895);
        if (imageButton != null) {
            i9 = 2131361953;
            Chip chip = (Chip) d.z(inflate, 2131361953);
            if (chip != null) {
                i9 = 2131361954;
                Chip chip2 = (Chip) d.z(inflate, 2131361954);
                if (chip2 != null) {
                    i9 = 2131361955;
                    Chip chip3 = (Chip) d.z(inflate, 2131361955);
                    if (chip3 != null) {
                        i9 = 2131361956;
                        Chip chip4 = (Chip) d.z(inflate, 2131361956);
                        if (chip4 != null) {
                            i9 = 2131361957;
                            Chip chip5 = (Chip) d.z(inflate, 2131361957);
                            if (chip5 != null) {
                                i9 = 2131361959;
                                Chip chip6 = (Chip) d.z(inflate, 2131361959);
                                if (chip6 != null) {
                                    i9 = 2131361960;
                                    Chip chip7 = (Chip) d.z(inflate, 2131361960);
                                    if (chip7 != null) {
                                        i9 = 2131361961;
                                        Chip chip8 = (Chip) d.z(inflate, 2131361961);
                                        if (chip8 != null) {
                                            i9 = 2131362157;
                                            LinearLayout linearLayout = (LinearLayout) d.z(inflate, 2131362157);
                                            if (linearLayout != null) {
                                                i9 = 2131362291;
                                                ProgressBar progressBar = (ProgressBar) d.z(inflate, 2131362291);
                                                if (progressBar != null) {
                                                    i9 = 2131362319;
                                                    RecyclerView recyclerView = (RecyclerView) d.z(inflate, 2131362319);
                                                    if (recyclerView != null) {
                                                        i9 = 2131362505;
                                                        TextView textView = (TextView) d.z(inflate, 2131362505);
                                                        if (textView != null) {
                                                            i9 = 2131362507;
                                                            TextView textView2 = (TextView) d.z(inflate, 2131362507);
                                                            if (textView2 != null) {
                                                                ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
                                                                this.E = new c(constraintLayout, imageButton, chip, chip2, chip3, chip4, chip5, chip6, chip7, chip8, linearLayout, progressBar, recyclerView, textView, textView2);
                                                                setContentView(constraintLayout);
                                                                this.F = new a0.l((Context) this);
                                                                this.G = new i7.l(new q3(this, 0), new q3(this, 1), new q3(this, 2));
                                                                this.H = new r(new q3(this, 3), new q3(this, 4), new q3(this, 5), new q3(this, 6));
                                                                c cVar = this.E;
                                                                if (cVar == null) {
                                                                    i.d("binding");
                                                                    throw null;
                                                                }
                                                                ((RecyclerView) cVar.f1669m).setLayoutManager(new LinearLayoutManager(1));
                                                                c cVar2 = this.E;
                                                                if (cVar2 == null) {
                                                                    i.d("binding");
                                                                    throw null;
                                                                }
                                                                ((Chip) cVar2.f1667k).setOnCheckedChangeListener(new r3(this, 0));
                                                                c cVar3 = this.E;
                                                                if (cVar3 == null) {
                                                                    i.d("binding");
                                                                    throw null;
                                                                }
                                                                ((Chip) cVar3.f1665i).setOnCheckedChangeListener(new r3(this, 1));
                                                                c cVar4 = this.E;
                                                                if (cVar4 == null) {
                                                                    i.d("binding");
                                                                    throw null;
                                                                }
                                                                ((Chip) cVar4.f1661d).setOnCheckedChangeListener(new r3(this, 2));
                                                                c cVar5 = this.E;
                                                                if (cVar5 == null) {
                                                                    i.d("binding");
                                                                    throw null;
                                                                }
                                                                final int i10 = 1;
                                                                ((Chip) cVar5.f1664g).setOnClickListener(new View.OnClickListener(this) { // from class: i7.p3

                                                                    /* renamed from: j, reason: collision with root package name */
                                                                    public final /* synthetic */ PlaylistsActivity f5031j;

                                                                    {
                                                                        this.f5031j = this;
                                                                    }

                                                                    /* JADX WARN: Removed duplicated region for block: B:91:0x032d  */
                                                                    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
                                                                    @Override // android.view.View.OnClickListener
                                                                    /*
                                                                        Code decompiled incorrectly, please refer to instructions dump.
                                                                        To view partially-correct add '--show-bad-code' argument
                                                                    */
                                                                    public final void onClick(android.view.View r27) {
                                                                        /*
                                                                            Method dump skipped, instructions count: 896
                                                                            To view this dump add '--comments-level debug' option
                                                                        */
                                                                        throw new UnsupportedOperationException("Method not decompiled: i7.p3.onClick(android.view.View):void");
                                                                    }
                                                                });
                                                                c cVar6 = this.E;
                                                                if (cVar6 == null) {
                                                                    i.d("binding");
                                                                    throw null;
                                                                }
                                                                final int i11 = 2;
                                                                ((Chip) cVar6.f1663f).setOnClickListener(new View.OnClickListener(this) { // from class: i7.p3

                                                                    /* renamed from: j, reason: collision with root package name */
                                                                    public final /* synthetic */ PlaylistsActivity f5031j;

                                                                    {
                                                                        this.f5031j = this;
                                                                    }

                                                                    @Override // android.view.View.OnClickListener
                                                                    public final void onClick(View view) {
                                                                        /*
                                                                            Method dump skipped, instructions count: 896
                                                                            To view this dump add '--comments-level debug' option
                                                                        */
                                                                        throw new UnsupportedOperationException("Method not decompiled: i7.p3.onClick(android.view.View):void");
                                                                    }
                                                                });
                                                                c cVar7 = this.E;
                                                                if (cVar7 == null) {
                                                                    i.d("binding");
                                                                    throw null;
                                                                }
                                                                final int i12 = 3;
                                                                ((Chip) cVar7.f1666j).setOnClickListener(new View.OnClickListener(this) { // from class: i7.p3

                                                                    /* renamed from: j, reason: collision with root package name */
                                                                    public final /* synthetic */ PlaylistsActivity f5031j;

                                                                    {
                                                                        this.f5031j = this;
                                                                    }

                                                                    @Override // android.view.View.OnClickListener
                                                                    public final void onClick(View view) {
                                                                        /*
                                                                            Method dump skipped, instructions count: 896
                                                                            To view this dump add '--comments-level debug' option
                                                                        */
                                                                        throw new UnsupportedOperationException("Method not decompiled: i7.p3.onClick(android.view.View):void");
                                                                    }
                                                                });
                                                                c cVar8 = this.E;
                                                                if (cVar8 == null) {
                                                                    i.d("binding");
                                                                    throw null;
                                                                }
                                                                final int i13 = 4;
                                                                ((Chip) cVar8.f1662e).setOnClickListener(new View.OnClickListener(this) { // from class: i7.p3

                                                                    /* renamed from: j, reason: collision with root package name */
                                                                    public final /* synthetic */ PlaylistsActivity f5031j;

                                                                    {
                                                                        this.f5031j = this;
                                                                    }

                                                                    @Override // android.view.View.OnClickListener
                                                                    public final void onClick(View view) {
                                                                        /*
                                                                            Method dump skipped, instructions count: 896
                                                                            To view this dump add '--comments-level debug' option
                                                                        */
                                                                        throw new UnsupportedOperationException("Method not decompiled: i7.p3.onClick(android.view.View):void");
                                                                    }
                                                                });
                                                                c cVar9 = this.E;
                                                                if (cVar9 == null) {
                                                                    i.d("binding");
                                                                    throw null;
                                                                }
                                                                final int i14 = 5;
                                                                ((Chip) cVar9.h).setOnClickListener(new View.OnClickListener(this) { // from class: i7.p3

                                                                    /* renamed from: j, reason: collision with root package name */
                                                                    public final /* synthetic */ PlaylistsActivity f5031j;

                                                                    {
                                                                        this.f5031j = this;
                                                                    }

                                                                    @Override // android.view.View.OnClickListener
                                                                    public final void onClick(View view) {
                                                                        /*
                                                                            Method dump skipped, instructions count: 896
                                                                            To view this dump add '--comments-level debug' option
                                                                        */
                                                                        throw new UnsupportedOperationException("Method not decompiled: i7.p3.onClick(android.view.View):void");
                                                                    }
                                                                });
                                                                t();
                                                                c cVar10 = this.E;
                                                                if (cVar10 == null) {
                                                                    i.d("binding");
                                                                    throw null;
                                                                }
                                                                final int i15 = 0;
                                                                ((ImageButton) cVar10.f1660c).setOnClickListener(new View.OnClickListener(this) { // from class: i7.p3

                                                                    /* renamed from: j, reason: collision with root package name */
                                                                    public final /* synthetic */ PlaylistsActivity f5031j;

                                                                    {
                                                                        this.f5031j = this;
                                                                    }

                                                                    @Override // android.view.View.OnClickListener
                                                                    public final void onClick(View view) {
                                                                        /*
                                                                            Method dump skipped, instructions count: 896
                                                                            To view this dump add '--comments-level debug' option
                                                                        */
                                                                        throw new UnsupportedOperationException("Method not decompiled: i7.p3.onClick(android.view.View):void");
                                                                    }
                                                                });
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
        m7.c.o("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i9)));
    }

    public final void s() {
        if (this.J) {
            return;
        }
        w(true);
        Application application = getApplication();
        application.getClass();
        k0 a9 = ((TvgramApplication) application).a();
        Settings.Secure.getString(getContentResolver(), "android_id");
        Log.i("PlaylistsActivity", "☁️ Iniciando escaneo de actualizaciones en la nube...");
        a9.w("#tvgram_sync", 15, new h7.c(this, a9));
    }

    public final void t() {
        this.I = null;
        c cVar = this.E;
        if (cVar == null) {
            i.d("binding");
            throw null;
        }
        cVar.f1670n.setText("Mis Listas");
        c cVar2 = this.E;
        if (cVar2 == null) {
            i.d("binding");
            throw null;
        }
        cVar2.f1659b.setText("Gestiona tus colecciones favoritas y crea listas personalizadas");
        c cVar3 = this.E;
        if (cVar3 == null) {
            i.d("binding");
            throw null;
        }
        cVar3.f1658a.setVisibility(8);
        a0.l lVar = this.F;
        if (lVar == null) {
            i.d("playlistManager");
            throw null;
        }
        List Q0 = h.Q0((ArrayList) lVar.f32k);
        Log.d("PlaylistsActivity", "🔄 Refrescando vista principal con " + Q0.size() + " listas.");
        i7.l lVar2 = this.G;
        if (lVar2 == null) {
            i.d("playlistsAdapter");
            throw null;
        }
        lVar2.f4949e = Q0;
        c cVar4 = this.E;
        if (cVar4 == null) {
            i.d("binding");
            throw null;
        }
        RecyclerView recyclerView = (RecyclerView) cVar4.f1669m;
        if (lVar2 == null) {
            i.d("playlistsAdapter");
            throw null;
        }
        recyclerView.setAdapter(lVar2);
        i7.l lVar3 = this.G;
        if (lVar3 == null) {
            i.d("playlistsAdapter");
            throw null;
        }
        lVar3.c();
        if (this.J) {
            return;
        }
        s();
    }

    public final void u(PlaylistItem playlistItem, int i9) {
        String id;
        Playlist playlist;
        List<PlaylistItem> items;
        int indexOf;
        int i10;
        Object obj;
        Playlist playlist2 = this.I;
        if (playlist2 == null || (id = playlist2.getId()) == null || (playlist = this.I) == null || (items = playlist.getItems()) == null || (indexOf = items.indexOf(playlistItem)) == -1 || (i10 = i9 + indexOf) < 0 || i10 >= items.size()) {
            return;
        }
        a0.l lVar = this.F;
        if (lVar == null) {
            i.d("playlistManager");
            throw null;
        }
        synchronized (lVar) {
            try {
                ArrayList arrayList = (ArrayList) lVar.f32k;
                int size = arrayList.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        obj = null;
                        break;
                    }
                    obj = arrayList.get(i11);
                    i11++;
                    if (i.a(((Playlist) obj).getId(), id)) {
                        break;
                    }
                }
                Playlist playlist3 = (Playlist) obj;
                if (playlist3 == null || indexOf < 0 || indexOf >= playlist3.getItems().size() || i10 < 0 || i10 >= playlist3.getItems().size()) {
                    return;
                }
                playlist3.getItems().add(i10, playlist3.getItems().remove(indexOf));
                lVar.w();
                a0.l lVar2 = this.F;
                if (lVar2 == null) {
                    i.d("playlistManager");
                    throw null;
                }
                Playlist k3 = lVar2.k(id);
                if (k3 != null) {
                    this.I = k3;
                    r rVar = this.H;
                    if (rVar == null) {
                        i.d("tracksAdapter");
                        throw null;
                    }
                    List<PlaylistItem> items2 = k3.getItems();
                    items2.getClass();
                    rVar.f5058e = items2;
                    r rVar2 = this.H;
                    if (rVar2 != null) {
                        rVar2.c();
                    } else {
                        i.d("tracksAdapter");
                        throw null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void v(Playlist playlist) {
        if (playlist.getItems().isEmpty()) {
            Toast.makeText(this, "La lista está vacía", 0).show();
            return;
        }
        Application application = getApplication();
        application.getClass();
        String str = ((TvgramApplication) application).a().f4132b;
        if (str.length() == 0) {
            str = "http://127.0.0.1:45302";
        }
        StringBuilder sb = new StringBuilder("#EXTM3U\n");
        int i9 = 1;
        for (PlaylistItem playlistItem : playlist.getItems()) {
            sb.append("#EXTINF:-1, " + i9 + " - " + e.u0(m.d0(playlistItem.getTitle(), "\n", " ")).toString() + "\n");
            sb.append(str + "/resolve?chat_id=" + playlistItem.getChatId() + "&msg_id=" + playlistItem.getMsgId() + "\n");
            i9++;
        }
        File cacheDir = getCacheDir();
        String lowerCase = m.d0(playlist.getName(), " ", "_").toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        File file = new File(cacheDir, "tvgram_" + lowerCase + ".m3u");
        com.bumptech.glide.c.Z(file, sb.toString());
        Uri c9 = FileProvider.c(this, getPackageName() + ".provider", file);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(c9, "audio/x-mpegurl");
        intent.addFlags(1);
        try {
            startActivity(intent);
        } catch (Exception unused) {
            Toast.makeText(this, "Instala VLC o un reproductor M3U", 1).show();
        }
    }

    public final void w(boolean z8) {
        this.J = z8;
        runOnUiThread(new u3(this, z8, 0));
    }

    public final void x(final Playlist playlist, final int i9) {
        new j(this).setTitle("¿Cómo quieres reproducir '" + playlist.getName() + "'?").b(new String[]{"Reproductor Externo (VLC/Kodi)", "Reproductor Interno (TVgram)"}, new DialogInterface.OnClickListener() { // from class: i7.t3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                int i11 = PlaylistsActivity.K;
                PlaylistsActivity playlistsActivity = PlaylistsActivity.this;
                Playlist playlist2 = playlist;
                if (i10 == 0) {
                    playlistsActivity.v(playlist2);
                    return;
                }
                if (i10 == 1 && !playlist2.getItems().isEmpty()) {
                    List<PlaylistItem> items = playlist2.getItems();
                    int i12 = i9;
                    PlaylistItem playlistItem = items.get(i12);
                    Intent intent = new Intent(playlistsActivity, (Class<?>) PlayerActivity.class);
                    long chatId = playlistItem.getChatId();
                    long msgId = playlistItem.getMsgId();
                    String encode = Uri.encode(playlistItem.getTitle());
                    StringBuilder c9 = t.a.c("tg://msg?chat_id=", chatId, "&msg_id=");
                    c9.append(msgId);
                    c9.append("&title=");
                    c9.append(encode);
                    intent.setData(Uri.parse("tvgram://play?url=" + Uri.encode(c9.toString())));
                    intent.putExtra("EXTRA_PLAYLIST_ID", playlist2.getId());
                    intent.putExtra("EXTRA_START_INDEX", i12);
                    intent.putExtra("CHAT_ID", playlistItem.getChatId());
                    intent.putExtra("MESSAGE_ID", playlistItem.getMsgId());
                    intent.putExtra("FILE_NAME", playlistItem.getTitle());
                    playlistsActivity.startActivity(intent);
                }
            }
        }).d("Cancelar", null).h();
    }

    public final void y(a aVar) {
        new j(this).setTitle("Actualización detectada ☁️").c("Existe una versión más reciente de '" + aVar.f1481d.getName() + "' en la nube. ¿Deseas actualizar tu copia local?").g("Actualizar", new y3(this, aVar, 0)).d("Mantener Local", null).h();
    }
}
