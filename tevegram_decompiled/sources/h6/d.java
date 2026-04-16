package h6;

import androidx.activity.g;
import androidx.fragment.app.i;
import com.google.crypto.tink.shaded.protobuf.m;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d extends i {

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f4050k;

    public d(byte[] bArr, int i9) {
        this.f4050k = i9;
        if (!g.d(1)) {
            androidx.fragment.app.a.o("Can not use ChaCha20Poly1305 in FIPS-mode.");
            throw null;
        }
        this.f761i = l(bArr, 1);
        this.f762j = l(bArr, 0);
    }

    @Override // androidx.fragment.app.i
    public final m l(byte[] bArr, int i9) {
        switch (this.f4050k) {
            case 0:
                return new c(i9, 0, bArr);
            default:
                return new c(i9, 1, bArr);
        }
    }
}
