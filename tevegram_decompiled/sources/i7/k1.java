package i7;

import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.network.tvgramplayer.TvgramApplication;
import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.ui.PlayerActivity;
import com.network.tvgramplayer.util.LinkDecryptor;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k1 extends t7.h implements a8.p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f4937m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ ContextWrapper f4938n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f4939o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Comparable f4940p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k1(m7.k kVar, m7.f fVar, TvgramApplication tvgramApplication, r7.c cVar) {
        super(2, cVar);
        this.f4937m = 2;
        this.f4939o = kVar;
        this.f4940p = fVar;
        this.f4938n = tvgramApplication;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        i8.u uVar = (i8.u) obj;
        r7.c cVar = (r7.c) obj2;
        switch (this.f4937m) {
            case 0:
                k1 k1Var = (k1) j(uVar, cVar);
                n7.g gVar = n7.g.f7490c;
                k1Var.k(gVar);
                return gVar;
            case 1:
                k1 k1Var2 = (k1) j(uVar, cVar);
                n7.g gVar2 = n7.g.f7490c;
                k1Var2.k(gVar2);
                return gVar2;
            default:
                k1 k1Var3 = (k1) j(uVar, cVar);
                n7.g gVar3 = n7.g.f7490c;
                k1Var3.k(gVar3);
                return gVar3;
        }
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        switch (this.f4937m) {
            case 0:
                return new k1((String) this.f4939o, (MainActivity) this.f4938n, (String) this.f4940p, cVar, 0);
            case 1:
                return new k1((com.bumptech.glide.c) this.f4939o, (MainActivity) this.f4938n, (Uri) this.f4940p, cVar, 1);
            default:
                return new k1((m7.k) this.f4939o, (m7.f) this.f4940p, (TvgramApplication) this.f4938n, cVar);
        }
    }

    @Override // t7.a
    public final Object k(Object obj) {
        Uri parse;
        com.bumptech.glide.c v8;
        int i9 = this.f4937m;
        ContextWrapper contextWrapper = this.f4938n;
        Comparable comparable = this.f4940p;
        Object obj2 = this.f4939o;
        switch (i9) {
            case 0:
                String str = (String) obj2;
                String str2 = (String) comparable;
                n7.g gVar = n7.g.f7490c;
                MainActivity mainActivity = (MainActivity) contextWrapper;
                com.bumptech.glide.c.V(obj);
                try {
                    parse = Uri.parse(str);
                    parse.getClass();
                    v8 = d4.t.v(parse);
                } catch (Exception unused) {
                }
                if (v8 instanceof d7.b) {
                    e7.a aVar = ((d7.b) v8).f2966p;
                    k7.a aVar2 = mainActivity.K;
                    if (aVar2 == null) {
                        b8.i.d("settings");
                        throw null;
                    }
                    if (aVar2.f5628b.getBoolean("use_external_player", false)) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setDataAndType(Uri.parse(aVar.f3151a), "video/*");
                        try {
                            mainActivity.startActivity(intent);
                        } catch (Exception unused2) {
                            Toast.makeText(mainActivity, "No hay reproductor externo disponible", 0).show();
                        }
                    } else {
                        n.q qVar = new n.q(mainActivity, null);
                        qVar.setText("Recordar mi elección");
                        FrameLayout frameLayout = new FrameLayout(mainActivity);
                        int i10 = (int) (16 * frameLayout.getResources().getDisplayMetrics().density);
                        frameLayout.setPadding(i10, i10 / 2, i10, 0);
                        frameLayout.addView(qVar);
                        k5.b m9 = new k5.b(mainActivity, 0).m("¿Cómo quieres abrir el vídeo?");
                        try {
                            m9.i(new String[]{"Reproductor Interno", "Reproductor Externo"}, new i1(mainActivity, qVar, aVar, (String) obj2, parse, 0));
                            k5.b n4 = m9.n(frameLayout);
                            n4.j("Cancelar", null);
                            n4.h();
                        } catch (Exception unused3) {
                            mainActivity = mainActivity;
                        }
                    }
                    return gVar;
                }
                if (v8 instanceof d7.a) {
                    String str3 = ((d7.a) v8).f2964p;
                    String str4 = ((d7.a) v8).f2965q;
                    if (str4 != null) {
                        str2 = str4;
                    }
                    mainActivity.B(str3, str2, str, (r11 & 32) == 0, (r11 & 16) != 0 ? null : "explorer");
                } else {
                    if (v8 instanceof d7.c) {
                        String a9 = LinkDecryptor.f2333a.a(mainActivity, ((d7.c) v8).f2967p);
                        if (a9 != null) {
                            List p02 = h8.e.p0(a9, new String[]{"|"}, 6);
                            if (p02.size() >= 2) {
                                String str5 = (String) p02.get(0);
                                String str6 = (String) p02.get(1);
                                String str7 = p02.size() >= 3 ? (String) p02.get(2) : null;
                                String str8 = str7 == null ? str2 : str7;
                                int i11 = MainActivity.X;
                                mainActivity.B(str6, str8, (String) obj2, true, str5);
                            }
                        } else {
                            Log.e("MainActivity", "❌ Error: Falló el descifrado");
                            Toast.makeText(mainActivity, "Error en enlace seguro", 0).show();
                            mainActivity.U = false;
                        }
                    }
                    String str9 = (String) obj2;
                    int i12 = MainActivity.X;
                    mainActivity.B(str9, (String) comparable, str9, true, null);
                }
                return gVar;
            case 1:
                Uri uri = (Uri) comparable;
                MainActivity mainActivity2 = (MainActivity) contextWrapper;
                com.bumptech.glide.c.V(obj);
                com.bumptech.glide.c cVar = (com.bumptech.glide.c) obj2;
                if (cVar instanceof d7.a) {
                    d7.a aVar3 = (d7.a) cVar;
                    String str10 = aVar3.f2965q;
                    Log.i("MainActivity", "Injecting Title from DeepLink: " + str10);
                    mainActivity2.s("> Parsed Action: Join " + aVar3.f2964p + " (Custom Title: " + str10 + ")");
                    String uri2 = uri.toString();
                    uri2.getClass();
                    mainActivity2.v(uri2, str10);
                } else if (cVar instanceof d7.b) {
                    mainActivity2.s("> Parsed Action: Play " + ((d7.b) cVar).f2966p.f3151a);
                    Intent intent2 = new Intent(mainActivity2, (Class<?>) PlayerActivity.class);
                    intent2.setData(uri);
                    intent2.putExtra("EXTRA_CONTEXT_URL", uri.toString());
                    mainActivity2.startActivity(intent2);
                } else if (cVar instanceof d7.c) {
                    String uri3 = uri.toString();
                    uri3.getClass();
                    int i13 = MainActivity.X;
                    mainActivity2.v(uri3, null);
                } else if (cVar != null) {
                    mainActivity2.s("> Parsed Action: " + cVar);
                }
                return n7.g.f7490c;
            default:
                com.bumptech.glide.c.V(obj);
                h7.k0 a10 = ((TvgramApplication) contextWrapper).a();
                CopyOnWriteArrayList copyOnWriteArrayList = m7.k.M;
                ((m7.k) obj2).e((m7.f) comparable, a10);
                return n7.g.f7490c;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k1(Object obj, MainActivity mainActivity, Comparable comparable, r7.c cVar, int i9) {
        super(2, cVar);
        this.f4937m = i9;
        this.f4939o = obj;
        this.f4938n = mainActivity;
        this.f4940p = comparable;
    }
}
