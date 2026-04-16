package com.network.tvgramplayer.ui;

import a3.i;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.c;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.d0;
import androidx.fragment.app.g;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import androidx.lifecycle.g0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c7.d;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.network.tvgramplayer.TvgramApplication;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.data.PlaylistItem;
import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.util.SubscriptionItem;
import g.f;
import g.l;
import h7.i0;
import h7.k0;
import h8.m;
import i7.b2;
import i7.b4;
import i7.h1;
import i7.k1;
import i7.l0;
import i7.m0;
import i7.n0;
import i7.o1;
import i7.p1;
import i7.r;
import i7.s0;
import i7.w;
import i7.w0;
import i7.x0;
import i8.c0;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k5.b;
import k7.a;
import n7.e;
import o3.k;
import o3.o;
import o7.h;
import o7.p;
import o7.t;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class MainActivity extends l {
    public static final /* synthetic */ int X = 0;
    public d E;
    public a0.l G;
    public r H;
    public g I;
    public a0.l J;
    public a K;
    public b4 L;
    public a5.d M;
    public b4 N;
    public a0.l O;
    public w P;
    public boolean T;
    public boolean U;
    public final c W;
    public final m0 F = new m0(this, 0);
    public List Q = p.f8013i;
    public final StringBuilder R = new StringBuilder();
    public final Handler S = new Handler(Looper.getMainLooper());
    public final e V = new e(new n0(this, 0));

    public MainActivity() {
        d0 d0Var = new d0(1);
        i iVar = new i(this, 10);
        this.W = this.f307s.c("activity_rq#" + this.f306r.getAndIncrement(), this, d0Var, iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Set] */
    public static final void D(MainActivity mainActivity, a aVar) {
        LinkedHashSet linkedHashSet = a.f5626c;
        SharedPreferences sharedPreferences = aVar.f5628b;
        Set<String> stringSet = sharedPreferences.getStringSet("enabled_uri_schemes", linkedHashSet);
        if (stringSet == null) {
            stringSet = linkedHashSet;
        }
        linkedHashSet.getClass();
        stringSet.getClass();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(t.b0(linkedHashSet.size() + stringSet.size()));
        linkedHashSet2.addAll(linkedHashSet);
        linkedHashSet2.addAll(stringSet);
        String[] strArr = (String[]) h.N0(linkedHashSet2).toArray(new String[0]);
        ?? stringSet2 = sharedPreferences.getStringSet("enabled_uri_schemes", linkedHashSet);
        if (stringSet2 != 0) {
            linkedHashSet = stringSet2;
        }
        int length = strArr.length;
        final boolean[] zArr = new boolean[length];
        for (int i9 = 0; i9 < length; i9++) {
            zArr[i9] = linkedHashSet.contains(strArr[i9]);
        }
        b m9 = new b(mainActivity, 0).m("Gestión de Protocolos (Schemes)");
        DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener = new DialogInterface.OnMultiChoiceClickListener() { // from class: i7.v0
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i10, boolean z8) {
                int i11 = MainActivity.X;
                zArr[i10] = z8;
            }
        };
        f fVar = m9.f3568a;
        fVar.f3520p = strArr;
        fVar.f3528x = onMultiChoiceClickListener;
        fVar.f3524t = zArr;
        fVar.f3525u = true;
        m9.k("Añadir", new w0(mainActivity, aVar));
        m9.l("Aplicar", new x0(strArr, zArr, aVar, mainActivity, 0));
        m9.j("Cerrar", null);
        m9.h();
    }

    public final void A() {
        a5.d dVar = this.M;
        if (dVar == null) {
            b8.i.d("searchHistoryManager");
            throw null;
        }
        List I0 = dVar.I0();
        boolean isEmpty = I0.isEmpty();
        d dVar2 = this.E;
        if (isEmpty) {
            if (dVar2 == null) {
                b8.i.d("binding");
                throw null;
            }
            dVar2.f1687r.setVisibility(8);
            d dVar3 = this.E;
            if (dVar3 != null) {
                dVar3.f1691v.setVisibility(8);
                return;
            } else {
                b8.i.d("binding");
                throw null;
            }
        }
        if (dVar2 == null) {
            b8.i.d("binding");
            throw null;
        }
        dVar2.f1687r.setVisibility(0);
        d dVar4 = this.E;
        if (dVar4 == null) {
            b8.i.d("binding");
            throw null;
        }
        dVar4.f1691v.setVisibility(0);
        b4 b4Var = this.N;
        if (b4Var == null) {
            b8.i.d("quickSearchAdapter");
            throw null;
        }
        b4Var.f4794e = I0;
        b4Var.c();
    }

    public final void B(String str, String str2, String str3, boolean z8, String str4) {
        if (this.U) {
            s("> Already processing a link, ignoring...");
            return;
        }
        this.U = true;
        Application application = getApplication();
        application.getClass();
        k0 a9 = ((TvgramApplication) application).a();
        String lowerCase = str.toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        if (m.f0(lowerCase, "http", false) || m.f0(lowerCase, "tg:", false) || m.f0(lowerCase, "telegram:", false) || m.f0(lowerCase, "tvgram:", false) || !(h8.e.g0(lowerCase, "://", false) || m.f0(lowerCase, "magnet:", false))) {
            i8.w.j(g0.a(this), null, new b2(this, a9, str3, str, str4, str2, z8, null), 3);
            return;
        }
        s("> Esquema externo detectado: " + h8.e.s0(str, ":") + ". Lanzando visor externo...");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            startActivity(intent);
        } catch (Exception e9) {
            Log.e("MainActivity", "Error lanzando esquema externo", e9);
            s("> Error: No hay aplicación para manejar este enlace.");
            runOnUiThread(new s0(this, 1));
        }
        this.U = false;
    }

    public final void E() {
        List list = this.Q;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            i0 i0Var = (i0) obj;
            g gVar = this.I;
            if (gVar == null) {
                b8.i.d("liveFilterManager");
                throw null;
            }
            if (!((LinkedHashSet) gVar.f730l).contains(String.valueOf(i0Var.f4113a))) {
                arrayList.add(obj);
            }
        }
        boolean isEmpty = this.Q.isEmpty();
        d dVar = this.E;
        if (isEmpty) {
            if (dVar == null) {
                b8.i.d("binding");
                throw null;
            }
            dVar.f1684o.setVisibility(8);
            d dVar2 = this.E;
            if (dVar2 != null) {
                dVar2.f1689t.setVisibility(8);
                return;
            } else {
                b8.i.d("binding");
                throw null;
            }
        }
        if (dVar == null) {
            b8.i.d("binding");
            throw null;
        }
        dVar.f1684o.setVisibility(0);
        boolean isEmpty2 = arrayList.isEmpty();
        d dVar3 = this.E;
        if (isEmpty2) {
            if (dVar3 == null) {
                b8.i.d("binding");
                throw null;
            }
            dVar3.f1689t.setVisibility(8);
            d dVar4 = this.E;
            if (dVar4 == null) {
                b8.i.d("binding");
                throw null;
            }
            if (dVar4.f1689t.getAdapter() != null) {
                d dVar5 = this.E;
                if (dVar5 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                o3.g0 adapter = dVar5.f1689t.getAdapter();
                adapter.getClass();
                i7.g0 g0Var = (i7.g0) adapter;
                p pVar = p.f8013i;
                k c9 = o.c(new i7.p(g0Var, pVar));
                g0Var.f4865d = pVar;
                c9.a(g0Var);
                return;
            }
            return;
        }
        if (dVar3 == null) {
            b8.i.d("binding");
            throw null;
        }
        dVar3.f1689t.setVisibility(0);
        d dVar6 = this.E;
        if (dVar6 == null) {
            b8.i.d("binding");
            throw null;
        }
        if (dVar6.f1689t.getAdapter() != null) {
            d dVar7 = this.E;
            if (dVar7 == null) {
                b8.i.d("binding");
                throw null;
            }
            o3.g0 adapter2 = dVar7.f1689t.getAdapter();
            adapter2.getClass();
            i7.g0 g0Var2 = (i7.g0) adapter2;
            k c10 = o.c(new i7.p(g0Var2, arrayList));
            g0Var2.f4865d = arrayList;
            c10.a(g0Var2);
            return;
        }
        i7.g0 g0Var3 = new i7.g0(arrayList, new m0(this, 10));
        d dVar8 = this.E;
        if (dVar8 == null) {
            b8.i.d("binding");
            throw null;
        }
        dVar8.f1689t.setLayoutManager(new LinearLayoutManager(0));
        d dVar9 = this.E;
        if (dVar9 == null) {
            b8.i.d("binding");
            throw null;
        }
        dVar9.f1689t.setAdapter(g0Var3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r41v0, types: [android.app.Activity, android.content.Context, androidx.lifecycle.s, com.network.tvgramplayer.ui.MainActivity, g.l] */
    /* JADX WARN: Type inference failed for: r8v19, types: [java.util.List] */
    @Override // g.l, androidx.activity.n, c0.g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        r7.c cVar = null;
        int i9 = 0;
        View inflate = getLayoutInflater().inflate(2131558432, (ViewGroup) null, false);
        int i10 = 2131361883;
        if (((LinearLayout) com.bumptech.glide.d.z(inflate, 2131361883)) != null) {
            i10 = 2131361893;
            ImageButton imageButton = (ImageButton) com.bumptech.glide.d.z(inflate, 2131361893);
            if (imageButton != null) {
                i10 = 2131361899;
                Button button = (Button) com.bumptech.glide.d.z(inflate, 2131361899);
                if (button != null) {
                    i10 = 2131361904;
                    ImageButton imageButton2 = (ImageButton) com.bumptech.glide.d.z(inflate, 2131361904);
                    if (imageButton2 != null) {
                        i10 = 2131361905;
                        ImageButton imageButton3 = (ImageButton) com.bumptech.glide.d.z(inflate, 2131361905);
                        if (imageButton3 != null) {
                            i10 = 2131361906;
                            ImageButton imageButton4 = (ImageButton) com.bumptech.glide.d.z(inflate, 2131361906);
                            if (imageButton4 != null) {
                                i10 = 2131361907;
                                ImageButton imageButton5 = (ImageButton) com.bumptech.glide.d.z(inflate, 2131361907);
                                if (imageButton5 != null) {
                                    i10 = 2131361912;
                                    ImageButton imageButton6 = (ImageButton) com.bumptech.glide.d.z(inflate, 2131361912);
                                    if (imageButton6 != null) {
                                        i10 = 2131361913;
                                        Button button2 = (Button) com.bumptech.glide.d.z(inflate, 2131361913);
                                        if (button2 != null) {
                                            i10 = 2131361918;
                                            Button button3 = (Button) com.bumptech.glide.d.z(inflate, 2131361918);
                                            if (button3 != null) {
                                                i10 = 2131361926;
                                                Button button4 = (Button) com.bumptech.glide.d.z(inflate, 2131361926);
                                                if (button4 != null) {
                                                    i10 = 2131361931;
                                                    Button button5 = (Button) com.bumptech.glide.d.z(inflate, 2131361931);
                                                    if (button5 != null) {
                                                        i10 = 2131361932;
                                                        Button button6 = (Button) com.bumptech.glide.d.z(inflate, 2131361932);
                                                        if (button6 != null) {
                                                            i10 = 2131361933;
                                                            Button button7 = (Button) com.bumptech.glide.d.z(inflate, 2131361933);
                                                            if (button7 != null) {
                                                                i10 = 2131361977;
                                                                if (((NestedScrollView) com.bumptech.glide.d.z(inflate, 2131361977)) != null) {
                                                                    i10 = 2131362021;
                                                                    EditText editText = (EditText) com.bumptech.glide.d.z(inflate, 2131362021);
                                                                    if (editText != null) {
                                                                        i10 = 2131362107;
                                                                        if (((LinearLayout) com.bumptech.glide.d.z(inflate, 2131362107)) != null) {
                                                                            i10 = 2131362119;
                                                                            if (((LinearLayout) com.bumptech.glide.d.z(inflate, 2131362119)) != null) {
                                                                                i10 = 2131362123;
                                                                                if (((LinearLayout) com.bumptech.glide.d.z(inflate, 2131362123)) != null) {
                                                                                    i10 = 2131362138;
                                                                                    if (((ImageView) com.bumptech.glide.d.z(inflate, 2131362138)) != null) {
                                                                                        i10 = 2131362170;
                                                                                        LinearLayout linearLayout = (LinearLayout) com.bumptech.glide.d.z(inflate, 2131362170);
                                                                                        if (linearLayout != null) {
                                                                                            i10 = 2131362172;
                                                                                            LinearLayout linearLayout2 = (LinearLayout) com.bumptech.glide.d.z(inflate, 2131362172);
                                                                                            if (linearLayout2 != null) {
                                                                                                i10 = 2131362284;
                                                                                                LinearLayout linearLayout3 = (LinearLayout) com.bumptech.glide.d.z(inflate, 2131362284);
                                                                                                if (linearLayout3 != null) {
                                                                                                    i10 = 2131362296;
                                                                                                    LinearLayout linearLayout4 = (LinearLayout) com.bumptech.glide.d.z(inflate, 2131362296);
                                                                                                    if (linearLayout4 != null) {
                                                                                                        i10 = 2131362315;
                                                                                                        RecyclerView recyclerView = (RecyclerView) com.bumptech.glide.d.z(inflate, 2131362315);
                                                                                                        if (recyclerView != null) {
                                                                                                            i10 = 2131362316;
                                                                                                            RecyclerView recyclerView2 = (RecyclerView) com.bumptech.glide.d.z(inflate, 2131362316);
                                                                                                            if (recyclerView2 != null) {
                                                                                                                i10 = 2131362318;
                                                                                                                RecyclerView recyclerView3 = (RecyclerView) com.bumptech.glide.d.z(inflate, 2131362318);
                                                                                                                if (recyclerView3 != null) {
                                                                                                                    i10 = 2131362320;
                                                                                                                    RecyclerView recyclerView4 = (RecyclerView) com.bumptech.glide.d.z(inflate, 2131362320);
                                                                                                                    if (recyclerView4 != null) {
                                                                                                                        i10 = 2131362322;
                                                                                                                        RecyclerView recyclerView5 = (RecyclerView) com.bumptech.glide.d.z(inflate, 2131362322);
                                                                                                                        if (recyclerView5 != null) {
                                                                                                                            i10 = 2131362341;
                                                                                                                            ScrollView scrollView = (ScrollView) com.bumptech.glide.d.z(inflate, 2131362341);
                                                                                                                            if (scrollView != null) {
                                                                                                                                i10 = 2131362395;
                                                                                                                                LinearLayout linearLayout5 = (LinearLayout) com.bumptech.glide.d.z(inflate, 2131362395);
                                                                                                                                if (linearLayout5 != null) {
                                                                                                                                    i10 = 2131362437;
                                                                                                                                    TextView textView = (TextView) com.bumptech.glide.d.z(inflate, 2131362437);
                                                                                                                                    if (textView != null) {
                                                                                                                                        i10 = 2131362438;
                                                                                                                                        TextView textView2 = (TextView) com.bumptech.glide.d.z(inflate, 2131362438);
                                                                                                                                        if (textView2 != null) {
                                                                                                                                            i10 = 2131362441;
                                                                                                                                            TextView textView3 = (TextView) com.bumptech.glide.d.z(inflate, 2131362441);
                                                                                                                                            if (textView3 != null) {
                                                                                                                                                i10 = 2131362445;
                                                                                                                                                TextView textView4 = (TextView) com.bumptech.glide.d.z(inflate, 2131362445);
                                                                                                                                                if (textView4 != null) {
                                                                                                                                                    i10 = 2131362446;
                                                                                                                                                    TextView textView5 = (TextView) com.bumptech.glide.d.z(inflate, 2131362446);
                                                                                                                                                    if (textView5 != null) {
                                                                                                                                                        i10 = 2131362459;
                                                                                                                                                        TextView textView6 = (TextView) com.bumptech.glide.d.z(inflate, 2131362459);
                                                                                                                                                        if (textView6 != null) {
                                                                                                                                                            ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
                                                                                                                                                            this.E = new d(constraintLayout, imageButton, button, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, button2, button3, button4, button5, button6, button7, editText, linearLayout, linearLayout2, linearLayout3, linearLayout4, recyclerView, recyclerView2, recyclerView3, recyclerView4, recyclerView5, scrollView, linearLayout5, textView, textView2, textView3, textView4, textView5, textView6);
                                                                                                                                                            setContentView(constraintLayout);
                                                                                                                                                            this.K = new a(this);
                                                                                                                                                            int i11 = 1;
                                                                                                                                                            int i12 = 2;
                                                                                                                                                            int i13 = 3;
                                                                                                                                                            this.H = new r(new m0(this, i11), new m0(this, i12), new m0(this, i13), new m0(this, 4));
                                                                                                                                                            d dVar = this.E;
                                                                                                                                                            if (dVar == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            dVar.f1688s.setLayoutManager(new LinearLayoutManager(1));
                                                                                                                                                            d dVar2 = this.E;
                                                                                                                                                            if (dVar2 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            RecyclerView recyclerView6 = dVar2.f1688s;
                                                                                                                                                            r rVar = this.H;
                                                                                                                                                            if (rVar == null) {
                                                                                                                                                                b8.i.d("historyAdapter");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            recyclerView6.setAdapter(rVar);
                                                                                                                                                            int i14 = 8;
                                                                                                                                                            this.L = new b4(new m0(this, 7), new m0(this, i14), (byte) 0);
                                                                                                                                                            d dVar3 = this.E;
                                                                                                                                                            if (dVar3 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            int i15 = 6;
                                                                                                                                                            dVar3.f1692w.setLayoutManager(new GridLayoutManager(6));
                                                                                                                                                            d dVar4 = this.E;
                                                                                                                                                            if (dVar4 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            RecyclerView recyclerView7 = dVar4.f1692w;
                                                                                                                                                            b4 b4Var = this.L;
                                                                                                                                                            if (b4Var == null) {
                                                                                                                                                                b8.i.d("subscriptionAdapter");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            recyclerView7.setAdapter(b4Var);
                                                                                                                                                            this.N = new b4(new m0(this, 5), new m0(this, i15));
                                                                                                                                                            d dVar5 = this.E;
                                                                                                                                                            if (dVar5 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            dVar5.f1691v.setLayoutManager(new LinearLayoutManager(0));
                                                                                                                                                            d dVar6 = this.E;
                                                                                                                                                            if (dVar6 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            RecyclerView recyclerView8 = dVar6.f1691v;
                                                                                                                                                            b4 b4Var2 = this.N;
                                                                                                                                                            if (b4Var2 == null) {
                                                                                                                                                                b8.i.d("quickSearchAdapter");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            recyclerView8.setAdapter(b4Var2);
                                                                                                                                                            d dVar7 = this.E;
                                                                                                                                                            if (dVar7 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            int i16 = 9;
                                                                                                                                                            dVar7.f1675e.setOnClickListener(new i7.k0(this, i16));
                                                                                                                                                            this.P = new w(new m0(this, i16));
                                                                                                                                                            d dVar8 = this.E;
                                                                                                                                                            if (dVar8 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            dVar8.f1690u.setLayoutManager(new GridLayoutManager(5));
                                                                                                                                                            d dVar9 = this.E;
                                                                                                                                                            if (dVar9 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            RecyclerView recyclerView9 = dVar9.f1690u;
                                                                                                                                                            w wVar = this.P;
                                                                                                                                                            if (wVar == null) {
                                                                                                                                                                b8.i.d("pinnedPlaylistsAdapter");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            recyclerView9.setAdapter(wVar);
                                                                                                                                                            d dVar10 = this.E;
                                                                                                                                                            if (dVar10 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            dVar10.f1674d.setOnClickListener(new i7.k0(this, 10));
                                                                                                                                                            long currentTimeMillis2 = System.currentTimeMillis();
                                                                                                                                                            this.G = new a0.l((l) this);
                                                                                                                                                            this.I = new g((MainActivity) this);
                                                                                                                                                            a0.l lVar = new a0.l();
                                                                                                                                                            SharedPreferences sharedPreferences = getSharedPreferences("tvgram_subscriptions", 0);
                                                                                                                                                            sharedPreferences.getClass();
                                                                                                                                                            lVar.f30i = sharedPreferences;
                                                                                                                                                            Gson gson = new Gson();
                                                                                                                                                            lVar.f31j = gson;
                                                                                                                                                            p pVar = p.f8013i;
                                                                                                                                                            l8.d a9 = l8.e.a(pVar);
                                                                                                                                                            lVar.f32k = a9;
                                                                                                                                                            lVar.f33l = a9;
                                                                                                                                                            String string = sharedPreferences.getString("subscribed_channels", null);
                                                                                                                                                            Type type = TypeToken.getParameterized(List.class, SubscriptionItem.class).getType();
                                                                                                                                                            if (string != null) {
                                                                                                                                                                try {
                                                                                                                                                                    Object fromJson = gson.fromJson(string, type);
                                                                                                                                                                    fromJson.getClass();
                                                                                                                                                                    pVar = (List) fromJson;
                                                                                                                                                                } catch (Exception unused) {
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                            ((l8.d) lVar.f32k).e(h.O0(pVar, new a0.k(i14)));
                                                                                                                                                            this.J = lVar;
                                                                                                                                                            this.M = new a5.d((l) this);
                                                                                                                                                            this.O = new a0.l((Context) this);
                                                                                                                                                            Log.i("TvgramStartup", "⏱️ Managers initialized synchronously: " + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
                                                                                                                                                            LifecycleCoroutineScopeImpl a10 = g0.a(this);
                                                                                                                                                            p8.c cVar2 = c0.f5251b;
                                                                                                                                                            i8.w.j(a10, cVar2, new o1(currentTimeMillis, this, null), 2);
                                                                                                                                                            m0 m0Var = this.F;
                                                                                                                                                            k0.G = m0Var;
                                                                                                                                                            CopyOnWriteArrayList copyOnWriteArrayList = m7.k.M;
                                                                                                                                                            m0Var.getClass();
                                                                                                                                                            m7.k.M.add(m0Var);
                                                                                                                                                            s("=== TVgram Player Started ===");
                                                                                                                                                            i8.w.j(g0.a(this), null, new p1(this, cVar, i9), 3);
                                                                                                                                                            d dVar11 = this.E;
                                                                                                                                                            if (dVar11 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            dVar11.f1680k.setOnClickListener(new i7.k0(this, 11));
                                                                                                                                                            d dVar12 = this.E;
                                                                                                                                                            if (dVar12 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            dVar12.f1672b.setOnClickListener(new i7.k0(this, 15));
                                                                                                                                                            d dVar13 = this.E;
                                                                                                                                                            if (dVar13 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            dVar13.f1678i.setOnClickListener(new i7.k0(this, i9));
                                                                                                                                                            d dVar14 = this.E;
                                                                                                                                                            if (dVar14 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            dVar14.f1682m.setOnClickListener(new i7.k0(this, i11));
                                                                                                                                                            d dVar15 = this.E;
                                                                                                                                                            if (dVar15 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            dVar15.f1681l.setOnClickListener(new i7.k0(this, i12));
                                                                                                                                                            d dVar16 = this.E;
                                                                                                                                                            if (dVar16 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            dVar16.f1683n.setOnEditorActionListener(new l0(this, i9));
                                                                                                                                                            d dVar17 = this.E;
                                                                                                                                                            if (dVar17 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            dVar17.f1679j.setOnClickListener(new i7.k0(this, i13));
                                                                                                                                                            d dVar18 = this.E;
                                                                                                                                                            if (dVar18 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            dVar18.f1673c.setOnClickListener(new i7.k0(this, 4));
                                                                                                                                                            d dVar19 = this.E;
                                                                                                                                                            if (dVar19 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            dVar19.f1671a.setOnClickListener(new i7.k0(this, 5));
                                                                                                                                                            d dVar20 = this.E;
                                                                                                                                                            if (dVar20 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            dVar20.h.setOnClickListener(new i7.k0(this, 6));
                                                                                                                                                            d dVar21 = this.E;
                                                                                                                                                            if (dVar21 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            dVar21.f1677g.setOnClickListener(new i7.k0(this, 12));
                                                                                                                                                            d dVar22 = this.E;
                                                                                                                                                            if (dVar22 == null) {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            dVar22.f1676f.setOnClickListener(new i7.k0(this, 13));
                                                                                                                                                            u(getIntent());
                                                                                                                                                            i8.w.j(g0.a(this), cVar2, new h1(this, cVar, i9), 2);
                                                                                                                                                            d dVar23 = this.E;
                                                                                                                                                            if (dVar23 != null) {
                                                                                                                                                                dVar23.E.setOnClickListener(new i7.k0(this, 14));
                                                                                                                                                                return;
                                                                                                                                                            } else {
                                                                                                                                                                b8.i.d("binding");
                                                                                                                                                                throw null;
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
        super.onDestroy();
        if (isFinishing()) {
            try {
                k0 t8 = t();
                t8.getClass();
                if (new a(t8.f4131a).f5628b.getBoolean("clear_cache_on_exit", true)) {
                    k0.r("🧹 Performing Exit Cleanup (Clear All)...");
                    Client client = t8.f4141l;
                    if (client != null) {
                        client.send(new TdApi.OptimizeStorage(0L, 0, -1, 0, null, null, null, false, -1), new androidx.fragment.app.a(t8, 26));
                    }
                }
            } catch (Exception e9) {
                Log.e("MainActivity", "Error cleaning storage: " + e9.getMessage());
            }
        }
        CopyOnWriteArrayList copyOnWriteArrayList = m7.k.M;
        m0 m0Var = this.F;
        m0Var.getClass();
        m7.k.M.remove(m0Var);
        k0.G = null;
    }

    @Override // g.l, androidx.activity.n, android.app.Activity
    public final void onNewIntent(Intent intent) {
        intent.getClass();
        super.onNewIntent(intent);
        setIntent(intent);
        u(intent);
    }

    @Override // g.l, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.M != null) {
            A();
        }
    }

    public final void s(String str) {
        str.getClass();
        synchronized (this.R) {
            this.R.append("\n".concat(str));
            if (!this.T) {
                this.T = true;
                this.S.postDelayed(new s0(this, 0), 200L);
            }
        }
    }

    public final k0 t() {
        return (k0) this.V.a();
    }

    public final void u(Intent intent) {
        String action;
        String stringExtra;
        Uri data;
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        int hashCode = action.hashCode();
        if (hashCode != -1173264947) {
            if (hashCode == -1173171990 && action.equals("android.intent.action.VIEW") && (data = intent.getData()) != null) {
                x(data);
                return;
            }
            return;
        }
        if (action.equals("android.intent.action.SEND") && "text/plain".equals(intent.getType()) && (stringExtra = intent.getStringExtra("android.intent.extra.TEXT")) != null) {
            s("> Texto recibido (Compartir): ".concat(stringExtra));
            Pattern compile = Pattern.compile("(https?://[^\\s]+)");
            compile.getClass();
            Matcher matcher = compile.matcher(stringExtra);
            matcher.getClass();
            a0.b bVar = !matcher.find(0) ? null : new a0.b(matcher, stringExtra);
            if (bVar == null) {
                v(h8.e.u0(stringExtra).toString(), null);
                return;
            }
            String group = ((Matcher) bVar.f8j).group();
            group.getClass();
            s("> URL detectada: ".concat(group));
            v(group, null);
        }
    }

    public final void v(String str, String str2) {
        i8.w.j(g0.a(this), null, new k1(str, this, str2, null, 0), 3);
    }

    public final void w(Playlist playlist) {
        try {
            StringBuilder sb = new StringBuilder();
            Application application = getApplication();
            application.getClass();
            String str = ((TvgramApplication) application).a().f4132b;
            if (str.length() == 0) {
                str = "http://127.0.0.1:45302";
            }
            sb.append("#EXTM3U\n");
            int i9 = 0;
            for (Object obj : playlist.getItems()) {
                int i10 = i9 + 1;
                if (i9 < 0) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                PlaylistItem playlistItem = (PlaylistItem) obj;
                sb.append("#EXTINF:-1, " + i10 + " - " + m.d0(playlistItem.getTitle(), "\n", " ") + "\n");
                sb.append(str + "/resolve?chat_id=" + playlistItem.getChatId() + "&msg_id=" + playlistItem.getMsgId() + "\n");
                i9 = i10;
            }
            File file = new File(getCacheDir(), "fav_" + playlist.getId() + ".m3u");
            com.bumptech.glide.c.Z(file, sb.toString());
            Uri c9 = FileProvider.c(this, getPackageName() + ".provider", file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(c9, "audio/x-mpegurl");
            intent.addFlags(1);
            startActivity(Intent.createChooser(intent, "Selecciona Reproductor"));
        } catch (Exception e9) {
            Toast.makeText(this, "Error: " + e9.getMessage(), 1).show();
        }
    }

    public final void x(Uri uri) {
        i8.w.j(g0.a(this), c0.f5250a, new i7.f(uri, this, null, 1), 2);
    }

    public final void y() {
        LifecycleCoroutineScopeImpl a9 = g0.a(this);
        p8.d dVar = c0.f5250a;
        i8.w.j(a9, n8.o.f7529a, new h1(this, null, 3), 2);
    }

    public final void z() {
        a0.l lVar = this.O;
        if (lVar == null) {
            b8.i.d("playlistManager");
            throw null;
        }
        ArrayList arrayList = (ArrayList) lVar.f32k;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            if (((Playlist) obj).isPinned()) {
                arrayList2.add(obj);
            }
        }
        List Q0 = h.Q0(arrayList2);
        w wVar = this.P;
        if (wVar == null) {
            b8.i.d("pinnedPlaylistsAdapter");
            throw null;
        }
        wVar.f5165e = Q0;
        wVar.c();
        boolean a9 = b8.i.a(t().f4135e.d(), "READY");
        d dVar = this.E;
        if (dVar == null) {
            b8.i.d("binding");
            throw null;
        }
        dVar.f1686q.setVisibility(a9 ? 0 : 8);
        boolean isEmpty = Q0.isEmpty();
        d dVar2 = this.E;
        if (isEmpty) {
            if (dVar2 == null) {
                b8.i.d("binding");
                throw null;
            }
            dVar2.f1690u.setVisibility(8);
            d dVar3 = this.E;
            if (dVar3 != null) {
                dVar3.f1695z.setVisibility(a9 ? 0 : 8);
                return;
            } else {
                b8.i.d("binding");
                throw null;
            }
        }
        if (dVar2 == null) {
            b8.i.d("binding");
            throw null;
        }
        dVar2.f1690u.setVisibility(0);
        d dVar4 = this.E;
        if (dVar4 != null) {
            dVar4.f1695z.setVisibility(8);
        } else {
            b8.i.d("binding");
            throw null;
        }
    }
}
