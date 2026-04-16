package o1;

import androidx.emoji2.text.m;
import d1.s;
import g1.w;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import l1.s0;
import v1.b0;
import v1.c0;
import v1.q;
import v1.v;
import v1.z;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f7569a;

    /* renamed from: b, reason: collision with root package name */
    public final z f7570b;

    /* renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f7571c;

    public /* synthetic */ d(CopyOnWriteArrayList copyOnWriteArrayList, int i9, z zVar) {
        this.f7571c = copyOnWriteArrayList;
        this.f7569a = i9;
        this.f7570b = zVar;
    }

    public void a(v vVar) {
        Iterator it = this.f7571c.iterator();
        while (it.hasNext()) {
            c0 c0Var = (c0) it.next();
            w.P(c0Var.f9253a, new m(this, c0Var.f9254b, vVar, 9));
        }
    }

    public void b(q qVar, int i9, int i10, s sVar, int i11, Object obj, long j5, long j9) {
        c(qVar, new v(i9, i10, sVar, i11, obj, w.W(j5), w.W(j9)));
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, v1.d0] */
    public void c(q qVar, v vVar) {
        Iterator it = this.f7571c.iterator();
        while (it.hasNext()) {
            c0 c0Var = (c0) it.next();
            w.P(c0Var.f9253a, new b0(this, c0Var.f9254b, qVar, vVar, 2));
        }
    }

    public void d(q qVar, int i9, int i10, s sVar, int i11, Object obj, long j5, long j9) {
        e(qVar, new v(i9, i10, sVar, i11, obj, w.W(j5), w.W(j9)));
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, v1.d0] */
    public void e(q qVar, v vVar) {
        Iterator it = this.f7571c.iterator();
        while (it.hasNext()) {
            c0 c0Var = (c0) it.next();
            w.P(c0Var.f9253a, new b0(this, c0Var.f9254b, qVar, vVar, 1));
        }
    }

    public void f(q qVar, int i9, int i10, s sVar, int i11, Object obj, long j5, long j9, IOException iOException, boolean z8) {
        g(qVar, new v(i9, i10, sVar, i11, obj, w.W(j5), w.W(j9)), iOException, z8);
    }

    public void g(q qVar, v vVar, IOException iOException, boolean z8) {
        Iterator it = this.f7571c.iterator();
        while (it.hasNext()) {
            c0 c0Var = (c0) it.next();
            w.P(c0Var.f9253a, new s0(this, c0Var.f9254b, qVar, vVar, iOException, z8, 1));
        }
    }

    public void h(q qVar, int i9, int i10, s sVar, int i11, Object obj, long j5, long j9) {
        i(qVar, new v(i9, i10, sVar, i11, obj, w.W(j5), w.W(j9)));
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, v1.d0] */
    public void i(q qVar, v vVar) {
        Iterator it = this.f7571c.iterator();
        while (it.hasNext()) {
            c0 c0Var = (c0) it.next();
            w.P(c0Var.f9253a, new b0(this, c0Var.f9254b, qVar, vVar, 0));
        }
    }

    public void j(v vVar) {
        z zVar = this.f7570b;
        zVar.getClass();
        Iterator it = this.f7571c.iterator();
        while (it.hasNext()) {
            c0 c0Var = (c0) it.next();
            w.P(c0Var.f9253a, new com.network.tvgramplayer.voip.a(this, c0Var.f9254b, zVar, vVar, 3));
        }
    }
}
