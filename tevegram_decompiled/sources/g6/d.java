package g6;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements f6.a {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.fragment.app.g f3749a;

    /* renamed from: b, reason: collision with root package name */
    public final d4.t f3750b;

    /* renamed from: c, reason: collision with root package name */
    public final d4.t f3751c;

    public d(androidx.fragment.app.g gVar) {
        this.f3749a = gVar;
        boolean isEmpty = ((p6.a) gVar.f730l).f8255a.isEmpty();
        d4.t tVar = m6.q.f6682a;
        if (isEmpty) {
            this.f3750b = tVar;
            this.f3751c = tVar;
            return;
        }
        m6.g gVar2 = (m6.g) m6.h.f6661b.f6663a.get();
        gVar2 = gVar2 == null ? m6.h.f6662c : gVar2;
        m6.q.a(gVar);
        gVar2.getClass();
        this.f3750b = tVar;
        this.f3751c = tVar;
    }

    @Override // f6.a
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        d4.t tVar = this.f3750b;
        f6.k kVar = (f6.k) this.f3749a.f729k;
        try {
            byte[] bArr3 = kVar.f3429c;
            byte[] j5 = a.a.j(bArr3 == null ? null : Arrays.copyOf(bArr3, bArr3.length), ((f6.a) kVar.f3428b).a(bArr, bArr2));
            int i9 = kVar.f3432f;
            int length = bArr.length;
            tVar.getClass();
            return j5;
        } catch (GeneralSecurityException e9) {
            tVar.getClass();
            throw e9;
        }
    }

    @Override // f6.a
    public final byte[] b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        androidx.fragment.app.g gVar = this.f3749a;
        d4.t tVar = this.f3751c;
        if (length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
            Iterator it = gVar.X(copyOf).iterator();
            while (it.hasNext()) {
                try {
                    byte[] b9 = ((f6.a) ((f6.k) it.next()).f3428b).b(copyOfRange, bArr2);
                    tVar.getClass();
                    return b9;
                } catch (GeneralSecurityException e9) {
                    e.f3752a.info("ciphertext prefix matches a key, but cannot decrypt: " + e9);
                }
            }
        }
        Iterator it2 = gVar.X(f6.b.f3415a).iterator();
        while (it2.hasNext()) {
            try {
                byte[] b10 = ((f6.a) ((f6.k) it2.next()).f3428b).b(bArr, bArr2);
                tVar.getClass();
                return b10;
            } catch (GeneralSecurityException unused) {
            }
        }
        tVar.getClass();
        androidx.fragment.app.a.o("decryption failed");
        return null;
    }
}
