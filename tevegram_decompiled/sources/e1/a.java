package e1;

import b6.g0;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final g0 f3014a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3015b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer[] f3016c = new ByteBuffer[0];

    /* renamed from: d, reason: collision with root package name */
    public boolean f3017d;

    public a(g0 g0Var) {
        this.f3014a = g0Var;
        b bVar = b.f3018e;
        this.f3017d = false;
    }

    public final void a() {
        ArrayList arrayList = this.f3015b;
        arrayList.clear();
        this.f3017d = false;
        int i9 = 0;
        while (true) {
            g0 g0Var = this.f3014a;
            if (i9 >= g0Var.size()) {
                break;
            }
            d dVar = (d) g0Var.get(i9);
            dVar.flush();
            if (dVar.b()) {
                arrayList.add(dVar);
            }
            i9++;
        }
        this.f3016c = new ByteBuffer[arrayList.size()];
        for (int i10 = 0; i10 <= b(); i10++) {
            this.f3016c[i10] = ((d) arrayList.get(i10)).d();
        }
    }

    public final int b() {
        return this.f3016c.length - 1;
    }

    public final boolean c() {
        return this.f3017d && ((d) this.f3015b.get(b())).a() && !this.f3016c[b()].hasRemaining();
    }

    public final boolean d() {
        return !this.f3015b.isEmpty();
    }

    public final void e(ByteBuffer byteBuffer) {
        boolean z8;
        for (boolean z9 = true; z9; z9 = z8) {
            z8 = false;
            int i9 = 0;
            while (i9 <= b()) {
                if (!this.f3016c[i9].hasRemaining()) {
                    ArrayList arrayList = this.f3015b;
                    d dVar = (d) arrayList.get(i9);
                    if (!dVar.a()) {
                        ByteBuffer byteBuffer2 = i9 > 0 ? this.f3016c[i9 - 1] : byteBuffer.hasRemaining() ? byteBuffer : d.f3023a;
                        long remaining = byteBuffer2.remaining();
                        dVar.f(byteBuffer2);
                        this.f3016c[i9] = dVar.d();
                        z8 |= remaining - ((long) byteBuffer2.remaining()) > 0 || this.f3016c[i9].hasRemaining();
                    } else if (!this.f3016c[i9].hasRemaining() && i9 < b()) {
                        ((d) arrayList.get(i9 + 1)).e();
                    }
                }
                i9++;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        g0 g0Var = ((a) obj).f3014a;
        g0 g0Var2 = this.f3014a;
        if (g0Var2.size() != g0Var.size()) {
            return false;
        }
        for (int i9 = 0; i9 < g0Var2.size(); i9++) {
            if (g0Var2.get(i9) != g0Var.get(i9)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.f3014a.hashCode();
    }
}
