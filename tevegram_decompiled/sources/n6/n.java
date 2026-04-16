package n6;

import d4.t;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import m6.q;
import r6.q1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n implements f6.j {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.fragment.app.g f7474a;

    /* renamed from: b, reason: collision with root package name */
    public final t f7475b;

    /* renamed from: c, reason: collision with root package name */
    public final t f7476c;

    public n(androidx.fragment.app.g gVar) {
        this.f7474a = gVar;
        boolean isEmpty = ((p6.a) gVar.f730l).f8255a.isEmpty();
        t tVar = q.f6682a;
        if (isEmpty) {
            this.f7475b = tVar;
            this.f7476c = tVar;
            return;
        }
        m6.g gVar2 = (m6.g) m6.h.f6661b.f6663a.get();
        gVar2 = gVar2 == null ? m6.h.f6662c : gVar2;
        q.a(gVar);
        gVar2.getClass();
        this.f7475b = tVar;
        this.f7476c = tVar;
    }

    @Override // f6.j
    public final void a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        t tVar = this.f7476c;
        if (length <= 5) {
            tVar.getClass();
            androidx.fragment.app.a.o("tag too short");
            return;
        }
        byte[] copyOf = Arrays.copyOf(bArr, 5);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
        androidx.fragment.app.g gVar = this.f7474a;
        for (f6.k kVar : gVar.X(copyOf)) {
            try {
                ((f6.j) kVar.f3428b).a(copyOfRange, kVar.f3431e.equals(q1.LEGACY) ? a.a.j(bArr2, o.f7478b) : bArr2);
                tVar.getClass();
                return;
            } catch (GeneralSecurityException e9) {
                o.f7477a.info("tag prefix matches a key, but cannot verify: " + e9);
            }
        }
        Iterator it = gVar.X(f6.b.f3415a).iterator();
        while (it.hasNext()) {
            try {
                ((f6.j) ((f6.k) it.next()).f3428b).a(bArr, bArr2);
                tVar.getClass();
                return;
            } catch (GeneralSecurityException unused) {
            }
        }
        tVar.getClass();
        androidx.fragment.app.a.o("invalid MAC");
    }

    @Override // f6.j
    public final byte[] b(byte[] bArr) {
        t tVar = this.f7475b;
        f6.k kVar = (f6.k) this.f7474a.f729k;
        if (kVar.f3431e.equals(q1.LEGACY)) {
            bArr = a.a.j(bArr, o.f7478b);
        }
        try {
            byte[] bArr2 = kVar.f3429c;
            byte[] j5 = a.a.j(bArr2 == null ? null : Arrays.copyOf(bArr2, bArr2.length), ((f6.j) kVar.f3428b).b(bArr));
            int i9 = kVar.f3432f;
            tVar.getClass();
            return j5;
        } catch (GeneralSecurityException e9) {
            tVar.getClass();
            throw e9;
        }
    }
}
