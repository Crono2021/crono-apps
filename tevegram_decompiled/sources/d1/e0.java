package d1;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f2408a;

    /* renamed from: b, reason: collision with root package name */
    public final b0 f2409b;

    /* renamed from: c, reason: collision with root package name */
    public final a0 f2410c;

    /* renamed from: d, reason: collision with root package name */
    public final h0 f2411d;

    /* renamed from: e, reason: collision with root package name */
    public final y f2412e;

    /* renamed from: f, reason: collision with root package name */
    public final c0 f2413f;

    static {
        w wVar = new w();
        b6.e0 e0Var = b6.g0.f1391j;
        b6.w0 w0Var = b6.w0.f1464m;
        List list = Collections.EMPTY_LIST;
        b6.w0 w0Var2 = b6.w0.f1464m;
        z zVar = new z();
        c0 c0Var = c0.f2371a;
        wVar.a();
        zVar.a();
        h0 h0Var = h0.f2449y;
        androidx.activity.g.s(0, 1, 2, 3, 4);
        g1.w.H(5);
    }

    public e0(String str, y yVar, b0 b0Var, a0 a0Var, h0 h0Var, c0 c0Var) {
        this.f2408a = str;
        this.f2409b = b0Var;
        this.f2410c = a0Var;
        this.f2411d = h0Var;
        this.f2412e = yVar;
        this.f2413f = c0Var;
    }

    public static e0 a(String str) {
        w wVar = new w();
        b6.e0 e0Var = b6.g0.f1391j;
        b6.w0 w0Var = b6.w0.f1464m;
        List list = Collections.EMPTY_LIST;
        b6.w0 w0Var2 = b6.w0.f1464m;
        z zVar = new z();
        c0 c0Var = c0.f2371a;
        Uri parse = str == null ? null : Uri.parse(str);
        return new e0("", new y(wVar), parse != null ? new b0(parse, null, null, list, w0Var2, -9223372036854775807L) : null, new a0(zVar), h0.f2449y, c0Var);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return g1.w.a(this.f2408a, e0Var.f2408a) && this.f2412e.equals(e0Var.f2412e) && g1.w.a(this.f2409b, e0Var.f2409b) && this.f2410c.equals(e0Var.f2410c) && g1.w.a(this.f2411d, e0Var.f2411d) && g1.w.a(this.f2413f, e0Var.f2413f);
    }

    public final int hashCode() {
        int hashCode = this.f2408a.hashCode() * 31;
        b0 b0Var = this.f2409b;
        int hashCode2 = (this.f2411d.hashCode() + ((this.f2412e.hashCode() + ((this.f2410c.hashCode() + ((hashCode + (b0Var != null ? b0Var.hashCode() : 0)) * 31)) * 31)) * 31)) * 31;
        this.f2413f.getClass();
        return hashCode2;
    }
}
