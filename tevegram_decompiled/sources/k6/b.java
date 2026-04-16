package k6;

import androidx.fragment.app.g;
import d4.t;
import f6.k;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import m6.h;
import m6.q;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements f6.c {

    /* renamed from: a, reason: collision with root package name */
    public final g f5621a;

    /* renamed from: b, reason: collision with root package name */
    public final t f5622b;

    /* renamed from: c, reason: collision with root package name */
    public final t f5623c;

    public b(g gVar) {
        this.f5621a = gVar;
        boolean isEmpty = ((p6.a) gVar.f730l).f8255a.isEmpty();
        t tVar = q.f6682a;
        if (isEmpty) {
            this.f5622b = tVar;
            this.f5623c = tVar;
            return;
        }
        m6.g gVar2 = (m6.g) h.f6661b.f6663a.get();
        gVar2 = gVar2 == null ? h.f6662c : gVar2;
        q.a(gVar);
        gVar2.getClass();
        this.f5622b = tVar;
        this.f5623c = tVar;
    }

    @Override // f6.c
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        t tVar = this.f5622b;
        k kVar = (k) this.f5621a.f729k;
        try {
            byte[] bArr3 = kVar.f3429c;
            byte[] j5 = a.a.j(bArr3 == null ? null : Arrays.copyOf(bArr3, bArr3.length), ((f6.c) kVar.f3428b).a(bArr, bArr2));
            int i9 = kVar.f3432f;
            tVar.getClass();
            return j5;
        } catch (GeneralSecurityException e9) {
            tVar.getClass();
            throw e9;
        }
    }

    @Override // f6.c
    public final byte[] b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        g gVar = this.f5621a;
        t tVar = this.f5623c;
        if (length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
            Iterator it = gVar.X(copyOf).iterator();
            while (it.hasNext()) {
                try {
                    byte[] b9 = ((f6.c) ((k) it.next()).f3428b).b(copyOfRange, bArr2);
                    tVar.getClass();
                    return b9;
                } catch (GeneralSecurityException e9) {
                    c.f5624a.info("ciphertext prefix matches a key, but cannot decrypt: " + e9);
                }
            }
        }
        Iterator it2 = gVar.X(f6.b.f3415a).iterator();
        while (it2.hasNext()) {
            try {
                byte[] b10 = ((f6.c) ((k) it2.next()).f3428b).b(bArr, bArr2);
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
