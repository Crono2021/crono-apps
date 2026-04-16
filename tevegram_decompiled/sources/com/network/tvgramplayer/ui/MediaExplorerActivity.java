package com.network.tvgramplayer.ui;

import a5.d;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.c;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.d0;
import androidx.lifecycle.g0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b8.i;
import c7.b;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.network.tvgramplayer.data.HistoryItem;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.telegram.TdClient$ExplorerAction;
import com.network.tvgramplayer.telegram.TdClient$ExplorerItem;
import com.network.tvgramplayer.telegram.TdClient$ExplorerType;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import g.j;
import g.l;
import h7.k0;
import h8.m;
import i7.b1;
import i7.d2;
import i7.e2;
import i7.f2;
import i7.h2;
import i7.j2;
import i7.l0;
import i7.m2;
import i7.n2;
import i7.t2;
import i7.u2;
import i7.x2;
import i8.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import n7.e;
import o7.h;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import t.a;
import tv.danmaku.ijk.media.player.IjkMediaMetadataRetriever;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class MediaExplorerActivity extends l {
    public static final /* synthetic */ int Y = 0;
    public b E;
    public j7.l F;
    public a0.l H;
    public d I;
    public a0.l J;
    public long K;
    public long L;
    public long M;
    public boolean N;
    public boolean P;
    public String R;
    public int S;
    public int T;
    public c W;
    public int X;
    public final e G = new e(new androidx.activity.d(this, 5));
    public boolean O = true;
    public String Q = "Explorador";
    public String U = "";
    public TdApi.SearchMessagesFilter V = new TdApi.SearchMessagesFilterEmpty();

    public static final void s(MediaExplorerActivity mediaExplorerActivity) {
        String stringExtra = mediaExplorerActivity.getIntent().getStringExtra("search_query");
        String stringExtra2 = mediaExplorerActivity.getIntent().getStringExtra("search_filter");
        if (stringExtra == null || stringExtra.length() == 0) {
            return;
        }
        mediaExplorerActivity.U = stringExtra;
        b bVar = mediaExplorerActivity.E;
        if (bVar == null) {
            i.d("binding");
            throw null;
        }
        ((EditText) bVar.f1653g).setText(stringExtra);
        mediaExplorerActivity.C(i.a(stringExtra2, "video") ? new TdApi.SearchMessagesFilterVideo() : i.a(stringExtra2, "document") ? new TdApi.SearchMessagesFilterDocument() : new TdApi.SearchMessagesFilterEmpty(), null);
    }

    public final void A(TdClient$ExplorerItem tdClient$ExplorerItem) {
        if (tdClient$ExplorerItem.getType() == TdClient$ExplorerType.VIDEO || tdClient$ExplorerItem.getType() == TdClient$ExplorerType.AUDIO) {
            a0.l lVar = this.J;
            if (lVar == null) {
                i.d("playlistManager");
                throw null;
            }
            List Q0 = h.Q0((ArrayList) lVar.f32k);
            if (tdClient$ExplorerItem.getMediaGroupId() != 0) {
                j jVar = new j(this);
                jVar.setTitle("¿Añadir Álbum o Track?");
                jVar.b(new String[]{"➡️ Añadir Track Suelto", "💿 Añadir Álbum Completo"}, new b1(this, tdClient$ExplorerItem, Q0, 2));
                jVar.h();
                return;
            }
            a0.l lVar2 = this.J;
            if (lVar2 != null) {
                z(tdClient$ExplorerItem, lVar2, Q0, false);
            } else {
                i.d("playlistManager");
                throw null;
            }
        }
    }

    public final void B() {
        d dVar = this.I;
        if (dVar == null) {
            i.d("searchHistoryManager");
            throw null;
        }
        List K0 = dVar.K0(this.K, this.L);
        boolean isEmpty = K0.isEmpty();
        b bVar = this.E;
        if (isEmpty) {
            if (bVar != null) {
                ((RecyclerView) bVar.f1655j).setVisibility(8);
                return;
            } else {
                i.d("binding");
                throw null;
            }
        }
        if (bVar == null) {
            i.d("binding");
            throw null;
        }
        ((RecyclerView) bVar.f1655j).setVisibility(0);
        b bVar2 = this.E;
        if (bVar2 == null) {
            i.d("binding");
            throw null;
        }
        ((RecyclerView) bVar2.f1655j).setLayoutManager(new LinearLayoutManager(1));
        b bVar3 = this.E;
        if (bVar3 != null) {
            ((RecyclerView) bVar3.f1655j).setAdapter(new t2(this, K0));
        } else {
            i.d("binding");
            throw null;
        }
    }

    public final void C(TdApi.SearchMessagesFilter searchMessagesFilter, View view) {
        View view2;
        this.V = searchMessagesFilter;
        b bVar = this.E;
        if (bVar == null) {
            i.d("binding");
            throw null;
        }
        ((ImageButton) bVar.f1647a).setImageTintList(ColorStateList.valueOf(Color.parseColor("#888888")));
        b bVar2 = this.E;
        if (bVar2 == null) {
            i.d("binding");
            throw null;
        }
        ((ImageButton) bVar2.f1652f).setImageTintList(ColorStateList.valueOf(Color.parseColor("#888888")));
        b bVar3 = this.E;
        if (bVar3 == null) {
            i.d("binding");
            throw null;
        }
        ((ImageButton) bVar3.f1651e).setImageTintList(ColorStateList.valueOf(Color.parseColor("#888888")));
        if (view == null) {
            boolean z8 = searchMessagesFilter instanceof TdApi.SearchMessagesFilterVideo;
            b bVar4 = this.E;
            if (z8) {
                if (bVar4 == null) {
                    i.d("binding");
                    throw null;
                }
                view2 = (ImageButton) bVar4.f1652f;
            } else if (searchMessagesFilter instanceof TdApi.SearchMessagesFilterDocument) {
                if (bVar4 == null) {
                    i.d("binding");
                    throw null;
                }
                view2 = (ImageButton) bVar4.f1651e;
            } else {
                if (bVar4 == null) {
                    i.d("binding");
                    throw null;
                }
                view2 = (ImageButton) bVar4.f1647a;
            }
        } else {
            view2 = view;
        }
        ImageButton imageButton = view2 instanceof ImageButton ? (ImageButton) view2 : null;
        if (imageButton != null) {
            imageButton.setImageTintList(ColorStateList.valueOf(Color.parseColor("#7289DA")));
        }
        if (view != null || this.U.length() > 0) {
            w(true);
        }
    }

    @Override // g.l, androidx.activity.n, c0.g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = getLayoutInflater().inflate(2131558433, (ViewGroup) null, false);
        int i9 = 2131361868;
        if (((AppBarLayout) com.bumptech.glide.d.z(inflate, 2131361868)) != null) {
            i9 = 2131361909;
            ImageButton imageButton = (ImageButton) com.bumptech.glide.d.z(inflate, 2131361909);
            if (imageButton != null) {
                i9 = 2131361910;
                ImageButton imageButton2 = (ImageButton) com.bumptech.glide.d.z(inflate, 2131361910);
                if (imageButton2 != null) {
                    i9 = 2131361911;
                    ImageButton imageButton3 = (ImageButton) com.bumptech.glide.d.z(inflate, 2131361911);
                    if (imageButton3 != null) {
                        i9 = 2131362027;
                        EditText editText = (EditText) com.bumptech.glide.d.z(inflate, 2131362027);
                        if (editText != null) {
                            i9 = 2131362159;
                            if (((LinearLayout) com.bumptech.glide.d.z(inflate, 2131362159)) != null) {
                                i9 = 2131362293;
                                ProgressBar progressBar = (ProgressBar) com.bumptech.glide.d.z(inflate, 2131362293);
                                if (progressBar != null) {
                                    i9 = 2131362313;
                                    RecyclerView recyclerView = (RecyclerView) com.bumptech.glide.d.z(inflate, 2131362313);
                                    if (recyclerView != null) {
                                        i9 = 2131362321;
                                        RecyclerView recyclerView2 = (RecyclerView) com.bumptech.glide.d.z(inflate, 2131362321);
                                        if (recyclerView2 != null) {
                                            i9 = 2131362344;
                                            LinearLayout linearLayout = (LinearLayout) com.bumptech.glide.d.z(inflate, 2131362344);
                                            if (linearLayout != null) {
                                                i9 = 2131362397;
                                                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) com.bumptech.glide.d.z(inflate, 2131362397);
                                                if (swipeRefreshLayout != null) {
                                                    i9 = 2131362462;
                                                    TextView textView = (TextView) com.bumptech.glide.d.z(inflate, 2131362462);
                                                    if (textView != null) {
                                                        i9 = 2131362482;
                                                        MaterialToolbar materialToolbar = (MaterialToolbar) com.bumptech.glide.d.z(inflate, 2131362482);
                                                        if (materialToolbar != null) {
                                                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
                                                            b bVar = new b();
                                                            bVar.f1650d = coordinatorLayout;
                                                            bVar.f1647a = imageButton;
                                                            bVar.f1651e = imageButton2;
                                                            bVar.f1652f = imageButton3;
                                                            bVar.f1653g = editText;
                                                            bVar.h = progressBar;
                                                            bVar.f1654i = recyclerView;
                                                            bVar.f1655j = recyclerView2;
                                                            bVar.f1648b = linearLayout;
                                                            bVar.f1656k = swipeRefreshLayout;
                                                            bVar.f1649c = textView;
                                                            bVar.f1657l = materialToolbar;
                                                            this.E = bVar;
                                                            setContentView(coordinatorLayout);
                                                            this.H = new a0.l((l) this);
                                                            this.I = new d(this);
                                                            this.J = new a0.l((Context) this);
                                                            this.W = this.f307s.c("activity_rq#" + this.f306r.getAndIncrement(), this, new d0(2), new d2(this));
                                                            this.K = getIntent().getLongExtra("chat_id", 0L);
                                                            this.L = getIntent().getLongExtra("thread_id", 0L);
                                                            String stringExtra = getIntent().getStringExtra("chat_title");
                                                            if (stringExtra == null) {
                                                                stringExtra = "Explorador";
                                                            }
                                                            this.Q = stringExtra;
                                                            this.R = getIntent().getStringExtra("parent_title");
                                                            Uri data = getIntent().getData();
                                                            if (data != null && i.a(data.getScheme(), "tvgram") && i.a(data.getHost(), "explore")) {
                                                                String queryParameter = data.getQueryParameter("chat_id");
                                                                Long a02 = queryParameter != null ? h8.l.a0(queryParameter) : null;
                                                                String queryParameter2 = data.getQueryParameter("thread_id");
                                                                Long a03 = queryParameter2 != null ? h8.l.a0(queryParameter2) : null;
                                                                if (a02 != null) {
                                                                    this.K = a02.longValue();
                                                                }
                                                                if (a03 != null) {
                                                                    this.L = a03.longValue();
                                                                }
                                                            }
                                                            long j5 = this.K;
                                                            if (j5 == 0) {
                                                                Toast.makeText(this, "ID de Chat inválido", 0).show();
                                                                finish();
                                                                return;
                                                            }
                                                            long j9 = this.L;
                                                            String str = this.Q;
                                                            StringBuilder c9 = a.c("onCreate: chatId=", j5, ", threadId=");
                                                            c9.append(j9);
                                                            c9.append(", title=");
                                                            c9.append(str);
                                                            Log.d("MediaExplorer", c9.toString());
                                                            String str2 = this.Q;
                                                            b bVar2 = this.E;
                                                            if (bVar2 == null) {
                                                                i.d("binding");
                                                                throw null;
                                                            }
                                                            ((TextView) bVar2.f1649c).setText(str2);
                                                            b bVar3 = this.E;
                                                            if (bVar3 == null) {
                                                                i.d("binding");
                                                                throw null;
                                                            }
                                                            final int i10 = 3;
                                                            ((MaterialToolbar) bVar3.f1657l).setNavigationOnClickListener(new View.OnClickListener(this) { // from class: i7.g2

                                                                /* renamed from: j, reason: collision with root package name */
                                                                public final /* synthetic */ MediaExplorerActivity f4870j;

                                                                {
                                                                    this.f4870j = this;
                                                                }

                                                                @Override // android.view.View.OnClickListener
                                                                public final void onClick(View view) {
                                                                    int i11 = i10;
                                                                    MediaExplorerActivity mediaExplorerActivity = this.f4870j;
                                                                    switch (i11) {
                                                                        case 0:
                                                                            int i12 = MediaExplorerActivity.Y;
                                                                            mediaExplorerActivity.C(new TdApi.SearchMessagesFilterEmpty(), view);
                                                                            break;
                                                                        case 1:
                                                                            int i13 = MediaExplorerActivity.Y;
                                                                            mediaExplorerActivity.C(new TdApi.SearchMessagesFilterVideo(), view);
                                                                            break;
                                                                        case 2:
                                                                            int i14 = MediaExplorerActivity.Y;
                                                                            mediaExplorerActivity.C(new TdApi.SearchMessagesFilterDocument(), view);
                                                                            break;
                                                                        default:
                                                                            int i15 = MediaExplorerActivity.Y;
                                                                            mediaExplorerActivity.finish();
                                                                            break;
                                                                    }
                                                                }
                                                            });
                                                            b bVar4 = this.E;
                                                            if (bVar4 == null) {
                                                                i.d("binding");
                                                                throw null;
                                                            }
                                                            ((MaterialToolbar) bVar4.f1657l).m(2131689472);
                                                            b bVar5 = this.E;
                                                            if (bVar5 == null) {
                                                                i.d("binding");
                                                                throw null;
                                                            }
                                                            ((MaterialToolbar) bVar5.f1657l).post(new j2(this, 3));
                                                            b bVar6 = this.E;
                                                            if (bVar6 == null) {
                                                                i.d("binding");
                                                                throw null;
                                                            }
                                                            ((MaterialToolbar) bVar6.f1657l).setOnMenuItemClickListener(new d2(this));
                                                            this.F = new j7.l(new ArrayList(), u(), new e2(this, 1), new e2(this, 2), new e2(this, 0));
                                                            b bVar7 = this.E;
                                                            if (bVar7 == null) {
                                                                i.d("binding");
                                                                throw null;
                                                            }
                                                            ((RecyclerView) bVar7.f1654i).setLayoutManager(new LinearLayoutManager(1));
                                                            b bVar8 = this.E;
                                                            if (bVar8 == null) {
                                                                i.d("binding");
                                                                throw null;
                                                            }
                                                            RecyclerView recyclerView3 = (RecyclerView) bVar8.f1654i;
                                                            j7.l lVar = this.F;
                                                            if (lVar == null) {
                                                                i.d("adapter");
                                                                throw null;
                                                            }
                                                            recyclerView3.setAdapter(lVar);
                                                            b bVar9 = this.E;
                                                            if (bVar9 == null) {
                                                                i.d("binding");
                                                                throw null;
                                                            }
                                                            ((SwipeRefreshLayout) bVar9.f1656k).setOnRefreshListener(new d2(this));
                                                            b bVar10 = this.E;
                                                            if (bVar10 == null) {
                                                                i.d("binding");
                                                                throw null;
                                                            }
                                                            ((EditText) bVar10.f1653g).setOnEditorActionListener(new l0(this, 1));
                                                            b bVar11 = this.E;
                                                            if (bVar11 == null) {
                                                                i.d("binding");
                                                                throw null;
                                                            }
                                                            ((EditText) bVar11.f1653g).setOnFocusChangeListener(new f2(this, 0));
                                                            b bVar12 = this.E;
                                                            if (bVar12 == null) {
                                                                i.d("binding");
                                                                throw null;
                                                            }
                                                            final int i11 = 0;
                                                            ((ImageButton) bVar12.f1647a).setOnClickListener(new View.OnClickListener(this) { // from class: i7.g2

                                                                /* renamed from: j, reason: collision with root package name */
                                                                public final /* synthetic */ MediaExplorerActivity f4870j;

                                                                {
                                                                    this.f4870j = this;
                                                                }

                                                                @Override // android.view.View.OnClickListener
                                                                public final void onClick(View view) {
                                                                    int i112 = i11;
                                                                    MediaExplorerActivity mediaExplorerActivity = this.f4870j;
                                                                    switch (i112) {
                                                                        case 0:
                                                                            int i12 = MediaExplorerActivity.Y;
                                                                            mediaExplorerActivity.C(new TdApi.SearchMessagesFilterEmpty(), view);
                                                                            break;
                                                                        case 1:
                                                                            int i13 = MediaExplorerActivity.Y;
                                                                            mediaExplorerActivity.C(new TdApi.SearchMessagesFilterVideo(), view);
                                                                            break;
                                                                        case 2:
                                                                            int i14 = MediaExplorerActivity.Y;
                                                                            mediaExplorerActivity.C(new TdApi.SearchMessagesFilterDocument(), view);
                                                                            break;
                                                                        default:
                                                                            int i15 = MediaExplorerActivity.Y;
                                                                            mediaExplorerActivity.finish();
                                                                            break;
                                                                    }
                                                                }
                                                            });
                                                            b bVar13 = this.E;
                                                            if (bVar13 == null) {
                                                                i.d("binding");
                                                                throw null;
                                                            }
                                                            final int i12 = 1;
                                                            ((ImageButton) bVar13.f1652f).setOnClickListener(new View.OnClickListener(this) { // from class: i7.g2

                                                                /* renamed from: j, reason: collision with root package name */
                                                                public final /* synthetic */ MediaExplorerActivity f4870j;

                                                                {
                                                                    this.f4870j = this;
                                                                }

                                                                @Override // android.view.View.OnClickListener
                                                                public final void onClick(View view) {
                                                                    int i112 = i12;
                                                                    MediaExplorerActivity mediaExplorerActivity = this.f4870j;
                                                                    switch (i112) {
                                                                        case 0:
                                                                            int i122 = MediaExplorerActivity.Y;
                                                                            mediaExplorerActivity.C(new TdApi.SearchMessagesFilterEmpty(), view);
                                                                            break;
                                                                        case 1:
                                                                            int i13 = MediaExplorerActivity.Y;
                                                                            mediaExplorerActivity.C(new TdApi.SearchMessagesFilterVideo(), view);
                                                                            break;
                                                                        case 2:
                                                                            int i14 = MediaExplorerActivity.Y;
                                                                            mediaExplorerActivity.C(new TdApi.SearchMessagesFilterDocument(), view);
                                                                            break;
                                                                        default:
                                                                            int i15 = MediaExplorerActivity.Y;
                                                                            mediaExplorerActivity.finish();
                                                                            break;
                                                                    }
                                                                }
                                                            });
                                                            b bVar14 = this.E;
                                                            if (bVar14 == null) {
                                                                i.d("binding");
                                                                throw null;
                                                            }
                                                            final int i13 = 2;
                                                            ((ImageButton) bVar14.f1651e).setOnClickListener(new View.OnClickListener(this) { // from class: i7.g2

                                                                /* renamed from: j, reason: collision with root package name */
                                                                public final /* synthetic */ MediaExplorerActivity f4870j;

                                                                {
                                                                    this.f4870j = this;
                                                                }

                                                                @Override // android.view.View.OnClickListener
                                                                public final void onClick(View view) {
                                                                    int i112 = i13;
                                                                    MediaExplorerActivity mediaExplorerActivity = this.f4870j;
                                                                    switch (i112) {
                                                                        case 0:
                                                                            int i122 = MediaExplorerActivity.Y;
                                                                            mediaExplorerActivity.C(new TdApi.SearchMessagesFilterEmpty(), view);
                                                                            break;
                                                                        case 1:
                                                                            int i132 = MediaExplorerActivity.Y;
                                                                            mediaExplorerActivity.C(new TdApi.SearchMessagesFilterVideo(), view);
                                                                            break;
                                                                        case 2:
                                                                            int i14 = MediaExplorerActivity.Y;
                                                                            mediaExplorerActivity.C(new TdApi.SearchMessagesFilterDocument(), view);
                                                                            break;
                                                                        default:
                                                                            int i15 = MediaExplorerActivity.Y;
                                                                            mediaExplorerActivity.finish();
                                                                            break;
                                                                    }
                                                                }
                                                            });
                                                            b bVar15 = this.E;
                                                            if (bVar15 == null) {
                                                                i.d("binding");
                                                                throw null;
                                                            }
                                                            ((RecyclerView) bVar15.f1654i).h(new i7.d(this, 1));
                                                            w.j(g0.a(this), null, new x2(this, null), 3);
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
        m7.c.o("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i9)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r24v0, types: [android.app.Activity, android.content.Context, com.network.tvgramplayer.ui.MediaExplorerActivity, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v2, types: [android.content.Intent] */
    public final void t(TdClient$ExplorerAction tdClient$ExplorerAction, String str, String str2) {
        ?? r12;
        int i9 = u2.f5148a[tdClient$ExplorerAction.getType().ordinal()];
        if (i9 == 1 || i9 == 2) {
            String str3 = (str2 == null || str2.length() == 0) ? str : str2;
            String stringExtra = getIntent().getStringExtra("chat_title");
            String stringExtra2 = getIntent().getStringExtra("EXTRA_CHAT_TYPE");
            a0.l lVar = this.H;
            if (lVar == null) {
                i.d("historyManager");
                throw null;
            }
            lVar.b(new HistoryItem(this.K, tdClient$ExplorerAction.getUrl(), str3, stringExtra, stringExtra2, false, 0L, 0L, null, null, "play", 992, null));
            Intent intent = new Intent((Context) this, (Class<?>) PlayerActivity.class);
            intent.setData(Uri.parse("tvgram://play?url=" + Uri.encode(tdClient$ExplorerAction.getUrl()) + "&title=" + Uri.encode(str3)));
            startActivity(intent);
            return;
        }
        if (i9 == 3) {
            ?? r02 = str;
            ?? intent2 = new Intent((Context) this, (Class<?>) ImageViewerActivity.class);
            intent2.putExtra(IjkMediaMetadataRetriever.METADATA_KEY_TITLE, r02);
            if (m.f0(tdClient$ExplorerAction.getUrl(), "telegram://", false)) {
                Integer Z = h8.l.Z(m.d0(tdClient$ExplorerAction.getUrl(), "telegram://", ""));
                intent2.putExtra("file_id", Z != null ? Z.intValue() : 0);
            } else {
                intent2.putExtra(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, tdClient$ExplorerAction.getUrl());
            }
            try {
                String stringExtra3 = intent2.getStringExtra("chat_title");
                String stringExtra4 = intent2.getStringExtra("EXTRA_CHAT_TYPE");
                a0.l lVar2 = this.H;
                try {
                    if (lVar2 == null) {
                        i.d("historyManager");
                        throw null;
                    }
                    try {
                        lVar2.b(new HistoryItem(this.K, tdClient$ExplorerAction.getUrl(), r02, stringExtra3, stringExtra4, false, 0L, 0L, null, null, "play", 992, null));
                        startActivity(intent2);
                    } catch (Exception unused) {
                        r02 = this;
                        Toast.makeText((Context) r02, "Error abriendo visor de imagen", 0).show();
                    }
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                r02 = this;
            }
        } else {
            if (i9 != 4) {
                return;
            }
            try {
                if (m.f0(tdClient$ExplorerAction.getUrl(), "telegram://", false) && m.f0(tdClient$ExplorerAction.getLabel(), "Guardar APK", false)) {
                    Integer Z2 = h8.l.Z(m.d0(tdClient$ExplorerAction.getUrl(), "telegram://", ""));
                    int intValue = Z2 != null ? Z2.intValue() : 0;
                    if (intValue == 0) {
                        Toast.makeText((Context) this, "ID de archivo APK inválido", 0).show();
                        return;
                    }
                    this.X = intValue;
                    Pattern compile = Pattern.compile("[^a-zA-Z0-9.\\-_]");
                    compile.getClass();
                    str.getClass();
                    String replaceAll = compile.matcher(str).replaceAll("_");
                    replaceAll.getClass();
                    Intent intent3 = new Intent("android.intent.action.CREATE_DOCUMENT");
                    intent3.addCategory("android.intent.category.OPENABLE");
                    intent3.setType("application/vnd.android.package-archive");
                    intent3.putExtra("android.intent.extra.TITLE", replaceAll);
                    try {
                        c cVar = this.W;
                        if (cVar != null) {
                            cVar.Z(intent3);
                            return;
                        } else {
                            i.d("createDocumentLauncher");
                            throw null;
                        }
                    } catch (ActivityNotFoundException unused4) {
                        Toast.makeText((Context) this, "Explorador no detectado. Guardando en Descargas...", 1).show();
                        Toast.makeText((Context) this, "Descargando desde Telegram...", 0).show();
                        b bVar = this.E;
                        if (bVar == null) {
                            i.d("binding");
                            throw null;
                        }
                        ((ProgressBar) bVar.h).setVisibility(0);
                        u().c(intValue, new h7.c(this, 7, replaceAll));
                        return;
                    }
                }
                String stringExtra5 = getIntent().getStringExtra("chat_title");
                r12 = getIntent().getStringExtra("EXTRA_CHAT_TYPE");
                a0.l lVar3 = this.H;
                try {
                    if (lVar3 == null) {
                        i.d("historyManager");
                        throw null;
                    }
                    try {
                        lVar3.b(new HistoryItem(this.K, tdClient$ExplorerAction.getUrl(), str, stringExtra5, r12, false, 0L, 0L, null, null, "play", 992, null));
                        Intent intent4 = new Intent("android.intent.action.VIEW", Uri.parse(tdClient$ExplorerAction.getUrl()));
                        if (h8.e.g0(tdClient$ExplorerAction.getUrl(), ".torrent", true)) {
                            intent4.setDataAndType(Uri.parse(tdClient$ExplorerAction.getUrl()), "application/x-bittorrent");
                        }
                        startActivity(intent4);
                    } catch (Exception unused5) {
                        r12 = this;
                        Toast.makeText((Context) r12, "No hay app para abrir este link: " + tdClient$ExplorerAction.getUrl(), 0).show();
                    }
                } catch (Exception unused6) {
                }
            } catch (Exception unused7) {
                r12 = this;
                Toast.makeText((Context) r12, "No hay app para abrir este link: " + tdClient$ExplorerAction.getUrl(), 0).show();
            }
        }
    }

    public final k0 u() {
        return (k0) this.G.a();
    }

    public final void v() {
        b bVar = this.E;
        if (bVar != null) {
            ((RecyclerView) bVar.f1655j).setVisibility(8);
        } else {
            i.d("binding");
            throw null;
        }
    }

    public final void w(boolean z8) {
        if (this.N) {
            return;
        }
        if (this.P && this.L == 0 && (this.V instanceof TdApi.SearchMessagesFilterEmpty)) {
            x(z8);
            return;
        }
        this.N = true;
        if (z8) {
            this.M = 0L;
            this.O = true;
            b bVar = this.E;
            if (bVar == null) {
                i.d("binding");
                throw null;
            }
            ((ProgressBar) bVar.h).setVisibility(0);
        }
        final k0 u3 = u();
        final long j5 = this.K;
        final long j9 = this.M;
        final long j10 = this.L;
        String str = this.U;
        TdApi.SearchMessagesFilter searchMessagesFilter = this.V;
        final h2 h2Var = new h2(this, z8, 0);
        u3.getClass();
        str.getClass();
        if (str.length() <= 0 && searchMessagesFilter == null) {
            StringBuilder c9 = a.c("Explorando contenido (Iterativo) para chat ", j5, " since ");
            c9.append(j9);
            c9.append(" (Thread: ");
            c9.append(j10);
            c9.append(")...");
            Log.d("TdClient", c9.toString());
            Client client = u3.f4141l;
            if (client != null) {
                client.send(new TdApi.GetChat(j5), new Client.ResultHandler() { // from class: h7.k
                    @Override // org.drinkless.tdlib.Client.ResultHandler
                    public final void onResult(TdApi.Object object) {
                        if (object instanceof TdApi.Error) {
                            Log.e("TdClient", "⚠️ GetChat failed: " + ((TdApi.Error) object).message);
                        }
                        k0.this.g(j5, j9, 0, j10, new ArrayList(), h2Var);
                    }
                });
                return;
            }
            return;
        }
        Log.d("TdClient", "Buscando contenido recursivo: q='" + str + "', filter=" + (searchMessagesFilter != null ? searchMessagesFilter.getClass().getSimpleName() : null) + ", threadID=" + j10 + ", fromId=" + j9);
        u3.z(j5, j9, 0, j10, str, searchMessagesFilter, new ArrayList(), h2Var);
    }

    public final void x(boolean z8) {
        if (this.N) {
            return;
        }
        this.N = true;
        if (z8) {
            this.S = 0;
            this.T = 0;
            this.O = true;
            b bVar = this.E;
            if (bVar == null) {
                i.d("binding");
                throw null;
            }
            ((ProgressBar) bVar.h).setVisibility(0);
        }
        k0 u3 = u();
        final long j5 = this.K;
        String str = this.U;
        int i9 = this.S;
        int i10 = this.T;
        h2 h2Var = new h2(this, z8, 1);
        u3.getClass();
        str.getClass();
        final h7.m mVar = new h7.m(0, j5, h2Var);
        Client client = u3.f4141l;
        if (client != null) {
            client.send(new TdApi.GetForumTopics(j5, str, i9, 0L, i10, 100), new Client.ResultHandler() { // from class: h7.x
                @Override // org.drinkless.tdlib.Client.ResultHandler
                public final void onResult(TdApi.Object object) {
                    boolean z9 = object instanceof TdApi.ForumTopics;
                    m mVar2 = m.this;
                    if (z9) {
                        mVar2.a(object);
                        return;
                    }
                    Log.e("TdClient", "Error getting forum topics for " + j5 + ": " + object);
                    mVar2.a(null);
                }
            });
        }
    }

    public final void y(TdClient$ExplorerItem tdClient$ExplorerItem, a0.l lVar, String str, boolean z8) {
        m2 m2Var = new m2(lVar, str, z8, tdClient$ExplorerItem, this);
        u().w(a.b("#tvgram_sync_", str), 1, new n2(this, m2Var, str));
    }

    public final void z(final TdClient$ExplorerItem tdClient$ExplorerItem, final a0.l lVar, final List list, final boolean z8) {
        j jVar = new j(this);
        jVar.setTitle("Seleccionar Lista");
        ArrayList arrayList = new ArrayList(o7.j.E0(list));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Playlist playlist = (Playlist) it.next();
            arrayList.add("🎵 " + playlist.getName() + " (" + playlist.getItems().size() + " tracks)");
        }
        final ArrayList arrayList2 = new ArrayList(arrayList);
        arrayList2.add("📝 Crear Nueva Lista...");
        jVar.b((CharSequence[]) arrayList2.toArray(new String[0]), new DialogInterface.OnClickListener() { // from class: i7.k2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i9) {
                int i10 = MediaExplorerActivity.Y;
                int size = arrayList2.size() - 1;
                final MediaExplorerActivity mediaExplorerActivity = this;
                final TdClient$ExplorerItem tdClient$ExplorerItem2 = tdClient$ExplorerItem;
                final a0.l lVar2 = lVar;
                final boolean z9 = z8;
                if (i9 != size) {
                    mediaExplorerActivity.y(tdClient$ExplorerItem2, lVar2, ((Playlist) list.get(i9)).getId(), z9);
                    return;
                }
                final EditText editText = new EditText(mediaExplorerActivity);
                editText.setHint("Ej: Canciones de Verano");
                new g.j(mediaExplorerActivity).setTitle("Nueva Lista").setView(editText).g("Crear", new DialogInterface.OnClickListener() { // from class: i7.l2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface2, int i11) {
                        int i12 = MediaExplorerActivity.Y;
                        String obj = h8.e.u0(editText.getText().toString()).toString();
                        if (obj.length() > 0) {
                            a0.l lVar3 = lVar2;
                            mediaExplorerActivity.y(tdClient$ExplorerItem2, lVar3, lVar3.f(obj).getId(), z9);
                        }
                    }
                }).d("Cancelar", null).h();
            }
        });
        jVar.h();
    }
}
