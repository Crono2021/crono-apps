package o3;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class d1 {

    /* renamed from: t, reason: collision with root package name */
    public static final List f7617t = Collections.EMPTY_LIST;

    /* renamed from: a, reason: collision with root package name */
    public final View f7618a;

    /* renamed from: b, reason: collision with root package name */
    public WeakReference f7619b;

    /* renamed from: j, reason: collision with root package name */
    public int f7626j;

    /* renamed from: r, reason: collision with root package name */
    public RecyclerView f7634r;

    /* renamed from: s, reason: collision with root package name */
    public g0 f7635s;

    /* renamed from: c, reason: collision with root package name */
    public int f7620c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f7621d = -1;

    /* renamed from: e, reason: collision with root package name */
    public long f7622e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f7623f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f7624g = -1;
    public d1 h = null;

    /* renamed from: i, reason: collision with root package name */
    public d1 f7625i = null;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f7627k = null;

    /* renamed from: l, reason: collision with root package name */
    public List f7628l = null;

    /* renamed from: m, reason: collision with root package name */
    public int f7629m = 0;

    /* renamed from: n, reason: collision with root package name */
    public l7.a f7630n = null;

    /* renamed from: o, reason: collision with root package name */
    public boolean f7631o = false;

    /* renamed from: p, reason: collision with root package name */
    public int f7632p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f7633q = -1;

    public d1(View view) {
        if (view != null) {
            this.f7618a = view;
        } else {
            m7.c.n("itemView may not be null");
            throw null;
        }
    }

    public final void a(int i9) {
        this.f7626j = i9 | this.f7626j;
    }

    public final int b() {
        int i9 = this.f7624g;
        return i9 == -1 ? this.f7620c : i9;
    }

    public final List c() {
        ArrayList arrayList;
        return ((this.f7626j & 1024) != 0 || (arrayList = this.f7627k) == null || arrayList.size() == 0) ? f7617t : this.f7628l;
    }

    public final boolean d() {
        View view = this.f7618a;
        return (view.getParent() == null || view.getParent() == this.f7634r) ? false : true;
    }

    public final boolean e() {
        return (this.f7626j & 1) != 0;
    }

    public final boolean f() {
        return (this.f7626j & 4) != 0;
    }

    public final boolean g() {
        if ((this.f7626j & 16) != 0) {
            return false;
        }
        WeakHashMap weakHashMap = n0.t0.f7209a;
        return !n0.c0.i(this.f7618a);
    }

    public final boolean h() {
        return (this.f7626j & 8) != 0;
    }

    public final boolean i() {
        return this.f7630n != null;
    }

    public final boolean j() {
        return (this.f7626j & 256) != 0;
    }

    public final boolean k() {
        return (this.f7626j & 2) != 0;
    }

    public final void l(int i9, boolean z8) {
        if (this.f7621d == -1) {
            this.f7621d = this.f7620c;
        }
        if (this.f7624g == -1) {
            this.f7624g = this.f7620c;
        }
        if (z8) {
            this.f7624g += i9;
        }
        this.f7620c += i9;
        View view = this.f7618a;
        if (view.getLayoutParams() != null) {
            ((p0) view.getLayoutParams()).f7767c = true;
        }
    }

    public final void m() {
        this.f7626j = 0;
        this.f7620c = -1;
        this.f7621d = -1;
        this.f7622e = -1L;
        this.f7624g = -1;
        this.f7629m = 0;
        this.h = null;
        this.f7625i = null;
        ArrayList arrayList = this.f7627k;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f7626j &= -1025;
        this.f7632p = 0;
        this.f7633q = -1;
        RecyclerView.j(this);
    }

    public final void n(boolean z8) {
        int i9 = this.f7629m;
        int i10 = z8 ? i9 - 1 : i9 + 1;
        this.f7629m = i10;
        if (i10 < 0) {
            this.f7629m = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            return;
        }
        if (!z8 && i10 == 1) {
            this.f7626j |= 16;
        } else if (z8 && i10 == 0) {
            this.f7626j &= -17;
        }
    }

    public final boolean o() {
        return (this.f7626j & 128) != 0;
    }

    public final boolean p() {
        return (this.f7626j & 32) != 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.f7620c + " id=" + this.f7622e + ", oldPos=" + this.f7621d + ", pLpos:" + this.f7624g);
        if (i()) {
            sb.append(" scrap ");
            sb.append(this.f7631o ? "[changeScrap]" : "[attachedScrap]");
        }
        if (f()) {
            sb.append(" invalid");
        }
        if (!e()) {
            sb.append(" unbound");
        }
        if ((this.f7626j & 2) != 0) {
            sb.append(" update");
        }
        if (h()) {
            sb.append(" removed");
        }
        if (o()) {
            sb.append(" ignored");
        }
        if (j()) {
            sb.append(" tmpDetached");
        }
        if (!g()) {
            sb.append(" not recyclable(" + this.f7629m + ")");
        }
        if ((this.f7626j & IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED) != 0 || f()) {
            sb.append(" undefined adapter position");
        }
        if (this.f7618a.getParent() == null) {
            sb.append(" no parent");
        }
        sb.append("}");
        return sb.toString();
    }
}
