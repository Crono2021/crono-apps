package u5;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public float f9132a;

    /* renamed from: b, reason: collision with root package name */
    public float f9133b;

    /* renamed from: c, reason: collision with root package name */
    public float f9134c;

    /* renamed from: d, reason: collision with root package name */
    public float f9135d;

    /* renamed from: e, reason: collision with root package name */
    public float f9136e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f9137f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f9138g = new ArrayList();

    public s() {
        d(0.0f, 270.0f, 0.0f);
    }

    public final void a(float f9) {
        float f10 = this.f9135d;
        if (f10 == f9) {
            return;
        }
        float f11 = ((f9 - f10) + 360.0f) % 360.0f;
        if (f11 > 180.0f) {
            return;
        }
        float f12 = this.f9133b;
        float f13 = this.f9134c;
        o oVar = new o(f12, f13, f12, f13);
        oVar.f9125f = this.f9135d;
        oVar.f9126g = f11;
        this.f9138g.add(new m(oVar));
        this.f9135d = f9;
    }

    public final void b(Matrix matrix, Path path) {
        ArrayList arrayList = this.f9137f;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            ((q) arrayList.get(i9)).a(matrix, path);
        }
    }

    public final void c(float f9, float f10) {
        p pVar = new p();
        pVar.f9127b = f9;
        pVar.f9128c = f10;
        this.f9137f.add(pVar);
        n nVar = new n(pVar, this.f9133b, this.f9134c);
        float b9 = nVar.b() + 270.0f;
        float b10 = nVar.b() + 270.0f;
        a(b9);
        this.f9138g.add(nVar);
        this.f9135d = b10;
        this.f9133b = f9;
        this.f9134c = f10;
    }

    public final void d(float f9, float f10, float f11) {
        this.f9132a = f9;
        this.f9133b = 0.0f;
        this.f9134c = f9;
        this.f9135d = f10;
        this.f9136e = (f10 + f11) % 360.0f;
        this.f9137f.clear();
        this.f9138g.clear();
    }
}
