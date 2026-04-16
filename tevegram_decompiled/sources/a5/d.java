package a5;

import android.animation.Animator;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaCodec;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.Selection;
import android.util.Pair;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.emoji2.text.x;
import androidx.fragment.app.h0;
import androidx.fragment.app.s;
import b2.f0;
import b2.i0;
import b2.j0;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.network.tvgramplayer.data.SearchHistoryManager$QuickSearchItem;
import com.network.tvgramplayer.ui.PlayerActivity;
import d1.d1;
import d1.f1;
import d1.h1;
import d1.n0;
import d1.o0;
import d1.r0;
import d1.t0;
import d1.y0;
import d2.o;
import d4.e0;
import d4.r;
import d4.t;
import g.c0;
import g1.u;
import h7.k0;
import h8.m;
import i3.a0;
import i3.w;
import i3.z;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import k4.p;
import l1.a1;
import l1.q0;
import l1.s0;
import l1.u0;
import l1.v0;
import n0.c1;
import n0.g0;
import o7.n;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import v1.d0;
import v1.q;
import v1.v;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements com.bumptech.glide.load.data.d, r0.j, z2.l, i1.g, d2.h, z, i5.h, t0, b4.l, p, d0, o1.e {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f173i;

    /* renamed from: j, reason: collision with root package name */
    public Object f174j;

    /* renamed from: k, reason: collision with root package name */
    public Object f175k;

    public d(int i9) {
        this.f173i = i9;
        switch (i9) {
            case 11:
                this.f174j = new e4.c(null);
                this.f175k = new HashMap();
                break;
            case 12:
                this.f174j = new HashMap();
                this.f175k = new f4.c(0);
                break;
            case 13:
                this.f174j = new w4.j(1000L);
                this.f175k = x4.c.a(10, new t(6));
                break;
            case 17:
                this.f174j = new g1.p();
                this.f175k = new h3.a();
                break;
            case 19:
                this.f174j = new HashMap();
                break;
            case 28:
                break;
            default:
                this.f174j = new Rect();
                this.f175k = new Rect();
                break;
        }
    }

    public static boolean N0(String str) {
        str.getClass();
        String lowerCase = str.toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        return h8.e.g0(lowerCase, "t.me/", false) || h8.e.g0(lowerCase, "telegram.me/", false) || m.f0(lowerCase, "telegram:", false) || m.f0(lowerCase, "tg:", false);
    }

    public static boolean p0(Editable editable, KeyEvent keyEvent, boolean z8) {
        x[] xVarArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (xVarArr = (x[]) editable.getSpans(selectionStart, selectionEnd, x.class)) != null && xVarArr.length > 0) {
                for (x xVar : xVarArr) {
                    int spanStart = editable.getSpanStart(xVar);
                    int spanEnd = editable.getSpanEnd(xVar);
                    if ((z8 && spanStart == selectionStart) || ((!z8 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // d1.t0
    public int A() {
        return ((t0) this.f174j).A();
    }

    public void A0(boolean z8) {
        s sVar = ((h0) this.f175k).f750p;
        if (sVar != null) {
            sVar.j().f745k.A0(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f174j).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                androidx.fragment.app.a.c();
            } else {
                if (!z8) {
                    throw null;
                }
                throw null;
            }
        }
    }

    @Override // d1.t0
    public f1.c B() {
        return ((t0) this.f174j).B();
    }

    public void B0(boolean z8) {
        s sVar = ((h0) this.f175k).f750p;
        if (sVar != null) {
            sVar.j().f745k.B0(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f174j).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                androidx.fragment.app.a.c();
            } else {
                if (!z8) {
                    throw null;
                }
                throw null;
            }
        }
    }

    @Override // d1.t0
    public void C(TextureView textureView) {
        ((t0) this.f174j).C(textureView);
    }

    public void C0(boolean z8) {
        s sVar = ((h0) this.f175k).f750p;
        if (sVar != null) {
            sVar.j().f745k.C0(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f174j).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                androidx.fragment.app.a.c();
            } else {
                if (!z8) {
                    throw null;
                }
                throw null;
            }
        }
    }

    @Override // d1.t0
    public h1 D() {
        return ((t0) this.f174j).D();
    }

    public void D0(boolean z8) {
        s sVar = ((h0) this.f175k).f750p;
        if (sVar != null) {
            sVar.j().f745k.D0(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f174j).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                androidx.fragment.app.a.c();
            } else {
                if (!z8) {
                    throw null;
                }
                throw null;
            }
        }
    }

    @Override // d1.t0
    public void E(r0 r0Var) {
        ((t0) this.f174j).E(new d1.t(this, r0Var));
    }

    public void E0(boolean z8) {
        s sVar = ((h0) this.f175k).f750p;
        if (sVar != null) {
            sVar.j().f745k.E0(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f174j).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                androidx.fragment.app.a.c();
            } else {
                if (!z8) {
                    throw null;
                }
                throw null;
            }
        }
    }

    @Override // d1.t0
    public void F() {
        ((t0) this.f174j).F();
    }

    public Object F0(e4.h hVar) {
        HashMap hashMap = (HashMap) this.f175k;
        e4.c cVar = (e4.c) hashMap.get(hVar);
        if (cVar == null) {
            cVar = new e4.c(hVar);
            hashMap.put(hVar, cVar);
        } else {
            hVar.a();
        }
        e4.c cVar2 = cVar.f3091d;
        cVar2.f3090c = cVar.f3090c;
        cVar.f3090c.f3091d = cVar2;
        e4.c cVar3 = (e4.c) this.f174j;
        cVar.f3091d = cVar3;
        e4.c cVar4 = cVar3.f3090c;
        cVar.f3090c = cVar4;
        cVar4.f3091d = cVar;
        cVar.f3091d.f3090c = cVar;
        ArrayList arrayList = cVar.f3089b;
        int size = arrayList != null ? arrayList.size() : 0;
        if (size > 0) {
            return cVar.f3089b.remove(size - 1);
        }
        return null;
    }

    @Override // d1.t0
    public void G() {
        ((t0) this.f174j).G();
    }

    public Pair G0(int i9, v1.z zVar) {
        v1.z zVar2;
        u0 u0Var = (u0) this.f174j;
        v1.z zVar3 = null;
        if (zVar != null) {
            int i10 = 0;
            while (true) {
                if (i10 >= u0Var.f6027c.size()) {
                    zVar2 = null;
                    break;
                }
                if (((v1.z) u0Var.f6027c.get(i10)).f9450d == zVar.f9450d) {
                    Object obj = zVar.f9447a;
                    Object obj2 = u0Var.f6026b;
                    int i11 = a1.f5763k;
                    zVar2 = zVar.a(Pair.create(obj2, obj));
                    break;
                }
                i10++;
            }
            if (zVar2 == null) {
                return null;
            }
            zVar3 = zVar2;
        }
        return Pair.create(Integer.valueOf(i9 + u0Var.f6028d), zVar3);
    }

    @Override // d1.t0
    public int H() {
        return ((t0) this.f174j).H();
    }

    public d2.m H0(Object... objArr) {
        Constructor b9;
        synchronized (((AtomicBoolean) this.f175k)) {
            if (!((AtomicBoolean) this.f175k).get()) {
                try {
                    b9 = ((androidx.fragment.app.a) this.f174j).b();
                } catch (ClassNotFoundException unused) {
                    ((AtomicBoolean) this.f175k).set(true);
                } catch (Exception e9) {
                    throw new RuntimeException("Error instantiating extension", e9);
                }
            }
            b9 = null;
        }
        if (b9 == null) {
            return null;
        }
        try {
            return (d2.m) b9.newInstance(objArr);
        } catch (Exception e10) {
            throw new IllegalStateException("Unexpected error creating extractor", e10);
        }
    }

    @Override // d1.t0
    public int I() {
        return ((t0) this.f174j).I();
    }

    public List I0() {
        String string = ((SharedPreferences) this.f174j).getString("quick_searches", null);
        o7.p pVar = o7.p.f8013i;
        if (string == null) {
            return pVar;
        }
        List list = (List) ((Gson) this.f175k).fromJson(string, new TypeToken<List<? extends SearchHistoryManager$QuickSearchItem>>() { // from class: com.network.tvgramplayer.data.SearchHistoryManager$getQuickSearches$type$1
        }.getType());
        return list == null ? pVar : list;
    }

    @Override // d1.t0
    public boolean J(int i9) {
        return (i9 == 7 || i9 == 9) ? ((PlayerActivity) this.f175k).O != null : ((t0) this.f174j).J(i9);
    }

    public String J0(b4.f fVar) {
        String str;
        synchronized (((w4.j) this.f174j)) {
            str = (String) ((w4.j) this.f174j).a(fVar);
        }
        if (str == null) {
            str = n0(fVar);
        }
        synchronized (((w4.j) this.f174j)) {
            ((w4.j) this.f174j).d(fVar, str);
        }
        return str;
    }

    @Override // com.bumptech.glide.load.data.d
    public void K(Object obj) {
        e0 e0Var = (e0) this.f175k;
        h4.p pVar = (h4.p) this.f174j;
        h4.p pVar2 = e0Var.f2832n;
        if (pVar2 == null || pVar2 != pVar) {
            return;
        }
        e0 e0Var2 = (e0) this.f175k;
        h4.p pVar3 = (h4.p) this.f174j;
        d4.m mVar = e0Var2.f2827i.f2848p;
        if (obj == null || !mVar.a(pVar3.f4002c.getDataSource())) {
            d4.k kVar = e0Var2.f2828j;
            b4.f fVar = pVar3.f4000a;
            com.bumptech.glide.load.data.e eVar = pVar3.f4002c;
            kVar.a(fVar, obj, eVar, eVar.getDataSource(), e0Var2.f2833o);
            return;
        }
        e0Var2.f2831m = obj;
        d4.k kVar2 = e0Var2.f2828j;
        kVar2.L = 2;
        r rVar = kVar2.f2871x;
        (rVar.f2909u ? rVar.f2905q : rVar.f2904p).execute(kVar2);
    }

    public List K0(long j5, long j9) {
        StringBuilder c9 = t.a.c("history_", j5, "_");
        c9.append(j9);
        String string = ((SharedPreferences) this.f174j).getString(c9.toString(), null);
        o7.p pVar = o7.p.f8013i;
        if (string == null) {
            return pVar;
        }
        List list = (List) ((Gson) this.f175k).fromJson(string, new TypeToken<List<? extends String>>() { // from class: com.network.tvgramplayer.data.SearchHistoryManager$getSearchHistory$type$1
        }.getType());
        return list == null ? pVar : list;
    }

    @Override // b4.l
    public int L(b4.i iVar) {
        return 2;
    }

    public synchronized Map L0() {
        try {
            if (((Map) this.f175k) == null) {
                this.f175k = Collections.unmodifiableMap(new HashMap((HashMap) this.f174j));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (Map) this.f175k;
    }

    @Override // d1.t0
    public void M(int i9) {
        ((t0) this.f174j).M(i9);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b8, code lost:
    
        if (r6 >= r7) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean M0(java.lang.CharSequence r10, int r11, int r12, androidx.emoji2.text.q r13) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.d.M0(java.lang.CharSequence, int, int, androidx.emoji2.text.q):boolean");
    }

    @Override // d1.t0
    public int N() {
        return ((t0) this.f174j).N();
    }

    @Override // d1.t0
    public void O(SurfaceView surfaceView) {
        ((t0) this.f174j).O(surfaceView);
    }

    public void O0(l.a aVar) {
        a0.l lVar = (a0.l) this.f174j;
        ((ActionMode.Callback) lVar.f30i).onDestroyActionMode(lVar.h(aVar));
        c0 c0Var = (c0) this.f175k;
        if (c0Var.E != null) {
            c0Var.f3489t.getDecorView().removeCallbacks(c0Var.F);
        }
        if (c0Var.D != null) {
            c1 c1Var = c0Var.G;
            if (c1Var != null) {
                c1Var.b();
            }
            c1 a9 = n0.t0.a(c0Var.D);
            a9.a(0.0f);
            c0Var.G = a9;
            a9.d(new g.t(this, 2));
        }
        c0Var.C = null;
        ViewGroup viewGroup = c0Var.I;
        WeakHashMap weakHashMap = n0.t0.f7209a;
        g0.c(viewGroup);
        c0Var.J();
    }

    @Override // d1.t0
    public void P(SurfaceView surfaceView) {
        ((t0) this.f174j).P(surfaceView);
    }

    public boolean P0(l.a aVar, Menu menu) {
        ViewGroup viewGroup = ((c0) this.f175k).I;
        WeakHashMap weakHashMap = n0.t0.f7209a;
        g0.c(viewGroup);
        a0.l lVar = (a0.l) this.f174j;
        ActionMode.Callback callback = (ActionMode.Callback) lVar.f30i;
        l.f h = lVar.h(aVar);
        s.h hVar = (s.h) lVar.f31j;
        Menu menu2 = (Menu) hVar.getOrDefault(menu, null);
        if (menu2 == null) {
            menu2 = new m.c0((Context) lVar.f33l, (m.m) menu);
            hVar.put(menu, menu2);
        }
        return callback.onPrepareActionMode(h, menu2);
    }

    @Override // v1.d0
    public void Q(int i9, v1.z zVar, q qVar, v vVar) {
        Pair G0 = G0(i9, zVar);
        if (G0 != null) {
            ((g1.t) ((v0) this.f175k).f6040j).c(new l1.r0(this, G0, qVar, vVar, 1));
        }
    }

    public void Q0(k0.e eVar) {
        Handler handler = (Handler) this.f175k;
        a0.b bVar = (a0.b) this.f174j;
        int i9 = eVar.f5514b;
        if (i9 != 0) {
            handler.post(new androidx.emoji2.text.j(i9, 2, bVar));
        } else {
            handler.post(new androidx.fragment.app.d(bVar, 9, eVar.f5513a));
        }
    }

    @Override // d1.t0
    public int R() {
        return ((t0) this.f174j).R();
    }

    public void R0(e4.h hVar, Object obj) {
        HashMap hashMap = (HashMap) this.f175k;
        e4.c cVar = (e4.c) hashMap.get(hVar);
        if (cVar == null) {
            cVar = new e4.c(hVar);
            cVar.f3091d = cVar;
            e4.c cVar2 = (e4.c) this.f174j;
            cVar.f3091d = cVar2.f3091d;
            cVar.f3090c = cVar2;
            cVar2.f3091d = cVar;
            cVar.f3091d.f3090c = cVar;
            hashMap.put(hVar, cVar);
        } else {
            hVar.a();
        }
        if (cVar.f3089b == null) {
            cVar.f3089b = new ArrayList();
        }
        cVar.f3089b.add(obj);
    }

    @Override // d1.t0
    public int S() {
        return ((t0) this.f174j).S();
    }

    public void S0(String str) {
        f4.b bVar;
        synchronized (this) {
            try {
                Object obj = ((HashMap) this.f174j).get(str);
                w4.f.c(obj, "Argument must not be null");
                bVar = (f4.b) obj;
                int i9 = bVar.f3373b;
                if (i9 < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + bVar.f3373b);
                }
                int i10 = i9 - 1;
                bVar.f3373b = i10;
                if (i10 == 0) {
                    f4.b bVar2 = (f4.b) ((HashMap) this.f174j).remove(str);
                    if (!bVar2.equals(bVar)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + bVar + ", but actually removed: " + bVar2 + ", safeKey: " + str);
                    }
                    ((f4.c) this.f175k).b(bVar2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        bVar.f3372a.unlock();
    }

    @Override // v1.d0
    public void T(int i9, v1.z zVar, q qVar, v vVar, IOException iOException, boolean z8) {
        Pair G0 = G0(i9, zVar);
        if (G0 != null) {
            ((g1.t) ((v0) this.f175k).f6040j).c(new s0(this, G0, qVar, vVar, iOException, z8, 0));
        }
    }

    public Object T0() {
        e4.c cVar = (e4.c) this.f174j;
        e4.c cVar2 = cVar.f3091d;
        while (true) {
            boolean equals = cVar2.equals(cVar);
            Object obj = cVar2.f3088a;
            if (equals) {
                return null;
            }
            ArrayList arrayList = cVar2.f3089b;
            int size = arrayList != null ? arrayList.size() : 0;
            Object remove = size > 0 ? cVar2.f3089b.remove(size - 1) : null;
            if (remove != null) {
                return remove;
            }
            e4.c cVar3 = cVar2.f3091d;
            cVar3.f3090c = cVar2.f3090c;
            cVar2.f3090c.f3091d = cVar3;
            ((HashMap) this.f175k).remove(obj);
            ((e4.h) obj).a();
            cVar2 = cVar2.f3091d;
        }
    }

    @Override // d1.t0
    public y0 U() {
        return ((t0) this.f174j).U();
    }

    public void U0(SearchHistoryManager$QuickSearchItem searchHistoryManager$QuickSearchItem) {
        searchHistoryManager$QuickSearchItem.getClass();
        ArrayList arrayList = new ArrayList(I0());
        n.F0(arrayList, new b7.b(searchHistoryManager$QuickSearchItem, 1));
        ((SharedPreferences) this.f174j).edit().putString("quick_searches", ((Gson) this.f175k).toJson(arrayList)).apply();
    }

    @Override // v1.d0
    public void V(int i9, v1.z zVar, q qVar, v vVar) {
        Pair G0 = G0(i9, zVar);
        if (G0 != null) {
            ((g1.t) ((v0) this.f175k).f6040j).c(new l1.r0(this, G0, qVar, vVar, 2));
        }
    }

    public Object V0(e7.a aVar, t7.h hVar) {
        Integer Z;
        k0 k0Var = (k0) this.f174j;
        String str = aVar.f3151a;
        if (!N0(str)) {
            return aVar;
        }
        SharedPreferences sharedPreferences = new k7.a((PlayerActivity) this.f175k).f5628b;
        boolean z8 = sharedPreferences.getBoolean("streaming_mode", true);
        boolean z9 = sharedPreferences.getBoolean("chunked_download", false);
        if ((!m.f0(str, "telegram://", false) && !m.f0(str, "telegram:", false)) || (Z = h8.l.Z(m.d0(m.d0(str, "telegram://", ""), "telegram:", ""))) == null) {
            r7.i iVar = new r7.i(com.bumptech.glide.c.C(hVar));
            k0Var.v(str, true, new f7.a(z8, z9, this, iVar, aVar));
            return iVar.a();
        }
        if (!z8 && !z9) {
            int intValue = Z.intValue();
            Client client = k0Var.f4141l;
            if (client != null) {
                client.send(new TdApi.DownloadFile(intValue, 32, 0L, 0L, true), new androidx.fragment.app.a(27));
            }
        }
        return e7.a.a(aVar, k0Var.f4132b + "/file/" + Z, 0, null, 0L, 254);
    }

    @Override // d1.t0
    public Looper W() {
        return ((t0) this.f174j).W();
    }

    public void W0(long j5, long j9, List list) {
        StringBuilder c9 = t.a.c("history_", j5, "_");
        c9.append(j9);
        ((SharedPreferences) this.f174j).edit().putString(c9.toString(), ((Gson) this.f175k).toJson(list)).apply();
    }

    @Override // d1.t0
    public boolean X() {
        return ((t0) this.f174j).X();
    }

    public void X0(SearchHistoryManager$QuickSearchItem searchHistoryManager$QuickSearchItem) {
        Object obj;
        searchHistoryManager$QuickSearchItem.getClass();
        ArrayList arrayList = new ArrayList(I0());
        int size = arrayList.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i9);
            i9++;
            SearchHistoryManager$QuickSearchItem searchHistoryManager$QuickSearchItem2 = (SearchHistoryManager$QuickSearchItem) obj;
            if (b8.i.a(searchHistoryManager$QuickSearchItem2.getQuery(), searchHistoryManager$QuickSearchItem.getQuery()) && searchHistoryManager$QuickSearchItem2.getChatId() == searchHistoryManager$QuickSearchItem.getChatId() && searchHistoryManager$QuickSearchItem2.getThreadId() == searchHistoryManager$QuickSearchItem.getThreadId() && b8.i.a(searchHistoryManager$QuickSearchItem2.getFilterType(), searchHistoryManager$QuickSearchItem.getFilterType())) {
                break;
            }
        }
        SearchHistoryManager$QuickSearchItem searchHistoryManager$QuickSearchItem3 = (SearchHistoryManager$QuickSearchItem) obj;
        if (searchHistoryManager$QuickSearchItem3 != null) {
            arrayList.remove(searchHistoryManager$QuickSearchItem3);
        } else {
            arrayList.add(0, searchHistoryManager$QuickSearchItem);
        }
        ((SharedPreferences) this.f174j).edit().putString("quick_searches", ((Gson) this.f175k).toJson(arrayList)).apply();
    }

    @Override // d1.t0
    public d1 Y() {
        return ((t0) this.f174j).Y();
    }

    public void Y0(h1 h1Var) {
        Handler handler = (Handler) this.f174j;
        if (handler != null) {
            handler.post(new f0(this, 0, h1Var));
        }
    }

    @Override // d1.t0
    public long Z() {
        return ((t0) this.f174j).Z();
    }

    @Override // i1.g
    public i1.h a() {
        return new i1.l((Context) this.f174j, ((i1.m) this.f175k).a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:194:0x03a4, code lost:
    
        r0.addAll(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0116, code lost:
    
        if (")".equals(h3.a.b(r11, r6)) == false) goto L37;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v7, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // z2.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a0(byte[] r20, int r21, int r22, z2.k r23, g1.c r24) {
        /*
            Method dump skipped, instructions count: 1058
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.d.a0(byte[], int, int, z2.k, g1.c):void");
    }

    @Override // d1.t0
    public void b() {
        ((t0) this.f174j).b();
    }

    @Override // d2.h
    public d2.g b0(d2.n nVar, long j5) {
        int a9;
        long position = nVar.getPosition();
        int min = (int) Math.min(20000L, nVar.e() - position);
        g1.p pVar = (g1.p) this.f175k;
        pVar.C(min);
        nVar.a(0, min, pVar.f3699a);
        int i9 = -1;
        long j9 = -9223372036854775807L;
        int i10 = -1;
        while (pVar.a() >= 4) {
            if (h2.a.a(pVar.f3699a, pVar.f3700b) != 442) {
                pVar.G(1);
            } else {
                pVar.G(4);
                long c9 = w.c(pVar);
                if (c9 != -9223372036854775807L) {
                    long b9 = ((u) this.f174j).b(c9);
                    if (b9 > j5) {
                        return j9 == -9223372036854775807L ? new d2.g(-1, b9, position) : new d2.g(0, -9223372036854775807L, position + i10);
                    }
                    long j10 = b9 + 100000;
                    int i11 = pVar.f3700b;
                    if (j10 > j5) {
                        return new d2.g(0, -9223372036854775807L, position + i11);
                    }
                    i10 = i11;
                    j9 = b9;
                }
                int i12 = pVar.f3701c;
                if (pVar.a() >= 10) {
                    pVar.G(9);
                    int t8 = pVar.t() & 7;
                    if (pVar.a() >= t8) {
                        pVar.G(t8);
                        if (pVar.a() >= 4) {
                            if (h2.a.a(pVar.f3699a, pVar.f3700b) == 443) {
                                pVar.G(4);
                                int z8 = pVar.z();
                                if (pVar.a() < z8) {
                                    pVar.F(i12);
                                } else {
                                    pVar.G(z8);
                                }
                            }
                            while (true) {
                                if (pVar.a() < 4 || (a9 = h2.a.a(pVar.f3699a, pVar.f3700b)) == 442 || a9 == 441 || (a9 >>> 8) != 1) {
                                    break;
                                }
                                pVar.G(4);
                                if (pVar.a() < 2) {
                                    pVar.F(i12);
                                    break;
                                }
                                pVar.F(Math.min(pVar.f3701c, pVar.f3700b + pVar.z()));
                            }
                        } else {
                            pVar.F(i12);
                        }
                    } else {
                        pVar.F(i12);
                    }
                } else {
                    pVar.F(i12);
                }
                i9 = pVar.f3700b;
            }
        }
        return j9 != -9223372036854775807L ? new d2.g(-2, j9, position + i9) : d2.g.f2690d;
    }

    @Override // i3.z
    public void c(g1.p pVar) {
        i3.c0 c0Var = (i3.c0) this.f175k;
        SparseArray sparseArray = c0Var.h;
        a3.g gVar = (a3.g) this.f174j;
        if (pVar.t() == 0 && (pVar.t() & 128) != 0) {
            pVar.G(6);
            int a9 = pVar.a() / 4;
            for (int i9 = 0; i9 < a9; i9++) {
                pVar.e(0, 4, gVar.f104b);
                gVar.p(0);
                int i10 = gVar.i(16);
                gVar.s(3);
                if (i10 == 0) {
                    gVar.s(13);
                } else {
                    int i11 = gVar.i(13);
                    if (sparseArray.get(i11) == null) {
                        sparseArray.put(i11, new a0(new g1.e(c0Var, i11)));
                        c0Var.f4441n++;
                    }
                }
            }
            if (c0Var.f4429a != 2) {
                sparseArray.remove(0);
            }
        }
    }

    @Override // d1.t0
    public void c0() {
        PlayerActivity playerActivity = (PlayerActivity) this.f175k;
        if (playerActivity.O != null) {
            playerActivity.v();
        } else {
            ((t0) this.f174j).c0();
        }
    }

    @Override // d1.t0
    public o0 d() {
        return ((t0) this.f174j).d();
    }

    @Override // d1.t0
    public void d0() {
        ((t0) this.f174j).d0();
    }

    @Override // d1.t0
    public void e(o0 o0Var) {
        ((t0) this.f174j).e(o0Var);
    }

    @Override // d2.h
    public void e0() {
        g1.p pVar = (g1.p) this.f175k;
        byte[] bArr = g1.w.f3718f;
        pVar.getClass();
        pVar.D(bArr, bArr.length);
    }

    @Override // d1.t0
    public void f0(TextureView textureView) {
        ((t0) this.f174j).f0(textureView);
    }

    @Override // d1.t0
    public n0 g() {
        return ((t0) this.f174j).g();
    }

    @Override // d1.t0
    public void g0() {
        ((t0) this.f174j).g0();
    }

    @Override // d1.t0
    public long getCurrentPosition() {
        return ((t0) this.f174j).getCurrentPosition();
    }

    @Override // d1.t0
    public long getDuration() {
        return ((t0) this.f174j).getDuration();
    }

    @Override // d1.t0
    public boolean h() {
        return ((t0) this.f174j).h();
    }

    @Override // z2.l
    public /* synthetic */ z2.f h0(int i9, int i10, byte[] bArr) {
        return t.a.a(this, bArr, i10);
    }

    @Override // d1.t0
    public long i() {
        return ((t0) this.f174j).i();
    }

    @Override // d1.t0
    public d1.h0 i0() {
        return ((t0) this.f174j).i0();
    }

    @Override // d1.t0
    public boolean isPlaying() {
        return ((t0) this.f174j).isPlaying();
    }

    @Override // d1.t0
    public long j() {
        return ((t0) this.f174j).j();
    }

    @Override // d1.t0
    public void j0() {
        PlayerActivity playerActivity = (PlayerActivity) this.f175k;
        if (playerActivity.O != null) {
            playerActivity.w();
        } else {
            ((t0) this.f174j).j0();
        }
    }

    @Override // d1.t0
    public long k() {
        return ((t0) this.f174j).k();
    }

    @Override // d1.t0
    public long k0() {
        return ((t0) this.f174j).k0();
    }

    @Override // d1.t0
    public void l(int i9, long j5) {
        ((t0) this.f174j).l(i9, j5);
    }

    @Override // k4.p
    public void l0(Bitmap bitmap, e4.a aVar) {
        IOException iOException = ((w4.e) this.f175k).f9936j;
        if (iOException != null) {
            if (bitmap == null) {
                throw iOException;
            }
            aVar.g(bitmap);
            throw iOException;
        }
    }

    @Override // v1.d0
    public void m(int i9, v1.z zVar, v vVar) {
        Pair G0 = G0(i9, zVar);
        if (G0 != null) {
            ((g1.t) ((v0) this.f175k).f6040j).c(new q0(this, G0, vVar, 1));
        }
    }

    @Override // k4.p
    public void m0() {
        k4.x xVar = (k4.x) this.f174j;
        synchronized (xVar) {
            xVar.f5606k = xVar.f5604i.length;
        }
    }

    @Override // d1.t0
    public void n(d1 d1Var) {
        ((t0) this.f174j).n(d1Var);
    }

    public String n0(b4.f fVar) {
        String str;
        f4.g gVar = (f4.g) ((x.c) this.f175k).b();
        try {
            fVar.b(gVar.f3386i);
            byte[] digest = gVar.f3386i.digest();
            char[] cArr = w4.n.f9952b;
            synchronized (cArr) {
                for (int i9 = 0; i9 < digest.length; i9++) {
                    byte b9 = digest[i9];
                    int i10 = i9 * 2;
                    char[] cArr2 = w4.n.f9951a;
                    cArr[i10] = cArr2[(b9 & 255) >>> 4];
                    cArr[i10 + 1] = cArr2[b9 & 15];
                }
                str = new String(cArr);
            }
            return str;
        } finally {
            ((x.c) this.f175k).a(gVar);
        }
    }

    @Override // v1.d0
    public void o(int i9, v1.z zVar, v vVar) {
        Pair G0 = G0(i9, zVar);
        if (G0 != null) {
            ((g1.t) ((v0) this.f175k).f6040j).c(new q0(this, G0, vVar, 0));
        }
    }

    public void o0() {
        this.f174j = null;
        this.f175k = null;
    }

    @Override // d1.t0
    public boolean p() {
        return ((t0) this.f174j).p();
    }

    @Override // d1.t0
    public void pause() {
        ((t0) this.f174j).pause();
    }

    @Override // d1.t0
    public void q() {
        ((t0) this.f174j).q();
    }

    public void q0(l1.f fVar) {
        synchronized (fVar) {
        }
        Handler handler = (Handler) this.f174j;
        if (handler != null) {
            handler.post(new i0(this, fVar, 1));
        }
    }

    @Override // d1.t0
    public void r(boolean z8) {
        ((t0) this.f174j).r(z8);
    }

    public void r0(boolean z8) {
        s sVar = ((h0) this.f175k).f750p;
        if (sVar != null) {
            sVar.j().f745k.r0(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f174j).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                androidx.fragment.app.a.c();
            } else {
                if (!z8) {
                    throw null;
                }
                throw null;
            }
        }
    }

    @Override // b4.b
    public boolean s(Object obj, File file, b4.i iVar) {
        return ((k4.b) this.f175k).s(new k4.d(((BitmapDrawable) ((d4.a0) obj).get()).getBitmap(), (e4.a) this.f174j), file, iVar);
    }

    public void s0(boolean z8) {
        h0 h0Var = (h0) this.f175k;
        g.l lVar = h0Var.f748n.f872p;
        s sVar = h0Var.f750p;
        if (sVar != null) {
            sVar.j().f745k.s0(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f174j).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                androidx.fragment.app.a.c();
            } else {
                if (!z8) {
                    throw null;
                }
                throw null;
            }
        }
    }

    @Override // d1.t0
    public void seekTo(long j5) {
        ((t0) this.f174j).seekTo(j5);
    }

    @Override // d1.t0
    public void stop() {
        ((t0) this.f174j).stop();
    }

    @Override // d1.t0
    public int t() {
        return ((t0) this.f174j).t();
    }

    public void t0(boolean z8) {
        s sVar = ((h0) this.f175k).f750p;
        if (sVar != null) {
            sVar.j().f745k.t0(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f174j).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                androidx.fragment.app.a.c();
            } else {
                if (!z8) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public String toString() {
        switch (this.f173i) {
            case 11:
                StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
                e4.c cVar = (e4.c) this.f174j;
                e4.c cVar2 = cVar.f3090c;
                boolean z8 = false;
                while (!cVar2.equals(cVar)) {
                    sb.append('{');
                    sb.append(cVar2.f3088a);
                    sb.append(':');
                    ArrayList arrayList = cVar2.f3089b;
                    sb.append(arrayList != null ? arrayList.size() : 0);
                    sb.append("}, ");
                    cVar2 = cVar2.f3090c;
                    z8 = true;
                }
                if (z8) {
                    sb.delete(sb.length() - 2, sb.length());
                }
                sb.append(" )");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    @Override // d1.t0
    public void u(r0 r0Var) {
        ((t0) this.f174j).u(new d1.t(this, r0Var));
    }

    public void u0(boolean z8) {
        s sVar = ((h0) this.f175k).f750p;
        if (sVar != null) {
            sVar.j().f745k.u0(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f174j).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                androidx.fragment.app.a.c();
            } else {
                if (!z8) {
                    throw null;
                }
                throw null;
            }
        }
    }

    @Override // d1.t0
    public f1 v() {
        return ((t0) this.f174j).v();
    }

    public void v0(boolean z8) {
        s sVar = ((h0) this.f175k).f750p;
        if (sVar != null) {
            sVar.j().f745k.v0(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f174j).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                androidx.fragment.app.a.c();
            } else {
                if (!z8) {
                    throw null;
                }
                throw null;
            }
        }
    }

    @Override // d1.t0
    public int w() {
        return ((t0) this.f174j).w();
    }

    public void w0(boolean z8) {
        s sVar = ((h0) this.f175k).f750p;
        if (sVar != null) {
            sVar.j().f745k.w0(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f174j).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                androidx.fragment.app.a.c();
            } else {
                if (!z8) {
                    throw null;
                }
                throw null;
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void x(Exception exc) {
        e0 e0Var = (e0) this.f175k;
        h4.p pVar = (h4.p) this.f174j;
        h4.p pVar2 = e0Var.f2832n;
        if (pVar2 == null || pVar2 != pVar) {
            return;
        }
        e0 e0Var2 = (e0) this.f175k;
        h4.p pVar3 = (h4.p) this.f174j;
        d4.k kVar = e0Var2.f2828j;
        d4.e eVar = e0Var2.f2833o;
        com.bumptech.glide.load.data.e eVar2 = pVar3.f4002c;
        kVar.c(eVar, exc, eVar2, eVar2.getDataSource());
    }

    public void x0(boolean z8) {
        h0 h0Var = (h0) this.f175k;
        g.l lVar = h0Var.f748n.f872p;
        s sVar = h0Var.f750p;
        if (sVar != null) {
            sVar.j().f745k.x0(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f174j).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                androidx.fragment.app.a.c();
            } else {
                if (!z8) {
                    throw null;
                }
                throw null;
            }
        }
    }

    @Override // v1.d0
    public void y(int i9, v1.z zVar, q qVar, v vVar) {
        Pair G0 = G0(i9, zVar);
        if (G0 != null) {
            ((g1.t) ((v0) this.f175k).f6040j).c(new l1.r0(this, G0, qVar, vVar, 0));
        }
    }

    public void y0(boolean z8) {
        s sVar = ((h0) this.f175k).f750p;
        if (sVar != null) {
            sVar.j().f745k.y0(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f174j).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                androidx.fragment.app.a.c();
            } else {
                if (!z8) {
                    throw null;
                }
                throw null;
            }
        }
    }

    @Override // d1.t0
    public long z() {
        return ((t0) this.f174j).z();
    }

    public void z0(boolean z8) {
        s sVar = ((h0) this.f175k).f750p;
        if (sVar != null) {
            sVar.j().f745k.z0(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f174j).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                androidx.fragment.app.a.c();
            } else {
                if (!z8) {
                    throw null;
                }
                throw null;
            }
        }
    }

    @Override // z2.l
    public /* synthetic */ void reset() {
    }

    public /* synthetic */ d(Object obj, Object obj2, int i9, boolean z8) {
        this.f173i = i9;
        this.f175k = obj;
        this.f174j = obj2;
    }

    public d(g.l lVar) {
        this.f173i = 5;
        this.f174j = lVar.getSharedPreferences("search_history", 0);
        this.f175k = new Gson();
    }

    public d(u5.e eVar) {
        this.f173i = 6;
        this.f174j = new HashMap();
        this.f175k = eVar;
    }

    public d(h0 h0Var) {
        this.f173i = 3;
        this.f174j = new CopyOnWriteArrayList();
        this.f175k = h0Var;
    }

    public d(u uVar) {
        this.f173i = 20;
        this.f174j = uVar;
        this.f175k = new g1.p();
    }

    public d(Context context, i1.m mVar) {
        this.f173i = 18;
        this.f174j = context.getApplicationContext();
        this.f175k = mVar;
    }

    public d(a0.l lVar, u5.e eVar, androidx.emoji2.text.e eVar2) {
        this.f173i = 1;
        this.f174j = lVar;
        this.f175k = eVar2;
    }

    public d(Handler handler, j0 j0Var) {
        this.f173i = 4;
        if (j0Var != null) {
            handler.getClass();
        } else {
            handler = null;
        }
        this.f174j = handler;
        this.f175k = j0Var;
    }

    public d(MediaCodec.CryptoInfo cryptoInfo) {
        this.f173i = 24;
        this.f174j = cryptoInfo;
        this.f175k = j0.j.j();
    }

    public d(ArrayList arrayList, ArrayList arrayList2) {
        this.f173i = 10;
        int size = arrayList.size();
        this.f174j = new int[size];
        this.f175k = new float[size];
        for (int i9 = 0; i9 < size; i9++) {
            ((int[]) this.f174j)[i9] = ((Integer) arrayList.get(i9)).intValue();
            ((float[]) this.f175k)[i9] = ((Float) arrayList2.get(i9)).floatValue();
        }
    }

    @Override // i3.z
    public void f(u uVar, o oVar, i3.e0 e0Var) {
    }

    public d(int i9, int i10) {
        this.f173i = 10;
        this.f174j = new int[]{i9, i10};
        this.f175k = new float[]{0.0f, 1.0f};
    }

    public d(int i9, int i10, int i11) {
        this.f173i = 10;
        this.f174j = new int[]{i9, i10, i11};
        this.f175k = new float[]{0.0f, 0.5f, 1.0f};
    }

    public d(Animation animation) {
        this.f173i = 2;
        this.f174j = animation;
        this.f175k = null;
    }

    public d(Animator animator) {
        this.f173i = 2;
        this.f174j = null;
        this.f175k = animator;
    }

    public d(i3.c0 c0Var) {
        this.f173i = 21;
        this.f175k = c0Var;
        this.f174j = new a3.g(new byte[4], 4);
    }

    public d(androidx.fragment.app.a aVar) {
        this.f173i = 7;
        this.f174j = aVar;
        this.f175k = new AtomicBoolean(false);
    }

    public /* synthetic */ d(Object obj, int i9, Object obj2) {
        this.f173i = i9;
        this.f174j = obj;
        this.f175k = obj2;
    }
}
