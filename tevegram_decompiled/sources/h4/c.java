package h4;

import java.io.File;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3968a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3969b;

    public /* synthetic */ c(Object obj, int i9) {
        this.f3968a = i9;
        this.f3969b = obj;
    }

    @Override // h4.q
    public final p a(Object obj, int i9, int i10, b4.i iVar) {
        switch (this.f3968a) {
            case 0:
                byte[] bArr = (byte[]) obj;
                return new p(new v4.b(bArr), new l(bArr, 1, (z) this.f3969b));
            case 1:
                return new p(new v4.b(obj), new l(obj.toString(), (z) this.f3969b));
            default:
                File file = (File) obj;
                return new p(new v4.b(file), new c4.b(1, file, (z) this.f3969b));
        }
    }

    @Override // h4.q
    public final boolean b(Object obj) {
        switch (this.f3968a) {
            case 0:
                return true;
            case 1:
                return obj.toString().startsWith("data:image");
            default:
                return true;
        }
    }
}
