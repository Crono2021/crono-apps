package androidx.emoji2.text;

import android.util.SparseArray;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public int f644a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final u f645b;

    /* renamed from: c, reason: collision with root package name */
    public u f646c;

    /* renamed from: d, reason: collision with root package name */
    public u f647d;

    /* renamed from: e, reason: collision with root package name */
    public int f648e;

    /* renamed from: f, reason: collision with root package name */
    public int f649f;

    public r(u uVar) {
        this.f645b = uVar;
        this.f646c = uVar;
    }

    public final int a(int i9) {
        SparseArray sparseArray = this.f646c.f659a;
        u uVar = sparseArray == null ? null : (u) sparseArray.get(i9);
        int i10 = 1;
        if (this.f644a == 2) {
            if (uVar != null) {
                this.f646c = uVar;
                this.f649f++;
            } else if (i9 == 65038) {
                b();
            } else if (i9 != 65039) {
                u uVar2 = this.f646c;
                if (uVar2.f660b != null) {
                    if (this.f649f != 1) {
                        this.f647d = uVar2;
                        b();
                    } else if (c()) {
                        this.f647d = this.f646c;
                        b();
                    } else {
                        b();
                    }
                    i10 = 3;
                } else {
                    b();
                }
            }
            i10 = 2;
        } else if (uVar == null) {
            b();
        } else {
            this.f644a = 2;
            this.f646c = uVar;
            this.f649f = 1;
            i10 = 2;
        }
        this.f648e = i9;
        return i10;
    }

    public final void b() {
        this.f644a = 1;
        this.f646c = this.f645b;
        this.f649f = 0;
    }

    public final boolean c() {
        w0.a b9 = this.f646c.f660b.b();
        int a9 = b9.a(6);
        return !(a9 == 0 || ((ByteBuffer) b9.f7134d).get(a9 + b9.f7131a) == 0) || this.f648e == 65039;
    }
}
