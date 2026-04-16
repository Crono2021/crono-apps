package k0;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5506a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f5507b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f5508c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c7.a f5509d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f5510e;

    public /* synthetic */ c(String str, Context context, c7.a aVar, int i9, int i10) {
        this.f5506a = i10;
        this.f5507b = str;
        this.f5508c = context;
        this.f5509d = aVar;
        this.f5510e = i9;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f5506a) {
            case 0:
                return f.a(this.f5507b, this.f5508c, this.f5509d, this.f5510e);
            default:
                try {
                    return f.a(this.f5507b, this.f5508c, this.f5509d, this.f5510e);
                } catch (Throwable unused) {
                    return new e(-3);
                }
        }
    }
}
