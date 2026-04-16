package u5;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i extends com.bumptech.glide.c {
    @Override // com.bumptech.glide.c
    public final void w(s sVar, float f9, float f10) {
        sVar.d(f10 * f9, 180.0f, 90.0f);
        float f11 = f10 * 2.0f * f9;
        o oVar = new o(0.0f, 0.0f, f11, f11);
        oVar.f9125f = 180.0f;
        oVar.f9126g = 90.0f;
        sVar.f9137f.add(oVar);
        m mVar = new m(oVar);
        sVar.a(180.0f);
        sVar.f9138g.add(mVar);
        sVar.f9135d = 270.0f;
        float f12 = (0.0f + f11) * 0.5f;
        float f13 = (f11 - 0.0f) / 2.0f;
        double d9 = 270.0f;
        sVar.f9133b = (((float) Math.cos(Math.toRadians(d9))) * f13) + f12;
        sVar.f9134c = (f13 * ((float) Math.sin(Math.toRadians(d9)))) + f12;
    }
}
