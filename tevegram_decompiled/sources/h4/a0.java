package h4;

import java.io.File;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a0 implements q {

    /* renamed from: b, reason: collision with root package name */
    public static final a0 f3961b = new a0(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3962a;

    public /* synthetic */ a0(int i9) {
        this.f3962a = i9;
    }

    @Override // h4.q
    public final p a(Object obj, int i9, int i10, b4.i iVar) {
        switch (this.f3962a) {
            case 0:
                return new p(new v4.b(obj), new d(obj, 1));
            case 1:
                File file = (File) obj;
                return new p(new v4.b(file), new d(file, 0));
            default:
                return null;
        }
    }

    @Override // h4.q
    public final boolean b(Object obj) {
        switch (this.f3962a) {
            case 0:
                return true;
            case 1:
                return true;
            default:
                return false;
        }
    }
}
