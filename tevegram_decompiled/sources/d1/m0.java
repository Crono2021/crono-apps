package d1;

import java.io.IOException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class m0 extends IOException {

    /* renamed from: i, reason: collision with root package name */
    public final boolean f2501i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2502j;

    public m0(String str, Throwable th, boolean z8, int i9) {
        super(str, th);
        this.f2501i = z8;
        this.f2502j = i9;
    }

    public static m0 a(RuntimeException runtimeException, String str) {
        return new m0(str, runtimeException, true, 1);
    }

    public static m0 b(String str) {
        return new m0(str, null, true, 4);
    }

    public static m0 c(String str) {
        return new m0(str, null, false, 1);
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return super.getMessage() + "{contentIsMalformed=" + this.f2501i + ", dataType=" + this.f2502j + "}";
    }
}
