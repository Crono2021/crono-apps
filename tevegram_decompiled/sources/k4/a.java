package k4;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.io.InputStream;
import java.util.ArrayDeque;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements b4.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5542a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f5543b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f5544c;

    public a(Resources resources, b4.k kVar) {
        this.f5542a = 0;
        this.f5544c = resources;
        this.f5543b = kVar;
    }

    @Override // b4.k
    public final d4.a0 a(Object obj, int i9, int i10, b4.i iVar) {
        x xVar;
        boolean z8;
        w4.e eVar;
        switch (this.f5542a) {
            case 0:
                d4.a0 a9 = ((b4.k) this.f5543b).a(obj, i9, i10, iVar);
                Resources resources = (Resources) this.f5544c;
                if (a9 == null) {
                    return null;
                }
                return new d(resources, a9);
            case 1:
                d4.a0 c9 = ((m4.d) this.f5543b).c((Uri) obj, iVar);
                if (c9 == null) {
                    return null;
                }
                return s.a((e4.a) this.f5544c, (Drawable) ((m4.c) c9).get(), i9, i10);
            default:
                InputStream inputStream = (InputStream) obj;
                if (inputStream instanceof x) {
                    xVar = (x) inputStream;
                    z8 = false;
                } else {
                    xVar = new x(inputStream, (e4.f) this.f5544c);
                    z8 = true;
                }
                ArrayDeque arrayDeque = w4.e.f9934k;
                synchronized (arrayDeque) {
                    eVar = (w4.e) arrayDeque.poll();
                }
                if (eVar == null) {
                    eVar = new w4.e();
                }
                w4.e eVar2 = eVar;
                eVar2.f9935i = xVar;
                w4.k kVar = new w4.k(eVar2);
                a5.d dVar = new a5.d(xVar, 27, eVar2);
                try {
                    q qVar = (q) this.f5543b;
                    d a10 = qVar.a(new androidx.fragment.app.g(kVar, qVar.f5591d, qVar.f5590c), i9, i10, iVar, dVar);
                    eVar2.a();
                    if (z8) {
                        xVar.b();
                    }
                    return a10;
                } finally {
                }
        }
    }

    @Override // b4.k
    public final boolean b(Object obj, b4.i iVar) {
        switch (this.f5542a) {
            case 0:
                return ((b4.k) this.f5543b).b(obj, iVar);
            case 1:
                return "android.resource".equals(((Uri) obj).getScheme());
            default:
                return true;
        }
    }

    public /* synthetic */ a(Object obj, int i9, Object obj2) {
        this.f5542a = i9;
        this.f5543b = obj;
        this.f5544c = obj2;
    }
}
